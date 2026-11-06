package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class TechChangeImportDTO {
   @ApiModelProperty("redisKey")
   private String redisKey;
   @ApiModelProperty("导入构件列表")
   private List<TechChangeArtifactDTO> artifactList;

   public String getRedisKey() {
      return this.redisKey;
   }

   public List<TechChangeArtifactDTO> getArtifactList() {
      return this.artifactList;
   }

   public void setRedisKey(final String redisKey) {
      this.redisKey = redisKey;
   }

   public void setArtifactList(final List<TechChangeArtifactDTO> artifactList) {
      this.artifactList = artifactList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TechChangeImportDTO)) {
         return false;
      } else {
         TechChangeImportDTO other = (TechChangeImportDTO)o;
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
      return other instanceof TechChangeImportDTO;
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
      return "TechChangeImportDTO(redisKey=" + this.getRedisKey() + ", artifactList=" + this.getArtifactList() + ")";
   }
}
