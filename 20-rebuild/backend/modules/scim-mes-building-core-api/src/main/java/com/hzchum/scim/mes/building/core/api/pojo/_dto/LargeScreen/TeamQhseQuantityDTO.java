package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "班组质量问题排名")
public class TeamQhseQuantityDTO {
   private Long teamId;
   private String teamName;
   private Integer qhseQuantity;

   public static TeamQhseQuantityDTO.TeamQhseQuantityDTOBuilder builder() {
      return new TeamQhseQuantityDTO.TeamQhseQuantityDTOBuilder();
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public Integer getQhseQuantity() {
      return this.qhseQuantity;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   public void setQhseQuantity(final Integer qhseQuantity) {
      this.qhseQuantity = qhseQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamQhseQuantityDTO)) {
         return false;
      }

      TeamQhseQuantityDTO other = (TeamQhseQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamId = this.getTeamId();
      Object other$teamId = other.getTeamId();
      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
         Object this$qhseQuantity = this.getQhseQuantity();
         Object other$qhseQuantity = other.getQhseQuantity();
         if (this$qhseQuantity == null ? other$qhseQuantity == null : this$qhseQuantity.equals(other$qhseQuantity)) {
            Object this$teamName = this.getTeamName();
            Object other$teamName = other.getTeamName();
            return this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamQhseQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $qhseQuantity = this.getQhseQuantity();
      result = result * 59 + ($qhseQuantity == null ? 43 : $qhseQuantity.hashCode());
      Object $teamName = this.getTeamName();
      return result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
   }

   @Override
   public String toString() {
      return "TeamQhseQuantityDTO(super="
         + super.toString()
         + ", teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
         + ", qhseQuantity="
         + this.getQhseQuantity()
         + ")";
   }

   public TeamQhseQuantityDTO(final Long teamId, final String teamName, final Integer qhseQuantity) {
      this.teamId = teamId;
      this.teamName = teamName;
      this.qhseQuantity = qhseQuantity;
   }

   public TeamQhseQuantityDTO() {
   }

   public static class TeamQhseQuantityDTOBuilder {
      private Long teamId;
      private String teamName;
      private Integer qhseQuantity;

      TeamQhseQuantityDTOBuilder() {
      }

      public TeamQhseQuantityDTO.TeamQhseQuantityDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public TeamQhseQuantityDTO.TeamQhseQuantityDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public TeamQhseQuantityDTO.TeamQhseQuantityDTOBuilder qhseQuantity(final Integer qhseQuantity) {
         this.qhseQuantity = qhseQuantity;
         return this;
      }

      public TeamQhseQuantityDTO build() {
         return new TeamQhseQuantityDTO(this.teamId, this.teamName, this.qhseQuantity);
      }

      @Override
      public String toString() {
         return "TeamQhseQuantityDTO.TeamQhseQuantityDTOBuilder(teamId="
            + this.teamId
            + ", teamName="
            + this.teamName
            + ", qhseQuantity="
            + this.qhseQuantity
            + ")";
      }
   }
}
