package com.spring.FirstSpringDemo;

import org.springframework.context.MessageSource;

public class AccountBean {
	private String name;
	private int balance;
	
	public AccountBean() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance + "]";
	}
	public AccountBean(String name, int balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	
	public void setMessageSource(MessageSource messageSource) {
		// TODO Auto-generated method stub
		System.out.println(messageSource);
	}
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AfterProperty Set is called");
	}
	public void initMethod()
	{
		System.out.println("InitMethod is called");
	}
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy method of disposableBean interface is called");
	}
	public void onDestroy()
	{
		System.out.println("Ondestroy method of destroy-method attribute is caled is called");
	}

}