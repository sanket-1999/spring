package com.spring.FirstSpringDemo;



import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;




import org.springframework.beans.BeansException;

public class Ques22 implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) 
		      throws BeansException {
		      
		      System.out.println("BeforeInitialization : " + beanName);
		      return bean; 
		   }
		   public Object postProcessAfterInitialization(Object bean, String beanName) 
		      throws BeansException {
		      
		      System.out.println("AfterInitialization : " + beanName);
		      return bean; 
		   }
		
}
