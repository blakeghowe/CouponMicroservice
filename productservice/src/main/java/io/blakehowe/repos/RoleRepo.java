package io.blakehowe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.blakehowe.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
