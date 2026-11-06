package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingDrillQuantitySummaryDTO", description = "零件钻孔汇总")
public class MesBuildingDrillQuantitySummaryDTO {
   @ApiModelProperty(name = "boolDrillEnum", value = "是否钻孔")
   @JsonProperty("boolDrillEnum")
   @JSONField(name = "boolDrillEnum")
   private Boolean boolDrillEnum;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "drillQuantity", value = "钻孔数量")
   @JsonProperty("drillQuantity")
   @JSONField(name = "drillQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer drillQuantity;
   @ApiModelProperty("是否全部匹配(0:否,1:是)")
   private Boolean boolAllMatched;

   public static MesBuildingDrillQuantitySummaryDTO.MesBuildingDrillQuantitySummaryDTOBuilder builder() {
      return new MesBuildingDrillQuantitySummaryDTO.MesBuildingDrillQuantitySummaryDTOBuilder();
   }

   public MesBuildingDrillQuantitySummaryDTO(final Boolean boolDrillEnum, final Integer quantity, final Integer drillQuantity, final Boolean boolAllMatched) {
      this.boolDrillEnum = boolDrillEnum;
      this.quantity = quantity;
      this.drillQuantity = drillQuantity;
      this.boolAllMatched = boolAllMatched;
   }

   public MesBuildingDrillQuantitySummaryDTO() {
   }

   public Boolean getBoolDrillEnum() {
      return this.boolDrillEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getDrillQuantity() {
      return this.drillQuantity;
   }

   public Boolean getBoolAllMatched() {
      return this.boolAllMatched;
   }

   @JsonProperty("boolDrillEnum")
   public MesBuildingDrillQuantitySummaryDTO setBoolDrillEnum(final Boolean boolDrillEnum) {
      this.boolDrillEnum = boolDrillEnum;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingDrillQuantitySummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("drillQuantity")
   public MesBuildingDrillQuantitySummaryDTO setDrillQuantity(final Integer drillQuantity) {
      this.drillQuantity = drillQuantity;
      return this;
   }

   public MesBuildingDrillQuantitySummaryDTO setBoolAllMatched(final Boolean boolAllMatched) {
      this.boolAllMatched = boolAllMatched;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingDrillQuantitySummaryDTO(boolDrillEnum="
         + this.getBoolDrillEnum()
         + ", quantity="
         + this.getQuantity()
         + ", drillQuantity="
         + this.getDrillQuantity()
         + ", boolAllMatched="
         + this.getBoolAllMatched()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingDrillQuantitySummaryDTO)) {
         return false;
      }

      MesBuildingDrillQuantitySummaryDTO other = (MesBuildingDrillQuantitySummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolDrillEnum = this.getBoolDrillEnum();
      Object other$boolDrillEnum = other.getBoolDrillEnum();
      if (this$boolDrillEnum == null ? other$boolDrillEnum == null : this$boolDrillEnum.equals(other$boolDrillEnum)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$drillQuantity = this.getDrillQuantity();
            Object other$drillQuantity = other.getDrillQuantity();
            if (this$drillQuantity == null ? other$drillQuantity == null : this$drillQuantity.equals(other$drillQuantity)) {
               Object this$boolAllMatched = this.getBoolAllMatched();
               Object other$boolAllMatched = other.getBoolAllMatched();
               return this$boolAllMatched == null ? other$boolAllMatched == null : this$boolAllMatched.equals(other$boolAllMatched);
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
      return other instanceof MesBuildingDrillQuantitySummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolDrillEnum = this.getBoolDrillEnum();
      result = result * 59 + ($boolDrillEnum == null ? 43 : $boolDrillEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $drillQuantity = this.getDrillQuantity();
      result = result * 59 + ($drillQuantity == null ? 43 : $drillQuantity.hashCode());
      Object $boolAllMatched = this.getBoolAllMatched();
      return result * 59 + ($boolAllMatched == null ? 43 : $boolAllMatched.hashCode());
   }

   public static class MesBuildingDrillQuantitySummaryDTOBuilder {
      private Boolean boolDrillEnum;
      private Integer quantity;
      private Integer drillQuantity;
      private Boolean boolAllMatched;

      MesBuildingDrillQuantitySummaryDTOBuilder() {
      }

      @JsonProperty("boolDrillEnum")
      public MesBuildingDrillQuantitySummaryDTO.MesBuildingDrillQuantitySummaryDTOBuilder boolDrillEnum(final Boolean boolDrillEnum) {
         this.boolDrillEnum = boolDrillEnum;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingDrillQuantitySummaryDTO.MesBuildingDrillQuantitySummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("drillQuantity")
      public MesBuildingDrillQuantitySummaryDTO.MesBuildingDrillQuantitySummaryDTOBuilder drillQuantity(final Integer drillQuantity) {
         this.drillQuantity = drillQuantity;
         return this;
      }

      public MesBuildingDrillQuantitySummaryDTO.MesBuildingDrillQuantitySummaryDTOBuilder boolAllMatched(final Boolean boolAllMatched) {
         this.boolAllMatched = boolAllMatched;
         return this;
      }

      public MesBuildingDrillQuantitySummaryDTO build() {
         return new MesBuildingDrillQuantitySummaryDTO(this.boolDrillEnum, this.quantity, this.drillQuantity, this.boolAllMatched);
      }

      @Override
      public String toString() {
         return "MesBuildingDrillQuantitySummaryDTO.MesBuildingDrillQuantitySummaryDTOBuilder(boolDrillEnum="
            + this.boolDrillEnum
            + ", quantity="
            + this.quantity
            + ", drillQuantity="
            + this.drillQuantity
            + ", boolAllMatched="
            + this.boolAllMatched
            + ")";
      }
   }
}
