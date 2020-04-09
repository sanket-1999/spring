package com.spring.FirstSpringDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Account_main {

		public static void main(String[] args) {
			
			AbstractApplicationContext iocContainer = 
				new ClassPathXmlApplicationContext("beans_simple.xml");
			AccountBean account = (AccountBean)iocContainer.getBean("Account");
			System.out.println(account);
			iocContainer.registerShutdownHook();
		}

	}