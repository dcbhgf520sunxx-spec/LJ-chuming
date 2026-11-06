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

@ApiModel(value = "ProjectAuxiliaryMaterialClass对象", description = "配套件分类配置表 ")
@Entity
@TableName("project_auxiliary_material_class")
@Table(name = "project_auxiliary_material_class")
@org.hibernate.annotations.Table(appliesTo = "project_auxiliary_material_class", comment = "配套件分类配置表 ")
public class ProjectAuxiliaryMaterialClass extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "classifyId", value = "配套件科目ID", notes = "配套件科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint(20)  COMMENT '配套件科目ID'", nullable = false)
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(64)  COMMENT '科目名称'", nullable = false)
   private String classifyName;
   @ApiModelProperty(name = "boolNoReport", value = "是否即入即安 1是 0否", notes = "是否即入即安 1是 0否")
   @JsonProperty("boolNoReport")
   @JSONField(name = "boolNoReport")
   @TableField("bool_no_report")
   @Column(name = "bool_no_report", columnDefinition = "tinyint(1) default '1' COMMENT '是否即入即安 1是 0否'", nullable = false)
   private Boolean boolNoReport;

   public static ProjectAuxiliaryMaterialClass.ProjectAuxiliaryMaterialClassBuilder builder() {
      return new ProjectAuxiliaryMaterialClass.ProjectAuxiliaryMaterialClassBuilder();
   }

   public ProjectAuxiliaryMaterialClass() {
   }

   public ProjectAuxiliaryMaterialClass(final Long id, final Long projectId, final Long classifyId, final String classifyName, final Boolean boolNoReport) {
      this.id = id;
      this.projectId = projectId;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.boolNoReport = boolNoReport;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Boolean getBoolNoReport() {
      return this.boolNoReport;
   }

   @JsonProperty("id")
   public ProjectAuxiliaryMaterialClass setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectAuxiliaryMaterialClass setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("classifyId")
   public ProjectAuxiliaryMaterialClass setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public ProjectAuxiliaryMaterialClass setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("boolNoReport")
   public ProjectAuxiliaryMaterialClass setBoolNoReport(final Boolean boolNoReport) {
      this.boolNoReport = boolNoReport;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectAuxiliaryMaterialClass(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", boolNoReport="
         + this.getBoolNoReport()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAuxiliaryMaterialClass)) {
         return false;
      }

      ProjectAuxiliaryMaterialClass other = (ProjectAuxiliaryMaterialClass)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$boolNoReport = this.getBoolNoReport();
               Object other$boolNoReport = other.getBoolNoReport();
               if (this$boolNoReport == null ? other$boolNoReport == null : this$boolNoReport.equals(other$boolNoReport)) {
                  Object this$classifyName = this.getClassifyName();
                  Object other$classifyName = other.getClassifyName();
                  return this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName);
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
      return other instanceof ProjectAuxiliaryMaterialClass;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolNoReport = this.getBoolNoReport();
      result = result * 59 + ($boolNoReport == null ? 43 : $boolNoReport.hashCode());
      Object $classifyName = this.getClassifyName();
      return result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
   }

   public static class ProjectAuxiliaryMaterialClassBuilder {
      private Long id;
      private Long projectId;
      private Long classifyId;
      private String classifyName;
      private Boolean boolNoReport;

      ProjectAuxiliaryMaterialClassBuilder() {
      }

      @JsonProperty("id")
      public ProjectAuxiliaryMaterialClass.ProjectAuxiliaryMaterialClassBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectAuxiliaryMaterialClass.ProjectAuxiliaryMaterialClassBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("classifyId")
      public ProjectAuxiliaryMaterialClass.ProjectAuxiliaryMaterialClassBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public ProjectAuxiliaryMaterialClass.ProjectAuxiliaryMaterialClassBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("boolNoReport")
      public ProjectAuxiliaryMaterialClass.ProjectAuxiliaryMaterialClassBuilder boolNoReport(final Boolean boolNoReport) {
         this.boolNoReport = boolNoReport;
         return this;
      }

      public ProjectAuxiliaryMaterialClass build() {
         return new ProjectAuxiliaryMaterialClass(this.id, this.projectId, this.classifyId, this.classifyName, this.boolNoReport);
      }

      @Override
      public String toString() {
         return "ProjectAuxiliaryMaterialClass.ProjectAuxiliaryMaterialClassBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", boolNoReport="
            + this.boolNoReport
            + ")";
      }
   }
}
