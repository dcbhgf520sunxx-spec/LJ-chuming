package com.hzchum.scim.mes.building.core.api.pojo._dto.task.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssistTeamDTO", description = "添加任务协同")
public class AssistTeamDTO {
   @ApiModelProperty(name = "id", notes = "班组id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "leaderName", notes = "班组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;

   public static AssistTeamDTO.AssistTeamDTOBuilder builder() {
      return new AssistTeamDTO.AssistTeamDTOBuilder();
   }

   public AssistTeamDTO() {
   }

   public AssistTeamDTO(final Long id, final String leaderName, final Long processId, final String processName) {
      this.id = id;
      this.leaderName = leaderName;
      this.processId = processId;
      this.processName = processName;
   }

   public Long getId() {
      return this.id;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   @JsonProperty("id")
   public AssistTeamDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("leaderName")
   public AssistTeamDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("processId")
   public AssistTeamDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public AssistTeamDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @Override
   public String toString() {
      return "AssistTeamDTO(id="
         + this.getId()
         + ", leaderName="
         + this.getLeaderName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssistTeamDTO)) {
         return false;
      }

      AssistTeamDTO other = (AssistTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$leaderName = this.getLeaderName();
            Object other$leaderName = other.getLeaderName();
            if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssistTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   public static class AssistTeamDTOBuilder {
      private Long id;
      private String leaderName;
      private Long processId;
      private String processName;

      AssistTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public AssistTeamDTO.AssistTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("leaderName")
      public AssistTeamDTO.AssistTeamDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("processId")
      public AssistTeamDTO.AssistTeamDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public AssistTeamDTO.AssistTeamDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public AssistTeamDTO build() {
         return new AssistTeamDTO(this.id, this.leaderName, this.processId, this.processName);
      }

      @Override
      public String toString() {
         return "AssistTeamDTO.AssistTeamDTOBuilder(id="
            + this.id
            + ", leaderName="
            + this.leaderName
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ")";
      }
   }
}
