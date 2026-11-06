package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel("计划追踪 响应类")
public class PlanDetailTraceDTO {
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "type", value = "1-深化计划   2-加工计划   4-安装计划  ")
   private Integer type;
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束日期")
   private LocalDate endDate;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "mete", value = "总量")
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "completedMete", value = "已完成量")
   private BigDecimal completedMete;

   public static PlanDetailTraceDTO.PlanDetailTraceDTOBuilder builder() {
      return new PlanDetailTraceDTO.PlanDetailTraceDTOBuilder();
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getCompletedMete() {
      return this.completedMete;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setCompletedMete(final BigDecimal completedMete) {
      this.completedMete = completedMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanDetailTraceDTO)) {
         return false;
      }

      PlanDetailTraceDTO other = (PlanDetailTraceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$startDate = this.getStartDate();
         Object other$startDate = other.getStartDate();
         if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
            Object this$endDate = this.getEndDate();
            Object other$endDate = other.getEndDate();
            if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                  Object this$completedMete = this.getCompletedMete();
                  Object other$completedMete = other.getCompletedMete();
                  return this$completedMete == null ? other$completedMete == null : this$completedMete.equals(other$completedMete);
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
      return other instanceof PlanDetailTraceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $completedMete = this.getCompletedMete();
      return result * 59 + ($completedMete == null ? 43 : $completedMete.hashCode());
   }

   @Override
   public String toString() {
      return "PlanDetailTraceDTO(type="
         + this.getType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", mete="
         + this.getMete()
         + ", completedMete="
         + this.getCompletedMete()
         + ")";
   }

   public PlanDetailTraceDTO(final Integer type, final LocalDate startDate, final LocalDate endDate, final BigDecimal mete, final BigDecimal completedMete) {
      this.type = type;
      this.startDate = startDate;
      this.endDate = endDate;
      this.mete = mete;
      this.completedMete = completedMete;
   }

   public PlanDetailTraceDTO() {
   }

   public static class PlanDetailTraceDTOBuilder {
      private Integer type;
      private LocalDate startDate;
      private LocalDate endDate;
      private BigDecimal mete;
      private BigDecimal completedMete;

      PlanDetailTraceDTOBuilder() {
      }

      public PlanDetailTraceDTO.PlanDetailTraceDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public PlanDetailTraceDTO.PlanDetailTraceDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public PlanDetailTraceDTO.PlanDetailTraceDTOBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public PlanDetailTraceDTO.PlanDetailTraceDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PlanDetailTraceDTO.PlanDetailTraceDTOBuilder completedMete(final BigDecimal completedMete) {
         this.completedMete = completedMete;
         return this;
      }

      public PlanDetailTraceDTO build() {
         return new PlanDetailTraceDTO(this.type, this.startDate, this.endDate, this.mete, this.completedMete);
      }

      @Override
      public String toString() {
         return "PlanDetailTraceDTO.PlanDetailTraceDTOBuilder(type="
            + this.type
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", mete="
            + this.mete
            + ", completedMete="
            + this.completedMete
            + ")";
      }
   }
}
