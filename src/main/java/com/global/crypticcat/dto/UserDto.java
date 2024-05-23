package com.global.crypticcat.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	private String username;
	private String firstName;
	private String lastName;
	private String slug;

}
