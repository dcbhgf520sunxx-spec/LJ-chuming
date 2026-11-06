package com.hzchum.scim.mes.building.core.biz.impl.attend;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.biz.attend.MesBuildingAttendanceOverConfigBiz;
import com.hzchum.scim.mes.building.core.api.enums.attend.WeekScopeEnum;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendance;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfigUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceStandConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.OvertimeClockDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.attend.MesBuildingAttendanceOverConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesBuildingAttendanceOverConfigDTO;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceStandConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesWxMsgService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.mes.building.core.mapper.attend.MesBuildingAttendanceOverConfigMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingAttendanceOverConfigBizImpl
   extends IBizImpl<MesBuildingAttendanceOverConfigService, MesBuildingAttendanceOverConfigMapper, MesBuildingAttendanceOverConfig>
   implements MesBuildingAttendanceOverConfigBiz {
   @Resource
   private MesRosterService rosterService;
   @Resource
   private UserService userService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private MesBuildingAttendanceOverConfigService overConfigService;
   @Resource
   private MesBuildingAttendanceOverConfigUserLinkService overConfigUserLinkService;
   @Resource
   private MesBuildingAttendanceService attendanceService;
   @Resource
   private MesWxMsgService wxMsgService;
   @Resource
   private MesBuildingAttendanceStandConfigService standConfigService;

   @Override
   public List<DepartmentDTO> getRosterDepartmentList() {
      List<Long> userIds = this.rosterService.list(Wrappers.lambdaQuery(MesRoster.class)).stream().map(MesRoster::getUserId).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(userIds)) {
         return new ArrayList<>();
      }

      List<Long> departmentIds = this.userService.listByIds(userIds).stream().map(User::getDepartmentId).distinct().collect(Collectors.toList());
      return CollectionUtils.isEmpty(departmentIds)
         ? new ArrayList<>()
         : this.departmentService.listByIds(departmentIds).stream().map(e -> BeanUtil.copy(e, DepartmentDTO.class)).collect(Collectors.toList());
   }

   @Override
   public List<IdAndNameDTO> getRosterByDepartment(Long deptId) {
      List<Long> userIds = this.userService
         .list(Wrappers.lambdaQuery(User.class).eq(User::getDepartmentId, deptId))
         .stream()
         .map(User::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(userIds)) {
         return new ArrayList<>();
      }

      List<MesRoster> rosterList = this.rosterService.list(Wrappers.lambdaQuery(MesRoster.class).in(MesRoster::getUserId, userIds));
      if (CollectionUtils.isEmpty(rosterList)) {
         return new ArrayList<>();
      }

      Map<String, List<MesRoster>> groupedByName = rosterList.stream().collect(Collectors.groupingBy(MesRoster::getName));
      return rosterList.stream().map(roster -> {
         IdAndNameDTO dto = new IdAndNameDTO();
         if (groupedByName.get(roster.getName()).size() > 1) {
            String subStr = StrUtil.sub(roster.getIdNumber(), roster.getIdNumber().length() - 4, roster.getIdNumber().length());
            dto.setId(roster.getId());
            dto.setName(roster.getName() + "(" + subStr + ")");
         } else {
            dto.setId(roster.getId());
            dto.setName(roster.getName());
         }

         return dto;
      }).collect(Collectors.toList());
   }

   @Transactional
   @Override
   public boolean editOverConfig(MesBuildingAttendanceOverConfigDTOParam param) {
      this.checkParam(param);
      List<Long> paramRosterIds = param.getRosterIds();
      if (param.getId() == null) {
         MesBuildingAttendanceOverConfig overConfig = BeanUtil.copy(param, MesBuildingAttendanceOverConfig.class);
         overConfig.setUserId(UserUtil.getCurrentUserId());
         overConfig.setUserName(UserUtil.getCurrentName());
         this.overConfigService.save(overConfig);
         List<MesBuildingAttendanceOverConfigUserLink> saveList = paramRosterIds.stream()
            .map(e -> MesBuildingAttendanceOverConfigUserLink.builder().overConfigId(overConfig.getId()).rosterId(e).build())
            .collect(Collectors.toList());
         this.overConfigUserLinkService.saveBatch(saveList);
         this.attendanceService.appendOverTask(overConfig, param.getRosterIds());
         this.wxMsgService.appendOverTimes(overConfig, param.getRosterIds());
      } else {
         MesBuildingAttendanceOverConfig overConfig = this.overConfigService.getById(param.getId());
         Preconditions.checkArgument(overConfig != null, "操作失败！请刷新重试！");
         List<Long> rosterIds = this.overConfigUserLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class)
                  .eq(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, overConfig.getId())
            )
            .stream()
            .map(MesBuildingAttendanceOverConfigUserLink::getRosterId)
            .collect(Collectors.toList());
         LocalDate now = LocalDate.now();
         List<LocalDate> paramRangeList = this.getDateRange(param.getOvertimeWorkingTime(), param.getOvertimeClosingTime());

         for (LocalDate attendanceDate : paramRangeList) {
            if (attendanceDate.isBefore(now)) {
               throw new BusinessException("操作失败,已使用的打卡配置不能修改！");
            }

            if (attendanceDate.isEqual(now)) {
               List<MesBuildingAttendance> attendanceList = this.attendanceService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingAttendance.class)
                        .eq(MesBuildingAttendance::getAttendanceDate, now)
                        .apply("find_in_set({0}, over_config_ids)", overConfig.getId())
                  );
               Map<Long, List<LocalDateTime>> collect1 = attendanceList.stream()
                  .map(t -> {
                     List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(t.getOvertimeWorkingTimeJson(), OvertimeClockDO.class);
                     return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
                  })
                  .flatMap(Collection::stream)
                  .filter(y -> y.getId().equals(overConfig.getId()))
                  .collect(Collectors.groupingBy(OvertimeClockDO::getId, Collectors.mapping(OvertimeClockDO::getOverClockTime, Collectors.toList())));
               Map<Long, List<LocalDateTime>> collect2 = attendanceList.stream()
                  .map(t -> {
                     List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(t.getOvertimeClosingTimeJson(), OvertimeClockDO.class);
                     return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
                  })
                  .flatMap(Collection::stream)
                  .filter(y -> y.getId().equals(overConfig.getId()))
                  .collect(Collectors.groupingBy(OvertimeClockDO::getId, Collectors.mapping(OvertimeClockDO::getOverClockTime, Collectors.toList())));
               if (collect1.containsKey(overConfig.getId()) || collect2.containsKey(overConfig.getId())) {
                  Preconditions.checkArgument(BeanUtil.copy(param, MesBuildingAttendanceOverConfig.class).equals(overConfig), "操作失败,已存在加班人员加班打卡信息！不可修改配置信息！");
                  Preconditions.checkArgument(paramRosterIds.containsAll(rosterIds), "操作失败,已存在加班人员加班打卡信息！只能新增打卡人员！");
               }
            }
         }

         List<Long> tempRosterIds = JSON.parseArray(JSON.toJSONString(rosterIds), Long.class);
         tempRosterIds.removeAll(paramRosterIds);
         if (CollectionUtils.isNotEmpty(tempRosterIds)) {
            this.overConfigUserLinkService
               .remove(
                  Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class)
                     .eq(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, overConfig.getId())
                     .in(MesBuildingAttendanceOverConfigUserLink::getRosterId, tempRosterIds)
               );
            this.attendanceService.removeOverTask(overConfig, tempRosterIds);
            this.wxMsgService.removeOverTimers(overConfig, tempRosterIds);
         }

         paramRosterIds.removeAll(rosterIds);
         if (CollectionUtils.isNotEmpty(paramRosterIds)) {
            List<MesBuildingAttendanceOverConfigUserLink> saveList = paramRosterIds.stream()
               .map(e -> MesBuildingAttendanceOverConfigUserLink.builder().overConfigId(overConfig.getId()).rosterId(e).build())
               .collect(Collectors.toList());
            this.overConfigUserLinkService.saveBatch(saveList);
            this.attendanceService.appendOverTask(overConfig, paramRosterIds);
            this.wxMsgService.appendOverTimes(overConfig, param.getRosterIds());
         }

         boolean isNeedAllAppend = false;
         List<LocalDate> oldRangeList = this.getDateRange(overConfig.getOvertimeWorkingTime(), overConfig.getOvertimeClosingTime());
         if (oldRangeList.contains(now) && !paramRangeList.contains(now)) {
            this.attendanceService.removeOverTask(overConfig, rosterIds);
            this.wxMsgService.removeOverTimers(overConfig, rosterIds);
         }

         if (!oldRangeList.contains(now) && paramRangeList.contains(now)) {
            isNeedAllAppend = true;
         }

         BeanUtil.copy(param, overConfig);
         this.overConfigService.updateById(overConfig);
         List<Long> updatedRosterIds = this.overConfigUserLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class)
                  .eq(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, overConfig.getId())
            )
            .stream()
            .map(MesBuildingAttendanceOverConfigUserLink::getRosterId)
            .collect(Collectors.toList());
         if (isNeedAllAppend) {
            this.attendanceService.appendOverTask(overConfig, updatedRosterIds);
            this.wxMsgService.appendOverTimes(overConfig, updatedRosterIds);
         }
      }

      return true;
   }

   public static boolean isNotInStandWorkTime(LocalDateTime overTime, LocalDateTime startTime, LocalDateTime endTime) {
      return !overTime.isAfter(startTime) || !overTime.isBefore(endTime);
   }

   @Override
   public PageVO<MesBuildingAttendanceOverConfigDTO> getOverConfigPage(LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingAttendanceOverConfig> overConfigList = this.overConfigService
         .list(
            Wrappers.lambdaQuery(MesBuildingAttendanceOverConfig.class)
               .apply(endDate != null, "DATE_FORMAT(overtime_working_time, '%Y-%m-%d') <= {0}", endDate)
               .apply(startDate != null, "DATE_FORMAT(overtime_closing_time, '%Y-%m-%d') >= {0}", startDate)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isEmpty(overConfigList)) {
         return new PageVO<>();
      }

      List<Long> configIds = overConfigList.stream().map(MesBuildingAttendanceOverConfig::getId).collect(Collectors.toList());
      Map<Long, List<Long>> configRosterMap = this.overConfigUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class).in(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, configIds))
         .stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingAttendanceOverConfigUserLink::getOverConfigId,
               Collectors.mapping(MesBuildingAttendanceOverConfigUserLink::getRosterId, Collectors.toList())
            )
         );
      Map<Long, String> deptMap = this.getRosterDepartmentList().stream().collect(Collectors.toMap(DepartmentDTO::getId, DepartmentDTO::getName));
      List<MesBuildingAttendanceOverConfigDTO> configDTOList = overConfigList.stream()
         .map(
            config -> {
               MesBuildingAttendanceOverConfigDTO configDTO = BeanUtil.copy(config, MesBuildingAttendanceOverConfigDTO.class);
               configDTO.setDeptName(deptMap.getOrDefault(config.getDepartmentId(), null));
               List<Long> rosterIds = configRosterMap.get(config.getId());
               List<MesRoster> rosterList = this.rosterService.listByIds(rosterIds);
               Map<Long, IdAndNameDTO> deptRosterMap = this.getRosterByDepartment(config.getDepartmentId())
                  .stream()
                  .collect(Collectors.toMap(IdAndNameDTO::getId, Function.identity()));
               List<IdAndNameDTO> rosterDTO = rosterList.stream().map(roster -> {
                  IdAndNameDTO dto = new IdAndNameDTO();
                  if (deptRosterMap.containsKey(roster.getId())) {
                     dto = deptRosterMap.get(roster.getId());
                  } else {
                     dto.setId(roster.getId());
                     dto.setName(roster.getName());
                  }

                  return dto;
               }).collect(Collectors.toList());
               configDTO.setRosterList(rosterDTO);
               return configDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, configDTOList);
   }

   @Override
   public MesBuildingAttendanceOverConfigDTO getOverConfigDetails(Long overConfigId) {
      MesBuildingAttendanceOverConfig overConfig = this.overConfigService.getById(overConfigId);
      Preconditions.checkArgument(overConfig != null, "加班配置不存在！请刷新重试！");
      MesBuildingAttendanceOverConfigDTO configDTO = BeanUtil.copy(overConfig, MesBuildingAttendanceOverConfigDTO.class);
      List<Long> rosterIds = this.overConfigUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class).eq(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, overConfigId))
         .stream()
         .map(MesBuildingAttendanceOverConfigUserLink::getRosterId)
         .collect(Collectors.toList());
      configDTO.setRosterIds(rosterIds);
      return configDTO;
   }

   @Override
   public List<MesBuildingAttendanceOverConfigDTO> getUserOverConfigList(LocalDate monthDate) {
      MesRoster roster = this.rosterService
         .getOne(
            Wrappers.lambdaQuery(MesRoster.class)
               .eq(MesRoster::getUserId, UserUtil.getCurrentUserId())
               .eq(MesRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      Preconditions.checkArgument(roster != null, "操作失败！劳务信息不存在！");
      List<Long> configIds = this.overConfigUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class).eq(MesBuildingAttendanceOverConfigUserLink::getRosterId, roster.getId()))
         .stream()
         .map(MesBuildingAttendanceOverConfigUserLink::getOverConfigId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(configIds)) {
         return new ArrayList<>();
      }

      List<MesBuildingAttendanceOverConfig> configList = this.overConfigService
         .list(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfig.class).in(MesBuildingAttendanceOverConfig::getId, configIds).and(q -> {
            q.apply("DATE_FORMAT(overtime_working_time, '%Y-%m') = DATE_FORMAT({0}, '%Y-%m')", monthDate);
            q.or();
            q.apply("DATE_FORMAT(overtime_closing_time, '%Y-%m') = DATE_FORMAT({0}, '%Y-%m')", monthDate);
         }).orderByDesc(BaseEntity::getCreateTime));
      return CollectionUtils.isEmpty(configList)
         ? new ArrayList<>()
         : configList.stream().map(e -> BeanUtil.copy(e, MesBuildingAttendanceOverConfigDTO.class)).collect(Collectors.toList());
   }

   @Transactional
   @Override
   public boolean delete(Long id) {
      MesBuildingAttendanceOverConfig overConfig = this.overConfigService.getById(id);
      Preconditions.checkArgument(overConfig != null, "加班配置不存在！，请刷新重试！");

      for (LocalDate attendanceDate : this.getDateRange(overConfig.getOvertimeWorkingTime(), overConfig.getOvertimeClosingTime())) {
         Preconditions.checkArgument(!attendanceDate.isBefore(LocalDate.now()), "已使用的加班配置不能删除！");
      }

      List<MesBuildingAttendance> attendanceList = this.attendanceService
         .list(
            Wrappers.lambdaQuery(MesBuildingAttendance.class)
               .eq(MesBuildingAttendance::getAttendanceDate, LocalDate.now())
               .apply("find_in_set({0}, over_config_ids)", overConfig.getId())
         );
      Map<Long, List<LocalDateTime>> collect1 = attendanceList.stream()
         .map(t -> {
            List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(t.getOvertimeWorkingTimeJson(), OvertimeClockDO.class);
            return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
         })
         .flatMap(Collection::stream)
         .filter(y -> y.getId().equals(overConfig.getId()))
         .collect(Collectors.groupingBy(OvertimeClockDO::getId, Collectors.mapping(OvertimeClockDO::getOverClockTime, Collectors.toList())));
      Map<Long, List<LocalDateTime>> collect2 = attendanceList.stream()
         .map(t -> {
            List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(t.getOvertimeClosingTimeJson(), OvertimeClockDO.class);
            return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
         })
         .flatMap(Collection::stream)
         .filter(y -> y.getId().equals(overConfig.getId()))
         .collect(Collectors.groupingBy(OvertimeClockDO::getId, Collectors.mapping(OvertimeClockDO::getOverClockTime, Collectors.toList())));
      if (!collect1.containsKey(overConfig.getId()) && !collect2.containsKey(overConfig.getId())) {
         List<MesBuildingAttendanceOverConfigUserLink> rosterLinkList = this.overConfigUserLinkService
            .list(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class).eq(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, id));
         List<Long> removeRosterIds = rosterLinkList.stream().map(MesBuildingAttendanceOverConfigUserLink::getRosterId).collect(Collectors.toList());
         this.wxMsgService.removeOverTimers(overConfig, removeRosterIds);
         this.overConfigUserLinkService.removeByIds(rosterLinkList.stream().map(MesBuildingAttendanceOverConfigUserLink::getId).collect(Collectors.toList()));
         this.attendanceService.removeOverTask(overConfig, removeRosterIds);
         this.overConfigService.removeById(overConfig);
         return true;
      } else {
         throw new BusinessException("操作失败,已存在加班人员加班打卡信息！不可删除配置信息！");
      }
   }

   private void checkParam(MesBuildingAttendanceOverConfigDTOParam param) {
      param.setOvertimeWorkingTime(this.removeSeconds(param.getOvertimeWorkingTime()));
      param.setOvertimeClosingTime(this.removeSeconds(param.getOvertimeClosingTime()));
      Preconditions.checkArgument(param.getOvertimeClosingTime().isAfter(param.getOvertimeWorkingTime()), "下班时间不能早于上班时间");
      MesBuildingAttendanceStandConfig baseConfig = this.standConfigService
         .getOne(Wrappers.lambdaQuery(MesBuildingAttendanceStandConfig.class).eq(MesBuildingAttendanceStandConfig::getIsBaseConfig, Boolean.TRUE));
      Preconditions.checkArgument(baseConfig != null, "常规考勤配置信息不存在！");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");
      LocalDate now = LocalDate.now();

      for (LocalDate attendanceDate : this.getDateRange(param.getOvertimeWorkingTime(), param.getOvertimeClosingTime())) {
         if (attendanceDate.isEqual(now)) {
            MesBuildingAttendanceStandConfig todayStandConfig = this.standConfigService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingAttendanceStandConfig.class)
                     .eq(MesBuildingAttendanceStandConfig::getIsBaseConfig, Boolean.FALSE)
                     .eq(MesBuildingAttendanceStandConfig::getAttendanceDate, now)
               );
            Integer toDayType = WeekScopeEnum.getToDayType(now);
            if (todayStandConfig != null && (toDayType & todayStandConfig.getWeekScope()) > 0) {
               LocalDateTime startTime = LocalDateTime.of(attendanceDate, todayStandConfig.getMorningWorkingTime().toLocalTime());
               LocalDateTime endTime = LocalDateTime.of(attendanceDate, todayStandConfig.getAfternoonClosingTime().toLocalTime());
               boolean lap = this.hasNoOverlap(param.getOvertimeWorkingTime(), param.getOvertimeClosingTime(), startTime, endTime);
               if (lap) {
                  throw new BusinessException("操作失败！正常上班时间为：" + startTime.format(formatter) + "~" + endTime.format(formatter));
               }
            }
         } else {
            Integer toDayType = WeekScopeEnum.getToDayType(attendanceDate);
            if ((toDayType & baseConfig.getWeekScope()) > 0) {
               LocalDateTime startTime = LocalDateTime.of(attendanceDate, baseConfig.getMorningWorkingTime().toLocalTime());
               LocalDateTime endTime = LocalDateTime.of(attendanceDate, baseConfig.getAfternoonClosingTime().toLocalTime());
               boolean lap = this.hasNoOverlap(param.getOvertimeWorkingTime(), param.getOvertimeClosingTime(), startTime, endTime);
               if (lap) {
                  throw new BusinessException("操作失败！正常上班时间为：" + startTime.format(formatter) + "~" + endTime.format(formatter));
               }
            }
         }

         if (param.getId() == null) {
            Preconditions.checkArgument(!attendanceDate.isBefore(LocalDate.now()), "考勤日期不能为当前日期之前！");

            for (MesBuildingAttendanceOverConfig hasConfig : this.overConfigService
               .list(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfig.class).eq(MesBuildingAttendanceOverConfig::getDepartmentId, param.getDepartmentId()))) {
               boolean lap = this.hasNoOverlap(
                  param.getOvertimeWorkingTime(), param.getOvertimeClosingTime(), hasConfig.getOvertimeWorkingTime(), hasConfig.getOvertimeClosingTime()
               );
               if (lap) {
                  List<Long> rosterIds = this.overConfigUserLinkService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class)
                           .eq(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, hasConfig.getId())
                     )
                     .stream()
                     .map(MesBuildingAttendanceOverConfigUserLink::getRosterId)
                     .collect(Collectors.toList());
                  rosterIds.retainAll(param.getRosterIds());
                  if (CollectionUtils.isNotEmpty(rosterIds)) {
                     List<String> names = this.rosterService.listByIds(rosterIds).stream().map(MesRoster::getName).collect(Collectors.toList());
                     throw new BusinessException(
                        "操作失败！"
                           + names
                           + "加班时间重复为："
                           + hasConfig.getOvertimeWorkingTime().format(formatter)
                           + "~"
                           + hasConfig.getOvertimeClosingTime().format(formatter)
                     );
                  }
               }
            }
         } else {
            MesBuildingAttendanceOverConfig oldOverConfig = this.overConfigService.getById(param.getId());
            Preconditions.checkArgument(oldOverConfig != null, "操作失败,请刷新重试！");
            Preconditions.checkArgument(!attendanceDate.isBefore(LocalDate.now()), "已使用的加班配置不能修改！");
            if (!oldOverConfig.getOvertimeWorkingTime().isEqual(param.getOvertimeWorkingTime())
               || !oldOverConfig.getOvertimeClosingTime().isEqual(param.getOvertimeClosingTime())
               || !oldOverConfig.getDepartmentId().equals(param.getDepartmentId())) {
               for (MesBuildingAttendanceOverConfig hasConfig : this.overConfigService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingAttendanceOverConfig.class)
                        .ne(MesBuildingAttendanceOverConfig::getId, oldOverConfig.getId())
                        .eq(MesBuildingAttendanceOverConfig::getDepartmentId, param.getDepartmentId())
                  )) {
                  boolean lap = this.hasNoOverlap(
                     param.getOvertimeWorkingTime(), param.getOvertimeClosingTime(), hasConfig.getOvertimeWorkingTime(), hasConfig.getOvertimeClosingTime()
                  );
                  if (lap) {
                     List<Long> rosterIds = this.overConfigUserLinkService
                        .list(
                           Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class)
                              .eq(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, hasConfig.getId())
                        )
                        .stream()
                        .map(MesBuildingAttendanceOverConfigUserLink::getRosterId)
                        .collect(Collectors.toList());
                     rosterIds.retainAll(param.getRosterIds());
                     if (CollectionUtils.isNotEmpty(rosterIds)) {
                        List<String> names = this.rosterService.listByIds(rosterIds).stream().map(MesRoster::getName).collect(Collectors.toList());
                        throw new BusinessException(
                           "操作失败！"
                              + names
                              + "加班时间重复为："
                              + hasConfig.getOvertimeWorkingTime().format(formatter)
                              + "~"
                              + hasConfig.getOvertimeClosingTime().format(formatter)
                        );
                     }
                  }
               }
            }
         }
      }
   }

   public boolean hasNoOverlap(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
      start1 = this.removeSeconds(start1);
      end1 = this.removeSeconds(end1);
      start2 = this.removeSeconds(start2);
      end2 = this.removeSeconds(end2);
      return start1.isBefore(end2) && end1.isAfter(start2);
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
