package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.inspectionTeam.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InspectionTeamUserLinkUpdateVORequest", description = "")
public class InspectionTeamUserLinkUpdateVORequest {
   @ApiModelProperty(name = "userId", notes = "用户id", value = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", notes = "用户名", value = "用户名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;

   public static InspectionTeamUserLinkUpdateVORequest.InspectionTeamUserLinkUpdateVORequestBuilder builder() {
      return new InspectionTeamUserLinkUpdateVORequest.InspectionTeamUserLinkUpdateVORequestBuilder();
   }

   public InspectionTeamUserLinkUpdateVORequest() {
   }

   public InspectionTeamUserLinkUpdateVORequest(final Long userId, final String userName) {
      this.userId = userId;
      this.userName = userName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   @JsonProperty("userId")
   public InspectionTeamUserLinkUpdateVORequest setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public InspectionTeamUserLinkUpdateVORequest setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof InspectionTeamUserLinkUpdateVORequest)) {
         return false;
      } else {
         InspectionTeamUserLinkUpdateVORequest other = (InspectionTeamUserLinkUpdateVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionTeamUserLinkUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionTeamUserLinkUpdateVORequest(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ")";
   }

   public static class InspectionTeamUserLinkUpdateVORequestBuilder {
      private Long userId;
      private String userName;

      InspectionTeamUserLinkUpdateVORequestBuilder() {
      }

      @JsonProperty("userId")
      public InspectionTeamUserLinkUpdateVORequest.InspectionTeamUserLinkUpdateVORequestBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public InspectionTeamUserLinkUpdateVORequest.InspectionTeamUserLinkUpdateVORequestBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public InspectionTeamUserLinkUpdateVORequest build() {
         return new InspectionTeamUserLinkUpdateVORequest(this.userId, this.userName);
      }

      @Override
      public String toString() {
         return "InspectionTeamUserLinkUpdateVORequest.InspectionTeamUserLinkUpdateVORequestBuilder(userId="
            + this.userId
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
