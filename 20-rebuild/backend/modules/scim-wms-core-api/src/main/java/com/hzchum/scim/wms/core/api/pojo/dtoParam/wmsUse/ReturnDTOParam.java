package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefDeptAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.time.LocalDateTime;
import java.util.List;

public class ReturnDTOParam {
   private Long id;
   private Integer basicClass;
   private String serialNumber;
   private List<ProjectInfoDTO> projects;
   private List<BriefIdAndSNDTO> outboundList;
   private Integer reviewStatus;
   private Boolean editable;
   private String applicantName;
   private String editorName;
   private String reviewerName;
   private String approvalComments;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private LocalDateTime userUpdateTime;
   private BriefDeptAndNameDTO applicant;
   private List<ReturnDetailDTOParam> list;

   public static ReturnDTOParam.ReturnDTOParamBuilder builder() {
      return new ReturnDTOParam.ReturnDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<ProjectInfoDTO> getProjects() {
      return this.projects;
   }

   public List<BriefIdAndSNDTO> getOutboundList() {
      return this.outboundList;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public BriefDeptAndNameDTO getApplicant() {
      return this.applicant;
   }

   public List<ReturnDetailDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjects(final List<ProjectInfoDTO> projects) {
      this.projects = projects;
   }

   public void setOutboundList(final List<BriefIdAndSNDTO> outboundList) {
      this.outboundList = outboundList;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setEditable(final Boolean editable) {
      this.editable = editable;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setEditorName(final String editorName) {
      this.editorName = editorName;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setApplicant(final BriefDeptAndNameDTO applicant) {
      this.applicant = applicant;
   }

   public void setList(final List<ReturnDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnDTOParam)) {
         return false;
      }

      ReturnDTOParam other = (ReturnDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$editable = this.getEditable();
               Object other$editable = other.getEditable();
               if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$projects = this.getProjects();
                     Object other$projects = other.getProjects();
                     if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                        Object this$outboundList = this.getOutboundList();
                        Object other$outboundList = other.getOutboundList();
                        if (this$outboundList == null ? other$outboundList == null : this$outboundList.equals(other$outboundList)) {
                           Object this$applicantName = this.getApplicantName();
                           Object other$applicantName = other.getApplicantName();
                           if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                              Object this$editorName = this.getEditorName();
                              Object other$editorName = other.getEditorName();
                              if (this$editorName == null ? other$editorName == null : this$editorName.equals(other$editorName)) {
                                 Object this$reviewerName = this.getReviewerName();
                                 Object other$reviewerName = other.getReviewerName();
                                 if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                    Object this$approvalComments = this.getApprovalComments();
                                    Object other$approvalComments = other.getApprovalComments();
                                    if (this$approvalComments == null ? other$approvalComments == null : this$approvalComments.equals(other$approvalComments)) {
                                       Object this$createTime = this.getCreateTime();
                                       Object other$createTime = other.getCreateTime();
                                       if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                          Object this$updateTime = this.getUpdateTime();
                                          Object other$updateTime = other.getUpdateTime();
                                          if (this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime)) {
                                             Object this$userUpdateTime = this.getUserUpdateTime();
                                             Object other$userUpdateTime = other.getUserUpdateTime();
                                             if (this$userUpdateTime == null ? other$userUpdateTime == null : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                Object this$applicant = this.getApplicant();
                                                Object other$applicant = other.getApplicant();
                                                if (this$applicant == null ? other$applicant == null : this$applicant.equals(other$applicant)) {
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
      return other instanceof ReturnDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $outboundList = this.getOutboundList();
      result = result * 59 + ($outboundList == null ? 43 : $outboundList.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnDTOParam(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projects="
         + this.getProjects()
         + ", outboundList="
         + this.getOutboundList()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", editable="
         + this.getEditable()
         + ", applicantName="
         + this.getApplicantName()
         + ", editorName="
         + this.getEditorName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", applicant="
         + this.getApplicant()
         + ", list="
         + this.getList()
         + ")";
   }

   public ReturnDTOParam(
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final List<ProjectInfoDTO> projects,
      final List<BriefIdAndSNDTO> outboundList,
      final Integer reviewStatus,
      final Boolean editable,
      final String applicantName,
      final String editorName,
      final String reviewerName,
      final String approvalComments,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final LocalDateTime userUpdateTime,
      final BriefDeptAndNameDTO applicant,
      final List<ReturnDetailDTOParam> list
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.projects = projects;
      this.outboundList = outboundList;
      this.reviewStatus = reviewStatus;
      this.editable = editable;
      this.applicantName = applicantName;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.approvalComments = approvalComments;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.userUpdateTime = userUpdateTime;
      this.applicant = applicant;
      this.list = list;
   }

   public ReturnDTOParam() {
   }

   public static class ReturnDTOParamBuilder {
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private List<ProjectInfoDTO> projects;
      private List<BriefIdAndSNDTO> outboundList;
      private Integer reviewStatus;
      private Boolean editable;
      private String applicantName;
      private String editorName;
      private String reviewerName;
      private String approvalComments;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private LocalDateTime userUpdateTime;
      private BriefDeptAndNameDTO applicant;
      private List<ReturnDetailDTOParam> list;

      ReturnDTOParamBuilder() {
      }

      public ReturnDTOParam.ReturnDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder projects(final List<ProjectInfoDTO> projects) {
         this.projects = projects;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder outboundList(final List<BriefIdAndSNDTO> outboundList) {
         this.outboundList = outboundList;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder applicant(final BriefDeptAndNameDTO applicant) {
         this.applicant = applicant;
         return this;
      }

      public ReturnDTOParam.ReturnDTOParamBuilder list(final List<ReturnDetailDTOParam> list) {
         this.list = list;
         return this;
      }

      public ReturnDTOParam build() {
         return new ReturnDTOParam(
            this.id,
            this.basicClass,
            this.serialNumber,
            this.projects,
            this.outboundList,
            this.reviewStatus,
            this.editable,
            this.applicantName,
            this.editorName,
            this.reviewerName,
            this.approvalComments,
            this.createTime,
            this.updateTime,
            this.userUpdateTime,
            this.applicant,
            this.list
         );
      }

      @Override
      public String toString() {
         return "ReturnDTOParam.ReturnDTOParamBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", projects="
            + this.projects
            + ", outboundList="
            + this.outboundList
            + ", reviewStatus="
            + this.reviewStatus
            + ", editable="
            + this.editable
            + ", applicantName="
            + this.applicantName
            + ", editorName="
            + this.editorName
            + ", reviewerName="
            + this.reviewerName
            + ", approvalComments="
            + this.approvalComments
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", applicant="
            + this.applicant
            + ", list="
            + this.list
            + ")";
      }
   }
}
