package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingTaskOrderArtifactDetailDTOParam", description = "零件任务工单请求类")
public class MesBuildingTaskOrderArtifactDetailDTOParam {
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @NotNull(message = "生产组id")
   private Long groupsId;
   @ApiModelProperty(name = "prodLineId", value = "生产线Id", notes = "生产线Id")
   @JsonProperty("prodLineId")
   @JSONField(name = "prodLineId")
   @NotNull(message = "生产线Id")
   private Long prodLineId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @NotNull(message = "区域Id")
   private Long areaId;
   @ApiModelProperty(name = "areaId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @NotNull(message = "批次Id")
   private Long areaBatchId;
   @ApiModelProperty(name = "quantity", value = "下发数量", notes = "下发数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder builder() {
      return new MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder();
   }

   public MesBuildingTaskOrderArtifactDetailDTOParam(
      final Long schedulingId,
      final Long productId,
      final LocalDateTime askCompleteTime,
      final Long groupsId,
      final Long prodLineId,
      final Long areaId,
      final Long areaBatchId,
      final Integer quantity
   ) {
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.askCompleteTime = askCompleteTime;
      this.groupsId = groupsId;
      this.prodLineId = prodLineId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.quantity = quantity;
   }

   public MesBuildingTaskOrderArtifactDetailDTOParam() {
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProdLineId() {
      return this.prodLineId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("schedulingId")
   public MesBuildingTaskOrderArtifactDetailDTOParam setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskOrderArtifactDetailDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskOrderArtifactDetailDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskOrderArtifactDetailDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("prodLineId")
   public MesBuildingTaskOrderArtifactDetailDTOParam setProdLineId(final Long prodLineId) {
      this.prodLineId = prodLineId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTaskOrderArtifactDetailDTOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTaskOrderArtifactDetailDTOParam setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskOrderArtifactDetailDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderArtifactDetailDTOParam)) {
         return false;
      }

      MesBuildingTaskOrderArtifactDetailDTOParam other = (MesBuildingTaskOrderArtifactDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$schedulingId = this.getSchedulingId();
      Object other$schedulingId = other.getSchedulingId();
      if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$groupsId = this.getGroupsId();
            Object other$groupsId = other.getGroupsId();
            if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
               Object this$prodLineId = this.getProdLineId();
               Object other$prodLineId = other.getProdLineId();
               if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$areaBatchId = this.getAreaBatchId();
                     Object other$areaBatchId = other.getAreaBatchId();
                     if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$askCompleteTime = this.getAskCompleteTime();
                           Object other$askCompleteTime = other.getAskCompleteTime();
                           return this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof MesBuildingTaskOrderArtifactDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderArtifactDetailDTOParam(schedulingId="
         + this.getSchedulingId()
         + ", productId="
         + this.getProductId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", groupsId="
         + this.getGroupsId()
         + ", prodLineId="
         + this.getProdLineId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public static class MesBuildingTaskOrderArtifactDetailDTOParamBuilder {
      private Long schedulingId;
      private Long productId;
      private LocalDateTime askCompleteTime;
      private Long groupsId;
      private Long prodLineId;
      private Long areaId;
      private Long areaBatchId;
      private Integer quantity;

      MesBuildingTaskOrderArtifactDetailDTOParamBuilder() {
      }

      @JsonProperty("schedulingId")
      public MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("prodLineId")
      public MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder prodLineId(final Long prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingTaskOrderArtifactDetailDTOParam build() {
         return new MesBuildingTaskOrderArtifactDetailDTOParam(
            this.schedulingId, this.productId, this.askCompleteTime, this.groupsId, this.prodLineId, this.areaId, this.areaBatchId, this.quantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderArtifactDetailDTOParam.MesBuildingTaskOrderArtifactDetailDTOParamBuilder(schedulingId="
            + this.schedulingId
            + ", productId="
            + this.productId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", groupsId="
            + this.groupsId
            + ", prodLineId="
            + this.prodLineId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
