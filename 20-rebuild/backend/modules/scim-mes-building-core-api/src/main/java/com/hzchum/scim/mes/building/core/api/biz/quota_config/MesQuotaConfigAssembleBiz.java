package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAssemble;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAssembleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigAssembleParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;

public interface MesQuotaConfigAssembleBiz extends IBiz<MesQuotaConfigAssemble> {
   PageVO<MesQuotaConfigAssembleDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesQuotaConfigAssembleDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigAssembleParam param);

   Boolean batchAdd(List<MesQuotaConfigAssembleParam> param);

   Boolean edit(MesQuotaConfigAssembleParam param);

   Boolean delete(Long id);
}
