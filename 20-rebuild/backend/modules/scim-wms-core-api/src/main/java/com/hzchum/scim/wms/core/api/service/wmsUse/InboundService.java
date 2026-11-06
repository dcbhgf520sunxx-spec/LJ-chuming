package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.YearSummaryDO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.BriefInboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundAmountDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PuchaseInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.APPInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.APPInboundPassDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AppCutMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ConditionsDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundQualityTestingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SurplusDetailDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface InboundService extends IService<Inbound> {
   PageVO<BriefInboundDTO> pageInfo(QueryInboundDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort);

   List<Inbound> listInfo(QueryInboundDTOParam dtoParam);

   Boolean saveInbound(InboundDTOParam dtoParam);

   Boolean saveSelfBuyingInboundV2(InboundDTOParam dtoParam);

   Boolean saveBeginSelfBuyingInbound(InboundDTOParam dtoParam);

   Boolean savePartyAInboundV2(InboundDTOParam dtoParam);

   Boolean saveBeginPartyAInbound(InboundDTOParam dtoParam);

   Boolean updateInbound(InboundDTOParam dtoParam);

   InboundDTO getList(Long id, Boolean b, Boolean qualityTestingBool);

   InboundDTO getListV2(Long id, Boolean b);

   List<Long> getIds(QueryInboundDTOParam queryInboundDTOParam);

   Boolean returned(Map<String, Object> map);

   Boolean returned(APPInboundPassDTOParam request);

   Boolean passed(InboundDTOParam request);

   List<InboundAmountDetailDTO> getDetails(Long purchaseOrderId);

   Map<String, BigDecimal> getAmount(Long purchaseOrderId);

   Boolean deleteByIds(List<Long> ids);

   void updateRejectStatus(Long inboundId);

   BigDecimal getInboundAmountSum(Long purchaseOrderId, Long supplierId);

   Map<Long, BigDecimal> getInboundAmountSumMap(Collection<Long> supplierIds, LocalDate startDate, LocalDate endDate);

   BigDecimal getInboundAmountSumV2(Long purchaseOrderId, Long supplierId);

   List<MonthSummaryDO> getMonthSummary(LocalDateTime year, Integer basicClass, Long classifyId, Integer thickness, Long specId, Long sectionSteelSpecId);

   List<YearSummaryDO> getYearSummary(LocalDateTime year, Integer basicClass);

   List<Integer> getThickness(Long classifyId);

   boolean qualityTesting(InboundQualityTestingDTOParam param);

   boolean qualityTestingV2(InboundQualityTestingDTOParam param);

   InboundDTO getQualityTestingDetail(Long id);

   PageVO<InboundDetailDTO> getQualityTestingDetailList(QueryInboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   Map<String, BigDecimal> getMeteByProjectId(Long pid, String year);

   List<BriefInboundDTO> getCanCheck(List<Integer> functionTypeList);

   Integer getCanCheckCount(List<Integer> functionTypeList);

   Object approvalSelfBuyingInbound(InboundDTOParam inboundDTOParam, Long approveRecordId, Integer decision, String opinion);

   Boolean approvalPartyAInbound(InboundDTOParam inboundDTOParam, Long approveRecordId, Integer decision, String opinion);

   Boolean returnUpdateInbound(InboundDTOParam request);

   Boolean revocation(Long id);

   InboundDTO getInboundDTOByRecordId(Long id);

   List<PuchaseInboundDetailDTO> orderDetailV2(Long orderId, LocalDate startTime, LocalDate endTime);

   List<PuchaseInboundDetailDTO> orderDetailV3(Long orderId);

   PrintVO<List<PuchaseInboundDetailDTO>> orderDetailV2Download(Long orderId, LocalDate startTime, LocalDate endTime);

   PrintVO<List<PuchaseInboundDetailDTO>> orderInboundDetailPrint(Long orderId, LocalDate startTime, LocalDate endTime);

   Boolean saveAPPInbound(APPInboundDTOParam appInboundDTOParam);

   Double getArea(APPInboundDTOParam request);

   Double getArea(String request);

   PageVO<AppInboundDetailDTO> selectAPPInboundDetailDTO(QueryInboundDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<SurplusDetailDTO> getSurplusList(
      Integer pageNumber, Integer pageSize, Boolean marking, String specification, BigDecimal thickness, Boolean boolPartyA, List<String> sort
   );

   Boolean updateMarking(Long id);

   ConditionsDTO getConditions();

   List<AppCutMaterialDTO> getMaterialInventory(Long id);

   BigDecimal getActualInboundAmount(Long orderId, Integer orderPlace, Integer purchaseType);

   Map<Long, BigDecimal> getPurchaseActualInboundAmountMap(Collection<Long> orderIds);

   PageVO<PuchaseInboundDetailDTO> orderReconciliationDetailAll(QueryPurchaseInboundDetailDTOParam queryDTOParam, Integer pageNumber, Integer pageSize);

   PrintVO<List<PuchaseInboundDetailDTO>> printOrderReconciliationDetailAll(QueryPurchaseInboundDetailDTOParam queryDTOParam);

   void orderDetailDownload(Long orderId, HttpServletResponse response);

   List<PuchaseInboundDetailDTO> getFactoryInboundDetailList(Long orderId, List<Long> orderDetailIds);

   List<PuchaseInboundDetailDTO> getConstructionInboundDetailList(Long orderId, List<Long> orderDetailIds);
}
