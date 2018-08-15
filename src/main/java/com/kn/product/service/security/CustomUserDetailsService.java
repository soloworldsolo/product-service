package com.kn.product.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.employee.service.UserInfoService;

//@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	//@Autowired
	//private UserInfoService userInfoService;

	@Autowired
	private Environment env;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired(required = true)
	private void init() {

	}

	@Override
	public UserDetails loadUserByUsername(String userName) {
	//	String user = userInfoService.findByUserName(userName);
		//LOGGER.info("User : {}", user);
		//if (null == user) {
			//LOGGER.info("User not found");
			//throw new UsernameNotFoundException("User not found");
		//}
		return null;
	}
}
