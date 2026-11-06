package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactSpecAmend;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecAmendDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecUncorrectedDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechArtifactSpecAmendUpdateVORequest;
import java.util.List;

public interface TechArtifactSpecAmendService extends IService<TechArtifactSpecAmend> {
   List<TechArtifactSpecAmendDTO> listByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      String name,
      String serialNumber,
      String oldSpecification,
      String newSpecification,
      String specification,
      Boolean boolAmendStatus
   );

   Boolean saveOne(TechArtifact artifact);

   Boolean delByArtifactIds(List<Long> artifactIds);

   List<TechArtifactSpecUncorrectedDTO> uncorrectedList(
      Long inventoryOperationId, String serialNumber, String specification, String material, Long maxLength, Long minLength, Long structureClassId
   );

   Boolean batchUpdateSpecAmenList(List<TechArtifactSpecAmendUpdateVORequest> paramList);
}
