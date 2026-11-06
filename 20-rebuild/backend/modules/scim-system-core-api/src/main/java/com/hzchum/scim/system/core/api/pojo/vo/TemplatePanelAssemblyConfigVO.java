package com.hzchum.scim.system.core.api.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class TemplatePanelAssemblyConfigVO {
   @ApiModelProperty(name = "id", value = "主键id", notes = "主键id")
   private Long id;
   @ApiModelProperty(name = "structureClassificationId", value = "构件特征定义Id")
   @NotNull(message = "构件特征定义Id不可为空!")
   private Long structureClassificationId;
   @ApiModelProperty(name = "artifactPartNumberPrefix", value = "零件编号前缀列表(用于判断构件特征定义归属)")
   private List<String> artifactPartNumberPrefixList;
   @ApiModelProperty(name = "webPartNumberPrefixList", value = "腹板零件编号前缀列表")
   private List<String> webPartNumberPrefixList;
   @ApiModelProperty(name = "sailPartNumberPrefixList", value = "翼板零件编号前缀列表")
   private List<String> sailPartNumberPrefixList;

   public Long getId() {
      return this.id;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public List<String> getArtifactPartNumberPrefixList() {
      return this.artifactPartNumberPrefixList;
   }

   public List<String> getWebPartNumberPrefixList() {
      return this.webPartNumberPrefixList;
   }

   public List<String> getSailPartNumberPrefixList() {
      return this.sailPartNumberPrefixList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
   }

   public void setArtifactPartNumberPrefixList(final List<String> artifactPartNumberPrefixList) {
      this.artifactPartNumberPrefixList = artifactPartNumberPrefixList;
   }

   public void setWebPartNumberPrefixList(final List<String> webPartNumberPrefixList) {
      this.webPartNumberPrefixList = webPartNumberPrefixList;
   }

   public void setSailPartNumberPrefixList(final List<String> sailPartNumberPrefixList) {
      this.sailPartNumberPrefixList = sailPartNumberPrefixList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TemplatePanelAssemblyConfigVO)) {
         return false;
      }

      TemplatePanelAssemblyConfigVO other = (TemplatePanelAssemblyConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$structureClassificationId = this.getStructureClassificationId();
         Object other$structureClassificationId = other.getStructureClassificationId();
         if (this$structureClassificationId == null
            ? other$structureClassificationId == null
            : this$structureClassificationId.equals(other$structureClassificationId)) {
            Object this$artifactPartNumberPrefixList = this.getArtifactPartNumberPrefixList();
            Object other$artifactPartNumberPrefixList = other.getArtifactPartNumberPrefixList();
            if (this$artifactPartNumberPrefixList == null
               ? other$artifactPartNumberPrefixList == null
               : this$artifactPartNumberPrefixList.equals(other$artifactPartNumberPrefixList)) {
               Object this$webPartNumberPrefixList = this.getWebPartNumberPrefixList();
               Object other$webPartNumberPrefixList = other.getWebPartNumberPrefixList();
               if (this$webPartNumberPrefixList == null
                  ? other$webPartNumberPrefixList == null
                  : this$webPartNumberPrefixList.equals(other$webPartNumberPrefixList)) {
                  Object this$sailPartNumberPrefixList = this.getSailPartNumberPrefixList();
                  Object other$sailPartNumberPrefixList = other.getSailPartNumberPrefixList();
                  return this$sailPartNumberPrefixList == null
                     ? other$sailPartNumberPrefixList == null
                     : this$sailPartNumberPrefixList.equals(other$sailPartNumberPrefixList);
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
      return other instanceof TemplatePanelAssemblyConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $artifactPartNumberPrefixList = this.getArtifactPartNumberPrefixList();
      result = result * 59 + ($artifactPartNumberPrefixList == null ? 43 : $artifactPartNumberPrefixList.hashCode());
      Object $webPartNumberPrefixList = this.getWebPartNumberPrefixList();
      result = result * 59 + ($webPartNumberPrefixList == null ? 43 : $webPartNumberPrefixList.hashCode());
      Object $sailPartNumberPrefixList = this.getSailPartNumberPrefixList();
      return result * 59 + ($sailPartNumberPrefixList == null ? 43 : $sailPartNumberPrefixList.hashCode());
   }

   @Override
   public String toString() {
      return "TemplatePanelAssemblyConfigVO(id="
         + this.getId()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", artifactPartNumberPrefixList="
         + this.getArtifactPartNumberPrefixList()
         + ", webPartNumberPrefixList="
         + this.getWebPartNumberPrefixList()
         + ", sailPartNumberPrefixList="
         + this.getSailPartNumberPrefixList()
         + ")";
   }
}
