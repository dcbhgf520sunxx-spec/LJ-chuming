package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class RejectDO {
   private Long id;
   private Integer basicClass;
   private String serialNumber;
   private BriefIdAndSNDTO purchaseOrder;
   private BriefIdAndSNDTO inboundReceipt;
   private List<ProjectInfo> projects;
   private String projectIds;
   private BriefIdAndNameDTO supplier;
   private BigDecimal inboundAmountExcludingVAT;
   private BigDecimal rejectAmountExcludingVAT;
   private BigDecimal inboundAmount;
   private BigDecimal rejectAmount;
   private String applicantName;
   private String editorName;
   private String reviewerName;
   private String remark;
   private String approvalComments;
   private LocalDateTime rejectTime;
   private LocalDateTime createTime;
   private LocalDateTime reviewTime;
   private BigDecimal amountCount;
   private BigDecimal amountExcludingVatCount;
   private BigDecimal inboundAmountExcludingVATNoFreight;
   private BigDecimal rejectAmountExcludingVATNoFreight;
   private BigDecimal inboundAmountNoFreight;
   private BigDecimal rejectAmountNoFreight;
   private BigDecimal amountCountNoFreight;
   private BigDecimal amountExcludingVatCountNoFreight;
   private Boolean boolPrinted;

   public static RejectDO.RejectDOBuilder builder() {
      return new RejectDO.RejectDOBuilder();
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

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
   }

   public BigDecimal getInboundAmountExcludingVAT() {
      return this.inboundAmountExcludingVAT;
   }

   public BigDecimal getRejectAmountExcludingVAT() {
      return this.rejectAmountExcludingVAT;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getRejectAmount() {
      return this.rejectAmount;
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

   public String getRemark() {
      return this.remark;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public LocalDateTime getRejectTime() {
      return this.rejectTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public BigDecimal getAmountCount() {
      return this.amountCount;
   }

   public BigDecimal getAmountExcludingVatCount() {
      return this.amountExcludingVatCount;
   }

   public BigDecimal getInboundAmountExcludingVATNoFreight() {
      return this.inboundAmountExcludingVATNoFreight;
   }

   public BigDecimal getRejectAmountExcludingVATNoFreight() {
      return this.rejectAmountExcludingVATNoFreight;
   }

   public BigDecimal getInboundAmountNoFreight() {
      return this.inboundAmountNoFreight;
   }

   public BigDecimal getRejectAmountNoFreight() {
      return this.rejectAmountNoFreight;
   }

   public BigDecimal getAmountCountNoFreight() {
      return this.amountCountNoFreight;
   }

   public BigDecimal getAmountExcludingVatCountNoFreight() {
      return this.amountExcludingVatCountNoFreight;
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

   public void setPurchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
      this.purchaseOrder = purchaseOrder;
   }

   public void setInboundReceipt(final BriefIdAndSNDTO inboundReceipt) {
      this.inboundReceipt = inboundReceipt;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
   }

   public void setInboundAmountExcludingVAT(final BigDecimal inboundAmountExcludingVAT) {
      this.inboundAmountExcludingVAT = inboundAmountExcludingVAT;
   }

   public void setRejectAmountExcludingVAT(final BigDecimal rejectAmountExcludingVAT) {
      this.rejectAmountExcludingVAT = rejectAmountExcludingVAT;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setRejectAmount(final BigDecimal rejectAmount) {
      this.rejectAmount = rejectAmount;
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

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
   }

   public void setRejectTime(final LocalDateTime rejectTime) {
      this.rejectTime = rejectTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setAmountCount(final BigDecimal amountCount) {
      this.amountCount = amountCount;
   }

   public void setAmountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
      this.amountExcludingVatCount = amountExcludingVatCount;
   }

   public void setInboundAmountExcludingVATNoFreight(final BigDecimal inboundAmountExcludingVATNoFreight) {
      this.inboundAmountExcludingVATNoFreight = inboundAmountExcludingVATNoFreight;
   }

   public void setRejectAmountExcludingVATNoFreight(final BigDecimal rejectAmountExcludingVATNoFreight) {
      this.rejectAmountExcludingVATNoFreight = rejectAmountExcludingVATNoFreight;
   }

   public void setInboundAmountNoFreight(final BigDecimal inboundAmountNoFreight) {
      this.inboundAmountNoFreight = inboundAmountNoFreight;
   }

   public void setRejectAmountNoFreight(final BigDecimal rejectAmountNoFreight) {
      this.rejectAmountNoFreight = rejectAmountNoFreight;
   }

   public void setAmountCountNoFreight(final BigDecimal amountCountNoFreight) {
      this.amountCountNoFreight = amountCountNoFreight;
   }

   public void setAmountExcludingVatCountNoFreight(final BigDecimal amountExcludingVatCountNoFreight) {
      this.amountExcludingVatCountNoFreight = amountExcludingVatCountNoFreight;
   }

   public void setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RejectDO)) {
         return false;
      }

      RejectDO other = (RejectDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$boolPrinted = this.getBoolPrinted();
            Object other$boolPrinted = other.getBoolPrinted();
            if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$purchaseOrder = this.getPurchaseOrder();
                  Object other$purchaseOrder = other.getPurchaseOrder();
                  if (this$purchaseOrder == null ? other$purchaseOrder == null : this$purchaseOrder.equals(other$purchaseOrder)) {
                     Object this$inboundReceipt = this.getInboundReceipt();
                     Object other$inboundReceipt = other.getInboundReceipt();
                     if (this$inboundReceipt == null ? other$inboundReceipt == null : this$inboundReceipt.equals(other$inboundReceipt)) {
                        Object this$projects = this.getProjects();
                        Object other$projects = other.getProjects();
                        if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                           Object this$projectIds = this.getProjectIds();
                           Object other$projectIds = other.getProjectIds();
                           if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                              Object this$supplier = this.getSupplier();
                              Object other$supplier = other.getSupplier();
                              if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                 Object this$inboundAmountExcludingVAT = this.getInboundAmountExcludingVAT();
                                 Object other$inboundAmountExcludingVAT = other.getInboundAmountExcludingVAT();
                                 if (this$inboundAmountExcludingVAT == null
                                    ? other$inboundAmountExcludingVAT == null
                                    : this$inboundAmountExcludingVAT.equals(other$inboundAmountExcludingVAT)) {
                                    Object this$rejectAmountExcludingVAT = this.getRejectAmountExcludingVAT();
                                    Object other$rejectAmountExcludingVAT = other.getRejectAmountExcludingVAT();
                                    if (this$rejectAmountExcludingVAT == null
                                       ? other$rejectAmountExcludingVAT == null
                                       : this$rejectAmountExcludingVAT.equals(other$rejectAmountExcludingVAT)) {
                                       Object this$inboundAmount = this.getInboundAmount();
                                       Object other$inboundAmount = other.getInboundAmount();
                                       if (this$inboundAmount == null ? other$inboundAmount == null : this$inboundAmount.equals(other$inboundAmount)) {
                                          Object this$rejectAmount = this.getRejectAmount();
                                          Object other$rejectAmount = other.getRejectAmount();
                                          if (this$rejectAmount == null ? other$rejectAmount == null : this$rejectAmount.equals(other$rejectAmount)) {
                                             Object this$applicantName = this.getApplicantName();
                                             Object other$applicantName = other.getApplicantName();
                                             if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                                Object this$editorName = this.getEditorName();
                                                Object other$editorName = other.getEditorName();
                                                if (this$editorName == null ? other$editorName == null : this$editorName.equals(other$editorName)) {
                                                   Object this$reviewerName = this.getReviewerName();
                                                   Object other$reviewerName = other.getReviewerName();
                                                   if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$approvalComments = this.getApprovalComments();
                                                         Object other$approvalComments = other.getApprovalComments();
                                                         if (this$approvalComments == null
                                                            ? other$approvalComments == null
                                                            : this$approvalComments.equals(other$approvalComments)) {
                                                            Object this$rejectTime = this.getRejectTime();
                                                            Object other$rejectTime = other.getRejectTime();
                                                            if (this$rejectTime == null ? other$rejectTime == null : this$rejectTime.equals(other$rejectTime)) {
                                                               Object this$createTime = this.getCreateTime();
                                                               Object other$createTime = other.getCreateTime();
                                                               if (this$createTime == null
                                                                  ? other$createTime == null
                                                                  : this$createTime.equals(other$createTime)) {
                                                                  Object this$reviewTime = this.getReviewTime();
                                                                  Object other$reviewTime = other.getReviewTime();
                                                                  if (this$reviewTime == null
                                                                     ? other$reviewTime == null
                                                                     : this$reviewTime.equals(other$reviewTime)) {
                                                                     Object this$amountCount = this.getAmountCount();
                                                                     Object other$amountCount = other.getAmountCount();
                                                                     if (this$amountCount == null
                                                                        ? other$amountCount == null
                                                                        : this$amountCount.equals(other$amountCount)) {
                                                                        Object this$amountExcludingVatCount = this.getAmountExcludingVatCount();
                                                                        Object other$amountExcludingVatCount = other.getAmountExcludingVatCount();
                                                                        if (this$amountExcludingVatCount == null
                                                                           ? other$amountExcludingVatCount == null
                                                                           : this$amountExcludingVatCount.equals(other$amountExcludingVatCount)) {
                                                                           Object this$inboundAmountExcludingVATNoFreight = this.getInboundAmountExcludingVATNoFreight();
                                                                           Object other$inboundAmountExcludingVATNoFreight = other.getInboundAmountExcludingVATNoFreight();
                                                                           if (this$inboundAmountExcludingVATNoFreight == null
                                                                              ? other$inboundAmountExcludingVATNoFreight == null
                                                                              : this$inboundAmountExcludingVATNoFreight.equals(
                                                                                 other$inboundAmountExcludingVATNoFreight
                                                                              )) {
                                                                              Object this$rejectAmountExcludingVATNoFreight = this.getRejectAmountExcludingVATNoFreight();
                                                                              Object other$rejectAmountExcludingVATNoFreight = other.getRejectAmountExcludingVATNoFreight();
                                                                              if (this$rejectAmountExcludingVATNoFreight == null
                                                                                 ? other$rejectAmountExcludingVATNoFreight == null
                                                                                 : this$rejectAmountExcludingVATNoFreight.equals(
                                                                                    other$rejectAmountExcludingVATNoFreight
                                                                                 )) {
                                                                                 Object this$inboundAmountNoFreight = this.getInboundAmountNoFreight();
                                                                                 Object other$inboundAmountNoFreight = other.getInboundAmountNoFreight();
                                                                                 if (this$inboundAmountNoFreight == null
                                                                                    ? other$inboundAmountNoFreight == null
                                                                                    : this$inboundAmountNoFreight.equals(other$inboundAmountNoFreight)) {
                                                                                    Object this$rejectAmountNoFreight = this.getRejectAmountNoFreight();
                                                                                    Object other$rejectAmountNoFreight = other.getRejectAmountNoFreight();
                                                                                    if (this$rejectAmountNoFreight == null
                                                                                       ? other$rejectAmountNoFreight == null
                                                                                       : this$rejectAmountNoFreight.equals(other$rejectAmountNoFreight)) {
                                                                                       Object this$amountCountNoFreight = this.getAmountCountNoFreight();
                                                                                       Object other$amountCountNoFreight = other.getAmountCountNoFreight();
                                                                                       if (this$amountCountNoFreight == null
                                                                                          ? other$amountCountNoFreight == null
                                                                                          : this$amountCountNoFreight.equals(other$amountCountNoFreight)) {
                                                                                          Object this$amountExcludingVatCountNoFreight = this.getAmountExcludingVatCountNoFreight();
                                                                                          Object other$amountExcludingVatCountNoFreight = other.getAmountExcludingVatCountNoFreight();
                                                                                          return this$amountExcludingVatCountNoFreight == null
                                                                                             ? other$amountExcludingVatCountNoFreight == null
                                                                                             : this$amountExcludingVatCountNoFreight.equals(
                                                                                                other$amountExcludingVatCountNoFreight
                                                                                             );
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RejectDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $inboundReceipt = this.getInboundReceipt();
      result = result * 59 + ($inboundReceipt == null ? 43 : $inboundReceipt.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $inboundAmountExcludingVAT = this.getInboundAmountExcludingVAT();
      result = result * 59 + ($inboundAmountExcludingVAT == null ? 43 : $inboundAmountExcludingVAT.hashCode());
      Object $rejectAmountExcludingVAT = this.getRejectAmountExcludingVAT();
      result = result * 59 + ($rejectAmountExcludingVAT == null ? 43 : $rejectAmountExcludingVAT.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $rejectAmount = this.getRejectAmount();
      result = result * 59 + ($rejectAmount == null ? 43 : $rejectAmount.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $rejectTime = this.getRejectTime();
      result = result * 59 + ($rejectTime == null ? 43 : $rejectTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $amountCount = this.getAmountCount();
      result = result * 59 + ($amountCount == null ? 43 : $amountCount.hashCode());
      Object $amountExcludingVatCount = this.getAmountExcludingVatCount();
      result = result * 59 + ($amountExcludingVatCount == null ? 43 : $amountExcludingVatCount.hashCode());
      Object $inboundAmountExcludingVATNoFreight = this.getInboundAmountExcludingVATNoFreight();
      result = result * 59 + ($inboundAmountExcludingVATNoFreight == null ? 43 : $inboundAmountExcludingVATNoFreight.hashCode());
      Object $rejectAmountExcludingVATNoFreight = this.getRejectAmountExcludingVATNoFreight();
      result = result * 59 + ($rejectAmountExcludingVATNoFreight == null ? 43 : $rejectAmountExcludingVATNoFreight.hashCode());
      Object $inboundAmountNoFreight = this.getInboundAmountNoFreight();
      result = result * 59 + ($inboundAmountNoFreight == null ? 43 : $inboundAmountNoFreight.hashCode());
      Object $rejectAmountNoFreight = this.getRejectAmountNoFreight();
      result = result * 59 + ($rejectAmountNoFreight == null ? 43 : $rejectAmountNoFreight.hashCode());
      Object $amountCountNoFreight = this.getAmountCountNoFreight();
      result = result * 59 + ($amountCountNoFreight == null ? 43 : $amountCountNoFreight.hashCode());
      Object $amountExcludingVatCountNoFreight = this.getAmountExcludingVatCountNoFreight();
      return result * 59 + ($amountExcludingVatCountNoFreight == null ? 43 : $amountExcludingVatCountNoFreight.hashCode());
   }

   @Override
   public String toString() {
      return "RejectDO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaseOrder="
         + this.getPurchaseOrder()
         + ", inboundReceipt="
         + this.getInboundReceipt()
         + ", projects="
         + this.getProjects()
         + ", projectIds="
         + this.getProjectIds()
         + ", supplier="
         + this.getSupplier()
         + ", inboundAmountExcludingVAT="
         + this.getInboundAmountExcludingVAT()
         + ", rejectAmountExcludingVAT="
         + this.getRejectAmountExcludingVAT()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", rejectAmount="
         + this.getRejectAmount()
         + ", applicantName="
         + this.getApplicantName()
         + ", editorName="
         + this.getEditorName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", remark="
         + this.getRemark()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", rejectTime="
         + this.getRejectTime()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", amountCount="
         + this.getAmountCount()
         + ", amountExcludingVatCount="
         + this.getAmountExcludingVatCount()
         + ", inboundAmountExcludingVATNoFreight="
         + this.getInboundAmountExcludingVATNoFreight()
         + ", rejectAmountExcludingVATNoFreight="
         + this.getRejectAmountExcludingVATNoFreight()
         + ", inboundAmountNoFreight="
         + this.getInboundAmountNoFreight()
         + ", rejectAmountNoFreight="
         + this.getRejectAmountNoFreight()
         + ", amountCountNoFreight="
         + this.getAmountCountNoFreight()
         + ", amountExcludingVatCountNoFreight="
         + this.getAmountExcludingVatCountNoFreight()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ")";
   }

   public RejectDO(
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final BriefIdAndSNDTO purchaseOrder,
      final BriefIdAndSNDTO inboundReceipt,
      final List<ProjectInfo> projects,
      final String projectIds,
      final BriefIdAndNameDTO supplier,
      final BigDecimal inboundAmountExcludingVAT,
      final BigDecimal rejectAmountExcludingVAT,
      final BigDecimal inboundAmount,
      final BigDecimal rejectAmount,
      final String applicantName,
      final String editorName,
      final String reviewerName,
      final String remark,
      final String approvalComments,
      final LocalDateTime rejectTime,
      final LocalDateTime createTime,
      final LocalDateTime reviewTime,
      final BigDecimal amountCount,
      final BigDecimal amountExcludingVatCount,
      final BigDecimal inboundAmountExcludingVATNoFreight,
      final BigDecimal rejectAmountExcludingVATNoFreight,
      final BigDecimal inboundAmountNoFreight,
      final BigDecimal rejectAmountNoFreight,
      final BigDecimal amountCountNoFreight,
      final BigDecimal amountExcludingVatCountNoFreight,
      final Boolean boolPrinted
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.purchaseOrder = purchaseOrder;
      this.inboundReceipt = inboundReceipt;
      this.projects = projects;
      this.projectIds = projectIds;
      this.supplier = supplier;
      this.inboundAmountExcludingVAT = inboundAmountExcludingVAT;
      this.rejectAmountExcludingVAT = rejectAmountExcludingVAT;
      this.inboundAmount = inboundAmount;
      this.rejectAmount = rejectAmount;
      this.applicantName = applicantName;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.remark = remark;
      this.approvalComments = approvalComments;
      this.rejectTime = rejectTime;
      this.createTime = createTime;
      this.reviewTime = reviewTime;
      this.amountCount = amountCount;
      this.amountExcludingVatCount = amountExcludingVatCount;
      this.inboundAmountExcludingVATNoFreight = inboundAmountExcludingVATNoFreight;
      this.rejectAmountExcludingVATNoFreight = rejectAmountExcludingVATNoFreight;
      this.inboundAmountNoFreight = inboundAmountNoFreight;
      this.rejectAmountNoFreight = rejectAmountNoFreight;
      this.amountCountNoFreight = amountCountNoFreight;
      this.amountExcludingVatCountNoFreight = amountExcludingVatCountNoFreight;
      this.boolPrinted = boolPrinted;
   }

   public RejectDO() {
   }

   public static class RejectDOBuilder {
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private BriefIdAndSNDTO purchaseOrder;
      private BriefIdAndSNDTO inboundReceipt;
      private List<ProjectInfo> projects;
      private String projectIds;
      private BriefIdAndNameDTO supplier;
      private BigDecimal inboundAmountExcludingVAT;
      private BigDecimal rejectAmountExcludingVAT;
      private BigDecimal inboundAmount;
      private BigDecimal rejectAmount;
      private String applicantName;
      private String editorName;
      private String reviewerName;
      private String remark;
      private String approvalComments;
      private LocalDateTime rejectTime;
      private LocalDateTime createTime;
      private LocalDateTime reviewTime;
      private BigDecimal amountCount;
      private BigDecimal amountExcludingVatCount;
      private BigDecimal inboundAmountExcludingVATNoFreight;
      private BigDecimal rejectAmountExcludingVATNoFreight;
      private BigDecimal inboundAmountNoFreight;
      private BigDecimal rejectAmountNoFreight;
      private BigDecimal amountCountNoFreight;
      private BigDecimal amountExcludingVatCountNoFreight;
      private Boolean boolPrinted;

      RejectDOBuilder() {
      }

      public RejectDO.RejectDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public RejectDO.RejectDOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public RejectDO.RejectDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public RejectDO.RejectDOBuilder purchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
         this.purchaseOrder = purchaseOrder;
         return this;
      }

      public RejectDO.RejectDOBuilder inboundReceipt(final BriefIdAndSNDTO inboundReceipt) {
         this.inboundReceipt = inboundReceipt;
         return this;
      }

      public RejectDO.RejectDOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public RejectDO.RejectDOBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public RejectDO.RejectDOBuilder supplier(final BriefIdAndNameDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public RejectDO.RejectDOBuilder inboundAmountExcludingVAT(final BigDecimal inboundAmountExcludingVAT) {
         this.inboundAmountExcludingVAT = inboundAmountExcludingVAT;
         return this;
      }

      public RejectDO.RejectDOBuilder rejectAmountExcludingVAT(final BigDecimal rejectAmountExcludingVAT) {
         this.rejectAmountExcludingVAT = rejectAmountExcludingVAT;
         return this;
      }

      public RejectDO.RejectDOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public RejectDO.RejectDOBuilder rejectAmount(final BigDecimal rejectAmount) {
         this.rejectAmount = rejectAmount;
         return this;
      }

      public RejectDO.RejectDOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public RejectDO.RejectDOBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      public RejectDO.RejectDOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public RejectDO.RejectDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public RejectDO.RejectDOBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public RejectDO.RejectDOBuilder rejectTime(final LocalDateTime rejectTime) {
         this.rejectTime = rejectTime;
         return this;
      }

      public RejectDO.RejectDOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public RejectDO.RejectDOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public RejectDO.RejectDOBuilder amountCount(final BigDecimal amountCount) {
         this.amountCount = amountCount;
         return this;
      }

      public RejectDO.RejectDOBuilder amountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
         this.amountExcludingVatCount = amountExcludingVatCount;
         return this;
      }

      public RejectDO.RejectDOBuilder inboundAmountExcludingVATNoFreight(final BigDecimal inboundAmountExcludingVATNoFreight) {
         this.inboundAmountExcludingVATNoFreight = inboundAmountExcludingVATNoFreight;
         return this;
      }

      public RejectDO.RejectDOBuilder rejectAmountExcludingVATNoFreight(final BigDecimal rejectAmountExcludingVATNoFreight) {
         this.rejectAmountExcludingVATNoFreight = rejectAmountExcludingVATNoFreight;
         return this;
      }

      public RejectDO.RejectDOBuilder inboundAmountNoFreight(final BigDecimal inboundAmountNoFreight) {
         this.inboundAmountNoFreight = inboundAmountNoFreight;
         return this;
      }

      public RejectDO.RejectDOBuilder rejectAmountNoFreight(final BigDecimal rejectAmountNoFreight) {
         this.rejectAmountNoFreight = rejectAmountNoFreight;
         return this;
      }

      public RejectDO.RejectDOBuilder amountCountNoFreight(final BigDecimal amountCountNoFreight) {
         this.amountCountNoFreight = amountCountNoFreight;
         return this;
      }

      public RejectDO.RejectDOBuilder amountExcludingVatCountNoFreight(final BigDecimal amountExcludingVatCountNoFreight) {
         this.amountExcludingVatCountNoFreight = amountExcludingVatCountNoFreight;
         return this;
      }

      public RejectDO.RejectDOBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public RejectDO build() {
         return new RejectDO(
            this.id,
            this.basicClass,
            this.serialNumber,
            this.purchaseOrder,
            this.inboundReceipt,
            this.projects,
            this.projectIds,
            this.supplier,
            this.inboundAmountExcludingVAT,
            this.rejectAmountExcludingVAT,
            this.inboundAmount,
            this.rejectAmount,
            this.applicantName,
            this.editorName,
            this.reviewerName,
            this.remark,
            this.approvalComments,
            this.rejectTime,
            this.createTime,
            this.reviewTime,
            this.amountCount,
            this.amountExcludingVatCount,
            this.inboundAmountExcludingVATNoFreight,
            this.rejectAmountExcludingVATNoFreight,
            this.inboundAmountNoFreight,
            this.rejectAmountNoFreight,
            this.amountCountNoFreight,
            this.amountExcludingVatCountNoFreight,
            this.boolPrinted
         );
      }

      @Override
      public String toString() {
         return "RejectDO.RejectDOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", purchaseOrder="
            + this.purchaseOrder
            + ", inboundReceipt="
            + this.inboundReceipt
            + ", projects="
            + this.projects
            + ", projectIds="
            + this.projectIds
            + ", supplier="
            + this.supplier
            + ", inboundAmountExcludingVAT="
            + this.inboundAmountExcludingVAT
            + ", rejectAmountExcludingVAT="
            + this.rejectAmountExcludingVAT
            + ", inboundAmount="
            + this.inboundAmount
            + ", rejectAmount="
            + this.rejectAmount
            + ", applicantName="
            + this.applicantName
            + ", editorName="
            + this.editorName
            + ", reviewerName="
            + this.reviewerName
            + ", remark="
            + this.remark
            + ", approvalComments="
            + this.approvalComments
            + ", rejectTime="
            + this.rejectTime
            + ", createTime="
            + this.createTime
            + ", reviewTime="
            + this.reviewTime
            + ", amountCount="
            + this.amountCount
            + ", amountExcludingVatCount="
            + this.amountExcludingVatCount
            + ", inboundAmountExcludingVATNoFreight="
            + this.inboundAmountExcludingVATNoFreight
            + ", rejectAmountExcludingVATNoFreight="
            + this.rejectAmountExcludingVATNoFreight
            + ", inboundAmountNoFreight="
            + this.inboundAmountNoFreight
            + ", rejectAmountNoFreight="
            + this.rejectAmountNoFreight
            + ", amountCountNoFreight="
            + this.amountCountNoFreight
            + ", amountExcludingVatCountNoFreight="
            + this.amountExcludingVatCountNoFreight
            + ", boolPrinted="
            + this.boolPrinted
            + ")";
      }
   }
}
