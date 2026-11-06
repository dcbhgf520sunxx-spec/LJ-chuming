package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProgressingProcessDTO", description = "")
public class ProduceStatisticsProcessDTO {
   @ApiModelProperty(name = "id", notes = "工序id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "工序id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "unQuantity", notes = "未完成数")
   @JsonProperty("unQuantity")
   @JSONField(name = "unQuantity")
   private Integer unQuantity;
   @ApiModelProperty(name = "unNetWeight", notes = "未完成量(净重)")
   @JsonProperty("unNetWeight")
   @JSONField(name = "unNetWeight")
   private BigDecimal unNetWeight;
   @ApiModelProperty(name = "unGrossWeight", notes = "未完成量(毛重)")
   @JsonProperty("unGrossWeight")
   @JSONField(name = "unGrossWeight")
   private BigDecimal unGrossWeight;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;

   public static ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder builder() {
      return new ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder();
   }

   public ProduceStatisticsProcessDTO() {
   }

   public ProduceStatisticsProcessDTO(
      final Long id,
      final Long projectId,
      final Long productId,
      final Integer unQuantity,
      final BigDecimal unNetWeight,
      final BigDecimal unGrossWeight,
      final Integer taskTypeEnum
   ) {
      this.id = id;
      this.projectId = projectId;
      this.productId = productId;
      this.unQuantity = unQuantity;
      this.unNetWeight = unNetWeight;
      this.unGrossWeight = unGrossWeight;
      this.taskTypeEnum = taskTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getUnQuantity() {
      return this.unQuantity;
   }

   public BigDecimal getUnNetWeight() {
      return this.unNetWeight;
   }

   public BigDecimal getUnGrossWeight() {
      return this.unGrossWeight;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   @JsonProperty("id")
   public ProduceStatisticsProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ProduceStatisticsProcessDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("productId")
   public ProduceStatisticsProcessDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("unQuantity")
   public ProduceStatisticsProcessDTO setUnQuantity(final Integer unQuantity) {
      this.unQuantity = unQuantity;
      return this;
   }

   @JsonProperty("unNetWeight")
   public ProduceStatisticsProcessDTO setUnNetWeight(final BigDecimal unNetWeight) {
      this.unNetWeight = unNetWeight;
      return this;
   }

   @JsonProperty("unGrossWeight")
   public ProduceStatisticsProcessDTO setUnGrossWeight(final BigDecimal unGrossWeight) {
      this.unGrossWeight = unGrossWeight;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProduceStatisticsProcessDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceStatisticsProcessDTO)) {
         return false;
      }

      ProduceStatisticsProcessDTO other = (ProduceStatisticsProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$unQuantity = this.getUnQuantity();
               Object other$unQuantity = other.getUnQuantity();
               if (this$unQuantity == null ? other$unQuantity == null : this$unQuantity.equals(other$unQuantity)) {
                  Object this$taskTypeEnum = this.getTaskTypeEnum();
                  Object other$taskTypeEnum = other.getTaskTypeEnum();
                  if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                     Object this$unNetWeight = this.getUnNetWeight();
                     Object other$unNetWeight = other.getUnNetWeight();
                     if (this$unNetWeight == null ? other$unNetWeight == null : this$unNetWeight.equals(other$unNetWeight)) {
                        Object this$unGrossWeight = this.getUnGrossWeight();
                        Object other$unGrossWeight = other.getUnGrossWeight();
                        return this$unGrossWeight == null ? other$unGrossWeight == null : this$unGrossWeight.equals(other$unGrossWeight);
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
      return other instanceof ProduceStatisticsProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $unQuantity = this.getUnQuantity();
      result = result * 59 + ($unQuantity == null ? 43 : $unQuantity.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $unNetWeight = this.getUnNetWeight();
      result = result * 59 + ($unNetWeight == null ? 43 : $unNetWeight.hashCode());
      Object $unGrossWeight = this.getUnGrossWeight();
      return result * 59 + ($unGrossWeight == null ? 43 : $unGrossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ProduceStatisticsProcessDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", productId="
         + this.getProductId()
         + ", unQuantity="
         + this.getUnQuantity()
         + ", unNetWeight="
         + this.getUnNetWeight()
         + ", unGrossWeight="
         + this.getUnGrossWeight()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ")";
   }

   public static class ProduceStatisticsProcessDTOBuilder {
      private Long id;
      private Long projectId;
      private Long productId;
      private Integer unQuantity;
      private BigDecimal unNetWeight;
      private BigDecimal unGrossWeight;
      private Integer taskTypeEnum;

      ProduceStatisticsProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("productId")
      public ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("unQuantity")
      public ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder unQuantity(final Integer unQuantity) {
         this.unQuantity = unQuantity;
         return this;
      }

      @JsonProperty("unNetWeight")
      public ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder unNetWeight(final BigDecimal unNetWeight) {
         this.unNetWeight = unNetWeight;
         return this;
      }

      @JsonProperty("unGrossWeight")
      public ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder unGrossWeight(final BigDecimal unGrossWeight) {
         this.unGrossWeight = unGrossWeight;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public ProduceStatisticsProcessDTO build() {
         return new ProduceStatisticsProcessDTO(
            this.id, this.projectId, this.productId, this.unQuantity, this.unNetWeight, this.unGrossWeight, this.taskTypeEnum
         );
      }

      @Override
      public String toString() {
         return "ProduceStatisticsProcessDTO.ProduceStatisticsProcessDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", productId="
            + this.productId
            + ", unQuantity="
            + this.unQuantity
            + ", unNetWeight="
            + this.unNetWeight
            + ", unGrossWeight="
            + this.unGrossWeight
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ")";
      }
   }
}
