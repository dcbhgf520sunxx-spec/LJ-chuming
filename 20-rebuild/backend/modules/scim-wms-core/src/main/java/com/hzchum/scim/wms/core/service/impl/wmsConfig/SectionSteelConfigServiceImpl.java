package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Standard;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.BatchSectionSteelDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SectionSteelDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SectionSteelConfigService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.ClassificationMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelConfigMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelSpecMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelSpecStandardDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.StandardMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SectionSteelConfigServiceImpl extends ServiceImpl<SectionSteelConfigMapper, SectionSteelConfig> implements SectionSteelConfigService {
   @Resource
   SectionSteelConfigMapper sectionSteelConfigMapper;
   @Resource
   private ClassificationMapper classificationMapper;
   @Resource
   SectionSteelSpecStandardDetailMapper standardDetailMapper;
   @Resource
   SectionSteelSpecMapper sectionSteelSpecMapper;
   @Resource
   StandardMapper standardMapper;

   @Override
   public PageVO<SectionSteelDTO> listInfo() {
      List<Classification> classifications = this.classificationMapper
         .selectList(
            (Wrapper<Classification>)(Wrappers.<Classification>lambdaQuery().eq(Classification::getBasicClass, 2)).orderByAsc(Classification::getParentId)
         );
      if (CollectionUtils.isEmpty(classifications)) {
         return null;
      }

      Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
      List<SectionSteelDTO> build = this.build(0L, subjectMap);
      return new PageVO<>(build);
   }

   private List<SectionSteelDTO> build(Long pid, Map<Long, List<Classification>> subjectMap) {
      List<Classification> classifications = subjectMap.get(pid);
      return CollectionUtils.isEmpty(classifications)
         ? null
         : classifications.stream()
            .map(
               subject -> {
                  SectionSteelConfig steelConfig = this.sectionSteelConfigMapper
                     .selectOne((Wrapper<SectionSteelConfig>)Wrappers.<SectionSteelConfig>lambdaQuery().eq(SectionSteelConfig::getClassificationId, subject.getId()));
                  SectionSteelDTO tree = BeanUtil.copy(steelConfig, SectionSteelDTO.class);
                  tree.setName(subject.getName());
                  tree.setSerialNumber(subject.getSerialNumber());
                  tree.setChildren(this.build(steelConfig.getClassificationId(), subjectMap));
                  return tree;
               }
            )
            .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean sectionSteelUpdate(SectionSteelDTOParam param) {
      SectionSteelConfig steelConfig = this.getSectionSteelConfig(param.getSectionSteelId(), param.getStandardId());
      return this.sectionSteelConfigMapper.updateById(steelConfig) == 1;
   }

   @NotNull
   private SectionSteelConfig getSectionSteelConfig(Long sectionSteelId, Long standardId) {
      SectionSteelConfig steelConfig = this.sectionSteelConfigMapper.selectById(sectionSteelId);
      Preconditions.checkArgument(steelConfig != null, "修改失败,当前操作型材配置不存在");
      Standard standard = this.standardMapper.selectById(standardId);
      Preconditions.checkArgument(standard != null, "修改失败,国标错误");
      steelConfig.setStandardName(standard.getName());
      steelConfig.setStandardId(standardId);
      steelConfig.setUpdateTime(LocalDateTime.now());
      return steelConfig;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean BatchSectionSteelUpdate(BatchSectionSteelDTOParam param) {
      for (SectionSteelDTOParam steelDTOParam : param.getSectionSteelIds()) {
         this.sectionSteelConfigMapper.updateById(this.getSectionSteelConfig(steelDTOParam.getId(), param.getStandardId()));
      }

      return true;
   }
}
