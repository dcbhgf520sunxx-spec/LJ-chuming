package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("报工审核日期信息DTO")
public class MesProductionReportingApprovalDateDTO {
   @ApiModelProperty("日期")
   private LocalDate date;
   @ApiModelProperty("是否存在未审核数据(1:存在, 0:不存在)")
   private Boolean boolExistsUnapprovedData;
   @ApiModelProperty("是否存在数据(1:存在, 0:不存在)")
   private Boolean boolExistsData;
   @ApiModelProperty("是否存在已审核数据(1:存在, 0:不存在)")
   private Boolean boolExistsApprovedData;

   public LocalDate getDate() {
      return this.date;
   }

   public Boolean getBoolExistsUnapprovedData() {
      return this.boolExistsUnapprovedData;
   }

   public Boolean getBoolExistsData() {
      return this.boolExistsData;
   }

   public Boolean getBoolExistsApprovedData() {
      return this.boolExistsApprovedData;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setBoolExistsUnapprovedData(final Boolean boolExistsUnapprovedData) {
      this.boolExistsUnapprovedData = boolExistsUnapprovedData;
   }

   public void setBoolExistsData(final Boolean boolExistsData) {
      this.boolExistsData = boolExistsData;
   }

   public void setBoolExistsApprovedData(final Boolean boolExistsApprovedData) {
      this.boolExistsApprovedData = boolExistsApprovedData;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalDateDTO)) {
         return false;
      }

      MesProductionReportingApprovalDateDTO other = (MesProductionReportingApprovalDateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolExistsUnapprovedData = this.getBoolExistsUnapprovedData();
      Object other$boolExistsUnapprovedData = other.getBoolExistsUnapprovedData();
      if (this$boolExistsUnapprovedData == null ? other$boolExistsUnapprovedData == null : this$boolExistsUnapprovedData.equals(other$boolExistsUnapprovedData)
         )
       {
         Object this$boolExistsData = this.getBoolExistsData();
         Object other$boolExistsData = other.getBoolExistsData();
         if (this$boolExistsData == null ? other$boolExistsData == null : this$boolExistsData.equals(other$boolExistsData)) {
            Object this$boolExistsApprovedData = this.getBoolExistsApprovedData();
            Object other$boolExistsApprovedData = other.getBoolExistsApprovedData();
            if (this$boolExistsApprovedData == null ? other$boolExistsApprovedData == null : this$boolExistsApprovedData.equals(other$boolExistsApprovedData)) {
               Object this$date = this.getDate();
               Object other$date = other.getDate();
               return this$date == null ? other$date == null : this$date.equals(other$date);
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
      return other instanceof MesProductionReportingApprovalDateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolExistsUnapprovedData = this.getBoolExistsUnapprovedData();
      result = result * 59 + ($boolExistsUnapprovedData == null ? 43 : $boolExistsUnapprovedData.hashCode());
      Object $boolExistsData = this.getBoolExistsData();
      result = result * 59 + ($boolExistsData == null ? 43 : $boolExistsData.hashCode());
      Object $boolExistsApprovedData = this.getBoolExistsApprovedData();
      result = result * 59 + ($boolExistsApprovedData == null ? 43 : $boolExistsApprovedData.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalDateDTO(date="
         + this.getDate()
         + ", boolExistsUnapprovedData="
         + this.getBoolExistsUnapprovedData()
         + ", boolExistsData="
         + this.getBoolExistsData()
         + ", boolExistsApprovedData="
         + this.getBoolExistsApprovedData()
         + ")";
   }
}
