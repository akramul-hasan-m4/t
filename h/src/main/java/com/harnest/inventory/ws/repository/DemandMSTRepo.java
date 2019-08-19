package com.harnest.inventory.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.DemandMST;

@Repository
public interface DemandMSTRepo extends JpaRepository<DemandMST, Integer>{

	List<DemandMST> findAllByEntryBy(String entryBy);
	
	DemandMST findByDemandNo(Integer demandNo);
	
}
