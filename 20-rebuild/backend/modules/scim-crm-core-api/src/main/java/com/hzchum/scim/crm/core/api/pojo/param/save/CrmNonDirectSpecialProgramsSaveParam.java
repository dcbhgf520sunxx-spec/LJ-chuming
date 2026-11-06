package com.hzchum.scim.crm.core.api.pojo.param.save;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CrmNonDirectSpecialProgramsSaveParam {
   @ApiModelProperty(name = "crmSpecialBubmissionStatusEnum", notes = "专项方案提报类型")
   private Integer crmSpecialBubmissionStatusEnum;
   @ApiModelProperty(name = "projectName", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", notes = "招标单位")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;

   public CrmNonDirectSpecialProgramsSaveParam(
      final Integer crmSpecialBubmissionStatusEnum,
      final String projectName,
      final Long crmEnterpriseWarehousingId,
      final List<Long> regionList,
      final String address
   ) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      this.projectName = projectName;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.regionList = regionList;
      this.address = address;
   }

   public CrmNonDirectSpecialProgramsSaveParam() {
   }

   public Integer getCrmSpecialBubmissionStatusEnum() {
      return this.crmSpecialBubmissionStatusEnum;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public List<Long> getRegionList() {
      return this.regionList;
   }

   public String getAddress() {
      return this.address;
   }

   public void setCrmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
   }

   public void setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmNonDirectSpecialProgramsSaveParam)) {
         return false;
      }

      CrmNonDirectSpecialProgramsSaveParam other = (CrmNonDirectSpecialProgramsSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      Object other$crmSpecialBubmissionStatusEnum = other.getCrmSpecialBubmissionStatusEnum();
      if (this$crmSpecialBubmissionStatusEnum == null
         ? other$crmSpecialBubmissionStatusEnum == null
         : this$crmSpecialBubmissionStatusEnum.equals(other$crmSpecialBubmissionStatusEnum)) {
         Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
         Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
         if (this$crmEnterpriseWarehousingId == null
            ? other$crmEnterpriseWarehousingId == null
            : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$regionList = this.getRegionList();
               Object other$regionList = other.getRegionList();
               if (this$regionList == null ? other$regionList == null : this$regionList.equals(other$regionList)) {
                  Object this$address = this.getAddress();
                  Object other$address = other.getAddress();
                  return this$address == null ? other$address == null : this$address.equals(other$address);
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
      return other instanceof CrmNonDirectSpecialProgramsSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      result = result * 59 + ($crmSpecialBubmissionStatusEnum == null ? 43 : $crmSpecialBubmissionStatusEnum.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $regionList = this.getRegionList();
      result = result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
      Object $address = this.getAddress();
      return result * 59 + ($address == null ? 43 : $address.hashCode());
   }

   @Override
   public String toString() {
      return "CrmNonDirectSpecialProgramsSaveParam(crmSpecialBubmissionStatusEnum="
         + this.getCrmSpecialBubmissionStatusEnum()
         + ", projectName="
         + this.getProjectName()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", regionList="
         + this.getRegionList()
         + ", address="
         + this.getAddress()
         + ")";
   }
}
