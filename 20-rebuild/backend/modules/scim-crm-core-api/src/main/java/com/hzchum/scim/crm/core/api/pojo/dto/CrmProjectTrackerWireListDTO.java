package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmProjectTrackerWireListDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", notes = "企业名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "position", value = "职务", notes = "职务")
   private String position;
   @ApiModelProperty(name = "phone", value = "电话", notes = "电话")
   private String phone;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目备案名称", notes = "项目备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "unitClassConfigurationId", value = "单位类别 CrmBasicsConfig", notes = "单位类别 CrmBasicsConfig")
   private Long unitClassConfigurationId;
   @ApiModelProperty(name = "unitClassConfigurationName", value = "单位性质Name  参考crm_basics_config", notes = "单位性质Name  参考crm_basics_config")
   private String unitClassConfigurationName;

   public CrmProjectTrackerWireListDTO(
      final Long id,
      final Long crmEnterpriseWarehousingId,
      final String crmEnterpriseWarehousingName,
      final String name,
      final String position,
      final String phone,
      final Long crmProjectInformationWarehousingId,
      final String crmProjectInformationWarehousingName,
      final Long unitClassConfigurationId,
      final String unitClassConfigurationName
   ) {
      this.id = id;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.name = name;
      this.position = position;
      this.phone = phone;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.unitClassConfigurationId = unitClassConfigurationId;
      this.unitClassConfigurationName = unitClassConfigurationName;
   }

   public CrmProjectTrackerWireListDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
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

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public Long getUnitClassConfigurationId() {
      return this.unitClassConfigurationId;
   }

   public String getUnitClassConfigurationName() {
      return this.unitClassConfigurationName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
   }

   public void setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
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

   public void setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
   }

   public void setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
   }

   public void setUnitClassConfigurationName(final String unitClassConfigurationName) {
      this.unitClassConfigurationName = unitClassConfigurationName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectTrackerWireListDTO)) {
         return false;
      }

      CrmProjectTrackerWireListDTO other = (CrmProjectTrackerWireListDTO)o;
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
                  Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                  Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                  if (this$crmEnterpriseWarehousingName == null
                     ? other$crmEnterpriseWarehousingName == null
                     : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$position = this.getPosition();
                        Object other$position = other.getPosition();
                        if (this$position == null ? other$position == null : this$position.equals(other$position)) {
                           Object this$phone = this.getPhone();
                           Object other$phone = other.getPhone();
                           if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                              Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                              Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                              if (this$crmProjectInformationWarehousingName == null
                                 ? other$crmProjectInformationWarehousingName == null
                                 : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
                                 Object this$unitClassConfigurationName = this.getUnitClassConfigurationName();
                                 Object other$unitClassConfigurationName = other.getUnitClassConfigurationName();
                                 return this$unitClassConfigurationName == null
                                    ? other$unitClassConfigurationName == null
                                    : this$unitClassConfigurationName.equals(other$unitClassConfigurationName);
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
      return other instanceof CrmProjectTrackerWireListDTO;
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
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $position = this.getPosition();
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $unitClassConfigurationName = this.getUnitClassConfigurationName();
      return result * 59 + ($unitClassConfigurationName == null ? 43 : $unitClassConfigurationName.hashCode());
   }

   @Override
   public String toString() {
      return "CrmProjectTrackerWireListDTO(id="
         + this.getId()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", name="
         + this.getName()
         + ", position="
         + this.getPosition()
         + ", phone="
         + this.getPhone()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", unitClassConfigurationId="
         + this.getUnitClassConfigurationId()
         + ", unitClassConfigurationName="
         + this.getUnitClassConfigurationName()
         + ")";
   }
}
