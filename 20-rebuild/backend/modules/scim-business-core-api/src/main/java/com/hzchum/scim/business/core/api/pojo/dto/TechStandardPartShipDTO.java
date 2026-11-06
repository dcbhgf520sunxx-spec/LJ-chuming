package com.hzchum.scim.business.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TechStandardPartShipDTO对象", description = "配套件发运跟踪详情 ")
public class TechStandardPartShipDTO {
   @ApiModelProperty(notes = "发运产品关联id")
   private Long linkId;
   @ApiModelProperty(notes = "项目")
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "cargoSerialNumber", value = "车次编号", notes = "车次编号")
   private String cargoSerialNumber;
   @ApiModelProperty(name = "actualUserName", value = "过磅人名称", notes = "过磅人名称")
   private String actualUserName;
   @ApiModelProperty(name = "auditUserName", value = "发运审核人名称", notes = "发运审核人名称")
   private String auditUserName;
   @ApiModelProperty(name = "userName", value = "装车人名称", notes = "装车人名称")
   private String userName;
   @ApiModelProperty(name = "supplierName", value = "物流公司名称", notes = "物流公司名称")
   private String supplierName;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("计量单位")
   private String measureUnit;
   @ApiModelProperty("数量")
   private BigDecimal quantity;
   @ApiModelProperty("核算单位")
   private String accountingUnit;
   @ApiModelProperty("核算数量")
   private BigDecimal mete;
   @ApiModelProperty("当前装车数量")
   private BigDecimal shipQuantity;
   @ApiModelProperty("单价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "createTime", value = "发运时间", notes = "发运时间")
   private LocalDateTime createTime;

   public static TechStandardPartShipDTO.TechStandardPartShipDTOBuilder builder() {
      return new TechStandardPartShipDTO.TechStandardPartShipDTOBuilder();
   }

   public TechStandardPartShipDTO() {
   }

   public TechStandardPartShipDTO(
      final Long linkId,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final String licensePlate,
      final String cargoSerialNumber,
      final String actualUserName,
      final String auditUserName,
      final String userName,
      final String supplierName,
      final String name,
      final String specification,
      final String measureUnit,
      final BigDecimal quantity,
      final String accountingUnit,
      final BigDecimal mete,
      final BigDecimal shipQuantity,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final LocalDateTime createTime
   ) {
      this.linkId = linkId;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.licensePlate = licensePlate;
      this.cargoSerialNumber = cargoSerialNumber;
      this.actualUserName = actualUserName;
      this.auditUserName = auditUserName;
      this.userName = userName;
      this.supplierName = supplierName;
      this.name = name;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.shipQuantity = shipQuantity;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.createTime = createTime;
   }

   public Long getLinkId() {
      return this.linkId;
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

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getCargoSerialNumber() {
      return this.cargoSerialNumber;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getShipQuantity() {
      return this.shipQuantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public TechStandardPartShipDTO setLinkId(final Long linkId) {
      this.linkId = linkId;
      return this;
   }

   public TechStandardPartShipDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public TechStandardPartShipDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public TechStandardPartShipDTO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   public TechStandardPartShipDTO setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public TechStandardPartShipDTO setCargoSerialNumber(final String cargoSerialNumber) {
      this.cargoSerialNumber = cargoSerialNumber;
      return this;
   }

   public TechStandardPartShipDTO setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
      return this;
   }

   public TechStandardPartShipDTO setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public TechStandardPartShipDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public TechStandardPartShipDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public TechStandardPartShipDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public TechStandardPartShipDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechStandardPartShipDTO setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public TechStandardPartShipDTO setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechStandardPartShipDTO setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   public TechStandardPartShipDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public TechStandardPartShipDTO setShipQuantity(final BigDecimal shipQuantity) {
      this.shipQuantity = shipQuantity;
      return this;
   }

   public TechStandardPartShipDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public TechStandardPartShipDTO setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public TechStandardPartShipDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartShipDTO)) {
         return false;
      }

      TechStandardPartShipDTO other = (TechStandardPartShipDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$shipQuantity = this.getShipQuantity();
            Object other$shipQuantity = other.getShipQuantity();
            if (this$shipQuantity == null ? other$shipQuantity == null : this$shipQuantity.equals(other$shipQuantity)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$area = this.getArea();
                     Object other$area = other.getArea();
                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                        Object this$licensePlate = this.getLicensePlate();
                        Object other$licensePlate = other.getLicensePlate();
                        if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                           Object this$cargoSerialNumber = this.getCargoSerialNumber();
                           Object other$cargoSerialNumber = other.getCargoSerialNumber();
                           if (this$cargoSerialNumber == null ? other$cargoSerialNumber == null : this$cargoSerialNumber.equals(other$cargoSerialNumber)) {
                              Object this$actualUserName = this.getActualUserName();
                              Object other$actualUserName = other.getActualUserName();
                              if (this$actualUserName == null ? other$actualUserName == null : this$actualUserName.equals(other$actualUserName)) {
                                 Object this$auditUserName = this.getAuditUserName();
                                 Object other$auditUserName = other.getAuditUserName();
                                 if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                    Object this$userName = this.getUserName();
                                    Object other$userName = other.getUserName();
                                    if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                       Object this$supplierName = this.getSupplierName();
                                       Object other$supplierName = other.getSupplierName();
                                       if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
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
                                                         Object this$unitPrice = this.getUnitPrice();
                                                         Object other$unitPrice = other.getUnitPrice();
                                                         if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                            Object this$totalPrice = this.getTotalPrice();
                                                            Object other$totalPrice = other.getTotalPrice();
                                                            if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                                                               Object this$createTime = this.getCreateTime();
                                                               Object other$createTime = other.getCreateTime();
                                                               return this$createTime == null
                                                                  ? other$createTime == null
                                                                  : this$createTime.equals(other$createTime);
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
      return other instanceof TechStandardPartShipDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $shipQuantity = this.getShipQuantity();
      result = result * 59 + ($shipQuantity == null ? 43 : $shipQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $cargoSerialNumber = this.getCargoSerialNumber();
      result = result * 59 + ($cargoSerialNumber == null ? 43 : $cargoSerialNumber.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "TechStandardPartShipDTO(linkId="
         + this.getLinkId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", cargoSerialNumber="
         + this.getCargoSerialNumber()
         + ", actualUserName="
         + this.getActualUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", userName="
         + this.getUserName()
         + ", supplierName="
         + this.getSupplierName()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantity="
         + this.getQuantity()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", shipQuantity="
         + this.getShipQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class TechStandardPartShipDTOBuilder {
      private Long linkId;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private String licensePlate;
      private String cargoSerialNumber;
      private String actualUserName;
      private String auditUserName;
      private String userName;
      private String supplierName;
      private String name;
      private String specification;
      private String measureUnit;
      private BigDecimal quantity;
      private String accountingUnit;
      private BigDecimal mete;
      private BigDecimal shipQuantity;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private LocalDateTime createTime;

      TechStandardPartShipDTOBuilder() {
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder cargoSerialNumber(final String cargoSerialNumber) {
         this.cargoSerialNumber = cargoSerialNumber;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder actualUserName(final String actualUserName) {
         this.actualUserName = actualUserName;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder shipQuantity(final BigDecimal shipQuantity) {
         this.shipQuantity = shipQuantity;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public TechStandardPartShipDTO.TechStandardPartShipDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechStandardPartShipDTO build() {
         return new TechStandardPartShipDTO(
            this.linkId,
            this.project,
            this.monomer,
            this.area,
            this.licensePlate,
            this.cargoSerialNumber,
            this.actualUserName,
            this.auditUserName,
            this.userName,
            this.supplierName,
            this.name,
            this.specification,
            this.measureUnit,
            this.quantity,
            this.accountingUnit,
            this.mete,
            this.shipQuantity,
            this.unitPrice,
            this.totalPrice,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "TechStandardPartShipDTO.TechStandardPartShipDTOBuilder(linkId="
            + this.linkId
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", licensePlate="
            + this.licensePlate
            + ", cargoSerialNumber="
            + this.cargoSerialNumber
            + ", actualUserName="
            + this.actualUserName
            + ", auditUserName="
            + this.auditUserName
            + ", userName="
            + this.userName
            + ", supplierName="
            + this.supplierName
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", quantity="
            + this.quantity
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", shipQuantity="
            + this.shipQuantity
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
