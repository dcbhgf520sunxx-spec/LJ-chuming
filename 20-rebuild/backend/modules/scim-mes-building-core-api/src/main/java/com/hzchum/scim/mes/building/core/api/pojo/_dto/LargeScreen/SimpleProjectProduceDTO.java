package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "简单项目产量")
public class SimpleProjectProduceDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "totalWeight", value = "总重")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "processName", value = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "rate", value = "工序名称")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;

   public static SimpleProjectProduceDTO.SimpleProjectProduceDTOBuilder builder() {
      return new SimpleProjectProduceDTO.SimpleProjectProduceDTOBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public String getProcessName() {
      return this.processName;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("totalWeight")
   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("rate")
   public void setRate(final BigDecimal rate) {
      this.rate = rate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SimpleProjectProduceDTO)) {
         return false;
      }

      SimpleProjectProduceDTO other = (SimpleProjectProduceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$totalWeight = this.getTotalWeight();
         Object other$totalWeight = other.getTotalWeight();
         if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
               Object this$rate = this.getRate();
               Object other$rate = other.getRate();
               return this$rate == null ? other$rate == null : this$rate.equals(other$rate);
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
      return other instanceof SimpleProjectProduceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $rate = this.getRate();
      return result * 59 + ($rate == null ? 43 : $rate.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleProjectProduceDTO(super="
         + super.toString()
         + ", projectId="
         + this.getProjectId()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", processName="
         + this.getProcessName()
         + ", rate="
         + this.getRate()
         + ")";
   }

   public SimpleProjectProduceDTO(final Long projectId, final BigDecimal totalWeight, final String processName, final BigDecimal rate) {
      this.projectId = projectId;
      this.totalWeight = totalWeight;
      this.processName = processName;
      this.rate = rate;
   }

   public SimpleProjectProduceDTO() {
   }

   public static class SimpleProjectProduceDTOBuilder {
      private Long projectId;
      private BigDecimal totalWeight;
      private String processName;
      private BigDecimal rate;

      SimpleProjectProduceDTOBuilder() {
      }

      @JsonProperty("projectId")
      public SimpleProjectProduceDTO.SimpleProjectProduceDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("totalWeight")
      public SimpleProjectProduceDTO.SimpleProjectProduceDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("processName")
      public SimpleProjectProduceDTO.SimpleProjectProduceDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("rate")
      public SimpleProjectProduceDTO.SimpleProjectProduceDTOBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      public SimpleProjectProduceDTO build() {
         return new SimpleProjectProduceDTO(this.projectId, this.totalWeight, this.processName, this.rate);
      }

      @Override
      public String toString() {
         return "SimpleProjectProduceDTO.SimpleProjectProduceDTOBuilder(projectId="
            + this.projectId
            + ", totalWeight="
            + this.totalWeight
            + ", processName="
            + this.processName
            + ", rate="
            + this.rate
            + ")";
      }
   }
}
