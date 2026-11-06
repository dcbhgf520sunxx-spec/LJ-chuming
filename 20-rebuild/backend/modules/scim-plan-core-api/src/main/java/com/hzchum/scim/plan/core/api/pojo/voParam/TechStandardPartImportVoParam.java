package com.hzchum.scim.plan.core.api.pojo.voParam;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class TechStandardPartImportVoParam {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @NotNull(message = "项目必传!")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "category", value = "品类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典表id")
   private Long dictionaryId;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   private Long enclosurePlanId;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartImportVoParam)) {
         return false;
      }

      TechStandardPartImportVoParam other = (TechStandardPartImportVoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$dictionaryId = this.getDictionaryId();
                  Object other$dictionaryId = other.getDictionaryId();
                  if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                     Object this$enclosurePlanId = this.getEnclosurePlanId();
                     Object other$enclosurePlanId = other.getEnclosurePlanId();
                     return this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId);
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
      return other instanceof TechStandardPartImportVoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      return result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
   }

   @Override
   public String toString() {
      return "TechStandardPartImportVoParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ")";
   }
}
