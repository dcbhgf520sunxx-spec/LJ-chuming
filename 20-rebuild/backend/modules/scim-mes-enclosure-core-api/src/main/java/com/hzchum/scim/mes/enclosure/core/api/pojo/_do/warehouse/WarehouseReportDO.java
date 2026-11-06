package com.hzchum.scim.mes.enclosure.core.api.pojo._do.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("入发存报表")
public class WarehouseReportDO {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty(name = "name", value = "工厂名称", notes = "工厂名称")
   private String factoryName;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty("围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty("类型")
   private Integer productType;
   @ApiModelProperty("期初库存（净重 m）")
   private BigDecimal beginMete;
   @ApiModelProperty("入库量（净重 m）")
   private BigDecimal inboundMete;
   @ApiModelProperty("出库量（净重 m）")
   private BigDecimal outboundMete;
   @ApiModelProperty("期初库存（毛重 ㎡）")
   private BigDecimal beginMete1;
   @ApiModelProperty("入库量（毛重 ㎡）")
   private BigDecimal inboundMete1;
   @ApiModelProperty("出库量（毛重 ㎡）")
   private BigDecimal outboundMete1;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getBeginMete() {
      return this.beginMete;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getBeginMete1() {
      return this.beginMete1;
   }

   public BigDecimal getInboundMete1() {
      return this.inboundMete1;
   }

   public BigDecimal getOutboundMete1() {
      return this.outboundMete1;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setBeginMete(final BigDecimal beginMete) {
      this.beginMete = beginMete;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setBeginMete1(final BigDecimal beginMete1) {
      this.beginMete1 = beginMete1;
   }

   public void setInboundMete1(final BigDecimal inboundMete1) {
      this.inboundMete1 = inboundMete1;
   }

   public void setOutboundMete1(final BigDecimal outboundMete1) {
      this.outboundMete1 = outboundMete1;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseReportDO)) {
         return false;
      }

      WarehouseReportDO other = (WarehouseReportDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
         Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
         if (this$enclosureMeasureMode == null ? other$enclosureMeasureMode == null : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$factoryName = this.getFactoryName();
                     Object other$factoryName = other.getFactoryName();
                     if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$beginMete = this.getBeginMete();
                           Object other$beginMete = other.getBeginMete();
                           if (this$beginMete == null ? other$beginMete == null : this$beginMete.equals(other$beginMete)) {
                              Object this$inboundMete = this.getInboundMete();
                              Object other$inboundMete = other.getInboundMete();
                              if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                                 Object this$outboundMete = this.getOutboundMete();
                                 Object other$outboundMete = other.getOutboundMete();
                                 if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                    Object this$beginMete1 = this.getBeginMete1();
                                    Object other$beginMete1 = other.getBeginMete1();
                                    if (this$beginMete1 == null ? other$beginMete1 == null : this$beginMete1.equals(other$beginMete1)) {
                                       Object this$inboundMete1 = this.getInboundMete1();
                                       Object other$inboundMete1 = other.getInboundMete1();
                                       if (this$inboundMete1 == null ? other$inboundMete1 == null : this$inboundMete1.equals(other$inboundMete1)) {
                                          Object this$outboundMete1 = this.getOutboundMete1();
                                          Object other$outboundMete1 = other.getOutboundMete1();
                                          return this$outboundMete1 == null ? other$outboundMete1 == null : this$outboundMete1.equals(other$outboundMete1);
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
      return other instanceof WarehouseReportDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $beginMete = this.getBeginMete();
      result = result * 59 + ($beginMete == null ? 43 : $beginMete.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $beginMete1 = this.getBeginMete1();
      result = result * 59 + ($beginMete1 == null ? 43 : $beginMete1.hashCode());
      Object $inboundMete1 = this.getInboundMete1();
      result = result * 59 + ($inboundMete1 == null ? 43 : $inboundMete1.hashCode());
      Object $outboundMete1 = this.getOutboundMete1();
      return result * 59 + ($outboundMete1 == null ? 43 : $outboundMete1.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseReportDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", factoryName="
         + this.getFactoryName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", productType="
         + this.getProductType()
         + ", beginMete="
         + this.getBeginMete()
         + ", inboundMete="
         + this.getInboundMete()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", beginMete1="
         + this.getBeginMete1()
         + ", inboundMete1="
         + this.getInboundMete1()
         + ", outboundMete1="
         + this.getOutboundMete1()
         + ")";
   }
}
