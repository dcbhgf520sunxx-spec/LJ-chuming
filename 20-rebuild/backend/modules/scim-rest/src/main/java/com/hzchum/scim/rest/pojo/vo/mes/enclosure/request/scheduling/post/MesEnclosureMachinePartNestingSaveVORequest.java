package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureMachinePartNestingSaveVORequest", description = "零件套料请求类")
public class MesEnclosureMachinePartNestingSaveVORequest {
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

   public static MesEnclosureMachinePartNestingSaveVORequest.MesEnclosureMachinePartNestingSaveVORequestBuilder builder() {
      return new MesEnclosureMachinePartNestingSaveVORequest.MesEnclosureMachinePartNestingSaveVORequestBuilder();
   }

   public MesEnclosureMachinePartNestingSaveVORequest(final Long schedulingId, final Long cutConfigId) {
      this.schedulingId = schedulingId;
      this.cutConfigId = cutConfigId;
   }

   public MesEnclosureMachinePartNestingSaveVORequest() {
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   @JsonProperty("schedulingId")
   public MesEnclosureMachinePartNestingSaveVORequest setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesEnclosureMachinePartNestingSaveVORequest setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosureMachinePartNestingSaveVORequest)) {
         return false;
      } else {
         MesEnclosureMachinePartNestingSaveVORequest other = (MesEnclosureMachinePartNestingSaveVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$schedulingId = this.getSchedulingId();
            Object other$schedulingId = other.getSchedulingId();
            if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
               Object this$cutConfigId = this.getCutConfigId();
               Object other$cutConfigId = other.getCutConfigId();
               return this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureMachinePartNestingSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      return result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureMachinePartNestingSaveVORequest(schedulingId=" + this.getSchedulingId() + ", cutConfigId=" + this.getCutConfigId() + ")";
   }

   public static class MesEnclosureMachinePartNestingSaveVORequestBuilder {
      private Long schedulingId;
      private Long cutConfigId;

      MesEnclosureMachinePartNestingSaveVORequestBuilder() {
      }

      @JsonProperty("schedulingId")
      public MesEnclosureMachinePartNestingSaveVORequest.MesEnclosureMachinePartNestingSaveVORequestBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesEnclosureMachinePartNestingSaveVORequest.MesEnclosureMachinePartNestingSaveVORequestBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      public MesEnclosureMachinePartNestingSaveVORequest build() {
         return new MesEnclosureMachinePartNestingSaveVORequest(this.schedulingId, this.cutConfigId);
      }

      @Override
      public String toString() {
         return "MesEnclosureMachinePartNestingSaveVORequest.MesEnclosureMachinePartNestingSaveVORequestBuilder(schedulingId="
            + this.schedulingId
            + ", cutConfigId="
            + this.cutConfigId
            + ")";
      }
   }
}
