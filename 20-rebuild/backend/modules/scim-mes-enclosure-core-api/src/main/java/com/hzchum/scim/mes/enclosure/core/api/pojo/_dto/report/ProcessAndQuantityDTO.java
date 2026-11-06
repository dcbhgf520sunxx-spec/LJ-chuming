package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessAndQuantityDTO", description = "每道工序可操作数量详情")
public class ProcessAndQuantityDTO {
   @ApiModelProperty(name = "quantity", value = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "processId", notes = "processId")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;

   public static ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder builder() {
      return new ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder();
   }

   public ProcessAndQuantityDTO() {
   }

   public ProcessAndQuantityDTO(final Integer quantity, final Long processId) {
      this.quantity = quantity;
      this.processId = processId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getProcessId() {
      return this.processId;
   }

   @JsonProperty("quantity")
   public ProcessAndQuantityDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("processId")
   public ProcessAndQuantityDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessAndQuantityDTO(quantity=" + this.getQuantity() + ", processId=" + this.getProcessId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProcessAndQuantityDTO)) {
         return false;
      } else {
         ProcessAndQuantityDTO other = (ProcessAndQuantityDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               return this$processId == null ? other$processId == null : this$processId.equals(other$processId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessAndQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $processId = this.getProcessId();
      return result * 59 + ($processId == null ? 43 : $processId.hashCode());
   }

   public static class ProcessAndQuantityDTOBuilder {
      private Integer quantity;
      private Long processId;

      ProcessAndQuantityDTOBuilder() {
      }

      @JsonProperty("quantity")
      public ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("processId")
      public ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public ProcessAndQuantityDTO build() {
         return new ProcessAndQuantityDTO(this.quantity, this.processId);
      }

      @Override
      public String toString() {
         return "ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder(quantity=" + this.quantity + ", processId=" + this.processId + ")";
      }
   }
}
