package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.HRDepartment;
import com.harnest.inventory.ws.repository.HRDepartmentRepo;
import com.harnest.inventory.ws.service.HRDepartmentService;

public class HRDepartmentServiceImpl implements HRDepartmentService{
	
	private @Autowired HRDepartmentRepo repo;

	@Override
	public List<HRDepartment> getAllHRDepartmentInfo() {
		return repo.findAll();
	}

}
