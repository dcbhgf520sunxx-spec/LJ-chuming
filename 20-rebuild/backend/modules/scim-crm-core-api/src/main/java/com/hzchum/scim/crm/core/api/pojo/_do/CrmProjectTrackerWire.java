package com.hzchum.scim.crm.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CrmProjectTrackerWire对象", description = "")
@Entity
@TableName("crm_project_tracker_wire")
@Table(name = "crm_project_tracker_wire")
@org.hibernate.annotations.Table(appliesTo = "crm_project_tracker_wire")
public class CrmProjectTrackerWire extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   @TableField("crm_enterprise_warehousing_id")
   @Column(name = "crm_enterprise_warehousing_id", columnDefinition = "bigint(20)  COMMENT '企业备案id'", nullable = true)
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "position", value = "职务", notes = "职务")
   @TableField("position")
   @Column(name = "position", columnDefinition = "varchar(64)  COMMENT '职务'", nullable = true)
   private String position;
   @ApiModelProperty(name = "phone", value = "电话", notes = "电话")
   @TableField("phone")
   @Column(name = "phone", columnDefinition = "varchar(64)  COMMENT '电话'", nullable = true)
   private String phone;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "企业备案id", notes = "企业备案id")
   @TableField("crm_project_information_warehousing_id")
   @Column(name = "crm_project_information_warehousing_id", columnDefinition = "bigint(20)  COMMENT '企业备案id'", nullable = true)
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "unitClassConfigurationId", value = "单位类别 CrmBasicsConfig", notes = "单位类别 CrmBasicsConfig")
   @TableField("unit_class_configuration_id")
   @Column(name = "unit_class_configuration_id", columnDefinition = "bigint(20)  COMMENT '单位类别 CrmBasicsConfig'", nullable = true)
   private Long unitClassConfigurationId;

   public static CrmProjectTrackerWire.CrmProjectTrackerWireBuilder builder() {
      return new CrmProjectTrackerWire.CrmProjectTrackerWireBuilder();
   }

   public CrmProjectTrackerWire() {
   }

   public CrmProjectTrackerWire(
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

   public CrmProjectTrackerWire setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectTrackerWire setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   public CrmProjectTrackerWire setName(final String name) {
      this.name = name;
      return this;
   }

   public CrmProjectTrackerWire setPosition(final String position) {
      this.position = position;
      return this;
   }

   public CrmProjectTrackerWire setPhone(final String phone) {
      this.phone = phone;
      return this;
   }

   public CrmProjectTrackerWire setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmProjectTrackerWire setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectTrackerWire(id="
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectTrackerWire)) {
         return false;
      }

      CrmProjectTrackerWire other = (CrmProjectTrackerWire)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectTrackerWire;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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

   public static class CrmProjectTrackerWireBuilder {
      private Long id;
      private Long crmEnterpriseWarehousingId;
      private String name;
      private String position;
      private String phone;
      private Long crmProjectInformationWarehousingId;
      private Long unitClassConfigurationId;

      CrmProjectTrackerWireBuilder() {
      }

      public CrmProjectTrackerWire.CrmProjectTrackerWireBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectTrackerWire.CrmProjectTrackerWireBuilder crmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmProjectTrackerWire.CrmProjectTrackerWireBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CrmProjectTrackerWire.CrmProjectTrackerWireBuilder position(final String position) {
         this.position = position;
         return this;
      }

      public CrmProjectTrackerWire.CrmProjectTrackerWireBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public CrmProjectTrackerWire.CrmProjectTrackerWireBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmProjectTrackerWire.CrmProjectTrackerWireBuilder unitClassConfigurationId(final Long unitClassConfigurationId) {
         this.unitClassConfigurationId = unitClassConfigurationId;
         return this;
      }

      public CrmProjectTrackerWire build() {
         return new CrmProjectTrackerWire(
            this.id,
            this.crmEnterpriseWarehousingId,
            this.name,
            this.position,
            this.phone,
            this.crmProjectInformationWarehousingId,
            this.unitClassConfigurationId
         );
      }

      @Override
      public String toString() {
         return "CrmProjectTrackerWire.CrmProjectTrackerWireBuilder(id="
            + this.id
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ", name="
            + this.name
            + ", position="
            + this.position
            + ", phone="
            + this.phone
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", unitClassConfigurationId="
            + this.unitClassConfigurationId
            + ")";
      }
   }
}
