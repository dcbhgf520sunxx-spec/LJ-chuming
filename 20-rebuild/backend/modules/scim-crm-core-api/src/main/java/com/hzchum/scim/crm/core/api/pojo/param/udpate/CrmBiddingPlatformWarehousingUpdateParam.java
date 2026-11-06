package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmBiddingPlatformWarehousingUpdateParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   private Long informantUserId;
   @ApiModelProperty(name = "departmentId", value = "部门id", notes = "部门id")
   private Long departmentId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "biddingPlatformName", value = "招标平台名称", notes = "招标平台名称")
   private String biddingPlatformName;
   @ApiModelProperty(name = "reasonForRegistration", value = "报名事由", notes = "报名事由")
   private String reasonForRegistration;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "地区id", notes = "地区id")
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   private String regionName;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "attachmentIds", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "acceptanceAddress", value = "受理地址", notes = "受理地址")
   private String acceptanceAddress;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "cost", value = "费用", notes = "费用")
   private BigDecimal cost;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;

   public CrmBiddingPlatformWarehousingUpdateParam(
      final Long id,
      final Long crmEnterpriseWarehousingId,
      final Long informantUserId,
      final Long departmentId,
      final LocalDateTime informantDateTime,
      final String biddingPlatformName,
      final String reasonForRegistration,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String address,
      final List<AttachmentDTO> attachmentIds,
      final String acceptanceAddress,
      final LocalDateTime deadlineForAcceptanceTime,
      final BigDecimal cost,
      final String remark,
      final Integer crmCheckStatusEnum,
      final List<Long> regionList,
      final Long crmProjectInformationWarehousingId
   ) {
      this.id = id;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.informantUserId = informantUserId;
      this.departmentId = departmentId;
      this.informantDateTime = informantDateTime;
      this.biddingPlatformName = biddingPlatformName;
      this.reasonForRegistration = reasonForRegistration;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.address = address;
      this.attachmentIds = attachmentIds;
      this.acceptanceAddress = acceptanceAddress;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.cost = cost;
      this.remark = remark;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.regionList = regionList;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public CrmBiddingPlatformWarehousingUpdateParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
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

   public String getBiddingPlatformName() {
      return this.biddingPlatformName;
   }

   public String getReasonForRegistration() {
      return this.reasonForRegistration;
   }

   public String getCityName() {
      return this.cityName;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getAddress() {
      return this.address;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getAcceptanceAddress() {
      return this.acceptanceAddress;
   }

   public LocalDateTime getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public List<Long> getRegionList() {
      return this.regionList;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
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

   public void setBiddingPlatformName(final String biddingPlatformName) {
      this.biddingPlatformName = biddingPlatformName;
   }

   public void setReasonForRegistration(final String reasonForRegistration) {
      this.reasonForRegistration = reasonForRegistration;
   }

   public void setCityName(final String cityName) {
      this.cityName = cityName;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
   }

   public void setRegionName(final String regionName) {
      this.regionName = regionName;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAcceptanceAddress(final String acceptanceAddress) {
      this.acceptanceAddress = acceptanceAddress;
   }

   public void setDeadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
   }

   public void setCost(final BigDecimal cost) {
      this.cost = cost;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
   }

   public void setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBiddingPlatformWarehousingUpdateParam)) {
         return false;
      }

      CrmBiddingPlatformWarehousingUpdateParam other = (CrmBiddingPlatformWarehousingUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
         Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
         if (this$crmEnterpriseWarehousingId == null
            ? other$crmEnterpriseWarehousingId == null
            : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
            Object this$informantUserId = this.getInformantUserId();
            Object other$informantUserId = other.getInformantUserId();
            if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
               Object this$departmentId = this.getDepartmentId();
               Object other$departmentId = other.getDepartmentId();
               if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
                  Object this$regionId = this.getRegionId();
                  Object other$regionId = other.getRegionId();
                  if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                     Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
                     Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
                     if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                        Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
                        Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
                        if (this$crmProjectInformationWarehousingId == null
                           ? other$crmProjectInformationWarehousingId == null
                           : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
                           Object this$informantDateTime = this.getInformantDateTime();
                           Object other$informantDateTime = other.getInformantDateTime();
                           if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
                              Object this$biddingPlatformName = this.getBiddingPlatformName();
                              Object other$biddingPlatformName = other.getBiddingPlatformName();
                              if (this$biddingPlatformName == null
                                 ? other$biddingPlatformName == null
                                 : this$biddingPlatformName.equals(other$biddingPlatformName)) {
                                 Object this$reasonForRegistration = this.getReasonForRegistration();
                                 Object other$reasonForRegistration = other.getReasonForRegistration();
                                 if (this$reasonForRegistration == null
                                    ? other$reasonForRegistration == null
                                    : this$reasonForRegistration.equals(other$reasonForRegistration)) {
                                    Object this$cityName = this.getCityName();
                                    Object other$cityName = other.getCityName();
                                    if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                                       Object this$regionName = this.getRegionName();
                                       Object other$regionName = other.getRegionName();
                                       if (this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName)) {
                                          Object this$address = this.getAddress();
                                          Object other$address = other.getAddress();
                                          if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                             Object this$attachmentIds = this.getAttachmentIds();
                                             Object other$attachmentIds = other.getAttachmentIds();
                                             if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                                Object this$acceptanceAddress = this.getAcceptanceAddress();
                                                Object other$acceptanceAddress = other.getAcceptanceAddress();
                                                if (this$acceptanceAddress == null
                                                   ? other$acceptanceAddress == null
                                                   : this$acceptanceAddress.equals(other$acceptanceAddress)) {
                                                   Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
                                                   Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
                                                   if (this$deadlineForAcceptanceTime == null
                                                      ? other$deadlineForAcceptanceTime == null
                                                      : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)) {
                                                      Object this$cost = this.getCost();
                                                      Object other$cost = other.getCost();
                                                      if (this$cost == null ? other$cost == null : this$cost.equals(other$cost)) {
                                                         Object this$remark = this.getRemark();
                                                         Object other$remark = other.getRemark();
                                                         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                            Object this$regionList = this.getRegionList();
                                                            Object other$regionList = other.getRegionList();
                                                            return this$regionList == null
                                                               ? other$regionList == null
                                                               : this$regionList.equals(other$regionList);
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
      return other instanceof CrmBiddingPlatformWarehousingUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $biddingPlatformName = this.getBiddingPlatformName();
      result = result * 59 + ($biddingPlatformName == null ? 43 : $biddingPlatformName.hashCode());
      Object $reasonForRegistration = this.getReasonForRegistration();
      result = result * 59 + ($reasonForRegistration == null ? 43 : $reasonForRegistration.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $acceptanceAddress = this.getAcceptanceAddress();
      result = result * 59 + ($acceptanceAddress == null ? 43 : $acceptanceAddress.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $cost = this.getCost();
      result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $regionList = this.getRegionList();
      return result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
   }

   @Override
   public String toString() {
      return "CrmBiddingPlatformWarehousingUpdateParam(id="
         + this.getId()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", biddingPlatformName="
         + this.getBiddingPlatformName()
         + ", reasonForRegistration="
         + this.getReasonForRegistration()
         + ", cityName="
         + this.getCityName()
         + ", regionId="
         + this.getRegionId()
         + ", regionName="
         + this.getRegionName()
         + ", address="
         + this.getAddress()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", acceptanceAddress="
         + this.getAcceptanceAddress()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", cost="
         + this.getCost()
         + ", remark="
         + this.getRemark()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", regionList="
         + this.getRegionList()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ")";
   }
}
