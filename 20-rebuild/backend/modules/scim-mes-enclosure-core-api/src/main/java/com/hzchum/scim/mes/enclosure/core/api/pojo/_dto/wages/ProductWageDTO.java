package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductWageDTO", description = "")
public class ProductWageDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "surfaceArea", notes = "面积（㎡）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "wage", value = "单价", notes = "新价格")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   private BigDecimal wage;
   @ApiModelProperty(name = "primerWage", value = "底漆价格", notes = "底漆价格")
   @JsonProperty("primerWage")
   @JSONField(name = "primerWage")
   private BigDecimal primerWage;
   @ApiModelProperty(name = "intermediatePaintWage", value = "中间漆价格", notes = "中间漆价格")
   @JsonProperty("intermediatePaintWage")
   @JSONField(name = "intermediatePaintWage")
   private BigDecimal intermediatePaintWage;
   @ApiModelProperty(name = "topcoatWage", value = "面漆单价", notes = "面漆单价")
   @JsonProperty("topcoatWage")
   @JSONField(name = "topcoatWage")
   private BigDecimal topcoatWage;
   @ApiModelProperty(name = "primerWageQuotaType", value = "底漆价格", notes = "底漆价格")
   @JsonProperty("primerWageQuotaType")
   @JSONField(name = "primerWageQuotaType")
   private Integer primerWageQuotaType;
   @ApiModelProperty(name = "intermediatePaintWageQuotaType", value = "中间漆价格", notes = "中间漆价格")
   @JsonProperty("intermediatePaintWageQuotaType")
   @JSONField(name = "intermediatePaintWageQuotaType")
   private Integer intermediatePaintWageQuotaType;
   @ApiModelProperty(name = "topcoatWageQuotaType", value = "面漆单价", notes = "面漆单价")
   @JsonProperty("topcoatWageQuotaType")
   @JSONField(name = "topcoatWageQuotaType")
   private Integer topcoatWageQuotaType;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;

   public static ProductWageDTO.ProductWageDTOBuilder builder() {
      return new ProductWageDTO.ProductWageDTOBuilder();
   }

   public ProductWageDTO(
      final Long id,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal surfaceArea,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final BigDecimal wage,
      final BigDecimal primerWage,
      final BigDecimal intermediatePaintWage,
      final BigDecimal topcoatWage,
      final Integer primerWageQuotaType,
      final Integer intermediatePaintWageQuotaType,
      final Integer topcoatWageQuotaType,
      final Integer wageQuotaType
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.surfaceArea = surfaceArea;
      this.monomer = monomer;
      this.area = area;
      this.wage = wage;
      this.primerWage = primerWage;
      this.intermediatePaintWage = intermediatePaintWage;
      this.topcoatWage = topcoatWage;
      this.primerWageQuotaType = primerWageQuotaType;
      this.intermediatePaintWageQuotaType = intermediatePaintWageQuotaType;
      this.topcoatWageQuotaType = topcoatWageQuotaType;
      this.wageQuotaType = wageQuotaType;
   }

   public ProductWageDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public BigDecimal getPrimerWage() {
      return this.primerWage;
   }

   public BigDecimal getIntermediatePaintWage() {
      return this.intermediatePaintWage;
   }

   public BigDecimal getTopcoatWage() {
      return this.topcoatWage;
   }

   public Integer getPrimerWageQuotaType() {
      return this.primerWageQuotaType;
   }

   public Integer getIntermediatePaintWageQuotaType() {
      return this.intermediatePaintWageQuotaType;
   }

   public Integer getTopcoatWageQuotaType() {
      return this.topcoatWageQuotaType;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   @JsonProperty("id")
   public ProductWageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductWageDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProductWageDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ProductWageDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ProductWageDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public ProductWageDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ProductWageDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("surfaceArea")
   public ProductWageDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("monomer")
   public ProductWageDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public ProductWageDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("wage")
   public ProductWageDTO setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("primerWage")
   public ProductWageDTO setPrimerWage(final BigDecimal primerWage) {
      this.primerWage = primerWage;
      return this;
   }

   @JsonProperty("intermediatePaintWage")
   public ProductWageDTO setIntermediatePaintWage(final BigDecimal intermediatePaintWage) {
      this.intermediatePaintWage = intermediatePaintWage;
      return this;
   }

   @JsonProperty("topcoatWage")
   public ProductWageDTO setTopcoatWage(final BigDecimal topcoatWage) {
      this.topcoatWage = topcoatWage;
      return this;
   }

   @JsonProperty("primerWageQuotaType")
   public ProductWageDTO setPrimerWageQuotaType(final Integer primerWageQuotaType) {
      this.primerWageQuotaType = primerWageQuotaType;
      return this;
   }

   @JsonProperty("intermediatePaintWageQuotaType")
   public ProductWageDTO setIntermediatePaintWageQuotaType(final Integer intermediatePaintWageQuotaType) {
      this.intermediatePaintWageQuotaType = intermediatePaintWageQuotaType;
      return this;
   }

   @JsonProperty("topcoatWageQuotaType")
   public ProductWageDTO setTopcoatWageQuotaType(final Integer topcoatWageQuotaType) {
      this.topcoatWageQuotaType = topcoatWageQuotaType;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public ProductWageDTO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @Override
   public String toString() {
      return "ProductWageDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", wage="
         + this.getWage()
         + ", primerWage="
         + this.getPrimerWage()
         + ", intermediatePaintWage="
         + this.getIntermediatePaintWage()
         + ", topcoatWage="
         + this.getTopcoatWage()
         + ", primerWageQuotaType="
         + this.getPrimerWageQuotaType()
         + ", intermediatePaintWageQuotaType="
         + this.getIntermediatePaintWageQuotaType()
         + ", topcoatWageQuotaType="
         + this.getTopcoatWageQuotaType()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductWageDTO)) {
         return false;
      }

      ProductWageDTO other = (ProductWageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$primerWageQuotaType = this.getPrimerWageQuotaType();
            Object other$primerWageQuotaType = other.getPrimerWageQuotaType();
            if (this$primerWageQuotaType == null ? other$primerWageQuotaType == null : this$primerWageQuotaType.equals(other$primerWageQuotaType)) {
               Object this$intermediatePaintWageQuotaType = this.getIntermediatePaintWageQuotaType();
               Object other$intermediatePaintWageQuotaType = other.getIntermediatePaintWageQuotaType();
               if (this$intermediatePaintWageQuotaType == null
                  ? other$intermediatePaintWageQuotaType == null
                  : this$intermediatePaintWageQuotaType.equals(other$intermediatePaintWageQuotaType)) {
                  Object this$topcoatWageQuotaType = this.getTopcoatWageQuotaType();
                  Object other$topcoatWageQuotaType = other.getTopcoatWageQuotaType();
                  if (this$topcoatWageQuotaType == null ? other$topcoatWageQuotaType == null : this$topcoatWageQuotaType.equals(other$topcoatWageQuotaType)) {
                     Object this$wageQuotaType = this.getWageQuotaType();
                     Object other$wageQuotaType = other.getWageQuotaType();
                     if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$length = this.getLength();
                              Object other$length = other.getLength();
                              if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$netWeight = this.getNetWeight();
                                    Object other$netWeight = other.getNetWeight();
                                    if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                       Object this$surfaceArea = this.getSurfaceArea();
                                       Object other$surfaceArea = other.getSurfaceArea();
                                       if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                          Object this$monomer = this.getMonomer();
                                          Object other$monomer = other.getMonomer();
                                          if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                             Object this$area = this.getArea();
                                             Object other$area = other.getArea();
                                             if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                Object this$wage = this.getWage();
                                                Object other$wage = other.getWage();
                                                if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                   Object this$primerWage = this.getPrimerWage();
                                                   Object other$primerWage = other.getPrimerWage();
                                                   if (this$primerWage == null ? other$primerWage == null : this$primerWage.equals(other$primerWage)) {
                                                      Object this$intermediatePaintWage = this.getIntermediatePaintWage();
                                                      Object other$intermediatePaintWage = other.getIntermediatePaintWage();
                                                      if (this$intermediatePaintWage == null
                                                         ? other$intermediatePaintWage == null
                                                         : this$intermediatePaintWage.equals(other$intermediatePaintWage)) {
                                                         Object this$topcoatWage = this.getTopcoatWage();
                                                         Object other$topcoatWage = other.getTopcoatWage();
                                                         return this$topcoatWage == null
                                                            ? other$topcoatWage == null
                                                            : this$topcoatWage.equals(other$topcoatWage);
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
      return other instanceof ProductWageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $primerWageQuotaType = this.getPrimerWageQuotaType();
      result = result * 59 + ($primerWageQuotaType == null ? 43 : $primerWageQuotaType.hashCode());
      Object $intermediatePaintWageQuotaType = this.getIntermediatePaintWageQuotaType();
      result = result * 59 + ($intermediatePaintWageQuotaType == null ? 43 : $intermediatePaintWageQuotaType.hashCode());
      Object $topcoatWageQuotaType = this.getTopcoatWageQuotaType();
      result = result * 59 + ($topcoatWageQuotaType == null ? 43 : $topcoatWageQuotaType.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $primerWage = this.getPrimerWage();
      result = result * 59 + ($primerWage == null ? 43 : $primerWage.hashCode());
      Object $intermediatePaintWage = this.getIntermediatePaintWage();
      result = result * 59 + ($intermediatePaintWage == null ? 43 : $intermediatePaintWage.hashCode());
      Object $topcoatWage = this.getTopcoatWage();
      return result * 59 + ($topcoatWage == null ? 43 : $topcoatWage.hashCode());
   }

   public static class ProductWageDTOBuilder {
      private Long id;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal surfaceArea;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private BigDecimal wage;
      private BigDecimal primerWage;
      private BigDecimal intermediatePaintWage;
      private BigDecimal topcoatWage;
      private Integer primerWageQuotaType;
      private Integer intermediatePaintWageQuotaType;
      private Integer topcoatWageQuotaType;
      private Integer wageQuotaType;

      ProductWageDTOBuilder() {
      }

      @JsonProperty("id")
      public ProductWageDTO.ProductWageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductWageDTO.ProductWageDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProductWageDTO.ProductWageDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ProductWageDTO.ProductWageDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ProductWageDTO.ProductWageDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public ProductWageDTO.ProductWageDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ProductWageDTO.ProductWageDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public ProductWageDTO.ProductWageDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("monomer")
      public ProductWageDTO.ProductWageDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public ProductWageDTO.ProductWageDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("wage")
      public ProductWageDTO.ProductWageDTOBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("primerWage")
      public ProductWageDTO.ProductWageDTOBuilder primerWage(final BigDecimal primerWage) {
         this.primerWage = primerWage;
         return this;
      }

      @JsonProperty("intermediatePaintWage")
      public ProductWageDTO.ProductWageDTOBuilder intermediatePaintWage(final BigDecimal intermediatePaintWage) {
         this.intermediatePaintWage = intermediatePaintWage;
         return this;
      }

      @JsonProperty("topcoatWage")
      public ProductWageDTO.ProductWageDTOBuilder topcoatWage(final BigDecimal topcoatWage) {
         this.topcoatWage = topcoatWage;
         return this;
      }

      @JsonProperty("primerWageQuotaType")
      public ProductWageDTO.ProductWageDTOBuilder primerWageQuotaType(final Integer primerWageQuotaType) {
         this.primerWageQuotaType = primerWageQuotaType;
         return this;
      }

      @JsonProperty("intermediatePaintWageQuotaType")
      public ProductWageDTO.ProductWageDTOBuilder intermediatePaintWageQuotaType(final Integer intermediatePaintWageQuotaType) {
         this.intermediatePaintWageQuotaType = intermediatePaintWageQuotaType;
         return this;
      }

      @JsonProperty("topcoatWageQuotaType")
      public ProductWageDTO.ProductWageDTOBuilder topcoatWageQuotaType(final Integer topcoatWageQuotaType) {
         this.topcoatWageQuotaType = topcoatWageQuotaType;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public ProductWageDTO.ProductWageDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public ProductWageDTO build() {
         return new ProductWageDTO(
            this.id,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.surfaceArea,
            this.monomer,
            this.area,
            this.wage,
            this.primerWage,
            this.intermediatePaintWage,
            this.topcoatWage,
            this.primerWageQuotaType,
            this.intermediatePaintWageQuotaType,
            this.topcoatWageQuotaType,
            this.wageQuotaType
         );
      }

      @Override
      public String toString() {
         return "ProductWageDTO.ProductWageDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", wage="
            + this.wage
            + ", primerWage="
            + this.primerWage
            + ", intermediatePaintWage="
            + this.intermediatePaintWage
            + ", topcoatWage="
            + this.topcoatWage
            + ", primerWageQuotaType="
            + this.primerWageQuotaType
            + ", intermediatePaintWageQuotaType="
            + this.intermediatePaintWageQuotaType
            + ", topcoatWageQuotaType="
            + this.topcoatWageQuotaType
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
