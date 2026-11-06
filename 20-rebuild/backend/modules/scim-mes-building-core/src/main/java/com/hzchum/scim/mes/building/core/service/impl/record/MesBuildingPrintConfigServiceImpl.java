package com.hzchum.scim.mes.building.core.service.impl.record;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingPrintConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.PrintConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingPrintConfigService;
import com.hzchum.scim.mes.building.core.mapper.record.MesBuildingPrintConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingPrintConfigServiceImpl
   extends ServiceImpl<MesBuildingPrintConfigMapper, MesBuildingPrintConfig>
   implements MesBuildingPrintConfigService {
   @Override
   public MesBuildingPrintConfig getByProjectIdOrUserId(Long projectId, Long userId, Integer printType) {
      return this.baseMapper
         .selectOne(
            ((Wrappers.<MesBuildingPrintConfig>lambdaQuery().eq(MesBuildingPrintConfig::getPrintType, printType))
                  .eq(projectId != null, MesBuildingPrintConfig::getProjectId, projectId))
               .eq(userId != null, MesBuildingPrintConfig::getUserId, userId)
         );
   }

   @Override
   public boolean setPrintConfig(PrintConfigDTOParam param, Long userId) {
      MesBuildingPrintConfig config = this.getByProjectIdOrUserId(param.getProjectId(), userId, param.getPrintType());
      if (config == null) {
         MesBuildingPrintConfig copy = BeanUtil.copy(param, MesBuildingPrintConfig.class);
         copy.setUserId(userId);
         this.baseMapper.insert(copy);
      } else {
         BeanUtil.copy(param, config);
         this.baseMapper.updateById(config);
      }

      return true;
   }
}
