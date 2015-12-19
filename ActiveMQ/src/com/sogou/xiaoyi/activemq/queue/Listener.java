package com.sogou.xiaoyi.activemq.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * 监听器
 * 
 * @author xiaoyi
 *
 */
public class Listener implements MessageListener {

	public void onMessage(Message message) {
		try {
			System.out.println("收到的消息"+((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
