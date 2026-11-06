package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmBiddingPlatformTaskPageDTO {
   @ApiModelProperty(name = "createTime", notes = "下达日期")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "biddingPlatformName", notes = "招标平台名称")
   private String biddingPlatformName;
   @ApiModelProperty(name = "reasonForRegistration", value = "报名事由", notes = "报名事由")
   private String reasonForRegistration;
   @ApiModelProperty(name = "attachmentIds", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "状态", notes = "状态")
   private Integer crmCheckStatusEnum;

   public static CrmBiddingPlatformTaskPageDTO.CrmBiddingPlatformTaskPageDTOBuilder builder() {
      return new CrmBiddingPlatformTaskPageDTO.CrmBiddingPlatformTaskPageDTOBuilder();
   }

   public CrmBiddingPlatformTaskPageDTO() {
   }

   public CrmBiddingPlatformTaskPageDTO(
      final LocalDateTime createTime,
      final String biddingPlatformName,
      final String reasonForRegistration,
      final List<AttachmentDTO> attachmentIds,
      final String createUserName,
      final Integer crmCheckStatusEnum
   ) {
      this.createTime = createTime;
      this.biddingPlatformName = biddingPlatformName;
      this.reasonForRegistration = reasonForRegistration;
      this.attachmentIds = attachmentIds;
      this.createUserName = createUserName;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getBiddingPlatformName() {
      return this.biddingPlatformName;
   }

   public String getReasonForRegistration() {
      return this.reasonForRegistration;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public CrmBiddingPlatformTaskPageDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public CrmBiddingPlatformTaskPageDTO setBiddingPlatformName(final String biddingPlatformName) {
      this.biddingPlatformName = biddingPlatformName;
      return this;
   }

   public CrmBiddingPlatformTaskPageDTO setReasonForRegistration(final String reasonForRegistration) {
      this.reasonForRegistration = reasonForRegistration;
      return this;
   }

   public CrmBiddingPlatformTaskPageDTO setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmBiddingPlatformTaskPageDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmBiddingPlatformTaskPageDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBiddingPlatformTaskPageDTO(createTime="
         + this.getCreateTime()
         + ", biddingPlatformName="
         + this.getBiddingPlatformName()
         + ", reasonForRegistration="
         + this.getReasonForRegistration()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", createUserName="
         + this.getCreateUserName()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBiddingPlatformTaskPageDTO)) {
         return false;
      }

      CrmBiddingPlatformTaskPageDTO other = (CrmBiddingPlatformTaskPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
      if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
         Object this$createTime = this.getCreateTime();
         Object other$createTime = other.getCreateTime();
         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
            Object this$biddingPlatformName = this.getBiddingPlatformName();
            Object other$biddingPlatformName = other.getBiddingPlatformName();
            if (this$biddingPlatformName == null ? other$biddingPlatformName == null : this$biddingPlatformName.equals(other$biddingPlatformName)) {
               Object this$reasonForRegistration = this.getReasonForRegistration();
               Object other$reasonForRegistration = other.getReasonForRegistration();
               if (this$reasonForRegistration == null ? other$reasonForRegistration == null : this$reasonForRegistration.equals(other$reasonForRegistration)) {
                  Object this$attachmentIds = this.getAttachmentIds();
                  Object other$attachmentIds = other.getAttachmentIds();
                  if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                     Object this$createUserName = this.getCreateUserName();
                     Object other$createUserName = other.getCreateUserName();
                     return this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName);
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
      return other instanceof CrmBiddingPlatformTaskPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $biddingPlatformName = this.getBiddingPlatformName();
      result = result * 59 + ($biddingPlatformName == null ? 43 : $biddingPlatformName.hashCode());
      Object $reasonForRegistration = this.getReasonForRegistration();
      result = result * 59 + ($reasonForRegistration == null ? 43 : $reasonForRegistration.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class CrmBiddingPlatformTaskPageDTOBuilder {
      private LocalDateTime createTime;
      private String biddingPlatformName;
      private String reasonForRegistration;
      private List<AttachmentDTO> attachmentIds;
      private String createUserName;
      private Integer crmCheckStatusEnum;

      CrmBiddingPlatformTaskPageDTOBuilder() {
      }

      public CrmBiddingPlatformTaskPageDTO.CrmBiddingPlatformTaskPageDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public CrmBiddingPlatformTaskPageDTO.CrmBiddingPlatformTaskPageDTOBuilder biddingPlatformName(final String biddingPlatformName) {
         this.biddingPlatformName = biddingPlatformName;
         return this;
      }

      public CrmBiddingPlatformTaskPageDTO.CrmBiddingPlatformTaskPageDTOBuilder reasonForRegistration(final String reasonForRegistration) {
         this.reasonForRegistration = reasonForRegistration;
         return this;
      }

      public CrmBiddingPlatformTaskPageDTO.CrmBiddingPlatformTaskPageDTOBuilder attachmentIds(final List<AttachmentDTO> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmBiddingPlatformTaskPageDTO.CrmBiddingPlatformTaskPageDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmBiddingPlatformTaskPageDTO.CrmBiddingPlatformTaskPageDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmBiddingPlatformTaskPageDTO build() {
         return new CrmBiddingPlatformTaskPageDTO(
            this.createTime, this.biddingPlatformName, this.reasonForRegistration, this.attachmentIds, this.createUserName, this.crmCheckStatusEnum
         );
      }

      @Override
      public String toString() {
         return "CrmBiddingPlatformTaskPageDTO.CrmBiddingPlatformTaskPageDTOBuilder(createTime="
            + this.createTime
            + ", biddingPlatformName="
            + this.biddingPlatformName
            + ", reasonForRegistration="
            + this.reasonForRegistration
            + ", attachmentIds="
            + this.attachmentIds
            + ", createUserName="
            + this.createUserName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ")";
      }
   }
}
