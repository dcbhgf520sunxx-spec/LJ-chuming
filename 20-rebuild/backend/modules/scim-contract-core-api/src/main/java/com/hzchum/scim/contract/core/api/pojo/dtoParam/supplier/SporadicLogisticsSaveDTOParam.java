package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("添加零星物流请求数据")
public class SporadicLogisticsSaveDTOParam {
   @ApiModelProperty("日期")
   private LocalDateTime reportDate;
   @ApiModelProperty("填报人")
   private String informantName;
   @ApiModelProperty("填报人id")
   private Long informantId;
   @ApiModelProperty("运承类型（1，个人。2，单位）")
   private Integer carrierType;
   @ApiModelProperty("供应商id（物流（收款）单位id）")
   private Long supplierId;
   @ApiModelProperty("供应商名称（物流（收款））单位")
   private String supplierName;
   @ApiModelProperty("所属项目id")
   private String projectId;
   @ApiModelProperty("申请金额")
   private BigDecimal applyAmount;
   @ApiModelProperty("备注")
   private String remark;

   public LocalDateTime getReportDate() {
      return this.reportDate;
   }

   public String getInformantName() {
      return this.informantName;
   }

   public Long getInformantId() {
      return this.informantId;
   }

   public Integer getCarrierType() {
      return this.carrierType;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getProjectId() {
      return this.projectId;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setReportDate(final LocalDateTime reportDate) {
      this.reportDate = reportDate;
   }

   public void setInformantName(final String informantName) {
      this.informantName = informantName;
   }

   public void setInformantId(final Long informantId) {
      this.informantId = informantId;
   }

   public void setCarrierType(final Integer carrierType) {
      this.carrierType = carrierType;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProjectId(final String projectId) {
      this.projectId = projectId;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SporadicLogisticsSaveDTOParam)) {
         return false;
      }

      SporadicLogisticsSaveDTOParam other = (SporadicLogisticsSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$informantId = this.getInformantId();
      Object other$informantId = other.getInformantId();
      if (this$informantId == null ? other$informantId == null : this$informantId.equals(other$informantId)) {
         Object this$carrierType = this.getCarrierType();
         Object other$carrierType = other.getCarrierType();
         if (this$carrierType == null ? other$carrierType == null : this$carrierType.equals(other$carrierType)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$reportDate = this.getReportDate();
               Object other$reportDate = other.getReportDate();
               if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                  Object this$informantName = this.getInformantName();
                  Object other$informantName = other.getInformantName();
                  if (this$informantName == null ? other$informantName == null : this$informantName.equals(other$informantName)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$applyAmount = this.getApplyAmount();
                           Object other$applyAmount = other.getApplyAmount();
                           if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SporadicLogisticsSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $informantId = this.getInformantId();
      result = result * 59 + ($informantId == null ? 43 : $informantId.hashCode());
      Object $carrierType = this.getCarrierType();
      result = result * 59 + ($carrierType == null ? 43 : $carrierType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $informantName = this.getInformantName();
      result = result * 59 + ($informantName == null ? 43 : $informantName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SporadicLogisticsSaveDTOParam(reportDate="
         + this.getReportDate()
         + ", informantName="
         + this.getInformantName()
         + ", informantId="
         + this.getInformantId()
         + ", carrierType="
         + this.getCarrierType()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectId="
         + this.getProjectId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
