package com.harnest.inventory.ws.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.harnest.inventory.ws.service.BuyerService;
import com.harnest.inventory.ws.service.CategoryInfoService;
import com.harnest.inventory.ws.service.DemandCHDService;
import com.harnest.inventory.ws.service.DemandMSTService;
import com.harnest.inventory.ws.service.ExecutiveInfoService;
import com.harnest.inventory.ws.service.FinishedGoodsQCService;
import com.harnest.inventory.ws.service.GarmentInfoService;
import com.harnest.inventory.ws.service.HRDepartmentService;
import com.harnest.inventory.ws.service.InitSampleCHDService;
import com.harnest.inventory.ws.service.InitSampleMSTService;
import com.harnest.inventory.ws.service.IssueCHDService;
import com.harnest.inventory.ws.service.IssueMSTService;
import com.harnest.inventory.ws.service.ItemService;
import com.harnest.inventory.ws.service.LookUpService;
import com.harnest.inventory.ws.service.LookupDtlService;
import com.harnest.inventory.ws.service.MachineService;
import com.harnest.inventory.ws.service.ProdOrderDTLMSTService;
import com.harnest.inventory.ws.service.ProdOrderDTLService;
import com.harnest.inventory.ws.service.ProductDemandCHDService;
import com.harnest.inventory.ws.service.ProductDemandService;
import com.harnest.inventory.ws.service.ProductOrderCHDService;
import com.harnest.inventory.ws.service.ProductOrderMSTService;
import com.harnest.inventory.ws.service.ProductOrderRcvCHDService;
import com.harnest.inventory.ws.service.ProductOrderRcvMSTService;
import com.harnest.inventory.ws.service.ReportService;
import com.harnest.inventory.ws.service.StockService;
import com.harnest.inventory.ws.service.UOMService;
import com.harnest.inventory.ws.service.UserService;
import com.harnest.inventory.ws.serviceimpl.BuyerServiceImpl;
import com.harnest.inventory.ws.serviceimpl.CategoryInfoServiceImpl;
import com.harnest.inventory.ws.serviceimpl.DemandCHDServiceImpl;
import com.harnest.inventory.ws.serviceimpl.DemandMSTServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ExecutiveInfoServiceImpl;
import com.harnest.inventory.ws.serviceimpl.FinishedGoodsQCServiceImpl;
import com.harnest.inventory.ws.serviceimpl.GarmentInfoServiceImpl;
import com.harnest.inventory.ws.serviceimpl.HRDepartmentServiceImpl;
import com.harnest.inventory.ws.serviceimpl.InitSampleCHDServiceImpl;
import com.harnest.inventory.ws.serviceimpl.InitSampleMSTServiceImpl;
import com.harnest.inventory.ws.serviceimpl.IssueCHDServiceImpl;
import com.harnest.inventory.ws.serviceimpl.IssueMSTServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ItemServiceImpl;
import com.harnest.inventory.ws.serviceimpl.LookUpServiceImpl;
import com.harnest.inventory.ws.serviceimpl.LookupDtlServiceImpl;
import com.harnest.inventory.ws.serviceimpl.MachineServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ProdOrderDTLMSTServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ProdOrderDTLServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ProductDemandCHDServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ProductDemandServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ProductOrderCHDServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ProductOrderMSTServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ProductOrderRcvCHDServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ProductOrderRcvMSTServiceImpl;
import com.harnest.inventory.ws.serviceimpl.ReportServiceImpl;
import com.harnest.inventory.ws.serviceimpl.StockServiceImpl;
import com.harnest.inventory.ws.serviceimpl.UOMServiceImpl;
import com.harnest.inventory.ws.serviceimpl.UserServiceImpl;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */
@Configuration
public class BeansConfiguration {

	@Bean
	public UOMService uomBean() {
		return new UOMServiceImpl();
	}
	
	@Bean
	public ItemService itemBean() {
		return new ItemServiceImpl();
	}
	
	@Bean
	public UserService userBean() {
		return new UserServiceImpl();
	}
	
	@Bean
	public BuyerService buyerBean() {
		return new BuyerServiceImpl();
	}
	
	@Bean
	public MachineService machineBean() {
		return new MachineServiceImpl();
	}
	
	@Bean
	public ExecutiveInfoService exeBean() {
		return new ExecutiveInfoServiceImpl();
	}
	
	@Bean
	public DemandMSTService demanMSTBean() {
		return new DemandMSTServiceImpl();
	}
	
	@Bean
	public ProductDemandService prodDemanMSTBean() {
		return new ProductDemandServiceImpl();
	}
	
	@Bean
	public ProductDemandCHDService prodDemanCHDBean() {
		return new ProductDemandCHDServiceImpl();
	}
	
	@Bean
	public ProductOrderMSTService poMSTBean() {
		return new ProductOrderMSTServiceImpl();
	}
	
	@Bean
	public ProductOrderCHDService poCHDBean() {
		return new ProductOrderCHDServiceImpl();
	}
	
	@Bean
	public ProductOrderRcvMSTService poRcvMStBean() {
		return new ProductOrderRcvMSTServiceImpl();
	}
	
	@Bean
	public ProductOrderRcvCHDService poRcvCHDBean() {
		return new ProductOrderRcvCHDServiceImpl();
	}
	
	@Bean
	public HRDepartmentService deptBean() {
		return new HRDepartmentServiceImpl();
	}
	
	@Bean
	public InitSampleCHDService initSampleChdBean() {
		return new InitSampleCHDServiceImpl();
	}
	
	@Bean
	public CategoryInfoService catBean() {
		return new CategoryInfoServiceImpl();
	}
	
	@Bean
	public GarmentInfoService garmentBean() {
		return new GarmentInfoServiceImpl();
	}
	
	@Bean
	public InitSampleMSTService initSampleMstBean() {
		return new InitSampleMSTServiceImpl();
	}
	
	@Bean
	public ProdOrderDTLService prodOrderDTLBean() {
		return new ProdOrderDTLServiceImpl();
	}
	
	@Bean
	public DemandCHDService demandCHDBean() {
		return new DemandCHDServiceImpl();
	}
	
	@Bean
	public ProdOrderDTLMSTService prodOrderDTLMSTBean() {
		return new ProdOrderDTLMSTServiceImpl();
	}
	
	@Bean
	public IssueMSTService issueMSTBean() {
		return new IssueMSTServiceImpl();
	}
	
	@Bean
	public IssueCHDService issueCHDBean() {
		return new IssueCHDServiceImpl();
	}
	
	@Bean
	public FinishedGoodsQCService fgQcBean() {
		return new FinishedGoodsQCServiceImpl();
	}
	
	@Bean
	public StockService stockBean() {
		return new StockServiceImpl();
	}
	
	@Bean
	public ReportService reportBean() {
		return new ReportServiceImpl();
	}
	
	@Bean
	public LookupDtlService lookUpDtlBean() {
		return new LookupDtlServiceImpl();
	}
	
	@Bean
	public LookUpService lookUpBean() {
		return new LookUpServiceImpl();
	}
	
}
