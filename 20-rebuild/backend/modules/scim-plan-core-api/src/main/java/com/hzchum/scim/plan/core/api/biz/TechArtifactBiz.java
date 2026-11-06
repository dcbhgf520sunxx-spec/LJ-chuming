package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductLineSummary;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactRemarkUpdateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import java.util.List;

public interface TechArtifactBiz {
   PageVO<ArtifactResponseDTO> ListByConditions(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      String name,
      String serialNumber,
      String specification,
      String material,
      Boolean boolSchedulingEnum,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      Integer permissionCheck
   );

   List<ComponentCrderInformationDTO> selectByProjectId(Long projectId);

   List<TechArtifact> selectByProductIds(List<Long> ids);

   ProductLineSummary selectByProjectIdAndLine(Long lineId, Long projectId, Integer type);

   void fillArtifactFiled(Long structureClassId);

   Integer countNotScheduling(Long projectId, Long monomerId, Long areaId);

   Boolean updateArtifactRemark(List<ArtifactRemarkUpdateDtoParam> params);

   PageVO<ArtifactSimpleVO> getArtifactListBySerialNumber(
      String serialNumber, Integer pageNumber, Integer pageSize, Long projectId, Long monomerId, Long areaId
   );

   PageVO<ArtifactSimpleVO> getArtifact(
      String serialNumber, Integer pageNumber, Integer pageSize, Long projectId, Long monomerId, Long areaId, Integer productType
   );

   List<ArtifactResponseDTO> listByProjectIdAndStructureClassId(
      Long projectId, Long structureClassId, String name, String serialNumber, String specification, String material
   );
}
