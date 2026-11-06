package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class QueryOutboundManufacturedDTOParam {
   @ApiModelProperty("出库单编号")
   private String serialNumber;
   @ApiModelProperty("领用人/申请人")
   private String personName;
   @ApiModelProperty("科目基础类型")
   private Integer basicClass;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("提交申请时间")
   private List<LocalDateTime> applicationTime;
   @ApiModelProperty("申请通过时间")
   private List<LocalDateTime> reviewPassTime;
   @ApiModelProperty("出库单审核状态")
   private Integer reviewStatus;
   @ApiModelProperty("规格")
   private String specification;

   public static QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder builder() {
      return new QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder();
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPersonName() {
      return this.personName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<LocalDateTime> getApplicationTime() {
      return this.applicationTime;
   }

   public List<LocalDateTime> getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getSpecification() {
      return this.specification;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPersonName(final String personName) {
      this.personName = personName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setApplicationTime(final List<LocalDateTime> applicationTime) {
      this.applicationTime = applicationTime;
   }

   public void setReviewPassTime(final List<LocalDateTime> reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryOutboundManufacturedDTOParam)) {
         return false;
      }

      QueryOutboundManufacturedDTOParam other = (QueryOutboundManufacturedDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$personName = this.getPersonName();
                  Object other$personName = other.getPersonName();
                  if (this$personName == null ? other$personName == null : this$personName.equals(other$personName)) {
                     Object this$applicationTime = this.getApplicationTime();
                     Object other$applicationTime = other.getApplicationTime();
                     if (this$applicationTime == null ? other$applicationTime == null : this$applicationTime.equals(other$applicationTime)) {
                        Object this$reviewPassTime = this.getReviewPassTime();
                        Object other$reviewPassTime = other.getReviewPassTime();
                        if (this$reviewPassTime == null ? other$reviewPassTime == null : this$reviewPassTime.equals(other$reviewPassTime)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           return this$specification == null ? other$specification == null : this$specification.equals(other$specification);
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
      return other instanceof QueryOutboundManufacturedDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $personName = this.getPersonName();
      result = result * 59 + ($personName == null ? 43 : $personName.hashCode());
      Object $applicationTime = this.getApplicationTime();
      result = result * 59 + ($applicationTime == null ? 43 : $applicationTime.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   @Override
   public String toString() {
      return "QueryOutboundManufacturedDTOParam(serialNumber="
         + this.getSerialNumber()
         + ", personName="
         + this.getPersonName()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectId="
         + this.getProjectId()
         + ", applicationTime="
         + this.getApplicationTime()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", specification="
         + this.getSpecification()
         + ")";
   }

   public QueryOutboundManufacturedDTOParam(
      final String serialNumber,
      final String personName,
      final Integer basicClass,
      final Long projectId,
      final List<LocalDateTime> applicationTime,
      final List<LocalDateTime> reviewPassTime,
      final Integer reviewStatus,
      final String specification
   ) {
      this.serialNumber = serialNumber;
      this.personName = personName;
      this.basicClass = basicClass;
      this.projectId = projectId;
      this.applicationTime = applicationTime;
      this.reviewPassTime = reviewPassTime;
      this.reviewStatus = reviewStatus;
      this.specification = specification;
   }

   public QueryOutboundManufacturedDTOParam() {
   }

   public static class QueryOutboundManufacturedDTOParamBuilder {
      private String serialNumber;
      private String personName;
      private Integer basicClass;
      private Long projectId;
      private List<LocalDateTime> applicationTime;
      private List<LocalDateTime> reviewPassTime;
      private Integer reviewStatus;
      private String specification;

      QueryOutboundManufacturedDTOParamBuilder() {
      }

      public QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder personName(final String personName) {
         this.personName = personName;
         return this;
      }

      public QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder applicationTime(final List<LocalDateTime> applicationTime) {
         this.applicationTime = applicationTime;
         return this;
      }

      public QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder reviewPassTime(final List<LocalDateTime> reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      public QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryOutboundManufacturedDTOParam build() {
         return new QueryOutboundManufacturedDTOParam(
            this.serialNumber,
            this.personName,
            this.basicClass,
            this.projectId,
            this.applicationTime,
            this.reviewPassTime,
            this.reviewStatus,
            this.specification
         );
      }

      @Override
      public String toString() {
         return "QueryOutboundManufacturedDTOParam.QueryOutboundManufacturedDTOParamBuilder(serialNumber="
            + this.serialNumber
            + ", personName="
            + this.personName
            + ", basicClass="
            + this.basicClass
            + ", projectId="
            + this.projectId
            + ", applicationTime="
            + this.applicationTime
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", reviewStatus="
            + this.reviewStatus
            + ", specification="
            + this.specification
            + ")";
      }
   }
}
