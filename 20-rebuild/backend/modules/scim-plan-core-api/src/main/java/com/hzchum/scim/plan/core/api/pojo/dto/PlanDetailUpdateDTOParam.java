package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@ApiModel("编辑 计划详情 请求类")
public class PlanDetailUpdateDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "type", value = "计划类型 1深化计划 2加工计划 4安装计划 8发运计划 16材料采购计划")
   @NotNull(message = "计划类型不能为空")
   private Integer type;
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;

   public Long getId() {
      return this.id;
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

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanDetailUpdateDTOParam)) {
         return false;
      }

      PlanDetailUpdateDTOParam other = (PlanDetailUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanDetailUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "PlanDetailUpdateDTOParam(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
