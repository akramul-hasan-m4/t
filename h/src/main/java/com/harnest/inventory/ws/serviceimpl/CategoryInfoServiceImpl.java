package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.CategoryInfo;
import com.harnest.inventory.ws.repository.CategoryInfoRepo;
import com.harnest.inventory.ws.service.CategoryInfoService;

public class CategoryInfoServiceImpl implements CategoryInfoService{

	private @Autowired CategoryInfoRepo repo;
	
	@Override
	public CategoryInfo findByCatId(Integer catId) {
		return repo.findByCategoryId(catId);
	}

}
