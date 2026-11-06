package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmGovernmentWarehousingUpdateParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "informantUserId", value = "填报人id", notes = "填报人id")
   private Long informantUserId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "attachmentIds", value = "附件id集合", notes = "附件id集合")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "departmentId", value = "部门id", notes = "部门id")
   private Long departmentId;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "acceptanceAddress", value = "受理地址", notes = "受理地址")
   private String acceptanceAddress;
   @ApiModelProperty(name = "cost", value = "费用", notes = "费用")
   private BigDecimal cost;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;

   public CrmGovernmentWarehousingUpdateParam(
      final Long id,
      final Long informantUserId,
      final LocalDateTime informantDateTime,
      final Long crmEnterpriseWarehousingId,
      final Long crmProjectInformationWarehousingId,
      final List<AttachmentDTO> attachmentIds,
      final Long departmentId,
      final LocalDateTime deadlineForAcceptanceTime,
      final String acceptanceAddress,
      final BigDecimal cost,
      final String remark,
      final List<Long> regionList
   ) {
      this.id = id;
      this.informantUserId = informantUserId;
      this.informantDateTime = informantDateTime;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.attachmentIds = attachmentIds;
      this.departmentId = departmentId;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.acceptanceAddress = acceptanceAddress;
      this.cost = cost;
      this.remark = remark;
      this.regionList = regionList;
   }

   public CrmGovernmentWarehousingUpdateParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
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

   public Long getDepartmentId() {
      return this.departmentId;
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

   public List<Long> getRegionList() {
      return this.regionList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
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

   public void setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
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

   public void setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmGovernmentWarehousingUpdateParam)) {
         return false;
      }

      CrmGovernmentWarehousingUpdateParam other = (CrmGovernmentWarehousingUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                  Object this$departmentId = this.getDepartmentId();
                  Object other$departmentId = other.getDepartmentId();
                  if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
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
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$regionList = this.getRegionList();
                                       Object other$regionList = other.getRegionList();
                                       return this$regionList == null ? other$regionList == null : this$regionList.equals(other$regionList);
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
      return other instanceof CrmGovernmentWarehousingUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
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
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $regionList = this.getRegionList();
      return result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
   }

   @Override
   public String toString() {
      return "CrmGovernmentWarehousingUpdateParam(id="
         + this.getId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", departmentId="
         + this.getDepartmentId()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", acceptanceAddress="
         + this.getAcceptanceAddress()
         + ", cost="
         + this.getCost()
         + ", remark="
         + this.getRemark()
         + ", regionList="
         + this.getRegionList()
         + ")";
   }
}
