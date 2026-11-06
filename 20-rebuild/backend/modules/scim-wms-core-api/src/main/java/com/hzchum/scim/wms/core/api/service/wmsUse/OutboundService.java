package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BatchSchedulingOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.OutboundAmountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingMeteListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppOutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialConsumingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailBasicDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SplitMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.FinishedProductsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingApproveOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UpdateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsShipmentReceiveApproveDetailDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

public interface OutboundService extends IService<Outbound> {
   PageVO<OutboundListDTO> pageInfo(QueryOutboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<Outbound> listInfo(QueryOutboundDTOParam param);

   Boolean saveOutbound(SteelPlateOutboundDTOParam param);

   List<Long> getIds(QueryOutboundDTOParam param);

   OutboundDTO getOutboundById(Long id);

   OutboundDTO getOutboundByIdV2(Long id);

   MaterialConsumingDTO getMaterialUseAndDeepMete(Long projectId, Long classifyId);

   OutboundDTO getOutboundDTO(Long id);

   PrintVO<List<OutboundDetailDTO>> outboundPrint(Long id);

   Boolean passed(OutboundDTOParam param);

   Boolean delete(Long listId, Long materialId);

   Boolean returned(Long id);

   OutboundDTO getByCurrentUser();

   Integer getDetailNumber();

   Boolean BatchOutbound(BatchOutboundDTOParam param);

   List<BriefIdAndSNDTO> getSNById(List<Long> spilt);

   MaterialInventoryDTO getMaterials(String barcode);

   AppOutboundDTO getPendingQuantity();

   Map<Long, BigDecimal> getProjectUseSteel(List<Long> ids);

   Integer getUnReviewed(Long projectId, Integer reviewStatus);

   List<OutboundAmountDTO> getAuxiliaryMaterialAmount(LocalDateTime year);

   BigDecimal getUseSteelAmount(Long projectId, int amountType);

   Map<String, BigDecimal> getUseMete(Long pid, String year);

   Map<Integer, BigDecimal> getMeteByProjectId(Long projectId, LocalDateTime year);

   Integer getWorkshopCount(Long id);

   PageVO getUseDetail(
      Long projectId, Integer basicClass, List<Long> classifyIds, BigDecimal thickness, String spec, boolean bool, Integer pageNumber, Integer pageSize
   );

   Map<String, Object> getUseByYear(String year);

   Map<Integer, BigDecimal> getUseAmountByYear(String year);

   Map<String, BigDecimal> getMeteByYear(String year);

   List<OutboundDetailDTO> getDetailByCondition(Integer basicClass, Long projectId, LocalDateTime startDate, LocalDateTime endDate);

   Boolean finishedProductsOutbound(FinishedProductsDTOParam param);

   List<OutboundDetailBasicDTO> getMeteByProject(Integer basicClass, List<Long> projectIds, LocalDateTime startDate, LocalDateTime endDate);

   Map<Long, BigDecimal> getNotProject(List<Long> classifyIds, MonthTimeRange monthTimeRange);

   Boolean BatchNestingDockingOutbound(BatchSchedulingOutboundDTOParam param);

   Boolean saveNestingDockingOutbound(SteelPlateOutboundDTOParam param);

   Boolean nestingDockingOutbound(SteelPlateOutboundDTOParam param);

   Boolean nestingDockingPassed(Long outboundId);

   PageVO<OutboundListDTO> nestingDockingPageInfo(QueryOutboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<Outbound> nestingDockingListInfo(QueryOutboundDTOParam param);

   OutboundDTO nestingDockingGetById(Long id);

   OutboundDTO getSchedulingMaterial(Long id);

   Boolean manuallyFreezeDirectOutbound(SteelPlateOutboundDTOParam param);

   Boolean manuallyFreezeSaveForSaleOutbound(SteelPlateOutboundDTOParam param);

   Boolean manuallyFreezeSubmitForSaleOutbound(SteelPlateOutboundDTOParam param);

   PageVO<OutboundListDTO> pageInfoV2(QueryOutboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<Outbound> listInfoV2(QueryOutboundDTOParam param);

   List<OutboundDTO> getByCurrentUserV2(Boolean boolPartyA, List<Integer> outboundTypes);

   Integer getDetailNumberV2(Boolean boolPartyA);

   Boolean saveOutsourcingOutbound(SteelPlateOutboundDTOParam param);

   Boolean outsourcingDirectSubmitReview(SteelPlateOutboundDTOParam param);

   Boolean outsourcingApproval(Long id, Long approveRecordId, Integer decision, String opinion);

   Boolean BatchOutsourcingSubmitReview(BatchOutboundDTOParam param);

   Boolean deleteOutsourcing(Long listId, Long materialId);

   Boolean deleteOutsourcingOutbound(Long id);

   Boolean outsourcingReturned(Long id, Integer reviewStatus);

   Boolean saveScrapsOutbound(SteelPlateOutboundDTOParam param);

   Boolean BatchScrapsOutbound(BatchOutboundDTOParam param);

   Boolean deleteScraps(Long listId, Long materialId);

   Boolean ScrapsPassed(Long id);

   Boolean saveForSaleOutbound(SteelPlateOutboundDTOParam param);

   Boolean submitForSaleOutbound(SteelPlateOutboundDTOParam param);

   Boolean BatchSaveForSale(BatchOutboundDTOParam param);

   Boolean BatchSubmitForSale(BatchOutboundDTOParam param);

   Outbound forSalePassed(OutboundDTOParam param, Outbound outbound, Integer decision, String opinion);

   Boolean reviewOutbound(Long approveRecordId, Integer decision, String opinion);

   Boolean submitReview(OutboundDTOParam param);

   Set<ProjectInfo> getOutsourcingProject();

   Boolean revocation(Long id);

   ProjectPickingListDTO getProjectPicking(QueryProjectPickingDTOParam param);

   ProjectPickingMeteListDTO PickingMete(QueryProjectPickingDTOParam param);

   Map<String, BigDecimal> CumulativePickingMete(QueryProjectPickingDTOParam param);

   void ProjectPickingDownload(QueryProjectPickingDTOParam param, HttpServletResponse response);

   OutboundDTO getPickingDetail(Long id);

   List<OutboundDetailDTO> getNumericalControlDetail(List<String> guids);

   Boolean SchedulingSubmitReview(String ids, Integer transactStatus);

   Boolean SchedulingReviewOutbound(Long approveRecordId, Integer decision, String opinion);

   List<OutboundDTO> getSchedulingOutboundDetail(Long id);

   Boolean deleteSchedulingOutboundDetail(Long listId, Long materialId);

   Outbound saveOutbound(List<PickingApproveOutboundDTOParam> partAParams, List<SplitMaterialDTO> partASplitParams, boolean b);

   Outbound saveOutbound(List<WmsShipmentReceiveApproveDetailDTOParam> partAParams, OutboundTypeEnum outboundType, boolean b);

   Boolean passedOutbound(Outbound outbound);

   Boolean fail(Long id, Integer reviewStatus, Integer materialFreezeType, Boolean boolInventory);

   List<OutboundDetailDTO> getOutboundDetailDTO(List<Long> outboundDetailIds);

   List<MoveOutboundDetail> getPassOrderDetail(Integer basicClass, Long workshopId, int size);

   Boolean updateOutboundDetail(UpdateOutboundDTOParam param);

   PageVO<OutboundDetailDTO> getAppProjectPicking(QueryProjectPickingDTOParam param, Integer pageNumber, Integer pageSize);
}
