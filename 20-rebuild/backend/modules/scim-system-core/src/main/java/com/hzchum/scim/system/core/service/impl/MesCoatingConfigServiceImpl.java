package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClassification;
import com.hzchum.scim.system.core.api.pojo._do.MesCoatingConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesCoatingConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesCoatingConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesArtifactClassificationService;
import com.hzchum.scim.system.core.api.service.MesCoatingConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesCoatingConfigMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesCoatingConfigServiceImpl extends ServiceImpl<MesCoatingConfigMapper, MesCoatingConfig> implements MesCoatingConfigService {
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesArtifactClassificationService artifactClassificationService;

   @Override
   public List<MesCoatingConfigDTO> listInfo() {
      return this.baseMapper.listInfo();
   }

   @Override
   public MesCoatingConfigDTO detailById(Long id) {
      return this.baseMapper.detailById(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveCoatingConfig(MesCoatingConfigSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      Boolean artifactClassificationIsExist = this.baseMapper.artifactClassificationIsExist(null, param.getArtifactClassificationIdList());
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
      MesCoatingConfig coatingConfig = BeanUtil.toBean(param, MesCoatingConfig.class);
      coatingConfig.setArtifactClassification(CollUtil.join(param.getArtifactClassificationIdList(), ","));
      this.baseMapper.insert(coatingConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateCoatingConfig(MesCoatingConfigSaveDTOParam param) {
      MesCoatingConfig coatingConfigOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(coatingConfigOld != null, "当前涂装配置不存在");
      Boolean artifactClassificationIsExist = this.baseMapper.artifactClassificationIsExist(param.getId(), param.getArtifactClassificationIdList());
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
      MesCoatingConfig coatingConfig = BeanUtil.toBean(param, MesCoatingConfig.class);
      coatingConfig.setArtifactClassification(CollUtil.join(param.getArtifactClassificationIdList(), ","));
      this.baseMapper.updateById(coatingConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Boolean status) {
      MesCoatingConfig coatingConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(coatingConfig != null, "当前涂装配置不存在");
      coatingConfig.setStatus(status);
      this.baseMapper.updateById(coatingConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesCoatingConfig coatingConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(coatingConfig != null, "当前涂装配置不存在");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }
}
