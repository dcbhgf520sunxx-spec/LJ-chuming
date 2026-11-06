package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public class OaApproveRecordDTOParam implements Serializable {
   @ApiModelProperty(name = "reviewStatus ", value = "日志审批状态")
   private Integer reviewStatus;
   @ApiModelProperty(name = "versionsName", value = "流程名称 自己定义的名字")
   private String versionsName;
   @ApiModelProperty(name = "recordSerialNumber", value = "流程编号")
   private String recordSerialNumber;
   @ApiModelProperty(name = "typeTimes", value = "时间类型 1申请日期 2最后操作日期 3最近七天被驳回的")
   private Integer typeTime;
   @ApiModelProperty(name = "times", value = "时间范围")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private List<LocalDateTime> times;
   @ApiModelProperty(name = "dataSerialNumber", value = "数据编号")
   private String dataSerialNumber;
   @ApiModelProperty(name = "applicant", value = "申请人")
   private String applicant;
   @ApiModelProperty(name = "lastApprover", value = "最后审批人")
   private String lastApprover;
   @ApiModelProperty(name = "waitMeCheck", value = "待我审批 选中为true")
   private Boolean waitMeCheck;
   @ApiModelProperty(name = "meLaunch", value = "我发起的 选中为true")
   private Boolean meLaunch;
   @ApiModelProperty(name = "componentNameList", value = "跳转路径名称查询")
   private List<String> componentNameList;
   @ApiModelProperty(name = "subjoinMsg", value = "附加信息")
   private String subjoinMsg;

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getVersionsName() {
      return this.versionsName;
   }

   public String getRecordSerialNumber() {
      return this.recordSerialNumber;
   }

   public Integer getTypeTime() {
      return this.typeTime;
   }

   public List<LocalDateTime> getTimes() {
      return this.times;
   }

   public String getDataSerialNumber() {
      return this.dataSerialNumber;
   }

   public String getApplicant() {
      return this.applicant;
   }

   public String getLastApprover() {
      return this.lastApprover;
   }

   public Boolean getWaitMeCheck() {
      return this.waitMeCheck;
   }

   public Boolean getMeLaunch() {
      return this.meLaunch;
   }

   public List<String> getComponentNameList() {
      return this.componentNameList;
   }

   public String getSubjoinMsg() {
      return this.subjoinMsg;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setVersionsName(final String versionsName) {
      this.versionsName = versionsName;
   }

   public void setRecordSerialNumber(final String recordSerialNumber) {
      this.recordSerialNumber = recordSerialNumber;
   }

   public void setTypeTime(final Integer typeTime) {
      this.typeTime = typeTime;
   }

   public void setTimes(final List<LocalDateTime> times) {
      this.times = times;
   }

   public void setDataSerialNumber(final String dataSerialNumber) {
      this.dataSerialNumber = dataSerialNumber;
   }

   public void setApplicant(final String applicant) {
      this.applicant = applicant;
   }

   public void setLastApprover(final String lastApprover) {
      this.lastApprover = lastApprover;
   }

   public void setWaitMeCheck(final Boolean waitMeCheck) {
      this.waitMeCheck = waitMeCheck;
   }

   public void setMeLaunch(final Boolean meLaunch) {
      this.meLaunch = meLaunch;
   }

   public void setComponentNameList(final List<String> componentNameList) {
      this.componentNameList = componentNameList;
   }

   public void setSubjoinMsg(final String subjoinMsg) {
      this.subjoinMsg = subjoinMsg;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaApproveRecordDTOParam)) {
         return false;
      }

      OaApproveRecordDTOParam other = (OaApproveRecordDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reviewStatus = this.getReviewStatus();
      Object other$reviewStatus = other.getReviewStatus();
      if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
         Object this$typeTime = this.getTypeTime();
         Object other$typeTime = other.getTypeTime();
         if (this$typeTime == null ? other$typeTime == null : this$typeTime.equals(other$typeTime)) {
            Object this$waitMeCheck = this.getWaitMeCheck();
            Object other$waitMeCheck = other.getWaitMeCheck();
            if (this$waitMeCheck == null ? other$waitMeCheck == null : this$waitMeCheck.equals(other$waitMeCheck)) {
               Object this$meLaunch = this.getMeLaunch();
               Object other$meLaunch = other.getMeLaunch();
               if (this$meLaunch == null ? other$meLaunch == null : this$meLaunch.equals(other$meLaunch)) {
                  Object this$versionsName = this.getVersionsName();
                  Object other$versionsName = other.getVersionsName();
                  if (this$versionsName == null ? other$versionsName == null : this$versionsName.equals(other$versionsName)) {
                     Object this$recordSerialNumber = this.getRecordSerialNumber();
                     Object other$recordSerialNumber = other.getRecordSerialNumber();
                     if (this$recordSerialNumber == null ? other$recordSerialNumber == null : this$recordSerialNumber.equals(other$recordSerialNumber)) {
                        Object this$times = this.getTimes();
                        Object other$times = other.getTimes();
                        if (this$times == null ? other$times == null : this$times.equals(other$times)) {
                           Object this$dataSerialNumber = this.getDataSerialNumber();
                           Object other$dataSerialNumber = other.getDataSerialNumber();
                           if (this$dataSerialNumber == null ? other$dataSerialNumber == null : this$dataSerialNumber.equals(other$dataSerialNumber)) {
                              Object this$applicant = this.getApplicant();
                              Object other$applicant = other.getApplicant();
                              if (this$applicant == null ? other$applicant == null : this$applicant.equals(other$applicant)) {
                                 Object this$lastApprover = this.getLastApprover();
                                 Object other$lastApprover = other.getLastApprover();
                                 if (this$lastApprover == null ? other$lastApprover == null : this$lastApprover.equals(other$lastApprover)) {
                                    Object this$componentNameList = this.getComponentNameList();
                                    Object other$componentNameList = other.getComponentNameList();
                                    if (this$componentNameList == null
                                       ? other$componentNameList == null
                                       : this$componentNameList.equals(other$componentNameList)) {
                                       Object this$subjoinMsg = this.getSubjoinMsg();
                                       Object other$subjoinMsg = other.getSubjoinMsg();
                                       return this$subjoinMsg == null ? other$subjoinMsg == null : this$subjoinMsg.equals(other$subjoinMsg);
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
      return other instanceof OaApproveRecordDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $typeTime = this.getTypeTime();
      result = result * 59 + ($typeTime == null ? 43 : $typeTime.hashCode());
      Object $waitMeCheck = this.getWaitMeCheck();
      result = result * 59 + ($waitMeCheck == null ? 43 : $waitMeCheck.hashCode());
      Object $meLaunch = this.getMeLaunch();
      result = result * 59 + ($meLaunch == null ? 43 : $meLaunch.hashCode());
      Object $versionsName = this.getVersionsName();
      result = result * 59 + ($versionsName == null ? 43 : $versionsName.hashCode());
      Object $recordSerialNumber = this.getRecordSerialNumber();
      result = result * 59 + ($recordSerialNumber == null ? 43 : $recordSerialNumber.hashCode());
      Object $times = this.getTimes();
      result = result * 59 + ($times == null ? 43 : $times.hashCode());
      Object $dataSerialNumber = this.getDataSerialNumber();
      result = result * 59 + ($dataSerialNumber == null ? 43 : $dataSerialNumber.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $lastApprover = this.getLastApprover();
      result = result * 59 + ($lastApprover == null ? 43 : $lastApprover.hashCode());
      Object $componentNameList = this.getComponentNameList();
      result = result * 59 + ($componentNameList == null ? 43 : $componentNameList.hashCode());
      Object $subjoinMsg = this.getSubjoinMsg();
      return result * 59 + ($subjoinMsg == null ? 43 : $subjoinMsg.hashCode());
   }

   @Override
   public String toString() {
      return "OaApproveRecordDTOParam(reviewStatus="
         + this.getReviewStatus()
         + ", versionsName="
         + this.getVersionsName()
         + ", recordSerialNumber="
         + this.getRecordSerialNumber()
         + ", typeTime="
         + this.getTypeTime()
         + ", times="
         + this.getTimes()
         + ", dataSerialNumber="
         + this.getDataSerialNumber()
         + ", applicant="
         + this.getApplicant()
         + ", lastApprover="
         + this.getLastApprover()
         + ", waitMeCheck="
         + this.getWaitMeCheck()
         + ", meLaunch="
         + this.getMeLaunch()
         + ", componentNameList="
         + this.getComponentNameList()
         + ", subjoinMsg="
         + this.getSubjoinMsg()
         + ")";
   }
}
