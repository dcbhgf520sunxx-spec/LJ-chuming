package com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "PriceDetailsDOParam", description = "")
public class PriceDetailsDOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "projectIds", notes = "项目ids")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   private List<Long> projectIds;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "startDate", notes = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", notes = "结束时间")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "productType", notes = "类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式", value = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;

   public static PriceDetailsDOParam.PriceDetailsDOParamBuilder builder() {
      return new PriceDetailsDOParam.PriceDetailsDOParamBuilder();
   }

   public PriceDetailsDOParam(
      final Long projectId,
      final List<Long> projectIds,
      final Long factoryId,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final Integer productType,
      final Long teamId,
      final Integer wageQuotaType
   ) {
      this.projectId = projectId;
      this.projectIds = projectIds;
      this.factoryId = factoryId;
      this.startDate = startDate;
      this.endDate = endDate;
      this.productType = productType;
      this.teamId = teamId;
      this.wageQuotaType = wageQuotaType;
   }

   public PriceDetailsDOParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   @JsonProperty("projectId")
   public PriceDetailsDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectIds")
   public PriceDetailsDOParam setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("factoryId")
   public PriceDetailsDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("startDate")
   public PriceDetailsDOParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public PriceDetailsDOParam setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("productType")
   public PriceDetailsDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("teamId")
   public PriceDetailsDOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public PriceDetailsDOParam setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @Override
   public String toString() {
      return "PriceDetailsDOParam(projectId="
         + this.getProjectId()
         + ", projectIds="
         + this.getProjectIds()
         + ", factoryId="
         + this.getFactoryId()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", productType="
         + this.getProductType()
         + ", teamId="
         + this.getTeamId()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PriceDetailsDOParam)) {
         return false;
      }

      PriceDetailsDOParam other = (PriceDetailsDOParam)o;
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
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$wageQuotaType = this.getWageQuotaType();
                  Object other$wageQuotaType = other.getWageQuotaType();
                  if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                     Object this$projectIds = this.getProjectIds();
                     Object other$projectIds = other.getProjectIds();
                     if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
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
      return other instanceof PriceDetailsDOParam;
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
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   public static class PriceDetailsDOParamBuilder {
      private Long projectId;
      private List<Long> projectIds;
      private Long factoryId;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private Integer productType;
      private Long teamId;
      private Integer wageQuotaType;

      PriceDetailsDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public PriceDetailsDOParam.PriceDetailsDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectIds")
      public PriceDetailsDOParam.PriceDetailsDOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("factoryId")
      public PriceDetailsDOParam.PriceDetailsDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("startDate")
      public PriceDetailsDOParam.PriceDetailsDOParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public PriceDetailsDOParam.PriceDetailsDOParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("productType")
      public PriceDetailsDOParam.PriceDetailsDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("teamId")
      public PriceDetailsDOParam.PriceDetailsDOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public PriceDetailsDOParam.PriceDetailsDOParamBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public PriceDetailsDOParam build() {
         return new PriceDetailsDOParam(
            this.projectId, this.projectIds, this.factoryId, this.startDate, this.endDate, this.productType, this.teamId, this.wageQuotaType
         );
      }

      @Override
      public String toString() {
         return "PriceDetailsDOParam.PriceDetailsDOParamBuilder(projectId="
            + this.projectId
            + ", projectIds="
            + this.projectIds
            + ", factoryId="
            + this.factoryId
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", productType="
            + this.productType
            + ", teamId="
            + this.teamId
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
