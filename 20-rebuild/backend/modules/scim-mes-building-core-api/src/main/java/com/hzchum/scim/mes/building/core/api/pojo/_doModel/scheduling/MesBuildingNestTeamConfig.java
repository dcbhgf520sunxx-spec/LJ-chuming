package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingNestTeamConfig对象", description = "MesBuildingNestTeamConfig对象")
@Entity
@TableName("mes_building_nest_team_config")
@Table(name = "mes_building_nest_team_config")
public class MesBuildingNestTeamConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "codeName", notes = "代号")
   @JsonProperty("codeName")
   @JSONField(name = "codeName")
   @TableField("code_name")
   @Column(name = "code_name", columnDefinition = "varchar(20)  COMMENT '代号'", nullable = false)
   private String codeName;
   @ApiModelProperty(name = "codeRule", notes = "代号规则")
   @JsonProperty("codeRule")
   @JSONField(name = "codeRule")
   @TableField("code_rule")
   @Column(name = "code_rule", columnDefinition = "tinyint(1) default 0 COMMENT '代号规则'", nullable = false)
   private Boolean codeRule;
   @ApiModelProperty(name = "displayRule", notes = "展示规则")
   @JsonProperty("displayRule")
   @JSONField(name = "displayRule")
   @TableField("display_rule")
   @Column(name = "display_rule", columnDefinition = "tinyint(1) default 0 COMMENT '展示规则'", nullable = false)
   private Boolean displayRule;
   @ApiModelProperty(name = "teamDisplayRule", notes = "班组展示规则")
   @JsonProperty("teamDisplayRule")
   @JSONField(name = "teamDisplayRule")
   @TableField("team_display_rule")
   @Column(name = "team_display_rule", columnDefinition = "tinyint(1) default 0 COMMENT '班组展示规则'", nullable = false)
   private Boolean teamDisplayRule;
   @ApiModelProperty("是否显示代号(1:显示, 0:显示)")
   @TableField("bool_show_codename")
   @Column(name = "bool_show_codename", columnDefinition = "tinyint(1) default 1 COMMENT '是否显示代号(1:显示, 0:显示)'", nullable = true)
   private Boolean boolShowCodename;

   public static MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder builder() {
      return new MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder();
   }

   public MesBuildingNestTeamConfig() {
   }

   public MesBuildingNestTeamConfig(
      final Long id,
      final Long workshopId,
      final Long processId,
      final Long teamId,
      final String codeName,
      final Boolean codeRule,
      final Boolean displayRule,
      final Boolean teamDisplayRule,
      final Boolean boolShowCodename
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.processId = processId;
      this.teamId = teamId;
      this.codeName = codeName;
      this.codeRule = codeRule;
      this.displayRule = displayRule;
      this.teamDisplayRule = teamDisplayRule;
      this.boolShowCodename = boolShowCodename;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getCodeName() {
      return this.codeName;
   }

   public Boolean getCodeRule() {
      return this.codeRule;
   }

   public Boolean getDisplayRule() {
      return this.displayRule;
   }

   public Boolean getTeamDisplayRule() {
      return this.teamDisplayRule;
   }

   public Boolean getBoolShowCodename() {
      return this.boolShowCodename;
   }

   @JsonProperty("id")
   public MesBuildingNestTeamConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingNestTeamConfig setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingNestTeamConfig setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingNestTeamConfig setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("codeName")
   public MesBuildingNestTeamConfig setCodeName(final String codeName) {
      this.codeName = codeName;
      return this;
   }

   @JsonProperty("codeRule")
   public MesBuildingNestTeamConfig setCodeRule(final Boolean codeRule) {
      this.codeRule = codeRule;
      return this;
   }

   @JsonProperty("displayRule")
   public MesBuildingNestTeamConfig setDisplayRule(final Boolean displayRule) {
      this.displayRule = displayRule;
      return this;
   }

   @JsonProperty("teamDisplayRule")
   public MesBuildingNestTeamConfig setTeamDisplayRule(final Boolean teamDisplayRule) {
      this.teamDisplayRule = teamDisplayRule;
      return this;
   }

   public MesBuildingNestTeamConfig setBoolShowCodename(final Boolean boolShowCodename) {
      this.boolShowCodename = boolShowCodename;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestTeamConfig(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", codeName="
         + this.getCodeName()
         + ", codeRule="
         + this.getCodeRule()
         + ", displayRule="
         + this.getDisplayRule()
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

      if (!(o instanceof MesBuildingNestTeamConfig)) {
         return false;
      }

      MesBuildingNestTeamConfig other = (MesBuildingNestTeamConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingNestTeamConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      Object $codeName = this.getCodeName();
      return result * 59 + ($codeName == null ? 43 : $codeName.hashCode());
   }

   public static class MesBuildingNestTeamConfigBuilder {
      private Long id;
      private Long workshopId;
      private Long processId;
      private Long teamId;
      private String codeName;
      private Boolean codeRule;
      private Boolean displayRule;
      private Boolean teamDisplayRule;
      private Boolean boolShowCodename;

      MesBuildingNestTeamConfigBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("codeName")
      public MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder codeName(final String codeName) {
         this.codeName = codeName;
         return this;
      }

      @JsonProperty("codeRule")
      public MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder codeRule(final Boolean codeRule) {
         this.codeRule = codeRule;
         return this;
      }

      @JsonProperty("displayRule")
      public MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder displayRule(final Boolean displayRule) {
         this.displayRule = displayRule;
         return this;
      }

      @JsonProperty("teamDisplayRule")
      public MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder teamDisplayRule(final Boolean teamDisplayRule) {
         this.teamDisplayRule = teamDisplayRule;
         return this;
      }

      public MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder boolShowCodename(final Boolean boolShowCodename) {
         this.boolShowCodename = boolShowCodename;
         return this;
      }

      public MesBuildingNestTeamConfig build() {
         return new MesBuildingNestTeamConfig(
            this.id, this.workshopId, this.processId, this.teamId, this.codeName, this.codeRule, this.displayRule, this.teamDisplayRule, this.boolShowCodename
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNestTeamConfig.MesBuildingNestTeamConfigBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", processId="
            + this.processId
            + ", teamId="
            + this.teamId
            + ", codeName="
            + this.codeName
            + ", codeRule="
            + this.codeRule
            + ", displayRule="
            + this.displayRule
            + ", teamDisplayRule="
            + this.teamDisplayRule
            + ", boolShowCodename="
            + this.boolShowCodename
            + ")";
      }
   }
}
