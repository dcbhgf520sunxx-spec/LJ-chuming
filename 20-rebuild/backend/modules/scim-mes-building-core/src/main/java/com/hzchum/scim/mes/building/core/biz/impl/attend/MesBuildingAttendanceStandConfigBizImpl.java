package com.hzchum.scim.mes.building.core.biz.impl.attend;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.attend.MesBuildingAttendanceOverConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.attend.MesBuildingAttendanceStandConfigBiz;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockNumberEnum;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.attend.WeekScopeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.attend.PointDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceStandConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.attend.MesBuildingAttendanceStandConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesBuildingAttendanceStandConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.PointDTO;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceStandConfigService;
import com.hzchum.scim.mes.building.core.mapper.attend.MesBuildingAttendanceStandConfigMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingAttendanceStandConfigBizImpl
   extends IBizImpl<MesBuildingAttendanceStandConfigService, MesBuildingAttendanceStandConfigMapper, MesBuildingAttendanceStandConfig>
   implements MesBuildingAttendanceStandConfigBiz {
   @Resource
   private MesBuildingAttendanceStandConfigService standConfigService;
   @Resource
   private MesBuildingAttendanceOverConfigBiz overConfigBiz;

   @Transactional
   @Override
   public boolean editStandConfig(MesBuildingAttendanceStandConfigDTOParam param) {
      this.checkParam(param);
      if (param.getId() == null) {
         MesBuildingAttendanceStandConfig baseConfig = BeanUtil.copy(param, MesBuildingAttendanceStandConfig.class);
         baseConfig.setIsBaseConfig(Boolean.TRUE);
         if (CollectionUtils.isNotEmpty(param.getPoints())) {
            baseConfig.setFenceJson(JSON.toJSONString(param.getPoints()));
         }

         this.standConfigService.save(baseConfig);
         this.standConfigService.generateAttendanceTask();
      } else {
         MesBuildingAttendanceStandConfig baseConfig = this.getById(param.getId());
         if (!baseConfig.getWeekScope().equals(param.getWeekScope())) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");
            List<MesBuildingAttendanceOverConfig> overConfigList = this.overConfigBiz.list(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfig.class));
            overConfigList.forEach(
               e -> {
                  for (LocalDate attendanceDate : this.getDateRange(e.getOvertimeWorkingTime(), e.getOvertimeClosingTime())) {
                     if ((param.getWeekScope() & WeekScopeEnum.getToDayType(attendanceDate)) > 0) {
                        LocalDateTime startTime = LocalDateTime.of(attendanceDate, baseConfig.getMorningWorkingTime().toLocalTime());
                        LocalDateTime endTime = LocalDateTime.of(attendanceDate, baseConfig.getAfternoonClosingTime().toLocalTime());
                        boolean lap = this.hasNoOverlap(e.getOvertimeWorkingTime(), e.getOvertimeClosingTime(), startTime, endTime);
                        if (lap) {
                           throw new BusinessException(
                              "操作失败！加班和白班时间冲突：" + e.getOvertimeWorkingTime().format(formatter) + "~" + e.getOvertimeClosingTime().format(formatter)
                           );
                        }
                     }
                  }
               }
            );
         }

         BeanUtil.copy(param, baseConfig);
         if (CollectionUtils.isNotEmpty(param.getPoints())) {
            baseConfig.setFenceJson(JSON.toJSONString(param.getPoints()));
         }

         this.standConfigService.updateById(baseConfig);
         if (ClockNumberEnum.TWICE.getType().equals(param.getPunchTimes())) {
            this.standConfigService
               .update(
                  Wrappers.lambdaUpdate(MesBuildingAttendanceStandConfig.class)
                     .set(MesBuildingAttendanceStandConfig::getMorningClosingTime, null)
                     .set(MesBuildingAttendanceStandConfig::getAfternoonWorkingTime, null)
                     .eq(MesBuildingAttendanceStandConfig::getId, baseConfig.getId())
               );
         }

         if (!param.getIsSetAdvance()) {
            this.standConfigService
               .update(
                  Wrappers.lambdaUpdate(MesBuildingAttendanceStandConfig.class)
                     .set(MesBuildingAttendanceStandConfig::getAdvanceTime, null)
                     .eq(MesBuildingAttendanceStandConfig::getId, baseConfig.getId())
               );
         }

         if (!param.getIsSetDelay()) {
            this.standConfigService
               .update(
                  Wrappers.lambdaUpdate(MesBuildingAttendanceStandConfig.class)
                     .set(MesBuildingAttendanceStandConfig::getDelayTime, null)
                     .eq(MesBuildingAttendanceStandConfig::getId, baseConfig.getId())
               );
         }
      }

      return true;
   }

   public static boolean isNotInStandWorkTime(LocalDateTime overTime, LocalDateTime startTime, LocalDateTime endTime) {
      return !overTime.isAfter(startTime) || !overTime.isBefore(endTime);
   }

   @Override
   public MesBuildingAttendanceStandConfigDTO getStandConfig() {
      MesBuildingAttendanceStandConfig baseConfig = this.getOne(
         Wrappers.lambdaQuery(MesBuildingAttendanceStandConfig.class).eq(MesBuildingAttendanceStandConfig::getIsBaseConfig, Boolean.TRUE)
      );
      if (baseConfig == null) {
         return null;
      }

      MesBuildingAttendanceStandConfigDTO standConfigDTO = BeanUtil.copy(baseConfig, MesBuildingAttendanceStandConfigDTO.class);
      standConfigDTO.setWeekScopeList(decomposeToPowersOfTwo(baseConfig.getWeekScope()));
      if (StringUtils.isNotBlank(baseConfig.getFenceJson())) {
         List<PointDO> doList = JSON.parseArray(baseConfig.getFenceJson(), PointDO.class);
         List<PointDTO> dtoList = doList.stream().map(pointDO -> {
            String[] split = pointDO.getPoint().split(",");
            return PointDTO.builder().lat(split[1]).sort(pointDO.getSort()).lng(split[0]).build();
         }).collect(Collectors.toList());
         standConfigDTO.setPointDTOList(dtoList);
      }

      return standConfigDTO;
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

   private void checkParam(MesBuildingAttendanceStandConfigDTOParam param) {
      param.setMorningWorkingTime(this.removeSeconds(param.getMorningWorkingTime()));
      param.setMorningClosingTime(this.removeSeconds(param.getMorningClosingTime()));
      param.setAfternoonWorkingTime(this.removeSeconds(param.getAfternoonWorkingTime()));
      param.setAfternoonClosingTime(this.removeSeconds(param.getAfternoonClosingTime()));
      if (ClockNumberEnum.TWICE.getType().equals(param.getPunchTimes())) {
         Preconditions.checkArgument(param.getMorningWorkingTime() != null, "操作失败！,上班时间不能为空！");
         Preconditions.checkArgument(param.getAfternoonClosingTime() != null, "操作失败！,下班时间不能为空！");
         Preconditions.checkArgument(param.getAfternoonClosingTime().toLocalTime().isAfter(param.getMorningWorkingTime().toLocalTime()), "下班时间不能早于上班时间");
      }

      if (ClockNumberEnum.FOUR.getType().equals(param.getPunchTimes())) {
         Preconditions.checkArgument(param.getMorningWorkingTime() != null, "上午上班时间不能为空！");
         Preconditions.checkArgument(param.getMorningClosingTime() != null, "上午下班时间不能为空！");
         Preconditions.checkArgument(param.getAfternoonWorkingTime() != null, "下午上班班时间不能为空！");
         Preconditions.checkArgument(param.getAfternoonClosingTime() != null, "下午下班时间不能为空！");
         Preconditions.checkArgument(param.getMorningClosingTime().toLocalTime().isAfter(param.getMorningWorkingTime().toLocalTime()), "上午下班时间不能早于上午上班时间");
         Preconditions.checkArgument(param.getAfternoonClosingTime().toLocalTime().isAfter(param.getAfternoonWorkingTime().toLocalTime()), "下午下班时间不能早于下午上班时间");
      }

      if (ClockTypeEnum.POSIT.getType().equals(param.getClockType())) {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(param.getPoints()), "操作失败！,打卡点位信息不能为空！");
         Preconditions.checkArgument(param.getPoints().size() > 2, "操作失败！,至少需要三个点位");
      }

      if (ClockTypeEnum.FACE.getType().equals(param.getClockType())) {
         throw new BusinessException("操作失败！,暂不支持的打卡方式");
      }

      if (param.getIsSetAdvance()) {
         Preconditions.checkArgument(param.getAdvanceTime() != null, "操作失败！,提前时间不能为空！");
      }

      if (param.getIsSetDelay()) {
         Preconditions.checkArgument(param.getDelayTime() != null, "操作失败！,延迟时间不能为空！");
      }
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
