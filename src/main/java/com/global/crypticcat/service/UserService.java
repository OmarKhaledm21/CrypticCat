package com.global.crypticcat.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.global.crypticcat.dto.UserDto;
import com.global.crypticcat.entity.User;
import com.global.crypticcat.exception.UserDoesNotExistException;
import com.global.crypticcat.mapper.UserMapper;
import com.global.crypticcat.repositoy.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public Optional<User> getCurrentUser() {
		String username = null;
		Optional<User> user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			} else {
				username = principal.toString();
			}
		}

		if (username != null) {
			user = userRepository.findByUsername(username);
		}
		return user;
	}

	public UserDto getCurrentUserProfile() {
		var user = getCurrentUser().orElseThrow(() -> new UserDoesNotExistException());
		return UserMapper.toDto(user);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UserDoesNotExistException());
	}

	public User findBySlug(String slug) {
		return userRepository.findBySlug(slug).orElseThrow(() -> new UserDoesNotExistException());
	}

	public boolean existsBySlug(String slug) {

		return userRepository.existsBySlug(slug);
	}

	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	public UserDto getUserProfileBySlug(String slug) {
		var user = userRepository.findBySlug(slug)
				.orElseThrow(() -> new UserDoesNotExistException());
		return UserMapper.toDto(user);
	}

}
