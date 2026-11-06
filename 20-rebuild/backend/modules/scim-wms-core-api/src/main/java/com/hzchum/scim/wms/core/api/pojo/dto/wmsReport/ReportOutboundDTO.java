package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReportOutboundDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "审核出库单编号", notes = "审核出库单编号")
   private String serialNumber;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   private String reviewerName;
   @ApiModelProperty(name = "recipients", value = "领用人名称集", notes = "领用人名称集")
   private String recipients;
   @ApiModelProperty(name = "recipients", value = "领用人名称集", notes = "领用人名称集")
   private List<String> recipientsList;
   @ApiModelProperty(name = "outboundTime", value = "出库时间", notes = "出库时间")
   private LocalDateTime outboundTime;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "userUpdateTime", value = "用户修改时间", notes = "用户修改时间")
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "containBasicClass", value = "出库单包含基础类型", notes = "出库单包含基础类型")
   private Integer containBasicClass;
   @ApiModelProperty(name = "outboundEndTime", value = "出库结束时间", notes = "出库结束时间")
   private LocalDateTime outboundEndTime;
   @ApiModelProperty(name = "outboundStartTime", value = "出库开始时间", notes = "出库开始时间")
   private LocalDateTime outboundStartTime;
   @ApiModelProperty(name = "projectIds", value = "出库项目ID集", notes = "出库项目ID集")
   private String projectIds;
   @ApiModelProperty(name = "projects", value = "出库项目", notes = "出库项目")
   private List<ProjectInfo> projects;
   @ApiModelProperty(name = "projects", value = "出库批次", notes = "出库批次")
   private List<String> areaBatchNames;
   @ApiModelProperty(name = "outboundLength", value = "条板实际出库长度", notes = "条板实际出库长度")
   private BigDecimal outboundLength;
   @ApiModelProperty(name = "outboundMete", value = "条板实际出库核算量", notes = "条板实际出库核算量")
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "boolPartyA")
   private Boolean boolPartyA;
   @ApiModelProperty(name = "outboundTypeSelection")
   private Integer outboundTypeSelection;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private Boolean boolPrinted;
   private String remark;
   private Integer orderSupplyType;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public String getRecipients() {
      return this.recipients;
   }

   public List<String> getRecipientsList() {
      return this.recipientsList;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public Integer getContainBasicClass() {
      return this.containBasicClass;
   }

   public LocalDateTime getOutboundEndTime() {
      return this.outboundEndTime;
   }

   public LocalDateTime getOutboundStartTime() {
      return this.outboundStartTime;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public List<String> getAreaBatchNames() {
      return this.areaBatchNames;
   }

   public BigDecimal getOutboundLength() {
      return this.outboundLength;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
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

   public String getRemark() {
      return this.remark;
   }

   public Integer getOrderSupplyType() {
      return this.orderSupplyType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setRecipients(final String recipients) {
      this.recipients = recipients;
   }

   public void setRecipientsList(final List<String> recipientsList) {
      this.recipientsList = recipientsList;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setContainBasicClass(final Integer containBasicClass) {
      this.containBasicClass = containBasicClass;
   }

   public void setOutboundEndTime(final LocalDateTime outboundEndTime) {
      this.outboundEndTime = outboundEndTime;
   }

   public void setOutboundStartTime(final LocalDateTime outboundStartTime) {
      this.outboundStartTime = outboundStartTime;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setAreaBatchNames(final List<String> areaBatchNames) {
      this.areaBatchNames = areaBatchNames;
   }

   public void setOutboundLength(final BigDecimal outboundLength) {
      this.outboundLength = outboundLength;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
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

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setOrderSupplyType(final Integer orderSupplyType) {
      this.orderSupplyType = orderSupplyType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReportOutboundDTO)) {
         return false;
      }

      ReportOutboundDTO other = (ReportOutboundDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$applicantId = this.getApplicantId();
         Object other$applicantId = other.getApplicantId();
         if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
            Object this$reviewerId = this.getReviewerId();
            Object other$reviewerId = other.getReviewerId();
            if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
               Object this$containBasicClass = this.getContainBasicClass();
               Object other$containBasicClass = other.getContainBasicClass();
               if (this$containBasicClass == null ? other$containBasicClass == null : this$containBasicClass.equals(other$containBasicClass)) {
                  Object this$boolPartyA = this.getBoolPartyA();
                  Object other$boolPartyA = other.getBoolPartyA();
                  if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                     Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                     Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                     if (this$outboundTypeSelection == null
                        ? other$outboundTypeSelection == null
                        : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                        Object this$boolPrinted = this.getBoolPrinted();
                        Object other$boolPrinted = other.getBoolPrinted();
                        if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                           Object this$orderSupplyType = this.getOrderSupplyType();
                           Object other$orderSupplyType = other.getOrderSupplyType();
                           if (this$orderSupplyType == null ? other$orderSupplyType == null : this$orderSupplyType.equals(other$orderSupplyType)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$applicantName = this.getApplicantName();
                                 Object other$applicantName = other.getApplicantName();
                                 if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                    Object this$reviewerName = this.getReviewerName();
                                    Object other$reviewerName = other.getReviewerName();
                                    if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                       Object this$recipients = this.getRecipients();
                                       Object other$recipients = other.getRecipients();
                                       if (this$recipients == null ? other$recipients == null : this$recipients.equals(other$recipients)) {
                                          Object this$recipientsList = this.getRecipientsList();
                                          Object other$recipientsList = other.getRecipientsList();
                                          if (this$recipientsList == null ? other$recipientsList == null : this$recipientsList.equals(other$recipientsList)) {
                                             Object this$outboundTime = this.getOutboundTime();
                                             Object other$outboundTime = other.getOutboundTime();
                                             if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                                                Object this$reviewTime = this.getReviewTime();
                                                Object other$reviewTime = other.getReviewTime();
                                                if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                                   Object this$userUpdateTime = this.getUserUpdateTime();
                                                   Object other$userUpdateTime = other.getUserUpdateTime();
                                                   if (this$userUpdateTime == null
                                                      ? other$userUpdateTime == null
                                                      : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                      Object this$outboundEndTime = this.getOutboundEndTime();
                                                      Object other$outboundEndTime = other.getOutboundEndTime();
                                                      if (this$outboundEndTime == null
                                                         ? other$outboundEndTime == null
                                                         : this$outboundEndTime.equals(other$outboundEndTime)) {
                                                         Object this$outboundStartTime = this.getOutboundStartTime();
                                                         Object other$outboundStartTime = other.getOutboundStartTime();
                                                         if (this$outboundStartTime == null
                                                            ? other$outboundStartTime == null
                                                            : this$outboundStartTime.equals(other$outboundStartTime)) {
                                                            Object this$projectIds = this.getProjectIds();
                                                            Object other$projectIds = other.getProjectIds();
                                                            if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                               Object this$projects = this.getProjects();
                                                               Object other$projects = other.getProjects();
                                                               if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                                                  Object this$areaBatchNames = this.getAreaBatchNames();
                                                                  Object other$areaBatchNames = other.getAreaBatchNames();
                                                                  if (this$areaBatchNames == null
                                                                     ? other$areaBatchNames == null
                                                                     : this$areaBatchNames.equals(other$areaBatchNames)) {
                                                                     Object this$outboundLength = this.getOutboundLength();
                                                                     Object other$outboundLength = other.getOutboundLength();
                                                                     if (this$outboundLength == null
                                                                        ? other$outboundLength == null
                                                                        : this$outboundLength.equals(other$outboundLength)) {
                                                                        Object this$outboundMete = this.getOutboundMete();
                                                                        Object other$outboundMete = other.getOutboundMete();
                                                                        if (this$outboundMete == null
                                                                           ? other$outboundMete == null
                                                                           : this$outboundMete.equals(other$outboundMete)) {
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
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    return this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark);
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
      return other instanceof ReportOutboundDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $containBasicClass = this.getContainBasicClass();
      result = result * 59 + ($containBasicClass == null ? 43 : $containBasicClass.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $orderSupplyType = this.getOrderSupplyType();
      result = result * 59 + ($orderSupplyType == null ? 43 : $orderSupplyType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $recipients = this.getRecipients();
      result = result * 59 + ($recipients == null ? 43 : $recipients.hashCode());
      Object $recipientsList = this.getRecipientsList();
      result = result * 59 + ($recipientsList == null ? 43 : $recipientsList.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $outboundEndTime = this.getOutboundEndTime();
      result = result * 59 + ($outboundEndTime == null ? 43 : $outboundEndTime.hashCode());
      Object $outboundStartTime = this.getOutboundStartTime();
      result = result * 59 + ($outboundStartTime == null ? 43 : $outboundStartTime.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $areaBatchNames = this.getAreaBatchNames();
      result = result * 59 + ($areaBatchNames == null ? 43 : $areaBatchNames.hashCode());
      Object $outboundLength = this.getOutboundLength();
      result = result * 59 + ($outboundLength == null ? 43 : $outboundLength.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      result = result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ReportOutboundDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", recipients="
         + this.getRecipients()
         + ", recipientsList="
         + this.getRecipientsList()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", containBasicClass="
         + this.getContainBasicClass()
         + ", outboundEndTime="
         + this.getOutboundEndTime()
         + ", outboundStartTime="
         + this.getOutboundStartTime()
         + ", projectIds="
         + this.getProjectIds()
         + ", projects="
         + this.getProjects()
         + ", areaBatchNames="
         + this.getAreaBatchNames()
         + ", outboundLength="
         + this.getOutboundLength()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", remark="
         + this.getRemark()
         + ", orderSupplyType="
         + this.getOrderSupplyType()
         + ")";
   }

   public ReportOutboundDTO(
      final Long id,
      final String serialNumber,
      final Long applicantId,
      final String applicantName,
      final Long reviewerId,
      final String reviewerName,
      final String recipients,
      final List<String> recipientsList,
      final LocalDateTime outboundTime,
      final LocalDateTime reviewTime,
      final LocalDateTime userUpdateTime,
      final Integer containBasicClass,
      final LocalDateTime outboundEndTime,
      final LocalDateTime outboundStartTime,
      final String projectIds,
      final List<ProjectInfo> projects,
      final List<String> areaBatchNames,
      final BigDecimal outboundLength,
      final BigDecimal outboundMete,
      final Boolean boolPartyA,
      final Integer outboundTypeSelection,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final Boolean boolPrinted,
      final String remark,
      final Integer orderSupplyType
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.recipients = recipients;
      this.recipientsList = recipientsList;
      this.outboundTime = outboundTime;
      this.reviewTime = reviewTime;
      this.userUpdateTime = userUpdateTime;
      this.containBasicClass = containBasicClass;
      this.outboundEndTime = outboundEndTime;
      this.outboundStartTime = outboundStartTime;
      this.projectIds = projectIds;
      this.projects = projects;
      this.areaBatchNames = areaBatchNames;
      this.outboundLength = outboundLength;
      this.outboundMete = outboundMete;
      this.boolPartyA = boolPartyA;
      this.outboundTypeSelection = outboundTypeSelection;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.boolPrinted = boolPrinted;
      this.remark = remark;
      this.orderSupplyType = orderSupplyType;
   }

   public ReportOutboundDTO() {
   }
}
