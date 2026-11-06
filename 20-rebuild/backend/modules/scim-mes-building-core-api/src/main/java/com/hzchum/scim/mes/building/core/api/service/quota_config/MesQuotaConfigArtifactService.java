package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigArtifact;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigArtifactParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;

public interface MesQuotaConfigArtifactService extends IService<MesQuotaConfigArtifact> {
   List<MesQuotaConfigArtifactDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigArtifactParam param);

   Boolean edit(MesQuotaConfigArtifactParam param);

   Boolean delete(Long id);
}
