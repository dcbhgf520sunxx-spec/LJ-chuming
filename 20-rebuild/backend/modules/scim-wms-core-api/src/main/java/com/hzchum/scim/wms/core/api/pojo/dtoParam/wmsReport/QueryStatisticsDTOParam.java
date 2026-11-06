package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class QueryStatisticsDTOParam {
   private Integer basicClass;
   private Integer orderSupplyType;
   private Long workshopId;
   private List<Long> classifyId;
   private List<Long> classifyIds;
   private Long projectId;
   private BigDecimal minLength;
   private BigDecimal maxLength;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal theoryThickness;
   private BigDecimal thickness;
   private String heatNoAndBatchNo;
   private String specification;
   private String color;
   private String brand;
   private LocalDateTime createTime;
   private Integer projectWarehouseType;
   private List<Long> statisticsIds;
   private boolean boolShowAmount;
   private Long wmsClosingTimeId;
   private Integer unitType;
   private List<Long> workshopIds;

   public static QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder builder() {
      return new QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getOrderSupplyType() {
      return this.orderSupplyType;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public List<Long> getClassifyId() {
      return this.classifyId;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public List<Long> getStatisticsIds() {
      return this.statisticsIds;
   }

   public boolean isBoolShowAmount() {
      return this.boolShowAmount;
   }

   public Long getWmsClosingTimeId() {
      return this.wmsClosingTimeId;
   }

   public Integer getUnitType() {
      return this.unitType;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setOrderSupplyType(final Integer orderSupplyType) {
      this.orderSupplyType = orderSupplyType;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setClassifyId(final List<Long> classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setStatisticsIds(final List<Long> statisticsIds) {
      this.statisticsIds = statisticsIds;
   }

   public void setBoolShowAmount(final boolean boolShowAmount) {
      this.boolShowAmount = boolShowAmount;
   }

   public void setWmsClosingTimeId(final Long wmsClosingTimeId) {
      this.wmsClosingTimeId = wmsClosingTimeId;
   }

   public void setUnitType(final Integer unitType) {
      this.unitType = unitType;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryStatisticsDTOParam)) {
         return false;
      }

      QueryStatisticsDTOParam other = (QueryStatisticsDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolShowAmount() != other.isBoolShowAmount()) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$orderSupplyType = this.getOrderSupplyType();
         Object other$orderSupplyType = other.getOrderSupplyType();
         if (this$orderSupplyType == null ? other$orderSupplyType == null : this$orderSupplyType.equals(other$orderSupplyType)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$projectWarehouseType = this.getProjectWarehouseType();
                  Object other$projectWarehouseType = other.getProjectWarehouseType();
                  if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                     Object this$wmsClosingTimeId = this.getWmsClosingTimeId();
                     Object other$wmsClosingTimeId = other.getWmsClosingTimeId();
                     if (this$wmsClosingTimeId == null ? other$wmsClosingTimeId == null : this$wmsClosingTimeId.equals(other$wmsClosingTimeId)) {
                        Object this$unitType = this.getUnitType();
                        Object other$unitType = other.getUnitType();
                        if (this$unitType == null ? other$unitType == null : this$unitType.equals(other$unitType)) {
                           Object this$classifyId = this.getClassifyId();
                           Object other$classifyId = other.getClassifyId();
                           if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                              Object this$classifyIds = this.getClassifyIds();
                              Object other$classifyIds = other.getClassifyIds();
                              if (this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds)) {
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
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
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
                                                               Object this$createTime = this.getCreateTime();
                                                               Object other$createTime = other.getCreateTime();
                                                               if (this$createTime == null
                                                                  ? other$createTime == null
                                                                  : this$createTime.equals(other$createTime)) {
                                                                  Object this$statisticsIds = this.getStatisticsIds();
                                                                  Object other$statisticsIds = other.getStatisticsIds();
                                                                  if (this$statisticsIds == null
                                                                     ? other$statisticsIds == null
                                                                     : this$statisticsIds.equals(other$statisticsIds)) {
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
      return other instanceof QueryStatisticsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolShowAmount() ? 79 : 97);
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $orderSupplyType = this.getOrderSupplyType();
      result = result * 59 + ($orderSupplyType == null ? 43 : $orderSupplyType.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $wmsClosingTimeId = this.getWmsClosingTimeId();
      result = result * 59 + ($wmsClosingTimeId == null ? 43 : $wmsClosingTimeId.hashCode());
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
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
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $statisticsIds = this.getStatisticsIds();
      result = result * 59 + ($statisticsIds == null ? 43 : $statisticsIds.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      return result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryStatisticsDTOParam(basicClass="
         + this.getBasicClass()
         + ", orderSupplyType="
         + this.getOrderSupplyType()
         + ", workshopId="
         + this.getWorkshopId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", projectId="
         + this.getProjectId()
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
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", createTime="
         + this.getCreateTime()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", statisticsIds="
         + this.getStatisticsIds()
         + ", boolShowAmount="
         + this.isBoolShowAmount()
         + ", wmsClosingTimeId="
         + this.getWmsClosingTimeId()
         + ", unitType="
         + this.getUnitType()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ")";
   }

   public QueryStatisticsDTOParam(
      final Integer basicClass,
      final Integer orderSupplyType,
      final Long workshopId,
      final List<Long> classifyId,
      final List<Long> classifyIds,
      final Long projectId,
      final BigDecimal minLength,
      final BigDecimal maxLength,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal theoryThickness,
      final BigDecimal thickness,
      final String heatNoAndBatchNo,
      final String specification,
      final String color,
      final String brand,
      final LocalDateTime createTime,
      final Integer projectWarehouseType,
      final List<Long> statisticsIds,
      final boolean boolShowAmount,
      final Long wmsClosingTimeId,
      final Integer unitType,
      final List<Long> workshopIds
   ) {
      this.basicClass = basicClass;
      this.orderSupplyType = orderSupplyType;
      this.workshopId = workshopId;
      this.classifyId = classifyId;
      this.classifyIds = classifyIds;
      this.projectId = projectId;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.length = length;
      this.width = width;
      this.theoryThickness = theoryThickness;
      this.thickness = thickness;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.specification = specification;
      this.color = color;
      this.brand = brand;
      this.createTime = createTime;
      this.projectWarehouseType = projectWarehouseType;
      this.statisticsIds = statisticsIds;
      this.boolShowAmount = boolShowAmount;
      this.wmsClosingTimeId = wmsClosingTimeId;
      this.unitType = unitType;
      this.workshopIds = workshopIds;
   }

   public QueryStatisticsDTOParam() {
   }

   public static class QueryStatisticsDTOParamBuilder {
      private Integer basicClass;
      private Integer orderSupplyType;
      private Long workshopId;
      private List<Long> classifyId;
      private List<Long> classifyIds;
      private Long projectId;
      private BigDecimal minLength;
      private BigDecimal maxLength;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal theoryThickness;
      private BigDecimal thickness;
      private String heatNoAndBatchNo;
      private String specification;
      private String color;
      private String brand;
      private LocalDateTime createTime;
      private Integer projectWarehouseType;
      private List<Long> statisticsIds;
      private boolean boolShowAmount;
      private Long wmsClosingTimeId;
      private Integer unitType;
      private List<Long> workshopIds;

      QueryStatisticsDTOParamBuilder() {
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder orderSupplyType(final Integer orderSupplyType) {
         this.orderSupplyType = orderSupplyType;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder classifyId(final List<Long> classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder statisticsIds(final List<Long> statisticsIds) {
         this.statisticsIds = statisticsIds;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder boolShowAmount(final boolean boolShowAmount) {
         this.boolShowAmount = boolShowAmount;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder wmsClosingTimeId(final Long wmsClosingTimeId) {
         this.wmsClosingTimeId = wmsClosingTimeId;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder unitType(final Integer unitType) {
         this.unitType = unitType;
         return this;
      }

      public QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public QueryStatisticsDTOParam build() {
         return new QueryStatisticsDTOParam(
            this.basicClass,
            this.orderSupplyType,
            this.workshopId,
            this.classifyId,
            this.classifyIds,
            this.projectId,
            this.minLength,
            this.maxLength,
            this.length,
            this.width,
            this.theoryThickness,
            this.thickness,
            this.heatNoAndBatchNo,
            this.specification,
            this.color,
            this.brand,
            this.createTime,
            this.projectWarehouseType,
            this.statisticsIds,
            this.boolShowAmount,
            this.wmsClosingTimeId,
            this.unitType,
            this.workshopIds
         );
      }

      @Override
      public String toString() {
         return "QueryStatisticsDTOParam.QueryStatisticsDTOParamBuilder(basicClass="
            + this.basicClass
            + ", orderSupplyType="
            + this.orderSupplyType
            + ", workshopId="
            + this.workshopId
            + ", classifyId="
            + this.classifyId
            + ", classifyIds="
            + this.classifyIds
            + ", projectId="
            + this.projectId
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
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", createTime="
            + this.createTime
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", statisticsIds="
            + this.statisticsIds
            + ", boolShowAmount="
            + this.boolShowAmount
            + ", wmsClosingTimeId="
            + this.wmsClosingTimeId
            + ", unitType="
            + this.unitType
            + ", workshopIds="
            + this.workshopIds
            + ")";
      }
   }
}
