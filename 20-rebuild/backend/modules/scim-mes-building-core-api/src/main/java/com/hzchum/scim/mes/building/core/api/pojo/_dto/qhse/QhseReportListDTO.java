package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "QhseReportListDTO", description = "问题报表 ")
public class QhseReportListDTO {
   @ApiModelProperty(name = "id", value = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "qhseNumber", value = "编号")
   @JsonProperty("qhseNumber")
   @JSONField(name = "qhseNumber")
   private String qhseNumber;
   @ApiModelProperty(name = "projectSerialNumber", value = "项目编号")
   @JsonProperty("projectSerialNumber")
   @JSONField(name = "projectSerialNumber")
   private String projectSerialNumber;
   @ApiModelProperty(name = "projectShortName", value = "项目简称")
   @JsonProperty("projectShortName")
   @JSONField(name = "projectShortName")
   private String projectShortName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "inspectionName", value = "质检人")
   private String inspectionName;
   @ApiModelProperty(name = "inspectionDate", value = "质检时间")
   private LocalDateTime inspectionDate;
   @ApiModelProperty(name = "teamLeaderName", value = "责任班组")
   private String teamLeaderName;
   @ApiModelProperty(name = "processName", value = "工序名称")
   private String processName;
   @ApiModelProperty(name = "levelOneName", value = "一级分类id")
   private String levelOneName;
   @ApiModelProperty(name = "levelTwoName", value = "二级分类id")
   private String levelTwoName;
   @ApiModelProperty(name = "behaviorScore", notes = "行为分数")
   private Integer behaviorScore;
   @ApiModelProperty(name = "penalty", value = "罚金", notes = "罚金")
   private BigDecimal penalty;
   @ApiModelProperty(name = "status", value = "处理状态", notes = "处理状态")
   private Integer status;

   public static QhseReportListDTO.QhseReportListDTOBuilder builder() {
      return new QhseReportListDTO.QhseReportListDTOBuilder();
   }

   public QhseReportListDTO() {
   }

   public QhseReportListDTO(
      final Long id,
      final String qhseNumber,
      final String projectSerialNumber,
      final String projectShortName,
      final String serialNumber,
      final String inspectionName,
      final LocalDateTime inspectionDate,
      final String teamLeaderName,
      final String processName,
      final String levelOneName,
      final String levelTwoName,
      final Integer behaviorScore,
      final BigDecimal penalty,
      final Integer status
   ) {
      this.id = id;
      this.qhseNumber = qhseNumber;
      this.projectSerialNumber = projectSerialNumber;
      this.projectShortName = projectShortName;
      this.serialNumber = serialNumber;
      this.inspectionName = inspectionName;
      this.inspectionDate = inspectionDate;
      this.teamLeaderName = teamLeaderName;
      this.processName = processName;
      this.levelOneName = levelOneName;
      this.levelTwoName = levelTwoName;
      this.behaviorScore = behaviorScore;
      this.penalty = penalty;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getQhseNumber() {
      return this.qhseNumber;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getProjectShortName() {
      return this.projectShortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getInspectionName() {
      return this.inspectionName;
   }

   public LocalDateTime getInspectionDate() {
      return this.inspectionDate;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getLevelOneName() {
      return this.levelOneName;
   }

   public String getLevelTwoName() {
      return this.levelTwoName;
   }

   public Integer getBehaviorScore() {
      return this.behaviorScore;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public QhseReportListDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseNumber")
   public QhseReportListDTO setQhseNumber(final String qhseNumber) {
      this.qhseNumber = qhseNumber;
      return this;
   }

   @JsonProperty("projectSerialNumber")
   public QhseReportListDTO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   @JsonProperty("projectShortName")
   public QhseReportListDTO setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
      return this;
   }

   public QhseReportListDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public QhseReportListDTO setInspectionName(final String inspectionName) {
      this.inspectionName = inspectionName;
      return this;
   }

   public QhseReportListDTO setInspectionDate(final LocalDateTime inspectionDate) {
      this.inspectionDate = inspectionDate;
      return this;
   }

   public QhseReportListDTO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   public QhseReportListDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   public QhseReportListDTO setLevelOneName(final String levelOneName) {
      this.levelOneName = levelOneName;
      return this;
   }

   public QhseReportListDTO setLevelTwoName(final String levelTwoName) {
      this.levelTwoName = levelTwoName;
      return this;
   }

   public QhseReportListDTO setBehaviorScore(final Integer behaviorScore) {
      this.behaviorScore = behaviorScore;
      return this;
   }

   public QhseReportListDTO setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
      return this;
   }

   public QhseReportListDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseReportListDTO)) {
         return false;
      }

      QhseReportListDTO other = (QhseReportListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$behaviorScore = this.getBehaviorScore();
         Object other$behaviorScore = other.getBehaviorScore();
         if (this$behaviorScore == null ? other$behaviorScore == null : this$behaviorScore.equals(other$behaviorScore)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$qhseNumber = this.getQhseNumber();
               Object other$qhseNumber = other.getQhseNumber();
               if (this$qhseNumber == null ? other$qhseNumber == null : this$qhseNumber.equals(other$qhseNumber)) {
                  Object this$projectSerialNumber = this.getProjectSerialNumber();
                  Object other$projectSerialNumber = other.getProjectSerialNumber();
                  if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                     Object this$projectShortName = this.getProjectShortName();
                     Object other$projectShortName = other.getProjectShortName();
                     if (this$projectShortName == null ? other$projectShortName == null : this$projectShortName.equals(other$projectShortName)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$inspectionName = this.getInspectionName();
                           Object other$inspectionName = other.getInspectionName();
                           if (this$inspectionName == null ? other$inspectionName == null : this$inspectionName.equals(other$inspectionName)) {
                              Object this$inspectionDate = this.getInspectionDate();
                              Object other$inspectionDate = other.getInspectionDate();
                              if (this$inspectionDate == null ? other$inspectionDate == null : this$inspectionDate.equals(other$inspectionDate)) {
                                 Object this$teamLeaderName = this.getTeamLeaderName();
                                 Object other$teamLeaderName = other.getTeamLeaderName();
                                 if (this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName)) {
                                    Object this$processName = this.getProcessName();
                                    Object other$processName = other.getProcessName();
                                    if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                       Object this$levelOneName = this.getLevelOneName();
                                       Object other$levelOneName = other.getLevelOneName();
                                       if (this$levelOneName == null ? other$levelOneName == null : this$levelOneName.equals(other$levelOneName)) {
                                          Object this$levelTwoName = this.getLevelTwoName();
                                          Object other$levelTwoName = other.getLevelTwoName();
                                          if (this$levelTwoName == null ? other$levelTwoName == null : this$levelTwoName.equals(other$levelTwoName)) {
                                             Object this$penalty = this.getPenalty();
                                             Object other$penalty = other.getPenalty();
                                             return this$penalty == null ? other$penalty == null : this$penalty.equals(other$penalty);
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
      return other instanceof QhseReportListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $behaviorScore = this.getBehaviorScore();
      result = result * 59 + ($behaviorScore == null ? 43 : $behaviorScore.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $qhseNumber = this.getQhseNumber();
      result = result * 59 + ($qhseNumber == null ? 43 : $qhseNumber.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $inspectionName = this.getInspectionName();
      result = result * 59 + ($inspectionName == null ? 43 : $inspectionName.hashCode());
      Object $inspectionDate = this.getInspectionDate();
      result = result * 59 + ($inspectionDate == null ? 43 : $inspectionDate.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $levelOneName = this.getLevelOneName();
      result = result * 59 + ($levelOneName == null ? 43 : $levelOneName.hashCode());
      Object $levelTwoName = this.getLevelTwoName();
      result = result * 59 + ($levelTwoName == null ? 43 : $levelTwoName.hashCode());
      Object $penalty = this.getPenalty();
      return result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
   }

   @Override
   public String toString() {
      return "QhseReportListDTO(id="
         + this.getId()
         + ", qhseNumber="
         + this.getQhseNumber()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", inspectionName="
         + this.getInspectionName()
         + ", inspectionDate="
         + this.getInspectionDate()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", processName="
         + this.getProcessName()
         + ", levelOneName="
         + this.getLevelOneName()
         + ", levelTwoName="
         + this.getLevelTwoName()
         + ", behaviorScore="
         + this.getBehaviorScore()
         + ", penalty="
         + this.getPenalty()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class QhseReportListDTOBuilder {
      private Long id;
      private String qhseNumber;
      private String projectSerialNumber;
      private String projectShortName;
      private String serialNumber;
      private String inspectionName;
      private LocalDateTime inspectionDate;
      private String teamLeaderName;
      private String processName;
      private String levelOneName;
      private String levelTwoName;
      private Integer behaviorScore;
      private BigDecimal penalty;
      private Integer status;

      QhseReportListDTOBuilder() {
      }

      @JsonProperty("id")
      public QhseReportListDTO.QhseReportListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseNumber")
      public QhseReportListDTO.QhseReportListDTOBuilder qhseNumber(final String qhseNumber) {
         this.qhseNumber = qhseNumber;
         return this;
      }

      @JsonProperty("projectSerialNumber")
      public QhseReportListDTO.QhseReportListDTOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      @JsonProperty("projectShortName")
      public QhseReportListDTO.QhseReportListDTOBuilder projectShortName(final String projectShortName) {
         this.projectShortName = projectShortName;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder inspectionName(final String inspectionName) {
         this.inspectionName = inspectionName;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder inspectionDate(final LocalDateTime inspectionDate) {
         this.inspectionDate = inspectionDate;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder levelOneName(final String levelOneName) {
         this.levelOneName = levelOneName;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder levelTwoName(final String levelTwoName) {
         this.levelTwoName = levelTwoName;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder behaviorScore(final Integer behaviorScore) {
         this.behaviorScore = behaviorScore;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      public QhseReportListDTO.QhseReportListDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public QhseReportListDTO build() {
         return new QhseReportListDTO(
            this.id,
            this.qhseNumber,
            this.projectSerialNumber,
            this.projectShortName,
            this.serialNumber,
            this.inspectionName,
            this.inspectionDate,
            this.teamLeaderName,
            this.processName,
            this.levelOneName,
            this.levelTwoName,
            this.behaviorScore,
            this.penalty,
            this.status
         );
      }

      @Override
      public String toString() {
         return "QhseReportListDTO.QhseReportListDTOBuilder(id="
            + this.id
            + ", qhseNumber="
            + this.qhseNumber
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", projectShortName="
            + this.projectShortName
            + ", serialNumber="
            + this.serialNumber
            + ", inspectionName="
            + this.inspectionName
            + ", inspectionDate="
            + this.inspectionDate
            + ", teamLeaderName="
            + this.teamLeaderName
            + ", processName="
            + this.processName
            + ", levelOneName="
            + this.levelOneName
            + ", levelTwoName="
            + this.levelTwoName
            + ", behaviorScore="
            + this.behaviorScore
            + ", penalty="
            + this.penalty
            + ", status="
            + this.status
            + ")";
      }
   }
}
