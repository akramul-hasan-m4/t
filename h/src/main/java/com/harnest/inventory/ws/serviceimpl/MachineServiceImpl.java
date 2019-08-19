package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.MachineInfo;
import com.harnest.inventory.ws.repository.MachineRepo;
import com.harnest.inventory.ws.service.MachineService;

public class MachineServiceImpl implements MachineService{

	@Autowired private MachineRepo repo;
	
	@Override
	public List<MachineInfo> getAllMaqchine() {
		return repo.findAll();
	}

}
