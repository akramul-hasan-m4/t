package com.harnest.inventory.ws.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.Users;
import com.harnest.inventory.ws.model.UserInfo;
import com.harnest.inventory.ws.repository.UserRepo;
import com.harnest.inventory.ws.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired private UserRepo repo;

	@Override
	public Users findUserByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public UserInfo getUserInfo(String userName) {
		UserInfo userInfo = new UserInfo();
		
		try {
			List<Object[]> user = repo.getUserInfo(userName);
			user.stream().forEach(u->{
				userInfo.setUserId((BigDecimal) u[0]);
				userInfo.setUsername((String) u[1]);
				userInfo.setUsergrpId((BigDecimal) u[2]);
				userInfo.setUserlvlId((BigDecimal) u[3]);
				userInfo.setRoleName((String) u[4]);
				userInfo.setEmpName((String) u[5]);
				userInfo.setDesigId((BigDecimal) u[6]);
				userInfo.setAreaId((BigDecimal) u[7]);
				userInfo.setEmpNo((String) u[8]);
				userInfo.setEmail((String) u[9]);
				userInfo.setPassword((String) u[10]);
			});
			 
		} catch (Exception e) {
			log.error("error==>>>> "+e.getMessage());
		}
		
		return userInfo;
	}

}
