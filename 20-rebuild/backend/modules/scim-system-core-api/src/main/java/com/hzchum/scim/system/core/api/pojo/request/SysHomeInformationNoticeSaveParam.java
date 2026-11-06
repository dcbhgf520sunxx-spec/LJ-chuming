package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class SysHomeInformationNoticeSaveParam {
   @ApiModelProperty(name = "title", value = "标题", notes = "标题")
   private String title;
   @ApiModelProperty(name = "sysHomeContentType", value = "内容类型", notes = "内容类型")
   private Integer sysHomeContentType;
   @ApiModelProperty(name = "content", value = "内容", notes = "内容")
   private String content;
   @ApiModelProperty(name = "attachmentIds", value = "附件ids ", notes = "附件ids ")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "informantDateTime", value = "创建日期", notes = "创建日期")
   private LocalDateTime informantDateTime;

   public SysHomeInformationNoticeSaveParam(
      final String title,
      final Integer sysHomeContentType,
      final String content,
      final List<AttachmentDTO> attachmentIds,
      final LocalDateTime informantDateTime
   ) {
      this.title = title;
      this.sysHomeContentType = sysHomeContentType;
      this.content = content;
      this.attachmentIds = attachmentIds;
      this.informantDateTime = informantDateTime;
   }

   public SysHomeInformationNoticeSaveParam() {
   }

   public String getTitle() {
      return this.title;
   }

   public Integer getSysHomeContentType() {
      return this.sysHomeContentType;
   }

   public String getContent() {
      return this.content;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setSysHomeContentType(final Integer sysHomeContentType) {
      this.sysHomeContentType = sysHomeContentType;
   }

   public void setContent(final String content) {
      this.content = content;
   }

   public void setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeInformationNoticeSaveParam)) {
         return false;
      }

      SysHomeInformationNoticeSaveParam other = (SysHomeInformationNoticeSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sysHomeContentType = this.getSysHomeContentType();
      Object other$sysHomeContentType = other.getSysHomeContentType();
      if (this$sysHomeContentType == null ? other$sysHomeContentType == null : this$sysHomeContentType.equals(other$sysHomeContentType)) {
         Object this$title = this.getTitle();
         Object other$title = other.getTitle();
         if (this$title == null ? other$title == null : this$title.equals(other$title)) {
            Object this$content = this.getContent();
            Object other$content = other.getContent();
            if (this$content == null ? other$content == null : this$content.equals(other$content)) {
               Object this$attachmentIds = this.getAttachmentIds();
               Object other$attachmentIds = other.getAttachmentIds();
               if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
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
      return other instanceof SysHomeInformationNoticeSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sysHomeContentType = this.getSysHomeContentType();
      result = result * 59 + ($sysHomeContentType == null ? 43 : $sysHomeContentType.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $content = this.getContent();
      result = result * 59 + ($content == null ? 43 : $content.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      return result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
   }

   @Override
   public String toString() {
      return "SysHomeInformationNoticeSaveParam(title="
         + this.getTitle()
         + ", sysHomeContentType="
         + this.getSysHomeContentType()
         + ", content="
         + this.getContent()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ")";
   }
}
