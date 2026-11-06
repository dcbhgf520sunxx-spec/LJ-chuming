package com.hzchum.scim.mes.building.core.service.impl.quota_config;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAssembleCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAssembleConditionDTO;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigAssembleConditionService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigAssembleConditionMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesQuotaConfigAssembleConditionServiceImpl
   extends ServiceImpl<MesQuotaConfigAssembleConditionMapper, MesQuotaConfigAssembleCondition>
   implements MesQuotaConfigAssembleConditionService {
   @Override
   public List<MesQuotaConfigAssembleConditionDTO> listByQuotaConfigIdList(List<Long> quotaConfigIdList) {
      return CollUtil.isEmpty(quotaConfigIdList) ? Collections.emptyList() : this.baseMapper.listByQuotaConfigIdList(quotaConfigIdList);
   }

   @Override
   public Boolean deteleByQuotaConfigId(Long quotaConfigId) {
      if (quotaConfigId != null) {
         this.baseMapper.deteleByQuotaConfigId(quotaConfigId);
      }

      return true;
   }
}
