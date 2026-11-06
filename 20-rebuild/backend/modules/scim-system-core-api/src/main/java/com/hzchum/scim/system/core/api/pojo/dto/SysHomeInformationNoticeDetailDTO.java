package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class SysHomeInformationNoticeDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   private Integer createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   private String createUserName;
   @ApiModelProperty(name = "title", value = "标题", notes = "标题")
   private String title;
   @ApiModelProperty(name = "content", value = "内容", notes = "内容")
   private String content;
   @ApiModelProperty(name = "attachmentIds", value = "文件id", notes = "文件id")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentDTOList", value = "附件集合", notes = "附件集合")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "informantDateTime", value = "创建日期", notes = "创建日期")
   private LocalDateTime informantDateTime;

   public static SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder builder() {
      return new SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder();
   }

   public SysHomeInformationNoticeDetailDTO() {
   }

   public SysHomeInformationNoticeDetailDTO(
      final Long id,
      final Integer createUserId,
      final String createUserName,
      final String title,
      final String content,
      final String attachmentIds,
      final List<AttachmentDTO> attachmentDTOList,
      final LocalDateTime informantDateTime
   ) {
      this.id = id;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.title = title;
      this.content = content;
      this.attachmentIds = attachmentIds;
      this.attachmentDTOList = attachmentDTOList;
      this.informantDateTime = informantDateTime;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getTitle() {
      return this.title;
   }

   public String getContent() {
      return this.content;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public SysHomeInformationNoticeDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeInformationNoticeDetailDTO setCreateUserId(final Integer createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public SysHomeInformationNoticeDetailDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public SysHomeInformationNoticeDetailDTO setTitle(final String title) {
      this.title = title;
      return this;
   }

   public SysHomeInformationNoticeDetailDTO setContent(final String content) {
      this.content = content;
      return this;
   }

   public SysHomeInformationNoticeDetailDTO setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public SysHomeInformationNoticeDetailDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   public SysHomeInformationNoticeDetailDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeInformationNoticeDetailDTO(id="
         + this.getId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", title="
         + this.getTitle()
         + ", content="
         + this.getContent()
         + ", attachmentIds="
         + this.getAttachmentIds()
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

      if (!(o instanceof SysHomeInformationNoticeDetailDTO)) {
         return false;
      }

      SysHomeInformationNoticeDetailDTO other = (SysHomeInformationNoticeDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$createUserName = this.getCreateUserName();
            Object other$createUserName = other.getCreateUserName();
            if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
               Object this$title = this.getTitle();
               Object other$title = other.getTitle();
               if (this$title == null ? other$title == null : this$title.equals(other$title)) {
                  Object this$content = this.getContent();
                  Object other$content = other.getContent();
                  if (this$content == null ? other$content == null : this$content.equals(other$content)) {
                     Object this$attachmentIds = this.getAttachmentIds();
                     Object other$attachmentIds = other.getAttachmentIds();
                     if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
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
      return other instanceof SysHomeInformationNoticeDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $content = this.getContent();
      result = result * 59 + ($content == null ? 43 : $content.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      return result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
   }

   public static class SysHomeInformationNoticeDetailDTOBuilder {
      private Long id;
      private Integer createUserId;
      private String createUserName;
      private String title;
      private String content;
      private String attachmentIds;
      private List<AttachmentDTO> attachmentDTOList;
      private LocalDateTime informantDateTime;

      SysHomeInformationNoticeDetailDTOBuilder() {
      }

      public SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder createUserId(final Integer createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder content(final String content) {
         this.content = content;
         return this;
      }

      public SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public SysHomeInformationNoticeDetailDTO build() {
         return new SysHomeInformationNoticeDetailDTO(
            this.id, this.createUserId, this.createUserName, this.title, this.content, this.attachmentIds, this.attachmentDTOList, this.informantDateTime
         );
      }

      @Override
      public String toString() {
         return "SysHomeInformationNoticeDetailDTO.SysHomeInformationNoticeDetailDTOBuilder(id="
            + this.id
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", title="
            + this.title
            + ", content="
            + this.content
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ", informantDateTime="
            + this.informantDateTime
            + ")";
      }
   }
}
