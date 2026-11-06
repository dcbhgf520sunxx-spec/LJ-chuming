package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class SysHomeCompanyDynamicsSaveParam {
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   private Integer createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   private String createUserName;
   @ApiModelProperty(name = "title", value = "标题", notes = "标题")
   private String title;
   @ApiModelProperty(name = "attachmentIds", value = "附件id 字符串", notes = "附件id 字符串")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "informantDateTime", value = "创建日期", notes = "创建日期")
   private LocalDateTime informantDateTime;

   public SysHomeCompanyDynamicsSaveParam(
      final Integer createUserId,
      final String createUserName,
      final String title,
      final List<AttachmentDTO> attachmentIds,
      final LocalDateTime informantDateTime
   ) {
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.title = title;
      this.attachmentIds = attachmentIds;
      this.informantDateTime = informantDateTime;
   }

   public SysHomeCompanyDynamicsSaveParam() {
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

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public void setCreateUserId(final Integer createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setTitle(final String title) {
      this.title = title;
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

      if (!(o instanceof SysHomeCompanyDynamicsSaveParam)) {
         return false;
      }

      SysHomeCompanyDynamicsSaveParam other = (SysHomeCompanyDynamicsSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createUserId = this.getCreateUserId();
      Object other$createUserId = other.getCreateUserId();
      if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
         Object this$createUserName = this.getCreateUserName();
         Object other$createUserName = other.getCreateUserName();
         if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
            Object this$title = this.getTitle();
            Object other$title = other.getTitle();
            if (this$title == null ? other$title == null : this$title.equals(other$title)) {
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
      return other instanceof SysHomeCompanyDynamicsSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      return result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
   }

   @Override
   public String toString() {
      return "SysHomeCompanyDynamicsSaveParam(createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", title="
         + this.getTitle()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ")";
   }
}
