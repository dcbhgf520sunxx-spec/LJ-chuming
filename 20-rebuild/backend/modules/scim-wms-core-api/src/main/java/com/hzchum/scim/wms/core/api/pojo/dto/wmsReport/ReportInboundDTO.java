package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.mes.building.core.api.pojo._dto.util.IdAndNameDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReportInboundDTO {
   private Long id;
   private Integer basicClass;
   private boolean boolPartyA;
   private Integer rejectStatus;
   private String serialNumber;
   private BriefIdAndSNDTO purchaseOrder;
   private String shipmentNumber;
   private String licensePlate;
   private BigDecimal rejectAmountExcludingVAT;
   private BigDecimal rejectAmountExcludingVATNoFreight;
   private BigDecimal inboundAmountExcludingVAT;
   private BigDecimal inboundAmountExcludingVATNoFreight;
   private List<ProjectInfoDTO> projects;
   private BriefIdAndNameDTO supplier;
   private Integer reviewStatus;
   private Boolean editable;
   private String applicantName;
   private String editorName;
   private String reviewerName;
   private LocalDateTime inboundTime;
   private LocalDateTime reviewTime;
   private LocalDateTime createTime;
   private LocalDateTime userUpdateTime;
   private Boolean printStatus;
   private IdAndNameDTO mesWorkshop;
   private Integer inboundWay;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public boolean isBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getRejectStatus() {
      return this.rejectStatus;
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

   public BigDecimal getRejectAmountExcludingVAT() {
      return this.rejectAmountExcludingVAT;
   }

   public BigDecimal getRejectAmountExcludingVATNoFreight() {
      return this.rejectAmountExcludingVATNoFreight;
   }

   public BigDecimal getInboundAmountExcludingVAT() {
      return this.inboundAmountExcludingVAT;
   }

   public BigDecimal getInboundAmountExcludingVATNoFreight() {
      return this.inboundAmountExcludingVATNoFreight;
   }

   public List<ProjectInfoDTO> getProjects() {
      return this.projects;
   }

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
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

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public Boolean getPrintStatus() {
      return this.printStatus;
   }

   public IdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
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

   public void setBoolPartyA(final boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setRejectStatus(final Integer rejectStatus) {
      this.rejectStatus = rejectStatus;
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

   public void setRejectAmountExcludingVAT(final BigDecimal rejectAmountExcludingVAT) {
      this.rejectAmountExcludingVAT = rejectAmountExcludingVAT;
   }

   public void setRejectAmountExcludingVATNoFreight(final BigDecimal rejectAmountExcludingVATNoFreight) {
      this.rejectAmountExcludingVATNoFreight = rejectAmountExcludingVATNoFreight;
   }

   public void setInboundAmountExcludingVAT(final BigDecimal inboundAmountExcludingVAT) {
      this.inboundAmountExcludingVAT = inboundAmountExcludingVAT;
   }

   public void setInboundAmountExcludingVATNoFreight(final BigDecimal inboundAmountExcludingVATNoFreight) {
      this.inboundAmountExcludingVATNoFreight = inboundAmountExcludingVATNoFreight;
   }

   public void setProjects(final List<ProjectInfoDTO> projects) {
      this.projects = projects;
   }

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
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

   public void setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setPrintStatus(final Boolean printStatus) {
      this.printStatus = printStatus;
   }

   public void setMesWorkshop(final IdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReportInboundDTO)) {
         return false;
      }

      ReportInboundDTO other = (ReportInboundDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolPartyA() != other.isBoolPartyA()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$rejectStatus = this.getRejectStatus();
            Object other$rejectStatus = other.getRejectStatus();
            if (this$rejectStatus == null ? other$rejectStatus == null : this$rejectStatus.equals(other$rejectStatus)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$editable = this.getEditable();
                  Object other$editable = other.getEditable();
                  if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                     Object this$printStatus = this.getPrintStatus();
                     Object other$printStatus = other.getPrintStatus();
                     if (this$printStatus == null ? other$printStatus == null : this$printStatus.equals(other$printStatus)) {
                        Object this$inboundWay = this.getInboundWay();
                        Object other$inboundWay = other.getInboundWay();
                        if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
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
                                       Object this$rejectAmountExcludingVAT = this.getRejectAmountExcludingVAT();
                                       Object other$rejectAmountExcludingVAT = other.getRejectAmountExcludingVAT();
                                       if (this$rejectAmountExcludingVAT == null
                                          ? other$rejectAmountExcludingVAT == null
                                          : this$rejectAmountExcludingVAT.equals(other$rejectAmountExcludingVAT)) {
                                          Object this$rejectAmountExcludingVATNoFreight = this.getRejectAmountExcludingVATNoFreight();
                                          Object other$rejectAmountExcludingVATNoFreight = other.getRejectAmountExcludingVATNoFreight();
                                          if (this$rejectAmountExcludingVATNoFreight == null
                                             ? other$rejectAmountExcludingVATNoFreight == null
                                             : this$rejectAmountExcludingVATNoFreight.equals(other$rejectAmountExcludingVATNoFreight)) {
                                             Object this$inboundAmountExcludingVAT = this.getInboundAmountExcludingVAT();
                                             Object other$inboundAmountExcludingVAT = other.getInboundAmountExcludingVAT();
                                             if (this$inboundAmountExcludingVAT == null
                                                ? other$inboundAmountExcludingVAT == null
                                                : this$inboundAmountExcludingVAT.equals(other$inboundAmountExcludingVAT)) {
                                                Object this$inboundAmountExcludingVATNoFreight = this.getInboundAmountExcludingVATNoFreight();
                                                Object other$inboundAmountExcludingVATNoFreight = other.getInboundAmountExcludingVATNoFreight();
                                                if (this$inboundAmountExcludingVATNoFreight == null
                                                   ? other$inboundAmountExcludingVATNoFreight == null
                                                   : this$inboundAmountExcludingVATNoFreight.equals(other$inboundAmountExcludingVATNoFreight)) {
                                                   Object this$projects = this.getProjects();
                                                   Object other$projects = other.getProjects();
                                                   if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                                      Object this$supplier = this.getSupplier();
                                                      Object other$supplier = other.getSupplier();
                                                      if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
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
                                                                  Object this$inboundTime = this.getInboundTime();
                                                                  Object other$inboundTime = other.getInboundTime();
                                                                  if (this$inboundTime == null
                                                                     ? other$inboundTime == null
                                                                     : this$inboundTime.equals(other$inboundTime)) {
                                                                     Object this$reviewTime = this.getReviewTime();
                                                                     Object other$reviewTime = other.getReviewTime();
                                                                     if (this$reviewTime == null
                                                                        ? other$reviewTime == null
                                                                        : this$reviewTime.equals(other$reviewTime)) {
                                                                        Object this$createTime = this.getCreateTime();
                                                                        Object other$createTime = other.getCreateTime();
                                                                        if (this$createTime == null
                                                                           ? other$createTime == null
                                                                           : this$createTime.equals(other$createTime)) {
                                                                           Object this$userUpdateTime = this.getUserUpdateTime();
                                                                           Object other$userUpdateTime = other.getUserUpdateTime();
                                                                           if (this$userUpdateTime == null
                                                                              ? other$userUpdateTime == null
                                                                              : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                              Object this$mesWorkshop = this.getMesWorkshop();
                                                                              Object other$mesWorkshop = other.getMesWorkshop();
                                                                              return this$mesWorkshop == null
                                                                                 ? other$mesWorkshop == null
                                                                                 : this$mesWorkshop.equals(other$mesWorkshop);
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
      return other instanceof ReportInboundDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolPartyA() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $rejectStatus = this.getRejectStatus();
      result = result * 59 + ($rejectStatus == null ? 43 : $rejectStatus.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $printStatus = this.getPrintStatus();
      result = result * 59 + ($printStatus == null ? 43 : $printStatus.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $rejectAmountExcludingVAT = this.getRejectAmountExcludingVAT();
      result = result * 59 + ($rejectAmountExcludingVAT == null ? 43 : $rejectAmountExcludingVAT.hashCode());
      Object $rejectAmountExcludingVATNoFreight = this.getRejectAmountExcludingVATNoFreight();
      result = result * 59 + ($rejectAmountExcludingVATNoFreight == null ? 43 : $rejectAmountExcludingVATNoFreight.hashCode());
      Object $inboundAmountExcludingVAT = this.getInboundAmountExcludingVAT();
      result = result * 59 + ($inboundAmountExcludingVAT == null ? 43 : $inboundAmountExcludingVAT.hashCode());
      Object $inboundAmountExcludingVATNoFreight = this.getInboundAmountExcludingVATNoFreight();
      result = result * 59 + ($inboundAmountExcludingVATNoFreight == null ? 43 : $inboundAmountExcludingVATNoFreight.hashCode());
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
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      return result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
   }

   @Override
   public String toString() {
      return "ReportInboundDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", boolPartyA="
         + this.isBoolPartyA()
         + ", rejectStatus="
         + this.getRejectStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaseOrder="
         + this.getPurchaseOrder()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", rejectAmountExcludingVAT="
         + this.getRejectAmountExcludingVAT()
         + ", rejectAmountExcludingVATNoFreight="
         + this.getRejectAmountExcludingVATNoFreight()
         + ", inboundAmountExcludingVAT="
         + this.getInboundAmountExcludingVAT()
         + ", inboundAmountExcludingVATNoFreight="
         + this.getInboundAmountExcludingVATNoFreight()
         + ", projects="
         + this.getProjects()
         + ", supplier="
         + this.getSupplier()
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
         + ", inboundTime="
         + this.getInboundTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", createTime="
         + this.getCreateTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", printStatus="
         + this.getPrintStatus()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", inboundWay="
         + this.getInboundWay()
         + ")";
   }

   public ReportInboundDTO(
      final Long id,
      final Integer basicClass,
      final boolean boolPartyA,
      final Integer rejectStatus,
      final String serialNumber,
      final BriefIdAndSNDTO purchaseOrder,
      final String shipmentNumber,
      final String licensePlate,
      final BigDecimal rejectAmountExcludingVAT,
      final BigDecimal rejectAmountExcludingVATNoFreight,
      final BigDecimal inboundAmountExcludingVAT,
      final BigDecimal inboundAmountExcludingVATNoFreight,
      final List<ProjectInfoDTO> projects,
      final BriefIdAndNameDTO supplier,
      final Integer reviewStatus,
      final Boolean editable,
      final String applicantName,
      final String editorName,
      final String reviewerName,
      final LocalDateTime inboundTime,
      final LocalDateTime reviewTime,
      final LocalDateTime createTime,
      final LocalDateTime userUpdateTime,
      final Boolean printStatus,
      final IdAndNameDTO mesWorkshop,
      final Integer inboundWay
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.boolPartyA = boolPartyA;
      this.rejectStatus = rejectStatus;
      this.serialNumber = serialNumber;
      this.purchaseOrder = purchaseOrder;
      this.shipmentNumber = shipmentNumber;
      this.licensePlate = licensePlate;
      this.rejectAmountExcludingVAT = rejectAmountExcludingVAT;
      this.rejectAmountExcludingVATNoFreight = rejectAmountExcludingVATNoFreight;
      this.inboundAmountExcludingVAT = inboundAmountExcludingVAT;
      this.inboundAmountExcludingVATNoFreight = inboundAmountExcludingVATNoFreight;
      this.projects = projects;
      this.supplier = supplier;
      this.reviewStatus = reviewStatus;
      this.editable = editable;
      this.applicantName = applicantName;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.inboundTime = inboundTime;
      this.reviewTime = reviewTime;
      this.createTime = createTime;
      this.userUpdateTime = userUpdateTime;
      this.printStatus = printStatus;
      this.mesWorkshop = mesWorkshop;
      this.inboundWay = inboundWay;
   }

   public ReportInboundDTO() {
   }
}
