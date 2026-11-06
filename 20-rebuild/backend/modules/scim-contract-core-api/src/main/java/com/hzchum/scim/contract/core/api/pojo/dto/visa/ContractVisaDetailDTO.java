package com.hzchum.scim.contract.core.api.pojo.dto.visa;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel(description = "签证 ")
public class ContractVisaDetailDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("签证类型 1签证 2结算")
   private Integer type;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("签证日期")
   private LocalDate visaDate;
   @ApiModelProperty("签证人id")
   private Long userId;
   @ApiModelProperty("签证人名称")
   private String userName;
   @ApiModelProperty("签证原因id")
   private String reasonId;
   @ApiModelProperty("签证原因名称")
   private String reasonName;
   @ApiModelProperty("签证额")
   private BigDecimal visaAmount;
   @ApiModelProperty("结算日期")
   private LocalDate settlementDate;
   @ApiModelProperty("加工结算额")
   private BigDecimal processingSettlementAmount;
   @ApiModelProperty("最终结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("监理单位")
   private String supervisionUnit;
   @ApiModelProperty("设计单位")
   private String designUnit;
   @ApiModelProperty("政府监管")
   private String governmentRegulation;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("项目信息")
   private ContractVisaProjectInfoDTO project;
   @ApiModelProperty("违约额")
   private BigDecimal breachAmount;
   @ApiModelProperty("附件")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty("附件备注")
   private String attachmentRemark;
   @ApiModelProperty(name = "approveRecordIdNow", value = "当前审批日志ID")
   private Long approveRecordIdNow;
   @ApiModelProperty("签证对象名称")
   private String recipients;
   @ApiModelProperty("签证对象(对内：分包id)")
   private Long supplierId;
   @ApiModelProperty("签证模式 1对内 2对外")
   private Integer mode;
   private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDate getVisaDate() {
      return this.visaDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getReasonId() {
      return this.reasonId;
   }

   public String getReasonName() {
      return this.reasonName;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
   }

   public LocalDate getSettlementDate() {
      return this.settlementDate;
   }

   public BigDecimal getProcessingSettlementAmount() {
      return this.processingSettlementAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public String getSupervisionUnit() {
      return this.supervisionUnit;
   }

   public String getDesignUnit() {
      return this.designUnit;
   }

   public String getGovernmentRegulation() {
      return this.governmentRegulation;
   }

   public String getRemark() {
      return this.remark;
   }

   public ContractVisaProjectInfoDTO getProject() {
      return this.project;
   }

   public BigDecimal getBreachAmount() {
      return this.breachAmount;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getAttachmentRemark() {
      return this.attachmentRemark;
   }

   public Long getApproveRecordIdNow() {
      return this.approveRecordIdNow;
   }

   public String getRecipients() {
      return this.recipients;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Integer getMode() {
      return this.mode;
   }

   public List<WmsApproveRecordFlowDTO> getWmsApproveRecordFlowDTOS() {
      return this.wmsApproveRecordFlowDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setVisaDate(final LocalDate visaDate) {
      this.visaDate = visaDate;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setReasonId(final String reasonId) {
      this.reasonId = reasonId;
   }

   public void setReasonName(final String reasonName) {
      this.reasonName = reasonName;
   }

   public void setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
   }

   public void setSettlementDate(final LocalDate settlementDate) {
      this.settlementDate = settlementDate;
   }

   public void setProcessingSettlementAmount(final BigDecimal processingSettlementAmount) {
      this.processingSettlementAmount = processingSettlementAmount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setSupervisionUnit(final String supervisionUnit) {
      this.supervisionUnit = supervisionUnit;
   }

   public void setDesignUnit(final String designUnit) {
      this.designUnit = designUnit;
   }

   public void setGovernmentRegulation(final String governmentRegulation) {
      this.governmentRegulation = governmentRegulation;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setProject(final ContractVisaProjectInfoDTO project) {
      this.project = project;
   }

   public void setBreachAmount(final BigDecimal breachAmount) {
      this.breachAmount = breachAmount;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setAttachmentRemark(final String attachmentRemark) {
      this.attachmentRemark = attachmentRemark;
   }

   public void setApproveRecordIdNow(final Long approveRecordIdNow) {
      this.approveRecordIdNow = approveRecordIdNow;
   }

   public void setRecipients(final String recipients) {
      this.recipients = recipients;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setMode(final Integer mode) {
      this.mode = mode;
   }

   public void setWmsApproveRecordFlowDTOS(final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS) {
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractVisaDetailDTO)) {
         return false;
      }

      ContractVisaDetailDTO other = (ContractVisaDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$approveRecordIdNow = this.getApproveRecordIdNow();
               Object other$approveRecordIdNow = other.getApproveRecordIdNow();
               if (this$approveRecordIdNow == null ? other$approveRecordIdNow == null : this$approveRecordIdNow.equals(other$approveRecordIdNow)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$mode = this.getMode();
                     Object other$mode = other.getMode();
                     if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$visaDate = this.getVisaDate();
                           Object other$visaDate = other.getVisaDate();
                           if (this$visaDate == null ? other$visaDate == null : this$visaDate.equals(other$visaDate)) {
                              Object this$userName = this.getUserName();
                              Object other$userName = other.getUserName();
                              if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                 Object this$reasonId = this.getReasonId();
                                 Object other$reasonId = other.getReasonId();
                                 if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
                                    Object this$reasonName = this.getReasonName();
                                    Object other$reasonName = other.getReasonName();
                                    if (this$reasonName == null ? other$reasonName == null : this$reasonName.equals(other$reasonName)) {
                                       Object this$visaAmount = this.getVisaAmount();
                                       Object other$visaAmount = other.getVisaAmount();
                                       if (this$visaAmount == null ? other$visaAmount == null : this$visaAmount.equals(other$visaAmount)) {
                                          Object this$settlementDate = this.getSettlementDate();
                                          Object other$settlementDate = other.getSettlementDate();
                                          if (this$settlementDate == null ? other$settlementDate == null : this$settlementDate.equals(other$settlementDate)) {
                                             Object this$processingSettlementAmount = this.getProcessingSettlementAmount();
                                             Object other$processingSettlementAmount = other.getProcessingSettlementAmount();
                                             if (this$processingSettlementAmount == null
                                                ? other$processingSettlementAmount == null
                                                : this$processingSettlementAmount.equals(other$processingSettlementAmount)) {
                                                Object this$settlementAmount = this.getSettlementAmount();
                                                Object other$settlementAmount = other.getSettlementAmount();
                                                if (this$settlementAmount == null
                                                   ? other$settlementAmount == null
                                                   : this$settlementAmount.equals(other$settlementAmount)) {
                                                   Object this$supervisionUnit = this.getSupervisionUnit();
                                                   Object other$supervisionUnit = other.getSupervisionUnit();
                                                   if (this$supervisionUnit == null
                                                      ? other$supervisionUnit == null
                                                      : this$supervisionUnit.equals(other$supervisionUnit)) {
                                                      Object this$designUnit = this.getDesignUnit();
                                                      Object other$designUnit = other.getDesignUnit();
                                                      if (this$designUnit == null ? other$designUnit == null : this$designUnit.equals(other$designUnit)) {
                                                         Object this$governmentRegulation = this.getGovernmentRegulation();
                                                         Object other$governmentRegulation = other.getGovernmentRegulation();
                                                         if (this$governmentRegulation == null
                                                            ? other$governmentRegulation == null
                                                            : this$governmentRegulation.equals(other$governmentRegulation)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                               Object this$project = this.getProject();
                                                               Object other$project = other.getProject();
                                                               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                  Object this$breachAmount = this.getBreachAmount();
                                                                  Object other$breachAmount = other.getBreachAmount();
                                                                  if (this$breachAmount == null
                                                                     ? other$breachAmount == null
                                                                     : this$breachAmount.equals(other$breachAmount)) {
                                                                     Object this$attachments = this.getAttachments();
                                                                     Object other$attachments = other.getAttachments();
                                                                     if (this$attachments == null
                                                                        ? other$attachments == null
                                                                        : this$attachments.equals(other$attachments)) {
                                                                        Object this$attachmentRemark = this.getAttachmentRemark();
                                                                        Object other$attachmentRemark = other.getAttachmentRemark();
                                                                        if (this$attachmentRemark == null
                                                                           ? other$attachmentRemark == null
                                                                           : this$attachmentRemark.equals(other$attachmentRemark)) {
                                                                           Object this$recipients = this.getRecipients();
                                                                           Object other$recipients = other.getRecipients();
                                                                           if (this$recipients == null
                                                                              ? other$recipients == null
                                                                              : this$recipients.equals(other$recipients)) {
                                                                              Object this$wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
                                                                              Object other$wmsApproveRecordFlowDTOS = other.getWmsApproveRecordFlowDTOS();
                                                                              return this$wmsApproveRecordFlowDTOS == null
                                                                                 ? other$wmsApproveRecordFlowDTOS == null
                                                                                 : this$wmsApproveRecordFlowDTOS.equals(other$wmsApproveRecordFlowDTOS);
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
      return other instanceof ContractVisaDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $visaDate = this.getVisaDate();
      result = result * 59 + ($visaDate == null ? 43 : $visaDate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $reasonName = this.getReasonName();
      result = result * 59 + ($reasonName == null ? 43 : $reasonName.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $settlementDate = this.getSettlementDate();
      result = result * 59 + ($settlementDate == null ? 43 : $settlementDate.hashCode());
      Object $processingSettlementAmount = this.getProcessingSettlementAmount();
      result = result * 59 + ($processingSettlementAmount == null ? 43 : $processingSettlementAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $supervisionUnit = this.getSupervisionUnit();
      result = result * 59 + ($supervisionUnit == null ? 43 : $supervisionUnit.hashCode());
      Object $designUnit = this.getDesignUnit();
      result = result * 59 + ($designUnit == null ? 43 : $designUnit.hashCode());
      Object $governmentRegulation = this.getGovernmentRegulation();
      result = result * 59 + ($governmentRegulation == null ? 43 : $governmentRegulation.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $breachAmount = this.getBreachAmount();
      result = result * 59 + ($breachAmount == null ? 43 : $breachAmount.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $attachmentRemark = this.getAttachmentRemark();
      result = result * 59 + ($attachmentRemark == null ? 43 : $attachmentRemark.hashCode());
      Object $recipients = this.getRecipients();
      result = result * 59 + ($recipients == null ? 43 : $recipients.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      return result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "ContractVisaDetailDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", visaDate="
         + this.getVisaDate()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", reasonId="
         + this.getReasonId()
         + ", reasonName="
         + this.getReasonName()
         + ", visaAmount="
         + this.getVisaAmount()
         + ", settlementDate="
         + this.getSettlementDate()
         + ", processingSettlementAmount="
         + this.getProcessingSettlementAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", supervisionUnit="
         + this.getSupervisionUnit()
         + ", designUnit="
         + this.getDesignUnit()
         + ", governmentRegulation="
         + this.getGovernmentRegulation()
         + ", remark="
         + this.getRemark()
         + ", project="
         + this.getProject()
         + ", breachAmount="
         + this.getBreachAmount()
         + ", attachments="
         + this.getAttachments()
         + ", attachmentRemark="
         + this.getAttachmentRemark()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", recipients="
         + this.getRecipients()
         + ", supplierId="
         + this.getSupplierId()
         + ", mode="
         + this.getMode()
         + ", wmsApproveRecordFlowDTOS="
         + this.getWmsApproveRecordFlowDTOS()
         + ")";
   }
}
