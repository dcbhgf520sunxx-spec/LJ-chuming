package com.hzchum.scim.rest.pojo.vo.mes.building.request.task.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "SchedulingSummaryVORequest", description = "")
public class SchedulingSummaryVORequest {
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
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "date", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private LocalDateTime date;
   @ApiModelProperty(name = "category", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;

   public static SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder builder() {
      return new SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder();
   }

   public SchedulingSummaryVORequest() {
   }

   public SchedulingSummaryVORequest(
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer productType,
      final LocalDateTime date,
      final Integer category
   ) {
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productType = productType;
      this.date = date;
      this.category = category;
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

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public Integer getCategory() {
      return this.category;
   }

   @JsonProperty("factoryId")
   public SchedulingSummaryVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public SchedulingSummaryVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public SchedulingSummaryVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectId")
   public SchedulingSummaryVORequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public SchedulingSummaryVORequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public SchedulingSummaryVORequest setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("productType")
   public SchedulingSummaryVORequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("date")
   public SchedulingSummaryVORequest setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @JsonProperty("category")
   public SchedulingSummaryVORequest setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @Override
   public String toString() {
      return "SchedulingSummaryVORequest(factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", date="
         + this.getDate()
         + ", category="
         + this.getCategory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingSummaryVORequest)) {
         return false;
      }

      SchedulingSummaryVORequest other = (SchedulingSummaryVORequest)o;
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
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
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
      return other instanceof SchedulingSummaryVORequest;
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
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   public static class SchedulingSummaryVORequestBuilder {
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer productType;
      private LocalDateTime date;
      private Integer category;

      SchedulingSummaryVORequestBuilder() {
      }

      @JsonProperty("factoryId")
      public SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectId")
      public SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("productType")
      public SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("date")
      public SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      @JsonProperty("category")
      public SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public SchedulingSummaryVORequest build() {
         return new SchedulingSummaryVORequest(
            this.factoryId, this.workshopId, this.productionLineId, this.projectId, this.monomerId, this.areaId, this.productType, this.date, this.category
         );
      }

      @Override
      public String toString() {
         return "SchedulingSummaryVORequest.SchedulingSummaryVORequestBuilder(factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productType="
            + this.productType
            + ", date="
            + this.date
            + ", category="
            + this.category
            + ")";
      }
   }
}
