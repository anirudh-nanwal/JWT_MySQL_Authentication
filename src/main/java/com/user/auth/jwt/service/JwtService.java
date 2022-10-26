/**
 * 
 */
package com.user.auth.jwt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.auth.jwt.dao.UserDao;
import com.user.auth.jwt.entity.JwtRequest;
import com.user.auth.jwt.entity.JwtResponse;
import com.user.auth.jwt.entity.User;
import com.user.auth.jwt.util.JwtUtil;

/**
 * @author anirudh.nanwal
 *
 * Service to implement the UserDetailsService.
 */
@Service
public class JwtService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtResponse createJwtToken(JwtRequest request) throws Exception{
		String userName = request.getUserName();
		String userPassword = request.getUserPassword();
		authenticate(userName, userPassword);
		
		final UserDetails userDetails = loadUserByUsername(userName);
		
		String token = jwtUtil.generateToken(userDetails);
		
		User user = userDao.findById(userName).get();
		return new JwtResponse(user, token);
	}

	/**
	 * Overridden loadUserByUsername method.
	 *
	**/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findById(username).get();
		if(user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), getAuthorities(user));
		} else {
			throw new UsernameNotFoundException("Username is not valid");
		}
	}
	
	private  Set<SimpleGrantedAuthority> getAuthorities(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		});
		return authorities;
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			throw new Exception("User is disabled");
		}catch(BadCredentialsException e) {
			throw new Exception("Bad credentials from user");
		}
	}

}
