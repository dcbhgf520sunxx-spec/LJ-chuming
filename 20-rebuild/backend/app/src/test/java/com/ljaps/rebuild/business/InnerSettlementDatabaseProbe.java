package com.ljaps.rebuild.business;
import com.ljaps.rebuild.RebuildApplication;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementAddDTOParam;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.*;
/** Dedicated real DB draft transaction. Does not call approval, payment or external OA. */
public class InnerSettlementDatabaseProbe {
 static final long BASE=8900007000000L,PROJECT=BASE+1,SUPPLIER=BASE+2,ORDER=BASE+3;
 static void require(boolean b,String m){if(!b)throw new AssertionError(m);}
 static SupplierSettlementAddDTOParam request(long manager){SupplierSettlementAddDTOParam p=new SupplierSettlementAddDTOParam();p.setApplyDate(LocalDateTime.now().minusDays(1).withNano(0));p.setApplyUserId(BASE+99);p.setProjectId(PROJECT);p.setSupplierId(SUPPLIER);p.setProjectManagerId(manager);p.setOrderId(ORDER);p.setPurchaseContractNumber("rebuild_inner_settlement_qa");p.setSettlementAmount(new BigDecimal("10.25"));p.setRemark("rebuild_inner_settlement_qa");return p;}
 static void principal(long actor,boolean admin,List<String> permissions){
  com.hzchum.scim.system.core.api.pojo._do.Department department=new com.hzchum.scim.system.core.api.pojo._do.Department();department.setName("QA fixture");
  SecurityUser user=new SecurityUser(actor,"fixture","QA fixture",null,null,null,"",null,null,Collections.emptyList(),department,null,Collections.emptyList(),Collections.emptyList(),true,"",permissions,admin,false,1,null,null,null);SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,null,Collections.emptyList()));
 }
 public static void main(String[]args)throws Exception{
  ConfigurableApplicationContext c=SpringApplication.run(RebuildApplication.class,args);JdbcTemplate j=c.getBean(JdbcTemplate.class);String db=j.queryForObject("SELECT DATABASE()",String.class);require(db.startsWith("plm7_rebuild_qa_"),"Independent QA only");long actor=j.queryForObject("SELECT MIN(id) FROM sys_user",Long.class),branch=j.queryForObject("SELECT MIN(id) FROM sys_branch_company",Long.class);Map<String,Object> evidence=new LinkedHashMap<>();evidence.put("database",db);
  principal(actor,true,Collections.emptyList());
  long settlementBefore=j.queryForObject("SELECT COUNT(*) FROM contract_supplier_settlement",Long.class),ledgerBefore=j.queryForObject("SELECT COUNT(*) FROM contract_audit_ledger",Long.class);
  try{
   TransactionTemplate tx=new TransactionTemplate(c.getBean(PlatformTransactionManager.class));tx.execute(status->{
    require(j.queryForObject("SELECT COUNT(*) FROM contract_project WHERE id=?",Integer.class,PROJECT)==0,"Unused fixture project");
    j.update("INSERT INTO contract_project(id,name,short_name,project_manager_id,contract_sign_body_id,project_attribute,user_id,start_date) VALUES(?,'rebuild_inner_qa','rebuild_inner_qa',?,?,1,?,CURRENT_DATE)",PROJECT,actor,branch,actor);
    j.update("INSERT INTO scm_supplier(id,name,short_name) VALUES(?,'rebuild_inner_qa','rebuild_inner_qa')",SUPPLIER);
    j.update("INSERT INTO scm_purchase_order(id,project_ids,supplier_id,project_manager_id,serial_number,purchase_type,amount,branch_company_id,settlement_status) VALUES(?,?,?,?,?,1,100,?,0)",ORDER,String.valueOf(PROJECT),SUPPLIER,actor,"rebuild_inner_settlement_qa",branch);
    SupplierSettlementService service=c.getBean(SupplierSettlementService.class);SupplierSettlementAddDTOParam p=request(actor);
    require(service.getSupplierSettlementInner(PROJECT,actor,SUPPLIER,p.getPurchaseContractNumber(),1,20).getOrderId().equals(ORDER),"Exact original GET service");
    for(int kind=0;kind<4;kind++){
     SupplierSettlementAddDTOParam invalid=request(actor);if(kind==0)invalid.setProjectId(PROJECT+1);if(kind==1)invalid.setSupplierId(SUPPLIER+1);if(kind==2)invalid.setProjectManagerId(actor+999);if(kind==3)invalid.setPurchaseContractNumber("forged");
     try{service.addOaSupplierSettlement(invalid);throw new AssertionError("Forged relation accepted");}catch(IllegalArgumentException expected){}
    }
    require(j.queryForObject("SELECT COUNT(*) FROM contract_supplier_settlement",Long.class)==settlementBefore,"Relationship rejection makes no draft");
    j.update("UPDATE scm_purchase_order SET project_ids=? WHERE id=?",PROJECT+",1",ORDER);c.getBean(org.mybatis.spring.SqlSessionTemplate.class).clearCache();
    try{service.addOaSupplierSettlement(p);throw new AssertionError("Multi-project legacy write accepted");}catch(IllegalArgumentException expected){}
    try{service.getSupplierSettlementInner(PROJECT,actor,SUPPLIER,p.getPurchaseContractNumber(),1,20);throw new AssertionError("CSV substring lookup accepted");}catch(IllegalArgumentException expected){}
    j.update("UPDATE scm_purchase_order SET project_ids=? WHERE id=?",String.valueOf(PROJECT),ORDER);c.getBean(org.mybatis.spring.SqlSessionTemplate.class).clearCache();
    com.hzchum.pangu.common.pojo.vo.ResultVO result=service.addOaSupplierSettlement(p);require(result.getCode()==20000L,"Inner draft protocol code");long ledgerId=((Number)result.getData()).longValue();
    Map<String,Object> ledger=j.queryForMap("SELECT * FROM contract_audit_ledger WHERE id=?",ledgerId);long settlementId=Long.parseLong(String.valueOf(ledger.get("payment_id")));Map<String,Object> draft=j.queryForMap("SELECT * FROM contract_supplier_settlement WHERE id=?",settlementId);
    require(((Number)draft.get("supplier_id")).longValue()==SUPPLIER&&((Number)draft.get("order_id")).longValue()==ORDER&&((Number)draft.get("order_class")).intValue()==1,"Draft facts from order");
    require(((Number)draft.get("apply_user_id")).longValue()==actor&&((Number)ledger.get("initiator_id")).longValue()==actor,"Browser actor ignored");
    require(((Number)ledger.get("supplier_id")).longValue()==SUPPLIER&&String.valueOf(ledger.get("project_id")).equals(String.valueOf(PROJECT)),"Ledger facts from order project");
    require(((Number)draft.get("audit_status")).intValue()==1&&((Number)ledger.get("audit_status_enum")).intValue()==1,"Drafts stay auditing");
    require(Boolean.TRUE.equals(draft.get("bool_delete_enum"))&&Boolean.TRUE.equals(ledger.get("bool_delete_enum")),"OA preview soft-hidden drafts preserved");
    require(((java.sql.Timestamp)ledger.get("filing_date")).toLocalDateTime().equals(p.getApplyDate()),"Original requested filing date preserved");
    require(((BigDecimal)draft.get("amount")).compareTo(new BigDecimal("10.25"))==0,"Original monetary amount");
    require(j.queryForObject("SELECT settlement_status FROM scm_purchase_order WHERE id=?",Integer.class,ORDER)==0,"Draft does not settle order");
    com.hzchum.scim.common.core.api.service.zhongnanoa.OaBusinessProcessService oa=c.getBean(com.hzchum.scim.common.core.api.service.zhongnanoa.OaBusinessProcessService.class);
    com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanFixedDataDTO preview=oa.getFixedData(ledgerId,3).getData();
    require(preview.getSettlementAmount().compareTo(p.getSettlementAmount())==0 && preview.getPurchaseType()==1 && preview.getSerialNumber().equals(p.getPurchaseContractNumber()),"Real original OA preview reads hidden owner draft");
    principal(actor,false,Collections.emptyList());
    try{oa.getFixedData(ledgerId,3);throw new AssertionError("No-permission hidden preview accepted");}catch(IllegalArgumentException expected){}
    long otherActor=j.queryForObject("SELECT MIN(id) FROM sys_user WHERE id<>?",Long.class,actor);principal(otherActor,true,Collections.emptyList());
    try{oa.getFixedData(ledgerId,3);throw new AssertionError("Other creator hidden preview accepted");}catch(IllegalArgumentException expected){}
    principal(actor,true,Collections.emptyList());
    evidence.put("original_oa_preview_reads_owned_hidden_draft",true);evidence.put("hidden_preview_no_permission_and_other_creator_rejected",true);

    evidence.put("exact_original_get_and_nested_draft_payload",true);evidence.put("forged_project_supplier_manager_serial_rejected",true);evidence.put("legacy_multi_project_and_csv_substring_rejected",true);evidence.put("supplier_order_class_and_filing_date_restored",true);evidence.put("authenticated_actor_not_browser_actor",true);evidence.put("oa_hidden_draft_without_approval_or_payment",true);status.setRollbackOnly();return null;
   });
   require(j.queryForObject("SELECT COUNT(*) FROM contract_supplier_settlement",Long.class)==settlementBefore&&j.queryForObject("SELECT COUNT(*) FROM contract_audit_ledger",Long.class)==ledgerBefore,"Whole outer transaction rolls back both drafts");require(j.queryForObject("SELECT COUNT(*) FROM scm_purchase_order WHERE id=?",Integer.class,ORDER)==0,"Fixture cleaned by rollback");evidence.put("outer_rollback_restores_drafts_and_fixtures",true);
  }finally{SecurityContextHolder.clearContext();new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new java.io.File("/evidence/inner-settlement-database-verification.json"),evidence);c.close();}
  System.out.println("INNER_SETTLEMENT_QA_PASSED");
 }
}
