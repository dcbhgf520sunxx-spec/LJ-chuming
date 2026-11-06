package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;

public class ArtifactProcessFileAttachmentDTO {
   @ApiModelProperty("工艺文件类型 1焊接工艺 2装配工艺 4涂装工艺")
   private Integer processType;
   @ApiModelProperty("自定义文件名称")
   private String fileName;
   private AttachmentDTO attachmentDTO;

   public static ArtifactProcessFileAttachmentDTO.ArtifactProcessFileAttachmentDTOBuilder builder() {
      return new ArtifactProcessFileAttachmentDTO.ArtifactProcessFileAttachmentDTOBuilder();
   }

   public ArtifactProcessFileAttachmentDTO(final Integer processType, final String fileName, final AttachmentDTO attachmentDTO) {
      this.processType = processType;
      this.fileName = fileName;
      this.attachmentDTO = attachmentDTO;
   }

   public ArtifactProcessFileAttachmentDTO() {
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public String getFileName() {
      return this.fileName;
   }

   public AttachmentDTO getAttachmentDTO() {
      return this.attachmentDTO;
   }

   public void setProcessType(final Integer processType) {
      this.processType = processType;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setAttachmentDTO(final AttachmentDTO attachmentDTO) {
      this.attachmentDTO = attachmentDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactProcessFileAttachmentDTO)) {
         return false;
      }

      ArtifactProcessFileAttachmentDTO other = (ArtifactProcessFileAttachmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processType = this.getProcessType();
      Object other$processType = other.getProcessType();
      if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
         Object this$fileName = this.getFileName();
         Object other$fileName = other.getFileName();
         if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
            Object this$attachmentDTO = this.getAttachmentDTO();
            Object other$attachmentDTO = other.getAttachmentDTO();
            return this$attachmentDTO == null ? other$attachmentDTO == null : this$attachmentDTO.equals(other$attachmentDTO);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactProcessFileAttachmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $attachmentDTO = this.getAttachmentDTO();
      return result * 59 + ($attachmentDTO == null ? 43 : $attachmentDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactProcessFileAttachmentDTO(processType="
         + this.getProcessType()
         + ", fileName="
         + this.getFileName()
         + ", attachmentDTO="
         + this.getAttachmentDTO()
         + ")";
   }

   public static class ArtifactProcessFileAttachmentDTOBuilder {
      private Integer processType;
      private String fileName;
      private AttachmentDTO attachmentDTO;

      ArtifactProcessFileAttachmentDTOBuilder() {
      }

      public ArtifactProcessFileAttachmentDTO.ArtifactProcessFileAttachmentDTOBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public ArtifactProcessFileAttachmentDTO.ArtifactProcessFileAttachmentDTOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public ArtifactProcessFileAttachmentDTO.ArtifactProcessFileAttachmentDTOBuilder attachmentDTO(final AttachmentDTO attachmentDTO) {
         this.attachmentDTO = attachmentDTO;
         return this;
      }

      public ArtifactProcessFileAttachmentDTO build() {
         return new ArtifactProcessFileAttachmentDTO(this.processType, this.fileName, this.attachmentDTO);
      }

      @Override
      public String toString() {
         return "ArtifactProcessFileAttachmentDTO.ArtifactProcessFileAttachmentDTOBuilder(processType="
            + this.processType
            + ", fileName="
            + this.fileName
            + ", attachmentDTO="
            + this.attachmentDTO
            + ")";
      }
   }
}
