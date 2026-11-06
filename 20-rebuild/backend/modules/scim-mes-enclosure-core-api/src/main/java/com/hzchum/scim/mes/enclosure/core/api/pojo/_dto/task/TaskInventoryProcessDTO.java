package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TaskInventoryProcessDTO", description = "清单工序关联表")
public class TaskInventoryProcessDTO {
   @ApiModelProperty("清单数量")
   private Integer quantity;
   @ApiModelProperty("清单重量(净重:kg)")
   private BigDecimal netWeight;
   @ApiModelProperty("清单重量(毛重:kg)")
   private BigDecimal grossWeight;
   @ApiModelProperty("工序id")
   @JsonInclude(Include.NON_NULL)
   private Long processId;
   @ApiModelProperty(name = "boolHaveHole", value = "零件是否有孔 true 有孔 false 无孔")
   private Boolean boolHaveHole;

   public static TaskInventoryProcessDTO.TaskInventoryProcessDTOBuilder builder() {
      return new TaskInventoryProcessDTO.TaskInventoryProcessDTOBuilder();
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Boolean getBoolHaveHole() {
      return this.boolHaveHole;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setBoolHaveHole(final Boolean boolHaveHole) {
      this.boolHaveHole = boolHaveHole;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskInventoryProcessDTO)) {
         return false;
      }

      TaskInventoryProcessDTO other = (TaskInventoryProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$boolHaveHole = this.getBoolHaveHole();
            Object other$boolHaveHole = other.getBoolHaveHole();
            if (this$boolHaveHole == null ? other$boolHaveHole == null : this$boolHaveHole.equals(other$boolHaveHole)) {
               Object this$netWeight = this.getNetWeight();
               Object other$netWeight = other.getNetWeight();
               if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                  Object this$grossWeight = this.getGrossWeight();
                  Object other$grossWeight = other.getGrossWeight();
                  return this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight);
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
      return other instanceof TaskInventoryProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $boolHaveHole = this.getBoolHaveHole();
      result = result * 59 + ($boolHaveHole == null ? 43 : $boolHaveHole.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      return result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "TaskInventoryProcessDTO(quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", processId="
         + this.getProcessId()
         + ", boolHaveHole="
         + this.getBoolHaveHole()
         + ")";
   }

   public TaskInventoryProcessDTO() {
   }

   public TaskInventoryProcessDTO(
      final Integer quantity, final BigDecimal netWeight, final BigDecimal grossWeight, final Long processId, final Boolean boolHaveHole
   ) {
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.processId = processId;
      this.boolHaveHole = boolHaveHole;
   }

   public static class TaskInventoryProcessDTOBuilder {
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Long processId;
      private Boolean boolHaveHole;

      TaskInventoryProcessDTOBuilder() {
      }

      public TaskInventoryProcessDTO.TaskInventoryProcessDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TaskInventoryProcessDTO.TaskInventoryProcessDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TaskInventoryProcessDTO.TaskInventoryProcessDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public TaskInventoryProcessDTO.TaskInventoryProcessDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public TaskInventoryProcessDTO.TaskInventoryProcessDTOBuilder boolHaveHole(final Boolean boolHaveHole) {
         this.boolHaveHole = boolHaveHole;
         return this;
      }

      public TaskInventoryProcessDTO build() {
         return new TaskInventoryProcessDTO(this.quantity, this.netWeight, this.grossWeight, this.processId, this.boolHaveHole);
      }

      @Override
      public String toString() {
         return "TaskInventoryProcessDTO.TaskInventoryProcessDTOBuilder(quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", processId="
            + this.processId
            + ", boolHaveHole="
            + this.boolHaveHole
            + ")";
      }
   }
}
