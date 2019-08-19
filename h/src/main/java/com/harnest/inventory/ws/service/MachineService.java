package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.MachineInfo;

@Service
public interface MachineService {

	@Transactional(readOnly = true)
	List<MachineInfo> getAllMaqchine();
	
}
