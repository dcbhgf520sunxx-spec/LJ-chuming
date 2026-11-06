package com.hzchum.scim.system.core.biz.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionTaskAbsencesRecordBiz;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionUserBiz;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionUserLinkRecordBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.AuditStateEnum;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspection;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskAbsencesRecord;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskRecord;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUser;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLink;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLinkRecord;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.safety.ProjectInspectionUserLinkRecordDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionInfo;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionUserDTO;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionLineDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionUserLinkRecordDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.ProjectLineApplyRemovePointDTOParam;
import com.hzchum.scim.system.core.api.service.ProjectInspectionService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionTaskRecordService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserLinkService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserService;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionUserMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectInspectionUserBizImpl
   extends IBizImpl<ProjectInspectionUserService, ProjectInspectionUserMapper, ProjectInspectionUser>
   implements ProjectInspectionUserBiz {
   @Resource
   private ProjectInspectionUserLinkService projectInspectionUserLinkService;
   @Resource
   private UserService userService;
   @Resource
   private ProjectInspectionService projectInspectionService;
   @Resource
   private ProjectInspectionTaskRecordService projectInspectionTaskRecordService;
   @Resource
   private ProjectInspectionTaskAbsencesRecordBiz projectInspectionTaskAbsencesRecordBiz;
   @Resource
   private ContractProjectBiz contractProjectBiz;
   @Resource
   private ProjectUserLinkService projectUserLinkService;
   @Resource
   private ProjectInspectionUserLinkRecordBiz inspectionUserLinkRecordBiz;
   @Resource
   private AttachmentService attachmentService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean saveLine(ProjectInspectionLineDTOParam projectInspectionLineDTOParam) {
      if (projectInspectionLineDTOParam.getIsSort() == 1) {
         List<ProjectInspectionDTO> projectInspectionDTOS = projectInspectionLineDTOParam.getProjectInspectionDTOS();
         long sortNumber = projectInspectionDTOS.stream().filter(item -> item.getSortNumber() == null).count();
         Preconditions.checkArgument(sortNumber <= 0L, "请先完成排序");
      }

      ProjectInspectionUser projectInspectionUser = this.getOne(
         Wrappers.lambdaQuery(ProjectInspectionUser.class).eq(ProjectInspectionUser::getUserId, projectInspectionLineDTOParam.getUserId())
      );
      Preconditions.checkArgument(projectInspectionUser == null, "项目人员巡检线已存在,不可重复创建");
      projectInspectionUser = BeanUtil.copy(projectInspectionLineDTOParam, ProjectInspectionUser.class);
      this.save(projectInspectionUser);
      List<Long> projectInspectionIds = this.projectInspectionService.list().stream().map(ProjectInspection::getId).collect(Collectors.toList());

      for (ProjectInspectionDTO projectInspectionDTO : projectInspectionLineDTOParam.getProjectInspectionDTOS()) {
         Long id = projectInspectionDTO.getId();
         Preconditions.checkArgument(projectInspectionIds.contains(id), "巡检路线中的巡检点不存在");
         ProjectInspectionUserLink projectInspectionUserLink = ProjectInspectionUserLink.builder()
            .status(1)
            .sortNumber(projectInspectionLineDTOParam.getIsSort() == 1 ? projectInspectionDTO.getSortNumber() : null)
            .projectInspectionUserId(projectInspectionUser.getId())
            .projectInspectionId(projectInspectionDTO.getId())
            .build();
         this.projectInspectionUserLinkService.save(projectInspectionUserLink);
      }

      return true;
   }

   @Override
   public boolean deleteLine(Long id) {
      ProjectInspectionUser projectInspectionUser = this.getById(id);
      Preconditions.checkArgument(projectInspectionUser != null, "巡检线不存在!");
      List<ProjectInspectionTaskAbsencesRecord> inspectionTaskAbsencesRecords = this.projectInspectionTaskAbsencesRecordBiz
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, projectInspectionUser.getUserId())
         );
      List<ProjectInspectionTaskRecord> inspectionTaskRecords = this.projectInspectionTaskRecordService
         .list(Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class).eq(ProjectInspectionTaskRecord::getUserId, projectInspectionUser.getUserId()));
      this.projectInspectionUserLinkService
         .remove(Wrappers.lambdaQuery(ProjectInspectionUserLink.class).eq(ProjectInspectionUserLink::getProjectInspectionUserId, id));
      this.inspectionUserLinkRecordBiz
         .remove(Wrappers.lambdaQuery(ProjectInspectionUserLinkRecord.class).eq(ProjectInspectionUserLinkRecord::getInspectionUserId, id));
      this.projectInspectionTaskRecordService
         .remove(Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class).eq(ProjectInspectionTaskRecord::getUserId, projectInspectionUser.getUserId()));
      this.projectInspectionTaskAbsencesRecordBiz
         .remove(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, projectInspectionUser.getUserId())
         );
      this.removeById(id);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updateLine(ProjectInspectionLineDTOParam projectInspectionLineDTOParam) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(projectInspectionLineDTOParam.getProjectInspectionDTOS()), "请先添加巡检点");
      ProjectInspectionUser projectInspectionUser = this.getById(projectInspectionLineDTOParam.getId());
      Preconditions.checkArgument(projectInspectionUser != null, "巡检配置不存在");
      List<ProjectInspectionTaskAbsencesRecord> inspectionTaskAbsencesRecords = this.projectInspectionTaskAbsencesRecordBiz
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, projectInspectionUser.getUserId())
         );
      List<ProjectInspectionTaskRecord> inspectionTaskRecords = this.projectInspectionTaskRecordService
         .list(Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class).eq(ProjectInspectionTaskRecord::getUserId, projectInspectionUser.getUserId()));
      if (CollectionUtils.isNotEmpty(inspectionTaskRecords) || CollectionUtils.isNotEmpty(inspectionTaskAbsencesRecords)) {
         Preconditions.checkArgument(projectInspectionLineDTOParam.getUserId().equals(projectInspectionUser.getUserId()), "巡检人员已存在巡检记录不允许修改巡检人员");
      }

      if (projectInspectionLineDTOParam.getIsSort() == 1) {
         List<ProjectInspectionDTO> projectInspectionDTOS = projectInspectionLineDTOParam.getProjectInspectionDTOS();
         long sortNumber = projectInspectionDTOS.stream().filter(item -> item.getSortNumber() == null).count();
         Preconditions.checkArgument(sortNumber <= 0L, "请先完成排序");
      }

      List<ProjectInspectionUserLink> projectInspectionUserLinks = this.projectInspectionUserLinkService
         .list(Wrappers.lambdaQuery(ProjectInspectionUserLink.class).eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId()));
      List<ProjectInspectionTaskRecord> projectInspectionTaskRecords = this.projectInspectionTaskRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
               .in(
                  ProjectInspectionTaskRecord::getProjectInspectionUserLinkId,
                  projectInspectionUserLinks.stream().map(ProjectInspectionUserLink::getId).collect(Collectors.toList())
               )
               .eq(ProjectInspectionTaskRecord::getInspectionDate, LocalDate.now())
         );
      List<ProjectInspectionTaskAbsencesRecord> projectInspectionTaskAbsencesRecords = this.projectInspectionTaskAbsencesRecordBiz
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, projectInspectionUser.getUserId())
               .eq(ProjectInspectionTaskAbsencesRecord::getInspectionDate, LocalDate.now())
         );
      Preconditions.checkArgument(projectInspectionTaskRecords.size() == 0, "当天已存在巡检记录,请在原配置巡检时间之后进行修改");
      Preconditions.checkArgument(projectInspectionTaskAbsencesRecords.size() == 0, "当天已存在巡检缺卡记录,请在原配置巡检时间之后进行修改");
      this.updateById(BeanUtil.copy(projectInspectionLineDTOParam, ProjectInspectionUser.class));
      List<Long> inspectionIds = this.projectInspectionUserLinkService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
               .eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionLineDTOParam.getId())
         )
         .stream()
         .map(ProjectInspectionUserLink::getProjectInspectionId)
         .collect(Collectors.toList());
      inspectionIds.removeAll(projectInspectionLineDTOParam.getProjectInspectionDTOS().stream().map(ProjectInspectionDTO::getId).collect(Collectors.toList()));
      if (CollectionUtils.isNotEmpty(inspectionIds)) {
         ProjectInspectionUserLinkRecord record = this.inspectionUserLinkRecordBiz
            .getOne(
               Wrappers.lambdaQuery(ProjectInspectionUserLinkRecord.class)
                  .eq(ProjectInspectionUserLinkRecord::getInspectionUserId, projectInspectionUser.getId())
                  .eq(ProjectInspectionUserLinkRecord::getAuditState, AuditStateEnum.AUDITING.getType())
            );
         if (record != null && inspectionIds.containsAll(JSON.parseArray(record.getRemovePointJson(), Long.class))) {
            throw new BusinessException("待删除的点位存在审核信息!");
         }
      }

      this.projectInspectionUserLinkService
         .remove(
            Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
               .eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionLineDTOParam.getId())
         );
      List<Long> projectInspectionIds = this.projectInspectionService.list().stream().map(ProjectInspection::getId).collect(Collectors.toList());

      for (ProjectInspectionDTO projectInspectionDTO : projectInspectionLineDTOParam.getProjectInspectionDTOS()) {
         Long id = projectInspectionDTO.getId();
         Preconditions.checkArgument(projectInspectionIds.contains(id), "巡检路线中的巡检点不存在");
         ProjectInspectionUserLink projectInspectionUserLink = ProjectInspectionUserLink.builder()
            .sortNumber(projectInspectionLineDTOParam.getIsSort() == 1 ? projectInspectionDTO.getSortNumber() : null)
            .status(1)
            .projectInspectionUserId(projectInspectionUser.getId())
            .projectInspectionId(projectInspectionDTO.getId())
            .build();
         this.projectInspectionUserLinkService.save(projectInspectionUserLink);
      }

      return true;
   }

   @Override
   public List<ProjectInspectionUserDTO> getLine() {
      List<ProjectInspectionUser> projectInspectionUserList = this.list();
      if (CollectionUtils.isNotEmpty(projectInspectionUserList)) {
         List<ProjectInspectionUserDTO> projectInspectionUserDTOList = cn.hutool.core.bean.BeanUtil.copyToList(
            projectInspectionUserList, ProjectInspectionUserDTO.class
         );
         projectInspectionUserDTOList.forEach(
            item -> {
               User sysUser = this.userService.getById(item.getUserId());
               if (sysUser != null) {
                  item.setUserName(sysUser.getName());
                  List<Long> inspectionIds = this.projectInspectionUserLinkService
                     .list(
                        Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
                           .eq(ProjectInspectionUserLink::getProjectInspectionUserId, item.getId())
                           .eq(ProjectInspectionUserLink::getStatus, 1)
                     )
                     .stream()
                     .map(ProjectInspectionUserLink::getProjectInspectionId)
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(inspectionIds)) {
                     List<ProjectInspectionDTO> inspectionList = this.projectInspectionService.getInspectionList(inspectionIds, item.getId());
                     item.setInspectionList(inspectionList);
                  }
               }
            }
         );
         return projectInspectionUserDTOList.stream().filter(item -> item.getUserName() != null).collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public ProjectInspectionDetailDTO getLineDetail(Long id) {
      ProjectInspectionUser byId = this.getById(id);
      ProjectInspectionDetailDTO projectInspectionDetailDTO = BeanUtil.copy(byId, ProjectInspectionDetailDTO.class);
      projectInspectionDetailDTO.setUserName(this.userService.getById(byId.getUserId()).getName());
      List<ProjectInspectionUserLink> projectInspectionUserLinkList = this.projectInspectionUserLinkService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
               .eq(ProjectInspectionUserLink::getProjectInspectionUserId, id)
               .eq(ProjectInspectionUserLink::getStatus, 1)
         );
      if (CollectionUtils.isNotEmpty(projectInspectionUserLinkList)) {
         List<ProjectInspectionDTO> projectInspectionDTOS = cn.hutool.core.bean.BeanUtil.copyToList(
            this.projectInspectionService
               .listByIds(projectInspectionUserLinkList.stream().map(ProjectInspectionUserLink::getProjectInspectionId).collect(Collectors.toList())),
            ProjectInspectionDTO.class
         );
         projectInspectionDTOS.forEach(item -> projectInspectionUserLinkList.forEach(link -> {
            if (link.getProjectInspectionId().equals(item.getId())) {
               item.setSortNumber(link.getSortNumber());
            }
         }));
         projectInspectionDetailDTO.setProjectInspectionDTOS(
            byId.getIsSort() == 1
               ? projectInspectionDTOS.stream().sorted(Comparator.comparing(ProjectInspectionDTO::getSortNumber)).collect(Collectors.toList())
               : projectInspectionDTOS
         );
      }

      return projectInspectionDetailDTO;
   }

   @Override
   public List<ProjectInspectionUserDTO> getAllInspectionUser() {
      List<ProjectInspectionTaskRecord> projectInspectionTaskRecords = this.projectInspectionTaskRecordService.list();
      List<ProjectInspectionTaskAbsencesRecord> projectInspectionTaskAbsencesRecords = this.projectInspectionTaskAbsencesRecordBiz.list();
      List<ProjectInspectionUser> projectInspectionUsers = this.baseService.list();
      Set<Long> userIdSet = new HashSet<>();
      projectInspectionUsers.stream().forEach(e -> userIdSet.add(e.getUserId()));
      projectInspectionTaskRecords.stream().forEach(e -> userIdSet.add(e.getUserId()));
      projectInspectionTaskAbsencesRecords.stream().forEach(e -> userIdSet.add(e.getUserId()));
      if (!CollectionUtils.isNotEmpty(userIdSet)) {
         return null;
      }

      List<User> sysUsers = this.userService.listByIds(userIdSet);
      List<ProjectInspectionUserDTO> projectInspectionUserDTOList = new ArrayList<>();

      for (User sysUser : sysUsers) {
         projectInspectionUserDTOList.add(ProjectInspectionUserDTO.builder().userId(sysUser.getId()).userName(sysUser.getName()).build());
      }

      return projectInspectionUserDTOList;
   }

   @Override
   public boolean updateLineStatus(Long id) {
      ProjectInspectionUser projectInspectionUser = this.getById(id);
      Preconditions.checkArgument(projectInspectionUser != null, "巡检线不存在");
      projectInspectionUser.setStatus(!projectInspectionUser.getStatus());
      this.baseService.updateById(projectInspectionUser);
      return true;
   }

   @Override
   public boolean updateLineMandatoryInspection(Long id) {
      ProjectInspectionUser projectInspectionUser = this.baseService.getById(id);
      Preconditions.checkArgument(projectInspectionUser != null, "巡检线路不存在");
      List<ProjectInspectionUserLink> projectInspectionUserLinks = this.projectInspectionUserLinkService
         .list(Wrappers.lambdaQuery(ProjectInspectionUserLink.class).eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId()));
      List<ProjectInspectionTaskRecord> projectInspectionTaskRecords = this.projectInspectionTaskRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
               .in(
                  ProjectInspectionTaskRecord::getProjectInspectionUserLinkId,
                  projectInspectionUserLinks.stream().map(ProjectInspectionUserLink::getId).collect(Collectors.toList())
               )
               .eq(ProjectInspectionTaskRecord::getInspectionDate, LocalDate.now())
         );
      List<ProjectInspectionTaskAbsencesRecord> projectInspectionTaskAbsencesRecords = this.projectInspectionTaskAbsencesRecordBiz
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, projectInspectionUser.getUserId())
               .eq(ProjectInspectionTaskAbsencesRecord::getInspectionDate, LocalDate.now())
         );
      Preconditions.checkArgument(projectInspectionTaskRecords.size() == 0, "当天已存在巡检记录,请在原配置巡检时间之后进行修改");
      Preconditions.checkArgument(projectInspectionTaskAbsencesRecords.size() == 0, "当天已存在巡检缺卡记录,请在原配置巡检时间之后进行修改");
      projectInspectionUser.setMandatoryInspection(!projectInspectionUser.isMandatoryInspection());
      this.baseService.updateById(projectInspectionUser);
      return true;
   }

   @Transactional
   @Override
   public boolean applyRemoveLine(ProjectLineApplyRemovePointDTOParam saveParam) {
      ProjectInspectionUser inspectionUser = this.getOne(
         Wrappers.lambdaQuery(ProjectInspectionUser.class).eq(ProjectInspectionUser::getUserId, UserUtil.getCurrentUserId())
      );
      Preconditions.checkArgument(inspectionUser != null, "巡检线不存在!");
      Map<Long, ProjectInspectionUserLink> pointIdLinkMap = this.projectInspectionUserLinkService
         .list(Wrappers.lambdaQuery(ProjectInspectionUserLink.class).eq(ProjectInspectionUserLink::getProjectInspectionUserId, inspectionUser.getId()))
         .stream()
         .collect(Collectors.toMap(ProjectInspectionUserLink::getProjectInspectionId, Function.identity()));
      Preconditions.checkArgument(pointIdLinkMap.keySet().containsAll(saveParam.getPointIds()), "所选点位已不存在!");
      Preconditions.checkArgument(pointIdLinkMap.keySet().size() > saveParam.getPointIds().size(), "请至少保留一个巡检点位");
      List<ProjectInspectionTaskRecord> projectInspectionTaskRecords = this.projectInspectionTaskRecordService
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
               .in(
                  ProjectInspectionTaskRecord::getProjectInspectionUserLinkId,
                  pointIdLinkMap.values().stream().map(ProjectInspectionUserLink::getId).collect(Collectors.toList())
               )
               .eq(ProjectInspectionTaskRecord::getInspectionDate, LocalDate.now())
         );
      List<ProjectInspectionTaskAbsencesRecord> projectInspectionTaskAbsencesRecords = this.projectInspectionTaskAbsencesRecordBiz
         .list(
            Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
               .eq(ProjectInspectionTaskAbsencesRecord::getUserId, inspectionUser.getUserId())
               .eq(ProjectInspectionTaskAbsencesRecord::getInspectionDate, LocalDate.now())
         );
      Preconditions.checkArgument(projectInspectionTaskRecords.size() == 0, "当天已存在巡检记录,请在原配置巡检时间之后进行修改");
      Preconditions.checkArgument(projectInspectionTaskAbsencesRecords.size() == 0, "当天已存在巡检缺卡记录,请在原配置巡检时间之后进行修改");
      ProjectInspection inspection = this.projectInspectionService.getById(saveParam.getPointIds().get(0));
      Preconditions.checkArgument(pointIdLinkMap.get(inspection.getId()).getStatus().equals(1), "巡检点已经关闭无需删除!");
      User admin = this.userService.getOne(Wrappers.lambdaQuery(User.class).eq(User::getUsername, "admin"));
      ProjectInspectionUserLinkRecordDTOParam build = ProjectInspectionUserLinkRecordDTOParam.builder()
         .inspectionUserId(inspectionUser.getId())
         .remark(saveParam.getRemark())
         .applyAnnexJson(JSON.toJSONString(saveParam.getApplyAnnexIds()))
         .removePointJson(JSON.toJSONString(saveParam.getPointIds()))
         .createUserId(UserUtil.getCurrentUserId())
         .createUserName(UserUtil.getCurrentName())
         .canAuditId(inspection.getCreateUserId() == null ? admin.getId() : inspection.getCreateUserId())
         .build();
      this.inspectionUserLinkRecordBiz.createRecord(build);
      return Boolean.TRUE;
   }

   @Override
   public PageVO<ProjectInspectionUserLinkRecordDTO> applyRemoveLinePage(Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectInspectionUserLinkRecord> applyRecordList = this.inspectionUserLinkRecordBiz
         .list(
            Wrappers.lambdaQuery(ProjectInspectionUserLinkRecord.class)
               .eq(ProjectInspectionUserLinkRecord::getAuditState, AuditStateEnum.AUDITING.getType())
               .eq(!UserUtil.getCurrentUser().isAdmin(), ProjectInspectionUserLinkRecord::getCanAuditId, UserUtil.getCurrentUserId())
         );
      List<ProjectInspectionUserLinkRecordDTO> recordDTOList = applyRecordList.stream()
         .map(
            record -> {
               ProjectInspectionUserLinkRecordDTO recordDTO = BeanUtil.copy(record, ProjectInspectionUserLinkRecordDTO.class);
               if (record.getCanAuditId() != null) {
                  recordDTO.setCanAuditUserName(this.userService.getById(record.getCanAuditId()).getName());
               }

               List<String> applyAnnexIds = JSON.parseArray(record.getApplyAnnexJson(), String.class);
               List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(StringUtils.join(applyAnnexIds, ","));
               recordDTO.setApplyAnnexDTOList(attachmentDTOS);
               List<ProjectInspection> projectInspectionList = this.projectInspectionService
                  .listByIds(JSON.parseArray(record.getRemovePointJson(), Long.class));
               List<ProjectInspectionInfo> projectInspectionInfoList = cn.hutool.core.bean.BeanUtil.copyToList(
                  projectInspectionList, ProjectInspectionInfo.class
               );
               recordDTO.setRemovePointList(projectInspectionInfoList);
               List<ProjectInspection> inspectionList = this.projectInspectionService
                  .listByIds(
                     this.projectInspectionUserLinkService
                        .list(
                           Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
                              .eq(ProjectInspectionUserLink::getProjectInspectionUserId, record.getInspectionUserId())
                        )
                        .stream()
                        .map(ProjectInspectionUserLink::getProjectInspectionId)
                        .collect(Collectors.toList())
                  );
               recordDTO.setPointList(cn.hutool.core.bean.BeanUtil.copyToList(inspectionList, ProjectInspectionInfo.class));
               return recordDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(recordDTOList);
   }

   @Override
   public Integer applyNum() {
      return this.inspectionUserLinkRecordBiz
         .count(
            Wrappers.lambdaQuery(ProjectInspectionUserLinkRecord.class)
               .eq(ProjectInspectionUserLinkRecord::getAuditState, AuditStateEnum.AUDITING.getType())
               .eq(!UserUtil.getCurrentUser().isAdmin(), ProjectInspectionUserLinkRecord::getCanAuditId, UserUtil.getCurrentUserId())
         );
   }

   @Transactional
   @Override
   public boolean auditResource(Long recordId, Integer auditStatus) {
      ProjectInspectionUserLinkRecord record = this.inspectionUserLinkRecordBiz.getById(recordId);
      Preconditions.checkArgument(record != null, "记录不存在!");
      Preconditions.checkArgument(record.getAuditState().equals(AuditStateEnum.AUDITING.getType()), "审核状态已改变!");
      Preconditions.checkArgument(!AuditStateEnum.AUDITING.getType().equals(auditStatus), "审核状态不正确!");
      ProjectInspectionUser projectInspectionUser = this.getById(record.getInspectionUserId());
      Preconditions.checkArgument(projectInspectionUser != null, "巡检线已不存在!");
      SecurityUser currentUser = UserUtil.getCurrentUser();
      if (!currentUser.isAdmin()) {
         Preconditions.checkArgument(currentUser.getId().equals(record.getCanAuditId()), "巡检线创建人和超管可以审核!");
      }

      record.setAuditState(auditStatus);
      record.setAuditTime(LocalDateTime.now());
      record.setAuditorId(UserUtil.getCurrentUserId());
      record.setAuditorName(UserUtil.getCurrentName());
      this.inspectionUserLinkRecordBiz.updateById(record);
      if (AuditStateEnum.SUCCEED.getType().equals(auditStatus)) {
         List<ProjectInspectionUserLink> projectInspectionUserLinks = this.projectInspectionUserLinkService
            .list(
               Wrappers.lambdaQuery(ProjectInspectionUserLink.class).eq(ProjectInspectionUserLink::getProjectInspectionUserId, projectInspectionUser.getId())
            );
         List<ProjectInspectionTaskRecord> projectInspectionTaskRecords = this.projectInspectionTaskRecordService
            .list(
               Wrappers.lambdaQuery(ProjectInspectionTaskRecord.class)
                  .in(
                     ProjectInspectionTaskRecord::getProjectInspectionUserLinkId,
                     projectInspectionUserLinks.stream().map(ProjectInspectionUserLink::getId).collect(Collectors.toList())
                  )
                  .eq(ProjectInspectionTaskRecord::getInspectionDate, LocalDate.now())
            );
         List<ProjectInspectionTaskAbsencesRecord> projectInspectionTaskAbsencesRecords = this.projectInspectionTaskAbsencesRecordBiz
            .list(
               Wrappers.lambdaQuery(ProjectInspectionTaskAbsencesRecord.class)
                  .eq(ProjectInspectionTaskAbsencesRecord::getUserId, projectInspectionUser.getUserId())
                  .eq(ProjectInspectionTaskAbsencesRecord::getInspectionDate, LocalDate.now())
            );
         Preconditions.checkArgument(projectInspectionTaskRecords.size() == 0, "当天已存在巡检记录,请在原配置巡检时间之后进行修改");
         Preconditions.checkArgument(projectInspectionTaskAbsencesRecords.size() == 0, "当天已存在巡检缺卡记录,请在原配置巡检时间之后进行修改");
         this.projectInspectionUserLinkService
            .remove(
               Wrappers.lambdaQuery(ProjectInspectionUserLink.class)
                  .eq(ProjectInspectionUserLink::getProjectInspectionUserId, record.getInspectionUserId())
                  .in(ProjectInspectionUserLink::getProjectInspectionId, JSON.parseArray(record.getRemovePointJson(), Long.class))
            );
      }

      return Boolean.TRUE;
   }
}
