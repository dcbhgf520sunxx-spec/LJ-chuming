package com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class EnclosureTeamDTO {
   @ApiModelProperty(name = "leaderName", value = "组长名称", notes = "组长名称")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "leaderId", value = "组长id", notes = "组长id")
   @JsonProperty("leaderId")
   @JSONField(name = "leaderId")
   private Long leaderId;

   public static EnclosureTeamDTO.EnclosureTeamDTOBuilder builder() {
      return new EnclosureTeamDTO.EnclosureTeamDTOBuilder();
   }

   public EnclosureTeamDTO() {
   }

   public EnclosureTeamDTO(final String leaderName, final Long leaderId) {
      this.leaderName = leaderName;
      this.leaderId = leaderId;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public Long getLeaderId() {
      return this.leaderId;
   }

   @JsonProperty("leaderName")
   public void setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
   }

   @JsonProperty("leaderId")
   public void setLeaderId(final Long leaderId) {
      this.leaderId = leaderId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof EnclosureTeamDTO)) {
         return false;
      } else {
         EnclosureTeamDTO other = (EnclosureTeamDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$leaderId = this.getLeaderId();
            Object other$leaderId = other.getLeaderId();
            if (this$leaderId == null ? other$leaderId == null : this$leaderId.equals(other$leaderId)) {
               Object this$leaderName = this.getLeaderName();
               Object other$leaderName = other.getLeaderName();
               return this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $leaderId = this.getLeaderId();
      result = result * 59 + ($leaderId == null ? 43 : $leaderId.hashCode());
      Object $leaderName = this.getLeaderName();
      return result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureTeamDTO(leaderName=" + this.getLeaderName() + ", leaderId=" + this.getLeaderId() + ")";
   }

   public static class EnclosureTeamDTOBuilder {
      private String leaderName;
      private Long leaderId;

      EnclosureTeamDTOBuilder() {
      }

      @JsonProperty("leaderName")
      public EnclosureTeamDTO.EnclosureTeamDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("leaderId")
      public EnclosureTeamDTO.EnclosureTeamDTOBuilder leaderId(final Long leaderId) {
         this.leaderId = leaderId;
         return this;
      }

      public EnclosureTeamDTO build() {
         return new EnclosureTeamDTO(this.leaderName, this.leaderId);
      }

      @Override
      public String toString() {
         return "EnclosureTeamDTO.EnclosureTeamDTOBuilder(leaderName=" + this.leaderName + ", leaderId=" + this.leaderId + ")";
      }
   }
}
