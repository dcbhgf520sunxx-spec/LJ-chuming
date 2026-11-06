package com.hzchum.scim.mes.building.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InspectionTeamReportSummaryDO", description = "")
public class InspectionTeamReportSummaryDO {
   @ApiModelProperty(name = "userId", notes = "质检用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", notes = "用户名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "qhseQuantity", notes = "问题数量")
   @JsonProperty("qhseQuantity")
   @JSONField(name = "qhseQuantity")
   private Integer qhseQuantity;

   public static InspectionTeamReportSummaryDO.InspectionTeamReportSummaryDOBuilder builder() {
      return new InspectionTeamReportSummaryDO.InspectionTeamReportSummaryDOBuilder();
   }

   public InspectionTeamReportSummaryDO(final Long userId, final String userName, final Integer inspectionQuantity, final Integer qhseQuantity) {
      this.userId = userId;
      this.userName = userName;
      this.inspectionQuantity = inspectionQuantity;
      this.qhseQuantity = qhseQuantity;
   }

   public InspectionTeamReportSummaryDO() {
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getQhseQuantity() {
      return this.qhseQuantity;
   }

   @JsonProperty("userId")
   public InspectionTeamReportSummaryDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public InspectionTeamReportSummaryDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public InspectionTeamReportSummaryDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("qhseQuantity")
   public InspectionTeamReportSummaryDO setQhseQuantity(final Integer qhseQuantity) {
      this.qhseQuantity = qhseQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionTeamReportSummaryDO(userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", qhseQuantity="
         + this.getQhseQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionTeamReportSummaryDO)) {
         return false;
      }

      InspectionTeamReportSummaryDO other = (InspectionTeamReportSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$inspectionQuantity = this.getInspectionQuantity();
         Object other$inspectionQuantity = other.getInspectionQuantity();
         if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
            Object this$qhseQuantity = this.getQhseQuantity();
            Object other$qhseQuantity = other.getQhseQuantity();
            if (this$qhseQuantity == null ? other$qhseQuantity == null : this$qhseQuantity.equals(other$qhseQuantity)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionTeamReportSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $qhseQuantity = this.getQhseQuantity();
      result = result * 59 + ($qhseQuantity == null ? 43 : $qhseQuantity.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class InspectionTeamReportSummaryDOBuilder {
      private Long userId;
      private String userName;
      private Integer inspectionQuantity;
      private Integer qhseQuantity;

      InspectionTeamReportSummaryDOBuilder() {
      }

      @JsonProperty("userId")
      public InspectionTeamReportSummaryDO.InspectionTeamReportSummaryDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public InspectionTeamReportSummaryDO.InspectionTeamReportSummaryDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public InspectionTeamReportSummaryDO.InspectionTeamReportSummaryDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("qhseQuantity")
      public InspectionTeamReportSummaryDO.InspectionTeamReportSummaryDOBuilder qhseQuantity(final Integer qhseQuantity) {
         this.qhseQuantity = qhseQuantity;
         return this;
      }

      public InspectionTeamReportSummaryDO build() {
         return new InspectionTeamReportSummaryDO(this.userId, this.userName, this.inspectionQuantity, this.qhseQuantity);
      }

      @Override
      public String toString() {
         return "InspectionTeamReportSummaryDO.InspectionTeamReportSummaryDOBuilder(userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", qhseQuantity="
            + this.qhseQuantity
            + ")";
      }
   }
}
