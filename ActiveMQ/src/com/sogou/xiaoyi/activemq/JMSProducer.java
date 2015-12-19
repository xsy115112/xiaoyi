package com.sogou.xiaoyi.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 
 * 
 * @author xiaoyi
 *
 */
public class JMSProducer {
	//Ĭ���û���
	public static String USERNAME = ActiveMQConnection.DEFAULT_USER;
	//Ĭ������
	public static String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	//Ĭ�����ӵ�ַ
	public static String BROKENURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		//���ӹ���
		ConnectionFactory connectionFactory = null;
		//����
		Connection connection = null;
		//�Ự���ܻ��߷�����Ϣ�Ľ���
		Session session = null;
		//Ŀ�ĵ�
		Destination destination = null;
		//��Ϣ������
		MessageProducer messageProducer = null;
		
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKENURL);
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			//��һ������ �Ƿ�������
			//�ڶ������� ��Ϣȷ�ϲ���
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			//������Ϣ����
			destination = session.createQueue("firstQueue");
			//��Ϣ������
			messageProducer = session.createProducer(destination);
			//����10����Ϣ
			for(int i=0;i<10;i++){
				TextMessage textMessage = session.createTextMessage("ActiveMQ ���͵���Ϣ"+i);
				messageProducer.send(textMessage);
			}
			session.commit();
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