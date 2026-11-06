package com.hzchum.scim.scm.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectRelevancyDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.SupplierSettlementDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.PurchaseStandingBookDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefPurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefPurchaseOrderNewDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupMonthDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupMonthDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupSupplierDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseSupplierSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SimpleListDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierAllBriefDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseStatusDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.PurchaseOrderDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryPurchaseOrderDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.UserResponseVO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

public interface PurchaseOrderService extends IService<PurchaseOrder> {
   PageVO<PurchaseOrderDTO> pageInfo(QueryPurchaseOrderDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean save(PurchaseOrderDTOParam dtoParam);

   Boolean updatePurchaseOrder(PurchaseOrderDTOParam dtoParam);

   Boolean deletePurchaseOrder(List<Long> ids);

   List<SimpleListDTO> simpleListInfo();

   Boolean editPurchaseStatus(Long id, Integer purchaseStatus);

   void exportOrder(Long id, HttpServletResponse response);

   ListVO<BriefPurchaseOrderDTO> listBrief();

   ListVO<BriefPurchaseOrderNewDTO> listBriefV2(
      Boolean BoolAnnual, Long supplierId, Integer level, Integer dataStatus, List<Integer> projectAttribute, Long workshopId, Integer orderPlace
   );

   BriefPurchaseOrderDTO selectById(Long id);

   List listByCondition(
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Integer purchaseType,
      Long supplierId,
      String supplierName,
      String serialNumber,
      Long projectId,
      Integer settlementStatus
   );

   List<PurchaseSupplierSummaryDTO> listBySupplierSum(String supplierName, LocalDate startDate, LocalDate endDate);

   List<PurchaseOrder> listByProjectId(Long projectId);

   BigDecimal getPurchaseAmountSum(LocalDate startDate, LocalDate endDate, Long supplierId, Long branchCompanyId, Integer purchaseType);

   int getCount(Long classId);

   Map<String, Object> getStatistics();

   ListVO<PurchaseOrderDTO> getSNByYear(LocalDateTime year);

   ListVO getStructureClass(Long projectId, Long monomerId, Long areaId);

   PageVO getArtifactEnclosureDetail(Long projectId, Long monomerId, Long structureClassId, Integer type, Long areaId, Integer pageNumber, Integer pageSize);

   ListVO<PurchaseOrderDetailDTO> canInboundDetail(Long id);

   ListVO<PurchaseOrderDetailDTO> canInboundDetailV2(Long id);

   List<SupplierDTO> getSupplierInfo(Long id);

   List<MesBuildingWorkshop> getMesWorkshop();

   PageVO<PurchaseOrderDTO> pageInfoV2(QueryPurchaseOrderDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<BriefPurchaseOrderNewDTO> getSimplePageList(QueryPurchaseOrderDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   Map<Long, BigDecimal> getOrderIdAdjustAmountMap(Collection<Long> orderIds);

   Boolean saveV2(PurchaseOrderDTOParam dtoParam, Boolean boolAgainSubmit);

   Map<String, Object> getStatisticsV2(List<LocalDateTime> createTime);

   List<PurchaseOrderDTO> StagingList(Integer boolTemporaryStorage, List<Integer> projectAttribute);

   Integer StagingListCount(Integer boolTemporaryStorage, List<Integer> projectAttribute);

   Boolean deleteStagingPurchaseOrder(List<Integer> projectAttribute);

   Boolean deleteByIdStagingPurchaseOrder(List<Long> ids);

   BriefPurchaseOrderDTO selectByIdPurchaseOrder(Long id);

   Boolean editPurchaseStatusV2(Long id, Integer purchaseStatus);

   ResultVO submitOaReviewOrder(PurchaseOrderDTOParam param);

   Boolean submitReviewOrder(PurchaseOrderDTOParam param);

   Boolean updatePurchaseOrderV2(PurchaseOrderDTOParam dtoParam);

   ResultVO updateOaPurchaseOrderV2(PurchaseOrderDTOParam dtoParam);

   Boolean updateApplyPurchaseOrderStatus(List<ApplyPurchaseStatusDTOParam> applyPurchaseStatusDTOParams);

   Boolean ApprovePurchaseOrder(WmsApproveOpinionDTOParam wmsApproveOpinionDTOParam);

   Boolean revocation(Long id);

   Boolean cancellation(Long id);

   void purchaseExcel(Long id, HttpServletResponse response);

   List<UserResponseVO> selectUserList();

   List<ProjectRelevancyDTO> selectProjectList();

   Set<Long> selectCreatedProject();

   Boolean againSubmitPurchaseOrder(PurchaseOrderDTOParam param);

   Boolean updateUnderReviewPurchase(PurchaseOrderDTOParam param);

   Boolean checkClassify(Long classifyId);

   Boolean deleteType(PurchaseOrderDTOParam param);

   void updateApplyProductQuantityAndMete(PurchaseOrder purchaseOrder, Boolean boolAdd);

   void initUpdateOrderPlace();

   List<SupplierAllBriefDTO> getSupplier(Boolean boolAnnual, Integer level, Integer dataStatus, List<Integer> projectAttribute, Integer orderPlace);

   PrintVO<List<PurchaseOrderDTO>> purchaseOrderPrint(QueryPurchaseOrderDTOParam param);

   SupplierSettlementDto getPurchaseOrder(Long orderId);

   List<PurchaseStandingBookDTO> getSecondaryUnitAll(Long supplierId, Integer settlementStatus, String serialNumber, Integer basicClass, Long branchCompanyId);

   List<PurchaseOrderSummaryDTO> getPurchaseSummary(LocalDate yearDate, Long branchCompanyId);

   List<PurchaseOrderGroupMonthDTO> getGroupMonth(LocalDate yearDate, Long branchCompanyId);

   List<PurchaseOrderGroupDetailDTO> getGroupDetail(LocalDate yearDate, Boolean yearGroup, Long branchCompanyId);

   void getGroupDetailDownload(LocalDate yearDate, Boolean yearGroup, Long branchCompanyId, HttpServletResponse response);

   List<PurchaseOrderSummaryDTO> getSupplierSummary(LocalDate yearDate, Long branchCompanyId);

   List<PurchaseOrderGroupSupplierDetailDTO> getSupplierGroupDetail(LocalDate yearDate, Long branchCompanyId);

   void getSupplierGroupDetailDownload(LocalDate yearDate, Long branchCompanyId, HttpServletResponse response);

   List<PurchaseOrderGroupMonthDTO> getGroupSupplierMonth(LocalDate yearDate, Long branchCompanyId, Boolean isAmountSort);

   List<PurchaseOrderGroupMonthDetailDTO> getGroupMonthDetail(LocalDate yearDate, Long branchCompanyId, Long supplierId);

   void getGroupMonthDetailDownload(LocalDate yearDate, Long branchCompanyId, Long supplierId, HttpServletResponse response);

   Boolean update(Long id);

   PurchaseOrder getById(Long id);

   void setActualTotalMete(List<PurchaseOrderDTO> purchaseOrderDTOList);

   List<PurchaseOrder> listAllByIds(List<Long> ids);

   BigDecimal getActualInboundAmount(Long orderId, Integer orderPlace, Integer purchaseType);
}
