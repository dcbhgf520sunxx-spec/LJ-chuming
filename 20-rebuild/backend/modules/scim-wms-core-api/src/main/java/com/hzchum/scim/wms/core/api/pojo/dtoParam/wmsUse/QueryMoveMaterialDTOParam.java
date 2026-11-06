package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryMoveMaterialDTOParam {
   private List<LocalDateTime> startAndEndTime;
   private Integer basicClass;
   private Integer reviewStatus;
   private String serialNumber;
   private String operatorName;
   private List<Long> projectIds;
   private List<Long> sourceWarehouseIds;
   private List<Long> directionWarehouseIds;
   private List<Long> sourceWorkshopIds;
   private List<Long> directionWorkshopIds;
   private Boolean boolPartyA;

   public static QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder builder() {
      return new QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder();
   }

   public List<LocalDateTime> getStartAndEndTime() {
      return this.startAndEndTime;
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

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public List<Long> getSourceWarehouseIds() {
      return this.sourceWarehouseIds;
   }

   public List<Long> getDirectionWarehouseIds() {
      return this.directionWarehouseIds;
   }

   public List<Long> getSourceWorkshopIds() {
      return this.sourceWorkshopIds;
   }

   public List<Long> getDirectionWorkshopIds() {
      return this.directionWorkshopIds;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public void setStartAndEndTime(final List<LocalDateTime> startAndEndTime) {
      this.startAndEndTime = startAndEndTime;
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

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setSourceWarehouseIds(final List<Long> sourceWarehouseIds) {
      this.sourceWarehouseIds = sourceWarehouseIds;
   }

   public void setDirectionWarehouseIds(final List<Long> directionWarehouseIds) {
      this.directionWarehouseIds = directionWarehouseIds;
   }

   public void setSourceWorkshopIds(final List<Long> sourceWorkshopIds) {
      this.sourceWorkshopIds = sourceWorkshopIds;
   }

   public void setDirectionWorkshopIds(final List<Long> directionWorkshopIds) {
      this.directionWorkshopIds = directionWorkshopIds;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryMoveMaterialDTOParam)) {
         return false;
      }

      QueryMoveMaterialDTOParam other = (QueryMoveMaterialDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$startAndEndTime = this.getStartAndEndTime();
               Object other$startAndEndTime = other.getStartAndEndTime();
               if (this$startAndEndTime == null ? other$startAndEndTime == null : this$startAndEndTime.equals(other$startAndEndTime)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$operatorName = this.getOperatorName();
                     Object other$operatorName = other.getOperatorName();
                     if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                        Object this$projectIds = this.getProjectIds();
                        Object other$projectIds = other.getProjectIds();
                        if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                           Object this$sourceWarehouseIds = this.getSourceWarehouseIds();
                           Object other$sourceWarehouseIds = other.getSourceWarehouseIds();
                           if (this$sourceWarehouseIds == null ? other$sourceWarehouseIds == null : this$sourceWarehouseIds.equals(other$sourceWarehouseIds)) {
                              Object this$directionWarehouseIds = this.getDirectionWarehouseIds();
                              Object other$directionWarehouseIds = other.getDirectionWarehouseIds();
                              if (this$directionWarehouseIds == null
                                 ? other$directionWarehouseIds == null
                                 : this$directionWarehouseIds.equals(other$directionWarehouseIds)) {
                                 Object this$sourceWorkshopIds = this.getSourceWorkshopIds();
                                 Object other$sourceWorkshopIds = other.getSourceWorkshopIds();
                                 if (this$sourceWorkshopIds == null ? other$sourceWorkshopIds == null : this$sourceWorkshopIds.equals(other$sourceWorkshopIds)) {
                                    Object this$directionWorkshopIds = this.getDirectionWorkshopIds();
                                    Object other$directionWorkshopIds = other.getDirectionWorkshopIds();
                                    return this$directionWorkshopIds == null
                                       ? other$directionWorkshopIds == null
                                       : this$directionWorkshopIds.equals(other$directionWorkshopIds);
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
      return other instanceof QueryMoveMaterialDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $startAndEndTime = this.getStartAndEndTime();
      result = result * 59 + ($startAndEndTime == null ? 43 : $startAndEndTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $sourceWarehouseIds = this.getSourceWarehouseIds();
      result = result * 59 + ($sourceWarehouseIds == null ? 43 : $sourceWarehouseIds.hashCode());
      Object $directionWarehouseIds = this.getDirectionWarehouseIds();
      result = result * 59 + ($directionWarehouseIds == null ? 43 : $directionWarehouseIds.hashCode());
      Object $sourceWorkshopIds = this.getSourceWorkshopIds();
      result = result * 59 + ($sourceWorkshopIds == null ? 43 : $sourceWorkshopIds.hashCode());
      Object $directionWorkshopIds = this.getDirectionWorkshopIds();
      return result * 59 + ($directionWorkshopIds == null ? 43 : $directionWorkshopIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryMoveMaterialDTOParam(startAndEndTime="
         + this.getStartAndEndTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", operatorName="
         + this.getOperatorName()
         + ", projectIds="
         + this.getProjectIds()
         + ", sourceWarehouseIds="
         + this.getSourceWarehouseIds()
         + ", directionWarehouseIds="
         + this.getDirectionWarehouseIds()
         + ", sourceWorkshopIds="
         + this.getSourceWorkshopIds()
         + ", directionWorkshopIds="
         + this.getDirectionWorkshopIds()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ")";
   }

   public QueryMoveMaterialDTOParam(
      final List<LocalDateTime> startAndEndTime,
      final Integer basicClass,
      final Integer reviewStatus,
      final String serialNumber,
      final String operatorName,
      final List<Long> projectIds,
      final List<Long> sourceWarehouseIds,
      final List<Long> directionWarehouseIds,
      final List<Long> sourceWorkshopIds,
      final List<Long> directionWorkshopIds,
      final Boolean boolPartyA
   ) {
      this.startAndEndTime = startAndEndTime;
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.serialNumber = serialNumber;
      this.operatorName = operatorName;
      this.projectIds = projectIds;
      this.sourceWarehouseIds = sourceWarehouseIds;
      this.directionWarehouseIds = directionWarehouseIds;
      this.sourceWorkshopIds = sourceWorkshopIds;
      this.directionWorkshopIds = directionWorkshopIds;
      this.boolPartyA = boolPartyA;
   }

   public QueryMoveMaterialDTOParam() {
   }

   public static class QueryMoveMaterialDTOParamBuilder {
      private List<LocalDateTime> startAndEndTime;
      private Integer basicClass;
      private Integer reviewStatus;
      private String serialNumber;
      private String operatorName;
      private List<Long> projectIds;
      private List<Long> sourceWarehouseIds;
      private List<Long> directionWarehouseIds;
      private List<Long> sourceWorkshopIds;
      private List<Long> directionWorkshopIds;
      private Boolean boolPartyA;

      QueryMoveMaterialDTOParamBuilder() {
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder startAndEndTime(final List<LocalDateTime> startAndEndTime) {
         this.startAndEndTime = startAndEndTime;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder sourceWarehouseIds(final List<Long> sourceWarehouseIds) {
         this.sourceWarehouseIds = sourceWarehouseIds;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder directionWarehouseIds(final List<Long> directionWarehouseIds) {
         this.directionWarehouseIds = directionWarehouseIds;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder sourceWorkshopIds(final List<Long> sourceWorkshopIds) {
         this.sourceWorkshopIds = sourceWorkshopIds;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder directionWorkshopIds(final List<Long> directionWorkshopIds) {
         this.directionWorkshopIds = directionWorkshopIds;
         return this;
      }

      public QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public QueryMoveMaterialDTOParam build() {
         return new QueryMoveMaterialDTOParam(
            this.startAndEndTime,
            this.basicClass,
            this.reviewStatus,
            this.serialNumber,
            this.operatorName,
            this.projectIds,
            this.sourceWarehouseIds,
            this.directionWarehouseIds,
            this.sourceWorkshopIds,
            this.directionWorkshopIds,
            this.boolPartyA
         );
      }

      @Override
      public String toString() {
         return "QueryMoveMaterialDTOParam.QueryMoveMaterialDTOParamBuilder(startAndEndTime="
            + this.startAndEndTime
            + ", basicClass="
            + this.basicClass
            + ", reviewStatus="
            + this.reviewStatus
            + ", serialNumber="
            + this.serialNumber
            + ", operatorName="
            + this.operatorName
            + ", projectIds="
            + this.projectIds
            + ", sourceWarehouseIds="
            + this.sourceWarehouseIds
            + ", directionWarehouseIds="
            + this.directionWarehouseIds
            + ", sourceWorkshopIds="
            + this.sourceWorkshopIds
            + ", directionWorkshopIds="
            + this.directionWorkshopIds
            + ", boolPartyA="
            + this.boolPartyA
            + ")";
      }
   }
}
