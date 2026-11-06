package com.hzchum.scim.mes.building.core.mapper.cargoList;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.AppArtifactShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.AppEnclosureShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactBasicsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactShipMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.EnclosureShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.EnclosureShipMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.PartSendShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.PartShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ProductShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.TechStandardPartShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProjectSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.cargoList.TrackingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.AppShipTimeDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListProductLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.TechMachinePartShipDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.CarGoQuantityPackageQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.AppShipDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingCargoListProductLinkMapper extends BaseMapper<MesBuildingCargoListProductLink> {
   List<ArtifactDetailDO> listArtifactNotPackById(Long cargoListId);

   List<SendDirectlyDetailDO> listPartNotPackById(Long cargoListId);

   List<SendDirectlyDetailDO> listAssembleNotPackById(Long cargoListId);

   List<EnclosureDetailDO> listEnclosureNotPackById(Long cargoListId);

   List<TechStandardPartDetailDO> listAuxiliaryMaterialNotPackById(Long cargoListId);

   List<ArtifactShipDO> listArtifactAllById(Long cargoListId);

   List<PartSendShipDO> listPartSendAllById(Long cargoListId);

   List<EnclosureShipDO> listEnclosureAllById(Long cargoListId);

   List<TechStandardPartShipDO> listAuxiliaryMaterialAllById(Long cargoListId);

   List<ArtifactShipMeteDO> listArtifactShipByProjectId(Long projectId);

   List<PartSendShipDO> listPartSendShipByProjectId(Long projectId);

   List<EnclosureShipMeteDO> listEnclosureShipByProjectId(Long projectId);

   List<TechStandardPartShipDO> listAuxiliaryMaterialShipByProjectId(Long projectId);

   List<Long> listCargoListIdByCondition(
      @Param("projectId") Long projectId,
      @Param("blurry") String blurry,
      @Param("boolAccurateQuery") Boolean boolAccurateQuery,
      @Param("monomerId") Long monomerId
   );

   List<ProductShipDO> listShipByCondition(TrackingDOParam param);

   List<ProductShipDO> listShipByProjectId(Long projectId);

   List<ProductProjectSumDO> sumShipmentGroupByProject(AppShipTimeDOParam param);

   List<AppArtifactShipDO> listArtifactShipment(AppShipDTOParam param);

   List<AppEnclosureShipDO> listEnclosureShipment(AppShipDTOParam param);

   Integer sumShipQuantityByProduct(@Param("productId") Long productId, @Param("productType") Integer productType);

   List<PartShipDO> listPartAllById(Long cargoListId);

   List<PartShipDO> listAssembleAllById(Long cargoListId);

   List<SendDirectlyDetailDO> listAssembleNotCargoListByIds(@Param("artifactIds") Set<Long> artifactIds);

   List<SendDirectlyDetailDO> listAssembleNotLoadedByIds(@Param("artifactIds") Set<Long> artifactIds);

   List<SendDirectlyDetailDO> listAssembleNotShippedLoadedByIds(@Param("artifactIds") Set<Long> artifactIds);

   List<CargoListDetailsDTO> artifactSourceReportCargoList(@Param("productId") Long productId, @Param("number") Integer number, @Param("taskId") Integer taskId);

   List<ArtifactBasicsDO> artifactCargoShipDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("handleMethod") Integer handleMethod,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("serialNumber") String serialNumber,
      @Param("monomerName") String monomerName,
      @Param("areaName") String areaName,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("name") String name
   );

   List<EnclosureShipDO> enclosureCargoShipDetail(
      @Param("projectId") Long projectId,
      @Param("enclosurePlanId") Long enclosurePlanId,
      @Param("plate") String plate,
      @Param("serialNumber") String serialNumber,
      @Param("planName") String planName,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("name") String name
   );

   List<TechMachinePartShipDTO> partSendCargoShipDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("serialNumber") String serialNumber,
      @Param("monomerName") String monomerName,
      @Param("areaName") String areaName,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<TechStandardPartShipDO> listStandardPartCargoShipDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("specification") String specification,
      @Param("name") String name,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<CargoListProductLinkDTO> selectShipProductRecord(
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("productType") Integer productType,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("auditStartDate") LocalDateTime auditStartDate,
      @Param("auditEndDate") LocalDateTime auditEndDate
   );

   List<CargoListProductLinkDTO> selectAllProductRecord(
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("productType") Integer productType,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("auditStartDate") LocalDateTime auditStartDate,
      @Param("auditEndDate") LocalDateTime auditEndDate
   );

   List<CarGoQuantityPackageQuantityDTO> listQuantity(@Param("taskType") Integer taskType, @Param("productId") Long productId, @Param("shopId") Long shopId);

   List<PartShipDO> listPurlinPartAllById(Long cargoListId);

   List<TechMachinePartShipDTO> partPurLineSendCargoShipDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("serialNumber") String serialNumber,
      @Param("monomerName") String monomerName,
      @Param("areaName") String areaName,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   ArtifactBasicsDO artifactCargoShipSum(
      @Param("projectId") Long projectId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate
   );
}
