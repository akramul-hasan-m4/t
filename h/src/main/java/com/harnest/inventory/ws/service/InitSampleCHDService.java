package com.harnest.inventory.ws.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.InitSampleCHD;

@Service
public interface InitSampleCHDService {
	
	@Transactional
	List<InitSampleCHD> getInitSampleCHDByDate(LocalDate startDate, LocalDate endDate);
	
	@Transactional
	InitSampleCHD findInitSampleCHDBySampleChdId(Integer sampleChdId);

}
