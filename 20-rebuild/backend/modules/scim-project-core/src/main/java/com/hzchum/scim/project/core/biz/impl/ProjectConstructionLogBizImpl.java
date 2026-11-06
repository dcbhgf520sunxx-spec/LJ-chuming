package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.project.core.api.biz.ProjectConstructionLogBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectConstructionLog;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectConstructionLogDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ConstructionLogDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectConstructionLogService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectConstructionLogBizImpl implements ProjectConstructionLogBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectConstructionLogBizImpl.class);
   @Resource
   private ProjectConstructionLogService constructionLogService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private UserService userService;

   @Override
   public ListVO<ProjectConstructionLogDTO> listLogDTO(Long projectId, String yearMonth) {
      List<ProjectConstructionLog> constructionLogs = this.constructionLogService.listLogs(projectId, yearMonth, null);
      List<ProjectConstructionLogDTO> logDTOList = constructionLogs.stream()
         .map(s -> BeanUtil.copy(s, ProjectConstructionLogDTO.class))
         .collect(Collectors.toList());
      return new ListVO<>(logDTOList);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveLog(ConstructionLogDTOParam param) {
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      ProjectConstructionLog log = this.constructionLogService
         .getOne(
            Wrappers.lambdaQuery(ProjectConstructionLog.class)
               .eq(ProjectConstructionLog::getProjectId, param.getProjectId())
               .eq(ProjectConstructionLog::getConstructionDate, param.getConstructionDate())
         );
      Preconditions.checkArgument(log == null, "该施工日期已存在施工日志");
      log = BeanUtil.copy(param, ProjectConstructionLog.class);
      User user = this.userService.getById(param.getManagerId());
      Preconditions.checkArgument(user != null, "负责人不存在");
      log.setManagerName(user.getName());
      user = this.userService.getById(param.getRecorderId());
      Preconditions.checkArgument(user != null, "记录人不存在");
      log.setRecorderName(user.getName());
      log.setUserId(UserUtil.getCurrentUserId());
      log.setUserName(UserUtil.getCurrentName());
      log.setId(null);
      return this.constructionLogService.save(log);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean editLog(ConstructionLogDTOParam param) {
      Preconditions.checkArgument(param.getId() != null, "id不能为空");
      ProjectConstructionLog log = this.constructionLogService.getById(param.getId());
      Preconditions.checkArgument(log != null, "施工日志不存在");
      if (!param.getConstructionDate().equals(log.getConstructionDate()) || !param.getProjectId().equals(log.getProjectId())) {
         ProjectConstructionLog constructionLog = this.constructionLogService
            .getOne(
               Wrappers.lambdaQuery(ProjectConstructionLog.class)
                  .eq(ProjectConstructionLog::getProjectId, param.getProjectId())
                  .eq(ProjectConstructionLog::getConstructionDate, param.getConstructionDate())
            );
         Preconditions.checkArgument(constructionLog == null, "项目当天的施工日志已存在");
      }

      BeanUtil.copy(param, log);
      if (!param.getRecorderId().equals(log.getUserId())) {
         User recorder = this.userService.getById(param.getRecorderId());
         Preconditions.checkArgument(recorder != null, "记录人不存在");
         log.setRecorderName(recorder.getName());
      }

      if (!param.getManagerId().equals(log.getManagerId())) {
         User manager = this.userService.getById(param.getManagerId());
         Preconditions.checkArgument(manager != null, "负责人不存在");
         log.setManagerName(manager.getName());
      }

      this.constructionLogService.updateById(log);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean removeLogs(List<Long> ids) {
      ids.forEach(id -> {
         ProjectConstructionLog log = this.constructionLogService.getById(id);
         Preconditions.checkArgument(log != null, "施工日志不存在");
         this.projectService.checkProjectStatus(log.getProjectId());
         this.constructionLogService.removeById(id);
      });
      return true;
   }

   @Override
   public void export(Long projectId, String yearMonth, String day, HttpServletResponse response) {
      List<ProjectConstructionLog> listLogs = this.constructionLogService.listLogs(projectId, yearMonth, day);
      ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
      List<Map<String, Object>> mapList = listLogs.stream().map(log -> {
         Map<String, Object> map = BeanUtil.beanToMap(log);
         map.put("projectName", projectInfo.getName());
         map.put("constructionDate", DateTimeUtil.getLocalDateStr(log.getConstructionDate()));
         return map;
      }).collect(Collectors.toList());
      String templateFilePath = "files/ConstructionLogTemplate.docx";
      String fileName = "施工日志.docx";
      PoiUtils.exportTemplateWord(templateFilePath, mapList, fileName, response);
   }
}
