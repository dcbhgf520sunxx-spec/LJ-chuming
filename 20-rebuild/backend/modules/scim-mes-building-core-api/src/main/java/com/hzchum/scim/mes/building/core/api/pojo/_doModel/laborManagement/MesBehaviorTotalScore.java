package com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement;

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

@ApiModel(value = "MesBehaviorTotalScore对象", description = "每年行为总分表")
@Entity
@TableName("mes_behavior_total_score")
@Table(name = "mes_behavior_total_score")
@org.hibernate.annotations.Table(appliesTo = "mes_behavior_total_score", comment = "每年行为总分表")
public class MesBehaviorTotalScore extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("年份")
   @TableField("year")
   @Column(name = "year", columnDefinition = "int COMMENT '年份'", nullable = true)
   private Integer year;
   @ApiModelProperty("总分")
   @TableField("total_score")
   @Column(name = "total_score", columnDefinition = "int COMMENT '总分'", nullable = true)
   private Integer totalScore;
   @ApiModelProperty("是否扣减总分(true: 扣, false: 不扣)")
   @TableField("bool_deduction")
   @Column(name = "bool_deduction", columnDefinition = "tinyint(1) COMMENT '是否扣减总分(true: 扣, false: 不扣)'", nullable = true)
   private Boolean boolDeduction;

   public static MesBehaviorTotalScore.MesBehaviorTotalScoreBuilder builder() {
      return new MesBehaviorTotalScore.MesBehaviorTotalScoreBuilder();
   }

   public MesBehaviorTotalScore() {
   }

   public MesBehaviorTotalScore(final Long id, final Integer year, final Integer totalScore, final Boolean boolDeduction) {
      this.id = id;
      this.year = year;
      this.totalScore = totalScore;
      this.boolDeduction = boolDeduction;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getTotalScore() {
      return this.totalScore;
   }

   public Boolean getBoolDeduction() {
      return this.boolDeduction;
   }

   public MesBehaviorTotalScore setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBehaviorTotalScore setYear(final Integer year) {
      this.year = year;
      return this;
   }

   public MesBehaviorTotalScore setTotalScore(final Integer totalScore) {
      this.totalScore = totalScore;
      return this;
   }

   public MesBehaviorTotalScore setBoolDeduction(final Boolean boolDeduction) {
      this.boolDeduction = boolDeduction;
      return this;
   }

   @Override
   public String toString() {
      return "MesBehaviorTotalScore(id="
         + this.getId()
         + ", year="
         + this.getYear()
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

      if (!(o instanceof MesBehaviorTotalScore)) {
         return false;
      }

      MesBehaviorTotalScore other = (MesBehaviorTotalScore)o;
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBehaviorTotalScore;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $totalScore = this.getTotalScore();
      result = result * 59 + ($totalScore == null ? 43 : $totalScore.hashCode());
      Object $boolDeduction = this.getBoolDeduction();
      return result * 59 + ($boolDeduction == null ? 43 : $boolDeduction.hashCode());
   }

   public static class MesBehaviorTotalScoreBuilder {
      private Long id;
      private Integer year;
      private Integer totalScore;
      private Boolean boolDeduction;

      MesBehaviorTotalScoreBuilder() {
      }

      public MesBehaviorTotalScore.MesBehaviorTotalScoreBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBehaviorTotalScore.MesBehaviorTotalScoreBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public MesBehaviorTotalScore.MesBehaviorTotalScoreBuilder totalScore(final Integer totalScore) {
         this.totalScore = totalScore;
         return this;
      }

      public MesBehaviorTotalScore.MesBehaviorTotalScoreBuilder boolDeduction(final Boolean boolDeduction) {
         this.boolDeduction = boolDeduction;
         return this;
      }

      public MesBehaviorTotalScore build() {
         return new MesBehaviorTotalScore(this.id, this.year, this.totalScore, this.boolDeduction);
      }

      @Override
      public String toString() {
         return "MesBehaviorTotalScore.MesBehaviorTotalScoreBuilder(id="
            + this.id
            + ", year="
            + this.year
            + ", totalScore="
            + this.totalScore
            + ", boolDeduction="
            + this.boolDeduction
            + ")";
      }
   }
}
