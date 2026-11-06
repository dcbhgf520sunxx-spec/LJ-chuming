package com.hzchum.scim.plan.core.mapper;

import com.hzchum.scim.plan.core.api.pojo.dto.ProjectExecutionDynamicsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectExecutionDynamicsDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectExecutionDynamicsDetailProductDTO;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectExecutionDynamicsMapper {
   List<ProjectExecutionDynamicsDTO> listInfo(@Param("projectIds") List<Long> projectIds);

   BigDecimal getTotalWeight(@Param("projectId") Long projectId);

   List<ProjectExecutionDynamicsDetailDTO> deepenDetail(@Param("projectId") Long projectId);

   List<ProjectExecutionDynamicsDetailProductDTO> deepenDetailProduct(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );

   List<ProjectExecutionDynamicsDetailDTO> schedulingDetail(@Param("projectId") Long projectId);

   List<ProjectExecutionDynamicsDetailProductDTO> schedulingDetailProduct(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );

   List<ProjectExecutionDynamicsDetailDTO> producedDetail(@Param("projectId") Long projectId);

   List<ProjectExecutionDynamicsDetailProductDTO> producedDetailProduct(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );

   List<ProjectExecutionDynamicsDetailDTO> notProducedDetail(@Param("projectId") Long projectId);

   List<ProjectExecutionDynamicsDetailProductDTO> notProducedDetailProduct(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );

   List<ProjectExecutionDynamicsDetailDTO> deliveryDetail(@Param("projectId") Long projectId);

   List<ProjectExecutionDynamicsDetailProductDTO> deliveryDetailProduct(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );
}
