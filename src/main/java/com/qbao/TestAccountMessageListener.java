package com.qbao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

/**
 * 通过MQ异步处理集团数据
 * 
 * @author Frank
 *
 */
@Component
public class TestAccountMessageListener implements ChannelAwareMessageListener {

	private static final Logger logger = LoggerFactory
			.getLogger(TestAccountMessageListener.class);
	

	int count = 0;
	/**
	 * 通过MQ异步处理集团账务数据
	 */
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		
		logger.info("onMessage()'s message={}，channel", message, channel);
		String messageBody = "";
		try {
			messageBody = new String(message.getBody(), "utf-8");
			if(null != messageBody){
				System.out.println("receive message ="+messageBody);
			}
		}catch (Exception e) {
		}
//		throw new Exception();
		//TODO 推送
	}

}
