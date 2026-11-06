package com.hzchum.scim.mes.building.core.service.impl.attend;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.enums.attend.AttendStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockNumberEnum;
import com.hzchum.scim.mes.building.core.api.enums.attend.OverStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.attend.WeekScopeEnum;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendance;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfigUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceStandConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceStandConfigService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.mes.building.core.mapper.attend.MesBuildingAttendanceStandConfigMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingAttendanceStandConfigServiceImpl
   extends ServiceImpl<MesBuildingAttendanceStandConfigMapper, MesBuildingAttendanceStandConfig>
   implements MesBuildingAttendanceStandConfigService {
   @Resource
   private MesRosterService rosterService;
   @Resource
   private MesBuildingAttendanceOverConfigService overConfigService;
   @Resource
   private MesBuildingAttendanceOverConfigUserLinkService overConfigUserLinkService;
   @Resource
   private MesBuildingAttendanceService attendanceService;

   @Transactional
   @Override
   public void generateAttendanceTask() {
      LocalDate now = LocalDate.now();
      MesBuildingAttendanceStandConfig todayStandConfig = this.getOne(
         Wrappers.lambdaQuery(MesBuildingAttendanceStandConfig.class)
            .eq(MesBuildingAttendanceStandConfig::getIsBaseConfig, Boolean.FALSE)
            .eq(MesBuildingAttendanceStandConfig::getAttendanceDate, now)
      );
      if (todayStandConfig == null) {
         MesBuildingAttendanceStandConfig baseConfig = this.getOne(
            Wrappers.lambdaQuery(MesBuildingAttendanceStandConfig.class).eq(MesBuildingAttendanceStandConfig::getIsBaseConfig, Boolean.TRUE)
         );
         if (baseConfig == null) {
            return;
         }

         todayStandConfig = BeanUtil.copy(baseConfig, MesBuildingAttendanceStandConfig.class);
         todayStandConfig.setIsBaseConfig(Boolean.FALSE);
         todayStandConfig.setAttendanceDate(now);
         todayStandConfig.setMorningWorkingTime(LocalDateTime.of(now, baseConfig.getMorningWorkingTime().toLocalTime()));
         todayStandConfig.setAfternoonClosingTime(LocalDateTime.of(now, baseConfig.getAfternoonClosingTime().toLocalTime()));
         if (ClockNumberEnum.FOUR.getType().equals(baseConfig.getPunchTimes())) {
            todayStandConfig.setMorningClosingTime(LocalDateTime.of(now, baseConfig.getMorningClosingTime().toLocalTime()));
            todayStandConfig.setAfternoonWorkingTime(LocalDateTime.of(now, baseConfig.getAfternoonWorkingTime().toLocalTime()));
         }

         this.save(todayStandConfig);
      }

      List<Long> overConfigIds = this.overConfigService
         .list(
            Wrappers.lambdaQuery(MesBuildingAttendanceOverConfig.class)
               .apply("DATE_FORMAT(overtime_working_time, '%Y-%m-%d') <= {0} and DATE_FORMAT(overtime_closing_time, '%Y-%m-%d') >= {0}", now)
         )
         .stream()
         .map(MesBuildingAttendanceOverConfig::getId)
         .collect(Collectors.toList());
      Map<Long, List<Long>> userOverConfigMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(overConfigIds)) {
         userOverConfigMap = this.overConfigUserLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class).in(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, overConfigIds)
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingAttendanceOverConfigUserLink::getRosterId,
                  Collectors.mapping(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, Collectors.toList())
               )
            );
      }

      List<MesRoster> rosterList = this.rosterService.list(Wrappers.lambdaQuery(MesRoster.class).eq(MesRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType()));
      ArrayList<MesBuildingAttendance> initList = new ArrayList<>();

      for (MesRoster roster : rosterList) {
         Integer toDayType = WeekScopeEnum.getToDayType(now);
         if ((toDayType & todayStandConfig.getWeekScope()) > 0 || userOverConfigMap.containsKey(roster.getId())) {
            MesBuildingAttendance attendance = MesBuildingAttendance.builder()
               .attendanceDate(now)
               .idNumber(roster.getIdNumber())
               .supplierId(roster.getSupplierId())
               .workType(roster.getWorkType())
               .name(roster.getName())
               .rosterId(roster.getId())
               .userId(roster.getUserId())
               .standConfigId(todayStandConfig.getId())
               .overConfigIds(userOverConfigMap.containsKey(roster.getId()) ? StringUtils.join(userOverConfigMap.get(roster.getId()), ",") : null)
               .build();
            attendance.setAttendStatus(attendance.getStandConfigId() == null ? AttendStatusEnum.UNDISTRIBUTED.getType() : AttendStatusEnum.ABSENTEE.getType());
            attendance.setOverStatus(attendance.getOverConfigIds() == null ? AttendStatusEnum.UNDISTRIBUTED.getType() : AttendStatusEnum.ABSENTEE.getType());
            initList.add(attendance);
         }
      }

      List<Long> rosterIds = this.attendanceService
         .list(Wrappers.lambdaQuery(MesBuildingAttendance.class).eq(MesBuildingAttendance::getAttendanceDate, now).select(MesBuildingAttendance::getRosterId))
         .stream()
         .map(MesBuildingAttendance::getRosterId)
         .collect(Collectors.toList());
      List<MesBuildingAttendance> saveList = initList.stream().filter(e -> !rosterIds.contains(e.getRosterId())).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(saveList)) {
         this.attendanceService.saveBatch(saveList);
      }
   }

   @Override
   public void saveRosterAttendanceInfo(MesRoster roster) {
      LocalDate now = LocalDate.now();
      MesBuildingAttendanceStandConfig todayStandConfig = this.getOne(
         Wrappers.lambdaQuery(MesBuildingAttendanceStandConfig.class)
            .eq(MesBuildingAttendanceStandConfig::getIsBaseConfig, Boolean.FALSE)
            .eq(MesBuildingAttendanceStandConfig::getAttendanceDate, now)
      );
      Integer toDayType = WeekScopeEnum.getToDayType(now);
      if (todayStandConfig != null && (toDayType & todayStandConfig.getWeekScope()) > 0) {
         MesBuildingAttendance attendInfo = MesBuildingAttendance.builder()
            .attendanceDate(now)
            .idNumber(roster.getIdNumber())
            .supplierId(roster.getSupplierId())
            .workType(roster.getWorkType())
            .name(roster.getName())
            .rosterId(roster.getId())
            .userId(roster.getUserId())
            .standConfigId(todayStandConfig.getId())
            .overConfigIds(null)
            .attendStatus(AttendStatusEnum.ABSENTEE.getType())
            .overStatus(OverStatusEnum.UNDISTRIBUTED.getType())
            .build();
         MesBuildingAttendance attendanceInfo = this.attendanceService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingAttendance.class)
                  .eq(MesBuildingAttendance::getAttendanceDate, now)
                  .eq(MesBuildingAttendance::getRosterId, roster.getId())
            );
         if (attendanceInfo == null) {
            this.attendanceService.save(attendInfo);
         }
      }
   }
}
