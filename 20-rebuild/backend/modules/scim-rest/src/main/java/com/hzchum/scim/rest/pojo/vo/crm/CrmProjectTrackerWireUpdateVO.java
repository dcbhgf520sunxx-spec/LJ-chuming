package com.hzchum.scim.rest.pojo.vo.crm;

import io.swagger.annotations.ApiModelProperty;

public class CrmProjectTrackerWireUpdateVO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "position", value = "职务", notes = "职务")
   private String position;
   @ApiModelProperty(name = "phone", value = "电话", notes = "电话")
   private String phone;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "unitClassConfigurationId", value = "单位类型 CrmBasicsConfig", notes = "单位类型 CrmBasicsConfig")
   private Long unitClassConfigurationId;

   public CrmProjectTrackerWireUpdateVO(
      final Long id,
      final Long crmEnterpriseWarehousingId,
      final String name,
      final String position,
      final String phone,
      final Long crmProjectInformationWarehousingId,
      final Long unitClassConfigurationId
   ) {
      this.id = id;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.name = name;
      this.position = position;
      this.phone = phone;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.unitClassConfigurationId = unitClassConfigurationId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public String getName() {
      return this.name;
   }

   public String getPosition() {
      return this.position;
   }

   public String getPhone() {
      return this.phone;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Long getUnitClassConfigurationId() {
      return this.unitClassConfigurationId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPosition(final String position) {
      this.position = position;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectTrackerWireUpdateVO)) {
         return false;
      }

      CrmProjectTrackerWireUpdateVO other = (CrmProjectTrackerWireUpdateVO)o;
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
            Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
            Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
            if (this$crmProjectInformationWarehousingId == null
               ? other$crmProjectInformationWarehousingId == null
               : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
               Object this$unitClassConfigurationId = this.getUnitClassConfigurationId();
               Object other$unitClassConfigurationId = other.getUnitClassConfigurationId();
               if (this$unitClassConfigurationId == null
                  ? other$unitClassConfigurationId == null
                  : this$unitClassConfigurationId.equals(other$unitClassConfigurationId)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$position = this.getPosition();
                     Object other$position = other.getPosition();
                     if (this$position == null ? other$position == null : this$position.equals(other$position)) {
                        Object this$phone = this.getPhone();
                        Object other$phone = other.getPhone();
                        return this$phone == null ? other$phone == null : this$phone.equals(other$phone);
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
      return other instanceof CrmProjectTrackerWireUpdateVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $unitClassConfigurationId = this.getUnitClassConfigurationId();
      result = result * 59 + ($unitClassConfigurationId == null ? 43 : $unitClassConfigurationId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $position = this.getPosition();
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $phone = this.getPhone();
      return result * 59 + ($phone == null ? 43 : $phone.hashCode());
   }

   @Override
   public String toString() {
      return "CrmProjectTrackerWireUpdateVO(id="
         + this.getId()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", name="
         + this.getName()
         + ", position="
         + this.getPosition()
         + ", phone="
         + this.getPhone()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", unitClassConfigurationId="
         + this.getUnitClassConfigurationId()
         + ")";
   }

   public CrmProjectTrackerWireUpdateVO() {
   }
}
