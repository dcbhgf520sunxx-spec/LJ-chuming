package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductionDetailDO", description = "生产明细")
public class ProductionDetailDO {
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   @JsonProperty("monomerName")
   @Excel(name = "单体", width = 40.0)
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   @JsonProperty("areaName")
   @Excel(name = "区域", width = 20.0)
   private String areaName;
   @ApiModelProperty(name = "productName", value = "名称")
   @JsonProperty("productName")
   @Excel(name = "名称")
   private String productName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @Excel(name = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @Excel(name = "规格", width = 30.0)
   private String specification;
   @ApiModelProperty(name = "length", value = "长度")
   @JsonProperty("length")
   @Excel(name = "长度", type = 10)
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @Excel(name = "材质")
   private String material;
   @ApiModelProperty(name = "productionNumber", value = "生产数")
   @JsonProperty("productionNumber")
   @Excel(name = "生产数", type = 10)
   private BigDecimal productionNumber;
   @ApiModelProperty(name = "weight", value = "重量（kg）")
   @JsonProperty("weight")
   @Excel(name = "重量（kg）", type = 10)
   private BigDecimal weight;
   @ApiModelProperty(name = "createTime", value = "入库日期")
   @JsonProperty("createTime")
   @Excel(name = "入库日期", width = 20.0)
   private String createTime;

   public static ProductionDetailDO.ProductionDetailDOBuilder builder() {
      return new ProductionDetailDO.ProductionDetailDOBuilder();
   }

   public ProductionDetailDO() {
   }

   public ProductionDetailDO(
      final String monomerName,
      final String areaName,
      final String productName,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal productionNumber,
      final BigDecimal weight,
      final String createTime
   ) {
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.productName = productName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.productionNumber = productionNumber;
      this.weight = weight;
      this.createTime = createTime;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getProductName() {
      return this.productName;
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

   public BigDecimal getProductionNumber() {
      return this.productionNumber;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getCreateTime() {
      return this.createTime;
   }

   @JsonProperty("monomerName")
   public ProductionDetailDO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaName")
   public ProductionDetailDO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("productName")
   public ProductionDetailDO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductionDetailDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProductionDetailDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ProductionDetailDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ProductionDetailDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("productionNumber")
   public ProductionDetailDO setProductionNumber(final BigDecimal productionNumber) {
      this.productionNumber = productionNumber;
      return this;
   }

   @JsonProperty("weight")
   public ProductionDetailDO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("createTime")
   public ProductionDetailDO setCreateTime(final String createTime) {
      this.createTime = createTime;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionDetailDO(monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", productName="
         + this.getProductName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", productionNumber="
         + this.getProductionNumber()
         + ", weight="
         + this.getWeight()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionDetailDO)) {
         return false;
      }

      ProductionDetailDO other = (ProductionDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerName = this.getMonomerName();
      Object other$monomerName = other.getMonomerName();
      if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
         Object this$areaName = this.getAreaName();
         Object other$areaName = other.getAreaName();
         if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
            Object this$productName = this.getProductName();
            Object other$productName = other.getProductName();
            if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
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
                           Object this$productionNumber = this.getProductionNumber();
                           Object other$productionNumber = other.getProductionNumber();
                           if (this$productionNumber == null ? other$productionNumber == null : this$productionNumber.equals(other$productionNumber)) {
                              Object this$weight = this.getWeight();
                              Object other$weight = other.getWeight();
                              if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                 Object this$createTime = this.getCreateTime();
                                 Object other$createTime = other.getCreateTime();
                                 return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof ProductionDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $productionNumber = this.getProductionNumber();
      result = result * 59 + ($productionNumber == null ? 43 : $productionNumber.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   public static class ProductionDetailDOBuilder {
      private String monomerName;
      private String areaName;
      private String productName;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal productionNumber;
      private BigDecimal weight;
      private String createTime;

      ProductionDetailDOBuilder() {
      }

      @JsonProperty("monomerName")
      public ProductionDetailDO.ProductionDetailDOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaName")
      public ProductionDetailDO.ProductionDetailDOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("productName")
      public ProductionDetailDO.ProductionDetailDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductionDetailDO.ProductionDetailDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProductionDetailDO.ProductionDetailDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ProductionDetailDO.ProductionDetailDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ProductionDetailDO.ProductionDetailDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("productionNumber")
      public ProductionDetailDO.ProductionDetailDOBuilder productionNumber(final BigDecimal productionNumber) {
         this.productionNumber = productionNumber;
         return this;
      }

      @JsonProperty("weight")
      public ProductionDetailDO.ProductionDetailDOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("createTime")
      public ProductionDetailDO.ProductionDetailDOBuilder createTime(final String createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProductionDetailDO build() {
         return new ProductionDetailDO(
            this.monomerName,
            this.areaName,
            this.productName,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.productionNumber,
            this.weight,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "ProductionDetailDO.ProductionDetailDOBuilder(monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", productName="
            + this.productName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", productionNumber="
            + this.productionNumber
            + ", weight="
            + this.weight
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
