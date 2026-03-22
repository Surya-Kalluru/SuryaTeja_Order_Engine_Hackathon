package com.vcube.smsapp01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.smsapp01.model.Subscription;
import com.vcube.smsapp01.service.SubscriptionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
	private final SubscriptionService subscriptionService;

    // Add Subscription
    @PostMapping("/{userId}/{categoryId}")
    public Subscription addSubscription(
            @PathVariable Integer userId,
            @PathVariable Long categoryId,
            @RequestBody Subscription subscription) {

        return subscriptionService.addSubscription(userId, categoryId, subscription);
    }

    // Get All Subscriptions
    @GetMapping("/getAllSubscriptions")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }
}
