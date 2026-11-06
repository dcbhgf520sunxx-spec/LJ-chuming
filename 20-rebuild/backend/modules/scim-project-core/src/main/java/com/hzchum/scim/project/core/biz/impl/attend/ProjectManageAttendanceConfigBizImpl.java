package com.hzchum.scim.project.core.biz.impl.attend;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.project.core.api.biz.attend.ProjectManageAttendanceConfigBiz;
import com.hzchum.scim.project.core.api.biz.attend.ProjectManageAttendanceFenceBiz;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceConfig;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceFence;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceConfigDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageAttendanceConfigDTOParam;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceConfigService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceService;
import com.hzchum.scim.project.core.mapper.attend.ProjectManageAttendanceConfigMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectManageAttendanceConfigBizImpl
   extends IBizImpl<ProjectManageAttendanceConfigService, ProjectManageAttendanceConfigMapper, ProjectManageAttendanceConfig>
   implements ProjectManageAttendanceConfigBiz {
   @Resource
   private ContractProjectBiz contractProjectBiz;
   @Resource
   private ProjectManageAttendanceFenceBiz attendanceFenceBiz;
   @Resource
   private ProjectManageAttendanceService attendanceService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean setAttendanceTime(ProjectManageAttendanceConfigDTOParam param) {
      param.setMorningWorkingTime(this.removeSeconds(param.getMorningWorkingTime()));
      param.setMorningClosingTime(this.removeSeconds(param.getMorningClosingTime()));
      param.setAfternoonWorkingTime(this.removeSeconds(param.getAfternoonWorkingTime()));
      param.setAfternoonClosingTime(this.removeSeconds(param.getAfternoonClosingTime()));
      ContractProject contractProject = this.contractProjectBiz.getById(param.getProjectId());
      Preconditions.checkArgument(contractProject != null, "项目不存在");
      Preconditions.checkArgument(param.getMorningClosingTime().toLocalTime().isAfter(param.getMorningWorkingTime().toLocalTime()), "上午下班时间不能早于上午上班时间");
      Preconditions.checkArgument(param.getAfternoonClosingTime().toLocalTime().isAfter(param.getAfternoonWorkingTime().toLocalTime()), "下午下班时间不能早于下午上班时间");
      ProjectManageAttendanceConfig config = this.baseService
         .getOne(Wrappers.lambdaQuery(ProjectManageAttendanceConfig.class).eq(ProjectManageAttendanceConfig::getProjectId, param.getProjectId()));
      if (config == null) {
         Preconditions.checkArgument(!param.getIsClose(), "操作失败！首次新增配置信息不可关闭配置！");
         config = BeanUtil.copy(param, ProjectManageAttendanceConfig.class);
         config.setPunchTimes(4);
         config.setWorkHours(
            this.getStandardHour(param.getMorningWorkingTime(), param.getMorningClosingTime())
               .add(this.getStandardHour(param.getAfternoonWorkingTime(), param.getAfternoonClosingTime()))
         );
         config.setSupplierScope(StringUtils.join(param.getSupplierScope(), ","));
         this.baseService.save(config);
         this.attendanceService.saveProjectAttendanceInfo(config);
      } else {
         boolean isUpdateClose = !param.getIsClose().equals(config.getIsClose());
         boolean isUpdateSupplier = CollectionUtils.isNotEmpty(param.getSupplierScope())
            && !config.getSupplierScope().equals(StringUtils.join(param.getSupplierScope(), ","));
         BeanUtil.copy(param, config);
         config.setSupplierScope(StringUtils.join(param.getSupplierScope(), ","));
         config.setWorkHours(
            this.getStandardHour(param.getMorningWorkingTime(), param.getMorningClosingTime())
               .add(this.getStandardHour(param.getAfternoonWorkingTime(), param.getAfternoonClosingTime()))
         );
         this.baseService.updateById(config);
         this.attendanceService.updateAttendanceInfoCancel(isUpdateClose, isUpdateSupplier, config);
      }

      if (param.getIsNeedFence() != null && param.getIsNeedFence()) {
         this.attendanceFenceBiz
            .remove(Wrappers.lambdaQuery(ProjectManageAttendanceFence.class).eq(ProjectManageAttendanceFence::getProjectId, param.getProjectId()));
         this.attendanceFenceBiz.setAttendanceFence(param.getProjectManageAttendanceFenceDTOParamList());
      }

      return true;
   }

   @Override
   public ProjectManageAttendanceConfigDTO getAttendanceTime(Long projectId) {
      Preconditions.checkArgument(projectId != null, "项目Id不能为空");
      ProjectManageAttendanceConfig config = this.baseService
         .getOne(Wrappers.lambdaQuery(ProjectManageAttendanceConfig.class).eq(ProjectManageAttendanceConfig::getProjectId, projectId));
      if (config == null) {
         return new ProjectManageAttendanceConfigDTO();
      }

      ProjectManageAttendanceConfigDTO configDTO = BeanUtil.copy(config, ProjectManageAttendanceConfigDTO.class);
      configDTO.setSupplierScope(Arrays.stream(StringUtils.split(config.getSupplierScope(), ",")).map(Long::valueOf).collect(Collectors.toList()));
      if (config.getIsNeedFence()) {
         configDTO.setProjectManageAttendanceFenceDTOList(this.attendanceFenceBiz.getAttendanceFence(projectId));
      }

      return configDTO;
   }

   private BigDecimal getStandardHour(LocalDateTime t1, LocalDateTime t2) {
      if (t1 != null && t2 != null) {
         Duration duration = Duration.between(t1, t2);
         return BigDecimal.valueOf(duration.toMillis()).divide(BigDecimal.valueOf(3600000L), 2, RoundingMode.HALF_UP);
      } else {
         return BigDecimal.ZERO;
      }
   }

   private LocalDateTime removeSeconds(LocalDateTime localDateTime) {
      return localDateTime == null ? null : localDateTime.truncatedTo(ChronoUnit.MINUTES);
   }
}
