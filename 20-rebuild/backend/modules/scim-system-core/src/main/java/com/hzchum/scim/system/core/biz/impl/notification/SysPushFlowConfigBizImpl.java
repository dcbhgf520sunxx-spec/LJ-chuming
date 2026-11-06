package com.hzchum.scim.system.core.biz.impl.notification;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowLinkConfigBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushFlowConfig;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushFlowLinkConfig;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushFlowConfigDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushFlowConfigDetailSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushFlowConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushFlowConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushFlowConfigSimpleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushNotificationRecordDTOParam;
import com.hzchum.scim.system.core.api.service.notification.SysPushFlowConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushFlowConfigMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysPushFlowConfigBizImpl extends IBizImpl<SysPushFlowConfigService, SysPushFlowConfigMapper, SysPushFlowConfig> implements SysPushFlowConfigBiz {
   private static final Logger log = LoggerFactory.getLogger(SysPushFlowConfigBizImpl.class);
   @Autowired
   private SysPushFlowLinkConfigBiz sysPushFlowLinkConfigBiz;
   @Autowired
   private SysPushNotificationConfigBiz sysPushNotificationConfigBiz;

   @Override
   public List<SysPushFlowConfigSimpleDTO> getPushFlowSimpleList(Boolean status, Integer notificationTypeEnum, String name) {
      List<Long> flowIds = new ArrayList<>();
      if (notificationTypeEnum != null) {
         List<SysPushFlowLinkConfig> sysPushFlowLinkConfigs = this.sysPushFlowLinkConfigBiz
            .list(Wrappers.lambdaQuery(SysPushFlowLinkConfig.class).eq(SysPushFlowLinkConfig::getNotificationTypeEnum, notificationTypeEnum));
         flowIds.addAll(sysPushFlowLinkConfigs.stream().map(SysPushFlowLinkConfig::getSysPushFlowConfigId).collect(Collectors.toList()));
         if (CollectionUtil.isEmpty(sysPushFlowLinkConfigs)) {
            return new ArrayList<>();
         }
      }

      List<SysPushFlowConfig> sysPushFlowConfigs = this.baseService
         .list(
            Wrappers.lambdaQuery(SysPushFlowConfig.class)
               .eq(status != null, SysPushFlowConfig::getStatus, status)
               .in(CollectionUtils.isNotEmpty(flowIds), SysPushFlowConfig::getId, flowIds)
               .like(StringUtils.isNotBlank(name), SysPushFlowConfig::getName, name)
         );
      if (CollectionUtils.isEmpty(sysPushFlowConfigs)) {
         return new ArrayList<>();
      }

      Map<Integer, NotificationModuleTypeEnum> moduleTypeEnumMap = Arrays.stream(NotificationModuleTypeEnum.values())
         .collect(Collectors.toMap(NotificationModuleTypeEnum::getNotificationType, Function.identity()));
      return sysPushFlowConfigs.stream()
         .map(
            item -> {
               SysPushFlowConfigSimpleDTO sysPushFlowConfigSimpleDTO = BeanUtil.copy(item, SysPushFlowConfigSimpleDTO.class);
               List<SysPushFlowLinkConfig> sysPushFlowLinkConfigs = this.sysPushFlowLinkConfigBiz
                  .list(Wrappers.lambdaQuery(SysPushFlowLinkConfig.class).eq(SysPushFlowLinkConfig::getSysPushFlowConfigId, item.getId()));
               if (CollectionUtil.isNotEmpty(sysPushFlowLinkConfigs)) {
                  sysPushFlowConfigSimpleDTO.setRelatedProcessList(sysPushFlowLinkConfigs.stream().map(config -> {
                     NotificationModuleTypeEnum notificationModuleTypeEnum = moduleTypeEnumMap.get(config.getNotificationTypeEnum());
                     return notificationModuleTypeEnum.getNotificationTypeName();
                  }).collect(Collectors.toList()));
               }

               return sysPushFlowConfigSimpleDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Transactional
   @Override
   public Boolean editFlow(SysPushFlowConfigDetailSaveDTOParam sysPushFlowConfigDetailSaveDTOParam) {
      if (sysPushFlowConfigDetailSaveDTOParam.getId() != null) {
         this.deleteFlow(sysPushFlowConfigDetailSaveDTOParam.getId());
      }

      SysPushFlowConfig sysPushFlowConfig = SysPushFlowConfig.builder()
         .name(sysPushFlowConfigDetailSaveDTOParam.getName())
         .status(Boolean.TRUE)
         .finalEditor(UserUtil.getCurrentName())
         .finalEditTime(LocalDateTime.now())
         .build();
      this.baseService.save(sysPushFlowConfig);
      SysPushFlowLinkConfig linkConfig = SysPushFlowLinkConfig.builder()
         .sysPushFlowConfigId(sysPushFlowConfig.getId())
         .notificationTypeEnum(sysPushFlowConfigDetailSaveDTOParam.getSysPushFlowConfigLinkSaveDTOParam().getNotificationType())
         .build();
      this.sysPushFlowLinkConfigBiz.save(linkConfig);
      if (CollectionUtils.isNotEmpty(sysPushFlowConfigDetailSaveDTOParam.getSysPushFlowConfigLinkSaveDTOParam().getChildren())) {
         sysPushFlowConfigDetailSaveDTOParam.getSysPushFlowConfigLinkSaveDTOParam()
            .getChildren()
            .forEach(item -> this.SaveConfigLinkDTOParam(item, linkConfig.getId(), sysPushFlowConfig.getId()));
      }

      return Boolean.TRUE;
   }

   @Override
   public SysPushFlowConfigDetailDTO getPushFlowDetail(Long id) {
      SysPushFlowConfig flowConfig = this.baseService.getById(id);
      Preconditions.checkArgument(flowConfig != null, "流程不存在");
      SysPushFlowConfigDetailDTO sysPushFlowConfigDetailDTO = BeanUtil.copy(flowConfig, SysPushFlowConfigDetailDTO.class);
      SysPushFlowLinkConfig linkConfig = this.sysPushFlowLinkConfigBiz
         .getOne(Wrappers.lambdaQuery(SysPushFlowLinkConfig.class).eq(SysPushFlowLinkConfig::getSysPushFlowConfigId, id).isNull(SysPushFlowLinkConfig::getPId));
      if (linkConfig != null) {
         Map<Integer, NotificationModuleTypeEnum> moduleTypeEnumMap = Arrays.stream(NotificationModuleTypeEnum.values())
            .collect(Collectors.toMap(NotificationModuleTypeEnum::getNotificationType, Function.identity()));
         SysPushFlowConfigLinkDTO linkDTO = BeanUtil.copy(linkConfig, SysPushFlowConfigLinkDTO.class);
         NotificationModuleTypeEnum notificationModuleTypeEnum = moduleTypeEnumMap.get(linkConfig.getNotificationTypeEnum());
         linkDTO.setNotificationTypeName(notificationModuleTypeEnum.getNotificationTypeName());
         linkDTO.setNotificationType(linkConfig.getNotificationTypeEnum());
         List<SysPushNotificationConfig> arrivalConfigs = this.sysPushNotificationConfigBiz
            .list(
               Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                  .eq(SysPushNotificationConfig::getNotificationTypeEnum, linkConfig.getNotificationTypeEnum())
            );
         linkDTO.setArrivalConfiguration(CollectionUtils.isNotEmpty(arrivalConfigs));
         List<SysPushNotificationConfig> completeConfigs = this.sysPushNotificationConfigBiz
            .list(
               Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                  .eq(SysPushNotificationConfig::getNotificationTypeEnum, linkConfig.getNotificationTypeEnum())
            );
         linkDTO.setCompletionConfiguration(CollectionUtils.isNotEmpty(completeConfigs));
         List<SysPushFlowConfigLinkDTO> flowConfigLinkDTOS = this.sysPushFlowLinkConfigBiz
            .list(Wrappers.lambdaQuery(SysPushFlowLinkConfig.class).eq(SysPushFlowLinkConfig::getSysPushFlowConfigId, id))
            .stream()
            .map(
               item -> {
                  NotificationModuleTypeEnum moduleTypeEnum = moduleTypeEnumMap.get(item.getNotificationTypeEnum());
                  SysPushFlowConfigLinkDTO sysPushFlowConfigLinkDTO = BeanUtil.copy(item, SysPushFlowConfigLinkDTO.class);
                  sysPushFlowConfigLinkDTO.setNotificationType(item.getNotificationTypeEnum());
                  sysPushFlowConfigLinkDTO.setNotificationTypeName(moduleTypeEnum.getNotificationTypeName());
                  List<SysPushNotificationConfig> itemArrivalConfigs = this.sysPushNotificationConfigBiz
                     .list(
                        Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                           .eq(SysPushNotificationConfig::getNotificationTypeEnum, item.getNotificationTypeEnum())
                     );
                  sysPushFlowConfigLinkDTO.setArrivalConfiguration(CollectionUtils.isNotEmpty(itemArrivalConfigs));
                  List<SysPushNotificationConfig> itemCompleteConfigs = this.sysPushNotificationConfigBiz
                     .list(
                        Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                           .eq(SysPushNotificationConfig::getNotificationTypeEnum, item.getNotificationTypeEnum())
                     );
                  sysPushFlowConfigLinkDTO.setCompletionConfiguration(CollectionUtils.isNotEmpty(itemCompleteConfigs));
                  return sysPushFlowConfigLinkDTO;
               }
            )
            .collect(Collectors.toList());
         SysPushFlowConfigLinkDTO pushListChildren = this.getPushListChildren(linkDTO, flowConfigLinkDTOS);
         sysPushFlowConfigDetailDTO.setSysPushFlowConfigLinkDTOS(pushListChildren);
      }

      return sysPushFlowConfigDetailDTO;
   }

   @Transactional
   @Override
   public void triggerFlow(NotificationServiceTriggerDTO notificationServiceTriggerDTO) {
      Map<Integer, NotificationModuleTypeEnum> enumMap = Arrays.stream(NotificationModuleTypeEnum.values())
         .collect(Collectors.toMap(NotificationModuleTypeEnum::getNotificationType, Function.identity()));
      List<SysPushNotificationConfig> currentPushConfig = this.sysPushNotificationConfigBiz
         .list(
            Wrappers.lambdaQuery(SysPushNotificationConfig.class)
               .eq(SysPushNotificationConfig::getNotificationTypeEnum, notificationServiceTriggerDTO.getNotificationTypeEnum())
               .eq(SysPushNotificationConfig::getStatus, Boolean.TRUE)
         );
      if (CollectionUtils.isNotEmpty(currentPushConfig)) {
         this.sysPushNotificationConfigBiz
            .businessCompletion(
               SysPushNotificationRecordDTOParam.builder()
                  .operationalModuleTypeEnum(enumMap.get(notificationServiceTriggerDTO.getNotificationTypeEnum()).getOperationalModuleType())
                  .notificationTypeEnum(enumMap.get(notificationServiceTriggerDTO.getNotificationTypeEnum()).getNotificationType())
                  .boolPush(Boolean.TRUE)
                  .pushDateTime(LocalDateTime.now())
                  .projectId(notificationServiceTriggerDTO.getProjectId())
                  .monomerId(notificationServiceTriggerDTO.getMonomerId())
                  .areaId(notificationServiceTriggerDTO.getAreaId())
                  .userPhoneList(notificationServiceTriggerDTO.getUserPhoneList())
                  .dataId(notificationServiceTriggerDTO.getDataId())
                  .createUserId(notificationServiceTriggerDTO.getCreateUserId())
                  .contentDetails(notificationServiceTriggerDTO.getContentDetails())
                  .build(),
               notificationServiceTriggerDTO.getUserList()
            );
      }
   }

   @Transactional
   @Override
   public Boolean deleteFlow(Long id) {
      this.baseService.removeById(id);
      this.sysPushFlowLinkConfigBiz.remove(Wrappers.lambdaQuery(SysPushFlowLinkConfig.class).eq(SysPushFlowLinkConfig::getSysPushFlowConfigId, id));
      return Boolean.TRUE;
   }

   @Override
   public Boolean editStatus(Long id) {
      SysPushFlowConfig config = this.baseService.getById(id);
      Preconditions.checkArgument(config != null, "流程不存在");
      config.setStatus(!config.getStatus());
      this.baseService.updateById(config);
      return Boolean.TRUE;
   }

   private Boolean SaveConfigLinkDTOParam(SysPushFlowConfigLinkSaveDTOParam link, Long pid, Long flowId) {
      SysPushFlowLinkConfig flowLink = SysPushFlowLinkConfig.builder()
         .pId(pid)
         .sysPushFlowConfigId(flowId)
         .notificationTypeEnum(link.getNotificationType())
         .build();
      this.sysPushFlowLinkConfigBiz.save(flowLink);
      if (CollectionUtils.isNotEmpty(link.getChildren())) {
         link.getChildren().forEach(e -> this.SaveConfigLinkDTOParam(e, flowLink.getId(), flowId));
      }

      return true;
   }

   private SysPushFlowConfigLinkDTO getPushListChildren(SysPushFlowConfigLinkDTO parent, List<SysPushFlowConfigLinkDTO> flowConfigLinkDTOS) {
      flowConfigLinkDTOS.forEach(link -> {
         if (parent.getId().equals(link.getPId())) {
            if (CollectionUtils.isEmpty(parent.getChildren())) {
               parent.setChildren(new ArrayList<>());
            }

            SysPushFlowConfigLinkDTO child = this.getPushListChildren(link, flowConfigLinkDTOS);
            parent.getChildren().add(child);
         }
      });
      return parent;
   }
}
