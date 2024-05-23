package com.global.crypticcat.mapper;

import com.global.crypticcat.dto.UserDto;
import com.global.crypticcat.entity.User;

public class UserMapper {

	public static UserDto toDto(User user) {
		return UserDto.builder().username(user.getUsername()).firstName(user.getFirstName())
				.lastName(user.getLastName()).slug(user.getSlug()).build();
	}

	public static User toEntity(UserDto userDto) {
		return User.builder().username(userDto.getUsername()).firstName(userDto.getFirstName())
				.lastName(userDto.getLastName()).slug(userDto.getSlug()).build();
	}

}
