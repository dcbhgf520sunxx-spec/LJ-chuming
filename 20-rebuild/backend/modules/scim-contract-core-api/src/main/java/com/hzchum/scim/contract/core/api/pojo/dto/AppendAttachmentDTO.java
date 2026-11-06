package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel("附件归档请求体")
public class AppendAttachmentDTO {
   private Long projectId;
   private List<Long> fileIds;

   public Long getProjectId() {
      return this.projectId;
   }

   public List<Long> getFileIds() {
      return this.fileIds;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setFileIds(final List<Long> fileIds) {
      this.fileIds = fileIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppendAttachmentDTO)) {
         return false;
      } else {
         AppendAttachmentDTO other = (AppendAttachmentDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$fileIds = this.getFileIds();
               Object other$fileIds = other.getFileIds();
               return this$fileIds == null ? other$fileIds == null : this$fileIds.equals(other$fileIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppendAttachmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $fileIds = this.getFileIds();
      return result * 59 + ($fileIds == null ? 43 : $fileIds.hashCode());
   }

   @Override
   public String toString() {
      return "AppendAttachmentDTO(projectId=" + this.getProjectId() + ", fileIds=" + this.getFileIds() + ")";
   }
}
