package com.hzchum.scim.common.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class WmsApproveRecordDTO extends WmsApproveRecord {
   @ApiModelProperty("申请人信息")
   private UserSimpleResponseVO applicantUserVO;
   @ApiModelProperty("业务模块名称")
   private String moduleTypeName;
   @ApiModelProperty("流程类型名称")
   private String approveProcessTypeName;
   @ApiModelProperty("流程名称 -- 流程版本名称")
   private String approveVersionsName;
   @ApiModelProperty("节点流转日期")
   private LocalDateTime flowArrivalTime;
   @ApiModelProperty("审批信息集合")
   private WmsApproveFlowDTO wmsApproveFlowDTO;
   @ApiModelProperty("当前人是否可审批 true的话显示审核的按钮")
   private Boolean boolCheck;
   @ApiModelProperty("当前人是否可撤销 true的话显示撤销的按钮")
   private Boolean boolCancel;
   @ApiModelProperty("是否有操作权限")
   private Boolean boolOperation;
   @ApiModelProperty(name = "wmsApproveRecordDTO", value = "日志信息")
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;
   @ApiModelProperty(name = "approveFacility", value = "审批设备 0：PC端 1：APP端 2：PC端和APP端都可以审批")
   private Integer approveFacility;
   @ApiModelProperty(name = "附加信息List类型", value = "附加信息List类型")
   private List<String> subjoinMsgList;

   public UserSimpleResponseVO getApplicantUserVO() {
      return this.applicantUserVO;
   }

   public String getModuleTypeName() {
      return this.moduleTypeName;
   }

   public String getApproveProcessTypeName() {
      return this.approveProcessTypeName;
   }

   public String getApproveVersionsName() {
      return this.approveVersionsName;
   }

   public LocalDateTime getFlowArrivalTime() {
      return this.flowArrivalTime;
   }

   public WmsApproveFlowDTO getWmsApproveFlowDTO() {
      return this.wmsApproveFlowDTO;
   }

   public Boolean getBoolCheck() {
      return this.boolCheck;
   }

   public Boolean getBoolCancel() {
      return this.boolCancel;
   }

   public Boolean getBoolOperation() {
      return this.boolOperation;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTO() {
      return this.wmsApproveRecordFlowDTO;
   }

   public Integer getApproveFacility() {
      return this.approveFacility;
   }

   public List<String> getSubjoinMsgList() {
      return this.subjoinMsgList;
   }

   public void setApplicantUserVO(final UserSimpleResponseVO applicantUserVO) {
      this.applicantUserVO = applicantUserVO;
   }

   public void setModuleTypeName(final String moduleTypeName) {
      this.moduleTypeName = moduleTypeName;
   }

   public void setApproveProcessTypeName(final String approveProcessTypeName) {
      this.approveProcessTypeName = approveProcessTypeName;
   }

   public void setApproveVersionsName(final String approveVersionsName) {
      this.approveVersionsName = approveVersionsName;
   }

   public void setFlowArrivalTime(final LocalDateTime flowArrivalTime) {
      this.flowArrivalTime = flowArrivalTime;
   }

   public void setWmsApproveFlowDTO(final WmsApproveFlowDTO wmsApproveFlowDTO) {
      this.wmsApproveFlowDTO = wmsApproveFlowDTO;
   }

   public void setBoolCheck(final Boolean boolCheck) {
      this.boolCheck = boolCheck;
   }

   public void setBoolCancel(final Boolean boolCancel) {
      this.boolCancel = boolCancel;
   }

   public void setBoolOperation(final Boolean boolOperation) {
      this.boolOperation = boolOperation;
   }

   public void setWmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   public void setApproveFacility(final Integer approveFacility) {
      this.approveFacility = approveFacility;
   }

   public void setSubjoinMsgList(final List<String> subjoinMsgList) {
      this.subjoinMsgList = subjoinMsgList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveRecordDTO)) {
         return false;
      }

      WmsApproveRecordDTO other = (WmsApproveRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolCheck = this.getBoolCheck();
      Object other$boolCheck = other.getBoolCheck();
      if (this$boolCheck == null ? other$boolCheck == null : this$boolCheck.equals(other$boolCheck)) {
         Object this$boolCancel = this.getBoolCancel();
         Object other$boolCancel = other.getBoolCancel();
         if (this$boolCancel == null ? other$boolCancel == null : this$boolCancel.equals(other$boolCancel)) {
            Object this$boolOperation = this.getBoolOperation();
            Object other$boolOperation = other.getBoolOperation();
            if (this$boolOperation == null ? other$boolOperation == null : this$boolOperation.equals(other$boolOperation)) {
               Object this$approveFacility = this.getApproveFacility();
               Object other$approveFacility = other.getApproveFacility();
               if (this$approveFacility == null ? other$approveFacility == null : this$approveFacility.equals(other$approveFacility)) {
                  Object this$applicantUserVO = this.getApplicantUserVO();
                  Object other$applicantUserVO = other.getApplicantUserVO();
                  if (this$applicantUserVO == null ? other$applicantUserVO == null : this$applicantUserVO.equals(other$applicantUserVO)) {
                     Object this$moduleTypeName = this.getModuleTypeName();
                     Object other$moduleTypeName = other.getModuleTypeName();
                     if (this$moduleTypeName == null ? other$moduleTypeName == null : this$moduleTypeName.equals(other$moduleTypeName)) {
                        Object this$approveProcessTypeName = this.getApproveProcessTypeName();
                        Object other$approveProcessTypeName = other.getApproveProcessTypeName();
                        if (this$approveProcessTypeName == null
                           ? other$approveProcessTypeName == null
                           : this$approveProcessTypeName.equals(other$approveProcessTypeName)) {
                           Object this$approveVersionsName = this.getApproveVersionsName();
                           Object other$approveVersionsName = other.getApproveVersionsName();
                           if (this$approveVersionsName == null
                              ? other$approveVersionsName == null
                              : this$approveVersionsName.equals(other$approveVersionsName)) {
                              Object this$flowArrivalTime = this.getFlowArrivalTime();
                              Object other$flowArrivalTime = other.getFlowArrivalTime();
                              if (this$flowArrivalTime == null ? other$flowArrivalTime == null : this$flowArrivalTime.equals(other$flowArrivalTime)) {
                                 Object this$wmsApproveFlowDTO = this.getWmsApproveFlowDTO();
                                 Object other$wmsApproveFlowDTO = other.getWmsApproveFlowDTO();
                                 if (this$wmsApproveFlowDTO == null ? other$wmsApproveFlowDTO == null : this$wmsApproveFlowDTO.equals(other$wmsApproveFlowDTO)) {
                                    Object this$wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
                                    Object other$wmsApproveRecordFlowDTO = other.getWmsApproveRecordFlowDTO();
                                    if (this$wmsApproveRecordFlowDTO == null
                                       ? other$wmsApproveRecordFlowDTO == null
                                       : this$wmsApproveRecordFlowDTO.equals(other$wmsApproveRecordFlowDTO)) {
                                       Object this$subjoinMsgList = this.getSubjoinMsgList();
                                       Object other$subjoinMsgList = other.getSubjoinMsgList();
                                       return this$subjoinMsgList == null ? other$subjoinMsgList == null : this$subjoinMsgList.equals(other$subjoinMsgList);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsApproveRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolCheck = this.getBoolCheck();
      result = result * 59 + ($boolCheck == null ? 43 : $boolCheck.hashCode());
      Object $boolCancel = this.getBoolCancel();
      result = result * 59 + ($boolCancel == null ? 43 : $boolCancel.hashCode());
      Object $boolOperation = this.getBoolOperation();
      result = result * 59 + ($boolOperation == null ? 43 : $boolOperation.hashCode());
      Object $approveFacility = this.getApproveFacility();
      result = result * 59 + ($approveFacility == null ? 43 : $approveFacility.hashCode());
      Object $applicantUserVO = this.getApplicantUserVO();
      result = result * 59 + ($applicantUserVO == null ? 43 : $applicantUserVO.hashCode());
      Object $moduleTypeName = this.getModuleTypeName();
      result = result * 59 + ($moduleTypeName == null ? 43 : $moduleTypeName.hashCode());
      Object $approveProcessTypeName = this.getApproveProcessTypeName();
      result = result * 59 + ($approveProcessTypeName == null ? 43 : $approveProcessTypeName.hashCode());
      Object $approveVersionsName = this.getApproveVersionsName();
      result = result * 59 + ($approveVersionsName == null ? 43 : $approveVersionsName.hashCode());
      Object $flowArrivalTime = this.getFlowArrivalTime();
      result = result * 59 + ($flowArrivalTime == null ? 43 : $flowArrivalTime.hashCode());
      Object $wmsApproveFlowDTO = this.getWmsApproveFlowDTO();
      result = result * 59 + ($wmsApproveFlowDTO == null ? 43 : $wmsApproveFlowDTO.hashCode());
      Object $wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
      result = result * 59 + ($wmsApproveRecordFlowDTO == null ? 43 : $wmsApproveRecordFlowDTO.hashCode());
      Object $subjoinMsgList = this.getSubjoinMsgList();
      return result * 59 + ($subjoinMsgList == null ? 43 : $subjoinMsgList.hashCode());
   }

   @Override
   public String toString() {
      return "WmsApproveRecordDTO(applicantUserVO="
         + this.getApplicantUserVO()
         + ", moduleTypeName="
         + this.getModuleTypeName()
         + ", approveProcessTypeName="
         + this.getApproveProcessTypeName()
         + ", approveVersionsName="
         + this.getApproveVersionsName()
         + ", flowArrivalTime="
         + this.getFlowArrivalTime()
         + ", wmsApproveFlowDTO="
         + this.getWmsApproveFlowDTO()
         + ", boolCheck="
         + this.getBoolCheck()
         + ", boolCancel="
         + this.getBoolCancel()
         + ", boolOperation="
         + this.getBoolOperation()
         + ", wmsApproveRecordFlowDTO="
         + this.getWmsApproveRecordFlowDTO()
         + ", approveFacility="
         + this.getApproveFacility()
         + ", subjoinMsgList="
         + this.getSubjoinMsgList()
         + ")";
   }
}
