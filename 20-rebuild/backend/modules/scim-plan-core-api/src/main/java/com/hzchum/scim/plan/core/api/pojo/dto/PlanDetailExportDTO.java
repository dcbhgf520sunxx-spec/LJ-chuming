package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;
import java.time.LocalDate;

@ExcelTarget("PlanDetailExportDTO")
public class PlanDetailExportDTO implements Serializable {
   @Excel(name = "序号")
   private Long orderNo;
   @Excel(name = "区域名称")
   private String name;
   @Excel(name = "轴线/标高")
   private String axis;
   @Excel(name = "类型", replace = {"自制_0", "外包_1"})
   private Integer type;
   @Excel(name = "开始日期", format = "yyyy-MM-dd")
   private LocalDate startDate;
   @Excel(name = "结束日期", format = "yyyy-MM-dd")
   private LocalDate endDate;
   @Excel(name = "计划用时(天)")
   private Integer planDays;
   @Excel(name = "备注")
   private String remark;

   public Long getOrderNo() {
      return this.orderNo;
   }

   public String getName() {
      return this.name;
   }

   public String getAxis() {
      return this.axis;
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

   public Integer getPlanDays() {
      return this.planDays;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setOrderNo(final Long orderNo) {
      this.orderNo = orderNo;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setAxis(final String axis) {
      this.axis = axis;
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

   public void setPlanDays(final Integer planDays) {
      this.planDays = planDays;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanDetailExportDTO)) {
         return false;
      }

      PlanDetailExportDTO other = (PlanDetailExportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$planDays = this.getPlanDays();
            Object other$planDays = other.getPlanDays();
            if (this$planDays == null ? other$planDays == null : this$planDays.equals(other$planDays)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$axis = this.getAxis();
                  Object other$axis = other.getAxis();
                  if (this$axis == null ? other$axis == null : this$axis.equals(other$axis)) {
                     Object this$startDate = this.getStartDate();
                     Object other$startDate = other.getStartDate();
                     if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                        Object this$endDate = this.getEndDate();
                        Object other$endDate = other.getEndDate();
                        if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanDetailExportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $planDays = this.getPlanDays();
      result = result * 59 + ($planDays == null ? 43 : $planDays.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $axis = this.getAxis();
      result = result * 59 + ($axis == null ? 43 : $axis.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "PlanDetailExportDTO(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
         + ", axis="
         + this.getAxis()
         + ", type="
         + this.getType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", planDays="
         + this.getPlanDays()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
