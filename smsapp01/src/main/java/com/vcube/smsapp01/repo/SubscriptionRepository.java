package com.vcube.smsapp01.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.smsapp01.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
	 List<Subscription> findByNextRenewalDateBefore(LocalDate date);
}
