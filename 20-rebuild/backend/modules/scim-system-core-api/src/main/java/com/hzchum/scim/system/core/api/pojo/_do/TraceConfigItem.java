package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "TraceConfigItem对象", description = "溯源配置明细表")
@Entity
@TableName("trace_config_item")
@Table(name = "trace_config_item")
public class TraceConfigItem extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("明细主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("页面展示序号")
   @JsonProperty("sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) NOT NULL DEFAULT 1 COMMENT '页面展示序号'")
   private Integer sort;
   @ApiModelProperty("字段名称")
   @JsonProperty("fieldName")
   @TableField("field_name")
   @Column(name = "field_name", columnDefinition = "varchar(128) NOT NULL COMMENT '字段名称'")
   private String fieldName;
   @ApiModelProperty("字段值")
   @JsonProperty("fieldValue")
   @TableField("field_value")
   @Column(name = "field_value", columnDefinition = "varchar(512) DEFAULT '' COMMENT '字段值'")
   private String fieldValue;
   @ApiModelProperty("该字段要展示到哪些项目，多个逗号分隔")
   @JsonProperty("displayProject")
   @TableField("display_project")
   @Column(name = "display_project", columnDefinition = "varchar(1024) DEFAULT '' COMMENT '该字段要展示到哪些项目，多个逗号分隔'")
   private String displayProject;
   @ApiModelProperty("是否启用 0否 1是")
   @JsonProperty("enableFlag")
   @TableField("enable_flag")
   @Column(name = "enable_flag", columnDefinition = "tinyint(1) DEFAULT 1 COMMENT '是否启用 0否 1是'")
   private Integer enableFlag;

   public static TraceConfigItem.TraceConfigItemBuilder builder() {
      return new TraceConfigItem.TraceConfigItemBuilder();
   }

   public TraceConfigItem() {
   }

   public TraceConfigItem(
      final Long id, final Integer sort, final String fieldName, final String fieldValue, final String displayProject, final Integer enableFlag
   ) {
      this.id = id;
      this.sort = sort;
      this.fieldName = fieldName;
      this.fieldValue = fieldValue;
      this.displayProject = displayProject;
      this.enableFlag = enableFlag;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getFieldName() {
      return this.fieldName;
   }

   public String getFieldValue() {
      return this.fieldValue;
   }

   public String getDisplayProject() {
      return this.displayProject;
   }

   public Integer getEnableFlag() {
      return this.enableFlag;
   }

   public TraceConfigItem setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("sort")
   public TraceConfigItem setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("fieldName")
   public TraceConfigItem setFieldName(final String fieldName) {
      this.fieldName = fieldName;
      return this;
   }

   @JsonProperty("fieldValue")
   public TraceConfigItem setFieldValue(final String fieldValue) {
      this.fieldValue = fieldValue;
      return this;
   }

   @JsonProperty("displayProject")
   public TraceConfigItem setDisplayProject(final String displayProject) {
      this.displayProject = displayProject;
      return this;
   }

   @JsonProperty("enableFlag")
   public TraceConfigItem setEnableFlag(final Integer enableFlag) {
      this.enableFlag = enableFlag;
      return this;
   }

   @Override
   public String toString() {
      return "TraceConfigItem(id="
         + this.getId()
         + ", sort="
         + this.getSort()
         + ", fieldName="
         + this.getFieldName()
         + ", fieldValue="
         + this.getFieldValue()
         + ", displayProject="
         + this.getDisplayProject()
         + ", enableFlag="
         + this.getEnableFlag()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TraceConfigItem)) {
         return false;
      }

      TraceConfigItem other = (TraceConfigItem)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$enableFlag = this.getEnableFlag();
            Object other$enableFlag = other.getEnableFlag();
            if (this$enableFlag == null ? other$enableFlag == null : this$enableFlag.equals(other$enableFlag)) {
               Object this$fieldName = this.getFieldName();
               Object other$fieldName = other.getFieldName();
               if (this$fieldName == null ? other$fieldName == null : this$fieldName.equals(other$fieldName)) {
                  Object this$fieldValue = this.getFieldValue();
                  Object other$fieldValue = other.getFieldValue();
                  if (this$fieldValue == null ? other$fieldValue == null : this$fieldValue.equals(other$fieldValue)) {
                     Object this$displayProject = this.getDisplayProject();
                     Object other$displayProject = other.getDisplayProject();
                     return this$displayProject == null ? other$displayProject == null : this$displayProject.equals(other$displayProject);
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
      return other instanceof TraceConfigItem;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enableFlag = this.getEnableFlag();
      result = result * 59 + ($enableFlag == null ? 43 : $enableFlag.hashCode());
      Object $fieldName = this.getFieldName();
      result = result * 59 + ($fieldName == null ? 43 : $fieldName.hashCode());
      Object $fieldValue = this.getFieldValue();
      result = result * 59 + ($fieldValue == null ? 43 : $fieldValue.hashCode());
      Object $displayProject = this.getDisplayProject();
      return result * 59 + ($displayProject == null ? 43 : $displayProject.hashCode());
   }

   public static class TraceConfigItemBuilder {
      private Long id;
      private Integer sort;
      private String fieldName;
      private String fieldValue;
      private String displayProject;
      private Integer enableFlag;

      TraceConfigItemBuilder() {
      }

      public TraceConfigItem.TraceConfigItemBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("sort")
      public TraceConfigItem.TraceConfigItemBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("fieldName")
      public TraceConfigItem.TraceConfigItemBuilder fieldName(final String fieldName) {
         this.fieldName = fieldName;
         return this;
      }

      @JsonProperty("fieldValue")
      public TraceConfigItem.TraceConfigItemBuilder fieldValue(final String fieldValue) {
         this.fieldValue = fieldValue;
         return this;
      }

      @JsonProperty("displayProject")
      public TraceConfigItem.TraceConfigItemBuilder displayProject(final String displayProject) {
         this.displayProject = displayProject;
         return this;
      }

      @JsonProperty("enableFlag")
      public TraceConfigItem.TraceConfigItemBuilder enableFlag(final Integer enableFlag) {
         this.enableFlag = enableFlag;
         return this;
      }

      public TraceConfigItem build() {
         return new TraceConfigItem(this.id, this.sort, this.fieldName, this.fieldValue, this.displayProject, this.enableFlag);
      }

      @Override
      public String toString() {
         return "TraceConfigItem.TraceConfigItemBuilder(id="
            + this.id
            + ", sort="
            + this.sort
            + ", fieldName="
            + this.fieldName
            + ", fieldValue="
            + this.fieldValue
            + ", displayProject="
            + this.displayProject
            + ", enableFlag="
            + this.enableFlag
            + ")";
      }
   }
}
