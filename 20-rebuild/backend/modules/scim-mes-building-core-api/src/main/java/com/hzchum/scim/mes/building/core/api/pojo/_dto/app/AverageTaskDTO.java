package com.hzchum.scim.mes.building.core.api.pojo._dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "app工序看板-平均任务达成率")
public class AverageTaskDTO {
   @ApiModelProperty("累计任务数")
   private BigDecimal totalTaskCount;
   @ApiModelProperty("准时完成数")
   private BigDecimal onTimeCompletionCount;
   @ApiModelProperty("平均任务完成率")
   private BigDecimal averageCompletionRate;

   public static AverageTaskDTO.AverageTaskDTOBuilder builder() {
      return new AverageTaskDTO.AverageTaskDTOBuilder();
   }

   public AverageTaskDTO(final BigDecimal totalTaskCount, final BigDecimal onTimeCompletionCount, final BigDecimal averageCompletionRate) {
      this.totalTaskCount = totalTaskCount;
      this.onTimeCompletionCount = onTimeCompletionCount;
      this.averageCompletionRate = averageCompletionRate;
   }

   public AverageTaskDTO() {
   }

   public BigDecimal getTotalTaskCount() {
      return this.totalTaskCount;
   }

   public BigDecimal getOnTimeCompletionCount() {
      return this.onTimeCompletionCount;
   }

   public BigDecimal getAverageCompletionRate() {
      return this.averageCompletionRate;
   }

   public AverageTaskDTO setTotalTaskCount(final BigDecimal totalTaskCount) {
      this.totalTaskCount = totalTaskCount;
      return this;
   }

   public AverageTaskDTO setOnTimeCompletionCount(final BigDecimal onTimeCompletionCount) {
      this.onTimeCompletionCount = onTimeCompletionCount;
      return this;
   }

   public AverageTaskDTO setAverageCompletionRate(final BigDecimal averageCompletionRate) {
      this.averageCompletionRate = averageCompletionRate;
      return this;
   }

   @Override
   public String toString() {
      return "AverageTaskDTO(totalTaskCount="
         + this.getTotalTaskCount()
         + ", onTimeCompletionCount="
         + this.getOnTimeCompletionCount()
         + ", averageCompletionRate="
         + this.getAverageCompletionRate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AverageTaskDTO)) {
         return false;
      }

      AverageTaskDTO other = (AverageTaskDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalTaskCount = this.getTotalTaskCount();
      Object other$totalTaskCount = other.getTotalTaskCount();
      if (this$totalTaskCount == null ? other$totalTaskCount == null : this$totalTaskCount.equals(other$totalTaskCount)) {
         Object this$onTimeCompletionCount = this.getOnTimeCompletionCount();
         Object other$onTimeCompletionCount = other.getOnTimeCompletionCount();
         if (this$onTimeCompletionCount == null ? other$onTimeCompletionCount == null : this$onTimeCompletionCount.equals(other$onTimeCompletionCount)) {
            Object this$averageCompletionRate = this.getAverageCompletionRate();
            Object other$averageCompletionRate = other.getAverageCompletionRate();
            return this$averageCompletionRate == null ? other$averageCompletionRate == null : this$averageCompletionRate.equals(other$averageCompletionRate);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AverageTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalTaskCount = this.getTotalTaskCount();
      result = result * 59 + ($totalTaskCount == null ? 43 : $totalTaskCount.hashCode());
      Object $onTimeCompletionCount = this.getOnTimeCompletionCount();
      result = result * 59 + ($onTimeCompletionCount == null ? 43 : $onTimeCompletionCount.hashCode());
      Object $averageCompletionRate = this.getAverageCompletionRate();
      return result * 59 + ($averageCompletionRate == null ? 43 : $averageCompletionRate.hashCode());
   }

   public static class AverageTaskDTOBuilder {
      private BigDecimal totalTaskCount;
      private BigDecimal onTimeCompletionCount;
      private BigDecimal averageCompletionRate;

      AverageTaskDTOBuilder() {
      }

      public AverageTaskDTO.AverageTaskDTOBuilder totalTaskCount(final BigDecimal totalTaskCount) {
         this.totalTaskCount = totalTaskCount;
         return this;
      }

      public AverageTaskDTO.AverageTaskDTOBuilder onTimeCompletionCount(final BigDecimal onTimeCompletionCount) {
         this.onTimeCompletionCount = onTimeCompletionCount;
         return this;
      }

      public AverageTaskDTO.AverageTaskDTOBuilder averageCompletionRate(final BigDecimal averageCompletionRate) {
         this.averageCompletionRate = averageCompletionRate;
         return this;
      }

      public AverageTaskDTO build() {
         return new AverageTaskDTO(this.totalTaskCount, this.onTimeCompletionCount, this.averageCompletionRate);
      }

      @Override
      public String toString() {
         return "AverageTaskDTO.AverageTaskDTOBuilder(totalTaskCount="
            + this.totalTaskCount
            + ", onTimeCompletionCount="
            + this.onTimeCompletionCount
            + ", averageCompletionRate="
            + this.averageCompletionRate
            + ")";
      }
   }
}
