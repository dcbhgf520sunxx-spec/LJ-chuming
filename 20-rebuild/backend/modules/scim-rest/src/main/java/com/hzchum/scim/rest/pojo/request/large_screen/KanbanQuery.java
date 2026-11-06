package com.hzchum.scim.rest.pojo.request.large_screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("看板大屏Query")
public class KanbanQuery {
   @ApiModelProperty("年份")
   private Integer year;
   @ApiModelProperty("机构id")
   private Long branchCompanyId;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("设备mid")
   private String mid;

   public Integer getYear() {
      return this.year;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getMid() {
      return this.mid;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setMid(final String mid) {
      this.mid = mid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof KanbanQuery)) {
         return false;
      }

      KanbanQuery other = (KanbanQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$year = this.getYear();
      Object other$year = other.getYear();
      if (this$year == null ? other$year == null : this$year.equals(other$year)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$mid = this.getMid();
               Object other$mid = other.getMid();
               return this$mid == null ? other$mid == null : this$mid.equals(other$mid);
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
      return other instanceof KanbanQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $mid = this.getMid();
      return result * 59 + ($mid == null ? 43 : $mid.hashCode());
   }

   @Override
   public String toString() {
      return "KanbanQuery(year="
         + this.getYear()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", mid="
         + this.getMid()
         + ")";
   }
}
