package com.hzchum.scim.contract.core.api.pojo.dto.visa;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(description = "签证 ")
public class ContractVisaDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("签证类型")
   private Integer type;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("签证原因名称")
   private String reasonName;
   @ApiModelProperty("签证额/结算额")
   private BigDecimal amount;
   @ApiModelProperty("签证人(申请人)id")
   private Long userId;
   @ApiModelProperty("签证人(申请人)名称")
   private String userName;
   @ApiModelProperty("创建人id")
   private Long createUserId;
   @ApiModelProperty("创建人名称")
   private String createUserName;
   @ApiModelProperty("审核人id")
   private Long checkUserId;
   @ApiModelProperty("审核人名称")
   private String checkUserName;
   @ApiModelProperty("审核状态 1未审核 2通过 4驳回")
   private Integer status;
   @ApiModelProperty("结算状态 0未结算 1已结算")
   private Integer isSubmitSettle;
   @ApiModelProperty("是否有结算记录 0没有 1有")
   private Boolean settlementRecord;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("申请日期")
   private LocalDateTime createTime;
   @ApiModelProperty("附件")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty("附件备注")
   private String attachmentRemark;
   @ApiModelProperty(name = "contractAmount", notes = "合同金额（元）")
   @JsonProperty("contractAmount")
   @JSONField(name = "contractAmount")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "approveRecordIdNow", value = "当前审批日志ID")
   private Long approveRecordIdNow;
   @ApiModelProperty("签证对象名称")
   private String recipients;
   @ApiModelProperty("签证对象(对内：分包id)")
   private Long supplierId;
   @ApiModelProperty("签证模式 1对内 2对外")
   private Integer mode;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getType() {
      return this.type;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getReasonName() {
      return this.reasonName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getCheckUserId() {
      return this.checkUserId;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getIsSubmitSettle() {
      return this.isSubmitSettle;
   }

   public Boolean getSettlementRecord() {
      return this.settlementRecord;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getAttachmentRemark() {
      return this.attachmentRemark;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setReasonName(final String reasonName) {
      this.reasonName = reasonName;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCheckUserId(final Long checkUserId) {
      this.checkUserId = checkUserId;
   }

   public void setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setIsSubmitSettle(final Integer isSubmitSettle) {
      this.isSubmitSettle = isSubmitSettle;
   }

   public void setSettlementRecord(final Boolean settlementRecord) {
      this.settlementRecord = settlementRecord;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setAttachmentRemark(final String attachmentRemark) {
      this.attachmentRemark = attachmentRemark;
   }

   @JsonProperty("contractAmount")
   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractVisaDTO)) {
         return false;
      }

      ContractVisaDTO other = (ContractVisaDTO)o;
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
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$checkUserId = this.getCheckUserId();
                  Object other$checkUserId = other.getCheckUserId();
                  if (this$checkUserId == null ? other$checkUserId == null : this$checkUserId.equals(other$checkUserId)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$isSubmitSettle = this.getIsSubmitSettle();
                        Object other$isSubmitSettle = other.getIsSubmitSettle();
                        if (this$isSubmitSettle == null ? other$isSubmitSettle == null : this$isSubmitSettle.equals(other$isSubmitSettle)) {
                           Object this$settlementRecord = this.getSettlementRecord();
                           Object other$settlementRecord = other.getSettlementRecord();
                           if (this$settlementRecord == null ? other$settlementRecord == null : this$settlementRecord.equals(other$settlementRecord)) {
                              Object this$approveRecordIdNow = this.getApproveRecordIdNow();
                              Object other$approveRecordIdNow = other.getApproveRecordIdNow();
                              if (this$approveRecordIdNow == null ? other$approveRecordIdNow == null : this$approveRecordIdNow.equals(other$approveRecordIdNow)
                                 )
                               {
                                 Object this$supplierId = this.getSupplierId();
                                 Object other$supplierId = other.getSupplierId();
                                 if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                    Object this$mode = this.getMode();
                                    Object other$mode = other.getMode();
                                    if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
                                       Object this$project = this.getProject();
                                       Object other$project = other.getProject();
                                       if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$reasonName = this.getReasonName();
                                             Object other$reasonName = other.getReasonName();
                                             if (this$reasonName == null ? other$reasonName == null : this$reasonName.equals(other$reasonName)) {
                                                Object this$amount = this.getAmount();
                                                Object other$amount = other.getAmount();
                                                if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                   Object this$userName = this.getUserName();
                                                   Object other$userName = other.getUserName();
                                                   if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                      Object this$createUserName = this.getCreateUserName();
                                                      Object other$createUserName = other.getCreateUserName();
                                                      if (this$createUserName == null
                                                         ? other$createUserName == null
                                                         : this$createUserName.equals(other$createUserName)) {
                                                         Object this$checkUserName = this.getCheckUserName();
                                                         Object other$checkUserName = other.getCheckUserName();
                                                         if (this$checkUserName == null
                                                            ? other$checkUserName == null
                                                            : this$checkUserName.equals(other$checkUserName)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                               Object this$createTime = this.getCreateTime();
                                                               Object other$createTime = other.getCreateTime();
                                                               if (this$createTime == null
                                                                  ? other$createTime == null
                                                                  : this$createTime.equals(other$createTime)) {
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
                                                                        Object this$contractAmount = this.getContractAmount();
                                                                        Object other$contractAmount = other.getContractAmount();
                                                                        if (this$contractAmount == null
                                                                           ? other$contractAmount == null
                                                                           : this$contractAmount.equals(other$contractAmount)) {
                                                                           Object this$recipients = this.getRecipients();
                                                                           Object other$recipients = other.getRecipients();
                                                                           return this$recipients == null
                                                                              ? other$recipients == null
                                                                              : this$recipients.equals(other$recipients);
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
      return other instanceof ContractVisaDTO;
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
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $checkUserId = this.getCheckUserId();
      result = result * 59 + ($checkUserId == null ? 43 : $checkUserId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $isSubmitSettle = this.getIsSubmitSettle();
      result = result * 59 + ($isSubmitSettle == null ? 43 : $isSubmitSettle.hashCode());
      Object $settlementRecord = this.getSettlementRecord();
      result = result * 59 + ($settlementRecord == null ? 43 : $settlementRecord.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reasonName = this.getReasonName();
      result = result * 59 + ($reasonName == null ? 43 : $reasonName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $attachmentRemark = this.getAttachmentRemark();
      result = result * 59 + ($attachmentRemark == null ? 43 : $attachmentRemark.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $recipients = this.getRecipients();
      return result * 59 + ($recipients == null ? 43 : $recipients.hashCode());
   }

   @Override
   public String toString() {
      return "ContractVisaDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", type="
         + this.getType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reasonName="
         + this.getReasonName()
         + ", amount="
         + this.getAmount()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", checkUserId="
         + this.getCheckUserId()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", status="
         + this.getStatus()
         + ", isSubmitSettle="
         + this.getIsSubmitSettle()
         + ", settlementRecord="
         + this.getSettlementRecord()
         + ", remark="
         + this.getRemark()
         + ", createTime="
         + this.getCreateTime()
         + ", attachments="
         + this.getAttachments()
         + ", attachmentRemark="
         + this.getAttachmentRemark()
         + ", contractAmount="
         + this.getContractAmount()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", recipients="
         + this.getRecipients()
         + ", supplierId="
         + this.getSupplierId()
         + ", mode="
         + this.getMode()
         + ")";
   }
}
