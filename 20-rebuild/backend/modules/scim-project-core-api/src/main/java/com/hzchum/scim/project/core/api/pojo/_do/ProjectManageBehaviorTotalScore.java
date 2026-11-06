package com.hzchum.scim.project.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectManageBehaviorTotalScore对象", description = "每年行为总分表")
@Entity
@TableName("project_manage_behavior_total_score")
@Table(name = "project_manage_behavior_total_score")
@org.hibernate.annotations.Table(appliesTo = "project_manage_behavior_total_score", comment = "每年行为总分表")
public class ProjectManageBehaviorTotalScore extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   @TableField("year")
   @Column(name = "year", columnDefinition = "int(11)  COMMENT '年份'", nullable = true)
   private Integer year;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "totalScore", value = "总分", notes = "总分")
   @TableField("total_score")
   @Column(name = "total_score", columnDefinition = "int(11)  COMMENT '总分'", nullable = true)
   private Integer totalScore;
   @ApiModelProperty(name = "boolDeduction", value = "是否扣减总分(true: 扣, false: 不扣)", notes = "是否扣减总分(true: 扣, false: 不扣)")
   @TableField("bool_deduction")
   @Column(name = "bool_deduction", columnDefinition = "tinyint(1)  COMMENT '是否扣减总分(true: 扣, false: 不扣)'", nullable = true)
   private Boolean boolDeduction;

   public static ProjectManageBehaviorTotalScore.ProjectManageBehaviorTotalScoreBuilder builder() {
      return new ProjectManageBehaviorTotalScore.ProjectManageBehaviorTotalScoreBuilder();
   }

   public ProjectManageBehaviorTotalScore() {
   }

   public ProjectManageBehaviorTotalScore(final Long id, final Integer year, final Long projectId, final Integer totalScore, final Boolean boolDeduction) {
      this.id = id;
      this.year = year;
      this.projectId = projectId;
      this.totalScore = totalScore;
      this.boolDeduction = boolDeduction;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getYear() {
      return this.year;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getTotalScore() {
      return this.totalScore;
   }

   public Boolean getBoolDeduction() {
      return this.boolDeduction;
   }

   public ProjectManageBehaviorTotalScore setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectManageBehaviorTotalScore setYear(final Integer year) {
      this.year = year;
      return this;
   }

   public ProjectManageBehaviorTotalScore setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectManageBehaviorTotalScore setTotalScore(final Integer totalScore) {
      this.totalScore = totalScore;
      return this;
   }

   public ProjectManageBehaviorTotalScore setBoolDeduction(final Boolean boolDeduction) {
      this.boolDeduction = boolDeduction;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectManageBehaviorTotalScore(id="
         + this.getId()
         + ", year="
         + this.getYear()
         + ", projectId="
         + this.getProjectId()
         + ", totalScore="
         + this.getTotalScore()
         + ", boolDeduction="
         + this.getBoolDeduction()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageBehaviorTotalScore)) {
         return false;
      }

      ProjectManageBehaviorTotalScore other = (ProjectManageBehaviorTotalScore)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$year = this.getYear();
         Object other$year = other.getYear();
         if (this$year == null ? other$year == null : this$year.equals(other$year)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$totalScore = this.getTotalScore();
               Object other$totalScore = other.getTotalScore();
               if (this$totalScore == null ? other$totalScore == null : this$totalScore.equals(other$totalScore)) {
                  Object this$boolDeduction = this.getBoolDeduction();
                  Object other$boolDeduction = other.getBoolDeduction();
                  return this$boolDeduction == null ? other$boolDeduction == null : this$boolDeduction.equals(other$boolDeduction);
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
      return other instanceof ProjectManageBehaviorTotalScore;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $totalScore = this.getTotalScore();
      result = result * 59 + ($totalScore == null ? 43 : $totalScore.hashCode());
      Object $boolDeduction = this.getBoolDeduction();
      return result * 59 + ($boolDeduction == null ? 43 : $boolDeduction.hashCode());
   }

   public static class ProjectManageBehaviorTotalScoreBuilder {
      private Long id;
      private Integer year;
      private Long projectId;
      private Integer totalScore;
      private Boolean boolDeduction;

      ProjectManageBehaviorTotalScoreBuilder() {
      }

      public ProjectManageBehaviorTotalScore.ProjectManageBehaviorTotalScoreBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectManageBehaviorTotalScore.ProjectManageBehaviorTotalScoreBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ProjectManageBehaviorTotalScore.ProjectManageBehaviorTotalScoreBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectManageBehaviorTotalScore.ProjectManageBehaviorTotalScoreBuilder totalScore(final Integer totalScore) {
         this.totalScore = totalScore;
         return this;
      }

      public ProjectManageBehaviorTotalScore.ProjectManageBehaviorTotalScoreBuilder boolDeduction(final Boolean boolDeduction) {
         this.boolDeduction = boolDeduction;
         return this;
      }

      public ProjectManageBehaviorTotalScore build() {
         return new ProjectManageBehaviorTotalScore(this.id, this.year, this.projectId, this.totalScore, this.boolDeduction);
      }

      @Override
      public String toString() {
         return "ProjectManageBehaviorTotalScore.ProjectManageBehaviorTotalScoreBuilder(id="
            + this.id
            + ", year="
            + this.year
            + ", projectId="
            + this.projectId
            + ", totalScore="
            + this.totalScore
            + ", boolDeduction="
            + this.boolDeduction
            + ")";
      }
   }
}
