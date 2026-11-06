package com.hzchum.scim.mes.building.core.service.impl.attend;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.enums.attend.ClockNumberEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendance;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceStandConfig;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceStandConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesWxMsgService;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.WxMsgUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.request.SendMsgToWxUserBaseInfoDTOParam;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class MesWxMsgServiceImpl implements MesWxMsgService {
   @Resource
   private UserService userService;
   @Resource
   private WxMsgUtil wxMsgUtil;
   @Resource
   private MesBuildingAttendanceService attendanceService;
   @Resource
   private MesBuildingAttendanceStandConfigService standConfigService;
   @Resource
   private MesBuildingAttendanceOverConfigService overConfigService;
   private static final int IN_ADVANCE = 10;

   @Override
   public void initToDaySendMsgTimers() {
      LocalDate now = LocalDate.now();
      MesBuildingAttendanceStandConfig nowStandConfig = this.standConfigService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingAttendanceStandConfig.class)
               .eq(MesBuildingAttendanceStandConfig::getAttendanceDate, now)
               .eq(MesBuildingAttendanceStandConfig::getIsBaseConfig, Boolean.FALSE)
         );
      if (nowStandConfig != null) {
         if (ClockNumberEnum.TWICE.getType().equals(nowStandConfig.getPunchTimes())) {
            List<MesBuildingAttendance> mesBuildingAttendances = this.attendanceService
               .list(
                  Wrappers.lambdaQuery(MesBuildingAttendance.class)
                     .eq(MesBuildingAttendance::getAttendanceDate, now)
                     .eq(MesBuildingAttendance::getStandConfigId, nowStandConfig.getId())
               );
            this.buildSendMsgBaseInfoToCreateTimer(nowStandConfig.getMorningWorkingTime(), mesBuildingAttendances, Boolean.TRUE);
         }

         if (ClockNumberEnum.FOUR.getType().equals(nowStandConfig.getPunchTimes())) {
            List<MesBuildingAttendance> mesBuildingAttendances = this.attendanceService
               .list(
                  Wrappers.lambdaQuery(MesBuildingAttendance.class)
                     .eq(MesBuildingAttendance::getAttendanceDate, now)
                     .eq(MesBuildingAttendance::getStandConfigId, nowStandConfig.getId())
               );
            this.buildSendMsgBaseInfoToCreateTimer(nowStandConfig.getMorningWorkingTime(), mesBuildingAttendances, Boolean.TRUE);
            this.buildSendMsgBaseInfoToCreateTimer(nowStandConfig.getAfternoonWorkingTime(), mesBuildingAttendances, Boolean.TRUE);
         }
      }

      Map<Long, MesBuildingAttendanceOverConfig> overConfigMap = this.overConfigService
         .list(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfig.class).and(q -> {
            q.apply("DATE_FORMAT(overtime_working_time, '%Y-%m-%d') = {0}", now);
            q.or();
            q.apply("DATE_FORMAT(overtime_closing_time, '%Y-%m-%d') = {0}", now);
         }))
         .stream()
         .collect(Collectors.toMap(MesBuildingAttendanceOverConfig::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(overConfigMap.keySet())) {
         for (MesBuildingAttendanceOverConfig overConfig : overConfigMap.values()) {
            List<MesBuildingAttendance> attendanceList = this.attendanceService
               .list(
                  Wrappers.lambdaQuery(MesBuildingAttendance.class)
                     .eq(MesBuildingAttendance::getAttendanceDate, now)
                     .apply("find_in_set({0}, over_config_ids)", overConfig.getId())
               );
            if (overConfig.getOvertimeWorkingTime().toLocalDate().isEqual(now)) {
               this.buildSendMsgBaseInfoToCreateTimer(overConfig.getOvertimeWorkingTime(), attendanceList, Boolean.FALSE);
            }
         }
      }
   }

   @Override
   public void initToDayUserSendMsgTimers(User user) {
      LocalDate now = LocalDate.now();
      MesBuildingAttendance attendance = this.attendanceService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingAttendance.class)
               .eq(MesBuildingAttendance::getAttendanceDate, now)
               .eq(MesBuildingAttendance::getUserId, user.getId())
         );
      if (attendance != null) {
         MesBuildingAttendanceStandConfig nowStandConfig = this.standConfigService.getById(attendance.getStandConfigId());
         if (nowStandConfig != null) {
            if (ClockNumberEnum.TWICE.getType().equals(nowStandConfig.getPunchTimes())) {
               this.buildSendMsgBaseInfoToCreateTimer(nowStandConfig.getMorningWorkingTime(), Collections.singletonList(attendance), Boolean.TRUE);
            }

            if (ClockNumberEnum.FOUR.getType().equals(nowStandConfig.getPunchTimes())) {
               this.buildSendMsgBaseInfoToCreateTimer(nowStandConfig.getMorningWorkingTime(), Collections.singletonList(attendance), Boolean.TRUE);
               this.buildSendMsgBaseInfoToCreateTimer(nowStandConfig.getAfternoonWorkingTime(), Collections.singletonList(attendance), Boolean.TRUE);
            }
         }

         if (attendance.getOverConfigIds() != null) {
            for (MesBuildingAttendanceOverConfig overConfig : this.overConfigService.getListByIdStr(attendance.getOverConfigIds())) {
               if (overConfig.getOvertimeWorkingTime().toLocalDate().isEqual(now)) {
                  this.buildSendMsgBaseInfoToCreateTimer(overConfig.getOvertimeWorkingTime(), Collections.singletonList(attendance), Boolean.FALSE);
               }
            }
         }
      }
   }

   @Override
   public void appendOverTimes(MesBuildingAttendanceOverConfig overConfig, List<Long> rosterIds) {
      LocalDate now = LocalDate.now();
      List<MesBuildingAttendance> attendanceList = this.attendanceService
         .list(
            Wrappers.lambdaQuery(MesBuildingAttendance.class)
               .eq(MesBuildingAttendance::getAttendanceDate, now)
               .in(MesBuildingAttendance::getRosterId, rosterIds)
               .apply("find_in_set({0}, over_config_ids)", overConfig.getId())
         );
      if (overConfig.getOvertimeWorkingTime().toLocalDate().isEqual(now)) {
         this.buildSendMsgBaseInfoToCreateTimer(overConfig.getOvertimeWorkingTime(), attendanceList, Boolean.FALSE);
      }
   }

   @Override
   public void removeOverTimers(MesBuildingAttendanceOverConfig overConfig, List<Long> rosterIds) {
      LocalDate now = LocalDate.now();
      List<MesBuildingAttendance> attendanceList = this.attendanceService
         .list(
            Wrappers.lambdaQuery(MesBuildingAttendance.class)
               .eq(MesBuildingAttendance::getAttendanceDate, now)
               .in(MesBuildingAttendance::getRosterId, rosterIds)
               .apply("find_in_set({0}, over_config_ids)", overConfig.getId())
         );
      if (CollectionUtils.isNotEmpty(attendanceList) && overConfig.getOvertimeWorkingTime().toLocalDate().isEqual(now)) {
         this.buildSendMsgBaseInfoToRemoveTimer(overConfig.getOvertimeWorkingTime(), attendanceList);
      }
   }

   private void buildSendMsgBaseInfoToRemoveTimer(LocalDateTime time, List<MesBuildingAttendance> attendanceList) {
      LocalDateTime remindTime = time.minusMinutes(10L);
      if (!remindTime.isBefore(LocalDateTime.now())) {
         if (!CollectionUtils.isEmpty(attendanceList)) {
            List<Long> userIds = attendanceList.stream().map(MesBuildingAttendance::getUserId).collect(Collectors.toList());
            List<User> userList = this.userService
               .list(
                  Wrappers.lambdaQuery(User.class)
                     .in(User::getId, userIds)
                     .eq(User::getUserType, UserTypeEnum.COMMON_USER.getType())
                     .ne(User::getOpenId, "")
                     .isNotNull(User::getOpenId)
               );
            if (!CollectionUtils.isEmpty(userList)) {
               List<SendMsgToWxUserBaseInfoDTOParam> baseInfoDTOParamList = userList.stream().map(user -> {
                  SendMsgToWxUserBaseInfoDTOParam dtoParam = new SendMsgToWxUserBaseInfoDTOParam();
                  dtoParam.setTouser(user.getOpenId());
                  return dtoParam;
               }).collect(Collectors.toList());
               this.wxMsgUtil.removeTimer(remindTime, new HashSet<>(baseInfoDTOParamList));
            }
         }
      }
   }

   private void buildSendMsgBaseInfoToCreateTimer(LocalDateTime time, List<MesBuildingAttendance> attendanceList, Boolean isStand) {
      LocalDateTime remindTime = time.minusMinutes(10L);
      if (!remindTime.isBefore(LocalDateTime.now())) {
         if (!CollectionUtils.isEmpty(attendanceList)) {
            List<Long> userIds = attendanceList.stream().map(MesBuildingAttendance::getUserId).collect(Collectors.toList());
            List<User> userList = this.userService
               .list(
                  Wrappers.lambdaQuery(User.class)
                     .in(User::getId, userIds)
                     .eq(User::getUserType, UserTypeEnum.COMMON_USER.getType())
                     .ne(User::getOpenId, "")
                     .isNotNull(User::getOpenId)
               );
            if (!CollectionUtils.isEmpty(userList)) {
               List<SendMsgToWxUserBaseInfoDTOParam> baseInfoDTOParamList = userList.stream().map(user -> {
                  SendMsgToWxUserBaseInfoDTOParam dtoParam = new SendMsgToWxUserBaseInfoDTOParam();
                  dtoParam.setTouser(user.getOpenId());
                  dtoParam.setPage("/pagesGround/mesClockIn/closeIn");
                  dtoParam.setData(this.getTemplateData(time, isStand ? "上班提醒" : "加班提醒"));
                  return dtoParam;
               }).collect(Collectors.toList());
               this.wxMsgUtil.createTimer(remindTime, new HashSet<>(baseInfoDTOParamList));
            }
         }
      }
   }

   private JSONObject getTemplateData(LocalDateTime remindTime, String phrase1Var) {
      JSONObject data = new JSONObject();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
      JSONObject date2Json = new JSONObject();
      date2Json.put("value", remindTime.format(formatter));
      data.put("date2", date2Json);
      JSONObject phrase1Json = new JSONObject();
      phrase1Json.put("value", phrase1Var);
      data.put("phrase1", phrase1Json);
      return data;
   }
}
