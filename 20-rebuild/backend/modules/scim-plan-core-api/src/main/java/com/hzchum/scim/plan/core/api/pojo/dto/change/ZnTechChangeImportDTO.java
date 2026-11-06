package com.hzchum.scim.plan.core.api.pojo.dto.change;

import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ZnTechChangeImportDTO {
   @ApiModelProperty("redisKey")
   private String redisKey;
   @ApiModelProperty("导入构件列表")
   private List<ArtifactBoxImportDTO> artifactList;

   public String getRedisKey() {
      return this.redisKey;
   }

   public List<ArtifactBoxImportDTO> getArtifactList() {
      return this.artifactList;
   }

   public void setRedisKey(final String redisKey) {
      this.redisKey = redisKey;
   }

   public void setArtifactList(final List<ArtifactBoxImportDTO> artifactList) {
      this.artifactList = artifactList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ZnTechChangeImportDTO)) {
         return false;
      } else {
         ZnTechChangeImportDTO other = (ZnTechChangeImportDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$redisKey = this.getRedisKey();
            Object other$redisKey = other.getRedisKey();
            if (this$redisKey == null ? other$redisKey == null : this$redisKey.equals(other$redisKey)) {
               Object this$artifactList = this.getArtifactList();
               Object other$artifactList = other.getArtifactList();
               return this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ZnTechChangeImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $redisKey = this.getRedisKey();
      result = result * 59 + ($redisKey == null ? 43 : $redisKey.hashCode());
      Object $artifactList = this.getArtifactList();
      return result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
   }

   @Override
   public String toString() {
      return "ZnTechChangeImportDTO(redisKey=" + this.getRedisKey() + ", artifactList=" + this.getArtifactList() + ")";
   }
}
