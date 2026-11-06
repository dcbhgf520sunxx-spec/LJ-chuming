package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpecStandardDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Standard;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.StandardDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.StandardService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelConfigMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelSpecStandardDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.StandardMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StandardServiceImpl extends ServiceImpl<StandardMapper, Standard> implements StandardService {
   @Resource
   StandardMapper standardMapper;
   @Resource
   SectionSteelConfigMapper sectionSteelConfigMapper;
   @Resource
   SectionSteelSpecStandardDetailMapper sectionSteelSpecStandardDetailMapper;

   @Override
   public List<StandardDTO> listStandard() {
      List<Standard> standards = this.standardMapper.selectList(null);
      return standards.stream()
         .map(
            standard -> {
               StandardDTO standardDTO = StandardDTO.builder().build();
               BeanUtils.copyProperties(standard, standardDTO);
               standardDTO.setDeletable(true);
               List<SectionSteelSpecStandardDetail> sectionSteelSpecStandardDetails = this.sectionSteelSpecStandardDetailMapper
                  .selectList(
                     (Wrapper<SectionSteelSpecStandardDetail>)Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery().eq(SectionSteelSpecStandardDetail::getStandardId, standard.getId())
                  );
               if (CollectionUtils.isNotEmpty(sectionSteelSpecStandardDetails)) {
                  standardDTO.setDeletable(false);
               }

               Integer count = this.sectionSteelConfigMapper
                  .selectCount((Wrapper<SectionSteelConfig>)Wrappers.<SectionSteelConfig>lambdaQuery().eq(SectionSteelConfig::getStandardId, standard.getId()));
               if (count != null && count > 0) {
                  standardDTO.setDeletable(false);
               }

               return standardDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addStandard(String name) {
      List<Standard> list = this.standardMapper.selectList((Wrapper<Standard>)Wrappers.<Standard>lambdaQuery().eq(Standard::getName, name));
      Preconditions.checkArgument(CollectionUtils.isEmpty(list), "新增失败,国标名称已存在");
      Standard standard = Standard.builder().build();
      Integer maxCode = this.standardMapper.getMaxCode();
      standard.setCode(maxCode + 1);
      standard.setName(name);
      return this.standardMapper.insert(standard) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delete(Long standardId) {
      Preconditions.checkArgument(this.standardMapper.selectById(standardId) != null, "当前国标不存在");
      Preconditions.checkArgument(
         CollectionUtils.isEmpty(
            this.sectionSteelSpecStandardDetailMapper
               .selectList((Wrapper<SectionSteelSpecStandardDetail>)Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery().eq(SectionSteelSpecStandardDetail::getStandardId, standardId))
         ),
         "删除失败,当前国标已被使用"
      );
      this.standardMapper.deleteById(standardId);
      return true;
   }
}
