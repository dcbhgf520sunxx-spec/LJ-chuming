package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "BusinessArtifact对象", description = "结构")
public class BusinessArtifactDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "area", value = "区域", notes = "area")
   private NameInfo area;
   @ApiModelProperty(name = "boolMergeEnum", value = "是否合并计价", notes = "是否合并计价")
   private Boolean boolMergeEnum;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "material", value = "材质 若非合并计价，材质为空", notes = "材质 若非合并计价，材质为空")
   private String material;
   @ApiModelProperty(name = "totalQuantity", value = "总数", notes = "总数")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalWeight", value = "总重", notes = "总重")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "totalWeight", value = "总长", notes = "总长/米")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式  0重量 1长度", notes = "计价方式  0重量 1长度")
   private Integer pricingManner;
   @ApiModelProperty(name = "status", value = "审核状态 1未审核 2已审核")
   private Integer status;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;

   public static BusinessArtifactDTO.BusinessArtifactDTOBuilder builder() {
      return new BusinessArtifactDTO.BusinessArtifactDTOBuilder();
   }

   public BusinessArtifactDTO() {
   }

   public BusinessArtifactDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final NameInfo area,
      final Boolean boolMergeEnum,
      final String specification,
      final String name,
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
      this.area = area;
      this.boolMergeEnum = boolMergeEnum;
      this.specification = specification;
      this.name = name;
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

   public NameInfo getArea() {
      return this.area;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
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

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessArtifactDTO)) {
         return false;
      }

      BusinessArtifactDTO other = (BusinessArtifactDTO)o;
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
                              Object this$area = this.getArea();
                              Object other$area = other.getArea();
                              if (this$area == null ? other$area == null : this$area.equals(other$area)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessArtifactDTO;
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
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
      return "BusinessArtifactDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", area="
         + this.getArea()
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

   public static class BusinessArtifactDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private NameInfo area;
      private Boolean boolMergeEnum;
      private String specification;
      private String name;
      private String material;
      private Integer totalQuantity;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer pricingManner;
      private Integer status;
      private Boolean boolAllPartSendDirectly;

      BusinessArtifactDTOBuilder() {
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder boolMergeEnum(final Boolean boolMergeEnum) {
         this.boolMergeEnum = boolMergeEnum;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public BusinessArtifactDTO.BusinessArtifactDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public BusinessArtifactDTO build() {
         return new BusinessArtifactDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.area,
            this.boolMergeEnum,
            this.specification,
            this.name,
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
         return "BusinessArtifactDTO.BusinessArtifactDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", area="
            + this.area
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
