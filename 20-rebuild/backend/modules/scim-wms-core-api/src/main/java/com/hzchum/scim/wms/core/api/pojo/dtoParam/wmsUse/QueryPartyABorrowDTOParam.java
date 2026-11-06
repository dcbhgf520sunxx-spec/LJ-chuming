package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryPartyABorrowDTOParam {
   private Integer returnStatus;
   private List<LocalDateTime> transferTime;
   private Long projectId;
   private Long borrowProjectId;
   private Integer basicClass;
   private String transferSN;
   private String operatorName;

   public static QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder builder() {
      return new QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder();
   }

   public Integer getReturnStatus() {
      return this.returnStatus;
   }

   public List<LocalDateTime> getTransferTime() {
      return this.transferTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getBorrowProjectId() {
      return this.borrowProjectId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getTransferSN() {
      return this.transferSN;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public void setReturnStatus(final Integer returnStatus) {
      this.returnStatus = returnStatus;
   }

   public void setTransferTime(final List<LocalDateTime> transferTime) {
      this.transferTime = transferTime;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBorrowProjectId(final Long borrowProjectId) {
      this.borrowProjectId = borrowProjectId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setTransferSN(final String transferSN) {
      this.transferSN = transferSN;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryPartyABorrowDTOParam)) {
         return false;
      }

      QueryPartyABorrowDTOParam other = (QueryPartyABorrowDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$returnStatus = this.getReturnStatus();
      Object other$returnStatus = other.getReturnStatus();
      if (this$returnStatus == null ? other$returnStatus == null : this$returnStatus.equals(other$returnStatus)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$borrowProjectId = this.getBorrowProjectId();
            Object other$borrowProjectId = other.getBorrowProjectId();
            if (this$borrowProjectId == null ? other$borrowProjectId == null : this$borrowProjectId.equals(other$borrowProjectId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$transferTime = this.getTransferTime();
                  Object other$transferTime = other.getTransferTime();
                  if (this$transferTime == null ? other$transferTime == null : this$transferTime.equals(other$transferTime)) {
                     Object this$transferSN = this.getTransferSN();
                     Object other$transferSN = other.getTransferSN();
                     if (this$transferSN == null ? other$transferSN == null : this$transferSN.equals(other$transferSN)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryPartyABorrowDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $returnStatus = this.getReturnStatus();
      result = result * 59 + ($returnStatus == null ? 43 : $returnStatus.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $borrowProjectId = this.getBorrowProjectId();
      result = result * 59 + ($borrowProjectId == null ? 43 : $borrowProjectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $transferTime = this.getTransferTime();
      result = result * 59 + ($transferTime == null ? 43 : $transferTime.hashCode());
      Object $transferSN = this.getTransferSN();
      result = result * 59 + ($transferSN == null ? 43 : $transferSN.hashCode());
      Object $operatorName = this.getOperatorName();
      return result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryPartyABorrowDTOParam(returnStatus="
         + this.getReturnStatus()
         + ", transferTime="
         + this.getTransferTime()
         + ", projectId="
         + this.getProjectId()
         + ", borrowProjectId="
         + this.getBorrowProjectId()
         + ", basicClass="
         + this.getBasicClass()
         + ", transferSN="
         + this.getTransferSN()
         + ", operatorName="
         + this.getOperatorName()
         + ")";
   }

   public QueryPartyABorrowDTOParam(
      final Integer returnStatus,
      final List<LocalDateTime> transferTime,
      final Long projectId,
      final Long borrowProjectId,
      final Integer basicClass,
      final String transferSN,
      final String operatorName
   ) {
      this.returnStatus = returnStatus;
      this.transferTime = transferTime;
      this.projectId = projectId;
      this.borrowProjectId = borrowProjectId;
      this.basicClass = basicClass;
      this.transferSN = transferSN;
      this.operatorName = operatorName;
   }

   public QueryPartyABorrowDTOParam() {
   }

   public static class QueryPartyABorrowDTOParamBuilder {
      private Integer returnStatus;
      private List<LocalDateTime> transferTime;
      private Long projectId;
      private Long borrowProjectId;
      private Integer basicClass;
      private String transferSN;
      private String operatorName;

      QueryPartyABorrowDTOParamBuilder() {
      }

      public QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder returnStatus(final Integer returnStatus) {
         this.returnStatus = returnStatus;
         return this;
      }

      public QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder transferTime(final List<LocalDateTime> transferTime) {
         this.transferTime = transferTime;
         return this;
      }

      public QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder borrowProjectId(final Long borrowProjectId) {
         this.borrowProjectId = borrowProjectId;
         return this;
      }

      public QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder transferSN(final String transferSN) {
         this.transferSN = transferSN;
         return this;
      }

      public QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryPartyABorrowDTOParam build() {
         return new QueryPartyABorrowDTOParam(
            this.returnStatus, this.transferTime, this.projectId, this.borrowProjectId, this.basicClass, this.transferSN, this.operatorName
         );
      }

      @Override
      public String toString() {
         return "QueryPartyABorrowDTOParam.QueryPartyABorrowDTOParamBuilder(returnStatus="
            + this.returnStatus
            + ", transferTime="
            + this.transferTime
            + ", projectId="
            + this.projectId
            + ", borrowProjectId="
            + this.borrowProjectId
            + ", basicClass="
            + this.basicClass
            + ", transferSN="
            + this.transferSN
            + ", operatorName="
            + this.operatorName
            + ")";
      }
   }
}
