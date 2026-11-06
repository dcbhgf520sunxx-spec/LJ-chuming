package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.time.LocalDateTime;
import java.util.List;

public class RejectDTO {
   private Long id;
   private Integer basicClass;
   private String serialNumber;
   private BriefIdAndSNDTO purchaseOrder;
   private BriefIdAndSNDTO inboundReceipt;
   private String shipmentNumber;
   private List<ProjectInfoDTO> projects;
   private BriefIdAndNameDTO supplier;
   private Boolean boolHasUnfreeze;
   private Integer reviewStatus;
   private String applicantName;
   private String editorName;
   private String reviewerName;
   private String approvalComments;
   private String remark;
   private LocalDateTime createTime;
   private LocalDateTime reviewTime;

   public static RejectDTO.RejectDTOBuilder builder() {
      return new RejectDTO.RejectDTOBuilder();
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

   public BriefIdAndSNDTO getPurchaseOrder() {
      return this.purchaseOrder;
   }

   public BriefIdAndSNDTO getInboundReceipt() {
      return this.inboundReceipt;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public List<ProjectInfoDTO> getProjects() {
      return this.projects;
   }

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
   }

   public Boolean getBoolHasUnfreeze() {
      return this.boolHasUnfreeze;
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

   public String getRemark() {
      return this.remark;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
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

   public void setPurchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
      this.purchaseOrder = purchaseOrder;
   }

   public void setInboundReceipt(final BriefIdAndSNDTO inboundReceipt) {
      this.inboundReceipt = inboundReceipt;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setProjects(final List<ProjectInfoDTO> projects) {
      this.projects = projects;
   }

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
   }

   public void setBoolHasUnfreeze(final Boolean boolHasUnfreeze) {
      this.boolHasUnfreeze = boolHasUnfreeze;
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

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RejectDTO)) {
         return false;
      }

      RejectDTO other = (RejectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$boolHasUnfreeze = this.getBoolHasUnfreeze();
            Object other$boolHasUnfreeze = other.getBoolHasUnfreeze();
            if (this$boolHasUnfreeze == null ? other$boolHasUnfreeze == null : this$boolHasUnfreeze.equals(other$boolHasUnfreeze)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$purchaseOrder = this.getPurchaseOrder();
                     Object other$purchaseOrder = other.getPurchaseOrder();
                     if (this$purchaseOrder == null ? other$purchaseOrder == null : this$purchaseOrder.equals(other$purchaseOrder)) {
                        Object this$inboundReceipt = this.getInboundReceipt();
                        Object other$inboundReceipt = other.getInboundReceipt();
                        if (this$inboundReceipt == null ? other$inboundReceipt == null : this$inboundReceipt.equals(other$inboundReceipt)) {
                           Object this$shipmentNumber = this.getShipmentNumber();
                           Object other$shipmentNumber = other.getShipmentNumber();
                           if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                              Object this$projects = this.getProjects();
                              Object other$projects = other.getProjects();
                              if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                 Object this$supplier = this.getSupplier();
                                 Object other$supplier = other.getSupplier();
                                 if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
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
                                                Object this$remark = this.getRemark();
                                                Object other$remark = other.getRemark();
                                                if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                   Object this$createTime = this.getCreateTime();
                                                   Object other$createTime = other.getCreateTime();
                                                   if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                      Object this$reviewTime = this.getReviewTime();
                                                      Object other$reviewTime = other.getReviewTime();
                                                      return this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime);
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
      return other instanceof RejectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolHasUnfreeze = this.getBoolHasUnfreeze();
      result = result * 59 + ($boolHasUnfreeze == null ? 43 : $boolHasUnfreeze.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $inboundReceipt = this.getInboundReceipt();
      result = result * 59 + ($inboundReceipt == null ? 43 : $inboundReceipt.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   @Override
   public String toString() {
      return "RejectDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaseOrder="
         + this.getPurchaseOrder()
         + ", inboundReceipt="
         + this.getInboundReceipt()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", projects="
         + this.getProjects()
         + ", supplier="
         + this.getSupplier()
         + ", boolHasUnfreeze="
         + this.getBoolHasUnfreeze()
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
         + ", remark="
         + this.getRemark()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ")";
   }

   public RejectDTO(
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final BriefIdAndSNDTO purchaseOrder,
      final BriefIdAndSNDTO inboundReceipt,
      final String shipmentNumber,
      final List<ProjectInfoDTO> projects,
      final BriefIdAndNameDTO supplier,
      final Boolean boolHasUnfreeze,
      final Integer reviewStatus,
      final String applicantName,
      final String editorName,
      final String reviewerName,
      final String approvalComments,
      final String remark,
      final LocalDateTime createTime,
      final LocalDateTime reviewTime
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.purchaseOrder = purchaseOrder;
      this.inboundReceipt = inboundReceipt;
      this.shipmentNumber = shipmentNumber;
      this.projects = projects;
      this.supplier = supplier;
      this.boolHasUnfreeze = boolHasUnfreeze;
      this.reviewStatus = reviewStatus;
      this.applicantName = applicantName;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.approvalComments = approvalComments;
      this.remark = remark;
      this.createTime = createTime;
      this.reviewTime = reviewTime;
   }

   public RejectDTO() {
   }

   public static class RejectDTOBuilder {
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private BriefIdAndSNDTO purchaseOrder;
      private BriefIdAndSNDTO inboundReceipt;
      private String shipmentNumber;
      private List<ProjectInfoDTO> projects;
      private BriefIdAndNameDTO supplier;
      private Boolean boolHasUnfreeze;
      private Integer reviewStatus;
      private String applicantName;
      private String editorName;
      private String reviewerName;
      private String approvalComments;
      private String remark;
      private LocalDateTime createTime;
      private LocalDateTime reviewTime;

      RejectDTOBuilder() {
      }

      public RejectDTO.RejectDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public RejectDTO.RejectDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public RejectDTO.RejectDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public RejectDTO.RejectDTOBuilder purchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
         this.purchaseOrder = purchaseOrder;
         return this;
      }

      public RejectDTO.RejectDTOBuilder inboundReceipt(final BriefIdAndSNDTO inboundReceipt) {
         this.inboundReceipt = inboundReceipt;
         return this;
      }

      public RejectDTO.RejectDTOBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public RejectDTO.RejectDTOBuilder projects(final List<ProjectInfoDTO> projects) {
         this.projects = projects;
         return this;
      }

      public RejectDTO.RejectDTOBuilder supplier(final BriefIdAndNameDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public RejectDTO.RejectDTOBuilder boolHasUnfreeze(final Boolean boolHasUnfreeze) {
         this.boolHasUnfreeze = boolHasUnfreeze;
         return this;
      }

      public RejectDTO.RejectDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public RejectDTO.RejectDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public RejectDTO.RejectDTOBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      public RejectDTO.RejectDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public RejectDTO.RejectDTOBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public RejectDTO.RejectDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public RejectDTO.RejectDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public RejectDTO.RejectDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public RejectDTO build() {
         return new RejectDTO(
            this.id,
            this.basicClass,
            this.serialNumber,
            this.purchaseOrder,
            this.inboundReceipt,
            this.shipmentNumber,
            this.projects,
            this.supplier,
            this.boolHasUnfreeze,
            this.reviewStatus,
            this.applicantName,
            this.editorName,
            this.reviewerName,
            this.approvalComments,
            this.remark,
            this.createTime,
            this.reviewTime
         );
      }

      @Override
      public String toString() {
         return "RejectDTO.RejectDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", purchaseOrder="
            + this.purchaseOrder
            + ", inboundReceipt="
            + this.inboundReceipt
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", projects="
            + this.projects
            + ", supplier="
            + this.supplier
            + ", boolHasUnfreeze="
            + this.boolHasUnfreeze
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
            + ", remark="
            + this.remark
            + ", createTime="
            + this.createTime
            + ", reviewTime="
            + this.reviewTime
            + ")";
      }
   }
}
