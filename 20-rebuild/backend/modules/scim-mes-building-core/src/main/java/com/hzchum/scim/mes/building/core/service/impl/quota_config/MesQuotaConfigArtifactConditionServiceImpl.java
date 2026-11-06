package com.hzchum.scim.mes.building.core.service.impl.quota_config;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigArtifactCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigArtifactConditionDTO;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigArtifactConditionService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigArtifactConditionMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigArtifactConditionServiceImpl
   extends ServiceImpl<MesQuotaConfigArtifactConditionMapper, MesQuotaConfigArtifactCondition>
   implements MesQuotaConfigArtifactConditionService {
   @Override
   public List<MesQuotaConfigArtifactConditionDTO> listByQuotaConfigIdList(List<Long> quotaConfigIdList) {
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
