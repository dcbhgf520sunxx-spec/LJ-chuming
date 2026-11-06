package com.hzchum.scim.project.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "SubBusiness对象", description = "分包商务")
public class SubBusinessDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目id")
   private ProjectInfo project;
   @ApiModelProperty(name = "area", value = "区域id")
   private NameInfo area;
   @ApiModelProperty(name = "type", value = "类型")
   private Integer type;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "material", value = "材质 若非合并计价，材质为空")
   private String material;
   @ApiModelProperty(name = "measure", value = "计量")
   private String measure;
   @ApiModelProperty(name = "nuclear", value = "核算")
   private String nuclear;
   @ApiModelProperty(name = "totalQuantity", value = "总数")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalMete", value = "总重/总长/总面积")
   private BigDecimal totalMete;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   private BigDecimal unitPrice;

   public static SubBusinessDTO.SubBusinessDTOBuilder builder() {
      return new SubBusinessDTO.SubBusinessDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getMeasure() {
      return this.measure;
   }

   public String getNuclear() {
      return this.nuclear;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
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

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setMeasure(final String measure) {
      this.measure = measure;
   }

   public void setNuclear(final String nuclear) {
      this.nuclear = nuclear;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubBusinessDTO)) {
         return false;
      }

      SubBusinessDTO other = (SubBusinessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$totalQuantity = this.getTotalQuantity();
            Object other$totalQuantity = other.getTotalQuantity();
            if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$measure = this.getMeasure();
                           Object other$measure = other.getMeasure();
                           if (this$measure == null ? other$measure == null : this$measure.equals(other$measure)) {
                              Object this$nuclear = this.getNuclear();
                              Object other$nuclear = other.getNuclear();
                              if (this$nuclear == null ? other$nuclear == null : this$nuclear.equals(other$nuclear)) {
                                 Object this$totalMete = this.getTotalMete();
                                 Object other$totalMete = other.getTotalMete();
                                 if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubBusinessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $measure = this.getMeasure();
      result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
      Object $nuclear = this.getNuclear();
      result = result * 59 + ($nuclear == null ? 43 : $nuclear.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "SubBusinessDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", area="
         + this.getArea()
         + ", type="
         + this.getType()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", measure="
         + this.getMeasure()
         + ", nuclear="
         + this.getNuclear()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   public SubBusinessDTO() {
   }

   public SubBusinessDTO(
      final Long id,
      final ProjectInfo project,
      final NameInfo area,
      final Integer type,
      final String name,
      final String material,
      final String measure,
      final String nuclear,
      final Integer totalQuantity,
      final BigDecimal totalMete,
      final BigDecimal unitPrice
   ) {
      this.id = id;
      this.project = project;
      this.area = area;
      this.type = type;
      this.name = name;
      this.material = material;
      this.measure = measure;
      this.nuclear = nuclear;
      this.totalQuantity = totalQuantity;
      this.totalMete = totalMete;
      this.unitPrice = unitPrice;
   }

   public static class SubBusinessDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private NameInfo area;
      private Integer type;
      private String name;
      private String material;
      private String measure;
      private String nuclear;
      private Integer totalQuantity;
      private BigDecimal totalMete;
      private BigDecimal unitPrice;

      SubBusinessDTOBuilder() {
      }

      public SubBusinessDTO.SubBusinessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder measure(final String measure) {
         this.measure = measure;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder nuclear(final String nuclear) {
         this.nuclear = nuclear;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public SubBusinessDTO.SubBusinessDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public SubBusinessDTO build() {
         return new SubBusinessDTO(
            this.id,
            this.project,
            this.area,
            this.type,
            this.name,
            this.material,
            this.measure,
            this.nuclear,
            this.totalQuantity,
            this.totalMete,
            this.unitPrice
         );
      }

      @Override
      public String toString() {
         return "SubBusinessDTO.SubBusinessDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", area="
            + this.area
            + ", type="
            + this.type
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", measure="
            + this.measure
            + ", nuclear="
            + this.nuclear
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalMete="
            + this.totalMete
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
