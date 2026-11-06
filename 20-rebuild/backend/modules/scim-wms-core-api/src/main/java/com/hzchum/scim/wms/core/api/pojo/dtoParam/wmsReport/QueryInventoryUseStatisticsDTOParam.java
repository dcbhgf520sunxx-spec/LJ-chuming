package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

public class QueryInventoryUseStatisticsDTOParam {
   @NotNull(message = "时间Id不可为空")
   private Long statisticsDateId;
   private List<Long> workshopIds;
   private Integer orderSupplyType;
   private Integer projectWarehouseType;
   private Integer basicClass;
   private List<Long> classifyIds;
   private Long projectId;
   private String specification;
   private String brand;
   private BigDecimal thickness;
   private BigDecimal theoryThickness;
   private BigDecimal width;
   private BigDecimal length;
   private String color;
   private BigDecimal minLength;
   private BigDecimal maxLength;
   private Integer materialIsWhole;

   public static QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder builder() {
      return new QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder();
   }

   public Long getStatisticsDateId() {
      return this.statisticsDateId;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public Integer getOrderSupplyType() {
      return this.orderSupplyType;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getBrand() {
      return this.brand;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getMinLength() {
      return this.minLength;
   }

   public BigDecimal getMaxLength() {
      return this.maxLength;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public void setStatisticsDateId(final Long statisticsDateId) {
      this.statisticsDateId = statisticsDateId;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
   }

   public void setOrderSupplyType(final Integer orderSupplyType) {
      this.orderSupplyType = orderSupplyType;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMinLength(final BigDecimal minLength) {
      this.minLength = minLength;
   }

   public void setMaxLength(final BigDecimal maxLength) {
      this.maxLength = maxLength;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryInventoryUseStatisticsDTOParam)) {
         return false;
      }

      QueryInventoryUseStatisticsDTOParam other = (QueryInventoryUseStatisticsDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$statisticsDateId = this.getStatisticsDateId();
      Object other$statisticsDateId = other.getStatisticsDateId();
      if (this$statisticsDateId == null ? other$statisticsDateId == null : this$statisticsDateId.equals(other$statisticsDateId)) {
         Object this$orderSupplyType = this.getOrderSupplyType();
         Object other$orderSupplyType = other.getOrderSupplyType();
         if (this$orderSupplyType == null ? other$orderSupplyType == null : this$orderSupplyType.equals(other$orderSupplyType)) {
            Object this$projectWarehouseType = this.getProjectWarehouseType();
            Object other$projectWarehouseType = other.getProjectWarehouseType();
            if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$materialIsWhole = this.getMaterialIsWhole();
                     Object other$materialIsWhole = other.getMaterialIsWhole();
                     if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                        Object this$workshopIds = this.getWorkshopIds();
                        Object other$workshopIds = other.getWorkshopIds();
                        if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
                           Object this$classifyIds = this.getClassifyIds();
                           Object other$classifyIds = other.getClassifyIds();
                           if (this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$brand = this.getBrand();
                                 Object other$brand = other.getBrand();
                                 if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                    Object this$thickness = this.getThickness();
                                    Object other$thickness = other.getThickness();
                                    if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                       Object this$theoryThickness = this.getTheoryThickness();
                                       Object other$theoryThickness = other.getTheoryThickness();
                                       if (this$theoryThickness == null ? other$theoryThickness == null : this$theoryThickness.equals(other$theoryThickness)) {
                                          Object this$width = this.getWidth();
                                          Object other$width = other.getWidth();
                                          if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                             Object this$length = this.getLength();
                                             Object other$length = other.getLength();
                                             if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                Object this$color = this.getColor();
                                                Object other$color = other.getColor();
                                                if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                   Object this$minLength = this.getMinLength();
                                                   Object other$minLength = other.getMinLength();
                                                   if (this$minLength == null ? other$minLength == null : this$minLength.equals(other$minLength)) {
                                                      Object this$maxLength = this.getMaxLength();
                                                      Object other$maxLength = other.getMaxLength();
                                                      return this$maxLength == null ? other$maxLength == null : this$maxLength.equals(other$maxLength);
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
      return other instanceof QueryInventoryUseStatisticsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $statisticsDateId = this.getStatisticsDateId();
      result = result * 59 + ($statisticsDateId == null ? 43 : $statisticsDateId.hashCode());
      Object $orderSupplyType = this.getOrderSupplyType();
      result = result * 59 + ($orderSupplyType == null ? 43 : $orderSupplyType.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $maxLength = this.getMaxLength();
      return result * 59 + ($maxLength == null ? 43 : $maxLength.hashCode());
   }

   @Override
   public String toString() {
      return "QueryInventoryUseStatisticsDTOParam(statisticsDateId="
         + this.getStatisticsDateId()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", orderSupplyType="
         + this.getOrderSupplyType()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", projectId="
         + this.getProjectId()
         + ", specification="
         + this.getSpecification()
         + ", brand="
         + this.getBrand()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", color="
         + this.getColor()
         + ", minLength="
         + this.getMinLength()
         + ", maxLength="
         + this.getMaxLength()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ")";
   }

   public QueryInventoryUseStatisticsDTOParam(
      final Long statisticsDateId,
      final List<Long> workshopIds,
      final Integer orderSupplyType,
      final Integer projectWarehouseType,
      final Integer basicClass,
      final List<Long> classifyIds,
      final Long projectId,
      final String specification,
      final String brand,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal width,
      final BigDecimal length,
      final String color,
      final BigDecimal minLength,
      final BigDecimal maxLength,
      final Integer materialIsWhole
   ) {
      this.statisticsDateId = statisticsDateId;
      this.workshopIds = workshopIds;
      this.orderSupplyType = orderSupplyType;
      this.projectWarehouseType = projectWarehouseType;
      this.basicClass = basicClass;
      this.classifyIds = classifyIds;
      this.projectId = projectId;
      this.specification = specification;
      this.brand = brand;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.width = width;
      this.length = length;
      this.color = color;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.materialIsWhole = materialIsWhole;
   }

   public QueryInventoryUseStatisticsDTOParam() {
   }

   public static class QueryInventoryUseStatisticsDTOParamBuilder {
      private Long statisticsDateId;
      private List<Long> workshopIds;
      private Integer orderSupplyType;
      private Integer projectWarehouseType;
      private Integer basicClass;
      private List<Long> classifyIds;
      private Long projectId;
      private String specification;
      private String brand;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal width;
      private BigDecimal length;
      private String color;
      private BigDecimal minLength;
      private BigDecimal maxLength;
      private Integer materialIsWhole;

      QueryInventoryUseStatisticsDTOParamBuilder() {
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder statisticsDateId(final Long statisticsDateId) {
         this.statisticsDateId = statisticsDateId;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder orderSupplyType(final Integer orderSupplyType) {
         this.orderSupplyType = orderSupplyType;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public QueryInventoryUseStatisticsDTOParam build() {
         return new QueryInventoryUseStatisticsDTOParam(
            this.statisticsDateId,
            this.workshopIds,
            this.orderSupplyType,
            this.projectWarehouseType,
            this.basicClass,
            this.classifyIds,
            this.projectId,
            this.specification,
            this.brand,
            this.thickness,
            this.theoryThickness,
            this.width,
            this.length,
            this.color,
            this.minLength,
            this.maxLength,
            this.materialIsWhole
         );
      }

      @Override
      public String toString() {
         return "QueryInventoryUseStatisticsDTOParam.QueryInventoryUseStatisticsDTOParamBuilder(statisticsDateId="
            + this.statisticsDateId
            + ", workshopIds="
            + this.workshopIds
            + ", orderSupplyType="
            + this.orderSupplyType
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", basicClass="
            + this.basicClass
            + ", classifyIds="
            + this.classifyIds
            + ", projectId="
            + this.projectId
            + ", specification="
            + this.specification
            + ", brand="
            + this.brand
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", color="
            + this.color
            + ", minLength="
            + this.minLength
            + ", maxLength="
            + this.maxLength
            + ", materialIsWhole="
            + this.materialIsWhole
            + ")";
      }
   }
}
