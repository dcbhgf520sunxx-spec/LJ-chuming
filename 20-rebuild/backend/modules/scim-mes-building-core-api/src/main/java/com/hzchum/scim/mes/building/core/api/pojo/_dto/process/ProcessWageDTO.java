package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProcessWageDTO", description = "")
public class ProcessWageDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "price", notes = "价格", value = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式 [1 重量, 2 长度，3 面积]", value = "计价方式 [1 重量, 2 长度，3 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;

   public static ProcessWageDTO.ProcessWageDTOBuilder builder() {
      return new ProcessWageDTO.ProcessWageDTOBuilder();
   }

   public ProcessWageDTO() {
   }

   public ProcessWageDTO(final Long id, final Long processId, final BigDecimal price, final Integer wageQuotaType, final Boolean organizationType) {
      this.id = id;
      this.processId = processId;
      this.price = price;
      this.wageQuotaType = wageQuotaType;
      this.organizationType = organizationType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("id")
   public ProcessWageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public ProcessWageDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("price")
   public ProcessWageDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public ProcessWageDTO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("organizationType")
   public ProcessWageDTO setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessWageDTO(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", price="
         + this.getPrice()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", organizationType="
         + this.getOrganizationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessWageDTO)) {
         return false;
      }

      ProcessWageDTO other = (ProcessWageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$wageQuotaType = this.getWageQuotaType();
            Object other$wageQuotaType = other.getWageQuotaType();
            if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
               Object this$organizationType = this.getOrganizationType();
               Object other$organizationType = other.getOrganizationType();
               if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessWageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class ProcessWageDTOBuilder {
      private Long id;
      private Long processId;
      private BigDecimal price;
      private Integer wageQuotaType;
      private Boolean organizationType;

      ProcessWageDTOBuilder() {
      }

      @JsonProperty("id")
      public ProcessWageDTO.ProcessWageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public ProcessWageDTO.ProcessWageDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("price")
      public ProcessWageDTO.ProcessWageDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public ProcessWageDTO.ProcessWageDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("organizationType")
      public ProcessWageDTO.ProcessWageDTOBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public ProcessWageDTO build() {
         return new ProcessWageDTO(this.id, this.processId, this.price, this.wageQuotaType, this.organizationType);
      }

      @Override
      public String toString() {
         return "ProcessWageDTO.ProcessWageDTOBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", price="
            + this.price
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
