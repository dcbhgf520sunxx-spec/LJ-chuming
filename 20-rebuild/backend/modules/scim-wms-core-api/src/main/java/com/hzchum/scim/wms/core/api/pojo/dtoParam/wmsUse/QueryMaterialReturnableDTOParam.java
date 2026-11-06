package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class QueryMaterialReturnableDTOParam {
   private Integer projectWarehouseType;
   private Integer materialIsWhole;
   private Long projectId;
   private Integer basicClass;
   private Long classifyId;
   private List<Long> classifyIds;
   private List<LocalDateTime> createTime;
   private BigDecimal minLength;
   private BigDecimal maxLength;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal theoryThickness;
   private BigDecimal thickness;
   private String heatNoAndBatchNo;
   private String specification;
   private Long warehouseId;
   private Long workshopId;
   private String color;
   private String brand;
   private Integer outboundTypeSelection;
   private Boolean boolReturn;
   private BigDecimal mete;
   private Boolean boolPartyA;
   private String serialNumber;
   private Boolean boolReviewPending;
   private Long areaBatchId;
   private Long recipientId;

   public static QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder builder() {
      return new QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder();
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public BigDecimal getMinLength() {
      return this.minLength;
   }

   public BigDecimal getMaxLength() {
      return this.maxLength;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Boolean getBoolReturn() {
      return this.boolReturn;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Boolean getBoolReviewPending() {
      return this.boolReviewPending;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setMinLength(final BigDecimal minLength) {
      this.minLength = minLength;
   }

   public void setMaxLength(final BigDecimal maxLength) {
      this.maxLength = maxLength;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setBoolReturn(final Boolean boolReturn) {
      this.boolReturn = boolReturn;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setBoolReviewPending(final Boolean boolReviewPending) {
      this.boolReviewPending = boolReviewPending;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryMaterialReturnableDTOParam)) {
         return false;
      }

      QueryMaterialReturnableDTOParam other = (QueryMaterialReturnableDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectWarehouseType = this.getProjectWarehouseType();
      Object other$projectWarehouseType = other.getProjectWarehouseType();
      if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
         Object this$materialIsWhole = this.getMaterialIsWhole();
         Object other$materialIsWhole = other.getMaterialIsWhole();
         if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$classifyId = this.getClassifyId();
                  Object other$classifyId = other.getClassifyId();
                  if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                     Object this$warehouseId = this.getWarehouseId();
                     Object other$warehouseId = other.getWarehouseId();
                     if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                           Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                           if (this$outboundTypeSelection == null
                              ? other$outboundTypeSelection == null
                              : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                              Object this$boolReturn = this.getBoolReturn();
                              Object other$boolReturn = other.getBoolReturn();
                              if (this$boolReturn == null ? other$boolReturn == null : this$boolReturn.equals(other$boolReturn)) {
                                 Object this$boolPartyA = this.getBoolPartyA();
                                 Object other$boolPartyA = other.getBoolPartyA();
                                 if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                    Object this$boolReviewPending = this.getBoolReviewPending();
                                    Object other$boolReviewPending = other.getBoolReviewPending();
                                    if (this$boolReviewPending == null
                                       ? other$boolReviewPending == null
                                       : this$boolReviewPending.equals(other$boolReviewPending)) {
                                       Object this$areaBatchId = this.getAreaBatchId();
                                       Object other$areaBatchId = other.getAreaBatchId();
                                       if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                                          Object this$recipientId = this.getRecipientId();
                                          Object other$recipientId = other.getRecipientId();
                                          if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                                             Object this$classifyIds = this.getClassifyIds();
                                             Object other$classifyIds = other.getClassifyIds();
                                             if (this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds)) {
                                                Object this$createTime = this.getCreateTime();
                                                Object other$createTime = other.getCreateTime();
                                                if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                   Object this$minLength = this.getMinLength();
                                                   Object other$minLength = other.getMinLength();
                                                   if (this$minLength == null ? other$minLength == null : this$minLength.equals(other$minLength)) {
                                                      Object this$maxLength = this.getMaxLength();
                                                      Object other$maxLength = other.getMaxLength();
                                                      if (this$maxLength == null ? other$maxLength == null : this$maxLength.equals(other$maxLength)) {
                                                         Object this$length = this.getLength();
                                                         Object other$length = other.getLength();
                                                         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                            Object this$width = this.getWidth();
                                                            Object other$width = other.getWidth();
                                                            if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                               Object this$theoryThickness = this.getTheoryThickness();
                                                               Object other$theoryThickness = other.getTheoryThickness();
                                                               if (this$theoryThickness == null
                                                                  ? other$theoryThickness == null
                                                                  : this$theoryThickness.equals(other$theoryThickness)) {
                                                                  Object this$thickness = this.getThickness();
                                                                  Object other$thickness = other.getThickness();
                                                                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)
                                                                     )
                                                                   {
                                                                     Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                     Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                     if (this$heatNoAndBatchNo == null
                                                                        ? other$heatNoAndBatchNo == null
                                                                        : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                        Object this$specification = this.getSpecification();
                                                                        Object other$specification = other.getSpecification();
                                                                        if (this$specification == null
                                                                           ? other$specification == null
                                                                           : this$specification.equals(other$specification)) {
                                                                           Object this$color = this.getColor();
                                                                           Object other$color = other.getColor();
                                                                           if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                              Object this$brand = this.getBrand();
                                                                              Object other$brand = other.getBrand();
                                                                              if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                                 Object this$mete = this.getMete();
                                                                                 Object other$mete = other.getMete();
                                                                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                    Object this$serialNumber = this.getSerialNumber();
                                                                                    Object other$serialNumber = other.getSerialNumber();
                                                                                    return this$serialNumber == null
                                                                                       ? other$serialNumber == null
                                                                                       : this$serialNumber.equals(other$serialNumber);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryMaterialReturnableDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $boolReturn = this.getBoolReturn();
      result = result * 59 + ($boolReturn == null ? 43 : $boolReturn.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $boolReviewPending = this.getBoolReviewPending();
      result = result * 59 + ($boolReviewPending == null ? 43 : $boolReviewPending.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $maxLength = this.getMaxLength();
      result = result * 59 + ($maxLength == null ? 43 : $maxLength.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "QueryMaterialReturnableDTOParam(projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", projectId="
         + this.getProjectId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", createTime="
         + this.getCreateTime()
         + ", minLength="
         + this.getMinLength()
         + ", maxLength="
         + this.getMaxLength()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", thickness="
         + this.getThickness()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", specification="
         + this.getSpecification()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", boolReturn="
         + this.getBoolReturn()
         + ", mete="
         + this.getMete()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", boolReviewPending="
         + this.getBoolReviewPending()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", recipientId="
         + this.getRecipientId()
         + ")";
   }

   public QueryMaterialReturnableDTOParam(
      final Integer projectWarehouseType,
      final Integer materialIsWhole,
      final Long projectId,
      final Integer basicClass,
      final Long classifyId,
      final List<Long> classifyIds,
      final List<LocalDateTime> createTime,
      final BigDecimal minLength,
      final BigDecimal maxLength,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal theoryThickness,
      final BigDecimal thickness,
      final String heatNoAndBatchNo,
      final String specification,
      final Long warehouseId,
      final Long workshopId,
      final String color,
      final String brand,
      final Integer outboundTypeSelection,
      final Boolean boolReturn,
      final BigDecimal mete,
      final Boolean boolPartyA,
      final String serialNumber,
      final Boolean boolReviewPending,
      final Long areaBatchId,
      final Long recipientId
   ) {
      this.projectWarehouseType = projectWarehouseType;
      this.materialIsWhole = materialIsWhole;
      this.projectId = projectId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyIds = classifyIds;
      this.createTime = createTime;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.length = length;
      this.width = width;
      this.theoryThickness = theoryThickness;
      this.thickness = thickness;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.specification = specification;
      this.warehouseId = warehouseId;
      this.workshopId = workshopId;
      this.color = color;
      this.brand = brand;
      this.outboundTypeSelection = outboundTypeSelection;
      this.boolReturn = boolReturn;
      this.mete = mete;
      this.boolPartyA = boolPartyA;
      this.serialNumber = serialNumber;
      this.boolReviewPending = boolReviewPending;
      this.areaBatchId = areaBatchId;
      this.recipientId = recipientId;
   }

   public QueryMaterialReturnableDTOParam() {
   }

   public static class QueryMaterialReturnableDTOParamBuilder {
      private Integer projectWarehouseType;
      private Integer materialIsWhole;
      private Long projectId;
      private Integer basicClass;
      private Long classifyId;
      private List<Long> classifyIds;
      private List<LocalDateTime> createTime;
      private BigDecimal minLength;
      private BigDecimal maxLength;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal theoryThickness;
      private BigDecimal thickness;
      private String heatNoAndBatchNo;
      private String specification;
      private Long warehouseId;
      private Long workshopId;
      private String color;
      private String brand;
      private Integer outboundTypeSelection;
      private Boolean boolReturn;
      private BigDecimal mete;
      private Boolean boolPartyA;
      private String serialNumber;
      private Boolean boolReviewPending;
      private Long areaBatchId;
      private Long recipientId;

      QueryMaterialReturnableDTOParamBuilder() {
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder boolReturn(final Boolean boolReturn) {
         this.boolReturn = boolReturn;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder boolReviewPending(final Boolean boolReviewPending) {
         this.boolReviewPending = boolReviewPending;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public QueryMaterialReturnableDTOParam build() {
         return new QueryMaterialReturnableDTOParam(
            this.projectWarehouseType,
            this.materialIsWhole,
            this.projectId,
            this.basicClass,
            this.classifyId,
            this.classifyIds,
            this.createTime,
            this.minLength,
            this.maxLength,
            this.length,
            this.width,
            this.theoryThickness,
            this.thickness,
            this.heatNoAndBatchNo,
            this.specification,
            this.warehouseId,
            this.workshopId,
            this.color,
            this.brand,
            this.outboundTypeSelection,
            this.boolReturn,
            this.mete,
            this.boolPartyA,
            this.serialNumber,
            this.boolReviewPending,
            this.areaBatchId,
            this.recipientId
         );
      }

      @Override
      public String toString() {
         return "QueryMaterialReturnableDTOParam.QueryMaterialReturnableDTOParamBuilder(projectWarehouseType="
            + this.projectWarehouseType
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", projectId="
            + this.projectId
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyIds="
            + this.classifyIds
            + ", createTime="
            + this.createTime
            + ", minLength="
            + this.minLength
            + ", maxLength="
            + this.maxLength
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", theoryThickness="
            + this.theoryThickness
            + ", thickness="
            + this.thickness
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", specification="
            + this.specification
            + ", warehouseId="
            + this.warehouseId
            + ", workshopId="
            + this.workshopId
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", boolReturn="
            + this.boolReturn
            + ", mete="
            + this.mete
            + ", boolPartyA="
            + this.boolPartyA
            + ", serialNumber="
            + this.serialNumber
            + ", boolReviewPending="
            + this.boolReviewPending
            + ", areaBatchId="
            + this.areaBatchId
            + ", recipientId="
            + this.recipientId
            + ")";
      }
   }
}
