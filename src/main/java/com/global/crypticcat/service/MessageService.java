package com.global.crypticcat.service;

import org.springframework.stereotype.Service;

import com.global.crypticcat.dto.MessageDto;
import com.global.crypticcat.entity.Message;
import com.global.crypticcat.exception.UserDoesNotExistException;
import com.global.crypticcat.mapper.MessageMapper;
import com.global.crypticcat.repositoy.MessageRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

	private final MessageRepository messageRepository;
	private final UserService userService;

	public void save(MessageDto messageDto, String userSlug) {
		var user = userService.findBySlug(userSlug);
		var message = MessageMapper.toEntity(messageDto, user);
		messageRepository.save(message);
	}

	public List<Message> findByUserId(Integer id) {
		return messageRepository.findByUserId(id);
	}

	public List<MessageDto> findByUser() {
		var user = userService.getCurrentUser().orElseThrow(() -> new UserDoesNotExistException());
		List<Message> messages = findByUserId(user.getId());
		return messages.stream().map((message) -> MessageMapper.toDto(message)).toList();
	}

}
