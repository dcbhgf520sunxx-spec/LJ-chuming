package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactSpecAmend;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecAmendDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecAmendUpdateDTOParam;
import java.util.List;

public interface TechArtifactSpecAmendBiz extends IBiz<TechArtifactSpecAmend> {
   PageVO<TechArtifactSpecAmendDTO> listSpecAmend(
      Long projectId,
      Long monomerId,
      Long areaId,
      String name,
      String serialNumber,
      String oldSpecification,
      String newSpecification,
      String specification,
      Boolean boolAmendStatus,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean amendArtifactSpec(List<TechArtifactSpecAmendUpdateDTOParam> list);

   List<String> listArtifactSpec(
      Long projectId, Long monomerId, Long areaId, String name, String serialNumber, String oldSpecification, String newSpecification, Boolean boolAmendStatus
   );
}
