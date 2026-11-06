package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionTaskRecordBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.AvoidTimeEnum;
import com.hzchum.scim.system.core.api.enums.InspectionSiteOptionTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspection;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskAbsencesRecord;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskRecord;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUser;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionTaskInfoDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionTaskRecordDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionTaskTimeAndAttachmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.TaskTimeAndAttachmentDTO;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionTaskRecordDTOParam;
import com.hzchum.scim.system.core.api.service.ProjectInspectionService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionTaskAbsencesRecordService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionTaskRecordService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserLinkService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionTaskRecordMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ProjectInspectionTaskRecordBizImpl
   extends IBizImpl<ProjectInspectionTaskRecordService, ProjectInspectionTaskRecordMapper, ProjectInspectionTaskRecord>
   implements ProjectInspectionTaskRecordBiz {
   @Resource
   private ProjectInspectionService projectInspectionService;
   @Resource
   private ProjectInspectionUserService projectInspectionUserService;
   @Resource
   private ProjectInspectionUserLinkService projectInspectionUserLinkService;
   @Resource
   private UserService userService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectInspectionTaskAbsencesRecordService projectInspectionTaskAbsencesRecordService;
   @Resource
   private ProjectInspectionTaskRecordService projectInspectionTaskRecordService;
   @Resource
   private ContractProjectBiz contractProjectBiz;
   @Resource
   private MesBuildingQhseService qhseService;

   @Override
   public boolean scanningCode(ProjectInspectionTaskRecordDTOParam projectInspectionTaskRecordDTOParam) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(projectInspectionTaskRecordDTOParam.getAttachmentIds()), "巡检照片数量不满足");
      Preconditions.checkArgument(StringUtils.isNotEmpty(projectInspectionTaskRecordDTOParam.getRemark()), "巡检记录信息不可为空");
      LocalDateTime inspectionTime = LocalDateTime.now();
      LocalTime now = inspectionTime.toLocalTime();
      ProjectInspectionUser projectInspectionUser = this.projectInspectionUserService
         .getOne(Wrappers.lambdaQuery(ProjectInspectionUser.class).eq(ProjectInspectionUser::getUserId, UserUtil.getCurrentUserId()));
      Preconditions.checkArgument(projectInspectionUser != null, "您不是该点位巡检人员");
      Preconditions.checkArgument(projectInspectionUser.getStatus(), "巡检线已关闭，不可巡检");
      ProjectInspection projectInspection = this.projectInspectionService.getById(projectInspectionTaskRecordDTOParam.getProjectInspectionId());
      Preconditions.checkArgument(projectInspection != null, "巡检点位不存在");
      ProjectInspectionUserLink projectInspectionUserLink = this.projectInspectionUserLinkService
         .getOne(
            Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
               .eq(ProjectInspectionUserLink::getProjectInspectionId, projectInspectionTaskRecordDTOParam.getProjectInspectionId())
               .eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId())
               .eq(ProjectInspectionUserLink::getStatus, 1)
         );
      Preconditions.checkArgument(projectInspectionUserLink != null, "您不是该点位巡检人员");
      List<ProjectInspectionTaskRecord> projectInspectionTaskRecordList = this.list(
         Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
            .eq(ProjectInspectionTaskRecord::getUserId, UserUtil.getCurrentUserId())
            .eq(ProjectInspectionTaskRecord::getInspectionDate, inspectionTime.toLocalDate())
      );
      List<ProjectInspectionUserLink> list = this.projectInspectionUserLinkService
         .list(Wrappers.lambdaQuery(ProjectInspectionUserLink.class).eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId()));
      List<ProjectInspectionTaskAbsencesRecord> projectInspectionTaskAbsencesRecords = this.projectInspectionTaskAbsencesRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, UserUtil.getCurrentUserId())
               .eq(ProjectInspectionTaskAbsencesRecord::getInspectionDate, inspectionTime.toLocalDate())
         );
      Preconditions.checkArgument(
         projectInspectionTaskRecordList != null && projectInspectionTaskRecordList.size() != projectInspectionUser.getPatrolsTime() * list.size(),
         "已达到巡检次数,不可扫码"
      );
      Preconditions.checkArgument(CollectionUtils.isEmpty(projectInspectionTaskAbsencesRecords), "今日巡检已结束,不可扫码");
      List<ProjectInspectionUserLink> projectInspectionUserLinks = this.projectInspectionUserLinkService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
               .eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId())
               .eq(ProjectInspectionUserLink::getStatus, 1)
         );
      if (projectInspectionUser.getIsSort() == 1 && projectInspectionUserLink.getSortNumber() != 1) {
         for (ProjectInspectionUserLink inspectionUserLink : projectInspectionUserLinks) {
            if (inspectionUserLink.getSortNumber().equals(projectInspectionUserLink.getSortNumber() - 1)) {
               List<ProjectInspectionTaskRecord> nowInspectionTaskRecords = this.list(
                  Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
                     .eq(ProjectInspectionTaskRecord::getInspectionDate, inspectionTime.toLocalDate())
                     .eq(ProjectInspectionTaskRecord::getProjectInspectionUserLinkId, projectInspectionUserLink.getId())
               );
               List<ProjectInspectionTaskRecord> previousInspectionTaskRecords = this.list(
                  Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
                     .eq(ProjectInspectionTaskRecord::getInspectionDate, inspectionTime.toLocalDate())
                     .eq(ProjectInspectionTaskRecord::getProjectInspectionUserLinkId, inspectionUserLink.getId())
               );
               Preconditions.checkArgument(nowInspectionTaskRecords.size() + 1 == previousInspectionTaskRecords.size(), "请按配置顺序巡检");
            }
         }
      } else if (projectInspectionUser.getIsSort() == 1 && projectInspectionUserLink.getSortNumber() == 1 && projectInspectionTaskRecordList.size() > 0) {
         Preconditions.checkArgument(projectInspectionTaskRecordList.size() % projectInspectionUserLinks.size() == 0, "请按配置顺序巡检");
      }

      LocalTime startTime = projectInspectionUser.getStartTime().toLocalTime();
      LocalTime endTime = projectInspectionUser.getEndTime().toLocalTime();
      boolean before = now.isBefore(startTime);
      boolean after = now.isAfter(endTime);
      Preconditions.checkArgument(!before, "还未到巡检时间不可扫码");
      Preconditions.checkArgument(!after, "已超过巡检时间不可扫码");
      if (projectInspectionUser.getIntervalTime() != null) {
         long intervalTime = projectInspectionUser.getIntervalTime() * 60;
         List<LocalDateTime> intervalTimes = projectInspectionTaskRecordList.stream()
            .map(ProjectInspectionTaskRecord::getInspectionTime)
            .collect(Collectors.toList());
         intervalTimes.forEach(item -> {
            long l = item.toEpochSecond(ZoneOffset.of("+8"));
            Preconditions.checkArgument(inspectionTime.toEpochSecond(ZoneOffset.of("+8")) > l + intervalTime, "上一次扫码时间未超过设置间隔时间,不可扫码");
         });
      }

      ProjectInspectionTaskRecord projectInspectionTaskRecord = BeanUtil.copy(projectInspectionTaskRecordDTOParam, ProjectInspectionTaskRecord.class);
      projectInspectionTaskRecord.setProjectInspectionUserLinkId(projectInspectionUserLink.getId());
      projectInspectionTaskRecord.setAttachmentIds(StringUtils.join(projectInspectionTaskRecordDTOParam.getAttachmentIds(), ","));
      projectInspectionTaskRecord.setInspectionTime(inspectionTime);
      projectInspectionTaskRecord.setUserId(projectInspectionUser.getUserId());
      projectInspectionTaskRecord.setInspectionDate(LocalDate.now());
      this.save(projectInspectionTaskRecord);
      return true;
   }

   @Override
   public ProjectInspectionTaskRecordDTO getInspectionTask() {
      Long userId = UserUtil.getCurrentUserId();
      ProjectInspectionUser projectInspectionUser = this.projectInspectionUserService
         .getOne(Wrappers.lambdaQuery(ProjectInspectionUser.class).eq(ProjectInspectionUser::getStatus, true).eq(ProjectInspectionUser::getUserId, userId));
      if (projectInspectionUser != null && projectInspectionUser.getStatus()) {
         if (projectInspectionUser.getAvoidTime() != null) {
            Integer avoidTime = projectInspectionUser.getAvoidTime();
            int value = LocalDateTime.now().getDayOfWeek().getValue();
            if (avoidTime.equals(AvoidTimeEnum.AVOID_SATURDAY.getType()) && value == 6) {
               return null;
            }

            if (avoidTime.equals(AvoidTimeEnum.AVOID_SUNDAY.getType()) && value == 7) {
               return null;
            }

            if (avoidTime.equals(AvoidTimeEnum.AVOID_SATURDAY.getType() + AvoidTimeEnum.AVOID_SUNDAY.getType()) && (value == 7 || value == 6)) {
               return null;
            }
         }

         ProjectInspectionTaskRecordDTO projectInspectionTaskRecordDTO = BeanUtil.copy(projectInspectionUser, ProjectInspectionTaskRecordDTO.class);
         projectInspectionTaskRecordDTO.setUserName(this.userService.getById(projectInspectionUser.getUserId()).getName());
         projectInspectionTaskRecordDTO.setIntervalTime(projectInspectionTaskRecordDTO.getIntervalTime());
         projectInspectionTaskRecordDTO.setInspectionDate(LocalDate.now());
         List<ProjectInspectionUserLink> projectInspectionUserLinkList = this.projectInspectionUserLinkService
            .list(
               Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
                  .eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId())
                  .eq(ProjectInspectionUserLink::getStatus, 1)
            );
         if (CollectionUtils.isNotEmpty(projectInspectionUserLinkList)) {
            List<ProjectInspectionTaskTimeAndAttachmentDTO> projectInspectionTaskTimeAndAttachmentDTOS = new ArrayList<>();
            Map<Long, List<ProjectInspectionTaskRecord>> inspectionTaskMap = this.projectInspectionTaskRecordService
               .list(
                  Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
                     .eq(ProjectInspectionTaskRecord::getUserId, userId)
                     .eq(ProjectInspectionTaskRecord::getInspectionDate, LocalDate.now())
               )
               .stream()
               .collect(Collectors.groupingBy(ProjectInspectionTaskRecord::getProjectInspectionId));
            projectInspectionUserLinkList.forEach(
               item -> {
                  List<TaskTimeAndAttachmentDTO> taskTimeAndAttachmentList = new ArrayList<>();
                  if (inspectionTaskMap.get(item.getProjectInspectionId()) != null) {
                     for (ProjectInspectionTaskRecord projectInspectionTaskRecord : inspectionTaskMap.get(item.getProjectInspectionId())) {
                        taskTimeAndAttachmentList.add(
                           TaskTimeAndAttachmentDTO.builder()
                              .point(projectInspectionTaskRecord.getPoint())
                              .remark(projectInspectionTaskRecord.getRemark())
                              .inspectionTime(projectInspectionTaskRecord.getInspectionTime())
                              .inspectionAttachmentList(this.attachmentService.listByIds(projectInspectionTaskRecord.getAttachmentIds()))
                              .build()
                        );
                     }
                  }

                  ProjectInspection inspection = this.projectInspectionService.getById(item.getProjectInspectionId());
                  projectInspectionTaskTimeAndAttachmentDTOS.add(
                     ProjectInspectionTaskTimeAndAttachmentDTO.builder()
                        .nfcSoleId(inspection.getNfcSoleId())
                        .point(inspection.getPoint())
                        .aroundRadius(inspection.getAroundRadius())
                        .id(item.getProjectInspectionId())
                        .sortNumber(item.getSortNumber())
                        .patrolsTime(taskTimeAndAttachmentList.size())
                        .inspectionName(inspection.getName())
                        .taskTimeAndAttachmentList(taskTimeAndAttachmentList)
                        .build()
                  );
               }
            );
            projectInspectionTaskRecordDTO.setProjectInspectionTaskTimeAndAttachmentDTOS(
               projectInspectionUser.getIsSort() == 1
                  ? projectInspectionTaskTimeAndAttachmentDTOS.stream()
                     .sorted(Comparator.comparing(ProjectInspectionTaskTimeAndAttachmentDTO::getSortNumber))
                     .collect(Collectors.toList())
                  : projectInspectionTaskTimeAndAttachmentDTOS
            );
         }

         return projectInspectionTaskRecordDTO;
      } else {
         return null;
      }
   }

   @Override
   public HashMap<String, Integer> getInspectionSummaryByUserId(Long userId, Integer inspectionSiteOptionType) {
      HashMap<String, Integer> summaryMap = new HashMap<>();
      List<Long> projectInspectionIds = new ArrayList<>();
      if (inspectionSiteOptionType.equals(InspectionSiteOptionTypeEnum.GET_MYSELF.getType())) {
         List<ProjectInspection> projectInspectionList = this.projectInspectionService
            .list(Wrappers.lambdaQuery(ProjectInspection.class).eq(ProjectInspection::getCreateUserId, UserUtil.getCurrentUserId()));
         if (CollectionUtils.isEmpty(projectInspectionList)) {
            return summaryMap;
         }

         projectInspectionList.forEach(item -> projectInspectionIds.add(item.getId()));
      }

      LocalDate startDate = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
      LocalDate endDate = LocalDate.now();
      Map<LocalDate, List<ProjectInspectionTaskRecord>> inspectionTaskRecordMap = this.projectInspectionTaskRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
               .eq(ProjectInspectionTaskRecord::getUserId, userId)
               .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionTaskRecord::getProjectInspectionId, projectInspectionIds)
               .between(ProjectInspectionTaskRecord::getInspectionDate, startDate, endDate)
         )
         .stream()
         .collect(Collectors.groupingBy(ProjectInspectionTaskRecord::getInspectionDate));
      Map<LocalDate, List<ProjectInspectionTaskAbsencesRecord>> inspectionTaskAbsencesRecordMap = this.projectInspectionTaskAbsencesRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, userId)
               .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionTaskAbsencesRecord::getProjectInspectionId, projectInspectionIds)
               .between(ProjectInspectionTaskAbsencesRecord::getInspectionDate, startDate, endDate)
         )
         .stream()
         .collect(Collectors.groupingBy(ProjectInspectionTaskAbsencesRecord::getInspectionDate));
      long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

      for (int i = 0; i <= daysBetween; i++) {
         LocalDate currentDate = startDate.plusDays(i);
         if (!currentDate.equals(LocalDate.now())) {
            if (inspectionTaskRecordMap.get(currentDate) != null && inspectionTaskAbsencesRecordMap.get(currentDate) != null) {
               summaryMap.put(
                  "improperCompletionByYear", summaryMap.get("improperCompletionByYear") == null ? 1 : summaryMap.get("improperCompletionByYear") + 1
               );
            }

            if (inspectionTaskRecordMap.get(currentDate) != null && inspectionTaskAbsencesRecordMap.get(currentDate) == null) {
               summaryMap.put("normalCompletionByYear", summaryMap.get("normalCompletionByYear") == null ? 1 : summaryMap.get("normalCompletionByYear") + 1);
            }

            if (inspectionTaskRecordMap.get(currentDate) == null && inspectionTaskAbsencesRecordMap.get(currentDate) != null) {
               summaryMap.put("numberOfAbsencesByYear", summaryMap.get("numberOfAbsencesByYear") == null ? 1 : summaryMap.get("numberOfAbsencesByYear") + 1);
            }
         }
      }

      LocalDate startMonthDate = LocalDate.now().withDayOfMonth(1);
      LocalDate endMonthDate = LocalDate.now();
      Map<LocalDate, List<ProjectInspectionTaskRecord>> inspectionMonthTaskRecordMap = this.projectInspectionTaskRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
               .eq(ProjectInspectionTaskRecord::getUserId, userId)
               .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionTaskRecord::getProjectInspectionId, projectInspectionIds)
               .between(ProjectInspectionTaskRecord::getInspectionDate, startMonthDate, endMonthDate)
         )
         .stream()
         .collect(Collectors.groupingBy(ProjectInspectionTaskRecord::getInspectionDate));
      Map<LocalDate, List<ProjectInspectionTaskAbsencesRecord>> inspectionMonthTaskAbsencesRecordMap = this.projectInspectionTaskAbsencesRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, userId)
               .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionTaskAbsencesRecord::getProjectInspectionId, projectInspectionIds)
               .between(ProjectInspectionTaskAbsencesRecord::getInspectionDate, startMonthDate, endMonthDate)
         )
         .stream()
         .collect(Collectors.groupingBy(ProjectInspectionTaskAbsencesRecord::getInspectionDate));
      long monthDaysBetween = ChronoUnit.DAYS.between(startMonthDate, endMonthDate);

      for (int i = 0; i <= monthDaysBetween; i++) {
         LocalDate currentDate = startMonthDate.plusDays(i);
         if (!currentDate.equals(LocalDate.now())) {
            if (inspectionMonthTaskRecordMap.get(currentDate) != null && inspectionMonthTaskAbsencesRecordMap.get(currentDate) != null) {
               summaryMap.put(
                  "improperCompletionByMonth", summaryMap.get("improperCompletionByMonth") == null ? 1 : summaryMap.get("improperCompletionByMonth") + 1
               );
            }

            if (inspectionMonthTaskRecordMap.get(currentDate) != null && inspectionMonthTaskAbsencesRecordMap.get(currentDate) == null) {
               summaryMap.put("normalCompletionByMonth", summaryMap.get("normalCompletionByMonth") == null ? 1 : summaryMap.get("normalCompletionByMonth") + 1);
            }

            if (inspectionMonthTaskRecordMap.get(currentDate) == null && inspectionMonthTaskAbsencesRecordMap.get(currentDate) != null) {
               summaryMap.put("numberOfAbsencesByMonth", summaryMap.get("numberOfAbsencesByMonth") == null ? 1 : summaryMap.get("numberOfAbsencesByMonth") + 1);
            }
         }
      }

      return summaryMap;
   }

   @Override
   public List<ProjectInspectionTaskInfoDTO> getInspectionTaskInfo(Long userId, LocalDate startDate, LocalDate endDate, Integer inspectionSiteOptionType) {
      if (startDate == null || endDate == null) {
         startDate = LocalDate.now().withDayOfMonth(1);
         endDate = LocalDate.now();
      }

      List<Long> projectInspectionIds = new ArrayList<>();
      if (inspectionSiteOptionType.equals(InspectionSiteOptionTypeEnum.GET_MYSELF.getType())) {
         List<ProjectInspection> projectInspectionList = this.projectInspectionService
            .list(Wrappers.lambdaQuery(ProjectInspection.class).eq(ProjectInspection::getCreateUserId, UserUtil.getCurrentUserId()));
         if (CollectionUtils.isEmpty(projectInspectionList)) {
            return new ArrayList<>();
         }

         projectInspectionList.forEach(item -> projectInspectionIds.add(item.getId()));
      }

      Map<LocalDate, List<MesBuildingQhse>> securityEnvironmentMap = this.qhseService
         .list(
            Wrappers.lambdaQuery(MesBuildingQhse.class)
               .eq(MesBuildingQhse::getUserId, userId)
               .apply("date_format(create_time,'%Y-%m-%d') <= {0}", endDate)
               .apply("date_format(create_time,'%Y-%m-%d') >= {0}", startDate)
               .last("and type &" + (QhseTypeEnum.SECURITY.getType() | QhseTypeEnum.ENVIRONMENT.getType()))
         )
         .stream()
         .collect(Collectors.groupingBy(e -> e.getCreateTime().toLocalDate()));
      Map<LocalDate, List<ProjectInspectionTaskRecord>> inspectionTaskMap = this.projectInspectionTaskRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
               .eq(ProjectInspectionTaskRecord::getUserId, userId)
               .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionTaskRecord::getProjectInspectionId, projectInspectionIds)
               .apply("date_format(inspection_date,'%Y-%m-%d') <= {0}", endDate)
               .apply("date_format(inspection_date,'%Y-%m-%d') >= {0}", startDate)
         )
         .stream()
         .collect(Collectors.groupingBy(ProjectInspectionTaskRecord::getInspectionDate));
      Map<LocalDate, List<ProjectInspectionTaskAbsencesRecord>> inspectionTaskAbsencesMap = this.projectInspectionTaskAbsencesRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, userId)
               .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionTaskAbsencesRecord::getProjectInspectionId, projectInspectionIds)
               .apply("date_format(inspection_date,'%Y-%m-%d') <= {0}", endDate)
               .apply("date_format(inspection_date,'%Y-%m-%d') >= {0}", startDate)
         )
         .stream()
         .collect(Collectors.groupingBy(ProjectInspectionTaskAbsencesRecord::getInspectionDate));
      List<ProjectInspectionTaskInfoDTO> projectInspectionTaskInfoDTOS = new ArrayList<>();

      for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1L)); date = date.plusDays(1L)) {
         ProjectInspectionTaskInfoDTO projectInspectionTaskInfoDTO = new ProjectInspectionTaskInfoDTO();
         projectInspectionTaskInfoDTO.setInspectionDate(date);
         List<Long> distinctProjectInspectionIds = new ArrayList<>();
         List<ProjectInspectionTaskRecord> projectInspectionTaskRecords = inspectionTaskMap.get(date);
         List<ProjectInspectionTaskAbsencesRecord> projectInspectionTaskAbsencesRecords = inspectionTaskAbsencesMap.get(date);
         List<MesBuildingQhse> qhses = securityEnvironmentMap.get(date);
         ProjectInspectionUser projectInspectionUser = this.projectInspectionUserService
            .getOne(Wrappers.lambdaQuery(ProjectInspectionUser.class).eq(ProjectInspectionUser::getStatus, true).eq(ProjectInspectionUser::getUserId, userId));
         List<ProjectInspectionUserLink> projectInspectionUserLinks = Collections.emptyList();
         if (projectInspectionUser != null) {
            projectInspectionUserLinks = this.projectInspectionUserLinkService
               .list(
                  Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
                     .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionUserLink::getProjectInspectionId, projectInspectionIds)
                     .eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId())
               );
         }

         if (date.equals(LocalDate.now())) {
            if (projectInspectionUser != null) {
               int value = LocalDate.now().getDayOfWeek().getValue();
               if (projectInspectionUser.getAvoidTime() != null
                     && projectInspectionUser.getAvoidTime().equals(AvoidTimeEnum.AVOID_SATURDAY.getType())
                     && value == 6
                  || projectInspectionUser.getAvoidTime() != null
                     && projectInspectionUser.getAvoidTime().equals(AvoidTimeEnum.AVOID_SUNDAY.getType())
                     && value == 7
                  || projectInspectionUser.getAvoidTime() != null && projectInspectionUser.getAvoidTime().equals(3) && (value == 7 || value == 6)) {
                  break;
               }

               if (CollectionUtils.isEmpty(inspectionTaskMap.get(date))) {
                  projectInspectionTaskInfoDTO.setCompleteState(3);
               } else if (projectInspectionUser.getPatrolsTime() * projectInspectionUserLinks.size() == inspectionTaskMap.get(date).size()) {
                  projectInspectionTaskInfoDTO.setCompleteState(1);
               } else {
                  projectInspectionTaskInfoDTO.setCompleteState(2);
               }

               projectInspectionTaskInfoDTO.setProjectInspectionCount(
                  CollectionUtils.isNotEmpty(projectInspectionUserLinks) ? projectInspectionUserLinks.size() : 0
               );
            }
         } else {
            if (CollectionUtils.isNotEmpty(projectInspectionTaskRecords) && CollectionUtils.isNotEmpty(projectInspectionTaskAbsencesRecords)) {
               projectInspectionTaskInfoDTO.setCompleteState(2);
            } else if (CollectionUtils.isNotEmpty(projectInspectionTaskRecords) && CollectionUtils.isEmpty(projectInspectionTaskAbsencesRecords)) {
               projectInspectionTaskInfoDTO.setCompleteState(1);
            } else if (CollectionUtils.isEmpty(projectInspectionTaskRecords) && CollectionUtils.isNotEmpty(projectInspectionTaskAbsencesRecords)) {
               projectInspectionTaskInfoDTO.setCompleteState(3);
            }

            Optional.ofNullable(projectInspectionTaskRecords)
               .map(records -> records.stream().map(ProjectInspectionTaskRecord::getProjectInspectionId).collect(Collectors.toList()))
               .ifPresent(distinctProjectInspectionIds::addAll);
            Optional.ofNullable(projectInspectionTaskAbsencesRecords)
               .map(records -> records.stream().map(ProjectInspectionTaskAbsencesRecord::getProjectInspectionId).collect(Collectors.toList()))
               .ifPresent(distinctProjectInspectionIds::addAll);
            distinctProjectInspectionIds = distinctProjectInspectionIds.stream().distinct().collect(Collectors.toList());
            projectInspectionTaskInfoDTO.setProjectInspectionCount(distinctProjectInspectionIds.size());
         }

         int taskCount = 0;
         int taskabsence = 0;
         int hazardCount = 0;
         taskCount = projectInspectionUser == null ? 0 : projectInspectionUser.getPatrolsTime() * projectInspectionUserLinks.size();
         if (CollectionUtils.isNotEmpty(projectInspectionTaskRecords)) {
            taskabsence = projectInspectionTaskRecords.size();
         }

         if (CollectionUtils.isNotEmpty(qhses)) {
            hazardCount = qhses.size();
         }

         projectInspectionTaskInfoDTO.setTotalInspect(taskCount);
         projectInspectionTaskInfoDTO.setInspected(taskabsence);
         projectInspectionTaskInfoDTO.setNotInspected(taskCount - taskabsence);
         projectInspectionTaskInfoDTO.setHazardCount(hazardCount);
         projectInspectionTaskInfoDTOS.add(projectInspectionTaskInfoDTO);
      }

      return projectInspectionTaskInfoDTOS;
   }

   @Override
   public ProjectInspectionTaskRecordDTO getInspectionTaskDetail(Long userId, LocalDate date, Integer inspectionSiteOptionType) {
      List<Long> projectInspectionIds = new ArrayList<>();
      if (inspectionSiteOptionType.equals(InspectionSiteOptionTypeEnum.GET_MYSELF.getType())) {
         List<ProjectInspection> projectInspectionList = this.projectInspectionService
            .list(Wrappers.lambdaQuery(ProjectInspection.class).eq(ProjectInspection::getCreateUserId, UserUtil.getCurrentUserId()));
         if (CollectionUtils.isEmpty(projectInspectionList)) {
            return null;
         }

         projectInspectionList.forEach(item -> projectInspectionIds.add(item.getId()));
      }

      if (date.equals(LocalDate.now())) {
         ProjectInspectionUser projectInspectionUser = this.projectInspectionUserService
            .getOne(Wrappers.lambdaQuery(ProjectInspectionUser.class).eq(ProjectInspectionUser::getUserId, userId));
         if (projectInspectionUser == null) {
            return null;
         }

         ProjectInspectionTaskRecordDTO projectInspectionTaskRecordDTO = BeanUtil.copy(projectInspectionUser, ProjectInspectionTaskRecordDTO.class);
         projectInspectionTaskRecordDTO.setUserName(this.userService.getById(userId).getName());
         projectInspectionTaskRecordDTO.setInspectionDate(date);
         List<ProjectInspectionTaskTimeAndAttachmentDTO> projectInspectionTaskTimeAndAttachmentDTOS = new ArrayList<>();
         Map<Long, List<ProjectInspectionTaskRecord>> inspectionTaskMap = this.projectInspectionTaskRecordService
            .list(
               Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
                  .eq(ProjectInspectionTaskRecord::getUserId, userId)
                  .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionTaskRecord::getProjectInspectionId, projectInspectionIds)
                  .eq(ProjectInspectionTaskRecord::getInspectionDate, date)
            )
            .stream()
            .collect(Collectors.groupingBy(ProjectInspectionTaskRecord::getProjectInspectionId));
         List<ProjectInspectionUserLink> projectInspectionUserLinkList = this.projectInspectionUserLinkService
            .list(
               Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
                  .eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId())
                  .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionUserLink::getProjectInspectionId, projectInspectionIds)
                  .eq(ProjectInspectionUserLink::getStatus, 1)
            );
         projectInspectionUserLinkList.forEach(
            item -> {
               List<TaskTimeAndAttachmentDTO> taskTimeAndAttachmentList = new ArrayList<>();
               if (inspectionTaskMap.get(item.getProjectInspectionId()) != null) {
                  for (ProjectInspectionTaskRecord projectInspectionTaskRecord : inspectionTaskMap.get(item.getProjectInspectionId())) {
                     taskTimeAndAttachmentList.add(
                        TaskTimeAndAttachmentDTO.builder()
                           .point(projectInspectionTaskRecord.getPoint())
                           .inspectionTime(projectInspectionTaskRecord.getInspectionTime())
                           .inspectionAttachmentList(this.attachmentService.listByIds(projectInspectionTaskRecord.getAttachmentIds()))
                           .remark(projectInspectionTaskRecord.getRemark())
                           .build()
                     );
                  }
               }

               projectInspectionTaskTimeAndAttachmentDTOS.add(
                  ProjectInspectionTaskTimeAndAttachmentDTO.builder()
                     .id(item.getProjectInspectionId())
                     .sortNumber(item.getSortNumber())
                     .inspectionName(this.projectInspectionService.getById(item.getProjectInspectionId()).getName())
                     .taskTimeAndAttachmentList(taskTimeAndAttachmentList)
                     .build()
               );
            }
         );
         projectInspectionTaskRecordDTO.setProjectInspectionTaskTimeAndAttachmentDTOS(
            projectInspectionUser.getIsSort() == 1
               ? projectInspectionTaskTimeAndAttachmentDTOS.stream()
                  .sorted(Comparator.comparing(ProjectInspectionTaskTimeAndAttachmentDTO::getSortNumber))
                  .collect(Collectors.toList())
               : projectInspectionTaskTimeAndAttachmentDTOS
         );
         return projectInspectionTaskRecordDTO;
      } else {
         ProjectInspectionUser projectInspectionUser = this.projectInspectionUserService
            .getOne(Wrappers.lambdaQuery(ProjectInspectionUser.class).eq(ProjectInspectionUser::getUserId, userId));
         Map<Long, List<ProjectInspectionTaskRecord>> inspectionTaskMap = this.projectInspectionTaskRecordService
            .list(
               Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
                  .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionTaskRecord::getProjectInspectionId, projectInspectionIds)
                  .eq(ProjectInspectionTaskRecord::getUserId, userId)
                  .eq(ProjectInspectionTaskRecord::getInspectionDate, date)
            )
            .stream()
            .collect(Collectors.groupingBy(ProjectInspectionTaskRecord::getProjectInspectionId));
         Map<Long, List<ProjectInspectionTaskAbsencesRecord>> inspectionTaskAbsencesMap = this.projectInspectionTaskAbsencesRecordService
            .list(
               Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
                  .eq(ProjectInspectionTaskAbsencesRecord::getUserId, userId)
                  .in(CollectionUtils.isNotEmpty(projectInspectionIds), ProjectInspectionTaskAbsencesRecord::getProjectInspectionId, projectInspectionIds)
                  .eq(ProjectInspectionTaskAbsencesRecord::getInspectionDate, date)
            )
            .stream()
            .collect(Collectors.groupingBy(ProjectInspectionTaskAbsencesRecord::getProjectInspectionId));
         ProjectInspectionTaskRecordDTO projectInspectionTaskRecordDTO = BeanUtil.copy(projectInspectionUser, ProjectInspectionTaskRecordDTO.class);
         projectInspectionTaskRecordDTO.setUserName(this.userService.getById(projectInspectionUser.getUserId()).getName());
         projectInspectionTaskRecordDTO.setInspectionDate(date);
         projectInspectionTaskRecordDTO.setPatrolsTime(
            (
                  inspectionTaskAbsencesMap.values().stream().map(List::size).collect(Collectors.toList()).stream().mapToInt(Integer::intValue).sum()
                     + inspectionTaskMap.values().stream().map(List::size).collect(Collectors.toList()).stream().mapToInt(Integer::intValue).sum()
               )
               / Stream.concat(inspectionTaskMap.keySet().stream(), inspectionTaskAbsencesMap.keySet().stream()).collect(Collectors.toSet()).size()
         );
         List<ProjectInspectionTaskTimeAndAttachmentDTO> projectInspectionTaskTimeAndAttachmentDTOS = new ArrayList<>();
         List<ProjectInspection> projectInspections = this.projectInspectionService
            .listByIds(Stream.concat(inspectionTaskMap.keySet().stream(), inspectionTaskAbsencesMap.keySet().stream()).collect(Collectors.toSet()));
         projectInspections.forEach(
            item -> {
               List<TaskTimeAndAttachmentDTO> taskTimeAndAttachmentList = new ArrayList<>();
               if (inspectionTaskMap.get(item.getId()) != null) {
                  for (ProjectInspectionTaskRecord projectInspectionTaskRecord : inspectionTaskMap.get(item.getId())) {
                     taskTimeAndAttachmentList.add(
                        TaskTimeAndAttachmentDTO.builder()
                           .remark(projectInspectionTaskRecord.getRemark())
                           .point(projectInspectionTaskRecord.getPoint())
                           .inspectionTime(projectInspectionTaskRecord.getInspectionTime())
                           .inspectionAttachmentList(this.attachmentService.listByIds(projectInspectionTaskRecord.getAttachmentIds()))
                           .build()
                     );
                  }
               }

               projectInspectionTaskTimeAndAttachmentDTOS.add(
                  ProjectInspectionTaskTimeAndAttachmentDTO.builder()
                     .id(item.getId())
                     .taskTimeAndAttachmentList(taskTimeAndAttachmentList)
                     .inspectionName(item.getName())
                     .patrolsTime(taskTimeAndAttachmentList.size())
                     .build()
               );
            }
         );
         projectInspectionTaskRecordDTO.setProjectInspectionTaskTimeAndAttachmentDTOS(projectInspectionTaskTimeAndAttachmentDTOS);
         return projectInspectionTaskRecordDTO;
      }
   }
}
