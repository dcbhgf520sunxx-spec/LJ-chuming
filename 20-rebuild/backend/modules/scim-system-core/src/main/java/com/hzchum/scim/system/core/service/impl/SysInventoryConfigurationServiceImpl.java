package com.hzchum.scim.system.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.pojo._do.SysInventoryConfiguration;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.vo.InventoryConfigurationVO;
import com.hzchum.scim.system.core.api.service.SysInventoryConfigurationService;
import com.hzchum.scim.system.core.mapper.SysInventoryConfigurationMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysInventoryConfigurationServiceImpl
   extends ServiceImpl<SysInventoryConfigurationMapper, SysInventoryConfiguration>
   implements SysInventoryConfigurationService {
   @Resource
   private ContractProjectService contractProjectService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveInventoryConfiguration(InventoryConfigurationVO configurationVO) {
      if (!configurationVO.getBoolGeneralConfig()) {
         Preconditions.checkArgument(configurationVO.getProjectId() != null, "操作失败,非通用配置需要选择项目!");
         ContractProject project = this.contractProjectService.getById(configurationVO.getProjectId());
         Preconditions.checkArgument(project != null, "操作失败,项目不存在!");
         SysInventoryConfiguration inventoryConfiguration = this.getOne(
            (Wrapper<SysInventoryConfiguration>)new LambdaQueryWrapper<SysInventoryConfiguration>().eq(SysInventoryConfiguration::getProjectId, project.getId())
         );
         Preconditions.checkArgument(inventoryConfiguration == null, "新增失败,该项目已配置清单误差!");
         configurationVO.setProjectName(project.getName());
         configurationVO.setProjectShortName(project.getShortName());
         configurationVO.setProjectSerialNumber(project.getSerialNumber());
      } else {
         Preconditions.checkArgument(configurationVO.getProjectId() == null, "操作失败,新增通用配置时,不可存在项目信息!");
         SysInventoryConfiguration inventoryConfiguration = this.getOne(
            (Wrapper<SysInventoryConfiguration>)new LambdaQueryWrapper<SysInventoryConfiguration>()
               .eq(SysInventoryConfiguration::getBoolGeneralConfig, configurationVO.getBoolGeneralConfig())
         );
         Preconditions.checkArgument(inventoryConfiguration == null, "新增失败,已配置通用清单误差!");
      }

      SysInventoryConfiguration inventoryConfiguration = SysInventoryConfiguration.builder()
         .projectId(configurationVO.getProjectId())
         .boolGeneralConfig(configurationVO.getBoolGeneralConfig())
         .value(JSON.toJSONString(configurationVO))
         .build();
      this.save(inventoryConfiguration);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateInventoryConfiguration(InventoryConfigurationVO configurationVO) {
      if (!configurationVO.getBoolGeneralConfig()) {
         Preconditions.checkArgument(configurationVO.getProjectId() != null, "操作失败,非通用配置需要选择项目!");
         ContractProject project = this.contractProjectService.getById(configurationVO.getProjectId());
         Preconditions.checkArgument(project != null, "操作失败,项目不存在!");
         configurationVO.setProjectName(project.getName());
         configurationVO.setProjectShortName(project.getShortName());
         configurationVO.setProjectSerialNumber(project.getSerialNumber());
      } else {
         Preconditions.checkArgument(configurationVO.getProjectId() == null, "操作失败,新增通用配置时,不可存在项目信息!");
      }

      SysInventoryConfiguration inventoryConfiguration = this.getOne(
         (new LambdaQueryWrapper<SysInventoryConfiguration>().eq(SysInventoryConfiguration::getBoolGeneralConfig, configurationVO.getBoolGeneralConfig()))
            .eq(configurationVO.getProjectId() != null, SysInventoryConfiguration::getProjectId, configurationVO.getProjectId())
      );
      Preconditions.checkArgument(inventoryConfiguration != null, "修改失败,清单误差配置不存在!");
      inventoryConfiguration.setValue(JSON.toJSONString(configurationVO));
      this.updateById(inventoryConfiguration);
      return Boolean.TRUE;
   }

   @Override
   public PageVO<InventoryConfigurationDTO> getInventoryConfigurationList(Boolean boolGeneralConfig, Long projectId, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SysInventoryConfiguration> inventoryConfigurationList = this.list(
         (new LambdaQueryWrapper<SysInventoryConfiguration>().eq(SysInventoryConfiguration::getBoolGeneralConfig, boolGeneralConfig))
            .eq(projectId != null, SysInventoryConfiguration::getProjectId, projectId)
      );
      if (CollectionUtils.isEmpty(inventoryConfigurationList)) {
         return new PageVO<>();
      }

      List<InventoryConfigurationDTO> configurationDTOS = inventoryConfigurationList.stream()
         .map(e -> JSON.parseObject(e.getValue(), InventoryConfigurationDTO.class))
         .collect(Collectors.toList());
      return new PageVO<>(configurationDTOS);
   }

   @Override
   public InventoryConfigurationDTO getInventoryConfigurationList(Long projectId) {
      SysInventoryConfiguration inventoryConfiguration = this.getOne(
         (Wrapper<SysInventoryConfiguration>)new LambdaQueryWrapper<SysInventoryConfiguration>().eq(SysInventoryConfiguration::getProjectId, projectId)
      );
      if (inventoryConfiguration == null) {
         inventoryConfiguration = this.getOne(
            (Wrapper<SysInventoryConfiguration>)new LambdaQueryWrapper<SysInventoryConfiguration>().eq(SysInventoryConfiguration::getBoolGeneralConfig, Boolean.TRUE)
         );
      }

      Preconditions.checkArgument(inventoryConfiguration != null, "操作失败,清单误差配置不存在!");
      return JSON.parseObject(inventoryConfiguration.getValue(), InventoryConfigurationDTO.class);
   }

   @Override
   public Boolean deleteInventoryConfiguration(Long projectId) {
      SysInventoryConfiguration projectInventoryConfiguration = this.getOne(
         (Wrapper<SysInventoryConfiguration>)new LambdaQueryWrapper<SysInventoryConfiguration>().eq(SysInventoryConfiguration::getProjectId, projectId)
      );
      if (projectInventoryConfiguration != null) {
         this.removeById(projectInventoryConfiguration);
      }

      return Boolean.TRUE;
   }
}
