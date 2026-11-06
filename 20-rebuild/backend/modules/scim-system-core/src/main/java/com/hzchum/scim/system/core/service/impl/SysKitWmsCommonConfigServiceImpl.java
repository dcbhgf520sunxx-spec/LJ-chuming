package com.hzchum.scim.system.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.pojo._do.KitWmsCommonConfigDTO;
import com.hzchum.scim.system.core.api.pojo._do.KitWmsConfigurationDetailDTO;
import com.hzchum.scim.system.core.api.pojo._do.SysKitWmsCommonConfig;
import com.hzchum.scim.system.core.api.pojo.vo.KitWmsCommonConfigVO;
import com.hzchum.scim.system.core.api.service.SysKitWmsCommonConfigService;
import com.hzchum.scim.system.core.mapper.SysKitWmsCommonConfigMapper;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysKitWmsCommonConfigServiceImpl extends ServiceImpl<SysKitWmsCommonConfigMapper, SysKitWmsCommonConfig> implements SysKitWmsCommonConfigService {
   @Value("${module}")
   private String module;
   @Autowired
   private ContractProjectService projectService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveKitWmsCommonConfig(KitWmsCommonConfigVO configurationVO) {
      if (!configurationVO.getBoolGeneralConfig()) {
         Preconditions.checkArgument(this.module.contains("wms"), "操作失败,当前版本配置不存在WMS模块");
      } else {
         Preconditions.checkArgument(CollectionUtils.isEmpty(configurationVO.getDetailList()), "操作失败,新增通用配置时,不可存在项目配置信息!");
      }

      SysKitWmsCommonConfig kitWmsCommonConfig = this.getOne(
         (Wrapper<SysKitWmsCommonConfig>)new LambdaQueryWrapper<SysKitWmsCommonConfig>().eq(SysKitWmsCommonConfig::getBoolGeneralConfig, configurationVO.getBoolGeneralConfig())
      );
      if (kitWmsCommonConfig == null) {
         kitWmsCommonConfig = SysKitWmsCommonConfig.builder()
            .boolGeneralConfig(configurationVO.getBoolGeneralConfig())
            .value(JSON.toJSONString(configurationVO))
            .build();
      } else {
         kitWmsCommonConfig.setValue(JSON.toJSONString(configurationVO));
      }

      this.saveOrUpdate(kitWmsCommonConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateKitWmsCommonConfig(KitWmsCommonConfigVO configurationVO) {
      if (!configurationVO.getBoolGeneralConfig()) {
         Preconditions.checkArgument(this.module.contains("wms"), "操作失败,当前版本配置不存在WMS模块");
      } else {
         Preconditions.checkArgument(configurationVO.getDetailList() == null, "操作失败,新增通用配置时,不可存在项目信息!");
      }

      SysKitWmsCommonConfig associationsConfiguration = this.getOne(
         (Wrapper<SysKitWmsCommonConfig>)new LambdaQueryWrapper<SysKitWmsCommonConfig>().eq(SysKitWmsCommonConfig::getBoolGeneralConfig, configurationVO.getBoolGeneralConfig())
      );
      Preconditions.checkArgument(associationsConfiguration != null, "修改失败,清单误差配置不存在!");
      associationsConfiguration.setValue(JSON.toJSONString(configurationVO));
      this.updateById(associationsConfiguration);
      return Boolean.TRUE;
   }

   @Override
   public KitWmsCommonConfigDTO getKitWmsCommonConfigList(Boolean boolGeneralConfig, Long projectId, Integer pageNumber, Integer pageSize) {
      boolGeneralConfig = boolGeneralConfig == null ? Boolean.TRUE : boolGeneralConfig;
      SysKitWmsCommonConfig kitWmsAssociationsConfigurationList = this.getOne(
         (Wrapper<SysKitWmsCommonConfig>)new LambdaQueryWrapper<SysKitWmsCommonConfig>().eq(SysKitWmsCommonConfig::getBoolGeneralConfig, boolGeneralConfig)
      );
      if (kitWmsAssociationsConfigurationList == null) {
         return new KitWmsCommonConfigDTO();
      }

      KitWmsCommonConfigDTO configurationDTO = JSON.parseObject(kitWmsAssociationsConfigurationList.getValue(), KitWmsCommonConfigDTO.class);
      if (!boolGeneralConfig && CollectionUtils.isNotEmpty(configurationDTO.getDetailList())) {
         Map<Long, String> projectMap = this.projectService
            .listByIds(configurationDTO.getDetailList().stream().map(KitWmsConfigurationDetailDTO::getProjectId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(e -> e.getId(), e -> e.getShortName()));
         configurationDTO.getDetailList().forEach(e -> e.setProjectName(projectMap.get(e.getProjectId())));
      }

      return configurationDTO;
   }

   @Override
   public KitWmsCommonConfigDTO getKitWmsCommonConfigList(Long projectId) {
      SysKitWmsCommonConfig commonConfig = this.getOne(
         (Wrapper<SysKitWmsCommonConfig>)new LambdaQueryWrapper<SysKitWmsCommonConfig>().eq(SysKitWmsCommonConfig::getBoolGeneralConfig, Boolean.FALSE)
      );
      if (commonConfig == null) {
         commonConfig = this.getOne((Wrapper<SysKitWmsCommonConfig>)new LambdaQueryWrapper<SysKitWmsCommonConfig>().eq(SysKitWmsCommonConfig::getBoolGeneralConfig, Boolean.TRUE));
      }

      Preconditions.checkArgument(commonConfig != null, "操作失败,清单误差配置不存在!");
      return JSON.parseObject(commonConfig.getValue(), KitWmsCommonConfigDTO.class);
   }

   @Override
   public Boolean deleteKitWmsCommonConfig(Long projectId) {
      SysKitWmsCommonConfig projectKitWmsCommonConfig = this.getOne(
         (Wrapper<SysKitWmsCommonConfig>)new LambdaQueryWrapper<SysKitWmsCommonConfig>().eq(SysKitWmsCommonConfig::getBoolGeneralConfig, Boolean.FALSE)
      );
      if (projectKitWmsCommonConfig != null) {
         KitWmsCommonConfigDTO configurationDTO = JSON.parseObject(projectKitWmsCommonConfig.getValue(), KitWmsCommonConfigDTO.class);
         configurationDTO.getDetailList().removeIf(item -> item.getProjectId().equals(projectId));
         projectKitWmsCommonConfig.setValue(JSON.toJSONString(configurationDTO));
         this.updateById(projectKitWmsCommonConfig);
      }

      return Boolean.TRUE;
   }
}
