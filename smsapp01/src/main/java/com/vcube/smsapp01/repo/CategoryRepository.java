package com.vcube.smsapp01.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.smsapp01.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
