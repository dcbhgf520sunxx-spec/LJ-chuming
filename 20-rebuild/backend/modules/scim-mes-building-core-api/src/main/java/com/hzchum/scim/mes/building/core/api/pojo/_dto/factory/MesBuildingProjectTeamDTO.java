package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import io.swagger.annotations.ApiModelProperty;

public class MesBuildingProjectTeamDTO {
   @ApiModelProperty(name = "id", notes = "班组Id")
   private Long id;
   @ApiModelProperty(name = "userName", notes = "班组长名称")
   private String userName;
   @ApiModelProperty(name = "userId", notes = "班组长Id")
   private Long userId;
   @ApiModelProperty(name = "processId", notes = "工序Id")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   private String processName;

   public static MesBuildingProjectTeamDTO.MesBuildingProjectTeamDTOBuilder builder() {
      return new MesBuildingProjectTeamDTO.MesBuildingProjectTeamDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProjectTeamDTO)) {
         return false;
      }

      MesBuildingProjectTeamDTO other = (MesBuildingProjectTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
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
      return other instanceof MesBuildingProjectTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingProjectTeamDTO(id="
         + this.getId()
         + ", userName="
         + this.getUserName()
         + ", userId="
         + this.getUserId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ")";
   }

   public MesBuildingProjectTeamDTO() {
   }

   public MesBuildingProjectTeamDTO(final Long id, final String userName, final Long userId, final Long processId, final String processName) {
      this.id = id;
      this.userName = userName;
      this.userId = userId;
      this.processId = processId;
      this.processName = processName;
   }

   public static class MesBuildingProjectTeamDTOBuilder {
      private Long id;
      private String userName;
      private Long userId;
      private Long processId;
      private String processName;

      MesBuildingProjectTeamDTOBuilder() {
      }

      public MesBuildingProjectTeamDTO.MesBuildingProjectTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingProjectTeamDTO.MesBuildingProjectTeamDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesBuildingProjectTeamDTO.MesBuildingProjectTeamDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingProjectTeamDTO.MesBuildingProjectTeamDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingProjectTeamDTO.MesBuildingProjectTeamDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public MesBuildingProjectTeamDTO build() {
         return new MesBuildingProjectTeamDTO(this.id, this.userName, this.userId, this.processId, this.processName);
      }

      @Override
      public String toString() {
         return "MesBuildingProjectTeamDTO.MesBuildingProjectTeamDTOBuilder(id="
            + this.id
            + ", userName="
            + this.userName
            + ", userId="
            + this.userId
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ")";
      }
   }
}
