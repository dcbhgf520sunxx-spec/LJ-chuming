package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 焊接工艺工单 新增 请求参数")
public class CappCraftProductTaskSaveDTO {
   @ApiModelProperty(name = "mesBuildingTaskId", value = "mes工单id", notes = "mes工单id")
   @JsonProperty("mesBuildingTaskId")
   @JSONField(name = "mesBuildingTaskId")
   private Long mesBuildingTaskId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;

   public Long getMesBuildingTaskId() {
      return this.mesBuildingTaskId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   @JsonProperty("mesBuildingTaskId")
   public void setMesBuildingTaskId(final Long mesBuildingTaskId) {
      this.mesBuildingTaskId = mesBuildingTaskId;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("monomerId")
   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @JsonProperty("areaId")
   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   @JsonProperty("productionLineId")
   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftProductTaskSaveDTO)) {
         return false;
      }

      CappCraftProductTaskSaveDTO other = (CappCraftProductTaskSaveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$mesBuildingTaskId = this.getMesBuildingTaskId();
      Object other$mesBuildingTaskId = other.getMesBuildingTaskId();
      if (this$mesBuildingTaskId == null ? other$mesBuildingTaskId == null : this$mesBuildingTaskId.equals(other$mesBuildingTaskId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     return this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId);
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
      return other instanceof CappCraftProductTaskSaveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mesBuildingTaskId = this.getMesBuildingTaskId();
      result = result * 59 + ($mesBuildingTaskId == null ? 43 : $mesBuildingTaskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      return result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftProductTaskSaveDTO(mesBuildingTaskId="
         + this.getMesBuildingTaskId()
         + ", productId="
         + this.getProductId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ")";
   }
}
