package com.harnest.inventory.ws.commons;

public class StringQuery {
	

	private StringQuery() {}

	public static final String REPORT_QUERY = "SELECT DISTINCT T.DEPT_NO,T.DEPTNAME,T.ITEM_NO,T.UD_ITEM_NO,T.ITEM_NAME,T.GROUP_NO,T.GROUP_NAME, \r\n" + 
			"       T.OP_BALANCE,T.PR_BALANCE,T.CL_BALANCE,T.IN_QTY,\r\n" + 
			"       T.OUT_QTY,T.RC_SHOW,Z.UOM_NAME\r\n" + 
			" FROM\r\n" + 
			" (SELECT MMM.DEPT_NO, FNC_DEPTNAME(MMM.DEPT_NO) DEPTNAME,MMM.ITEM_NO, I.UD_ITEM_NO, I.ITEM_NAME,\r\n" + 
			"      I.CATEGORY_ID AS GROUP_NO,G.CATEGORY_NAME AS GROUP_NAME,\r\n" + 
			"       NVL (OPB, 0) OP_BALANCE,\r\n" + 
			"       NVL (PRB, 0) PR_BALANCE, \r\n" + 
			"       NVL (CLB, 0) CL_BALANCE,\r\n" + 
			"       NVL(IN_QTY,0) IN_QTY,\r\n" + 
			"       NVL(OUT_QTY,0) OUT_QTY,\r\n" + 
			"     CASE\r\n" + 
			"        WHEN OPB=0 AND IN_QTY=0 AND OUT_QTY=0 AND CLB=0 THEN  'N'\r\n" + 
			"        ELSE 'Y'\r\n" + 
			"     END RC_SHOW\r\n" + 
			"    \r\n" + 
			" FROM (SELECT DEPT_NO,ITEM_NO, NVL(SUM(OPB),0) OPB,NVL(SUM(PRB),0) PRB,(NVL(SUM(OPB),0)+NVL(SUM(PRB),0)) CLB,\r\n" + 
			"       NVL(SUM(IN_QTY),0) IN_QTY,NVL(SUM(OUT_QTY),0) OUT_QTY\r\n" + 
			"       --2129\r\n" + 
			"      FROM (SELECT DEPT_NO,ITEM_NO, NVL (OB, 0) OPB,NVL (CB, 0) PRB,NVL(IN_QTY,0) IN_QTY,NVL(OUT_QTY,0) OUT_QTY\r\n" + 
			"                   FROM (SELECT    DEPT_NO, ITEM_NO, SUM (QTY) AS OB,NULL CB,NULL  IN_QTY,NULL  OUT_QTY\r\n" + 
			"                                             FROM INV_MSTOCK \r\n" + 
			"                                            WHERE ITEM_NO=NVL(:ITEMNO ,ITEM_NO)                  \r\n" + 
			"                                                  AND DEPT_NO=NVL(:DEPTNO, DEPT_NO) \r\n" + 
			"                                                  AND  TRUNC(TRAN_DATE )< NVL (:START_DATE , SYSDATE)\r\n" + 
			"                                         GROUP BY DEPT_NO, ITEM_NO) \r\n" + 
			"                     UNION ALL\r\n" + 
			"                         (SELECT   MI.DEPT_NO, MI.ITEM_NO,NULL OB, SUM (QTY) AS CB,NULL  IN_QTY,NULL  OUT_QTY\r\n" + 
			"                          FROM INV_MSTOCK  MI\r\n" + 
			"                          WHERE MI.ITEM_NO=NVL(:ITEMNO ,MI.ITEM_NO) \r\n" + 
			"                            AND MI.DEPT_NO=NVL( :DEPTNO ,MI.DEPT_NO) \r\n" + 
			"                            AND TRUNC(TRAN_DATE) BETWEEN NVL (:START_DATE , SYSDATE)AND NVL (:END_DATE , SYSDATE)\r\n" + 
			"                          GROUP BY MI.DEPT_NO, MI.ITEM_NO) \r\n" + 
			"                     UNION ALL  \r\n" + 
			"                         (SELECT   MI.DEPT_NO, MI.ITEM_NO,NULL OB,NULL CB, SUM (QTY) AS IN_QTY ,NULL  OUT_QTY\r\n" + 
			"                          FROM INV_MSTOCK  MI\r\n" + 
			"                          WHERE MI.ITEM_NO=NVL(:ITEMNO ,MI.ITEM_NO) \r\n" + 
			"                            AND MI.DEPT_NO=NVL( :DEPTNO ,MI.DEPT_NO) \r\n" + 
			"                            AND MI.QTY>0\r\n" + 
			"                            AND TRUNC(TRAN_DATE) BETWEEN NVL (:START_DATE , SYSDATE)AND NVL (:END_DATE , SYSDATE)\r\n" + 
			"                          GROUP BY MI.DEPT_NO, MI.ITEM_NO)\r\n" + 
			"                    UNION ALL\r\n" + 
			"                         (SELECT   MI.DEPT_NO, MI.ITEM_NO,NULL OB,NULL CB,NULL  IN_QTY, SUM (QTY) AS OUT_QTY \r\n" + 
			"                          FROM INV_MSTOCK  MI\r\n" + 
			"                          WHERE MI.ITEM_NO=NVL(:ITEMNO ,MI.ITEM_NO) \r\n" + 
			"                            AND MI.DEPT_NO=NVL( :DEPTNO ,MI.DEPT_NO) \r\n" + 
			"                            AND MI.QTY<0\r\n" + 
			"                            AND TRUNC(TRAN_DATE) BETWEEN NVL (:START_DATE , SYSDATE)AND NVL (:END_DATE , SYSDATE)\r\n" + 
			"                          GROUP BY MI.DEPT_NO, MI.ITEM_NO)         \r\n" + 
			"          ) KK\r\n" + 
			"              WHERE KK.ITEM_NO IS NOT NULL\r\n" + 
			"              GROUP BY KK.DEPT_NO,KK.ITEM_NO) MMM,\r\n" + 
			" INV_ITEM I,\r\n" + 
			" CATEGORY_INFO G\r\n" + 
			" WHERE MMM.ITEM_NO(+) = I.ITEM_NO \r\n" + 
			"  AND  I.CATEGORY_ID=G.CATEGORY_ID(+)\r\n" + 
			"   AND MMM.DEPT_NO = NVL ( :DEPTNO ,MMM.DEPT_NO)\r\n" + 
			"   AND MMM.ITEM_NO = NVL (:ITEMNO ,MMM.ITEM_NO)\r\n" + 
			"   AND I.UD_ITEM_NO = NVL (:UDITEMNO , I.UD_ITEM_NO)\r\n" + 
			"  AND  NVL(UPPER(I.CATEGORY_ID),1) LIKE NVL(UPPER('%'|| :GROUPNO ||'%'),UPPER(NVL(I.CATEGORY_ID,1)))\r\n" + 
			"   ) T,  MMV_ITEMSTOCKTRNS Z\r\n" + 
			" WHERE  --T.RC_SHOW <>'N' and \r\n" + 
			" T.ITEM_NO=Z.ITEM_NO\r\n" + 
			" AND NVL(UPPER(T.ITEM_NAME),'$#@$#@')  LIKE NVL(UPPER('%'|| :ITEMNAME ||'%'),UPPER(NVL(T.ITEM_NAME,'$#@$#@')))\r\n" + 
			" ORDER BY T.DEPTNAME ASC,T.GROUP_NAME ASC,T.ITEM_NAME ASC, NVL (T.OP_BALANCE, 0) DESC, NVL (T.CL_BALANCE, 0) DESC";
	
	
	public static final String FINISH_GOODS_QUERY = "SELECT *\r\n" + 
			" FROM LABEL_PRINTING.PRODORDER_MST\r\n" + 
			" WHERE ACTIVE_STATUS = 1\r\n" + 
			" AND SORT_DELIVERY = 1\r\n" + 
			" AND (PI_STATUS = 1 OR CHALLAN_STATUS = 1)\r\n" + 
			" AND TO_CHAR(CRE_DT, 'MMYYYY')\r\n" + 
			" BETWEEN TO_CHAR(SYSDATE-90, 'MMYYYY') AND TO_CHAR(SYSDATE, 'MMYYYY')"; 
			
