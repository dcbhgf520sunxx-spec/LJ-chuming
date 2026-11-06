package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "MesBuildingPartReportDetailDTO", description = "零件上报明细")
public class MesBuildingPartReportDetailDTO {
   @ApiModelProperty(name = "createTime", notes = "日期")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDate createTime;
   @ApiModelProperty(name = "reportName", notes = " 上报人")
   @JsonProperty("reportName")
   @JSONField(name = "reportName")
   private String reportName;
   @ApiModelProperty(name = "monomerName", notes = "单体名称")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "serialNumber", notes = " 编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = " 规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "quantity", notes = " 数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private String quantity;
   @ApiModelProperty(name = "netWeight", notes = " 净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalWeight", notes = " 总重")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;

   public static MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder builder() {
      return new MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder();
   }

   public MesBuildingPartReportDetailDTO() {
   }

   public MesBuildingPartReportDetailDTO(
      final LocalDate createTime,
      final String reportName,
      final String monomerName,
      final String serialNumber,
      final String specification,
      final String quantity,
      final BigDecimal netWeight,
      final BigDecimal totalWeight
   ) {
      this.createTime = createTime;
      this.reportName = reportName;
      this.monomerName = monomerName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalWeight = totalWeight;
   }

   public LocalDate getCreateTime() {
      return this.createTime;
   }

   public String getReportName() {
      return this.reportName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   @JsonProperty("createTime")
   public MesBuildingPartReportDetailDTO setCreateTime(final LocalDate createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("reportName")
   public MesBuildingPartReportDetailDTO setReportName(final String reportName) {
      this.reportName = reportName;
      return this;
   }

   @JsonProperty("monomerName")
   public MesBuildingPartReportDetailDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingPartReportDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingPartReportDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingPartReportDetailDTO setQuantity(final String quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingPartReportDetailDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalWeight")
   public MesBuildingPartReportDetailDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartReportDetailDTO)) {
         return false;
      }

      MesBuildingPartReportDetailDTO other = (MesBuildingPartReportDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createTime = this.getCreateTime();
      Object other$createTime = other.getCreateTime();
      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
         Object this$reportName = this.getReportName();
         Object other$reportName = other.getReportName();
         if (this$reportName == null ? other$reportName == null : this$reportName.equals(other$reportName)) {
            Object this$monomerName = this.getMonomerName();
            Object other$monomerName = other.getMonomerName();
            if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$netWeight = this.getNetWeight();
                        Object other$netWeight = other.getNetWeight();
                        if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
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
      return other instanceof MesBuildingPartReportDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reportName = this.getReportName();
      result = result * 59 + ($reportName == null ? 43 : $reportName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      return result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPartReportDetailDTO(createTime="
         + this.getCreateTime()
         + ", reportName="
         + this.getReportName()
         + ", monomerName="
         + this.getMonomerName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ")";
   }

   public static class MesBuildingPartReportDetailDTOBuilder {
      private LocalDate createTime;
      private String reportName;
      private String monomerName;
      private String serialNumber;
      private String specification;
      private String quantity;
      private BigDecimal netWeight;
      private BigDecimal totalWeight;

      MesBuildingPartReportDetailDTOBuilder() {
      }

      @JsonProperty("createTime")
      public MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder createTime(final LocalDate createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("reportName")
      public MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder reportName(final String reportName) {
         this.reportName = reportName;
         return this;
      }

      @JsonProperty("monomerName")
      public MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder quantity(final String quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalWeight")
      public MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public MesBuildingPartReportDetailDTO build() {
         return new MesBuildingPartReportDetailDTO(
            this.createTime, this.reportName, this.monomerName, this.serialNumber, this.specification, this.quantity, this.netWeight, this.totalWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPartReportDetailDTO.MesBuildingPartReportDetailDTOBuilder(createTime="
            + this.createTime
            + ", reportName="
            + this.reportName
            + ", monomerName="
            + this.monomerName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalWeight="
            + this.totalWeight
            + ")";
      }
   }
}
