package io.blakehowe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.blakehowe.model.Coupon;
import io.blakehowe.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	CouponRepo repo;
	
	@PostMapping(value = "/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}
	
	@GetMapping(value = "/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);
	}
}
