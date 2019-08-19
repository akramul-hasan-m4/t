package com.harnest.inventory.ws.commons;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

public class URIConstants {

	private URIConstants() {
		//For Singleton Class
	}
	
	public static final String SUCCESS_MSG = "SuccessMsg";
	public static final String ERROR_MSG = "ErrorMsg";
	public static final String NOT_FOUND = "Not Found";
	
	public static final String BASE_URL = "/";
	public static final String API = "/api";
	
	public static final String UOM = "/uom";
	public static final String GET_ALL_ACTIVE_UOM = "/get-all-active-uom";
	
	public static final String ITEM = "/item";
	public static final String SAVE_ITEM = "/save-item";
	public static final String GET_ALL_ITEM = "/get-all-item";
	public static final String GET_ITEM_BY_TYPE = "/get-item-by-item-type/{itemType}";
	public static final String GET_ITEM_BY_TYPE_FLAG = "/get-item-by-item-type-flag/{flag}";
	
	public static final String USER = "/user";
	public static final String GET_USER_INFO = "/get-user-info/{username}";
	
	public static final String BUYER = "/buyer";
	public static final String GET_ALL_BUYER_INFO = "/get-all-buyer-info";
	
	public static final String MACHINE = "/machine";
	public static final String GET_ALL_MACHINE = "/get-all-machine";
	
	public static final String EXECUTIVE = "/executive";
	public static final String GET_ALL_EXECUTIVE = "/get-all-executive";
	
	public static final String DEMAND = "/demand";
	public static final String SAVE_DEMAND = "/save-demand";
	public static final String SAVE_DEMAND_CHILD = "/save-demand-child";
	public static final String FIND_DEMAND_CHILD_BY_ID = "/find-demand-child-by-id/{childId}";
	public static final String PRODUCT_DEMAND = "/prod-demand";
	public static final String DEMAND_FIND_ALL_APPROVED = "/find-all-approved";
	public static final String PRODUCT_SAVE_DEMAND = "/save-prod-demand";
	public static final String DEMAND_FIND_ALL_BY_PRIVILIGE = "/get-all-requsion-by-privilige";
	public static final String PRODUCT_SAVE_CHD_DEMAND = "/save-chd-prod-demand";
	
	public static final String DEPARTMENT = "/department";
	public static final String GET_ALL_DEPARTMENT_INFO = "/get-all-department-info";
	
	public static final String INIT_SAMPLE_CHD = "/init-sample-chd";
	public static final String GET_BY_DATE_INIT_SAMPLE_CHD = "/get-between-date";
	public static final String GET_INIT_SAMPLE_CHD_BY_ID = "/get-sample-by-id/{sampleChdId}";
	
	public static final String PRODUCT_ORDER_RCV = "/product-order-rcv";
	public static final String PRODUCT_ORDER_RCV_SAVE = "/save";
	public static final String PRODUCT_ORDER_RCV_GET_BY_CREATE_BY = "/get-create-by/{createBy}";
	
	public static final String PRODUCTION = "/production";
	public static final String PRODUCTION_GET_BY_BTWEEN_DATE = "/get-between-date";
	
	public static final String ISSUE = "/issue";
	public static final String ISSUE_SAVE = "/save";
	
	public static final String FINISH_GOODS_QC = "/fgqc";
	public static final String FINISH_GOODS_QC_SAVE = "/save";
	public static final String FINISH_GOODS_QC_GET_INFO = "/get-by-flag/{searchType}";
	public static final String FINISH_GOODS_GET_ALL = "/get-all-finish-goods";
	
	public static final String STOCK = "/stock";
	public static final String CHECK_STOCK_QTY = "/check-stock-qty";
	
	public static final String REPORT = "/report";
	public static final String REPORT_BALANCE = "/balance";
	
	public static final String LOOKUP = "/lookup";
	public static final String LOOKUP_GET_ALL_INFO = "/get-all-lookup-info";
	public static final String LOOKUP_GET_ALL_INFO_BY_LOOKUP_NO = "/get-lookup-info-by-lookup-no/{lookUpNo}";
	public static final String LOOKUP_SAVE_MST = "/save-lookup-info";
	public static final String LOOKUP_SAVE_DTL = "/save-lookup-details-info";
	public static final String LOOKUP_GET_ALL_LOOKUP_MST = "/get-lookup-infos";
}
