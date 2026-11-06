package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectProductInfoDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.AllSendArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaArtifactSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactClassSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSnDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusQHSEDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanArtifactAssembleMatchingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.StructureClassDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductLineSummary;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupByProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimArtifactVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimBoxOrElementsVO;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;

public interface TechArtifactService extends IService<TechArtifact> {
   List<ArtifactResponseDTO> listByCondition(
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
      Integer artifactType,
      Integer permissionCheck,
      Long userId
   );

   List<ArtifactResponseDTO> listByCondition(Long projectId, Long monomerId, Long structureClassId, Long areaId);

   List<ArtifactResponseDTO> listByCondition(Long projectId, Long structureClassId, String name, String serialNumber, String specification, String material);

   ArtifactDTO getInfoById(Long id);

   ArtifactDTO getInfoById(Long id, int type);

   ArtifactInfoDTO getInfo(Long monomerId, Long areaId, String serialNumber);

   List<TechArtifact> listByBusinessId(Long businessId);

   ProductMeteDTO sumMeteByCondition(Long projectId, Long monomerId, Long areaId);

   List<ProductMeteGroupByProjectDTO> sumMeteGroupByProject(Long projectId);

   List<ProductMeteGroupDTO> sumMeteGroup(Long projectId, Long monomerId, Integer permissionCheck, Long userId);

   List<ProductMeteGroupDTO> sumMeteGroupByAreaIds(List<Long> areaIds);

   void setQuantity(TechArtifact artifact, Integer newQuantity);

   TechArtifact getByIdIgnoreDelete(Long id);

   BimArtifactVO selectArtifactByBim(@Param("monomerId") Long monomerId, @Param("areaIds") List<Long> areaIds, @Param("serialNumber") String serialNumber);

   BimBoxOrElementsVO selectBridgeArtifactByBim(
      @Param("monomerId") Long monomerId, @Param("areaIds") List<Long> areaIds, @Param("serialNumber") String serialNumber
   );

   TechArtifact getOneByClassIdAndPrefix(Long structureClassId, String specPrefix, String snPrefix);

   TechArtifact getOneBySerialNumber(String serialNumber);

   List<ComponentCrderInformationDTO> selectProjectGroupBySpec(Long projectId);

   List<ArtifactsDTO> getArtifactList(String classificationName, String material, Long projectId);

   ProductLineSummary selectByProjectIdAndLine(Long lineId, Long projectId, Integer type);

   String selectByTypeAndId(Integer productType, Long productId);

   Boolean listByConditionsDownLoad(
      Long areaId, Long areaBatchId, Integer status, String name, String serialNumber, String specification, String material, HttpServletResponse response
   );

   ArtifactSumDTO listByConditionsSummary(
      Long areaId, Long areaBatchId, Integer status, String name, String serialNumber, String specification, String material
   );

   TechArtifact getOneOutLengthScope(Long structureClassId, BigDecimal minLength, BigDecimal maxLength);

   List<AreaArtifactSummaryDTO> areaArtifactSummary(Long projectId, Long monomerId, Long areaId);

   List<PlanArtifactAssembleMatchingDTO> listArtifactProcess(
      List<Long> ids,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long structureClassId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Long areaBatchId
   );

   Object artifactSourceProductList(Long productId, Integer productType, Long taskId, Integer number);

   List artifactSourceReportProductList(Long productId, Integer number, Long taskId, Integer productType);

   List newArtifactSourceReportProductList(Long taskProcessId, Long productId, Integer number);

   List<StructureClassDTO> getStructureClass(Long projectId, Long monomerId, Long areaId);

   ArtifactSumDTO appListByConditionsSummary(
      Long projectId, Long monomerId, Long areaId, Integer status, String name, String serialNumber, String specification, String material
   );

   PageVO<ArtifactStatusQHSEDTO> listArtifactDetail(
      Long projectId, Long areaId, Long monomerId, String serialNumber, Boolean boolCompany, Integer pageNumber, Integer pageSize
   );

   PageVO<String> listSerialNumber(Long projectId, Long areaId, Long monomerId, String serialNumber, Boolean boolCompany, Integer pageNumber, Integer pageSize);

   BigDecimal sumTnventoryTon(Long projectId);

   List<ArtifactClassSummaryDTO> listClassSnQuantity(Long projectId, Long monomerId);

   List<ArtifactSnDTO> listArtifactSn(
      Long projectId, Long monomerId, String name, String serialNumber, String specification, String material, List<Long> structureClassIdList
   );

   Boolean changeBusinessArtifact(Long productId);

   List<AllSendArtifactDTO> listAllPartsByIds(List<Long> artifactIds);

   List<AllSendArtifactDTO> listAllAsssByIds(List<Long> artifactIds);

   List<ArtifactSimpleVO> getArtifact(String serialNumber, Long projectId, Long monomerId, Long areaId);

   List<ArtifactSimpleVO> getArtifactListBySerialNumber(String serialNumber, Long projectId, Long monomerId, Long areaId);

   BigDecimal selectListQuantity(Long projectId);

   List<ProjectProductInfoDTO> findSchedulingArtifactInfo(
      List<Long> userProjectIds, List<Long> areaIds, Long monmerId, Long areaId, Long classId, String serialNumber
   );

   List<TechAssembleRecord> getAssembleRecordList(Long monomerId, Long areaId, String serialNumber, Long inventoryOperationId);

   List<ArtifactResponseDTO> listByConditionV2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer status,
      String name,
      String serialNumber,
      String specification,
      String material,
      Boolean boolSchedulingEnum,
      Integer artifactType,
      String batchNumber
   );

   List<PlanArtifactAssembleMatchingDTO> listArtifactProcessByTaskOrderId(Long taskOrderId);
}
