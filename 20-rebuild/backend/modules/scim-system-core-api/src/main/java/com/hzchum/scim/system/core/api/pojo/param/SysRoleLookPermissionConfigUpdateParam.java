package com.hzchum.scim.system.core.api.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SysRoleLookPermissionConfigUpdateParam {
   @ApiModelProperty(name = "sysRoleId", value = "对应角色", notes = "对应角色")
   private Long sysRoleId;
   @ApiModelProperty(name = "isFullPermissions", value = "是否拥有全部权限", notes = "是否拥有全部权限")
   private Boolean isFullPermissions;
   @ApiModelProperty(name = "isThisDepartment", value = "是否可查看本部门", notes = "是否可查看本部门")
   private Boolean isThisDepartment;
   @ApiModelProperty(name = "isIndividual", value = "是否只可查看自己", notes = "是否只可查看自己")
   private Boolean isIndividual;
   @ApiModelProperty(name = "isIndividualAndThisDept", value = "自己和自己当前部门的数据", notes = "自己和自己当前部门的数据")
   private Boolean isIndividualAndThisDept;
   @ApiModelProperty(name = "isThisDepartmentAndSubordinateDepartments", value = "是否可查看下自己部门以及下属部门", notes = "是否可查看下自己部门以及下属部门")
   private Boolean isThisDepartmentAndSubordinateDepartments;
   @ApiModelProperty(name = "sysModuleTypeEnum", value = "模块类型（参考枚举SysModuleTypeEnum）", notes = "模块类型（参考枚举SysModuleTypeEnum）")
   private Integer sysModuleTypeEnum;
   @ApiModelProperty(name = "departmentIdList", value = "可查看的部门ids", notes = "可查看的部门ids")
   private List<Long> departmentIdList;

   public SysRoleLookPermissionConfigUpdateParam(
      final Long sysRoleId,
      final Boolean isFullPermissions,
      final Boolean isThisDepartment,
      final Boolean isIndividual,
      final Boolean isIndividualAndThisDept,
      final Boolean isThisDepartmentAndSubordinateDepartments,
      final Integer sysModuleTypeEnum,
      final List<Long> departmentIdList
   ) {
      this.sysRoleId = sysRoleId;
      this.isFullPermissions = isFullPermissions;
      this.isThisDepartment = isThisDepartment;
      this.isIndividual = isIndividual;
      this.isIndividualAndThisDept = isIndividualAndThisDept;
      this.isThisDepartmentAndSubordinateDepartments = isThisDepartmentAndSubordinateDepartments;
      this.sysModuleTypeEnum = sysModuleTypeEnum;
      this.departmentIdList = departmentIdList;
   }

   public SysRoleLookPermissionConfigUpdateParam() {
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

   public Boolean getIsIndividual() {
      return this.isIndividual;
   }

   public Boolean getIsIndividualAndThisDept() {
      return this.isIndividualAndThisDept;
   }

   public Boolean getIsThisDepartmentAndSubordinateDepartments() {
      return this.isThisDepartmentAndSubordinateDepartments;
   }

   public Integer getSysModuleTypeEnum() {
      return this.sysModuleTypeEnum;
   }

   public List<Long> getDepartmentIdList() {
      return this.departmentIdList;
   }

   public void setSysRoleId(final Long sysRoleId) {
      this.sysRoleId = sysRoleId;
   }

   public void setIsFullPermissions(final Boolean isFullPermissions) {
      this.isFullPermissions = isFullPermissions;
   }

   public void setIsThisDepartment(final Boolean isThisDepartment) {
      this.isThisDepartment = isThisDepartment;
   }

   public void setIsIndividual(final Boolean isIndividual) {
      this.isIndividual = isIndividual;
   }

   public void setIsIndividualAndThisDept(final Boolean isIndividualAndThisDept) {
      this.isIndividualAndThisDept = isIndividualAndThisDept;
   }

   public void setIsThisDepartmentAndSubordinateDepartments(final Boolean isThisDepartmentAndSubordinateDepartments) {
      this.isThisDepartmentAndSubordinateDepartments = isThisDepartmentAndSubordinateDepartments;
   }

   public void setSysModuleTypeEnum(final Integer sysModuleTypeEnum) {
      this.sysModuleTypeEnum = sysModuleTypeEnum;
   }

   public void setDepartmentIdList(final List<Long> departmentIdList) {
      this.departmentIdList = departmentIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysRoleLookPermissionConfigUpdateParam)) {
         return false;
      }

      SysRoleLookPermissionConfigUpdateParam other = (SysRoleLookPermissionConfigUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sysRoleId = this.getSysRoleId();
      Object other$sysRoleId = other.getSysRoleId();
      if (this$sysRoleId == null ? other$sysRoleId == null : this$sysRoleId.equals(other$sysRoleId)) {
         Object this$isFullPermissions = this.getIsFullPermissions();
         Object other$isFullPermissions = other.getIsFullPermissions();
         if (this$isFullPermissions == null ? other$isFullPermissions == null : this$isFullPermissions.equals(other$isFullPermissions)) {
            Object this$isThisDepartment = this.getIsThisDepartment();
            Object other$isThisDepartment = other.getIsThisDepartment();
            if (this$isThisDepartment == null ? other$isThisDepartment == null : this$isThisDepartment.equals(other$isThisDepartment)) {
               Object this$isIndividual = this.getIsIndividual();
               Object other$isIndividual = other.getIsIndividual();
               if (this$isIndividual == null ? other$isIndividual == null : this$isIndividual.equals(other$isIndividual)) {
                  Object this$isIndividualAndThisDept = this.getIsIndividualAndThisDept();
                  Object other$isIndividualAndThisDept = other.getIsIndividualAndThisDept();
                  if (this$isIndividualAndThisDept == null
                     ? other$isIndividualAndThisDept == null
                     : this$isIndividualAndThisDept.equals(other$isIndividualAndThisDept)) {
                     Object this$isThisDepartmentAndSubordinateDepartments = this.getIsThisDepartmentAndSubordinateDepartments();
                     Object other$isThisDepartmentAndSubordinateDepartments = other.getIsThisDepartmentAndSubordinateDepartments();
                     if (this$isThisDepartmentAndSubordinateDepartments == null
                        ? other$isThisDepartmentAndSubordinateDepartments == null
                        : this$isThisDepartmentAndSubordinateDepartments.equals(other$isThisDepartmentAndSubordinateDepartments)) {
                        Object this$sysModuleTypeEnum = this.getSysModuleTypeEnum();
                        Object other$sysModuleTypeEnum = other.getSysModuleTypeEnum();
                        if (this$sysModuleTypeEnum == null ? other$sysModuleTypeEnum == null : this$sysModuleTypeEnum.equals(other$sysModuleTypeEnum)) {
                           Object this$departmentIdList = this.getDepartmentIdList();
                           Object other$departmentIdList = other.getDepartmentIdList();
                           return this$departmentIdList == null ? other$departmentIdList == null : this$departmentIdList.equals(other$departmentIdList);
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
      return other instanceof SysRoleLookPermissionConfigUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sysRoleId = this.getSysRoleId();
      result = result * 59 + ($sysRoleId == null ? 43 : $sysRoleId.hashCode());
      Object $isFullPermissions = this.getIsFullPermissions();
      result = result * 59 + ($isFullPermissions == null ? 43 : $isFullPermissions.hashCode());
      Object $isThisDepartment = this.getIsThisDepartment();
      result = result * 59 + ($isThisDepartment == null ? 43 : $isThisDepartment.hashCode());
      Object $isIndividual = this.getIsIndividual();
      result = result * 59 + ($isIndividual == null ? 43 : $isIndividual.hashCode());
      Object $isIndividualAndThisDept = this.getIsIndividualAndThisDept();
      result = result * 59 + ($isIndividualAndThisDept == null ? 43 : $isIndividualAndThisDept.hashCode());
      Object $isThisDepartmentAndSubordinateDepartments = this.getIsThisDepartmentAndSubordinateDepartments();
      result = result * 59 + ($isThisDepartmentAndSubordinateDepartments == null ? 43 : $isThisDepartmentAndSubordinateDepartments.hashCode());
      Object $sysModuleTypeEnum = this.getSysModuleTypeEnum();
      result = result * 59 + ($sysModuleTypeEnum == null ? 43 : $sysModuleTypeEnum.hashCode());
      Object $departmentIdList = this.getDepartmentIdList();
      return result * 59 + ($departmentIdList == null ? 43 : $departmentIdList.hashCode());
   }

   @Override
   public String toString() {
      return "SysRoleLookPermissionConfigUpdateParam(sysRoleId="
         + this.getSysRoleId()
         + ", isFullPermissions="
         + this.getIsFullPermissions()
         + ", isThisDepartment="
         + this.getIsThisDepartment()
         + ", isIndividual="
         + this.getIsIndividual()
         + ", isIndividualAndThisDept="
         + this.getIsIndividualAndThisDept()
         + ", isThisDepartmentAndSubordinateDepartments="
         + this.getIsThisDepartmentAndSubordinateDepartments()
         + ", sysModuleTypeEnum="
         + this.getSysModuleTypeEnum()
         + ", departmentIdList="
         + this.getDepartmentIdList()
         + ")";
   }
}
