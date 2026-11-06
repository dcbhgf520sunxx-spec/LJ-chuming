package com.hzchum.scim.rest.runner.test;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MesBuildingProduceTeamReportTest1 implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingProduceTeamReportTest1.class);
   @Resource
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Resource
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;

   @Override
   public void run(String... args) throws Exception {
      List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
         .list(
            (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                  .in(MesBuildingProduceTeamReport::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType(), TaskTypeEnum.ASSEMBLE.getType()))
               .isNull(MesBuildingProduceTeamReport::getInspectionTime)
         );
      if (CollectionUtils.isNotEmpty(produceTeamReportList)) {
         List<MesBuildingProduceInspectionTeamReport> inspectionTeamReports = this.inspectionTeamReportService
            .list(
               (Wrapper<MesBuildingProduceInspectionTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                     .in(MesBuildingProduceInspectionTeamReport::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType(), TaskTypeEnum.ASSEMBLE.getType()))
                  .eq(MesBuildingProduceInspectionTeamReport::getBoolAdoptEnum, Boolean.TRUE)
            );
         if (CollectionUtils.isNotEmpty(inspectionTeamReports)) {
            Map<String, MesBuildingProduceInspectionTeamReport> produceInspectionTeamReportMap = inspectionTeamReports.stream()
               .collect(Collectors.toMap(e -> e.getTaskTypeEnum() + "-" + e.getProductId() + "-" + e.getNumber() + "-" + e.getProcessId(), Function.identity()));

            for (MesBuildingProduceTeamReport report : produceTeamReportList) {
               MesBuildingProduceInspectionTeamReport inspectionTeamReport = produceInspectionTeamReportMap.get(
                  report.getTaskTypeEnum() + "-" + report.getProductId() + "-" + report.getNumber() + "-" + report.getProcessId()
               );
               if (inspectionTeamReport != null) {
                  report.setInspectionTime(inspectionTeamReport.getInspectReportTime());
                  report.setInspectionInYearMonthDate(inspectionTeamReport.getInspectReportTime().format(DatePattern.NORM_MONTH_FORMATTER));
                  report.setInspectionInYearMonthDayDate(inspectionTeamReport.getInspectReportTime().format(DatePattern.NORM_DATE_FORMATTER));
               }

               if (inspectionTeamReport == null && report.getInspectionQuantity() != null && report.getInspectionQuantity() > 0) {
                  report.setInspectionTime(report.getCreateTime());
                  report.setInspectionInYearMonthDate(report.getCreateTime().format(DatePattern.NORM_MONTH_FORMATTER));
                  report.setInspectionInYearMonthDayDate(report.getCreateTime().format(DatePattern.NORM_DATE_FORMATTER));
               }
            }

            this.produceTeamReportService.updateBatchById(produceTeamReportList, 3000);
         }
      }
   }
}
