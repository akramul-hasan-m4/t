package com.harnest.inventory.ws.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.InitSampleCHD;
import com.harnest.inventory.ws.repository.InitSampleCHDRepo;
import com.harnest.inventory.ws.service.InitSampleCHDService;

public class InitSampleCHDServiceImpl implements InitSampleCHDService{
	
	private @Autowired InitSampleCHDRepo repo;

	@Override
	public List<InitSampleCHD> getInitSampleCHDByDate(LocalDate startDate, LocalDate endDate) {
		return repo.findByExpDeliveryDateBetween(startDate, endDate);
	}

	@Override
	public InitSampleCHD findInitSampleCHDBySampleChdId(Integer sampleChdId) {
		return repo.findBySampleChdId(sampleChdId);
	}

}
