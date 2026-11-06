package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProcessAndQuantityDTO", description = "每道工序可操作数量详情")
public class ProcessAndQuantityDTO {
   @ApiModelProperty(name = "processId", notes = "processId")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "processName")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "taskTypeEnum", notes = "taskTypeEnum")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", value = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "weight", value = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;

   public static ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder builder() {
      return new ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder();
   }

   public ProcessAndQuantityDTO() {
   }

   public ProcessAndQuantityDTO(
      final Long processId, final String processName, final Integer taskTypeEnum, final Integer quantity, final BigDecimal netWeight, final BigDecimal weight
   ) {
      this.processId = processId;
      this.processName = processName;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.weight = weight;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   @JsonProperty("processId")
   public ProcessAndQuantityDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public ProcessAndQuantityDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProcessAndQuantityDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public ProcessAndQuantityDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ProcessAndQuantityDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("weight")
   public ProcessAndQuantityDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessAndQuantityDTO(processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", weight="
         + this.getWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessAndQuantityDTO)) {
         return false;
      }

      ProcessAndQuantityDTO other = (ProcessAndQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$processName = this.getProcessName();
               Object other$processName = other.getProcessName();
               if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                  Object this$netWeight = this.getNetWeight();
                  Object other$netWeight = other.getNetWeight();
                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                     Object this$weight = this.getWeight();
                     Object other$weight = other.getWeight();
                     return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessAndQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   public static class ProcessAndQuantityDTOBuilder {
      private Long processId;
      private String processName;
      private Integer taskTypeEnum;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal weight;

      ProcessAndQuantityDTOBuilder() {
      }

      @JsonProperty("processId")
      public ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("weight")
      public ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public ProcessAndQuantityDTO build() {
         return new ProcessAndQuantityDTO(this.processId, this.processName, this.taskTypeEnum, this.quantity, this.netWeight, this.weight);
      }

      @Override
      public String toString() {
         return "ProcessAndQuantityDTO.ProcessAndQuantityDTOBuilder(processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", weight="
            + this.weight
            + ")";
      }
   }
}
