package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.ExecutiveInfo;

@Service
public interface ExecutiveInfoService {

	@Transactional(readOnly = true)
	List<ExecutiveInfo> getAllExecutiveInfo();
	
	@Transactional(readOnly = true)
	ExecutiveInfo findByExeInfoId(Integer exeInfoId);
	
}
