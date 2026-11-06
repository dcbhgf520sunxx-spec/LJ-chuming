package com.hzchum.scim.mes.building.core.api.pojo._doParam.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WagesDOParam", description = "")
public class WagesDOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;

   public static WagesDOParam.WagesDOParamBuilder builder() {
      return new WagesDOParam.WagesDOParamBuilder();
   }

   public WagesDOParam(final Long projectId, final Long monomerId, final Integer productType) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productType = productType;
   }

   public WagesDOParam() {
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

   @JsonProperty("projectId")
   public WagesDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public WagesDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("productType")
   public WagesDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "WagesDOParam(projectId=" + this.getProjectId() + ", monomerId=" + this.getMonomerId() + ", productType=" + this.getProductType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WagesDOParam)) {
         return false;
      }

      WagesDOParam other = (WagesDOParam)o;
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
            return this$productType == null ? other$productType == null : this$productType.equals(other$productType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WagesDOParam;
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
      return result * 59 + ($productType == null ? 43 : $productType.hashCode());
   }

   public static class WagesDOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Integer productType;

      WagesDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public WagesDOParam.WagesDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public WagesDOParam.WagesDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("productType")
      public WagesDOParam.WagesDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public WagesDOParam build() {
         return new WagesDOParam(this.projectId, this.monomerId, this.productType);
      }

      @Override
      public String toString() {
         return "WagesDOParam.WagesDOParamBuilder(projectId=" + this.projectId + ", monomerId=" + this.monomerId + ", productType=" + this.productType + ")";
      }
   }
}
