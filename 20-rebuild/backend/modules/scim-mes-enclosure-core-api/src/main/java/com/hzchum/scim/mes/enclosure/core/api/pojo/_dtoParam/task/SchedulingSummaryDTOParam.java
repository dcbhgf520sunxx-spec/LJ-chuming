package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "SchedulingSummaryDTOParam", description = "")
public class SchedulingSummaryDTOParam {
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "date", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private LocalDateTime date;

   public static SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder builder() {
      return new SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder();
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   @JsonProperty("factoryId")
   public SchedulingSummaryDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public SchedulingSummaryDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public SchedulingSummaryDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectId")
   public SchedulingSummaryDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public SchedulingSummaryDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public SchedulingSummaryDTOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("productType")
   public SchedulingSummaryDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public SchedulingSummaryDTOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("date")
   public SchedulingSummaryDTOParam setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @Override
   public String toString() {
      return "SchedulingSummaryDTOParam(factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", date="
         + this.getDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingSummaryDTOParam)) {
         return false;
      }

      SchedulingSummaryDTOParam other = (SchedulingSummaryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryId = this.getFactoryId();
      Object other$factoryId = other.getFactoryId();
      if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$planId = this.getPlanId();
                     Object other$planId = other.getPlanId();
                     if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$category = this.getCategory();
                           Object other$category = other.getCategory();
                           if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                              Object this$date = this.getDate();
                              Object other$date = other.getDate();
                              return this$date == null ? other$date == null : this$date.equals(other$date);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SchedulingSummaryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   public SchedulingSummaryDTOParam() {
   }

   public SchedulingSummaryDTOParam(
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Integer productType,
      final Integer category,
      final LocalDateTime date
   ) {
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.productType = productType;
      this.category = category;
      this.date = date;
   }

   public static class SchedulingSummaryDTOParamBuilder {
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Integer productType;
      private Integer category;
      private LocalDateTime date;

      SchedulingSummaryDTOParamBuilder() {
      }

      @JsonProperty("factoryId")
      public SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectId")
      public SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("productType")
      public SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("date")
      public SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public SchedulingSummaryDTOParam build() {
         return new SchedulingSummaryDTOParam(
            this.factoryId, this.workshopId, this.productionLineId, this.projectId, this.monomerId, this.planId, this.productType, this.category, this.date
         );
      }

      @Override
      public String toString() {
         return "SchedulingSummaryDTOParam.SchedulingSummaryDTOParamBuilder(factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", date="
            + this.date
            + ")";
      }
   }
}
