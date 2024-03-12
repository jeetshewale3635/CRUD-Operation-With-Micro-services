package com.ajit.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajit.crud.entity.AuthRequest;
import com.ajit.crud.entity.UserInfo;
import com.ajit.crud.service.JwtService;
import com.ajit.crud.service.UserInfoService; 
  


@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserInfoService userInfoService; 
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	
	@GetMapping("/welcome")
	public String welcome() {
		return "testing This end point is NOT Secure....";
	}
	
	@PostMapping("/addNewUser")
	public String addUser(@RequestBody UserInfo userInfo) {
		System.out.println("Get call");
		return userInfoService.addUser(userInfo);
	}
	
	 @PostMapping("/generateToken") 
	    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
	        if (authentication.isAuthenticated()) { 
	            return jwtService.generateToken(authRequest.getUsername()); 
	        } else { 
	            throw new UsernameNotFoundException("invalid user request !"); 
	        } 
	    } 
	
	
}
