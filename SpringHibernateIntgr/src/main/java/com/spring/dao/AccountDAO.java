package com.spring.dao;

import com.spring.hibernate.entity.Account;

import java.util.List;

public interface AccountDAO {
	void save(Account account);
	void update(Account account);
	List<com.spring.hibernate.entity.Account> read();
	void delete(Account account);

}