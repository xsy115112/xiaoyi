package com.sogou.xiaoyi.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 监听器方式（推荐）
 * 
 * @author xiaoyi
 *
 */
public class TopicConsumer2 {
	//默认用户名
	public static String USERNAME = ActiveMQConnection.DEFAULT_USER;
	//默认密码
	public static String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	//默认连接地址
	public static String BROKENURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		//连接工厂
		ConnectionFactory connectionFactory = null;
		//连接
		Connection connection = null;
		//会话接受或者发送消息的进程
		Session session = null;
		//目的地
		Destination destination = null;
		//消息消费者
		MessageConsumer messageCosumer = null;
		
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKENURL);
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			//第一个参数 是否有事务
			//第二个参数 消息确认参数
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//创建消息队列
			destination = session.createTopic("firstTopic");
			//消息消费者
			messageCosumer = session.createConsumer(destination);
			//注册监听器
			messageCosumer.setMessageListener(new Listener1());
		} catch (JMSException e) {
			e.printStackTrace();
		}finally{
			if(connection != null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}