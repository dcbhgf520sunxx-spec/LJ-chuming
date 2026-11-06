package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("柏楚(/api/result/get_job)根据钢板guid获取作业及板材信息")
public class MesBuildingBoChuSteelPlateByGuidDTO {
   @ApiModelProperty("钢板guid")
   private String uuid;
   @ApiModelProperty("板材guid")
   private String plateGuid;
   @ApiModelProperty("使用板材数")
   private int amount;
   @ApiModelProperty("板材类型(0:标准, 1:余料)")
   private int plateType;
   @ApiModelProperty("钢板关联作业List")
   private List<MesBuildingBoChuSteelPlateByGuidDTO.JobSimpleInfo> jobList;

   public String getUuid() {
      return this.uuid;
   }

   public String getPlateGuid() {
      return this.plateGuid;
   }

   public int getAmount() {
      return this.amount;
   }

   public int getPlateType() {
      return this.plateType;
   }

   public List<MesBuildingBoChuSteelPlateByGuidDTO.JobSimpleInfo> getJobList() {
      return this.jobList;
   }

   public void setUuid(final String uuid) {
      this.uuid = uuid;
   }

   public void setPlateGuid(final String plateGuid) {
      this.plateGuid = plateGuid;
   }

   public void setAmount(final int amount) {
      this.amount = amount;
   }

   public void setPlateType(final int plateType) {
      this.plateType = plateType;
   }

   public void setJobList(final List<MesBuildingBoChuSteelPlateByGuidDTO.JobSimpleInfo> jobList) {
      this.jobList = jobList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoChuSteelPlateByGuidDTO)) {
         return false;
      }

      MesBuildingBoChuSteelPlateByGuidDTO other = (MesBuildingBoChuSteelPlateByGuidDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getAmount() != other.getAmount()) {
         return false;
      }

      if (this.getPlateType() != other.getPlateType()) {
         return false;
      }

      Object this$uuid = this.getUuid();
      Object other$uuid = other.getUuid();
      if (this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid)) {
         Object this$plateGuid = this.getPlateGuid();
         Object other$plateGuid = other.getPlateGuid();
         if (this$plateGuid == null ? other$plateGuid == null : this$plateGuid.equals(other$plateGuid)) {
            Object this$jobList = this.getJobList();
            Object other$jobList = other.getJobList();
            return this$jobList == null ? other$jobList == null : this$jobList.equals(other$jobList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingBoChuSteelPlateByGuidDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAmount();
      result = result * 59 + this.getPlateType();
      Object $uuid = this.getUuid();
      result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
      Object $plateGuid = this.getPlateGuid();
      result = result * 59 + ($plateGuid == null ? 43 : $plateGuid.hashCode());
      Object $jobList = this.getJobList();
      return result * 59 + ($jobList == null ? 43 : $jobList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingBoChuSteelPlateByGuidDTO(uuid="
         + this.getUuid()
         + ", plateGuid="
         + this.getPlateGuid()
         + ", amount="
         + this.getAmount()
         + ", plateType="
         + this.getPlateType()
         + ", jobList="
         + this.getJobList()
         + ")";
   }

   public static class JobSimpleInfo {
      @ApiModelProperty("作业id")
      private Integer jobId;
      @ApiModelProperty("作业名称")
      private String jobName;

      public Integer getJobId() {
         return this.jobId;
      }

      public String getJobName() {
         return this.jobName;
      }

      public void setJobId(final Integer jobId) {
         this.jobId = jobId;
      }

      public void setJobName(final String jobName) {
         this.jobName = jobName;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         } else if (!(o instanceof MesBuildingBoChuSteelPlateByGuidDTO.JobSimpleInfo)) {
            return false;
         } else {
            MesBuildingBoChuSteelPlateByGuidDTO.JobSimpleInfo other = (MesBuildingBoChuSteelPlateByGuidDTO.JobSimpleInfo)o;
            if (!other.canEqual(this)) {
               return false;
            } else {
               Object this$jobId = this.getJobId();
               Object other$jobId = other.getJobId();
               if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                  Object this$jobName = this.getJobName();
                  Object other$jobName = other.getJobName();
                  return this$jobName == null ? other$jobName == null : this$jobName.equals(other$jobName);
               } else {
                  return false;
               }
            }
         }
      }

      protected boolean canEqual(final Object other) {
         return other instanceof MesBuildingBoChuSteelPlateByGuidDTO.JobSimpleInfo;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $jobId = this.getJobId();
         result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
         Object $jobName = this.getJobName();
         return result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
      }

      @Override
      public String toString() {
         return "MesBuildingBoChuSteelPlateByGuidDTO.JobSimpleInfo(jobId=" + this.getJobId() + ", jobName=" + this.getJobName() + ")";
      }
   }
}
