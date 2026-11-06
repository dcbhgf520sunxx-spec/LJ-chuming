package com.hzchum.scim.mes.building.core.mapper.quota_config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigEnclosure;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesQuotaConfigEnclosureMapper extends BaseMapper<MesQuotaConfigEnclosure> {
   List<MesQuotaConfigEnclosureDTO> listInfo(MesQuotaConfigConditionQuery query);

   int getMaxSerialNumber(@Param("prefix") String prefix);
}
