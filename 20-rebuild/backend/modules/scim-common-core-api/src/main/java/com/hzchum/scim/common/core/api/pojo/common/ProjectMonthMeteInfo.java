package com.hzchum.scim.common.core.api.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目-月份-完成量")
public class ProjectMonthMeteInfo {
   @ApiModelProperty(name = "month", notes = "年月")
   private Integer month;
   @ApiModelProperty(name = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "mete", notes = "产量")
   private BigDecimal mete;

   public Integer getMonth() {
      return this.month;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectMonthMeteInfo)) {
         return false;
      }

      ProjectMonthMeteInfo other = (ProjectMonthMeteInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectMonthMeteInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectMonthMeteInfo(month=" + this.getMonth() + ", projectId=" + this.getProjectId() + ", mete=" + this.getMete() + ")";
   }
}
