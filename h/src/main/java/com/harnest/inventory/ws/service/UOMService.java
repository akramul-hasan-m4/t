package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.UnitofMeasure;

@Service
public interface UOMService {
	
	@Transactional
	List<UnitofMeasure> findAllByActiveFgAndMobileFG(Integer activeFG, Integer mobileFG);
	
	@Transactional
	UnitofMeasure findByUomNo(Integer uomNo);

}
