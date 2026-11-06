package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "HysteresisVORequest", description = "迟滞请求类")
public class HysteresisDOParam {
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "dateTime", value = "时间")
   @JsonProperty("dateTime")
   @JSONField(name = "dateTime")
   @NotNull(message = "时间不能为空")
   private LocalDateTime dateTime;
   @ApiModelProperty(name = "category", value = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "projectIds", notes = "项目ids")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   private List<Long> projectIds;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
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

   public static HysteresisDOParam.HysteresisDOParamBuilder builder() {
      return new HysteresisDOParam.HysteresisDOParamBuilder();
   }

   public HysteresisDOParam() {
   }

   public HysteresisDOParam(
      final Integer productType,
      final LocalDateTime dateTime,
      final Integer category,
      final Long projectId,
      final List<Long> projectIds,
      final Long monomerId,
      final Long planId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId
   ) {
      this.productType = productType;
      this.dateTime = dateTime;
      this.category = category;
      this.projectId = projectId;
      this.projectIds = projectIds;
      this.monomerId = monomerId;
      this.planId = planId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getPlanId() {
      return this.planId;
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

   @JsonProperty("productType")
   public HysteresisDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("dateTime")
   public HysteresisDOParam setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
      return this;
   }

   @JsonProperty("category")
   public HysteresisDOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("projectId")
   public HysteresisDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectIds")
   public HysteresisDOParam setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("monomerId")
   public HysteresisDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public HysteresisDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public HysteresisDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public HysteresisDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public HysteresisDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @Override
   public String toString() {
      return "HysteresisDOParam(productType="
         + this.getProductType()
         + ", dateTime="
         + this.getDateTime()
         + ", category="
         + this.getCategory()
         + ", projectId="
         + this.getProjectId()
         + ", projectIds="
         + this.getProjectIds()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof HysteresisDOParam)) {
         return false;
      }

      HysteresisDOParam other = (HysteresisDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$planId = this.getPlanId();
                  Object other$planId = other.getPlanId();
                  if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                     Object this$factoryId = this.getFactoryId();
                     Object other$factoryId = other.getFactoryId();
                     if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$productionLineId = this.getProductionLineId();
                           Object other$productionLineId = other.getProductionLineId();
                           if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                              Object this$dateTime = this.getDateTime();
                              Object other$dateTime = other.getDateTime();
                              if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
                                 Object this$projectIds = this.getProjectIds();
                                 Object other$projectIds = other.getProjectIds();
                                 return this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof HysteresisDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   public static class HysteresisDOParamBuilder {
      private Integer productType;
      private LocalDateTime dateTime;
      private Integer category;
      private Long projectId;
      private List<Long> projectIds;
      private Long monomerId;
      private Long planId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;

      HysteresisDOParamBuilder() {
      }

      @JsonProperty("productType")
      public HysteresisDOParam.HysteresisDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("dateTime")
      public HysteresisDOParam.HysteresisDOParamBuilder dateTime(final LocalDateTime dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      @JsonProperty("category")
      public HysteresisDOParam.HysteresisDOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("projectId")
      public HysteresisDOParam.HysteresisDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectIds")
      public HysteresisDOParam.HysteresisDOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("monomerId")
      public HysteresisDOParam.HysteresisDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public HysteresisDOParam.HysteresisDOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public HysteresisDOParam.HysteresisDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public HysteresisDOParam.HysteresisDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public HysteresisDOParam.HysteresisDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public HysteresisDOParam build() {
         return new HysteresisDOParam(
            this.productType,
            this.dateTime,
            this.category,
            this.projectId,
            this.projectIds,
            this.monomerId,
            this.planId,
            this.factoryId,
            this.workshopId,
            this.productionLineId
         );
      }

      @Override
      public String toString() {
         return "HysteresisDOParam.HysteresisDOParamBuilder(productType="
            + this.productType
            + ", dateTime="
            + this.dateTime
            + ", category="
            + this.category
            + ", projectId="
            + this.projectId
            + ", projectIds="
            + this.projectIds
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ")";
      }
   }
}
