package com.ljaps.rebuild.business;
import com.ljaps.rebuild.RebuildApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.time.YearMonth;
import java.util.*;
import java.lang.reflect.Method;
/** Only dedicated QA monthly records, original cron method and real transactional period ledger. */
public class ProductionCarryDatabaseProbe {
 static final long BASE=8900006000000L;
 static void require(boolean b,String m){if(!b)throw new AssertionError(m);}
 static List<Map<String,Object>> rows(JdbcTemplate j){return j.queryForList("SELECT * FROM mes_building_product_production_summary WHERE project_id=? ORDER BY product_id,product_type,month",BASE);}
 static void totals(JdbcTemplate j,long product,int type,String month,int begin,int task,int production,int complete){Map<String,Object> r=j.queryForMap("SELECT begin_quantity,task_quantity,in_production_quantity,complete_quantity FROM mes_building_product_production_summary WHERE product_id=? AND product_type=? AND month=? AND bool_delete_enum=0",product,type,month);require(((Number)r.get("begin_quantity")).intValue()==begin&&((Number)r.get("task_quantity")).intValue()==task&&((Number)r.get("in_production_quantity")).intValue()==production&&((Number)r.get("complete_quantity")).intValue()==complete,"Carry merged into correct product/type/month");}
 public static void main(String[]args)throws Exception{
  ConfigurableApplicationContext c=SpringApplication.run(RebuildApplication.class,args);JdbcTemplate j=c.getBean(JdbcTemplate.class);String db=j.queryForObject("SELECT DATABASE()",String.class);require(db.startsWith("plm7_rebuild_qa_"),"Independent QA only");String month=YearMonth.now().toString(),previous=YearMonth.now().minusMonths(1).toString(),job="com.hzchum.scim.rest.schedule.ProductProductionSummarySchedule#task1";Map<String,Object> evidence=new LinkedHashMap<>();evidence.put("database",db);
  require(j.queryForObject("SELECT COUNT(*) FROM mes_building_product_production_summary WHERE month=?",Integer.class,previous)==0,"Do not replay other previous-month records");require(rows(j).isEmpty(),"Fixture unused");require(j.queryForObject("SELECT COUNT(*) FROM rebuild_job_execution WHERE job_name=? AND period_key=?",Integer.class,job,month)==0,"Period fixture must be absent");
  try{
   String insert="INSERT INTO mes_building_product_production_summary(project_id,monomer_id,product_id,product_type,begin_quantity,task_quantity,in_production_quantity,complete_quantity,month) VALUES(?,?,?,?,?,?,?,?,?)";
   j.update(insert,BASE,BASE,BASE+1,2,2,10,7,4,previous);
   j.update(insert,BASE,BASE,BASE+1,1,1,5,4,2,previous);
   j.update(insert,BASE,BASE,BASE+2,2,3,8,6,2,previous);
   j.update(insert,BASE,BASE,BASE+2,2,0,5,3,1,month);
   j.update(insert,BASE,BASE,BASE+9,2,0,2,1,0,previous);
   j.update(insert,BASE,BASE,BASE+9,2,777,1,1,0,month);
   List<Map<String,Object>> before=rows(j);
   LocalBusinessLifecycle life=c.getBean(LocalBusinessLifecycle.class);Object target=c.getAutowireCapableBeanFactory().createBean(Class.forName("com.hzchum.scim.rest.schedule.ProductProductionSummarySchedule"));Method action=target.getClass().getMethod("task1"),execute=LocalBusinessLifecycle.class.getDeclaredMethod("execute",String.class,String.class,Object.class,Method.class);execute.setAccessible(true);
   try{execute.invoke(life,job,"monthly",target,action);throw new AssertionError("Ambiguous historical opening must fail");}catch(java.lang.reflect.InvocationTargetException expected){require(expected.getCause() instanceof RuntimeException,"Explicit source-state failure");}
   require(before.equals(rows(j)),"Failure rolls back every earlier carry mutation");require("FAILED".equals(j.queryForObject("SELECT status FROM rebuild_job_execution WHERE job_name=? AND period_key=?",String.class,job,month)),"Failure recorded separately");evidence.put("ambiguous_opening_rejected_and_all_carry_changes_rolled_back",true);
   j.update("UPDATE mes_building_product_production_summary SET begin_quantity=0 WHERE project_id=? AND product_id=? AND month=?",BASE,BASE+9,month);
   require("SUCCEEDED".equals(execute.invoke(life,job,"monthly",target,action)),"Retry commits original source cron method and monthly ledger");
   totals(j,BASE+1,2,month,8,0,3,0);totals(j,BASE+1,1,month,4,0,2,0);totals(j,BASE+2,2,month,9,5,7,1);totals(j,BASE+9,2,month,2,1,2,0);
   totals(j,BASE+1,2,previous,2,10,7,4);totals(j,BASE+2,2,previous,3,8,6,2);
   List<Map<String,Object>> committed=rows(j);require("SKIPPED_SUCCEEDED".equals(execute.invoke(life,job,"monthly",target,action)),"Repeated successful monthly period skips");require(committed.equals(rows(j)),"Repeated period changes no records");
   evidence.put("new_current_month_row_uses_original_formula",true);evidence.put("existing_new_month_task_complete_preserved_and_inproduction_added",true);evidence.put("same_product_different_type_isolated",true);evidence.put("previous_month_records_unchanged",true);evidence.put("same_period_repeated_without_double_carry",true);evidence.put("failed_period_retry_then_succeeded",true);evidence.put("original_cron",action.getAnnotation(org.springframework.scheduling.annotation.Scheduled.class).cron());
  }finally{
   j.update("DELETE FROM mes_building_product_production_summary WHERE project_id=? AND product_id IN(?,?,?)",BASE,BASE+1,BASE+2,BASE+9);j.update("DELETE FROM rebuild_job_execution WHERE job_name=? AND period_key=?",job,month);evidence.put("fixture_cleanup",rows(j).isEmpty());new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new java.io.File("/evidence/production-carry-database-verification.json"),evidence);c.close();
  }
  System.out.println("PRODUCTION_CARRY_QA_PASSED");
 }
}
