package com.hzchum.scim.common.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersions;
import com.hzchum.scim.common.core.api.pojo.vo.JobResponseVO;
import com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class WmsApproveTemplateVersionsDTO extends WmsApproveTemplateVersions {
   @ApiModelProperty(name = "moduleName", value = "该模块名称", notes = "该模块名称")
   private String moduleName;
   @ApiModelProperty(name = "approveTemplateFlowStr", value = "审批流程String类型", notes = "审批流程String类型")
   private String approveTemplateFlowStr;
   @ApiModelProperty(name = "applicationUser", value = "编辑人", notes = "编辑人")
   private UserSimpleResponseVO applicationUser;
   @ApiModelProperty(name = "objTypeName", value = "适用对象", notes = "适用对象")
   private String objTypeName;
   @ApiModelProperty(name = "departmentDTOS", value = "部门返回对象集合", notes = "部门返回对象")
   private List<DepartmentDTO> departmentDTOS;
   @ApiModelProperty(name = "userSimpleResponseVOS", value = "用户返回对象", notes = "用户返回对象")
   private List<UserSimpleResponseVO> userSimpleResponseVOS;
   @ApiModelProperty(name = "jobResponseVOS", value = "岗位返回对象", notes = "岗位返回对象")
   private List<JobResponseVO> jobResponseVOS;
   @ApiModelProperty(name = "wmsApproveTemplateVersionsFlowDTO", value = "审批模版版本流程表DTO", notes = "审批模版版本流程表DTO")
   private List<WmsApproveTemplateVersionsFlowDTO> wmsApproveTemplateVersionsFlowDTOS;
   @ApiModelProperty(name = "mountMessageDTO", value = "挂载信息", notes = "挂载信息")
   private MountMessageDTO mountMessageDTO;

   public String getModuleName() {
      return this.moduleName;
   }

   public String getApproveTemplateFlowStr() {
      return this.approveTemplateFlowStr;
   }

   public UserSimpleResponseVO getApplicationUser() {
      return this.applicationUser;
   }

   public String getObjTypeName() {
      return this.objTypeName;
   }

   public List<DepartmentDTO> getDepartmentDTOS() {
      return this.departmentDTOS;
   }

   public List<UserSimpleResponseVO> getUserSimpleResponseVOS() {
      return this.userSimpleResponseVOS;
   }

   public List<JobResponseVO> getJobResponseVOS() {
      return this.jobResponseVOS;
   }

   public List<WmsApproveTemplateVersionsFlowDTO> getWmsApproveTemplateVersionsFlowDTOS() {
      return this.wmsApproveTemplateVersionsFlowDTOS;
   }

   public MountMessageDTO getMountMessageDTO() {
      return this.mountMessageDTO;
   }

   public void setModuleName(final String moduleName) {
      this.moduleName = moduleName;
   }

   public void setApproveTemplateFlowStr(final String approveTemplateFlowStr) {
      this.approveTemplateFlowStr = approveTemplateFlowStr;
   }

   public void setApplicationUser(final UserSimpleResponseVO applicationUser) {
      this.applicationUser = applicationUser;
   }

   public void setObjTypeName(final String objTypeName) {
      this.objTypeName = objTypeName;
   }

   public void setDepartmentDTOS(final List<DepartmentDTO> departmentDTOS) {
      this.departmentDTOS = departmentDTOS;
   }

   public void setUserSimpleResponseVOS(final List<UserSimpleResponseVO> userSimpleResponseVOS) {
      this.userSimpleResponseVOS = userSimpleResponseVOS;
   }

   public void setJobResponseVOS(final List<JobResponseVO> jobResponseVOS) {
      this.jobResponseVOS = jobResponseVOS;
   }

   public void setWmsApproveTemplateVersionsFlowDTOS(final List<WmsApproveTemplateVersionsFlowDTO> wmsApproveTemplateVersionsFlowDTOS) {
      this.wmsApproveTemplateVersionsFlowDTOS = wmsApproveTemplateVersionsFlowDTOS;
   }

   public void setMountMessageDTO(final MountMessageDTO mountMessageDTO) {
      this.mountMessageDTO = mountMessageDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveTemplateVersionsDTO)) {
         return false;
      }

      WmsApproveTemplateVersionsDTO other = (WmsApproveTemplateVersionsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$moduleName = this.getModuleName();
      Object other$moduleName = other.getModuleName();
      if (this$moduleName == null ? other$moduleName == null : this$moduleName.equals(other$moduleName)) {
         Object this$approveTemplateFlowStr = this.getApproveTemplateFlowStr();
         Object other$approveTemplateFlowStr = other.getApproveTemplateFlowStr();
         if (this$approveTemplateFlowStr == null ? other$approveTemplateFlowStr == null : this$approveTemplateFlowStr.equals(other$approveTemplateFlowStr)) {
            Object this$applicationUser = this.getApplicationUser();
            Object other$applicationUser = other.getApplicationUser();
            if (this$applicationUser == null ? other$applicationUser == null : this$applicationUser.equals(other$applicationUser)) {
               Object this$objTypeName = this.getObjTypeName();
               Object other$objTypeName = other.getObjTypeName();
               if (this$objTypeName == null ? other$objTypeName == null : this$objTypeName.equals(other$objTypeName)) {
                  Object this$departmentDTOS = this.getDepartmentDTOS();
                  Object other$departmentDTOS = other.getDepartmentDTOS();
                  if (this$departmentDTOS == null ? other$departmentDTOS == null : this$departmentDTOS.equals(other$departmentDTOS)) {
                     Object this$userSimpleResponseVOS = this.getUserSimpleResponseVOS();
                     Object other$userSimpleResponseVOS = other.getUserSimpleResponseVOS();
                     if (this$userSimpleResponseVOS == null
                        ? other$userSimpleResponseVOS == null
                        : this$userSimpleResponseVOS.equals(other$userSimpleResponseVOS)) {
                        Object this$jobResponseVOS = this.getJobResponseVOS();
                        Object other$jobResponseVOS = other.getJobResponseVOS();
                        if (this$jobResponseVOS == null ? other$jobResponseVOS == null : this$jobResponseVOS.equals(other$jobResponseVOS)) {
                           Object this$wmsApproveTemplateVersionsFlowDTOS = this.getWmsApproveTemplateVersionsFlowDTOS();
                           Object other$wmsApproveTemplateVersionsFlowDTOS = other.getWmsApproveTemplateVersionsFlowDTOS();
                           if (this$wmsApproveTemplateVersionsFlowDTOS == null
                              ? other$wmsApproveTemplateVersionsFlowDTOS == null
                              : this$wmsApproveTemplateVersionsFlowDTOS.equals(other$wmsApproveTemplateVersionsFlowDTOS)) {
                              Object this$mountMessageDTO = this.getMountMessageDTO();
                              Object other$mountMessageDTO = other.getMountMessageDTO();
                              return this$mountMessageDTO == null ? other$mountMessageDTO == null : this$mountMessageDTO.equals(other$mountMessageDTO);
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
      return other instanceof WmsApproveTemplateVersionsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $moduleName = this.getModuleName();
      result = result * 59 + ($moduleName == null ? 43 : $moduleName.hashCode());
      Object $approveTemplateFlowStr = this.getApproveTemplateFlowStr();
      result = result * 59 + ($approveTemplateFlowStr == null ? 43 : $approveTemplateFlowStr.hashCode());
      Object $applicationUser = this.getApplicationUser();
      result = result * 59 + ($applicationUser == null ? 43 : $applicationUser.hashCode());
      Object $objTypeName = this.getObjTypeName();
      result = result * 59 + ($objTypeName == null ? 43 : $objTypeName.hashCode());
      Object $departmentDTOS = this.getDepartmentDTOS();
      result = result * 59 + ($departmentDTOS == null ? 43 : $departmentDTOS.hashCode());
      Object $userSimpleResponseVOS = this.getUserSimpleResponseVOS();
      result = result * 59 + ($userSimpleResponseVOS == null ? 43 : $userSimpleResponseVOS.hashCode());
      Object $jobResponseVOS = this.getJobResponseVOS();
      result = result * 59 + ($jobResponseVOS == null ? 43 : $jobResponseVOS.hashCode());
      Object $wmsApproveTemplateVersionsFlowDTOS = this.getWmsApproveTemplateVersionsFlowDTOS();
      result = result * 59 + ($wmsApproveTemplateVersionsFlowDTOS == null ? 43 : $wmsApproveTemplateVersionsFlowDTOS.hashCode());
      Object $mountMessageDTO = this.getMountMessageDTO();
      return result * 59 + ($mountMessageDTO == null ? 43 : $mountMessageDTO.hashCode());
   }

   @Override
   public String toString() {
      return "WmsApproveTemplateVersionsDTO(moduleName="
         + this.getModuleName()
         + ", approveTemplateFlowStr="
         + this.getApproveTemplateFlowStr()
         + ", applicationUser="
         + this.getApplicationUser()
         + ", objTypeName="
         + this.getObjTypeName()
         + ", departmentDTOS="
         + this.getDepartmentDTOS()
         + ", userSimpleResponseVOS="
         + this.getUserSimpleResponseVOS()
         + ", jobResponseVOS="
         + this.getJobResponseVOS()
         + ", wmsApproveTemplateVersionsFlowDTOS="
         + this.getWmsApproveTemplateVersionsFlowDTOS()
         + ", mountMessageDTO="
         + this.getMountMessageDTO()
         + ")";
   }
}
