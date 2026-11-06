package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingTaskProcessMachinePartDO", description = "零件专用汇总表 ")
public class MesBuildingTaskProcessMachinePartDO {
   @ApiModelProperty(name = "needQuantity", notes = "此道工序需要完成数量")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   private Integer needQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "此道工序已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "inspectionQuantity", notes = "通过质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "problemQuantity", notes = "问题上报数量")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   private Integer problemQuantity;

   public static MesBuildingTaskProcessMachinePartDO.MesBuildingTaskProcessMachinePartDOBuilder builder() {
      return new MesBuildingTaskProcessMachinePartDO.MesBuildingTaskProcessMachinePartDOBuilder();
   }

   public MesBuildingTaskProcessMachinePartDO() {
   }

   public MesBuildingTaskProcessMachinePartDO(
      final Integer needQuantity, final Integer completeQuantity, final Integer inspectionQuantity, final Integer problemQuantity
   ) {
      this.needQuantity = needQuantity;
      this.completeQuantity = completeQuantity;
      this.inspectionQuantity = inspectionQuantity;
      this.problemQuantity = problemQuantity;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   @JsonProperty("needQuantity")
   public MesBuildingTaskProcessMachinePartDO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingTaskProcessMachinePartDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesBuildingTaskProcessMachinePartDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesBuildingTaskProcessMachinePartDO setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskProcessMachinePartDO(needQuantity="
         + this.getNeedQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskProcessMachinePartDO)) {
         return false;
      }

      MesBuildingTaskProcessMachinePartDO other = (MesBuildingTaskProcessMachinePartDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$needQuantity = this.getNeedQuantity();
      Object other$needQuantity = other.getNeedQuantity();
      if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$inspectionQuantity = this.getInspectionQuantity();
            Object other$inspectionQuantity = other.getInspectionQuantity();
            if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
               Object this$problemQuantity = this.getProblemQuantity();
               Object other$problemQuantity = other.getProblemQuantity();
               return this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity);
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
      return other instanceof MesBuildingTaskProcessMachinePartDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      return result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
   }

   public static class MesBuildingTaskProcessMachinePartDOBuilder {
      private Integer needQuantity;
      private Integer completeQuantity;
      private Integer inspectionQuantity;
      private Integer problemQuantity;

      MesBuildingTaskProcessMachinePartDOBuilder() {
      }

      @JsonProperty("needQuantity")
      public MesBuildingTaskProcessMachinePartDO.MesBuildingTaskProcessMachinePartDOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingTaskProcessMachinePartDO.MesBuildingTaskProcessMachinePartDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesBuildingTaskProcessMachinePartDO.MesBuildingTaskProcessMachinePartDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesBuildingTaskProcessMachinePartDO.MesBuildingTaskProcessMachinePartDOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      public MesBuildingTaskProcessMachinePartDO build() {
         return new MesBuildingTaskProcessMachinePartDO(this.needQuantity, this.completeQuantity, this.inspectionQuantity, this.problemQuantity);
      }

      @Override
      public String toString() {
         return "MesBuildingTaskProcessMachinePartDO.MesBuildingTaskProcessMachinePartDOBuilder(needQuantity="
            + this.needQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", problemQuantity="
            + this.problemQuantity
            + ")";
      }
   }
}
