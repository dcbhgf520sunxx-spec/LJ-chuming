package com.hzchum.scim.project.core.api.pojo.dao;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "SubBusiness对象", description = "分包商务")
public class SubBusinessDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目id")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体id")
   private NameInfo monomer;
   @ApiModelProperty(name = "Area", value = "区域id")
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
   @ApiModelProperty(name = "unitPrice", value = "单价")
   private BigDecimal unitPrice;

   public static SubBusinessDO.SubBusinessDOBuilder builder() {
      return new SubBusinessDO.SubBusinessDOBuilder();
   }

   public Long getId() {
      return this.id;
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

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubBusinessDO)) {
         return false;
      }

      SubBusinessDO other = (SubBusinessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                                       Object this$unitPrice = this.getUnitPrice();
                                       Object other$unitPrice = other.getUnitPrice();
                                       return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof SubBusinessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "SubBusinessDO(id="
         + this.getId()
         + ", project="
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
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   public SubBusinessDO() {
   }

   public SubBusinessDO(
      final Long id,
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
      final BigDecimal unitPrice
   ) {
      this.id = id;
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
      this.unitPrice = unitPrice;
   }

   public static class SubBusinessDOBuilder {
      private Long id;
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
      private BigDecimal unitPrice;

      SubBusinessDOBuilder() {
      }

      public SubBusinessDO.SubBusinessDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder Area(final NameInfo Area) {
         this.Area = Area;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public SubBusinessDO.SubBusinessDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public SubBusinessDO build() {
         return new SubBusinessDO(
            this.id,
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
            this.unitPrice
         );
      }

      @Override
      public String toString() {
         return "SubBusinessDO.SubBusinessDOBuilder(id="
            + this.id
            + ", project="
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
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
