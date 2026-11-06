package com.hzchum.scim.system.core.api.pojo.dto.safety;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("工地配置响应")
public class SiteDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "firstLevelName", notes = "一级名称")
   private String firstLevelName;
   @ApiModelProperty(name = "secondLevelName", notes = "二级名称")
   private String secondLevelName;
   @ApiModelProperty(name = "name", notes = "问题名字")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "pId", notes = "父级id")
   @JsonProperty("pId")
   @JSONField(name = "pId")
   private Long pId;
   @ApiModelProperty(name = "personalOrSceneEnum", notes = "个人或现场")
   @JsonProperty("personalOrSceneEnum")
   @JSONField(name = "personalOrSceneEnum")
   private Integer personalOrSceneEnum;
   @ApiModelProperty(name = "qualityOrSafetyEnum", notes = "质量或安全")
   @JsonProperty("qualityOrSafetyEnum")
   @JSONField(name = "qualityOrSafetyEnum")
   private Integer qualityOrSafetyEnum;
   @ApiModelProperty(name = "behaviorScore", notes = "行为分数")
   @JsonProperty("behaviorScore")
   @JSONField(name = "behaviorScore")
   private BigDecimal behaviorScore;
   @ApiModelProperty(name = "penalty", value = "罚金", notes = "罚金")
   @JsonProperty("penalty")
   @JSONField(name = "penalty")
   private BigDecimal penalty;
   @ApiModelProperty(name = "boolEnable", notes = "是否启用")
   @JsonProperty("boolEnable")
   @JSONField(name = "boolEnable")
   private boolean boolEnable;
   @ApiModelProperty(name = "siteDTO", notes = "子问题")
   @JsonProperty("siteDTO")
   @JSONField(name = "siteDTO")
   private List<SiteDTO> siteDTO;
   @ApiModelProperty(name = "level", value = "level", notes = "等级")
   @JsonProperty("level")
   @JSONField(name = "level")
   private Integer level;
   @ApiModelProperty(name = "operationalRiskAnalysis", value = "operationalRiskAnalysis", notes = "作业风险分析")
   @JsonProperty("operationalRiskAnalysis")
   @JSONField(name = "operationalRiskAnalysis")
   private String operationalRiskAnalysis;
   @ApiModelProperty(name = "hiddenDangerLevel", value = "hiddenDangerLevel", notes = "隐患级别")
   @JsonProperty("hiddenDangerLevel")
   @JSONField(name = "hiddenDangerLevel")
   private String hiddenDangerLevel;
   @ApiModelProperty(name = "correctiveMeasures", value = "correctiveMeasures", notes = "整改措施")
   @JsonProperty("correctiveMeasures")
   @JSONField(name = "correctiveMeasures")
   private String correctiveMeasures;
   @ApiModelProperty(name = "acceptanceCriteria", value = "acceptanceCriteria", notes = "验收标准")
   @JsonProperty("acceptanceCriteria")
   @JSONField(name = "acceptanceCriteria")
   private String acceptanceCriteria;
   @ApiModelProperty(name = "rectificationRequirement", value = "rectificationRequirement", notes = "整改要求")
   @JsonProperty("rectificationRequirement")
   @JSONField(name = "rectificationRequirement")
   private String rectificationRequirement;

   public Long getId() {
      return this.id;
   }

   public String getFirstLevelName() {
      return this.firstLevelName;
   }

   public String getSecondLevelName() {
      return this.secondLevelName;
   }

   public String getName() {
      return this.name;
   }

   public Long getPId() {
      return this.pId;
   }

   public Integer getPersonalOrSceneEnum() {
      return this.personalOrSceneEnum;
   }

   public Integer getQualityOrSafetyEnum() {
      return this.qualityOrSafetyEnum;
   }

   public BigDecimal getBehaviorScore() {
      return this.behaviorScore;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public boolean isBoolEnable() {
      return this.boolEnable;
   }

   public List<SiteDTO> getSiteDTO() {
      return this.siteDTO;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getOperationalRiskAnalysis() {
      return this.operationalRiskAnalysis;
   }

   public String getHiddenDangerLevel() {
      return this.hiddenDangerLevel;
   }

   public String getCorrectiveMeasures() {
      return this.correctiveMeasures;
   }

   public String getAcceptanceCriteria() {
      return this.acceptanceCriteria;
   }

   public String getRectificationRequirement() {
      return this.rectificationRequirement;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFirstLevelName(final String firstLevelName) {
      this.firstLevelName = firstLevelName;
   }

   public void setSecondLevelName(final String secondLevelName) {
      this.secondLevelName = secondLevelName;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("pId")
   public void setPId(final Long pId) {
      this.pId = pId;
   }

   @JsonProperty("personalOrSceneEnum")
   public void setPersonalOrSceneEnum(final Integer personalOrSceneEnum) {
      this.personalOrSceneEnum = personalOrSceneEnum;
   }

   @JsonProperty("qualityOrSafetyEnum")
   public void setQualityOrSafetyEnum(final Integer qualityOrSafetyEnum) {
      this.qualityOrSafetyEnum = qualityOrSafetyEnum;
   }

   @JsonProperty("behaviorScore")
   public void setBehaviorScore(final BigDecimal behaviorScore) {
      this.behaviorScore = behaviorScore;
   }

   @JsonProperty("penalty")
   public void setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
   }

   @JsonProperty("boolEnable")
   public void setBoolEnable(final boolean boolEnable) {
      this.boolEnable = boolEnable;
   }

   @JsonProperty("siteDTO")
   public void setSiteDTO(final List<SiteDTO> siteDTO) {
      this.siteDTO = siteDTO;
   }

   @JsonProperty("level")
   public void setLevel(final Integer level) {
      this.level = level;
   }

   @JsonProperty("operationalRiskAnalysis")
   public void setOperationalRiskAnalysis(final String operationalRiskAnalysis) {
      this.operationalRiskAnalysis = operationalRiskAnalysis;
   }

   @JsonProperty("hiddenDangerLevel")
   public void setHiddenDangerLevel(final String hiddenDangerLevel) {
      this.hiddenDangerLevel = hiddenDangerLevel;
   }

   @JsonProperty("correctiveMeasures")
   public void setCorrectiveMeasures(final String correctiveMeasures) {
      this.correctiveMeasures = correctiveMeasures;
   }

   @JsonProperty("acceptanceCriteria")
   public void setAcceptanceCriteria(final String acceptanceCriteria) {
      this.acceptanceCriteria = acceptanceCriteria;
   }

   @JsonProperty("rectificationRequirement")
   public void setRectificationRequirement(final String rectificationRequirement) {
      this.rectificationRequirement = rectificationRequirement;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SiteDTO)) {
         return false;
      }

      SiteDTO other = (SiteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolEnable() != other.isBoolEnable()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pId = this.getPId();
         Object other$pId = other.getPId();
         if (this$pId == null ? other$pId == null : this$pId.equals(other$pId)) {
            Object this$personalOrSceneEnum = this.getPersonalOrSceneEnum();
            Object other$personalOrSceneEnum = other.getPersonalOrSceneEnum();
            if (this$personalOrSceneEnum == null ? other$personalOrSceneEnum == null : this$personalOrSceneEnum.equals(other$personalOrSceneEnum)) {
               Object this$qualityOrSafetyEnum = this.getQualityOrSafetyEnum();
               Object other$qualityOrSafetyEnum = other.getQualityOrSafetyEnum();
               if (this$qualityOrSafetyEnum == null ? other$qualityOrSafetyEnum == null : this$qualityOrSafetyEnum.equals(other$qualityOrSafetyEnum)) {
                  Object this$level = this.getLevel();
                  Object other$level = other.getLevel();
                  if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                     Object this$firstLevelName = this.getFirstLevelName();
                     Object other$firstLevelName = other.getFirstLevelName();
                     if (this$firstLevelName == null ? other$firstLevelName == null : this$firstLevelName.equals(other$firstLevelName)) {
                        Object this$secondLevelName = this.getSecondLevelName();
                        Object other$secondLevelName = other.getSecondLevelName();
                        if (this$secondLevelName == null ? other$secondLevelName == null : this$secondLevelName.equals(other$secondLevelName)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$behaviorScore = this.getBehaviorScore();
                              Object other$behaviorScore = other.getBehaviorScore();
                              if (this$behaviorScore == null ? other$behaviorScore == null : this$behaviorScore.equals(other$behaviorScore)) {
                                 Object this$penalty = this.getPenalty();
                                 Object other$penalty = other.getPenalty();
                                 if (this$penalty == null ? other$penalty == null : this$penalty.equals(other$penalty)) {
                                    Object this$siteDTO = this.getSiteDTO();
                                    Object other$siteDTO = other.getSiteDTO();
                                    if (this$siteDTO == null ? other$siteDTO == null : this$siteDTO.equals(other$siteDTO)) {
                                       Object this$operationalRiskAnalysis = this.getOperationalRiskAnalysis();
                                       Object other$operationalRiskAnalysis = other.getOperationalRiskAnalysis();
                                       if (this$operationalRiskAnalysis == null
                                          ? other$operationalRiskAnalysis == null
                                          : this$operationalRiskAnalysis.equals(other$operationalRiskAnalysis)) {
                                          Object this$hiddenDangerLevel = this.getHiddenDangerLevel();
                                          Object other$hiddenDangerLevel = other.getHiddenDangerLevel();
                                          if (this$hiddenDangerLevel == null
                                             ? other$hiddenDangerLevel == null
                                             : this$hiddenDangerLevel.equals(other$hiddenDangerLevel)) {
                                             Object this$correctiveMeasures = this.getCorrectiveMeasures();
                                             Object other$correctiveMeasures = other.getCorrectiveMeasures();
                                             if (this$correctiveMeasures == null
                                                ? other$correctiveMeasures == null
                                                : this$correctiveMeasures.equals(other$correctiveMeasures)) {
                                                Object this$acceptanceCriteria = this.getAcceptanceCriteria();
                                                Object other$acceptanceCriteria = other.getAcceptanceCriteria();
                                                if (this$acceptanceCriteria == null
                                                   ? other$acceptanceCriteria == null
                                                   : this$acceptanceCriteria.equals(other$acceptanceCriteria)) {
                                                   Object this$rectificationRequirement = this.getRectificationRequirement();
                                                   Object other$rectificationRequirement = other.getRectificationRequirement();
                                                   return this$rectificationRequirement == null
                                                      ? other$rectificationRequirement == null
                                                      : this$rectificationRequirement.equals(other$rectificationRequirement);
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
      return other instanceof SiteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolEnable() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pId = this.getPId();
      result = result * 59 + ($pId == null ? 43 : $pId.hashCode());
      Object $personalOrSceneEnum = this.getPersonalOrSceneEnum();
      result = result * 59 + ($personalOrSceneEnum == null ? 43 : $personalOrSceneEnum.hashCode());
      Object $qualityOrSafetyEnum = this.getQualityOrSafetyEnum();
      result = result * 59 + ($qualityOrSafetyEnum == null ? 43 : $qualityOrSafetyEnum.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $firstLevelName = this.getFirstLevelName();
      result = result * 59 + ($firstLevelName == null ? 43 : $firstLevelName.hashCode());
      Object $secondLevelName = this.getSecondLevelName();
      result = result * 59 + ($secondLevelName == null ? 43 : $secondLevelName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $behaviorScore = this.getBehaviorScore();
      result = result * 59 + ($behaviorScore == null ? 43 : $behaviorScore.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      Object $siteDTO = this.getSiteDTO();
      result = result * 59 + ($siteDTO == null ? 43 : $siteDTO.hashCode());
      Object $operationalRiskAnalysis = this.getOperationalRiskAnalysis();
      result = result * 59 + ($operationalRiskAnalysis == null ? 43 : $operationalRiskAnalysis.hashCode());
      Object $hiddenDangerLevel = this.getHiddenDangerLevel();
      result = result * 59 + ($hiddenDangerLevel == null ? 43 : $hiddenDangerLevel.hashCode());
      Object $correctiveMeasures = this.getCorrectiveMeasures();
      result = result * 59 + ($correctiveMeasures == null ? 43 : $correctiveMeasures.hashCode());
      Object $acceptanceCriteria = this.getAcceptanceCriteria();
      result = result * 59 + ($acceptanceCriteria == null ? 43 : $acceptanceCriteria.hashCode());
      Object $rectificationRequirement = this.getRectificationRequirement();
      return result * 59 + ($rectificationRequirement == null ? 43 : $rectificationRequirement.hashCode());
   }

   @Override
   public String toString() {
      return "SiteDTO(id="
         + this.getId()
         + ", firstLevelName="
         + this.getFirstLevelName()
         + ", secondLevelName="
         + this.getSecondLevelName()
         + ", name="
         + this.getName()
         + ", pId="
         + this.getPId()
         + ", personalOrSceneEnum="
         + this.getPersonalOrSceneEnum()
         + ", qualityOrSafetyEnum="
         + this.getQualityOrSafetyEnum()
         + ", behaviorScore="
         + this.getBehaviorScore()
         + ", penalty="
         + this.getPenalty()
         + ", boolEnable="
         + this.isBoolEnable()
         + ", siteDTO="
         + this.getSiteDTO()
         + ", level="
         + this.getLevel()
         + ", operationalRiskAnalysis="
         + this.getOperationalRiskAnalysis()
         + ", hiddenDangerLevel="
         + this.getHiddenDangerLevel()
         + ", correctiveMeasures="
         + this.getCorrectiveMeasures()
         + ", acceptanceCriteria="
         + this.getAcceptanceCriteria()
         + ", rectificationRequirement="
         + this.getRectificationRequirement()
         + ")";
   }
}
