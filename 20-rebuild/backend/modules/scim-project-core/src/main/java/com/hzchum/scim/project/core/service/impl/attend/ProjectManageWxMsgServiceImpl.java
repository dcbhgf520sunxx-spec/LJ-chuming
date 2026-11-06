package com.hzchum.scim.project.core.service.impl.attend;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendance;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageWxMsgService;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.WxMsgUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.request.SendMsgToWxUserBaseInfoDTOParam;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProjectManageWxMsgServiceImpl implements ProjectManageWxMsgService {
   private static final Logger log = LoggerFactory.getLogger(ProjectManageWxMsgServiceImpl.class);
   @Resource
   private ProjectManageAttendanceService attendanceService;
   @Resource
   private UserService userService;
   @Resource
   private WxMsgUtil wxMsgUtil;
   @Resource
   private ProjectManageRosterService rosterService;
   private static final int IN_ADVANCE = 10;

   @Override
   public void initToDaySendMsgTimers() {
      this.wxMsgUtil.clearMap();
      LocalDate now = LocalDate.now();
      List<ProjectManageAttendance> attendanceList = this.attendanceService
         .list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getAttendanceDate, now)
               .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
         );
      Map<LocalDateTime, List<ProjectManageAttendance>> groupedByMorningWorkingTime = attendanceList.stream()
         .collect(Collectors.groupingBy(ProjectManageAttendance::getMorningWorkingTimeConfig));
      Map<LocalDateTime, List<ProjectManageAttendance>> groupedByAfternoonWorkingTime = attendanceList.stream()
         .collect(Collectors.groupingBy(ProjectManageAttendance::getAfternoonWorkingTimeConfig));
      groupedByMorningWorkingTime.forEach(this::buildSendMsgBaseInfoToCreateTimer);
      groupedByAfternoonWorkingTime.forEach(this::buildSendMsgBaseInfoToCreateTimer);
   }

   @Override
   public void initToDayUserSendMsgTimers(User user) {
      LocalDate now = LocalDate.now();
      List<ProjectManageAttendance> attendanceList = this.attendanceService
         .list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getUserId, user.getId())
               .eq(ProjectManageAttendance::getAttendanceDate, now)
               .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
         );
      if (!CollectionUtils.isEmpty(attendanceList)) {
         Map<LocalDateTime, List<ProjectManageAttendance>> groupedByMorningWorkingTime = attendanceList.stream()
            .collect(Collectors.groupingBy(ProjectManageAttendance::getMorningWorkingTimeConfig));
         Map<LocalDateTime, List<ProjectManageAttendance>> groupedByAfternoonWorkingTime = attendanceList.stream()
            .collect(Collectors.groupingBy(ProjectManageAttendance::getAfternoonWorkingTimeConfig));
         groupedByMorningWorkingTime.forEach(this::buildSendMsgBaseInfoToCreateTimer);
         groupedByAfternoonWorkingTime.forEach(this::buildSendMsgBaseInfoToCreateTimer);
      }
   }

   @Override
   public void saveSendMsgByRoster(ProjectManageRoster roster) {
      LocalDate now = LocalDate.now();
      List<ProjectManageAttendance> attendanceList = this.attendanceService
         .list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
               .eq(ProjectManageAttendance::getAttendanceDate, now)
               .eq(ProjectManageAttendance::getProjectManageRosterId, roster.getId())
         );
      if (!CollectionUtils.isEmpty(attendanceList)) {
         Map<LocalDateTime, List<ProjectManageAttendance>> groupedByMorningWorkingTime = attendanceList.stream()
            .collect(Collectors.groupingBy(ProjectManageAttendance::getMorningWorkingTimeConfig));
         Map<LocalDateTime, List<ProjectManageAttendance>> groupedByAfternoonWorkingTime = attendanceList.stream()
            .collect(Collectors.groupingBy(ProjectManageAttendance::getAfternoonWorkingTimeConfig));
         groupedByMorningWorkingTime.forEach(this::buildSendMsgBaseInfoToCreateTimer);
         groupedByAfternoonWorkingTime.forEach(this::buildSendMsgBaseInfoToCreateTimer);
      }
   }

   @Override
   public void removeSendMsgByRoster(ProjectManageRoster roster) {
      LocalDate now = LocalDate.now();
      List<ProjectManageAttendance> attendanceList = this.attendanceService
         .list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
               .eq(ProjectManageAttendance::getAttendanceDate, now)
               .eq(ProjectManageAttendance::getProjectManageRosterId, roster.getId())
         );
      if (!CollectionUtils.isEmpty(attendanceList)) {
         Map<LocalDateTime, List<ProjectManageAttendance>> groupedByMorningWorkingTime = attendanceList.stream()
            .collect(Collectors.groupingBy(ProjectManageAttendance::getMorningWorkingTimeConfig));
         Map<LocalDateTime, List<ProjectManageAttendance>> groupedByAfternoonWorkingTime = attendanceList.stream()
            .collect(Collectors.groupingBy(ProjectManageAttendance::getAfternoonWorkingTimeConfig));
         groupedByMorningWorkingTime.forEach(this::buildSendMsgBaseInfoToRemoveTimer);
         groupedByAfternoonWorkingTime.forEach(this::buildSendMsgBaseInfoToRemoveTimer);
      }
   }

   private void buildSendMsgBaseInfoToCreateTimer(LocalDateTime time, List<ProjectManageAttendance> attendanceList) {
      LocalDateTime remindTime = time.minusMinutes(10L);
      if (!remindTime.isBefore(LocalDateTime.now())) {
         Map<Long, List<ProjectManageAttendance>> attendanceParamMap = attendanceList.stream()
            .collect(Collectors.groupingBy(ProjectManageAttendance::getUserId));
         Map<Long, ProjectManageAttendance> attendanceMap = new HashMap<>();
         attendanceParamMap.forEach(
            (userId, rosterAttendanceList) -> {
               if (Integer.valueOf(1).equals(rosterAttendanceList.size())) {
                  attendanceMap.put(userId, rosterAttendanceList.get(0));
               } else {
                  ProjectManageRoster roster = this.rosterService
                     .getOne(
                        Wrappers.lambdaQuery(ProjectManageRoster.class)
                           .eq(ProjectManageRoster::getUserId, userId)
                           .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
                     );
                  if (roster != null) {
                     Map<Long, ProjectManageAttendance> rosterAttendanceMap = rosterAttendanceList.stream()
                        .collect(Collectors.toMap(ProjectManageAttendance::getProjectManageRosterId, Function.identity()));
                     if (rosterAttendanceMap.containsKey(roster.getId())) {
                        attendanceMap.put(userId, rosterAttendanceMap.get(roster.getId()));
                     }
                  }
               }
            }
         );
         if (!CollectionUtils.isEmpty(attendanceMap.keySet())) {
            List<User> userList = this.userService
               .list(
                  Wrappers.lambdaQuery(User.class)
                     .in(User::getId, attendanceMap.keySet())
                     .eq(User::getUserType, UserTypeEnum.TEMP_USER.getType())
                     .ne(User::getOpenId, "")
                     .isNotNull(User::getOpenId)
               );
            if (!CollectionUtils.isEmpty(userList)) {
               List<SendMsgToWxUserBaseInfoDTOParam> baseInfoDTOParamList = userList.stream().map(user -> {
                  SendMsgToWxUserBaseInfoDTOParam dtoParam = new SendMsgToWxUserBaseInfoDTOParam();
                  dtoParam.setPage("/pagesGround/closeIn/closeIn");
                  dtoParam.setTouser(user.getOpenId());
                  dtoParam.setData(this.getTemplateData(remindTime, attendanceMap.getOrDefault(user.getId(), null)));
                  return dtoParam;
               }).collect(Collectors.toList());
               this.wxMsgUtil.createTimer(remindTime, new HashSet<>(baseInfoDTOParamList));
            }
         }
      }
   }

   private void buildSendMsgBaseInfoToRemoveTimer(LocalDateTime time, List<ProjectManageAttendance> attendanceList) {
      LocalDateTime remindTime = time.minusMinutes(10L);
      if (!remindTime.isBefore(LocalDateTime.now())) {
         if (!CollectionUtils.isEmpty(attendanceList)) {
            List<Long> userIds = attendanceList.stream().map(ProjectManageAttendance::getUserId).collect(Collectors.toList());
            List<User> userList = this.userService
               .list(
                  Wrappers.lambdaQuery(User.class)
                     .in(User::getId, userIds)
                     .eq(User::getUserType, UserTypeEnum.TEMP_USER.getType())
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

   private JSONObject getTemplateData(LocalDateTime remindTime, ProjectManageAttendance attendance) {
      JSONObject data = new JSONObject();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
      String phrase1Var = "";
      String date2Var = "";
      if (attendance != null) {
         if (attendance.getMorningWorkingTimeConfig().minusMinutes(10L).isEqual(remindTime)) {
            phrase1Var = "上午上班";
            date2Var = attendance.getMorningWorkingTimeConfig().format(formatter);
         }

         if (attendance.getAfternoonWorkingTimeConfig().minusMinutes(10L).isEqual(remindTime)) {
            phrase1Var = "下午上班";
            date2Var = attendance.getAfternoonWorkingTimeConfig().format(formatter);
         }

         JSONObject date2Json = new JSONObject();
         date2Json.put("value", date2Var);
         data.put("date2", date2Json);
         JSONObject phrase1Json = new JSONObject();
         phrase1Json.put("value", phrase1Var);
         data.put("phrase1", phrase1Json);
      }

      return data;
   }
}
