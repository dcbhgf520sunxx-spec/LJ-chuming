package com.hzchum.scim.mes.building.core.api.pojo._do.warehouse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArtifactStockNumberDO", description = "构件库存一物一码序号 ")
public class ArtifactStockNumberDO {
   @ApiModelProperty(name = "productId", notes = "构件编号")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "number", notes = "一物一码编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "factory", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "boolPackage", notes = "是否打包")
   @JsonProperty("boolPackage")
   @JSONField(name = "boolPackage")
   private Boolean boolPackage;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "warehouseType", notes = "是否返修")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   private Integer warehouseType;

   public static ArtifactStockNumberDO.ArtifactStockNumberDOBuilder builder() {
      return new ArtifactStockNumberDO.ArtifactStockNumberDOBuilder();
   }

   public ArtifactStockNumberDO() {
   }

   public ArtifactStockNumberDO(
      final Long productId,
      final Integer number,
      final FactoryDetailDO factory,
      final Boolean boolPackage,
      final WorkshopDetailDO workshop,
      final Integer warehouseType
   ) {
      this.productId = productId;
      this.number = number;
      this.factory = factory;
      this.boolPackage = boolPackage;
      this.workshop = workshop;
      this.warehouseType = warehouseType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public Boolean getBoolPackage() {
      return this.boolPackage;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   @JsonProperty("productId")
   public ArtifactStockNumberDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("number")
   public ArtifactStockNumberDO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("factory")
   public ArtifactStockNumberDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("boolPackage")
   public ArtifactStockNumberDO setBoolPackage(final Boolean boolPackage) {
      this.boolPackage = boolPackage;
      return this;
   }

   @JsonProperty("workshop")
   public ArtifactStockNumberDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("warehouseType")
   public ArtifactStockNumberDO setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactStockNumberDO(productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ", factory="
         + this.getFactory()
         + ", boolPackage="
         + this.getBoolPackage()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouseType="
         + this.getWarehouseType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactStockNumberDO)) {
         return false;
      }

      ArtifactStockNumberDO other = (ArtifactStockNumberDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$boolPackage = this.getBoolPackage();
            Object other$boolPackage = other.getBoolPackage();
            if (this$boolPackage == null ? other$boolPackage == null : this$boolPackage.equals(other$boolPackage)) {
               Object this$warehouseType = this.getWarehouseType();
               Object other$warehouseType = other.getWarehouseType();
               if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                  Object this$factory = this.getFactory();
                  Object other$factory = other.getFactory();
                  if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                     Object this$workshop = this.getWorkshop();
                     Object other$workshop = other.getWorkshop();
                     return this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop);
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
      return other instanceof ArtifactStockNumberDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $boolPackage = this.getBoolPackage();
      result = result * 59 + ($boolPackage == null ? 43 : $boolPackage.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      return result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
   }

   public static class ArtifactStockNumberDOBuilder {
      private Long productId;
      private Integer number;
      private FactoryDetailDO factory;
      private Boolean boolPackage;
      private WorkshopDetailDO workshop;
      private Integer warehouseType;

      ArtifactStockNumberDOBuilder() {
      }

      @JsonProperty("productId")
      public ArtifactStockNumberDO.ArtifactStockNumberDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("number")
      public ArtifactStockNumberDO.ArtifactStockNumberDOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("factory")
      public ArtifactStockNumberDO.ArtifactStockNumberDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("boolPackage")
      public ArtifactStockNumberDO.ArtifactStockNumberDOBuilder boolPackage(final Boolean boolPackage) {
         this.boolPackage = boolPackage;
         return this;
      }

      @JsonProperty("workshop")
      public ArtifactStockNumberDO.ArtifactStockNumberDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("warehouseType")
      public ArtifactStockNumberDO.ArtifactStockNumberDOBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public ArtifactStockNumberDO build() {
         return new ArtifactStockNumberDO(this.productId, this.number, this.factory, this.boolPackage, this.workshop, this.warehouseType);
      }

      @Override
      public String toString() {
         return "ArtifactStockNumberDO.ArtifactStockNumberDOBuilder(productId="
            + this.productId
            + ", number="
            + this.number
            + ", factory="
            + this.factory
            + ", boolPackage="
            + this.boolPackage
            + ", workshop="
            + this.workshop
            + ", warehouseType="
            + this.warehouseType
            + ")";
      }
   }
}
