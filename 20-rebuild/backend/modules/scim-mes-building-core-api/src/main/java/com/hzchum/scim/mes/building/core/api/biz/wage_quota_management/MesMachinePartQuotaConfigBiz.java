package com.hzchum.scim.mes.building.core.api.biz.wage_quota_management;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesMachinePartQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesMachinePartQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesMachinePartQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import java.util.List;

public interface MesMachinePartQuotaConfigBiz extends IBiz<MesMachinePartQuotaConfig> {
   PageVO<MesMachinePartQuotaConfigDTO> pageInfo(MesQuotaConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean add(MesMachinePartQuotaConfigParam param);

   Boolean edit(MesMachinePartQuotaConfigParam param);

   Boolean editStatus(Long id, Boolean status);

   Boolean deleteById(Long id);

   List<NameInfo> machinePartProcessSelect();
}
