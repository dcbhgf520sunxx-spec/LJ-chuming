package com.hzchum.scim.common.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectProductProcessDTO", description = "项目产品工序信息")
public class ProjectProductProcessDTO {
   @ApiModelProperty(name = "id", notes = "工序id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "needQuantity", value = "任务数")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   private Integer needQuantity;
   @ApiModelProperty(name = "completedQuantity", notes = "完成数")
   @JsonProperty("completedQuantity")
   @JSONField(name = "completedQuantity")
   private Integer completedQuantity;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getCompletedQuantity() {
      return this.completedQuantity;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("needQuantity")
   public void setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
   }

   @JsonProperty("completedQuantity")
   public void setCompletedQuantity(final Integer completedQuantity) {
      this.completedQuantity = completedQuantity;
   }

   @JsonProperty("taskTypeEnum")
   public void setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductProcessDTO)) {
         return false;
      }

      ProjectProductProcessDTO other = (ProjectProductProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$needQuantity = this.getNeedQuantity();
            Object other$needQuantity = other.getNeedQuantity();
            if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
               Object this$completedQuantity = this.getCompletedQuantity();
               Object other$completedQuantity = other.getCompletedQuantity();
               if (this$completedQuantity == null ? other$completedQuantity == null : this$completedQuantity.equals(other$completedQuantity)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectProductProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $completedQuantity = this.getCompletedQuantity();
      result = result * 59 + ($completedQuantity == null ? 43 : $completedQuantity.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      return result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductProcessDTO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", completedQuantity="
         + this.getCompletedQuantity()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ")";
   }
}
