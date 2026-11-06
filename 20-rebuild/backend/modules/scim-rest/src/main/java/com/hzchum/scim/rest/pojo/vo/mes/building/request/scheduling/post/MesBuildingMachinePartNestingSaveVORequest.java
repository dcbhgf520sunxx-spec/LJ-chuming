package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingMachinePartNestingSaveVORequest", description = "零件套料请求类")
public class MesBuildingMachinePartNestingSaveVORequest {
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

   public static MesBuildingMachinePartNestingSaveVORequest.MesBuildingMachinePartNestingSaveVORequestBuilder builder() {
      return new MesBuildingMachinePartNestingSaveVORequest.MesBuildingMachinePartNestingSaveVORequestBuilder();
   }

   public MesBuildingMachinePartNestingSaveVORequest(final Long schedulingId, final Long cutConfigId) {
      this.schedulingId = schedulingId;
      this.cutConfigId = cutConfigId;
   }

   public MesBuildingMachinePartNestingSaveVORequest() {
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   @JsonProperty("schedulingId")
   public MesBuildingMachinePartNestingSaveVORequest setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingMachinePartNestingSaveVORequest setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingMachinePartNestingSaveVORequest)) {
         return false;
      } else {
         MesBuildingMachinePartNestingSaveVORequest other = (MesBuildingMachinePartNestingSaveVORequest)o;
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
      return other instanceof MesBuildingMachinePartNestingSaveVORequest;
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
      return "MesBuildingMachinePartNestingSaveVORequest(schedulingId=" + this.getSchedulingId() + ", cutConfigId=" + this.getCutConfigId() + ")";
   }

   public static class MesBuildingMachinePartNestingSaveVORequestBuilder {
      private Long schedulingId;
      private Long cutConfigId;

      MesBuildingMachinePartNestingSaveVORequestBuilder() {
      }

      @JsonProperty("schedulingId")
      public MesBuildingMachinePartNestingSaveVORequest.MesBuildingMachinePartNestingSaveVORequestBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingMachinePartNestingSaveVORequest.MesBuildingMachinePartNestingSaveVORequestBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      public MesBuildingMachinePartNestingSaveVORequest build() {
         return new MesBuildingMachinePartNestingSaveVORequest(this.schedulingId, this.cutConfigId);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartNestingSaveVORequest.MesBuildingMachinePartNestingSaveVORequestBuilder(schedulingId="
            + this.schedulingId
            + ", cutConfigId="
            + this.cutConfigId
            + ")";
      }
   }
}
