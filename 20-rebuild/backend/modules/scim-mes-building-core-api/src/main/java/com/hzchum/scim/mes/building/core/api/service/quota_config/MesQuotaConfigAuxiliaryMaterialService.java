package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAuxiliaryMaterial;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAuxiliaryMaterialDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigAuxiliaryMaterialParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;

public interface MesQuotaConfigAuxiliaryMaterialService extends IService<MesQuotaConfigAuxiliaryMaterial> {
   List<MesQuotaConfigAuxiliaryMaterialDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigAuxiliaryMaterialParam param);

   Boolean edit(MesQuotaConfigAuxiliaryMaterialParam param);

   Boolean deleteById(Long id);
}
