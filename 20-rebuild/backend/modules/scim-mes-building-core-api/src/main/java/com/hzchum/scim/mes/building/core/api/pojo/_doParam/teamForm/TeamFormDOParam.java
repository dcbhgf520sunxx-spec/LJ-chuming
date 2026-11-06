package com.hzchum.scim.mes.building.core.api.pojo._doParam.teamForm;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "TeamFormRequestDTOParam", description = "")
public class TeamFormDOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "startDate", notes = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", notes = "结束时间")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "projectIds", notes = "项目ids")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   private List<Long> projectIds;

   public static TeamFormDOParam.TeamFormDOParamBuilder builder() {
      return new TeamFormDOParam.TeamFormDOParamBuilder();
   }

   public TeamFormDOParam(
      final Long projectId,
      final Long factoryId,
      final Integer productType,
      final Long processId,
      final Long productionLineId,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final List<Long> projectIds
   ) {
      this.projectId = projectId;
      this.factoryId = factoryId;
      this.productType = productType;
      this.processId = processId;
      this.productionLineId = productionLineId;
      this.startDate = startDate;
      this.endDate = endDate;
      this.projectIds = projectIds;
   }

   public TeamFormDOParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProcessId() {
      return this.processId;
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

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   @JsonProperty("projectId")
   public TeamFormDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("factoryId")
   public TeamFormDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productType")
   public TeamFormDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("processId")
   public TeamFormDOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("productionLineId")
   public TeamFormDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("startDate")
   public TeamFormDOParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public TeamFormDOParam setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("projectIds")
   public TeamFormDOParam setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @Override
   public String toString() {
      return "TeamFormDOParam(projectId="
         + this.getProjectId()
         + ", factoryId="
         + this.getFactoryId()
         + ", productType="
         + this.getProductType()
         + ", processId="
         + this.getProcessId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectIds="
         + this.getProjectIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamFormDOParam)) {
         return false;
      }

      TeamFormDOParam other = (TeamFormDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$startDate = this.getStartDate();
                     Object other$startDate = other.getStartDate();
                     if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                        Object this$endDate = this.getEndDate();
                        Object other$endDate = other.getEndDate();
                        if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamFormDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   public static class TeamFormDOParamBuilder {
      private Long projectId;
      private Long factoryId;
      private Integer productType;
      private Long processId;
      private Long productionLineId;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private List<Long> projectIds;

      TeamFormDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public TeamFormDOParam.TeamFormDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("factoryId")
      public TeamFormDOParam.TeamFormDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productType")
      public TeamFormDOParam.TeamFormDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("processId")
      public TeamFormDOParam.TeamFormDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("productionLineId")
      public TeamFormDOParam.TeamFormDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("startDate")
      public TeamFormDOParam.TeamFormDOParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public TeamFormDOParam.TeamFormDOParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("projectIds")
      public TeamFormDOParam.TeamFormDOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public TeamFormDOParam build() {
         return new TeamFormDOParam(
            this.projectId, this.factoryId, this.productType, this.processId, this.productionLineId, this.startDate, this.endDate, this.projectIds
         );
      }

      @Override
      public String toString() {
         return "TeamFormDOParam.TeamFormDOParamBuilder(projectId="
            + this.projectId
            + ", factoryId="
            + this.factoryId
            + ", productType="
            + this.productType
            + ", processId="
            + this.processId
            + ", productionLineId="
            + this.productionLineId
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", projectIds="
            + this.projectIds
            + ")";
      }
   }
}
