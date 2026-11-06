package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class EnclosureFindDTOParam {
   private List<Long> ids;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "category", value = "品类")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "plate", value = "板型")
   private String plate;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "thickness", value = "厚度")
   private BigDecimal thickness;

   public static EnclosureFindDTOParam.EnclosureFindDTOParamBuilder builder() {
      return new EnclosureFindDTOParam.EnclosureFindDTOParamBuilder();
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public String getName() {
      return this.name;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureFindDTOParam)) {
         return false;
      }

      EnclosureFindDTOParam other = (EnclosureFindDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$enclosurePlanId = this.getEnclosurePlanId();
            Object other$enclosurePlanId = other.getEnclosurePlanId();
            if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
               Object this$ids = this.getIds();
               Object other$ids = other.getIds();
               if (this$ids == null ? other$ids == null : this$ids.equals(other$ids)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$plate = this.getPlate();
                     Object other$plate = other.getPlate();
                     if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                        Object this$brand = this.getBrand();
                        Object other$brand = other.getBrand();
                        if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                           Object this$color = this.getColor();
                           Object other$color = other.getColor();
                           if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                              Object this$thickness = this.getThickness();
                              Object other$thickness = other.getThickness();
                              return this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness);
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
      return other instanceof EnclosureFindDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $ids = this.getIds();
      result = result * 59 + ($ids == null ? 43 : $ids.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $thickness = this.getThickness();
      return result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureFindDTOParam(ids="
         + this.getIds()
         + ", projectId="
         + this.getProjectId()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", name="
         + this.getName()
         + ", plate="
         + this.getPlate()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", thickness="
         + this.getThickness()
         + ")";
   }

   public EnclosureFindDTOParam(
      final List<Long> ids,
      final Long projectId,
      final Integer category,
      final Long enclosurePlanId,
      final String name,
      final String plate,
      final String brand,
      final String color,
      final BigDecimal thickness
   ) {
      this.ids = ids;
      this.projectId = projectId;
      this.category = category;
      this.enclosurePlanId = enclosurePlanId;
      this.name = name;
      this.plate = plate;
      this.brand = brand;
      this.color = color;
      this.thickness = thickness;
   }

   public EnclosureFindDTOParam() {
   }

   public static class EnclosureFindDTOParamBuilder {
      private List<Long> ids;
      private Long projectId;
      private Integer category;
      private Long enclosurePlanId;
      private String name;
      private String plate;
      private String brand;
      private String color;
      private BigDecimal thickness;

      EnclosureFindDTOParamBuilder() {
      }

      public EnclosureFindDTOParam.EnclosureFindDTOParamBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public EnclosureFindDTOParam.EnclosureFindDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public EnclosureFindDTOParam.EnclosureFindDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public EnclosureFindDTOParam.EnclosureFindDTOParamBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public EnclosureFindDTOParam.EnclosureFindDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public EnclosureFindDTOParam.EnclosureFindDTOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public EnclosureFindDTOParam.EnclosureFindDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public EnclosureFindDTOParam.EnclosureFindDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public EnclosureFindDTOParam.EnclosureFindDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public EnclosureFindDTOParam build() {
         return new EnclosureFindDTOParam(
            this.ids, this.projectId, this.category, this.enclosurePlanId, this.name, this.plate, this.brand, this.color, this.thickness
         );
      }

      @Override
      public String toString() {
         return "EnclosureFindDTOParam.EnclosureFindDTOParamBuilder(ids="
            + this.ids
            + ", projectId="
            + this.projectId
            + ", category="
            + this.category
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", name="
            + this.name
            + ", plate="
            + this.plate
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", thickness="
            + this.thickness
            + ")";
      }
   }
}
