package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MachinePartSummartDOParam", description = "零件汇总请求类")
public class MachinePartSummartDOParam {
   @ApiModelProperty(name = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planIds")
   @JsonProperty("planIds")
   @JSONField(name = "planIds")
   private List<Long> planIds;
   @ApiModelProperty(name = "boolAbnormalEnum", notes = "是否异常")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   private Boolean boolAbnormalEnum;

   public static MachinePartSummartDOParam.MachinePartSummartDOParamBuilder builder() {
      return new MachinePartSummartDOParam.MachinePartSummartDOParamBuilder();
   }

   public MachinePartSummartDOParam(final Long projectId, final Long monomerId, final List<Long> planIds, final Boolean boolAbnormalEnum) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planIds = planIds;
      this.boolAbnormalEnum = boolAbnormalEnum;
   }

   public MachinePartSummartDOParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getPlanIds() {
      return this.planIds;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   @JsonProperty("projectId")
   public MachinePartSummartDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MachinePartSummartDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planIds")
   public MachinePartSummartDOParam setPlanIds(final List<Long> planIds) {
      this.planIds = planIds;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public MachinePartSummartDOParam setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartSummartDOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planIds="
         + this.getPlanIds()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartSummartDOParam)) {
         return false;
      }

      MachinePartSummartDOParam other = (MachinePartSummartDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
            Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
            if (this$boolAbnormalEnum == null ? other$boolAbnormalEnum == null : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
               Object this$planIds = this.getPlanIds();
               Object other$planIds = other.getPlanIds();
               return this$planIds == null ? other$planIds == null : this$planIds.equals(other$planIds);
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
      return other instanceof MachinePartSummartDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $planIds = this.getPlanIds();
      return result * 59 + ($planIds == null ? 43 : $planIds.hashCode());
   }

   public static class MachinePartSummartDOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private List<Long> planIds;
      private Boolean boolAbnormalEnum;

      MachinePartSummartDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public MachinePartSummartDOParam.MachinePartSummartDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MachinePartSummartDOParam.MachinePartSummartDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planIds")
      public MachinePartSummartDOParam.MachinePartSummartDOParamBuilder planIds(final List<Long> planIds) {
         this.planIds = planIds;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public MachinePartSummartDOParam.MachinePartSummartDOParamBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      public MachinePartSummartDOParam build() {
         return new MachinePartSummartDOParam(this.projectId, this.monomerId, this.planIds, this.boolAbnormalEnum);
      }

      @Override
      public String toString() {
         return "MachinePartSummartDOParam.MachinePartSummartDOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planIds="
            + this.planIds
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ")";
      }
   }
}
