package com.hzchum.scim.mes.building.core.api.biz.wage_quota;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesEnclosureProductQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesEnclosureProductQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesEnclosureProductQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesEnclosureProductQuotaConfigQuery;
import java.util.List;

public interface MesEnclosureProductQuotaConfigBiz extends IBiz<MesEnclosureProductQuotaConfig> {
   PageVO<MesEnclosureProductQuotaConfigDTO> pageInfo(MesEnclosureProductQuotaConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean add(MesEnclosureProductQuotaConfigParam param);

   Boolean edit(MesEnclosureProductQuotaConfigParam param);

   Boolean deleteById(Long id);
}
