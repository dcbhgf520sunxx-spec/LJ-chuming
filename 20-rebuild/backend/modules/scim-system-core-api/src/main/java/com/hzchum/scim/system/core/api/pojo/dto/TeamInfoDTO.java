package com.hzchum.scim.system.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class TeamInfoDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;

   public static TeamInfoDTO.TeamInfoDTOBuilder builder() {
      return new TeamInfoDTO.TeamInfoDTOBuilder();
   }

   public TeamInfoDTO() {
   }

   public TeamInfoDTO(final Long id, final Long processId) {
      this.id = id;
      this.processId = processId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   @JsonProperty("id")
   public TeamInfoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public TeamInfoDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @Override
   public String toString() {
      return "TeamInfoDTO(id=" + this.getId() + ", processId=" + this.getProcessId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TeamInfoDTO)) {
         return false;
      } else {
         TeamInfoDTO other = (TeamInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               return this$processId == null ? other$processId == null : this$processId.equals(other$processId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      return result * 59 + ($processId == null ? 43 : $processId.hashCode());
   }

   public static class TeamInfoDTOBuilder {
      private Long id;
      private Long processId;

      TeamInfoDTOBuilder() {
      }

      @JsonProperty("id")
      public TeamInfoDTO.TeamInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public TeamInfoDTO.TeamInfoDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public TeamInfoDTO build() {
         return new TeamInfoDTO(this.id, this.processId);
      }

      @Override
      public String toString() {
         return "TeamInfoDTO.TeamInfoDTOBuilder(id=" + this.id + ", processId=" + this.processId + ")";
      }
   }
}
