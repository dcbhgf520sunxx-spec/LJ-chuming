package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryShipmentReceiveApproveDTOParam {
   private List<LocalDateTime> createTimeList;
   private String applicantName;
   private Integer reviewStatus;

   public static QueryShipmentReceiveApproveDTOParam.QueryShipmentReceiveApproveDTOParamBuilder builder() {
      return new QueryShipmentReceiveApproveDTOParam.QueryShipmentReceiveApproveDTOParamBuilder();
   }

   public List<LocalDateTime> getCreateTimeList() {
      return this.createTimeList;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public void setCreateTimeList(final List<LocalDateTime> createTimeList) {
      this.createTimeList = createTimeList;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryShipmentReceiveApproveDTOParam)) {
         return false;
      }

      QueryShipmentReceiveApproveDTOParam other = (QueryShipmentReceiveApproveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reviewStatus = this.getReviewStatus();
      Object other$reviewStatus = other.getReviewStatus();
      if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
         Object this$createTimeList = this.getCreateTimeList();
         Object other$createTimeList = other.getCreateTimeList();
         if (this$createTimeList == null ? other$createTimeList == null : this$createTimeList.equals(other$createTimeList)) {
            Object this$applicantName = this.getApplicantName();
            Object other$applicantName = other.getApplicantName();
            return this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryShipmentReceiveApproveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $createTimeList = this.getCreateTimeList();
      result = result * 59 + ($createTimeList == null ? 43 : $createTimeList.hashCode());
      Object $applicantName = this.getApplicantName();
      return result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryShipmentReceiveApproveDTOParam(createTimeList="
         + this.getCreateTimeList()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   public QueryShipmentReceiveApproveDTOParam(final List<LocalDateTime> createTimeList, final String applicantName, final Integer reviewStatus) {
      this.createTimeList = createTimeList;
      this.applicantName = applicantName;
      this.reviewStatus = reviewStatus;
   }

   public QueryShipmentReceiveApproveDTOParam() {
   }

   public static class QueryShipmentReceiveApproveDTOParamBuilder {
      private List<LocalDateTime> createTimeList;
      private String applicantName;
      private Integer reviewStatus;

      QueryShipmentReceiveApproveDTOParamBuilder() {
      }

      public QueryShipmentReceiveApproveDTOParam.QueryShipmentReceiveApproveDTOParamBuilder createTimeList(final List<LocalDateTime> createTimeList) {
         this.createTimeList = createTimeList;
         return this;
      }

      public QueryShipmentReceiveApproveDTOParam.QueryShipmentReceiveApproveDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public QueryShipmentReceiveApproveDTOParam.QueryShipmentReceiveApproveDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryShipmentReceiveApproveDTOParam build() {
         return new QueryShipmentReceiveApproveDTOParam(this.createTimeList, this.applicantName, this.reviewStatus);
      }

      @Override
      public String toString() {
         return "QueryShipmentReceiveApproveDTOParam.QueryShipmentReceiveApproveDTOParamBuilder(createTimeList="
            + this.createTimeList
            + ", applicantName="
            + this.applicantName
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
