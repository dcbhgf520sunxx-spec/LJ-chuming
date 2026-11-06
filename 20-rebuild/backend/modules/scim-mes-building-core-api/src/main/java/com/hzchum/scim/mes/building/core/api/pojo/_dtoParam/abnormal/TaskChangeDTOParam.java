package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TaskChangeDTOParam", description = "")
public class TaskChangeDTOParam {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static TaskChangeDTOParam.TaskChangeDTOParamBuilder builder() {
      return new TaskChangeDTOParam.TaskChangeDTOParamBuilder();
   }

   public TaskChangeDTOParam(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public TaskChangeDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public TaskChangeDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public TaskChangeDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "TaskChangeDTOParam(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TaskChangeDTOParam)) {
         return false;
      } else {
         TaskChangeDTOParam other = (TaskChangeDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskChangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class TaskChangeDTOParamBuilder {
      private Long id;
      private Integer quantity;

      TaskChangeDTOParamBuilder() {
      }

      @JsonProperty("id")
      public TaskChangeDTOParam.TaskChangeDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public TaskChangeDTOParam.TaskChangeDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TaskChangeDTOParam build() {
         return new TaskChangeDTOParam(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "TaskChangeDTOParam.TaskChangeDTOParamBuilder(id=" + this.id + ", quantity=" + this.quantity + ")";
      }
   }
}
