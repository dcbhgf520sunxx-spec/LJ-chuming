package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

@ApiModel(value = "WorkTreeDTO", description = "")
public class WorkTreeDTO {
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty("车间idList")
   private List<Long> workShopId;
   @ApiModelProperty("切割状态")
   private Integer cutStatus;

   public static WorkTreeDTO.WorkTreeDTOBuilder builder() {
      return new WorkTreeDTO.WorkTreeDTOBuilder();
   }

   public WorkTreeDTO(final String name, final LocalDate startDate, final LocalDate endDate, final List<Long> workShopId, final Integer cutStatus) {
      this.name = name;
      this.startDate = startDate;
      this.endDate = endDate;
      this.workShopId = workShopId;
      this.cutStatus = cutStatus;
   }

   public WorkTreeDTO() {
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public List<Long> getWorkShopId() {
      return this.workShopId;
   }

   public Integer getCutStatus() {
      return this.cutStatus;
   }

   public WorkTreeDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public WorkTreeDTO setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
      return this;
   }

   public WorkTreeDTO setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
      return this;
   }

   public WorkTreeDTO setWorkShopId(final List<Long> workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   public WorkTreeDTO setCutStatus(final Integer cutStatus) {
      this.cutStatus = cutStatus;
      return this;
   }

   @Override
   public String toString() {
      return "WorkTreeDTO(name="
         + this.getName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", workShopId="
         + this.getWorkShopId()
         + ", cutStatus="
         + this.getCutStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkTreeDTO)) {
         return false;
      }

      WorkTreeDTO other = (WorkTreeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$cutStatus = this.getCutStatus();
      Object other$cutStatus = other.getCutStatus();
      if (this$cutStatus == null ? other$cutStatus == null : this$cutStatus.equals(other$cutStatus)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$endDate = this.getEndDate();
               Object other$endDate = other.getEndDate();
               if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                  Object this$workShopId = this.getWorkShopId();
                  Object other$workShopId = other.getWorkShopId();
                  return this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId);
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
      return other instanceof WorkTreeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $cutStatus = this.getCutStatus();
      result = result * 59 + ($cutStatus == null ? 43 : $cutStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $workShopId = this.getWorkShopId();
      return result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
   }

   public static class WorkTreeDTOBuilder {
      private String name;
      private LocalDate startDate;
      private LocalDate endDate;
      private List<Long> workShopId;
      private Integer cutStatus;

      WorkTreeDTOBuilder() {
      }

      public WorkTreeDTO.WorkTreeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WorkTreeDTO.WorkTreeDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public WorkTreeDTO.WorkTreeDTOBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public WorkTreeDTO.WorkTreeDTOBuilder workShopId(final List<Long> workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public WorkTreeDTO.WorkTreeDTOBuilder cutStatus(final Integer cutStatus) {
         this.cutStatus = cutStatus;
         return this;
      }

      public WorkTreeDTO build() {
         return new WorkTreeDTO(this.name, this.startDate, this.endDate, this.workShopId, this.cutStatus);
      }

      @Override
      public String toString() {
         return "WorkTreeDTO.WorkTreeDTOBuilder(name="
            + this.name
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", workShopId="
            + this.workShopId
            + ", cutStatus="
            + this.cutStatus
            + ")";
      }
   }
}
