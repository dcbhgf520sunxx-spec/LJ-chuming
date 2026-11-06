package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProgressingProcessDTO", description = "")
public class ProgressingProcessDTO {
   @ApiModelProperty(name = "id", notes = "工序id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "unQuantity", notes = "未完成数")
   @JsonProperty("unQuantity")
   @JSONField(name = "unQuantity")
   private Integer unQuantity;
   @ApiModelProperty(name = "unNetWeight", notes = "未完成量")
   @JsonProperty("unNetWeight")
   @JSONField(name = "unNetWeight")
   private Integer unNetWeight;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;

   public static ProgressingProcessDTO.ProgressingProcessDTOBuilder builder() {
      return new ProgressingProcessDTO.ProgressingProcessDTOBuilder();
   }

   public ProgressingProcessDTO() {
   }

   public ProgressingProcessDTO(final Long id, final Integer unQuantity, final Integer unNetWeight, final Integer taskTypeEnum) {
      this.id = id;
      this.unQuantity = unQuantity;
      this.unNetWeight = unNetWeight;
      this.taskTypeEnum = taskTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getUnQuantity() {
      return this.unQuantity;
   }

   public Integer getUnNetWeight() {
      return this.unNetWeight;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   @JsonProperty("id")
   public ProgressingProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("unQuantity")
   public ProgressingProcessDTO setUnQuantity(final Integer unQuantity) {
      this.unQuantity = unQuantity;
      return this;
   }

   @JsonProperty("unNetWeight")
   public ProgressingProcessDTO setUnNetWeight(final Integer unNetWeight) {
      this.unNetWeight = unNetWeight;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProgressingProcessDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProgressingProcessDTO)) {
         return false;
      }

      ProgressingProcessDTO other = (ProgressingProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$unQuantity = this.getUnQuantity();
         Object other$unQuantity = other.getUnQuantity();
         if (this$unQuantity == null ? other$unQuantity == null : this$unQuantity.equals(other$unQuantity)) {
            Object this$unNetWeight = this.getUnNetWeight();
            Object other$unNetWeight = other.getUnNetWeight();
            if (this$unNetWeight == null ? other$unNetWeight == null : this$unNetWeight.equals(other$unNetWeight)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               return this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum);
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
      return other instanceof ProgressingProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $unQuantity = this.getUnQuantity();
      result = result * 59 + ($unQuantity == null ? 43 : $unQuantity.hashCode());
      Object $unNetWeight = this.getUnNetWeight();
      result = result * 59 + ($unNetWeight == null ? 43 : $unNetWeight.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      return result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
   }

   @Override
   public String toString() {
      return "ProgressingProcessDTO(id="
         + this.getId()
         + ", unQuantity="
         + this.getUnQuantity()
         + ", unNetWeight="
         + this.getUnNetWeight()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ")";
   }

   public static class ProgressingProcessDTOBuilder {
      private Long id;
      private Integer unQuantity;
      private Integer unNetWeight;
      private Integer taskTypeEnum;

      ProgressingProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public ProgressingProcessDTO.ProgressingProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("unQuantity")
      public ProgressingProcessDTO.ProgressingProcessDTOBuilder unQuantity(final Integer unQuantity) {
         this.unQuantity = unQuantity;
         return this;
      }

      @JsonProperty("unNetWeight")
      public ProgressingProcessDTO.ProgressingProcessDTOBuilder unNetWeight(final Integer unNetWeight) {
         this.unNetWeight = unNetWeight;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProgressingProcessDTO.ProgressingProcessDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public ProgressingProcessDTO build() {
         return new ProgressingProcessDTO(this.id, this.unQuantity, this.unNetWeight, this.taskTypeEnum);
      }

      @Override
      public String toString() {
         return "ProgressingProcessDTO.ProgressingProcessDTOBuilder(id="
            + this.id
            + ", unQuantity="
            + this.unQuantity
            + ", unNetWeight="
            + this.unNetWeight
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ")";
      }
   }
}
