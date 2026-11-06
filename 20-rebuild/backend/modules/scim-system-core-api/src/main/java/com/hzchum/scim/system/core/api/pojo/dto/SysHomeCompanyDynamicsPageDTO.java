package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class SysHomeCompanyDynamicsPageDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   private String createUserName;
   @ApiModelProperty(name = "title", value = "标题", notes = "标题")
   private String title;
   @ApiModelProperty(name = "attachmentDTOList", value = "文件id", notes = "文件id")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "informantDateTime", value = "创建日期", notes = "创建日期")
   private LocalDateTime informantDateTime;

   public static SysHomeCompanyDynamicsPageDTO.SysHomeCompanyDynamicsPageDTOBuilder builder() {
      return new SysHomeCompanyDynamicsPageDTO.SysHomeCompanyDynamicsPageDTOBuilder();
   }

   public SysHomeCompanyDynamicsPageDTO() {
   }

   public SysHomeCompanyDynamicsPageDTO(
      final Long id, final String createUserName, final String title, final List<AttachmentDTO> attachmentDTOList, final LocalDateTime informantDateTime
   ) {
      this.id = id;
      this.createUserName = createUserName;
      this.title = title;
      this.attachmentDTOList = attachmentDTOList;
      this.informantDateTime = informantDateTime;
   }

   public Long getId() {
      return this.id;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getTitle() {
      return this.title;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public SysHomeCompanyDynamicsPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeCompanyDynamicsPageDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public SysHomeCompanyDynamicsPageDTO setTitle(final String title) {
      this.title = title;
      return this;
   }

   public SysHomeCompanyDynamicsPageDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   public SysHomeCompanyDynamicsPageDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeCompanyDynamicsPageDTO(id="
         + this.getId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", title="
         + this.getTitle()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeCompanyDynamicsPageDTO)) {
         return false;
      }

      SysHomeCompanyDynamicsPageDTO other = (SysHomeCompanyDynamicsPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserName = this.getCreateUserName();
         Object other$createUserName = other.getCreateUserName();
         if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
            Object this$title = this.getTitle();
            Object other$title = other.getTitle();
            if (this$title == null ? other$title == null : this$title.equals(other$title)) {
               Object this$attachmentDTOList = this.getAttachmentDTOList();
               Object other$attachmentDTOList = other.getAttachmentDTOList();
               if (this$attachmentDTOList == null ? other$attachmentDTOList == null : this$attachmentDTOList.equals(other$attachmentDTOList)) {
                  Object this$informantDateTime = this.getInformantDateTime();
                  Object other$informantDateTime = other.getInformantDateTime();
                  return this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime);
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
      return other instanceof SysHomeCompanyDynamicsPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      return result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
   }

   public static class SysHomeCompanyDynamicsPageDTOBuilder {
      private Long id;
      private String createUserName;
      private String title;
      private List<AttachmentDTO> attachmentDTOList;
      private LocalDateTime informantDateTime;

      SysHomeCompanyDynamicsPageDTOBuilder() {
      }

      public SysHomeCompanyDynamicsPageDTO.SysHomeCompanyDynamicsPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeCompanyDynamicsPageDTO.SysHomeCompanyDynamicsPageDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysHomeCompanyDynamicsPageDTO.SysHomeCompanyDynamicsPageDTOBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public SysHomeCompanyDynamicsPageDTO.SysHomeCompanyDynamicsPageDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public SysHomeCompanyDynamicsPageDTO.SysHomeCompanyDynamicsPageDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public SysHomeCompanyDynamicsPageDTO build() {
         return new SysHomeCompanyDynamicsPageDTO(this.id, this.createUserName, this.title, this.attachmentDTOList, this.informantDateTime);
      }

      @Override
      public String toString() {
         return "SysHomeCompanyDynamicsPageDTO.SysHomeCompanyDynamicsPageDTOBuilder(id="
            + this.id
            + ", createUserName="
            + this.createUserName
            + ", title="
            + this.title
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ", informantDateTime="
            + this.informantDateTime
            + ")";
      }
   }
}
