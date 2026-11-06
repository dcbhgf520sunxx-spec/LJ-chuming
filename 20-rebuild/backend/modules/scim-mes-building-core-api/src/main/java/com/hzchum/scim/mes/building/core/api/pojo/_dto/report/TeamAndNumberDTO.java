package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TeamAndNumberDTO", description = "班组和一物一码关联")
public class TeamAndNumberDTO {
   @ApiModelProperty(name = "number", value = "一物一码序号", notes = "一物一码序号")
   private Integer number;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   private Long teamId;

   public static TeamAndNumberDTO.TeamAndNumberDTOBuilder builder() {
      return new TeamAndNumberDTO.TeamAndNumberDTOBuilder();
   }

   public TeamAndNumberDTO() {
   }

   public TeamAndNumberDTO(final Integer number, final Long teamId) {
      this.number = number;
      this.teamId = teamId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public TeamAndNumberDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public TeamAndNumberDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "TeamAndNumberDTO(number=" + this.getNumber() + ", teamId=" + this.getTeamId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TeamAndNumberDTO)) {
         return false;
      } else {
         TeamAndNumberDTO other = (TeamAndNumberDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               return this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamAndNumberDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $teamId = this.getTeamId();
      return result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
   }

   public static class TeamAndNumberDTOBuilder {
      private Integer number;
      private Long teamId;

      TeamAndNumberDTOBuilder() {
      }

      public TeamAndNumberDTO.TeamAndNumberDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public TeamAndNumberDTO.TeamAndNumberDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public TeamAndNumberDTO build() {
         return new TeamAndNumberDTO(this.number, this.teamId);
      }

      @Override
      public String toString() {
         return "TeamAndNumberDTO.TeamAndNumberDTOBuilder(number=" + this.number + ", teamId=" + this.teamId + ")";
      }
   }
}
