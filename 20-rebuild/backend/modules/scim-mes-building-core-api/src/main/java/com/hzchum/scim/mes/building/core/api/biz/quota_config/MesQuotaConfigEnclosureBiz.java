package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigEnclosure;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigEnclosureParam;
import java.util.List;

public interface MesQuotaConfigEnclosureBiz extends IBiz<MesQuotaConfigEnclosure> {
   PageVO<MesQuotaConfigEnclosureDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesQuotaConfigEnclosureDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigEnclosureParam param);

   Boolean edit(MesQuotaConfigEnclosureParam param);

   Boolean delete(Long id);
}
