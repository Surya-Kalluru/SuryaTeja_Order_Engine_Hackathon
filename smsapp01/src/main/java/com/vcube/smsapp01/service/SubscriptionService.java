package com.vcube.smsapp01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.smsapp01.model.Category;
import com.vcube.smsapp01.model.RenewalType;
import com.vcube.smsapp01.model.Stat;
import com.vcube.smsapp01.model.Subscription;
import com.vcube.smsapp01.model.User;
import com.vcube.smsapp01.repo.CategoryRepository;
import com.vcube.smsapp01.repo.SubscriptionRepository;
import com.vcube.smsapp01.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

	private final SubscriptionRepository subscriptionRepository;
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;

	public Subscription addSubscription(Integer userId, Long categoryId, Subscription subscription) {

		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found"));

		subscription.setUser(user);
		subscription.setCategory(category);
		subscription.setStat(Stat.ACTIVE);

		if (subscription.getRenewalType() == RenewalType.MONTHLY) {
			subscription.setNextRenewalDate(subscription.getStartDate().plusMonths(1));
		} else {
			subscription.setNextRenewalDate(subscription.getStartDate().plusYears(1));
		}

		return subscriptionRepository.save(subscription);
	}

	public List<Subscription> getAllSubscriptions() {
		return subscriptionRepository.findAll();
	}
}