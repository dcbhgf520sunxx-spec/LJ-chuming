package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAuxiliaryMaterial;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAuxiliaryMaterialDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigAuxiliaryMaterialParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;

public interface MesQuotaConfigAuxiliaryMaterialBiz extends IBiz<MesQuotaConfigAuxiliaryMaterial> {
   PageVO<MesQuotaConfigAuxiliaryMaterialDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean add(MesQuotaConfigAuxiliaryMaterialParam param);

   Boolean edit(MesQuotaConfigAuxiliaryMaterialParam param);

   Boolean delete(Long id);

   List<String> typeSelectList();
}
