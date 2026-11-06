package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MachinePartSummartDTOParam", description = "零件汇总请求类")
public class MachinePartSummartDTOParam {
   @ApiModelProperty(name = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaIds")
   @JsonProperty("areaIds")
   @JSONField(name = "areaIds")
   private List<Long> areaIds;
   @ApiModelProperty(name = "boolAbnormalEnum", notes = "是否异常")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "statusType", notes = "1:未排产,2:未排产完成,4:已排产完成")
   @JsonProperty("statusType")
   @JSONField(name = "statusType")
   private Integer statusType;

   public static MachinePartSummartDTOParam.MachinePartSummartDTOParamBuilder builder() {
      return new MachinePartSummartDTOParam.MachinePartSummartDTOParamBuilder();
   }

   public MachinePartSummartDTOParam(
      final Long projectId, final Long monomerId, final List<Long> areaIds, final Boolean boolAbnormalEnum, final Integer statusType
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaIds = areaIds;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.statusType = statusType;
   }

   public MachinePartSummartDTOParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getAreaIds() {
      return this.areaIds;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   public Integer getStatusType() {
      return this.statusType;
   }

   @JsonProperty("projectId")
   public MachinePartSummartDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MachinePartSummartDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaIds")
   public MachinePartSummartDTOParam setAreaIds(final List<Long> areaIds) {
      this.areaIds = areaIds;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public MachinePartSummartDTOParam setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("statusType")
   public MachinePartSummartDTOParam setStatusType(final Integer statusType) {
      this.statusType = statusType;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartSummartDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaIds="
         + this.getAreaIds()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", statusType="
         + this.getStatusType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartSummartDTOParam)) {
         return false;
      }

      MachinePartSummartDTOParam other = (MachinePartSummartDTOParam)o;
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
               Object this$statusType = this.getStatusType();
               Object other$statusType = other.getStatusType();
               if (this$statusType == null ? other$statusType == null : this$statusType.equals(other$statusType)) {
                  Object this$areaIds = this.getAreaIds();
                  Object other$areaIds = other.getAreaIds();
                  return this$areaIds == null ? other$areaIds == null : this$areaIds.equals(other$areaIds);
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
      return other instanceof MachinePartSummartDTOParam;
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
      Object $statusType = this.getStatusType();
      result = result * 59 + ($statusType == null ? 43 : $statusType.hashCode());
      Object $areaIds = this.getAreaIds();
      return result * 59 + ($areaIds == null ? 43 : $areaIds.hashCode());
   }

   public static class MachinePartSummartDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private List<Long> areaIds;
      private Boolean boolAbnormalEnum;
      private Integer statusType;

      MachinePartSummartDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public MachinePartSummartDTOParam.MachinePartSummartDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MachinePartSummartDTOParam.MachinePartSummartDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaIds")
      public MachinePartSummartDTOParam.MachinePartSummartDTOParamBuilder areaIds(final List<Long> areaIds) {
         this.areaIds = areaIds;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public MachinePartSummartDTOParam.MachinePartSummartDTOParamBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("statusType")
      public MachinePartSummartDTOParam.MachinePartSummartDTOParamBuilder statusType(final Integer statusType) {
         this.statusType = statusType;
         return this;
      }

      public MachinePartSummartDTOParam build() {
         return new MachinePartSummartDTOParam(this.projectId, this.monomerId, this.areaIds, this.boolAbnormalEnum, this.statusType);
      }

      @Override
      public String toString() {
         return "MachinePartSummartDTOParam.MachinePartSummartDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaIds="
            + this.areaIds
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", statusType="
            + this.statusType
            + ")";
      }
   }
}
