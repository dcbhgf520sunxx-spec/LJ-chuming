package com.hzchum.scim.mes.building.core.api.biz.wage_quota_management;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesAssembleQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesAssembleQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import java.util.List;

public interface MesAssembleQuotaConfigBiz extends IBiz<MesAssembleQuotaConfig> {
   PageVO<MesAssembleQuotaConfigDTO> pageInfo(MesQuotaConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean add(MesAssembleQuotaConfigParam param);

   Boolean edit(MesAssembleQuotaConfigParam param);

   Boolean editStatus(Long id, Boolean status);

   Boolean deleteById(Long id);
}
