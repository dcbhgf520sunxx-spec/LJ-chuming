package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 工艺库 简单列表 请求参数")
public class CappCraftCardStorehouseSimpleListDTO {
   @ApiModelProperty(name = "craftType", value = "工艺类型参考枚举 CappCraftTypeEnum", notes = "工艺类型参考枚举 CappCraftTypeEnum")
   private Integer craftType;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;

   public CappCraftCardStorehouseSimpleListDTO(final Integer craftType, final Long projectId) {
      this.craftType = craftType;
      this.projectId = projectId;
   }

   public CappCraftCardStorehouseSimpleListDTO() {
   }

   public Integer getCraftType() {
      return this.craftType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public void setCraftType(final Integer craftType) {
      this.craftType = craftType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CappCraftCardStorehouseSimpleListDTO)) {
         return false;
      } else {
         CappCraftCardStorehouseSimpleListDTO other = (CappCraftCardStorehouseSimpleListDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$craftType = this.getCraftType();
            Object other$craftType = other.getCraftType();
            if (this$craftType == null ? other$craftType == null : this$craftType.equals(other$craftType)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               return this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardStorehouseSimpleListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $craftType = this.getCraftType();
      result = result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
      Object $projectId = this.getProjectId();
      return result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardStorehouseSimpleListDTO(craftType=" + this.getCraftType() + ", projectId=" + this.getProjectId() + ")";
   }
}
