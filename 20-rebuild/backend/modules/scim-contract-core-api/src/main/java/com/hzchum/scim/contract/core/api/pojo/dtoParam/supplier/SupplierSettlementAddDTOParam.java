package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMin;

/** Historical inner-purchase settlement protocol recovered from plm6-test-bak.jar; no attachment field. */
public class SupplierSettlementAddDTOParam {
   @NotNull
   private LocalDateTime applyDate;
   private Long applyUserId;
   @NotNull
   private Long projectId;
   @NotNull
   private Long supplierId;
   @NotNull
   private Long projectManagerId;
   @NotNull
   private Long orderId;
   @NotNull
   private String purchaseContractNumber;
   @NotNull
   @DecimalMin("0.01")
   private BigDecimal settlementAmount;
   private String remark;
   public LocalDateTime getApplyDate() { return applyDate; }
   public void setApplyDate(LocalDateTime value) { this.applyDate = value; }
   public Long getApplyUserId() { return applyUserId; }
   public void setApplyUserId(Long value) { this.applyUserId = value; }
   public Long getProjectId() { return projectId; }
   public void setProjectId(Long value) { this.projectId = value; }
   public Long getSupplierId() { return supplierId; }
   public void setSupplierId(Long value) { this.supplierId = value; }
   public Long getProjectManagerId() { return projectManagerId; }
   public void setProjectManagerId(Long value) { this.projectManagerId = value; }
   public Long getOrderId() { return orderId; }
   public void setOrderId(Long value) { this.orderId = value; }
   public String getPurchaseContractNumber() { return purchaseContractNumber; }
   public void setPurchaseContractNumber(String value) { this.purchaseContractNumber = value; }
   public BigDecimal getSettlementAmount() { return settlementAmount; }
   public void setSettlementAmount(BigDecimal value) { this.settlementAmount = value; }
   public String getRemark() { return remark; }
   public void setRemark(String value) { this.remark = value; }
}
