package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "车间月度产量统计")
public class WorkshopYieldInfoDTO {
   @ApiModelProperty("车间id")
   private Long workShopId;
   @ApiModelProperty("车间名")
   private String workShopName;
   @ApiModelProperty("每月数据")
   private List<WorkshopAchievementRateDTO> dateInfo;

   public static WorkshopYieldInfoDTO.WorkshopYieldInfoDTOBuilder builder() {
      return new WorkshopYieldInfoDTO.WorkshopYieldInfoDTOBuilder();
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public List<WorkshopAchievementRateDTO> getDateInfo() {
      return this.dateInfo;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   public void setDateInfo(final List<WorkshopAchievementRateDTO> dateInfo) {
      this.dateInfo = dateInfo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopYieldInfoDTO)) {
         return false;
      }

      WorkshopYieldInfoDTO other = (WorkshopYieldInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$workShopName = this.getWorkShopName();
         Object other$workShopName = other.getWorkShopName();
         if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
            Object this$dateInfo = this.getDateInfo();
            Object other$dateInfo = other.getDateInfo();
            return this$dateInfo == null ? other$dateInfo == null : this$dateInfo.equals(other$dateInfo);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopYieldInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $dateInfo = this.getDateInfo();
      return result * 59 + ($dateInfo == null ? 43 : $dateInfo.hashCode());
   }

   @Override
   public String toString() {
      return "WorkshopYieldInfoDTO(super="
         + super.toString()
         + ", workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", dateInfo="
         + this.getDateInfo()
         + ")";
   }

   public WorkshopYieldInfoDTO(final Long workShopId, final String workShopName, final List<WorkshopAchievementRateDTO> dateInfo) {
      this.workShopId = workShopId;
      this.workShopName = workShopName;
      this.dateInfo = dateInfo;
   }

   public WorkshopYieldInfoDTO() {
   }

   public static class WorkshopYieldInfoDTOBuilder {
      private Long workShopId;
      private String workShopName;
      private List<WorkshopAchievementRateDTO> dateInfo;

      WorkshopYieldInfoDTOBuilder() {
      }

      public WorkshopYieldInfoDTO.WorkshopYieldInfoDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public WorkshopYieldInfoDTO.WorkshopYieldInfoDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      public WorkshopYieldInfoDTO.WorkshopYieldInfoDTOBuilder dateInfo(final List<WorkshopAchievementRateDTO> dateInfo) {
         this.dateInfo = dateInfo;
         return this;
      }

      public WorkshopYieldInfoDTO build() {
         return new WorkshopYieldInfoDTO(this.workShopId, this.workShopName, this.dateInfo);
      }

      @Override
      public String toString() {
         return "WorkshopYieldInfoDTO.WorkshopYieldInfoDTOBuilder(workShopId="
            + this.workShopId
            + ", workShopName="
            + this.workShopName
            + ", dateInfo="
            + this.dateInfo
            + ")";
      }
   }
}
