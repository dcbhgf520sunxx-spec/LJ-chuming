package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingCargoListProductLink对象", description = "发运产品关联")
public class CargoListProductLinkDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "cargoListId", value = "装车id", notes = "装车id")
   private Long cargoListId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(notes = "名称")
   private String name;
   @ApiModelProperty(notes = "编号")
   private String serialNumber;
   @ApiModelProperty(notes = "规格")
   private String specification;
   @ApiModelProperty(notes = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "装车数量", notes = "装车数量")
   private Integer quantity;
   @ApiModelProperty(name = "quantity", value = "装车核算量", notes = "装车核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "netWeight", value = "单净重", notes = "单净重")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重", notes = "单毛重")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "weight", value = "参与计算重量", notes = "参与计算重量")
   private BigDecimal weight;
   @ApiModelProperty(name = "length", value = "单长度", notes = "单长度")
   private BigDecimal length;
   @ApiModelProperty(name = "surfaceArea", value = "单面积", notes = "单面积")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "category", value = "围护类型 2压型彩板 4夹心板 8桁架楼承板 16压型楼承板 32折边件 枚举:EnclosureCategoryEnum", notes = "围护类型")
   private Integer category;
   @ApiModelProperty(name = "measureMode", value = "计量方式 构件:1理计2磅计, 围护:1长度计量2面积计量 ", notes = "计量方式 构件:1理计2磅计, 围护:1长度计量2面积计量")
   private Integer measureMode;
   @ApiModelProperty("备注")
   private String remark;

   public static CargoListProductLinkDTO.CargoListProductLinkDTOBuilder builder() {
      return new CargoListProductLinkDTO.CargoListProductLinkDTOBuilder();
   }

   public CargoListProductLinkDTO() {
   }

   public CargoListProductLinkDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final LocalDateTime auditTime,
      final Long cargoListId,
      final Long productId,
      final Integer productType,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer quantity,
      final BigDecimal mete,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal weight,
      final BigDecimal length,
      final BigDecimal surfaceArea,
      final Integer category,
      final Integer measureMode,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.auditTime = auditTime;
      this.cargoListId = cargoListId;
      this.productId = productId;
      this.productType = productType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.quantity = quantity;
      this.mete = mete;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.weight = weight;
      this.length = length;
      this.surfaceArea = surfaceArea;
      this.category = category;
      this.measureMode = measureMode;
      this.remark = remark;
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

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
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

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getMeasureMode() {
      return this.measureMode;
   }

   public String getRemark() {
      return this.remark;
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

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListProductLinkDTO)) {
         return false;
      }

      CargoListProductLinkDTO other = (CargoListProductLinkDTO)o;
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
                  Object this$cargoListId = this.getCargoListId();
                  Object other$cargoListId = other.getCargoListId();
                  if (this$cargoListId == null ? other$cargoListId == null : this$cargoListId.equals(other$cargoListId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$category = this.getCategory();
                              Object other$category = other.getCategory();
                              if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                 Object this$measureMode = this.getMeasureMode();
                                 Object other$measureMode = other.getMeasureMode();
                                 if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
                                    Object this$auditTime = this.getAuditTime();
                                    Object other$auditTime = other.getAuditTime();
                                    if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$netWeight = this.getNetWeight();
                                                      Object other$netWeight = other.getNetWeight();
                                                      if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                         Object this$grossWeight = this.getGrossWeight();
                                                         Object other$grossWeight = other.getGrossWeight();
                                                         if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                            Object this$weight = this.getWeight();
                                                            Object other$weight = other.getWeight();
                                                            if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                               Object this$length = this.getLength();
                                                               Object other$length = other.getLength();
                                                               if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                  Object this$surfaceArea = this.getSurfaceArea();
                                                                  Object other$surfaceArea = other.getSurfaceArea();
                                                                  if (this$surfaceArea == null
                                                                     ? other$surfaceArea == null
                                                                     : this$surfaceArea.equals(other$surfaceArea)) {
                                                                     Object this$remark = this.getRemark();
                                                                     Object other$remark = other.getRemark();
                                                                     return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof CargoListProductLinkDTO;
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
      Object $cargoListId = this.getCargoListId();
      result = result * 59 + ($cargoListId == null ? 43 : $cargoListId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListProductLinkDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", auditTime="
         + this.getAuditTime()
         + ", cargoListId="
         + this.getCargoListId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", weight="
         + this.getWeight()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", category="
         + this.getCategory()
         + ", measureMode="
         + this.getMeasureMode()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class CargoListProductLinkDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private LocalDateTime auditTime;
      private Long cargoListId;
      private Long productId;
      private Integer productType;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal weight;
      private BigDecimal length;
      private BigDecimal surfaceArea;
      private Integer category;
      private Integer measureMode;
      private String remark;

      CargoListProductLinkDTOBuilder() {
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      public CargoListProductLinkDTO.CargoListProductLinkDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CargoListProductLinkDTO build() {
         return new CargoListProductLinkDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.auditTime,
            this.cargoListId,
            this.productId,
            this.productType,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.quantity,
            this.mete,
            this.netWeight,
            this.grossWeight,
            this.weight,
            this.length,
            this.surfaceArea,
            this.category,
            this.measureMode,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "CargoListProductLinkDTO.CargoListProductLinkDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", auditTime="
            + this.auditTime
            + ", cargoListId="
            + this.cargoListId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", weight="
            + this.weight
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ", category="
            + this.category
            + ", measureMode="
            + this.measureMode
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
