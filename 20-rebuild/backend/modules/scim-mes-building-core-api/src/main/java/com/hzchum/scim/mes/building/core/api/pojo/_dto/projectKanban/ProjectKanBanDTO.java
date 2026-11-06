package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.ArtifactCompleteSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.EnclosureCompleteSummaryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectKanBanDTO", description = "项目看板")
public class ProjectKanBanDTO {
   @ApiModelProperty(name = "summary", notes = "构件统计")
   @JsonProperty("summary")
   @JSONField(name = "summary")
   private ArtifactCompleteSummaryDTO artifactSummary;
   @ApiModelProperty(name = "enclosureSummary", notes = "围护统计")
   @JsonProperty("enclosureSummary")
   @JSONField(name = "enclosureSummary")
   private List<EnclosureCompleteSummaryDTO> enclosureSummary;
   @ApiModelProperty(name = "type", notes = "围护计算方式")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;

   public static ProjectKanBanDTO.ProjectKanBanDTOBuilder builder() {
      return new ProjectKanBanDTO.ProjectKanBanDTOBuilder();
   }

   public ProjectKanBanDTO() {
   }

   public ProjectKanBanDTO(final ArtifactCompleteSummaryDTO artifactSummary, final List<EnclosureCompleteSummaryDTO> enclosureSummary, final Integer type) {
      this.artifactSummary = artifactSummary;
      this.enclosureSummary = enclosureSummary;
      this.type = type;
   }

   public ArtifactCompleteSummaryDTO getArtifactSummary() {
      return this.artifactSummary;
   }

   public List<EnclosureCompleteSummaryDTO> getEnclosureSummary() {
      return this.enclosureSummary;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("summary")
   public ProjectKanBanDTO setArtifactSummary(final ArtifactCompleteSummaryDTO artifactSummary) {
      this.artifactSummary = artifactSummary;
      return this;
   }

   @JsonProperty("enclosureSummary")
   public ProjectKanBanDTO setEnclosureSummary(final List<EnclosureCompleteSummaryDTO> enclosureSummary) {
      this.enclosureSummary = enclosureSummary;
      return this;
   }

   @JsonProperty("type")
   public ProjectKanBanDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectKanBanDTO(artifactSummary="
         + this.getArtifactSummary()
         + ", enclosureSummary="
         + this.getEnclosureSummary()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectKanBanDTO)) {
         return false;
      }

      ProjectKanBanDTO other = (ProjectKanBanDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$artifactSummary = this.getArtifactSummary();
         Object other$artifactSummary = other.getArtifactSummary();
         if (this$artifactSummary == null ? other$artifactSummary == null : this$artifactSummary.equals(other$artifactSummary)) {
            Object this$enclosureSummary = this.getEnclosureSummary();
            Object other$enclosureSummary = other.getEnclosureSummary();
            return this$enclosureSummary == null ? other$enclosureSummary == null : this$enclosureSummary.equals(other$enclosureSummary);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectKanBanDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $artifactSummary = this.getArtifactSummary();
      result = result * 59 + ($artifactSummary == null ? 43 : $artifactSummary.hashCode());
      Object $enclosureSummary = this.getEnclosureSummary();
      return result * 59 + ($enclosureSummary == null ? 43 : $enclosureSummary.hashCode());
   }

   public static class ProjectKanBanDTOBuilder {
      private ArtifactCompleteSummaryDTO artifactSummary;
      private List<EnclosureCompleteSummaryDTO> enclosureSummary;
      private Integer type;

      ProjectKanBanDTOBuilder() {
      }

      @JsonProperty("summary")
      public ProjectKanBanDTO.ProjectKanBanDTOBuilder artifactSummary(final ArtifactCompleteSummaryDTO artifactSummary) {
         this.artifactSummary = artifactSummary;
         return this;
      }

      @JsonProperty("enclosureSummary")
      public ProjectKanBanDTO.ProjectKanBanDTOBuilder enclosureSummary(final List<EnclosureCompleteSummaryDTO> enclosureSummary) {
         this.enclosureSummary = enclosureSummary;
         return this;
      }

      @JsonProperty("type")
      public ProjectKanBanDTO.ProjectKanBanDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ProjectKanBanDTO build() {
         return new ProjectKanBanDTO(this.artifactSummary, this.enclosureSummary, this.type);
      }

      @Override
      public String toString() {
         return "ProjectKanBanDTO.ProjectKanBanDTOBuilder(artifactSummary="
            + this.artifactSummary
            + ", enclosureSummary="
            + this.enclosureSummary
            + ", type="
            + this.type
            + ")";
      }
   }
}
