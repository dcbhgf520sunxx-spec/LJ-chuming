package com.hzchum.scim.business.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "BusinessMachinePart对象", description = "商务直发零件dto ")
public class BusinessMachinePartDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   private String material;
   @ApiModelProperty(name = "totalQuantity", value = "总数", notes = "总数")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalWeight", value = "总重量(kg)", notes = "总重量(kg)")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "totalLength", value = "总长度(m)", notes = "总长度(m)")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式 0重量 1长度", notes = "计价方式 0重量 1长度")
   private Integer pricingManner;
   @ApiModelProperty(name = "status", value = "审核状态 1未审核 2已审核")
   private Integer status;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;

   public static BusinessMachinePartDTO.BusinessMachinePartDTOBuilder builder() {
      return new BusinessMachinePartDTO.BusinessMachinePartDTOBuilder();
   }

   public BusinessMachinePartDTO() {
   }

   public BusinessMachinePartDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String name,
      final String specification,
      final String material,
      final Integer totalQuantity,
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer pricingManner,
      final Integer status,
      final Boolean boolAllPartSendDirectly
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.name = name;
      this.specification = specification;
      this.material = material;
      this.totalQuantity = totalQuantity;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.pricingManner = pricingManner;
      this.status = status;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
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

   public Long getAreaId() {
      return this.areaId;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
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

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public BusinessMachinePartDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessMachinePartDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessMachinePartDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public BusinessMachinePartDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public BusinessMachinePartDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public BusinessMachinePartDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public BusinessMachinePartDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public BusinessMachinePartDTO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public BusinessMachinePartDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   public BusinessMachinePartDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public BusinessMachinePartDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public BusinessMachinePartDTO setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public BusinessMachinePartDTO setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   public BusinessMachinePartDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public BusinessMachinePartDTO setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessMachinePartDTO)) {
         return false;
      }

      BusinessMachinePartDTO other = (BusinessMachinePartDTO)o;
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
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$totalQuantity = this.getTotalQuantity();
                  Object other$totalQuantity = other.getTotalQuantity();
                  if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                     Object this$pricingManner = this.getPricingManner();
                     Object other$pricingManner = other.getPricingManner();
                     if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                           Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                           if (this$boolAllPartSendDirectly == null
                              ? other$boolAllPartSendDirectly == null
                              : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$totalWeight = this.getTotalWeight();
                                       Object other$totalWeight = other.getTotalWeight();
                                       if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                          Object this$totalLength = this.getTotalLength();
                                          Object other$totalLength = other.getTotalLength();
                                          if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
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
      return other instanceof BusinessMachinePartDTO;
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
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessMachinePartDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", pricingManner="
         + this.getPricingManner()
         + ", status="
         + this.getStatus()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ")";
   }

   public static class BusinessMachinePartDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String specification;
      private String material;
      private Integer totalQuantity;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer pricingManner;
      private Integer status;
      private Boolean boolAllPartSendDirectly;

      BusinessMachinePartDTOBuilder() {
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public BusinessMachinePartDTO.BusinessMachinePartDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public BusinessMachinePartDTO build() {
         return new BusinessMachinePartDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.name,
            this.specification,
            this.material,
            this.totalQuantity,
            this.totalWeight,
            this.totalLength,
            this.unitPrice,
            this.totalPrice,
            this.pricingManner,
            this.status,
            this.boolAllPartSendDirectly
         );
      }

      @Override
      public String toString() {
         return "BusinessMachinePartDTO.BusinessMachinePartDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalWeight="
            + this.totalWeight
            + ", totalLength="
            + this.totalLength
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", pricingManner="
            + this.pricingManner
            + ", status="
            + this.status
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ")";
      }
   }
}
