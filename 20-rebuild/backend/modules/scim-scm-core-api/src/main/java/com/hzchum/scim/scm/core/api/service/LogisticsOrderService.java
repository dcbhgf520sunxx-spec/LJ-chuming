package com.hzchum.scim.scm.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LoadingChargeRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsHomeDTO;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo.dto.LogisticsOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderFreightDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryLogisticsOrderDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LogisticsOrderService extends IService<LogisticsOrder> {
   PageVO<LogisticsOrderDTO> pageInfo(QueryLogisticsOrderDTOParam param, Integer pageNumber, Integer pageSize);

   Integer getCreateCount();

   List summaryBySupplier(Integer year, String supplierName);

   List<LogisticsHomeDTO> showAll(String supplierName);

   List<PurchaseOrderFreightDTO> getLogisticsFee(Long purchaseId, Long supplierId, Long branchCompanyId);

   BigDecimal getSumFreight(Long purchaseId, Long branchCompanyId, Long supplierId, LocalDate startDate, LocalDate endDate);

   PageVO<LoadingChargeRecordDTO> recordLoadingCharge(
      LocalDateTime passStartDate,
      LocalDateTime passEndDate,
      String licensePlate,
      String inboundSN,
      String purchaseOrderSN,
      String userName,
      Integer pageNumber,
      Integer pageSize
   );

   List<LoadingChargeRecordDTO> recordLoadingChargeAll(
      LocalDateTime passStartDate, LocalDateTime passEndDate, String licensePlate, String inboundSN, String purchaseOrderSN, String userName
   );

   BigDecimal loadingChargeCount(
      LocalDateTime passStartDate, LocalDateTime passEndDate, String licensePlate, String inboundSN, String purchaseOrderSN, String userName
   );
}
