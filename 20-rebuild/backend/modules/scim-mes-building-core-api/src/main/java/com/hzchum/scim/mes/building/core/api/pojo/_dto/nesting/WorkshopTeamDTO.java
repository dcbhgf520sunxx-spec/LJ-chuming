package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "WorkshopTeamDTO", description = "车间班组对象")
public class WorkshopTeamDTO {
   @ApiModelProperty("车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @NotBlank
   private Long workshopId;
   @ApiModelProperty("车间名称")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty("生产组名称")
   @JsonProperty("groupsName")
   @JSONField(name = "groupsName")
   private String groupsName;
   @ApiModelProperty("生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty("班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @NotBlank
   private Long teamId;
   @ApiModelProperty("班组长id")
   @JsonProperty("leaderId")
   @JSONField(name = "leaderId")
   private Long leaderId;
   @ApiModelProperty("班组长名称")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;

   public static WorkshopTeamDTO.WorkshopTeamDTOBuilder builder() {
      return new WorkshopTeamDTO.WorkshopTeamDTOBuilder();
   }

   public WorkshopTeamDTO(
      final Long workshopId,
      final String workshopName,
      final String groupsName,
      final Long groupsId,
      final Long teamId,
      final Long leaderId,
      final String leaderName,
      final LocalDateTime askCompleteTime
   ) {
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.groupsName = groupsName;
      this.groupsId = groupsId;
      this.teamId = teamId;
      this.leaderId = leaderId;
      this.leaderName = leaderName;
      this.askCompleteTime = askCompleteTime;
   }

   public WorkshopTeamDTO() {
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getGroupsName() {
      return this.groupsName;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getLeaderId() {
      return this.leaderId;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   @JsonProperty("workshopId")
   public WorkshopTeamDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public WorkshopTeamDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("groupsName")
   public WorkshopTeamDTO setGroupsName(final String groupsName) {
      this.groupsName = groupsName;
      return this;
   }

   @JsonProperty("groupsId")
   public WorkshopTeamDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("teamId")
   public WorkshopTeamDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("leaderId")
   public WorkshopTeamDTO setLeaderId(final Long leaderId) {
      this.leaderId = leaderId;
      return this;
   }

   @JsonProperty("leaderName")
   public WorkshopTeamDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public WorkshopTeamDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopTeamDTO(workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", groupsName="
         + this.getGroupsName()
         + ", groupsId="
         + this.getGroupsId()
         + ", teamId="
         + this.getTeamId()
         + ", leaderId="
         + this.getLeaderId()
         + ", leaderName="
         + this.getLeaderName()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopTeamDTO)) {
         return false;
      }

      WorkshopTeamDTO other = (WorkshopTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$leaderId = this.getLeaderId();
               Object other$leaderId = other.getLeaderId();
               if (this$leaderId == null ? other$leaderId == null : this$leaderId.equals(other$leaderId)) {
                  Object this$workshopName = this.getWorkshopName();
                  Object other$workshopName = other.getWorkshopName();
                  if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                     Object this$groupsName = this.getGroupsName();
                     Object other$groupsName = other.getGroupsName();
                     if (this$groupsName == null ? other$groupsName == null : this$groupsName.equals(other$groupsName)) {
                        Object this$leaderName = this.getLeaderName();
                        Object other$leaderName = other.getLeaderName();
                        if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                           Object this$askCompleteTime = this.getAskCompleteTime();
                           Object other$askCompleteTime = other.getAskCompleteTime();
                           return this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof WorkshopTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $leaderId = this.getLeaderId();
      result = result * 59 + ($leaderId == null ? 43 : $leaderId.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $groupsName = this.getGroupsName();
      result = result * 59 + ($groupsName == null ? 43 : $groupsName.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   public static class WorkshopTeamDTOBuilder {
      private Long workshopId;
      private String workshopName;
      private String groupsName;
      private Long groupsId;
      private Long teamId;
      private Long leaderId;
      private String leaderName;
      private LocalDateTime askCompleteTime;

      WorkshopTeamDTOBuilder() {
      }

      @JsonProperty("workshopId")
      public WorkshopTeamDTO.WorkshopTeamDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public WorkshopTeamDTO.WorkshopTeamDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("groupsName")
      public WorkshopTeamDTO.WorkshopTeamDTOBuilder groupsName(final String groupsName) {
         this.groupsName = groupsName;
         return this;
      }

      @JsonProperty("groupsId")
      public WorkshopTeamDTO.WorkshopTeamDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("teamId")
      public WorkshopTeamDTO.WorkshopTeamDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("leaderId")
      public WorkshopTeamDTO.WorkshopTeamDTOBuilder leaderId(final Long leaderId) {
         this.leaderId = leaderId;
         return this;
      }

      @JsonProperty("leaderName")
      public WorkshopTeamDTO.WorkshopTeamDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public WorkshopTeamDTO.WorkshopTeamDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public WorkshopTeamDTO build() {
         return new WorkshopTeamDTO(
            this.workshopId, this.workshopName, this.groupsName, this.groupsId, this.teamId, this.leaderId, this.leaderName, this.askCompleteTime
         );
      }

      @Override
      public String toString() {
         return "WorkshopTeamDTO.WorkshopTeamDTOBuilder(workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", groupsName="
            + this.groupsName
            + ", groupsId="
            + this.groupsId
            + ", teamId="
            + this.teamId
            + ", leaderId="
            + this.leaderId
            + ", leaderName="
            + this.leaderName
            + ", askCompleteTime="
            + this.askCompleteTime
            + ")";
      }
   }
}
