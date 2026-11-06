package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import java.time.LocalDateTime;
import java.util.List;

public class BriefInboundDTO {
   private Long id;
   private Integer basicClass;
   private Boolean boolPartyA;
   private String serialNumber;
   private String purchaseSN;
   private String licensePlate;
   private String shipmentNumber;
   private List<ProjectInfo> projects;
   private Supplier supplier;
   private Integer reviewStatus;
   private String approvalComments;
   private String applicantName;
   private Long applicantId;
   private String editorName;
   private String reviewerName;
   private Boolean editable;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private LocalDateTime userUpdateTime;
   @JsonInclude(Include.NON_NULL)
   private List<AttachmentDTO> attachments;
   @JsonInclude(Include.NON_NULL)
   private String qualityTestingUserName;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime qualityTestingTime;
   @JsonInclude(Include.NON_NULL)
   private Integer qualityTestingEnum;
   @JsonInclude(Include.NON_NULL)
   private String qualityTestingRemark;
   private LocalDateTime reviewTime;
   private Boolean editMoney;
   private Integer inboundWay;

   public static BriefInboundDTO.BriefInboundDTOBuilder builder() {
      return new BriefInboundDTO.BriefInboundDTOBuilder();
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

   public String getPurchaseSN() {
      return this.purchaseSN;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public Supplier getSupplier() {
      return this.supplier;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Boolean getEditable() {
      return this.editable;
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

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getQualityTestingUserName() {
      return this.qualityTestingUserName;
   }

   public LocalDateTime getQualityTestingTime() {
      return this.qualityTestingTime;
   }

   public Integer getQualityTestingEnum() {
      return this.qualityTestingEnum;
   }

   public String getQualityTestingRemark() {
      return this.qualityTestingRemark;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Boolean getEditMoney() {
      return this.editMoney;
   }

   public Integer getInboundWay() {
      return this.inboundWay;
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

   public void setPurchaseSN(final String purchaseSN) {
      this.purchaseSN = purchaseSN;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setSupplier(final Supplier supplier) {
      this.supplier = supplier;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setEditorName(final String editorName) {
      this.editorName = editorName;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setEditable(final Boolean editable) {
      this.editable = editable;
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

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setQualityTestingUserName(final String qualityTestingUserName) {
      this.qualityTestingUserName = qualityTestingUserName;
   }

   public void setQualityTestingTime(final LocalDateTime qualityTestingTime) {
      this.qualityTestingTime = qualityTestingTime;
   }

   public void setQualityTestingEnum(final Integer qualityTestingEnum) {
      this.qualityTestingEnum = qualityTestingEnum;
   }

   public void setQualityTestingRemark(final String qualityTestingRemark) {
      this.qualityTestingRemark = qualityTestingRemark;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setEditMoney(final Boolean editMoney) {
      this.editMoney = editMoney;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BriefInboundDTO)) {
         return false;
      }

      BriefInboundDTO other = (BriefInboundDTO)o;
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
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$applicantId = this.getApplicantId();
                  Object other$applicantId = other.getApplicantId();
                  if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                     Object this$editable = this.getEditable();
                     Object other$editable = other.getEditable();
                     if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                        Object this$qualityTestingEnum = this.getQualityTestingEnum();
                        Object other$qualityTestingEnum = other.getQualityTestingEnum();
                        if (this$qualityTestingEnum == null ? other$qualityTestingEnum == null : this$qualityTestingEnum.equals(other$qualityTestingEnum)) {
                           Object this$editMoney = this.getEditMoney();
                           Object other$editMoney = other.getEditMoney();
                           if (this$editMoney == null ? other$editMoney == null : this$editMoney.equals(other$editMoney)) {
                              Object this$inboundWay = this.getInboundWay();
                              Object other$inboundWay = other.getInboundWay();
                              if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$purchaseSN = this.getPurchaseSN();
                                    Object other$purchaseSN = other.getPurchaseSN();
                                    if (this$purchaseSN == null ? other$purchaseSN == null : this$purchaseSN.equals(other$purchaseSN)) {
                                       Object this$licensePlate = this.getLicensePlate();
                                       Object other$licensePlate = other.getLicensePlate();
                                       if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                          Object this$shipmentNumber = this.getShipmentNumber();
                                          Object other$shipmentNumber = other.getShipmentNumber();
                                          if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                                             Object this$projects = this.getProjects();
                                             Object other$projects = other.getProjects();
                                             if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                                Object this$supplier = this.getSupplier();
                                                Object other$supplier = other.getSupplier();
                                                if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                                   Object this$approvalComments = this.getApprovalComments();
                                                   Object other$approvalComments = other.getApprovalComments();
                                                   if (this$approvalComments == null
                                                      ? other$approvalComments == null
                                                      : this$approvalComments.equals(other$approvalComments)) {
                                                      Object this$applicantName = this.getApplicantName();
                                                      Object other$applicantName = other.getApplicantName();
                                                      if (this$applicantName == null
                                                         ? other$applicantName == null
                                                         : this$applicantName.equals(other$applicantName)) {
                                                         Object this$editorName = this.getEditorName();
                                                         Object other$editorName = other.getEditorName();
                                                         if (this$editorName == null ? other$editorName == null : this$editorName.equals(other$editorName)) {
                                                            Object this$reviewerName = this.getReviewerName();
                                                            Object other$reviewerName = other.getReviewerName();
                                                            if (this$reviewerName == null
                                                               ? other$reviewerName == null
                                                               : this$reviewerName.equals(other$reviewerName)) {
                                                               Object this$createTime = this.getCreateTime();
                                                               Object other$createTime = other.getCreateTime();
                                                               if (this$createTime == null
                                                                  ? other$createTime == null
                                                                  : this$createTime.equals(other$createTime)) {
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
                                                                        Object this$attachments = this.getAttachments();
                                                                        Object other$attachments = other.getAttachments();
                                                                        if (this$attachments == null
                                                                           ? other$attachments == null
                                                                           : this$attachments.equals(other$attachments)) {
                                                                           Object this$qualityTestingUserName = this.getQualityTestingUserName();
                                                                           Object other$qualityTestingUserName = other.getQualityTestingUserName();
                                                                           if (this$qualityTestingUserName == null
                                                                              ? other$qualityTestingUserName == null
                                                                              : this$qualityTestingUserName.equals(other$qualityTestingUserName)) {
                                                                              Object this$qualityTestingTime = this.getQualityTestingTime();
                                                                              Object other$qualityTestingTime = other.getQualityTestingTime();
                                                                              if (this$qualityTestingTime == null
                                                                                 ? other$qualityTestingTime == null
                                                                                 : this$qualityTestingTime.equals(other$qualityTestingTime)) {
                                                                                 Object this$qualityTestingRemark = this.getQualityTestingRemark();
                                                                                 Object other$qualityTestingRemark = other.getQualityTestingRemark();
                                                                                 if (this$qualityTestingRemark == null
                                                                                    ? other$qualityTestingRemark == null
                                                                                    : this$qualityTestingRemark.equals(other$qualityTestingRemark)) {
                                                                                    Object this$reviewTime = this.getReviewTime();
                                                                                    Object other$reviewTime = other.getReviewTime();
                                                                                    return this$reviewTime == null
                                                                                       ? other$reviewTime == null
                                                                                       : this$reviewTime.equals(other$reviewTime);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BriefInboundDTO;
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
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $qualityTestingEnum = this.getQualityTestingEnum();
      result = result * 59 + ($qualityTestingEnum == null ? 43 : $qualityTestingEnum.hashCode());
      Object $editMoney = this.getEditMoney();
      result = result * 59 + ($editMoney == null ? 43 : $editMoney.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaseSN = this.getPurchaseSN();
      result = result * 59 + ($purchaseSN == null ? 43 : $purchaseSN.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $qualityTestingUserName = this.getQualityTestingUserName();
      result = result * 59 + ($qualityTestingUserName == null ? 43 : $qualityTestingUserName.hashCode());
      Object $qualityTestingTime = this.getQualityTestingTime();
      result = result * 59 + ($qualityTestingTime == null ? 43 : $qualityTestingTime.hashCode());
      Object $qualityTestingRemark = this.getQualityTestingRemark();
      result = result * 59 + ($qualityTestingRemark == null ? 43 : $qualityTestingRemark.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   @Override
   public String toString() {
      return "BriefInboundDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", projects="
         + this.getProjects()
         + ", supplier="
         + this.getSupplier()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantId="
         + this.getApplicantId()
         + ", editorName="
         + this.getEditorName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", editable="
         + this.getEditable()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", attachments="
         + this.getAttachments()
         + ", qualityTestingUserName="
         + this.getQualityTestingUserName()
         + ", qualityTestingTime="
         + this.getQualityTestingTime()
         + ", qualityTestingEnum="
         + this.getQualityTestingEnum()
         + ", qualityTestingRemark="
         + this.getQualityTestingRemark()
         + ", reviewTime="
         + this.getReviewTime()
         + ", editMoney="
         + this.getEditMoney()
         + ", inboundWay="
         + this.getInboundWay()
         + ")";
   }

   public BriefInboundDTO(
      final Long id,
      final Integer basicClass,
      final Boolean boolPartyA,
      final String serialNumber,
      final String purchaseSN,
      final String licensePlate,
      final String shipmentNumber,
      final List<ProjectInfo> projects,
      final Supplier supplier,
      final Integer reviewStatus,
      final String approvalComments,
      final String applicantName,
      final Long applicantId,
      final String editorName,
      final String reviewerName,
      final Boolean editable,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final LocalDateTime userUpdateTime,
      final List<AttachmentDTO> attachments,
      final String qualityTestingUserName,
      final LocalDateTime qualityTestingTime,
      final Integer qualityTestingEnum,
      final String qualityTestingRemark,
      final LocalDateTime reviewTime,
      final Boolean editMoney,
      final Integer inboundWay
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.boolPartyA = boolPartyA;
      this.serialNumber = serialNumber;
      this.purchaseSN = purchaseSN;
      this.licensePlate = licensePlate;
      this.shipmentNumber = shipmentNumber;
      this.projects = projects;
      this.supplier = supplier;
      this.reviewStatus = reviewStatus;
      this.approvalComments = approvalComments;
      this.applicantName = applicantName;
      this.applicantId = applicantId;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.editable = editable;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.userUpdateTime = userUpdateTime;
      this.attachments = attachments;
      this.qualityTestingUserName = qualityTestingUserName;
      this.qualityTestingTime = qualityTestingTime;
      this.qualityTestingEnum = qualityTestingEnum;
      this.qualityTestingRemark = qualityTestingRemark;
      this.reviewTime = reviewTime;
      this.editMoney = editMoney;
      this.inboundWay = inboundWay;
   }

   public BriefInboundDTO() {
   }

   public static class BriefInboundDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Boolean boolPartyA;
      private String serialNumber;
      private String purchaseSN;
      private String licensePlate;
      private String shipmentNumber;
      private List<ProjectInfo> projects;
      private Supplier supplier;
      private Integer reviewStatus;
      private String approvalComments;
      private String applicantName;
      private Long applicantId;
      private String editorName;
      private String reviewerName;
      private Boolean editable;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private LocalDateTime userUpdateTime;
      private List<AttachmentDTO> attachments;
      private String qualityTestingUserName;
      private LocalDateTime qualityTestingTime;
      private Integer qualityTestingEnum;
      private String qualityTestingRemark;
      private LocalDateTime reviewTime;
      private Boolean editMoney;
      private Integer inboundWay;

      BriefInboundDTOBuilder() {
      }

      public BriefInboundDTO.BriefInboundDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder purchaseSN(final String purchaseSN) {
         this.purchaseSN = purchaseSN;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder supplier(final Supplier supplier) {
         this.supplier = supplier;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder qualityTestingUserName(final String qualityTestingUserName) {
         this.qualityTestingUserName = qualityTestingUserName;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder qualityTestingTime(final LocalDateTime qualityTestingTime) {
         this.qualityTestingTime = qualityTestingTime;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder qualityTestingEnum(final Integer qualityTestingEnum) {
         this.qualityTestingEnum = qualityTestingEnum;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder qualityTestingRemark(final String qualityTestingRemark) {
         this.qualityTestingRemark = qualityTestingRemark;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder editMoney(final Boolean editMoney) {
         this.editMoney = editMoney;
         return this;
      }

      public BriefInboundDTO.BriefInboundDTOBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      public BriefInboundDTO build() {
         return new BriefInboundDTO(
            this.id,
            this.basicClass,
            this.boolPartyA,
            this.serialNumber,
            this.purchaseSN,
            this.licensePlate,
            this.shipmentNumber,
            this.projects,
            this.supplier,
            this.reviewStatus,
            this.approvalComments,
            this.applicantName,
            this.applicantId,
            this.editorName,
            this.reviewerName,
            this.editable,
            this.createTime,
            this.updateTime,
            this.userUpdateTime,
            this.attachments,
            this.qualityTestingUserName,
            this.qualityTestingTime,
            this.qualityTestingEnum,
            this.qualityTestingRemark,
            this.reviewTime,
            this.editMoney,
            this.inboundWay
         );
      }

      @Override
      public String toString() {
         return "BriefInboundDTO.BriefInboundDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", boolPartyA="
            + this.boolPartyA
            + ", serialNumber="
            + this.serialNumber
            + ", purchaseSN="
            + this.purchaseSN
            + ", licensePlate="
            + this.licensePlate
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", projects="
            + this.projects
            + ", supplier="
            + this.supplier
            + ", reviewStatus="
            + this.reviewStatus
            + ", approvalComments="
            + this.approvalComments
            + ", applicantName="
            + this.applicantName
            + ", applicantId="
            + this.applicantId
            + ", editorName="
            + this.editorName
            + ", reviewerName="
            + this.reviewerName
            + ", editable="
            + this.editable
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", attachments="
            + this.attachments
            + ", qualityTestingUserName="
            + this.qualityTestingUserName
            + ", qualityTestingTime="
            + this.qualityTestingTime
            + ", qualityTestingEnum="
            + this.qualityTestingEnum
            + ", qualityTestingRemark="
            + this.qualityTestingRemark
            + ", reviewTime="
            + this.reviewTime
            + ", editMoney="
            + this.editMoney
            + ", inboundWay="
            + this.inboundWay
            + ")";
      }
   }
}
