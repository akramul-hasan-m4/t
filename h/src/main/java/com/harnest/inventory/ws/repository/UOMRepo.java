package com.harnest.inventory.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.UnitofMeasure;

@Repository
public interface UOMRepo extends JpaRepository<UnitofMeasure, Integer>{

	UnitofMeasure findByUomNo(Integer uomNo);
	
	List<UnitofMeasure> findAllByActiveFgAndMobileFG(Integer activeFG, Integer mobileFG);
	
}
