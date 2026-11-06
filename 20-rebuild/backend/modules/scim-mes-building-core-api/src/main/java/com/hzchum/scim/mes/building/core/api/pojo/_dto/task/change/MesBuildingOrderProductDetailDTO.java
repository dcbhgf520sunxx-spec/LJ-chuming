package com.hzchum.scim.mes.building.core.api.pojo._dto.task.change;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingOrderProductDetailDTO", description = "建刚工单生产详细信息")
public class MesBuildingOrderProductDetailDTO {
   @ApiModelProperty(name = "id", value = "工单id", notes = "工单id")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重", notes = "总净重")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重", notes = "总毛重")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "completeQuantity", value = "完成数量", notes = "完成数量")
   private Integer completeQuantity;
   @ApiModelProperty(name = "totalCompleteNetWeight", value = "完成总净重", notes = "完成总净重")
   private BigDecimal totalCompleteNetWeight;
   @ApiModelProperty(name = "totalCompleteGrossWeight", value = "完成总毛重", notes = "完成总毛重")
   private BigDecimal totalCompleteGrossWeight;

   public static MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder builder() {
      return new MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder();
   }

   public MesBuildingOrderProductDetailDTO() {
   }

   public MesBuildingOrderProductDetailDTO(
      final Long id,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final Integer completeQuantity,
      final BigDecimal totalCompleteNetWeight,
      final BigDecimal totalCompleteGrossWeight
   ) {
      this.id = id;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.completeQuantity = completeQuantity;
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getTotalCompleteNetWeight() {
      return this.totalCompleteNetWeight;
   }

   public BigDecimal getTotalCompleteGrossWeight() {
      return this.totalCompleteGrossWeight;
   }

   public MesBuildingOrderProductDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingOrderProductDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingOrderProductDetailDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public MesBuildingOrderProductDetailDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public MesBuildingOrderProductDetailDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public MesBuildingOrderProductDetailDTO setTotalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      return this;
   }

   public MesBuildingOrderProductDetailDTO setTotalCompleteGrossWeight(final BigDecimal totalCompleteGrossWeight) {
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingOrderProductDetailDTO(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", totalCompleteNetWeight="
         + this.getTotalCompleteNetWeight()
         + ", totalCompleteGrossWeight="
         + this.getTotalCompleteGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingOrderProductDetailDTO)) {
         return false;
      }

      MesBuildingOrderProductDetailDTO other = (MesBuildingOrderProductDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$totalNetWeight = this.getTotalNetWeight();
               Object other$totalNetWeight = other.getTotalNetWeight();
               if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                  Object this$totalGrossWeight = this.getTotalGrossWeight();
                  Object other$totalGrossWeight = other.getTotalGrossWeight();
                  if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                     Object this$totalCompleteNetWeight = this.getTotalCompleteNetWeight();
                     Object other$totalCompleteNetWeight = other.getTotalCompleteNetWeight();
                     if (this$totalCompleteNetWeight == null
                        ? other$totalCompleteNetWeight == null
                        : this$totalCompleteNetWeight.equals(other$totalCompleteNetWeight)) {
                        Object this$totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
                        Object other$totalCompleteGrossWeight = other.getTotalCompleteGrossWeight();
                        return this$totalCompleteGrossWeight == null
                           ? other$totalCompleteGrossWeight == null
                           : this$totalCompleteGrossWeight.equals(other$totalCompleteGrossWeight);
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
      return other instanceof MesBuildingOrderProductDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalCompleteNetWeight = this.getTotalCompleteNetWeight();
      result = result * 59 + ($totalCompleteNetWeight == null ? 43 : $totalCompleteNetWeight.hashCode());
      Object $totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
      return result * 59 + ($totalCompleteGrossWeight == null ? 43 : $totalCompleteGrossWeight.hashCode());
   }

   public static class MesBuildingOrderProductDetailDTOBuilder {
      private Long id;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private Integer completeQuantity;
      private BigDecimal totalCompleteNetWeight;
      private BigDecimal totalCompleteGrossWeight;

      MesBuildingOrderProductDetailDTOBuilder() {
      }

      public MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder totalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
         this.totalCompleteNetWeight = totalCompleteNetWeight;
         return this;
      }

      public MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder totalCompleteGrossWeight(final BigDecimal totalCompleteGrossWeight) {
         this.totalCompleteGrossWeight = totalCompleteGrossWeight;
         return this;
      }

      public MesBuildingOrderProductDetailDTO build() {
         return new MesBuildingOrderProductDetailDTO(
            this.id,
            this.quantity,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.completeQuantity,
            this.totalCompleteNetWeight,
            this.totalCompleteGrossWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingOrderProductDetailDTO.MesBuildingOrderProductDetailDTOBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", totalCompleteNetWeight="
            + this.totalCompleteNetWeight
            + ", totalCompleteGrossWeight="
            + this.totalCompleteGrossWeight
            + ")";
      }
   }
}
