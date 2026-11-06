package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.biz.SysProductTraceabilityConfigBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysProductTraceabilityConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysProductTraceabilityConfigDetail;
import com.hzchum.scim.system.core.api.pojo.dto.SysProductTraceabilityConfigDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysProductTraceabilityConfigParam;
import com.hzchum.scim.system.core.api.service.SysProductTraceabilityConfigDetailService;
import com.hzchum.scim.system.core.api.service.SysProductTraceabilityConfigService;
import com.hzchum.scim.system.core.mapper.SysProductTraceabilityConfigMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysProductTraceabilityConfigBizImpl
   extends IBizImpl<SysProductTraceabilityConfigService, SysProductTraceabilityConfigMapper, SysProductTraceabilityConfig>
   implements SysProductTraceabilityConfigBiz {
   private final ContractProjectService projectService;
   private final SysProductTraceabilityConfigDetailService productTraceabilityConfigDetailService;

   @Override
   public SysProductTraceabilityConfig getByProjectId(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      SysProductTraceabilityConfigDetail traceabilityConfigDetail = this.productTraceabilityConfigDetailService
         .getOne(Wrappers.lambdaQuery(SysProductTraceabilityConfigDetail.builder().projectId(projectId).build()));
      return traceabilityConfigDetail != null
         ? this.baseService.getById(traceabilityConfigDetail.getTraceabilityConfigId())
         : this.baseService.getOne(Wrappers.lambdaQuery(SysProductTraceabilityConfig.builder().boolDefault(true).build()));
   }

   @Override
   public List<SysProductTraceabilityConfigDTO> listByCondition(Long projectId, String projectName) {
      List<Long> projectIds = null;
      if (projectName != null) {
         projectIds = this.getProjectIdList(projectName);
      }

      if (projectIds != null && projectIds.isEmpty()) {
         return Collections.emptyList();
      }

      List<SysProductTraceabilityConfigDetail> traceabilityConfigDetailList = this.productTraceabilityConfigDetailService
         .list(
            Wrappers.lambdaQuery(SysProductTraceabilityConfigDetail.class)
               .eq(projectId != null, SysProductTraceabilityConfigDetail::getProjectId, projectId)
               .in(projectIds != null, SysProductTraceabilityConfigDetail::getProjectId, projectIds)
         );
      Set<Long> traceabilityConfigIds = traceabilityConfigDetailList.stream()
         .map(SysProductTraceabilityConfigDetail::getTraceabilityConfigId)
         .collect(Collectors.toSet());
      List<SysProductTraceabilityConfigDTO> dtoList = new ArrayList<>(traceabilityConfigIds.size());
      if (CollectionUtils.isNotEmpty(traceabilityConfigIds)) {
         List<SysProductTraceabilityConfig> traceabilityConfigList = this.baseService.listByIds(traceabilityConfigIds);
         List<SysProductTraceabilityConfigDetail> productTraceabilityConfigDetailList = this.productTraceabilityConfigDetailService
            .list(
               Wrappers.lambdaQuery(SysProductTraceabilityConfigDetail.class)
                  .in(SysProductTraceabilityConfigDetail::getTraceabilityConfigId, traceabilityConfigIds)
            );
         Map<Long, List<Long>> traceabilityConfigIdProjectIdsMap = productTraceabilityConfigDetailList.stream()
            .collect(
               Collectors.groupingBy(
                  SysProductTraceabilityConfigDetail::getTraceabilityConfigId,
                  Collectors.mapping(SysProductTraceabilityConfigDetail::getProjectId, Collectors.toList())
               )
            );
         List<Long> allProjectIds = productTraceabilityConfigDetailList.stream()
            .map(SysProductTraceabilityConfigDetail::getProjectId)
            .collect(Collectors.toList());
         Map<Long, ProjectInfo> projectMap = this.projectService
            .listInfoByIdList(allProjectIds)
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         traceabilityConfigList.forEach(s -> {
            SysProductTraceabilityConfigDTO dto = BeanUtil.copy(s, SysProductTraceabilityConfigDTO.class);
            List<Long> projectIdList = traceabilityConfigIdProjectIdsMap.getOrDefault(s.getId(), Collections.emptyList());
            dto.setProjectList(projectIdList.stream().map(projectMap::get).filter(Objects::nonNull).collect(Collectors.toList()));
            dtoList.add(dto);
         });
      }

      return dtoList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean saveBatch(List<SysProductTraceabilityConfigParam> paramList) {
      List<Long> projectIds = new ArrayList<>(1024);
      paramList.forEach(param -> {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(param.getProjectIdList()), "未传项目数据!!");
         projectIds.addAll(param.getProjectIdList());
      });
      this.baseService.remove(Wrappers.lambdaQuery(SysProductTraceabilityConfig.builder().boolDefault(false).build()));
      this.productTraceabilityConfigDetailService.remove(null);
      Preconditions.checkArgument(projectIds.size() == projectIds.stream().distinct().count(), "项目出现重复!!!");
      if (projectIds.isEmpty()) {
         return true;
      }
      Map<Long, ContractProject> projectMap = this.projectService
         .listByIds(projectIds)
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<SysProductTraceabilityConfigDetail> traceabilityConfigDetailList = new ArrayList<>(1024);
      paramList.forEach(
         param -> {
            SysProductTraceabilityConfig config = BeanUtil.copy(param, SysProductTraceabilityConfig.class);
            config.setCreateUserId(UserUtil.getCurrentUserId());
            config.setBoolDefault(false);
            this.baseService.save(config);
            param.getProjectIdList()
               .forEach(
                  projectId -> {
                     ContractProject project = projectMap.get(projectId);
                     Preconditions.checkArgument(project != null, "项目不存在!");
                     SysProductTraceabilityConfigDetail detail = SysProductTraceabilityConfigDetail.builder()
                        .traceabilityConfigId(config.getId())
                        .projectId(projectId)
                        .build();
                     traceabilityConfigDetailList.add(detail);
                  }
               );
         }
      );
      this.productTraceabilityConfigDetailService.saveBatch(traceabilityConfigDetailList);
      return true;
   }

   @Override
   public SysProductTraceabilityConfig getDefault() {
      return this.baseService.getOne(Wrappers.lambdaQuery(SysProductTraceabilityConfig.builder().boolDefault(true).build()));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveDefault(SysProductTraceabilityConfigParam param) {
      SysProductTraceabilityConfig defaultConfig = this.baseService
         .getOne(Wrappers.lambdaQuery(SysProductTraceabilityConfig.builder().boolDefault(true).build()));
      if (defaultConfig != null) {
         defaultConfig.setSystemName(param.getSystemName());
         defaultConfig.setCompanyName(param.getCompanyName());
         defaultConfig.setProductionBaseName(param.getProductionBaseName());
         this.baseService.updateById(defaultConfig);
      } else {
         defaultConfig = BeanUtil.copy(param, SysProductTraceabilityConfig.class);
         defaultConfig.setCreateUserId(UserUtil.getCurrentUserId());
         defaultConfig.setBoolDefault(true);
         this.baseService.save(defaultConfig);
      }

      return true;
   }

   private List<Long> getProjectIdList(String projectName) {
      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .and(
                  w -> {
                     LambdaQueryWrapper var10000 = w.like(ContractProject::getName, projectName)
                        .or()
                        .like(ContractProject::getShortName, projectName)
                        .or()
                        .like(ContractProject::getSerialNumber, projectName);
                  }
               )
         );
      return projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
   }

   public SysProductTraceabilityConfigBizImpl(
      final ContractProjectService projectService, final SysProductTraceabilityConfigDetailService productTraceabilityConfigDetailService
   ) {
      this.projectService = projectService;
      this.productTraceabilityConfigDetailService = productTraceabilityConfigDetailService;
   }
}
