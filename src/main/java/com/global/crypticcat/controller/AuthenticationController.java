package com.global.crypticcat.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.crypticcat.dto.AuthenticationRequest;
import com.global.crypticcat.dto.AuthenticationResponse;
import com.global.crypticcat.dto.RegisterRequest;
import com.global.crypticcat.service.AuthenticationService;
import com.global.crypticcat.usecase.IUserCreateUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authenticationService;
	private final IUserCreateUseCase userCreateUseCase;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		var user = userCreateUseCase.create(request);
		return ResponseEntity.ok(authenticationService.register(user));

	}

	@PostMapping("authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}
	
	@PostMapping("/refresh-token")
	  public void refreshToken(
	      HttpServletRequest request,
	      HttpServletResponse response
	  ) throws IOException {
		authenticationService.refreshToken(request, response);
	  }

}
