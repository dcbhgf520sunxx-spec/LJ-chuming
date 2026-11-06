package com.hzchum.scim.project.core.api.pojo._do;

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

@ApiModel(value = "ProjectQhseProblemType对象", description = "质安问题类型表 ")
@Entity
@TableName("project_qhse_problem_type")
@Table(name = "project_qhse_problem_type")
@org.hibernate.annotations.Table(appliesTo = "project_qhse_problem_type", comment = "质安问题类型表 ")
public class ProjectQhseProblemType extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "类型名称", notes = "类型名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(128)  COMMENT '类型名称'", nullable = false)
   private String name;

   public static ProjectQhseProblemType.ProjectQhseProblemTypeBuilder builder() {
      return new ProjectQhseProblemType.ProjectQhseProblemTypeBuilder();
   }

   public ProjectQhseProblemType() {
   }

   public ProjectQhseProblemType(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public ProjectQhseProblemType setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProjectQhseProblemType setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectQhseProblemType(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectQhseProblemType)) {
         return false;
      } else {
         ProjectQhseProblemType other = (ProjectQhseProblemType)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectQhseProblemType;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ProjectQhseProblemTypeBuilder {
      private Long id;
      private String name;

      ProjectQhseProblemTypeBuilder() {
      }

      @JsonProperty("id")
      public ProjectQhseProblemType.ProjectQhseProblemTypeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProjectQhseProblemType.ProjectQhseProblemTypeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectQhseProblemType build() {
         return new ProjectQhseProblemType(this.id, this.name);
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemType.ProjectQhseProblemTypeBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
