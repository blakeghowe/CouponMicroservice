package io.blakehowe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.blakehowe.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
