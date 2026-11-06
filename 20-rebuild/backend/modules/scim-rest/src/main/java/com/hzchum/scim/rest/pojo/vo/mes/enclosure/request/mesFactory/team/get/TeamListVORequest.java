package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.team.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class TeamListVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "productionLineIds", notes = "生产线ids")
   @JsonProperty("productionLineIds")
   @JSONField(name = "productionLineIds")
   private List<Long> productionLineIds;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]", value = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;
   @ApiModelProperty(name = "boolExtraCountEnum", notes = "编制属性[0 不单独计算,单独计算]")
   @JsonProperty("boolExtraCountEnum")
   @JSONField(name = "boolExtraCountEnum")
   private Boolean boolExtraCountEnum;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式 [1 重量, 2 长度，4 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;

   public static TeamListVORequest.TeamListVORequestBuilder builder() {
      return new TeamListVORequest.TeamListVORequestBuilder();
   }

   public TeamListVORequest() {
   }

   public TeamListVORequest(
      final Long id,
      final Long processId,
      final Long factoryId,
      final List<Long> productionLineIds,
      final Boolean organizationType,
      final Boolean boolExtraCountEnum,
      final Integer wageQuotaType
   ) {
      this.id = id;
      this.processId = processId;
      this.factoryId = factoryId;
      this.productionLineIds = productionLineIds;
      this.organizationType = organizationType;
      this.boolExtraCountEnum = boolExtraCountEnum;
      this.wageQuotaType = wageQuotaType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public List<Long> getProductionLineIds() {
      return this.productionLineIds;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Boolean getBoolExtraCountEnum() {
      return this.boolExtraCountEnum;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   @JsonProperty("id")
   public TeamListVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public TeamListVORequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public TeamListVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productionLineIds")
   public TeamListVORequest setProductionLineIds(final List<Long> productionLineIds) {
      this.productionLineIds = productionLineIds;
      return this;
   }

   @JsonProperty("organizationType")
   public TeamListVORequest setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("boolExtraCountEnum")
   public TeamListVORequest setBoolExtraCountEnum(final Boolean boolExtraCountEnum) {
      this.boolExtraCountEnum = boolExtraCountEnum;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public TeamListVORequest setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @Override
   public String toString() {
      return "TeamListVORequest(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", factoryId="
         + this.getFactoryId()
         + ", productionLineIds="
         + this.getProductionLineIds()
         + ", organizationType="
         + this.getOrganizationType()
         + ", boolExtraCountEnum="
         + this.getBoolExtraCountEnum()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamListVORequest)) {
         return false;
      }

      TeamListVORequest other = (TeamListVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$organizationType = this.getOrganizationType();
               Object other$organizationType = other.getOrganizationType();
               if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                  Object this$boolExtraCountEnum = this.getBoolExtraCountEnum();
                  Object other$boolExtraCountEnum = other.getBoolExtraCountEnum();
                  if (this$boolExtraCountEnum == null ? other$boolExtraCountEnum == null : this$boolExtraCountEnum.equals(other$boolExtraCountEnum)) {
                     Object this$wageQuotaType = this.getWageQuotaType();
                     Object other$wageQuotaType = other.getWageQuotaType();
                     if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                        Object this$productionLineIds = this.getProductionLineIds();
                        Object other$productionLineIds = other.getProductionLineIds();
                        return this$productionLineIds == null ? other$productionLineIds == null : this$productionLineIds.equals(other$productionLineIds);
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
      return other instanceof TeamListVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $boolExtraCountEnum = this.getBoolExtraCountEnum();
      result = result * 59 + ($boolExtraCountEnum == null ? 43 : $boolExtraCountEnum.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $productionLineIds = this.getProductionLineIds();
      return result * 59 + ($productionLineIds == null ? 43 : $productionLineIds.hashCode());
   }

   public static class TeamListVORequestBuilder {
      private Long id;
      private Long processId;
      private Long factoryId;
      private List<Long> productionLineIds;
      private Boolean organizationType;
      private Boolean boolExtraCountEnum;
      private Integer wageQuotaType;

      TeamListVORequestBuilder() {
      }

      @JsonProperty("id")
      public TeamListVORequest.TeamListVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public TeamListVORequest.TeamListVORequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public TeamListVORequest.TeamListVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productionLineIds")
      public TeamListVORequest.TeamListVORequestBuilder productionLineIds(final List<Long> productionLineIds) {
         this.productionLineIds = productionLineIds;
         return this;
      }

      @JsonProperty("organizationType")
      public TeamListVORequest.TeamListVORequestBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("boolExtraCountEnum")
      public TeamListVORequest.TeamListVORequestBuilder boolExtraCountEnum(final Boolean boolExtraCountEnum) {
         this.boolExtraCountEnum = boolExtraCountEnum;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public TeamListVORequest.TeamListVORequestBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public TeamListVORequest build() {
         return new TeamListVORequest(
            this.id, this.processId, this.factoryId, this.productionLineIds, this.organizationType, this.boolExtraCountEnum, this.wageQuotaType
         );
      }

      @Override
      public String toString() {
         return "TeamListVORequest.TeamListVORequestBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", factoryId="
            + this.factoryId
            + ", productionLineIds="
            + this.productionLineIds
            + ", organizationType="
            + this.organizationType
            + ", boolExtraCountEnum="
            + this.boolExtraCountEnum
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
