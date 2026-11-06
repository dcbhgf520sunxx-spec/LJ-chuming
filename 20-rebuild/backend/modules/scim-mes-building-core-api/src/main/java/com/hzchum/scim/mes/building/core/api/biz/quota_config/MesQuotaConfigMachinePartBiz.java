package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigMachinePart;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigMachinePartParam;
import java.util.List;

public interface MesQuotaConfigMachinePartBiz extends IBiz<MesQuotaConfigMachinePart> {
   PageVO<MesQuotaConfigMachinePartDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesQuotaConfigMachinePartDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigMachinePartParam param);

   Boolean batchAdd(List<MesQuotaConfigMachinePartParam> param);

   Boolean edit(MesQuotaConfigMachinePartParam param);

   Boolean delete(Long id);
}
