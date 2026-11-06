package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("入发存报表")
public class WarehouseReportDTO {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty(name = "factoryName", value = "工厂名称")
   private String factoryName;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty("类型")
   private Integer productType;
   @ApiModelProperty("单位")
   private String unit;
   @ApiModelProperty("期初库存")
   private BigDecimal beginMete;
   @ApiModelProperty("入库数量")
   private BigDecimal inboundMete;
   @ApiModelProperty("出库数量")
   private BigDecimal outboundMete;
   @ApiModelProperty("期末库存")
   private BigDecimal endMete;

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

   public Integer getProductType() {
      return this.productType;
   }

   public String getUnit() {
      return this.unit;
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

   public BigDecimal getEndMete() {
      return this.endMete;
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

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
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

   public void setEndMete(final BigDecimal endMete) {
      this.endMete = endMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseReportDTO)) {
         return false;
      }

      WarehouseReportDTO other = (WarehouseReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                        Object this$unit = this.getUnit();
                        Object other$unit = other.getUnit();
                        if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                           Object this$beginMete = this.getBeginMete();
                           Object other$beginMete = other.getBeginMete();
                           if (this$beginMete == null ? other$beginMete == null : this$beginMete.equals(other$beginMete)) {
                              Object this$inboundMete = this.getInboundMete();
                              Object other$inboundMete = other.getInboundMete();
                              if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                                 Object this$outboundMete = this.getOutboundMete();
                                 Object other$outboundMete = other.getOutboundMete();
                                 if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                    Object this$endMete = this.getEndMete();
                                    Object other$endMete = other.getEndMete();
                                    return this$endMete == null ? other$endMete == null : this$endMete.equals(other$endMete);
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
      return other instanceof WarehouseReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $beginMete = this.getBeginMete();
      result = result * 59 + ($beginMete == null ? 43 : $beginMete.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $endMete = this.getEndMete();
      return result * 59 + ($endMete == null ? 43 : $endMete.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseReportDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", factoryName="
         + this.getFactoryName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", unit="
         + this.getUnit()
         + ", beginMete="
         + this.getBeginMete()
         + ", inboundMete="
         + this.getInboundMete()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", endMete="
         + this.getEndMete()
         + ")";
   }
}
