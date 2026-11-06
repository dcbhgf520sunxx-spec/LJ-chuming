package com.hzchum.scim.rest.pojo.vo.mes.building.request.process.productProcess.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProductProcessApplyAllVORequest", description = "工序应用全部")
public class ProductProcessApplyAllVORequest {
   @ApiModelProperty(name = "productProcessId", notes = "总工序Id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   @NotNull(message = "总工序Id不能为空")
   private Long productProcessId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @NotNull(message = "任务类型不能为空")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "classIds", notes = "应用种类id")
   @JsonProperty("classIds")
   @JSONField(name = "classIds")
   @NotNull(message = "应用种类id不能为空")
   private List<Long> classIds;

   public static ProductProcessApplyAllVORequest.ProductProcessApplyAllVORequestBuilder builder() {
      return new ProductProcessApplyAllVORequest.ProductProcessApplyAllVORequestBuilder();
   }

   public ProductProcessApplyAllVORequest() {
   }

   public ProductProcessApplyAllVORequest(final Long productProcessId, final Integer taskTypeEnum, final List<Long> classIds) {
      this.productProcessId = productProcessId;
      this.taskTypeEnum = taskTypeEnum;
      this.classIds = classIds;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public List<Long> getClassIds() {
      return this.classIds;
   }

   @JsonProperty("productProcessId")
   public ProductProcessApplyAllVORequest setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProductProcessApplyAllVORequest setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("classIds")
   public ProductProcessApplyAllVORequest setClassIds(final List<Long> classIds) {
      this.classIds = classIds;
      return this;
   }

   @Override
   public String toString() {
      return "ProductProcessApplyAllVORequest(productProcessId="
         + this.getProductProcessId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", classIds="
         + this.getClassIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessApplyAllVORequest)) {
         return false;
      }

      ProductProcessApplyAllVORequest other = (ProductProcessApplyAllVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productProcessId = this.getProductProcessId();
      Object other$productProcessId = other.getProductProcessId();
      if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$classIds = this.getClassIds();
            Object other$classIds = other.getClassIds();
            return this$classIds == null ? other$classIds == null : this$classIds.equals(other$classIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductProcessApplyAllVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $classIds = this.getClassIds();
      return result * 59 + ($classIds == null ? 43 : $classIds.hashCode());
   }

   public static class ProductProcessApplyAllVORequestBuilder {
      private Long productProcessId;
      private Integer taskTypeEnum;
      private List<Long> classIds;

      ProductProcessApplyAllVORequestBuilder() {
      }

      @JsonProperty("productProcessId")
      public ProductProcessApplyAllVORequest.ProductProcessApplyAllVORequestBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProductProcessApplyAllVORequest.ProductProcessApplyAllVORequestBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("classIds")
      public ProductProcessApplyAllVORequest.ProductProcessApplyAllVORequestBuilder classIds(final List<Long> classIds) {
         this.classIds = classIds;
         return this;
      }

      public ProductProcessApplyAllVORequest build() {
         return new ProductProcessApplyAllVORequest(this.productProcessId, this.taskTypeEnum, this.classIds);
      }

      @Override
      public String toString() {
         return "ProductProcessApplyAllVORequest.ProductProcessApplyAllVORequestBuilder(productProcessId="
            + this.productProcessId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", classIds="
            + this.classIds
            + ")";
      }
   }
}
