package com.harnest.inventory.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.ExecutiveInfo;

@Repository
public interface ExecutiveInfoRepo extends JpaRepository<ExecutiveInfo, Integer>{

	ExecutiveInfo findByExeInfoId(Integer exeInfoId);
	
}
