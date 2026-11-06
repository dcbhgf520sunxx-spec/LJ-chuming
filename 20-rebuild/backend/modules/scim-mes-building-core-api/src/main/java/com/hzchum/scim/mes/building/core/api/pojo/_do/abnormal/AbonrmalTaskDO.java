package com.hzchum.scim.mes.building.core.api.pojo._do.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AbonrmalTaskDO", description = "排产详情请求类")
public class AbonrmalTaskDO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productionLine", notes = "生产线信息")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "factory", notes = "工厂信息")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成时间")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private String askCompleteTime;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "inProductionQuantity", notes = "进入生产数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "quantity", notes = "清单数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static AbonrmalTaskDO.AbonrmalTaskDOBuilder builder() {
      return new AbonrmalTaskDO.AbonrmalTaskDOBuilder();
   }

   public AbonrmalTaskDO() {
   }

   public AbonrmalTaskDO(
      final Long id,
      final ProductionLineDetailDO productionLine,
      final FactoryDetailDO factory,
      final Integer taskQuantity,
      final String askCompleteTime,
      final Integer completeQuantity,
      final Integer inProductionQuantity,
      final Integer quantity
   ) {
      this.id = id;
      this.productionLine = productionLine;
      this.factory = factory;
      this.taskQuantity = taskQuantity;
      this.askCompleteTime = askCompleteTime;
      this.completeQuantity = completeQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public String getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public AbonrmalTaskDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productionLine")
   public AbonrmalTaskDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("factory")
   public AbonrmalTaskDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("taskQuantity")
   public AbonrmalTaskDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AbonrmalTaskDO setAskCompleteTime(final String askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeQuantity")
   public AbonrmalTaskDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public AbonrmalTaskDO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public AbonrmalTaskDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "AbonrmalTaskDO(id="
         + this.getId()
         + ", productionLine="
         + this.getProductionLine()
         + ", factory="
         + this.getFactory()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbonrmalTaskDO)) {
         return false;
      }

      AbonrmalTaskDO other = (AbonrmalTaskDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$inProductionQuantity = this.getInProductionQuantity();
               Object other$inProductionQuantity = other.getInProductionQuantity();
               if (this$inProductionQuantity == null ? other$inProductionQuantity == null : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$productionLine = this.getProductionLine();
                     Object other$productionLine = other.getProductionLine();
                     if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                        Object this$factory = this.getFactory();
                        Object other$factory = other.getFactory();
                        if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                           Object this$askCompleteTime = this.getAskCompleteTime();
                           Object other$askCompleteTime = other.getAskCompleteTime();
                           return this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof AbonrmalTaskDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   public static class AbonrmalTaskDOBuilder {
      private Long id;
      private ProductionLineDetailDO productionLine;
      private FactoryDetailDO factory;
      private Integer taskQuantity;
      private String askCompleteTime;
      private Integer completeQuantity;
      private Integer inProductionQuantity;
      private Integer quantity;

      AbonrmalTaskDOBuilder() {
      }

      @JsonProperty("id")
      public AbonrmalTaskDO.AbonrmalTaskDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productionLine")
      public AbonrmalTaskDO.AbonrmalTaskDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("factory")
      public AbonrmalTaskDO.AbonrmalTaskDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("taskQuantity")
      public AbonrmalTaskDO.AbonrmalTaskDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AbonrmalTaskDO.AbonrmalTaskDOBuilder askCompleteTime(final String askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeQuantity")
      public AbonrmalTaskDO.AbonrmalTaskDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public AbonrmalTaskDO.AbonrmalTaskDOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public AbonrmalTaskDO.AbonrmalTaskDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public AbonrmalTaskDO build() {
         return new AbonrmalTaskDO(
            this.id,
            this.productionLine,
            this.factory,
            this.taskQuantity,
            this.askCompleteTime,
            this.completeQuantity,
            this.inProductionQuantity,
            this.quantity
         );
      }

      @Override
      public String toString() {
         return "AbonrmalTaskDO.AbonrmalTaskDOBuilder(id="
            + this.id
            + ", productionLine="
            + this.productionLine
            + ", factory="
            + this.factory
            + ", taskQuantity="
            + this.taskQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeQuantity="
            + this.completeQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
