package com.hzchum.scim.bid.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeDeserializer;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "招标科目表", description = "")
@TableName("project_subject")
@Table(name = "project_subject")
public class ProjectSubject implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "subjectId", value = "科目id(末级id)")
   @JsonProperty("subjectId")
   @JSONField(name = "subjectId")
   @TableField("subject_id")
   @Column(name = "subject_id")
   private Long subjectId;
   @ApiModelProperty(name = "subjectNames", value = "科目组合名称")
   @JsonProperty("subjectNames")
   @JSONField(name = "subjectNames")
   @TableField("subject_names")
   @Column(name = "subject_names")
   private String subjectNames;
   @ApiModelProperty(name = "unitName", value = "单位名称(默认末级单位)")
   @JsonProperty("unitName")
   @JSONField(name = "unitName")
   @TableField("unit_name")
   @Column(name = "unit_name")
   private String unitName;
   @ApiModelProperty(name = "projectId", value = "招标项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "modelNumber", value = "型号")
   @JsonProperty("modelNumber")
   @JSONField(name = "modelNumber")
   @TableField("model_number")
   @Column(name = "model_number")
   private String modelNumber;
   @ApiModelProperty(name = "mete", value = "采购量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete")
   private Double mete;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "status", value = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int default 0")
   private Integer status;
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT)
   @Column
   @JsonInclude(Include.NON_NULL)
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime createTime;
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT_UPDATE)
   @Column
   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime updateTime;
   @ApiModelProperty(hidden = true)
   @Version
   @Column
   @JsonIgnore
   private Integer version;

   public static ProjectSubject.ProjectSubjectBuilder builder() {
      return new ProjectSubject.ProjectSubjectBuilder();
   }

   public ProjectSubject() {
   }

   public ProjectSubject(
      final Long id,
      final Long subjectId,
      final String subjectNames,
      final String unitName,
      final Long projectId,
      final String specification,
      final String modelNumber,
      final Double mete,
      final String remark,
      final Integer status,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer version
   ) {
      this.id = id;
      this.subjectId = subjectId;
      this.subjectNames = subjectNames;
      this.unitName = unitName;
      this.projectId = projectId;
      this.specification = specification;
      this.modelNumber = modelNumber;
      this.mete = mete;
      this.remark = remark;
      this.status = status;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.version = version;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSubjectId() {
      return this.subjectId;
   }

   public String getSubjectNames() {
      return this.subjectNames;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getModelNumber() {
      return this.modelNumber;
   }

   public Double getMete() {
      return this.mete;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getStatus() {
      return this.status;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public Integer getVersion() {
      return this.version;
   }

   @JsonProperty("id")
   public ProjectSubject setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("subjectId")
   public ProjectSubject setSubjectId(final Long subjectId) {
      this.subjectId = subjectId;
      return this;
   }

   @JsonProperty("subjectNames")
   public ProjectSubject setSubjectNames(final String subjectNames) {
      this.subjectNames = subjectNames;
      return this;
   }

   @JsonProperty("unitName")
   public ProjectSubject setUnitName(final String unitName) {
      this.unitName = unitName;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectSubject setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("specification")
   public ProjectSubject setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("modelNumber")
   public ProjectSubject setModelNumber(final String modelNumber) {
      this.modelNumber = modelNumber;
      return this;
   }

   @JsonProperty("mete")
   public ProjectSubject setMete(final Double mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("remark")
   public ProjectSubject setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("status")
   public ProjectSubject setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public ProjectSubject setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public ProjectSubject setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   @JsonIgnore
   public ProjectSubject setVersion(final Integer version) {
      this.version = version;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSubject)) {
         return false;
      }

      ProjectSubject other = (ProjectSubject)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$subjectId = this.getSubjectId();
         Object other$subjectId = other.getSubjectId();
         if (this$subjectId == null ? other$subjectId == null : this$subjectId.equals(other$subjectId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$version = this.getVersion();
                     Object other$version = other.getVersion();
                     if (this$version == null ? other$version == null : this$version.equals(other$version)) {
                        Object this$subjectNames = this.getSubjectNames();
                        Object other$subjectNames = other.getSubjectNames();
                        if (this$subjectNames == null ? other$subjectNames == null : this$subjectNames.equals(other$subjectNames)) {
                           Object this$unitName = this.getUnitName();
                           Object other$unitName = other.getUnitName();
                           if (this$unitName == null ? other$unitName == null : this$unitName.equals(other$unitName)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$modelNumber = this.getModelNumber();
                                 Object other$modelNumber = other.getModelNumber();
                                 if (this$modelNumber == null ? other$modelNumber == null : this$modelNumber.equals(other$modelNumber)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$createTime = this.getCreateTime();
                                       Object other$createTime = other.getCreateTime();
                                       if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                          Object this$updateTime = this.getUpdateTime();
                                          Object other$updateTime = other.getUpdateTime();
                                          return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof ProjectSubject;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $subjectId = this.getSubjectId();
      result = result * 59 + ($subjectId == null ? 43 : $subjectId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $subjectNames = this.getSubjectNames();
      result = result * 59 + ($subjectNames == null ? 43 : $subjectNames.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $modelNumber = this.getModelNumber();
      result = result * 59 + ($modelNumber == null ? 43 : $modelNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSubject(id="
         + this.getId()
         + ", subjectId="
         + this.getSubjectId()
         + ", subjectNames="
         + this.getSubjectNames()
         + ", unitName="
         + this.getUnitName()
         + ", projectId="
         + this.getProjectId()
         + ", specification="
         + this.getSpecification()
         + ", modelNumber="
         + this.getModelNumber()
         + ", mete="
         + this.getMete()
         + ", remark="
         + this.getRemark()
         + ", status="
         + this.getStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", version="
         + this.getVersion()
         + ")";
   }

   public static class ProjectSubjectBuilder {
      private Long id;
      private Long subjectId;
      private String subjectNames;
      private String unitName;
      private Long projectId;
      private String specification;
      private String modelNumber;
      private Double mete;
      private String remark;
      private Integer status;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer version;

      ProjectSubjectBuilder() {
      }

      @JsonProperty("id")
      public ProjectSubject.ProjectSubjectBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("subjectId")
      public ProjectSubject.ProjectSubjectBuilder subjectId(final Long subjectId) {
         this.subjectId = subjectId;
         return this;
      }

      @JsonProperty("subjectNames")
      public ProjectSubject.ProjectSubjectBuilder subjectNames(final String subjectNames) {
         this.subjectNames = subjectNames;
         return this;
      }

      @JsonProperty("unitName")
      public ProjectSubject.ProjectSubjectBuilder unitName(final String unitName) {
         this.unitName = unitName;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectSubject.ProjectSubjectBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("specification")
      public ProjectSubject.ProjectSubjectBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("modelNumber")
      public ProjectSubject.ProjectSubjectBuilder modelNumber(final String modelNumber) {
         this.modelNumber = modelNumber;
         return this;
      }

      @JsonProperty("mete")
      public ProjectSubject.ProjectSubjectBuilder mete(final Double mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("remark")
      public ProjectSubject.ProjectSubjectBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("status")
      public ProjectSubject.ProjectSubjectBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public ProjectSubject.ProjectSubjectBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonIgnore
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public ProjectSubject.ProjectSubjectBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      @JsonIgnore
      public ProjectSubject.ProjectSubjectBuilder version(final Integer version) {
         this.version = version;
         return this;
      }

      public ProjectSubject build() {
         return new ProjectSubject(
            this.id,
            this.subjectId,
            this.subjectNames,
            this.unitName,
            this.projectId,
            this.specification,
            this.modelNumber,
            this.mete,
            this.remark,
            this.status,
            this.createTime,
            this.updateTime,
            this.version
         );
      }

      @Override
      public String toString() {
         return "ProjectSubject.ProjectSubjectBuilder(id="
            + this.id
            + ", subjectId="
            + this.subjectId
            + ", subjectNames="
            + this.subjectNames
            + ", unitName="
            + this.unitName
            + ", projectId="
            + this.projectId
            + ", specification="
            + this.specification
            + ", modelNumber="
            + this.modelNumber
            + ", mete="
            + this.mete
            + ", remark="
            + this.remark
            + ", status="
            + this.status
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", version="
            + this.version
            + ")";
      }
   }
}
