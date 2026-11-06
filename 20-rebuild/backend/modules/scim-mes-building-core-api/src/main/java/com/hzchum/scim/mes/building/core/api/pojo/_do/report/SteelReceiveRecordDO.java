package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "SteelReceiveRecordDO", description = "钢材领用明细 ")
public class SteelReceiveRecordDO {
   @ApiModelProperty(name = "type", value = "类型")
   @JsonProperty("type")
   private String type;
   @ApiModelProperty(name = "materialType", value = "物料种类")
   @JsonProperty("materialType")
   private String materialType;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   private String specification;
   @ApiModelProperty(name = "texture", value = "材质")
   @JsonProperty("texture")
   private String texture;
   @ApiModelProperty(name = "unit", value = "单位")
   @JsonProperty("unit")
   private String unit;
   @ApiModelProperty(name = "total", value = "数量")
   @JsonProperty("total")
   private BigDecimal total;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @JsonProperty("accountingUnit")
   private String accountingUnit;
   @ApiModelProperty(name = "accountingQuantity", value = "核算量")
   @JsonProperty("accountingQuantity")
   private BigDecimal accountingQuantity;
   @ApiModelProperty(name = "outDate", value = "出（退）库日期")
   @JsonProperty("outDate")
   private String outDate;
   @ApiModelProperty(name = "useWorkshop", value = "领用车间")
   @JsonProperty("useWorkshop")
   private String useWorkshop;
   @ApiModelProperty(name = "receivePerson", value = "领料人")
   @JsonProperty("receivePerson")
   private String receivePerson;
   @ApiModelProperty(name = "handlePerson", value = "办理人")
   @JsonProperty("handlePerson")
   private String handlePerson;

   public static SteelReceiveRecordDO.SteelReceiveRecordDOBuilder builder() {
      return new SteelReceiveRecordDO.SteelReceiveRecordDOBuilder();
   }

   public SteelReceiveRecordDO() {
   }

   public SteelReceiveRecordDO(
      final String type,
      final String materialType,
      final String specification,
      final String texture,
      final String unit,
      final BigDecimal total,
      final String accountingUnit,
      final BigDecimal accountingQuantity,
      final String outDate,
      final String useWorkshop,
      final String receivePerson,
      final String handlePerson
   ) {
      this.type = type;
      this.materialType = materialType;
      this.specification = specification;
      this.texture = texture;
      this.unit = unit;
      this.total = total;
      this.accountingUnit = accountingUnit;
      this.accountingQuantity = accountingQuantity;
      this.outDate = outDate;
      this.useWorkshop = useWorkshop;
      this.receivePerson = receivePerson;
      this.handlePerson = handlePerson;
   }

   public String getType() {
      return this.type;
   }

