package com.harnest.inventory.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.IssueMST;

@Repository
public interface IssueMSTRepo extends JpaRepository<IssueMST, Integer>{

	IssueMST findByDemandNo(Integer demandNo);
	
}
