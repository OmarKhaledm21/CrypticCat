package com.global.crypticcat.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.global.crypticcat.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message> findByUserId(Integer userId);
}
