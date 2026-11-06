package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryTransferDTOParam {
   private List<LocalDateTime> createTime;
   private Integer basicClass;
   private Integer reviewStatus;
   private String serialNumber;
   private String operatorName;
   private Long sourceProjectId;
   private Long directionProjectId;
   private Integer transferType;
   private Integer transferCreateType;
   private String outboundSn;

   public static QueryTransferDTOParam.QueryTransferDTOParamBuilder builder() {
      return new QueryTransferDTOParam.QueryTransferDTOParamBuilder();
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Long getSourceProjectId() {
      return this.sourceProjectId;
   }

   public Long getDirectionProjectId() {
      return this.directionProjectId;
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public Integer getTransferCreateType() {
      return this.transferCreateType;
   }

   public String getOutboundSn() {
      return this.outboundSn;
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

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setSourceProjectId(final Long sourceProjectId) {
      this.sourceProjectId = sourceProjectId;
   }

   public void setDirectionProjectId(final Long directionProjectId) {
      this.directionProjectId = directionProjectId;
   }

   public void setTransferType(final Integer transferType) {
      this.transferType = transferType;
   }

   public void setTransferCreateType(final Integer transferCreateType) {
      this.transferCreateType = transferCreateType;
   }

   public void setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryTransferDTOParam)) {
         return false;
      }

      QueryTransferDTOParam other = (QueryTransferDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$sourceProjectId = this.getSourceProjectId();
            Object other$sourceProjectId = other.getSourceProjectId();
            if (this$sourceProjectId == null ? other$sourceProjectId == null : this$sourceProjectId.equals(other$sourceProjectId)) {
               Object this$directionProjectId = this.getDirectionProjectId();
               Object other$directionProjectId = other.getDirectionProjectId();
               if (this$directionProjectId == null ? other$directionProjectId == null : this$directionProjectId.equals(other$directionProjectId)) {
                  Object this$transferType = this.getTransferType();
                  Object other$transferType = other.getTransferType();
                  if (this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType)) {
                     Object this$transferCreateType = this.getTransferCreateType();
                     Object other$transferCreateType = other.getTransferCreateType();
                     if (this$transferCreateType == null ? other$transferCreateType == null : this$transferCreateType.equals(other$transferCreateType)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$operatorName = this.getOperatorName();
                              Object other$operatorName = other.getOperatorName();
                              if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                                 Object this$outboundSn = this.getOutboundSn();
                                 Object other$outboundSn = other.getOutboundSn();
                                 return this$outboundSn == null ? other$outboundSn == null : this$outboundSn.equals(other$outboundSn);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryTransferDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $sourceProjectId = this.getSourceProjectId();
      result = result * 59 + ($sourceProjectId == null ? 43 : $sourceProjectId.hashCode());
      Object $directionProjectId = this.getDirectionProjectId();
      result = result * 59 + ($directionProjectId == null ? 43 : $directionProjectId.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $transferCreateType = this.getTransferCreateType();
      result = result * 59 + ($transferCreateType == null ? 43 : $transferCreateType.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $outboundSn = this.getOutboundSn();
      return result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
   }

   @Override
   public String toString() {
      return "QueryTransferDTOParam(createTime="
         + this.getCreateTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", operatorName="
         + this.getOperatorName()
         + ", sourceProjectId="
         + this.getSourceProjectId()
         + ", directionProjectId="
         + this.getDirectionProjectId()
         + ", transferType="
         + this.getTransferType()
         + ", transferCreateType="
         + this.getTransferCreateType()
         + ", outboundSn="
         + this.getOutboundSn()
         + ")";
   }

   public QueryTransferDTOParam(
      final List<LocalDateTime> createTime,
      final Integer basicClass,
      final Integer reviewStatus,
      final String serialNumber,
      final String operatorName,
      final Long sourceProjectId,
      final Long directionProjectId,
      final Integer transferType,
      final Integer transferCreateType,
      final String outboundSn
   ) {
      this.createTime = createTime;
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.serialNumber = serialNumber;
      this.operatorName = operatorName;
      this.sourceProjectId = sourceProjectId;
      this.directionProjectId = directionProjectId;
      this.transferType = transferType;
      this.transferCreateType = transferCreateType;
      this.outboundSn = outboundSn;
   }

   public QueryTransferDTOParam() {
   }

   public static class QueryTransferDTOParamBuilder {
      private List<LocalDateTime> createTime;
      private Integer basicClass;
      private Integer reviewStatus;
      private String serialNumber;
      private String operatorName;
      private Long sourceProjectId;
      private Long directionProjectId;
      private Integer transferType;
      private Integer transferCreateType;
      private String outboundSn;

      QueryTransferDTOParamBuilder() {
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder sourceProjectId(final Long sourceProjectId) {
         this.sourceProjectId = sourceProjectId;
         return this;
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder directionProjectId(final Long directionProjectId) {
         this.directionProjectId = directionProjectId;
         return this;
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder transferCreateType(final Integer transferCreateType) {
         this.transferCreateType = transferCreateType;
         return this;
      }

      public QueryTransferDTOParam.QueryTransferDTOParamBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      public QueryTransferDTOParam build() {
         return new QueryTransferDTOParam(
            this.createTime,
            this.basicClass,
            this.reviewStatus,
            this.serialNumber,
            this.operatorName,
            this.sourceProjectId,
            this.directionProjectId,
            this.transferType,
            this.transferCreateType,
            this.outboundSn
         );
      }

      @Override
      public String toString() {
         return "QueryTransferDTOParam.QueryTransferDTOParamBuilder(createTime="
            + this.createTime
            + ", basicClass="
            + this.basicClass
            + ", reviewStatus="
            + this.reviewStatus
            + ", serialNumber="
            + this.serialNumber
            + ", operatorName="
            + this.operatorName
            + ", sourceProjectId="
            + this.sourceProjectId
            + ", directionProjectId="
            + this.directionProjectId
            + ", transferType="
            + this.transferType
            + ", transferCreateType="
            + this.transferCreateType
            + ", outboundSn="
            + this.outboundSn
            + ")";
      }
   }
}
