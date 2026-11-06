package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.wages.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TeamWagesDTOParam", description = "")
public class TeamWagesDTOParam {
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "organizationType", notes = "编制类型")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @NotNull(message = "编制类型不能为空")
   private Boolean organizationType;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "details", notes = "详情")
   @JsonProperty("details")
   @JSONField(name = "details")
   private List<TeamWagesDetailsDTOParam> details;

   public static TeamWagesDTOParam.TeamWagesDTOParamBuilder builder() {
      return new TeamWagesDTOParam.TeamWagesDTOParamBuilder();
   }

   public TeamWagesDTOParam(
      final Long productId, final Integer productType, final Boolean organizationType, final Long processId, final List<TeamWagesDetailsDTOParam> details
   ) {
      this.productId = productId;
      this.productType = productType;
      this.organizationType = organizationType;
      this.processId = processId;
      this.details = details;
   }

   public TeamWagesDTOParam() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public List<TeamWagesDetailsDTOParam> getDetails() {
      return this.details;
   }

   @JsonProperty("productId")
   public TeamWagesDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public TeamWagesDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("organizationType")
   public TeamWagesDTOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("processId")
   public TeamWagesDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("details")
   public TeamWagesDTOParam setDetails(final List<TeamWagesDetailsDTOParam> details) {
      this.details = details;
      return this;
   }

   @Override
   public String toString() {
      return "TeamWagesDTOParam(productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", organizationType="
         + this.getOrganizationType()
         + ", processId="
         + this.getProcessId()
         + ", details="
         + this.getDetails()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamWagesDTOParam)) {
         return false;
      }

      TeamWagesDTOParam other = (TeamWagesDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$organizationType = this.getOrganizationType();
            Object other$organizationType = other.getOrganizationType();
            if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$details = this.getDetails();
                  Object other$details = other.getDetails();
                  return this$details == null ? other$details == null : this$details.equals(other$details);
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
      return other instanceof TeamWagesDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   public static class TeamWagesDTOParamBuilder {
      private Long productId;
      private Integer productType;
      private Boolean organizationType;
      private Long processId;
      private List<TeamWagesDetailsDTOParam> details;

      TeamWagesDTOParamBuilder() {
      }

      @JsonProperty("productId")
      public TeamWagesDTOParam.TeamWagesDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public TeamWagesDTOParam.TeamWagesDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("organizationType")
      public TeamWagesDTOParam.TeamWagesDTOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("processId")
      public TeamWagesDTOParam.TeamWagesDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("details")
      public TeamWagesDTOParam.TeamWagesDTOParamBuilder details(final List<TeamWagesDetailsDTOParam> details) {
         this.details = details;
         return this;
      }

      public TeamWagesDTOParam build() {
         return new TeamWagesDTOParam(this.productId, this.productType, this.organizationType, this.processId, this.details);
      }

      @Override
      public String toString() {
         return "TeamWagesDTOParam.TeamWagesDTOParamBuilder(productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", organizationType="
            + this.organizationType
            + ", processId="
            + this.processId
            + ", details="
            + this.details
            + ")";
      }
   }
}
