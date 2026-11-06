package com.hzchum.scim.project.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectImageProgress对象", description = "形象进度 ")
public class ProjectImageProgressDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "attachmentId", value = "附件id")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "date", value = "日期")
   private String date;

   public static ProjectImageProgressDTO.ProjectImageProgressDTOBuilder builder() {
      return new ProjectImageProgressDTO.ProjectImageProgressDTOBuilder();
   }

   public ProjectImageProgressDTO() {
   }

   public ProjectImageProgressDTO(final Long projectId, final List<AttachmentDTO> attachments, final String date) {
      this.projectId = projectId;
      this.attachments = attachments;
      this.date = date;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getDate() {
      return this.date;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setDate(final String date) {
      this.date = date;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectImageProgressDTO)) {
         return false;
      }

      ProjectImageProgressDTO other = (ProjectImageProgressDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$attachments = this.getAttachments();
         Object other$attachments = other.getAttachments();
         if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            return this$date == null ? other$date == null : this$date.equals(other$date);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectImageProgressDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectImageProgressDTO(projectId=" + this.getProjectId() + ", attachments=" + this.getAttachments() + ", date=" + this.getDate() + ")";
   }

   public static class ProjectImageProgressDTOBuilder {
      private Long projectId;
      private List<AttachmentDTO> attachments;
      private String date;

      ProjectImageProgressDTOBuilder() {
      }

      public ProjectImageProgressDTO.ProjectImageProgressDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectImageProgressDTO.ProjectImageProgressDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ProjectImageProgressDTO.ProjectImageProgressDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public ProjectImageProgressDTO build() {
         return new ProjectImageProgressDTO(this.projectId, this.attachments, this.date);
      }

      @Override
      public String toString() {
         return "ProjectImageProgressDTO.ProjectImageProgressDTOBuilder(projectId="
            + this.projectId
            + ", attachments="
            + this.attachments
            + ", date="
            + this.date
            + ")";
      }
   }
}
