package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TaskChangeRequest", description = "")
public class TaskChangeRequest {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "groupsId", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @NotNull(message = "groupsId不能为空")
   private Long groupsId;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @Min(value = 1L, message = "最小值不能小于1")
   private Integer quantity;

   public Long getId() {
      return this.id;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public TaskChangeRequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("groupsId")
   public TaskChangeRequest setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("quantity")
   public TaskChangeRequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "TaskChangeRequest(id=" + this.getId() + ", groupsId=" + this.getGroupsId() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskChangeRequest)) {
         return false;
      }

      TaskChangeRequest other = (TaskChangeRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskChangeRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }
}
