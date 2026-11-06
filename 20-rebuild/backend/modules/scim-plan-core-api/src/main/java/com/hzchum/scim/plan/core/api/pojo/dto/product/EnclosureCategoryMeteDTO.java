package com.hzchum.scim.plan.core.api.pojo.dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class EnclosureCategoryMeteDTO {
   @ApiModelProperty("项目id")
   @JsonInclude(Include.NON_NULL)
   private Long projectId;
   @ApiModelProperty("区域id")
   @JsonInclude(Include.NON_NULL)
   private Long areaId;
   @ApiModelProperty("围护分类")
   private Integer category;
   @ApiModelProperty("长度")
   private BigDecimal mete;
   @ApiModelProperty("数量")
   private Integer quantity;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureCategoryMeteDTO)) {
         return false;
      }

      EnclosureCategoryMeteDTO other = (EnclosureCategoryMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof EnclosureCategoryMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureCategoryMeteDTO(projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
         + ", category="
         + this.getCategory()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }
}
