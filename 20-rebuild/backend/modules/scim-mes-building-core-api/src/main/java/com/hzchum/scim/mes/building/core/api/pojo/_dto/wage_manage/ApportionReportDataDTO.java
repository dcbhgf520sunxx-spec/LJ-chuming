package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("分摊报表数据DTO类")
public class ApportionReportDataDTO {
   @ApiModelProperty(name = "monthValue", value = "月份", notes = "月份")
   private Integer monthValue;
   @ApiModelProperty(name = "totalInboundQuantity", value = "入库总量（吨）", notes = "入库总量（吨）")
   private BigDecimal totalInboundQuantity;
   @ApiModelProperty(name = "typeName", value = "分摊类型名称", notes = "分摊类型名称")
   private String typeName;
   @ApiModelProperty(name = "cost", value = "费用", notes = "费用")
   private BigDecimal cost;

   public Integer getMonthValue() {
      return this.monthValue;
   }

   public BigDecimal getTotalInboundQuantity() {
      return this.totalInboundQuantity;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public void setMonthValue(final Integer monthValue) {
      this.monthValue = monthValue;
   }

   public void setTotalInboundQuantity(final BigDecimal totalInboundQuantity) {
      this.totalInboundQuantity = totalInboundQuantity;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setCost(final BigDecimal cost) {
      this.cost = cost;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApportionReportDataDTO)) {
         return false;
      }

      ApportionReportDataDTO other = (ApportionReportDataDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monthValue = this.getMonthValue();
      Object other$monthValue = other.getMonthValue();
      if (this$monthValue == null ? other$monthValue == null : this$monthValue.equals(other$monthValue)) {
         Object this$totalInboundQuantity = this.getTotalInboundQuantity();
         Object other$totalInboundQuantity = other.getTotalInboundQuantity();
         if (this$totalInboundQuantity == null ? other$totalInboundQuantity == null : this$totalInboundQuantity.equals(other$totalInboundQuantity)) {
            Object this$typeName = this.getTypeName();
            Object other$typeName = other.getTypeName();
            if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
               Object this$cost = this.getCost();
               Object other$cost = other.getCost();
               return this$cost == null ? other$cost == null : this$cost.equals(other$cost);
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
      return other instanceof ApportionReportDataDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monthValue = this.getMonthValue();
      result = result * 59 + ($monthValue == null ? 43 : $monthValue.hashCode());
      Object $totalInboundQuantity = this.getTotalInboundQuantity();
      result = result * 59 + ($totalInboundQuantity == null ? 43 : $totalInboundQuantity.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $cost = this.getCost();
      return result * 59 + ($cost == null ? 43 : $cost.hashCode());
   }

   @Override
   public String toString() {
      return "ApportionReportDataDTO(monthValue="
         + this.getMonthValue()
         + ", totalInboundQuantity="
         + this.getTotalInboundQuantity()
         + ", typeName="
         + this.getTypeName()
         + ", cost="
         + this.getCost()
         + ")";
   }
}
