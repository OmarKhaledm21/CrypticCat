package com.global.crypticcat.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.crypticcat.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
	
	Optional<User> findBySlug(String slug);

	boolean existsBySlug(String slug);
	
	boolean existsByUsername(String username);
}
