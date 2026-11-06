package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import java.util.List;

public interface TechArtifactExtService extends IService<TechArtifactExt> {
   TechArtifactExt getOne(Long artifactId, Integer sortNumber);

   void addReduceExt(Long monomerId, Long artifactId, String serialNumber, Integer quantity);

   List<TechArtifactExt> listArtifact(List<NumberInfoDTO> NumberInfos);

   List<TechArtifactExt> listAllArtifactExt(Long monomerId, List<String> serialNumberList);
}
