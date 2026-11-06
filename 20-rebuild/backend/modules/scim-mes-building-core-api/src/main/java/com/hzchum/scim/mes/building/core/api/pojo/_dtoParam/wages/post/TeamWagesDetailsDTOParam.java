package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wages.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TeamWagesDTOParam", description = "")
public class TeamWagesDetailsDTOParam {
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @NotNull(message = "班组id不能为空")
   private Long teamId;
   @ApiModelProperty(name = "wages", notes = "单体id")
   @JsonProperty("wages")
   @JSONField(name = "wages")
   @NotNull(message = "工价不能为空")
   private BigDecimal wages;

   public static TeamWagesDetailsDTOParam.TeamWagesDetailsDTOParamBuilder builder() {
      return new TeamWagesDetailsDTOParam.TeamWagesDetailsDTOParamBuilder();
   }

   public TeamWagesDetailsDTOParam(final Long teamId, final BigDecimal wages) {
      this.teamId = teamId;
      this.wages = wages;
   }

   public TeamWagesDetailsDTOParam() {
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public BigDecimal getWages() {
      return this.wages;
   }

   @JsonProperty("teamId")
   public TeamWagesDetailsDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("wages")
   public TeamWagesDetailsDTOParam setWages(final BigDecimal wages) {
      this.wages = wages;
      return this;
   }

   @Override
   public String toString() {
      return "TeamWagesDetailsDTOParam(teamId=" + this.getTeamId() + ", wages=" + this.getWages() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TeamWagesDetailsDTOParam)) {
         return false;
      } else {
         TeamWagesDetailsDTOParam other = (TeamWagesDetailsDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$wages = this.getWages();
               Object other$wages = other.getWages();
               return this$wages == null ? other$wages == null : this$wages.equals(other$wages);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamWagesDetailsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $wages = this.getWages();
      return result * 59 + ($wages == null ? 43 : $wages.hashCode());
   }

   public static class TeamWagesDetailsDTOParamBuilder {
      private Long teamId;
      private BigDecimal wages;

      TeamWagesDetailsDTOParamBuilder() {
      }

      @JsonProperty("teamId")
      public TeamWagesDetailsDTOParam.TeamWagesDetailsDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("wages")
      public TeamWagesDetailsDTOParam.TeamWagesDetailsDTOParamBuilder wages(final BigDecimal wages) {
         this.wages = wages;
         return this;
      }

      public TeamWagesDetailsDTOParam build() {
         return new TeamWagesDetailsDTOParam(this.teamId, this.wages);
      }

      @Override
      public String toString() {
         return "TeamWagesDetailsDTOParam.TeamWagesDetailsDTOParamBuilder(teamId=" + this.teamId + ", wages=" + this.wages + ")";
      }
   }
}
