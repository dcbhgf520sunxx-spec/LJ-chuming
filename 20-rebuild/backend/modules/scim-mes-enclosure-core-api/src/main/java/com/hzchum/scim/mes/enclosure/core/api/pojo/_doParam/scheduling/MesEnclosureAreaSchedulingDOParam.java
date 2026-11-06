package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;

@ApiModel(value = "MesEnclosureAreaSchedulingDOParam", description = "项目排期信息 ")
public class MesEnclosureAreaSchedulingDOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", value = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "factoryId", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "区域id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "startDate", value = "开始时间", notes = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "datetime  COMMENT '开始时间'", nullable = false)
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间", notes = "结束时间")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "datetime  COMMENT '结束时间'", nullable = false)
   private LocalDateTime endDate;

   public static MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder builder() {
      return new MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder();
   }

   public MesEnclosureAreaSchedulingDOParam() {
   }

   public MesEnclosureAreaSchedulingDOParam(
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final LocalDateTime startDate,
      final LocalDateTime endDate
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.startDate = startDate;
      this.endDate = endDate;
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

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   @JsonProperty("projectId")
   public MesEnclosureAreaSchedulingDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureAreaSchedulingDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureAreaSchedulingDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureAreaSchedulingDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureAreaSchedulingDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureAreaSchedulingDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("startDate")
   public MesEnclosureAreaSchedulingDOParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public MesEnclosureAreaSchedulingDOParam setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureAreaSchedulingDOParam(projectId="
         + this.getProjectId()
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
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureAreaSchedulingDOParam)) {
         return false;
      }

      MesEnclosureAreaSchedulingDOParam other = (MesEnclosureAreaSchedulingDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
                        Object this$startDate = this.getStartDate();
                        Object other$startDate = other.getStartDate();
                        if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                           Object this$endDate = this.getEndDate();
                           Object other$endDate = other.getEndDate();
                           return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof MesEnclosureAreaSchedulingDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   public static class MesEnclosureAreaSchedulingDOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private LocalDateTime startDate;
      private LocalDateTime endDate;

      MesEnclosureAreaSchedulingDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("startDate")
      public MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public MesEnclosureAreaSchedulingDOParam build() {
         return new MesEnclosureAreaSchedulingDOParam(
            this.projectId, this.monomerId, this.planId, this.factoryId, this.workshopId, this.productionLineId, this.startDate, this.endDate
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureAreaSchedulingDOParam.MesEnclosureAreaSchedulingDOParamBuilder(projectId="
            + this.projectId
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
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ")";
      }
   }
}
