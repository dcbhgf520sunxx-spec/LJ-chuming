package com.hzchum.scim.system.core.biz.impl.notification;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.config.WebSocketServer;
import com.hzchum.scim.common.core.api.utils.JiGuangPushUtils;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationConfigBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationRecordBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationSuitableObjectLinkBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationUserLinkBiz;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModeTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.SuitableObjectTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.notification.MessagePushUtil;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationConfig;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationRecord;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationSuitableObjectLink;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationConfigDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.notification.PushNotificationConfigDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.PushNotificationConfigSimpleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SuitableObjectCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushNotificationRecordDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushSocketUserIdDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushSocketUserLinkDTO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationConfigMapper;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationConfigBizImpl
   extends IBizImpl<SysPushNotificationConfigService, SysPushNotificationConfigMapper, SysPushNotificationConfig>
   implements SysPushNotificationConfigBiz {
   private static final Logger log = LoggerFactory.getLogger(SysPushNotificationConfigBizImpl.class);
   @Resource
   private UserService sysUserBiz;
   @Resource
   private JobService sysJobBiz;
   @Resource
   private DepartmentService sysDepartmentBiz;
   @Resource
   private SysPushNotificationSuitableObjectLinkBiz sysPushNotificationSuitableObjectLinkBiz;
   @Resource
   private SysPushNotificationRecordBiz sysPushNotificationRecordBiz;
   @Resource
   private SysPushNotificationUserLinkBiz sysPushNotificationUserLinkBiz;
   @Resource
   private MessagePushUtil messagePushUtil;

   @Override
   public Boolean editNotification(List<NotificationConfigDTOParam> params, Integer notificationType, Integer operationalModuleType) {
      params.forEach(
         param -> {
            Boolean result = NotificationModeTypeEnum.TIMING.getType() == param.getNotificationModeTypeEnum()
               && (param.getDuration() == null || param.getDuration() == 0);
            Boolean result1 = NotificationModeTypeEnum.DEFINITE_NUMBER.getType() == param.getNotificationModeTypeEnum()
               && (param.getNumber() == null || param.getNumber() <= 0);
            Preconditions.checkArgument(!result, "通知方式为定时时，时长不能为空且大于0！");
            Preconditions.checkArgument(!result1, "通知方式为定数时，数量不能为空且大于0！");
         }
      );
      if (CollectionUtils.isEmpty(params)) {
         List<SysPushNotificationConfig> sysPushNotificationConfigs = this.baseService
            .list(
               Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                  .eq(SysPushNotificationConfig::getNotificationTypeEnum, notificationType)
                  .eq(SysPushNotificationConfig::getOperationalModuleTypeEnum, operationalModuleType)
            );
         if (CollectionUtils.isNotEmpty(sysPushNotificationConfigs)) {
            this.sysPushNotificationSuitableObjectLinkBiz
               .remove(
                  Wrappers.lambdaQuery(SysPushNotificationSuitableObjectLink.class)
                     .in(
                        SysPushNotificationSuitableObjectLink::getSysPushNotificationConfigId,
                        sysPushNotificationConfigs.stream().map(SysPushNotificationConfig::getId).collect(Collectors.toList())
                     )
               );
            this.baseService
               .remove(
                  Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                     .in(
                        SysPushNotificationConfig::getId,
                        sysPushNotificationConfigs.stream().map(SysPushNotificationConfig::getId).collect(Collectors.toList())
                     )
               );
         }

         return Boolean.TRUE;
      } else {
         List<SysPushNotificationConfig> sysPushNotificationConfigs = this.baseService
            .list(
               Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                  .eq(SysPushNotificationConfig::getNotificationTypeEnum, notificationType)
                  .eq(SysPushNotificationConfig::getOperationalModuleTypeEnum, operationalModuleType)
            );
         if (CollectionUtils.isNotEmpty(sysPushNotificationConfigs)) {
            this.sysPushNotificationSuitableObjectLinkBiz
               .remove(
                  Wrappers.lambdaQuery(SysPushNotificationSuitableObjectLink.class)
                     .in(
                        SysPushNotificationSuitableObjectLink::getSysPushNotificationConfigId,
                        sysPushNotificationConfigs.stream().map(SysPushNotificationConfig::getId).collect(Collectors.toList())
                     )
               );
            this.baseService
               .remove(
                  Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                     .in(
                        SysPushNotificationConfig::getId,
                        sysPushNotificationConfigs.stream().map(SysPushNotificationConfig::getId).collect(Collectors.toList())
                     )
               );
         }

         params.forEach(
            param -> {
               SysPushNotificationConfig sysPushNotificationConfig = SysPushNotificationConfig.builder()
                  .suitableObjectTypeEnum(param.getSuitableObjectTypeEnum())
                  .notificationModeTypeEnum(param.getNotificationModeTypeEnum())
                  .duration(param.getDuration())
                  .number(param.getNumber())
                  .timeTypeEnum(param.getTimeTypeEnum())
                  .notificationTypeEnum(notificationType)
                  .operationalModuleTypeEnum(operationalModuleType)
                  .status(Boolean.TRUE)
                  .build();
               this.baseService.save(sysPushNotificationConfig);
               if (!param.getSuitableObjectTypeEnum().equals(SuitableObjectTypeEnum.SYS_DEFAULT.getType())) {
                  param.getSuitableObjectIdList()
                     .stream()
                     .map(
                        id -> SysPushNotificationSuitableObjectLink.builder()
                           .suitableObjectId(id)
                           .sysPushNotificationConfigId(sysPushNotificationConfig.getId())
                           .build()
                     )
                     .collect(Collectors.toList())
                     .forEach(item -> this.sysPushNotificationSuitableObjectLinkBiz.save(item));
               }
            }
         );
         return Boolean.TRUE;
      }
   }

   @Override
   public Boolean editStatus(Long id) {
      SysPushNotificationConfig notificationConfig = this.baseService.getById(id);
      Preconditions.checkArgument(notificationConfig != null, "配置不存在");
      notificationConfig.setStatus(!notificationConfig.getStatus());
      this.baseService.updateById(notificationConfig);
      return Boolean.TRUE;
   }

   @Override
   public List<SuitableObjectCommonDTO> getSuitableObject(Integer suitableObjectTypeEnum) {
      if (suitableObjectTypeEnum.equals(SuitableObjectTypeEnum.PERSONAGE.getType())) {
         return this.sysUserBiz
            .list()
            .stream()
            .map(user -> SuitableObjectCommonDTO.builder().id(user.getId()).phoneNumber(user.getPhone()).name(user.getName()).build())
            .collect(Collectors.toList());
      } else if (suitableObjectTypeEnum.equals(SuitableObjectTypeEnum.JOB.getType())) {
         return this.sysJobBiz
            .list()
            .stream()
            .map(job -> SuitableObjectCommonDTO.builder().id(job.getId()).name(job.getName()).build())
            .collect(Collectors.toList());
      } else {
         return suitableObjectTypeEnum.equals(SuitableObjectTypeEnum.DEPT.getType())
            ? this.sysDepartmentBiz
               .list()
               .stream()
               .map(dept -> SuitableObjectCommonDTO.builder().id(dept.getId()).name(dept.getName()).build())
               .collect(Collectors.toList())
            : new ArrayList<>();
      }
   }

   @Override
   public List<PushNotificationConfigSimpleDTO> getList(
      Integer operationalModuleTypeEnum, Boolean isDisposition, Boolean status, Integer notificationModeTypeEnum
   ) {
      List<NotificationModuleTypeEnum> notificationModuleTypeEnumList = Arrays.asList(NotificationModuleTypeEnum.values())
         .stream()
         .filter(item -> !item.getNotificationType().equals(NotificationModuleTypeEnum.SHR_UPDATE_PUSH.getNotificationType()))
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(notificationModuleTypeEnumList), "数据异常请联系管理人员");
      if (operationalModuleTypeEnum != null) {
         notificationModuleTypeEnumList = notificationModuleTypeEnumList.stream()
            .filter(item -> item.getOperationalModuleType().equals(operationalModuleTypeEnum))
            .collect(Collectors.toList());
      }

      List<PushNotificationConfigSimpleDTO> pushNotificationConfigSimpleDTOS = notificationModuleTypeEnumList.stream()
         .map(
            item -> {
               PushNotificationConfigSimpleDTO pushNotificationConfigSimpleDTO = new PushNotificationConfigSimpleDTO();
               pushNotificationConfigSimpleDTO.setOperationalModuleType(item.getOperationalModuleType());
               pushNotificationConfigSimpleDTO.setOperationalModuleTypeName(item.getOperationalModuleTypeName());
               pushNotificationConfigSimpleDTO.setNotificationType(item.getNotificationType());
               pushNotificationConfigSimpleDTO.setNotificationTypeName(item.getNotificationTypeName());
               List<SysPushNotificationConfig> sysPushNotificationConfigs = this.baseService
                  .list(
                     Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                        .eq(SysPushNotificationConfig::getOperationalModuleTypeEnum, item.getOperationalModuleType())
                        .eq(SysPushNotificationConfig::getNotificationTypeEnum, item.getNotificationType())
                        .eq(status != null, SysPushNotificationConfig::getStatus, status)
                        .eq(notificationModeTypeEnum != null, SysPushNotificationConfig::getNotificationModeTypeEnum, notificationModeTypeEnum)
                  );
               if (CollectionUtils.isNotEmpty(sysPushNotificationConfigs)) {
                  List<PushNotificationConfigDetailDTO> pushNotificationConfigDetailDTOS = sysPushNotificationConfigs.stream()
                     .map(
                        config -> {
                           PushNotificationConfigDetailDTO pushNotificationConfigDetailDTO = new PushNotificationConfigDetailDTO();
                           pushNotificationConfigDetailDTO.setId(config.getId());
                           pushNotificationConfigDetailDTO.setStatus(config.getStatus());
                           pushNotificationConfigDetailDTO.setNotificationModeTypeEnum(config.getNotificationModeTypeEnum());
                           pushNotificationConfigDetailDTO.setSuitableObjectTypeEnum(config.getSuitableObjectTypeEnum());
                           pushNotificationConfigDetailDTO.setDuration(config.getDuration());
                           pushNotificationConfigDetailDTO.setNumber(config.getNumber());
                           pushNotificationConfigDetailDTO.setTimeTypeEnum(config.getTimeTypeEnum());
                           List<SysPushNotificationSuitableObjectLink> sysPushNotificationSuitableObjectLinks = this.sysPushNotificationSuitableObjectLinkBiz
                              .list(
                                 Wrappers.lambdaQuery(SysPushNotificationSuitableObjectLink.class)
                                    .eq(SysPushNotificationSuitableObjectLink::getSysPushNotificationConfigId, config.getId())
                              );
                           if (CollectionUtils.isNotEmpty(sysPushNotificationSuitableObjectLinks)) {
                              if (config.getSuitableObjectTypeEnum().equals(SuitableObjectTypeEnum.PERSONAGE.getType())) {
                                 Map<Long, String> userMap = this.sysUserBiz
                                    .list(
                                       Wrappers.lambdaQuery(User.class)
                                          .in(
                                             User::getId,
                                             sysPushNotificationSuitableObjectLinks.stream()
                                                .map(SysPushNotificationSuitableObjectLink::getSuitableObjectId)
                                                .collect(Collectors.toList())
                                          )
                                    )
                                    .stream()
                                    .collect(Collectors.toMap(User::getId, User::getName));
                                 pushNotificationConfigDetailDTO.setSuitableObjectCommonDTOList(
                                    sysPushNotificationSuitableObjectLinks.stream()
                                       .map(
                                          link -> SuitableObjectCommonDTO.builder()
                                             .id(link.getSuitableObjectId())
                                             .name(userMap.get(link.getSuitableObjectId()))
                                             .build()
                                       )
                                       .collect(Collectors.toList())
                                 );
                              }

                              if (config.getSuitableObjectTypeEnum().equals(SuitableObjectTypeEnum.JOB.getType())) {
                                 Map<Long, String> jobMap = this.sysJobBiz
                                    .list(
                                       Wrappers.lambdaQuery(Job.class)
                                          .in(
                                             Job::getId,
                                             sysPushNotificationSuitableObjectLinks.stream()
                                                .map(SysPushNotificationSuitableObjectLink::getSuitableObjectId)
                                                .collect(Collectors.toList())
                                          )
                                    )
                                    .stream()
                                    .collect(Collectors.toMap(Job::getId, Job::getName));
                                 pushNotificationConfigDetailDTO.setSuitableObjectCommonDTOList(
                                    sysPushNotificationSuitableObjectLinks.stream()
                                       .map(
                                          link -> SuitableObjectCommonDTO.builder()
                                             .id(link.getSuitableObjectId())
                                             .name(jobMap.get(link.getSuitableObjectId()))
                                             .build()
                                       )
                                       .collect(Collectors.toList())
                                 );
                              }

                              if (config.getSuitableObjectTypeEnum().equals(SuitableObjectTypeEnum.DEPT.getType())) {
                                 Map<Long, String> deptMap = this.sysDepartmentBiz
                                    .list(
                                       Wrappers.lambdaQuery(Department.class)
                                          .in(
                                             Department::getId,
                                             sysPushNotificationSuitableObjectLinks.stream()
                                                .map(SysPushNotificationSuitableObjectLink::getSuitableObjectId)
                                                .collect(Collectors.toList())
                                          )
                                    )
                                    .stream()
                                    .collect(Collectors.toMap(Department::getId, Department::getName));
                                 pushNotificationConfigDetailDTO.setSuitableObjectCommonDTOList(
                                    sysPushNotificationSuitableObjectLinks.stream()
                                       .map(
                                          link -> SuitableObjectCommonDTO.builder()
                                             .id(link.getSuitableObjectId())
                                             .name(deptMap.get(link.getSuitableObjectId()))
                                             .build()
                                       )
                                       .collect(Collectors.toList())
                                 );
                              }
                           }

                           return pushNotificationConfigDetailDTO;
                        }
                     )
                     .collect(Collectors.toList());
                  pushNotificationConfigSimpleDTO.setPushNotificationConfigDetailDTOList(pushNotificationConfigDetailDTOS);
               }

               return pushNotificationConfigSimpleDTO;
            }
         )
         .collect(Collectors.toList());
      if (isDisposition != null) {
         if (isDisposition) {
            pushNotificationConfigSimpleDTOS = pushNotificationConfigSimpleDTOS.stream()
               .filter(item -> CollectionUtils.isNotEmpty(item.getPushNotificationConfigDetailDTOList()))
               .collect(Collectors.toList());
         } else {
            pushNotificationConfigSimpleDTOS = pushNotificationConfigSimpleDTOS.stream()
               .filter(item -> CollectionUtils.isEmpty(item.getPushNotificationConfigDetailDTOList()))
               .collect(Collectors.toList());
         }
      }

      return pushNotificationConfigSimpleDTOS;
   }

   @Override
   public void businessCompletion(SysPushNotificationRecordDTOParam sysPushNotificationRecordDTOParam, List<Long> userList) {
      List<SysPushNotificationConfig> pushNotificationConfigList = this.baseService
         .list(
            Wrappers.lambdaQuery(SysPushNotificationConfig.class)
               .eq(SysPushNotificationConfig::getNotificationTypeEnum, sysPushNotificationRecordDTOParam.getNotificationTypeEnum())
               .eq(SysPushNotificationConfig::getOperationalModuleTypeEnum, sysPushNotificationRecordDTOParam.getOperationalModuleTypeEnum())
         );
      if (CollectionUtils.isNotEmpty(pushNotificationConfigList)) {
         SysPushNotificationRecord sysPushNotificationRecord = BeanUtil.copy(sysPushNotificationRecordDTOParam, SysPushNotificationRecord.class);
         this.sysPushNotificationRecordBiz.save(sysPushNotificationRecord);
         log.info("主表记录生成成功，记录数据为：{}", sysPushNotificationRecord.toString());
         pushNotificationConfigList.forEach(
            pushNotificationConfig -> {
               String serialNumber = this.generateSerialNumber(pushNotificationConfig);
               if (pushNotificationConfig.getSuitableObjectTypeEnum().equals(SuitableObjectTypeEnum.SYS_DEFAULT.getType())) {
                  this.generateUserLinks(sysPushNotificationRecordDTOParam, pushNotificationConfig, serialNumber, userList, sysPushNotificationRecord.getId());
               }

               if (pushNotificationConfig.getSuitableObjectTypeEnum().equals(SuitableObjectTypeEnum.PERSONAGE.getType())) {
                  List<SysPushNotificationSuitableObjectLink> userLinks = this.sysPushNotificationSuitableObjectLinkBiz
                     .list(
                        Wrappers.lambdaQuery(SysPushNotificationSuitableObjectLink.class)
                           .eq(SysPushNotificationSuitableObjectLink::getSysPushNotificationConfigId, pushNotificationConfig.getId())
                     );
                  if (CollectionUtils.isNotEmpty(userLinks)) {
                     List<User> sysUsers = this.sysUserBiz
                        .list(
                           Wrappers.lambdaQuery(User.class)
                              .in(User::getId, userLinks.stream().map(SysPushNotificationSuitableObjectLink::getSuitableObjectId).collect(Collectors.toList()))
                        );
                     if (CollectionUtils.isNotEmpty(sysUsers)) {
                        this.generateUserLinks(
                           sysPushNotificationRecordDTOParam,
                           pushNotificationConfig,
                           serialNumber,
                           sysUsers.stream().map(User::getId).collect(Collectors.toList()),
                           sysPushNotificationRecord.getId()
                        );
                     }
                  }
               }

               if (pushNotificationConfig.getSuitableObjectTypeEnum().equals(SuitableObjectTypeEnum.JOB.getType())) {
                  List<SysPushNotificationSuitableObjectLink> userLinks = this.sysPushNotificationSuitableObjectLinkBiz
                     .list(
                        Wrappers.lambdaQuery(SysPushNotificationSuitableObjectLink.class)
                           .eq(SysPushNotificationSuitableObjectLink::getSysPushNotificationConfigId, pushNotificationConfig.getId())
                     );
                  if (CollectionUtils.isNotEmpty(userLinks)) {
                     List<User> sysUsers = this.sysUserBiz
                        .list(
                           Wrappers.lambdaQuery(User.class)
                              .in(
                                 User::getJobId,
                                 userLinks.stream().map(SysPushNotificationSuitableObjectLink::getSuitableObjectId).collect(Collectors.toList())
                              )
                        );
                     if (CollectionUtils.isNotEmpty(sysUsers)) {
                        this.generateUserLinks(
                           sysPushNotificationRecordDTOParam,
                           pushNotificationConfig,
                           serialNumber,
                           sysUsers.stream().map(User::getId).collect(Collectors.toList()),
                           sysPushNotificationRecord.getId()
                        );
                     }
                  }
               }

               if (pushNotificationConfig.getSuitableObjectTypeEnum().equals(SuitableObjectTypeEnum.DEPT.getType())) {
                  List<SysPushNotificationSuitableObjectLink> userLinks = this.sysPushNotificationSuitableObjectLinkBiz
                     .list(
                        Wrappers.lambdaQuery(SysPushNotificationSuitableObjectLink.class)
                           .eq(SysPushNotificationSuitableObjectLink::getSysPushNotificationConfigId, pushNotificationConfig.getId())
                     );
                  if (CollectionUtils.isNotEmpty(userLinks)) {
                     List<User> sysUsers = this.sysUserBiz
                        .list(
                           Wrappers.lambdaQuery(User.class)
                              .in(
                                 User::getDepartmentId,
                                 userLinks.stream().map(SysPushNotificationSuitableObjectLink::getSuitableObjectId).collect(Collectors.toList())
                              )
                        );
                     if (CollectionUtils.isNotEmpty(sysUsers)) {
                        this.generateUserLinks(
                           sysPushNotificationRecordDTOParam,
                           pushNotificationConfig,
                           serialNumber,
                           sysUsers.stream().map(User::getId).collect(Collectors.toList()),
                           sysPushNotificationRecord.getId()
                        );
                     }
                  }
               }
            }
         );
      }
   }

   private void generateUserLinks(
      SysPushNotificationRecordDTOParam sysPushNotificationRecordDTOParam,
      SysPushNotificationConfig pushNotificationConfig,
      String generateSerialNumber,
      List<Long> userList,
      Long recordId
   ) {
      HashSet<String> stringSet = new HashSet<>();
      SysPushSocketUserLinkDTO userLinkDTO = new SysPushSocketUserLinkDTO();
      List<SysPushSocketUserIdDTO> userIdDTOList = new ArrayList<>();
      String content = sysPushNotificationRecordDTOParam.getContentDetails().toString();
      log.info("数据详情已生成，记录数据为：{}", content);
      userList.forEach(
         item -> {
            stringSet.add(String.valueOf(item));
            SysPushNotificationUserLink build = SysPushNotificationUserLink.builder()
               .userId(item)
               .sysPushNotificationRecordId(recordId)
               .serialNumber(generateSerialNumber)
               .pushTime(sysPushNotificationRecordDTOParam.getPushDateTime())
               .dataId(sysPushNotificationRecordDTOParam.getDataId())
               .createUserId(sysPushNotificationRecordDTOParam.getCreateUserId())
               .contentDetails(content)
               .build();
            this.sysPushNotificationUserLinkBiz.save(build);
            userIdDTOList.add(SysPushSocketUserIdDTO.builder().userId(item).id(build.getId()).build());
         }
      );
      this.messagePushUtil
         .sendDingTalkMessage(content, sysPushNotificationRecordDTOParam.getNotificationTypeEnum(), sysPushNotificationRecordDTOParam.getUserPhoneList());
      userLinkDTO.setContentDetails(content);
      NotificationModuleTypeEnum typeEnum = NotificationModuleTypeEnum.getEnumByNotificationTypeAndOperationalModuleType(
         sysPushNotificationRecordDTOParam.getNotificationTypeEnum(), sysPushNotificationRecordDTOParam.getOperationalModuleTypeEnum()
      );
      userLinkDTO.setNotificationTypeEnumName(typeEnum.getNotificationTypeName());
      userLinkDTO.setOperationalModuleTypeEnum(typeEnum.getOperationalModuleType());
      userLinkDTO.setOperationalModuleTypeEnumName(typeEnum.getOperationalModuleTypeName());
      userLinkDTO.setUserIdDTOList(userIdDTOList);
      List<User> list = this.sysUserBiz.list(Wrappers.lambdaQuery(User.class).in(User::getId, userList));
      list.forEach(item -> {
         if (StringUtils.isNotBlank(item.getRegistrationId())) {
            JiGuangPushUtils.pushMessage(content, Arrays.stream(item.getRegistrationId().split(",")).map(String::valueOf).collect(Collectors.toList()));
         }
      });

      try {
         WebSocketServer.sendMessage(JSONObject.toJSONString(userLinkDTO), stringSet);
      } catch (IOException e) {
         log.info("推送失败，原因为：{}", e.getMessage());
         e.printStackTrace();
      }
   }

   private String generateSerialNumber(SysPushNotificationConfig sysPushNotificationRecord) {
      String abbreviation = this.getAbbreviation(LocalDateTime.now().getMonth().getValue());
      List<SysPushNotificationRecord> sysPushNotificationRecords = this.sysPushNotificationRecordBiz
         .list(Wrappers.lambdaQuery(SysPushNotificationRecord.class).apply("DATE_FORMAT(create_time, '%Y-%m-%d') = {0}", LocalDate.now()));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(abbreviation);
      stringBuilder.append(LocalDateTime.now().getDayOfMonth());
      stringBuilder.append("-");
      stringBuilder.append(CollectionUtils.isNotEmpty(sysPushNotificationRecords) ? sysPushNotificationRecords.size() + 1 : 1);
      return stringBuilder.toString();
   }

   public String getAbbreviation(int month) {
      String abbreviation;
      switch (month) {
         case 1:
            abbreviation = "Jan";
            break;
         case 2:
            abbreviation = "Feb";
            break;
         case 3:
            abbreviation = "Mar";
            break;
         case 4:
            abbreviation = "Apr";
            break;
         case 5:
            abbreviation = "May";
            break;
         case 6:
            abbreviation = "Jun";
            break;
         case 7:
            abbreviation = "Jul";
            break;
         case 8:
            abbreviation = "Aug";
            break;
         case 9:
            abbreviation = "Sep";
            break;
         case 10:
            abbreviation = "Oct";
            break;
         case 11:
            abbreviation = "Nov";
            break;
         case 12:
            abbreviation = "Dec";
            break;
         default:
            abbreviation = "Invalid Month";
      }

      return abbreviation;
   }
}
