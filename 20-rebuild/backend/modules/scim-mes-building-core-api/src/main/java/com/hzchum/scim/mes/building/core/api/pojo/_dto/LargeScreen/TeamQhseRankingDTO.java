package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "班组质量问题排名")
public class TeamQhseRankingDTO {
   private String teamName;
   private Integer quantity;

   public static TeamQhseRankingDTO.TeamQhseRankingDTOBuilder builder() {
      return new TeamQhseRankingDTO.TeamQhseRankingDTOBuilder();
   }

   public String getTeamName() {
      return this.teamName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TeamQhseRankingDTO)) {
         return false;
      } else {
         TeamQhseRankingDTO other = (TeamQhseRankingDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
      return other instanceof TeamQhseRankingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $teamName = this.getTeamName();
      return result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
   }

   @Override
   public String toString() {
      return "TeamQhseRankingDTO(super=" + super.toString() + ", teamName=" + this.getTeamName() + ", quantity=" + this.getQuantity() + ")";
   }

   public TeamQhseRankingDTO(final String teamName, final Integer quantity) {
      this.teamName = teamName;
      this.quantity = quantity;
   }

   public TeamQhseRankingDTO() {
   }

   public static class TeamQhseRankingDTOBuilder {
      private String teamName;
      private Integer quantity;

      TeamQhseRankingDTOBuilder() {
      }

      public TeamQhseRankingDTO.TeamQhseRankingDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public TeamQhseRankingDTO.TeamQhseRankingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TeamQhseRankingDTO build() {
         return new TeamQhseRankingDTO(this.teamName, this.quantity);
      }

      @Override
      public String toString() {
         return "TeamQhseRankingDTO.TeamQhseRankingDTOBuilder(teamName=" + this.teamName + ", quantity=" + this.quantity + ")";
      }
   }
}
