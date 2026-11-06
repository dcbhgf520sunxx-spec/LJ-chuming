package com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(description = "清单排期-项目排期")
public class ListSchedulingProjectDTO {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("简称")
   private String shortName;
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty("工期(天)")
   private Integer duration;
   @ApiModelProperty("清单总量(吨)")
   private BigDecimal listTotalWeight;
   @ApiModelProperty("排期状态(1: 未排期, 2: 部分排期, 4: 已排期)")
   private Integer schedulingStatus;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShortName() {
      return this.shortName;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getDuration() {
      return this.duration;
   }

   public BigDecimal getListTotalWeight() {
      return this.listTotalWeight;
   }

   public Integer getSchedulingStatus() {
      return this.schedulingStatus;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setDuration(final Integer duration) {
      this.duration = duration;
   }

   public void setListTotalWeight(final BigDecimal listTotalWeight) {
      this.listTotalWeight = listTotalWeight;
   }

   public void setSchedulingStatus(final Integer schedulingStatus) {
      this.schedulingStatus = schedulingStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ListSchedulingProjectDTO)) {
         return false;
      }

      ListSchedulingProjectDTO other = (ListSchedulingProjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$duration = this.getDuration();
         Object other$duration = other.getDuration();
         if (this$duration == null ? other$duration == null : this$duration.equals(other$duration)) {
            Object this$schedulingStatus = this.getSchedulingStatus();
            Object other$schedulingStatus = other.getSchedulingStatus();
            if (this$schedulingStatus == null ? other$schedulingStatus == null : this$schedulingStatus.equals(other$schedulingStatus)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$startDate = this.getStartDate();
                     Object other$startDate = other.getStartDate();
                     if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                        Object this$endDate = this.getEndDate();
                        Object other$endDate = other.getEndDate();
                        if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                           Object this$listTotalWeight = this.getListTotalWeight();
                           Object other$listTotalWeight = other.getListTotalWeight();
                           return this$listTotalWeight == null ? other$listTotalWeight == null : this$listTotalWeight.equals(other$listTotalWeight);
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
      return other instanceof ListSchedulingProjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $duration = this.getDuration();
      result = result * 59 + ($duration == null ? 43 : $duration.hashCode());
      Object $schedulingStatus = this.getSchedulingStatus();
      result = result * 59 + ($schedulingStatus == null ? 43 : $schedulingStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $listTotalWeight = this.getListTotalWeight();
      return result * 59 + ($listTotalWeight == null ? 43 : $listTotalWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ListSchedulingProjectDTO(projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shortName="
         + this.getShortName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", duration="
         + this.getDuration()
         + ", listTotalWeight="
         + this.getListTotalWeight()
         + ", schedulingStatus="
         + this.getSchedulingStatus()
         + ")";
   }
}
