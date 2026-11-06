package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("构件商务-区域合并")
public class ArtifactMergeAreaDTOParam {
   @ApiModelProperty("单体id")
   @NotNull(message = "单体id不能为空")
   private Long monomerId;
   @ApiModelProperty
   @NotEmpty(message = "区域id不能为空")
   private Set<Long> areaIds;

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Set<Long> getAreaIds() {
      return this.areaIds;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaIds(final Set<Long> areaIds) {
      this.areaIds = areaIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactMergeAreaDTOParam)) {
         return false;
      } else {
         ArtifactMergeAreaDTOParam other = (ArtifactMergeAreaDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaIds = this.getAreaIds();
               Object other$areaIds = other.getAreaIds();
               return this$areaIds == null ? other$areaIds == null : this$areaIds.equals(other$areaIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactMergeAreaDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaIds = this.getAreaIds();
      return result * 59 + ($areaIds == null ? 43 : $areaIds.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactMergeAreaDTOParam(monomerId=" + this.getMonomerId() + ", areaIds=" + this.getAreaIds() + ")";
   }
}
