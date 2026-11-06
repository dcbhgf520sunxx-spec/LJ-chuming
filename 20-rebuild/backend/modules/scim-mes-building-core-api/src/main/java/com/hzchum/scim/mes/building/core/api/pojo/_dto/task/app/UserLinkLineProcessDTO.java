package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "UserLinkLineProcessDTO", description = "产线及其相关工序ID")
public class UserLinkLineProcessDTO {
   @ApiModelProperty(name = "lineId", notes = "生产线ID")
   @JsonProperty("lineId")
   @JSONField(name = "lineId")
   private Long lineId;
   @ApiModelProperty(name = "teamId", notes = "班组Id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "processIds", notes = "工序Id")
   @JsonProperty("processIds")
   @JSONField(name = "processIds")
   private List<Long> processIds;

   public static UserLinkLineProcessDTO.UserLinkLineProcessDTOBuilder builder() {
      return new UserLinkLineProcessDTO.UserLinkLineProcessDTOBuilder();
   }

   public UserLinkLineProcessDTO() {
   }

   public UserLinkLineProcessDTO(final Long lineId, final Long teamId, final List<Long> processIds) {
      this.lineId = lineId;
      this.teamId = teamId;
      this.processIds = processIds;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public List<Long> getProcessIds() {
      return this.processIds;
   }

   @JsonProperty("lineId")
   public UserLinkLineProcessDTO setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("teamId")
   public UserLinkLineProcessDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("processIds")
   public UserLinkLineProcessDTO setProcessIds(final List<Long> processIds) {
      this.processIds = processIds;
      return this;
   }

   @Override
   public String toString() {
      return "UserLinkLineProcessDTO(lineId=" + this.getLineId() + ", teamId=" + this.getTeamId() + ", processIds=" + this.getProcessIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserLinkLineProcessDTO)) {
         return false;
      }

      UserLinkLineProcessDTO other = (UserLinkLineProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$lineId = this.getLineId();
      Object other$lineId = other.getLineId();
      if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$processIds = this.getProcessIds();
            Object other$processIds = other.getProcessIds();
            return this$processIds == null ? other$processIds == null : this$processIds.equals(other$processIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserLinkLineProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $processIds = this.getProcessIds();
      return result * 59 + ($processIds == null ? 43 : $processIds.hashCode());
   }

   public static class UserLinkLineProcessDTOBuilder {
      private Long lineId;
      private Long teamId;
      private List<Long> processIds;

      UserLinkLineProcessDTOBuilder() {
      }

      @JsonProperty("lineId")
      public UserLinkLineProcessDTO.UserLinkLineProcessDTOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      @JsonProperty("teamId")
      public UserLinkLineProcessDTO.UserLinkLineProcessDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("processIds")
      public UserLinkLineProcessDTO.UserLinkLineProcessDTOBuilder processIds(final List<Long> processIds) {
         this.processIds = processIds;
         return this;
      }

      public UserLinkLineProcessDTO build() {
         return new UserLinkLineProcessDTO(this.lineId, this.teamId, this.processIds);
      }

      @Override
      public String toString() {
         return "UserLinkLineProcessDTO.UserLinkLineProcessDTOBuilder(lineId="
            + this.lineId
            + ", teamId="
            + this.teamId
            + ", processIds="
            + this.processIds
            + ")";
      }
   }
}
