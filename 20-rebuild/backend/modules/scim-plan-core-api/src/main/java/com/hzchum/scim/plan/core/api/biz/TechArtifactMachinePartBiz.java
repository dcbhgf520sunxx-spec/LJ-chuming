package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTOParam;
import com.hzchum.scim.plan.core.api.pojo.vo.MonomerAndProductIdVO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface TechArtifactMachinePartBiz {
   void exportArtifactPartTemplate(Integer mesInventoryProductEnum, HttpServletResponse response);

   PageVO<TechArtifactDTO> listArtifactDTOByConditions(
      Long areaId,
      Long areaBatchId,
      String artifactName,
      String artifactSerialNumber,
      String specification,
      String material,
      String machinePartSerialNumber,
      Boolean boolMyself,
      String assembleSerialNumber,
      List<LocalDateTime> dateTimeList,
      String userName,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      Integer permissionCheck,
      Boolean boolImportDrawing
   );

   void exportArtifactPartList(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      String artifactName,
      String artifactSerialNumber,
      String specification,
      String material,
      String machinePartSerialNumber,
      Long userId,
      String assembleSerialNumber,
      HttpServletResponse response
   );

   Boolean updateStatus(Integer type, Long id, Boolean status);

   Boolean deleteArtifact(MonomerAndProductIdVO vo);

   Boolean oneClearArtifact(Long areaId, Long monomerId, Long areaBatchId);

   void deleteArtifactList(Map<Long, List<TechArtifactExt>> artifactMap, List<Long> removeArtifactIdList);

   void exportArtifactPartChangeTemplate(HttpServletResponse response);

   Boolean inventoryCheck(MesTechInventoryOperationDTOParam dtoParam);
}
