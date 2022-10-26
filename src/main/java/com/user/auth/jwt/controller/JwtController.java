/**
 * 
 */
package com.user.auth.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.auth.jwt.entity.JwtRequest;
import com.user.auth.jwt.entity.JwtResponse;
import com.user.auth.jwt.service.JwtService;

/**
 * @author anirudh.nanwal
 *
 */
@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/authenticate")
	public JwtResponse createJwtToken(@RequestBody JwtRequest request) throws Exception {
		return jwtService.createJwtToken(request);
	}
}
