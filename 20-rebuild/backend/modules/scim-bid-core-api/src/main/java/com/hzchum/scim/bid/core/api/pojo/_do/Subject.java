package com.hzchum.scim.bid.core.api.pojo._do;

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "招采-科目", description = "")
@TableName("subject")
@Table(name = "subject")
public class Subject extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "pid", value = "科目父id")
   @JsonProperty("pid")
   @JSONField(name = "pid")
   @TableField("pid")
   @Column(name = "pid")
   private Long pid;
   @ApiModelProperty(name = "name", value = "科目名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "level", value = "层级 顶级为1")
   @JsonProperty("level")
   @JSONField(name = "level")
   @TableField("level")
   @Column(name = "level")
   private Integer level;
   @ApiModelProperty(name = "unitId", value = "单位id")
   @JsonProperty("unitId")
   @JSONField(name = "unitId")
   @TableField("unit_id")
   @Column(name = "unit_id")
   private Long unitId;
   @ApiModelProperty(name = "unitName", value = "单位名称")
   @JsonProperty("unitName")
   @JSONField(name = "unitName")
   @TableField("unit_name")
   @Column(name = "unit_name")
   private String unitName;
   @ApiModelProperty(name = "boolLastEnum", value = "是否为末级科目")
   @JsonProperty("boolLastEnum")
   @JSONField(name = "bool_last_enum")
   @TableField("bool_last_enum")
   @Column(name = "bool_last_enum", columnDefinition = "int default 0")
   private Boolean boolLastEnum;
   @ApiModelProperty(name = "path", value = "科目路径")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField("path")
   @Column(name = "path")
   private String path;

   public static Subject.SubjectBuilder builder() {
      return new Subject.SubjectBuilder();
   }

   public Subject() {
   }

   public Subject(
      final Long id,
      final Long pid,
      final String name,
      final Integer level,
      final Long unitId,
      final String unitName,
      final Boolean boolLastEnum,
      final String path
   ) {
      this.id = id;
      this.pid = pid;
      this.name = name;
      this.level = level;
      this.unitId = unitId;
      this.unitName = unitName;
      this.boolLastEnum = boolLastEnum;
      this.path = path;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPid() {
      return this.pid;
   }

   public String getName() {
      return this.name;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Long getUnitId() {
      return this.unitId;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public Boolean getBoolLastEnum() {
      return this.boolLastEnum;
   }

   public String getPath() {
      return this.path;
   }

   @JsonProperty("id")
   public Subject setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("pid")
   public Subject setPid(final Long pid) {
      this.pid = pid;
      return this;
   }

   @JsonProperty("name")
   public Subject setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("level")
   public Subject setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   @JsonProperty("unitId")
   public Subject setUnitId(final Long unitId) {
      this.unitId = unitId;
      return this;
   }

   @JsonProperty("unitName")
   public Subject setUnitName(final String unitName) {
      this.unitName = unitName;
      return this;
   }

   @JsonProperty("boolLastEnum")
   public Subject setBoolLastEnum(final Boolean boolLastEnum) {
      this.boolLastEnum = boolLastEnum;
      return this;
   }

   @JsonProperty("path")
   public Subject setPath(final String path) {
      this.path = path;
      return this;
   }

   @Override
   public String toString() {
      return "Subject(id="
         + this.getId()
         + ", pid="
         + this.getPid()
         + ", name="
         + this.getName()
         + ", level="
         + this.getLevel()
         + ", unitId="
         + this.getUnitId()
         + ", unitName="
         + this.getUnitName()
         + ", boolLastEnum="
         + this.getBoolLastEnum()
         + ", path="
         + this.getPath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Subject)) {
         return false;
      }

      Subject other = (Subject)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$level = this.getLevel();
            Object other$level = other.getLevel();
            if (this$level == null ? other$level == null : this$level.equals(other$level)) {
               Object this$unitId = this.getUnitId();
               Object other$unitId = other.getUnitId();
               if (this$unitId == null ? other$unitId == null : this$unitId.equals(other$unitId)) {
                  Object this$boolLastEnum = this.getBoolLastEnum();
                  Object other$boolLastEnum = other.getBoolLastEnum();
                  if (this$boolLastEnum == null ? other$boolLastEnum == null : this$boolLastEnum.equals(other$boolLastEnum)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$unitName = this.getUnitName();
                        Object other$unitName = other.getUnitName();
                        if (this$unitName == null ? other$unitName == null : this$unitName.equals(other$unitName)) {
                           Object this$path = this.getPath();
                           Object other$path = other.getPath();
                           return this$path == null ? other$path == null : this$path.equals(other$path);
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
      return other instanceof Subject;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $unitId = this.getUnitId();
      result = result * 59 + ($unitId == null ? 43 : $unitId.hashCode());
      Object $boolLastEnum = this.getBoolLastEnum();
      result = result * 59 + ($boolLastEnum == null ? 43 : $boolLastEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $path = this.getPath();
      return result * 59 + ($path == null ? 43 : $path.hashCode());
   }

   public static class SubjectBuilder {
      private Long id;
      private Long pid;
      private String name;
      private Integer level;
      private Long unitId;
      private String unitName;
      private Boolean boolLastEnum;
      private String path;

      SubjectBuilder() {
      }

      @JsonProperty("id")
      public Subject.SubjectBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("pid")
      public Subject.SubjectBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      @JsonProperty("name")
      public Subject.SubjectBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("level")
      public Subject.SubjectBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      @JsonProperty("unitId")
      public Subject.SubjectBuilder unitId(final Long unitId) {
         this.unitId = unitId;
         return this;
      }

      @JsonProperty("unitName")
      public Subject.SubjectBuilder unitName(final String unitName) {
         this.unitName = unitName;
         return this;
      }

      @JsonProperty("boolLastEnum")
      public Subject.SubjectBuilder boolLastEnum(final Boolean boolLastEnum) {
         this.boolLastEnum = boolLastEnum;
         return this;
      }

      @JsonProperty("path")
      public Subject.SubjectBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public Subject build() {
         return new Subject(this.id, this.pid, this.name, this.level, this.unitId, this.unitName, this.boolLastEnum, this.path);
      }

      @Override
      public String toString() {
         return "Subject.SubjectBuilder(id="
            + this.id
            + ", pid="
            + this.pid
            + ", name="
            + this.name
            + ", level="
            + this.level
            + ", unitId="
            + this.unitId
            + ", unitName="
            + this.unitName
            + ", boolLastEnum="
            + this.boolLastEnum
            + ", path="
            + this.path
            + ")";
      }
   }
}
