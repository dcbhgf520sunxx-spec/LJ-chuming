package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssistDTOParam", description = "")
public class AssistDTOParam {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "groupsId", notes = "任务id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;

   public static AssistDTOParam.AssistDTOParamBuilder builder() {
      return new AssistDTOParam.AssistDTOParamBuilder();
   }

   public AssistDTOParam() {
   }

   public AssistDTOParam(final Long id, final Long groupsId) {
      this.id = id;
      this.groupsId = groupsId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   @JsonProperty("id")
   public AssistDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("groupsId")
   public AssistDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @Override
   public String toString() {
      return "AssistDTOParam(id=" + this.getId() + ", groupsId=" + this.getGroupsId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AssistDTOParam)) {
         return false;
      } else {
         AssistDTOParam other = (AssistDTOParam)o;
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
      return other instanceof AssistDTOParam;
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

   public static class AssistDTOParamBuilder {
      private Long id;
      private Long groupsId;

      AssistDTOParamBuilder() {
      }

      @JsonProperty("id")
      public AssistDTOParam.AssistDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("groupsId")
      public AssistDTOParam.AssistDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public AssistDTOParam build() {
         return new AssistDTOParam(this.id, this.groupsId);
      }

      @Override
      public String toString() {
         return "AssistDTOParam.AssistDTOParamBuilder(id=" + this.id + ", groupsId=" + this.groupsId + ")";
      }
   }
}
