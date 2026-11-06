package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShipmentInfoDTO {
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域/围护计划")
   private NameInfo area;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(notes = "发运id")
   private Long cargoListId;
   @ApiModelProperty(notes = "发运明细id")
   private Long cargoListProductLinkId;
   @ApiModelProperty(notes = "是否存在制成品退货")
   private Boolean boolExistReturn;
   @ApiModelProperty(notes = "名称")
   private String name;
   @ApiModelProperty(notes = "编号")
   private String serialNumber;
   @ApiModelProperty(notes = "规格")
   private String specification;
   @ApiModelProperty(notes = "材质")
   private String material;
   @ApiModelProperty(notes = "长度")
   private BigDecimal length;
   @ApiModelProperty(notes = "计量单位")
   private String measure;
   @ApiModelProperty(notes = "核算单位")
   private String nuclear;
   @ApiModelProperty(notes = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(notes = "总量")
   private BigDecimal totalMete;
   @ApiModelProperty(notes = "计价方式")
   private Integer pricingMannerEnum;
   @ApiModelProperty(notes = "计价单位类型")
   private Integer pricingUnitTypeEnum;
   @ApiModelProperty(name = "pricingWeightTypeEnum", value = "(构件)计价重量类型 1净重 2毛重 4图纸重'", notes = "(构件)计价重量类型 1净重 2毛重 4图纸重'")
   private Integer pricingWeightTypeEnum;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否是直发檩条 true 是 false 否")
   private Boolean boolPurLineSendDirectly;
   @ApiModelProperty("备注")
   private String remark;

   public static ShipmentInfoDTO.ShipmentInfoDTOBuilder builder() {
      return new ShipmentInfoDTO.ShipmentInfoDTOBuilder();
   }

   public ShipmentInfoDTO(
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final Integer productType,
      final Long productId,
      final Long cargoListId,
      final Long cargoListProductLinkId,
      final Boolean boolExistReturn,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final String measure,
      final String nuclear,
      final BigDecimal quantity,
      final BigDecimal totalMete,
      final Integer pricingMannerEnum,
      final Integer pricingUnitTypeEnum,
      final Integer pricingWeightTypeEnum,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final String licensePlate,
      final LocalDateTime auditTime,
      final Boolean boolAllPartSendDirectly,
      final Boolean boolPurLineSendDirectly,
      final String remark
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.productType = productType;
      this.productId = productId;
      this.cargoListId = cargoListId;
      this.cargoListProductLinkId = cargoListProductLinkId;
      this.boolExistReturn = boolExistReturn;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.measure = measure;
      this.nuclear = nuclear;
      this.quantity = quantity;
      this.totalMete = totalMete;
      this.pricingMannerEnum = pricingMannerEnum;
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.licensePlate = licensePlate;
      this.auditTime = auditTime;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.boolPurLineSendDirectly = boolPurLineSendDirectly;
      this.remark = remark;
   }

   public ShipmentInfoDTO() {
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public Long getCargoListProductLinkId() {
      return this.cargoListProductLinkId;
   }

   public Boolean getBoolExistReturn() {
      return this.boolExistReturn;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMeasure() {
      return this.measure;
   }

   public String getNuclear() {
      return this.nuclear;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public Integer getPricingMannerEnum() {
      return this.pricingMannerEnum;
   }

   public Integer getPricingUnitTypeEnum() {
      return this.pricingUnitTypeEnum;
   }

   public Integer getPricingWeightTypeEnum() {
      return this.pricingWeightTypeEnum;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolPurLineSendDirectly() {
      return this.boolPurLineSendDirectly;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
   }

   public void setCargoListProductLinkId(final Long cargoListProductLinkId) {
      this.cargoListProductLinkId = cargoListProductLinkId;
   }

   public void setBoolExistReturn(final Boolean boolExistReturn) {
      this.boolExistReturn = boolExistReturn;
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

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMeasure(final String measure) {
      this.measure = measure;
   }

   public void setNuclear(final String nuclear) {
      this.nuclear = nuclear;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
   }

   public void setPricingMannerEnum(final Integer pricingMannerEnum) {
      this.pricingMannerEnum = pricingMannerEnum;
   }

   public void setPricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
   }

   public void setPricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setBoolPurLineSendDirectly(final Boolean boolPurLineSendDirectly) {
      this.boolPurLineSendDirectly = boolPurLineSendDirectly;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ShipmentInfoDTO)) {
         return false;
      }

      ShipmentInfoDTO other = (ShipmentInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$cargoListId = this.getCargoListId();
            Object other$cargoListId = other.getCargoListId();
            if (this$cargoListId == null ? other$cargoListId == null : this$cargoListId.equals(other$cargoListId)) {
               Object this$cargoListProductLinkId = this.getCargoListProductLinkId();
               Object other$cargoListProductLinkId = other.getCargoListProductLinkId();
               if (this$cargoListProductLinkId == null
                  ? other$cargoListProductLinkId == null
                  : this$cargoListProductLinkId.equals(other$cargoListProductLinkId)) {
                  Object this$boolExistReturn = this.getBoolExistReturn();
                  Object other$boolExistReturn = other.getBoolExistReturn();
                  if (this$boolExistReturn == null ? other$boolExistReturn == null : this$boolExistReturn.equals(other$boolExistReturn)) {
                     Object this$pricingMannerEnum = this.getPricingMannerEnum();
                     Object other$pricingMannerEnum = other.getPricingMannerEnum();
                     if (this$pricingMannerEnum == null ? other$pricingMannerEnum == null : this$pricingMannerEnum.equals(other$pricingMannerEnum)) {
                        Object this$pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
                        Object other$pricingUnitTypeEnum = other.getPricingUnitTypeEnum();
                        if (this$pricingUnitTypeEnum == null ? other$pricingUnitTypeEnum == null : this$pricingUnitTypeEnum.equals(other$pricingUnitTypeEnum)) {
                           Object this$pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
                           Object other$pricingWeightTypeEnum = other.getPricingWeightTypeEnum();
                           if (this$pricingWeightTypeEnum == null
                              ? other$pricingWeightTypeEnum == null
                              : this$pricingWeightTypeEnum.equals(other$pricingWeightTypeEnum)) {
                              Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                              Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                              if (this$boolAllPartSendDirectly == null
                                 ? other$boolAllPartSendDirectly == null
                                 : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                                 Object this$boolPurLineSendDirectly = this.getBoolPurLineSendDirectly();
                                 Object other$boolPurLineSendDirectly = other.getBoolPurLineSendDirectly();
                                 if (this$boolPurLineSendDirectly == null
                                    ? other$boolPurLineSendDirectly == null
                                    : this$boolPurLineSendDirectly.equals(other$boolPurLineSendDirectly)) {
                                    Object this$project = this.getProject();
                                    Object other$project = other.getProject();
                                    if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                       Object this$monomer = this.getMonomer();
                                       Object other$monomer = other.getMonomer();
                                       if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                          Object this$area = this.getArea();
                                          Object other$area = other.getArea();
                                          if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                             Object this$name = this.getName();
                                             Object other$name = other.getName();
                                             if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$length = this.getLength();
                                                         Object other$length = other.getLength();
                                                         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                            Object this$measure = this.getMeasure();
                                                            Object other$measure = other.getMeasure();
                                                            if (this$measure == null ? other$measure == null : this$measure.equals(other$measure)) {
                                                               Object this$nuclear = this.getNuclear();
                                                               Object other$nuclear = other.getNuclear();
                                                               if (this$nuclear == null ? other$nuclear == null : this$nuclear.equals(other$nuclear)) {
                                                                  Object this$quantity = this.getQuantity();
                                                                  Object other$quantity = other.getQuantity();
                                                                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                     Object this$totalMete = this.getTotalMete();
                                                                     Object other$totalMete = other.getTotalMete();
                                                                     if (this$totalMete == null
                                                                        ? other$totalMete == null
                                                                        : this$totalMete.equals(other$totalMete)) {
                                                                        Object this$unitPrice = this.getUnitPrice();
                                                                        Object other$unitPrice = other.getUnitPrice();
                                                                        if (this$unitPrice == null
                                                                           ? other$unitPrice == null
                                                                           : this$unitPrice.equals(other$unitPrice)) {
                                                                           Object this$totalPrice = this.getTotalPrice();
                                                                           Object other$totalPrice = other.getTotalPrice();
                                                                           if (this$totalPrice == null
                                                                              ? other$totalPrice == null
                                                                              : this$totalPrice.equals(other$totalPrice)) {
                                                                              Object this$licensePlate = this.getLicensePlate();
                                                                              Object other$licensePlate = other.getLicensePlate();
                                                                              if (this$licensePlate == null
                                                                                 ? other$licensePlate == null
                                                                                 : this$licensePlate.equals(other$licensePlate)) {
                                                                                 Object this$auditTime = this.getAuditTime();
                                                                                 Object other$auditTime = other.getAuditTime();
                                                                                 if (this$auditTime == null
                                                                                    ? other$auditTime == null
                                                                                    : this$auditTime.equals(other$auditTime)) {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    return this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark);
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
      return other instanceof ShipmentInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $cargoListId = this.getCargoListId();
      result = result * 59 + ($cargoListId == null ? 43 : $cargoListId.hashCode());
      Object $cargoListProductLinkId = this.getCargoListProductLinkId();
      result = result * 59 + ($cargoListProductLinkId == null ? 43 : $cargoListProductLinkId.hashCode());
      Object $boolExistReturn = this.getBoolExistReturn();
      result = result * 59 + ($boolExistReturn == null ? 43 : $boolExistReturn.hashCode());
      Object $pricingMannerEnum = this.getPricingMannerEnum();
      result = result * 59 + ($pricingMannerEnum == null ? 43 : $pricingMannerEnum.hashCode());
      Object $pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
      result = result * 59 + ($pricingUnitTypeEnum == null ? 43 : $pricingUnitTypeEnum.hashCode());
      Object $pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
      result = result * 59 + ($pricingWeightTypeEnum == null ? 43 : $pricingWeightTypeEnum.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolPurLineSendDirectly = this.getBoolPurLineSendDirectly();
      result = result * 59 + ($boolPurLineSendDirectly == null ? 43 : $boolPurLineSendDirectly.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $measure = this.getMeasure();
      result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
      Object $nuclear = this.getNuclear();
      result = result * 59 + ($nuclear == null ? 43 : $nuclear.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ShipmentInfoDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", cargoListId="
         + this.getCargoListId()
         + ", cargoListProductLinkId="
         + this.getCargoListProductLinkId()
         + ", boolExistReturn="
         + this.getBoolExistReturn()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", measure="
         + this.getMeasure()
         + ", nuclear="
         + this.getNuclear()
         + ", quantity="
         + this.getQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", pricingMannerEnum="
         + this.getPricingMannerEnum()
         + ", pricingUnitTypeEnum="
         + this.getPricingUnitTypeEnum()
         + ", pricingWeightTypeEnum="
         + this.getPricingWeightTypeEnum()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", auditTime="
         + this.getAuditTime()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolPurLineSendDirectly="
         + this.getBoolPurLineSendDirectly()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ShipmentInfoDTOBuilder {
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private Integer productType;
      private Long productId;
      private Long cargoListId;
      private Long cargoListProductLinkId;
      private Boolean boolExistReturn;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private String measure;
      private String nuclear;
      private BigDecimal quantity;
      private BigDecimal totalMete;
      private Integer pricingMannerEnum;
      private Integer pricingUnitTypeEnum;
      private Integer pricingWeightTypeEnum;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private String licensePlate;
      private LocalDateTime auditTime;
      private Boolean boolAllPartSendDirectly;
      private Boolean boolPurLineSendDirectly;
      private String remark;

      ShipmentInfoDTOBuilder() {
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder cargoListProductLinkId(final Long cargoListProductLinkId) {
         this.cargoListProductLinkId = cargoListProductLinkId;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder boolExistReturn(final Boolean boolExistReturn) {
         this.boolExistReturn = boolExistReturn;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder measure(final String measure) {
         this.measure = measure;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder nuclear(final String nuclear) {
         this.nuclear = nuclear;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder pricingMannerEnum(final Integer pricingMannerEnum) {
         this.pricingMannerEnum = pricingMannerEnum;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder pricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
         this.pricingUnitTypeEnum = pricingUnitTypeEnum;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder pricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
         this.pricingWeightTypeEnum = pricingWeightTypeEnum;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder boolPurLineSendDirectly(final Boolean boolPurLineSendDirectly) {
         this.boolPurLineSendDirectly = boolPurLineSendDirectly;
         return this;
      }

      public ShipmentInfoDTO.ShipmentInfoDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ShipmentInfoDTO build() {
         return new ShipmentInfoDTO(
            this.project,
            this.monomer,
            this.area,
            this.productType,
            this.productId,
            this.cargoListId,
            this.cargoListProductLinkId,
            this.boolExistReturn,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.measure,
            this.nuclear,
            this.quantity,
            this.totalMete,
            this.pricingMannerEnum,
            this.pricingUnitTypeEnum,
            this.pricingWeightTypeEnum,
            this.unitPrice,
            this.totalPrice,
            this.licensePlate,
            this.auditTime,
            this.boolAllPartSendDirectly,
            this.boolPurLineSendDirectly,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ShipmentInfoDTO.ShipmentInfoDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", cargoListId="
            + this.cargoListId
            + ", cargoListProductLinkId="
            + this.cargoListProductLinkId
            + ", boolExistReturn="
            + this.boolExistReturn
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", measure="
            + this.measure
            + ", nuclear="
            + this.nuclear
            + ", quantity="
            + this.quantity
            + ", totalMete="
            + this.totalMete
            + ", pricingMannerEnum="
            + this.pricingMannerEnum
            + ", pricingUnitTypeEnum="
            + this.pricingUnitTypeEnum
            + ", pricingWeightTypeEnum="
            + this.pricingWeightTypeEnum
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", licensePlate="
            + this.licensePlate
            + ", auditTime="
            + this.auditTime
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", boolPurLineSendDirectly="
            + this.boolPurLineSendDirectly
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
