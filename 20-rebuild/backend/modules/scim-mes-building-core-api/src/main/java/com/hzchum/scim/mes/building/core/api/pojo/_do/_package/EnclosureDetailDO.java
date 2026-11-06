package com.hzchum.scim.mes.building.core.api.pojo._do._package;

import com.hzchum.scim.common.core.api.pojo.common.EnclosureBaseInfo;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("围护发运")
public class EnclosureDetailDO extends EnclosureBaseInfo {
   @ApiModelProperty(name = "id", notes = "出入库id")
   private Long id;
   @ApiModelProperty(name = "warehouseType", value = "入库类型")
   private Integer warehouseType;
   @ApiModelProperty(notes = "工厂")
   private NameInfo factory;
   @ApiModelProperty(notes = "车间")
   private NameInfo workshop;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "type", notes = "种类（芯材信息）")
   private String type;
   @ApiModelProperty(name = "capacity", notes = "容量（芯材信息）")
   private String capacity;
   @ApiModelProperty(name = "inQuantity", notes = "入库数量")
   private BigDecimal inQuantity;
   @ApiModelProperty(name = "packageQuantity", value = "打包数量")
   private BigDecimal packageQuantity;
   @ApiModelProperty(name = "unPackageQuantity", value = "可使用数量")
   private BigDecimal unPackageQuantity;

   public static EnclosureDetailDO.EnclosureDetailDOBuilder builder() {
      return new EnclosureDetailDO.EnclosureDetailDOBuilder();
   }

   public EnclosureDetailDO() {
   }

   public EnclosureDetailDO(
      final Long id,
      final Integer warehouseType,
      final NameInfo factory,
      final NameInfo workshop,
      final Integer productType,
      final Long productId,
      final String type,
      final String capacity,
      final BigDecimal inQuantity,
      final BigDecimal packageQuantity,
      final BigDecimal unPackageQuantity
   ) {
      this.id = id;
      this.warehouseType = warehouseType;
      this.factory = factory;
      this.workshop = workshop;
      this.productType = productType;
      this.productId = productId;
      this.type = type;
      this.capacity = capacity;
      this.inQuantity = inQuantity;
      this.packageQuantity = packageQuantity;
      this.unPackageQuantity = unPackageQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public NameInfo getFactory() {
      return this.factory;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getType() {
      return this.type;
   }

   public String getCapacity() {
      return this.capacity;
   }

   public BigDecimal getInQuantity() {
      return this.inQuantity;
   }

   public BigDecimal getPackageQuantity() {
      return this.packageQuantity;
   }

   public BigDecimal getUnPackageQuantity() {
      return this.unPackageQuantity;
   }

   public EnclosureDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public EnclosureDetailDO setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   public EnclosureDetailDO setFactory(final NameInfo factory) {
      this.factory = factory;
      return this;
   }

   public EnclosureDetailDO setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
      return this;
   }

   public EnclosureDetailDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public EnclosureDetailDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public EnclosureDetailDO setType(final String type) {
      this.type = type;
      return this;
   }

   public EnclosureDetailDO setCapacity(final String capacity) {
      this.capacity = capacity;
      return this;
   }

   public EnclosureDetailDO setInQuantity(final BigDecimal inQuantity) {
      this.inQuantity = inQuantity;
      return this;
   }

   public EnclosureDetailDO setPackageQuantity(final BigDecimal packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }

   public EnclosureDetailDO setUnPackageQuantity(final BigDecimal unPackageQuantity) {
      this.unPackageQuantity = unPackageQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosureDetailDO(id="
         + this.getId()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", type="
         + this.getType()
         + ", capacity="
         + this.getCapacity()
         + ", inQuantity="
         + this.getInQuantity()
         + ", packageQuantity="
         + this.getPackageQuantity()
         + ", unPackageQuantity="
         + this.getUnPackageQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureDetailDO)) {
         return false;
      }

      EnclosureDetailDO other = (EnclosureDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$warehouseType = this.getWarehouseType();
         Object other$warehouseType = other.getWarehouseType();
         if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$factory = this.getFactory();
                  Object other$factory = other.getFactory();
                  if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                     Object this$workshop = this.getWorkshop();
                     Object other$workshop = other.getWorkshop();
                     if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$capacity = this.getCapacity();
                           Object other$capacity = other.getCapacity();
                           if (this$capacity == null ? other$capacity == null : this$capacity.equals(other$capacity)) {
                              Object this$inQuantity = this.getInQuantity();
                              Object other$inQuantity = other.getInQuantity();
                              if (this$inQuantity == null ? other$inQuantity == null : this$inQuantity.equals(other$inQuantity)) {
                                 Object this$packageQuantity = this.getPackageQuantity();
                                 Object other$packageQuantity = other.getPackageQuantity();
                                 if (this$packageQuantity == null ? other$packageQuantity == null : this$packageQuantity.equals(other$packageQuantity)) {
                                    Object this$unPackageQuantity = this.getUnPackageQuantity();
                                    Object other$unPackageQuantity = other.getUnPackageQuantity();
                                    return this$unPackageQuantity == null
                                       ? other$unPackageQuantity == null
                                       : this$unPackageQuantity.equals(other$unPackageQuantity);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $capacity = this.getCapacity();
      result = result * 59 + ($capacity == null ? 43 : $capacity.hashCode());
      Object $inQuantity = this.getInQuantity();
      result = result * 59 + ($inQuantity == null ? 43 : $inQuantity.hashCode());
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $unPackageQuantity = this.getUnPackageQuantity();
      return result * 59 + ($unPackageQuantity == null ? 43 : $unPackageQuantity.hashCode());
   }

   public static class EnclosureDetailDOBuilder {
      private Long id;
      private Integer warehouseType;
      private NameInfo factory;
      private NameInfo workshop;
      private Integer productType;
      private Long productId;
      private String type;
      private String capacity;
      private BigDecimal inQuantity;
      private BigDecimal packageQuantity;
      private BigDecimal unPackageQuantity;

      EnclosureDetailDOBuilder() {
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder factory(final NameInfo factory) {
         this.factory = factory;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder workshop(final NameInfo workshop) {
         this.workshop = workshop;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder capacity(final String capacity) {
         this.capacity = capacity;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder inQuantity(final BigDecimal inQuantity) {
         this.inQuantity = inQuantity;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder packageQuantity(final BigDecimal packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      public EnclosureDetailDO.EnclosureDetailDOBuilder unPackageQuantity(final BigDecimal unPackageQuantity) {
         this.unPackageQuantity = unPackageQuantity;
         return this;
      }

      public EnclosureDetailDO build() {
         return new EnclosureDetailDO(
            this.id,
            this.warehouseType,
            this.factory,
            this.workshop,
            this.productType,
            this.productId,
            this.type,
            this.capacity,
            this.inQuantity,
            this.packageQuantity,
            this.unPackageQuantity
         );
      }

      @Override
      public String toString() {
         return "EnclosureDetailDO.EnclosureDetailDOBuilder(id="
            + this.id
            + ", warehouseType="
            + this.warehouseType
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", type="
            + this.type
            + ", capacity="
            + this.capacity
            + ", inQuantity="
            + this.inQuantity
            + ", packageQuantity="
            + this.packageQuantity
            + ", unPackageQuantity="
            + this.unPackageQuantity
            + ")";
      }
   }
}
