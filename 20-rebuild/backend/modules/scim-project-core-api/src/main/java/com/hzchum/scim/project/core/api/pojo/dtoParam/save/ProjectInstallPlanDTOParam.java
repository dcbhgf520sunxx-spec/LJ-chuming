package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@ApiModel("安装计划设置类")
public class ProjectInstallPlanDTOParam {
   @ApiModelProperty("区域id")
   @NotNull(message = "区域id不能为空")
   private Long id;
   @ApiModelProperty(name = "startDate", value = "安装计划开始日期")
   @NotNull(message = "区域开工日期不能为空")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "安装计划结束日期")
   @NotNull(message = "区域完工日期不能为空")
   private LocalDate endDate;
   @ApiModelProperty(name = "supplierId", value = "供应商id")
   @NotNull(message = "供应商不能为空")
   private Long supplierId;

   public Long getId() {
      return this.id;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallPlanDTOParam)) {
         return false;
      }

      ProjectInstallPlanDTOParam other = (ProjectInstallPlanDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$endDate = this.getEndDate();
               Object other$endDate = other.getEndDate();
               return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof ProjectInstallPlanDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallPlanDTOParam(id="
         + this.getId()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", supplierId="
         + this.getSupplierId()
         + ")";
   }
}
