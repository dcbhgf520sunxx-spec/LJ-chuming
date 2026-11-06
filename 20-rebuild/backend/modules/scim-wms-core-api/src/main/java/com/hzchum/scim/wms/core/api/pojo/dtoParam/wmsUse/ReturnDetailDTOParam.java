package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class ReturnDetailDTOParam {
   private Long id;
   private String specification;
   private Long classifyId;
   private Integer basicClass;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private String brand;
   private String heatNoAndBatchNo;
   private BigDecimal quantity;
   private BigDecimal mete;
   private Long factoryId;
   private Long warehouseId;
   private String remark;
   private Long materialReturnableId;

   public static ReturnDetailDTOParam.ReturnDetailDTOParamBuilder builder() {
      return new ReturnDetailDTOParam.ReturnDetailDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getMaterialReturnableId() {
      return this.materialReturnableId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMaterialReturnableId(final Long materialReturnableId) {
      this.materialReturnableId = materialReturnableId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnDetailDTOParam)) {
         return false;
      }

      ReturnDetailDTOParam other = (ReturnDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$materialReturnableId = this.getMaterialReturnableId();
                     Object other$materialReturnableId = other.getMaterialReturnableId();
                     if (this$materialReturnableId == null ? other$materialReturnableId == null : this$materialReturnableId.equals(other$materialReturnableId)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$width = this.getWidth();
                              Object other$width = other.getWidth();
                              if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                 Object this$thickness = this.getThickness();
                                 Object other$thickness = other.getThickness();
                                 if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                    Object this$brand = this.getBrand();
                                    Object other$brand = other.getBrand();
                                    if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                       Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                       Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                       if (this$heatNoAndBatchNo == null
                                          ? other$heatNoAndBatchNo == null
                                          : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                Object this$remark = this.getRemark();
                                                Object other$remark = other.getRemark();
                                                return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ReturnDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $materialReturnableId = this.getMaterialReturnableId();
      result = result * 59 + ($materialReturnableId == null ? 43 : $materialReturnableId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnDetailDTOParam(id="
         + this.getId()
         + ", specification="
         + this.getSpecification()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", factoryId="
         + this.getFactoryId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", remark="
         + this.getRemark()
         + ", materialReturnableId="
         + this.getMaterialReturnableId()
         + ")";
   }

   public ReturnDetailDTOParam(
      final Long id,
      final String specification,
      final Long classifyId,
      final Integer basicClass,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String heatNoAndBatchNo,
      final BigDecimal quantity,
      final BigDecimal mete,
      final Long factoryId,
      final Long warehouseId,
      final String remark,
      final Long materialReturnableId
   ) {
      this.id = id;
      this.specification = specification;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.quantity = quantity;
      this.mete = mete;
      this.factoryId = factoryId;
      this.warehouseId = warehouseId;
      this.remark = remark;
      this.materialReturnableId = materialReturnableId;
   }

   public ReturnDetailDTOParam() {
   }

   public static class ReturnDetailDTOParamBuilder {
      private Long id;
      private String specification;
      private Long classifyId;
      private Integer basicClass;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String heatNoAndBatchNo;
      private BigDecimal quantity;
      private BigDecimal mete;
      private Long factoryId;
      private Long warehouseId;
      private String remark;
      private Long materialReturnableId;

      ReturnDetailDTOParamBuilder() {
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ReturnDetailDTOParam.ReturnDetailDTOParamBuilder materialReturnableId(final Long materialReturnableId) {
         this.materialReturnableId = materialReturnableId;
         return this;
      }

      public ReturnDetailDTOParam build() {
         return new ReturnDetailDTOParam(
            this.id,
            this.specification,
            this.classifyId,
            this.basicClass,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.quantity,
            this.mete,
            this.factoryId,
            this.warehouseId,
            this.remark,
            this.materialReturnableId
         );
      }

      @Override
      public String toString() {
         return "ReturnDetailDTOParam.ReturnDetailDTOParamBuilder(id="
            + this.id
            + ", specification="
            + this.specification
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", factoryId="
            + this.factoryId
            + ", warehouseId="
            + this.warehouseId
            + ", remark="
            + this.remark
            + ", materialReturnableId="
            + this.materialReturnableId
            + ")";
      }
   }
}
