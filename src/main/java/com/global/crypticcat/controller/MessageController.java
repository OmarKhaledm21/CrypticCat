package com.global.crypticcat.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.crypticcat.dto.MessageDto;
import com.global.crypticcat.service.MessageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
	public final MessageService messageService;
	
	@PostMapping("/send/{userSlug}")
	public ResponseEntity<String> createMessage(@RequestBody MessageDto messageDto, @PathVariable String userSlug) {
		messageService.save(messageDto, userSlug);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<MessageDto>> getMessages() {
		return ResponseEntity.ok(messageService.findByUser());
	}
}
