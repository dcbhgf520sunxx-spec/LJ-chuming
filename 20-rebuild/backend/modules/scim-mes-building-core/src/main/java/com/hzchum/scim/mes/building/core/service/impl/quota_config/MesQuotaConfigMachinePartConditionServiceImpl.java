package com.hzchum.scim.mes.building.core.service.impl.quota_config;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigMachinePartCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartConditionDTO;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigMachinePartConditionService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigMachinePartConditionMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigMachinePartConditionServiceImpl
   extends ServiceImpl<MesQuotaConfigMachinePartConditionMapper, MesQuotaConfigMachinePartCondition>
   implements MesQuotaConfigMachinePartConditionService {
   @Override
   public List<MesQuotaConfigMachinePartConditionDTO> listByQuotaConfigIdList(List<Long> quotaConfigIdList) {
      return CollUtil.isEmpty(quotaConfigIdList) ? Collections.emptyList() : this.baseMapper.listByQuotaConfigIdList(quotaConfigIdList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deteleByQuotaConfigId(Long quotaConfigId) {
      if (quotaConfigId != null) {
         this.baseMapper.deteleByQuotaConfigId(quotaConfigId);
      }

      return true;
   }
}
