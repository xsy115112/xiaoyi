package com.sogou.xiaoyi.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * ѭ����ʽ��ȡ��Ϣ�����Ƽ���
 * 
 * @author xiaoyi
 *
 */
public class JMSConsumer2 {
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
		MessageConsumer messageCosumer = null;
		
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKENURL);
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			//��һ������ �Ƿ�������
			//�ڶ������� ��Ϣȷ�ϲ���
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//������Ϣ����
			destination = session.createQueue("firstQueue");
			//��Ϣ������
			messageCosumer = session.createConsumer(destination);
			while (true) {
				TextMessage textMessage = (TextMessage) messageCosumer.receive(100000);
				if(textMessage != null){
					System.out.println(textMessage.getText());
				}else{
					break;
				}
			}
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