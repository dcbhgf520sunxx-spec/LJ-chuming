package com.hzchum.scim.mes.building.core.mapper.wage_quota_management;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesAssembleQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import java.util.List;

public interface MesAssembleQuotaConfigMapper extends BaseMapper<MesAssembleQuotaConfig> {
   List<MesAssembleQuotaConfigDTO> listInfo(MesQuotaConfigQuery query);

   Integer getMaxNumber();
}
