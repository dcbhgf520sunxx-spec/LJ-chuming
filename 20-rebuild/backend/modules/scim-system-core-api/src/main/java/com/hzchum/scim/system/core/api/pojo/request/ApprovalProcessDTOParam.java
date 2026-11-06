package com.hzchum.scim.system.core.api.pojo.request;

import java.util.List;

public class ApprovalProcessDTOParam {
   private Long id;
   private List<Long> applicantIds;
   private String approvalCode;
   private Integer type;
   private String approveInfoName;
   private List<ApproverDTOParam> list;

   public static ApprovalProcessDTOParam.ApprovalProcessDTOParamBuilder builder() {
      return new ApprovalProcessDTOParam.ApprovalProcessDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<Long> getApplicantIds() {
      return this.applicantIds;
   }

   public String getApprovalCode() {
      return this.approvalCode;
   }

   public Integer getType() {
      return this.type;
   }

   public String getApproveInfoName() {
      return this.approveInfoName;
   }

   public List<ApproverDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setApplicantIds(final List<Long> applicantIds) {
      this.applicantIds = applicantIds;
   }

   public void setApprovalCode(final String approvalCode) {
      this.approvalCode = approvalCode;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setApproveInfoName(final String approveInfoName) {
      this.approveInfoName = approveInfoName;
   }

   public void setList(final List<ApproverDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApprovalProcessDTOParam)) {
         return false;
      }

      ApprovalProcessDTOParam other = (ApprovalProcessDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$applicantIds = this.getApplicantIds();
            Object other$applicantIds = other.getApplicantIds();
            if (this$applicantIds == null ? other$applicantIds == null : this$applicantIds.equals(other$applicantIds)) {
               Object this$approvalCode = this.getApprovalCode();
               Object other$approvalCode = other.getApprovalCode();
               if (this$approvalCode == null ? other$approvalCode == null : this$approvalCode.equals(other$approvalCode)) {
                  Object this$approveInfoName = this.getApproveInfoName();
                  Object other$approveInfoName = other.getApproveInfoName();
                  if (this$approveInfoName == null ? other$approveInfoName == null : this$approveInfoName.equals(other$approveInfoName)) {
                     Object this$list = this.getList();
                     Object other$list = other.getList();
                     return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof ApprovalProcessDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $applicantIds = this.getApplicantIds();
      result = result * 59 + ($applicantIds == null ? 43 : $applicantIds.hashCode());
      Object $approvalCode = this.getApprovalCode();
      result = result * 59 + ($approvalCode == null ? 43 : $approvalCode.hashCode());
      Object $approveInfoName = this.getApproveInfoName();
      result = result * 59 + ($approveInfoName == null ? 43 : $approveInfoName.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "ApprovalProcessDTOParam(id="
         + this.getId()
         + ", applicantIds="
         + this.getApplicantIds()
         + ", approvalCode="
         + this.getApprovalCode()
         + ", type="
         + this.getType()
         + ", approveInfoName="
         + this.getApproveInfoName()
         + ", list="
         + this.getList()
         + ")";
   }

   public ApprovalProcessDTOParam(
      final Long id,
      final List<Long> applicantIds,
      final String approvalCode,
      final Integer type,
      final String approveInfoName,
      final List<ApproverDTOParam> list
   ) {
      this.id = id;
      this.applicantIds = applicantIds;
      this.approvalCode = approvalCode;
      this.type = type;
      this.approveInfoName = approveInfoName;
      this.list = list;
   }

   public ApprovalProcessDTOParam() {
   }

   public static class ApprovalProcessDTOParamBuilder {
      private Long id;
      private List<Long> applicantIds;
      private String approvalCode;
      private Integer type;
      private String approveInfoName;
      private List<ApproverDTOParam> list;

      ApprovalProcessDTOParamBuilder() {
      }

      public ApprovalProcessDTOParam.ApprovalProcessDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ApprovalProcessDTOParam.ApprovalProcessDTOParamBuilder applicantIds(final List<Long> applicantIds) {
         this.applicantIds = applicantIds;
         return this;
      }

      public ApprovalProcessDTOParam.ApprovalProcessDTOParamBuilder approvalCode(final String approvalCode) {
         this.approvalCode = approvalCode;
         return this;
      }

      public ApprovalProcessDTOParam.ApprovalProcessDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ApprovalProcessDTOParam.ApprovalProcessDTOParamBuilder approveInfoName(final String approveInfoName) {
         this.approveInfoName = approveInfoName;
         return this;
      }

      public ApprovalProcessDTOParam.ApprovalProcessDTOParamBuilder list(final List<ApproverDTOParam> list) {
         this.list = list;
         return this;
      }

      public ApprovalProcessDTOParam build() {
         return new ApprovalProcessDTOParam(this.id, this.applicantIds, this.approvalCode, this.type, this.approveInfoName, this.list);
      }

      @Override
      public String toString() {
         return "ApprovalProcessDTOParam.ApprovalProcessDTOParamBuilder(id="
            + this.id
            + ", applicantIds="
            + this.applicantIds
            + ", approvalCode="
            + this.approvalCode
            + ", type="
            + this.type
            + ", approveInfoName="
            + this.approveInfoName
            + ", list="
            + this.list
            + ")";
      }
   }
}
