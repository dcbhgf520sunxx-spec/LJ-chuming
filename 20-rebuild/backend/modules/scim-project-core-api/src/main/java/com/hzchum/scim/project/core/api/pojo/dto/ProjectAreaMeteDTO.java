package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProjectAreaMeteDTO {
   @ApiModelProperty(name = "id", value = "区域ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "区域名称")
   private String name;
   @ApiModelProperty(name = "productType", value = "区域产品类型 1构件 2压型彩板 4夹芯板 8")
   private Integer productType;
   @ApiModelProperty(name = "axis", value = "轴线或标高")
   private String axis;
   @ApiModelProperty(name = "quantity", value = "清单数")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "清单量(t或m)")
   private BigDecimal mete;
   @ApiModelProperty(name = "boolRelationStatus", value = "关联状态 true正常关联 false中断关联")
   private Boolean boolRelationStatus;
   @ApiModelProperty(name = "boolSettlementStatus", value = "订单结算状态 true已结算 false未结算", notes = "结算状态 true已结算 false未结算")
   private Boolean boolSettlementStatus;

   public static ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder builder() {
      return new ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder();
   }

   public ProjectAreaMeteDTO() {
   }

   public ProjectAreaMeteDTO(
      final Long id,
      final String name,
      final Integer productType,
      final String axis,
      final BigDecimal quantity,
      final BigDecimal mete,
      final Boolean boolRelationStatus,
      final Boolean boolSettlementStatus
   ) {
      this.id = id;
      this.name = name;
      this.productType = productType;
      this.axis = axis;
      this.quantity = quantity;
      this.mete = mete;
      this.boolRelationStatus = boolRelationStatus;
      this.boolSettlementStatus = boolSettlementStatus;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getAxis() {
      return this.axis;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Boolean getBoolRelationStatus() {
      return this.boolRelationStatus;
   }

   public Boolean getBoolSettlementStatus() {
      return this.boolSettlementStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setAxis(final String axis) {
      this.axis = axis;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setBoolRelationStatus(final Boolean boolRelationStatus) {
      this.boolRelationStatus = boolRelationStatus;
   }

   public void setBoolSettlementStatus(final Boolean boolSettlementStatus) {
      this.boolSettlementStatus = boolSettlementStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAreaMeteDTO)) {
         return false;
      }

      ProjectAreaMeteDTO other = (ProjectAreaMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$boolRelationStatus = this.getBoolRelationStatus();
            Object other$boolRelationStatus = other.getBoolRelationStatus();
            if (this$boolRelationStatus == null ? other$boolRelationStatus == null : this$boolRelationStatus.equals(other$boolRelationStatus)) {
               Object this$boolSettlementStatus = this.getBoolSettlementStatus();
               Object other$boolSettlementStatus = other.getBoolSettlementStatus();
               if (this$boolSettlementStatus == null ? other$boolSettlementStatus == null : this$boolSettlementStatus.equals(other$boolSettlementStatus)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$axis = this.getAxis();
                     Object other$axis = other.getAxis();
                     if (this$axis == null ? other$axis == null : this$axis.equals(other$axis)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$mete = this.getMete();
                           Object other$mete = other.getMete();
                           return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof ProjectAreaMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolRelationStatus = this.getBoolRelationStatus();
      result = result * 59 + ($boolRelationStatus == null ? 43 : $boolRelationStatus.hashCode());
      Object $boolSettlementStatus = this.getBoolSettlementStatus();
      result = result * 59 + ($boolSettlementStatus == null ? 43 : $boolSettlementStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $axis = this.getAxis();
      result = result * 59 + ($axis == null ? 43 : $axis.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAreaMeteDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", axis="
         + this.getAxis()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", boolRelationStatus="
         + this.getBoolRelationStatus()
         + ", boolSettlementStatus="
         + this.getBoolSettlementStatus()
         + ")";
   }

   public static class ProjectAreaMeteDTOBuilder {
      private Long id;
      private String name;
      private Integer productType;
      private String axis;
      private BigDecimal quantity;
      private BigDecimal mete;
      private Boolean boolRelationStatus;
      private Boolean boolSettlementStatus;

      ProjectAreaMeteDTOBuilder() {
      }

      public ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder axis(final String axis) {
         this.axis = axis;
         return this;
      }

      public ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder boolRelationStatus(final Boolean boolRelationStatus) {
         this.boolRelationStatus = boolRelationStatus;
         return this;
      }

      public ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this;
      }

      public ProjectAreaMeteDTO build() {
         return new ProjectAreaMeteDTO(
            this.id, this.name, this.productType, this.axis, this.quantity, this.mete, this.boolRelationStatus, this.boolSettlementStatus
         );
      }

      @Override
      public String toString() {
         return "ProjectAreaMeteDTO.ProjectAreaMeteDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productType="
            + this.productType
            + ", axis="
            + this.axis
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", boolRelationStatus="
            + this.boolRelationStatus
            + ", boolSettlementStatus="
            + this.boolSettlementStatus
            + ")";
      }
   }
}
