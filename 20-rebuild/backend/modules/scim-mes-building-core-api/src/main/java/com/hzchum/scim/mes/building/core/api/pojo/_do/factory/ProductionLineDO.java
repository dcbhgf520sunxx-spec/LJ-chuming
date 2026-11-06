package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductionLineDTO", description = "")
public class ProductionLineDO {
   @ApiModelProperty(name = "factory", notes = "工厂", value = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "workshop", notes = "车间", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线", value = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;

   public static ProductionLineDO.ProductionLineDOBuilder builder() {
      return new ProductionLineDO.ProductionLineDOBuilder();
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   @JsonProperty("factory")
   public ProductionLineDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public ProductionLineDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ProductionLineDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineDO(factory=" + this.getFactory() + ", workshop=" + this.getWorkshop() + ", productionLine=" + this.getProductionLine() + ")";
   }

   public ProductionLineDO(final FactoryDetailDO factory, final WorkshopDetailDO workshop, final ProductionLineDetailDO productionLine) {
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
   }

   public ProductionLineDO() {
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLineDO)) {
         return false;
      }

      ProductionLineDO other = (ProductionLineDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factory = this.getFactory();
      Object other$factory = other.getFactory();
      if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
         Object this$workshop = this.getWorkshop();
         Object other$workshop = other.getWorkshop();
         if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
            Object this$productionLine = this.getProductionLine();
            Object other$productionLine = other.getProductionLine();
            return this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionLineDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      return result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
   }

   public static class ProductionLineDOBuilder {
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;

      ProductionLineDOBuilder() {
      }

      @JsonProperty("factory")
      public ProductionLineDO.ProductionLineDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public ProductionLineDO.ProductionLineDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ProductionLineDO.ProductionLineDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      public ProductionLineDO build() {
         return new ProductionLineDO(this.factory, this.workshop, this.productionLine);
      }

      @Override
      public String toString() {
         return "ProductionLineDO.ProductionLineDOBuilder(factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ")";
      }
   }
}
