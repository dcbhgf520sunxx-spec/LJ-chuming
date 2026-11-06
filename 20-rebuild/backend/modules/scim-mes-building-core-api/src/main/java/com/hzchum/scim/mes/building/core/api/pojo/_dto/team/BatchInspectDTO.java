package com.hzchum.scim.mes.building.core.api.pojo._dto.team;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "批量上报DTO", description = "")
public class BatchInspectDTO {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "taskProcessId", value = "工序任务id", notes = "工序任务id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "taskTypeEnum", value = "产品类型", notes = "产品类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "processId", value = "产品id", notes = "产品id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;

   public Long getProductId() {
      return this.productId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   @JsonProperty("productId")
   public BatchInspectDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public BatchInspectDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public BatchInspectDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("teamId")
   public BatchInspectDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("processId")
   public BatchInspectDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @Override
   public String toString() {
      return "BatchInspectDTO(productId="
         + this.getProductId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", teamId="
         + this.getTeamId()
         + ", processId="
         + this.getProcessId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchInspectDTO)) {
         return false;
      }

      BatchInspectDTO other = (BatchInspectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$taskProcessId = this.getTaskProcessId();
         Object other$taskProcessId = other.getTaskProcessId();
         if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  return this$processId == null ? other$processId == null : this$processId.equals(other$processId);
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
      return other instanceof BatchInspectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $processId = this.getProcessId();
      return result * 59 + ($processId == null ? 43 : $processId.hashCode());
   }
}
