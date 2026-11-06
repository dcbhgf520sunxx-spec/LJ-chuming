package com.hzchum.scim.mes.building.core.service.impl.attend;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.enums.attend.AttendStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendance;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.OvertimeClockDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceStandConfigService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.mes.building.core.mapper.attend.MesBuildingAttendanceMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAttendanceServiceImpl extends ServiceImpl<MesBuildingAttendanceMapper, MesBuildingAttendance> implements MesBuildingAttendanceService {
   @Resource
   private MesBuildingAttendanceStandConfigService standConfigService;
   @Resource
   private MesRosterService rosterService;
   @Resource
   private MesBuildingAttendanceOverConfigService overConfigService;

   @Override
   public void appendOverTask(MesBuildingAttendanceOverConfig config, List<Long> rosterIds) {
      LocalDate now = LocalDate.now();
      List<LocalDate> dateRange = this.getDateRange(config.getOvertimeWorkingTime(), config.getOvertimeClosingTime());
      if (dateRange.contains(now)) {
         List<MesBuildingAttendance> updateList = this.list(
            Wrappers.lambdaQuery(MesBuildingAttendance.class)
               .eq(MesBuildingAttendance::getAttendanceDate, now)
               .in(MesBuildingAttendance::getRosterId, rosterIds)
         );
         if (CollectionUtils.isNotEmpty(updateList)) {
            Preconditions.checkArgument(rosterIds.size() == updateList.size(), "操作失败！数据异常");
            updateList.forEach(e -> {
               String overConfigIds = null;
               if (StrUtil.isBlank(e.getOverConfigIds())) {
                  overConfigIds = String.valueOf(config.getId());
               } else {
                  overConfigIds = e.getOverConfigIds() + "," + config.getId();
               }

               e.setOverConfigIds(overConfigIds);
               List<MesBuildingAttendanceOverConfig> overConfigDTOList = this.overConfigService.getListByIdStr(overConfigIds);
               List<OvertimeClockDO> overtimeClockDO1 = JSON.parseArray(e.getOvertimeWorkingTimeJson(), OvertimeClockDO.class);
               List<OvertimeClockDO> overtimeClockDO2 = JSON.parseArray(e.getOvertimeClosingTimeJson(), OvertimeClockDO.class);
               if (overtimeClockDO1 == null) {
                  overtimeClockDO1 = new ArrayList<>();
               }

               if (overtimeClockDO2 == null) {
                  overtimeClockDO2 = new ArrayList<>();
               }

               long count1 = overConfigDTOList.stream().filter(t -> t.getOvertimeWorkingTime().toLocalDate().equals(LocalDate.now())).count();
               long count2 = overConfigDTOList.stream().filter(t -> t.getOvertimeClosingTime().toLocalDate().equals(LocalDate.now())).count();
               if (CollectionUtils.isEmpty(overtimeClockDO1) && CollectionUtils.isEmpty(overtimeClockDO2)) {
                  e.setOverStatus(AttendStatusEnum.ABSENTEE.getType());
               } else if (overtimeClockDO1.size() == count1 && overtimeClockDO2.size() == count2) {
                  e.setOverStatus(AttendStatusEnum.NORMAL.getType());
               } else {
                  e.setOverStatus(AttendStatusEnum.ABSENCE.getType());
               }
            });
            this.updateBatchById(updateList);
         } else {
            List<MesRoster> rosterList = this.rosterService
               .list(Wrappers.lambdaQuery(MesRoster.class).eq(MesRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType()));
            ArrayList<MesBuildingAttendance> initList = new ArrayList<>();

            for (MesRoster roster : rosterList) {
               MesBuildingAttendance attendance = MesBuildingAttendance.builder()
                  .attendanceDate(now)
                  .idNumber(roster.getIdNumber())
                  .supplierId(roster.getSupplierId())
                  .workType(roster.getWorkType())
                  .name(roster.getName())
                  .rosterId(roster.getId())
                  .userId(roster.getUserId())
                  .standConfigId(null)
                  .overConfigIds(String.valueOf(config.getId()))
                  .attendStatus(AttendStatusEnum.UNDISTRIBUTED.getType())
                  .overStatus(AttendStatusEnum.ABSENTEE.getType())
                  .build();
               initList.add(attendance);
            }

            this.saveBatch(initList);
         }
      }
   }

   @Override
   public void removeOverTask(MesBuildingAttendanceOverConfig config, List<Long> rosterIds) {
      LocalDate now = LocalDate.now();
      List<MesBuildingAttendance> updateList = this.list(
         Wrappers.lambdaQuery(MesBuildingAttendance.class)
            .eq(MesBuildingAttendance::getAttendanceDate, now)
            .apply("find_in_set({0}, over_config_ids)", config.getId())
            .in(MesBuildingAttendance::getRosterId, rosterIds)
      );
      if (CollectionUtils.isNotEmpty(updateList)) {
         updateList.forEach(e -> {
            String[] split = StringUtils.split(e.getOverConfigIds(), ",");
            List<Long> idList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            idList.remove(config.getId());
            if (CollectionUtils.isEmpty(idList)) {
               e.setOverConfigIds(null);
               e.setOvertimeWorkingTimeJson(null);
               e.setOvertimeClosingTimeJson(null);
            } else {
               e.setOverConfigIds(StringUtils.join(idList, ","));
            }

            List<MesBuildingAttendanceOverConfig> overConfigDTOList = this.overConfigService.getListByIdStr(e.getOverConfigIds());
            if (CollectionUtils.isEmpty(overConfigDTOList)) {
               e.setOverStatus(AttendStatusEnum.UNDISTRIBUTED.getType());
            } else {
               List<OvertimeClockDO> overtimeClockDO1 = JSON.parseArray(e.getOvertimeWorkingTimeJson(), OvertimeClockDO.class);
               List<OvertimeClockDO> overtimeClockDO2 = JSON.parseArray(e.getOvertimeClosingTimeJson(), OvertimeClockDO.class);
               if (overtimeClockDO1 == null) {
                  overtimeClockDO1 = new ArrayList<>();
               }

               if (overtimeClockDO2 == null) {
                  overtimeClockDO2 = new ArrayList<>();
               }

               long count1 = overConfigDTOList.stream().filter(t -> t.getOvertimeWorkingTime().toLocalDate().equals(LocalDate.now())).count();
               long count2 = overConfigDTOList.stream().filter(t -> t.getOvertimeClosingTime().toLocalDate().equals(LocalDate.now())).count();
               if (CollectionUtils.isEmpty(overtimeClockDO1) && CollectionUtils.isEmpty(overtimeClockDO2)) {
                  e.setOverStatus(AttendStatusEnum.ABSENTEE.getType());
               } else if (overtimeClockDO1.size() == count1 && overtimeClockDO2.size() == count2) {
                  e.setOverStatus(AttendStatusEnum.NORMAL.getType());
               } else {
                  e.setOverStatus(AttendStatusEnum.ABSENCE.getType());
               }
            }
         });
      }

      this.updateBatchById(updateList);
      this.remove(
         Wrappers.lambdaQuery(MesBuildingAttendance.class)
            .eq(MesBuildingAttendance::getAttendanceDate, now)
            .in(MesBuildingAttendance::getRosterId, rosterIds)
            .isNull(MesBuildingAttendance::getOverConfigIds)
            .isNull(MesBuildingAttendance::getStandConfigId)
      );
   }

   public boolean hasNoOverlap(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
      start1 = this.removeSeconds(start1);
      end1 = this.removeSeconds(end1);
      start2 = this.removeSeconds(start2);
      end2 = this.removeSeconds(end2);
      if (!start1.isAfter(end1) && !start2.isAfter(end2)) {
         return start1.isBefore(end2) && end1.isAfter(start2);
      } else {
         throw new IllegalArgumentException("配置的加班时间和正常上班时间重复");
      }
   }

   public List<LocalDate> getDateRange(LocalDateTime start, LocalDateTime end) {
      LocalDate startDate = start.toLocalDate();
      LocalDate endDate = end.toLocalDate();
      return Stream.<LocalDate>iterate(startDate, date -> date.plusDays(1L))
         .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1L)
         .collect(Collectors.toList());
   }

   private LocalDateTime removeSeconds(LocalDateTime localDateTime) {
      return localDateTime == null ? null : localDateTime.truncatedTo(ChronoUnit.MINUTES);
   }
}
