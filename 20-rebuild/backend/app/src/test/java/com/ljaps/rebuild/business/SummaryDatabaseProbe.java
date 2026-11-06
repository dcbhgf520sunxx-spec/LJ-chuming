package com.ljaps.rebuild.business;

import com.ljaps.rebuild.RebuildApplication;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import java.time.YearMonth;
import java.util.*;

/** Test-only main; separately compiled into the disposable QA evidence directory, never application JAR. */
public class SummaryDatabaseProbe {
    static final long PRODUCT=8900003000001L,PROJECT=8900003000099L;
    static ProductProductionSummaryDTOParam delta(int type,int task,int production,int complete){return ProductProductionSummaryDTOParam.builder().projectId(PROJECT).monomerId(PROJECT).productId(PRODUCT).productType(type).taskQuantity(task).inProductionQuantity(production).completeQuantity(complete).build();}
    static void require(boolean condition,String message){if(!condition)throw new AssertionError(message);}
    static List<Map<String,Object>> rows(JdbcTemplate jdbc){return jdbc.queryForList("SELECT id,product_type,task_quantity,in_production_quantity,complete_quantity,month FROM mes_building_product_production_summary WHERE product_id=? ORDER BY month,product_type",PRODUCT);}
    static void totals(JdbcTemplate jdbc,int type,String month,int task,int production,int complete){List<Map<String,Object>> rows=jdbc.queryForList("SELECT task_quantity,in_production_quantity,complete_quantity FROM mes_building_product_production_summary WHERE product_id=? AND product_type=? AND month=?",PRODUCT,type,month);require(rows.size()==1,"Distinct month/product/type row required");Map<String,Object> row=rows.get(0);require(((Number)row.get("task_quantity")).intValue()==task && ((Number)row.get("in_production_quantity")).intValue()==production && ((Number)row.get("complete_quantity")).intValue()==complete,"Persisted increments differ");}
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context=SpringApplication.run(RebuildApplication.class,args);
        JdbcTemplate jdbc=context.getBean(JdbcTemplate.class);String db=jdbc.queryForObject("SELECT DATABASE()",String.class);
        require(db.startsWith("plm7_rebuild_qa_"),"Only independent QA database allowed");
        require(rows(jdbc).isEmpty(),"Fixture product must be unused");
        Map<String,Object> evidence=new LinkedHashMap<>();evidence.put("database",db);
        try{
            MesBuildingProductProductionSummaryService service=context.getBean(MesBuildingProductProductionSummaryService.class);String month=YearMonth.now().toString(),previous=YearMonth.now().minusMonths(1).toString();
            require(service.updateRecord(delta(2,5,3,1)),"Insert must persist");totals(jdbc,2,month,5,3,1);long id=((Number)rows(jdbc).get(0).get("id")).longValue();
            require(service.updateRecord(delta(2,2,1,1)),"Increment must persist");totals(jdbc,2,month,7,4,2);require(((Number)rows(jdbc).get(0).get("id")).longValue()==id,"Same month must reuse row");
            require(service.updateRecord(delta(2,-1,-1,-1)),"Negative source delta must persist");totals(jdbc,2,month,6,3,1);
            require(service.updateRecord(delta(1,11,7,4)),"Different type insert");totals(jdbc,1,month,11,7,4);totals(jdbc,2,month,6,3,1);
            jdbc.update("INSERT INTO mes_building_product_production_summary(project_id,product_id,product_type,task_quantity,in_production_quantity,complete_quantity,month) VALUES(?,?,2,99,88,77,?)",PROJECT,PRODUCT,previous);
            require(service.updateRecord(delta(2,1,1,1)),"Current month increment");totals(jdbc,2,month,7,4,2);totals(jdbc,2,previous,99,88,77);
            require(service.updateRecordForMonth(delta(2,0,-2,-3),previous),"Report-month reversal");totals(jdbc,2,previous,99,86,74);totals(jdbc,2,month,7,4,2);
            evidence.put("reversal_targets_original_report_month",true);
            List<Map<String,Object>> before=rows(jdbc);TransactionTemplate tx=new TransactionTemplate(context.getBean(PlatformTransactionManager.class));
            try{tx.execute(status->{service.updateRecord(delta(2,100,100,100));throw new IllegalStateException("QA forced transaction rollback");});throw new AssertionError("Expected rollback");}catch(IllegalStateException expected){require(expected.getMessage().contains("QA forced"),"Unexpected transaction failure");}
            require(before.equals(rows(jdbc)),"Outer business transaction rollback must restore counters");
            require(jdbc.queryForObject("SELECT COUNT(*) FROM plan_area WHERE id BETWEEN 8900003000101 AND 8900003000104",Integer.class)==0,"Area fixture identities must be unused");
            jdbc.update("INSERT INTO plan_area(id,project_id,monomer_id,name,type,bool_delete_enum) VALUES(8900003000101,?,?,'rebuild_area_qa_1',1,0),(8900003000102,?,?,'rebuild_area_qa_2',1,0),(8900003000103,?,?,'rebuild_area_qa_deleted',1,1),(8900003000104,?,?,'rebuild_area_qa_other',1,0)",PROJECT,PROJECT,PROJECT,PROJECT,PROJECT,PROJECT,PROJECT,PROJECT+1);
            java.util.List<com.hzchum.scim.plan.core.api.pojo._do.PlanArea> areas=context.getBean(com.hzchum.scim.plan.core.api.service.PlanAreaService.class).listAreaByMonomerId(PROJECT);
            require(areas.size()==2 && areas.stream().allMatch(a->a.getMonomerId().equals(PROJECT) && a.getId()>=8900003000101L && a.getId()<=8900003000102L),"Monomer boundary and logical deletion must be preserved");
            evidence.put("area_query_matches_only_requested_monomer_active_rows",true);
            evidence.put("new_record_persisted",true);evidence.put("same_month_incremented_same_record",true);evidence.put("negative_delta_applied",true);evidence.put("same_product_different_type_separated",true);evidence.put("previous_month_unchanged",true);evidence.put("outer_transaction_rolled_back",true);
        }finally{
            jdbc.update("DELETE FROM plan_area WHERE id BETWEEN 8900003000101 AND 8900003000104 AND name LIKE 'rebuild_area_qa_%'");
            jdbc.update("DELETE FROM mes_building_product_production_summary WHERE product_id=? AND project_id=?",PRODUCT,PROJECT);evidence.put("fixture_cleanup",rows(jdbc).isEmpty());
            new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new java.io.File("/evidence/summary-persistence-verification.json"),evidence);context.close();
        }
        System.out.println("SUMMARY_PERSISTENCE_QA_PASSED");
    }
}
