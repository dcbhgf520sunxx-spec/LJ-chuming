package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingAssembleTaskDTO", description = "部件对象 ")
public class MesBuildingAssembleTaskDTO {
   @ApiModelProperty(name = "serialNumber", notes = "部件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", notes = "部件数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "weight", notes = "部件重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;

   public static MesBuildingAssembleTaskDTO.MesBuildingAssembleTaskDTOBuilder builder() {
      return new MesBuildingAssembleTaskDTO.MesBuildingAssembleTaskDTOBuilder();
   }

   public MesBuildingAssembleTaskDTO() {
   }

   public MesBuildingAssembleTaskDTO(final String serialNumber, final Integer quantity, final BigDecimal weight) {
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.weight = weight;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   @JsonProperty("serialNumber")
   public MesBuildingAssembleTaskDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingAssembleTaskDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("weight")
   public MesBuildingAssembleTaskDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleTaskDTO(serialNumber=" + this.getSerialNumber() + ", quantity=" + this.getQuantity() + ", weight=" + this.getWeight() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleTaskDTO)) {
         return false;
      }

      MesBuildingAssembleTaskDTO other = (MesBuildingAssembleTaskDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$weight = this.getWeight();
            Object other$weight = other.getWeight();
            return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAssembleTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   public static class MesBuildingAssembleTaskDTOBuilder {
      private String serialNumber;
      private Integer quantity;
      private BigDecimal weight;

      MesBuildingAssembleTaskDTOBuilder() {
      }

      @JsonProperty("serialNumber")
      public MesBuildingAssembleTaskDTO.MesBuildingAssembleTaskDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingAssembleTaskDTO.MesBuildingAssembleTaskDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("weight")
      public MesBuildingAssembleTaskDTO.MesBuildingAssembleTaskDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public MesBuildingAssembleTaskDTO build() {
         return new MesBuildingAssembleTaskDTO(this.serialNumber, this.quantity, this.weight);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleTaskDTO.MesBuildingAssembleTaskDTOBuilder(serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ", weight="
            + this.weight
            + ")";
      }
   }
}
