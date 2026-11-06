package com.hzchum.scim.business.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.business.core.api.pojo.dto.ArtifactBasicsDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessReturnProductDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessShipCargoDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ContractSaleLedgerDTO;
import com.hzchum.scim.business.core.api.pojo.dto.EnclosureBasicsDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ShipmentInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ShipmentRecordDTO;
import com.hzchum.scim.business.core.api.pojo.dto.SummaryDTO;
import com.hzchum.scim.business.core.api.pojo.dto.SummaryPriceDTO;
import com.hzchum.scim.business.core.api.pojo.dto.TechStandardPartShipDTO;
import com.hzchum.scim.business.core.api.pojo.dto.TrackingDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BindDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.TrainTrackingDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.CostShipAmountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.TechMachinePartShipDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface BusinessBiz {
   Boolean bind(BindDTOParam param);

   SummaryDTO summaryEnclosure(Long projectId, Long monomerId);

   SummaryPriceDTO summary(Long projectId, Long monomerId, Long areaId, Integer type);

   PageVO<TrackingDTO> pageTrainTracking(TrainTrackingDTOParam param);

   Map<String, Object> getTrainTracking(Long id);

   PageVO<ContractSaleLedgerDTO> pageListSalesLedger(
      Integer year, Integer projectStatus, String name, Integer orderSourceType, Integer productType, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printListSalesLedger(Integer year, Integer projectStatus, String name, Integer orderSourceType, Integer productType);

   Map<Long, BigDecimal> getProjectWarehouseAmountMap(List<Long> projectIds);

   Map<Long, BigDecimal> getProjectShipAmountMap(List<Long> projectIds);

   Map<Long, BigDecimal> getProjectShipAmountMapMonth(List<Long> projectIds, LocalDateTime auditStartDate, LocalDateTime auditEndDate);

   CostShipAmountDTO getProjectCostShipAmountDTOMonth(List<Long> projectIds, LocalDateTime auditStartDate, LocalDateTime auditEndDate);

   Map<Long, Integer> getProjectTransportQuantityMap(List<Long> projectIds);

   PageVO<ShipmentInfoDTO> pageTracking(
      Long projectId,
      Long monomerId,
      Integer productType,
      String name,
      String serialNumber,
      LocalDateTime auditStartDate,
      LocalDateTime auditEndDate,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printTracking(
      Long projectId, Long monomerId, Integer productType, String name, String serialNumber, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   );

   PageVO<ShipmentRecordDTO> listShipByProjectId(Long projectId, Integer pageNumber, Integer pageSize);

   ListVO<TechArtifact> listArtifactByBusinessId(Long businessId);

   void downloadArtifactByBusinessId(Long businessId, HttpServletResponse response);

   ListVO<TechEnclosure> listEnclosureByBusinessId(Long businessId);

   BigDecimal getWarehouseAmount(Long projectId);

   BusinessShipCargoDTO shipCargoSummary(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String material,
      String serialNumber,
      String name,
      Integer projectStatus
   );

   List<ArtifactBasicsDTO> shipCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer handleMethod,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String material,
      String serialNumber,
      String name
   );

   PageVO<ArtifactBasicsDTO> pageShipCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer handleMethod,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String material,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String name
   );

   List<TechStandardPartShipDTO> shipStandardPartCargoDetail(
      Integer productType, Long projectId, Long monomerId, Long areaId, LocalDateTime startDate, LocalDateTime endDate, String specification, String name
   );

   PageVO<TechStandardPartShipDTO> pageShipStandardPartCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String name
   );

   List<EnclosureBasicsDTO> shipCargoEnclosureDetail(
      Integer productType,
      Long projectId,
      Long enclosurePlanId,
      String planName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String plate,
      String serialNumber,
      String name
   );

   PageVO<EnclosureBasicsDTO> pageShipCargoEnclosureDetail(
      Integer productType,
      Long projectId,
      Long enclosurePlanId,
      String planName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String plate,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String name
   );

   PrintVO<List<Map<String, Object>>> printShipCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long enclosurePlanId,
      Integer handleMethod,
      String monomerName,
      String areaName,
      String planName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String plate,
      String material,
      String serialNumber,
      String name
   );

   void downloadShipCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long enclosurePlanId,
      Integer handleMethod,
      String monomerName,
      String areaName,
      String planName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String plate,
      String material,
      String serialNumber,
      String name,
      HttpServletResponse response
   );

   PageVO<TechMachinePartShipDTO> pageShipDirectCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String material,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String name
   );

   Map<Long, BigDecimal> getProjectAllProduceAmountMap(List<Long> projectIds, LocalDateTime secondStartDate, LocalDateTime secondEndDate);

   List<BusinessReturnProductDTO> listReturnProduct(Long linkId);

   PrintVO<List<BusinessReturnProductDTO>> printListReturnProduct(Long linkId);
}
