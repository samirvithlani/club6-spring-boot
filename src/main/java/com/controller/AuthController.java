package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AuthRequest;
import com.dto.AuthResponse;
import com.util.JwtUtil;

@RestController
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	UserDetailsService userDetailsService;

	@PostMapping("/api/public/authenticate")
	public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception {

		System.out.println(authRequest.getUsername() + " "+authRequest.getPassword());
		try {

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("incrorect username and passeword", e);
		}

		UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		String jwt = jwtUtil.generateToken(userDetails.getUsername());
		return ResponseEntity.ok(new AuthResponse(jwt));

	}
}
