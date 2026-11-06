package com.hzchum.scim.mes.building.core.mapper.quota_config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAssembleCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAssembleConditionDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesQuotaConfigAssembleConditionMapper extends BaseMapper<MesQuotaConfigAssembleCondition> {
   List<MesQuotaConfigAssembleConditionDTO> listByQuotaConfigIdList(@Param("quotaConfigIdList") List<Long> quotaConfigIdList);

   int deteleByQuotaConfigId(@Param("quotaConfigId") Long quotaConfigId);
}
