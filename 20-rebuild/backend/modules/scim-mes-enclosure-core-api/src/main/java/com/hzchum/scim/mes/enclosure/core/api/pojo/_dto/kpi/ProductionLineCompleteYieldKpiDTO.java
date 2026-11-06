package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductionLineCompleteYieldKpiDO", description = "每月产量kpi")
public class ProductionLineCompleteYieldKpiDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名称", value = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "factoryName", notes = "工厂名", value = "工厂名")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
   @ApiModelProperty(name = "workshopName", notes = "车间名", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "lastMonthYield", notes = "上月产量", value = "上月产量")
   @JsonProperty("lastMonthYield")
   @JSONField(name = "lastMonthYield")
   private BigDecimal lastMonthYield;
   @ApiModelProperty(name = "yield", notes = "本月产量", value = "本月产量")
   @JsonProperty("yield")
   @JSONField(name = "yield")
   private BigDecimal yield;

   public static ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder builder() {
      return new ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder();
   }

   public ProductionLineCompleteYieldKpiDTO(
      final Long id,
      final String name,
      final Long factoryId,
      final Long workshopId,
      final String factoryName,
      final String workshopName,
      final BigDecimal lastMonthYield,
      final BigDecimal yield
   ) {
      this.id = id;
      this.name = name;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.factoryName = factoryName;
      this.workshopName = workshopName;
      this.lastMonthYield = lastMonthYield;
      this.yield = yield;
   }

   public ProductionLineCompleteYieldKpiDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public BigDecimal getLastMonthYield() {
      return this.lastMonthYield;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   @JsonProperty("id")
   public ProductionLineCompleteYieldKpiDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProductionLineCompleteYieldKpiDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("factoryId")
   public ProductionLineCompleteYieldKpiDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public ProductionLineCompleteYieldKpiDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("factoryName")
   public ProductionLineCompleteYieldKpiDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("workshopName")
   public ProductionLineCompleteYieldKpiDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("lastMonthYield")
   public ProductionLineCompleteYieldKpiDTO setLastMonthYield(final BigDecimal lastMonthYield) {
      this.lastMonthYield = lastMonthYield;
      return this;
   }

   @JsonProperty("yield")
   public ProductionLineCompleteYieldKpiDTO setYield(final BigDecimal yield) {
      this.yield = yield;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineCompleteYieldKpiDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", factoryName="
         + this.getFactoryName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", lastMonthYield="
         + this.getLastMonthYield()
         + ", yield="
         + this.getYield()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLineCompleteYieldKpiDTO)) {
         return false;
      }

      ProductionLineCompleteYieldKpiDTO other = (ProductionLineCompleteYieldKpiDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$factoryName = this.getFactoryName();
                  Object other$factoryName = other.getFactoryName();
                  if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                     Object this$workshopName = this.getWorkshopName();
                     Object other$workshopName = other.getWorkshopName();
                     if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                        Object this$lastMonthYield = this.getLastMonthYield();
                        Object other$lastMonthYield = other.getLastMonthYield();
                        if (this$lastMonthYield == null ? other$lastMonthYield == null : this$lastMonthYield.equals(other$lastMonthYield)) {
                           Object this$yield = this.getYield();
                           Object other$yield = other.getYield();
                           return this$yield == null ? other$yield == null : this$yield.equals(other$yield);
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
      return other instanceof ProductionLineCompleteYieldKpiDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $lastMonthYield = this.getLastMonthYield();
      result = result * 59 + ($lastMonthYield == null ? 43 : $lastMonthYield.hashCode());
      Object $yield = this.getYield();
      return result * 59 + ($yield == null ? 43 : $yield.hashCode());
   }

   public static class ProductionLineCompleteYieldKpiDTOBuilder {
      private Long id;
      private String name;
      private Long factoryId;
      private Long workshopId;
      private String factoryName;
      private String workshopName;
      private BigDecimal lastMonthYield;
      private BigDecimal yield;

      ProductionLineCompleteYieldKpiDTOBuilder() {
      }

      @JsonProperty("id")
      public ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("factoryId")
      public ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("factoryName")
      public ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopName")
      public ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("lastMonthYield")
      public ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder lastMonthYield(final BigDecimal lastMonthYield) {
         this.lastMonthYield = lastMonthYield;
         return this;
      }

      @JsonProperty("yield")
      public ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder yield(final BigDecimal yield) {
         this.yield = yield;
         return this;
      }

      public ProductionLineCompleteYieldKpiDTO build() {
         return new ProductionLineCompleteYieldKpiDTO(
            this.id, this.name, this.factoryId, this.workshopId, this.factoryName, this.workshopName, this.lastMonthYield, this.yield
         );
      }

      @Override
      public String toString() {
         return "ProductionLineCompleteYieldKpiDTO.ProductionLineCompleteYieldKpiDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", factoryName="
            + this.factoryName
            + ", workshopName="
            + this.workshopName
            + ", lastMonthYield="
            + this.lastMonthYield
            + ", yield="
            + this.yield
            + ")";
      }
   }
}
