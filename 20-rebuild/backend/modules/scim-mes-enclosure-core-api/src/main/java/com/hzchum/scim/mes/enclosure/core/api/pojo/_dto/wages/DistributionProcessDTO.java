package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "DistributionProcessDO", description = "")
public class DistributionProcessDTO {
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "生产数量")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "price", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static DistributionProcessDTO.DistributionProcessDTOBuilder builder() {
      return new DistributionProcessDTO.DistributionProcessDTOBuilder();
   }

   public DistributionProcessDTO(final Long processId, final String processName, final BigDecimal price) {
      this.processId = processId;
      this.processName = processName;
      this.price = price;
   }

   public DistributionProcessDTO() {
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("processId")
   public DistributionProcessDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public DistributionProcessDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("price")
   public DistributionProcessDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "DistributionProcessDTO(processId=" + this.getProcessId() + ", processName=" + this.getProcessName() + ", price=" + this.getPrice() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DistributionProcessDTO)) {
         return false;
      }

      DistributionProcessDTO other = (DistributionProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$processName = this.getProcessName();
         Object other$processName = other.getProcessName();
         if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
            Object this$price = this.getPrice();
            Object other$price = other.getPrice();
            return this$price == null ? other$price == null : this$price.equals(other$price);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DistributionProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class DistributionProcessDTOBuilder {
      private Long processId;
      private String processName;
      private BigDecimal price;

      DistributionProcessDTOBuilder() {
      }

      @JsonProperty("processId")
      public DistributionProcessDTO.DistributionProcessDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public DistributionProcessDTO.DistributionProcessDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("price")
      public DistributionProcessDTO.DistributionProcessDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public DistributionProcessDTO build() {
         return new DistributionProcessDTO(this.processId, this.processName, this.price);
      }

      @Override
      public String toString() {
         return "DistributionProcessDTO.DistributionProcessDTOBuilder(processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", price="
            + this.price
            + ")";
      }
   }
}
