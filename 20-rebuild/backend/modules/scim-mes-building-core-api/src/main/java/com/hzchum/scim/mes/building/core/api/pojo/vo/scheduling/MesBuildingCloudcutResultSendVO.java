package com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingCloudcutResultSendVO", description = "已下发的文件或已存在的文件")
public class MesBuildingCloudcutResultSendVO {
   private String repeatFileName;
   private String sendFileName;
   private Boolean sendResult;

   public String getRepeatFileName() {
      return this.repeatFileName;
   }

   public String getSendFileName() {
      return this.sendFileName;
   }

   public Boolean getSendResult() {
      return this.sendResult;
   }

   public void setRepeatFileName(final String repeatFileName) {
      this.repeatFileName = repeatFileName;
   }

   public void setSendFileName(final String sendFileName) {
      this.sendFileName = sendFileName;
   }

   public void setSendResult(final Boolean sendResult) {
      this.sendResult = sendResult;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCloudcutResultSendVO)) {
         return false;
      }

      MesBuildingCloudcutResultSendVO other = (MesBuildingCloudcutResultSendVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sendResult = this.getSendResult();
      Object other$sendResult = other.getSendResult();
      if (this$sendResult == null ? other$sendResult == null : this$sendResult.equals(other$sendResult)) {
         Object this$repeatFileName = this.getRepeatFileName();
         Object other$repeatFileName = other.getRepeatFileName();
         if (this$repeatFileName == null ? other$repeatFileName == null : this$repeatFileName.equals(other$repeatFileName)) {
            Object this$sendFileName = this.getSendFileName();
            Object other$sendFileName = other.getSendFileName();
            return this$sendFileName == null ? other$sendFileName == null : this$sendFileName.equals(other$sendFileName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingCloudcutResultSendVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sendResult = this.getSendResult();
      result = result * 59 + ($sendResult == null ? 43 : $sendResult.hashCode());
      Object $repeatFileName = this.getRepeatFileName();
      result = result * 59 + ($repeatFileName == null ? 43 : $repeatFileName.hashCode());
      Object $sendFileName = this.getSendFileName();
      return result * 59 + ($sendFileName == null ? 43 : $sendFileName.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingCloudcutResultSendVO(repeatFileName="
         + this.getRepeatFileName()
         + ", sendFileName="
         + this.getSendFileName()
         + ", sendResult="
         + this.getSendResult()
         + ")";
   }
}
