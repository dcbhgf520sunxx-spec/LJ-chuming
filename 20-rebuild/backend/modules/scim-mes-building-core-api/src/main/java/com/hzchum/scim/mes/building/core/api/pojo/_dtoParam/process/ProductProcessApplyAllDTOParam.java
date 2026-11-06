package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProductProcessApplyAllDTOParam", description = "")
public class ProductProcessApplyAllDTOParam {
   @ApiModelProperty(name = "productProcessId", notes = "总工序Id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "classIds", notes = "应用种类id")
   @JsonProperty("classIds")
   @JSONField(name = "classIds")
   private List<Long> classIds;

   public static ProductProcessApplyAllDTOParam.ProductProcessApplyAllDTOParamBuilder builder() {
      return new ProductProcessApplyAllDTOParam.ProductProcessApplyAllDTOParamBuilder();
   }

   public ProductProcessApplyAllDTOParam() {
   }

   public ProductProcessApplyAllDTOParam(final Long productProcessId, final Integer taskTypeEnum, final List<Long> classIds) {
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
   public ProductProcessApplyAllDTOParam setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProductProcessApplyAllDTOParam setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("classIds")
   public ProductProcessApplyAllDTOParam setClassIds(final List<Long> classIds) {
      this.classIds = classIds;
      return this;
   }

   @Override
   public String toString() {
      return "ProductProcessApplyAllDTOParam(productProcessId="
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

      if (!(o instanceof ProductProcessApplyAllDTOParam)) {
         return false;
      }

      ProductProcessApplyAllDTOParam other = (ProductProcessApplyAllDTOParam)o;
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
      return other instanceof ProductProcessApplyAllDTOParam;
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

   public static class ProductProcessApplyAllDTOParamBuilder {
      private Long productProcessId;
      private Integer taskTypeEnum;
      private List<Long> classIds;

      ProductProcessApplyAllDTOParamBuilder() {
      }

      @JsonProperty("productProcessId")
      public ProductProcessApplyAllDTOParam.ProductProcessApplyAllDTOParamBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProductProcessApplyAllDTOParam.ProductProcessApplyAllDTOParamBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("classIds")
      public ProductProcessApplyAllDTOParam.ProductProcessApplyAllDTOParamBuilder classIds(final List<Long> classIds) {
         this.classIds = classIds;
         return this;
      }

      public ProductProcessApplyAllDTOParam build() {
         return new ProductProcessApplyAllDTOParam(this.productProcessId, this.taskTypeEnum, this.classIds);
      }

      @Override
      public String toString() {
         return "ProductProcessApplyAllDTOParam.ProductProcessApplyAllDTOParamBuilder(productProcessId="
            + this.productProcessId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", classIds="
            + this.classIds
            + ")";
      }
   }
}
