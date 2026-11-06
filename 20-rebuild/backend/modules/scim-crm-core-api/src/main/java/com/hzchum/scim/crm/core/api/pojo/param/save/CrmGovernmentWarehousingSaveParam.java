package com.hzchum.scim.crm.core.api.pojo.param.save;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmGovernmentWarehousingSaveParam {
   @ApiModelProperty(name = "informantUserId", value = "填报人id", notes = "填报人id")
   private Long informantUserId;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "attachmentIds", value = "附件id集合", notes = "附件id集合")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "acceptanceAddress", value = "受理地址", notes = "受理地址")
   private String acceptanceAddress;
   @ApiModelProperty(name = "cost", value = "费用", notes = "费用")
   private BigDecimal cost;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   private Long approveRecordId;
   @ApiModelProperty(name = "serialNumber", value = "备案编号", notes = "备案编号")
   private String serialNumber;

   public CrmGovernmentWarehousingSaveParam(
      final Long informantUserId,
      final Long crmEnterpriseWarehousingId,
      final Long crmProjectInformationWarehousingId,
      final List<AttachmentDTO> attachmentIds,
      final LocalDateTime deadlineForAcceptanceTime,
      final String acceptanceAddress,
      final BigDecimal cost,
      final String remark,
      final Long approveRecordId,
      final String serialNumber
   ) {
      this.informantUserId = informantUserId;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.attachmentIds = attachmentIds;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.acceptanceAddress = acceptanceAddress;
      this.cost = cost;
      this.remark = remark;
      this.approveRecordId = approveRecordId;
      this.serialNumber = serialNumber;
   }

   public CrmGovernmentWarehousingSaveParam() {
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public LocalDateTime getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public String getAcceptanceAddress() {
      return this.acceptanceAddress;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public void setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
   }

   public void setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setDeadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
   }

   public void setAcceptanceAddress(final String acceptanceAddress) {
      this.acceptanceAddress = acceptanceAddress;
   }

   public void setCost(final BigDecimal cost) {
      this.cost = cost;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmGovernmentWarehousingSaveParam)) {
         return false;
      }

      CrmGovernmentWarehousingSaveParam other = (CrmGovernmentWarehousingSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$informantUserId = this.getInformantUserId();
      Object other$informantUserId = other.getInformantUserId();
      if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
         Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
         Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
         if (this$crmEnterpriseWarehousingId == null
            ? other$crmEnterpriseWarehousingId == null
            : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
            Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
            Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
            if (this$crmProjectInformationWarehousingId == null
               ? other$crmProjectInformationWarehousingId == null
               : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
               Object this$approveRecordId = this.getApproveRecordId();
               Object other$approveRecordId = other.getApproveRecordId();
               if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                  Object this$attachmentIds = this.getAttachmentIds();
                  Object other$attachmentIds = other.getAttachmentIds();
                  if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                     Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
                     Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
                     if (this$deadlineForAcceptanceTime == null
                        ? other$deadlineForAcceptanceTime == null
                        : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)) {
                        Object this$acceptanceAddress = this.getAcceptanceAddress();
                        Object other$acceptanceAddress = other.getAcceptanceAddress();
                        if (this$acceptanceAddress == null ? other$acceptanceAddress == null : this$acceptanceAddress.equals(other$acceptanceAddress)) {
                           Object this$cost = this.getCost();
                           Object other$cost = other.getCost();
                           if (this$cost == null ? other$cost == null : this$cost.equals(other$cost)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof CrmGovernmentWarehousingSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $acceptanceAddress = this.getAcceptanceAddress();
      result = result * 59 + ($acceptanceAddress == null ? 43 : $acceptanceAddress.hashCode());
      Object $cost = this.getCost();
      result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CrmGovernmentWarehousingSaveParam(informantUserId="
         + this.getInformantUserId()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", acceptanceAddress="
         + this.getAcceptanceAddress()
         + ", cost="
         + this.getCost()
         + ", remark="
         + this.getRemark()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }
}
