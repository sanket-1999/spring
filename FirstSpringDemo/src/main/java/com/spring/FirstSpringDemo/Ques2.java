package com.spring.FirstSpringDemo;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Ques2 implements BeanNameAware,InitializingBean,DisposableBean  {
	private String message;

	  
	public  Ques2() {
		super();
		System.out.println("Const called");
	}
	
	public Ques2(String message) {
		super();
		System.out.println(" parameter const called");
		this.message = message;
	}




	public void setMessage(String message){
	      this.message = message;
	  	System.out.println("Setter method called");
	   }
	   public void getMessage(){
	      System.out.println("Getter method called");
	   }
	   public void init(){
	      System.out.println("init method.");
	   }
	  

	public void setBeanName(String name) {
		System.out.println("BeanNameAware Interface");
		
	}
	
		public void afterPropertiesSet() throws Exception {
		System.out.println("After Properties set method called");
			
		}
		
		
		@PreDestroy
		private void shutdown() {
			System.out.println("Shutdown All Resources");
		}
		
		public void destroy() throws Exception {
			System.out.println("Destroy method called");
			
		}
	
	
	
}
