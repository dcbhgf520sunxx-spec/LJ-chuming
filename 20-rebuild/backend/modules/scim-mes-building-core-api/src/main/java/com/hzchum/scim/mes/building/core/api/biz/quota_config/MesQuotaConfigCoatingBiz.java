package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigCoating;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigCoatingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigCoatingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;

public interface MesQuotaConfigCoatingBiz extends IBiz<MesQuotaConfigCoating> {
   PageVO<MesQuotaConfigCoatingDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesQuotaConfigCoatingDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigCoatingParam param);

   Boolean edit(MesQuotaConfigCoatingParam param);

   Boolean delete(Long id);
}
