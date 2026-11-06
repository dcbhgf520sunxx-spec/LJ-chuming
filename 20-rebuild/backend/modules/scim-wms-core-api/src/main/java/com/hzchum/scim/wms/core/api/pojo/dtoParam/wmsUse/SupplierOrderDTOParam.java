package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

public class SupplierOrderDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("采购类型[1 原材料采购,2 制成品采购]")
   private Integer purchaseType;
   @ApiModelProperty("开始时间")
   private LocalDate startDate;
   @ApiModelProperty("结束时间")
   private LocalDate endDate;
   @ApiModelProperty("订单号")
   private String serialNumber;
   @ApiModelProperty("供应商")
   private String supplierName;
   @ApiModelProperty("结算状态[CheckStatusEnum 0未结算 1已结算]")
   private Integer settlementStatus;
}
