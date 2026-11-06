package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class SysHomeEnterpriseNetdiskPageDownloadDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "sysHomeFileType", value = "文件类型", notes = "文件类型")
   private Integer sysHomeFileType;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "informantDateTime", value = "创建日期", notes = "创建日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "attachmentDTOList", value = "文件", notes = "文件")
   private List<AttachmentDTO> attachmentDTOList;

   public static SysHomeEnterpriseNetdiskPageDownloadDTO.SysHomeEnterpriseNetdiskPageDownloadDTOBuilder builder() {
      return new SysHomeEnterpriseNetdiskPageDownloadDTO.SysHomeEnterpriseNetdiskPageDownloadDTOBuilder();
   }

   public SysHomeEnterpriseNetdiskPageDownloadDTO() {
   }

   public SysHomeEnterpriseNetdiskPageDownloadDTO(
      final Long id,
      final Integer sysHomeFileType,
      final String createUserName,
      final LocalDateTime informantDateTime,
      final List<AttachmentDTO> attachmentDTOList
   ) {
      this.id = id;
      this.sysHomeFileType = sysHomeFileType;
      this.createUserName = createUserName;
      this.informantDateTime = informantDateTime;
      this.attachmentDTOList = attachmentDTOList;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getSysHomeFileType() {
      return this.sysHomeFileType;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public SysHomeEnterpriseNetdiskPageDownloadDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeEnterpriseNetdiskPageDownloadDTO setSysHomeFileType(final Integer sysHomeFileType) {
      this.sysHomeFileType = sysHomeFileType;
      return this;
   }

   public SysHomeEnterpriseNetdiskPageDownloadDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public SysHomeEnterpriseNetdiskPageDownloadDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public SysHomeEnterpriseNetdiskPageDownloadDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeEnterpriseNetdiskPageDownloadDTO(id="
         + this.getId()
         + ", sysHomeFileType="
         + this.getSysHomeFileType()
         + ", createUserName="
         + this.getCreateUserName()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeEnterpriseNetdiskPageDownloadDTO)) {
         return false;
      }

      SysHomeEnterpriseNetdiskPageDownloadDTO other = (SysHomeEnterpriseNetdiskPageDownloadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sysHomeFileType = this.getSysHomeFileType();
         Object other$sysHomeFileType = other.getSysHomeFileType();
         if (this$sysHomeFileType == null ? other$sysHomeFileType == null : this$sysHomeFileType.equals(other$sysHomeFileType)) {
            Object this$createUserName = this.getCreateUserName();
            Object other$createUserName = other.getCreateUserName();
            if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
               Object this$informantDateTime = this.getInformantDateTime();
               Object other$informantDateTime = other.getInformantDateTime();
               if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
                  Object this$attachmentDTOList = this.getAttachmentDTOList();
                  Object other$attachmentDTOList = other.getAttachmentDTOList();
                  return this$attachmentDTOList == null ? other$attachmentDTOList == null : this$attachmentDTOList.equals(other$attachmentDTOList);
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
      return other instanceof SysHomeEnterpriseNetdiskPageDownloadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sysHomeFileType = this.getSysHomeFileType();
      result = result * 59 + ($sysHomeFileType == null ? 43 : $sysHomeFileType.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      return result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
   }

   public static class SysHomeEnterpriseNetdiskPageDownloadDTOBuilder {
      private Long id;
      private Integer sysHomeFileType;
      private String createUserName;
      private LocalDateTime informantDateTime;
      private List<AttachmentDTO> attachmentDTOList;

      SysHomeEnterpriseNetdiskPageDownloadDTOBuilder() {
      }

      public SysHomeEnterpriseNetdiskPageDownloadDTO.SysHomeEnterpriseNetdiskPageDownloadDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeEnterpriseNetdiskPageDownloadDTO.SysHomeEnterpriseNetdiskPageDownloadDTOBuilder sysHomeFileType(final Integer sysHomeFileType) {
         this.sysHomeFileType = sysHomeFileType;
         return this;
      }

      public SysHomeEnterpriseNetdiskPageDownloadDTO.SysHomeEnterpriseNetdiskPageDownloadDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysHomeEnterpriseNetdiskPageDownloadDTO.SysHomeEnterpriseNetdiskPageDownloadDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public SysHomeEnterpriseNetdiskPageDownloadDTO.SysHomeEnterpriseNetdiskPageDownloadDTOBuilder attachmentDTOList(
         final List<AttachmentDTO> attachmentDTOList
      ) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public SysHomeEnterpriseNetdiskPageDownloadDTO build() {
         return new SysHomeEnterpriseNetdiskPageDownloadDTO(this.id, this.sysHomeFileType, this.createUserName, this.informantDateTime, this.attachmentDTOList);
      }

      @Override
      public String toString() {
         return "SysHomeEnterpriseNetdiskPageDownloadDTO.SysHomeEnterpriseNetdiskPageDownloadDTOBuilder(id="
            + this.id
            + ", sysHomeFileType="
            + this.sysHomeFileType
            + ", createUserName="
            + this.createUserName
            + ", informantDateTime="
            + this.informantDateTime
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ")";
      }
   }
}
