package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class CrmBiddingPlatformTaskPageDownLoadDTO {
   @ApiModelProperty(name = "createTime", notes = "下达日期")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "biddingPlatformName", notes = "招标平台名称")
   private String biddingPlatformName;
   @ApiModelProperty(name = "reasonForRegistration", value = "报名事由", notes = "报名事由")
   private String reasonForRegistration;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "状态", notes = "状态")
   private Integer crmCheckStatusEnum;

   public static CrmBiddingPlatformTaskPageDownLoadDTO.CrmBiddingPlatformTaskPageDownLoadDTOBuilder builder() {
      return new CrmBiddingPlatformTaskPageDownLoadDTO.CrmBiddingPlatformTaskPageDownLoadDTOBuilder();
   }

   public CrmBiddingPlatformTaskPageDownLoadDTO() {
   }

   public CrmBiddingPlatformTaskPageDownLoadDTO(
      final LocalDateTime createTime,
      final String biddingPlatformName,
      final String reasonForRegistration,
      final String createUserName,
      final Integer crmCheckStatusEnum
   ) {
      this.createTime = createTime;
      this.biddingPlatformName = biddingPlatformName;
      this.reasonForRegistration = reasonForRegistration;
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

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public CrmBiddingPlatformTaskPageDownLoadDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public CrmBiddingPlatformTaskPageDownLoadDTO setBiddingPlatformName(final String biddingPlatformName) {
      this.biddingPlatformName = biddingPlatformName;
      return this;
   }

   public CrmBiddingPlatformTaskPageDownLoadDTO setReasonForRegistration(final String reasonForRegistration) {
      this.reasonForRegistration = reasonForRegistration;
      return this;
   }

   public CrmBiddingPlatformTaskPageDownLoadDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmBiddingPlatformTaskPageDownLoadDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBiddingPlatformTaskPageDownLoadDTO(createTime="
         + this.getCreateTime()
         + ", biddingPlatformName="
         + this.getBiddingPlatformName()
         + ", reasonForRegistration="
         + this.getReasonForRegistration()
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

      if (!(o instanceof CrmBiddingPlatformTaskPageDownLoadDTO)) {
         return false;
      }

      CrmBiddingPlatformTaskPageDownLoadDTO other = (CrmBiddingPlatformTaskPageDownLoadDTO)o;
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmBiddingPlatformTaskPageDownLoadDTO;
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
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class CrmBiddingPlatformTaskPageDownLoadDTOBuilder {
      private LocalDateTime createTime;
      private String biddingPlatformName;
      private String reasonForRegistration;
      private String createUserName;
      private Integer crmCheckStatusEnum;

      CrmBiddingPlatformTaskPageDownLoadDTOBuilder() {
      }

      public CrmBiddingPlatformTaskPageDownLoadDTO.CrmBiddingPlatformTaskPageDownLoadDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public CrmBiddingPlatformTaskPageDownLoadDTO.CrmBiddingPlatformTaskPageDownLoadDTOBuilder biddingPlatformName(final String biddingPlatformName) {
         this.biddingPlatformName = biddingPlatformName;
         return this;
      }

      public CrmBiddingPlatformTaskPageDownLoadDTO.CrmBiddingPlatformTaskPageDownLoadDTOBuilder reasonForRegistration(final String reasonForRegistration) {
         this.reasonForRegistration = reasonForRegistration;
         return this;
      }

      public CrmBiddingPlatformTaskPageDownLoadDTO.CrmBiddingPlatformTaskPageDownLoadDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmBiddingPlatformTaskPageDownLoadDTO.CrmBiddingPlatformTaskPageDownLoadDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmBiddingPlatformTaskPageDownLoadDTO build() {
         return new CrmBiddingPlatformTaskPageDownLoadDTO(
            this.createTime, this.biddingPlatformName, this.reasonForRegistration, this.createUserName, this.crmCheckStatusEnum
         );
      }

      @Override
      public String toString() {
         return "CrmBiddingPlatformTaskPageDownLoadDTO.CrmBiddingPlatformTaskPageDownLoadDTOBuilder(createTime="
            + this.createTime
            + ", biddingPlatformName="
            + this.biddingPlatformName
            + ", reasonForRegistration="
            + this.reasonForRegistration
            + ", createUserName="
            + this.createUserName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ")";
      }
   }
}
