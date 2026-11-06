package com.hzchum.scim.rest.runner.onecode;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportSummaryService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Order(100)
public class OnecodeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(OnecodeRunner.class);
   private final MesBuildingProduceTeamReportSummaryService reportSummaryService;
   @Resource
   private InitializationService service;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      log.info("一物一码升级脚本开始............................................");
      this.addColumn();
      log.info("一物一码升级脚本结束............................................");
   }

   private void addColumn() {
      this.service
         .updateSql(
            "UPDATE mes_building_produce_team_report_summary summery, mes_building_task_process process SET summery.groups_id = process.groups_id WHERE summery.task_process_id = process.id and summery.groups_id is null;"
         );
      this.service.updateSql("UPDATE mes_building_produce_team_report SET report_time = create_time WHERE report_time is null ;");
      this.service.updateSql("UPDATE mes_building_produce_team_report SET report_number = id WHERE report_number =0 ;");
      this.service
         .updateSql(
            "UPDATE mes_building_task task,\nmes_building_task_order ord \nSET task.top_task_order_id = ord.top_task_order_id \nWHERE\n\ttask.top_task_order_id = 0 \n\tAND task.task_order_id = ord.id;"
         );
   }

   public OnecodeRunner(final MesBuildingProduceTeamReportSummaryService reportSummaryService, final InitializationService service) {
      this.reportSummaryService = reportSummaryService;
      this.service = service;
   }
}
