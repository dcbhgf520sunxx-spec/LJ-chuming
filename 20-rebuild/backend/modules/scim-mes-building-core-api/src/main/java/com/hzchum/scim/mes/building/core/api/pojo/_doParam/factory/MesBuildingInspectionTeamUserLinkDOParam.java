package com.hzchum.scim.mes.building.core.api.pojo._doParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingInspectionTeamUserLinkDOParam对象", description = "")
public class MesBuildingInspectionTeamUserLinkDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "userId", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", notes = "用户id")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "inspectionTeamId", notes = "质检班组id")
   @JsonProperty("inspectionTeamId")
   @JSONField(name = "inspectionTeamId")
   private Long inspectionTeamId;

   public static MesBuildingInspectionTeamUserLinkDOParam.MesBuildingInspectionTeamUserLinkDOParamBuilder builder() {
      return new MesBuildingInspectionTeamUserLinkDOParam.MesBuildingInspectionTeamUserLinkDOParamBuilder();
   }

   public MesBuildingInspectionTeamUserLinkDOParam() {
   }

   public MesBuildingInspectionTeamUserLinkDOParam(final Long id, final Long userId, final String userName, final Long inspectionTeamId) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.inspectionTeamId = inspectionTeamId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getInspectionTeamId() {
      return this.inspectionTeamId;
   }

   @JsonProperty("id")
   public MesBuildingInspectionTeamUserLinkDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingInspectionTeamUserLinkDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingInspectionTeamUserLinkDOParam setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("inspectionTeamId")
   public MesBuildingInspectionTeamUserLinkDOParam setInspectionTeamId(final Long inspectionTeamId) {
      this.inspectionTeamId = inspectionTeamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingInspectionTeamUserLinkDOParam(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", inspectionTeamId="
         + this.getInspectionTeamId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingInspectionTeamUserLinkDOParam)) {
         return false;
      }

      MesBuildingInspectionTeamUserLinkDOParam other = (MesBuildingInspectionTeamUserLinkDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$inspectionTeamId = this.getInspectionTeamId();
            Object other$inspectionTeamId = other.getInspectionTeamId();
            if (this$inspectionTeamId == null ? other$inspectionTeamId == null : this$inspectionTeamId.equals(other$inspectionTeamId)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingInspectionTeamUserLinkDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $inspectionTeamId = this.getInspectionTeamId();
      result = result * 59 + ($inspectionTeamId == null ? 43 : $inspectionTeamId.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class MesBuildingInspectionTeamUserLinkDOParamBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Long inspectionTeamId;

      MesBuildingInspectionTeamUserLinkDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingInspectionTeamUserLinkDOParam.MesBuildingInspectionTeamUserLinkDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingInspectionTeamUserLinkDOParam.MesBuildingInspectionTeamUserLinkDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingInspectionTeamUserLinkDOParam.MesBuildingInspectionTeamUserLinkDOParamBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("inspectionTeamId")
      public MesBuildingInspectionTeamUserLinkDOParam.MesBuildingInspectionTeamUserLinkDOParamBuilder inspectionTeamId(final Long inspectionTeamId) {
         this.inspectionTeamId = inspectionTeamId;
         return this;
      }

      public MesBuildingInspectionTeamUserLinkDOParam build() {
         return new MesBuildingInspectionTeamUserLinkDOParam(this.id, this.userId, this.userName, this.inspectionTeamId);
      }

      @Override
      public String toString() {
         return "MesBuildingInspectionTeamUserLinkDOParam.MesBuildingInspectionTeamUserLinkDOParamBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", inspectionTeamId="
            + this.inspectionTeamId
            + ")";
      }
   }
}
