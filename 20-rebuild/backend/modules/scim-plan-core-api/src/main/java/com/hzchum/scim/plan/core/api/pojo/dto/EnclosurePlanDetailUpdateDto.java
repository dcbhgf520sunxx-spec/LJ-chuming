package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnclosurePlanDetailUpdateDto {
   @ApiModelProperty(name = "id", notes = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "name", notes = "批次名称")
   @NotBlank(message = "批次名称不能为空!")
   private String name;
   @ApiModelProperty(name = "date", notes = "交货日期")
   @NotNull(message = "交货日期不能为空")
   private LocalDate date;
   @ApiModelProperty(name = "quantityWork", notes = "工程量")
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "remark", notes = "备注")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosurePlanDetailUpdateDto)) {
         return false;
      }

      EnclosurePlanDetailUpdateDto other = (EnclosurePlanDetailUpdateDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$quantityWork = this.getQuantityWork();
               Object other$quantityWork = other.getQuantityWork();
               if (this$quantityWork == null ? other$quantityWork == null : this$quantityWork.equals(other$quantityWork)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosurePlanDetailUpdateDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $quantityWork = this.getQuantityWork();
      result = result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosurePlanDetailUpdateDto(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
