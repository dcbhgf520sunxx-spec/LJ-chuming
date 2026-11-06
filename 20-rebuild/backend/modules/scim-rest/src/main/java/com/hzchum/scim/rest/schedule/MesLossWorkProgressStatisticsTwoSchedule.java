package com.hzchum.scim.rest.schedule;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesLossWorkProgressStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageLossCostSummaryDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MesLossWorkProgressStatisticsTwoSchedule {
   private static final Logger log = LoggerFactory.getLogger(MesLossWorkProgressStatisticsTwoSchedule.class);
   @Resource
   private RedisUtils redisUtils;
   private static final ObjectMapper objectMapper = new ObjectMapper();
   private static final String PROJECT_WASTAGEDTOBY_DETAIL_KEY = "project_wastagedtoby_detail_key";
   private static final String WORKSHOP_WASTAGEDTOBY_DETAIL_KEY = "workshop_wastagedtoby_deail_key";
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesLossWorkProgressStatisticsBiz progressStatisticsBiz;
   @Resource
   private MesBuildingWorkshopService workshopService;
   private ConfigService configService;

   @Scheduled(cron = "0 0 3 * * ?")
   public void task3() {
      Integer lossCalculationFormula = this.configService.getRawMaterialLossCalculationFormula();
      List<ContractProject> projectList = this.projectService.list();
      if (CollectionUtils.isNotEmpty(projectList)) {
         for (ContractProject project : projectList) {
            List<WastageLossCostSummaryDTO> costSummaryDTOS = Lists.newArrayList();
            this.progressStatisticsBiz.getWastageLossCostSummaryByproject(project.getId(), costSummaryDTOS, lossCalculationFormula);
            if (CollectionUtils.isNotEmpty(costSummaryDTOS)) {
               String jsonData = null;

               try {
                  jsonData = objectMapper.writeValueAsString(costSummaryDTOS);
                  this.redisUtils.set("project_wastagedtoby_detail_key" + project.getId(), jsonData);
               } catch (JsonProcessingException e) {
                  e.printStackTrace();
         throw new IllegalStateException("Local business task failed", e);
               }
            }
         }
      }

      List<MesBuildingWorkshop> workshopList = this.workshopService.list();
      if (CollectionUtils.isNotEmpty(workshopList)) {
         List<LocalDateTime> localDateTimes = workshopList.stream().map(BaseEntity::getCreateTime).collect(Collectors.toList());
         LocalDateTime startDateTime = Collections.min(localDateTimes);
         LocalDateTime endDateTime = LocalDateTime.now();
         List<Integer> years = new ArrayList<>();
         if (startDateTime.getYear() == endDateTime.getYear()) {
            years.add(startDateTime.getYear());
         } else {
            for (LocalDateTime current = startDateTime; !current.isAfter(endDateTime); current = current.plusYears(1L)) {
               years.add(current.getYear());
            }
         }

         for (Integer year : years) {
            for (MesBuildingWorkshop workshop : workshopList) {
               List<WastageLossCostSummaryDTO> costSummaryDTOS = Lists.newArrayList();
               this.progressStatisticsBiz.getWastageLossCostSummaryByWorkShop(year, workshop.getId(), costSummaryDTOS, lossCalculationFormula);
               if (CollectionUtils.isNotEmpty(costSummaryDTOS)) {
                  String jsonData = null;

                  try {
                     jsonData = objectMapper.writeValueAsString(costSummaryDTOS);
                     this.redisUtils.set("workshop_wastagedtoby_deail_key" + workshop.getId() + year, jsonData);
                  } catch (JsonProcessingException e) {
                     e.printStackTrace();
         throw new IllegalStateException("Local business task failed", e);
                  }
               }
            }
         }
      }
   }

   public MesLossWorkProgressStatisticsTwoSchedule(
      final RedisUtils redisUtils,
      final ContractProjectService projectService,
      final MesLossWorkProgressStatisticsBiz progressStatisticsBiz,
      final MesBuildingWorkshopService workshopService,
      final ConfigService configService
   ) {
      this.redisUtils = redisUtils;
      this.projectService = projectService;
      this.progressStatisticsBiz = progressStatisticsBiz;
      this.workshopService = workshopService;
      this.configService = configService;
   }
}
