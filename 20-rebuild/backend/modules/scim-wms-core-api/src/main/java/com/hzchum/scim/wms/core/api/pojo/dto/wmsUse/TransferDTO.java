package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.DTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransferDTO {
   private Long id;
   private Integer basicClass;
   private Boolean boolPartyA;
   private String serialNumber;
   private List<DTO> source;
   private DTO direction;
   private ProjectInfo borrowProject;
   private Boolean boolBorrowReturnNotSelf = false;
   private Boolean boolHasUnfreeze;
   private Integer transferCreateType;
   private Integer transferType;
   private Integer reviewStatus;
   private String applicantName;
   private String editorName;
   private String reviewerName;
   private String approvalComments;
   private LocalDateTime reviewTime;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private LocalDateTime userUpdateTime;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private Boolean boolPrinted;
   private String outboundSn;

   public static TransferDTO.TransferDTOBuilder builder() {
      return new TransferDTO.TransferDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<DTO> getSource() {
      return this.source;
   }

   public DTO getDirection() {
      return this.direction;
   }

   public ProjectInfo getBorrowProject() {
      return this.borrowProject;
   }

   public Boolean getBoolBorrowReturnNotSelf() {
      return this.boolBorrowReturnNotSelf;
   }

   public Boolean getBoolHasUnfreeze() {
      return this.boolHasUnfreeze;
   }

   public Integer getTransferCreateType() {
      return this.transferCreateType;
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
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

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
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

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getInputVAT() {
      return this.inputVAT;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public String getOutboundSn() {
      return this.outboundSn;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSource(final List<DTO> source) {
      this.source = source;
   }

   public void setDirection(final DTO direction) {
      this.direction = direction;
   }

   public void setBorrowProject(final ProjectInfo borrowProject) {
      this.borrowProject = borrowProject;
   }

   public void setBoolBorrowReturnNotSelf(final Boolean boolBorrowReturnNotSelf) {
      this.boolBorrowReturnNotSelf = boolBorrowReturnNotSelf;
   }

   public void setBoolHasUnfreeze(final Boolean boolHasUnfreeze) {
      this.boolHasUnfreeze = boolHasUnfreeze;
   }

   public void setTransferCreateType(final Integer transferCreateType) {
      this.transferCreateType = transferCreateType;
   }

   public void setTransferType(final Integer transferType) {
      this.transferType = transferType;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
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

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
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

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   public void setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
   }

   public void setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferDTO)) {
         return false;
      }

      TransferDTO other = (TransferDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$boolBorrowReturnNotSelf = this.getBoolBorrowReturnNotSelf();
               Object other$boolBorrowReturnNotSelf = other.getBoolBorrowReturnNotSelf();
               if (this$boolBorrowReturnNotSelf == null
                  ? other$boolBorrowReturnNotSelf == null
                  : this$boolBorrowReturnNotSelf.equals(other$boolBorrowReturnNotSelf)) {
                  Object this$boolHasUnfreeze = this.getBoolHasUnfreeze();
                  Object other$boolHasUnfreeze = other.getBoolHasUnfreeze();
                  if (this$boolHasUnfreeze == null ? other$boolHasUnfreeze == null : this$boolHasUnfreeze.equals(other$boolHasUnfreeze)) {
                     Object this$transferCreateType = this.getTransferCreateType();
                     Object other$transferCreateType = other.getTransferCreateType();
                     if (this$transferCreateType == null ? other$transferCreateType == null : this$transferCreateType.equals(other$transferCreateType)) {
                        Object this$transferType = this.getTransferType();
                        Object other$transferType = other.getTransferType();
                        if (this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType)) {
                           Object this$reviewStatus = this.getReviewStatus();
                           Object other$reviewStatus = other.getReviewStatus();
                           if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                              Object this$boolPrinted = this.getBoolPrinted();
                              Object other$boolPrinted = other.getBoolPrinted();
                              if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$source = this.getSource();
                                    Object other$source = other.getSource();
                                    if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                                       Object this$direction = this.getDirection();
                                       Object other$direction = other.getDirection();
                                       if (this$direction == null ? other$direction == null : this$direction.equals(other$direction)) {
                                          Object this$borrowProject = this.getBorrowProject();
                                          Object other$borrowProject = other.getBorrowProject();
                                          if (this$borrowProject == null ? other$borrowProject == null : this$borrowProject.equals(other$borrowProject)) {
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
                                                      if (this$approvalComments == null
                                                         ? other$approvalComments == null
                                                         : this$approvalComments.equals(other$approvalComments)) {
                                                         Object this$reviewTime = this.getReviewTime();
                                                         Object other$reviewTime = other.getReviewTime();
                                                         if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
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
                                                                     Object this$amount = this.getAmount();
                                                                     Object other$amount = other.getAmount();
                                                                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                        Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                                                        Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                                                        if (this$amountExcludingVAT == null
                                                                           ? other$amountExcludingVAT == null
                                                                           : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                                                                           Object this$inputVAT = this.getInputVAT();
                                                                           Object other$inputVAT = other.getInputVAT();
                                                                           if (this$inputVAT == null
                                                                              ? other$inputVAT == null
                                                                              : this$inputVAT.equals(other$inputVAT)) {
                                                                              Object this$outboundSn = this.getOutboundSn();
                                                                              Object other$outboundSn = other.getOutboundSn();
                                                                              return this$outboundSn == null
                                                                                 ? other$outboundSn == null
                                                                                 : this$outboundSn.equals(other$outboundSn);
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
      return other instanceof TransferDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $boolBorrowReturnNotSelf = this.getBoolBorrowReturnNotSelf();
      result = result * 59 + ($boolBorrowReturnNotSelf == null ? 43 : $boolBorrowReturnNotSelf.hashCode());
      Object $boolHasUnfreeze = this.getBoolHasUnfreeze();
      result = result * 59 + ($boolHasUnfreeze == null ? 43 : $boolHasUnfreeze.hashCode());
      Object $transferCreateType = this.getTransferCreateType();
      result = result * 59 + ($transferCreateType == null ? 43 : $transferCreateType.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $direction = this.getDirection();
      result = result * 59 + ($direction == null ? 43 : $direction.hashCode());
      Object $borrowProject = this.getBorrowProject();
      result = result * 59 + ($borrowProject == null ? 43 : $borrowProject.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      result = result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
      Object $outboundSn = this.getOutboundSn();
      return result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
   }

   @Override
   public String toString() {
      return "TransferDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", source="
         + this.getSource()
         + ", direction="
         + this.getDirection()
         + ", borrowProject="
         + this.getBorrowProject()
         + ", boolBorrowReturnNotSelf="
         + this.getBoolBorrowReturnNotSelf()
         + ", boolHasUnfreeze="
         + this.getBoolHasUnfreeze()
         + ", transferCreateType="
         + this.getTransferCreateType()
         + ", transferType="
         + this.getTransferType()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", applicantName="
         + this.getApplicantName()
         + ", editorName="
         + this.getEditorName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", reviewTime="
         + this.getReviewTime()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", outboundSn="
         + this.getOutboundSn()
         + ")";
   }

   public TransferDTO(
      final Long id,
      final Integer basicClass,
      final Boolean boolPartyA,
      final String serialNumber,
      final List<DTO> source,
      final DTO direction,
      final ProjectInfo borrowProject,
      final Boolean boolBorrowReturnNotSelf,
      final Boolean boolHasUnfreeze,
      final Integer transferCreateType,
      final Integer transferType,
      final Integer reviewStatus,
      final String applicantName,
      final String editorName,
      final String reviewerName,
      final String approvalComments,
      final LocalDateTime reviewTime,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final LocalDateTime userUpdateTime,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final Boolean boolPrinted,
      final String outboundSn
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.boolPartyA = boolPartyA;
      this.serialNumber = serialNumber;
      this.source = source;
      this.direction = direction;
      this.borrowProject = borrowProject;
      this.boolBorrowReturnNotSelf = boolBorrowReturnNotSelf;
      this.boolHasUnfreeze = boolHasUnfreeze;
      this.transferCreateType = transferCreateType;
      this.transferType = transferType;
      this.reviewStatus = reviewStatus;
      this.applicantName = applicantName;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.approvalComments = approvalComments;
      this.reviewTime = reviewTime;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.userUpdateTime = userUpdateTime;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.boolPrinted = boolPrinted;
      this.outboundSn = outboundSn;
   }

   public TransferDTO() {
   }

   public static class TransferDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Boolean boolPartyA;
      private String serialNumber;
      private List<DTO> source;
      private DTO direction;
      private ProjectInfo borrowProject;
      private Boolean boolBorrowReturnNotSelf;
      private Boolean boolHasUnfreeze;
      private Integer transferCreateType;
      private Integer transferType;
      private Integer reviewStatus;
      private String applicantName;
      private String editorName;
      private String reviewerName;
      private String approvalComments;
      private LocalDateTime reviewTime;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private LocalDateTime userUpdateTime;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private Boolean boolPrinted;
      private String outboundSn;

      TransferDTOBuilder() {
      }

      public TransferDTO.TransferDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TransferDTO.TransferDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public TransferDTO.TransferDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public TransferDTO.TransferDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TransferDTO.TransferDTOBuilder source(final List<DTO> source) {
         this.source = source;
         return this;
      }

      public TransferDTO.TransferDTOBuilder direction(final DTO direction) {
         this.direction = direction;
         return this;
      }

      public TransferDTO.TransferDTOBuilder borrowProject(final ProjectInfo borrowProject) {
         this.borrowProject = borrowProject;
         return this;
      }

      public TransferDTO.TransferDTOBuilder boolBorrowReturnNotSelf(final Boolean boolBorrowReturnNotSelf) {
         this.boolBorrowReturnNotSelf = boolBorrowReturnNotSelf;
         return this;
      }

      public TransferDTO.TransferDTOBuilder boolHasUnfreeze(final Boolean boolHasUnfreeze) {
         this.boolHasUnfreeze = boolHasUnfreeze;
         return this;
      }

      public TransferDTO.TransferDTOBuilder transferCreateType(final Integer transferCreateType) {
         this.transferCreateType = transferCreateType;
         return this;
      }

      public TransferDTO.TransferDTOBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      public TransferDTO.TransferDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public TransferDTO.TransferDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public TransferDTO.TransferDTOBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      public TransferDTO.TransferDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public TransferDTO.TransferDTOBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public TransferDTO.TransferDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public TransferDTO.TransferDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TransferDTO.TransferDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public TransferDTO.TransferDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public TransferDTO.TransferDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public TransferDTO.TransferDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public TransferDTO.TransferDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public TransferDTO.TransferDTOBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public TransferDTO.TransferDTOBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      public TransferDTO build() {
         return new TransferDTO(
            this.id,
            this.basicClass,
            this.boolPartyA,
            this.serialNumber,
            this.source,
            this.direction,
            this.borrowProject,
            this.boolBorrowReturnNotSelf,
            this.boolHasUnfreeze,
            this.transferCreateType,
            this.transferType,
            this.reviewStatus,
            this.applicantName,
            this.editorName,
            this.reviewerName,
            this.approvalComments,
            this.reviewTime,
            this.createTime,
            this.updateTime,
            this.userUpdateTime,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.boolPrinted,
            this.outboundSn
         );
      }

      @Override
      public String toString() {
         return "TransferDTO.TransferDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", boolPartyA="
            + this.boolPartyA
            + ", serialNumber="
            + this.serialNumber
            + ", source="
            + this.source
            + ", direction="
            + this.direction
            + ", borrowProject="
            + this.borrowProject
            + ", boolBorrowReturnNotSelf="
            + this.boolBorrowReturnNotSelf
            + ", boolHasUnfreeze="
            + this.boolHasUnfreeze
            + ", transferCreateType="
            + this.transferCreateType
            + ", transferType="
            + this.transferType
            + ", reviewStatus="
            + this.reviewStatus
            + ", applicantName="
            + this.applicantName
            + ", editorName="
            + this.editorName
            + ", reviewerName="
            + this.reviewerName
            + ", approvalComments="
            + this.approvalComments
            + ", reviewTime="
            + this.reviewTime
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", inputVAT="
            + this.inputVAT
            + ", boolPrinted="
            + this.boolPrinted
            + ", outboundSn="
            + this.outboundSn
            + ")";
      }
   }
}
