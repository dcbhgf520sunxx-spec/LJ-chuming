package com.hzchum.scim.project.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("外购合同可收货详情")
public class ProjectPurchaseProductDetailsDTO {
   @ApiModelProperty(name = "detailId", value = "采购详情id", notes = "采购详情id")
   @JsonInclude(Include.NON_NULL)
   private Long detailId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonInclude(Include.NON_NULL)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型 2构件 4围护 8配套件")
   @JsonInclude(Include.NON_NULL)
   private Integer productType;
   @ApiModelProperty(name = "classifyId", notes = "科目id")
   @JsonInclude(Include.NON_NULL)
   private Long classifyId;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "", notes = "产品总量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty("核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "mete", value = "核算总量")
   private BigDecimal mete;
   @ApiModelProperty(name = "canReceivedQuantity", value = "", notes = "可收货数量")
   private BigDecimal canReceivedQuantity;
   @ApiModelProperty(name = "canReceivedMete", value = "可收货核算总量")
   private BigDecimal canReceivedMete;
   @ApiModelProperty(name = "receivedQuantity", value = "收货数量", notes = "收货数量")
   private BigDecimal receivedQuantity;
   @ApiModelProperty(name = "receivedMete", value = "收货核算量 ", notes = "收货核算量")
   private BigDecimal receivedMete;
   @ApiModelProperty(name = "measurePrecision", value = "计量单位精度 ", notes = "收货核算量")
   private Integer measurePrecision;
   @ApiModelProperty(name = "accountingPrecision", value = "核算单位精度 ", notes = "核算单位精度")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "actualReceivedMete", value = "原材料实际收货量 ", notes = "原材料实际收货量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal actualReceivedMete;
   @ApiModelProperty(name = "width", value = "宽度", notes = "宽度")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   private BigDecimal thickness;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   private String color;
   @ApiModelProperty(name = "basicClass", value = "材料类型", notes = "材料类型")
   private Integer basicClass;
   @ApiModelProperty(name = "areaId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty("单体")
   private NameInfo monomer;
   @ApiModelProperty("区域")
   private NameInfo area;
   @ApiModelProperty("制成品计价方式")
   private Integer wageQuotaType;

   public static ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder builder() {
      return new ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder();
   }

   public ProjectPurchaseProductDetailsDTO() {
   }

   public ProjectPurchaseProductDetailsDTO(
      final Long detailId,
      final Long productId,
      final Integer productType,
      final Long classifyId,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal quantity,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal mete,
      final BigDecimal canReceivedQuantity,
      final BigDecimal canReceivedMete,
      final BigDecimal receivedQuantity,
      final BigDecimal receivedMete,
      final Integer measurePrecision,
      final Integer accountingPrecision,
      final BigDecimal actualReceivedMete,
      final BigDecimal width,
      final BigDecimal thickness,
      final String color,
      final Integer basicClass,
      final Long monomerId,
      final Long areaId,
      final NameInfo monomer,
      final NameInfo area,
      final Integer wageQuotaType
   ) {
      this.detailId = detailId;
      this.productId = productId;
      this.productType = productType;
      this.classifyId = classifyId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.canReceivedQuantity = canReceivedQuantity;
      this.canReceivedMete = canReceivedMete;
      this.receivedQuantity = receivedQuantity;
      this.receivedMete = receivedMete;
      this.measurePrecision = measurePrecision;
      this.accountingPrecision = accountingPrecision;
      this.actualReceivedMete = actualReceivedMete;
      this.width = width;
      this.thickness = thickness;
      this.color = color;
      this.basicClass = basicClass;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.monomer = monomer;
      this.area = area;
      this.wageQuotaType = wageQuotaType;
   }

   public Long getDetailId() {
      return this.detailId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getClassifyId() {
      return this.classifyId;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getCanReceivedQuantity() {
      return this.canReceivedQuantity;
   }

   public BigDecimal getCanReceivedMete() {
      return this.canReceivedMete;
   }

   public BigDecimal getReceivedQuantity() {
      return this.receivedQuantity;
   }

   public BigDecimal getReceivedMete() {
      return this.receivedMete;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public BigDecimal getActualReceivedMete() {
      return this.actualReceivedMete;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getColor() {
      return this.color;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public void setDetailId(final Long detailId) {
      this.detailId = detailId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
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

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setCanReceivedQuantity(final BigDecimal canReceivedQuantity) {
      this.canReceivedQuantity = canReceivedQuantity;
   }

   public void setCanReceivedMete(final BigDecimal canReceivedMete) {
      this.canReceivedMete = canReceivedMete;
   }

   public void setReceivedQuantity(final BigDecimal receivedQuantity) {
      this.receivedQuantity = receivedQuantity;
   }

   public void setReceivedMete(final BigDecimal receivedMete) {
      this.receivedMete = receivedMete;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setActualReceivedMete(final BigDecimal actualReceivedMete) {
      this.actualReceivedMete = actualReceivedMete;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPurchaseProductDetailsDTO)) {
         return false;
      }

      ProjectPurchaseProductDetailsDTO other = (ProjectPurchaseProductDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$detailId = this.getDetailId();
      Object other$detailId = other.getDetailId();
      if (this$detailId == null ? other$detailId == null : this$detailId.equals(other$detailId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$measurePrecision = this.getMeasurePrecision();
                  Object other$measurePrecision = other.getMeasurePrecision();
                  if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                     Object this$accountingPrecision = this.getAccountingPrecision();
                     Object other$accountingPrecision = other.getAccountingPrecision();
                     if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                        Object this$basicClass = this.getBasicClass();
                        Object other$basicClass = other.getBasicClass();
                        if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$wageQuotaType = this.getWageQuotaType();
                                 Object other$wageQuotaType = other.getWageQuotaType();
                                 if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                                   Object this$quantity = this.getQuantity();
                                                   Object other$quantity = other.getQuantity();
                                                   if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                      Object this$measureUnit = this.getMeasureUnit();
                                                      Object other$measureUnit = other.getMeasureUnit();
                                                      if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                         Object this$accountingUnit = this.getAccountingUnit();
                                                         Object other$accountingUnit = other.getAccountingUnit();
                                                         if (this$accountingUnit == null
                                                            ? other$accountingUnit == null
                                                            : this$accountingUnit.equals(other$accountingUnit)) {
                                                            Object this$mete = this.getMete();
                                                            Object other$mete = other.getMete();
                                                            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                               Object this$canReceivedQuantity = this.getCanReceivedQuantity();
                                                               Object other$canReceivedQuantity = other.getCanReceivedQuantity();
                                                               if (this$canReceivedQuantity == null
                                                                  ? other$canReceivedQuantity == null
                                                                  : this$canReceivedQuantity.equals(other$canReceivedQuantity)) {
                                                                  Object this$canReceivedMete = this.getCanReceivedMete();
                                                                  Object other$canReceivedMete = other.getCanReceivedMete();
                                                                  if (this$canReceivedMete == null
                                                                     ? other$canReceivedMete == null
                                                                     : this$canReceivedMete.equals(other$canReceivedMete)) {
                                                                     Object this$receivedQuantity = this.getReceivedQuantity();
                                                                     Object other$receivedQuantity = other.getReceivedQuantity();
                                                                     if (this$receivedQuantity == null
                                                                        ? other$receivedQuantity == null
                                                                        : this$receivedQuantity.equals(other$receivedQuantity)) {
                                                                        Object this$receivedMete = this.getReceivedMete();
                                                                        Object other$receivedMete = other.getReceivedMete();
                                                                        if (this$receivedMete == null
                                                                           ? other$receivedMete == null
                                                                           : this$receivedMete.equals(other$receivedMete)) {
                                                                           Object this$actualReceivedMete = this.getActualReceivedMete();
                                                                           Object other$actualReceivedMete = other.getActualReceivedMete();
                                                                           if (this$actualReceivedMete == null
                                                                              ? other$actualReceivedMete == null
                                                                              : this$actualReceivedMete.equals(other$actualReceivedMete)) {
                                                                              Object this$width = this.getWidth();
                                                                              Object other$width = other.getWidth();
                                                                              if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                                 Object this$thickness = this.getThickness();
                                                                                 Object other$thickness = other.getThickness();
                                                                                 if (this$thickness == null
                                                                                    ? other$thickness == null
                                                                                    : this$thickness.equals(other$thickness)) {
                                                                                    Object this$color = this.getColor();
                                                                                    Object other$color = other.getColor();
                                                                                    if (this$color == null
                                                                                       ? other$color == null
                                                                                       : this$color.equals(other$color)) {
                                                                                       Object this$monomer = this.getMonomer();
                                                                                       Object other$monomer = other.getMonomer();
                                                                                       if (this$monomer == null
                                                                                          ? other$monomer == null
                                                                                          : this$monomer.equals(other$monomer)) {
                                                                                          Object this$area = this.getArea();
                                                                                          Object other$area = other.getArea();
                                                                                          return this$area == null
                                                                                             ? other$area == null
                                                                                             : this$area.equals(other$area);
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
      return other instanceof ProjectPurchaseProductDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $detailId = this.getDetailId();
      result = result * 59 + ($detailId == null ? 43 : $detailId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $canReceivedQuantity = this.getCanReceivedQuantity();
      result = result * 59 + ($canReceivedQuantity == null ? 43 : $canReceivedQuantity.hashCode());
      Object $canReceivedMete = this.getCanReceivedMete();
      result = result * 59 + ($canReceivedMete == null ? 43 : $canReceivedMete.hashCode());
      Object $receivedQuantity = this.getReceivedQuantity();
      result = result * 59 + ($receivedQuantity == null ? 43 : $receivedQuantity.hashCode());
      Object $receivedMete = this.getReceivedMete();
      result = result * 59 + ($receivedMete == null ? 43 : $receivedMete.hashCode());
      Object $actualReceivedMete = this.getActualReceivedMete();
      result = result * 59 + ($actualReceivedMete == null ? 43 : $actualReceivedMete.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      return result * 59 + ($area == null ? 43 : $area.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPurchaseProductDetailsDTO(detailId="
         + this.getDetailId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", classifyId="
         + this.getClassifyId()
         + ", name="
         + this.getName()
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
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", canReceivedQuantity="
         + this.getCanReceivedQuantity()
         + ", canReceivedMete="
         + this.getCanReceivedMete()
         + ", receivedQuantity="
         + this.getReceivedQuantity()
         + ", receivedMete="
         + this.getReceivedMete()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", actualReceivedMete="
         + this.getActualReceivedMete()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", color="
         + this.getColor()
         + ", basicClass="
         + this.getBasicClass()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   public static class ProjectPurchaseProductDetailsDTOBuilder {
      private Long detailId;
      private Long productId;
      private Integer productType;
      private Long classifyId;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal quantity;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal mete;
      private BigDecimal canReceivedQuantity;
      private BigDecimal canReceivedMete;
      private BigDecimal receivedQuantity;
      private BigDecimal receivedMete;
      private Integer measurePrecision;
      private Integer accountingPrecision;
      private BigDecimal actualReceivedMete;
      private BigDecimal width;
      private BigDecimal thickness;
      private String color;
      private Integer basicClass;
      private Long monomerId;
      private Long areaId;
      private NameInfo monomer;
      private NameInfo area;
      private Integer wageQuotaType;

      ProjectPurchaseProductDetailsDTOBuilder() {
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder detailId(final Long detailId) {
         this.detailId = detailId;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder canReceivedQuantity(final BigDecimal canReceivedQuantity) {
         this.canReceivedQuantity = canReceivedQuantity;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder canReceivedMete(final BigDecimal canReceivedMete) {
         this.canReceivedMete = canReceivedMete;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder receivedQuantity(final BigDecimal receivedQuantity) {
         this.receivedQuantity = receivedQuantity;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder receivedMete(final BigDecimal receivedMete) {
         this.receivedMete = receivedMete;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder actualReceivedMete(final BigDecimal actualReceivedMete) {
         this.actualReceivedMete = actualReceivedMete;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public ProjectPurchaseProductDetailsDTO build() {
         return new ProjectPurchaseProductDetailsDTO(
            this.detailId,
            this.productId,
            this.productType,
            this.classifyId,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.measureUnit,
            this.accountingUnit,
            this.mete,
            this.canReceivedQuantity,
            this.canReceivedMete,
            this.receivedQuantity,
            this.receivedMete,
            this.measurePrecision,
            this.accountingPrecision,
            this.actualReceivedMete,
            this.width,
            this.thickness,
            this.color,
            this.basicClass,
            this.monomerId,
            this.areaId,
            this.monomer,
            this.area,
            this.wageQuotaType
         );
      }

      @Override
      public String toString() {
         return "ProjectPurchaseProductDetailsDTO.ProjectPurchaseProductDetailsDTOBuilder(detailId="
            + this.detailId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", classifyId="
            + this.classifyId
            + ", name="
            + this.name
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
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", canReceivedQuantity="
            + this.canReceivedQuantity
            + ", canReceivedMete="
            + this.canReceivedMete
            + ", receivedQuantity="
            + this.receivedQuantity
            + ", receivedMete="
            + this.receivedMete
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", actualReceivedMete="
            + this.actualReceivedMete
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", color="
            + this.color
            + ", basicClass="
            + this.basicClass
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
