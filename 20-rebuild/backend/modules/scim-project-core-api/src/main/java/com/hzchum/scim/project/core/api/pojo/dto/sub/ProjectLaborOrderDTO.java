package com.hzchum.scim.project.core.api.pojo.dto.sub;

import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectLaborOrderDTO", description = "清单划分包信息")
public class ProjectLaborOrderDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "分包编号", notes = "分包编号")
   private String serialNumber;
   @ApiModelProperty(name = "supplier")
   private IdAndNameDTO supplier;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "围护细类")
   private Integer category;
   @ApiModelProperty(name = "measureMode", notes = "计量方式 构件:1理计2磅记, 围护:1长度计量2面积计量")
   private Integer measureMode;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "actualQuantity", value = "实际安装数量", notes = "实际安装数量")
   private Integer actualQuantity;
   @ApiModelProperty(name = "mete", value = "总量")
   private BigDecimal mete;
   @ApiModelProperty(name = "actualMete", value = "实际安装总量")
   private BigDecimal actualMete;

   public static ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder builder() {
      return new ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder();
   }

   public ProjectLaborOrderDTO() {
   }

   public ProjectLaborOrderDTO(
      final Long id,
      final String serialNumber,
      final IdAndNameDTO supplier,
      final Integer productType,
      final Integer category,
      final Integer measureMode,
      final Integer quantity,
      final Integer actualQuantity,
      final BigDecimal mete,
      final BigDecimal actualMete
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.supplier = supplier;
      this.productType = productType;
      this.category = category;
      this.measureMode = measureMode;
      this.quantity = quantity;
      this.actualQuantity = actualQuantity;
      this.mete = mete;
      this.actualMete = actualMete;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public IdAndNameDTO getSupplier() {
      return this.supplier;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getMeasureMode() {
      return this.measureMode;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public ProjectLaborOrderDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectLaborOrderDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProjectLaborOrderDTO setSupplier(final IdAndNameDTO supplier) {
      this.supplier = supplier;
      return this;
   }

   public ProjectLaborOrderDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProjectLaborOrderDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public ProjectLaborOrderDTO setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
      return this;
   }

   public ProjectLaborOrderDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public ProjectLaborOrderDTO setActualQuantity(final Integer actualQuantity) {
      this.actualQuantity = actualQuantity;
      return this;
   }

   public ProjectLaborOrderDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public ProjectLaborOrderDTO setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLaborOrderDTO)) {
         return false;
      }

      ProjectLaborOrderDTO other = (ProjectLaborOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$measureMode = this.getMeasureMode();
               Object other$measureMode = other.getMeasureMode();
               if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$actualQuantity = this.getActualQuantity();
                     Object other$actualQuantity = other.getActualQuantity();
                     if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$supplier = this.getSupplier();
                           Object other$supplier = other.getSupplier();
                           if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                              Object this$mete = this.getMete();
                              Object other$mete = other.getMete();
                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                 Object this$actualMete = this.getActualMete();
                                 Object other$actualMete = other.getActualMete();
                                 return this$actualMete == null ? other$actualMete == null : this$actualMete.equals(other$actualMete);
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
      return other instanceof ProjectLaborOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $actualMete = this.getActualMete();
      return result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLaborOrderDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplier="
         + this.getSupplier()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", measureMode="
         + this.getMeasureMode()
         + ", quantity="
         + this.getQuantity()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", mete="
         + this.getMete()
         + ", actualMete="
         + this.getActualMete()
         + ")";
   }

   public static class ProjectLaborOrderDTOBuilder {
      private Long id;
      private String serialNumber;
      private IdAndNameDTO supplier;
      private Integer productType;
      private Integer category;
      private Integer measureMode;
      private Integer quantity;
      private Integer actualQuantity;
      private BigDecimal mete;
      private BigDecimal actualMete;

      ProjectLaborOrderDTOBuilder() {
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder supplier(final IdAndNameDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder actualQuantity(final Integer actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      public ProjectLaborOrderDTO build() {
         return new ProjectLaborOrderDTO(
            this.id,
            this.serialNumber,
            this.supplier,
            this.productType,
            this.category,
            this.measureMode,
            this.quantity,
            this.actualQuantity,
            this.mete,
            this.actualMete
         );
      }

      @Override
      public String toString() {
         return "ProjectLaborOrderDTO.ProjectLaborOrderDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", supplier="
            + this.supplier
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", measureMode="
            + this.measureMode
            + ", quantity="
            + this.quantity
            + ", actualQuantity="
            + this.actualQuantity
            + ", mete="
            + this.mete
            + ", actualMete="
            + this.actualMete
            + ")";
      }
   }
}
