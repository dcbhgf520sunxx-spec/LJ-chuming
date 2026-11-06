package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;

@ApiModel(value = "MesBuildingAreaSchedulingDTOParam", description = "项目排期信息 ")
public class MesBuildingAreaSchedulingDTOParam {
   @ApiModelProperty(name = "id", value = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   private Long areaBatchId;
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
   @ApiModelProperty(name = "startTime", value = "开始时间(用于车间产量统计报表)", notes = "开始时间(用于车间产量统计报表)")
   @JsonProperty("startTime")
   @JSONField(name = "startTime")
   private LocalDateTime startTime;

   public static MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder builder() {
      return new MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder();
   }

   public MesBuildingAreaSchedulingDTOParam() {
   }

   public MesBuildingAreaSchedulingDTOParam(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final LocalDateTime startTime
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.startDate = startDate;
      this.endDate = endDate;
      this.startTime = startTime;
   }

   public Long getId() {
      return this.id;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
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

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   @JsonProperty("id")
   public MesBuildingAreaSchedulingDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingAreaSchedulingDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingAreaSchedulingDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingAreaSchedulingDTOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingAreaSchedulingDTOParam setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingAreaSchedulingDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingAreaSchedulingDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingAreaSchedulingDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("startDate")
   public MesBuildingAreaSchedulingDTOParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public MesBuildingAreaSchedulingDTOParam setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("startTime")
   public MesBuildingAreaSchedulingDTOParam setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAreaSchedulingDTOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
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
         + ", startTime="
         + this.getStartTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAreaSchedulingDTOParam)) {
         return false;
      }

      MesBuildingAreaSchedulingDTOParam other = (MesBuildingAreaSchedulingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
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
                                 if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                    Object this$startTime = this.getStartTime();
                                    Object other$startTime = other.getStartTime();
                                    return this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAreaSchedulingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $startTime = this.getStartTime();
      return result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
   }

   public static class MesBuildingAreaSchedulingDTOParamBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private LocalDateTime startTime;

      MesBuildingAreaSchedulingDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("startDate")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("startTime")
      public MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public MesBuildingAreaSchedulingDTOParam build() {
         return new MesBuildingAreaSchedulingDTOParam(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.startDate,
            this.endDate,
            this.startTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAreaSchedulingDTOParam.MesBuildingAreaSchedulingDTOParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
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
            + ", startTime="
            + this.startTime
            + ")";
      }
   }
}
