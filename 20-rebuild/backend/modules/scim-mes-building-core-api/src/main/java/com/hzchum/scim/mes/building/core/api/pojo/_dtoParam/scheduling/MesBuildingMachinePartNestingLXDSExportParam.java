package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingMachinePartNestingExportParam", description = "零件套料排产零件")
public class MesBuildingMachinePartNestingLXDSExportParam {
   @ApiModelProperty(name = "result_list", value = "结果集", notes = "结果集")
   @JsonProperty("result_list")
   @JSONField(name = "result_list")
   private List<String> result_list;
   @ApiModelProperty(name = "job_id", value = "作业id", notes = "作业id")
   @JsonProperty("job_id")
   @JSONField(name = "job_id")
   private Integer job_id;

   public static MesBuildingMachinePartNestingLXDSExportParam.MesBuildingMachinePartNestingLXDSExportParamBuilder builder() {
      return new MesBuildingMachinePartNestingLXDSExportParam.MesBuildingMachinePartNestingLXDSExportParamBuilder();
   }

   public MesBuildingMachinePartNestingLXDSExportParam(final List<String> result_list, final Integer job_id) {
      this.result_list = result_list;
      this.job_id = job_id;
   }

   public MesBuildingMachinePartNestingLXDSExportParam() {
   }

   public List<String> getResult_list() {
      return this.result_list;
   }

   public Integer getJob_id() {
      return this.job_id;
   }

   @JsonProperty("result_list")
   public MesBuildingMachinePartNestingLXDSExportParam setResult_list(final List<String> result_list) {
      this.result_list = result_list;
      return this;
   }

   @JsonProperty("job_id")
   public MesBuildingMachinePartNestingLXDSExportParam setJob_id(final Integer job_id) {
      this.job_id = job_id;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartNestingLXDSExportParam(result_list=" + this.getResult_list() + ", job_id=" + this.getJob_id() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingMachinePartNestingLXDSExportParam)) {
         return false;
      } else {
         MesBuildingMachinePartNestingLXDSExportParam other = (MesBuildingMachinePartNestingLXDSExportParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$job_id = this.getJob_id();
            Object other$job_id = other.getJob_id();
            if (this$job_id == null ? other$job_id == null : this$job_id.equals(other$job_id)) {
               Object this$result_list = this.getResult_list();
               Object other$result_list = other.getResult_list();
               return this$result_list == null ? other$result_list == null : this$result_list.equals(other$result_list);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartNestingLXDSExportParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $job_id = this.getJob_id();
      result = result * 59 + ($job_id == null ? 43 : $job_id.hashCode());
      Object $result_list = this.getResult_list();
      return result * 59 + ($result_list == null ? 43 : $result_list.hashCode());
   }

   public static class MesBuildingMachinePartNestingLXDSExportParamBuilder {
      private List<String> result_list;
      private Integer job_id;

      MesBuildingMachinePartNestingLXDSExportParamBuilder() {
      }

      @JsonProperty("result_list")
      public MesBuildingMachinePartNestingLXDSExportParam.MesBuildingMachinePartNestingLXDSExportParamBuilder result_list(final List<String> result_list) {
         this.result_list = result_list;
         return this;
      }

      @JsonProperty("job_id")
      public MesBuildingMachinePartNestingLXDSExportParam.MesBuildingMachinePartNestingLXDSExportParamBuilder job_id(final Integer job_id) {
         this.job_id = job_id;
         return this;
      }

      public MesBuildingMachinePartNestingLXDSExportParam build() {
         return new MesBuildingMachinePartNestingLXDSExportParam(this.result_list, this.job_id);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartNestingLXDSExportParam.MesBuildingMachinePartNestingLXDSExportParamBuilder(result_list="
            + this.result_list
            + ", job_id="
            + this.job_id
            + ")";
      }
   }
}
