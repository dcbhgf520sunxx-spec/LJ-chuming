package com.hzchum.scim.mes.building.core.biz.impl.attend;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.biz.attend.MesBuildingAttendanceBiz;
import com.hzchum.scim.mes.building.core.api.biz.attend.MesBuildingAttendanceOverConfigBiz;
import com.hzchum.scim.mes.building.core.api.enums.attend.AttendStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockInTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockNumberEnum;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.attend.PointDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendance;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceStandConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.OvertimeClockDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.OvertimeClockDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.attend.MesBuildingAttendanceDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesAttendanceDayDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesAttendanceMonthDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesAttendanceSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesBuildingAttendanceOverConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesBuildingAttendanceStandConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesTodayAttendanceConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.PointDTO;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceStandConfigService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.mes.building.core.mapper.attend.MesBuildingAttendanceMapper;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class MesBuildingAttendanceBizImpl
   extends IBizImpl<MesBuildingAttendanceService, MesBuildingAttendanceMapper, MesBuildingAttendance>
   implements MesBuildingAttendanceBiz {
   @Resource
   private MesRosterService rosterService;
   @Resource
   private MesBuildingAttendanceService attendanceService;
   @Resource
   private MesBuildingAttendanceStandConfigService standConfigService;
   @Resource
   private MesBuildingAttendanceOverConfigBiz overConfigBiz;
   @Resource
   private MesBuildingAttendanceOverConfigService overConfigService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private UserService userService;
   @Resource
   private SupplierService supplierService;

   @Override
   public MesTodayAttendanceConfigDTO getTodayConfig(Boolean hasBaseInfo) {
      MesTodayAttendanceConfigDTO configDTO = new MesTodayAttendanceConfigDTO();
      Long userId = UserUtil.getCurrentUserId();
      LocalDate now = LocalDate.now();
      MesRoster roster = this.rosterService
         .getOne(Wrappers.lambdaQuery(MesRoster.class).eq(MesRoster::getUserId, userId).eq(MesRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType()));
      if (roster != null) {
         MesBuildingAttendance attendance = this.attendanceService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingAttendance.class)
                  .eq(MesBuildingAttendance::getRosterId, roster.getId())
                  .eq(MesBuildingAttendance::getAttendanceDate, now)
            );
         if (attendance != null) {
            BeanUtil.copy(attendance, configDTO);
            Long standConfigId = attendance.getStandConfigId();
            if (standConfigId != null && (hasBaseInfo || !AttendStatusEnum.UNDISTRIBUTED.getType().equals(attendance.getAttendStatus()))) {
               MesBuildingAttendanceStandConfig standConfig = this.standConfigService.getById(standConfigId);
               MesBuildingAttendanceStandConfigDTO standConfigDTO = BeanUtil.copy(standConfig, MesBuildingAttendanceStandConfigDTO.class);
               standConfigDTO.setWeekScopeList(decomposeToPowersOfTwo(standConfig.getWeekScope()));
               configDTO.setStandConfigDTO(standConfigDTO);
            }

            String overConfigIds = attendance.getOverConfigIds();
            List<MesBuildingAttendanceOverConfigDTO> overConfigDTOList = new ArrayList<>();
            List<OvertimeClockDTO> clockList = new ArrayList<>();
            if (StrUtil.isNotBlank(overConfigIds)) {
               List<MesBuildingAttendanceOverConfig> configList = this.overConfigService.getListByIdStr(overConfigIds);
               overConfigDTOList = configList.stream().map(e -> BeanUtil.copy(e, MesBuildingAttendanceOverConfigDTO.class)).collect(Collectors.toList());
               clockList = configList.stream()
                  .map(
                     overConfig -> {
                        List<MesBuildingAttendance> clockRecordList = this.attendanceService
                           .list(
                              Wrappers.lambdaQuery(MesBuildingAttendance.class)
                                 .eq(MesBuildingAttendance::getRosterId, attendance.getRosterId())
                                 .apply("find_in_set({0}, over_config_ids)", overConfig.getId())
                           );
                        Map<Long, LocalDateTime> collect1 = clockRecordList.stream()
                           .map(t -> {
                              List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(t.getOvertimeWorkingTimeJson(), OvertimeClockDO.class);
                              return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
                           })
                           .flatMap(Collection::stream)
                           .filter(y -> y.getId().equals(overConfig.getId()))
                           .collect(Collectors.toMap(OvertimeClockDO::getId, OvertimeClockDO::getOverClockTime));
                        Map<Long, LocalDateTime> collect2 = clockRecordList.stream()
                           .map(t -> {
                              List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(t.getOvertimeClosingTimeJson(), OvertimeClockDO.class);
                              return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
                           })
                           .flatMap(Collection::stream)
                           .filter(y -> y.getId().equals(overConfig.getId()))
                           .collect(Collectors.toMap(OvertimeClockDO::getId, OvertimeClockDO::getOverClockTime));
                        return OvertimeClockDTO.builder()
                           .id(overConfig.getId())
                           .workingTime(collect1.get(overConfig.getId()))
                           .closingTime(collect2.get(overConfig.getId()))
                           .build();
                     }
                  )
                  .collect(Collectors.toList());
            }

            configDTO.setOverConfigDTOList(overConfigDTOList);
            configDTO.setOverClockList(clockList);
         }

         MesBuildingAttendanceStandConfig baseConfig = this.standConfigService
            .getOne(Wrappers.lambdaQuery(MesBuildingAttendanceStandConfig.class).eq(MesBuildingAttendanceStandConfig::getIsBaseConfig, Boolean.TRUE));
         if (StringUtils.isNotBlank(baseConfig.getFenceJson())) {
            List<PointDO> doList = JSON.parseArray(baseConfig.getFenceJson(), PointDO.class);
            List<PointDTO> dtoList = doList.stream().map(pointDO -> {
               String[] split = pointDO.getPoint().split(",");
               return PointDTO.builder().lat(split[1]).sort(pointDO.getSort()).lng(split[0]).build();
            }).collect(Collectors.toList());
            configDTO.setPointDTOList(dtoList);
         }
      }

      return configDTO;
   }

   public static List<Integer> decomposeToPowersOfTwo(int number) {
      List<Integer> powersOfTwo = new ArrayList<>();

      for (int power = 0; number > 0; power++) {
         if ((number & 1) == 1) {
            powersOfTwo.add((int)Math.pow(2.0, power));
         }

         number >>= 1;
      }

      return powersOfTwo;
   }

   @Override
   public boolean saveAttendance(MesBuildingAttendanceDTOParam param) {
      MesTodayAttendanceConfigDTO configDTO = this.getTodayConfig(true);
      Preconditions.checkArgument(configDTO.getId() != null, "操作失败,该人员无需打卡！");
      MesBuildingAttendance attendanceInfo = this.attendanceService.getById(configDTO.getId());
      Preconditions.checkArgument(attendanceInfo != null, "操作失败,该人员无需打卡！");
      Integer clockInType = param.getClockInTypeEnum();
      LocalDateTime attendanceTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
      MesBuildingAttendanceStandConfigDTO standConfigDTO = configDTO.getStandConfigDTO();
      Map<Long, MesBuildingAttendanceOverConfigDTO> configDTOMap = configDTO.getOverConfigDTOList()
         .stream()
         .collect(Collectors.toMap(MesBuildingAttendanceOverConfigDTO::getId, Function.identity()));
      if (ClockTypeEnum.POSIT.getType().equals(standConfigDTO.getClockType())) {
         Preconditions.checkArgument(StringUtils.isNotBlank(param.getPoint()), "操作失败,点位信息不能为空！");
         Preconditions.checkArgument(
            ClockNumberEnum.FOUR.getType().equals(standConfigDTO.getPunchTimes())
               || !ClockInTypeEnum.MORNING_CLOSING.getType().equals(param.getClockInTypeEnum())
                  && !ClockInTypeEnum.AFTERNOON_WORKING.getType().equals(param.getClockInTypeEnum()),
            "打卡类型不正确！"
         );
         if (clockInType.equals(ClockInTypeEnum.MORNING_WORKING.getType())) {
            if (standConfigDTO.getIsSetDelay() && standConfigDTO.getDelayTime() != null) {
               Preconditions.checkArgument(
                  !attendanceTime.isAfter(standConfigDTO.getMorningWorkingTime().plusMinutes(standConfigDTO.getDelayTime().intValue())),
                  "操作失败,配置延迟返岗时间不能超过" + standConfigDTO.getAdvanceTime() + "分钟"
               );
            }

            attendanceInfo.setMorningWorkingTime(attendanceTime);
         }

         if (clockInType.equals(ClockInTypeEnum.MORNING_CLOSING.getType())) {
            if (standConfigDTO.getIsSetAdvance() && standConfigDTO.getAdvanceTime() != null) {
               Preconditions.checkArgument(
                  !attendanceTime.isBefore(standConfigDTO.getMorningClosingTime().minusMinutes(standConfigDTO.getAdvanceTime().intValue())),
                  "操作失败,配置提前离岗时间不能超过" + standConfigDTO.getDelayTime() + "分钟"
               );
            }

            attendanceInfo.setMorningClosingTime(attendanceTime);
         }

         if (clockInType.equals(ClockInTypeEnum.AFTERNOON_WORKING.getType())) {
            if (standConfigDTO.getIsSetDelay() && standConfigDTO.getDelayTime() != null) {
               Preconditions.checkArgument(
                  !attendanceTime.isAfter(standConfigDTO.getAfternoonWorkingTime().plusMinutes(standConfigDTO.getDelayTime().intValue())),
                  "操作失败,配置延迟返岗时间不能超过" + standConfigDTO.getAdvanceTime() + "分钟"
               );
            }

            attendanceInfo.setAfternoonWorkingTime(attendanceTime);
         }

         if (clockInType.equals(ClockInTypeEnum.AFTERNOON_CLOSING.getType())) {
            if (standConfigDTO.getIsSetAdvance() && standConfigDTO.getAdvanceTime() != null) {
               Preconditions.checkArgument(
                  !attendanceTime.isBefore(standConfigDTO.getAfternoonClosingTime().minusMinutes(standConfigDTO.getAdvanceTime().intValue())),
                  "操作失败,配置提前离岗时间不能超过" + standConfigDTO.getDelayTime() + "分钟"
               );
            }

            attendanceInfo.setAfternoonClosingTime(attendanceTime);
         }

         MesBuildingAttendanceOverConfigDTO overConfigDTO = null;
         if (param.getOverConfigId() != null) {
            overConfigDTO = configDTOMap.get(param.getOverConfigId());
         }

         if (overConfigDTO != null) {
            Long overConfigId = overConfigDTO.getId();
            if (clockInType.equals(ClockInTypeEnum.OVERTIME_WORKING.getType())) {
               if (!overConfigDTO.getIsCanDelay()) {
                  Preconditions.checkArgument(!attendanceTime.isAfter(overConfigDTO.getOvertimeWorkingTime()), "操作失败，配置禁止迟到打卡！");
               }

               List<MesBuildingAttendance> beforeAttendanceList = this.attendanceService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingAttendance.class)
                        .eq(MesBuildingAttendance::getRosterId, configDTO.getRosterId())
                        .apply("find_in_set({0}, over_config_ids)", overConfigId)
                  );
               List<OvertimeClockDO> beforeOvertimeClock = beforeAttendanceList.stream().map(e -> {
                  List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(e.getOvertimeWorkingTimeJson(), OvertimeClockDO.class);
                  return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
               }).flatMap(Collection::stream).filter(e -> e.getId().equals(overConfigId)).collect(Collectors.toList());
               Preconditions.checkArgument(beforeOvertimeClock.stream().noneMatch(e -> e.getId().equals(overConfigId)), "本次加班上班已经打卡");
               List<OvertimeClockDO> overtimeClockDOS = JSON.parseArray(attendanceInfo.getOvertimeWorkingTimeJson(), OvertimeClockDO.class);
               OvertimeClockDO build = OvertimeClockDO.builder().id(overConfigId).overClockTime(attendanceTime).build();
               if (CollectionUtils.isEmpty(overtimeClockDOS)) {
                  attendanceInfo.setOvertimeWorkingTimeJson(JSON.toJSONString(Collections.singletonList(build)));
               } else {
                  Preconditions.checkArgument(overtimeClockDOS.stream().noneMatch(e -> e.getId().equals(build.getId())), "本次加班上班已经打卡");
                  overtimeClockDOS.add(build);
                  attendanceInfo.setOvertimeWorkingTimeJson(JSON.toJSONString(overtimeClockDOS));
               }
            }

            if (clockInType.equals(ClockInTypeEnum.OVERTIME_CLOSING.getType())) {
               if (!overConfigDTO.getIsCanDelay()) {
                  Preconditions.checkArgument(!attendanceTime.isBefore(overConfigDTO.getOvertimeClosingTime()), "操作失败，配置禁止早退打卡！");
               }

               List<MesBuildingAttendance> beforeAttendanceList = this.attendanceService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingAttendance.class)
                        .eq(MesBuildingAttendance::getRosterId, configDTO.getRosterId())
                        .apply("find_in_set({0}, over_config_ids)", overConfigId)
                  );
               List<OvertimeClockDO> beforeOvertimeClock = beforeAttendanceList.stream().map(e -> {
                  List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(e.getOvertimeClosingTimeJson(), OvertimeClockDO.class);
                  return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
               }).flatMap(Collection::stream).filter(e -> e.getId().equals(overConfigId)).collect(Collectors.toList());
               Preconditions.checkArgument(beforeOvertimeClock.stream().noneMatch(e -> e.getId().equals(overConfigId)), "本次加班下班班已经打卡");
               List<OvertimeClockDO> overtimeClockDOS = JSON.parseArray(attendanceInfo.getOvertimeClosingTimeJson(), OvertimeClockDO.class);
               OvertimeClockDO build = OvertimeClockDO.builder().id(overConfigId).overClockTime(attendanceTime).build();
               if (CollectionUtils.isEmpty(overtimeClockDOS)) {
                  attendanceInfo.setOvertimeClosingTimeJson(JSON.toJSONString(Collections.singletonList(build)));
               } else {
                  Preconditions.checkArgument(overtimeClockDOS.stream().noneMatch(e -> e.getId().equals(build.getId())), "本次加班下班班已经打卡");
                  overtimeClockDOS.add(build);
                  attendanceInfo.setOvertimeClosingTimeJson(JSON.toJSONString(overtimeClockDOS));
               }
            }

            ArrayList<MesBuildingAttendanceOverConfigDTO> overConfigDTOList = new ArrayList<>(configDTOMap.values());
            List<OvertimeClockDO> overtimeClockDO1 = JSON.parseArray(attendanceInfo.getOvertimeWorkingTimeJson(), OvertimeClockDO.class);
            List<OvertimeClockDO> overtimeClockDO2 = JSON.parseArray(attendanceInfo.getOvertimeClosingTimeJson(), OvertimeClockDO.class);
            if (overtimeClockDO1 == null) {
               overtimeClockDO1 = new ArrayList<>();
            }

            if (overtimeClockDO2 == null) {
               overtimeClockDO2 = new ArrayList<>();
            }

            long count1 = overConfigDTOList.stream().filter(e -> e.getOvertimeWorkingTime().toLocalDate().equals(LocalDate.now())).count();
            long count2 = overConfigDTOList.stream().filter(e -> e.getOvertimeClosingTime().toLocalDate().equals(LocalDate.now())).count();
            if (CollectionUtils.isEmpty(overtimeClockDO1) && CollectionUtils.isEmpty(overtimeClockDO2)) {
               attendanceInfo.setOverStatus(AttendStatusEnum.ABSENTEE.getType());
            } else if (overtimeClockDO1.size() == count1 && overtimeClockDO2.size() == count2) {
               attendanceInfo.setOverStatus(AttendStatusEnum.NORMAL.getType());
            } else {
               attendanceInfo.setOverStatus(AttendStatusEnum.ABSENCE.getType());
            }
         } else {
            Preconditions.checkArgument(
               !ClockInTypeEnum.OVERTIME_WORKING.getType().equals(param.getClockInTypeEnum())
                  && !ClockInTypeEnum.OVERTIME_CLOSING.getType().equals(param.getClockInTypeEnum()),
               "打卡类型不正确！"
            );
            if (ClockNumberEnum.TWICE.getType().equals(standConfigDTO.getPunchTimes())) {
               attendanceInfo.setAttendStatus(this.getAttendStatus(attendanceInfo.getMorningWorkingTime(), attendanceInfo.getAfternoonClosingTime()));
            } else {
               attendanceInfo.setAttendStatus(
                  this.getAttendStatus(
                     attendanceInfo.getMorningWorkingTime(),
                     attendanceInfo.getMorningClosingTime(),
                     attendanceInfo.getAfternoonWorkingTime(),
                     attendanceInfo.getAfternoonClosingTime()
                  )
               );
            }
         }

         if (org.apache.commons.lang3.StringUtils.isBlank(attendanceInfo.getPoint())) {
            attendanceInfo.setPoint(param.getPoint());
         } else {
            List<String> pintList = Arrays.stream(attendanceInfo.getPoint().split(";")).collect(Collectors.toList());
            pintList.add(param.getPoint());
            attendanceInfo.setPoint(org.apache.commons.lang3.StringUtils.join(pintList, ";"));
         }

         this.baseService.updateById(attendanceInfo);
      }

      if (ClockTypeEnum.FACE.getType().equals(standConfigDTO.getClockType())) {
         throw new BusinessException("暂不支持人脸识别打卡");
      } else {
         return true;
      }
   }

   @Override
   public PageVO<MesAttendanceDayDetailsDTO> getAttendanceDayDetails(
      Long deptId, String wokeType, String name, LocalDate startDate, LocalDate endDate, Boolean isStand, Integer pageNumber, Integer pageSize
   ) {
      List<Long> userIds = new ArrayList<>();
      if (deptId != null) {
         userIds = this.userService
            .list(Wrappers.lambdaQuery(User.class).eq(User::getDepartmentId, deptId))
            .stream()
            .map(User::getId)
            .collect(Collectors.toList());
      }

      LambdaQueryWrapper<MesBuildingAttendance> queryWrapper = Wrappers.lambdaQuery(MesBuildingAttendance.class)
         .in(deptId != null && CollectionUtils.isNotEmpty(userIds), MesBuildingAttendance::getUserId, userIds)
         .eq(StringUtils.isNotBlank(wokeType), MesBuildingAttendance::getWorkType, wokeType)
         .like(StringUtils.isNotBlank(name), MesBuildingAttendance::getName, name)
         .apply(startDate != null, "date_format(attendance_date, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", startDate)
         .apply(endDate != null, "date_format(attendance_date, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", endDate)
         .orderByDesc(MesBuildingAttendance::getAttendanceDate)
         .orderByDesc(MesBuildingAttendance::getAttendStatus)
         .orderByDesc(MesBuildingAttendance::getOverStatus)
         .orderByDesc(MesBuildingAttendance::getId);
      if (isStand != null && isStand) {
         queryWrapper.ne(MesBuildingAttendance::getAttendStatus, AttendStatusEnum.UNDISTRIBUTED.getType());
      }

      if (isStand != null && !isStand) {
         queryWrapper.ne(MesBuildingAttendance::getOverStatus, AttendStatusEnum.UNDISTRIBUTED.getType());
      }

      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingAttendance> attendanceList = this.baseService.list(queryWrapper);
      return new PageVO<>(page, this.convertToDayDetailsDTO(attendanceList));
   }

   @Override
   public void getAttendanceDayDetailsDownload(Long deptId, String workType, String name, LocalDate startDate, LocalDate endDate, Boolean isStand) {
      List<Long> userIds = new ArrayList<>();
      if (deptId != null) {
         userIds = this.userService
            .list(Wrappers.lambdaQuery(User.class).eq(User::getDepartmentId, deptId))
            .stream()
            .map(User::getId)
            .collect(Collectors.toList());
      }

      LambdaQueryWrapper<MesBuildingAttendance> queryWrapper = Wrappers.lambdaQuery(MesBuildingAttendance.class)
         .in(deptId != null && CollectionUtils.isNotEmpty(userIds), MesBuildingAttendance::getUserId, userIds)
         .eq(StringUtils.isNotBlank(workType), MesBuildingAttendance::getWorkType, workType)
         .like(StringUtils.isNotBlank(name), MesBuildingAttendance::getName, name)
         .apply(startDate != null, "date_format(attendance_date, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", startDate)
         .apply(endDate != null, "date_format(attendance_date, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", endDate)
         .orderByDesc(MesBuildingAttendance::getAttendanceDate)
         .orderByDesc(MesBuildingAttendance::getAttendStatus)
         .orderByDesc(MesBuildingAttendance::getOverStatus)
         .orderByDesc(MesBuildingAttendance::getId);
      if (isStand != null && isStand) {
         queryWrapper.ne(MesBuildingAttendance::getAttendStatus, AttendStatusEnum.UNDISTRIBUTED.getType());
      }

      if (isStand != null && !isStand) {
         queryWrapper.ne(MesBuildingAttendance::getOverStatus, AttendStatusEnum.UNDISTRIBUTED.getType());
      }

      List<MesBuildingAttendance> attendanceList = this.baseService.list(queryWrapper);
      List<MesAttendanceDayDetailsDTO> dtoList = this.convertToDayDetailsDTO(attendanceList);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      dtoList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setRosterId(orderNo.get());
         e.setDateStr(e.getAttendanceDate().toString() + " " + this.getDayOfWeekString(e.getAttendanceDate()));
         StringBuilder b1 = new StringBuilder();
         StringBuilder b2 = new StringBuilder();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

         for (MesBuildingAttendanceOverConfigDTO configDTO : e.getOverClockDTOList()) {
            if (configDTO.getWorkingTime() != null) {
               b1.append(configDTO.getWorkingTime().format(formatter));
            } else {
               b1.append("-");
            }

            b1.append("\n");
            if (configDTO.getClosingTime() != null) {
               b2.append(configDTO.getClosingTime().format(formatter));
            } else {
               b2.append("-");
            }

            b2.append("\n");
         }

         e.setWorkingStr(b1.toString());
         e.setClosingStr(b2.toString());
      });
      HashMap<String, Object> result = new HashMap<>();
      result.put("resultList", dtoList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/MesAttendanceDayDetails.xlsx";
      String exportFileName = "工厂考勤信息.xlsx";
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      assert servletRequestAttributes != null;
      HttpServletResponse response = servletRequestAttributes.getResponse();
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, result, response);
   }

   @Override
   public List<MesAttendanceSummaryDTO> getAttendanceSummary(LocalDate monthDate, Long supplierId) {
      return this.baseMapper.getAttendanceSummary(monthDate, supplierId);
   }

   @Override
   public PageVO<MesAttendanceDayDetailsDTO> getCardDetails(LocalDate dayDate, Long supplierId, Boolean isStand, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      LambdaQueryWrapper<MesBuildingAttendance> queryWrapper = Wrappers.lambdaQuery(MesBuildingAttendance.class)
         .eq(dayDate != null, MesBuildingAttendance::getAttendanceDate, dayDate)
         .eq(supplierId != null, MesBuildingAttendance::getSupplierId, supplierId)
         .orderByDesc(MesBuildingAttendance::getAttendanceDate)
         .orderByDesc(MesBuildingAttendance::getAttendStatus)
         .orderByDesc(MesBuildingAttendance::getOverStatus)
         .orderByDesc(MesBuildingAttendance::getId);
      if (isStand != null && isStand) {
         queryWrapper.ne(MesBuildingAttendance::getAttendStatus, AttendStatusEnum.UNDISTRIBUTED.getType());
      }

      if (isStand != null && !isStand) {
         queryWrapper.ne(MesBuildingAttendance::getOverStatus, AttendStatusEnum.UNDISTRIBUTED.getType());
      }

      List<MesBuildingAttendance> attendanceList = this.baseService.list(queryWrapper);
      return new PageVO<>(page, this.convertToDayDetailsDTO(attendanceList));
   }

   @Override
   public void getCardDetailsDownload(LocalDate dayDate, Long supplierId, Boolean isStand) {
      LambdaQueryWrapper<MesBuildingAttendance> queryWrapper = Wrappers.lambdaQuery(MesBuildingAttendance.class)
         .eq(dayDate != null, MesBuildingAttendance::getAttendanceDate, dayDate)
         .eq(supplierId != null, MesBuildingAttendance::getSupplierId, supplierId)
         .orderByDesc(MesBuildingAttendance::getAttendanceDate)
         .orderByDesc(MesBuildingAttendance::getAttendStatus)
         .orderByDesc(MesBuildingAttendance::getOverStatus)
         .orderByDesc(MesBuildingAttendance::getId);
      if (isStand) {
         queryWrapper.ne(MesBuildingAttendance::getAttendStatus, AttendStatusEnum.UNDISTRIBUTED.getType());
      }

      if (!isStand) {
         queryWrapper.ne(MesBuildingAttendance::getOverStatus, AttendStatusEnum.UNDISTRIBUTED.getType());
      }

      List<MesBuildingAttendance> attendanceList = this.baseService.list(queryWrapper);
      List<MesAttendanceDayDetailsDTO> dtoList = this.convertToDayDetailsDTO(attendanceList);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      dtoList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setRosterId(orderNo.get());
         e.setDateStr(e.getAttendanceDate().toString() + " " + this.getDayOfWeekString(e.getAttendanceDate()));
         StringBuilder b1 = new StringBuilder();
         StringBuilder b2 = new StringBuilder();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

         for (MesBuildingAttendanceOverConfigDTO configDTO : e.getOverClockDTOList()) {
            if (configDTO.getWorkingTime() != null) {
               b1.append(configDTO.getWorkingTime().format(formatter));
            } else {
               b1.append("-");
            }

            b1.append("\n");
            if (configDTO.getClosingTime() != null) {
               b2.append(configDTO.getClosingTime().format(formatter));
            } else {
               b2.append("-");
            }

            b2.append("\n");
         }

         e.setWorkingStr(b1.toString());
         e.setClosingStr(b2.toString());
      });
      HashMap<String, Object> result = new HashMap<>();
      result.put("resultList", dtoList);
      String tempFileName = "ResourcePlan";
      String resourcePath = isStand ? "files/MesAttendanceCardDetails1.xlsx" : "files/MesAttendanceCardDetails2.xlsx";
      String exportFileName = "工厂考勤信息.xlsx";
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      assert servletRequestAttributes != null;
      HttpServletResponse response = servletRequestAttributes.getResponse();
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, result, response);
   }

   @Override
   public HashMap<String, Integer> getUserAttendanceSummary() {
      Long currentUserId = UserUtil.getCurrentUserId();
      MesRoster roster = this.rosterService
         .getOne(Wrappers.lambdaQuery(MesRoster.class).eq(MesRoster::getUserId, currentUserId).eq(MesRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType()));
      return roster == null ? new HashMap<>() : this.baseMapper.getUserAttendanceSummary(roster.getId());
   }

   @Override
   public List<MesAttendanceDayDetailsDTO> getUserAttendanceDayDetails(LocalDate monthDate) {
      Long currentUserId = UserUtil.getCurrentUserId();
      MesRoster roster = this.rosterService
         .getOne(Wrappers.lambdaQuery(MesRoster.class).eq(MesRoster::getUserId, currentUserId).eq(MesRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType()));
      if (roster == null) {
         return new ArrayList<>();
      }

      List<MesBuildingAttendance> attendanceList = this.baseService
         .list(
            Wrappers.lambdaQuery(MesBuildingAttendance.class)
               .eq(MesBuildingAttendance::getRosterId, roster.getId())
               .and(
                  qw -> {
                     LambdaQueryWrapper var10000 = qw.in(
                           MesBuildingAttendance::getAttendStatus, Arrays.asList(AttendStatusEnum.ABSENCE.getType(), AttendStatusEnum.NORMAL.getType())
                        )
                        .or()
                        .in(MesBuildingAttendance::getOverStatus, Arrays.asList(AttendStatusEnum.ABSENCE.getType(), AttendStatusEnum.NORMAL.getType()));
                  }
               )
               .apply("date_format(attendance_date, '%Y-%m') = date_format({0}, '%Y-%m')", monthDate)
               .orderByDesc(MesBuildingAttendance::getAttendanceDate)
               .orderByAsc(MesBuildingAttendance::getAttendStatus)
         );
      return this.convertToDayDetailsDTO(attendanceList);
   }

   @Override
   public PageVO<MesAttendanceMonthDetailsDTO> getAttendanceMonthDetails(LocalDate monthDate, Integer pageNumber, Integer pageSize) {
      return PageUtil.listPage(pageNumber, pageSize, this.getAttendanceMonthDetailsList(monthDate));
   }

   @Override
   public void getAttendanceMonthDetailsDownload(LocalDate monthDate) {
      List<MesAttendanceMonthDetailsDTO> monthDetailsList = this.getAttendanceMonthDetailsList(monthDate);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      monthDetailsList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setRosterId(orderNo.get());
      });
      HashMap<String, Object> result = new HashMap<>();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      result.put("monthDate", monthDate != null ? monthDate.format(formatter) : "-");
      result.put("resultList", monthDetailsList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/MesAttendanceMonthDetails.xlsx";
      String exportFileName = "花名册月考勤信息.xlsx";
      this.download(result, tempFileName, resourcePath, exportFileName);
   }

   @NotNull
   private ArrayList<MesAttendanceMonthDetailsDTO> getAttendanceMonthDetailsList(LocalDate monthDate) {
      List<MesBuildingAttendance> attendanceList = this.baseService
         .list(
            Wrappers.lambdaQuery(MesBuildingAttendance.class)
               .ne(MesBuildingAttendance::getAttendanceDate, LocalDate.now())
               .apply("date_format(attendance_date, '%Y-%m') = date_format({0}, '%Y-%m')", monthDate)
         );
      if (CollectionUtils.isEmpty(attendanceList)) {
         return new ArrayList<>();
      }

      List<MesAttendanceDayDetailsDTO> dayDetailsDTOList = this.convertToDayDetailsDTO(attendanceList);
      Map<Long, List<MesAttendanceDayDetailsDTO>> attendanceMap = dayDetailsDTOList.stream()
         .collect(Collectors.groupingBy(MesAttendanceDayDetailsDTO::getRosterId));
      List<Long> rosterIds = attendanceList.stream().map(MesBuildingAttendance::getRosterId).distinct().collect(Collectors.toList());
      Map<Long, MesRoster> rosterMap = this.rosterService.listByIds(rosterIds).stream().collect(Collectors.toMap(MesRoster::getId, Function.identity()));
      ArrayList<MesAttendanceMonthDetailsDTO> detailsList = new ArrayList<>();
      attendanceMap.forEach(
         (rosterId, list1) -> {
            if (rosterMap.containsKey(rosterId)) {
               MesRoster roster = rosterMap.get(rosterId);
               Supplier supplier = this.supplierService.getById(roster.getSupplierId());
               MesAttendanceMonthDetailsDTO detailsDTO = new MesAttendanceMonthDetailsDTO();
               detailsDTO.setRosterId(rosterId);
               detailsDTO.setUserName(roster.getName());
               detailsDTO.setIdCard(roster.getIdNumber());
               if (supplier != null) {
                  detailsDTO.setSupplierName(supplier.getName());
               }

               long count0 = list1.stream()
                  .filter(e -> AttendStatusEnum.ABSENTEE.getType().equals(e.getAttendStatus()) || AttendStatusEnum.ABSENTEE.getType().equals(e.getOverStatus()))
                  .count();
               long count1 = list1.stream()
                  .filter(
                     e -> e.getAttendStatus() != null && e.getAttendStatus() > AttendStatusEnum.ABSENTEE.getType()
                        || e.getOverStatus() != null && e.getOverStatus() > AttendStatusEnum.ABSENTEE.getType()
                  )
                  .count();
               BigDecimal count2 = list1.stream().map(MesAttendanceDayDetailsDTO::getActualHours).reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal count3 = list1.stream().map(MesAttendanceDayDetailsDTO::getOverHours).reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal count4 = list1.stream().map(MesAttendanceDayDetailsDTO::getAbsenceHours).reduce(BigDecimal.ZERO, BigDecimal::add);
               detailsDTO.setClockNumber(count1);
               detailsDTO.setWorkHours(count2.add(count3));
               detailsDTO.setBaseHours(count2);
               detailsDTO.setOverHours(count3);
               detailsDTO.setAbsenceHours(count4);
               detailsDTO.setAbsenceNumber(count0);
               detailsList.add(detailsDTO);
            }
         }
      );
      return detailsList;
   }

   private List<MesAttendanceDayDetailsDTO> convertToDayDetailsDTO(List<MesBuildingAttendance> attendanceList) {
      if (CollectionUtils.isEmpty(attendanceList)) {
         return new ArrayList<>();
      }

      List<Long> standConfigIds = attendanceList.stream().map(MesBuildingAttendance::getStandConfigId).distinct().collect(Collectors.toList());
      Map<Long, MesBuildingAttendanceStandConfig> standConfigMap = this.standConfigService
         .listByIds(standConfigIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingAttendanceStandConfig::getId, Function.identity()));
      Map<Long, String> deptNameMap = this.overConfigBiz
         .getRosterDepartmentList()
         .stream()
         .collect(Collectors.toMap(DepartmentDTO::getId, DepartmentDTO::getName));
      List<Long> userIds = attendanceList.stream().map(MesBuildingAttendance::getUserId).collect(Collectors.toList());
      Map<Long, Long> userDeptMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getDepartmentId));
      Map<String, String> wokeNameMap = this.dictionaryService
         .listByName(DictionaryEnum.WORK_TYPE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getValue, SysDictionary::getLabel));
      return attendanceList.stream()
         .map(
            attendance -> {
               MesAttendanceDayDetailsDTO detailsDTO = BeanUtil.copy(attendance, MesAttendanceDayDetailsDTO.class);
               if (attendance.getSupplierId() != null) {
                  Supplier supplier = this.supplierService.getById(attendance.getSupplierId());
                  if (supplier != null) {
                     detailsDTO.setSupplierName(supplier.getName());
                  }
               }

               if (userDeptMap.containsKey(attendance.getUserId())) {
                  detailsDTO.setDeptName(deptNameMap.getOrDefault(userDeptMap.get(attendance.getUserId()), null));
                  Map<Long, String> nameMap = this.overConfigBiz
                     .getRosterByDepartment(userDeptMap.get(attendance.getUserId()))
                     .stream()
                     .collect(Collectors.toMap(IdAndNameDTO::getId, IdAndNameDTO::getName));
                  if (nameMap.containsKey(attendance.getRosterId())) {
                     detailsDTO.setName(nameMap.get(attendance.getRosterId()));
                  }
               }

               detailsDTO.setWokeName(wokeNameMap.getOrDefault(attendance.getWorkType(), null));
               BigDecimal workHours = BigDecimal.ZERO;
               BigDecimal actualHours = BigDecimal.ZERO;
               BigDecimal absenceHours = BigDecimal.ZERO;
               if (attendance.getStandConfigId() != null) {
                  MesBuildingAttendanceStandConfig standConfig = standConfigMap.get(attendance.getStandConfigId());
                  if (ClockNumberEnum.TWICE.getType().equals(standConfig.getPunchTimes())) {
                     workHours = this.getStandardHour(standConfig.getMorningWorkingTime(), standConfig.getMorningClosingTime());
                     BigDecimal hours1 = BigDecimal.ZERO;
                     if (attendance.getMorningWorkingTime() != null && attendance.getAfternoonClosingTime() != null) {
                        if (this.hasEffectiveWokeTime(
                           attendance.getMorningWorkingTime(),
                           attendance.getAfternoonClosingTime(),
                           standConfig.getMorningWorkingTime(),
                           standConfig.getAfternoonClosingTime()
                        )) {
                           LocalDateTime minDateTime1 = this.getMaxDateTime(attendance.getMorningWorkingTime(), standConfig.getMorningWorkingTime());
                           LocalDateTime minDateTime2 = this.getMinDateTime(attendance.getAfternoonClosingTime(), standConfig.getAfternoonClosingTime());
                           hours1 = this.getStandardHour(minDateTime1, minDateTime2);
                           if (hours1.compareTo(workHours) < 0) {
                              absenceHours = workHours.subtract(hours1).add(absenceHours);
                           }
                        } else {
                           absenceHours = absenceHours.add(workHours);
                        }
                     } else {
                        absenceHours = absenceHours.add(workHours);
                     }

                     actualHours = hours1;
                     detailsDTO.setMorningHours(hours1);
                  }

                  if (ClockNumberEnum.FOUR.getType().equals(standConfig.getPunchTimes())) {
                     BigDecimal workHours1 = this.getStandardHour(standConfig.getMorningWorkingTime(), standConfig.getMorningClosingTime());
                     BigDecimal workHours2 = this.getStandardHour(standConfig.getAfternoonWorkingTime(), standConfig.getAfternoonClosingTime());
                     workHours = workHours1.add(workHours2);
                     BigDecimal hours1 = BigDecimal.ZERO;
                     BigDecimal hours2 = BigDecimal.ZERO;
                     if (attendance.getMorningWorkingTime() != null && attendance.getMorningClosingTime() != null) {
                        if (this.hasEffectiveWokeTime(
                           attendance.getMorningWorkingTime(),
                           attendance.getMorningClosingTime(),
                           standConfig.getMorningWorkingTime(),
                           standConfig.getMorningClosingTime()
                        )) {
                           LocalDateTime minDateTime1 = this.getMaxDateTime(attendance.getMorningWorkingTime(), standConfig.getMorningWorkingTime());
                           LocalDateTime minDateTime2 = this.getMinDateTime(attendance.getMorningClosingTime(), standConfig.getMorningClosingTime());
                           hours1 = this.getStandardHour(minDateTime1, minDateTime2);
                           if (hours1.compareTo(workHours1) < 0) {
                              absenceHours = workHours1.subtract(hours1).add(absenceHours);
                           }
                        } else {
                           absenceHours = absenceHours.add(workHours1);
                        }
                     } else {
                        absenceHours = absenceHours.add(workHours1);
                     }

                     if (attendance.getAfternoonWorkingTime() != null && attendance.getAfternoonClosingTime() != null) {
                        if (this.hasEffectiveWokeTime(
                           attendance.getAfternoonWorkingTime(),
                           attendance.getAfternoonClosingTime(),
                           standConfig.getAfternoonWorkingTime(),
                           standConfig.getAfternoonClosingTime()
                        )) {
                           LocalDateTime minDateTime1 = this.getMaxDateTime(attendance.getAfternoonWorkingTime(), standConfig.getAfternoonWorkingTime());
                           LocalDateTime minDateTime2 = this.getMinDateTime(attendance.getAfternoonClosingTime(), standConfig.getAfternoonClosingTime());
                           hours2 = this.getStandardHour(minDateTime1, minDateTime2);
                           if (hours2.compareTo(workHours2) < 0) {
                              absenceHours = workHours2.subtract(hours2).add(absenceHours);
                           }
                        } else {
                           absenceHours = absenceHours.add(workHours2);
                        }
                     } else {
                        absenceHours = absenceHours.add(workHours2);
                     }

                     actualHours = hours1.add(hours2);
                     detailsDTO.setMorningHours(hours1);
                     detailsDTO.setAfternoonHours(hours2);
                  }
               }

               detailsDTO.setWorkHours(workHours);
               detailsDTO.setActualHours(actualHours);
               BigDecimal hours1 = BigDecimal.ZERO;
               List<MesBuildingAttendanceOverConfigDTO> overClockDTOList = new ArrayList<>();
               if (attendance.getOverConfigIds() != null) {
                  List<OvertimeClockDTO> clockList = new ArrayList<>();
                  List<MesBuildingAttendanceOverConfig> overConfigList = this.overConfigService.getListByIdStr(attendance.getOverConfigIds());
                  overConfigList.stream()
                     .forEach(
                        overConfigx -> {
                           List<MesBuildingAttendance> clockRecordList = this.attendanceService
                              .list(
                                 Wrappers.lambdaQuery(MesBuildingAttendance.class)
                                    .eq(MesBuildingAttendance::getRosterId, attendance.getRosterId())
                                    .apply("find_in_set({0}, over_config_ids)", overConfigx.getId())
                              );
                           Map<Long, LocalDateTime> collect1 = clockRecordList.stream()
                              .map(t -> {
                                 List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(t.getOvertimeWorkingTimeJson(), OvertimeClockDO.class);
                                 return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
                              })
                              .flatMap(Collection::stream)
                              .filter(y -> y.getId().equals(overConfigx.getId()))
                              .collect(Collectors.toMap(OvertimeClockDO::getId, OvertimeClockDO::getOverClockTime));
                           Map<Long, LocalDateTime> collect2 = clockRecordList.stream()
                              .map(t -> {
                                 List<OvertimeClockDO> beforeOvertimeClockDOS = JSON.parseArray(t.getOvertimeClosingTimeJson(), OvertimeClockDO.class);
                                 return CollectionUtils.isEmpty(beforeOvertimeClockDOS) ? new ArrayList<OvertimeClockDO>() : beforeOvertimeClockDOS;
                              })
                              .flatMap(Collection::stream)
                              .filter(y -> y.getId().equals(overConfigx.getId()))
                              .collect(Collectors.toMap(OvertimeClockDO::getId, OvertimeClockDO::getOverClockTime));
                           OvertimeClockDTO build = OvertimeClockDTO.builder()
                              .id(overConfigx.getId())
                              .workingTime(collect1.get(overConfigx.getId()))
                              .closingTime(collect2.get(overConfigx.getId()))
                              .build();
                           clockList.add(build);
                           if (collect1.containsKey(overConfigx.getId()) || collect2.containsKey(overConfigx.getId())) {
                              MesBuildingAttendanceOverConfigDTO copy = BeanUtil.copy(overConfigx, MesBuildingAttendanceOverConfigDTO.class);
                              if (collect1.containsKey(overConfigx.getId())) {
                                 copy.setWorkingTime(
                                    collect1.get(overConfigx.getId()).toLocalDate().isEqual(attendance.getAttendanceDate())
                                       ? collect1.get(overConfigx.getId())
                                       : null
                                 );
                              }

                              if (collect2.containsKey(overConfigx.getId())) {
                                 copy.setClosingTime(
                                    collect2.get(overConfigx.getId()).toLocalDate().isEqual(attendance.getAttendanceDate())
                                       ? collect2.get(overConfigx.getId())
                                       : null
                                 );
                              }

                              overClockDTOList.add(copy);
                           }
                        }
                     );
                  Map<Long, MesBuildingAttendanceOverConfig> configMap = overConfigList.stream()
                     .collect(Collectors.toMap(MesBuildingAttendanceOverConfig::getId, Function.identity()));
                  BigDecimal overWorkHours = BigDecimal.ZERO;

                  for (OvertimeClockDTO clockDTO : clockList) {
                     MesBuildingAttendanceOverConfig overConfig = configMap.get(clockDTO.getId());
                     LocalDateTime overTime1 = this.getMaxDateTime(
                        overConfig.getOvertimeWorkingTime(), LocalDateTime.of(attendance.getAttendanceDate(), LocalTime.of(0, 0, 0))
                     );
                     LocalDateTime overTime2 = this.getMinDateTime(
                        overConfig.getOvertimeClosingTime(), LocalDateTime.of(attendance.getAttendanceDate(), LocalTime.of(23, 59, 59))
                     );
                     BigDecimal standardHour = this.getStandardHour(overTime1, overTime2);
                     overWorkHours = overWorkHours.add(standardHour);
                     if (clockDTO.getWorkingTime() != null && clockDTO.getClosingTime() != null) {
                        if (this.hasEffectiveWokeTime(clockDTO.getWorkingTime(), clockDTO.getClosingTime(), overTime1, overTime2)) {
                           LocalDateTime minDateTime1 = this.getMaxDateTime(clockDTO.getWorkingTime(), overTime1);
                           LocalDateTime minDateTime2 = this.getMinDateTime(clockDTO.getClosingTime(), overTime2);
                           hours1 = hours1.add(this.getStandardHour(minDateTime1, minDateTime2));
                           if (hours1.compareTo(standardHour) < 0) {
                              absenceHours = standardHour.subtract(hours1).add(absenceHours);
                           }
                        } else {
                           absenceHours = absenceHours.add(standardHour);
                        }
                     } else {
                        absenceHours = absenceHours.add(standardHour);
                     }
                  }

                  detailsDTO.setOverWorkHours(overWorkHours);
               }

               detailsDTO.setOverClockDTOList(overClockDTOList);
               detailsDTO.setOverHours(hours1);
               detailsDTO.setTotalHours(hours1.add(detailsDTO.getActualHours()));
               detailsDTO.setAbsenceHours(absenceHours);
               return detailsDTO;
            }
         )
         .collect(Collectors.toList());
   }

   private void download(HashMap<String, Object> result, String tempFileName, String resourcePath, String exportFileName) {
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      assert servletRequestAttributes != null;
      HttpServletResponse response = servletRequestAttributes.getResponse();
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, result);
      this.exportExcel(exportFileName, response, workbook);
   }

   public void exportExcel(String fileName, HttpServletResponse response, Workbook workbook) {
      List<Integer> sheets = Collections.singletonList(0);
      CellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
      cellStyle.setAlignment(HorizontalAlignment.CENTER);
      cellStyle.setBorderBottom(BorderStyle.THIN);
      cellStyle.setBorderTop(BorderStyle.THIN);
      cellStyle.setBorderLeft(BorderStyle.THIN);
      cellStyle.setBorderRight(BorderStyle.THIN);
      cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
      cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

      for (Integer sheet : sheets) {
         Sheet sheetAt = workbook.getSheetAt(sheet == null ? 0 : sheet);
         if (sheetAt != null) {
            for (int i = 0; i <= sheetAt.getPhysicalNumberOfRows(); i++) {
               Row row = sheetAt.getRow(i);
               if (row != null) {
                  for (Cell cell : row) {
                     CellType cellType = cell.getCellType();
                     if (CellType.STRING.getCode() == cellType.getCode()
                        && NumberUtils.isNumber(cell.getStringCellValue())
                        && cell.getStringCellValue().matches("^(-?\\d+)(\\.\\d+)?$")
                        && !cell.getStringCellValue().contains("%")
                        && !IdcardUtil.isValidCard(cell.getStringCellValue())) {
                        cell.setCellType(CellType.STRING);
                        String stringCellValue = cell.getStringCellValue();
                        String[] split = stringCellValue.split("\\.");
                        if (split.length > 1) {
                           cell.setCellValue(Double.parseDouble(stringCellValue));
                           cellStyle.setDataFormat((short)BuiltinFormats.getBuiltinFormat("0.00000000_ "));
                        } else if (new BigInteger(stringCellValue).compareTo(BigInteger.valueOf(2147483647L)) <= 0
                           && new BigInteger(stringCellValue).compareTo(BigInteger.valueOf(-2147483648L)) >= 0) {
                           cell.setCellValue(Integer.parseInt(stringCellValue));
                           cellStyle.setDataFormat((short)BuiltinFormats.getBuiltinFormat("0_ "));
                        }

                        Font font = workbook.createFont();
                        font.setFontName("宋体");
                        font.setFontHeightInPoints((short)10);
                        cellStyle.setFont(font);
                        cell.setCellStyle(cellStyle);
                     }

                     cell.setCellStyle(cellStyle);
                  }
               }
            }
         }
      }

      try {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         workbook.write(response.getOutputStream());
      } catch (IOException e) {
         throw new BusinessException(e.getMessage());
      }
   }

   private Integer getAttendStatus(LocalDateTime... times) {
      if (Arrays.stream(times).allMatch(Objects::nonNull)) {
         return AttendStatusEnum.NORMAL.getType();
      } else {
         return Arrays.stream(times).noneMatch(Objects::nonNull) ? AttendStatusEnum.ABSENTEE.getType() : AttendStatusEnum.ABSENCE.getType();
      }
   }

   private String getDayOfWeekString(LocalDate date) {
      DayOfWeek dayOfWeek = date.getDayOfWeek();
      String weekDay;
      switch (dayOfWeek) {
         case MONDAY:
            weekDay = "星期一";
            break;
         case TUESDAY:
            weekDay = "星期二";
            break;
         case WEDNESDAY:
            weekDay = "星期三";
            break;
         case THURSDAY:
            weekDay = "星期四";
            break;
         case FRIDAY:
            weekDay = "星期五";
            break;
         case SATURDAY:
            weekDay = "星期六";
            break;
         case SUNDAY:
            weekDay = "星期天";
            break;
         default:
            weekDay = "未知";
      }

      return weekDay;
   }

   private LocalDateTime getMinDateTime(LocalDateTime dt1, LocalDateTime dt2) {
      return dt1.isBefore(dt2) ? dt1 : dt2;
   }

   private LocalDateTime getMaxDateTime(LocalDateTime dt1, LocalDateTime dt2) {
      return dt1.isBefore(dt2) ? dt2 : dt1;
   }

   private BigDecimal getStandardHour(LocalDateTime t1, LocalDateTime t2) {
      if (t1 != null && t2 != null) {
         Duration duration = Duration.between(t1, t2);
         return BigDecimal.valueOf(duration.toMillis()).divide(BigDecimal.valueOf(3600000L), 2, RoundingMode.HALF_UP);
      } else {
         return BigDecimal.ZERO;
      }
   }

   private boolean hasEffectiveWokeTime(LocalDateTime w1, LocalDateTime w2, LocalDateTime start, LocalDateTime end) {
      return !this.isBeforeOrEqual(w2, start) && !this.isAfterOrEqual(w1, end);
   }

   private boolean isBeforeOrEqual(LocalDateTime time1, LocalDateTime time2) {
      return time1.isBefore(time2) || time1.isEqual(time2);
   }

   private boolean isAfterOrEqual(LocalDateTime time1, LocalDateTime time2) {
      return time1.isAfter(time2) || time1.isEqual(time2);
   }
}
