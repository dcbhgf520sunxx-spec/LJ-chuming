package com.hzchum.scim.mes.building.core.mapper.quota_config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigMachinePart;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesQuotaConfigMachinePartMapper extends BaseMapper<MesQuotaConfigMachinePart> {
   List<MesQuotaConfigMachinePartDTO> listInfo(MesQuotaConfigConditionQuery query);

   int getMaxSerialNumber(@Param("prefix") String prefix);
}
