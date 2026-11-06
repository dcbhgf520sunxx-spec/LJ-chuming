package com.hzchum.scim.plan.core.api.pojo.dtoParam.craft;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class TechPaintTechnologyArtifactQueryParam {
   @NotNull(message = "涂装工艺id未传值!")
   @ApiModelProperty(name = "paintTechnologyId", value = "涂装工艺id", notes = "涂装工艺id")
   private Long paintTechnologyId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;

   public Long getPaintTechnologyId() {
      return this.paintTechnologyId;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public void setPaintTechnologyId(final Long paintTechnologyId) {
      this.paintTechnologyId = paintTechnologyId;
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

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechPaintTechnologyArtifactQueryParam)) {
         return false;
      }

      TechPaintTechnologyArtifactQueryParam other = (TechPaintTechnologyArtifactQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paintTechnologyId = this.getPaintTechnologyId();
      Object other$paintTechnologyId = other.getPaintTechnologyId();
      if (this$paintTechnologyId == null ? other$paintTechnologyId == null : this$paintTechnologyId.equals(other$paintTechnologyId)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof TechPaintTechnologyArtifactQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paintTechnologyId = this.getPaintTechnologyId();
      result = result * 59 + ($paintTechnologyId == null ? 43 : $paintTechnologyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "TechPaintTechnologyArtifactQueryParam(paintTechnologyId="
         + this.getPaintTechnologyId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }
}
