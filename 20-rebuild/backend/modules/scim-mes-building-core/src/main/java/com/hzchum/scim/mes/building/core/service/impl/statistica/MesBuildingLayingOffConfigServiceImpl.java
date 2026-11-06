package com.hzchum.scim.mes.building.core.service.impl.statistica;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.NumberUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingCutConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingLayingOffConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingLayingOffConfigDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingCutConfigService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingLayingOffConfigService;
import com.hzchum.scim.mes.building.core.mapper.statistica.MesBuildingLayingOffConfigMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingLayingOffConfigServiceImpl
   extends ServiceImpl<MesBuildingLayingOffConfigMapper, MesBuildingLayingOffConfig>
   implements MesBuildingLayingOffConfigService {
   @Resource
   private MesBuildingCutConfigService mesBuildingCutConfigService;

   @Override
   public Boolean saveLayingOffList(List<MesBuildingLayingOffConfigDTO> dtoList) {
      dtoList.forEach(
         dto -> {
            MesBuildingCutConfig cutConfig = this.mesBuildingCutConfigService.getById(dto.getCutConfigId());
            Preconditions.checkArgument(cutConfig != null, "下料方式不存在!!!");
            Preconditions.checkArgument(dto.getMaxNumerical().compareTo(dto.getMinNumerical()) >= 0, "最小数值不能大于最大数值");
            List<MesBuildingLayingOffConfig> mesBuildingLayingOffConfigs = this.baseMapper
               .selectList(
                  (Wrapper<MesBuildingLayingOffConfig>)(new LambdaQueryWrapper<MesBuildingLayingOffConfig>()
                        .eq(MesBuildingLayingOffConfig::getCutConfigId, dto.getCutConfigId()))
                     .eq(MesBuildingLayingOffConfig::getSpecPrefix, dto.getSpecPrefix())
               );
            if (CollectionUtils.isNotEmpty(mesBuildingLayingOffConfigs)) {
               mesBuildingLayingOffConfigs.forEach(
                  config -> Preconditions.checkArgument(
                     NumberUtil.rangeInDefined(dto.getMinNumerical(), dto.getMaxNumerical(), config.getMinNumerical(), config.getMaxNumerical()), "数值范围已存在!!!"
                  )
               );
            }

            MesBuildingLayingOffConfig copy = BeanUtil.copy(dto, MesBuildingLayingOffConfig.class);
            copy.setCutConfigId(cutConfig.getId());
            copy.setName(cutConfig.getName());
            this.baseMapper.insert(copy);
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingLayingOffConfigDTO> getLayingOffList() {
      List<MesBuildingLayingOffConfig> mesBuildingLayingOffConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<>());
      if (CollectionUtils.isNotEmpty(mesBuildingLayingOffConfigs)) {
         Set<Long> cutConfigIds = mesBuildingLayingOffConfigs.stream().map(MesBuildingLayingOffConfig::getCutConfigId).collect(Collectors.toSet());
         List<MesBuildingCutConfig> cutConfigs = this.mesBuildingCutConfigService.listByIds(cutConfigIds);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(cutConfigIds), "查询失败，下料方式不存在!!!");
         Map<Long, MesBuildingCutConfig> cutConfigMap = cutConfigs.stream()
            .collect(Collectors.toMap(MesBuildingCutConfig::getId, e -> (MesBuildingCutConfig)e));
         List<MesBuildingLayingOffConfigDTO> layingOffConfigDTOS = mesBuildingLayingOffConfigs.stream()
            .map(config -> BeanUtil.copy(config, MesBuildingLayingOffConfigDTO.class))
            .collect(Collectors.toList());
         layingOffConfigDTOS.forEach(e -> {
            MesBuildingCutConfig cutConfig = cutConfigMap.get(e.getCutConfigId());
            e.setName(cutConfig.getName());
         });
         return layingOffConfigDTOS;
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public Boolean updateLayingOff(MesBuildingLayingOffConfigDTO dto) {
      MesBuildingLayingOffConfig config = this.baseMapper.selectById(dto.getId());
      Preconditions.checkArgument(config != null, "零件下料配置不存在");
      if (!config.getCutConfigId().equals(dto.getCutConfigId())) {
         MesBuildingCutConfig cutConfig = this.mesBuildingCutConfigService.getById(dto.getCutConfigId());
         Preconditions.checkArgument(cutConfig != null, "下料方式不存在!!!");
      }

      List<MesBuildingLayingOffConfig> mesBuildingLayingOffConfigs = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingLayingOffConfig>)((new LambdaQueryWrapper<MesBuildingLayingOffConfig>()
                     .eq(MesBuildingLayingOffConfig::getCutConfigId, dto.getCutConfigId()))
                  .eq(MesBuildingLayingOffConfig::getSpecPrefix, dto.getSpecPrefix()))
               .ne(MesBuildingLayingOffConfig::getId, config.getId())
         );
      if (dto.getMinNumerical().compareTo(config.getMinNumerical()) != 0 || dto.getMaxNumerical().compareTo(config.getMaxNumerical()) != 0) {
         mesBuildingLayingOffConfigs.forEach(
            e -> Preconditions.checkArgument(
               NumberUtil.rangeInDefined(dto.getMinNumerical(), dto.getMaxNumerical(), e.getMinNumerical(), e.getMaxNumerical()), "数值范围已存在!!!"
            )
         );
      }

      BeanUtil.copy(dto, config);
      this.baseMapper.updateById(config);
      return Boolean.TRUE;
   }

   @Override
   public Boolean removeLayingOff(List<Long> ids) {
      Preconditions.checkArgument(this.baseMapper.selectBatchIds(ids).size() == ids.size(), "删除失败，零件下料配置不存在");
      this.baseMapper.deleteBatchIds(ids);
      return Boolean.TRUE;
   }
}
