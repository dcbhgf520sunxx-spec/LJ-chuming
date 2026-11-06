package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessKanBanAndQuantityDTO", description = "工序看板数")
public class ProcessKanBanAndQuantityDTO {
   @ApiModelProperty(name = "incompleteQuantity", value = "未完成数")
   @JsonProperty("incompleteQuantity")
   @JSONField(name = "incompleteQuantity")
   private Integer incompleteQuantity;
   @ApiModelProperty(name = "dayQuantity", value = "当天完成数")
   @JsonProperty("dayQuantity")
   @JSONField(name = "dayQuantity")
   private Integer dayQuantity;
   @ApiModelProperty(name = "monthQuantity", value = "当月完成数")
   @JsonProperty("monthQuantity")
   @JSONField(name = "monthQuantity")
   private Integer monthQuantity;
   @ApiModelProperty(name = "qhseQuantity", value = "不合格数")
   @JsonProperty("qhseQuantity")
   @JSONField(name = "qhseQuantity")
   private Integer qhseQuantity;

   public static ProcessKanBanAndQuantityDTO.ProcessKanBanAndQuantityDTOBuilder builder() {
      return new ProcessKanBanAndQuantityDTO.ProcessKanBanAndQuantityDTOBuilder();
   }

   public ProcessKanBanAndQuantityDTO() {
   }

   public ProcessKanBanAndQuantityDTO(final Integer incompleteQuantity, final Integer dayQuantity, final Integer monthQuantity, final Integer qhseQuantity) {
      this.incompleteQuantity = incompleteQuantity;
      this.dayQuantity = dayQuantity;
      this.monthQuantity = monthQuantity;
      this.qhseQuantity = qhseQuantity;
   }

   public Integer getIncompleteQuantity() {
      return this.incompleteQuantity;
   }

   public Integer getDayQuantity() {
      return this.dayQuantity;
   }

   public Integer getMonthQuantity() {
      return this.monthQuantity;
   }

   public Integer getQhseQuantity() {
      return this.qhseQuantity;
   }

   @JsonProperty("incompleteQuantity")
   public ProcessKanBanAndQuantityDTO setIncompleteQuantity(final Integer incompleteQuantity) {
      this.incompleteQuantity = incompleteQuantity;
      return this;
   }

   @JsonProperty("dayQuantity")
   public ProcessKanBanAndQuantityDTO setDayQuantity(final Integer dayQuantity) {
      this.dayQuantity = dayQuantity;
      return this;
   }

   @JsonProperty("monthQuantity")
   public ProcessKanBanAndQuantityDTO setMonthQuantity(final Integer monthQuantity) {
      this.monthQuantity = monthQuantity;
      return this;
   }

   @JsonProperty("qhseQuantity")
   public ProcessKanBanAndQuantityDTO setQhseQuantity(final Integer qhseQuantity) {
      this.qhseQuantity = qhseQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessKanBanAndQuantityDTO(incompleteQuantity="
         + this.getIncompleteQuantity()
         + ", dayQuantity="
         + this.getDayQuantity()
         + ", monthQuantity="
         + this.getMonthQuantity()
         + ", qhseQuantity="
         + this.getQhseQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessKanBanAndQuantityDTO)) {
         return false;
      }

      ProcessKanBanAndQuantityDTO other = (ProcessKanBanAndQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$incompleteQuantity = this.getIncompleteQuantity();
      Object other$incompleteQuantity = other.getIncompleteQuantity();
      if (this$incompleteQuantity == null ? other$incompleteQuantity == null : this$incompleteQuantity.equals(other$incompleteQuantity)) {
         Object this$dayQuantity = this.getDayQuantity();
         Object other$dayQuantity = other.getDayQuantity();
         if (this$dayQuantity == null ? other$dayQuantity == null : this$dayQuantity.equals(other$dayQuantity)) {
            Object this$monthQuantity = this.getMonthQuantity();
            Object other$monthQuantity = other.getMonthQuantity();
            if (this$monthQuantity == null ? other$monthQuantity == null : this$monthQuantity.equals(other$monthQuantity)) {
               Object this$qhseQuantity = this.getQhseQuantity();
               Object other$qhseQuantity = other.getQhseQuantity();
               return this$qhseQuantity == null ? other$qhseQuantity == null : this$qhseQuantity.equals(other$qhseQuantity);
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
      return other instanceof ProcessKanBanAndQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $incompleteQuantity = this.getIncompleteQuantity();
      result = result * 59 + ($incompleteQuantity == null ? 43 : $incompleteQuantity.hashCode());
      Object $dayQuantity = this.getDayQuantity();
      result = result * 59 + ($dayQuantity == null ? 43 : $dayQuantity.hashCode());
      Object $monthQuantity = this.getMonthQuantity();
      result = result * 59 + ($monthQuantity == null ? 43 : $monthQuantity.hashCode());
      Object $qhseQuantity = this.getQhseQuantity();
      return result * 59 + ($qhseQuantity == null ? 43 : $qhseQuantity.hashCode());
   }

   public static class ProcessKanBanAndQuantityDTOBuilder {
      private Integer incompleteQuantity;
      private Integer dayQuantity;
      private Integer monthQuantity;
      private Integer qhseQuantity;

      ProcessKanBanAndQuantityDTOBuilder() {
      }

      @JsonProperty("incompleteQuantity")
      public ProcessKanBanAndQuantityDTO.ProcessKanBanAndQuantityDTOBuilder incompleteQuantity(final Integer incompleteQuantity) {
         this.incompleteQuantity = incompleteQuantity;
         return this;
      }

      @JsonProperty("dayQuantity")
      public ProcessKanBanAndQuantityDTO.ProcessKanBanAndQuantityDTOBuilder dayQuantity(final Integer dayQuantity) {
         this.dayQuantity = dayQuantity;
         return this;
      }

      @JsonProperty("monthQuantity")
      public ProcessKanBanAndQuantityDTO.ProcessKanBanAndQuantityDTOBuilder monthQuantity(final Integer monthQuantity) {
         this.monthQuantity = monthQuantity;
         return this;
      }

      @JsonProperty("qhseQuantity")
      public ProcessKanBanAndQuantityDTO.ProcessKanBanAndQuantityDTOBuilder qhseQuantity(final Integer qhseQuantity) {
         this.qhseQuantity = qhseQuantity;
         return this;
      }

      public ProcessKanBanAndQuantityDTO build() {
         return new ProcessKanBanAndQuantityDTO(this.incompleteQuantity, this.dayQuantity, this.monthQuantity, this.qhseQuantity);
      }

      @Override
      public String toString() {
         return "ProcessKanBanAndQuantityDTO.ProcessKanBanAndQuantityDTOBuilder(incompleteQuantity="
            + this.incompleteQuantity
            + ", dayQuantity="
            + this.dayQuantity
            + ", monthQuantity="
            + this.monthQuantity
            + ", qhseQuantity="
            + this.qhseQuantity
            + ")";
      }
   }
}
