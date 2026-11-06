package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAssembleSaveNestingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.ArtifactAssociationCount;
import java.util.List;

public interface TechAssembleDetailService extends IService<TechAssembleDetail> {
   List<TechAssembleSaveNestingDTO> listNestingDetail(List<Long> ids, Integer productionLineTypeEnum);

   List<ArtifactAssociationCount> getArtifactPartConvertCounts(List<Long> artifactId);
}
