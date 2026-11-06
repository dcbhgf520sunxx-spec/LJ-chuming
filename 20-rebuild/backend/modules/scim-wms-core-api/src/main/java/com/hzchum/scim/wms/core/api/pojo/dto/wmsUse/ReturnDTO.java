package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefDeptAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReturnDTO {
   private Long id;
   private Integer basicClass;
   private String serialNumber;
   private List<ProjectInfoDTO> projects;
   private List<BriefIdAndSNDTO> outboundList;
   private Integer reviewStatus;
   private String approvalComments;
   private Boolean editable;
   private String applicantName;
   private String editorName;
   private String reviewerName;
   private LocalDateTime reviewTime;
   private LocalDateTime returnTime;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private LocalDateTime userUpdateTime;
   private BriefDeptAndNameDTO applicant;
   private Boolean boolRealReturn;
   private Integer outboundTypeSelection;
   private Long approveRecordId;
   private List<ReturnDetailDTO> list;
   private Integer returnDestination;
   private BigDecimal amount;
   private BigDecimal amountExcludingVat;
   private BigDecimal inputVat;
   private Boolean boolPrinted;

   public static ReturnDTO.ReturnDTOBuilder builder() {
      return new ReturnDTO.ReturnDTOBuilder();
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

   public String getApprovalComments() {
      return this.approvalComments;
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

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getReturnTime() {
      return this.returnTime;
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

   public Boolean getBoolRealReturn() {
      return this.boolRealReturn;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public List<ReturnDetailDTO> getList() {
      return this.list;
   }

   public Integer getReturnDestination() {
      return this.returnDestination;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
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

   public void setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
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

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setReturnTime(final LocalDateTime returnTime) {
      this.returnTime = returnTime;
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

   public void setBoolRealReturn(final Boolean boolRealReturn) {
      this.boolRealReturn = boolRealReturn;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setList(final List<ReturnDetailDTO> list) {
      this.list = list;
   }

   public void setReturnDestination(final Integer returnDestination) {
      this.returnDestination = returnDestination;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   public void setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnDTO)) {
         return false;
      }

      ReturnDTO other = (ReturnDTO)o;
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
                  Object this$boolRealReturn = this.getBoolRealReturn();
                  Object other$boolRealReturn = other.getBoolRealReturn();
                  if (this$boolRealReturn == null ? other$boolRealReturn == null : this$boolRealReturn.equals(other$boolRealReturn)) {
                     Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                     Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                     if (this$outboundTypeSelection == null
                        ? other$outboundTypeSelection == null
                        : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                        Object this$approveRecordId = this.getApproveRecordId();
                        Object other$approveRecordId = other.getApproveRecordId();
                        if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                           Object this$returnDestination = this.getReturnDestination();
                           Object other$returnDestination = other.getReturnDestination();
                           if (this$returnDestination == null ? other$returnDestination == null : this$returnDestination.equals(other$returnDestination)) {
                              Object this$boolPrinted = this.getBoolPrinted();
                              Object other$boolPrinted = other.getBoolPrinted();
                              if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$projects = this.getProjects();
                                    Object other$projects = other.getProjects();
                                    if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                       Object this$outboundList = this.getOutboundList();
                                       Object other$outboundList = other.getOutboundList();
                                       if (this$outboundList == null ? other$outboundList == null : this$outboundList.equals(other$outboundList)) {
                                          Object this$approvalComments = this.getApprovalComments();
                                          Object other$approvalComments = other.getApprovalComments();
                                          if (this$approvalComments == null
                                             ? other$approvalComments == null
                                             : this$approvalComments.equals(other$approvalComments)) {
                                             Object this$applicantName = this.getApplicantName();
                                             Object other$applicantName = other.getApplicantName();
                                             if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                                Object this$editorName = this.getEditorName();
                                                Object other$editorName = other.getEditorName();
                                                if (this$editorName == null ? other$editorName == null : this$editorName.equals(other$editorName)) {
                                                   Object this$reviewerName = this.getReviewerName();
                                                   Object other$reviewerName = other.getReviewerName();
                                                   if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                                      Object this$reviewTime = this.getReviewTime();
                                                      Object other$reviewTime = other.getReviewTime();
                                                      if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                                         Object this$returnTime = this.getReturnTime();
                                                         Object other$returnTime = other.getReturnTime();
                                                         if (this$returnTime == null ? other$returnTime == null : this$returnTime.equals(other$returnTime)) {
                                                            Object this$createTime = this.getCreateTime();
                                                            Object other$createTime = other.getCreateTime();
                                                            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                               Object this$updateTime = this.getUpdateTime();
                                                               Object other$updateTime = other.getUpdateTime();
                                                               if (this$updateTime == null
                                                                  ? other$updateTime == null
                                                                  : this$updateTime.equals(other$updateTime)) {
                                                                  Object this$userUpdateTime = this.getUserUpdateTime();
                                                                  Object other$userUpdateTime = other.getUserUpdateTime();
                                                                  if (this$userUpdateTime == null
                                                                     ? other$userUpdateTime == null
                                                                     : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                     Object this$applicant = this.getApplicant();
                                                                     Object other$applicant = other.getApplicant();
                                                                     if (this$applicant == null
                                                                        ? other$applicant == null
                                                                        : this$applicant.equals(other$applicant)) {
                                                                        Object this$list = this.getList();
                                                                        Object other$list = other.getList();
                                                                        if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                                                           Object this$amount = this.getAmount();
                                                                           Object other$amount = other.getAmount();
                                                                           if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                              Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                              Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                              if (this$amountExcludingVat == null
                                                                                 ? other$amountExcludingVat == null
                                                                                 : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                 Object this$inputVat = this.getInputVat();
                                                                                 Object other$inputVat = other.getInputVat();
                                                                                 return this$inputVat == null
                                                                                    ? other$inputVat == null
                                                                                    : this$inputVat.equals(other$inputVat);
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
      return other instanceof ReturnDTO;
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
      Object $boolRealReturn = this.getBoolRealReturn();
      result = result * 59 + ($boolRealReturn == null ? 43 : $boolRealReturn.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $returnDestination = this.getReturnDestination();
      result = result * 59 + ($returnDestination == null ? 43 : $returnDestination.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $outboundList = this.getOutboundList();
      result = result * 59 + ($outboundList == null ? 43 : $outboundList.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      return result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnDTO(id="
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
         + ", approvalComments="
         + this.getApprovalComments()
         + ", editable="
         + this.getEditable()
         + ", applicantName="
         + this.getApplicantName()
         + ", editorName="
         + this.getEditorName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", returnTime="
         + this.getReturnTime()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", applicant="
         + this.getApplicant()
         + ", boolRealReturn="
         + this.getBoolRealReturn()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", list="
         + this.getList()
         + ", returnDestination="
         + this.getReturnDestination()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ")";
   }

   public ReturnDTO(
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final List<ProjectInfoDTO> projects,
      final List<BriefIdAndSNDTO> outboundList,
      final Integer reviewStatus,
      final String approvalComments,
      final Boolean editable,
      final String applicantName,
      final String editorName,
      final String reviewerName,
      final LocalDateTime reviewTime,
      final LocalDateTime returnTime,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final LocalDateTime userUpdateTime,
      final BriefDeptAndNameDTO applicant,
      final Boolean boolRealReturn,
      final Integer outboundTypeSelection,
      final Long approveRecordId,
      final List<ReturnDetailDTO> list,
      final Integer returnDestination,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final Boolean boolPrinted
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.projects = projects;
      this.outboundList = outboundList;
      this.reviewStatus = reviewStatus;
      this.approvalComments = approvalComments;
      this.editable = editable;
      this.applicantName = applicantName;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
      this.returnTime = returnTime;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.userUpdateTime = userUpdateTime;
      this.applicant = applicant;
      this.boolRealReturn = boolRealReturn;
      this.outboundTypeSelection = outboundTypeSelection;
      this.approveRecordId = approveRecordId;
      this.list = list;
      this.returnDestination = returnDestination;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.boolPrinted = boolPrinted;
   }

   public ReturnDTO() {
   }

   public static class ReturnDTOBuilder {
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private List<ProjectInfoDTO> projects;
      private List<BriefIdAndSNDTO> outboundList;
      private Integer reviewStatus;
      private String approvalComments;
      private Boolean editable;
      private String applicantName;
      private String editorName;
      private String reviewerName;
      private LocalDateTime reviewTime;
      private LocalDateTime returnTime;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private LocalDateTime userUpdateTime;
      private BriefDeptAndNameDTO applicant;
      private Boolean boolRealReturn;
      private Integer outboundTypeSelection;
      private Long approveRecordId;
      private List<ReturnDetailDTO> list;
      private Integer returnDestination;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private Boolean boolPrinted;

      ReturnDTOBuilder() {
      }

      public ReturnDTO.ReturnDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder projects(final List<ProjectInfoDTO> projects) {
         this.projects = projects;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder outboundList(final List<BriefIdAndSNDTO> outboundList) {
         this.outboundList = outboundList;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder returnTime(final LocalDateTime returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder applicant(final BriefDeptAndNameDTO applicant) {
         this.applicant = applicant;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder boolRealReturn(final Boolean boolRealReturn) {
         this.boolRealReturn = boolRealReturn;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder list(final List<ReturnDetailDTO> list) {
         this.list = list;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder returnDestination(final Integer returnDestination) {
         this.returnDestination = returnDestination;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public ReturnDTO.ReturnDTOBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public ReturnDTO build() {
         return new ReturnDTO(
            this.id,
            this.basicClass,
            this.serialNumber,
            this.projects,
            this.outboundList,
            this.reviewStatus,
            this.approvalComments,
            this.editable,
            this.applicantName,
            this.editorName,
            this.reviewerName,
            this.reviewTime,
            this.returnTime,
            this.createTime,
            this.updateTime,
            this.userUpdateTime,
            this.applicant,
            this.boolRealReturn,
            this.outboundTypeSelection,
            this.approveRecordId,
            this.list,
            this.returnDestination,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.boolPrinted
         );
      }

      @Override
      public String toString() {
         return "ReturnDTO.ReturnDTOBuilder(id="
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
            + ", approvalComments="
            + this.approvalComments
            + ", editable="
            + this.editable
            + ", applicantName="
            + this.applicantName
            + ", editorName="
            + this.editorName
            + ", reviewerName="
            + this.reviewerName
            + ", reviewTime="
            + this.reviewTime
            + ", returnTime="
            + this.returnTime
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", applicant="
            + this.applicant
            + ", boolRealReturn="
            + this.boolRealReturn
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", approveRecordId="
            + this.approveRecordId
            + ", list="
            + this.list
            + ", returnDestination="
            + this.returnDestination
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", boolPrinted="
            + this.boolPrinted
            + ")";
      }
   }
}
