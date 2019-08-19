package com.harnest.inventory.ws.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.CategoryInfo;

@Service
public interface CategoryInfoService {

	@Transactional
	CategoryInfo findByCatId(Integer catId);
}
