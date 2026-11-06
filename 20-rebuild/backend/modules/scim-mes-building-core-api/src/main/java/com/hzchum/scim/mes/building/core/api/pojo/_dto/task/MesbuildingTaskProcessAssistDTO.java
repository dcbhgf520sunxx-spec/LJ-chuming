package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesbuildingTaskProcessAssistDTO", description = "批量工序协同请求类")
public class MesbuildingTaskProcessAssistDTO {
   @ApiModelProperty(name = "taskProcessId", value = "任务工序详情id", notes = "任务工序详情id")
   private Long taskProcessId;
   @ApiModelProperty(name = "productionLineId", value = "生产线Id", notes = "生产线Id")
   private Long productionLineId;
   @ApiModelProperty(name = "quantity", value = "协同数量", notes = "协同数量")
   private Integer quantity;
   @ApiModelProperty(name = "nextProcessIds", notes = "后续工序列表")
   @JsonProperty("nextProcessIds")
   @JSONField(name = "nextProcessIds")
   private List<Long> nextProcessIds;
   @ApiModelProperty(name = "artifactTaskId", value = "构件任务Id", notes = "构件任务Id")
   private Long artifactTaskId;

   public static MesbuildingTaskProcessAssistDTO.MesbuildingTaskProcessAssistDTOBuilder builder() {
      return new MesbuildingTaskProcessAssistDTO.MesbuildingTaskProcessAssistDTOBuilder();
   }

   public MesbuildingTaskProcessAssistDTO() {
   }

   public MesbuildingTaskProcessAssistDTO(
      final Long taskProcessId, final Long productionLineId, final Integer quantity, final List<Long> nextProcessIds, final Long artifactTaskId
   ) {
      this.taskProcessId = taskProcessId;
      this.productionLineId = productionLineId;
      this.quantity = quantity;
      this.nextProcessIds = nextProcessIds;
      this.artifactTaskId = artifactTaskId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public List<Long> getNextProcessIds() {
      return this.nextProcessIds;
   }

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public MesbuildingTaskProcessAssistDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public MesbuildingTaskProcessAssistDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public MesbuildingTaskProcessAssistDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("nextProcessIds")
   public MesbuildingTaskProcessAssistDTO setNextProcessIds(final List<Long> nextProcessIds) {
      this.nextProcessIds = nextProcessIds;
      return this;
   }

   public MesbuildingTaskProcessAssistDTO setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesbuildingTaskProcessAssistDTO)) {
         return false;
      }

      MesbuildingTaskProcessAssistDTO other = (MesbuildingTaskProcessAssistDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskProcessId = this.getTaskProcessId();
      Object other$taskProcessId = other.getTaskProcessId();
      if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$artifactTaskId = this.getArtifactTaskId();
               Object other$artifactTaskId = other.getArtifactTaskId();
               if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
                  Object this$nextProcessIds = this.getNextProcessIds();
                  Object other$nextProcessIds = other.getNextProcessIds();
                  return this$nextProcessIds == null ? other$nextProcessIds == null : this$nextProcessIds.equals(other$nextProcessIds);
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
      return other instanceof MesbuildingTaskProcessAssistDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $nextProcessIds = this.getNextProcessIds();
      return result * 59 + ($nextProcessIds == null ? 43 : $nextProcessIds.hashCode());
   }

   @Override
   public String toString() {
      return "MesbuildingTaskProcessAssistDTO(taskProcessId="
         + this.getTaskProcessId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", quantity="
         + this.getQuantity()
         + ", nextProcessIds="
         + this.getNextProcessIds()
         + ", artifactTaskId="
         + this.getArtifactTaskId()
         + ")";
   }

   public static class MesbuildingTaskProcessAssistDTOBuilder {
      private Long taskProcessId;
      private Long productionLineId;
      private Integer quantity;
      private List<Long> nextProcessIds;
      private Long artifactTaskId;

      MesbuildingTaskProcessAssistDTOBuilder() {
      }

      public MesbuildingTaskProcessAssistDTO.MesbuildingTaskProcessAssistDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesbuildingTaskProcessAssistDTO.MesbuildingTaskProcessAssistDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MesbuildingTaskProcessAssistDTO.MesbuildingTaskProcessAssistDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("nextProcessIds")
      public MesbuildingTaskProcessAssistDTO.MesbuildingTaskProcessAssistDTOBuilder nextProcessIds(final List<Long> nextProcessIds) {
         this.nextProcessIds = nextProcessIds;
         return this;
      }

      public MesbuildingTaskProcessAssistDTO.MesbuildingTaskProcessAssistDTOBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      public MesbuildingTaskProcessAssistDTO build() {
         return new MesbuildingTaskProcessAssistDTO(this.taskProcessId, this.productionLineId, this.quantity, this.nextProcessIds, this.artifactTaskId);
      }

      @Override
      public String toString() {
         return "MesbuildingTaskProcessAssistDTO.MesbuildingTaskProcessAssistDTOBuilder(taskProcessId="
            + this.taskProcessId
            + ", productionLineId="
            + this.productionLineId
            + ", quantity="
            + this.quantity
            + ", nextProcessIds="
            + this.nextProcessIds
            + ", artifactTaskId="
            + this.artifactTaskId
            + ")";
      }
   }
}
