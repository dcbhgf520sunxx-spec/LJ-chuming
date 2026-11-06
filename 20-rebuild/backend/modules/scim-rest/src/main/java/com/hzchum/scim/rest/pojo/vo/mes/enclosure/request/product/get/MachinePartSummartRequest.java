package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.product.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MachinePartSummartRequest", description = "零件汇总请求类")
public class MachinePartSummartRequest {
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

   public static MachinePartSummartRequest.MachinePartSummartRequestBuilder builder() {
      return new MachinePartSummartRequest.MachinePartSummartRequestBuilder();
   }

   public MachinePartSummartRequest(
      final Long projectId, final Long monomerId, final List<Long> areaIds, final Boolean boolAbnormalEnum, final Integer statusType
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaIds = areaIds;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.statusType = statusType;
   }

   public MachinePartSummartRequest() {
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
   public MachinePartSummartRequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MachinePartSummartRequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaIds")
   public MachinePartSummartRequest setAreaIds(final List<Long> areaIds) {
      this.areaIds = areaIds;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public MachinePartSummartRequest setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("statusType")
   public MachinePartSummartRequest setStatusType(final Integer statusType) {
      this.statusType = statusType;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartSummartRequest(projectId="
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

      if (!(o instanceof MachinePartSummartRequest)) {
         return false;
      }

      MachinePartSummartRequest other = (MachinePartSummartRequest)o;
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
      return other instanceof MachinePartSummartRequest;
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

   public static class MachinePartSummartRequestBuilder {
      private Long projectId;
      private Long monomerId;
      private List<Long> areaIds;
      private Boolean boolAbnormalEnum;
      private Integer statusType;

      MachinePartSummartRequestBuilder() {
      }

      @JsonProperty("projectId")
      public MachinePartSummartRequest.MachinePartSummartRequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MachinePartSummartRequest.MachinePartSummartRequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaIds")
      public MachinePartSummartRequest.MachinePartSummartRequestBuilder areaIds(final List<Long> areaIds) {
         this.areaIds = areaIds;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public MachinePartSummartRequest.MachinePartSummartRequestBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("statusType")
      public MachinePartSummartRequest.MachinePartSummartRequestBuilder statusType(final Integer statusType) {
         this.statusType = statusType;
         return this;
      }

      public MachinePartSummartRequest build() {
         return new MachinePartSummartRequest(this.projectId, this.monomerId, this.areaIds, this.boolAbnormalEnum, this.statusType);
      }

      @Override
      public String toString() {
         return "MachinePartSummartRequest.MachinePartSummartRequestBuilder(projectId="
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
