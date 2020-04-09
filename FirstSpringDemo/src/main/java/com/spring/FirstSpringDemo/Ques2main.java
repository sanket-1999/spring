package com.spring.FirstSpringDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ques2main {
   public static void main(String[] args) {
      AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");

      Ques2 obj = (Ques2) context.getBean("helloWorld");
      obj.getMessage();
      context.registerShutdownHook();
   }
}