package com.hzchum.scim.rest.runner.redis;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(120)
@Component
public class ReportNumberRedisRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ReportNumberRedisRunner.class);
   @Resource
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Resource
   private MesBuildingProduceInspectionTeamReportService produceInspectionTeamReportService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private MesBuildingProductProcessService mesBuildingProductProcessService;
   @Resource
   private MesBuildingProductProcessLinkService mesBuildingProductProcessLinkService;
   @Resource
   private MesBuildingTaskService mesBuildingTaskService;
   @Resource
   private RedisUtils redisUtils;

   @Override
   public void run(String... args) {
      MesBuildingProduceTeamReport lastReport = this.produceTeamReportService
         .getOne(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).orderByDesc(MesBuildingProduceTeamReport::getReportNumber).last("limit 1"));
      Long produceReportNumber = lastReport == null ? 1L : lastReport.getReportNumber();
      this.redisUtils.set("teamreport_reportnumber:", produceReportNumber);
      MesBuildingProduceInspectionTeamReport report = this.produceInspectionTeamReportService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReport.class)
               .orderByDesc(MesBuildingProduceInspectionTeamReport::getInspectReportNumber)
               .last("LIMIT 1")
         );
      Long reportNumber = report == null ? 1L : report.getInspectReportNumber();
      this.redisUtils.set("inspection_reportnumber:", reportNumber);
   }

   public ReportNumberRedisRunner(
      final MesBuildingProduceTeamReportService produceTeamReportService,
      final MesBuildingProduceInspectionTeamReportService produceInspectionTeamReportService,
      final MesBuildingCompleteService completeService,
      final TechArtifactService artifactService,
      final MesBuildingProductProcessService mesBuildingProductProcessService,
      final MesBuildingProductProcessLinkService mesBuildingProductProcessLinkService,
      final MesBuildingTaskService mesBuildingTaskService,
      final RedisUtils redisUtils
   ) {
      this.produceTeamReportService = produceTeamReportService;
      this.produceInspectionTeamReportService = produceInspectionTeamReportService;
      this.completeService = completeService;
      this.artifactService = artifactService;
      this.mesBuildingProductProcessService = mesBuildingProductProcessService;
      this.mesBuildingProductProcessLinkService = mesBuildingProductProcessLinkService;
      this.mesBuildingTaskService = mesBuildingTaskService;
      this.redisUtils = redisUtils;
   }
}
