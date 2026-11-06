package com.hzchum.scim.mes.building.core.api.pojo._dto.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenMonthlyOutputDTO", description = "月度产量")
public class ScreenMonthlyOutputDTO {
   @ApiModelProperty(name = "inspectionQuantity", notes = "通过质检数")
   private Double inspectionQuantity;
   @ApiModelProperty(name = "teamName", notes = "班组名称")
   private String teamName;

   public static ScreenMonthlyOutputDTO.ScreenMonthlyOutputDTOBuilder builder() {
      return new ScreenMonthlyOutputDTO.ScreenMonthlyOutputDTOBuilder();
   }

   public ScreenMonthlyOutputDTO() {
   }

   public ScreenMonthlyOutputDTO(final Double inspectionQuantity, final String teamName) {
      this.inspectionQuantity = inspectionQuantity;
      this.teamName = teamName;
   }

   public Double getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public ScreenMonthlyOutputDTO setInspectionQuantity(final Double inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   public ScreenMonthlyOutputDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenMonthlyOutputDTO(inspectionQuantity=" + this.getInspectionQuantity() + ", teamName=" + this.getTeamName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ScreenMonthlyOutputDTO)) {
         return false;
      } else {
         ScreenMonthlyOutputDTO other = (ScreenMonthlyOutputDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$inspectionQuantity = this.getInspectionQuantity();
            Object other$inspectionQuantity = other.getInspectionQuantity();
            if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
               Object this$teamName = this.getTeamName();
               Object other$teamName = other.getTeamName();
               return this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScreenMonthlyOutputDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $teamName = this.getTeamName();
      return result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
   }

   public static class ScreenMonthlyOutputDTOBuilder {
      private Double inspectionQuantity;
      private String teamName;

      ScreenMonthlyOutputDTOBuilder() {
      }

      public ScreenMonthlyOutputDTO.ScreenMonthlyOutputDTOBuilder inspectionQuantity(final Double inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public ScreenMonthlyOutputDTO.ScreenMonthlyOutputDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public ScreenMonthlyOutputDTO build() {
         return new ScreenMonthlyOutputDTO(this.inspectionQuantity, this.teamName);
      }

      @Override
      public String toString() {
         return "ScreenMonthlyOutputDTO.ScreenMonthlyOutputDTOBuilder(inspectionQuantity=" + this.inspectionQuantity + ", teamName=" + this.teamName + ")";
      }
   }
}
