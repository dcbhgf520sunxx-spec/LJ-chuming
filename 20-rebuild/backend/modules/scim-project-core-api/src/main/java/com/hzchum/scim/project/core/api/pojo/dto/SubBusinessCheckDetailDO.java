package com.hzchum.scim.project.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SubBusinessCheckDetailDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "Area", value = "区域")
   private NameInfo Area;
   @ApiModelProperty(name = "type", value = "类型")
   private Integer type;
   @ApiModelProperty(name = "category", value = "类别（针对围护使用获取计量方式）")
   private Integer category;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "material", value = "材质 若非合并计价，材质为空")
   private String material;
   @ApiModelProperty(name = "totalQuantity", value = "总数")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalMete", value = "总重/总长")
   private BigDecimal totalMete;
   @ApiModelProperty(name = "totalArea", value = "总面积")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "oldUnitPrice", value = "原有单价")
   private BigDecimal oldUnitPrice;
   @ApiModelProperty(name = "newUnitPrice", value = "原有单价")
   private BigDecimal newUnitPrice;

   public static SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder builder() {
      return new SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder();
   }

   public SubBusinessCheckDetailDO() {
   }

   public SubBusinessCheckDetailDO(
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo Area,
      final Integer type,
      final Integer category,
      final String name,
      final String material,
      final Integer totalQuantity,
      final BigDecimal totalMete,
      final BigDecimal totalArea,
      final BigDecimal oldUnitPrice,
      final BigDecimal newUnitPrice
   ) {
      this.project = project;
      this.monomer = monomer;
      this.Area = Area;
      this.type = type;
      this.category = category;
      this.name = name;
      this.material = material;
      this.totalQuantity = totalQuantity;
      this.totalMete = totalMete;
      this.totalArea = totalArea;
      this.oldUnitPrice = oldUnitPrice;
      this.newUnitPrice = newUnitPrice;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.Area;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getOldUnitPrice() {
      return this.oldUnitPrice;
   }

   public BigDecimal getNewUnitPrice() {
      return this.newUnitPrice;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo Area) {
      this.Area = Area;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setOldUnitPrice(final BigDecimal oldUnitPrice) {
      this.oldUnitPrice = oldUnitPrice;
   }

   public void setNewUnitPrice(final BigDecimal newUnitPrice) {
      this.newUnitPrice = newUnitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubBusinessCheckDetailDO)) {
         return false;
      }

      SubBusinessCheckDetailDO other = (SubBusinessCheckDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$totalQuantity = this.getTotalQuantity();
            Object other$totalQuantity = other.getTotalQuantity();
            if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$Area = this.getArea();
                     Object other$Area = other.getArea();
                     if (this$Area == null ? other$Area == null : this$Area.equals(other$Area)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$totalMete = this.getTotalMete();
                              Object other$totalMete = other.getTotalMete();
                              if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
                                 Object this$totalArea = this.getTotalArea();
                                 Object other$totalArea = other.getTotalArea();
                                 if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                    Object this$oldUnitPrice = this.getOldUnitPrice();
                                    Object other$oldUnitPrice = other.getOldUnitPrice();
                                    if (this$oldUnitPrice == null ? other$oldUnitPrice == null : this$oldUnitPrice.equals(other$oldUnitPrice)) {
                                       Object this$newUnitPrice = this.getNewUnitPrice();
                                       Object other$newUnitPrice = other.getNewUnitPrice();
                                       return this$newUnitPrice == null ? other$newUnitPrice == null : this$newUnitPrice.equals(other$newUnitPrice);
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
      return other instanceof SubBusinessCheckDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $Area = this.getArea();
      result = result * 59 + ($Area == null ? 43 : $Area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $oldUnitPrice = this.getOldUnitPrice();
      result = result * 59 + ($oldUnitPrice == null ? 43 : $oldUnitPrice.hashCode());
      Object $newUnitPrice = this.getNewUnitPrice();
      return result * 59 + ($newUnitPrice == null ? 43 : $newUnitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "SubBusinessCheckDetailDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", Area="
         + this.getArea()
         + ", type="
         + this.getType()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", totalArea="
         + this.getTotalArea()
         + ", oldUnitPrice="
         + this.getOldUnitPrice()
         + ", newUnitPrice="
         + this.getNewUnitPrice()
         + ")";
   }

   public static class SubBusinessCheckDetailDOBuilder {
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo Area;
      private Integer type;
      private Integer category;
      private String name;
      private String material;
      private Integer totalQuantity;
      private BigDecimal totalMete;
      private BigDecimal totalArea;
      private BigDecimal oldUnitPrice;
      private BigDecimal newUnitPrice;

      SubBusinessCheckDetailDOBuilder() {
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder Area(final NameInfo Area) {
         this.Area = Area;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder oldUnitPrice(final BigDecimal oldUnitPrice) {
         this.oldUnitPrice = oldUnitPrice;
         return this;
      }

      public SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder newUnitPrice(final BigDecimal newUnitPrice) {
         this.newUnitPrice = newUnitPrice;
         return this;
      }

      public SubBusinessCheckDetailDO build() {
         return new SubBusinessCheckDetailDO(
            this.project,
            this.monomer,
            this.Area,
            this.type,
            this.category,
            this.name,
            this.material,
            this.totalQuantity,
            this.totalMete,
            this.totalArea,
            this.oldUnitPrice,
            this.newUnitPrice
         );
      }

      @Override
      public String toString() {
         return "SubBusinessCheckDetailDO.SubBusinessCheckDetailDOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", Area="
            + this.Area
            + ", type="
            + this.type
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalMete="
            + this.totalMete
            + ", totalArea="
            + this.totalArea
            + ", oldUnitPrice="
            + this.oldUnitPrice
            + ", newUnitPrice="
            + this.newUnitPrice
            + ")";
      }
   }
}
