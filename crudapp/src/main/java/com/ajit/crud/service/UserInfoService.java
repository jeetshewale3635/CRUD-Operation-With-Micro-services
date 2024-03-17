package com.ajit.crud.service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ajit.crud.entity.UserInfo;
import com.ajit.crud.repository.UserInfoRepository; 

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
	        return userDetail.map(this::createSpringSecurityUser) 
	                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
	    } 
	  
	  private User createSpringSecurityUser(UserInfo user) {
	        List<SimpleGrantedAuthority> grantedAuthorities = Arrays.asList(new SimpleGrantedAuthority(user.getRoles()));
	        return new User(user.getName(), user.getPassword(), grantedAuthorities);
	    }
	 

	public String addUser(UserInfo userInfo) {
		
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userRepoObj.save(userInfo);
		
		return "Added User successfully";
	}

}
