package com.hzchum.scim.rest.pojo.vo.mes.building.request.wages.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "WagesRequest", description = "")
public class WagesRequest {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @NotNull(message = "项目id不能为空")
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
   @ApiModelProperty(name = "organizationType", notes = "编制类型")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;

   public static WagesRequest.WagesRequestBuilder builder() {
      return new WagesRequest.WagesRequestBuilder();
   }

   public WagesRequest(final Long projectId, final Long monomerId, final Integer productType, final Boolean organizationType) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productType = productType;
      this.organizationType = organizationType;
   }

   public WagesRequest() {
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

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("projectId")
   public WagesRequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public WagesRequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("productType")
   public WagesRequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("organizationType")
   public WagesRequest setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "WagesRequest(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
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

      if (!(o instanceof WagesRequest)) {
         return false;
      }

      WagesRequest other = (WagesRequest)o;
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WagesRequest;
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
      Object $organizationType = this.getOrganizationType();
      return result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
   }

   public static class WagesRequestBuilder {
      private Long projectId;
      private Long monomerId;
      private Integer productType;
      private Boolean organizationType;

      WagesRequestBuilder() {
      }

      @JsonProperty("projectId")
      public WagesRequest.WagesRequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public WagesRequest.WagesRequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("productType")
      public WagesRequest.WagesRequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("organizationType")
      public WagesRequest.WagesRequestBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public WagesRequest build() {
         return new WagesRequest(this.projectId, this.monomerId, this.productType, this.organizationType);
      }

      @Override
      public String toString() {
         return "WagesRequest.WagesRequestBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", productType="
            + this.productType
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
