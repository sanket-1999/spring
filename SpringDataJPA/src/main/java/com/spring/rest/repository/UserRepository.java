package com.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.UserEntity;
import com.spring.json.User;

@Component
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	List<UserEntity> findByFirstName(String firstName);
	List<UserEntity>  findByOrderByFirstNameAsc();
	List<UserEntity>  findByOrderByFirstNameDesc();
	List<UserEntity>  findByUserName(String userName);
	List<UserEntity>  findBySessionId(String sessionId);
}
