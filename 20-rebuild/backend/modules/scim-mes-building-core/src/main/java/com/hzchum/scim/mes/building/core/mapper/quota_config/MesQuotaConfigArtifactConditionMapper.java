package com.hzchum.scim.mes.building.core.mapper.quota_config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigArtifactCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigArtifactConditionDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesQuotaConfigArtifactConditionMapper extends BaseMapper<MesQuotaConfigArtifactCondition> {
   List<MesQuotaConfigArtifactConditionDTO> listByQuotaConfigIdList(@Param("quotaConfigIdList") List<Long> quotaConfigIdList);

   int deteleByQuotaConfigId(@Param("quotaConfigId") Long quotaConfigId);
}
