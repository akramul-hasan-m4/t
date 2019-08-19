package com.harnest.inventory.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.CategoryInfo;

@Repository
public interface CategoryInfoRepo extends JpaRepository<CategoryInfo, Integer>{

	CategoryInfo findByCategoryId(Integer categoryId);
}
