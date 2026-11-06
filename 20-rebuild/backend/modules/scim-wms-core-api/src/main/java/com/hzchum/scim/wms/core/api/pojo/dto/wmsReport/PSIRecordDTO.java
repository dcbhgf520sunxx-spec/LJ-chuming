package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class PSIRecordDTO {
   private Long classifyId;
   private String classifyName;
   private Integer basicClass;
   private String specification;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal width;
   private BigDecimal length;
   private BigDecimal inboundMete;
   private BigDecimal outboundMete;
   private BigDecimal inventoryMete;
   private String accountingUnit;
   private String materialSn;
   @ApiModelProperty("计量单位")
   private String measureUnit;
   @ApiModelProperty("入库数量")
   private BigDecimal inboundQuantity;
   @ApiModelProperty("出库数量")
   private BigDecimal outboundQuantity;
   @ApiModelProperty("库存数量")
   private BigDecimal inventoryQuantity;

   public static PSIRecordDTO.PSIRecordDTOBuilder builder() {
      return new PSIRecordDTO.PSIRecordDTOBuilder();
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getInventoryMete() {
      return this.inventoryMete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getInboundQuantity() {
      return this.inboundQuantity;
   }

   public BigDecimal getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public BigDecimal getInventoryQuantity() {
      return this.inventoryQuantity;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setInventoryMete(final BigDecimal inventoryMete) {
      this.inventoryMete = inventoryMete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setInboundQuantity(final BigDecimal inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   public void setOutboundQuantity(final BigDecimal outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
   }

   public void setInventoryQuantity(final BigDecimal inventoryQuantity) {
      this.inventoryQuantity = inventoryQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PSIRecordDTO)) {
         return false;
      }

      PSIRecordDTO other = (PSIRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyName = this.getClassifyName();
            Object other$classifyName = other.getClassifyName();
            if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$thickness = this.getThickness();
                     Object other$thickness = other.getThickness();
                     if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                        Object this$width = this.getWidth();
                        Object other$width = other.getWidth();
                        if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$inboundMete = this.getInboundMete();
                              Object other$inboundMete = other.getInboundMete();
                              if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                                 Object this$outboundMete = this.getOutboundMete();
                                 Object other$outboundMete = other.getOutboundMete();
                                 if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                    Object this$inventoryMete = this.getInventoryMete();
                                    Object other$inventoryMete = other.getInventoryMete();
                                    if (this$inventoryMete == null ? other$inventoryMete == null : this$inventoryMete.equals(other$inventoryMete)) {
                                       Object this$accountingUnit = this.getAccountingUnit();
                                       Object other$accountingUnit = other.getAccountingUnit();
                                       if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                          Object this$materialSn = this.getMaterialSn();
                                          Object other$materialSn = other.getMaterialSn();
                                          if (this$materialSn == null ? other$materialSn == null : this$materialSn.equals(other$materialSn)) {
                                             Object this$measureUnit = this.getMeasureUnit();
                                             Object other$measureUnit = other.getMeasureUnit();
                                             if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                Object this$inboundQuantity = this.getInboundQuantity();
                                                Object other$inboundQuantity = other.getInboundQuantity();
                                                if (this$inboundQuantity == null
                                                   ? other$inboundQuantity == null
                                                   : this$inboundQuantity.equals(other$inboundQuantity)) {
                                                   Object this$outboundQuantity = this.getOutboundQuantity();
                                                   Object other$outboundQuantity = other.getOutboundQuantity();
                                                   if (this$outboundQuantity == null
                                                      ? other$outboundQuantity == null
                                                      : this$outboundQuantity.equals(other$outboundQuantity)) {
                                                      Object this$inventoryQuantity = this.getInventoryQuantity();
                                                      Object other$inventoryQuantity = other.getInventoryQuantity();
                                                      return this$inventoryQuantity == null
                                                         ? other$inventoryQuantity == null
                                                         : this$inventoryQuantity.equals(other$inventoryQuantity);
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
      return other instanceof PSIRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $inventoryMete = this.getInventoryMete();
      result = result * 59 + ($inventoryMete == null ? 43 : $inventoryMete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $inventoryQuantity = this.getInventoryQuantity();
      return result * 59 + ($inventoryQuantity == null ? 43 : $inventoryQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "PSIRecordDTO(classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", inboundMete="
         + this.getInboundMete()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", inventoryMete="
         + this.getInventoryMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", materialSn="
         + this.getMaterialSn()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", inventoryQuantity="
         + this.getInventoryQuantity()
         + ")";
   }

   public PSIRecordDTO(
      final Long classifyId,
      final String classifyName,
      final Integer basicClass,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal length,
      final BigDecimal inboundMete,
      final BigDecimal outboundMete,
      final BigDecimal inventoryMete,
      final String accountingUnit,
      final String materialSn,
      final String measureUnit,
      final BigDecimal inboundQuantity,
      final BigDecimal outboundQuantity,
      final BigDecimal inventoryQuantity
   ) {
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.basicClass = basicClass;
      this.specification = specification;
      this.quantity = quantity;
      this.thickness = thickness;
      this.width = width;
      this.length = length;
      this.inboundMete = inboundMete;
      this.outboundMete = outboundMete;
      this.inventoryMete = inventoryMete;
      this.accountingUnit = accountingUnit;
      this.materialSn = materialSn;
      this.measureUnit = measureUnit;
      this.inboundQuantity = inboundQuantity;
      this.outboundQuantity = outboundQuantity;
      this.inventoryQuantity = inventoryQuantity;
   }

   public PSIRecordDTO() {
   }

   public static class PSIRecordDTOBuilder {
      private Long classifyId;
      private String classifyName;
      private Integer basicClass;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal length;
      private BigDecimal inboundMete;
      private BigDecimal outboundMete;
      private BigDecimal inventoryMete;
      private String accountingUnit;
      private String materialSn;
      private String measureUnit;
      private BigDecimal inboundQuantity;
      private BigDecimal outboundQuantity;
      private BigDecimal inventoryQuantity;

      PSIRecordDTOBuilder() {
      }

      public PSIRecordDTO.PSIRecordDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder inventoryMete(final BigDecimal inventoryMete) {
         this.inventoryMete = inventoryMete;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder inboundQuantity(final BigDecimal inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder outboundQuantity(final BigDecimal outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      public PSIRecordDTO.PSIRecordDTOBuilder inventoryQuantity(final BigDecimal inventoryQuantity) {
         this.inventoryQuantity = inventoryQuantity;
         return this;
      }

      public PSIRecordDTO build() {
         return new PSIRecordDTO(
            this.classifyId,
            this.classifyName,
            this.basicClass,
            this.specification,
            this.quantity,
            this.thickness,
            this.width,
            this.length,
            this.inboundMete,
            this.outboundMete,
            this.inventoryMete,
            this.accountingUnit,
            this.materialSn,
            this.measureUnit,
            this.inboundQuantity,
            this.outboundQuantity,
            this.inventoryQuantity
         );
      }

      @Override
      public String toString() {
         return "PSIRecordDTO.PSIRecordDTOBuilder(classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", inboundMete="
            + this.inboundMete
            + ", outboundMete="
            + this.outboundMete
            + ", inventoryMete="
            + this.inventoryMete
            + ", accountingUnit="
            + this.accountingUnit
            + ", materialSn="
            + this.materialSn
            + ", measureUnit="
            + this.measureUnit
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", inventoryQuantity="
            + this.inventoryQuantity
            + ")";
      }
   }
}
