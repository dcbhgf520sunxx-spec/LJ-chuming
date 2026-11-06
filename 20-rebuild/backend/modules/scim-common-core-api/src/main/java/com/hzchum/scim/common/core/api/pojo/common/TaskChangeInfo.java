package com.hzchum.scim.common.core.api.pojo.common;

public class TaskChangeInfo {
   private String corpId;
   private String processCode;
   private String title;
   private String processInstanceId;
   private String EventType;
   private String type;
   private Long createTime;
   private Long finishTime;
   private String result;
   private String remark;
   private String staffId;
   private String businessId;
   private Long taskId;

   public String getCorpId() {
      return this.corpId;
   }

   public String getProcessCode() {
      return this.processCode;
   }

   public String getTitle() {
      return this.title;
   }

   public String getProcessInstanceId() {
      return this.processInstanceId;
   }

   public String getEventType() {
      return this.EventType;
   }

   public String getType() {
      return this.type;
   }

   public Long getCreateTime() {
      return this.createTime;
   }

   public Long getFinishTime() {
      return this.finishTime;
   }

   public String getResult() {
      return this.result;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getStaffId() {
      return this.staffId;
   }

   public String getBusinessId() {
      return this.businessId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public void setCorpId(final String corpId) {
      this.corpId = corpId;
   }

   public void setProcessCode(final String processCode) {
      this.processCode = processCode;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setProcessInstanceId(final String processInstanceId) {
      this.processInstanceId = processInstanceId;
   }

   public void setEventType(final String EventType) {
      this.EventType = EventType;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setCreateTime(final Long createTime) {
      this.createTime = createTime;
   }

   public void setFinishTime(final Long finishTime) {
      this.finishTime = finishTime;
   }

   public void setResult(final String result) {
      this.result = result;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setStaffId(final String staffId) {
      this.staffId = staffId;
   }

   public void setBusinessId(final String businessId) {
      this.businessId = businessId;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskChangeInfo)) {
         return false;
      }

      TaskChangeInfo other = (TaskChangeInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createTime = this.getCreateTime();
      Object other$createTime = other.getCreateTime();
      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
         Object this$finishTime = this.getFinishTime();
         Object other$finishTime = other.getFinishTime();
         if (this$finishTime == null ? other$finishTime == null : this$finishTime.equals(other$finishTime)) {
            Object this$taskId = this.getTaskId();
            Object other$taskId = other.getTaskId();
            if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
               Object this$corpId = this.getCorpId();
               Object other$corpId = other.getCorpId();
               if (this$corpId == null ? other$corpId == null : this$corpId.equals(other$corpId)) {
                  Object this$processCode = this.getProcessCode();
                  Object other$processCode = other.getProcessCode();
                  if (this$processCode == null ? other$processCode == null : this$processCode.equals(other$processCode)) {
                     Object this$title = this.getTitle();
                     Object other$title = other.getTitle();
                     if (this$title == null ? other$title == null : this$title.equals(other$title)) {
                        Object this$processInstanceId = this.getProcessInstanceId();
                        Object other$processInstanceId = other.getProcessInstanceId();
                        if (this$processInstanceId == null ? other$processInstanceId == null : this$processInstanceId.equals(other$processInstanceId)) {
                           Object this$EventType = this.getEventType();
                           Object other$EventType = other.getEventType();
                           if (this$EventType == null ? other$EventType == null : this$EventType.equals(other$EventType)) {
                              Object this$type = this.getType();
                              Object other$type = other.getType();
                              if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                 Object this$result = this.getResult();
                                 Object other$result = other.getResult();
                                 if (this$result == null ? other$result == null : this$result.equals(other$result)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$staffId = this.getStaffId();
                                       Object other$staffId = other.getStaffId();
                                       if (this$staffId == null ? other$staffId == null : this$staffId.equals(other$staffId)) {
                                          Object this$businessId = this.getBusinessId();
                                          Object other$businessId = other.getBusinessId();
                                          return this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskChangeInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $finishTime = this.getFinishTime();
      result = result * 59 + ($finishTime == null ? 43 : $finishTime.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $corpId = this.getCorpId();
      result = result * 59 + ($corpId == null ? 43 : $corpId.hashCode());
      Object $processCode = this.getProcessCode();
      result = result * 59 + ($processCode == null ? 43 : $processCode.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $processInstanceId = this.getProcessInstanceId();
      result = result * 59 + ($processInstanceId == null ? 43 : $processInstanceId.hashCode());
      Object $EventType = this.getEventType();
      result = result * 59 + ($EventType == null ? 43 : $EventType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $result = this.getResult();
      result = result * 59 + ($result == null ? 43 : $result.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $staffId = this.getStaffId();
      result = result * 59 + ($staffId == null ? 43 : $staffId.hashCode());
      Object $businessId = this.getBusinessId();
      return result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
   }

   @Override
   public String toString() {
      return "TaskChangeInfo(corpId="
         + this.getCorpId()
         + ", processCode="
         + this.getProcessCode()
         + ", title="
         + this.getTitle()
         + ", processInstanceId="
         + this.getProcessInstanceId()
         + ", EventType="
         + this.getEventType()
         + ", type="
         + this.getType()
         + ", createTime="
         + this.getCreateTime()
         + ", finishTime="
         + this.getFinishTime()
         + ", result="
         + this.getResult()
         + ", remark="
         + this.getRemark()
         + ", staffId="
         + this.getStaffId()
         + ", businessId="
         + this.getBusinessId()
         + ", taskId="
         + this.getTaskId()
         + ")";
   }
}
