package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.time.LocalDateTime;
import java.util.List;

public class QueryReportOutboundDTOParam {
   private Integer basicClass;
   private Boolean boolPartyA;
   private Integer orderSupplyType;
   private Long factoryId;
   private Long workshopId;
   private Long warehouseId;
   private List<LocalDateTime> outboundTime;
   private List<LocalDateTime> materialOutboundTime;
   private List<LocalDateTime> reviewTime;
   private List<LocalDateTime> createTime;
   private Long recipientId;
   private Long monomerId;
   private Long areaId;
   private String operatorName;
   private Long projectId;
   private Integer projectWarehouseType;
   private String serialNumber;
   private Integer outboundTypeSelection;
   private Long sourceProjectId;
   private Integer weightMeasurementMode;
   private Long sourceWorkshopId;
   private Long branchCompanyId;
   private Integer functionType;
   private Boolean boolScheduling;
   private List<Long> sourceWorkshopIds;

   public static QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder builder() {
      return new QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getOrderSupplyType() {
      return this.orderSupplyType;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public List<LocalDateTime> getOutboundTime() {
      return this.outboundTime;
   }

   public List<LocalDateTime> getMaterialOutboundTime() {
      return this.materialOutboundTime;
   }

   public List<LocalDateTime> getReviewTime() {
      return this.reviewTime;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Long getSourceProjectId() {
      return this.sourceProjectId;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getFunctionType() {
      return this.functionType;
   }

   public Boolean getBoolScheduling() {
      return this.boolScheduling;
   }

   public List<Long> getSourceWorkshopIds() {
      return this.sourceWorkshopIds;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setOrderSupplyType(final Integer orderSupplyType) {
      this.orderSupplyType = orderSupplyType;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setOutboundTime(final List<LocalDateTime> outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setMaterialOutboundTime(final List<LocalDateTime> materialOutboundTime) {
      this.materialOutboundTime = materialOutboundTime;
   }

   public void setReviewTime(final List<LocalDateTime> reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setSourceProjectId(final Long sourceProjectId) {
      this.sourceProjectId = sourceProjectId;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setFunctionType(final Integer functionType) {
      this.functionType = functionType;
   }

   public void setBoolScheduling(final Boolean boolScheduling) {
      this.boolScheduling = boolScheduling;
   }

   public void setSourceWorkshopIds(final List<Long> sourceWorkshopIds) {
      this.sourceWorkshopIds = sourceWorkshopIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryReportOutboundDTOParam)) {
         return false;
      }

      QueryReportOutboundDTOParam other = (QueryReportOutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$boolPartyA = this.getBoolPartyA();
         Object other$boolPartyA = other.getBoolPartyA();
         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
            Object this$orderSupplyType = this.getOrderSupplyType();
            Object other$orderSupplyType = other.getOrderSupplyType();
            if (this$orderSupplyType == null ? other$orderSupplyType == null : this$orderSupplyType.equals(other$orderSupplyType)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$warehouseId = this.getWarehouseId();
                     Object other$warehouseId = other.getWarehouseId();
                     if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                        Object this$recipientId = this.getRecipientId();
                        Object other$recipientId = other.getRecipientId();
                        if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$projectId = this.getProjectId();
                                 Object other$projectId = other.getProjectId();
                                 if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                    Object this$projectWarehouseType = this.getProjectWarehouseType();
                                    Object other$projectWarehouseType = other.getProjectWarehouseType();
                                    if (this$projectWarehouseType == null
                                       ? other$projectWarehouseType == null
                                       : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                                       Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                       Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                       if (this$outboundTypeSelection == null
                                          ? other$outboundTypeSelection == null
                                          : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                          Object this$sourceProjectId = this.getSourceProjectId();
                                          Object other$sourceProjectId = other.getSourceProjectId();
                                          if (this$sourceProjectId == null ? other$sourceProjectId == null : this$sourceProjectId.equals(other$sourceProjectId)
                                             )
                                           {
                                             Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                             Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                             if (this$weightMeasurementMode == null
                                                ? other$weightMeasurementMode == null
                                                : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                Object this$sourceWorkshopId = this.getSourceWorkshopId();
                                                Object other$sourceWorkshopId = other.getSourceWorkshopId();
                                                if (this$sourceWorkshopId == null
                                                   ? other$sourceWorkshopId == null
                                                   : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                                                   Object this$branchCompanyId = this.getBranchCompanyId();
                                                   Object other$branchCompanyId = other.getBranchCompanyId();
                                                   if (this$branchCompanyId == null
                                                      ? other$branchCompanyId == null
                                                      : this$branchCompanyId.equals(other$branchCompanyId)) {
                                                      Object this$functionType = this.getFunctionType();
                                                      Object other$functionType = other.getFunctionType();
                                                      if (this$functionType == null ? other$functionType == null : this$functionType.equals(other$functionType)
                                                         )
                                                       {
                                                         Object this$boolScheduling = this.getBoolScheduling();
                                                         Object other$boolScheduling = other.getBoolScheduling();
                                                         if (this$boolScheduling == null
                                                            ? other$boolScheduling == null
                                                            : this$boolScheduling.equals(other$boolScheduling)) {
                                                            Object this$outboundTime = this.getOutboundTime();
                                                            Object other$outboundTime = other.getOutboundTime();
                                                            if (this$outboundTime == null
                                                               ? other$outboundTime == null
                                                               : this$outboundTime.equals(other$outboundTime)) {
                                                               Object this$materialOutboundTime = this.getMaterialOutboundTime();
                                                               Object other$materialOutboundTime = other.getMaterialOutboundTime();
                                                               if (this$materialOutboundTime == null
                                                                  ? other$materialOutboundTime == null
                                                                  : this$materialOutboundTime.equals(other$materialOutboundTime)) {
                                                                  Object this$reviewTime = this.getReviewTime();
                                                                  Object other$reviewTime = other.getReviewTime();
                                                                  if (this$reviewTime == null
                                                                     ? other$reviewTime == null
                                                                     : this$reviewTime.equals(other$reviewTime)) {
                                                                     Object this$createTime = this.getCreateTime();
                                                                     Object other$createTime = other.getCreateTime();
                                                                     if (this$createTime == null
                                                                        ? other$createTime == null
                                                                        : this$createTime.equals(other$createTime)) {
                                                                        Object this$operatorName = this.getOperatorName();
                                                                        Object other$operatorName = other.getOperatorName();
                                                                        if (this$operatorName == null
                                                                           ? other$operatorName == null
                                                                           : this$operatorName.equals(other$operatorName)) {
                                                                           Object this$serialNumber = this.getSerialNumber();
                                                                           Object other$serialNumber = other.getSerialNumber();
                                                                           if (this$serialNumber == null
                                                                              ? other$serialNumber == null
                                                                              : this$serialNumber.equals(other$serialNumber)) {
                                                                              Object this$sourceWorkshopIds = this.getSourceWorkshopIds();
                                                                              Object other$sourceWorkshopIds = other.getSourceWorkshopIds();
                                                                              return this$sourceWorkshopIds == null
                                                                                 ? other$sourceWorkshopIds == null
                                                                                 : this$sourceWorkshopIds.equals(other$sourceWorkshopIds);
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
      return other instanceof QueryReportOutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $orderSupplyType = this.getOrderSupplyType();
      result = result * 59 + ($orderSupplyType == null ? 43 : $orderSupplyType.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $sourceProjectId = this.getSourceProjectId();
      result = result * 59 + ($sourceProjectId == null ? 43 : $sourceProjectId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $functionType = this.getFunctionType();
      result = result * 59 + ($functionType == null ? 43 : $functionType.hashCode());
      Object $boolScheduling = this.getBoolScheduling();
      result = result * 59 + ($boolScheduling == null ? 43 : $boolScheduling.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $materialOutboundTime = this.getMaterialOutboundTime();
      result = result * 59 + ($materialOutboundTime == null ? 43 : $materialOutboundTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $sourceWorkshopIds = this.getSourceWorkshopIds();
      return result * 59 + ($sourceWorkshopIds == null ? 43 : $sourceWorkshopIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryReportOutboundDTOParam(basicClass="
         + this.getBasicClass()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", orderSupplyType="
         + this.getOrderSupplyType()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", materialOutboundTime="
         + this.getMaterialOutboundTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", createTime="
         + this.getCreateTime()
         + ", recipientId="
         + this.getRecipientId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", operatorName="
         + this.getOperatorName()
         + ", projectId="
         + this.getProjectId()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", sourceProjectId="
         + this.getSourceProjectId()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", functionType="
         + this.getFunctionType()
         + ", boolScheduling="
         + this.getBoolScheduling()
         + ", sourceWorkshopIds="
         + this.getSourceWorkshopIds()
         + ")";
   }

   public QueryReportOutboundDTOParam(
      final Integer basicClass,
      final Boolean boolPartyA,
      final Integer orderSupplyType,
      final Long factoryId,
      final Long workshopId,
      final Long warehouseId,
      final List<LocalDateTime> outboundTime,
      final List<LocalDateTime> materialOutboundTime,
      final List<LocalDateTime> reviewTime,
      final List<LocalDateTime> createTime,
      final Long recipientId,
      final Long monomerId,
      final Long areaId,
      final String operatorName,
      final Long projectId,
      final Integer projectWarehouseType,
      final String serialNumber,
      final Integer outboundTypeSelection,
      final Long sourceProjectId,
      final Integer weightMeasurementMode,
      final Long sourceWorkshopId,
      final Long branchCompanyId,
      final Integer functionType,
      final Boolean boolScheduling,
      final List<Long> sourceWorkshopIds
   ) {
      this.basicClass = basicClass;
      this.boolPartyA = boolPartyA;
      this.orderSupplyType = orderSupplyType;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.outboundTime = outboundTime;
      this.materialOutboundTime = materialOutboundTime;
      this.reviewTime = reviewTime;
      this.createTime = createTime;
      this.recipientId = recipientId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.operatorName = operatorName;
      this.projectId = projectId;
      this.projectWarehouseType = projectWarehouseType;
      this.serialNumber = serialNumber;
      this.outboundTypeSelection = outboundTypeSelection;
      this.sourceProjectId = sourceProjectId;
      this.weightMeasurementMode = weightMeasurementMode;
      this.sourceWorkshopId = sourceWorkshopId;
      this.branchCompanyId = branchCompanyId;
      this.functionType = functionType;
      this.boolScheduling = boolScheduling;
      this.sourceWorkshopIds = sourceWorkshopIds;
   }

   public QueryReportOutboundDTOParam() {
   }

   public static class QueryReportOutboundDTOParamBuilder {
      private Integer basicClass;
      private Boolean boolPartyA;
      private Integer orderSupplyType;
      private Long factoryId;
      private Long workshopId;
      private Long warehouseId;
      private List<LocalDateTime> outboundTime;
      private List<LocalDateTime> materialOutboundTime;
      private List<LocalDateTime> reviewTime;
      private List<LocalDateTime> createTime;
      private Long recipientId;
      private Long monomerId;
      private Long areaId;
      private String operatorName;
      private Long projectId;
      private Integer projectWarehouseType;
      private String serialNumber;
      private Integer outboundTypeSelection;
      private Long sourceProjectId;
      private Integer weightMeasurementMode;
      private Long sourceWorkshopId;
      private Long branchCompanyId;
      private Integer functionType;
      private Boolean boolScheduling;
      private List<Long> sourceWorkshopIds;

      QueryReportOutboundDTOParamBuilder() {
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder orderSupplyType(final Integer orderSupplyType) {
         this.orderSupplyType = orderSupplyType;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder outboundTime(final List<LocalDateTime> outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder materialOutboundTime(final List<LocalDateTime> materialOutboundTime) {
         this.materialOutboundTime = materialOutboundTime;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder reviewTime(final List<LocalDateTime> reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder sourceProjectId(final Long sourceProjectId) {
         this.sourceProjectId = sourceProjectId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder functionType(final Integer functionType) {
         this.functionType = functionType;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder boolScheduling(final Boolean boolScheduling) {
         this.boolScheduling = boolScheduling;
         return this;
      }

      public QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder sourceWorkshopIds(final List<Long> sourceWorkshopIds) {
         this.sourceWorkshopIds = sourceWorkshopIds;
         return this;
      }

      public QueryReportOutboundDTOParam build() {
         return new QueryReportOutboundDTOParam(
            this.basicClass,
            this.boolPartyA,
            this.orderSupplyType,
            this.factoryId,
            this.workshopId,
            this.warehouseId,
            this.outboundTime,
            this.materialOutboundTime,
            this.reviewTime,
            this.createTime,
            this.recipientId,
            this.monomerId,
            this.areaId,
            this.operatorName,
            this.projectId,
            this.projectWarehouseType,
            this.serialNumber,
            this.outboundTypeSelection,
            this.sourceProjectId,
            this.weightMeasurementMode,
            this.sourceWorkshopId,
            this.branchCompanyId,
            this.functionType,
            this.boolScheduling,
            this.sourceWorkshopIds
         );
      }

      @Override
      public String toString() {
         return "QueryReportOutboundDTOParam.QueryReportOutboundDTOParamBuilder(basicClass="
            + this.basicClass
            + ", boolPartyA="
            + this.boolPartyA
            + ", orderSupplyType="
            + this.orderSupplyType
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", outboundTime="
            + this.outboundTime
            + ", materialOutboundTime="
            + this.materialOutboundTime
            + ", reviewTime="
            + this.reviewTime
            + ", createTime="
            + this.createTime
            + ", recipientId="
            + this.recipientId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", operatorName="
            + this.operatorName
            + ", projectId="
            + this.projectId
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", serialNumber="
            + this.serialNumber
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", sourceProjectId="
            + this.sourceProjectId
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", functionType="
            + this.functionType
            + ", boolScheduling="
            + this.boolScheduling
            + ", sourceWorkshopIds="
            + this.sourceWorkshopIds
            + ")";
      }
   }
}
