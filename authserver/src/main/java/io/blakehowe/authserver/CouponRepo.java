package io.blakehowe.authserver;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
