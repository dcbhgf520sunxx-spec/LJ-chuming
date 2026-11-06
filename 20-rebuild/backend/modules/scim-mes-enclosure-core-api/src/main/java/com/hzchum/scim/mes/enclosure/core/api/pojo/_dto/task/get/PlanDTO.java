package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.get;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PlanDTO {
   @ApiModelProperty(notes = "计划id")
   private Long planId;
   @ApiModelProperty(notes = "计划名")
   private String planName;
   @ApiModelProperty("开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty("交货日期")
   private LocalDateTime date;
   @ApiModelProperty("工程量")
   private BigDecimal quantityWork;
   @ApiModelProperty("2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private List<Integer> categorys;

   public static PlanDTO.PlanDTOBuilder builder() {
      return new PlanDTO.PlanDTOBuilder();
   }

   public Long getPlanId() {
      return this.planId;
   }

   public String getPlanName() {
      return this.planName;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public List<Integer> getCategorys() {
      return this.categorys;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setPlanName(final String planName) {
      this.planName = planName;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setDate(final LocalDateTime date) {
      this.date = date;
   }

   public void setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
   }

   public void setCategorys(final List<Integer> categorys) {
      this.categorys = categorys;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanDTO)) {
         return false;
      }

      PlanDTO other = (PlanDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$planId = this.getPlanId();
      Object other$planId = other.getPlanId();
      if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
         Object this$planName = this.getPlanName();
         Object other$planName = other.getPlanName();
         if (this$planName == null ? other$planName == null : this$planName.equals(other$planName)) {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$date = this.getDate();
               Object other$date = other.getDate();
               if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                  Object this$quantityWork = this.getQuantityWork();
                  Object other$quantityWork = other.getQuantityWork();
                  if (this$quantityWork == null ? other$quantityWork == null : this$quantityWork.equals(other$quantityWork)) {
                     Object this$categorys = this.getCategorys();
                     Object other$categorys = other.getCategorys();
                     return this$categorys == null ? other$categorys == null : this$categorys.equals(other$categorys);
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
      return other instanceof PlanDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $planName = this.getPlanName();
      result = result * 59 + ($planName == null ? 43 : $planName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $quantityWork = this.getQuantityWork();
      result = result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
      Object $categorys = this.getCategorys();
      return result * 59 + ($categorys == null ? 43 : $categorys.hashCode());
   }

   @Override
   public String toString() {
      return "PlanDTO(planId="
         + this.getPlanId()
         + ", planName="
         + this.getPlanName()
         + ", startDate="
         + this.getStartDate()
         + ", date="
         + this.getDate()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", categorys="
         + this.getCategorys()
         + ")";
   }

   public PlanDTO(
      final Long planId,
      final String planName,
      final LocalDateTime startDate,
      final LocalDateTime date,
      final BigDecimal quantityWork,
      final List<Integer> categorys
   ) {
      this.planId = planId;
      this.planName = planName;
      this.startDate = startDate;
      this.date = date;
      this.quantityWork = quantityWork;
      this.categorys = categorys;
   }

   public PlanDTO() {
   }

   public static class PlanDTOBuilder {
      private Long planId;
      private String planName;
      private LocalDateTime startDate;
      private LocalDateTime date;
      private BigDecimal quantityWork;
      private List<Integer> categorys;

      PlanDTOBuilder() {
      }

      public PlanDTO.PlanDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public PlanDTO.PlanDTOBuilder planName(final String planName) {
         this.planName = planName;
         return this;
      }

      public PlanDTO.PlanDTOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public PlanDTO.PlanDTOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public PlanDTO.PlanDTOBuilder quantityWork(final BigDecimal quantityWork) {
         this.quantityWork = quantityWork;
         return this;
      }

      public PlanDTO.PlanDTOBuilder categorys(final List<Integer> categorys) {
         this.categorys = categorys;
         return this;
      }

      public PlanDTO build() {
         return new PlanDTO(this.planId, this.planName, this.startDate, this.date, this.quantityWork, this.categorys);
      }

      @Override
      public String toString() {
         return "PlanDTO.PlanDTOBuilder(planId="
            + this.planId
            + ", planName="
            + this.planName
            + ", startDate="
            + this.startDate
            + ", date="
            + this.date
            + ", quantityWork="
            + this.quantityWork
            + ", categorys="
            + this.categorys
            + ")";
      }
   }
}
