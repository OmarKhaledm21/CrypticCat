package com.global.crypticcat.usecase.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.global.crypticcat.dto.RegisterRequest;
import com.global.crypticcat.entity.User;
import com.global.crypticcat.enums.Role;
import com.global.crypticcat.service.UserService;
import com.global.crypticcat.usecase.IUserCreateUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserCreateUseCaseImpl implements IUserCreateUseCase {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	@Override
	public User create(RegisterRequest request) {
		var user = User.builder().username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword())).role(Role.USER)
				.firstName(request.getFirstName()).lastName(request.getLastName()).build();
		if (user.getUsername() != null && (user.getSlug() == null || user.getSlug().isEmpty())) {
			String baseSlug = user.getUsername().toLowerCase().replaceAll("[\\\\s?&#]+", "-");
			String slug = baseSlug;
			int count = 1;
			while (userService.existsBySlug(slug)) {
				slug = baseSlug + "-" + count++;
			}
			user.setSlug(slug);
		}
		return user;
	}

}
