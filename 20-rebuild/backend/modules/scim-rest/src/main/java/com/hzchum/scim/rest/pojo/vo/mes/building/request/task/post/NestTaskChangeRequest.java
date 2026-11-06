package com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "NestTaskChangeRequest", description = "")
public class NestTaskChangeRequest {
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

   public Long getId() {
      return this.id;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   @JsonProperty("id")
   public NestTaskChangeRequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("groupsId")
   public NestTaskChangeRequest setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @Override
   public String toString() {
      return "NestTaskChangeRequest(id=" + this.getId() + ", groupsId=" + this.getGroupsId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof NestTaskChangeRequest)) {
         return false;
      } else {
         NestTaskChangeRequest other = (NestTaskChangeRequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$groupsId = this.getGroupsId();
               Object other$groupsId = other.getGroupsId();
               return this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NestTaskChangeRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $groupsId = this.getGroupsId();
      return result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
   }
}
