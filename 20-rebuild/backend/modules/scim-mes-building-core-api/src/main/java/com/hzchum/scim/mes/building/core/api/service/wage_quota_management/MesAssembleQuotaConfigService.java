package com.hzchum.scim.mes.building.core.api.service.wage_quota_management;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesAssembleQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesAssembleQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import java.util.List;

public interface MesAssembleQuotaConfigService extends IService<MesAssembleQuotaConfig> {
   List<MesAssembleQuotaConfigDTO> listInfo(MesQuotaConfigQuery query);

   Boolean add(MesAssembleQuotaConfigParam param);

   Boolean edit(MesAssembleQuotaConfigParam param);

   Boolean editStatus(Long id, Boolean status);

   Boolean deleteById(Long id);
}
