package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import java.time.LocalDateTime;
import java.util.List;

public class AdjustDTO {
   private Long id;
   private Integer basicClass;
   private Boolean boolPartyA;
   private String purchaseSN;
   private String licensePlate;
   private String shipmentNumber;
   private List<ProjectInfo> projects;
   private Supplier supplier;
   private Integer reviewStatus;
   private String approvalComments;
   private String applicantName;
   private String editorName;
   private String reviewerName;
   private Boolean editable;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private LocalDateTime userUpdateTime;
   private LocalDateTime reviewTime;
   private String serialNumber;
   private Long inboundId;
   private String adjustSerialNumber;
   private Integer inboundWay;

   public static AdjustDTO.AdjustDTOBuilder builder() {
      return new AdjustDTO.AdjustDTOBuilder();
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

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getAdjustSerialNumber() {
      return this.adjustSerialNumber;
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

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setAdjustSerialNumber(final String adjustSerialNumber) {
      this.adjustSerialNumber = adjustSerialNumber;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AdjustDTO)) {
         return false;
      }

      AdjustDTO other = (AdjustDTO)o;
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
                  Object this$editable = this.getEditable();
                  Object other$editable = other.getEditable();
                  if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                     Object this$inboundId = this.getInboundId();
                     Object other$inboundId = other.getInboundId();
                     if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
                        Object this$inboundWay = this.getInboundWay();
                        Object other$inboundWay = other.getInboundWay();
                        if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
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
                                             if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                                Object this$editorName = this.getEditorName();
                                                Object other$editorName = other.getEditorName();
                                                if (this$editorName == null ? other$editorName == null : this$editorName.equals(other$editorName)) {
                                                   Object this$reviewerName = this.getReviewerName();
                                                   Object other$reviewerName = other.getReviewerName();
                                                   if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                                      Object this$createTime = this.getCreateTime();
                                                      Object other$createTime = other.getCreateTime();
                                                      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                         Object this$updateTime = this.getUpdateTime();
                                                         Object other$updateTime = other.getUpdateTime();
                                                         if (this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime)) {
                                                            Object this$userUpdateTime = this.getUserUpdateTime();
                                                            Object other$userUpdateTime = other.getUserUpdateTime();
                                                            if (this$userUpdateTime == null
                                                               ? other$userUpdateTime == null
                                                               : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                               Object this$reviewTime = this.getReviewTime();
                                                               Object other$reviewTime = other.getReviewTime();
                                                               if (this$reviewTime == null
                                                                  ? other$reviewTime == null
                                                                  : this$reviewTime.equals(other$reviewTime)) {
                                                                  Object this$serialNumber = this.getSerialNumber();
                                                                  Object other$serialNumber = other.getSerialNumber();
                                                                  if (this$serialNumber == null
                                                                     ? other$serialNumber == null
                                                                     : this$serialNumber.equals(other$serialNumber)) {
                                                                     Object this$adjustSerialNumber = this.getAdjustSerialNumber();
                                                                     Object other$adjustSerialNumber = other.getAdjustSerialNumber();
                                                                     return this$adjustSerialNumber == null
                                                                        ? other$adjustSerialNumber == null
                                                                        : this$adjustSerialNumber.equals(other$adjustSerialNumber);
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
      return other instanceof AdjustDTO;
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
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
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
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $adjustSerialNumber = this.getAdjustSerialNumber();
      return result * 59 + ($adjustSerialNumber == null ? 43 : $adjustSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "AdjustDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", boolPartyA="
         + this.getBoolPartyA()
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
         + ", reviewTime="
         + this.getReviewTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", inboundId="
         + this.getInboundId()
         + ", adjustSerialNumber="
         + this.getAdjustSerialNumber()
         + ", inboundWay="
         + this.getInboundWay()
         + ")";
   }

   public AdjustDTO(
      final Long id,
      final Integer basicClass,
      final Boolean boolPartyA,
      final String purchaseSN,
      final String licensePlate,
      final String shipmentNumber,
      final List<ProjectInfo> projects,
      final Supplier supplier,
      final Integer reviewStatus,
      final String approvalComments,
      final String applicantName,
      final String editorName,
      final String reviewerName,
      final Boolean editable,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final LocalDateTime userUpdateTime,
      final LocalDateTime reviewTime,
      final String serialNumber,
      final Long inboundId,
      final String adjustSerialNumber,
      final Integer inboundWay
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.boolPartyA = boolPartyA;
      this.purchaseSN = purchaseSN;
      this.licensePlate = licensePlate;
      this.shipmentNumber = shipmentNumber;
      this.projects = projects;
      this.supplier = supplier;
      this.reviewStatus = reviewStatus;
      this.approvalComments = approvalComments;
      this.applicantName = applicantName;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.editable = editable;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.userUpdateTime = userUpdateTime;
      this.reviewTime = reviewTime;
      this.serialNumber = serialNumber;
      this.inboundId = inboundId;
      this.adjustSerialNumber = adjustSerialNumber;
      this.inboundWay = inboundWay;
   }

   public AdjustDTO() {
   }

   public static class AdjustDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Boolean boolPartyA;
      private String purchaseSN;
      private String licensePlate;
      private String shipmentNumber;
      private List<ProjectInfo> projects;
      private Supplier supplier;
      private Integer reviewStatus;
      private String approvalComments;
      private String applicantName;
      private String editorName;
      private String reviewerName;
      private Boolean editable;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private LocalDateTime userUpdateTime;
      private LocalDateTime reviewTime;
      private String serialNumber;
      private Long inboundId;
      private String adjustSerialNumber;
      private Integer inboundWay;

      AdjustDTOBuilder() {
      }

      public AdjustDTO.AdjustDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder purchaseSN(final String purchaseSN) {
         this.purchaseSN = purchaseSN;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder supplier(final Supplier supplier) {
         this.supplier = supplier;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder adjustSerialNumber(final String adjustSerialNumber) {
         this.adjustSerialNumber = adjustSerialNumber;
         return this;
      }

      public AdjustDTO.AdjustDTOBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      public AdjustDTO build() {
         return new AdjustDTO(
            this.id,
            this.basicClass,
            this.boolPartyA,
            this.purchaseSN,
            this.licensePlate,
            this.shipmentNumber,
            this.projects,
            this.supplier,
            this.reviewStatus,
            this.approvalComments,
            this.applicantName,
            this.editorName,
            this.reviewerName,
            this.editable,
            this.createTime,
            this.updateTime,
            this.userUpdateTime,
            this.reviewTime,
            this.serialNumber,
            this.inboundId,
            this.adjustSerialNumber,
            this.inboundWay
         );
      }

      @Override
      public String toString() {
         return "AdjustDTO.AdjustDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", boolPartyA="
            + this.boolPartyA
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
            + ", reviewTime="
            + this.reviewTime
            + ", serialNumber="
            + this.serialNumber
            + ", inboundId="
            + this.inboundId
            + ", adjustSerialNumber="
            + this.adjustSerialNumber
            + ", inboundWay="
            + this.inboundWay
            + ")";
      }
   }
}
