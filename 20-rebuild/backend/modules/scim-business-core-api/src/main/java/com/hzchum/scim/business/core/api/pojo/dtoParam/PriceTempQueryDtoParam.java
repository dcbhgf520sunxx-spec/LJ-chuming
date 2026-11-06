package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class PriceTempQueryDtoParam {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "relationType", value = "关联类型", notes = "关联类型")
   private Integer relationType;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "category", value = "围护分类", notes = "围护分类")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划id", notes = "围护计划id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢 2桥梁 4立体停车库 8围护项目", notes = "项目类型 1建钢 2桥梁 4立体停车库 8围护项目")
   private Integer projectType;
   @NotNull(message = "产品类型不能为空")
   @ApiModelProperty(name = "type", value = "产品类型 建钢项目: 1零件 2构件 4围护 8标准件 桥梁项目: 1分段件 围护项目: 4围护", notes = "产品类型 建钢项目: 1零件 2构件 4围护 8标准件 桥梁项目: 1分段件 围护项目: 4围护")
   private Integer type;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getRelationType() {
      return this.relationType;
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

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getType() {
      return this.type;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
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

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PriceTempQueryDtoParam)) {
         return false;
      }

      PriceTempQueryDtoParam other = (PriceTempQueryDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$relationType = this.getRelationType();
         Object other$relationType = other.getRelationType();
         if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$enclosurePlanId = this.getEnclosurePlanId();
                     Object other$enclosurePlanId = other.getEnclosurePlanId();
                     if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                        Object this$projectType = this.getProjectType();
                        Object other$projectType = other.getProjectType();
                        if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           return this$type == null ? other$type == null : this$type.equals(other$type);
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
      return other instanceof PriceTempQueryDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "PriceTempQueryDtoParam(projectId="
         + this.getProjectId()
         + ", relationType="
         + this.getRelationType()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", projectType="
         + this.getProjectType()
         + ", type="
         + this.getType()
         + ")";
   }
}
