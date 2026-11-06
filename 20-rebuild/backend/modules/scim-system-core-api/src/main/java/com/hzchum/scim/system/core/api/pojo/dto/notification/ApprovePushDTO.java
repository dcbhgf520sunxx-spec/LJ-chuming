package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class ApprovePushDTO {
   @ApiModelProperty(name = "approveRecordSerialNumber", value = "审批日志编号", notes = "审批日志编号")
   private String approveRecordSerialNumber;
   @ApiModelProperty(name = "userIds", value = "审批人ids  用逗号隔开", notes = "审批人ids  用逗号隔开")
   private String userIds;
   @ApiModelProperty(name = "type", value = "审批流程标识 1 会签 2或签 3单人 4抄送、通知  ApproveTemplateVersionsFlowEnum", notes = "审批流程标识 1 会签 2或签 3单人 4抄送、通知 m")
   private Integer type;
   @ApiModelProperty(name = "approveProcessName", value = "流程名称", notes = "流程名称")
   private Integer approveProcessName;
   @ApiModelProperty(name = "applicantUser", value = "申请人", notes = "申请人")
   private Long applicantUser;
   @ApiModelProperty(name = "applicantTime", value = "申请时间", notes = "申请时间")
   private LocalDateTime applicantTime;

   public static ApprovePushDTO.ApprovePushDTOBuilder builder() {
      return new ApprovePushDTO.ApprovePushDTOBuilder();
   }

   public ApprovePushDTO(
      final String approveRecordSerialNumber,
      final String userIds,
      final Integer type,
      final Integer approveProcessName,
      final Long applicantUser,
      final LocalDateTime applicantTime
   ) {
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      this.userIds = userIds;
      this.type = type;
      this.approveProcessName = approveProcessName;
      this.applicantUser = applicantUser;
      this.applicantTime = applicantTime;
   }

   public ApprovePushDTO() {
   }

   public String getApproveRecordSerialNumber() {
      return this.approveRecordSerialNumber;
   }

   public String getUserIds() {
      return this.userIds;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getApproveProcessName() {
      return this.approveProcessName;
   }

   public Long getApplicantUser() {
      return this.applicantUser;
   }

   public LocalDateTime getApplicantTime() {
      return this.applicantTime;
   }

   public void setApproveRecordSerialNumber(final String approveRecordSerialNumber) {
      this.approveRecordSerialNumber = approveRecordSerialNumber;
   }

   public void setUserIds(final String userIds) {
      this.userIds = userIds;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setApproveProcessName(final Integer approveProcessName) {
      this.approveProcessName = approveProcessName;
   }

   public void setApplicantUser(final Long applicantUser) {
      this.applicantUser = applicantUser;
   }

   public void setApplicantTime(final LocalDateTime applicantTime) {
      this.applicantTime = applicantTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApprovePushDTO)) {
         return false;
      }

      ApprovePushDTO other = (ApprovePushDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$approveProcessName = this.getApproveProcessName();
         Object other$approveProcessName = other.getApproveProcessName();
         if (this$approveProcessName == null ? other$approveProcessName == null : this$approveProcessName.equals(other$approveProcessName)) {
            Object this$applicantUser = this.getApplicantUser();
            Object other$applicantUser = other.getApplicantUser();
            if (this$applicantUser == null ? other$applicantUser == null : this$applicantUser.equals(other$applicantUser)) {
               Object this$approveRecordSerialNumber = this.getApproveRecordSerialNumber();
               Object other$approveRecordSerialNumber = other.getApproveRecordSerialNumber();
               if (this$approveRecordSerialNumber == null
                  ? other$approveRecordSerialNumber == null
                  : this$approveRecordSerialNumber.equals(other$approveRecordSerialNumber)) {
                  Object this$userIds = this.getUserIds();
                  Object other$userIds = other.getUserIds();
                  if (this$userIds == null ? other$userIds == null : this$userIds.equals(other$userIds)) {
                     Object this$applicantTime = this.getApplicantTime();
                     Object other$applicantTime = other.getApplicantTime();
                     return this$applicantTime == null ? other$applicantTime == null : this$applicantTime.equals(other$applicantTime);
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
      return other instanceof ApprovePushDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $approveProcessName = this.getApproveProcessName();
      result = result * 59 + ($approveProcessName == null ? 43 : $approveProcessName.hashCode());
      Object $applicantUser = this.getApplicantUser();
      result = result * 59 + ($applicantUser == null ? 43 : $applicantUser.hashCode());
      Object $approveRecordSerialNumber = this.getApproveRecordSerialNumber();
      result = result * 59 + ($approveRecordSerialNumber == null ? 43 : $approveRecordSerialNumber.hashCode());
      Object $userIds = this.getUserIds();
      result = result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
      Object $applicantTime = this.getApplicantTime();
      return result * 59 + ($applicantTime == null ? 43 : $applicantTime.hashCode());
   }

   @Override
   public String toString() {
      return "ApprovePushDTO(approveRecordSerialNumber="
         + this.getApproveRecordSerialNumber()
         + ", userIds="
         + this.getUserIds()
         + ", type="
         + this.getType()
         + ", approveProcessName="
         + this.getApproveProcessName()
         + ", applicantUser="
         + this.getApplicantUser()
         + ", applicantTime="
         + this.getApplicantTime()
         + ")";
   }

   public static class ApprovePushDTOBuilder {
      private String approveRecordSerialNumber;
      private String userIds;
      private Integer type;
      private Integer approveProcessName;
      private Long applicantUser;
      private LocalDateTime applicantTime;

      ApprovePushDTOBuilder() {
      }

      public ApprovePushDTO.ApprovePushDTOBuilder approveRecordSerialNumber(final String approveRecordSerialNumber) {
         this.approveRecordSerialNumber = approveRecordSerialNumber;
         return this;
      }

      public ApprovePushDTO.ApprovePushDTOBuilder userIds(final String userIds) {
         this.userIds = userIds;
         return this;
      }

      public ApprovePushDTO.ApprovePushDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ApprovePushDTO.ApprovePushDTOBuilder approveProcessName(final Integer approveProcessName) {
         this.approveProcessName = approveProcessName;
         return this;
      }

      public ApprovePushDTO.ApprovePushDTOBuilder applicantUser(final Long applicantUser) {
         this.applicantUser = applicantUser;
         return this;
      }

      public ApprovePushDTO.ApprovePushDTOBuilder applicantTime(final LocalDateTime applicantTime) {
         this.applicantTime = applicantTime;
         return this;
      }

      public ApprovePushDTO build() {
         return new ApprovePushDTO(this.approveRecordSerialNumber, this.userIds, this.type, this.approveProcessName, this.applicantUser, this.applicantTime);
      }

      @Override
      public String toString() {
         return "ApprovePushDTO.ApprovePushDTOBuilder(approveRecordSerialNumber="
            + this.approveRecordSerialNumber
            + ", userIds="
            + this.userIds
            + ", type="
            + this.type
            + ", approveProcessName="
            + this.approveProcessName
            + ", applicantUser="
            + this.applicantUser
            + ", applicantTime="
            + this.applicantTime
            + ")";
      }
   }
}
