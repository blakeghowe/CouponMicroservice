package io.blakehowe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.blakehowe.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
