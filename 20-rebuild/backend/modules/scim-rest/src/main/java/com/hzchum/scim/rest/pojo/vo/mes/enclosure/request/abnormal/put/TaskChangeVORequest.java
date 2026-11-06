package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.abnormal.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TaskChangeVORequest", description = "")
public class TaskChangeVORequest {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "quantity", notes = "减少的数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static TaskChangeVORequest.TaskChangeVORequestBuilder builder() {
      return new TaskChangeVORequest.TaskChangeVORequestBuilder();
   }

   public TaskChangeVORequest(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public TaskChangeVORequest() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public TaskChangeVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public TaskChangeVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "TaskChangeVORequest(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TaskChangeVORequest)) {
         return false;
      } else {
         TaskChangeVORequest other = (TaskChangeVORequest)o;
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
      return other instanceof TaskChangeVORequest;
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

   public static class TaskChangeVORequestBuilder {
      private Long id;
      private Integer quantity;

      TaskChangeVORequestBuilder() {
      }

      @JsonProperty("id")
      public TaskChangeVORequest.TaskChangeVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public TaskChangeVORequest.TaskChangeVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TaskChangeVORequest build() {
         return new TaskChangeVORequest(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "TaskChangeVORequest.TaskChangeVORequestBuilder(id=" + this.id + ", quantity=" + this.quantity + ")";
      }
   }
}
