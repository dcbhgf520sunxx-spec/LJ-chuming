package com.hzchum.scim.project.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SubBusinessCheckDetailDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
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
   @ApiModelProperty(name = "oldUnitPrice", value = "原有单价")
   private BigDecimal oldUnitPrice;
   @ApiModelProperty(name = "newUnitPrice", value = "原有单价")
   private BigDecimal newUnitPrice;

   public static SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder builder() {
      return new SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder();
   }

   public SubBusinessCheckDetailDTO() {
   }

   public SubBusinessCheckDetailDTO(
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final Integer type,
      final String name,
      final String material,
      final String measure,
      final String nuclear,
      final Integer totalQuantity,
      final BigDecimal totalMete,
      final BigDecimal oldUnitPrice,
      final BigDecimal newUnitPrice
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.type = type;
      this.name = name;
      this.material = material;
      this.measure = measure;
      this.nuclear = nuclear;
      this.totalQuantity = totalQuantity;
      this.totalMete = totalMete;
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

      if (!(o instanceof SubBusinessCheckDetailDTO)) {
         return false;
      }

      SubBusinessCheckDetailDTO other = (SubBusinessCheckDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$totalQuantity = this.getTotalQuantity();
         Object other$totalQuantity = other.getTotalQuantity();
         if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
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
      return other instanceof SubBusinessCheckDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
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
      Object $oldUnitPrice = this.getOldUnitPrice();
      result = result * 59 + ($oldUnitPrice == null ? 43 : $oldUnitPrice.hashCode());
      Object $newUnitPrice = this.getNewUnitPrice();
      return result * 59 + ($newUnitPrice == null ? 43 : $newUnitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "SubBusinessCheckDetailDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
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
         + ", oldUnitPrice="
         + this.getOldUnitPrice()
         + ", newUnitPrice="
         + this.getNewUnitPrice()
         + ")";
   }

   public static class SubBusinessCheckDetailDTOBuilder {
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private Integer type;
      private String name;
      private String material;
      private String measure;
      private String nuclear;
      private Integer totalQuantity;
      private BigDecimal totalMete;
      private BigDecimal oldUnitPrice;
      private BigDecimal newUnitPrice;

      SubBusinessCheckDetailDTOBuilder() {
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder measure(final String measure) {
         this.measure = measure;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder nuclear(final String nuclear) {
         this.nuclear = nuclear;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder oldUnitPrice(final BigDecimal oldUnitPrice) {
         this.oldUnitPrice = oldUnitPrice;
         return this;
      }

      public SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder newUnitPrice(final BigDecimal newUnitPrice) {
         this.newUnitPrice = newUnitPrice;
         return this;
      }

      public SubBusinessCheckDetailDTO build() {
         return new SubBusinessCheckDetailDTO(
            this.project,
            this.monomer,
            this.area,
            this.type,
            this.name,
            this.material,
            this.measure,
            this.nuclear,
            this.totalQuantity,
            this.totalMete,
            this.oldUnitPrice,
            this.newUnitPrice
         );
      }

      @Override
      public String toString() {
         return "SubBusinessCheckDetailDTO.SubBusinessCheckDetailDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
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
            + ", oldUnitPrice="
            + this.oldUnitPrice
            + ", newUnitPrice="
            + this.newUnitPrice
            + ")";
      }
   }
}
