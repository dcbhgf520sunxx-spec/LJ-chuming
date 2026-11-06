package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigArtifact;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigArtifactParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import java.util.List;

public interface MesQuotaConfigArtifactBiz extends IBiz<MesQuotaConfigArtifact> {
   PageVO<MesQuotaConfigArtifactDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesQuotaConfigArtifactDTO> listInfo(MesQuotaConfigConditionQuery query);

   Boolean add(MesQuotaConfigArtifactParam param);

   Boolean batchAdd(List<MesQuotaConfigArtifactParam> param);

   Boolean edit(MesQuotaConfigArtifactParam param);

   Boolean delete(Long id);
}
