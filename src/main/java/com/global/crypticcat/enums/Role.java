package com.global.crypticcat.enums;

public enum Role {
	USER, ADMIN;

	public Role getRole(String role) {
		if (role.equals("USER")) {
			return Role.USER;
		} else if (role.equals("ADMIN")) {
			return Role.ADMIN;
		}
		return null;
	}

	public String getRole(Role role) {
		if (role.equals(Role.USER)) {
			return "USER";
		} else if (role.equals(Role.ADMIN)) {
			return "ADMIN";
		}
		return null;
	}

}
