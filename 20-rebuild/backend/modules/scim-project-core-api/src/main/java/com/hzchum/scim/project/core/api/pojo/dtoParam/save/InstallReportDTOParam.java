package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class InstallReportDTOParam {
   @ApiModelProperty(name = "productId", value = "产品ID(构件、围护、配套件id)")
   @NotNull(message = "产品ID不能为空")
   private Long productId;
   @ApiModelProperty(name = "reportQuantity", value = "填报数量")
   @NotNull(message = "填报数量不能为空")
   private BigDecimal reportQuantity;

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getReportQuantity() {
      return this.reportQuantity;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setReportQuantity(final BigDecimal reportQuantity) {
      this.reportQuantity = reportQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof InstallReportDTOParam)) {
         return false;
      } else {
         InstallReportDTOParam other = (InstallReportDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$reportQuantity = this.getReportQuantity();
               Object other$reportQuantity = other.getReportQuantity();
               return this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InstallReportDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      return result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "InstallReportDTOParam(productId=" + this.getProductId() + ", reportQuantity=" + this.getReportQuantity() + ")";
   }
}
