package com.harnest.inventory.ws.serviceimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.LookupDtl;
import com.harnest.inventory.ws.model.LookupDTLModel;
import com.harnest.inventory.ws.repository.LookupDtlRepo;
import com.harnest.inventory.ws.service.LookupDtlService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LookupDtlServiceImpl implements LookupDtlService{

	private @Autowired LookupDtlRepo repo;
	
	@Override
	public List<LookupDTLModel> getLookupDtlInfo() {
		return convertObjectToModel(repo.getLookupDtlInfo());
	}

	@Override
	public List<LookupDTLModel> getLookupDtlInfoByLookUpNo(List<Integer> lookUpNo) {
		return convertObjectToModel(repo.getLookupDtlInfoByLookUpNo(lookUpNo));
	}
	
	@Override
	public void saveLookUpDtl(LookupDtl lookupDtl) {
		repo.save(lookupDtl);
	}
	
	private List<LookupDTLModel> convertObjectToModel(List<Object[]> dtlList){
		List<LookupDTLModel> lookUpList = new ArrayList<>();
		try {
			dtlList.stream().forEach(m ->{
				LookupDTLModel model = new LookupDTLModel();
				
				model.setLookupDtlNo((BigDecimal)m[0]);
				model.setLookupNo((BigDecimal)m[1]);
				model.setLookupName((String)m[2]);
				model.setDtlName((String)m[3]);
				//model.setOrderNo((BigDecimal)m[4]);
				//model.setChangeable((BigDecimal)m[5]);
				//model.setActiveFlag((BigDecimal)m[6]);
				
				lookUpList.add(model);
			});
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return lookUpList;
	}

	

}
