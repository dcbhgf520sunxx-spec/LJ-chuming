package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysRoleLookPermissionConfig对象", description = "")
@Entity
@TableName("sys_role_look_permission_config")
@Table(name = "sys_role_look_permission_config")
@org.hibernate.annotations.Table(appliesTo = "sys_role_look_permission_config")
public class SysRoleLookPermissionConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "sysRoleId", value = "对应角色", notes = "对应角色")
   @TableField("sys_role_id")
   @Column(name = "sys_role_id", columnDefinition = "bigint(20)  COMMENT '对应角色'", nullable = false)
   private Long sysRoleId;
   @ApiModelProperty(name = "isFullPermissions", value = "是否拥有全部权限", notes = "是否拥有全部权限")
   @TableField("is_full_permissions")
   @Column(name = "is_full_permissions", columnDefinition = "tinyint(1)  COMMENT '是否拥有全部权限'", nullable = false)
   private Boolean isFullPermissions;
   @ApiModelProperty(name = "isThisDepartment", value = "是否可查看本部门", notes = "是否可查看本部门")
   @TableField("is_this_department")
   @Column(name = "is_this_department", columnDefinition = "tinyint(1)  COMMENT '是否可查看本部门'", nullable = false)
   private Boolean isThisDepartment;
   @ApiModelProperty(name = "isThisDepartmentAndSubordinateDepartments", value = "是否可查看下自己部门以及下属部门", notes = "是否可查看下自己部门以及下属部门")
   @TableField("is_this_department_and_subordinate_departments")
   @Column(name = "is_this_department_and_subordinate_departments", columnDefinition = "tinyint(1)  COMMENT '是否可查看下自己部门以及下属部门'", nullable = false)
   private Boolean isThisDepartmentAndSubordinateDepartments;
   @ApiModelProperty(name = "isIndividual", value = "是否只可查看自己", notes = "是否只可查看自己")
   @TableField("is_individual")
   @Column(name = "is_individual", columnDefinition = "tinyint(1)  COMMENT '是否只可查看自己'", nullable = false)
   private Boolean isIndividual;
   @ApiModelProperty(name = "departmentIds", value = "可查看的部门ids", notes = "可查看的部门ids")
   @TableField("department_ids")
   @Column(name = "department_ids", columnDefinition = "varchar(2048)  COMMENT '可查看的部门ids'", nullable = true)
   private String departmentIds;
   @ApiModelProperty(name = "sysModuleTypeEnum", value = "模块类型（参考枚举SysModuleTypeEnum）", notes = "模块类型（参考枚举SysModuleTypeEnum）")
   @TableField("sys_module_type_enum")
   @Column(name = "sys_module_type_enum", columnDefinition = "int(11)  COMMENT '模块类型（参考枚举SysModuleTypeEnum）'", nullable = false)
   private Integer sysModuleTypeEnum;
   @ApiModelProperty(name = "isIndividualAndThisDept", value = "自己和自己当前部门的数据", notes = "自己和自己当前部门的数据")
   @TableField("is_individual_and_this_dept")
   @Column(name = "is_individual_and_this_dept", columnDefinition = "tinyint(1)  COMMENT '自己和自己当前部门的数据'", nullable = false)
   private Boolean isIndividualAndThisDept;

   public static SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder builder() {
      return new SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder();
   }

   public SysRoleLookPermissionConfig() {
   }

   public SysRoleLookPermissionConfig(
      final Long id,
      final Long sysRoleId,
      final Boolean isFullPermissions,
      final Boolean isThisDepartment,
      final Boolean isThisDepartmentAndSubordinateDepartments,
      final Boolean isIndividual,
      final String departmentIds,
      final Integer sysModuleTypeEnum,
      final Boolean isIndividualAndThisDept
   ) {
      this.id = id;
      this.sysRoleId = sysRoleId;
      this.isFullPermissions = isFullPermissions;
      this.isThisDepartment = isThisDepartment;
      this.isThisDepartmentAndSubordinateDepartments = isThisDepartmentAndSubordinateDepartments;
      this.isIndividual = isIndividual;
      this.departmentIds = departmentIds;
      this.sysModuleTypeEnum = sysModuleTypeEnum;
      this.isIndividualAndThisDept = isIndividualAndThisDept;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSysRoleId() {
      return this.sysRoleId;
   }

   public Boolean getIsFullPermissions() {
      return this.isFullPermissions;
   }

   public Boolean getIsThisDepartment() {
      return this.isThisDepartment;
   }

   public Boolean getIsThisDepartmentAndSubordinateDepartments() {
      return this.isThisDepartmentAndSubordinateDepartments;
   }

   public Boolean getIsIndividual() {
      return this.isIndividual;
   }

   public String getDepartmentIds() {
      return this.departmentIds;
   }

   public Integer getSysModuleTypeEnum() {
      return this.sysModuleTypeEnum;
   }

   public Boolean getIsIndividualAndThisDept() {
      return this.isIndividualAndThisDept;
   }

   public SysRoleLookPermissionConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysRoleLookPermissionConfig setSysRoleId(final Long sysRoleId) {
      this.sysRoleId = sysRoleId;
      return this;
   }

   public SysRoleLookPermissionConfig setIsFullPermissions(final Boolean isFullPermissions) {
      this.isFullPermissions = isFullPermissions;
      return this;
   }

   public SysRoleLookPermissionConfig setIsThisDepartment(final Boolean isThisDepartment) {
      this.isThisDepartment = isThisDepartment;
      return this;
   }

   public SysRoleLookPermissionConfig setIsThisDepartmentAndSubordinateDepartments(final Boolean isThisDepartmentAndSubordinateDepartments) {
      this.isThisDepartmentAndSubordinateDepartments = isThisDepartmentAndSubordinateDepartments;
      return this;
   }

   public SysRoleLookPermissionConfig setIsIndividual(final Boolean isIndividual) {
      this.isIndividual = isIndividual;
      return this;
   }

   public SysRoleLookPermissionConfig setDepartmentIds(final String departmentIds) {
      this.departmentIds = departmentIds;
      return this;
   }

   public SysRoleLookPermissionConfig setSysModuleTypeEnum(final Integer sysModuleTypeEnum) {
      this.sysModuleTypeEnum = sysModuleTypeEnum;
      return this;
   }

   public SysRoleLookPermissionConfig setIsIndividualAndThisDept(final Boolean isIndividualAndThisDept) {
      this.isIndividualAndThisDept = isIndividualAndThisDept;
      return this;
   }

   @Override
   public String toString() {
      return "SysRoleLookPermissionConfig(id="
         + this.getId()
         + ", sysRoleId="
         + this.getSysRoleId()
         + ", isFullPermissions="
         + this.getIsFullPermissions()
         + ", isThisDepartment="
         + this.getIsThisDepartment()
         + ", isThisDepartmentAndSubordinateDepartments="
         + this.getIsThisDepartmentAndSubordinateDepartments()
         + ", isIndividual="
         + this.getIsIndividual()
         + ", departmentIds="
         + this.getDepartmentIds()
         + ", sysModuleTypeEnum="
         + this.getSysModuleTypeEnum()
         + ", isIndividualAndThisDept="
         + this.getIsIndividualAndThisDept()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysRoleLookPermissionConfig)) {
         return false;
      }

      SysRoleLookPermissionConfig other = (SysRoleLookPermissionConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sysRoleId = this.getSysRoleId();
         Object other$sysRoleId = other.getSysRoleId();
         if (this$sysRoleId == null ? other$sysRoleId == null : this$sysRoleId.equals(other$sysRoleId)) {
            Object this$isFullPermissions = this.getIsFullPermissions();
            Object other$isFullPermissions = other.getIsFullPermissions();
            if (this$isFullPermissions == null ? other$isFullPermissions == null : this$isFullPermissions.equals(other$isFullPermissions)) {
               Object this$isThisDepartment = this.getIsThisDepartment();
               Object other$isThisDepartment = other.getIsThisDepartment();
               if (this$isThisDepartment == null ? other$isThisDepartment == null : this$isThisDepartment.equals(other$isThisDepartment)) {
                  Object this$isThisDepartmentAndSubordinateDepartments = this.getIsThisDepartmentAndSubordinateDepartments();
                  Object other$isThisDepartmentAndSubordinateDepartments = other.getIsThisDepartmentAndSubordinateDepartments();
                  if (this$isThisDepartmentAndSubordinateDepartments == null
                     ? other$isThisDepartmentAndSubordinateDepartments == null
                     : this$isThisDepartmentAndSubordinateDepartments.equals(other$isThisDepartmentAndSubordinateDepartments)) {
                     Object this$isIndividual = this.getIsIndividual();
                     Object other$isIndividual = other.getIsIndividual();
                     if (this$isIndividual == null ? other$isIndividual == null : this$isIndividual.equals(other$isIndividual)) {
                        Object this$sysModuleTypeEnum = this.getSysModuleTypeEnum();
                        Object other$sysModuleTypeEnum = other.getSysModuleTypeEnum();
                        if (this$sysModuleTypeEnum == null ? other$sysModuleTypeEnum == null : this$sysModuleTypeEnum.equals(other$sysModuleTypeEnum)) {
                           Object this$isIndividualAndThisDept = this.getIsIndividualAndThisDept();
                           Object other$isIndividualAndThisDept = other.getIsIndividualAndThisDept();
                           if (this$isIndividualAndThisDept == null
                              ? other$isIndividualAndThisDept == null
                              : this$isIndividualAndThisDept.equals(other$isIndividualAndThisDept)) {
                              Object this$departmentIds = this.getDepartmentIds();
                              Object other$departmentIds = other.getDepartmentIds();
                              return this$departmentIds == null ? other$departmentIds == null : this$departmentIds.equals(other$departmentIds);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysRoleLookPermissionConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sysRoleId = this.getSysRoleId();
      result = result * 59 + ($sysRoleId == null ? 43 : $sysRoleId.hashCode());
      Object $isFullPermissions = this.getIsFullPermissions();
      result = result * 59 + ($isFullPermissions == null ? 43 : $isFullPermissions.hashCode());
      Object $isThisDepartment = this.getIsThisDepartment();
      result = result * 59 + ($isThisDepartment == null ? 43 : $isThisDepartment.hashCode());
      Object $isThisDepartmentAndSubordinateDepartments = this.getIsThisDepartmentAndSubordinateDepartments();
      result = result * 59 + ($isThisDepartmentAndSubordinateDepartments == null ? 43 : $isThisDepartmentAndSubordinateDepartments.hashCode());
      Object $isIndividual = this.getIsIndividual();
      result = result * 59 + ($isIndividual == null ? 43 : $isIndividual.hashCode());
      Object $sysModuleTypeEnum = this.getSysModuleTypeEnum();
      result = result * 59 + ($sysModuleTypeEnum == null ? 43 : $sysModuleTypeEnum.hashCode());
      Object $isIndividualAndThisDept = this.getIsIndividualAndThisDept();
      result = result * 59 + ($isIndividualAndThisDept == null ? 43 : $isIndividualAndThisDept.hashCode());
      Object $departmentIds = this.getDepartmentIds();
      return result * 59 + ($departmentIds == null ? 43 : $departmentIds.hashCode());
   }

   public static class SysRoleLookPermissionConfigBuilder {
      private Long id;
      private Long sysRoleId;
      private Boolean isFullPermissions;
      private Boolean isThisDepartment;
      private Boolean isThisDepartmentAndSubordinateDepartments;
      private Boolean isIndividual;
      private String departmentIds;
      private Integer sysModuleTypeEnum;
      private Boolean isIndividualAndThisDept;

      SysRoleLookPermissionConfigBuilder() {
      }

      public SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder sysRoleId(final Long sysRoleId) {
         this.sysRoleId = sysRoleId;
         return this;
      }

      public SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder isFullPermissions(final Boolean isFullPermissions) {
         this.isFullPermissions = isFullPermissions;
         return this;
      }

      public SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder isThisDepartment(final Boolean isThisDepartment) {
         this.isThisDepartment = isThisDepartment;
         return this;
      }

      public SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder isThisDepartmentAndSubordinateDepartments(
         final Boolean isThisDepartmentAndSubordinateDepartments
      ) {
         this.isThisDepartmentAndSubordinateDepartments = isThisDepartmentAndSubordinateDepartments;
         return this;
      }

      public SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder isIndividual(final Boolean isIndividual) {
         this.isIndividual = isIndividual;
         return this;
      }

      public SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder departmentIds(final String departmentIds) {
         this.departmentIds = departmentIds;
         return this;
      }

      public SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder sysModuleTypeEnum(final Integer sysModuleTypeEnum) {
         this.sysModuleTypeEnum = sysModuleTypeEnum;
         return this;
      }

      public SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder isIndividualAndThisDept(final Boolean isIndividualAndThisDept) {
         this.isIndividualAndThisDept = isIndividualAndThisDept;
         return this;
      }

      public SysRoleLookPermissionConfig build() {
         return new SysRoleLookPermissionConfig(
            this.id,
            this.sysRoleId,
            this.isFullPermissions,
            this.isThisDepartment,
            this.isThisDepartmentAndSubordinateDepartments,
            this.isIndividual,
            this.departmentIds,
            this.sysModuleTypeEnum,
            this.isIndividualAndThisDept
         );
      }

      @Override
      public String toString() {
         return "SysRoleLookPermissionConfig.SysRoleLookPermissionConfigBuilder(id="
            + this.id
            + ", sysRoleId="
            + this.sysRoleId
            + ", isFullPermissions="
            + this.isFullPermissions
            + ", isThisDepartment="
            + this.isThisDepartment
            + ", isThisDepartmentAndSubordinateDepartments="
            + this.isThisDepartmentAndSubordinateDepartments
            + ", isIndividual="
            + this.isIndividual
            + ", departmentIds="
            + this.departmentIds
            + ", sysModuleTypeEnum="
            + this.sysModuleTypeEnum
            + ", isIndividualAndThisDept="
            + this.isIndividualAndThisDept
            + ")";
      }
   }
}
