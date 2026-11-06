package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.CommonSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InboundDetailService extends IService<InboundDetail> {
   List<InboundRecordDTO> listInboundRecord(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSerialNumber,
      Long inboundId,
      String inboundSerialNumber
   );

   BigDecimal getInboundAmount(Long purchaseId, Long supplierId);

   List<InboundDetailDTO> getDetailList(String year, Long supplierId, List<Long> classifyIds, Long purchaseId, List<LocalDateTime> date);

   Map<String, BigDecimal> getMeteByYear(String year);

   List<InboundDetail> getListByApplyPurchaseId(Long id);

   QuantityMeteDTO getCountMete(Long purchaseId, List<Integer> status);

   BigDecimal getStorageQuantity();

   List<InboundDetail> selectPassDetailByPurchaseDetailIds(List<Long> purchaseDetailIds);

   List<InboundDetail> getInboundDetailList(Long purchaseId, Long purchaseDetailId, Integer reviewStatus);

   List<ReconciliationDetailDTO> orderReconciliationDetail(QueryPurchaseInboundDetailDTOParam queryDTOParam);

   List<CommonSummaryDTO> getMaterialInboundMete(Integer basicClass, List<Long> classifyIds, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<InboundDetail> getOperationsAnalysisInboundDetail(
      Integer basicClass, List<Long> classifyIds, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   );

   List<InboundDetail> getMaterialInbound(QueryByMaterialDTOParam param);

   HashMap<String, Object> getInboundPriceSummary(QueryByMaterialDTOParam param);

   List<ReceiptMeteDTO> getPurchaseInboundMete(List<Long> purchaseIds);

   List<InboundDetailDO> selectPassDetail(Long workshopId, LocalDateTime startDay, LocalDateTime endDay);
}
