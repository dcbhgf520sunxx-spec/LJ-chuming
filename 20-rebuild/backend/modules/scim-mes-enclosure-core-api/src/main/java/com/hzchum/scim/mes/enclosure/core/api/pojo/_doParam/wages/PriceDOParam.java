package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "PriceDOParam", description = "")
public class PriceDOParam {
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
   @ApiModelProperty(name = "workshopName", notes = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineName", notes = "生产线名")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
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
   @ApiModelProperty(name = "organizationType", notes = "班组编制")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;

   public static PriceDOParam.PriceDOParamBuilder builder() {
      return new PriceDOParam.PriceDOParamBuilder();
   }

   public PriceDOParam(
      final Long projectId,
      final List<Long> projectIds,
      final Long factoryId,
      final String workshopName,
      final String productionLineName,
      final String processName,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final Integer productType,
      final Boolean organizationType
   ) {
      this.projectId = projectId;
      this.projectIds = projectIds;
      this.factoryId = factoryId;
      this.workshopName = workshopName;
      this.productionLineName = productionLineName;
      this.processName = processName;
      this.startDate = startDate;
      this.endDate = endDate;
      this.productType = productType;
      this.organizationType = organizationType;
   }

   public PriceDOParam() {
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

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getProcessName() {
      return this.processName;
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

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("projectId")
   public PriceDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectIds")
   public PriceDOParam setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("factoryId")
   public PriceDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopName")
   public PriceDOParam setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineName")
   public PriceDOParam setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("processName")
   public PriceDOParam setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("startDate")
   public PriceDOParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public PriceDOParam setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("productType")
   public PriceDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("organizationType")
   public PriceDOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "PriceDOParam(projectId="
         + this.getProjectId()
         + ", projectIds="
         + this.getProjectIds()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", processName="
         + this.getProcessName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", productType="
         + this.getProductType()
         + ", organizationType="
         + this.getOrganizationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PriceDOParam)) {
         return false;
      }

      PriceDOParam other = (PriceDOParam)o;
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
               Object this$organizationType = this.getOrganizationType();
               Object other$organizationType = other.getOrganizationType();
               if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                  Object this$projectIds = this.getProjectIds();
                  Object other$projectIds = other.getProjectIds();
                  if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                     Object this$workshopName = this.getWorkshopName();
                     Object other$workshopName = other.getWorkshopName();
                     if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                        Object this$productionLineName = this.getProductionLineName();
                        Object other$productionLineName = other.getProductionLineName();
                        if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                           Object this$processName = this.getProcessName();
                           Object other$processName = other.getProcessName();
                           if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PriceDOParam;
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
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   public static class PriceDOParamBuilder {
      private Long projectId;
      private List<Long> projectIds;
      private Long factoryId;
      private String workshopName;
      private String productionLineName;
      private String processName;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private Integer productType;
      private Boolean organizationType;

      PriceDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public PriceDOParam.PriceDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectIds")
      public PriceDOParam.PriceDOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("factoryId")
      public PriceDOParam.PriceDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopName")
      public PriceDOParam.PriceDOParamBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineName")
      public PriceDOParam.PriceDOParamBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("processName")
      public PriceDOParam.PriceDOParamBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("startDate")
      public PriceDOParam.PriceDOParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public PriceDOParam.PriceDOParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("productType")
      public PriceDOParam.PriceDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("organizationType")
      public PriceDOParam.PriceDOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public PriceDOParam build() {
         return new PriceDOParam(
            this.projectId,
            this.projectIds,
            this.factoryId,
            this.workshopName,
            this.productionLineName,
            this.processName,
            this.startDate,
            this.endDate,
            this.productType,
            this.organizationType
         );
      }

      @Override
      public String toString() {
         return "PriceDOParam.PriceDOParamBuilder(projectId="
            + this.projectId
            + ", projectIds="
            + this.projectIds
            + ", factoryId="
            + this.factoryId
            + ", workshopName="
            + this.workshopName
            + ", productionLineName="
            + this.productionLineName
            + ", processName="
            + this.processName
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", productType="
            + this.productType
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
