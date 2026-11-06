package com.hzchum.scim.bid.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "招标项目每一轮的科目", description = "")
@TableName("project_subject_round")
@Table(name = "project_subject_round")
public class ProjectSubjectRound implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectSubjectId", value = "招标科目表主键id")
   @JsonProperty("projectSubjectId")
   @JSONField(name = "projectSubjectId")
   @TableField("project_subject_id")
   @Column(name = "project_subject_id")
   private Long projectSubjectId;
   @ApiModelProperty(name = "projectId", value = "招标项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "round", value = "招标轮次")
   @JsonProperty("round")
   @JSONField(name = "round")
   @TableField("round")
   @Column(name = "round")
   private Integer round;

   public static ProjectSubjectRound.ProjectSubjectRoundBuilder builder() {
      return new ProjectSubjectRound.ProjectSubjectRoundBuilder();
   }

   public ProjectSubjectRound() {
   }

   public ProjectSubjectRound(final Long id, final Long projectSubjectId, final Long projectId, final Integer round) {
      this.id = id;
      this.projectSubjectId = projectSubjectId;
      this.projectId = projectId;
      this.round = round;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectSubjectId() {
      return this.projectSubjectId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getRound() {
      return this.round;
   }

   @JsonProperty("id")
   public ProjectSubjectRound setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectSubjectId")
   public ProjectSubjectRound setProjectSubjectId(final Long projectSubjectId) {
      this.projectSubjectId = projectSubjectId;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectSubjectRound setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("round")
   public ProjectSubjectRound setRound(final Integer round) {
      this.round = round;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSubjectRound)) {
         return false;
      }

      ProjectSubjectRound other = (ProjectSubjectRound)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectSubjectId = this.getProjectSubjectId();
         Object other$projectSubjectId = other.getProjectSubjectId();
         if (this$projectSubjectId == null ? other$projectSubjectId == null : this$projectSubjectId.equals(other$projectSubjectId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$round = this.getRound();
               Object other$round = other.getRound();
               return this$round == null ? other$round == null : this$round.equals(other$round);
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
      return other instanceof ProjectSubjectRound;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectSubjectId = this.getProjectSubjectId();
      result = result * 59 + ($projectSubjectId == null ? 43 : $projectSubjectId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $round = this.getRound();
      return result * 59 + ($round == null ? 43 : $round.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSubjectRound(id="
         + this.getId()
         + ", projectSubjectId="
         + this.getProjectSubjectId()
         + ", projectId="
         + this.getProjectId()
         + ", round="
         + this.getRound()
         + ")";
   }

   public static class ProjectSubjectRoundBuilder {
      private Long id;
      private Long projectSubjectId;
      private Long projectId;
      private Integer round;

      ProjectSubjectRoundBuilder() {
      }

      @JsonProperty("id")
      public ProjectSubjectRound.ProjectSubjectRoundBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectSubjectId")
      public ProjectSubjectRound.ProjectSubjectRoundBuilder projectSubjectId(final Long projectSubjectId) {
         this.projectSubjectId = projectSubjectId;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectSubjectRound.ProjectSubjectRoundBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("round")
      public ProjectSubjectRound.ProjectSubjectRoundBuilder round(final Integer round) {
         this.round = round;
         return this;
      }

      public ProjectSubjectRound build() {
         return new ProjectSubjectRound(this.id, this.projectSubjectId, this.projectId, this.round);
      }

      @Override
      public String toString() {
         return "ProjectSubjectRound.ProjectSubjectRoundBuilder(id="
            + this.id
            + ", projectSubjectId="
            + this.projectSubjectId
            + ", projectId="
            + this.projectId
            + ", round="
            + this.round
            + ")";
      }
   }
}
