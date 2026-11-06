package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingArtifactSchedulingRecordUpdateVORequest", description = "构件排产请求类")
public class MesBuildingArtifactSchedulingRecordUpdateVORequest {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @NotNull(message = "车间id不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @NotNull(message = "生产线id不能为空")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "排产数量不能为空")
   @Min(value = 1L, message = "排产数量不能小于1")
   private Integer quantity;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @NotNull(message = "要求完成日期不能为空")
   private LocalDateTime askCompleteTime;

   public static MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder builder() {
      return new MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   @JsonProperty("id")
   public MesBuildingArtifactSchedulingRecordUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingArtifactSchedulingRecordUpdateVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingArtifactSchedulingRecordUpdateVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingArtifactSchedulingRecordUpdateVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingArtifactSchedulingRecordUpdateVORequest setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactSchedulingRecordUpdateVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingArtifactSchedulingRecordUpdateVORequest setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactSchedulingRecordUpdateVORequest)) {
         return false;
      }

      MesBuildingArtifactSchedulingRecordUpdateVORequest other = (MesBuildingArtifactSchedulingRecordUpdateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$groupsId = this.getGroupsId();
                  Object other$groupsId = other.getGroupsId();
                  if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactSchedulingRecordUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingRecordUpdateVORequest(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", quantity="
         + this.getQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ")";
   }

   public MesBuildingArtifactSchedulingRecordUpdateVORequest(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Integer quantity,
      final LocalDateTime askCompleteTime
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.quantity = quantity;
      this.askCompleteTime = askCompleteTime;
   }

   public MesBuildingArtifactSchedulingRecordUpdateVORequest() {
   }

   public static class MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Integer quantity;
      private LocalDateTime askCompleteTime;

      MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder productionLineId(
         final Long productionLineId
      ) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder askCompleteTime(
         final LocalDateTime askCompleteTime
      ) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesBuildingArtifactSchedulingRecordUpdateVORequest build() {
         return new MesBuildingArtifactSchedulingRecordUpdateVORequest(
            this.id, this.factoryId, this.workshopId, this.productionLineId, this.groupsId, this.quantity, this.askCompleteTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingRecordUpdateVORequest.MesBuildingArtifactSchedulingRecordUpdateVORequestBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", quantity="
            + this.quantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ")";
      }
   }
}
