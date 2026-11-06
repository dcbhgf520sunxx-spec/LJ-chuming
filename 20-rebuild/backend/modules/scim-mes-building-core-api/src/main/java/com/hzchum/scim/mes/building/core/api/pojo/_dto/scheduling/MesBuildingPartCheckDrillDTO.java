package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingPartCheckDrillDTO", description = "零件验证排产请求类")
public class MesBuildingPartCheckDrillDTO {
   @ApiModelProperty(name = "id", value = "零件id", notes = "零件id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "thick", value = "厚(mm)")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private String thick;
   @ApiModelProperty(name = "taskOrderId", value = "工单id", notes = "工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty("净重(kg)")
   private BigDecimal netWeight;
   @ApiModelProperty("毛重(kg)")
   private BigDecimal grossWeight;

   public static MesBuildingPartCheckDrillDTO.MesBuildingPartCheckDrillDTOBuilder builder() {
      return new MesBuildingPartCheckDrillDTO.MesBuildingPartCheckDrillDTOBuilder();
   }

   public MesBuildingPartCheckDrillDTO(
      final Long id, final Integer quantity, final String thick, final Long taskOrderId, final BigDecimal netWeight, final BigDecimal grossWeight
   ) {
      this.id = id;
      this.quantity = quantity;
      this.thick = thick;
      this.taskOrderId = taskOrderId;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
   }

   public MesBuildingPartCheckDrillDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getThick() {
      return this.thick;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   @JsonProperty("id")
   public MesBuildingPartCheckDrillDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingPartCheckDrillDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingPartCheckDrillDTO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingPartCheckDrillDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   public MesBuildingPartCheckDrillDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public MesBuildingPartCheckDrillDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartCheckDrillDTO)) {
         return false;
      }

      MesBuildingPartCheckDrillDTO other = (MesBuildingPartCheckDrillDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$thick = this.getThick();
               Object other$thick = other.getThick();
               if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                  Object this$netWeight = this.getNetWeight();
                  Object other$netWeight = other.getNetWeight();
                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                     Object this$grossWeight = this.getGrossWeight();
                     Object other$grossWeight = other.getGrossWeight();
                     return this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight);
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
      return other instanceof MesBuildingPartCheckDrillDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      return result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPartCheckDrillDTO(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", thick="
         + this.getThick()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ")";
   }

   public static class MesBuildingPartCheckDrillDTOBuilder {
      private Long id;
      private Integer quantity;
      private String thick;
      private Long taskOrderId;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;

      MesBuildingPartCheckDrillDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPartCheckDrillDTO.MesBuildingPartCheckDrillDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingPartCheckDrillDTO.MesBuildingPartCheckDrillDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingPartCheckDrillDTO.MesBuildingPartCheckDrillDTOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingPartCheckDrillDTO.MesBuildingPartCheckDrillDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public MesBuildingPartCheckDrillDTO.MesBuildingPartCheckDrillDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public MesBuildingPartCheckDrillDTO.MesBuildingPartCheckDrillDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public MesBuildingPartCheckDrillDTO build() {
         return new MesBuildingPartCheckDrillDTO(this.id, this.quantity, this.thick, this.taskOrderId, this.netWeight, this.grossWeight);
      }

      @Override
      public String toString() {
         return "MesBuildingPartCheckDrillDTO.MesBuildingPartCheckDrillDTOBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", thick="
            + this.thick
            + ", taskOrderId="
            + this.taskOrderId
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ")";
      }
   }
}
