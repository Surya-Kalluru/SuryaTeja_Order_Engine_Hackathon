package com.vcube.smsapp01.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.smsapp01.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
