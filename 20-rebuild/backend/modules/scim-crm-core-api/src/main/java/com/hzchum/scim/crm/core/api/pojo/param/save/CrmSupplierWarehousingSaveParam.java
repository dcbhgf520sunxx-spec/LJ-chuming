package com.hzchum.scim.crm.core.api.pojo.param.save;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmSupplierWarehousingSaveParam {
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   private Long informantUserId;
   @ApiModelProperty(name = "departmentId", value = "所属部门", notes = "所属部门")
   private Long departmentId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "attachmentIds", value = "入库附件", notes = "入库附件")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "acceptanceAddress", value = "受理地址", notes = "受理地址")
   private String acceptanceAddress;
   @ApiModelProperty(name = "cost", value = "费用", notes = "费用")
   private BigDecimal cost;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;

   public CrmSupplierWarehousingSaveParam(
      final Long informantUserId,
      final Long departmentId,
      final LocalDateTime informantDateTime,
      final List<AttachmentDTO> attachmentIds,
      final LocalDateTime deadlineForAcceptanceTime,
      final String acceptanceAddress,
      final BigDecimal cost,
      final String remark,
      final Long crmEnterpriseWarehousingId
   ) {
      this.informantUserId = informantUserId;
      this.departmentId = departmentId;
      this.informantDateTime = informantDateTime;
      this.attachmentIds = attachmentIds;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.acceptanceAddress = acceptanceAddress;
      this.cost = cost;
      this.remark = remark;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
   }

   public CrmSupplierWarehousingSaveParam() {
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
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

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public void setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
   }

   public void setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
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

   public void setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmSupplierWarehousingSaveParam)) {
         return false;
      }

      CrmSupplierWarehousingSaveParam other = (CrmSupplierWarehousingSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$informantUserId = this.getInformantUserId();
      Object other$informantUserId = other.getInformantUserId();
      if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
         Object this$departmentId = this.getDepartmentId();
         Object other$departmentId = other.getDepartmentId();
         if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
            Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
            Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
            if (this$crmEnterpriseWarehousingId == null
               ? other$crmEnterpriseWarehousingId == null
               : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
               Object this$informantDateTime = this.getInformantDateTime();
               Object other$informantDateTime = other.getInformantDateTime();
               if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmSupplierWarehousingSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $acceptanceAddress = this.getAcceptanceAddress();
      result = result * 59 + ($acceptanceAddress == null ? 43 : $acceptanceAddress.hashCode());
      Object $cost = this.getCost();
      result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CrmSupplierWarehousingSaveParam(informantUserId="
         + this.getInformantUserId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", informantDateTime="
         + this.getInformantDateTime()
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
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ")";
   }
}
