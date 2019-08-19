package com.harnest.inventory.ws.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.InitSampleCHD;

@Repository
public interface InitSampleCHDRepo extends JpaRepository<InitSampleCHD, Integer>{

	List<InitSampleCHD> findByExpDeliveryDateBetween(LocalDate startDate, LocalDate endDate);
	
	InitSampleCHD findBySampleChdId(Integer sampleChdId);
	
}
