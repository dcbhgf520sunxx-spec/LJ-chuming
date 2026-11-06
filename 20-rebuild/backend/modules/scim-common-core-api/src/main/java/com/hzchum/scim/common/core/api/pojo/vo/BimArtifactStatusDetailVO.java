package com.hzchum.scim.common.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "BimArtifactStatusDetailVO", description = "构件模型数据")
public class BimArtifactStatusDetailVO {
   @ApiModelProperty(name = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "boxSerialNumber", notes = "分段编号")
   private String boxSerialNumber;
   @ApiModelProperty(name = "quantity", notes = "清单量")
   private Integer quantity;
   @ApiModelProperty(name = "productWeldCount", value = "焊缝数量")
   private Integer productWeldCount;
   @ApiModelProperty(name = "totalNetWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "清单总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "清单总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量,已入库数量,收货数量")
   private Integer completeQuantity;
   @ApiModelProperty(name = "inProductionQuantity", notes = "进入生产,已出库,安装数量")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;

   public static BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder builder() {
      return new BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder();
   }

   public BimArtifactStatusDetailVO() {
   }

   public BimArtifactStatusDetailVO(
      final Long id,
      final String name,
      final String serialNumber,
      final String boxSerialNumber,
      final Integer quantity,
      final Integer productWeldCount,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final Integer completeQuantity,
      final Integer inProductionQuantity,
      final BigDecimal length
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.boxSerialNumber = boxSerialNumber;
      this.quantity = quantity;
      this.productWeldCount = productWeldCount;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.completeQuantity = completeQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.length = length;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getBoxSerialNumber() {
      return this.boxSerialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProductWeldCount() {
      return this.productWeldCount;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BimArtifactStatusDetailVO setId(final Long id) {
      this.id = id;
      return this;
   }

   public BimArtifactStatusDetailVO setName(final String name) {
      this.name = name;
      return this;
   }

   public BimArtifactStatusDetailVO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public BimArtifactStatusDetailVO setBoxSerialNumber(final String boxSerialNumber) {
      this.boxSerialNumber = boxSerialNumber;
      return this;
   }

   public BimArtifactStatusDetailVO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public BimArtifactStatusDetailVO setProductWeldCount(final Integer productWeldCount) {
      this.productWeldCount = productWeldCount;
      return this;
   }

   public BimArtifactStatusDetailVO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public BimArtifactStatusDetailVO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public BimArtifactStatusDetailVO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public BimArtifactStatusDetailVO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public BimArtifactStatusDetailVO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public BimArtifactStatusDetailVO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   public BimArtifactStatusDetailVO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @Override
   public String toString() {
      return "BimArtifactStatusDetailVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", boxSerialNumber="
         + this.getBoxSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", productWeldCount="
         + this.getProductWeldCount()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", length="
         + this.getLength()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimArtifactStatusDetailVO)) {
         return false;
      }

      BimArtifactStatusDetailVO other = (BimArtifactStatusDetailVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$productWeldCount = this.getProductWeldCount();
            Object other$productWeldCount = other.getProductWeldCount();
            if (this$productWeldCount == null ? other$productWeldCount == null : this$productWeldCount.equals(other$productWeldCount)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                  Object this$inProductionQuantity = this.getInProductionQuantity();
                  Object other$inProductionQuantity = other.getInProductionQuantity();
                  if (this$inProductionQuantity == null ? other$inProductionQuantity == null : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$boxSerialNumber = this.getBoxSerialNumber();
                           Object other$boxSerialNumber = other.getBoxSerialNumber();
                           if (this$boxSerialNumber == null ? other$boxSerialNumber == null : this$boxSerialNumber.equals(other$boxSerialNumber)) {
                              Object this$netWeight = this.getNetWeight();
                              Object other$netWeight = other.getNetWeight();
                              if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                 Object this$grossWeight = this.getGrossWeight();
                                 Object other$grossWeight = other.getGrossWeight();
                                 if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                    if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                       Object this$totalGrossWeight = this.getTotalGrossWeight();
                                       Object other$totalGrossWeight = other.getTotalGrossWeight();
                                       if (this$totalGrossWeight == null
                                          ? other$totalGrossWeight == null
                                          : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          return this$length == null ? other$length == null : this$length.equals(other$length);
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
      return other instanceof BimArtifactStatusDetailVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productWeldCount = this.getProductWeldCount();
      result = result * 59 + ($productWeldCount == null ? 43 : $productWeldCount.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $boxSerialNumber = this.getBoxSerialNumber();
      result = result * 59 + ($boxSerialNumber == null ? 43 : $boxSerialNumber.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $length = this.getLength();
      return result * 59 + ($length == null ? 43 : $length.hashCode());
   }

   public static class BimArtifactStatusDetailVOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String boxSerialNumber;
      private Integer quantity;
      private Integer productWeldCount;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private Integer completeQuantity;
      private Integer inProductionQuantity;
      private BigDecimal length;

      BimArtifactStatusDetailVOBuilder() {
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder boxSerialNumber(final String boxSerialNumber) {
         this.boxSerialNumber = boxSerialNumber;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder productWeldCount(final Integer productWeldCount) {
         this.productWeldCount = productWeldCount;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      public BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public BimArtifactStatusDetailVO build() {
         return new BimArtifactStatusDetailVO(
            this.id,
            this.name,
            this.serialNumber,
            this.boxSerialNumber,
            this.quantity,
            this.productWeldCount,
            this.netWeight,
            this.grossWeight,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.completeQuantity,
            this.inProductionQuantity,
            this.length
         );
      }

      @Override
      public String toString() {
         return "BimArtifactStatusDetailVO.BimArtifactStatusDetailVOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", boxSerialNumber="
            + this.boxSerialNumber
            + ", quantity="
            + this.quantity
            + ", productWeldCount="
            + this.productWeldCount
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", length="
            + this.length
            + ")";
      }
   }
}
