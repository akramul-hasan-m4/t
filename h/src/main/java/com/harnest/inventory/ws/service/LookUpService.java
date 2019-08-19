package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.LookUp;

@Service
public interface LookUpService {
	
	@Transactional
	void saveLookUp(LookUp lookup);
	
	@Transactional
	List<LookUp> getAllLookUpInfo();

}
