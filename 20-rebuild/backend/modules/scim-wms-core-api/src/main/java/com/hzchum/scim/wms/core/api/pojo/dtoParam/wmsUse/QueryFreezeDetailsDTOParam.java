package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class QueryFreezeDetailsDTOParam {
   @ApiModelProperty(name = "idList", value = "包含的详情编号不能为空")
   private List<Long> idList;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   private Integer basicClass;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态(1 整料, 余料)")
   private Integer materialIsWhole;
   @ApiModelProperty(name = "classifyId", value = "科目id集合")
   private List<Long> classifyId;
   @ApiModelProperty(name = "classifyIds", value = "末级科目id集合")
   private List<Long> classifyIds;
   @ApiModelProperty(name = "minLength", value = "钢卷最小长度")
   private BigDecimal minLength;
   @ApiModelProperty(name = "maxLength", value = "钢卷最大长度")
   private BigDecimal maxLength;
   @ApiModelProperty(name = "length", value = "长度")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度")
   private BigDecimal width;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度")
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "thickness", value = "实际厚度")
   private BigDecimal thickness;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号/卷号")
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "workshopId", value = "仓库Id")
   private Long workshopId;
   @ApiModelProperty(name = "warehouseId", value = "仓库存储位置")
   private Long warehouseId;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;

   public static QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder builder() {
      return new QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder();
   }

   public List<Long> getIdList() {
      return this.idList;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
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

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public void setIdList(final List<Long> idList) {
      this.idList = idList;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
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

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryFreezeDetailsDTOParam)) {
         return false;
      }

      QueryFreezeDetailsDTOParam other = (QueryFreezeDetailsDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$materialIsWhole = this.getMaterialIsWhole();
         Object other$materialIsWhole = other.getMaterialIsWhole();
         if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$warehouseId = this.getWarehouseId();
               Object other$warehouseId = other.getWarehouseId();
               if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                  Object this$idList = this.getIdList();
                  Object other$idList = other.getIdList();
                  if (this$idList == null ? other$idList == null : this$idList.equals(other$idList)) {
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
                                       if (this$theoryThickness == null ? other$theoryThickness == null : this$theoryThickness.equals(other$theoryThickness)) {
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
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$color = this.getColor();
                                                   Object other$color = other.getColor();
                                                   if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                      Object this$brand = this.getBrand();
                                                      Object other$brand = other.getBrand();
                                                      return this$brand == null ? other$brand == null : this$brand.equals(other$brand);
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
      return other instanceof QueryFreezeDetailsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $idList = this.getIdList();
      result = result * 59 + ($idList == null ? 43 : $idList.hashCode());
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
      return result * 59 + ($brand == null ? 43 : $brand.hashCode());
   }

   @Override
   public String toString() {
      return "QueryFreezeDetailsDTOParam(idList="
         + this.getIdList()
         + ", basicClass="
         + this.getBasicClass()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
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
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ")";
   }

   public QueryFreezeDetailsDTOParam(
      final List<Long> idList,
      final Integer basicClass,
      final Integer materialIsWhole,
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
      final Long workshopId,
      final Long warehouseId,
      final String color,
      final String brand
   ) {
      this.idList = idList;
      this.basicClass = basicClass;
      this.materialIsWhole = materialIsWhole;
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
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.color = color;
      this.brand = brand;
   }

   public QueryFreezeDetailsDTOParam() {
   }

   public static class QueryFreezeDetailsDTOParamBuilder {
      private List<Long> idList;
      private Integer basicClass;
      private Integer materialIsWhole;
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
      private Long workshopId;
      private Long warehouseId;
      private String color;
      private String brand;

      QueryFreezeDetailsDTOParamBuilder() {
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder idList(final List<Long> idList) {
         this.idList = idList;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder classifyId(final List<Long> classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryFreezeDetailsDTOParam build() {
         return new QueryFreezeDetailsDTOParam(
            this.idList,
            this.basicClass,
            this.materialIsWhole,
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
            this.workshopId,
            this.warehouseId,
            this.color,
            this.brand
         );
      }

      @Override
      public String toString() {
         return "QueryFreezeDetailsDTOParam.QueryFreezeDetailsDTOParamBuilder(idList="
            + this.idList
            + ", basicClass="
            + this.basicClass
            + ", materialIsWhole="
            + this.materialIsWhole
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
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ")";
      }
   }
}
