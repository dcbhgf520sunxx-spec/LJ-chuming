package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.time.LocalDateTime;
import java.util.List;

public class QueryReportDeficitDTOParam {
   private Integer basicClass;
   private List<LocalDateTime> createTime;
   private Integer deficitType;
   private Integer warehouseType;
   private Long projectId;
   private String serialNumber;
   private String applicantName;
   private Integer reviewStatus;
   private Integer projectWarehouseType;

   public static QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder builder() {
      return new QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Integer getDeficitType() {
      return this.deficitType;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setDeficitType(final Integer deficitType) {
      this.deficitType = deficitType;
   }

   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryReportDeficitDTOParam)) {
         return false;
      }

      QueryReportDeficitDTOParam other = (QueryReportDeficitDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$deficitType = this.getDeficitType();
         Object other$deficitType = other.getDeficitType();
         if (this$deficitType == null ? other$deficitType == null : this$deficitType.equals(other$deficitType)) {
            Object this$warehouseType = this.getWarehouseType();
            Object other$warehouseType = other.getWarehouseType();
            if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$reviewStatus = this.getReviewStatus();
                  Object other$reviewStatus = other.getReviewStatus();
                  if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                     Object this$projectWarehouseType = this.getProjectWarehouseType();
                     Object other$projectWarehouseType = other.getProjectWarehouseType();
                     if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$applicantName = this.getApplicantName();
                              Object other$applicantName = other.getApplicantName();
                              return this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName);
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
      return other instanceof QueryReportDeficitDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $deficitType = this.getDeficitType();
      result = result * 59 + ($deficitType == null ? 43 : $deficitType.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      return result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryReportDeficitDTOParam(basicClass="
         + this.getBasicClass()
         + ", createTime="
         + this.getCreateTime()
         + ", deficitType="
         + this.getDeficitType()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ")";
   }

   public QueryReportDeficitDTOParam(
      final Integer basicClass,
      final List<LocalDateTime> createTime,
      final Integer deficitType,
      final Integer warehouseType,
      final Long projectId,
      final String serialNumber,
      final String applicantName,
      final Integer reviewStatus,
      final Integer projectWarehouseType
   ) {
      this.basicClass = basicClass;
      this.createTime = createTime;
      this.deficitType = deficitType;
      this.warehouseType = warehouseType;
      this.projectId = projectId;
      this.serialNumber = serialNumber;
      this.applicantName = applicantName;
      this.reviewStatus = reviewStatus;
      this.projectWarehouseType = projectWarehouseType;
   }

   public QueryReportDeficitDTOParam() {
   }

   public static class QueryReportDeficitDTOParamBuilder {
      private Integer basicClass;
      private List<LocalDateTime> createTime;
      private Integer deficitType;
      private Integer warehouseType;
      private Long projectId;
      private String serialNumber;
      private String applicantName;
      private Integer reviewStatus;
      private Integer projectWarehouseType;

      QueryReportDeficitDTOParamBuilder() {
      }

      public QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder deficitType(final Integer deficitType) {
         this.deficitType = deficitType;
         return this;
      }

      public QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryReportDeficitDTOParam build() {
         return new QueryReportDeficitDTOParam(
            this.basicClass,
            this.createTime,
            this.deficitType,
            this.warehouseType,
            this.projectId,
            this.serialNumber,
            this.applicantName,
            this.reviewStatus,
            this.projectWarehouseType
         );
      }

      @Override
      public String toString() {
         return "QueryReportDeficitDTOParam.QueryReportDeficitDTOParamBuilder(basicClass="
            + this.basicClass
            + ", createTime="
            + this.createTime
            + ", deficitType="
            + this.deficitType
            + ", warehouseType="
            + this.warehouseType
            + ", projectId="
            + this.projectId
            + ", serialNumber="
            + this.serialNumber
            + ", applicantName="
            + this.applicantName
            + ", reviewStatus="
            + this.reviewStatus
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ")";
      }
   }
}
