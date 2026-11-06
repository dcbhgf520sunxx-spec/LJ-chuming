package com.hzchum.scim.project.core.service.impl.attend;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.project.core.api.enums.AttendStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendance;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceConfig;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceSummaryDTO;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceConfigService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageWxMsgService;
import com.hzchum.scim.project.core.mapper.attend.ProjectManageAttendanceMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectManageAttendanceServiceImpl
   extends ServiceImpl<ProjectManageAttendanceMapper, ProjectManageAttendance>
   implements ProjectManageAttendanceService {
   @Resource
   private ProjectManageAttendanceConfigService configService;
   @Resource
   private ProjectManageRosterService rosterService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   @Lazy
   private ProjectManageWxMsgService projectManageWxMsgService;

   @Transactional
   @Override
   public void initToDayAttendanceInfo() {
      LocalDate date = LocalDate.now();
      List<ProjectManageAttendanceConfig> configList = this.configService
         .list(Wrappers.lambdaQuery(ProjectManageAttendanceConfig.class).eq(ProjectManageAttendanceConfig::getIsClose, Boolean.FALSE));
      if (!CollectionUtils.isEmpty(configList)) {
         List<Long> projectIds = configList.stream().map(ProjectManageAttendanceConfig::getProjectId).collect(Collectors.toList());
         List<Long> initProjectIds = this.projectService
            .list(
               Wrappers.lambdaQuery(ContractProject.class)
                  .in(ContractProject::getId, projectIds)
                  .eq(ContractProject::getStatus, ProjectStatusEnum.PROCESSING.getType())
                  .select(ContractProject::getId)
            )
            .stream()
            .map(ContractProject::getId)
            .collect(Collectors.toList());
         Map<Long, ProjectManageAttendanceConfig> configMap = configList.stream()
            .filter(e -> initProjectIds.contains(e.getProjectId()))
            .collect(Collectors.toMap(ProjectManageAttendanceConfig::getProjectId, Function.identity()));
         ArrayList<ProjectManageAttendance> initInfo = new ArrayList<>();
         configMap.forEach(
            (projectId, attendConfig) -> {
               List<Long> supplierIds = Arrays.stream(attendConfig.getSupplierScope().split(",")).map(Long::valueOf).collect(Collectors.toList());

               for (ProjectManageRoster roster : this.rosterService
                  .list(
                     Wrappers.lambdaQuery(ProjectManageRoster.class)
                        .eq(ProjectManageRoster::getProjectId, projectId)
                        .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
                        .in(ProjectManageRoster::getSupplierId, supplierIds)
                  )) {
                  ProjectManageAttendance attendInfo = ProjectManageAttendance.builder()
                     .projectManageRosterId(roster.getId())
                     .userId(roster.getUserId())
                     .projectId(roster.getProjectId())
                     .supplierId(roster.getSupplierId())
                     .attendanceDate(date)
                     .workType(Integer.valueOf(roster.getWorkType()))
                     .name(roster.getName())
                     .attendStatus(AttendStatusEnum.ABSENTEE.getType())
                     .isCancel(Boolean.FALSE)
                     .morningWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningWorkingTime().toLocalTime()))
                     .morningClosingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningClosingTime().toLocalTime()))
                     .afternoonWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonWorkingTime().toLocalTime()))
                     .afternoonClosingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonClosingTime().toLocalTime()))
                     .attendanceTimeConfigurationId(attendConfig.getId())
                     .build();
                  initInfo.add(attendInfo);
               }
            }
         );
         List<Long> rosterIds = this.list(
               Wrappers.lambdaQuery(ProjectManageAttendance.class)
                  .eq(ProjectManageAttendance::getAttendanceDate, date)
                  .select(ProjectManageAttendance::getProjectManageRosterId)
            )
            .stream()
            .map(ProjectManageAttendance::getProjectManageRosterId)
            .collect(Collectors.toList());
         List<ProjectManageAttendance> saveList = initInfo.stream().filter(e -> !rosterIds.contains(e.getProjectManageRosterId())).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(saveList)) {
            this.saveBatch(saveList);
         }
      }
   }

   @Transactional
   @Override
   public void saveProjectAttendanceInfo(ProjectManageAttendanceConfig attendConfig) {
      LocalDate date = LocalDate.now();
      ArrayList<ProjectManageAttendance> initInfo = new ArrayList<>();
      List<Long> supplierIds = Arrays.stream(attendConfig.getSupplierScope().split(",")).map(Long::valueOf).collect(Collectors.toList());

      for (ProjectManageRoster roster : this.rosterService
         .list(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getProjectId, attendConfig.getProjectId())
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
               .in(ProjectManageRoster::getSupplierId, supplierIds)
         )) {
         ProjectManageAttendance attendInfo = ProjectManageAttendance.builder()
            .projectManageRosterId(roster.getId())
            .userId(roster.getUserId())
            .projectId(roster.getProjectId())
            .supplierId(roster.getSupplierId())
            .attendanceDate(date)
            .workType(Integer.valueOf(roster.getWorkType()))
            .name(roster.getName())
            .attendStatus(AttendStatusEnum.ABSENTEE.getType())
            .isCancel(Boolean.FALSE)
            .morningWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningWorkingTime().toLocalTime()))
            .morningClosingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningClosingTime().toLocalTime()))
            .afternoonWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonWorkingTime().toLocalTime()))
            .afternoonClosingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonClosingTime().toLocalTime()))
            .attendanceTimeConfigurationId(attendConfig.getId())
            .build();
         initInfo.add(attendInfo);
      }

      List<Long> rosterIds = this.list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getProjectId, attendConfig.getProjectId())
               .eq(ProjectManageAttendance::getAttendanceDate, date)
               .select(ProjectManageAttendance::getProjectManageRosterId)
         )
         .stream()
         .map(ProjectManageAttendance::getProjectManageRosterId)
         .collect(Collectors.toList());
      List<ProjectManageAttendance> saveList = initInfo.stream().filter(e -> !rosterIds.contains(e.getProjectManageRosterId())).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(saveList)) {
         this.saveBatch(saveList);
      }
   }

   @Transactional
   @Override
   public void updateAttendanceInfoCancel(boolean isUpdateClose, boolean isUpdateSupplier, ProjectManageAttendanceConfig attendConfig) {
      if (isUpdateClose || isUpdateSupplier) {
         if (!isUpdateClose) {
            this.updateBySupplierScope(attendConfig);
         } else if (!isUpdateSupplier) {
            this.updateByIsClose(attendConfig);
         } else {
            if (attendConfig.getIsClose()) {
               this.updateBySupplierScope(attendConfig);
               this.updateByIsClose(attendConfig);
            } else {
               this.updateByIsClose(attendConfig);
               this.updateBySupplierScope(attendConfig);
            }
         }
      }
   }

   @Transactional
   @Override
   public void saveRosterAttendanceInfo(ProjectManageRoster roster) {
      LocalDate date = LocalDate.now();
      ProjectManageAttendanceConfig attendConfig = this.configService
         .getOne(
            Wrappers.lambdaQuery(ProjectManageAttendanceConfig.class)
               .eq(ProjectManageAttendanceConfig::getProjectId, roster.getProjectId())
               .eq(ProjectManageAttendanceConfig::getIsClose, Boolean.FALSE)
         );
      if (attendConfig != null) {
         if (Arrays.stream(attendConfig.getSupplierScope().split(",")).map(Long::valueOf).collect(Collectors.toList()).contains(roster.getSupplierId())) {
            ProjectManageAttendance attendInfo = ProjectManageAttendance.builder()
               .projectManageRosterId(roster.getId())
               .userId(roster.getUserId())
               .projectId(roster.getProjectId())
               .supplierId(roster.getSupplierId())
               .attendanceDate(date)
               .workType(Integer.valueOf(roster.getWorkType()))
               .name(roster.getName())
               .attendStatus(AttendStatusEnum.ABSENTEE.getType())
               .isCancel(Boolean.FALSE)
               .morningWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningWorkingTime().toLocalTime()))
               .morningClosingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningClosingTime().toLocalTime()))
               .afternoonWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonWorkingTime().toLocalTime()))
               .afternoonClosingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonClosingTime().toLocalTime()))
               .attendanceTimeConfigurationId(attendConfig.getId())
               .build();
            ProjectManageAttendance attendanceInfo = this.getOne(
               Wrappers.lambdaQuery(ProjectManageAttendance.class)
                  .eq(ProjectManageAttendance::getAttendanceDate, date)
                  .eq(ProjectManageAttendance::getProjectManageRosterId, roster.getId())
            );
            if (attendanceInfo != null && attendanceInfo.getIsCancel()) {
               this.projectManageWxMsgService.saveSendMsgByRoster(roster);
               attendanceInfo.setIsCancel(Boolean.FALSE);
               this.updateById(attendanceInfo);
            }

            if (attendanceInfo == null) {
               this.save(attendInfo);
               this.projectManageWxMsgService.saveSendMsgByRoster(roster);
            }
         }
      }
   }

   @Override
   public void removeRosterAttendanceInfo(ProjectManageRoster roster) {
      LocalDate date = LocalDate.now();
      ProjectManageAttendance attendanceInfo = this.getOne(
         Wrappers.lambdaQuery(ProjectManageAttendance.class)
            .eq(ProjectManageAttendance::getAttendanceDate, date)
            .eq(ProjectManageAttendance::getProjectManageRosterId, roster.getId())
      );
      if (attendanceInfo != null && !attendanceInfo.getIsCancel()) {
         this.projectManageWxMsgService.removeSendMsgByRoster(roster);
         attendanceInfo.setIsCancel(Boolean.TRUE);
         this.updateById(attendanceInfo);
      }
   }

   @Override
   public List<ProjectManageAttendanceSummaryDTO> getAttendanceSummary(Long projectId, Long supplierId, LocalDate monthDate) {
      return this.baseMapper.getAttendanceSummary(projectId, supplierId, monthDate);
   }

   @Override
   public HashMap<String, Integer> getUserAttendanceSummary(Long rosterId) {
      return this.baseMapper.getUserAttendanceSummary(rosterId);
   }

   private void updateByIsClose(ProjectManageAttendanceConfig attendConfig) {
      LocalDate date = LocalDate.now();
      if (attendConfig.getIsClose()) {
         List<ProjectManageAttendance> updateList = this.list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getProjectId, attendConfig.getProjectId())
               .eq(ProjectManageAttendance::getAttendanceDate, date)
         );
         if (CollectionUtils.isNotEmpty(updateList)) {
            updateList.forEach(e -> e.setIsCancel(Boolean.TRUE));
            this.updateBatchById(updateList);
         }
      }

      if (!attendConfig.getIsClose()) {
         List<ProjectManageAttendance> updateList = this.list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getProjectId, attendConfig.getProjectId())
               .eq(ProjectManageAttendance::getAttendanceDate, date)
         );
         if (CollectionUtils.isNotEmpty(updateList)) {
            updateList.forEach(e -> e.setIsCancel(Boolean.FALSE));
            this.updateBatchById(updateList);
         }

         if (CollectionUtils.isEmpty(updateList)) {
            List<Long> supplierIds = Arrays.stream(attendConfig.getSupplierScope().split(",")).map(Long::valueOf).collect(Collectors.toList());

            for (ProjectManageRoster roster : this.rosterService
               .list(
                  Wrappers.lambdaQuery(ProjectManageRoster.class)
                     .eq(ProjectManageRoster::getProjectId, attendConfig.getProjectId())
                     .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
                     .in(ProjectManageRoster::getSupplierId, supplierIds)
               )) {
               ArrayList<ProjectManageAttendance> initInfo = new ArrayList<>();
               ProjectManageAttendance attendInfo = ProjectManageAttendance.builder()
                  .projectManageRosterId(roster.getId())
                  .userId(roster.getUserId())
                  .projectId(roster.getProjectId())
                  .supplierId(roster.getSupplierId())
                  .attendanceDate(date)
                  .workType(Integer.valueOf(roster.getWorkType()))
                  .name(roster.getName())
                  .attendStatus(AttendStatusEnum.ABSENTEE.getType())
                  .isCancel(Boolean.FALSE)
                  .morningWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningWorkingTime().toLocalTime()))
                  .morningClosingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningClosingTime().toLocalTime()))
                  .afternoonWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonWorkingTime().toLocalTime()))
                  .afternoonClosingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonClosingTime().toLocalTime()))
                  .attendanceTimeConfigurationId(attendConfig.getId())
                  .build();
               initInfo.add(attendInfo);
               if (CollectionUtils.isNotEmpty(initInfo)) {
                  this.saveBatch(initInfo);
               }
            }
         }
      }
   }

   private void updateBySupplierScope(ProjectManageAttendanceConfig attendConfig) {
      LocalDate date = LocalDate.now();
      List<Long> supplierIds = Arrays.stream(attendConfig.getSupplierScope().split(",")).map(Long::valueOf).collect(Collectors.toList());
      List<ProjectManageAttendance> updateList = new ArrayList<>(
         this.list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getProjectId, attendConfig.getProjectId())
               .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
               .eq(ProjectManageAttendance::getAttendanceDate, date)
         )
      );
      List<Long> updateSupplierIds = updateList.stream().map(ProjectManageAttendance::getSupplierId).distinct().collect(Collectors.toList());
      List<ProjectManageAttendance> deleteList = updateList.stream().filter(e -> !supplierIds.contains(e.getSupplierId())).collect(Collectors.toList());
      deleteList.forEach(e -> e.setIsCancel(Boolean.TRUE));
      if (CollectionUtils.isNotEmpty(deleteList)) {
         this.updateBatchById(deleteList);
      }

      supplierIds.removeAll(updateSupplierIds);
      if (CollectionUtils.isNotEmpty(supplierIds)) {
         ArrayList<ProjectManageAttendance> initInfo = new ArrayList<>();

         for (ProjectManageRoster roster : this.rosterService
            .list(
               Wrappers.lambdaQuery(ProjectManageRoster.class)
                  .eq(ProjectManageRoster::getProjectId, attendConfig.getProjectId())
                  .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
                  .in(ProjectManageRoster::getSupplierId, supplierIds)
            )) {
            ProjectManageAttendance attendInfo = ProjectManageAttendance.builder()
               .projectManageRosterId(roster.getId())
               .userId(roster.getUserId())
               .projectId(roster.getProjectId())
               .supplierId(roster.getSupplierId())
               .attendanceDate(date)
               .workType(Integer.valueOf(roster.getWorkType()))
               .name(roster.getName())
               .attendStatus(AttendStatusEnum.ABSENTEE.getType())
               .isCancel(Boolean.FALSE)
               .morningWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningWorkingTime().toLocalTime()))
               .morningClosingTimeConfig(LocalDateTime.of(date, attendConfig.getMorningClosingTime().toLocalTime()))
               .afternoonWorkingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonWorkingTime().toLocalTime()))
               .afternoonClosingTimeConfig(LocalDateTime.of(date, attendConfig.getAfternoonClosingTime().toLocalTime()))
               .attendanceTimeConfigurationId(attendConfig.getId())
               .build();
            initInfo.add(attendInfo);
         }

         List<Long> rosterIds = this.list(
               Wrappers.lambdaQuery(ProjectManageAttendance.class)
                  .eq(ProjectManageAttendance::getProjectId, attendConfig.getProjectId())
                  .eq(ProjectManageAttendance::getAttendanceDate, date)
                  .select(ProjectManageAttendance::getProjectManageRosterId)
            )
            .stream()
            .map(ProjectManageAttendance::getProjectManageRosterId)
            .collect(Collectors.toList());
         List<ProjectManageAttendance> saveList = initInfo.stream().filter(e -> !rosterIds.contains(e.getProjectManageRosterId())).collect(Collectors.toList());
         List<ProjectManageAttendance> updateIsCancelList = initInfo.stream()
            .filter(e -> rosterIds.contains(e.getProjectManageRosterId()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(saveList)) {
            this.saveBatch(saveList);
         }

         if (CollectionUtils.isNotEmpty(updateIsCancelList)) {
            updateIsCancelList.forEach(e -> e.setIsCancel(Boolean.FALSE));
            this.updateBatchById(saveList);
         }
      }
   }
}
