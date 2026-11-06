package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureTaskOrderArtifactDetailDTOParam", description = "零件任务工单请求类")
public class MesEnclosureTaskOrderArtifactDetailDTOParam {
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @NotNull(message = "生产组id")
   private Long groupsId;
   @ApiModelProperty(name = "quantity", value = "下发数量", notes = "下发数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static MesEnclosureTaskOrderArtifactDetailDTOParam.MesEnclosureTaskOrderArtifactDetailDTOParamBuilder builder() {
      return new MesEnclosureTaskOrderArtifactDetailDTOParam.MesEnclosureTaskOrderArtifactDetailDTOParamBuilder();
   }

   public MesEnclosureTaskOrderArtifactDetailDTOParam(final Long schedulingId, final Long groupsId, final Integer quantity) {
      this.schedulingId = schedulingId;
      this.groupsId = groupsId;
      this.quantity = quantity;
   }

   public MesEnclosureTaskOrderArtifactDetailDTOParam() {
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("schedulingId")
   public MesEnclosureTaskOrderArtifactDetailDTOParam setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureTaskOrderArtifactDetailDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureTaskOrderArtifactDetailDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderArtifactDetailDTOParam)) {
         return false;
      }

      MesEnclosureTaskOrderArtifactDetailDTOParam other = (MesEnclosureTaskOrderArtifactDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$schedulingId = this.getSchedulingId();
      Object other$schedulingId = other.getSchedulingId();
      if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTaskOrderArtifactDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderArtifactDetailDTOParam(schedulingId="
         + this.getSchedulingId()
         + ", groupsId="
         + this.getGroupsId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public static class MesEnclosureTaskOrderArtifactDetailDTOParamBuilder {
      private Long schedulingId;
      private Long groupsId;
      private Integer quantity;

      MesEnclosureTaskOrderArtifactDetailDTOParamBuilder() {
      }

      @JsonProperty("schedulingId")
      public MesEnclosureTaskOrderArtifactDetailDTOParam.MesEnclosureTaskOrderArtifactDetailDTOParamBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesEnclosureTaskOrderArtifactDetailDTOParam.MesEnclosureTaskOrderArtifactDetailDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureTaskOrderArtifactDetailDTOParam.MesEnclosureTaskOrderArtifactDetailDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesEnclosureTaskOrderArtifactDetailDTOParam build() {
         return new MesEnclosureTaskOrderArtifactDetailDTOParam(this.schedulingId, this.groupsId, this.quantity);
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderArtifactDetailDTOParam.MesEnclosureTaskOrderArtifactDetailDTOParamBuilder(schedulingId="
            + this.schedulingId
            + ", groupsId="
            + this.groupsId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