   public String getMaterialType() {
      return this.materialType;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getTexture() {
      return this.texture;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getTotal() {
      return this.total;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getAccountingQuantity() {
      return this.accountingQuantity;
   }

   public String getOutDate() {
      return this.outDate;
   }

   public String getUseWorkshop() {
      return this.useWorkshop;
   }

   public String getReceivePerson() {
      return this.receivePerson;
   }

   public String getHandlePerson() {
      return this.handlePerson;
   }

   @JsonProperty("type")
   public SteelReceiveRecordDO setType(final String type) {
      this.type = type;
      return this;
   }

   @JsonProperty("materialType")
   public SteelReceiveRecordDO setMaterialType(final String materialType) {
      this.materialType = materialType;
      return this;
   }

   @JsonProperty("specification")
   public SteelReceiveRecordDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("texture")
   public SteelReceiveRecordDO setTexture(final String texture) {
      this.texture = texture;
      return this;
   }

   @JsonProperty("unit")
   public SteelReceiveRecordDO setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   @JsonProperty("total")
   public SteelReceiveRecordDO setTotal(final BigDecimal total) {
      this.total = total;
      return this;
   }

   @JsonProperty("accountingUnit")
   public SteelReceiveRecordDO setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("accountingQuantity")
   public SteelReceiveRecordDO setAccountingQuantity(final BigDecimal accountingQuantity) {
      this.accountingQuantity = accountingQuantity;
      return this;
   }

   @JsonProperty("outDate")
   public SteelReceiveRecordDO setOutDate(final String outDate) {
      this.outDate = outDate;
      return this;
   }

   @JsonProperty("useWorkshop")
   public SteelReceiveRecordDO setUseWorkshop(final String useWorkshop) {
      this.useWorkshop = useWorkshop;
      return this;
   }

   @JsonProperty("receivePerson")
   public SteelReceiveRecordDO setReceivePerson(final String receivePerson) {
      this.receivePerson = receivePerson;
      return this;
   }

   @JsonProperty("handlePerson")
   public SteelReceiveRecordDO setHandlePerson(final String handlePerson) {
      this.handlePerson = handlePerson;
      return this;
   }

   @Override
   public String toString() {
      return "SteelReceiveRecordDO(type="
         + this.getType()
         + ", materialType="
         + this.getMaterialType()
         + ", specification="
         + this.getSpecification()
         + ", texture="
         + this.getTexture()
         + ", unit="
         + this.getUnit()
         + ", total="
         + this.getTotal()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingQuantity="
         + this.getAccountingQuantity()
         + ", outDate="
         + this.getOutDate()
         + ", useWorkshop="
         + this.getUseWorkshop()
         + ", receivePerson="
         + this.getReceivePerson()
         + ", handlePerson="
         + this.getHandlePerson()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelReceiveRecordDO)) {
         return false;
      }

      SteelReceiveRecordDO other = (SteelReceiveRecordDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$materialType = this.getMaterialType();
         Object other$materialType = other.getMaterialType();
         if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
            Object this$specification = this.getSpecification();
            Object other$specification = other.getSpecification();
            if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
               Object this$texture = this.getTexture();
               Object other$texture = other.getTexture();
               if (this$texture == null ? other$texture == null : this$texture.equals(other$texture)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$total = this.getTotal();
                     Object other$total = other.getTotal();
                     if (this$total == null ? other$total == null : this$total.equals(other$total)) {
                        Object this$accountingUnit = this.getAccountingUnit();
                        Object other$accountingUnit = other.getAccountingUnit();
                        if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                           Object this$accountingQuantity = this.getAccountingQuantity();
                           Object other$accountingQuantity = other.getAccountingQuantity();
                           if (this$accountingQuantity == null ? other$accountingQuantity == null : this$accountingQuantity.equals(other$accountingQuantity)) {
                              Object this$outDate = this.getOutDate();
                              Object other$outDate = other.getOutDate();
                              if (this$outDate == null ? other$outDate == null : this$outDate.equals(other$outDate)) {
                                 Object this$useWorkshop = this.getUseWorkshop();
                                 Object other$useWorkshop = other.getUseWorkshop();
                                 if (this$useWorkshop == null ? other$useWorkshop == null : this$useWorkshop.equals(other$useWorkshop)) {
                                    Object this$receivePerson = this.getReceivePerson();
                                    Object other$receivePerson = other.getReceivePerson();
                                    if (this$receivePerson == null ? other$receivePerson == null : this$receivePerson.equals(other$receivePerson)) {
                                       Object this$handlePerson = this.getHandlePerson();
                                       Object other$handlePerson = other.getHandlePerson();
                                       return this$handlePerson == null ? other$handlePerson == null : this$handlePerson.equals(other$handlePerson);
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
      return other instanceof SteelReceiveRecordDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $texture = this.getTexture();
      result = result * 59 + ($texture == null ? 43 : $texture.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $total = this.getTotal();
      result = result * 59 + ($total == null ? 43 : $total.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $accountingQuantity = this.getAccountingQuantity();
      result = result * 59 + ($accountingQuantity == null ? 43 : $accountingQuantity.hashCode());
      Object $outDate = this.getOutDate();
      result = result * 59 + ($outDate == null ? 43 : $outDate.hashCode());
      Object $useWorkshop = this.getUseWorkshop();
      result = result * 59 + ($useWorkshop == null ? 43 : $useWorkshop.hashCode());
      Object $receivePerson = this.getReceivePerson();
      result = result * 59 + ($receivePerson == null ? 43 : $receivePerson.hashCode());
      Object $handlePerson = this.getHandlePerson();
      return result * 59 + ($handlePerson == null ? 43 : $handlePerson.hashCode());
   }

   public static class SteelReceiveRecordDOBuilder {
      private String type;
      private String materialType;
      private String specification;
      private String texture;
      private String unit;
      private BigDecimal total;
      private String accountingUnit;
      private BigDecimal accountingQuantity;
      private String outDate;
      private String useWorkshop;
      private String receivePerson;
      private String handlePerson;

      SteelReceiveRecordDOBuilder() {
      }

      @JsonProperty("type")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      @JsonProperty("materialType")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder materialType(final String materialType) {
         this.materialType = materialType;
         return this;
      }

      @JsonProperty("specification")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("texture")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder texture(final String texture) {
         this.texture = texture;
         return this;
      }

      @JsonProperty("unit")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      @JsonProperty("total")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder total(final BigDecimal total) {
         this.total = total;
         return this;
      }

      @JsonProperty("accountingUnit")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("accountingQuantity")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder accountingQuantity(final BigDecimal accountingQuantity) {
         this.accountingQuantity = accountingQuantity;
         return this;
      }

      @JsonProperty("outDate")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder outDate(final String outDate) {
         this.outDate = outDate;
         return this;
      }

      @JsonProperty("useWorkshop")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder useWorkshop(final String useWorkshop) {
         this.useWorkshop = useWorkshop;
         return this;
      }

      @JsonProperty("receivePerson")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder receivePerson(final String receivePerson) {
         this.receivePerson = receivePerson;
         return this;
      }

      @JsonProperty("handlePerson")
      public SteelReceiveRecordDO.SteelReceiveRecordDOBuilder handlePerson(final String handlePerson) {
         this.handlePerson = handlePerson;
         return this;
      }

      public SteelReceiveRecordDO build() {
         return new SteelReceiveRecordDO(
            this.type,
            this.materialType,
            this.specification,
            this.texture,
            this.unit,
            this.total,
            this.accountingUnit,
            this.accountingQuantity,
            this.outDate,
            this.useWorkshop,
            this.receivePerson,
            this.handlePerson
         );
      }

      @Override
      public String toString() {
         return "SteelReceiveRecordDO.SteelReceiveRecordDOBuilder(type="
            + this.type
            + ", materialType="
            + this.materialType
            + ", specification="
            + this.specification
            + ", texture="
            + this.texture
            + ", unit="
            + this.unit
            + ", total="
            + this.total
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingQuantity="
            + this.accountingQuantity
            + ", outDate="
            + this.outDate
            + ", useWorkshop="
            + this.useWorkshop
            + ", receivePerson="
            + this.receivePerson
            + ", handlePerson="
            + this.handlePerson
            + ")";
      }
   }
}
