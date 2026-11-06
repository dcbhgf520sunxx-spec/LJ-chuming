package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.Column;

public class SysRoleLookPermissionConfigDTO {
   @ApiModelProperty(name = "sysRoleId", value = "对应角色", notes = "对应角色")
   private Long sysRoleId;
   @ApiModelProperty(name = "isFullPermissions", value = "是否拥有全部权限", notes = "是否拥有全部权限")
   private Boolean isFullPermissions;
   @ApiModelProperty(name = "isThisDepartment", value = "是否可查看本部门", notes = "是否可查看本部门")
   private Boolean isThisDepartment;
   @ApiModelProperty(name = "isThisDepartmentAndSubordinateDepartments", value = "是否可查看下自己部门以及下属部门", notes = "是否可查看下自己部门以及下属部门")
   private Boolean isThisDepartmentAndSubordinateDepartments;
   @ApiModelProperty(name = "isIndividual", value = "是否只可查看自己", notes = "是否只可查看自己")
   private Boolean isIndividual;
   @ApiModelProperty(name = "departmentIds", value = "可查看的部门ids", notes = "可查看的部门ids")
   @Column(name = "department_ids", columnDefinition = "varchar(2048)  COMMENT '可查看的部门ids'", nullable = true)
   private List<Long> departmentIds;
   @ApiModelProperty(name = "sysModuleTypeEnum", value = "模块类型（参考枚举SysModuleTypeEnum）", notes = "模块类型（参考枚举SysModuleTypeEnum）")
   private Integer sysModuleTypeEnum;
   @ApiModelProperty(name = "isIndividualAndThisDept", value = "自己和自己当前部门的数据", notes = "自己和自己当前部门的数据")
   private Boolean isIndividualAndThisDept;

   public static SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder builder() {
      return new SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder();
   }

   public SysRoleLookPermissionConfigDTO(
      final Long sysRoleId,
      final Boolean isFullPermissions,
      final Boolean isThisDepartment,
      final Boolean isThisDepartmentAndSubordinateDepartments,
      final Boolean isIndividual,
      final List<Long> departmentIds,
      final Integer sysModuleTypeEnum,
      final Boolean isIndividualAndThisDept
   ) {
      this.sysRoleId = sysRoleId;
      this.isFullPermissions = isFullPermissions;
      this.isThisDepartment = isThisDepartment;
      this.isThisDepartmentAndSubordinateDepartments = isThisDepartmentAndSubordinateDepartments;
      this.isIndividual = isIndividual;
      this.departmentIds = departmentIds;
      this.sysModuleTypeEnum = sysModuleTypeEnum;
      this.isIndividualAndThisDept = isIndividualAndThisDept;
   }

   public SysRoleLookPermissionConfigDTO() {
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

   public List<Long> getDepartmentIds() {
      return this.departmentIds;
   }

   public Integer getSysModuleTypeEnum() {
      return this.sysModuleTypeEnum;
   }

   public Boolean getIsIndividualAndThisDept() {
      return this.isIndividualAndThisDept;
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

   public void setIsThisDepartmentAndSubordinateDepartments(final Boolean isThisDepartmentAndSubordinateDepartments) {
      this.isThisDepartmentAndSubordinateDepartments = isThisDepartmentAndSubordinateDepartments;
   }

   public void setIsIndividual(final Boolean isIndividual) {
      this.isIndividual = isIndividual;
   }

   public void setDepartmentIds(final List<Long> departmentIds) {
      this.departmentIds = departmentIds;
   }

   public void setSysModuleTypeEnum(final Integer sysModuleTypeEnum) {
      this.sysModuleTypeEnum = sysModuleTypeEnum;
   }

   public void setIsIndividualAndThisDept(final Boolean isIndividualAndThisDept) {
      this.isIndividualAndThisDept = isIndividualAndThisDept;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysRoleLookPermissionConfigDTO)) {
         return false;
      }

      SysRoleLookPermissionConfigDTO other = (SysRoleLookPermissionConfigDTO)o;
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysRoleLookPermissionConfigDTO;
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

   @Override
   public String toString() {
      return "SysRoleLookPermissionConfigDTO(sysRoleId="
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

   public static class SysRoleLookPermissionConfigDTOBuilder {
      private Long sysRoleId;
      private Boolean isFullPermissions;
      private Boolean isThisDepartment;
      private Boolean isThisDepartmentAndSubordinateDepartments;
      private Boolean isIndividual;
      private List<Long> departmentIds;
      private Integer sysModuleTypeEnum;
      private Boolean isIndividualAndThisDept;

      SysRoleLookPermissionConfigDTOBuilder() {
      }

      public SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder sysRoleId(final Long sysRoleId) {
         this.sysRoleId = sysRoleId;
         return this;
      }

      public SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder isFullPermissions(final Boolean isFullPermissions) {
         this.isFullPermissions = isFullPermissions;
         return this;
      }

      public SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder isThisDepartment(final Boolean isThisDepartment) {
         this.isThisDepartment = isThisDepartment;
         return this;
      }

      public SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder isThisDepartmentAndSubordinateDepartments(
         final Boolean isThisDepartmentAndSubordinateDepartments
      ) {
         this.isThisDepartmentAndSubordinateDepartments = isThisDepartmentAndSubordinateDepartments;
         return this;
      }

      public SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder isIndividual(final Boolean isIndividual) {
         this.isIndividual = isIndividual;
         return this;
      }

      public SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder departmentIds(final List<Long> departmentIds) {
         this.departmentIds = departmentIds;
         return this;
      }

      public SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder sysModuleTypeEnum(final Integer sysModuleTypeEnum) {
         this.sysModuleTypeEnum = sysModuleTypeEnum;
         return this;
      }

      public SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder isIndividualAndThisDept(final Boolean isIndividualAndThisDept) {
         this.isIndividualAndThisDept = isIndividualAndThisDept;
         return this;
      }

      public SysRoleLookPermissionConfigDTO build() {
         return new SysRoleLookPermissionConfigDTO(
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
         return "SysRoleLookPermissionConfigDTO.SysRoleLookPermissionConfigDTOBuilder(sysRoleId="
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
