package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "FormSummaryDTOParam", description = "项目报表请求类")
public class FormSummaryDTOParam {
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
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "产品类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;

   public static FormSummaryDTOParam.FormSummaryDTOParamBuilder builder() {
      return new FormSummaryDTOParam.FormSummaryDTOParamBuilder();
   }

   public FormSummaryDTOParam() {
   }

   public FormSummaryDTOParam(final Long projectId, final Long monomerId, final Integer productType, final Integer category) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productType = productType;
      this.category = category;
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

   public Integer getCategory() {
      return this.category;
   }

   @JsonProperty("projectId")
   public FormSummaryDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public FormSummaryDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("productType")
   public FormSummaryDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public FormSummaryDTOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @Override
   public String toString() {
      return "FormSummaryDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FormSummaryDTOParam)) {
         return false;
      }

      FormSummaryDTOParam other = (FormSummaryDTOParam)o;
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
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               return this$category == null ? other$category == null : this$category.equals(other$category);
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
      return other instanceof FormSummaryDTOParam;
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
      Object $category = this.getCategory();
      return result * 59 + ($category == null ? 43 : $category.hashCode());
   }

   public static class FormSummaryDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Integer productType;
      private Integer category;

      FormSummaryDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public FormSummaryDTOParam.FormSummaryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public FormSummaryDTOParam.FormSummaryDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("productType")
      public FormSummaryDTOParam.FormSummaryDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public FormSummaryDTOParam.FormSummaryDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public FormSummaryDTOParam build() {
         return new FormSummaryDTOParam(this.projectId, this.monomerId, this.productType, this.category);
      }

      @Override
      public String toString() {
         return "FormSummaryDTOParam.FormSummaryDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ")";
      }
   }
}
