package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TechAssembleBiz {
   PageVO<AssembleDTO> pageListByCondition(
      Long areaId,
      Long areaBatchId,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      Integer permissionCheck
   );

   void exportAssembles(Long areaId, Long areabatchId, String serialNumber, String specification, String material, HttpServletResponse response);

   List<ComponentCrderInformationDTO> selectByProjectId(Long projectId);

   void importAssemble(MultipartFile file, Long areaId, Integer importType, HttpServletResponse response);
}
