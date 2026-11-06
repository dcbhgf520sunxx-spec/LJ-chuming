package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "LossStatisticsDetailDTO", description = "损耗统计任务详情DTO")
public class LossStatisticsDetailDTO {
   @ApiModelProperty(name = "createTime", notes = "创建时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDate createTime;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量（吨）")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private BigDecimal taskQuantity;
   @ApiModelProperty(name = "netWeight", notes = "净重（吨）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalWeight", notes = "总重量（吨）")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;

   public static LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder builder() {
      return new LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder();
   }

   public LossStatisticsDetailDTO() {
   }

   public LossStatisticsDetailDTO(
      final LocalDate createTime,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal taskQuantity,
      final BigDecimal netWeight,
      final BigDecimal totalWeight
   ) {
      this.createTime = createTime;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.taskQuantity = taskQuantity;
      this.netWeight = netWeight;
      this.totalWeight = totalWeight;
   }

   public LocalDate getCreateTime() {
      return this.createTime;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   @JsonProperty("createTime")
   public LossStatisticsDetailDTO setCreateTime(final LocalDate createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("name")
   public LossStatisticsDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public LossStatisticsDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public LossStatisticsDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("taskQuantity")
   public LossStatisticsDetailDTO setTaskQuantity(final BigDecimal taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("netWeight")
   public LossStatisticsDetailDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalWeight")
   public LossStatisticsDetailDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LossStatisticsDetailDTO)) {
         return false;
      }

      LossStatisticsDetailDTO other = (LossStatisticsDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createTime = this.getCreateTime();
      Object other$createTime = other.getCreateTime();
      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
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
      return other instanceof LossStatisticsDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      return result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
   }

   @Override
   public String toString() {
      return "LossStatisticsDetailDTO(createTime="
         + this.getCreateTime()
         + ", name="
         + this.getName()
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

   public static class LossStatisticsDetailDTOBuilder {
      private LocalDate createTime;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal taskQuantity;
      private BigDecimal netWeight;
      private BigDecimal totalWeight;

      LossStatisticsDetailDTOBuilder() {
      }

      @JsonProperty("createTime")
      public LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder createTime(final LocalDate createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("name")
      public LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("taskQuantity")
      public LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder taskQuantity(final BigDecimal taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("netWeight")
      public LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalWeight")
      public LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public LossStatisticsDetailDTO build() {
         return new LossStatisticsDetailDTO(
            this.createTime, this.name, this.serialNumber, this.specification, this.taskQuantity, this.netWeight, this.totalWeight
         );
      }

      @Override
      public String toString() {
         return "LossStatisticsDetailDTO.LossStatisticsDetailDTOBuilder(createTime="
            + this.createTime
            + ", name="
            + this.name
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
