package com.hzchum.scim.mes.building.core.api.service.cargoList;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
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

public interface MesBuildingCargoListProductLinkService extends IService<MesBuildingCargoListProductLink> {
   List<ArtifactDetailDO> listArtifactNotPackById(Long cargoListId);

   List<SendDirectlyDetailDO> listPartNotPackById(Long cargoListId);

   List<SendDirectlyDetailDO> listAssembleNotPackById(Long cargoListId);

   List<EnclosureDetailDO> listEnclosureNotPackById(Long cargoListId);

   List<TechStandardPartDetailDO> listAuxiliaryMaterialNotPackById(Long cargoListId);

   List<ArtifactShipDO> listArtifactAllById(Long cargoListId);

   List<PartSendShipDO> listPartSendAllById(Long cargoListId);

   List<EnclosureShipDO> listEnclosureAllById(Long cargoListId);

   List<TechStandardPartShipDO> listAuxiliaryMaterialAllById(Long cargoListId);

   List<ProductShipDO> listShipByCondition(TrackingDOParam param);

   List<ProductShipDO> listShipByProjectId(Long projectId);

   List<ArtifactShipMeteDO> listArtifactShipByProjectId(Long projectId);

   List<PartSendShipDO> listPartSendShipByProjectId(Long projectId);

   List<EnclosureShipMeteDO> listEnclosureShipByProjectId(Long projectId);

   List<TechStandardPartShipDO> listAuxiliaryMaterialShipByProjectId(Long projectId);

   List<Long> listCargoListIdByCondition(Long projectId, String blurry, Boolean boolAccurateQuery, Long monomerId);

   ListVO<ProductProjectSumDO> sumShipmentGroupByProject(AppShipTimeDOParam param);

   PageVO pageArtifactShipment(AppShipDTOParam param);

   PageVO pageEnclosureShipment(AppShipDTOParam param);

   Integer getShipQuantityByProduct(Long productId, Integer productType);

   List<PartShipDO> listPartAllById(Long cargoListId);

   List<PartShipDO> listAssembleAllById(Long cargoListId);

   List<SendDirectlyDetailDO> listAssembleNotCargoListByIds(Set<Long> artifactIds);

   List<SendDirectlyDetailDO> listAssembleNotLoadedByIds(@Param("artifactIds") Set<Long> artifactIds);

   List<SendDirectlyDetailDO> listAssembleNotShippedLoadedByIds(@Param("artifactIds") Set<Long> artifactIds);

   List<CargoListDetailsDTO> artifactSourceReportCargoList(Long productId, Integer number, Integer taskId);

   List<ArtifactBasicsDO> artifactCargoShipDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer handleMethod,
      String specification,
      String material,
      String serialNumber,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String name
   );

   List<EnclosureShipDO> enclosureCargoShipDetail(
      Long projectId, Long enclosurePlanId, String plate, String serialNumber, String planName, LocalDateTime startDate, LocalDateTime endDate, String name
   );

   List<TechMachinePartShipDTO> partSendCargoShipDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      String specification,
      String material,
      String serialNumber,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   List<TechStandardPartShipDO> listStandardPartCargoShipDetail(
      Long projectId, Long monomerId, Long areaId, String specification, String name, LocalDateTime startDate, LocalDateTime endDate
   );

   List<CargoListProductLinkDTO> listShipProductRecord(
      List<Long> projectIds, Long monomerId, Integer productType, String name, String serialNumber, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   );

   List<CargoListProductLinkDTO> listAllProductRecord(
      List<Long> projectIds, Long monomerId, Integer productType, String name, String serialNumber, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   );

   List<CarGoQuantityPackageQuantityDTO> listQuantity(Integer taskType, Long productId, Long shopId);

   List<PartShipDO> listPurlinPartAllById(Long cargoListId);

   List<TechMachinePartShipDTO> partPurLineSendCargoShipDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      String specification,
      String material,
      String serialNumber,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   ArtifactBasicsDO artifactCargoShipSum(Long projectId, LocalDateTime startDate, LocalDateTime endDate);
}
