package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("围护计划详情响应类")
public class EnclosurePlanTechDto {
   @ApiModelProperty(name = "id", value = "计划id")
   private Long id;
   @ApiModelProperty(name = "projectContentEnum", value = "合同内筒枚举")
   private Integer projectContentEnum;
   @ApiModelProperty(name = "projectContent", value = "合同内筒")
   private String projectContent;
   @ApiModelProperty(name = "unit", value = "单位")
   private String unit;
   @ApiModelProperty(name = "quantityWork", value = "工程量")
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "category", value = "类型")
   private Integer category;

   public Long getId() {
      return this.id;
   }

   public Integer getProjectContentEnum() {
      return this.projectContentEnum;
   }

   public String getProjectContent() {
      return this.projectContent;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public Integer getCategory() {
      return this.category;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectContentEnum(final Integer projectContentEnum) {
      this.projectContentEnum = projectContentEnum;
   }

   public void setProjectContent(final String projectContent) {
      this.projectContent = projectContent;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosurePlanTechDto)) {
         return false;
      }

      EnclosurePlanTechDto other = (EnclosurePlanTechDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectContentEnum = this.getProjectContentEnum();
         Object other$projectContentEnum = other.getProjectContentEnum();
         if (this$projectContentEnum == null ? other$projectContentEnum == null : this$projectContentEnum.equals(other$projectContentEnum)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$projectContent = this.getProjectContent();
               Object other$projectContent = other.getProjectContent();
               if (this$projectContent == null ? other$projectContent == null : this$projectContent.equals(other$projectContent)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$quantityWork = this.getQuantityWork();
                     Object other$quantityWork = other.getQuantityWork();
                     return this$quantityWork == null ? other$quantityWork == null : this$quantityWork.equals(other$quantityWork);
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
      return other instanceof EnclosurePlanTechDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectContentEnum = this.getProjectContentEnum();
      result = result * 59 + ($projectContentEnum == null ? 43 : $projectContentEnum.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $quantityWork = this.getQuantityWork();
      return result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosurePlanTechDto(id="
         + this.getId()
         + ", projectContentEnum="
         + this.getProjectContentEnum()
         + ", projectContent="
         + this.getProjectContent()
         + ", unit="
         + this.getUnit()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", category="
         + this.getCategory()
         + ")";
   }
}
