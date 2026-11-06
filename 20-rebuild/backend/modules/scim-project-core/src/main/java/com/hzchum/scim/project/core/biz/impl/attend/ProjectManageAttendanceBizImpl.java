package com.hzchum.scim.project.core.biz.impl.attend;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.util.IdcardUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
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
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.project.core.api.biz.ProjectManageRosterBiz;
import com.hzchum.scim.project.core.api.biz.attend.ProjectManageAttendanceBiz;
import com.hzchum.scim.project.core.api.biz.attend.ProjectManageAttendanceFenceBiz;
import com.hzchum.scim.project.core.api.enums.AttendStatusEnum;
import com.hzchum.scim.project.core.api.enums.ClockInTypeEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendance;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceConfig;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceDayDetailsDTO;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceMonthDetailsDTO;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageTodayAttendanceConfig;
import com.hzchum.scim.project.core.api.pojo.dtoParam.put.ProjectManageAttendanceDTOParam;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceConfigService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceService;
import com.hzchum.scim.project.core.mapper.attend.ProjectManageAttendanceMapper;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
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
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.apache.commons.lang3.StringUtils;
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
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class ProjectManageAttendanceBizImpl
   extends IBizImpl<ProjectManageAttendanceService, ProjectManageAttendanceMapper, ProjectManageAttendance>
   implements ProjectManageAttendanceBiz {
   @Resource
   private ProjectManageRosterBiz projectManageRosterBiz;
   @Resource
   private ProjectManageAttendanceConfigService configService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private ContractProjectBiz projectBiz;
   @Resource
   private ProjectManageAttendanceFenceBiz fenceBiz;
   @Resource
   private AttachmentService attachmentService;

   @Transactional
   @Override
   public boolean saveAttendance(ProjectManageAttendanceDTOParam param) {
      Integer clockInType = param.getClockInTypeEnum();
      LocalDateTime attendanceTime = this.removeSeconds(LocalDateTime.now());
      SecurityUser currentUser = UserUtil.getCurrentUser();
      ProjectManageRoster roster = this.projectManageRosterBiz
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
               .eq(ProjectManageRoster::getUserId, currentUser.getId())
               .eq(ProjectManageRoster::getSupplierId, param.getSupplierId())
               .eq(ProjectManageRoster::getProjectId, param.getProjectId())
         );
      Preconditions.checkArgument(roster != null, "操作失败,花名册人员信息不存在");
      ProjectManageAttendanceConfig attendConfig = this.configService
         .getOne(Wrappers.lambdaQuery(ProjectManageAttendanceConfig.class).eq(ProjectManageAttendanceConfig::getProjectId, param.getProjectId()));
      Preconditions.checkArgument(attendConfig != null, "操作失败！该项目未配置考勤信息！");
      Preconditions.checkArgument(!attendConfig.getIsClose(), "操作失败！该项目考勤打卡已关闭");
      Preconditions.checkArgument(
         Arrays.stream(StringUtils.split(attendConfig.getSupplierScope(), ","))
            .map(Long::parseLong)
            .collect(Collectors.toList())
            .contains(param.getSupplierId()),
         "操作失败！该项目未配置该分包商考勤！"
      );
      if (attendConfig.getIsNeedFence()) {
         Preconditions.checkArgument(StringUtils.isNotBlank(param.getPoint()), "操作失败！点位信息不能空！");
      }

      if (attendConfig.getIsNeedPicture()) {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(param.getAttachmentIds()), "操作失败！图片不能为空！");
      }

      ProjectManageAttendance attendanceInfo = this.baseService
         .getOne(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getProjectManageRosterId, roster.getId())
               .eq(ProjectManageAttendance::getAttendanceDate, LocalDate.now())
         );
      Preconditions.checkArgument(attendanceInfo != null, "操作失败！该用户无需打卡！");
      Preconditions.checkArgument(attendanceInfo.getIsCancel().equals(Boolean.FALSE), "操作失败！该用户无需打卡");
      if (!attendConfig.getIsOutScope()) {
         if (clockInType.equals(ClockInTypeEnum.MORNING_WORKING.getType())) {
            Preconditions.checkArgument(!attendanceTime.isAfter(attendanceInfo.getMorningWorkingTimeConfig()), "操作失败！打卡配置迟到打卡！");
         }

         if (clockInType.equals(ClockInTypeEnum.AFTERNOON_WORKING.getType())) {
            Preconditions.checkArgument(!attendanceTime.isAfter(attendanceInfo.getAfternoonWorkingTimeConfig()), "操作失败！打卡配置迟到打卡！");
         }

         if (clockInType.equals(ClockInTypeEnum.MORNING_CLOSING.getType())) {
            Preconditions.checkArgument(!attendanceTime.isBefore(attendanceInfo.getMorningClosingTimeConfig()), "操作失败！打卡配置禁止早退打卡！");
         }

         if (clockInType.equals(ClockInTypeEnum.AFTERNOON_CLOSING.getType())) {
            Preconditions.checkArgument(!attendanceTime.isBefore(attendanceInfo.getAfternoonClosingTimeConfig()), "操作失败！打卡配置禁止早退打卡！");
         }
      }

      if (clockInType.equals(ClockInTypeEnum.MORNING_WORKING.getType())) {
         attendanceInfo.setMorningWorkingTime(attendanceTime);
      }

      if (clockInType.equals(ClockInTypeEnum.MORNING_CLOSING.getType())) {
         attendanceInfo.setMorningClosingTime(attendanceTime);
      }

      if (clockInType.equals(ClockInTypeEnum.AFTERNOON_WORKING.getType())) {
         attendanceInfo.setAfternoonWorkingTime(attendanceTime);
      }

      if (clockInType.equals(ClockInTypeEnum.AFTERNOON_CLOSING.getType())) {
         attendanceInfo.setAfternoonClosingTime(attendanceTime);
      }

      if (clockInType.equals(ClockInTypeEnum.OVERTIME_WORKING.getType())) {
         Preconditions.checkArgument(attendanceTime.isAfter(attendanceInfo.getAfternoonClosingTimeConfig()), "操作失败！加班打卡必须在下班时间之后！");
         attendanceInfo.setOvertimeWorkingTime(attendanceTime);
      }

      if (clockInType.equals(ClockInTypeEnum.OVERTIME_CLOSING.getType())) {
         Preconditions.checkArgument(attendanceTime.isAfter(attendanceInfo.getAfternoonClosingTimeConfig()), "操作失败！加班打卡必须在下班时间之后！");
         attendanceInfo.setOvertimeClosingTime(attendanceTime);
      }

      attendanceInfo.setAttendStatus(
         this.getAttendStatus(
            attendanceInfo.getMorningWorkingTime(),
            attendanceInfo.getMorningClosingTime(),
            attendanceInfo.getAfternoonWorkingTime(),
            attendanceInfo.getAfternoonClosingTime()
         )
      );
      if (attendConfig.getIsNeedFence()) {
         if (StringUtils.isBlank(attendanceInfo.getPoint())) {
            attendanceInfo.setPoint(param.getPoint());
         } else {
            List<String> pintList = Arrays.stream(attendanceInfo.getPoint().split(";")).collect(Collectors.toList());
            pintList.add(param.getPoint());
            attendanceInfo.setPoint(StringUtils.join(pintList, ";"));
         }
      }

      if (attendConfig.getIsNeedPicture()) {
         if (StringUtils.isBlank(attendanceInfo.getAttachmentIds())) {
            attendanceInfo.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
         } else {
            List<Long> pictureList = Arrays.stream(attendanceInfo.getAttachmentIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
            pictureList.addAll(param.getAttachmentIds());
            attendanceInfo.setAttachmentIds(StringUtils.join(pictureList, ","));
         }
      }

      this.baseService.updateById(attendanceInfo);
      return true;
   }

   @Override
   public ProjectManageTodayAttendanceConfig getUserConfig(Long projectId) {
      ProjectManageTodayAttendanceConfig todayConfig = new ProjectManageTodayAttendanceConfig();
      todayConfig.setIsNeedClock(Boolean.FALSE);
      ProjectManageRoster roster = this.projectManageRosterBiz
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getProjectId, projectId)
               .eq(ProjectManageRoster::getUserId, UserUtil.getCurrentUserId())
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      if (roster != null) {
         ProjectManageAttendance attendance = this.baseService
            .getOne(
               Wrappers.lambdaQuery(ProjectManageAttendance.class)
                  .eq(ProjectManageAttendance::getProjectManageRosterId, roster.getId())
                  .eq(ProjectManageAttendance::getAttendanceDate, LocalDate.now())
                  .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
            );
         if (attendance != null) {
            todayConfig.setIsNeedClock(Boolean.TRUE);
            BeanUtil.copy(attendance, todayConfig);
            ProjectManageAttendanceConfig config = this.configService.getById(attendance.getAttendanceTimeConfigurationId());
            if (config != null) {
               todayConfig.setIsNeedFence(config.getIsNeedFence());
               todayConfig.setIsNeedPicture(config.getIsNeedPicture());
               todayConfig.setIsOutScope(config.getIsOutScope());
               if (config.getIsNeedFence()) {
                  todayConfig.setFenceDTOList(this.fenceBiz.getAttendanceFence(projectId));
               }
            }
         }
      }

      return todayConfig;
   }

   @Override
   public List<ProjectManageAttendanceSummaryDTO> getAttendanceSummary(Long projectId, Long supplierId, LocalDate monthDate) {
      Map<String, ProjectManageAttendanceSummaryDTO> summaryDTOMap = this.baseService
         .getAttendanceSummary(projectId, supplierId, monthDate)
         .stream()
         .collect(Collectors.toMap(ProjectManageAttendanceSummaryDTO::getAttendanceDate, Function.identity()));
      return this.getDatesUntilToday(monthDate)
         .stream()
         .map(
            e -> summaryDTOMap.getOrDefault(
               e, ProjectManageAttendanceSummaryDTO.builder().attendanceDate(e).absenteeNumber(0).totalNumber(0).clockNumber(0).build()
            )
         )
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectManageAttendanceDayDetailsDTO> getAttendanceDayDetails(
      Boolean isSummaryDetail, Long projectId, Long supplierId, LocalDate dayDate, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectManageAttendance> attendanceList = this.baseService
         .list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getProjectId, projectId)
               .eq(supplierId != null, ProjectManageAttendance::getSupplierId, supplierId)
               .eq(dayDate != null, ProjectManageAttendance::getAttendanceDate, dayDate)
               .ne(!isSummaryDetail, ProjectManageAttendance::getAttendStatus, AttendStatusEnum.ABSENTEE.getType())
               .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
               .apply(startDate != null, "date_format(attendance_date, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", startDate)
               .apply(endDate != null, "date_format(attendance_date, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", endDate)
               .orderByDesc(ProjectManageAttendance::getAttendanceDate)
               .orderByDesc(ProjectManageAttendance::getSupplierId)
               .orderByDesc(ProjectManageAttendance::getAttendStatus)
               .orderByDesc(ProjectManageAttendance::getId)
         );
      return new PageVO<>(page, this.convertToDayDetailsDTO(attendanceList));
   }

   @Override
   public void getAttendanceDayDetailsDownload(
      Boolean isSummaryDetail, Long projectId, Long supplierId, LocalDate dayDate, LocalDate startDate, LocalDate endDate
   ) {
      List<ProjectManageAttendance> attendanceList = this.baseService
         .list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getProjectId, projectId)
               .eq(supplierId != null, ProjectManageAttendance::getSupplierId, supplierId)
               .eq(dayDate != null, ProjectManageAttendance::getAttendanceDate, dayDate)
               .ne(!isSummaryDetail, ProjectManageAttendance::getAttendStatus, AttendStatusEnum.ABSENTEE.getType())
               .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
               .apply(startDate != null, "date_format(attendance_date, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", startDate)
               .apply(endDate != null, "date_format(attendance_date, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", endDate)
               .orderByDesc(ProjectManageAttendance::getAttendanceDate)
               .orderByDesc(ProjectManageAttendance::getSupplierId)
               .orderByDesc(ProjectManageAttendance::getAttendStatus)
         );
      List<ProjectManageAttendanceDayDetailsDTO> dayDetailsDTOList = this.convertToDayDetailsDTO(attendanceList);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      dayDetailsDTOList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setProjectManageRosterId(orderNo.get());
         e.setDateStr(e.getAttendanceDate().toString() + " " + this.getDayOfWeekString(e.getAttendanceDate()));
      });
      ContractProject project = this.projectBiz.getById(projectId);
      HashMap<String, Object> result = new HashMap<>();
      result.put("resultList", dayDetailsDTOList);
      result.put("projectName", project != null ? project.getName() : "");
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/ProjectAttendanceDayDetails.xlsx";
      String exportFileName = "花名册日考勤信息.xlsx";
      this.download(result, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public PageVO<ProjectManageAttendanceMonthDetailsDTO> getAttendanceMonthDetails(Long projectId, LocalDate monthDate, Integer pageNumber, Integer pageSize) {
      return PageUtil.listPage(pageNumber, pageSize, this.getAttendanceMonthDetailsList(projectId, monthDate));
   }

   @Override
   public void getAttendanceMonthDetailsDownload(Long projectId, LocalDate monthDate) {
      List<ProjectManageAttendanceMonthDetailsDTO> monthDetailsList = this.getAttendanceMonthDetailsList(projectId, monthDate);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      monthDetailsList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setRosterId(orderNo.get());
      });
      ContractProject project = this.projectBiz.getById(projectId);
      HashMap<String, Object> result = new HashMap<>();
      result.put("resultList", monthDetailsList);
      result.put("projectName", project != null ? project.getName() : "");
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/ProjectAttendanceMonthDetails.xlsx";
      String exportFileName = "花名册月考勤信息.xlsx";
      this.download(result, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public HashMap<String, Integer> getUserAttendanceSummary() {
      Long currentUserId = UserUtil.getCurrentUserId();
      ProjectManageRoster roster = this.projectManageRosterBiz
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getUserId, currentUserId)
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      return roster == null ? new HashMap<>() : this.baseService.getUserAttendanceSummary(roster.getId());
   }

   @Override
   public List<ProjectManageAttendanceDayDetailsDTO> getUserAttendanceDayDetails(LocalDate monthDate) {
      Long currentUserId = UserUtil.getCurrentUserId();
      ProjectManageRoster roster = this.projectManageRosterBiz
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getUserId, currentUserId)
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      if (roster == null) {
         return new ArrayList<>();
      }

      List<ProjectManageAttendance> attendanceList = this.baseService
         .list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .eq(ProjectManageAttendance::getProjectManageRosterId, roster.getId())
               .ne(ProjectManageAttendance::getAttendStatus, AttendStatusEnum.ABSENTEE.getType())
               .apply("date_format(attendance_date, '%Y-%m') = date_format({0}, '%Y-%m')", monthDate)
               .orderByDesc(ProjectManageAttendance::getAttendanceDate)
               .orderByAsc(ProjectManageAttendance::getAttendStatus)
         );
      return this.convertToDayDetailsDTO(attendanceList);
   }

   private List<ProjectManageAttendanceMonthDetailsDTO> getAttendanceMonthDetailsList(Long projectId, LocalDate monthDate) {
      List<ProjectManageAttendance> attendanceList = this.baseService
         .list(
            Wrappers.lambdaQuery(ProjectManageAttendance.class)
               .ne(ProjectManageAttendance::getAttendanceDate, LocalDate.now())
               .eq(ProjectManageAttendance::getProjectId, projectId)
               .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
               .apply("date_format(attendance_date, '%Y-%m') = date_format({0}, '%Y-%m')", monthDate)
         );
      if (CollectionUtils.isEmpty(attendanceList)) {
         return new ArrayList<>();
      }

      List<ProjectManageAttendanceDayDetailsDTO> dayDetailsDTOList = this.convertToDayDetailsDTO(attendanceList);
      Map<Long, List<ProjectManageAttendanceDayDetailsDTO>> attendanceMap = dayDetailsDTOList.stream()
         .collect(Collectors.groupingBy(ProjectManageAttendanceDayDetailsDTO::getProjectManageRosterId));
      List<Long> rosterIds = attendanceList.stream().map(ProjectManageAttendance::getProjectManageRosterId).distinct().collect(Collectors.toList());
      Map<Long, ProjectManageRoster> rosterMap = this.projectManageRosterBiz
         .listByIds(rosterIds)
         .stream()
         .collect(Collectors.toMap(ProjectManageRoster::getId, Function.identity()));
      ArrayList<ProjectManageAttendanceMonthDetailsDTO> detailsList = new ArrayList<>();
      attendanceMap.forEach((rosterId, list1) -> {
         if (rosterMap.containsKey(rosterId)) {
            ProjectManageRoster roster = rosterMap.get(rosterId);
            Supplier supplier = this.supplierService.getById(roster.getSupplierId());
            ProjectManageAttendanceMonthDetailsDTO detailsDTO = new ProjectManageAttendanceMonthDetailsDTO();
            detailsDTO.setUserName(roster.getName());
            detailsDTO.setIdCard(roster.getIdNumber());
            if (supplier != null) {
               detailsDTO.setSupplierName(supplier.getName());
            }

            long count0 = list1.stream().filter(e -> AttendStatusEnum.ABSENTEE.getType().equals(e.getAttendStatus())).count();
            long count1 = list1.stream().filter(e -> !AttendStatusEnum.ABSENTEE.getType().equals(e.getAttendStatus())).count();
            BigDecimal count2 = list1.stream().map(ProjectManageAttendanceDayDetailsDTO::getActualHours).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal count3 = list1.stream().map(ProjectManageAttendanceDayDetailsDTO::getOverHours).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal count4 = list1.stream().map(ProjectManageAttendanceDayDetailsDTO::getAbsenceHours).reduce(BigDecimal.ZERO, BigDecimal::add);
            detailsDTO.setClockNumber(count1);
            detailsDTO.setWorkHours(count2);
            detailsDTO.setOverHours(count3);
            detailsDTO.setAbsenceHours(count4);
            detailsDTO.setAbsenceNumber(count0);
            detailsList.add(detailsDTO);
         }
      });
      return detailsList;
   }

   private List<ProjectManageAttendanceDayDetailsDTO> convertToDayDetailsDTO(List<ProjectManageAttendance> attendanceList) {
      return CollectionUtils.isEmpty(attendanceList)
         ? new ArrayList<>()
         : attendanceList.stream()
            .map(
               attendance -> {
                  ProjectManageAttendanceDayDetailsDTO detailsDTO = BeanUtil.copy(attendance, ProjectManageAttendanceDayDetailsDTO.class);
                  ProjectManageRoster roster = this.projectManageRosterBiz.getById(attendance.getProjectManageRosterId());
                  Supplier supplier = this.supplierService.getById(attendance.getSupplierId());
                  if (roster != null) {
                     detailsDTO.setUserName(roster.getName());
                     detailsDTO.setIdCard(roster.getIdNumber());
                  }

                  if (supplier != null) {
                     detailsDTO.setSupplierName(supplier.getName());
                  }

                  BigDecimal workHours = this.getStandardHour(attendance.getMorningWorkingTimeConfig(), attendance.getMorningClosingTimeConfig())
                     .add(this.getStandardHour(attendance.getAfternoonWorkingTimeConfig(), attendance.getAfternoonClosingTimeConfig()));
                  detailsDTO.setWorkHours(workHours);
                  BigDecimal hours1 = BigDecimal.ZERO;
                  BigDecimal hours2 = BigDecimal.ZERO;
                  BigDecimal hours3 = BigDecimal.ZERO;
                  BigDecimal hours4 = BigDecimal.ZERO;
                  if (attendance.getMorningWorkingTime() != null && attendance.getMorningClosingTime() != null) {
                     if (this.hasEffectiveWokeTime(
                        attendance.getMorningWorkingTime(),
                        attendance.getMorningClosingTime(),
                        attendance.getMorningWorkingTimeConfig(),
                        attendance.getMorningClosingTimeConfig()
                     )) {
                        LocalDateTime minDateTime1 = this.getMaxDateTime(attendance.getMorningWorkingTime(), attendance.getMorningWorkingTimeConfig());
                        LocalDateTime minDateTime2 = this.getMinDateTime(attendance.getMorningClosingTime(), attendance.getMorningClosingTimeConfig());
                        hours1 = this.getStandardHour(minDateTime1, minDateTime2);
                        BigDecimal standConfig = this.getStandardHour(attendance.getMorningWorkingTimeConfig(), attendance.getMorningClosingTimeConfig());
                        if (standConfig.compareTo(hours1) > 0) {
                           hours3 = standConfig.subtract(hours1);
                        }
                     } else {
                        hours3 = this.getStandardHour(attendance.getMorningWorkingTimeConfig(), attendance.getMorningClosingTimeConfig());
                     }
                  } else {
                     hours3 = this.getStandardHour(attendance.getMorningWorkingTimeConfig(), attendance.getMorningClosingTimeConfig());
                  }

                  if (attendance.getAfternoonWorkingTime() != null && attendance.getAfternoonClosingTime() != null) {
                     if (this.hasEffectiveWokeTime(
                        attendance.getAfternoonWorkingTime(),
                        attendance.getAfternoonClosingTime(),
                        attendance.getAfternoonWorkingTimeConfig(),
                        attendance.getAfternoonClosingTimeConfig()
                     )) {
                        LocalDateTime minDateTime1 = this.getMaxDateTime(attendance.getAfternoonWorkingTime(), attendance.getAfternoonWorkingTimeConfig());
                        LocalDateTime minDateTime2 = this.getMinDateTime(attendance.getAfternoonClosingTime(), attendance.getAfternoonClosingTimeConfig());
                        hours2 = this.getStandardHour(minDateTime1, minDateTime2);
                        BigDecimal standConfig = this.getStandardHour(attendance.getAfternoonWorkingTimeConfig(), attendance.getAfternoonClosingTimeConfig());
                        if (standConfig.compareTo(hours2) > 0) {
                           hours4 = standConfig.subtract(hours2);
                        }
                     } else {
                        hours4 = this.getStandardHour(attendance.getAfternoonWorkingTimeConfig(), attendance.getAfternoonClosingTimeConfig());
                     }
                  } else {
                     hours4 = this.getStandardHour(attendance.getAfternoonWorkingTimeConfig(), attendance.getAfternoonClosingTimeConfig());
                  }

                  detailsDTO.setMorningHours(hours1);
                  detailsDTO.setAfternoonHours(hours2);
                  detailsDTO.setActualHours(hours1.add(hours2));
                  detailsDTO.setAbsenceHours(hours3.add(hours4));
                  BigDecimal overHours = this.getStandardHour(attendance.getOvertimeWorkingTime(), attendance.getOvertimeClosingTime());
                  detailsDTO.setOverHours(overHours);
                  detailsDTO.setTotalHours(overHours.add(detailsDTO.getActualHours()));
                  detailsDTO.setAttachmentDTOList(this.attachmentService.listByIds(attendance.getAttachmentIds()));
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

   private List<String> getDatesUntilToday(LocalDate inputDate) {
      List<String> dates = new ArrayList<>();
      LocalDate today = LocalDate.now();
      if (inputDate.isAfter(today)) {
         return dates;
      }

      LocalDate firstDayOfInputMonth = inputDate.withDayOfMonth(1);
      if (inputDate.getYear() == today.getYear() && inputDate.getMonth() == today.getMonth()) {
         for (LocalDate date = firstDayOfInputMonth; !date.isAfter(today); date = date.plusDays(1L)) {
            dates.add(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         }
      } else {
         int daysInMonth = inputDate.lengthOfMonth();

         for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = inputDate.withDayOfMonth(day);
            dates.add(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         }
      }

      return dates;
   }

   private Integer getAttendStatus(LocalDateTime... times) {
      if (Arrays.stream(times).allMatch(Objects::nonNull)) {
         return AttendStatusEnum.NORMAL.getType();
      } else {
         return Arrays.stream(times).noneMatch(Objects::nonNull) ? AttendStatusEnum.ABSENTEE.getType() : AttendStatusEnum.ABSENCE.getType();
      }
   }

   private boolean isBeforeOrEqual(LocalDateTime time1, LocalDateTime time2) {
      return time1.isBefore(time2) || time1.isEqual(time2);
   }

   private boolean isAfterOrEqual(LocalDateTime time1, LocalDateTime time2) {
      return time1.isAfter(time2) || time1.isEqual(time2);
   }

   private boolean hasEffectiveWokeTime(LocalDateTime w1, LocalDateTime w2, LocalDateTime start, LocalDateTime end) {
      return !this.isBeforeOrEqual(w2, start) && !this.isAfterOrEqual(w1, end);
   }

   private BigDecimal getStandardHour(LocalDateTime t1, LocalDateTime t2) {
      if (t1 != null && t2 != null) {
         Duration duration = Duration.between(t1, t2);
         return BigDecimal.valueOf(duration.toMillis()).divide(BigDecimal.valueOf(3600000L), 2, RoundingMode.HALF_UP);
      } else {
         return BigDecimal.ZERO;
      }
   }

   private LocalDateTime getMinDateTime(LocalDateTime dt1, LocalDateTime dt2) {
      return dt1.isBefore(dt2) ? dt1 : dt2;
   }

   private LocalDateTime getMaxDateTime(LocalDateTime dt1, LocalDateTime dt2) {
      return dt1.isBefore(dt2) ? dt2 : dt1;
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

   private LocalDateTime removeSeconds(LocalDateTime localDateTime) {
      return localDateTime == null ? null : localDateTime.truncatedTo(ChronoUnit.MINUTES);
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
}
