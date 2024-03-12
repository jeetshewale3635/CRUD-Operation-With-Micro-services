package com.ajit.crud.service;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;

import com.ajit.crud.entity.UserInfo;
import com.ajit.crud.repository.UserInfoRepository;

import java.util.Optional; 

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	UserInfoRepository userRepoObj;
	
	
	  @Autowired 
	  PasswordEncoder passwordEncoder;
	  
	  @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
	  
	        Optional<UserInfo> userDetail = userRepoObj.findByName(username); 
	  
	        System.out.println(" Username = "+userDetail.get().getName());
	        // Converting userDetail to UserDetails 
	        return userDetail.map(UserInfoDetails::new) 
	                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
	    } 
	 

	public String addUser(UserInfo userInfo) {
		
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userRepoObj.save(userInfo);
		
		return "Added User successfully";
	}

}
