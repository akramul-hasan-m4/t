package com.harnest.inventory.ws.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.ExecutiveInfo;
import com.harnest.inventory.ws.entity.GarmentInfo;
import com.harnest.inventory.ws.entity.ProdOrderDTLMST;
import com.harnest.inventory.ws.entity.Users;
import com.harnest.inventory.ws.repository.ExecutiveInfoRepo;
import com.harnest.inventory.ws.repository.GarmentInfoRepo;
import com.harnest.inventory.ws.repository.ProdOrderDTLMSTRepo;
import com.harnest.inventory.ws.repository.UserRepo;
import com.harnest.inventory.ws.service.ProdOrderDTLMSTService;

public class ProdOrderDTLMSTServiceImpl implements ProdOrderDTLMSTService{
	
	private @Autowired ProdOrderDTLMSTRepo repo;
	private @Autowired GarmentInfoRepo garmentRepo;
	private @Autowired ExecutiveInfoRepo exeRepo;
	private @Autowired UserRepo userRepo;

	@Override
	public ProdOrderDTLMST findByReferenceNo(String referenceNo) {
		return repo.findByReferenceNo(referenceNo);
	}

	@Override
	public List<ProdOrderDTLMST> getFinishGoodsList() {
		List<ProdOrderDTLMST> fgList = new ArrayList<>();
		Optional<List<ProdOrderDTLMST>> list = repo.getAllFinishGoods();
		
		if(list.isPresent()) {
			list.get().stream().filter(f -> f != null).forEach(fg -> {
				Integer grrmId = fg.getGrmmId() == null ? 0 : Integer.parseInt(fg.getGrmmId());
				Integer exeId = fg.getMarkExe() == null ? 0 : Integer.parseInt(fg.getMarkExe());
				GarmentInfo gmInfo = garmentRepo.findByGarmentInfoId(grrmId);
				ExecutiveInfo exeInfo = exeRepo.findByExeInfoId(exeId);
				Users user = userRepo.findByEmpNo(fg.getCreateBy());
				
				String garmentName = gmInfo == null || gmInfo.getGarmentName() == null ? "" : gmInfo.getGarmentName();
				String exeName = exeInfo == null || exeInfo.getExeName()== null ? "" : exeInfo.getExeName();
				String userFullName = user == null || user.getFullName() == null ? "" : user.getFullName();
				
				fg.setGarmentName(garmentName);
				fg.setExeName(exeName);
				fg.setCreatedByName(userFullName);
				
				fgList.add(fg);
			});
		}
		
		return fgList;
	}

}
