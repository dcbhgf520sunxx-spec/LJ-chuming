package com.hzchum.scim.project.core.api.pojo.dto.sub;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("分包订单结算信息")
public class SupplierSettlementInfo {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty("订单id")
   private Long orderId;
   @ApiModelProperty("订单类别 1原材料订单 2制成品订单 4分包订单")
   private Integer orderClass;
   @ApiModelProperty("结算金额")
   private BigDecimal amount;
   @ApiModelProperty("是否扣除违约金 true 扣除 false 不扣除")
   private Boolean boolDeduct;
   @ApiModelProperty("申请日期")
   private LocalDate applyDate;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("附件id字符串")
   private String attachmentIds;
   @ApiModelProperty("附件对象列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("审核人id")
   private Long auditUserId;
   @ApiModelProperty("审核人名字")
   private String auditUserName;
   @ApiModelProperty("审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("审核状态 1未审核 2审核通过 4驳回")
   private Integer auditStatus;

   public Long getId() {
      return this.id;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Integer getOrderClass() {
      return this.orderClass;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Boolean getBoolDeduct() {
      return this.boolDeduct;
   }

   public LocalDate getApplyDate() {
      return this.applyDate;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setOrderClass(final Integer orderClass) {
      this.orderClass = orderClass;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setBoolDeduct(final Boolean boolDeduct) {
      this.boolDeduct = boolDeduct;
   }

   public void setApplyDate(final LocalDate applyDate) {
      this.applyDate = applyDate;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSettlementInfo)) {
         return false;
      }

      SupplierSettlementInfo other = (SupplierSettlementInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$orderId = this.getOrderId();
         Object other$orderId = other.getOrderId();
         if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
            Object this$orderClass = this.getOrderClass();
            Object other$orderClass = other.getOrderClass();
            if (this$orderClass == null ? other$orderClass == null : this$orderClass.equals(other$orderClass)) {
               Object this$boolDeduct = this.getBoolDeduct();
               Object other$boolDeduct = other.getBoolDeduct();
               if (this$boolDeduct == null ? other$boolDeduct == null : this$boolDeduct.equals(other$boolDeduct)) {
                  Object this$applyUserId = this.getApplyUserId();
                  Object other$applyUserId = other.getApplyUserId();
                  if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                     Object this$auditUserId = this.getAuditUserId();
                     Object other$auditUserId = other.getAuditUserId();
                     if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                        Object this$auditStatus = this.getAuditStatus();
                        Object other$auditStatus = other.getAuditStatus();
                        if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                           Object this$amount = this.getAmount();
                           Object other$amount = other.getAmount();
                           if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                              Object this$applyDate = this.getApplyDate();
                              Object other$applyDate = other.getApplyDate();
                              if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                                 Object this$applyUserName = this.getApplyUserName();
                                 Object other$applyUserName = other.getApplyUserName();
                                 if (this$applyUserName == null ? other$applyUserName == null : this$applyUserName.equals(other$applyUserName)) {
                                    Object this$attachmentIds = this.getAttachmentIds();
                                    Object other$attachmentIds = other.getAttachmentIds();
                                    if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                       Object this$attachments = this.getAttachments();
                                       Object other$attachments = other.getAttachments();
                                       if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                             Object this$auditUserName = this.getAuditUserName();
                                             Object other$auditUserName = other.getAuditUserName();
                                             if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                                Object this$auditTime = this.getAuditTime();
                                                Object other$auditTime = other.getAuditTime();
                                                return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
      return other instanceof SupplierSettlementInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $orderClass = this.getOrderClass();
      result = result * 59 + ($orderClass == null ? 43 : $orderClass.hashCode());
      Object $boolDeduct = this.getBoolDeduct();
      result = result * 59 + ($boolDeduct == null ? 43 : $boolDeduct.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSettlementInfo(id="
         + this.getId()
         + ", orderId="
         + this.getOrderId()
         + ", orderClass="
         + this.getOrderClass()
         + ", amount="
         + this.getAmount()
         + ", boolDeduct="
         + this.getBoolDeduct()
         + ", applyDate="
         + this.getApplyDate()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }
}
