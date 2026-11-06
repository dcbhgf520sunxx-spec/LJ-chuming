package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingCoatingConfig;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingCoatingConfigService;
import com.hzchum.scim.mes.enclosure.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClassification;
import com.hzchum.scim.system.core.api.pojo._do.MesCoatingConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectCoatingConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesCoatingConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectCoatingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectCoatingConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MesArtifactClassificationService;
import com.hzchum.scim.system.core.api.service.MesCoatingConfigService;
import com.hzchum.scim.system.core.api.service.MesContractProjectCoatingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesContractProjectCoatingConfigLinkMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectCoatingConfigLinkServiceImpl
   extends ServiceImpl<MesContractProjectCoatingConfigLinkMapper, MesContractProjectCoatingConfigLink>
   implements MesContractProjectCoatingConfigLinkService {
   @Autowired
   private MesArtifactClassificationService artifactClassificationService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private ConfigService configService;
   @Autowired
   private MesCoatingConfigService coatingConfigService;
   @Autowired
   private MesBuildingCoatingConfigService buildingCoatingConfigService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;

   @Override
   public List<MesContractProjectCoatingConfigLinkDTO> listInfo(Long projectId) {
      return this.baseMapper.listInfo(projectId);
   }

   @Override
   public List<MesContractProjectCoatingConfigLinkDTO> listInfoByContractProjectIds(List<Long> contractProjectIds) {
      return this.baseMapper.listInfoByContractProjectIds(contractProjectIds);
   }

   @Override
   public MesContractProjectCoatingConfigLinkDTO detailById(Long id) {
      return this.baseMapper.detailById(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveConfig(MesContractProjectCoatingConfigLinkSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      Boolean artifactClassificationIsExist = this.baseMapper
         .artifactClassificationIsExist(null, param.getContractProjectId(), param.getArtifactClassificationIdList());
      Preconditions.checkArgument(!artifactClassificationIsExist, "构件分类重复");
      Integer artifactClassificationCount = this.artifactClassificationService
         .count(Wrappers.lambdaQuery(MesArtifactClassification.class).in(MesArtifactClassification::getId, param.getArtifactClassificationIdList()));
      Preconditions.checkArgument(artifactClassificationCount.equals(param.getArtifactClassificationIdList().size()), "包含不存在的构件分类");
      Preconditions.checkArgument(
         CollUtil.newArrayList(
               PaintingTypeEnum.PRIMER.getType(),
               PaintingTypeEnum.PRIMER.getType() + PaintingTypeEnum.INTERMEDIATE_PAINT.getType(),
               PaintingTypeEnum.PRIMER.getType() + PaintingTypeEnum.INTERMEDIATE_PAINT.getType() + PaintingTypeEnum.TOPCOAT.getType()
            )
            .contains(param.getPaintType()),
         "油漆类型不存在"
      );
      Preconditions.checkArgument(CollUtil.newArrayList(WageQuotaTypeEnum.WEIGHT_PRICE.getType()).contains(param.getMeasurementManner()), "计量方式不存在");
      MesContractProjectCoatingConfigLink config = BeanUtil.toBean(param, MesContractProjectCoatingConfigLink.class);
      config.setArtifactClassification(CollUtil.join(param.getArtifactClassificationIdList(), ","));
      this.baseMapper.insert(config);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateConfig(MesContractProjectCoatingConfigLinkSaveDTOParam param) {
      MesContractProjectCoatingConfigLink oldConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldConfig != null, "当前涂装配置不存在");
      Boolean artifactClassificationIsExist = this.baseMapper
         .artifactClassificationIsExist(param.getId(), param.getContractProjectId(), param.getArtifactClassificationIdList());
      Preconditions.checkArgument(!artifactClassificationIsExist, "构件分类重复");
      Integer artifactClassificationCount = this.artifactClassificationService
         .count(Wrappers.lambdaQuery(MesArtifactClassification.class).in(MesArtifactClassification::getId, param.getArtifactClassificationIdList()));
      Preconditions.checkArgument(artifactClassificationCount.equals(param.getArtifactClassificationIdList().size()), "包含不存在的构件分类");
      Preconditions.checkArgument(
         CollUtil.newArrayList(
               PaintingTypeEnum.PRIMER.getType(),
               PaintingTypeEnum.PRIMER.getType() + PaintingTypeEnum.INTERMEDIATE_PAINT.getType(),
               PaintingTypeEnum.PRIMER.getType() + PaintingTypeEnum.INTERMEDIATE_PAINT.getType() + PaintingTypeEnum.TOPCOAT.getType()
            )
            .contains(param.getPaintType()),
         "油漆类型不存在"
      );
      Preconditions.checkArgument(CollUtil.newArrayList(WageQuotaTypeEnum.WEIGHT_PRICE.getType()).contains(param.getMeasurementManner()), "计量方式不存在");
      MesContractProjectCoatingConfigLink newConfig = BeanUtil.toBean(param, MesContractProjectCoatingConfigLink.class);
      newConfig.setArtifactClassification(CollUtil.join(param.getArtifactClassificationIdList(), ","));
      this.baseMapper.updateById(newConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Boolean status) {
      MesContractProjectCoatingConfigLink config = this.baseMapper.selectById(id);
      Preconditions.checkArgument(config != null, "当前涂装配置不存在");
      config.setStatus(status);
      this.baseMapper.updateById(config);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesContractProjectCoatingConfigLink config = this.baseMapper.selectById(id);
      Preconditions.checkArgument(config != null, "当前涂装配置不存在");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectCoatingConfigLink(Long contractProjectId) {
      ContractProject contractProject = this.contractProjectService.getById(contractProjectId);
      Preconditions.checkArgument(contractProject != null, "合同项目不存在");
      Integer measurementManner = this.configService.getCoatingConfigMeasurementManner();
      if (measurementManner == null) {
         return Boolean.TRUE;
      }

      List<MesContractProjectCoatingConfigLink> coatingConfigLinkList = new ArrayList<>();
      if (com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum.AREA_PRICE.getType() == measurementManner) {
         List<MesBuildingCoatingConfig> buildingCoatingConfigList = this.buildingCoatingConfigService.list();
         if (CollUtil.isEmpty(buildingCoatingConfigList)) {
            return Boolean.TRUE;
         }

         coatingConfigLinkList = buildingCoatingConfigList.stream().map(cc -> {
            MesContractProjectCoatingConfigLink coatingConfigLink = BeanUtil.toBean(cc, MesContractProjectCoatingConfigLink.class);
            coatingConfigLink.setContractProjectId(contractProjectId);
            coatingConfigLink.setMeasurementManner(measurementManner);
            coatingConfigLink.setPaintType(cc.getType());
            return coatingConfigLink;
         }).collect(Collectors.toList());
      }

      if (com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum.WEIGHT_PRICE.getType() == measurementManner) {
         List<MesCoatingConfigDTO> coatingConfigDTOList = this.coatingConfigService.listInfo();
         if (CollUtil.isEmpty(coatingConfigDTOList)) {
            return Boolean.TRUE;
         }

         coatingConfigLinkList = coatingConfigDTOList.stream().filter(MesCoatingConfig::getStatus).map(cc -> {
            MesContractProjectCoatingConfigLink coatingConfigLink = BeanUtil.toBean(cc, MesContractProjectCoatingConfigLink.class);
            coatingConfigLink.setContractProjectId(contractProjectId);
            coatingConfigLink.setMeasurementManner(measurementManner);
            return coatingConfigLink;
         }).collect(Collectors.toList());
      }

      this.saveBatch(coatingConfigLinkList, coatingConfigLinkList.size());
      return Boolean.TRUE;
   }
}
