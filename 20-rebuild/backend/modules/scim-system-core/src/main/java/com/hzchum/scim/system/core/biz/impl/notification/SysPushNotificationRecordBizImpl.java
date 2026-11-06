package com.hzchum.scim.system.core.biz.impl.notification;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationReadLinkBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationRecordBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationUserLinkBiz;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationReadLink;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationRecord;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.notification.DepartmentAndUserInfoDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushAppDetailsDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushNotificationDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushNotificationRecordAppListDTO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationRecordService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationRecordMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationRecordBizImpl
   extends IBizImpl<SysPushNotificationRecordService, SysPushNotificationRecordMapper, SysPushNotificationRecord>
   implements SysPushNotificationRecordBiz {
   @Resource
   private SysPushNotificationUserLinkBiz sysPushNotificationUserLinkBiz;
   @Resource
   private SysPushNotificationReadLinkBiz sysPushNotificationReadLinkBiz;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private UserService sysUserService;
   @Resource
   private DepartmentService departmentService;

   @Override
   public List<SysPushNotificationRecordAppListDTO> getAppList() {
      List<SysPushNotificationRecordAppListDTO> list = new ArrayList<>();
      Map<Integer, List<SysPushNotificationRecord>> recordsMap = this.baseService
         .list(Wrappers.lambdaQuery(SysPushNotificationRecord.class))
         .stream()
         .collect(Collectors.groupingBy(SysPushNotificationRecord::getOperationalModuleTypeEnum));
      recordsMap.forEach(
         (key, value) -> {
            NotificationModuleTypeEnum operationalModuleType = NotificationModuleTypeEnum.getOperationalModuleType(key);
            List<SysPushNotificationRecord> newValue = value.stream()
               .sorted(Comparator.<SysPushNotificationRecord, java.time.LocalDateTime>comparing(BaseEntity::getCreateTime).reversed())
               .collect(Collectors.toList());
            List<SysPushNotificationUserLink> userLink = this.sysPushNotificationUserLinkBiz
               .list(
                  Wrappers.lambdaQuery(SysPushNotificationUserLink.class)
                     .in(
                        SysPushNotificationUserLink::getSysPushNotificationRecordId,
                        newValue.stream().map(SysPushNotificationRecord::getId).collect(Collectors.toList())
                     )
                     .eq(SysPushNotificationUserLink::getUserId, UserUtil.getCurrentUserId())
               );
            if (CollectionUtils.isNotEmpty(userLink)) {
               userLink = userLink.stream().sorted(Comparator.<SysPushNotificationUserLink, java.time.LocalDateTime>comparing(BaseEntity::getCreateTime).reversed()).collect(Collectors.toList());
               List<SysPushNotificationReadLink> readLinks = this.sysPushNotificationReadLinkBiz
                  .list(
                     Wrappers.lambdaQuery(SysPushNotificationReadLink.class)
                        .eq(SysPushNotificationReadLink::getUserId, UserUtil.getCurrentUserId())
                        .in(
                           SysPushNotificationReadLink::getSysPushNotificationUserLinkId,
                           userLink.stream().map(SysPushNotificationUserLink::getId).collect(Collectors.toList())
                        )
                  );
               SysPushNotificationRecordAppListDTO listDTO = new SysPushNotificationRecordAppListDTO();
               listDTO.setOperationalModuleType(key);
               listDTO.setOperationalModuleTypeName(
                  StringUtils.isBlank(operationalModuleType.getOperationalModuleTypeName()) ? "" : operationalModuleType.getOperationalModuleTypeName()
               );
               List<String> content = userLink.stream()
                  .filter(item -> item.getSysPushNotificationRecordId().equals(newValue.get(0).getId()))
                  .map(item -> item.getContentDetails())
                  .collect(Collectors.toList());
               listDTO.setContent(CollectionUtils.isNotEmpty(content) ? content.get(0) : "");
               long count = userLink.stream()
                  .filter(
                     item -> !readLinks.stream()
                        .map(SysPushNotificationReadLink::getSysPushNotificationUserLinkId)
                        .collect(Collectors.toList())
                        .contains(item.getId())
                  )
                  .count();
               listDTO.setUnRead((int)count);
               listDTO.setTime(value.get(0).getCreateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
               list.add(listDTO);
            }
         }
      );
      return list;
   }

   @Override
   public Boolean readBatchMessage(Integer operationalModuleType, LocalDate startDate, LocalDate endDate, String content) {
      Long currentUserId = UserUtil.getCurrentUserId();
      List<SysPushAppDetailsDTO> appMessageDetails = this.baseService.getRecodeDetail(operationalModuleType, startDate, endDate, content, currentUserId);
      Map<Long, List<SysPushAppDetailsDTO>> userLinkIdMap = appMessageDetails.stream().collect(Collectors.groupingBy(SysPushAppDetailsDTO::getUserLinkId));
      List<Long> readLinks = this.sysPushNotificationReadLinkBiz
         .list(Wrappers.lambdaQuery(SysPushNotificationReadLink.class).eq(SysPushNotificationReadLink::getUserId, currentUserId))
         .stream()
         .map(item -> item.getSysPushNotificationUserLinkId())
         .collect(Collectors.toList());
      List<CompletableFuture<Void>> futures = userLinkIdMap.entrySet()
         .stream()
         .filter(entry -> !readLinks.contains(entry.getKey()))
         .map(
            entry -> CompletableFuture.runAsync(
               () -> {
                  List<SysPushAppDetailsDTO> value = (List<SysPushAppDetailsDTO>)entry.getValue();
                  this.sysPushNotificationReadLinkBiz
                     .save(
                        SysPushNotificationReadLink.builder()
                           .userId(currentUserId)
                           .sysPushNotificationRecordId(value.get(0).getRecordId())
                           .sysPushNotificationUserLinkId(value.get(0).getUserLinkId())
                           .build()
                     );
               }
            )
         )
         .collect(Collectors.toList());
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
      return true;
   }

   @Override
   public Boolean readPushMessage(Long id) {
      SysPushNotificationUserLink userLink = this.sysPushNotificationUserLinkBiz
         .getOne(Wrappers.lambdaQuery(SysPushNotificationUserLink.class).eq(SysPushNotificationUserLink::getId, id));
      if (userLink != null) {
         SysPushNotificationRecord notificationRecord = this.baseService.getById(userLink.getSysPushNotificationRecordId());
         if (notificationRecord != null) {
            List<SysPushNotificationReadLink> sysPushNotificationReadLinks = this.sysPushNotificationReadLinkBiz
               .list(
                  Wrappers.lambdaQuery(SysPushNotificationReadLink.class)
                     .eq(SysPushNotificationReadLink::getSysPushNotificationUserLinkId, userLink.getId())
                     .eq(SysPushNotificationReadLink::getUserId, UserUtil.getCurrentUserId())
               );
            if (CollectionUtils.isEmpty(sysPushNotificationReadLinks)) {
               this.sysPushNotificationReadLinkBiz
                  .save(
                     SysPushNotificationReadLink.builder()
                        .userId(UserUtil.getCurrentUserId())
                        .sysPushNotificationRecordId(notificationRecord.getId())
                        .sysPushNotificationUserLinkId(id)
                        .build()
                  );
            }
         }
      }

      return Boolean.TRUE;
   }

   @Override
   public PageVO<SysPushNotificationDetailDTO> getAppMessageDetail(
      Integer operationalModuleType, LocalDate startDate, LocalDate endDate, Boolean isRead, String content, Integer pageNumber, Integer pageSize
   ) {
      if (startDate == null || endDate == null) {
         LocalDate currentDate = LocalDate.now();
         endDate = currentDate;
         startDate = currentDate.minusDays(30L);
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<SysPushAppDetailsDTO> recodeDetail = this.baseService
         .getRecodeDetail(operationalModuleType, startDate, endDate, content, UserUtil.getCurrentUserId());
      List<SysPushNotificationDetailDTO> detailDTOS = new ArrayList<>();
      if (isRead != null && !CollectionUtils.isEmpty(recodeDetail)) {
         List<SysPushNotificationReadLink> sysPushNotificationReadLinks = this.sysPushNotificationReadLinkBiz
            .list(
               Wrappers.lambdaQuery(SysPushNotificationReadLink.class)
                  .eq(SysPushNotificationReadLink::getUserId, UserUtil.getCurrentUserId())
                  .in(
                     SysPushNotificationReadLink::getSysPushNotificationUserLinkId,
                     recodeDetail.stream().map(SysPushAppDetailsDTO::getUserLinkId).collect(Collectors.toList())
                  )
            );
         if (isRead) {
            recodeDetail = recodeDetail.stream()
               .filter(
                  userLink -> sysPushNotificationReadLinks.stream()
                     .map(SysPushNotificationReadLink::getSysPushNotificationUserLinkId)
                     .collect(Collectors.toList())
                     .contains(userLink.getUserLinkId())
               )
               .collect(Collectors.toList());
         } else {
            recodeDetail = recodeDetail.stream()
               .filter(
                  userLink -> !sysPushNotificationReadLinks.stream()
                     .map(SysPushNotificationReadLink::getSysPushNotificationUserLinkId)
                     .collect(Collectors.toList())
                     .contains(userLink.getUserLinkId())
               )
               .collect(Collectors.toList());
         }
      }

      recodeDetail.forEach(
         userLinkItem -> {
            NotificationModuleTypeEnum typeEnum = NotificationModuleTypeEnum.getEnumByNotificationTypeAndOperationalModuleType(
               userLinkItem.getNotificationTypeEnum(), userLinkItem.getOperationalModuleTypeEnum()
            );
            List<SysPushNotificationReadLink> sysPushNotificationReadLinksx = this.sysPushNotificationReadLinkBiz
               .list(
                  Wrappers.lambdaQuery(SysPushNotificationReadLink.class)
                     .eq(SysPushNotificationReadLink::getUserId, userLinkItem.getUserId())
                     .in(SysPushNotificationReadLink::getSysPushNotificationUserLinkId, userLinkItem.getUserLinkId())
               );
            Boolean isReadParam = CollectionUtils.isNotEmpty(sysPushNotificationReadLinksx) ? Boolean.TRUE : Boolean.FALSE;
            SysPushNotificationDetailDTO build = SysPushNotificationDetailDTO.builder()
               .operationalModuleTypeEnumName(typeEnum != null ? typeEnum.getOperationalModuleTypeName() : "")
               .operationalModuleTypeEnum(userLinkItem != null ? userLinkItem.getOperationalModuleTypeEnum() : 0)
               .notificationTypeEnum(userLinkItem != null ? userLinkItem.getNotificationTypeEnum() : 0)
               .notificationTypeEnumName(typeEnum != null ? typeEnum.getNotificationTypeName() : "")
               .isRead(isReadParam)
               .recordId(userLinkItem != null ? userLinkItem.getRecordId() : 0L)
               .contentDetails(userLinkItem != null ? userLinkItem.getContentDetails().toString() : "")
               .id(userLinkItem != null ? userLinkItem.getUserLinkId() : 0L)
               .pushTime(userLinkItem != null ? userLinkItem.getPushTime() : LocalDateTime.now())
               .build();
            List<SysPushNotificationUserLink> sysPushNotificationUserLinks = this.sysPushNotificationUserLinkBiz
               .list(
                  Wrappers.lambdaQuery(SysPushNotificationUserLink.class)
                     .eq(SysPushNotificationUserLink::getSysPushNotificationRecordId, userLinkItem.getRecordId())
               );
            if (CollectionUtils.isNotEmpty(sysPushNotificationUserLinks)) {
               Map<Long, User> userMap = this.sysUserService
                  .list(
                     Wrappers.lambdaQuery(User.class)
                        .in(User::getId, sysPushNotificationUserLinks.stream().map(SysPushNotificationUserLink::getUserId).collect(Collectors.toList()))
                  )
                  .stream()
                  .collect(Collectors.toMap(User::getId, Function.identity()));
               Map<Long, Department> departmentMap = this.departmentService.list().stream().collect(Collectors.toMap(Department::getId, Function.identity()));
               List<DepartmentAndUserInfoDTO> departmentAndUserInfoDTOS = new ArrayList<>();
               sysPushNotificationUserLinks.forEach(
                  links -> {
                     if (userMap.get(links.getUserId()) != null) {
                        User sysUser = userMap.get(links.getUserId());
                        if (sysUser.getDepartmentId() != null) {
                           Department sysDepartment = departmentMap.get(sysUser.getDepartmentId());
                           if (sysDepartment != null) {
                              departmentAndUserInfoDTOS.add(
                                 DepartmentAndUserInfoDTO.builder().departmentName(sysDepartment.getName()).userName(sysUser.getName()).build()
                              );
                           }
                        }
                     }
                  }
               );
               build.setDepartmentAndUserInfoDTOS(departmentAndUserInfoDTOS);
            }

            detailDTOS.add(build);
         }
      );
      return new PageVO<>(
         PageUtils.getPageVO(
            this.baseService.getRecodeDetail(operationalModuleType, startDate, endDate, content, UserUtil.getCurrentUserId()), pageNumber, pageSize
         ),
         detailDTOS
      );
   }
}
