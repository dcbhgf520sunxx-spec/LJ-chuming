package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TechAuxiliaryPart对象", description = "新配套件汇总 ")
public class TechAuxiliaryPartSummaryDTO {
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）", notes = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder builder() {
      return new TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder();
   }

   public TechAuxiliaryPartSummaryDTO() {
   }

   public TechAuxiliaryPartSummaryDTO(
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final String name,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final String remark
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.name = name;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.remark = remark;
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

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
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

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAuxiliaryPartSummaryDTO)) {
         return false;
      }

      TechAuxiliaryPartSummaryDTO other = (TechAuxiliaryPartSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$length = this.getLength();
                        Object other$length = other.getLength();
                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechAuxiliaryPartSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "TechAuxiliaryPartSummaryDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class TechAuxiliaryPartSummaryDTOBuilder {
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private String name;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private String remark;

      TechAuxiliaryPartSummaryDTOBuilder() {
      }

      public TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechAuxiliaryPartSummaryDTO build() {
         return new TechAuxiliaryPartSummaryDTO(
            this.project, this.monomer, this.area, this.name, this.specification, this.length, this.material, this.quantity, this.remark
         );
      }

      @Override
      public String toString() {
         return "TechAuxiliaryPartSummaryDTO.TechAuxiliaryPartSummaryDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
