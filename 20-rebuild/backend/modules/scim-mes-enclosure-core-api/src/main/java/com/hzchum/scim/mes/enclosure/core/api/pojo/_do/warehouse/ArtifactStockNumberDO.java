package com.hzchum.scim.mes.enclosure.core.api.pojo._do.warehouse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
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

   public static ArtifactStockNumberDO.ArtifactStockNumberDOBuilder builder() {
      return new ArtifactStockNumberDO.ArtifactStockNumberDOBuilder();
   }

   public ArtifactStockNumberDO() {
   }

   public ArtifactStockNumberDO(final Long productId, final Integer number, final FactoryDetailDO factory, final Boolean boolPackage) {
      this.productId = productId;
      this.number = number;
      this.factory = factory;
      this.boolPackage = boolPackage;
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
               Object this$factory = this.getFactory();
               Object other$factory = other.getFactory();
               return this$factory == null ? other$factory == null : this$factory.equals(other$factory);
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
      Object $factory = this.getFactory();
      return result * 59 + ($factory == null ? 43 : $factory.hashCode());
   }

   public static class ArtifactStockNumberDOBuilder {
      private Long productId;
      private Integer number;
      private FactoryDetailDO factory;
      private Boolean boolPackage;

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

      public ArtifactStockNumberDO build() {
         return new ArtifactStockNumberDO(this.productId, this.number, this.factory, this.boolPackage);
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
            + ")";
      }
   }
}
