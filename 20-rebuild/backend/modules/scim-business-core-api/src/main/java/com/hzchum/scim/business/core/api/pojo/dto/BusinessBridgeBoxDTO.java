package com.hzchum.scim.business.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "BusinessBridgeBox对象", description = "分段(箱体)商务")
public class BusinessBridgeBoxDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "boolMergeEnum", value = "是否合并计价", notes = "是否合并计价")
   private Boolean boolMergeEnum;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   private String material;
   @ApiModelProperty(name = "totalQuantity", value = "总数", notes = "总数")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalWeight", value = "总重", notes = "总重")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   private BigDecimal totalPrice;
   @ApiModelProperty("审核状态")
   private Integer status;

   public static BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder builder() {
      return new BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder();
   }

   public BusinessBridgeBoxDTO() {
   }

   public BusinessBridgeBoxDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Boolean boolMergeEnum,
      final String specification,
      final String name,
      final String material,
      final Integer totalQuantity,
      final BigDecimal totalWeight,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer status
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.boolMergeEnum = boolMergeEnum;
      this.specification = specification;
      this.name = name;
      this.material = material;
      this.totalQuantity = totalQuantity;
      this.totalWeight = totalWeight;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Boolean getBoolMergeEnum() {
      return this.boolMergeEnum;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setBoolMergeEnum(final Boolean boolMergeEnum) {
      this.boolMergeEnum = boolMergeEnum;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessBridgeBoxDTO)) {
         return false;
      }

      BusinessBridgeBoxDTO other = (BusinessBridgeBoxDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$boolMergeEnum = this.getBoolMergeEnum();
               Object other$boolMergeEnum = other.getBoolMergeEnum();
               if (this$boolMergeEnum == null ? other$boolMergeEnum == null : this$boolMergeEnum.equals(other$boolMergeEnum)) {
                  Object this$totalQuantity = this.getTotalQuantity();
                  Object other$totalQuantity = other.getTotalQuantity();
                  if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$totalWeight = this.getTotalWeight();
                                 Object other$totalWeight = other.getTotalWeight();
                                 if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                    Object this$unitPrice = this.getUnitPrice();
                                    Object other$unitPrice = other.getUnitPrice();
                                    if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                       Object this$totalPrice = this.getTotalPrice();
                                       Object other$totalPrice = other.getTotalPrice();
                                       return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
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
      return other instanceof BusinessBridgeBoxDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $boolMergeEnum = this.getBoolMergeEnum();
      result = result * 59 + ($boolMergeEnum == null ? 43 : $boolMergeEnum.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessBridgeBoxDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", boolMergeEnum="
         + this.getBoolMergeEnum()
         + ", specification="
         + this.getSpecification()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class BusinessBridgeBoxDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Boolean boolMergeEnum;
      private String specification;
      private String name;
      private String material;
      private Integer totalQuantity;
      private BigDecimal totalWeight;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer status;

      BusinessBridgeBoxDTOBuilder() {
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder boolMergeEnum(final Boolean boolMergeEnum) {
         this.boolMergeEnum = boolMergeEnum;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public BusinessBridgeBoxDTO build() {
         return new BusinessBridgeBoxDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.boolMergeEnum,
            this.specification,
            this.name,
            this.material,
            this.totalQuantity,
            this.totalWeight,
            this.unitPrice,
            this.totalPrice,
            this.status
         );
      }

      @Override
      public String toString() {
         return "BusinessBridgeBoxDTO.BusinessBridgeBoxDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", boolMergeEnum="
            + this.boolMergeEnum
            + ", specification="
            + this.specification
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalWeight="
            + this.totalWeight
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", status="
            + this.status
            + ")";
      }
   }
}
