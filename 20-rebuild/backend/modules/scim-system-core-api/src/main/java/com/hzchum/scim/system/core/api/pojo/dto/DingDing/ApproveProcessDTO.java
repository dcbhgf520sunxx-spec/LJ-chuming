package com.hzchum.scim.system.core.api.pojo.dto.DingDing;

import com.hzchum.scim.common.core.api.pojo.vo.ApproveInfoVO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApproveProcessDTO {
   private Long id;
   private Integer type;
   private String code;
   private Integer approvalType;
   private String approveInfoName;
   private List<ApproveInfoVO> approvers = new ArrayList<>();
   private List<Long> applicantIds;
   private LocalDateTime updateTime;

   public static ApproveProcessDTO.ApproveProcessDTOBuilder builder() {
      return new ApproveProcessDTO.ApproveProcessDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getApprovalType() {
      return this.approvalType;
   }

   public String getApproveInfoName() {
      return this.approveInfoName;
   }

   public List<ApproveInfoVO> getApprovers() {
      return this.approvers;
   }

   public List<Long> getApplicantIds() {
      return this.applicantIds;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setApprovalType(final Integer approvalType) {
      this.approvalType = approvalType;
   }

   public void setApproveInfoName(final String approveInfoName) {
      this.approveInfoName = approveInfoName;
   }

   public void setApprovers(final List<ApproveInfoVO> approvers) {
      this.approvers = approvers;
   }

   public void setApplicantIds(final List<Long> applicantIds) {
      this.applicantIds = applicantIds;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApproveProcessDTO)) {
         return false;
      }

      ApproveProcessDTO other = (ApproveProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$approvalType = this.getApprovalType();
            Object other$approvalType = other.getApprovalType();
            if (this$approvalType == null ? other$approvalType == null : this$approvalType.equals(other$approvalType)) {
               Object this$code = this.getCode();
               Object other$code = other.getCode();
               if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                  Object this$approveInfoName = this.getApproveInfoName();
                  Object other$approveInfoName = other.getApproveInfoName();
                  if (this$approveInfoName == null ? other$approveInfoName == null : this$approveInfoName.equals(other$approveInfoName)) {
                     Object this$approvers = this.getApprovers();
                     Object other$approvers = other.getApprovers();
                     if (this$approvers == null ? other$approvers == null : this$approvers.equals(other$approvers)) {
                        Object this$applicantIds = this.getApplicantIds();
                        Object other$applicantIds = other.getApplicantIds();
                        if (this$applicantIds == null ? other$applicantIds == null : this$applicantIds.equals(other$applicantIds)) {
                           Object this$updateTime = this.getUpdateTime();
                           Object other$updateTime = other.getUpdateTime();
                           return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof ApproveProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $approvalType = this.getApprovalType();
      result = result * 59 + ($approvalType == null ? 43 : $approvalType.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $approveInfoName = this.getApproveInfoName();
      result = result * 59 + ($approveInfoName == null ? 43 : $approveInfoName.hashCode());
      Object $approvers = this.getApprovers();
      result = result * 59 + ($approvers == null ? 43 : $approvers.hashCode());
      Object $applicantIds = this.getApplicantIds();
      result = result * 59 + ($applicantIds == null ? 43 : $applicantIds.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "ApproveProcessDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", code="
         + this.getCode()
         + ", approvalType="
         + this.getApprovalType()
         + ", approveInfoName="
         + this.getApproveInfoName()
         + ", approvers="
         + this.getApprovers()
         + ", applicantIds="
         + this.getApplicantIds()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }

   public ApproveProcessDTO(
      final Long id,
      final Integer type,
      final String code,
      final Integer approvalType,
      final String approveInfoName,
      final List<ApproveInfoVO> approvers,
      final List<Long> applicantIds,
      final LocalDateTime updateTime
   ) {
      this.id = id;
      this.type = type;
      this.code = code;
      this.approvalType = approvalType;
      this.approveInfoName = approveInfoName;
      this.approvers = approvers;
      this.applicantIds = applicantIds;
      this.updateTime = updateTime;
   }

   public ApproveProcessDTO() {
   }

   public static class ApproveProcessDTOBuilder {
      private Long id;
      private Integer type;
      private String code;
      private Integer approvalType;
      private String approveInfoName;
      private List<ApproveInfoVO> approvers;
      private List<Long> applicantIds;
      private LocalDateTime updateTime;

      ApproveProcessDTOBuilder() {
      }

      public ApproveProcessDTO.ApproveProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ApproveProcessDTO.ApproveProcessDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ApproveProcessDTO.ApproveProcessDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public ApproveProcessDTO.ApproveProcessDTOBuilder approvalType(final Integer approvalType) {
         this.approvalType = approvalType;
         return this;
      }

      public ApproveProcessDTO.ApproveProcessDTOBuilder approveInfoName(final String approveInfoName) {
         this.approveInfoName = approveInfoName;
         return this;
      }

      public ApproveProcessDTO.ApproveProcessDTOBuilder approvers(final List<ApproveInfoVO> approvers) {
         this.approvers = approvers;
         return this;
      }

      public ApproveProcessDTO.ApproveProcessDTOBuilder applicantIds(final List<Long> applicantIds) {
         this.applicantIds = applicantIds;
         return this;
      }

      public ApproveProcessDTO.ApproveProcessDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public ApproveProcessDTO build() {
         return new ApproveProcessDTO(
            this.id, this.type, this.code, this.approvalType, this.approveInfoName, this.approvers, this.applicantIds, this.updateTime
         );
      }

      @Override
      public String toString() {
         return "ApproveProcessDTO.ApproveProcessDTOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", code="
            + this.code
            + ", approvalType="
            + this.approvalType
            + ", approveInfoName="
            + this.approveInfoName
            + ", approvers="
            + this.approvers
            + ", applicantIds="
            + this.applicantIds
            + ", updateTime="
            + this.updateTime
            + ")";
      }
   }
}
