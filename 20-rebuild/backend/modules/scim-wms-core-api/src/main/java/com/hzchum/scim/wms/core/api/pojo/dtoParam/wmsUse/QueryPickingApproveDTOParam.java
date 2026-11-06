package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryPickingApproveDTOParam {
   private List<LocalDateTime> createTimeList;
   private String serialNumber;
   private String taskOrderNumber;
   private String applicationName;
   private Integer reviewStatus;

   public static QueryPickingApproveDTOParam.QueryPickingApproveDTOParamBuilder builder() {
      return new QueryPickingApproveDTOParam.QueryPickingApproveDTOParamBuilder();
   }

   public List<LocalDateTime> getCreateTimeList() {
      return this.createTimeList;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public String getApplicationName() {
      return this.applicationName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public void setCreateTimeList(final List<LocalDateTime> createTimeList) {
      this.createTimeList = createTimeList;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setApplicationName(final String applicationName) {
      this.applicationName = applicationName;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryPickingApproveDTOParam)) {
         return false;
      }

      QueryPickingApproveDTOParam other = (QueryPickingApproveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reviewStatus = this.getReviewStatus();
      Object other$reviewStatus = other.getReviewStatus();
      if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
         Object this$createTimeList = this.getCreateTimeList();
         Object other$createTimeList = other.getCreateTimeList();
         if (this$createTimeList == null ? other$createTimeList == null : this$createTimeList.equals(other$createTimeList)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$taskOrderNumber = this.getTaskOrderNumber();
               Object other$taskOrderNumber = other.getTaskOrderNumber();
               if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                  Object this$applicationName = this.getApplicationName();
                  Object other$applicationName = other.getApplicationName();
                  return this$applicationName == null ? other$applicationName == null : this$applicationName.equals(other$applicationName);
               } else {
                  return false;
               }
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
      return other instanceof QueryPickingApproveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $createTimeList = this.getCreateTimeList();
      result = result * 59 + ($createTimeList == null ? 43 : $createTimeList.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $applicationName = this.getApplicationName();
      return result * 59 + ($applicationName == null ? 43 : $applicationName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryPickingApproveDTOParam(createTimeList="
         + this.getCreateTimeList()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", applicationName="
         + this.getApplicationName()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   public QueryPickingApproveDTOParam(
      final List<LocalDateTime> createTimeList,
      final String serialNumber,
      final String taskOrderNumber,
      final String applicationName,
      final Integer reviewStatus
   ) {
      this.createTimeList = createTimeList;
      this.serialNumber = serialNumber;
      this.taskOrderNumber = taskOrderNumber;
      this.applicationName = applicationName;
      this.reviewStatus = reviewStatus;
   }

   public QueryPickingApproveDTOParam() {
   }

   public static class QueryPickingApproveDTOParamBuilder {
      private List<LocalDateTime> createTimeList;
      private String serialNumber;
      private String taskOrderNumber;
      private String applicationName;
      private Integer reviewStatus;

      QueryPickingApproveDTOParamBuilder() {
      }

      public QueryPickingApproveDTOParam.QueryPickingApproveDTOParamBuilder createTimeList(final List<LocalDateTime> createTimeList) {
         this.createTimeList = createTimeList;
         return this;
      }

      public QueryPickingApproveDTOParam.QueryPickingApproveDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryPickingApproveDTOParam.QueryPickingApproveDTOParamBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public QueryPickingApproveDTOParam.QueryPickingApproveDTOParamBuilder applicationName(final String applicationName) {
         this.applicationName = applicationName;
         return this;
      }

      public QueryPickingApproveDTOParam.QueryPickingApproveDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryPickingApproveDTOParam build() {
         return new QueryPickingApproveDTOParam(this.createTimeList, this.serialNumber, this.taskOrderNumber, this.applicationName, this.reviewStatus);
      }

      @Override
      public String toString() {
         return "QueryPickingApproveDTOParam.QueryPickingApproveDTOParamBuilder(createTimeList="
            + this.createTimeList
            + ", serialNumber="
            + this.serialNumber
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", applicationName="
            + this.applicationName
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
