package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ExcelTarget("NestingTaskFailDTO")
@ApiModel(value = "零件套料需要排产信息", description = "零件套料需要排产信息")
public class NestingTaskFailDTO {
   @ApiModelProperty(name = "jobId", value = "作业号", notes = "作业号")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   private String jobId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   @Excel(name = "项目名称", orderNum = "0", width = 20.0)
   private String projectName;
   @ApiModelProperty(name = "taskOrderNumber", value = "工单编号", notes = "工单编号")
   @JsonProperty("taskOrderNumber")
   @JSONField(name = "taskOrderNumber")
   @Excel(name = "工单编号", orderNum = "1", width = 10.0)
   private String taskOrderNumber;
   @ApiModelProperty(name = "filename", value = "文件名", notes = "文件名")
   @JsonProperty("filename")
   @JSONField(name = "filename")
   @Excel(name = "文件名", orderNum = "2", width = 10.0)
   private String filename;

   public static NestingTaskFailDTO.NestingTaskFailDTOBuilder builder() {
      return new NestingTaskFailDTO.NestingTaskFailDTOBuilder();
   }

   public NestingTaskFailDTO(final String jobId, final String projectName, final String taskOrderNumber, final String filename) {
      this.jobId = jobId;
      this.projectName = projectName;
      this.taskOrderNumber = taskOrderNumber;
      this.filename = filename;
   }

   public NestingTaskFailDTO() {
   }

   public String getJobId() {
      return this.jobId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public String getFilename() {
      return this.filename;
   }

   @JsonProperty("jobId")
   public NestingTaskFailDTO setJobId(final String jobId) {
      this.jobId = jobId;
      return this;
   }

   @JsonProperty("projectName")
   public NestingTaskFailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("taskOrderNumber")
   public NestingTaskFailDTO setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
      return this;
   }

   @JsonProperty("filename")
   public NestingTaskFailDTO setFilename(final String filename) {
      this.filename = filename;
      return this;
   }

   @Override
   public String toString() {
      return "NestingTaskFailDTO(jobId="
         + this.getJobId()
         + ", projectName="
         + this.getProjectName()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", filename="
         + this.getFilename()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestingTaskFailDTO)) {
         return false;
      }

      NestingTaskFailDTO other = (NestingTaskFailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jobId = this.getJobId();
      Object other$jobId = other.getJobId();
      if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$taskOrderNumber = this.getTaskOrderNumber();
            Object other$taskOrderNumber = other.getTaskOrderNumber();
            if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
               Object this$filename = this.getFilename();
               Object other$filename = other.getFilename();
               return this$filename == null ? other$filename == null : this$filename.equals(other$filename);
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
      return other instanceof NestingTaskFailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $filename = this.getFilename();
      return result * 59 + ($filename == null ? 43 : $filename.hashCode());
   }

   public static class NestingTaskFailDTOBuilder {
      private String jobId;
      private String projectName;
      private String taskOrderNumber;
      private String filename;

      NestingTaskFailDTOBuilder() {
      }

      @JsonProperty("jobId")
      public NestingTaskFailDTO.NestingTaskFailDTOBuilder jobId(final String jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("projectName")
      public NestingTaskFailDTO.NestingTaskFailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("taskOrderNumber")
      public NestingTaskFailDTO.NestingTaskFailDTOBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      @JsonProperty("filename")
      public NestingTaskFailDTO.NestingTaskFailDTOBuilder filename(final String filename) {
         this.filename = filename;
         return this;
      }

      public NestingTaskFailDTO build() {
         return new NestingTaskFailDTO(this.jobId, this.projectName, this.taskOrderNumber, this.filename);
      }

      @Override
      public String toString() {
         return "NestingTaskFailDTO.NestingTaskFailDTOBuilder(jobId="
            + this.jobId
            + ", projectName="
            + this.projectName
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", filename="
            + this.filename
            + ")";
      }
   }
}
