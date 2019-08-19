package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.UnitofMeasure;
import com.harnest.inventory.ws.repository.UOMRepo;
import com.harnest.inventory.ws.service.UOMService;

public class UOMServiceImpl implements UOMService {
	
	@Autowired private UOMRepo repo;

	@Override
	public UnitofMeasure findByUomNo(Integer uomNo) {
		return repo.findByUomNo(uomNo);
	}

	@Override
	public List<UnitofMeasure> findAllByActiveFgAndMobileFG(Integer activeFG, Integer mobileFG) {
		return repo.findAllByActiveFgAndMobileFG(activeFG, mobileFG);
	}

}
