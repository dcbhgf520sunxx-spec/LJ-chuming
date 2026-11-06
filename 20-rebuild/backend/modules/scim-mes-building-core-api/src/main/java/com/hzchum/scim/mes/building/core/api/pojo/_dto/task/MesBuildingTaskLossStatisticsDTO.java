package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "MesBuildingTaskLossStatisticsDTO", description = "损失统计排产量")
public class MesBuildingTaskLossStatisticsDTO {
   @ApiModelProperty(name = "createTime", notes = "日期")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDate createTime;
   @ApiModelProperty(name = "monomerName", notes = " monomerName")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "serialNumber", notes = "  serialNumber")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = " specification")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "taskQuantity", notes = " taskQuantity")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "netWeight", notes = " netWeight")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalWeight", notes = " totalWeight")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;

   public static MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder builder() {
      return new MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder();
   }

   public MesBuildingTaskLossStatisticsDTO() {
   }

   public MesBuildingTaskLossStatisticsDTO(
      final LocalDate createTime,
      final String monomerName,
      final String serialNumber,
      final String specification,
      final Integer taskQuantity,
      final BigDecimal netWeight,
      final BigDecimal totalWeight
   ) {
      this.createTime = createTime;
      this.monomerName = monomerName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.taskQuantity = taskQuantity;
      this.netWeight = netWeight;
      this.totalWeight = totalWeight;
   }

   public LocalDate getCreateTime() {
      return this.createTime;
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

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   @JsonProperty("createTime")
   public MesBuildingTaskLossStatisticsDTO setCreateTime(final LocalDate createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("monomerName")
   public MesBuildingTaskLossStatisticsDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingTaskLossStatisticsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingTaskLossStatisticsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingTaskLossStatisticsDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingTaskLossStatisticsDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalWeight")
   public MesBuildingTaskLossStatisticsDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskLossStatisticsDTO)) {
         return false;
      }

      MesBuildingTaskLossStatisticsDTO other = (MesBuildingTaskLossStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskQuantity = this.getTaskQuantity();
      Object other$taskQuantity = other.getTaskQuantity();
      if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
         Object this$createTime = this.getCreateTime();
         Object other$createTime = other.getCreateTime();
         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
            Object this$monomerName = this.getMonomerName();
            Object other$monomerName = other.getMonomerName();
            if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskLossStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      return result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskLossStatisticsDTO(createTime="
         + this.getCreateTime()
         + ", monomerName="
         + this.getMonomerName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ")";
   }

   public static class MesBuildingTaskLossStatisticsDTOBuilder {
      private LocalDate createTime;
      private String monomerName;
      private String serialNumber;
      private String specification;
      private Integer taskQuantity;
      private BigDecimal netWeight;
      private BigDecimal totalWeight;

      MesBuildingTaskLossStatisticsDTOBuilder() {
      }

      @JsonProperty("createTime")
      public MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder createTime(final LocalDate createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("monomerName")
      public MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalWeight")
      public MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public MesBuildingTaskLossStatisticsDTO build() {
         return new MesBuildingTaskLossStatisticsDTO(
            this.createTime, this.monomerName, this.serialNumber, this.specification, this.taskQuantity, this.netWeight, this.totalWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskLossStatisticsDTO.MesBuildingTaskLossStatisticsDTOBuilder(createTime="
            + this.createTime
            + ", monomerName="
            + this.monomerName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", taskQuantity="
            + this.taskQuantity
            + ", netWeight="
            + this.netWeight
            + ", totalWeight="
            + this.totalWeight
            + ")";
      }
   }
}
