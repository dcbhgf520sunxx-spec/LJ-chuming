package com.ljaps.rebuild.business;

import com.ljaps.rebuild.RebuildApplication;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProjectProductionSummaryBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.aop.framework.Advised;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;

/** Real DB, fixture-only transaction; never in the production artifact. HTTP chain is tested separately. */
public class ProductionMonthlyDatabaseProbe {
 static final long BASE=8900004000000L, PROJECT=BASE+99, PRODUCT=BASE+1,TASK=BASE+2;
 static void require(boolean condition,String message){if(!condition)throw new AssertionError(message);}
 static Object target(Object bean)throws Exception{return bean instanceof Advised ? ((Advised)bean).getTargetSource().getTarget():bean;}
 static void invoke(Object bean,String name,Class<?>[] types,Object... args)throws Exception {Object t=target(bean);java.lang.reflect.Method m=t.getClass().getDeclaredMethod(name,types);m.setAccessible(true);m.invoke(t,args);}
 static Map<String,Object> product(JdbcTemplate j,String month){return j.queryForMap("SELECT task_quantity,in_production_quantity,complete_quantity FROM mes_building_product_production_summary WHERE product_id=? AND product_type=2 AND month=? AND bool_delete_enum=0",PRODUCT,month);}
 static void productTotals(JdbcTemplate j,String month,int task,int production,int complete){Map<String,Object> p=product(j,month);require(((Number)p.get("task_quantity")).intValue()==task&&((Number)p.get("in_production_quantity")).intValue()==production&&((Number)p.get("complete_quantity")).intValue()==complete,"Product dispatch/report/revoke counters differ");}
 static Map<String,Object> project(JdbcTemplate j,boolean global,String month){List<Map<String,Object>> rows=j.queryForList("SELECT quantity,mete,paining_quantity,paining_mete,assembly_riveting_welding_quantity,assembly_riveting_welding_mete FROM mes_building_project_production_summary WHERE "+(global?"project_id IS NULL":"project_id="+PROJECT)+" AND month=? AND bool_delete_enum=0",month);return rows.isEmpty()?Collections.emptyMap():rows.get(0);}
 static void projectDelta(JdbcTemplate j,boolean global,String month,Map<String,Object> before,int assembled,int painting,int complete){Map<String,Object> p=project(j,global,month);String[] fields={"assembly_riveting_welding_quantity","paining_quantity","quantity","assembly_riveting_welding_mete","paining_mete","mete"};BigDecimal[] deltas={new BigDecimal(assembled),new BigDecimal(painting),new BigDecimal(complete),new BigDecimal("3.14").multiply(new BigDecimal(assembled)),new BigDecimal("3.14").multiply(new BigDecimal(painting)),new BigDecimal("3.14").multiply(new BigDecimal(complete))};for(int i=0;i<fields.length;i++){BigDecimal a=new BigDecimal(String.valueOf(p.getOrDefault(fields[i],0))),b=new BigDecimal(String.valueOf(before.getOrDefault(fields[i],0)));require(a.subtract(b).compareTo(deltas[i])==0,"Project/global field differs: "+fields[i]);}}
 public static void main(String[] args)throws Exception{
  ConfigurableApplicationContext c=SpringApplication.run(RebuildApplication.class,args);JdbcTemplate j=c.getBean(JdbcTemplate.class);String db=j.queryForObject("SELECT DATABASE()",String.class);require(db.startsWith("plm7_rebuild_qa_"),"Independent QA only");Map<String,Object> evidence=new LinkedHashMap<>();evidence.put("database",db);
  try{
   TransactionTemplate tx=new TransactionTemplate(c.getBean(PlatformTransactionManager.class));
   tx.execute(status->{try{
    String month=YearMonth.now().toString();String prior=YearMonth.now().minusMonths(1).toString();
    require(j.queryForObject("SELECT COUNT(*) FROM tech_artifact WHERE id=?",Integer.class,PRODUCT)==0,"Fixture must be unused");
    Map<String,Object> globalBefore=project(j,true,month);
    j.update("INSERT INTO tech_artifact(id,project_id,monomer_id,serial_number,quantity,net_weight,spec_prefix,serial_number_prefix) VALUES(?,?,?,'rebuild_monthly_fixture',2,3.14,'Q','Q')",PRODUCT,PROJECT,PROJECT);
    j.update("INSERT INTO mes_building_task(id,project_id,monomer_id,product_id,task_type_enum,product_process_id,user_id,task_quantity,in_production_quantity,complete_quantity) VALUES(?,?,?,?,2,0,1,2,2,2)",TASK,PROJECT,PROJECT,PRODUCT);
    for(int i=0;i<4;i++){
     j.update("INSERT INTO mes_building_process(id,name,product_type,user_id,type,product_category_type) VALUES(?,'rebuild_monthly_fixture',2,1,?,2)",BASE+10+i,i==3?2:1);
     j.update("INSERT INTO mes_building_task_process(id,task_id,project_id,product_id,task_type_enum,product_process_id,user_id,process_id,sequence,task_quantity) VALUES(?,?,?,?,2,0,1,?,?,2)",BASE+20+i,TASK,PROJECT,PRODUCT,BASE+10+i,i);
    }
    Object order=c.getBean("mesBuildingTaskOrderBizImpl");MesBuildingTask task=MesBuildingTask.builder().id(TASK).projectId(PROJECT).monomerId(PROJECT).productId(PRODUCT).taskTypeEnum(2).taskQuantity(2).build();
    invoke(order,"recordNewTaskQuantities",new Class<?>[]{List.class},Arrays.asList(task));productTotals(j,month,2,0,0);
    com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService summary=c.getBean(com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService.class);
    summary.updateRecord(com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam.builder().projectId(PROJECT).monomerId(PROJECT).productId(PRODUCT).productType(2).inProductionQuantity(2).completeQuantity(2).build());productTotals(j,month,2,2,2);
    MesBuildingProduceTeamReport report=MesBuildingProduceTeamReport.builder().quantity(1).build();report.setCreateTime(LocalDateTime.now());
    Object newTask=c.getBean("mesBuildingNewTaskBizImpl");MesBuildingTaskProcess first=MesBuildingTaskProcess.builder().id(BASE+20).taskId(TASK).sequence(0).build(),last=MesBuildingTaskProcess.builder().id(BASE+23).taskId(TASK).sequence(3).build();
    invoke(newTask,"reverseMonthlyProductionSummary",new Class<?>[]{List.class,MesBuildingTaskProcess.class,boolean.class},Arrays.asList(report),first,true);productTotals(j,month,2,1,2);
    summary.updateRecord(com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam.builder().projectId(PROJECT).monomerId(PROJECT).productId(PRODUCT).productType(2).inProductionQuantity(1).build());productTotals(j,month,2,2,2);
    invoke(newTask,"reverseMonthlyProductionSummary",new Class<?>[]{List.class,MesBuildingTaskProcess.class,boolean.class},Arrays.asList(report),last,true);productTotals(j,month,2,2,1);
    summary.updateRecord(com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam.builder().projectId(PROJECT).monomerId(PROJECT).productId(PRODUCT).productType(2).completeQuantity(1).build());productTotals(j,month,2,2,2);
    MesBuildingProjectProductionSummaryBiz b=c.getBean(MesBuildingProjectProductionSummaryBiz.class);
    b.updateProjectMeteSummary(TASK,BASE+20,2,null);projectDelta(j,false,month,Collections.emptyMap(),0,0,0);
    b.updateProjectMeteSummary(TASK,BASE+22,2,null);projectDelta(j,false,month,Collections.emptyMap(),2,0,0);projectDelta(j,true,month,globalBefore,2,0,0);
    b.updateProjectMeteSummary(TASK,BASE+23,2,null);projectDelta(j,false,month,Collections.emptyMap(),2,2,2);projectDelta(j,true,month,globalBefore,2,2,2);
    b.revokeProjectMeteSummary(TASK,BASE+23,1,LocalDateTime.now());projectDelta(j,false,month,Collections.emptyMap(),2,1,1);
    b.updateProjectMeteSummary(TASK,BASE+23,1,null);projectDelta(j,false,month,Collections.emptyMap(),2,2,2);projectDelta(j,true,month,globalBefore,2,2,2);
    b.revokeProjectMeteSummary(TASK,BASE+23,2,LocalDateTime.now());b.revokeProjectMeteSummary(TASK,BASE+22,2,LocalDateTime.now());projectDelta(j,false,month,Collections.emptyMap(),0,0,0);projectDelta(j,true,month,globalBefore,0,0,0);
    j.update("INSERT INTO mes_building_cargo_list(id,project_id,license_plate,quantity,total_net_weight,total_gross_weight,actual_weight,actual_gross_weight,total_price,status) VALUES(?,?,'rebuild_qa_only',1,3.14,4,3.14,4,9,4),(?,?,'rebuild_qa_only',1,3.14,4,3.14,4,9,8)",BASE+80,PROJECT,BASE+81,PROJECT);
    com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz cargo=c.getBean(com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz.class);
    require(cargo.shipmentByProject(PROJECT).size()==2 && cargo.shipmentByProject(PROJECT).stream().allMatch(x->x.getQuantity()==1),"Both shipped statuses have numeric piece count");
    Map shipment=cargo.shipmentSummary(PROJECT);require(((Number)shipment.get("quantity")).intValue()==2 && ((BigDecimal)shipment.get("totalNetWeight")).compareTo(new BigDecimal("6.28"))==0 && ((BigDecimal)shipment.get("totalPrice")).compareTo(new BigDecimal("18"))==0,"Shipment summary quantities/weights/prices");
    com.hzchum.pangu.common.pojo.vo.PageVO shipmentPage=cargo.shipmentByProjectPage(PROJECT,1,10);require(shipmentPage.getContent().size()==2,"Shipment page same real rows");
    require(((com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.MesBuildingCargoListDTO)shipmentPage.getContent().get(0)).getQuantity()==1,"Shipment page quantity conversion");
    evidence.put("real_shipment_list_summary_and_page_numeric_quantity",true);
    evidence.put("dispatch_null_default_counters",true);evidence.put("first_revoke_then_rereport_returns_two_not_three",true);evidence.put("last_revoke_then_rereport_returns_two",true);evidence.put("own_project_and_global_fields",true);evidence.put("two_pieces_weight_6_28kg",true);evidence.put("non_penultimate_assembly_does_not_add_project",true);evidence.put("project_revoke_then_rereport",true);status.setRollbackOnly();return null;
   }catch(Exception e){throw new RuntimeException(e);}});
   require(j.queryForObject("SELECT COUNT(*) FROM tech_artifact WHERE id=?",Integer.class,PRODUCT)==0,"Fixture transaction rolled back");require(j.queryForObject("SELECT COUNT(*) FROM mes_building_product_production_summary WHERE product_id=?",Integer.class,PRODUCT)==0,"Product summaries rolled back");evidence.put("outer_transaction_rolls_back_business_and_summaries",true);
  }finally{new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new java.io.File("/evidence/production-monthly-database-verification.json"),evidence);c.close();}
  System.out.println("PRODUCTION_MONTHLY_QA_PASSED");
 }
}
