package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionTaskAbsencesRecordBiz;
import com.hzchum.scim.system.core.api.enums.AvoidTimeEnum;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskAbsencesRecord;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskRecord;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUser;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLink;
import com.hzchum.scim.system.core.api.service.ProjectInspectionTaskAbsencesRecordService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionTaskRecordService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserLinkService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionTaskAbsencesRecordMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProjectInspectionTaskAbsencesRecordBizImpl
   extends IBizImpl<ProjectInspectionTaskAbsencesRecordService, ProjectInspectionTaskAbsencesRecordMapper, ProjectInspectionTaskAbsencesRecord>
   implements ProjectInspectionTaskAbsencesRecordBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectInspectionTaskAbsencesRecordBizImpl.class);
   @Resource
   private ProjectInspectionTaskRecordService projectInspectionTaskRecordService;
   @Resource
   private ProjectInspectionUserService projectInspectionUserService;
   @Resource
   private ProjectInspectionUserLinkService projectInspectionUserLinkService;

   @Override
   public void generateInspectionTaskAbsencesRecord(Long projectInspectionUserId) {
      log.info("生成巡检缺卡记录-------");
      LocalDate now = LocalDate.now();
      if (projectInspectionUserId == null) {
         List<ProjectInspectionUser> projectInspectionUsers = this.projectInspectionUserService.list(Wrappers.lambdaQuery(ProjectInspectionUser.class));
         if (CollectionUtils.isNotEmpty(projectInspectionUsers)) {
            projectInspectionUsers.forEach(
               item -> {
                  if (item.getStatus()) {
                     if (item.getAvoidTime() != null && item.getAvoidTime() != 0) {
                        if (item.getAvoidTime().equals(AvoidTimeEnum.AVOID_SATURDAY.getType()) && now.getDayOfWeek().getValue() != 6) {
                           this.generateInspectionTaskAbsencesRecord(item, now);
                        }

                        if (item.getAvoidTime().equals(AvoidTimeEnum.AVOID_SUNDAY.getType()) && now.getDayOfWeek().getValue() != 7) {
                           this.generateInspectionTaskAbsencesRecord(item, now);
                        }

                        if (item.getAvoidTime().equals(AvoidTimeEnum.AVOID_SUNDAY.getType() + AvoidTimeEnum.AVOID_SATURDAY.getType())
                           && now.getDayOfWeek().getValue() != 6
                           && now.getDayOfWeek().getValue() != 7) {
                           this.generateInspectionTaskAbsencesRecord(item, now);
                        }
                     } else {
                        this.generateInspectionTaskAbsencesRecord(item, now);
                     }
                  }
               }
            );
         }
      } else {
         ProjectInspectionUser projectInspectionUser = this.projectInspectionUserService.getById(projectInspectionUserId);
         if (projectInspectionUser != null) {
            this.generateInspectionTaskAbsencesRecord(projectInspectionUser, now);
         }
      }

      log.info("生成巡检缺卡记录完成-------");
   }

   private void generateInspectionTaskAbsencesRecord(ProjectInspectionUser projectInspectionUser, LocalDate now) {
      if (projectInspectionUser != null) {
         Integer patrolsTime = projectInspectionUser.getPatrolsTime();
         List<ProjectInspectionUserLink> projectInspectionUserLinkList = this.projectInspectionUserLinkService
            .list(
               Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
                  .eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId())
                  .eq(ProjectInspectionUserLink::getStatus, 1)
            );
         List<ProjectInspectionTaskRecord> projectInspectionTaskRecordList = this.projectInspectionTaskRecordService
            .list(
               Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
                  .eq(ProjectInspectionTaskRecord::getUserId, projectInspectionUser.getUserId())
                  .eq(ProjectInspectionTaskRecord::getInspectionDate, now)
            );
         List<ProjectInspectionTaskAbsencesRecord> projectInspectionTaskAbsencesRecords = this.list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, projectInspectionUser.getUserId())
               .eq(ProjectInspectionTaskAbsencesRecord::getInspectionDate, now)
               .in(
                  ProjectInspectionTaskAbsencesRecord::getProjectInspectionId,
                  projectInspectionUserLinkList.stream().map(ProjectInspectionUserLink::getProjectInspectionId).collect(Collectors.toList())
               )
         );
         if (CollectionUtils.isEmpty(projectInspectionTaskAbsencesRecords)) {
            Map<Long, List<ProjectInspectionTaskRecord>> map = projectInspectionTaskRecordList.stream()
               .collect(Collectors.groupingBy(ProjectInspectionTaskRecord::getProjectInspectionId));
            projectInspectionUserLinkList.forEach(
               item -> {
                  List<ProjectInspectionTaskRecord> projectInspectionTaskRecords = map.getOrDefault(item.getProjectInspectionId(), new ArrayList<>());

                  for (int i = 0; i < patrolsTime - projectInspectionTaskRecords.size(); i++) {
                     ProjectInspectionTaskAbsencesRecord projectInspectionTaskAbsencesRecord = ProjectInspectionTaskAbsencesRecord.builder()
                        .projectInspectionId(item.getProjectInspectionId())
                        .inspectionDate(now)
                        .userId(projectInspectionUser.getUserId())
                        .build();
                     this.save(projectInspectionTaskAbsencesRecord);
                  }
               }
            );
         }
      }
   }
}
