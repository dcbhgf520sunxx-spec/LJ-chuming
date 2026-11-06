package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.time.LocalDateTime;
import java.util.List;

public class QueryReportSurplusDTOParam {
   private Integer basicClass;
   private Boolean boolPartyA;
   private List<LocalDateTime> createTime;
   private List<LocalDateTime> reviewTime;
   private Long projectId;
   private String serialNumber;
   private String applicantName;
   private Integer reviewStatus;
   private Integer projectWarehouseType;
   private Long warehouseId;
   private List<Long> sourceWorkshopIds;
   private List<Long> classifyId;
   private List<Long> classifyIds;
   private String surplusSerialNumber;
   private String specification;
   private String brand;
   private String operatorName;

   public static QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder builder() {
      return new QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public List<LocalDateTime> getReviewTime() {
      return this.reviewTime;
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

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public List<Long> getSourceWorkshopIds() {
      return this.sourceWorkshopIds;
   }

   public List<Long> getClassifyId() {
      return this.classifyId;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public String getSurplusSerialNumber() {
      return this.surplusSerialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setReviewTime(final List<LocalDateTime> reviewTime) {
      this.reviewTime = reviewTime;
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

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setSourceWorkshopIds(final List<Long> sourceWorkshopIds) {
      this.sourceWorkshopIds = sourceWorkshopIds;
   }

   public void setClassifyId(final List<Long> classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setSurplusSerialNumber(final String surplusSerialNumber) {
      this.surplusSerialNumber = surplusSerialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryReportSurplusDTOParam)) {
         return false;
      }

      QueryReportSurplusDTOParam other = (QueryReportSurplusDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$boolPartyA = this.getBoolPartyA();
         Object other$boolPartyA = other.getBoolPartyA();
         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$projectWarehouseType = this.getProjectWarehouseType();
                  Object other$projectWarehouseType = other.getProjectWarehouseType();
                  if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                     Object this$warehouseId = this.getWarehouseId();
                     Object other$warehouseId = other.getWarehouseId();
                     if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$reviewTime = this.getReviewTime();
                           Object other$reviewTime = other.getReviewTime();
                           if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$applicantName = this.getApplicantName();
                                 Object other$applicantName = other.getApplicantName();
                                 if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                    Object this$sourceWorkshopIds = this.getSourceWorkshopIds();
                                    Object other$sourceWorkshopIds = other.getSourceWorkshopIds();
                                    if (this$sourceWorkshopIds == null
                                       ? other$sourceWorkshopIds == null
                                       : this$sourceWorkshopIds.equals(other$sourceWorkshopIds)) {
                                       Object this$classifyId = this.getClassifyId();
                                       Object other$classifyId = other.getClassifyId();
                                       if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                          Object this$classifyIds = this.getClassifyIds();
                                          Object other$classifyIds = other.getClassifyIds();
                                          if (this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds)) {
                                             Object this$surplusSerialNumber = this.getSurplusSerialNumber();
                                             Object other$surplusSerialNumber = other.getSurplusSerialNumber();
                                             if (this$surplusSerialNumber == null
                                                ? other$surplusSerialNumber == null
                                                : this$surplusSerialNumber.equals(other$surplusSerialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$brand = this.getBrand();
                                                   Object other$brand = other.getBrand();
                                                   if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                      Object this$operatorName = this.getOperatorName();
                                                      Object other$operatorName = other.getOperatorName();
                                                      return this$operatorName == null
                                                         ? other$operatorName == null
                                                         : this$operatorName.equals(other$operatorName);
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
      return other instanceof QueryReportSurplusDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $sourceWorkshopIds = this.getSourceWorkshopIds();
      result = result * 59 + ($sourceWorkshopIds == null ? 43 : $sourceWorkshopIds.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $surplusSerialNumber = this.getSurplusSerialNumber();
      result = result * 59 + ($surplusSerialNumber == null ? 43 : $surplusSerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $operatorName = this.getOperatorName();
      return result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryReportSurplusDTOParam(basicClass="
         + this.getBasicClass()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewTime="
         + this.getReviewTime()
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
         + ", warehouseId="
         + this.getWarehouseId()
         + ", sourceWorkshopIds="
         + this.getSourceWorkshopIds()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", surplusSerialNumber="
         + this.getSurplusSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", brand="
         + this.getBrand()
         + ", operatorName="
         + this.getOperatorName()
         + ")";
   }

   public QueryReportSurplusDTOParam(
      final Integer basicClass,
      final Boolean boolPartyA,
      final List<LocalDateTime> createTime,
      final List<LocalDateTime> reviewTime,
      final Long projectId,
      final String serialNumber,
      final String applicantName,
      final Integer reviewStatus,
      final Integer projectWarehouseType,
      final Long warehouseId,
      final List<Long> sourceWorkshopIds,
      final List<Long> classifyId,
      final List<Long> classifyIds,
      final String surplusSerialNumber,
      final String specification,
      final String brand,
      final String operatorName
   ) {
      this.basicClass = basicClass;
      this.boolPartyA = boolPartyA;
      this.createTime = createTime;
      this.reviewTime = reviewTime;
      this.projectId = projectId;
      this.serialNumber = serialNumber;
      this.applicantName = applicantName;
      this.reviewStatus = reviewStatus;
      this.projectWarehouseType = projectWarehouseType;
      this.warehouseId = warehouseId;
      this.sourceWorkshopIds = sourceWorkshopIds;
      this.classifyId = classifyId;
      this.classifyIds = classifyIds;
      this.surplusSerialNumber = surplusSerialNumber;
      this.specification = specification;
      this.brand = brand;
      this.operatorName = operatorName;
   }

   public QueryReportSurplusDTOParam() {
   }

   public static class QueryReportSurplusDTOParamBuilder {
      private Integer basicClass;
      private Boolean boolPartyA;
      private List<LocalDateTime> createTime;
      private List<LocalDateTime> reviewTime;
      private Long projectId;
      private String serialNumber;
      private String applicantName;
      private Integer reviewStatus;
      private Integer projectWarehouseType;
      private Long warehouseId;
      private List<Long> sourceWorkshopIds;
      private List<Long> classifyId;
      private List<Long> classifyIds;
      private String surplusSerialNumber;
      private String specification;
      private String brand;
      private String operatorName;

      QueryReportSurplusDTOParamBuilder() {
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder reviewTime(final List<LocalDateTime> reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder sourceWorkshopIds(final List<Long> sourceWorkshopIds) {
         this.sourceWorkshopIds = sourceWorkshopIds;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder classifyId(final List<Long> classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder surplusSerialNumber(final String surplusSerialNumber) {
         this.surplusSerialNumber = surplusSerialNumber;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryReportSurplusDTOParam build() {
         return new QueryReportSurplusDTOParam(
            this.basicClass,
            this.boolPartyA,
            this.createTime,
            this.reviewTime,
            this.projectId,
            this.serialNumber,
            this.applicantName,
            this.reviewStatus,
            this.projectWarehouseType,
            this.warehouseId,
            this.sourceWorkshopIds,
            this.classifyId,
            this.classifyIds,
            this.surplusSerialNumber,
            this.specification,
            this.brand,
            this.operatorName
         );
      }

      @Override
      public String toString() {
         return "QueryReportSurplusDTOParam.QueryReportSurplusDTOParamBuilder(basicClass="
            + this.basicClass
            + ", boolPartyA="
            + this.boolPartyA
            + ", createTime="
            + this.createTime
            + ", reviewTime="
            + this.reviewTime
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
            + ", warehouseId="
            + this.warehouseId
            + ", sourceWorkshopIds="
            + this.sourceWorkshopIds
            + ", classifyId="
            + this.classifyId
            + ", classifyIds="
            + this.classifyIds
            + ", surplusSerialNumber="
            + this.surplusSerialNumber
            + ", specification="
            + this.specification
            + ", brand="
            + this.brand
            + ", operatorName="
            + this.operatorName
            + ")";
      }
   }
}
