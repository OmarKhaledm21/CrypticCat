package com.global.crypticcat.usecase;

import com.global.crypticcat.dto.RegisterRequest;
import com.global.crypticcat.entity.User;

public interface IUserCreateUseCase {
	User create(RegisterRequest request);
}
