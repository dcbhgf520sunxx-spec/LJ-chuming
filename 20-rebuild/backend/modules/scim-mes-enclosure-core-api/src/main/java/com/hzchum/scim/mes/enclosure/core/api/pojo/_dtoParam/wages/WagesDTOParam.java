package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "WagesDTOParam", description = "")
public class WagesDTOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @NotNull(message = "单体id不能为空")
   private Long monomerId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "planId", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "organizationType", notes = "编制类型")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;

   public static WagesDTOParam.WagesDTOParamBuilder builder() {
      return new WagesDTOParam.WagesDTOParamBuilder();
   }

   public WagesDTOParam(final Long projectId, final Long monomerId, final Integer productType, final Long planId, final Boolean organizationType) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productType = productType;
      this.planId = planId;
      this.organizationType = organizationType;
   }

   public WagesDTOParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("projectId")
   public WagesDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public WagesDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("productType")
   public WagesDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("planId")
   public WagesDTOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("organizationType")
   public WagesDTOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "WagesDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productType="
         + this.getProductType()
         + ", planId="
         + this.getPlanId()
         + ", organizationType="
         + this.getOrganizationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WagesDTOParam)) {
         return false;
      }

      WagesDTOParam other = (WagesDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$planId = this.getPlanId();
               Object other$planId = other.getPlanId();
               if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                  Object this$organizationType = this.getOrganizationType();
                  Object other$organizationType = other.getOrganizationType();
                  return this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType);
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
      return other instanceof WagesDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $organizationType = this.getOrganizationType();
      return result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
   }

   public static class WagesDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Integer productType;
      private Long planId;
      private Boolean organizationType;

      WagesDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public WagesDTOParam.WagesDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public WagesDTOParam.WagesDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("productType")
      public WagesDTOParam.WagesDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("planId")
      public WagesDTOParam.WagesDTOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("organizationType")
      public WagesDTOParam.WagesDTOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public WagesDTOParam build() {
         return new WagesDTOParam(this.projectId, this.monomerId, this.productType, this.planId, this.organizationType);
      }

      @Override
      public String toString() {
         return "WagesDTOParam.WagesDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", productType="
            + this.productType
            + ", planId="
            + this.planId
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
