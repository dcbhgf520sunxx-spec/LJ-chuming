package com.hzchum.scim.rest.schedule;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.enums.QhseStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingProcessLagDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingProductionPlanningDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingQualityInspectionDTO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModeTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationConfigService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import io.swagger.annotations.Api;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "定时任务执行消息推送")
@RequestMapping("/api/MessagePushSchedule/config")
@RestController
public class MessagePushSchedule {
   private static final Logger log = LoggerFactory.getLogger(MessagePushSchedule.class);
   @Resource
   private final SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Resource
   private InboundDetailService inboundDetailService;
   @Resource
   private MoveOutboundDetailService outboundDetailService;
   @Resource
   private MaterialInventoryService inventoryService;
   @Resource
   private MesBuildingTaskOrderService taskOrderService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingCargoListService cargoListService;
   @Autowired
   private RedisTemplate redisTemplate;
   @Autowired
   private MesBuildingProduceTeamReportService teamReportService;
   @Autowired
   private SysPushNotificationConfigService configService;
   @Autowired
   private MesBuildingQhseService mesBuildingQhseService;
   @Autowired
   private WorkshopService workshopService;

   public void getSteelNventoryDetails() {
      log.info("----------------- 消息推送-钢材库存详情:00:00:10执行 -----------------");
      LocalDateTime now = LocalDateTime.now();
      LocalDateTime startOfLastMonth = now.minusMonths(1L).withDayOfMonth(1);
      LocalDateTime endOfLastMonth = now.withDayOfMonth(1).minusDays(1L);
      List<MaterialInventory> inventoryList = this.inventoryService
         .list(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .in(MaterialInventory::getBasicClass, 1, 2, 4)
               .ge(BaseEntity::getCreateTime, startOfLastMonth)
               .le(BaseEntity::getCreateTime, endOfLastMonth)
         );
      BigDecimal storageQuantity = ObjectUtils.isEmpty(this.inboundDetailService.getStorageQuantity())
         ? new BigDecimal(0)
         : this.inboundDetailService.getStorageQuantity();
      BigDecimal deliveryVolume = ObjectUtils.isEmpty(this.outboundDetailService.getDeliveryVolume())
         ? new BigDecimal(0)
         : this.outboundDetailService.getDeliveryVolume();
      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .notificationTypeEnum(NotificationModuleTypeEnum.STEEL_NVENTORY.getNotificationType())
               .userList(new ArrayList<>())
               .contentDetails(
                  this.detailsUtils
                     .getSteelInventoryDetails(
                        LocalDateTime.now(),
                        storageQuantity,
                        deliveryVolume,
                        inventoryList.stream().map(MaterialInventory::getMete).reduce(BigDecimal.ZERO, BigDecimal::add)
                     )
               )
               .build()
         );
   }

   public void getdeliveryCompletedDetails() {
      log.info("----------------- 消息推送-完工提示:每天23:58执行一次 -----------------");
      List<MesBuildingTaskOrder> taskOrders = this.taskOrderService
         .list(Wrappers.lambdaQuery(MesBuildingTaskOrder.class).eq(MesBuildingTaskOrder::getStatus, 1))
         .stream()
         .filter(e -> e.getCompleteTime() != null && e.getCompleteTime().toLocalDate().equals(LocalDate.now()))
         .collect(Collectors.toList());
      Map<String, List<MesBuildingTaskOrder>> taskOrderMap = taskOrders.stream().collect(Collectors.groupingBy(e -> e.getOrderNumber()));
      taskOrderMap.forEach(
         (orderNumber, v) -> {
            MesBuildingTaskOrder mesBuildingTaskOrder = v.get(0);
            this.sysPushFlowConfigBiz
               .triggerFlow(
                  NotificationServiceTriggerDTO.builder()
                     .notificationTypeEnum(NotificationModuleTypeEnum.DELIVERY_COMPLETED.getNotificationType())
                     .userList(new ArrayList<>())
                     .dataId(mesBuildingTaskOrder.getId())
                     .projectId(mesBuildingTaskOrder.getProjectId())
                     .contentDetails(this.detailsUtils.getCompletionNoticeDetails(mesBuildingTaskOrder.getProjectId(), orderNumber))
                     .build()
               );
         }
      );
   }

   public void getBehindScheduleDetails() {
      log.info("----------------- 消息推送-计划滞后-生产计划:每天00:00:10分钟执行一次 -----------------");
      List<MesBuildingProductionPlanningDTO> productionPlanningDateil = this.taskProcessService.getProductionPlanningDateil(LocalDateTime.now());
      if (CollectionUtils.isNotEmpty(productionPlanningDateil)) {
         productionPlanningDateil.stream()
            .collect(Collectors.groupingBy(MesBuildingProductionPlanningDTO::getProjectName))
            .forEach(
               (getProjectName, value) -> value.stream()
                  .collect(Collectors.groupingBy(MesBuildingProductionPlanningDTO::getWorkshopName))
                  .forEach(
                     (workshopName, processLagDTOList) -> processLagDTOList.stream()
                        .collect(Collectors.groupingBy(MesBuildingProductionPlanningDTO::getTeamName))
                        .forEach(
                           (teamName, processLagDTOList1) -> processLagDTOList1.stream()
                              .collect(Collectors.groupingBy(MesBuildingProductionPlanningDTO::getOrderNumber))
                              .forEach(
                                 (orderNumber, processLagDTOList2) -> {
                                    MesBuildingProductionPlanningDTO dateil = processLagDTOList2.get(0);
                                    this.sysPushFlowConfigBiz
                                       .triggerFlow(
                                          NotificationServiceTriggerDTO.builder()
                                             .notificationTypeEnum(NotificationModuleTypeEnum.PLAN_ENCOUNTER.getNotificationType())
                                             .userList(new ArrayList<>())
                                             .dataId(dateil.getTeskProcessId())
                                             .contentDetails(
                                                this.detailsUtils
                                                   .getBehindScheduleDetails(
                                                      dateil.getWorkshopName(),
                                                      dateil.getTeamName(),
                                                      dateil.getProcessName(),
                                                      dateil.getProjectName(),
                                                      dateil.getOrderNumber(),
                                                      dateil.getCompleteTime()
                                                   )
                                             )
                                             .build()
                                       );
                                 }
                              )
                        )
                  )
            );
      }
   }

   public void getProcessLagDetailsDetails() {
      log.info("----------------- 消息推送-工序呆滞:每60分钟执行一次 -----------------");
      SysPushNotificationConfig config = this.configService
         .getOne(
            Wrappers.lambdaQuery(SysPushNotificationConfig.class)
               .eq(SysPushNotificationConfig::getNotificationTypeEnum, NotificationModuleTypeEnum.PROCESS_SLUGGISHNESS.getNotificationType())
               .eq(SysPushNotificationConfig::getStatus, true)
         );
      List<MesBuildingProcessLagDTO> buildingProcessLags = this.taskProcessService.scheduledTaskLagNumber(LocalDateTime.now());
      if (CollectionUtils.isNotEmpty(buildingProcessLags)) {
         buildingProcessLags.stream()
            .collect(Collectors.groupingBy(MesBuildingProcessLagDTO::getProjectId))
            .forEach(
               (getProjectId, value) -> value.stream()
                  .collect(Collectors.groupingBy(MesBuildingProcessLagDTO::getWorkshopName))
                  .forEach(
                     (workshopName, processLagDTOList) -> processLagDTOList.stream()
                        .collect(Collectors.groupingBy(MesBuildingProcessLagDTO::getTeamName))
                        .forEach(
                           (teamName, processLagDTOList1) -> processLagDTOList1.stream()
                              .collect(Collectors.groupingBy(MesBuildingProcessLagDTO::getOrderNumber))
                              .forEach(
                                 (orderNumber, processLagDTOList2) -> {
                                    MesBuildingProcessLagDTO item = processLagDTOList2.get(0);
                                    StringBuffer processLagDetails = this.detailsUtils
                                       .getProcessLagDetails(
                                          item.getProjectId(), item.getWorkshopName(), item.getProcessName(), item.getTeamName(), item.getOrderNumber()
                                       );
                                    log.info(String.format("工序滞后即将发送：%s", processLagDetails));
                                    this.sysPushFlowConfigBiz
                                       .triggerFlow(
                                          NotificationServiceTriggerDTO.builder()
                                             .notificationTypeEnum(NotificationModuleTypeEnum.PROCESS_LAG.getNotificationType())
                                             .userList(new ArrayList<>())
                                             .projectId(item.getProjectId())
                                             .dataId(item.getTeskProcessId())
                                             .contentDetails(processLagDetails)
                                             .build()
                                       );
                                 }
                              )
                        )
                  )
            );
      }

      if (ObjectUtils.isNotEmpty(config) && config.getNumber() != null && config.getNumber() > 0) {
         log.info(String.format("%s,配置的工序呆滞数量为：%d", NotificationModuleTypeEnum.PROCESS_SLUGGISHNESS.getNotificationTypeName(), config.getNumber()));
         List<MesBuildingProcessLagDTO> mesBuildingProcessLagDTOS = buildingProcessLags.stream()
            .filter(e -> e.getUnQuantity() > config.getNumber())
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(mesBuildingProcessLagDTOS)) {
            mesBuildingProcessLagDTOS.stream()
               .collect(Collectors.groupingBy(MesBuildingProcessLagDTO::getProjectId))
               .forEach(
                  (getProjectId, value) -> value.stream()
                     .collect(Collectors.groupingBy(MesBuildingProcessLagDTO::getWorkshopName))
                     .forEach(
                        (workshopName, processLagDTOList) -> processLagDTOList.stream()
                           .collect(Collectors.groupingBy(MesBuildingProcessLagDTO::getTeamName))
                           .forEach(
                              (teamName, processLagDTOList1) -> processLagDTOList1.stream()
                                 .collect(Collectors.groupingBy(MesBuildingProcessLagDTO::getOrderNumber))
                                 .forEach(
                                    (orderNumber, processLagDTOList2) -> {
                                       MesBuildingProcessLagDTO processLagDTO = processLagDTOList2.get(0);
                                       StringBuffer processSlackDetails = this.detailsUtils
                                          .getProcessSlackDetails(
                                             processLagDTO.getProjectId(),
                                             processLagDTO.getWorkshopName(),
                                             processLagDTO.getProcessName(),
                                             processLagDTO.getTeamName(),
                                             processLagDTO.getUnQuantity()
                                          );
                                       log.info(String.format("工序呆滞即将发送：%s", processSlackDetails));
                                       this.sysPushFlowConfigBiz
                                          .triggerFlow(
                                             NotificationServiceTriggerDTO.builder()
                                                .notificationTypeEnum(NotificationModuleTypeEnum.PROCESS_SLUGGISHNESS.getNotificationType())
                                                .userList(new ArrayList<>())
                                                .projectId(processLagDTO.getProjectId())
                                                .dataId(processLagDTO.getTeskProcessId())
                                                .contentDetails(processSlackDetails)
                                                .build()
                                          );
                                    }
                                 )
                           )
                     )
               );
         }
      }
   }

   public void getQualityRectificationDetails() {
      log.info("----------------- 消息推送-质安整改:每60分钟执行一次 -----------------");
      LocalDateTime now = LocalDateTime.now();
      LocalDateTime twentyFourHoursAgo = now.minus(1L, ChronoUnit.DAYS);
      List<MesBuildingQhse> qhses = this.mesBuildingQhseService
         .list(
            (Wrapper<MesBuildingQhse>)(((Wrappers.<MesBuildingQhse>lambdaQuery()
                        .eq(MesBuildingQhse::getStatus, QhseStatusEnum.UN_ADOPT.getType()))
                     .or())
                  .eq(MesBuildingQhse::getStatus, QhseStatusEnum.UN_RECTIFIED.getType()))
               .and(i -> {
                  LambdaQueryWrapper var10000 = i.lt(BaseEntity::getCreateTime, twentyFourHoursAgo);
               })
         );
      qhses.forEach(
         qhse -> {
            Workshop workshop = this.workshopService.getById(qhse.getWorkshopId());
            this.sysPushFlowConfigBiz
               .triggerFlow(
                  NotificationServiceTriggerDTO.builder()
                     .contentDetails(
                        this.detailsUtils
                           .getRectificationTipsDetails(
                              QhseTypeEnum.fromType(qhse.getType()).getName(),
                              ObjectUtils.isEmpty(workshop) ? "无车间" : workshop.getName(),
                              qhse.getTeamId(),
                              qhse.getDutyId(),
                              qhse.getRemark()
                           )
                     )
                     .notificationTypeEnum(NotificationModuleTypeEnum.ABARBEITUNG.getNotificationType())
                     .userList(new ArrayList<>())
                     .build()
               );
         }
      );
   }

   public void processDelayedTasks() {
      log.info("----------------- 消息推送-质量检验:每60分钟执行一次 -----------------");
      SysPushNotificationConfig notificationConfig = this.configService
         .getOne(
            Wrappers.lambdaQuery(SysPushNotificationConfig.class)
               .eq(SysPushNotificationConfig::getNotificationTypeEnum, NotificationModuleTypeEnum.QUALITY_INSPECTION.getNotificationType())
               .eq(SysPushNotificationConfig::getNotificationModeTypeEnum, NotificationModeTypeEnum.DEFINITE_NUMBER.getType())
               .eq(SysPushNotificationConfig::getStatus, true)
         );
      if (ObjectUtils.isNotEmpty(notificationConfig)) {
         List<MesBuildingQualityInspectionDTO> definiteNumberDetails = this.teamReportService.getQualityInspectionDefiniteNumberDetails();
         Map<String, List<MesBuildingQualityInspectionDTO>> definiteNumbeMap = definiteNumberDetails.stream()
            .collect(Collectors.groupingBy(MesBuildingQualityInspectionDTO::getProcessName));
         definiteNumbeMap.forEach(
            (processName, valuex) -> {
               if (valuex.size() >= notificationConfig.getNumber()) {
                  String inspectUserName = valuex.stream()
                     .map(MesBuildingQualityInspectionDTO::getInspectUserName)
                     .map(Object::toString)
                     .distinct()
                     .collect(Collectors.joining(", "));
                  StringBuffer content = this.detailsUtils.getQualityInspectionDefiniteNumberDetails(processName, inspectUserName, valuex.size());
                  log.info("质检定数-消息推送内容为：{}", content);
                  this.sysPushFlowConfigBiz
                     .triggerFlow(
                        NotificationServiceTriggerDTO.builder()
                           .notificationTypeEnum(NotificationModuleTypeEnum.QUALITY_INSPECTION.getNotificationType())
                           .userList(new ArrayList<>())
                           .contentDetails(content)
                           .build()
                     );
               }
            }
         );
      }

      Set<String> tasks = this.redisTemplate.opsForZSet().rangeByScore("message_notification_quality_inspection", 0.0, System.currentTimeMillis());
      if (tasks != null && !tasks.isEmpty()) {
         log.info("过期任务: {}", tasks);

         for (String task : tasks) {
            log.info("开始执行任务: {}", task);
            this.redisTemplate.opsForZSet().remove("message_notification_quality_inspection", task);
            List<String> value = Arrays.asList(task.split("\\+"));
            List<Long> teamReportIds = Arrays.asList(value.get(0).split(",")).stream().map(Long::parseLong).collect(Collectors.toList());
            List<MesBuildingQualityInspectionDTO> qualityInspectionDetails = this.teamReportService.getQualityInspectionDetails(teamReportIds);
            log.info("质检需要通知的消息内容: {}", qualityInspectionDetails.toString());
            if (CollectionUtils.isNotEmpty(qualityInspectionDetails)) {
               Map<String, List<MesBuildingQualityInspectionDTO>> serialCodeMap = qualityInspectionDetails.stream()
                  .collect(Collectors.groupingBy(MesBuildingQualityInspectionDTO::getSerialCode));
               serialCodeMap.forEach(
                  (serialCode, details) -> {
                     Map<String, List<MesBuildingQualityInspectionDTO>> processNameMap = details.stream()
                        .collect(Collectors.groupingBy(MesBuildingQualityInspectionDTO::getProcessName));
                     processNameMap.forEach(
                        (processName, processDetails) -> {
                           Map<String, List<MesBuildingQualityInspectionDTO>> serialNumberMap = processDetails.stream()
                              .collect(Collectors.groupingBy(MesBuildingQualityInspectionDTO::getSerialNumber));
                           serialNumberMap.forEach(
                              (serialNumber, serialNumberDetails) -> {
                                 String inspectUserName = serialNumberDetails.stream()
                                    .map(MesBuildingQualityInspectionDTO::getInspectUserName)
                                    .map(Object::toString)
                                    .distinct()
                                    .collect(Collectors.joining(", "));
                                 StringBuffer content = this.detailsUtils
                                    .getQualityInspectionTimingDetails(
                                       serialCode,
                                       ((MesBuildingQualityInspectionDTO)details.get(0)).getShortName(),
                                       processName,
                                       value.get(1),
                                       inspectUserName,
                                       serialNumber
                                    );
                                 log.info("redis最后一步，开始消息推送内容为：{}", content);
                                 this.sysPushFlowConfigBiz
                                    .triggerFlow(
                                       NotificationServiceTriggerDTO.builder()
                                          .notificationTypeEnum(NotificationModuleTypeEnum.QUALITY_INSPECTION.getNotificationType())
                                          .userList(new ArrayList<>())
                                          .contentDetails(content)
                                          .build()
                                    );
                              }
                           );
                        }
                     );
                  }
               );
            }
         }
      }
   }

   public MessagePushSchedule(
      final SysPushFlowConfigBiz sysPushFlowConfigBiz,
      final NotificationTemplateDetailsUtils detailsUtils,
      final InboundDetailService inboundDetailService,
      final MoveOutboundDetailService outboundDetailService,
      final MaterialInventoryService inventoryService,
      final MesBuildingTaskOrderService taskOrderService,
      final MesBuildingTaskProcessService taskProcessService,
      final MesBuildingCompleteService completeService,
      final MesBuildingCargoListService cargoListService,
      final RedisTemplate redisTemplate,
      final MesBuildingProduceTeamReportService teamReportService,
      final SysPushNotificationConfigService configService,
      final MesBuildingQhseService mesBuildingQhseService,
      final WorkshopService workshopService
   ) {
      this.sysPushFlowConfigBiz = sysPushFlowConfigBiz;
      this.detailsUtils = detailsUtils;
      this.inboundDetailService = inboundDetailService;
      this.outboundDetailService = outboundDetailService;
      this.inventoryService = inventoryService;
      this.taskOrderService = taskOrderService;
      this.taskProcessService = taskProcessService;
      this.completeService = completeService;
      this.cargoListService = cargoListService;
      this.redisTemplate = redisTemplate;
      this.teamReportService = teamReportService;
      this.configService = configService;
      this.mesBuildingQhseService = mesBuildingQhseService;
      this.workshopService = workshopService;
   }
}
