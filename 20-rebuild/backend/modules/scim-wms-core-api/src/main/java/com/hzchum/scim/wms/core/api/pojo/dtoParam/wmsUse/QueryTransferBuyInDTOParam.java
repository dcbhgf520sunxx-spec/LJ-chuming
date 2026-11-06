package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class QueryTransferBuyInDTOParam {
   private Integer projectWarehouseType;
   private Integer materialIsWhole;
   private Long projectId;
   private Integer basicClass;
   private List<Long> classifyId;
   private List<Long> classifyIds;
   private BigDecimal minLength;
   private BigDecimal maxLength;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal theoryThickness;
   private BigDecimal thickness;
   private String heatNoAndBatchNo;
   private String specification;
   private String brand;
   private Long warehouseId;
   private Long workshopId;
   private String color;
   private List<LocalDateTime> createTime;
   private List<Long> TransferIds;
   private List<Long> workshopIds;

   public static QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder builder() {
      return new QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder();
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

   public List<Long> getClassifyId() {
      return this.classifyId;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
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

   public String getBrand() {
      return this.brand;
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

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public List<Long> getTransferIds() {
      return this.TransferIds;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
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

   public void setClassifyId(final List<Long> classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
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

   public void setBrand(final String brand) {
      this.brand = brand;
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

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setTransferIds(final List<Long> TransferIds) {
      this.TransferIds = TransferIds;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryTransferBuyInDTOParam)) {
         return false;
      }

      QueryTransferBuyInDTOParam other = (QueryTransferBuyInDTOParam)o;
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
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
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
                                          if (this$theoryThickness == null ? other$theoryThickness == null : this$theoryThickness.equals(other$theoryThickness)
                                             )
                                           {
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
                                                      Object this$brand = this.getBrand();
                                                      Object other$brand = other.getBrand();
                                                      if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                         Object this$color = this.getColor();
                                                         Object other$color = other.getColor();
                                                         if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                            Object this$createTime = this.getCreateTime();
                                                            Object other$createTime = other.getCreateTime();
                                                            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                               Object this$TransferIds = this.getTransferIds();
                                                               Object other$TransferIds = other.getTransferIds();
                                                               if (this$TransferIds == null
                                                                  ? other$TransferIds == null
                                                                  : this$TransferIds.equals(other$TransferIds)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryTransferBuyInDTOParam;
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
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
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
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $TransferIds = this.getTransferIds();
      result = result * 59 + ($TransferIds == null ? 43 : $TransferIds.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      return result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryTransferBuyInDTOParam(projectWarehouseType="
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
         + ", brand="
         + this.getBrand()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", color="
         + this.getColor()
         + ", createTime="
         + this.getCreateTime()
         + ", TransferIds="
         + this.getTransferIds()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ")";
   }

   public QueryTransferBuyInDTOParam(
      final Integer projectWarehouseType,
      final Integer materialIsWhole,
      final Long projectId,
      final Integer basicClass,
      final List<Long> classifyId,
      final List<Long> classifyIds,
      final BigDecimal minLength,
      final BigDecimal maxLength,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal theoryThickness,
      final BigDecimal thickness,
      final String heatNoAndBatchNo,
      final String specification,
      final String brand,
      final Long warehouseId,
      final Long workshopId,
      final String color,
      final List<LocalDateTime> createTime,
      final List<Long> TransferIds,
      final List<Long> workshopIds
   ) {
      this.projectWarehouseType = projectWarehouseType;
      this.materialIsWhole = materialIsWhole;
      this.projectId = projectId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyIds = classifyIds;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.length = length;
      this.width = width;
      this.theoryThickness = theoryThickness;
      this.thickness = thickness;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.specification = specification;
      this.brand = brand;
      this.warehouseId = warehouseId;
      this.workshopId = workshopId;
      this.color = color;
      this.createTime = createTime;
      this.TransferIds = TransferIds;
      this.workshopIds = workshopIds;
   }

   public QueryTransferBuyInDTOParam() {
   }

   public static class QueryTransferBuyInDTOParamBuilder {
      private Integer projectWarehouseType;
      private Integer materialIsWhole;
      private Long projectId;
      private Integer basicClass;
      private List<Long> classifyId;
      private List<Long> classifyIds;
      private BigDecimal minLength;
      private BigDecimal maxLength;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal theoryThickness;
      private BigDecimal thickness;
      private String heatNoAndBatchNo;
      private String specification;
      private String brand;
      private Long warehouseId;
      private Long workshopId;
      private String color;
      private List<LocalDateTime> createTime;
      private List<Long> TransferIds;
      private List<Long> workshopIds;

      QueryTransferBuyInDTOParamBuilder() {
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder classifyId(final List<Long> classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder TransferIds(final List<Long> TransferIds) {
         this.TransferIds = TransferIds;
         return this;
      }

      public QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public QueryTransferBuyInDTOParam build() {
         return new QueryTransferBuyInDTOParam(
            this.projectWarehouseType,
            this.materialIsWhole,
            this.projectId,
            this.basicClass,
            this.classifyId,
            this.classifyIds,
            this.minLength,
            this.maxLength,
            this.length,
            this.width,
            this.theoryThickness,
            this.thickness,
            this.heatNoAndBatchNo,
            this.specification,
            this.brand,
            this.warehouseId,
            this.workshopId,
            this.color,
            this.createTime,
            this.TransferIds,
            this.workshopIds
         );
      }

      @Override
      public String toString() {
         return "QueryTransferBuyInDTOParam.QueryTransferBuyInDTOParamBuilder(projectWarehouseType="
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
            + ", brand="
            + this.brand
            + ", warehouseId="
            + this.warehouseId
            + ", workshopId="
            + this.workshopId
            + ", color="
            + this.color
            + ", createTime="
            + this.createTime
            + ", TransferIds="
            + this.TransferIds
            + ", workshopIds="
            + this.workshopIds
            + ")";
      }
   }
}
