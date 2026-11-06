package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDownloadParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryInventoryUseStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportAdjustDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportDeficitDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportSurplusDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface ReceiptDownloadService {
   void inboundDownload(QueryReportInboundDTOParam param, HttpServletResponse response);

   void inboundAndRejectDownload(QueryReportInboundDTOParam param, HttpServletResponse response);

   void outboundDownload(QueryDetailDTOParam param, HttpServletResponse response, int type);

   void outboundDownloadAndReturnDownload(QueryDetailDTOParam param, HttpServletResponse response, int type);

   void transferDownload(QueryDetailDTOParam param, HttpServletResponse response);

   void moveMaterialDownload(QueryDetailDTOParam param, HttpServletResponse response);

   void returnDetailDownload(QueryDetailDTOParam param, HttpServletResponse response);

   void rejectDetailDownload(QueryRejectDetailDTOParam param, HttpServletResponse response);

   void RDFeeDownload(QueryDetailDTOParam param, HttpServletResponse response);

   void statisticsDownload(QueryStatisticsDTOParam param, HttpServletResponse response);

   void statisticsDetailDownload(List<Long> ids, Integer formType, LocalDateTime date, List<Long> statId, HttpServletResponse response);

   void inventoryDetailExcel(
      Integer basicClass, List<Long> classifyId, Integer orderSupplyType, List<Long> workshopIds, String specification, HttpServletResponse response
   );

   void inventoryBeginExcel(List<Integer> basicClass, Boolean boolPartyA, String specification, HttpServletResponse response);

   void PSIExcel(Integer basicClass, List<LocalDateTime> times, String spec, BigDecimal thickness, Long classifyId, HttpServletResponse response);

   void inventoryDetailsRecordExcel(List<LocalDateTime> dates, String detailKey, HttpServletResponse response);

   void templateExcel(Integer receiptType, Integer basicClass, HttpServletResponse response);

   void adjustDetailListExcel(QueryReportAdjustDTOParam queryInboundDTOParam, HttpServletResponse response);

   void templateExcelV2(Integer receiptType, Integer basicClass, HttpServletResponse response);

   void rejectDetailsDownload(QueryRejectDetailDTOParam param, HttpServletResponse response);

   void outsourcingOutboundDownload(QueryDetailDTOParam param, HttpServletResponse response, int type);

   void forSaleDownload(QueryDetailDTOParam param, HttpServletResponse response, int type);

   void scrapsOutboundDownload(QueryDetailDTOParam param, HttpServletResponse response, int type);

   void deficitDetailExcel(QueryReportDeficitDTOParam param, HttpServletResponse response);

   void inboundManufacturedDownload(QueryInboundManufacturedDTOParam param, HttpServletResponse response);

   void outboundManufacturedDownload(QueryOutboundManufacturedDTOParam param, HttpServletResponse response);

   void returnManufacturedDownload(QueryReturnManufacturedDTOParam param, HttpServletResponse response);

   void inboundTemplateExcel(Boolean boolPartyA, Integer basicClass, HttpServletResponse response);

   void beginPeriodInboundTemplateExcel(Boolean boolPartyA, Integer basicClass, HttpServletResponse response);

   void surplusBatchDownload(QueryDownloadParam param, HttpServletResponse response);

   void surplusDetailsDownload(QueryReportSurplusDTOParam param, HttpServletResponse response);

   void inventoryStatisticsDownload(QueryInventoryUseStatisticsDTOParam param, HttpServletResponse response);

   void inventoryStatisticsDownloadNew(QueryInventoryUseStatisticsDTOParam param, HttpServletResponse response);

   void inventoryUseRecordDownload(Long id, HttpServletResponse response);

   void inventoryUseRecordDownloadNew(List<Long> ids, HttpServletResponse response);

   void inboundPurchaseDetailDownload(Long id, Integer basicClass, HttpServletResponse response);

   PrintVO<List<Map<String, Object>>> printDeliveryPurchaseOrderDetailList(Long orderId);

   void surplusImportTemplateExcel(Boolean boolPartyA, Integer basicClass, HttpServletResponse response);

   void loseInventoryDownload(QueryByMaterialDTOParam param, HttpServletResponse response);
}
