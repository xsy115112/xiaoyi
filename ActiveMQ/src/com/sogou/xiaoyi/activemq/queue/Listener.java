package com.sogou.xiaoyi.activemq.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * ������
 * 
 * @author xiaoyi
 *
 */
public class Listener implements MessageListener {

	public void onMessage(Message message) {
		try {
			System.out.println("�յ�����Ϣ"+((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
