package com.hzchum.scim.crm.core.api.pojo.param.save;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CrmPrequalificationRecordSaveParam {
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "文件受理截止日", notes = "文件受理截止日")
   private LocalDate deadlineForAcceptanceTime;
   @ApiModelProperty(name = "address", value = "文件受理地点", notes = "文件受理地点")
   private String address;
   @ApiModelProperty(name = "email", value = "文件受理邮箱", notes = "文件受理邮箱")
   private String email;
   @ApiModelProperty(name = "cost", value = "预审费用", notes = "预审费用")
   private BigDecimal cost;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态", notes = "审核状态")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "attachmentIds", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;

   public CrmPrequalificationRecordSaveParam(
      final LocalDate deadlineForAcceptanceTime,
      final String address,
      final String email,
      final BigDecimal cost,
      final Integer crmCheckStatusEnum,
      final List<AttachmentDTO> attachmentIds,
      final String remark,
      final Long crmProjectInformationWarehousingId
   ) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.address = address;
      this.email = email;
      this.cost = cost;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public CrmPrequalificationRecordSaveParam() {
   }

   public LocalDate getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public String getAddress() {
      return this.address;
   }

   public String getEmail() {
      return this.email;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public void setDeadlineForAcceptanceTime(final LocalDate deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setCost(final BigDecimal cost) {
      this.cost = cost;
   }

   public void setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
   }

   public void setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPrequalificationRecordSaveParam)) {
         return false;
      }

      CrmPrequalificationRecordSaveParam other = (CrmPrequalificationRecordSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
      if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
         Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
         Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
         if (this$crmProjectInformationWarehousingId == null
            ? other$crmProjectInformationWarehousingId == null
            : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
            Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
            Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
            if (this$deadlineForAcceptanceTime == null
               ? other$deadlineForAcceptanceTime == null
               : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)) {
               Object this$address = this.getAddress();
               Object other$address = other.getAddress();
               if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                  Object this$email = this.getEmail();
                  Object other$email = other.getEmail();
                  if (this$email == null ? other$email == null : this$email.equals(other$email)) {
                     Object this$cost = this.getCost();
                     Object other$cost = other.getCost();
                     if (this$cost == null ? other$cost == null : this$cost.equals(other$cost)) {
                        Object this$attachmentIds = this.getAttachmentIds();
                        Object other$attachmentIds = other.getAttachmentIds();
                        if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof CrmPrequalificationRecordSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $cost = this.getCost();
      result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CrmPrequalificationRecordSaveParam(deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", address="
         + this.getAddress()
         + ", email="
         + this.getEmail()
         + ", cost="
         + this.getCost()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ")";
   }
}
