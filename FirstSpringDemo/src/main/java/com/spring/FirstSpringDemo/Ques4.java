package com.spring.FirstSpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ques4 {

	public static void main(String[] args) {
		AbstractApplicationContext iocContainer= new ClassPathXmlApplicationContext("DepartmentBean.xml");
		Employee employee=(Employee)iocContainer.getBean("Employee_1");
		System.out.println(employee);
	}

}