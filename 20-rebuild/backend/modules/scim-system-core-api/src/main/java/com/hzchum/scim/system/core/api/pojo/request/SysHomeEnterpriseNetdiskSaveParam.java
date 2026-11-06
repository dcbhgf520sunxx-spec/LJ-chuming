package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class SysHomeEnterpriseNetdiskSaveParam {
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   private Integer createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   private String createUserName;
   @ApiModelProperty(name = "sysHomeFileType", value = "系统文件类型", notes = "系统文件类型")
   private Integer sysHomeFileType;
   @ApiModelProperty(name = "informantDateTime", value = "创建日期", notes = "创建日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "attachmentIds", value = "附件id 字符串", notes = "附件id 字符串")
   private List<AttachmentDTO> attachmentIds;

   public SysHomeEnterpriseNetdiskSaveParam(
      final Integer createUserId,
      final String createUserName,
      final Integer sysHomeFileType,
      final LocalDateTime informantDateTime,
      final List<AttachmentDTO> attachmentIds
   ) {
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.sysHomeFileType = sysHomeFileType;
      this.informantDateTime = informantDateTime;
      this.attachmentIds = attachmentIds;
   }

   public SysHomeEnterpriseNetdiskSaveParam() {
   }

   public Integer getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getSysHomeFileType() {
      return this.sysHomeFileType;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setCreateUserId(final Integer createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setSysHomeFileType(final Integer sysHomeFileType) {
      this.sysHomeFileType = sysHomeFileType;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
   }

   public void setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeEnterpriseNetdiskSaveParam)) {
         return false;
      }

      SysHomeEnterpriseNetdiskSaveParam other = (SysHomeEnterpriseNetdiskSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createUserId = this.getCreateUserId();
      Object other$createUserId = other.getCreateUserId();
      if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
         Object this$sysHomeFileType = this.getSysHomeFileType();
         Object other$sysHomeFileType = other.getSysHomeFileType();
         if (this$sysHomeFileType == null ? other$sysHomeFileType == null : this$sysHomeFileType.equals(other$sysHomeFileType)) {
            Object this$createUserName = this.getCreateUserName();
            Object other$createUserName = other.getCreateUserName();
            if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
               Object this$informantDateTime = this.getInformantDateTime();
               Object other$informantDateTime = other.getInformantDateTime();
               if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
                  Object this$attachmentIds = this.getAttachmentIds();
                  Object other$attachmentIds = other.getAttachmentIds();
                  return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof SysHomeEnterpriseNetdiskSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $sysHomeFileType = this.getSysHomeFileType();
      result = result * 59 + ($sysHomeFileType == null ? 43 : $sysHomeFileType.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "SysHomeEnterpriseNetdiskSaveParam(createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", sysHomeFileType="
         + this.getSysHomeFileType()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }
}
