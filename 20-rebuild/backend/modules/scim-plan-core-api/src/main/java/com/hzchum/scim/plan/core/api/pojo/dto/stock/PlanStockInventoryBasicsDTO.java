package com.hzchum.scim.plan.core.api.pojo.dto.stock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;

@ApiModel("备料库存利用单基础DTO类")
public class PlanStockInventoryBasicsDTO {
   @ApiModelProperty("库存利用单id")
   private Long id;
   @ApiModelProperty("备注")
   private String remark;
   @Valid
   @ApiModelProperty("库存利用单")
   private PlanWmsInventoryDTO material;

   public static PlanStockInventoryBasicsDTO.PlanStockInventoryBasicsDTOBuilder builder() {
      return new PlanStockInventoryBasicsDTO.PlanStockInventoryBasicsDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getRemark() {
      return this.remark;
   }

   public PlanWmsInventoryDTO getMaterial() {
      return this.material;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMaterial(final PlanWmsInventoryDTO material) {
      this.material = material;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanStockInventoryBasicsDTO)) {
         return false;
      }

      PlanStockInventoryBasicsDTO other = (PlanStockInventoryBasicsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$remark = this.getRemark();
         Object other$remark = other.getRemark();
         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            return this$material == null ? other$material == null : this$material.equals(other$material);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanStockInventoryBasicsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "PlanStockInventoryBasicsDTO(id=" + this.getId() + ", remark=" + this.getRemark() + ", material=" + this.getMaterial() + ")";
   }

   public PlanStockInventoryBasicsDTO() {
   }

   public PlanStockInventoryBasicsDTO(final Long id, final String remark, final PlanWmsInventoryDTO material) {
      this.id = id;
      this.remark = remark;
      this.material = material;
   }

   public static class PlanStockInventoryBasicsDTOBuilder {
      private Long id;
      private String remark;
      private PlanWmsInventoryDTO material;

      PlanStockInventoryBasicsDTOBuilder() {
      }

      public PlanStockInventoryBasicsDTO.PlanStockInventoryBasicsDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanStockInventoryBasicsDTO.PlanStockInventoryBasicsDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PlanStockInventoryBasicsDTO.PlanStockInventoryBasicsDTOBuilder material(final PlanWmsInventoryDTO material) {
         this.material = material;
         return this;
      }

      public PlanStockInventoryBasicsDTO build() {
         return new PlanStockInventoryBasicsDTO(this.id, this.remark, this.material);
      }

      @Override
      public String toString() {
         return "PlanStockInventoryBasicsDTO.PlanStockInventoryBasicsDTOBuilder(id="
            + this.id
            + ", remark="
            + this.remark
            + ", material="
            + this.material
            + ")";
      }
   }
}
