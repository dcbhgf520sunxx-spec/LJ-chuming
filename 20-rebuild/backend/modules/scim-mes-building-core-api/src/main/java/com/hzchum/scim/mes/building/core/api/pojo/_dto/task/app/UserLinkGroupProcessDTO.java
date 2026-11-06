package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "UserLinkGroupProcessDTO", description = "产组及其相关工序ID")
public class UserLinkGroupProcessDTO {
   @ApiModelProperty(name = "groupId", notes = "生产组ID")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   private Long groupId;
   @ApiModelProperty(name = "processIds", notes = "工序Id")
   @JsonProperty("processIds")
   @JSONField(name = "processIds")
   private List<Long> processIds;

   public static UserLinkGroupProcessDTO.UserLinkGroupProcessDTOBuilder builder() {
      return new UserLinkGroupProcessDTO.UserLinkGroupProcessDTOBuilder();
   }

   public UserLinkGroupProcessDTO() {
   }

   public UserLinkGroupProcessDTO(final Long groupId, final List<Long> processIds) {
      this.groupId = groupId;
      this.processIds = processIds;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public List<Long> getProcessIds() {
      return this.processIds;
   }

   @JsonProperty("groupId")
   public UserLinkGroupProcessDTO setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   @JsonProperty("processIds")
   public UserLinkGroupProcessDTO setProcessIds(final List<Long> processIds) {
      this.processIds = processIds;
      return this;
   }

   @Override
   public String toString() {
      return "UserLinkGroupProcessDTO(groupId=" + this.getGroupId() + ", processIds=" + this.getProcessIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UserLinkGroupProcessDTO)) {
         return false;
      } else {
         UserLinkGroupProcessDTO other = (UserLinkGroupProcessDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$groupId = this.getGroupId();
            Object other$groupId = other.getGroupId();
            if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
               Object this$processIds = this.getProcessIds();
               Object other$processIds = other.getProcessIds();
               return this$processIds == null ? other$processIds == null : this$processIds.equals(other$processIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserLinkGroupProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $processIds = this.getProcessIds();
      return result * 59 + ($processIds == null ? 43 : $processIds.hashCode());
   }

   public static class UserLinkGroupProcessDTOBuilder {
      private Long groupId;
      private List<Long> processIds;

      UserLinkGroupProcessDTOBuilder() {
      }

      @JsonProperty("groupId")
      public UserLinkGroupProcessDTO.UserLinkGroupProcessDTOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      @JsonProperty("processIds")
      public UserLinkGroupProcessDTO.UserLinkGroupProcessDTOBuilder processIds(final List<Long> processIds) {
         this.processIds = processIds;
         return this;
      }

      public UserLinkGroupProcessDTO build() {
         return new UserLinkGroupProcessDTO(this.groupId, this.processIds);
      }

      @Override
      public String toString() {
         return "UserLinkGroupProcessDTO.UserLinkGroupProcessDTOBuilder(groupId=" + this.groupId + ", processIds=" + this.processIds + ")";
      }
   }
}
