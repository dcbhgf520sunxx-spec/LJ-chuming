package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("发运汇总信息")
public class CargoDayOrMonthSummaryDTO {
   @ApiModelProperty(name = "supplierName", value = "物流单位", notes = "物流单位")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   private String supplierName;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "date", value = "日期", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "shippedWeight", value = "对应日期发运重量", notes = "对应日期发运重量")
   @JsonProperty("shippedWeight")
   @JSONField(name = "shippedWeight")
   private BigDecimal shippedWeight;
   @ApiModelProperty(name = "totalWeight", value = "总发运重量", notes = "总发运重量")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;

   public static CargoDayOrMonthSummaryDTO.CargoDayOrMonthSummaryDTOBuilder builder() {
      return new CargoDayOrMonthSummaryDTO.CargoDayOrMonthSummaryDTOBuilder();
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getDate() {
      return this.date;
   }

   public BigDecimal getShippedWeight() {
      return this.shippedWeight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   @JsonProperty("supplierName")
   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   @JsonProperty("projectName")
   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @JsonProperty("date")
   public void setDate(final String date) {
      this.date = date;
   }

   @JsonProperty("shippedWeight")
   public void setShippedWeight(final BigDecimal shippedWeight) {
      this.shippedWeight = shippedWeight;
   }

   @JsonProperty("totalWeight")
   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoDayOrMonthSummaryDTO)) {
         return false;
      }

      CargoDayOrMonthSummaryDTO other = (CargoDayOrMonthSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierName = this.getSupplierName();
      Object other$supplierName = other.getSupplierName();
      if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$shippedWeight = this.getShippedWeight();
               Object other$shippedWeight = other.getShippedWeight();
               if (this$shippedWeight == null ? other$shippedWeight == null : this$shippedWeight.equals(other$shippedWeight)) {
                  Object this$totalWeight = this.getTotalWeight();
                  Object other$totalWeight = other.getTotalWeight();
                  return this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight);
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
      return other instanceof CargoDayOrMonthSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $shippedWeight = this.getShippedWeight();
      result = result * 59 + ($shippedWeight == null ? 43 : $shippedWeight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      return result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
   }

   @Override
   public String toString() {
      return "CargoDayOrMonthSummaryDTO(supplierName="
         + this.getSupplierName()
         + ", projectName="
         + this.getProjectName()
         + ", date="
         + this.getDate()
         + ", shippedWeight="
         + this.getShippedWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ")";
   }

   public CargoDayOrMonthSummaryDTO() {
   }

   public CargoDayOrMonthSummaryDTO(
      final String supplierName, final String projectName, final String date, final BigDecimal shippedWeight, final BigDecimal totalWeight
   ) {
      this.supplierName = supplierName;
      this.projectName = projectName;
      this.date = date;
      this.shippedWeight = shippedWeight;
      this.totalWeight = totalWeight;
   }

   public static class CargoDayOrMonthSummaryDTOBuilder {
      private String supplierName;
      private String projectName;
      private String date;
      private BigDecimal shippedWeight;
      private BigDecimal totalWeight;

      CargoDayOrMonthSummaryDTOBuilder() {
      }

      @JsonProperty("supplierName")
      public CargoDayOrMonthSummaryDTO.CargoDayOrMonthSummaryDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("projectName")
      public CargoDayOrMonthSummaryDTO.CargoDayOrMonthSummaryDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("date")
      public CargoDayOrMonthSummaryDTO.CargoDayOrMonthSummaryDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      @JsonProperty("shippedWeight")
      public CargoDayOrMonthSummaryDTO.CargoDayOrMonthSummaryDTOBuilder shippedWeight(final BigDecimal shippedWeight) {
         this.shippedWeight = shippedWeight;
         return this;
      }

      @JsonProperty("totalWeight")
      public CargoDayOrMonthSummaryDTO.CargoDayOrMonthSummaryDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public CargoDayOrMonthSummaryDTO build() {
         return new CargoDayOrMonthSummaryDTO(this.supplierName, this.projectName, this.date, this.shippedWeight, this.totalWeight);
      }

      @Override
      public String toString() {
         return "CargoDayOrMonthSummaryDTO.CargoDayOrMonthSummaryDTOBuilder(supplierName="
            + this.supplierName
            + ", projectName="
            + this.projectName
            + ", date="
            + this.date
            + ", shippedWeight="
            + this.shippedWeight
            + ", totalWeight="
            + this.totalWeight
            + ")";
      }
   }
}
