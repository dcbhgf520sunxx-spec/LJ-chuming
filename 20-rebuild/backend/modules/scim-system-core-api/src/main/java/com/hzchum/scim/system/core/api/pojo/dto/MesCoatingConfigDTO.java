package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo._do.MesCoatingConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("涂装配置DTO类")
public class MesCoatingConfigDTO extends MesCoatingConfig {
   @ApiModelProperty(name = "artifactClassificationIdList", value = "构件分类id列表", notes = "构件分类id列表")
   private List<Long> artifactClassificationIdList;
   @ApiModelProperty(name = "artifactClassificationNameList", value = "构件分类名称列表", notes = "构件分类名称列表")
   private List<String> artifactClassificationNameList;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesCoatingConfigDTO)) {
         return false;
      } else {
         MesCoatingConfigDTO other = (MesCoatingConfigDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$artifactClassificationIdList = this.getArtifactClassificationIdList();
            Object other$artifactClassificationIdList = other.getArtifactClassificationIdList();
            if (this$artifactClassificationIdList == null
               ? other$artifactClassificationIdList == null
               : this$artifactClassificationIdList.equals(other$artifactClassificationIdList)) {
               Object this$artifactClassificationNameList = this.getArtifactClassificationNameList();
               Object other$artifactClassificationNameList = other.getArtifactClassificationNameList();
               return this$artifactClassificationNameList == null
                  ? other$artifactClassificationNameList == null
                  : this$artifactClassificationNameList.equals(other$artifactClassificationNameList);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesCoatingConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $artifactClassificationIdList = this.getArtifactClassificationIdList();
      result = result * 59 + ($artifactClassificationIdList == null ? 43 : $artifactClassificationIdList.hashCode());
      Object $artifactClassificationNameList = this.getArtifactClassificationNameList();
      return result * 59 + ($artifactClassificationNameList == null ? 43 : $artifactClassificationNameList.hashCode());
   }

   public List<Long> getArtifactClassificationIdList() {
      return this.artifactClassificationIdList;
   }

   public List<String> getArtifactClassificationNameList() {
      return this.artifactClassificationNameList;
   }

   public void setArtifactClassificationIdList(final List<Long> artifactClassificationIdList) {
      this.artifactClassificationIdList = artifactClassificationIdList;
   }

   public void setArtifactClassificationNameList(final List<String> artifactClassificationNameList) {
      this.artifactClassificationNameList = artifactClassificationNameList;
   }

   @Override
   public String toString() {
      return "MesCoatingConfigDTO(super="
         + super.toString()
         + ", artifactClassificationIdList="
         + this.getArtifactClassificationIdList()
         + ", artifactClassificationNameList="
         + this.getArtifactClassificationNameList()
         + ")";
   }
}
