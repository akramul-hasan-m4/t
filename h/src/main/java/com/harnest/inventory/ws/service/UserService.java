package com.harnest.inventory.ws.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.Users;
import com.harnest.inventory.ws.model.UserInfo;

@Service
public interface UserService {

	@Transactional(readOnly = true)
	Users findUserByUsername(String username);
	
	@Transactional(readOnly = true)
	UserInfo getUserInfo(String userName);
}
