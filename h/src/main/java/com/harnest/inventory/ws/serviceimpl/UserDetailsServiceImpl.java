package com.harnest.inventory.ws.serviceimpl;




import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.model.UserInfo;
import com.harnest.inventory.ws.service.UserService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired private UserService service;
	
	@Autowired BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserInfo userInfo1 = service.getUserInfo(userName);
		String userRole = userInfo1 == null || userInfo1.getRoleName() == null ? "" : "ROLE_" + userInfo1.getRoleName();
		GrantedAuthority authority = new SimpleGrantedAuthority(userRole);
		return new User(userInfo1.getUsername(), passwordEncoder.encode(userInfo1.getPassword()), Arrays.asList(authority));
	}
	
}
