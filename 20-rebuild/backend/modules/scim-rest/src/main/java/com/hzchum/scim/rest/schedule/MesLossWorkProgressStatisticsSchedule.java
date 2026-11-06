package com.hzchum.scim.rest.schedule;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesLossWorkProgressStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProjectLossWorkProgressStatisticsWastageDTO;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MesLossWorkProgressStatisticsSchedule {
   private static final Logger log = LoggerFactory.getLogger(MesLossWorkProgressStatisticsSchedule.class);
   @Resource
   private RedisUtils redisUtils;
   private static final ObjectMapper objectMapper = new ObjectMapper();
   private static final String PROJECT_WASTAGEDTOBY_KEY = "project_wastagedtoby_key";
   private static final String WORKSHOP_WASTAGEDTOBY_KEY = "workshop_wastagedtoby_key";
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesLossWorkProgressStatisticsBiz progressStatisticsBiz;
   private ConfigService configService;

   @Scheduled(cron = "0 0 2 * * ?")
   public void task3() {
      Integer lossCalculationFormula = this.configService.getRawMaterialLossCalculationFormula();
      List<Long> projectIds = this.projectService.list().stream().map(ContractProject::getId).collect(Collectors.toList());
      List<ProjectLossWorkProgressStatisticsWastageDTO> wastageDtoByProject = this.progressStatisticsBiz
         .getWastageDtoByProject(null, null, projectIds, lossCalculationFormula);
      if (CollectionUtils.isNotEmpty(wastageDtoByProject)) {
         try {
            String jsonData = objectMapper.writeValueAsString(wastageDtoByProject);
            this.redisUtils.set("project_wastagedtoby_key", jsonData);
         } catch (JsonProcessingException e) {
            log.error("损耗统计报表项目维度定时任务异常:", e.getMessage());
         throw new IllegalStateException("Local business task failed", e);
         }
      }

      List<ProjectLossWorkProgressStatisticsWastageDTO> wastageDtoByWorkShop = this.progressStatisticsBiz.getWastageDtoByWorkShop(null, lossCalculationFormula);
      if (CollectionUtils.isNotEmpty(wastageDtoByWorkShop)) {
         try {
            String jsonData = objectMapper.writeValueAsString(wastageDtoByWorkShop);
            this.redisUtils.set("workshop_wastagedtoby_key", jsonData);
         } catch (JsonProcessingException e) {
            log.error("损耗统计报表车间维度定时任务异常:", e.getMessage());
         throw new IllegalStateException("Local business task failed", e);
         }
      }
   }

   public MesLossWorkProgressStatisticsSchedule(
      final RedisUtils redisUtils,
      final ContractProjectService projectService,
      final MesLossWorkProgressStatisticsBiz progressStatisticsBiz,
      final ConfigService configService
   ) {
      this.redisUtils = redisUtils;
      this.projectService = projectService;
      this.progressStatisticsBiz = progressStatisticsBiz;
      this.configService = configService;
   }
}
