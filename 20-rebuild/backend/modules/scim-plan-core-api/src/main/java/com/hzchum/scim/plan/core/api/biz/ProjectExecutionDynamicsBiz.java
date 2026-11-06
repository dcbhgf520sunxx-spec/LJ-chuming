package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectExecutionDynamicsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectExecutionDynamicsDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectExecutionDynamicsDetailProductDTO;
import java.util.List;

public interface ProjectExecutionDynamicsBiz {
   PageVO<ProjectExecutionDynamicsDTO> pageInfo(Integer year, Integer status, Long projectId, Integer pageNumber, Integer pageSize, List<String> sort);

   List<ProjectExecutionDynamicsDetailDTO> deepenDetail(Long projectId);

   PageVO<ProjectExecutionDynamicsDetailProductDTO> deepenDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   );

   List<ProjectExecutionDynamicsDetailDTO> schedulingDetail(Long projectId);

   PageVO<ProjectExecutionDynamicsDetailProductDTO> schedulingDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   );

   PrintVO schedulingDetailProductPrint(Long projectId, Long monomerId, Long areaId);

   List<ProjectExecutionDynamicsDetailDTO> producedDetail(Long projectId);

   PageVO<ProjectExecutionDynamicsDetailProductDTO> producedDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   );

   PrintVO producedDetailProductPrint(Long projectId, Long monomerId, Long areaId);

   List<ProjectExecutionDynamicsDetailDTO> notProducedDetail(Long projectId);

   PageVO<ProjectExecutionDynamicsDetailProductDTO> notProducedDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   );

   PrintVO notProducedDetailProductPrint(Long projectId, Long monomerId, Long areaId);

   List<ProjectExecutionDynamicsDetailDTO> deliveryDetail(Long projectId);

   PageVO<ProjectExecutionDynamicsDetailProductDTO> deliveryDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   );

   PrintVO deliveryDetailProductPrint(Long projectId, Long monomerId, Long areaId);

   ProjectExecutionDynamicsDTO getProjectExecutionDynamics(Long projectId, Long branchCompanyId);
}
