package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnclosurePlanDetailCreateDto {
   @ApiModelProperty(name = "name", notes = "批次名称")
   @NotBlank(message = "批次名称不能为空!")
   private String name;
   @ApiModelProperty(name = "date", notes = "交货日期")
   @NotNull(message = "交货日期不能为空")
   private LocalDate date;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "categroy", notes = "类型")
   private Integer category;
   @ApiModelProperty(name = "quantityWork", notes = "工程量")
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "remark", notes = "备注")
   private String remark;

   public String getName() {
      return this.name;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
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

      if (!(o instanceof EnclosurePlanDetailCreateDto)) {
         return false;
      }

      EnclosurePlanDetailCreateDto other = (EnclosurePlanDetailCreateDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosurePlanDetailCreateDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
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
      return "EnclosurePlanDetailCreateDto(name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", projectId="
         + this.getProjectId()
         + ", category="
         + this.getCategory()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
