package com.spring.FirstSpringDemo;



import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChatApp_q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext iocContainer=new ClassPathXmlApplicationContext("chat.xml");
		Map<String,Chatroom> orderMap=iocContainer.getBeansOfType(Chatroom.class);
		for(String key :orderMap.keySet())
		{
			Chatroom chatroom=orderMap.get(key);
			System.out.println(chatroom);
		}
		
	}


}