	public static final String USER_INFO = "SELECT U.USER_ID, U.USERNAME, U.USERGRP_ID, U.USERLVL_ID,\r\n" + 
			" (SELECT UGLEVE_NAME FROM SA_UG_LEVEL\r\n" + 
			" WHERE UG_LEVEL_ID IN\r\n" + 
			" (SELECT USERLVL_ID FROM SA_USERS\r\n" + 
			" WHERE USERLVL_ID = U.USERLVL_ID\r\n" + 
			" AND USERNAME = :UN )) ROLE_NAME,\r\n" + 
			" E.EMP_NAME, U.DESIG_ID, U.AREA_ID, U.EMP_NO, U.EMAIL, U.USERPW\r\n" + 
			" FROM SA_USERS U, HR_EMPLOYEE E\r\n" + 
			" WHERE U.ACTIVE_STATUS = 1\r\n" + 
			" AND U.USERNAME = :UN\r\n" + 
			" AND E.EMP_NO = U.EMP_NO";
	
	public static final String GET_LOOK_UP_INFO =" select LOOKUPDTL_NO, LOOKUP_NO,\r\n" + 
			"(select LOOKUP_NAME from INV_LOOKUP where LOOKUP_NO = D.LOOKUP_NO) LOOKUP_NAME,\r\n" + 
			" DTL_NAME, ORDER_NO, CHANGEABLE, ACTIVE_FLAG\r\n" + 
			"from INV_LOOKUPDTL D\r\n" + 
			"where ACTIVE_FLAG = 1";
	
	public static final String GET_LOOK_UP_INFO_BY_ID = "SELECT D.LOOKUPDTL_NO, D.LOOKUP_NO,A.LOOKUP_NAME ,D.DTL_NAME\r\n" + 
			" FROM INV_LOOKUPDTL D,INV_LOOKUP A\r\n" + 
			" WHERE D.LOOKUP_NO =A.LOOKUP_NO \r\n" + 
			" AND D.ACTIVE_FLAG = 1\r\n" + 
			" AND A.LOOKUP_NO IN ( :lookUpNo )\r\n" + 
			" ORDER BY  D.LOOKUP_NO, D.ORDER_NO" + 
			"";
	
}
