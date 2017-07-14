package com.qbao;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RabbitTest {

	@Autowired
	@Qualifier("testMqTemplate2")
	RabbitTemplate testMqTemplate;
	
	@Autowired
	@Qualifier("testMqTemplate3")
	RabbitTemplate testMqTemplate3;
	
	@Autowired
	@Qualifier("testMqTemplate4")
	RabbitTemplate testMqTemplate4;
	
	@Autowired
	@Qualifier("testMqTemplate5")
	RabbitTemplate testMqTemplate5;
	
	@RequestMapping("/send")
	public void send() throws InterruptedException{
		int i=0;
		while(true){
			System.out.println("send message = ok "+(++i));
//			testMqTemplate.convertAndSend("testMqTemplate send message = ok "+(i));
//			testMqTemplate.convertAndSend("my.queue","testMqTemplate send message = ok "+(i));
			testMqTemplate3.convertAndSend("testMqTemplate3 send message = ok "+(i));
//			testMqTemplate5.convertAndSend("testMqTemplate3 send message = ok "+(i));
			Thread.sleep(1000);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(RabbitCofig.class);
//		
////		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:spring/app-config.xml");
//		RabbitTemplate rabbitTemplate=app.getBean("testMqTemplate", RabbitTemplate.class);
////		rabbitTemplate.convertAndSend("lala");
		System.out.println(StringUtils.trimAllWhitespace("abc aaa"));
	}

}
