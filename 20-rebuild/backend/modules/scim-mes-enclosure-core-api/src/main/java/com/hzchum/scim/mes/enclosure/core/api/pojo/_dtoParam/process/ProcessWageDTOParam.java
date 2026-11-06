package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProcessWageDTOParam", description = "")
public class ProcessWageDTOParam {
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "price", notes = "价格", value = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式 [1 重量, 2 长度，3 面积]", value = "计价方式 [1 重量, 2 长度，3 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;

   public static ProcessWageDTOParam.ProcessWageDTOParamBuilder builder() {
      return new ProcessWageDTOParam.ProcessWageDTOParamBuilder();
   }

   public ProcessWageDTOParam() {
   }

   public ProcessWageDTOParam(final Long processId, final BigDecimal price, final Boolean organizationType, final Integer wageQuotaType) {
      this.processId = processId;
      this.price = price;
      this.organizationType = organizationType;
      this.wageQuotaType = wageQuotaType;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   @JsonProperty("processId")
   public ProcessWageDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("price")
   public ProcessWageDTOParam setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("organizationType")
   public ProcessWageDTOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public ProcessWageDTOParam setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessWageDTOParam(processId="
         + this.getProcessId()
         + ", price="
         + this.getPrice()
         + ", organizationType="
         + this.getOrganizationType()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessWageDTOParam)) {
         return false;
      }

      ProcessWageDTOParam other = (ProcessWageDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$organizationType = this.getOrganizationType();
         Object other$organizationType = other.getOrganizationType();
         if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
            Object this$wageQuotaType = this.getWageQuotaType();
            Object other$wageQuotaType = other.getWageQuotaType();
            if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
               Object this$price = this.getPrice();
               Object other$price = other.getPrice();
               return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof ProcessWageDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class ProcessWageDTOParamBuilder {
      private Long processId;
      private BigDecimal price;
      private Boolean organizationType;
      private Integer wageQuotaType;

      ProcessWageDTOParamBuilder() {
      }

      @JsonProperty("processId")
      public ProcessWageDTOParam.ProcessWageDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("price")
      public ProcessWageDTOParam.ProcessWageDTOParamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("organizationType")
      public ProcessWageDTOParam.ProcessWageDTOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public ProcessWageDTOParam.ProcessWageDTOParamBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public ProcessWageDTOParam build() {
         return new ProcessWageDTOParam(this.processId, this.price, this.organizationType, this.wageQuotaType);
      }

      @Override
      public String toString() {
         return "ProcessWageDTOParam.ProcessWageDTOParamBuilder(processId="
            + this.processId
            + ", price="
            + this.price
            + ", organizationType="
            + this.organizationType
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
