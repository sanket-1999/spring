package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.UserEntity;
import com.spring.json.User;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		UserEntity userEntity = 
				userRepository.save(UserUtils.convertUserToUserEntity(user));
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	public List<User> getAllUsers() {
		List<UserEntity> userEntityList = userRepository.findAll();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	public User getUserById(String id) {
		UserEntity userEntity = userRepository.findById(Long.valueOf(id)).get();
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	
	@Override
	public User update(User user, String id) {
		UserEntity userEntity = userRepository.findById(Long.valueOf(id)).get();
		if(userEntity != null) {
			userEntity.setFirstName(user.getFirstName());
			userEntity.setUserName(user.getUserName());
			userEntity.setPassword(user.getPassword());
			userEntity = userRepository.save(userEntity);
			return UserUtils.convertUserEntityToUser(userEntity);
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		if(userRepository.existsById(Long.valueOf(id))) {
			userRepository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}

	@Override
	public String login(User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		List<UserEntity> userlist= userRepository.findByUserName(userName);	
		if (userlist==null || userlist.size()==0)
		{
			return "invalid user";
		}
		
		else {
			UserEntity userEntity = userlist.get(0);
			if(password.equals(user.getPassword())) {
				
			String sessionId= new java.rmi.server.UID().toString().substring(0,10);
			userEntity.setSessionId(sessionId);
			userRepository.save(userEntity);
			return "{ \"result\" : \"seccess\" , \"message\" :"
					+ " \"login successfull\" , \"sessionid\":" +sessionId +"\"}";
			}
			else {
				return "invalid pass";
			}
		}
	
	}	
	
	
	public User logout(String auth) {
		
			com.spring.entity.UserEntity user1=userRepository.findBySessionId(auth).get(0);
			user1.setSessionId(null);
			com.spring.entity.UserEntity userEntity=userRepository.save(user1);	
			return UserUtils.convertUserEntityToUser(userEntity);
		
	}




}
