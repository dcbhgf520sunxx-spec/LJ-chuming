package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingMachinePartNestingExportParam", description = "零件套料排产零件")
public class MesBuildingMachinePartNestingNCExportParam {
   @ApiModelProperty(name = "result_list", value = "结果集", notes = "结果集")
   @JsonProperty("result_list")
   @JSONField(name = "result_list")
   private List<String> result_list;
   @ApiModelProperty(name = "type", value = "类型", notes = "类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private String type;
   @ApiModelProperty(name = "job_id", value = "作业id", notes = "作业id")
   @JsonProperty("job_id")
   @JSONField(name = "job_id")
   private Integer job_id;
   @ApiModelProperty(name = "name_filter_flag", value = "是否过滤名称", notes = "是否过滤名称")
   @JsonProperty("name_filter_flag")
   @JSONField(name = "name_filter_flag")
   private Boolean name_filter_flag;

   public static MesBuildingMachinePartNestingNCExportParam.MesBuildingMachinePartNestingNCExportParamBuilder builder() {
      return new MesBuildingMachinePartNestingNCExportParam.MesBuildingMachinePartNestingNCExportParamBuilder();
   }

   public MesBuildingMachinePartNestingNCExportParam(final List<String> result_list, final String type, final Integer job_id, final Boolean name_filter_flag) {
      this.result_list = result_list;
      this.type = type;
      this.job_id = job_id;
      this.name_filter_flag = name_filter_flag;
   }

   public MesBuildingMachinePartNestingNCExportParam() {
   }

   public List<String> getResult_list() {
      return this.result_list;
   }

   public String getType() {
      return this.type;
   }

   public Integer getJob_id() {
      return this.job_id;
   }

   public Boolean getName_filter_flag() {
      return this.name_filter_flag;
   }

   @JsonProperty("result_list")
   public MesBuildingMachinePartNestingNCExportParam setResult_list(final List<String> result_list) {
      this.result_list = result_list;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingMachinePartNestingNCExportParam setType(final String type) {
      this.type = type;
      return this;
   }

   @JsonProperty("job_id")
   public MesBuildingMachinePartNestingNCExportParam setJob_id(final Integer job_id) {
      this.job_id = job_id;
      return this;
   }

   @JsonProperty("name_filter_flag")
   public MesBuildingMachinePartNestingNCExportParam setName_filter_flag(final Boolean name_filter_flag) {
      this.name_filter_flag = name_filter_flag;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartNestingNCExportParam(result_list="
         + this.getResult_list()
         + ", type="
         + this.getType()
         + ", job_id="
         + this.getJob_id()
         + ", name_filter_flag="
         + this.getName_filter_flag()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartNestingNCExportParam)) {
         return false;
      }

      MesBuildingMachinePartNestingNCExportParam other = (MesBuildingMachinePartNestingNCExportParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$job_id = this.getJob_id();
      Object other$job_id = other.getJob_id();
      if (this$job_id == null ? other$job_id == null : this$job_id.equals(other$job_id)) {
         Object this$name_filter_flag = this.getName_filter_flag();
         Object other$name_filter_flag = other.getName_filter_flag();
         if (this$name_filter_flag == null ? other$name_filter_flag == null : this$name_filter_flag.equals(other$name_filter_flag)) {
            Object this$result_list = this.getResult_list();
            Object other$result_list = other.getResult_list();
            if (this$result_list == null ? other$result_list == null : this$result_list.equals(other$result_list)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartNestingNCExportParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $job_id = this.getJob_id();
      result = result * 59 + ($job_id == null ? 43 : $job_id.hashCode());
      Object $name_filter_flag = this.getName_filter_flag();
      result = result * 59 + ($name_filter_flag == null ? 43 : $name_filter_flag.hashCode());
      Object $result_list = this.getResult_list();
      result = result * 59 + ($result_list == null ? 43 : $result_list.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   public static class MesBuildingMachinePartNestingNCExportParamBuilder {
      private List<String> result_list;
      private String type;
      private Integer job_id;
      private Boolean name_filter_flag;

      MesBuildingMachinePartNestingNCExportParamBuilder() {
      }

      @JsonProperty("result_list")
      public MesBuildingMachinePartNestingNCExportParam.MesBuildingMachinePartNestingNCExportParamBuilder result_list(final List<String> result_list) {
         this.result_list = result_list;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingMachinePartNestingNCExportParam.MesBuildingMachinePartNestingNCExportParamBuilder type(final String type) {
         this.type = type;
         return this;
      }

      @JsonProperty("job_id")
      public MesBuildingMachinePartNestingNCExportParam.MesBuildingMachinePartNestingNCExportParamBuilder job_id(final Integer job_id) {
         this.job_id = job_id;
         return this;
      }

      @JsonProperty("name_filter_flag")
      public MesBuildingMachinePartNestingNCExportParam.MesBuildingMachinePartNestingNCExportParamBuilder name_filter_flag(final Boolean name_filter_flag) {
         this.name_filter_flag = name_filter_flag;
         return this;
      }

      public MesBuildingMachinePartNestingNCExportParam build() {
         return new MesBuildingMachinePartNestingNCExportParam(this.result_list, this.type, this.job_id, this.name_filter_flag);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartNestingNCExportParam.MesBuildingMachinePartNestingNCExportParamBuilder(result_list="
            + this.result_list
            + ", type="
            + this.type
            + ", job_id="
            + this.job_id
            + ", name_filter_flag="
            + this.name_filter_flag
            + ")";
      }
   }
}
