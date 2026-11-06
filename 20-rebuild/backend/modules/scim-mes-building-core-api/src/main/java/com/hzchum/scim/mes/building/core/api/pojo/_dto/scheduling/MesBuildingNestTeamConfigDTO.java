package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingNestTeamConfigDTO", description = "套料班组配置 ")
public class MesBuildingNestTeamConfigDTO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", notes = "车间名称")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "teamName", notes = "班组名称")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty(name = "codeRule", notes = "代号规则")
   @JsonProperty("codeRule")
   @JSONField(name = "codeRule")
   private Boolean codeRule;
   @ApiModelProperty(name = "displayRule", notes = "展示规则")
   @JsonProperty("displayRule")
   @JSONField(name = "displayRule")
   private Boolean displayRule;
   @ApiModelProperty(name = "codeName", notes = "代号")
   @JsonProperty("codeName")
   @JSONField(name = "codeName")
   private String codeName;
   @ApiModelProperty(name = "teamDisplayRule", notes = "班组展示规则")
   @JsonProperty("teamDisplayRule")
   @JSONField(name = "teamDisplayRule")
   private Boolean teamDisplayRule;
   @ApiModelProperty("是否显示代号(1:显示, 0:显示)")
   private Boolean boolShowCodename;

   public static MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder builder() {
      return new MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder();
   }

   public MesBuildingNestTeamConfigDTO() {
   }

   public MesBuildingNestTeamConfigDTO(
      final Long id,
      final Long workshopId,
      final String workshopName,
      final Long processId,
      final String processName,
      final Long teamId,
      final String teamName,
      final Boolean codeRule,
      final Boolean displayRule,
      final String codeName,
      final Boolean teamDisplayRule,
      final Boolean boolShowCodename
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.processId = processId;
      this.processName = processName;
      this.teamId = teamId;
      this.teamName = teamName;
      this.codeRule = codeRule;
      this.displayRule = displayRule;
      this.codeName = codeName;
      this.teamDisplayRule = teamDisplayRule;
      this.boolShowCodename = boolShowCodename;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public Boolean getCodeRule() {
      return this.codeRule;
   }

   public Boolean getDisplayRule() {
      return this.displayRule;
   }

   public String getCodeName() {
      return this.codeName;
   }

   public Boolean getTeamDisplayRule() {
      return this.teamDisplayRule;
   }

   public Boolean getBoolShowCodename() {
      return this.boolShowCodename;
   }

   @JsonProperty("id")
   public MesBuildingNestTeamConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingNestTeamConfigDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingNestTeamConfigDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingNestTeamConfigDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingNestTeamConfigDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingNestTeamConfigDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamName")
   public MesBuildingNestTeamConfigDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @JsonProperty("codeRule")
   public MesBuildingNestTeamConfigDTO setCodeRule(final Boolean codeRule) {
      this.codeRule = codeRule;
      return this;
   }

   @JsonProperty("displayRule")
   public MesBuildingNestTeamConfigDTO setDisplayRule(final Boolean displayRule) {
      this.displayRule = displayRule;
      return this;
   }

   @JsonProperty("codeName")
   public MesBuildingNestTeamConfigDTO setCodeName(final String codeName) {
      this.codeName = codeName;
      return this;
   }

   @JsonProperty("teamDisplayRule")
   public MesBuildingNestTeamConfigDTO setTeamDisplayRule(final Boolean teamDisplayRule) {
      this.teamDisplayRule = teamDisplayRule;
      return this;
   }

   public MesBuildingNestTeamConfigDTO setBoolShowCodename(final Boolean boolShowCodename) {
      this.boolShowCodename = boolShowCodename;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestTeamConfigDTO(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
         + ", codeRule="
         + this.getCodeRule()
         + ", displayRule="
         + this.getDisplayRule()
         + ", codeName="
         + this.getCodeName()
         + ", teamDisplayRule="
         + this.getTeamDisplayRule()
         + ", boolShowCodename="
         + this.getBoolShowCodename()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestTeamConfigDTO)) {
         return false;
      }

      MesBuildingNestTeamConfigDTO other = (MesBuildingNestTeamConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$codeRule = this.getCodeRule();
                  Object other$codeRule = other.getCodeRule();
                  if (this$codeRule == null ? other$codeRule == null : this$codeRule.equals(other$codeRule)) {
                     Object this$displayRule = this.getDisplayRule();
                     Object other$displayRule = other.getDisplayRule();
                     if (this$displayRule == null ? other$displayRule == null : this$displayRule.equals(other$displayRule)) {
                        Object this$teamDisplayRule = this.getTeamDisplayRule();
                        Object other$teamDisplayRule = other.getTeamDisplayRule();
                        if (this$teamDisplayRule == null ? other$teamDisplayRule == null : this$teamDisplayRule.equals(other$teamDisplayRule)) {
                           Object this$boolShowCodename = this.getBoolShowCodename();
                           Object other$boolShowCodename = other.getBoolShowCodename();
                           if (this$boolShowCodename == null ? other$boolShowCodename == null : this$boolShowCodename.equals(other$boolShowCodename)) {
                              Object this$workshopName = this.getWorkshopName();
                              Object other$workshopName = other.getWorkshopName();
                              if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                 Object this$processName = this.getProcessName();
                                 Object other$processName = other.getProcessName();
                                 if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                    Object this$teamName = this.getTeamName();
                                    Object other$teamName = other.getTeamName();
                                    if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                                       Object this$codeName = this.getCodeName();
                                       Object other$codeName = other.getCodeName();
                                       return this$codeName == null ? other$codeName == null : this$codeName.equals(other$codeName);
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
      return other instanceof MesBuildingNestTeamConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $codeRule = this.getCodeRule();
      result = result * 59 + ($codeRule == null ? 43 : $codeRule.hashCode());
      Object $displayRule = this.getDisplayRule();
      result = result * 59 + ($displayRule == null ? 43 : $displayRule.hashCode());
      Object $teamDisplayRule = this.getTeamDisplayRule();
      result = result * 59 + ($teamDisplayRule == null ? 43 : $teamDisplayRule.hashCode());
      Object $boolShowCodename = this.getBoolShowCodename();
      result = result * 59 + ($boolShowCodename == null ? 43 : $boolShowCodename.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $codeName = this.getCodeName();
      return result * 59 + ($codeName == null ? 43 : $codeName.hashCode());
   }

   public static class MesBuildingNestTeamConfigDTOBuilder {
      private Long id;
      private Long workshopId;
      private String workshopName;
      private Long processId;
      private String processName;
      private Long teamId;
      private String teamName;
      private Boolean codeRule;
      private Boolean displayRule;
      private String codeName;
      private Boolean teamDisplayRule;
      private Boolean boolShowCodename;

      MesBuildingNestTeamConfigDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("teamName")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      @JsonProperty("codeRule")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder codeRule(final Boolean codeRule) {
         this.codeRule = codeRule;
         return this;
      }

      @JsonProperty("displayRule")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder displayRule(final Boolean displayRule) {
         this.displayRule = displayRule;
         return this;
      }

      @JsonProperty("codeName")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder codeName(final String codeName) {
         this.codeName = codeName;
         return this;
      }

      @JsonProperty("teamDisplayRule")
      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder teamDisplayRule(final Boolean teamDisplayRule) {
         this.teamDisplayRule = teamDisplayRule;
         return this;
      }

      public MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder boolShowCodename(final Boolean boolShowCodename) {
         this.boolShowCodename = boolShowCodename;
         return this;
      }

      public MesBuildingNestTeamConfigDTO build() {
         return new MesBuildingNestTeamConfigDTO(
            this.id,
            this.workshopId,
            this.workshopName,
            this.processId,
            this.processName,
            this.teamId,
            this.teamName,
            this.codeRule,
            this.displayRule,
            this.codeName,
            this.teamDisplayRule,
            this.boolShowCodename
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNestTeamConfigDTO.MesBuildingNestTeamConfigDTOBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", teamId="
            + this.teamId
            + ", teamName="
            + this.teamName
            + ", codeRule="
            + this.codeRule
            + ", displayRule="
            + this.displayRule
            + ", codeName="
            + this.codeName
            + ", teamDisplayRule="
            + this.teamDisplayRule
            + ", boolShowCodename="
            + this.boolShowCodename
            + ")";
      }
   }
}
