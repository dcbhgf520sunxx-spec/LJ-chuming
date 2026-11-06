package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryOutboundDTOParam {
   private Long classifyId;
   private String applicationSN;
   private String serialNumber;
   private String operatorName;
   private List<LocalDateTime> createTime;
   private List<LocalDateTime> outboundTime;
   private Integer basicClass;
   private Long projectId;
   private Integer type;
   private Integer projectWarehouseType;
   private Boolean boolPartyA;
   private Integer outboundTypeSelection;
   private List<Long> classifyIds;
   private List<LocalDateTime> reviewTime;
   private List<LocalDateTime> materialOutboundTime;
   private Long mesWorkshopId;
   private Boolean boolScheduling;
   private List<Long> workshopIds;

   public static QueryOutboundDTOParam.QueryOutboundDTOParamBuilder builder() {
      return new QueryOutboundDTOParam.QueryOutboundDTOParamBuilder();
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getApplicationSN() {
      return this.applicationSN;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public List<LocalDateTime> getOutboundTime() {
      return this.outboundTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public List<LocalDateTime> getReviewTime() {
      return this.reviewTime;
   }

   public List<LocalDateTime> getMaterialOutboundTime() {
      return this.materialOutboundTime;
   }

   public Long getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   public Boolean getBoolScheduling() {
      return this.boolScheduling;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setApplicationSN(final String applicationSN) {
      this.applicationSN = applicationSN;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setOutboundTime(final List<LocalDateTime> outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setReviewTime(final List<LocalDateTime> reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setMaterialOutboundTime(final List<LocalDateTime> materialOutboundTime) {
      this.materialOutboundTime = materialOutboundTime;
   }

   public void setMesWorkshopId(final Long mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
   }

   public void setBoolScheduling(final Boolean boolScheduling) {
      this.boolScheduling = boolScheduling;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryOutboundDTOParam)) {
         return false;
      }

      QueryOutboundDTOParam other = (QueryOutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$projectWarehouseType = this.getProjectWarehouseType();
                  Object other$projectWarehouseType = other.getProjectWarehouseType();
                  if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                        Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                        if (this$outboundTypeSelection == null
                           ? other$outboundTypeSelection == null
                           : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                           Object this$mesWorkshopId = this.getMesWorkshopId();
                           Object other$mesWorkshopId = other.getMesWorkshopId();
                           if (this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId)) {
                              Object this$boolScheduling = this.getBoolScheduling();
                              Object other$boolScheduling = other.getBoolScheduling();
                              if (this$boolScheduling == null ? other$boolScheduling == null : this$boolScheduling.equals(other$boolScheduling)) {
                                 Object this$applicationSN = this.getApplicationSN();
                                 Object other$applicationSN = other.getApplicationSN();
                                 if (this$applicationSN == null ? other$applicationSN == null : this$applicationSN.equals(other$applicationSN)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$operatorName = this.getOperatorName();
                                       Object other$operatorName = other.getOperatorName();
                                       if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                                          Object this$createTime = this.getCreateTime();
                                          Object other$createTime = other.getCreateTime();
                                          if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                             Object this$outboundTime = this.getOutboundTime();
                                             Object other$outboundTime = other.getOutboundTime();
                                             if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                                                Object this$classifyIds = this.getClassifyIds();
                                                Object other$classifyIds = other.getClassifyIds();
                                                if (this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds)) {
                                                   Object this$reviewTime = this.getReviewTime();
                                                   Object other$reviewTime = other.getReviewTime();
                                                   if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                                      Object this$materialOutboundTime = this.getMaterialOutboundTime();
                                                      Object other$materialOutboundTime = other.getMaterialOutboundTime();
                                                      if (this$materialOutboundTime == null
                                                         ? other$materialOutboundTime == null
                                                         : this$materialOutboundTime.equals(other$materialOutboundTime)) {
                                                         Object this$workshopIds = this.getWorkshopIds();
                                                         Object other$workshopIds = other.getWorkshopIds();
                                                         return this$workshopIds == null
                                                            ? other$workshopIds == null
                                                            : this$workshopIds.equals(other$workshopIds);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryOutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      result = result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
      Object $boolScheduling = this.getBoolScheduling();
      result = result * 59 + ($boolScheduling == null ? 43 : $boolScheduling.hashCode());
      Object $applicationSN = this.getApplicationSN();
      result = result * 59 + ($applicationSN == null ? 43 : $applicationSN.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $materialOutboundTime = this.getMaterialOutboundTime();
      result = result * 59 + ($materialOutboundTime == null ? 43 : $materialOutboundTime.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      return result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryOutboundDTOParam(classifyId="
         + this.getClassifyId()
         + ", applicationSN="
         + this.getApplicationSN()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", operatorName="
         + this.getOperatorName()
         + ", createTime="
         + this.getCreateTime()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectId="
         + this.getProjectId()
         + ", type="
         + this.getType()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", reviewTime="
         + this.getReviewTime()
         + ", materialOutboundTime="
         + this.getMaterialOutboundTime()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ", boolScheduling="
         + this.getBoolScheduling()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ")";
   }

   public QueryOutboundDTOParam(
      final Long classifyId,
      final String applicationSN,
      final String serialNumber,
      final String operatorName,
      final List<LocalDateTime> createTime,
      final List<LocalDateTime> outboundTime,
      final Integer basicClass,
      final Long projectId,
      final Integer type,
      final Integer projectWarehouseType,
      final Boolean boolPartyA,
      final Integer outboundTypeSelection,
      final List<Long> classifyIds,
      final List<LocalDateTime> reviewTime,
      final List<LocalDateTime> materialOutboundTime,
      final Long mesWorkshopId,
      final Boolean boolScheduling,
      final List<Long> workshopIds
   ) {
      this.classifyId = classifyId;
      this.applicationSN = applicationSN;
      this.serialNumber = serialNumber;
      this.operatorName = operatorName;
      this.createTime = createTime;
      this.outboundTime = outboundTime;
      this.basicClass = basicClass;
      this.projectId = projectId;
      this.type = type;
      this.projectWarehouseType = projectWarehouseType;
      this.boolPartyA = boolPartyA;
      this.outboundTypeSelection = outboundTypeSelection;
      this.classifyIds = classifyIds;
      this.reviewTime = reviewTime;
      this.materialOutboundTime = materialOutboundTime;
      this.mesWorkshopId = mesWorkshopId;
      this.boolScheduling = boolScheduling;
      this.workshopIds = workshopIds;
   }

   public QueryOutboundDTOParam() {
   }

   public static class QueryOutboundDTOParamBuilder {
      private Long classifyId;
      private String applicationSN;
      private String serialNumber;
      private String operatorName;
      private List<LocalDateTime> createTime;
      private List<LocalDateTime> outboundTime;
      private Integer basicClass;
      private Long projectId;
      private Integer type;
      private Integer projectWarehouseType;
      private Boolean boolPartyA;
      private Integer outboundTypeSelection;
      private List<Long> classifyIds;
      private List<LocalDateTime> reviewTime;
      private List<LocalDateTime> materialOutboundTime;
      private Long mesWorkshopId;
      private Boolean boolScheduling;
      private List<Long> workshopIds;

      QueryOutboundDTOParamBuilder() {
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder applicationSN(final String applicationSN) {
         this.applicationSN = applicationSN;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder outboundTime(final List<LocalDateTime> outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder reviewTime(final List<LocalDateTime> reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder materialOutboundTime(final List<LocalDateTime> materialOutboundTime) {
         this.materialOutboundTime = materialOutboundTime;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder mesWorkshopId(final Long mesWorkshopId) {
         this.mesWorkshopId = mesWorkshopId;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder boolScheduling(final Boolean boolScheduling) {
         this.boolScheduling = boolScheduling;
         return this;
      }

      public QueryOutboundDTOParam.QueryOutboundDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public QueryOutboundDTOParam build() {
         return new QueryOutboundDTOParam(
            this.classifyId,
            this.applicationSN,
            this.serialNumber,
            this.operatorName,
            this.createTime,
            this.outboundTime,
            this.basicClass,
            this.projectId,
            this.type,
            this.projectWarehouseType,
            this.boolPartyA,
            this.outboundTypeSelection,
            this.classifyIds,
            this.reviewTime,
            this.materialOutboundTime,
            this.mesWorkshopId,
            this.boolScheduling,
            this.workshopIds
         );
      }

      @Override
      public String toString() {
         return "QueryOutboundDTOParam.QueryOutboundDTOParamBuilder(classifyId="
            + this.classifyId
            + ", applicationSN="
            + this.applicationSN
            + ", serialNumber="
            + this.serialNumber
            + ", operatorName="
            + this.operatorName
            + ", createTime="
            + this.createTime
            + ", outboundTime="
            + this.outboundTime
            + ", basicClass="
            + this.basicClass
            + ", projectId="
            + this.projectId
            + ", type="
            + this.type
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", boolPartyA="
            + this.boolPartyA
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", classifyIds="
            + this.classifyIds
            + ", reviewTime="
            + this.reviewTime
            + ", materialOutboundTime="
            + this.materialOutboundTime
            + ", mesWorkshopId="
            + this.mesWorkshopId
            + ", boolScheduling="
            + this.boolScheduling
            + ", workshopIds="
            + this.workshopIds
            + ")";
      }
   }
}
