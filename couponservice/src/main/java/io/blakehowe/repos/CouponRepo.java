package io.blakehowe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.blakehowe.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
