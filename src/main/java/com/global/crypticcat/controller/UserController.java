package com.global.crypticcat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.crypticcat.dto.UserDto;
import com.global.crypticcat.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("/profile")
	public ResponseEntity<UserDto> getUserData() {
		return ResponseEntity.ok(userService.getCurrentUserProfile());
	}

	@GetMapping("/profile/{slug}")
	public ResponseEntity<UserDto> getUserDataBySlug(@PathVariable String slug) {
		return ResponseEntity.ok(userService.getUserProfileBySlug(slug));
	}
}
