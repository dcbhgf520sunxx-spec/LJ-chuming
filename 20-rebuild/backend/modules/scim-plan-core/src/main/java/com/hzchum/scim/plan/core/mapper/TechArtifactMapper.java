package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectProductInfoDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.AllSendArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaArtifactSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactClassSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSnDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactWeightSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanArtifactAssembleMatchingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.StructureClassDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductLineSummary;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupByProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimArtifactVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimBoxOrElementsVO;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechArtifactMapper extends BaseMapper<TechArtifact> {
   List<ArtifactResponseDTO> selectListByCondition(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("structureClassId") Long structureClassId,
      @Param("status") Integer status,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("boolSchedulingEnum") Boolean boolSchedulingEnum,
      @Param("productType") Integer productType,
      @Param("areaType") Integer areaType,
      @Param("dataType") Integer dataType,
      @Param("artifactType") Integer artifactType,
      @Param("permissionCheck") Integer permissionCheck,
      @Param("userId") Long userId
   );

   List<Long> selectIdsByAreaId(@Param("areaId") Long areaId);

   ProductMeteDTO sumMete(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   List<ProductMeteGroupByProjectDTO> sumMeteGroupByProject(Long projectId);

   ArtifactWeightSumDTO getWeightSum(@Param("areaId") Long areaId);

   List<ProductMeteGroupDTO> sumMeteGroupByMonomerId(
      @Param("projectId") Long projectId, @Param("permissionCheck") Integer permissionCheck, @Param("userId") Long userId
   );

   List<ProductMeteGroupDTO> sumMeteGroupByAreaId(
      @Param("monomerId") Long monomerId, @Param("permissionCheck") Integer permissionCheck, @Param("userId") Long userId
   );

   List<ProductMeteGroupDTO> sumMeteGroupByAreaIds(@Param("areaIds") List<Long> areaIds);

   TechArtifact selectByIdIgnoreDelete(@Param("id") Long id);

   BimArtifactVO selectArtifactByBim(@Param("monomerId") Long monomerId, @Param("areaIds") List<Long> areaIds, @Param("serialNumber") String serialNumber);

   BimBoxOrElementsVO selectBridgeArtifactByBim(
      @Param("monomerId") Long monomerId, @Param("areaIds") List<Long> areaIds, @Param("serialNumber") String serialNumber
   );

   List<ComponentCrderInformationDTO> selectProjectGroupBySpec(Long projectId);

   List<ArtifactsDTO> getArtifactList(
      @Param("classificationName") String classificationName, @Param("material") String material, @Param("projectId") Long projectId
   );

   ProductLineSummary selectByProjectIdAndLine(@Param("lineId") Long lineId, @Param("projectId") Long projectId, @Param("type") Integer type);

   String selectByTypeAndId(@Param("productType") Integer productType, @Param("productId") Long productId);

   List<AreaArtifactSummaryDTO> areaArtifactSummary(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   List<PlanArtifactAssembleMatchingDTO> listArtifactProcess(
      @Param("ids") List<Long> ids,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("structureClassId") Long structureClassId,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("areaBatchId") Long areaBatchId
   );

   ArtifactDTO artifactSourceProductList(Long productId);

   List<StructureClassDTO> getStructureClass(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   ArtifactDTO getInfoById(Long id);

   BigDecimal sumTnventoryTon(@Param("projectId") Long projectId);

   List<ArtifactClassSummaryDTO> selectClassSnQuantity(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId);

   List<ArtifactSnDTO> selectArtifactSnList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("structureClassIdList") List<Long> structureClassIdList
   );

   List<AllSendArtifactDTO> listAllPartsByIds(@Param("artifactIds") List<Long> artifactIds);

   List<AllSendArtifactDTO> listAllAsssByIds(@Param("artifactIds") List<Long> artifactIds);

   List<ArtifactSimpleVO> getArtifact(
      @Param("serialNumber") String serialNumber, @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );

   List<ArtifactSimpleVO> getArtifactListBySerialNumber(
      @Param("serialNumber") String serialNumber, @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );

   BigDecimal selectListQuantity(@Param("projectId") Long projectId);

   List<ArtifactSimpleVO> getArtifactDetail(
      @Param("projectId") Long projectId, @Param("areaId") Long areaId, @Param("monomerId") Long monomerId, @Param("serialNumber") String serialNumber
   );

   List<ArtifactSimpleVO> getCompanyArtifactDetail(
      @Param("projectId") Long projectId, @Param("areaId") Long areaId, @Param("monomerId") Long monomerId, @Param("serialNumber") String serialNumber
   );

   List<String> listSerialNumber(
      @Param("projectId") Long projectId, @Param("areaId") Long areaId, @Param("monomerId") Long monomerId, @Param("serialNumber") String serialNumber
   );

   List<String> listCompanySerialNumber(
      @Param("projectId") Long projectId, @Param("areaId") Long areaId, @Param("monomerId") Long monomerId, @Param("serialNumber") String serialNumber
   );

   List<ProjectProductInfoDTO> findSchedulingArtifactInfo(
      @Param("userProjectIds") List<Long> userProjectIds,
      @Param("areaIds") List<Long> areaIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("classId") Long classId,
      @Param("serialNumber") String serialNumber
   );

   List<TechAssembleRecord> getAssembleRecordList(
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("inventoryOperationId") Long inventoryOperationId
   );

   List<ArtifactResponseDTO> selectListByConditionV2(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("structureClassId") Long structureClassId,
      @Param("status") Integer status,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("boolSchedulingEnum") Boolean boolSchedulingEnum,
      @Param("productType") Integer productType,
      @Param("areaType") Integer areaType,
      @Param("dataType") Integer dataType,
      @Param("artifactType") Integer artifactType,
      @Param("batchNumber") String batchNumber
   );

   List<PlanArtifactAssembleMatchingDTO> listArtifactProcessByTaskOrderId(@Param("taskOrderId") Long taskOrderId);
}
