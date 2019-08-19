package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.ExecutiveInfo;
import com.harnest.inventory.ws.repository.ExecutiveInfoRepo;
import com.harnest.inventory.ws.service.ExecutiveInfoService;

public class ExecutiveInfoServiceImpl implements ExecutiveInfoService{

	@Autowired private ExecutiveInfoRepo repo;
	
	@Override
	public List<ExecutiveInfo> getAllExecutiveInfo() {
		return repo.findAll();
	}

	@Override
	public ExecutiveInfo findByExeInfoId(Integer exeInfoId) {
		return repo.findByExeInfoId(exeInfoId);
	}

}
