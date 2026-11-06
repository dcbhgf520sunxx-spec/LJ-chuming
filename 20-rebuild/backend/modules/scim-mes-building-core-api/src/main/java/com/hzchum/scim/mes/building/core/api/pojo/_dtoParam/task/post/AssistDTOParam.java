package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AssistDTOParam", description = "")
public class AssistDTOParam {
   @ApiModelProperty(name = "id", notes = "任务工序详情id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productionLineId", notes = "协同生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "quantity", notes = "协同数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "numbers", notes = "一物一码号")
   @JsonProperty("numbers")
   @JSONField(name = "numbers")
   private List<Integer> numbers;
   @ApiModelProperty(name = "nextProcessIds", notes = "协同后续工序")
   @JsonProperty("nextProcessIds")
   @JSONField(name = "nextProcessIds")
   private List<Long> nextProcessIds;

   public static AssistDTOParam.AssistDTOParamBuilder builder() {
      return new AssistDTOParam.AssistDTOParamBuilder();
   }

   public AssistDTOParam() {
   }

   public AssistDTOParam(final Long id, final Long productionLineId, final Integer quantity, final List<Integer> numbers, final List<Long> nextProcessIds) {
      this.id = id;
      this.productionLineId = productionLineId;
      this.quantity = quantity;
      this.numbers = numbers;
      this.nextProcessIds = nextProcessIds;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<Long> getNextProcessIds() {
      return this.nextProcessIds;
   }

   @JsonProperty("id")
   public AssistDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productionLineId")
   public AssistDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("quantity")
   public AssistDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("numbers")
   public AssistDTOParam setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
      return this;
   }

   @JsonProperty("nextProcessIds")
   public AssistDTOParam setNextProcessIds(final List<Long> nextProcessIds) {
      this.nextProcessIds = nextProcessIds;
      return this;
   }

   @Override
   public String toString() {
      return "AssistDTOParam(id="
         + this.getId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", quantity="
         + this.getQuantity()
         + ", numbers="
         + this.getNumbers()
         + ", nextProcessIds="
         + this.getNextProcessIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssistDTOParam)) {
         return false;
      }

      AssistDTOParam other = (AssistDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$numbers = this.getNumbers();
               Object other$numbers = other.getNumbers();
               if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
                  Object this$nextProcessIds = this.getNextProcessIds();
                  Object other$nextProcessIds = other.getNextProcessIds();
                  return this$nextProcessIds == null ? other$nextProcessIds == null : this$nextProcessIds.equals(other$nextProcessIds);
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
      return other instanceof AssistDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $nextProcessIds = this.getNextProcessIds();
      return result * 59 + ($nextProcessIds == null ? 43 : $nextProcessIds.hashCode());
   }

   public static class AssistDTOParamBuilder {
      private Long id;
      private Long productionLineId;
      private Integer quantity;
      private List<Integer> numbers;
      private List<Long> nextProcessIds;

      AssistDTOParamBuilder() {
      }

      @JsonProperty("id")
      public AssistDTOParam.AssistDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productionLineId")
      public AssistDTOParam.AssistDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("quantity")
      public AssistDTOParam.AssistDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("numbers")
      public AssistDTOParam.AssistDTOParamBuilder numbers(final List<Integer> numbers) {
         this.numbers = numbers;
         return this;
      }

      @JsonProperty("nextProcessIds")
      public AssistDTOParam.AssistDTOParamBuilder nextProcessIds(final List<Long> nextProcessIds) {
         this.nextProcessIds = nextProcessIds;
         return this;
      }

      public AssistDTOParam build() {
         return new AssistDTOParam(this.id, this.productionLineId, this.quantity, this.numbers, this.nextProcessIds);
      }

      @Override
      public String toString() {
         return "AssistDTOParam.AssistDTOParamBuilder(id="
            + this.id
            + ", productionLineId="
            + this.productionLineId
            + ", quantity="
            + this.quantity
            + ", numbers="
            + this.numbers
            + ", nextProcessIds="
            + this.nextProcessIds
            + ")";
      }
   }
}
