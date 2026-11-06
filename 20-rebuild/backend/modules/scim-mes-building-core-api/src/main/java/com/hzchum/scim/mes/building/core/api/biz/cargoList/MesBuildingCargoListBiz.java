package com.hzchum.scim.mes.building.core.api.biz.cargoList;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.CargoListDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ArtifactByCargoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.AuditInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListLogisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMeteByMonomerAndAreaDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMeteGroupMonthDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListReceiptDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListReviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListShipDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListSupplierDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.MesBuildingCargoListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.OverweightSMSUserDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListAuxiliaryDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListEnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListEnclosureMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListMeteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListSumDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListSumEnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.YearCargoListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.YearCargoListMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.AppCargoListDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListCheckDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListLogisticsDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListPriceChangeDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListReceiptDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListReviewDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListShipDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListStatisticsQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListWeighSMSDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListLogisticsUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListReceiptUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListUpdateConcertDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListUpdateDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MesBuildingCargoListBiz {
   List<CargoListSupplierDTO> listSupplier(Long supplierPriceId);

   BigDecimal getFareBySupplierId(Long supplierId);

   CargoListDetailsDTO getDetailById(Long id);

   ListVO<SendDirectlyDetailDO> getDirectlyNoCartList(Long id, Long productId);

   Boolean updateCargoList(CargoListUpdateDTOParam param);

   Boolean updateCargoListLogistics(CargoListLogisticsUpdateDTOParam param);

   boolean deleteByIds(List<Long> ids);

   OverweightSMSUserDTO checkCargoList(CargoListCheckDTOParam requestVO);

   Boolean sendWeighSms(CargoListWeighSMSDTOParam dtoParam);

   Boolean checkCaptcha(Long id, String verifyCode);

   AuditInfoDTO getAuditInfo(Long cargoListId);

   AuditInfoDTO getAuditInfoV2(Long cargoListId);

   boolean review(CheckDTOParam param);

   PageVO pageAppCargoList(AppCargoListDTOParam param);

   Map<String, Object> getShipAmountByCargoListId(Long cargoListId, Integer structureMeasureMode, Integer enclosureMeasureMode, Long projectId);

   void setShipAmountByProjectId(Long projectId);

   PageVO<CargoListShipDTO> pageShip(CargoListShipDTOParam param);

   Map cargoListMeteSummary(LocalDateTime dateTime, Long projectId, Integer projectType, LocalDateTime auditStartDate, LocalDateTime auditEndDate);

   Map<String, Object> getShipDetail(Long id);

   PrintVO<List<Map<String, Object>>> printShipDayOrMonthSummary(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer type);

   CargoListMeteDTO getShipMeteByCondition(CargoListShipDTOParam requestVO);

   PrintVO printShip(CargoListShipDTOParam param);

   PrintVO printShipDetail(Long id);

   PageVO<CargoListReceiptDTO> pageReceipt(CargoListReceiptDTOParam param);

   PrintVO printReceipt(CargoListReceiptDTOParam param);

   PageVO<CargoListLogisticsDTO> pageLogistics(CargoListLogisticsDTOParam param);

   Boolean cargoListPriceChange(CargoListPriceChangeDTOParam param);

   Object cargoListPriceChangeLog(Long id);

   ListVO listLogistics(CargoListLogisticsDTOParam param);

   PrintVO printLogistics(CargoListLogisticsDTOParam param);

   PageVO<CargoListReviewDTO> pageReview(CargoListReviewDTOParam param);

   PrintVO printReview(CargoListReviewDTOParam param);

   Boolean reviewDetailDownload(Long id, HttpServletResponse response);

   Boolean reviewDetailDownloadV2(Long id, HttpServletResponse response);

   Map<String, Object> reviewDetail(Long id);

   Map<String, Object> reviewDetailV2(Long id);

   PrintVO<List<Map<String, Object>>> reviewDetailPrint(Long id);

   Boolean cancelReceiving(CargoListReceiptUpdateDTOParam param);

   Boolean signIn(Long id, Long attachmentId);

   BigDecimal getProjectShipAmount(Long projectId, Long cargoList);

   List<ProjectCargoListMeteDTO> projectCargoListMeteSummary(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      String projectName,
      Integer productionLineTypeEnum,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer projectStatus
   );

   List<ProjectCargoListMeteDTO> projectCargoListMeteSummaryV2(CargoListStatisticsQueryParam param);

   List<ProjectCargoListEnclosureMeteDTO> projectCargoListEnclosureProjectSummary(
      LocalDateTime dateTime, Integer sendStatus, Boolean settled, Long workshopId, String projectName, Integer projectStatus
   );

   List<ProjectCargoListEnclosureMeteDTO> projectCargoListEnclosureProjectSummaryV2(CargoListStatisticsQueryParam param);

   PageVO<ProjectCargoListMeteDTO> projectCargoListMeteSummaryPage(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      String projectName,
      Integer productionLineTypeEnum,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer projectStatus,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<ProjectCargoListEnclosureMeteDTO> projectCargoListEnclosureSummaryPage(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      String projectName,
      Integer projectStatus,
      Integer pageNumber,
      Integer pageSize
   );

   ProjectCargoListSumDetailDTO projectDetailSummary(Long projectId, Long monomerId, Long areaId, Long workshopId, LocalDateTime dateTime);

   ProjectCargoListSumDetailDTO directShipmentProjectDetailSummary(Long projectId, Long monomerId, Long areaId, Long workshopId, LocalDateTime dateTime);

   ProjectCargoListSumEnclosureDetailDTO projectEnclosureDetailSummary(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, LocalDateTime dateTime
   );

   PageVO projectDetailType(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO directShipmentProjectDetailType(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO projectEnclosureDetailType(
      Long projectId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> projectDetailTypePrint(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      Integer weightStatus,
      HttpServletResponse response
   );

   PrintVO<List<Map<String, Object>>> directShipmentProjectDetailTypePrint(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      HttpServletResponse response
   );

   PrintVO<List<Map<String, Object>>> projectEnclosureDetailTypePrint(
      Long projectId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      HttpServletResponse response
   );

   void projectDetailTypeDown(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      HttpServletResponse response
   );

   YearCargoListMeteDTO getYearCargoListMeteSummary(
      LocalDateTime dateTime, Long workshopId, Integer productionLineTypeEnum, Integer projectType, Integer lumpSumSystemType, Integer projectStatus
   );

   YearCargoListMeteDTO getYearCargoListEnclosureSummary(
      LocalDateTime dateTime, Long workshopId, Integer projectType, Integer lumpSumSystemType, Integer projectStatus
   );

   List<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      String serialNumber,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   List<ProjectCargoListMeteDetailDTO> directShipmentProjectCargoListMeteDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      String serialNumber,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   List<ProjectCargoListEnclosureDetailDTO> projectCargoListEnclosureDetail(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, String serialNumber
   );

   List<ProjectCargoListAuxiliaryDetailDTO> projectCargoListAuxiliaryDetail(
      Long projectId, Long monomerId, Long areaId, Integer category, Long enclosurePlanId, String serialNumber, Integer relationType, Integer projectStatus
   );

   PageVO<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<ProjectCargoListMeteDetailDTO> directShipmentProjectCargoListMeteDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<ProjectCargoListEnclosureDetailDTO> projectCargoListEnclosureDetailPage(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, Integer pageNumber, Integer pageSize
   );

   PageVO<ProjectCargoListAuxiliaryDetailDTO> projectCargoListAuxiliaryDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      Integer relationType,
      Integer projectStatus,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> projectCargoListMeteDetailPrint(
      Long projectId, Long monomerId, Long areaId, Long workshopId, Integer productionLineTypeEnum, LocalDateTime startDate, LocalDateTime endDate
   );

   PrintVO<List<Map<String, Object>>> directShipmentProjectCargoListMeteDetailPrint(
      Long projectId, Long monomerId, Long areaId, Long workshopId, Integer productionLineTypeEnum, LocalDateTime startDate, LocalDateTime endDate
   );

   PrintVO<List<Map<String, Object>>> projectCargoListEnclosureDetailPrint(Long projectId, Integer category, Long enclosurePlanId, Long workshopId);

   PrintVO<List<Map<String, Object>>> projectCargoListAuxiliaryDetailPrint(
      Long projectId, Long monomerId, Long areaId, Integer category, Long enclosurePlanId, String serialNumber, Integer relationType, Integer projectStatus
   );

   YearCargoListDTO getYearCargoListSummary(LocalDateTime dateTime, Integer projectStatus);

   List<CargoListMeteGroupMonthDTO> getCargoListGroupMonth(LocalDateTime dateTime);

   List<ProjectCargoListMeteDTO> projectCargoListSummaryList(LocalDateTime dateTime, Integer projectStatus);

   List<CargoListMeteByMonomerAndAreaDTO> projectByMonomerCargoList(Long projectId);

   List<CargoListDO> cargoListShipByProject(Long projectId);

   YearCargoListDTO projectCargoListSummary(Long projectId);

   List<MesBuildingCargoListDTO> shipmentByProject(Long id);

   Map shipmentSummary(Long id);

   PrintVO<List<Map<String, Object>>> shipmentByProjectPrint(Long id);

   PageVO shipmentByProjectPage(Long projectId, Integer pageNumber, Integer pageSize);

   List<CargoListMeteByMonomerAndAreaDTO> projectByAreaCargoList(Long projectId, Long monomerId);

   List<ArtifactByCargoDTO> projectByAreaProductCargoList(Long projectId, Long monomerId, Long areaId, String serialNumber, Integer type);

   PageVO<ArtifactByCargoDTO> projectByAreaProductCargoPage(
      Long projectId, Long monomerId, Long areaId, String serialNumber, Integer type, Integer pageNumber, Integer pageSize
   );

   List<ArtifactShipDO> listShipArtifactAndPartSend(Long cargoListId);

   Map<Long, BigDecimal> getProjectShipAmountMap(List<Long> projectIds);

   Boolean updateConcertCargoList(CargoListUpdateConcertDTOParam param);

   Map<String, Number> projectCargoListAuxiliaryDetailSum(Long projectId, Long monomerId, Long areaId, Integer relationType, Integer projectStatus);
}
