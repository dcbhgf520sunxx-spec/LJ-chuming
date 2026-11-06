package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.MesStatisticsModeConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesStatisticsModeConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesStatisticsModeConfigService;
import com.hzchum.scim.system.core.mapper.MesStatisticsModeConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesStatisticsModeConfigServiceImpl
   extends ServiceImpl<MesStatisticsModeConfigMapper, MesStatisticsModeConfig>
   implements MesStatisticsModeConfigService {
   @Override
   public MesStatisticsModeConfig getInfo() {
      return this.baseMapper.selectOne(Wrappers.emptyWrapper());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editStatisticsModeConfig(MesStatisticsModeConfigSaveDTOParam param) {
      MesStatisticsModeConfig statisticsModeConfig = BeanUtil.toBean(param, MesStatisticsModeConfig.class);
      this.baseMapper.updateById(statisticsModeConfig);
      return Boolean.TRUE;
   }
}
