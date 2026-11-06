package com.hzchum.scim.mes.building.core.service.impl.statistica;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingCoatingConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingCoatingConfigDTO;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingCoatingConfigService;
import com.hzchum.scim.mes.building.core.mapper.statistica.MesBuildingCoatingConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingCoatingConfigServiceImpl
   extends ServiceImpl<MesBuildingCoatingConfigMapper, MesBuildingCoatingConfig>
   implements MesBuildingCoatingConfigService {
   @Override
   public ListVO<MesBuildingCoatingConfigDTO> getCoatingConfigAll() {
      List<MesBuildingCoatingConfig> coatingConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<>());
      List<MesBuildingCoatingConfigDTO> dtoList = BeanUtil.copyToList(coatingConfigs, MesBuildingCoatingConfigDTO.class);
      return new ListVO<>(dtoList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setCoatingConfig(MesBuildingCoatingConfigDTO dto) {
      if (WageQuotaTypeEnum.AREA_PRICE.getType() == dto.getMeasureUnit()) {
         Preconditions.checkArgument(dto.getOutThickness() != null && dto.getOutThickness() % 5 == 0, "超标厚度必须是5的倍数");
         Preconditions.checkArgument(dto.getThickness() != null && dto.getThickness() % 5 == 0, "标准厚度必须是5的倍数");
         Preconditions.checkArgument(dto.getOutUnitPrice() != null, "超标单价不能为空!!!");
      }

      if (dto.getId() == null) {
         MesBuildingCoatingConfig config = this.baseMapper
            .selectOne((Wrapper<MesBuildingCoatingConfig>)new LambdaQueryWrapper<MesBuildingCoatingConfig>().eq(MesBuildingCoatingConfig::getType, dto.getType()));
         Preconditions.checkArgument(config == null, "油漆类型重复");
         config = com.hzchum.pangu.common.util.BeanUtil.copy(dto, MesBuildingCoatingConfig.class);
         this.baseMapper.insert(config);
      } else {
         MesBuildingCoatingConfig config = this.baseMapper
            .selectOne(
               (Wrapper<MesBuildingCoatingConfig>)(new LambdaQueryWrapper<MesBuildingCoatingConfig>().eq(MesBuildingCoatingConfig::getType, dto.getType()))
                  .ne(MesBuildingCoatingConfig::getId, dto.getId())
            );
         Preconditions.checkArgument(config == null, "油漆类型重复");
         config = com.hzchum.pangu.common.util.BeanUtil.copy(dto, MesBuildingCoatingConfig.class);
         this.baseMapper.updateById(config);
      }

      return Boolean.TRUE;
   }

   @Override
   public MesBuildingCoatingConfigDTO getCoatingConfig(Integer type) {
      MesBuildingCoatingConfig config = this.baseMapper
         .selectOne((Wrapper<MesBuildingCoatingConfig>)new LambdaQueryWrapper<MesBuildingCoatingConfig>().eq(MesBuildingCoatingConfig::getType, type));
      return config == null ? null : com.hzchum.pangu.common.util.BeanUtil.copy(config, MesBuildingCoatingConfigDTO.class);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesBuildingCoatingConfig coatingConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(coatingConfig != null, "当前涂装配置不存在");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteByType(Integer type) {
      MesBuildingCoatingConfig coatingConfig = this.baseMapper
         .selectOne((Wrapper<MesBuildingCoatingConfig>)new LambdaQueryWrapper<MesBuildingCoatingConfig>().eq(MesBuildingCoatingConfig::getType, type));
      Preconditions.checkArgument(coatingConfig != null, "当前涂装配置不存在");
      this.baseMapper.delete(Wrappers.lambdaQuery(MesBuildingCoatingConfig.class).eq(MesBuildingCoatingConfig::getType, type));
      return Boolean.TRUE;
   }
}
