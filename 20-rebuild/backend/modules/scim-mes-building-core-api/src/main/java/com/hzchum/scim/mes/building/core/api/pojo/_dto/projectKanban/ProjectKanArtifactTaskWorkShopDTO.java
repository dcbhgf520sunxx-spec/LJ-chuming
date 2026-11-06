package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class ProjectKanArtifactTaskWorkShopDTO {
   @ApiModelProperty(name = "artifactTaskId", notes = "构件任务Id")
   @JsonProperty("artifactTaskId")
   @JSONField(name = "artifactTaskId")
   private Long artifactTaskId;
   @ApiModelProperty(name = "assistWorkShopNames", notes = "协同车间名")
   @JsonProperty("assistWorkShopNames")
   @JSONField(name = "assistWorkShopNames")
   private String assistWorkShopNames;

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public String getAssistWorkShopNames() {
      return this.assistWorkShopNames;
   }

   @JsonProperty("artifactTaskId")
   public void setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
   }

   @JsonProperty("assistWorkShopNames")
   public void setAssistWorkShopNames(final String assistWorkShopNames) {
      this.assistWorkShopNames = assistWorkShopNames;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectKanArtifactTaskWorkShopDTO)) {
         return false;
      } else {
         ProjectKanArtifactTaskWorkShopDTO other = (ProjectKanArtifactTaskWorkShopDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactTaskId = this.getArtifactTaskId();
            Object other$artifactTaskId = other.getArtifactTaskId();
            if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
               Object this$assistWorkShopNames = this.getAssistWorkShopNames();
               Object other$assistWorkShopNames = other.getAssistWorkShopNames();
               return this$assistWorkShopNames == null ? other$assistWorkShopNames == null : this$assistWorkShopNames.equals(other$assistWorkShopNames);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectKanArtifactTaskWorkShopDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $assistWorkShopNames = this.getAssistWorkShopNames();
      return result * 59 + ($assistWorkShopNames == null ? 43 : $assistWorkShopNames.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectKanArtifactTaskWorkShopDTO(artifactTaskId=" + this.getArtifactTaskId() + ", assistWorkShopNames=" + this.getAssistWorkShopNames() + ")";
   }
}
