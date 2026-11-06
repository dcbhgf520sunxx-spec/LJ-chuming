package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InboundAndOutboundDataDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InstantMessageHintDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.MonthRealTimeInventoryAmountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.NameAndValueDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectSteelCountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.RealTimeOutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.RealTimePurchaseAndInboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WMSStockTurnoverMonthVO;
import java.util.List;
import java.util.Map;

public interface WarehouseDataDashboardService {
   List<NameAndValueDTO> inventoryAmount(Long factoryId, Long workshopId);

   List<NameAndValueDTO> inventoryRatio(Long factoryId, Long workshopId);

   Map<String, List<RealTimeOutboundDTO>> realTimeOutbound(Long factoryId, Long workshopId);

   List<RealTimePurchaseAndInboundDTO> realTimePurchaseAndInbound(Long factoryId, Long workshopId);

   List<WMSStockTurnoverMonthVO> steelStockTurnover(Long factoryId, Long workshopId);

   List<InboundAndOutboundDataDTO> inboundAndOutboundData(Long factoryId, Long workshopId);

   List<ProjectSteelCountDTO> projectSteelCount(Long factoryId, Long workshopId);

   List<InstantMessageHintDTO> instantMessageHint(Long factoryId, Long workshopId);

   void saveInstantMessageHint(InstantMessageHintDTO instantMessageHintDTO);

   void delInstantMessageHint(InstantMessageHintDTO instantMessageHintDTO);

   List<MonthRealTimeInventoryAmountDTO> monthRealTimeInventoryAmount(Long factoryId, Long workshopId);
}
