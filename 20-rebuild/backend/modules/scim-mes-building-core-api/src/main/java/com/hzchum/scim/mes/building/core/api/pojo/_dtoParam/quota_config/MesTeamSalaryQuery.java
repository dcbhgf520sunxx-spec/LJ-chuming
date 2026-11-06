package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("班组工资Query")
public class MesTeamSalaryQuery {
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("班组id")
   private Long teamId;
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty("产品类型")
   private Integer productTypeEnum;
   @ApiModelProperty("产品编号")
   private String productSerialNumber;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTeamSalaryQuery)) {
         return false;
      }

      MesTeamSalaryQuery other = (MesTeamSalaryQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$productTypeEnum = this.getProductTypeEnum();
               Object other$productTypeEnum = other.getProductTypeEnum();
               if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$productSerialNumber = this.getProductSerialNumber();
                        Object other$productSerialNumber = other.getProductSerialNumber();
                        return this$productSerialNumber == null
                           ? other$productSerialNumber == null
                           : this$productSerialNumber.equals(other$productSerialNumber);
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
      return other instanceof MesTeamSalaryQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MesTeamSalaryQuery(workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ")";
   }
}
