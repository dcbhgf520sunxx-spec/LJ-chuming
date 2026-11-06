package com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "GroupTeamLinkDetailDTO", description = "生产者班组关联详细信息返回类")
public class GroupTeamLinkDetailDTO {
   private Long groupId;
   private String groupName;
   private Long teamId;
   private Long processId;
   private String processName;
   private String leaderName;

   public static GroupTeamLinkDetailDTO.GroupTeamLinkDetailDTOBuilder builder() {
      return new GroupTeamLinkDetailDTO.GroupTeamLinkDetailDTOBuilder();
   }

   public GroupTeamLinkDetailDTO(
      final Long groupId, final String groupName, final Long teamId, final Long processId, final String processName, final String leaderName
   ) {
      this.groupId = groupId;
      this.groupName = groupName;
      this.teamId = teamId;
      this.processId = processId;
      this.processName = processName;
      this.leaderName = leaderName;
   }

   public GroupTeamLinkDetailDTO() {
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public GroupTeamLinkDetailDTO setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   public GroupTeamLinkDetailDTO setGroupName(final String groupName) {
      this.groupName = groupName;
      return this;
   }

   public GroupTeamLinkDetailDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public GroupTeamLinkDetailDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public GroupTeamLinkDetailDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   public GroupTeamLinkDetailDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @Override
   public String toString() {
      return "GroupTeamLinkDetailDTO(groupId="
         + this.getGroupId()
         + ", groupName="
         + this.getGroupName()
         + ", teamId="
         + this.getTeamId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", leaderName="
         + this.getLeaderName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GroupTeamLinkDetailDTO)) {
         return false;
      }

      GroupTeamLinkDetailDTO other = (GroupTeamLinkDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$groupId = this.getGroupId();
      Object other$groupId = other.getGroupId();
      if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$groupName = this.getGroupName();
               Object other$groupName = other.getGroupName();
               if (this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                     Object this$leaderName = this.getLeaderName();
                     Object other$leaderName = other.getLeaderName();
                     return this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName);
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
      return other instanceof GroupTeamLinkDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $leaderName = this.getLeaderName();
      return result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
   }

   public static class GroupTeamLinkDetailDTOBuilder {
      private Long groupId;
      private String groupName;
      private Long teamId;
      private Long processId;
      private String processName;
      private String leaderName;

      GroupTeamLinkDetailDTOBuilder() {
      }

      public GroupTeamLinkDetailDTO.GroupTeamLinkDetailDTOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      public GroupTeamLinkDetailDTO.GroupTeamLinkDetailDTOBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      public GroupTeamLinkDetailDTO.GroupTeamLinkDetailDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public GroupTeamLinkDetailDTO.GroupTeamLinkDetailDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public GroupTeamLinkDetailDTO.GroupTeamLinkDetailDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public GroupTeamLinkDetailDTO.GroupTeamLinkDetailDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      public GroupTeamLinkDetailDTO build() {
         return new GroupTeamLinkDetailDTO(this.groupId, this.groupName, this.teamId, this.processId, this.processName, this.leaderName);
      }

      @Override
      public String toString() {
         return "GroupTeamLinkDetailDTO.GroupTeamLinkDetailDTOBuilder(groupId="
            + this.groupId
            + ", groupName="
            + this.groupName
            + ", teamId="
            + this.teamId
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", leaderName="
            + this.leaderName
            + ")";
      }
   }
}
