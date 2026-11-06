package com.hzchum.scim.rest.initialize.mes.building;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProjectProductionSummaryBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Order(61)
public class MesProjectProductionSummaryRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesProjectProductionSummaryRunner.class);
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private MesBuildingProjectProductionSummaryBiz projectProductionSummaryBiz;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) {
      log.info("初始化项目制造汇总表............................................");
      if (this.projectProductionSummaryBiz.count() == 0) {
         List<MesBuildingProduceTeamReport> teamReportList = this.teamReportService
            .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).eq(MesBuildingProduceTeamReport::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()));
         if (teamReportList.size() > 0) {
            teamReportList.forEach(
               e -> {
                  List<MesBuildingProduceInspectionTeamReport> inspectionTeamReportList = this.inspectionTeamReportService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReport.class)
                           .eq(MesBuildingProduceInspectionTeamReport::getTaskProcessId, e.getTaskProcessId())
                     );
                  if (inspectionTeamReportList.size() == 0) {
                     this.projectProductionSummaryBiz
                        .updateProjectMeteSummary(e.getTaskId(), e.getTaskProcessId(), e.getInspectionQuantity(), e.getCreateTime());
                  } else {
                     inspectionTeamReportList.forEach(
                        inspectionTeamReport -> this.projectProductionSummaryBiz
                           .updateProjectMeteSummary(
                              inspectionTeamReport.getTaskId(),
                              inspectionTeamReport.getTaskProcessId(),
                              inspectionTeamReport.getInspectionQuantity(),
                              inspectionTeamReport.getCreateTime()
                           )
                     );
                  }
               }
            );
         }
      }

      log.info("初始化项目制造汇总表  处理操作结束----------------------------------------");
   }

   public MesProjectProductionSummaryRunner(
      final MesBuildingCompleteService completeService,
      final MesBuildingProjectProductionSummaryBiz projectProductionSummaryBiz,
      final MesBuildingProduceTeamReportService teamReportService,
      final MesBuildingProduceInspectionTeamReportService inspectionTeamReportService
   ) {
      this.completeService = completeService;
      this.projectProductionSummaryBiz = projectProductionSummaryBiz;
      this.teamReportService = teamReportService;
      this.inspectionTeamReportService = inspectionTeamReportService;
   }
}
