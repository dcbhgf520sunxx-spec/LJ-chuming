package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProcessWipStatisticsDTO", description = "在制品工序统计")
public class ProcessWipStatisticsDTO {
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "weight", notes = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   @JsonProperty("processId")
   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("weight")
   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessWipStatisticsDTO)) {
         return false;
      }

      ProcessWipStatisticsDTO other = (ProcessWipStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessWipStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   @Override
   public String toString() {
      return "ProcessWipStatisticsDTO(processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", quantity="
         + this.getQuantity()
         + ", weight="
         + this.getWeight()
         + ")";
   }
}
