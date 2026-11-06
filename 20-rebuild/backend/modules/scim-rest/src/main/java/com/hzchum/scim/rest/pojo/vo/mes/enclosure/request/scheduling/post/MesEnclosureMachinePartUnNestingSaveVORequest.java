package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureMachinePartNestingSaveVORequest", description = "零件套料请求类")
public class MesEnclosureMachinePartUnNestingSaveVORequest {
   @ApiModelProperty(name = "schedulingId", value = "零件排产id", notes = "零件排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @NotNull(message = "零件排产id不能为空")
   private Long schedulingId;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   @NotNull(message = "切割配置id不能为空")
   private Long cutConfigId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @NotNull(message = "生产组id不能为空")
   private Long groupsId;
   @ApiModelProperty(name = "artifactDateTime", value = "构件排产日期")
   @JsonProperty("artifactDateTime")
   @JSONField(name = "artifactDateTime")
   @NotNull(message = "构件排产日期不能为空")
   private LocalDateTime artifactDateTime;

   public static MesEnclosureMachinePartUnNestingSaveVORequest.MesEnclosureMachinePartUnNestingSaveVORequestBuilder builder() {
      return new MesEnclosureMachinePartUnNestingSaveVORequest.MesEnclosureMachinePartUnNestingSaveVORequestBuilder();
   }

   public MesEnclosureMachinePartUnNestingSaveVORequest(
      final Long schedulingId, final Long cutConfigId, final Long groupsId, final LocalDateTime artifactDateTime
   ) {
      this.schedulingId = schedulingId;
      this.cutConfigId = cutConfigId;
      this.groupsId = groupsId;
      this.artifactDateTime = artifactDateTime;
   }

   public MesEnclosureMachinePartUnNestingSaveVORequest() {
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public LocalDateTime getArtifactDateTime() {
      return this.artifactDateTime;
   }

   @JsonProperty("schedulingId")
   public MesEnclosureMachinePartUnNestingSaveVORequest setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesEnclosureMachinePartUnNestingSaveVORequest setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureMachinePartUnNestingSaveVORequest setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("artifactDateTime")
   public MesEnclosureMachinePartUnNestingSaveVORequest setArtifactDateTime(final LocalDateTime artifactDateTime) {
      this.artifactDateTime = artifactDateTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartUnNestingSaveVORequest)) {
         return false;
      }

      MesEnclosureMachinePartUnNestingSaveVORequest other = (MesEnclosureMachinePartUnNestingSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$schedulingId = this.getSchedulingId();
      Object other$schedulingId = other.getSchedulingId();
      if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
         Object this$cutConfigId = this.getCutConfigId();
         Object other$cutConfigId = other.getCutConfigId();
         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
            Object this$groupsId = this.getGroupsId();
            Object other$groupsId = other.getGroupsId();
            if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
               Object this$artifactDateTime = this.getArtifactDateTime();
               Object other$artifactDateTime = other.getArtifactDateTime();
               return this$artifactDateTime == null ? other$artifactDateTime == null : this$artifactDateTime.equals(other$artifactDateTime);
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
      return other instanceof MesEnclosureMachinePartUnNestingSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $artifactDateTime = this.getArtifactDateTime();
      return result * 59 + ($artifactDateTime == null ? 43 : $artifactDateTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureMachinePartUnNestingSaveVORequest(schedulingId="
         + this.getSchedulingId()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", groupsId="
         + this.getGroupsId()
         + ", artifactDateTime="
         + this.getArtifactDateTime()
         + ")";
   }

   public static class MesEnclosureMachinePartUnNestingSaveVORequestBuilder {
      private Long schedulingId;
      private Long cutConfigId;
      private Long groupsId;
      private LocalDateTime artifactDateTime;

      MesEnclosureMachinePartUnNestingSaveVORequestBuilder() {
      }

      @JsonProperty("schedulingId")
      public MesEnclosureMachinePartUnNestingSaveVORequest.MesEnclosureMachinePartUnNestingSaveVORequestBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesEnclosureMachinePartUnNestingSaveVORequest.MesEnclosureMachinePartUnNestingSaveVORequestBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesEnclosureMachinePartUnNestingSaveVORequest.MesEnclosureMachinePartUnNestingSaveVORequestBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("artifactDateTime")
      public MesEnclosureMachinePartUnNestingSaveVORequest.MesEnclosureMachinePartUnNestingSaveVORequestBuilder artifactDateTime(
         final LocalDateTime artifactDateTime
      ) {
         this.artifactDateTime = artifactDateTime;
         return this;
      }

      public MesEnclosureMachinePartUnNestingSaveVORequest build() {
         return new MesEnclosureMachinePartUnNestingSaveVORequest(this.schedulingId, this.cutConfigId, this.groupsId, this.artifactDateTime);
      }

      @Override
      public String toString() {
         return "MesEnclosureMachinePartUnNestingSaveVORequest.MesEnclosureMachinePartUnNestingSaveVORequestBuilder(schedulingId="
            + this.schedulingId
            + ", cutConfigId="
            + this.cutConfigId
            + ", groupsId="
            + this.groupsId
            + ", artifactDateTime="
            + this.artifactDateTime
            + ")";
      }
   }
}
