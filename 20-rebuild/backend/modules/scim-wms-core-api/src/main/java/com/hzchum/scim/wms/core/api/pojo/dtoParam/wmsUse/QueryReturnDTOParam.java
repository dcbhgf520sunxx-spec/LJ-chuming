package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryReturnDTOParam {
   private List<LocalDateTime> createTime;
   private Integer basicClass;
   private Integer reviewStatus;
   private Integer projectWarehouseType;
   private String serialNumber;
   private String operatorName;
   private Boolean boolRealReturn;
   private Long projectId;

   public static QueryReturnDTOParam.QueryReturnDTOParamBuilder builder() {
      return new QueryReturnDTOParam.QueryReturnDTOParamBuilder();
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Boolean getBoolRealReturn() {
      return this.boolRealReturn;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setBoolRealReturn(final Boolean boolRealReturn) {
      this.boolRealReturn = boolRealReturn;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryReturnDTOParam)) {
         return false;
      }

      QueryReturnDTOParam other = (QueryReturnDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$projectWarehouseType = this.getProjectWarehouseType();
            Object other$projectWarehouseType = other.getProjectWarehouseType();
            if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
               Object this$boolRealReturn = this.getBoolRealReturn();
               Object other$boolRealReturn = other.getBoolRealReturn();
               if (this$boolRealReturn == null ? other$boolRealReturn == null : this$boolRealReturn.equals(other$boolRealReturn)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$operatorName = this.getOperatorName();
                           Object other$operatorName = other.getOperatorName();
                           return this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName);
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
      return other instanceof QueryReturnDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $boolRealReturn = this.getBoolRealReturn();
      result = result * 59 + ($boolRealReturn == null ? 43 : $boolRealReturn.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $operatorName = this.getOperatorName();
      return result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryReturnDTOParam(createTime="
         + this.getCreateTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", operatorName="
         + this.getOperatorName()
         + ", boolRealReturn="
         + this.getBoolRealReturn()
         + ", projectId="
         + this.getProjectId()
         + ")";
   }

   public QueryReturnDTOParam(
      final List<LocalDateTime> createTime,
      final Integer basicClass,
      final Integer reviewStatus,
      final Integer projectWarehouseType,
      final String serialNumber,
      final String operatorName,
      final Boolean boolRealReturn,
      final Long projectId
   ) {
      this.createTime = createTime;
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.projectWarehouseType = projectWarehouseType;
      this.serialNumber = serialNumber;
      this.operatorName = operatorName;
      this.boolRealReturn = boolRealReturn;
      this.projectId = projectId;
   }

   public QueryReturnDTOParam() {
   }

   public static class QueryReturnDTOParamBuilder {
      private List<LocalDateTime> createTime;
      private Integer basicClass;
      private Integer reviewStatus;
      private Integer projectWarehouseType;
      private String serialNumber;
      private String operatorName;
      private Boolean boolRealReturn;
      private Long projectId;

      QueryReturnDTOParamBuilder() {
      }

      public QueryReturnDTOParam.QueryReturnDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryReturnDTOParam.QueryReturnDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryReturnDTOParam.QueryReturnDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryReturnDTOParam.QueryReturnDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryReturnDTOParam.QueryReturnDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryReturnDTOParam.QueryReturnDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryReturnDTOParam.QueryReturnDTOParamBuilder boolRealReturn(final Boolean boolRealReturn) {
         this.boolRealReturn = boolRealReturn;
         return this;
      }

      public QueryReturnDTOParam.QueryReturnDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryReturnDTOParam build() {
         return new QueryReturnDTOParam(
            this.createTime,
            this.basicClass,
            this.reviewStatus,
            this.projectWarehouseType,
            this.serialNumber,
            this.operatorName,
            this.boolRealReturn,
            this.projectId
         );
      }

      @Override
      public String toString() {
         return "QueryReturnDTOParam.QueryReturnDTOParamBuilder(createTime="
            + this.createTime
            + ", basicClass="
            + this.basicClass
            + ", reviewStatus="
            + this.reviewStatus
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", serialNumber="
            + this.serialNumber
            + ", operatorName="
            + this.operatorName
            + ", boolRealReturn="
            + this.boolRealReturn
            + ", projectId="
            + this.projectId
            + ")";
      }
   }
}
