package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.time.LocalDateTime;
import java.util.List;

public class RejectInboundDTO {
   private Long id;
   private Integer basicClass;
   private String serialNumber;
   private BriefIdAndSNDTO purchaseOrder;
   private String shipmentNumber;
   private String licensePlate;
   private List<ProjectInfoDTO> projects;
   private BriefIdAndNameDTO supplier;
   private String applicantName;
   private String editorName;
   private String reviewerName;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private LocalDateTime reviewTime;
   private LocalDateTime userUpdateTime;

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

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public List<ProjectInfoDTO> getProjects() {
      return this.projects;
   }

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
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

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
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

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setProjects(final List<ProjectInfoDTO> projects) {
      this.projects = projects;
   }

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
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

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RejectInboundDTO)) {
         return false;
      }

      RejectInboundDTO other = (RejectInboundDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$purchaseOrder = this.getPurchaseOrder();
               Object other$purchaseOrder = other.getPurchaseOrder();
               if (this$purchaseOrder == null ? other$purchaseOrder == null : this$purchaseOrder.equals(other$purchaseOrder)) {
                  Object this$shipmentNumber = this.getShipmentNumber();
                  Object other$shipmentNumber = other.getShipmentNumber();
                  if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                     Object this$licensePlate = this.getLicensePlate();
                     Object other$licensePlate = other.getLicensePlate();
                     if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
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
                                       Object this$createTime = this.getCreateTime();
                                       Object other$createTime = other.getCreateTime();
                                       if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                          Object this$updateTime = this.getUpdateTime();
                                          Object other$updateTime = other.getUpdateTime();
                                          if (this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime)) {
                                             Object this$reviewTime = this.getReviewTime();
                                             Object other$reviewTime = other.getReviewTime();
                                             if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                                Object this$userUpdateTime = this.getUserUpdateTime();
                                                Object other$userUpdateTime = other.getUserUpdateTime();
                                                return this$userUpdateTime == null
                                                   ? other$userUpdateTime == null
                                                   : this$userUpdateTime.equals(other$userUpdateTime);
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
      return other instanceof RejectInboundDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
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
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      return result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
   }

   @Override
   public String toString() {
      return "RejectInboundDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaseOrder="
         + this.getPurchaseOrder()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", projects="
         + this.getProjects()
         + ", supplier="
         + this.getSupplier()
         + ", applicantName="
         + this.getApplicantName()
         + ", editorName="
         + this.getEditorName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ")";
   }

   public RejectInboundDTO(
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final BriefIdAndSNDTO purchaseOrder,
      final String shipmentNumber,
      final String licensePlate,
      final List<ProjectInfoDTO> projects,
      final BriefIdAndNameDTO supplier,
      final String applicantName,
      final String editorName,
      final String reviewerName,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final LocalDateTime reviewTime,
      final LocalDateTime userUpdateTime
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.purchaseOrder = purchaseOrder;
      this.shipmentNumber = shipmentNumber;
      this.licensePlate = licensePlate;
      this.projects = projects;
      this.supplier = supplier;
      this.applicantName = applicantName;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.reviewTime = reviewTime;
      this.userUpdateTime = userUpdateTime;
   }

   public RejectInboundDTO() {
   }
}
