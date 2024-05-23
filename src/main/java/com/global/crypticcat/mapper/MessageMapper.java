package com.global.crypticcat.mapper;

import com.global.crypticcat.dto.MessageDto;
import com.global.crypticcat.entity.Message;
import com.global.crypticcat.entity.User;

public class MessageMapper {

	public static MessageDto toDto(Message message) {
		return MessageDto.builder().text(message.getText()).createdAt(message.getCreatedAt()).build();
	}

	public static Message toEntity(MessageDto messageDto, User user) {
		return Message.builder().text(messageDto.getText()).user(user).build();
	}
}
