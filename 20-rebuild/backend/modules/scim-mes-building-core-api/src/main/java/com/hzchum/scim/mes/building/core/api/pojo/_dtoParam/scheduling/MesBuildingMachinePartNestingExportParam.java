package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingMachinePartNestingExportParam", description = "零件套料排产零件")
public class MesBuildingMachinePartNestingExportParam {
   @ApiModelProperty(name = "resultList", value = "结果集", notes = "结果集")
   @JsonProperty("resultList")
   @JSONField(name = "resultList")
   private List<String> resultList;
   @ApiModelProperty(name = "machineToolId", value = "机床id", notes = "机床id")
   @JsonProperty("machineToolId")
   @JSONField(name = "machineToolId")
   private String machineToolId;
   @ApiModelProperty(name = "type", value = "类型", notes = "类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private String type;
   @ApiModelProperty(name = "jobId", value = "作业id", notes = "作业id")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   private Integer jobId;
   @ApiModelProperty(name = "name_filter_flag", value = "是否过滤名称", notes = "是否过滤名称")
   @JsonProperty("name_filter_flag")
   @JSONField(name = "name_filter_flag")
   private Boolean nameFilterFlag;

   public static MesBuildingMachinePartNestingExportParam.MesBuildingMachinePartNestingExportParamBuilder builder() {
      return new MesBuildingMachinePartNestingExportParam.MesBuildingMachinePartNestingExportParamBuilder();
   }

   public MesBuildingMachinePartNestingExportParam(
      final List<String> resultList, final String machineToolId, final String type, final Integer jobId, final Boolean nameFilterFlag
   ) {
      this.resultList = resultList;
      this.machineToolId = machineToolId;
      this.type = type;
      this.jobId = jobId;
      this.nameFilterFlag = nameFilterFlag;
   }

   public MesBuildingMachinePartNestingExportParam() {
   }

   public List<String> getResultList() {
      return this.resultList;
   }

   public String getMachineToolId() {
      return this.machineToolId;
   }

   public String getType() {
      return this.type;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public Boolean getNameFilterFlag() {
      return this.nameFilterFlag;
   }

   @JsonProperty("resultList")
   public MesBuildingMachinePartNestingExportParam setResultList(final List<String> resultList) {
      this.resultList = resultList;
      return this;
   }

   @JsonProperty("machineToolId")
   public MesBuildingMachinePartNestingExportParam setMachineToolId(final String machineToolId) {
      this.machineToolId = machineToolId;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingMachinePartNestingExportParam setType(final String type) {
      this.type = type;
      return this;
   }

   @JsonProperty("jobId")
   public MesBuildingMachinePartNestingExportParam setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   @JsonProperty("name_filter_flag")
   public MesBuildingMachinePartNestingExportParam setNameFilterFlag(final Boolean nameFilterFlag) {
      this.nameFilterFlag = nameFilterFlag;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartNestingExportParam(resultList="
         + this.getResultList()
         + ", machineToolId="
         + this.getMachineToolId()
         + ", type="
         + this.getType()
         + ", jobId="
         + this.getJobId()
         + ", nameFilterFlag="
         + this.getNameFilterFlag()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartNestingExportParam)) {
         return false;
      }

      MesBuildingMachinePartNestingExportParam other = (MesBuildingMachinePartNestingExportParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jobId = this.getJobId();
      Object other$jobId = other.getJobId();
      if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
         Object this$nameFilterFlag = this.getNameFilterFlag();
         Object other$nameFilterFlag = other.getNameFilterFlag();
         if (this$nameFilterFlag == null ? other$nameFilterFlag == null : this$nameFilterFlag.equals(other$nameFilterFlag)) {
            Object this$resultList = this.getResultList();
            Object other$resultList = other.getResultList();
            if (this$resultList == null ? other$resultList == null : this$resultList.equals(other$resultList)) {
               Object this$machineToolId = this.getMachineToolId();
               Object other$machineToolId = other.getMachineToolId();
               if (this$machineToolId == null ? other$machineToolId == null : this$machineToolId.equals(other$machineToolId)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  return this$type == null ? other$type == null : this$type.equals(other$type);
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
      return other instanceof MesBuildingMachinePartNestingExportParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $nameFilterFlag = this.getNameFilterFlag();
      result = result * 59 + ($nameFilterFlag == null ? 43 : $nameFilterFlag.hashCode());
      Object $resultList = this.getResultList();
      result = result * 59 + ($resultList == null ? 43 : $resultList.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   public static class MesBuildingMachinePartNestingExportParamBuilder {
      private List<String> resultList;
      private String machineToolId;
      private String type;
      private Integer jobId;
      private Boolean nameFilterFlag;

      MesBuildingMachinePartNestingExportParamBuilder() {
      }

      @JsonProperty("resultList")
      public MesBuildingMachinePartNestingExportParam.MesBuildingMachinePartNestingExportParamBuilder resultList(final List<String> resultList) {
         this.resultList = resultList;
         return this;
      }

      @JsonProperty("machineToolId")
      public MesBuildingMachinePartNestingExportParam.MesBuildingMachinePartNestingExportParamBuilder machineToolId(final String machineToolId) {
         this.machineToolId = machineToolId;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingMachinePartNestingExportParam.MesBuildingMachinePartNestingExportParamBuilder type(final String type) {
         this.type = type;
         return this;
      }

      @JsonProperty("jobId")
      public MesBuildingMachinePartNestingExportParam.MesBuildingMachinePartNestingExportParamBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("name_filter_flag")
      public MesBuildingMachinePartNestingExportParam.MesBuildingMachinePartNestingExportParamBuilder nameFilterFlag(final Boolean nameFilterFlag) {
         this.nameFilterFlag = nameFilterFlag;
         return this;
      }

      public MesBuildingMachinePartNestingExportParam build() {
         return new MesBuildingMachinePartNestingExportParam(this.resultList, this.machineToolId, this.type, this.jobId, this.nameFilterFlag);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartNestingExportParam.MesBuildingMachinePartNestingExportParamBuilder(resultList="
            + this.resultList
            + ", machineToolId="
            + this.machineToolId
            + ", type="
            + this.type
            + ", jobId="
            + this.jobId
            + ", nameFilterFlag="
            + this.nameFilterFlag
            + ")";
      }
   }
}
