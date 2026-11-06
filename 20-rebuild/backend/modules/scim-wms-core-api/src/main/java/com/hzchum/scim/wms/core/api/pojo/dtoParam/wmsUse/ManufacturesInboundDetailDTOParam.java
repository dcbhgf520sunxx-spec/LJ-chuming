package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class ManufacturesInboundDetailDTOParam {
   private Long id;
   private Long monomerId;
   private Long areaId;
   private String name;
   private String serialNumber;
   private String specification;
   private String measureUnit;
   private Integer quantity;
   private String accountingUnit;
   private BigDecimal mete;
   private Long factoryId;
   private String remark;

   public static ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder builder() {
      return new ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
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

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ManufacturesInboundDetailDTOParam)) {
         return false;
      }

      ManufacturesInboundDetailDTOParam other = (ManufacturesInboundDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$measureUnit = this.getMeasureUnit();
                              Object other$measureUnit = other.getMeasureUnit();
                              if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                 Object this$accountingUnit = this.getAccountingUnit();
                                 Object other$accountingUnit = other.getAccountingUnit();
                                 if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                    Object this$mete = this.getMete();
                                    Object other$mete = other.getMete();
                                    if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ManufacturesInboundDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ManufacturesInboundDetailDTOParam(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
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
         + ", factoryId="
         + this.getFactoryId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public ManufacturesInboundDetailDTOParam(
      final Long id,
      final Long monomerId,
      final Long areaId,
      final String name,
      final String serialNumber,
      final String specification,
      final String measureUnit,
      final Integer quantity,
      final String accountingUnit,
      final BigDecimal mete,
      final Long factoryId,
      final String remark
   ) {
      this.id = id;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.factoryId = factoryId;
      this.remark = remark;
   }

   public ManufacturesInboundDetailDTOParam() {
   }

   public static class ManufacturesInboundDetailDTOParamBuilder {
      private Long id;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String serialNumber;
      private String specification;
      private String measureUnit;
      private Integer quantity;
      private String accountingUnit;
      private BigDecimal mete;
      private Long factoryId;
      private String remark;

      ManufacturesInboundDetailDTOParamBuilder() {
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ManufacturesInboundDetailDTOParam build() {
         return new ManufacturesInboundDetailDTOParam(
            this.id,
            this.monomerId,
            this.areaId,
            this.name,
            this.serialNumber,
            this.specification,
            this.measureUnit,
            this.quantity,
            this.accountingUnit,
            this.mete,
            this.factoryId,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ManufacturesInboundDetailDTOParam.ManufacturesInboundDetailDTOParamBuilder(id="
            + this.id
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
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
            + ", factoryId="
            + this.factoryId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
