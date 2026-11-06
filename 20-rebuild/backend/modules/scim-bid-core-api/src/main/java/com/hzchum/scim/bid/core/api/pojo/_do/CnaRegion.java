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

@ApiModel(value = "行政地区表", description = "")
@TableName("cna_region")
@Table(name = "cna_region")
public class CnaRegion implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "pid", value = "父id")
   @JsonProperty("pid")
   @JSONField(name = "pid")
   @TableField("pid")
   @Column(name = "pid")
   private Long pid;
   @ApiModelProperty(name = "name", value = "地区名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "code", value = "地区代号")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code")
   private String code;
   @ApiModelProperty(name = "level", value = "层级(顶级为1)")
   @JsonProperty("level")
   @JSONField(name = "level")
   @TableField("level")
   @Column(name = "level")
   private Integer level;
   @ApiModelProperty(name = "path", value = "地区路径")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField("path")
   @Column(name = "path")
   private String path;

   public static CnaRegion.CnaRegionBuilder builder() {
      return new CnaRegion.CnaRegionBuilder();
   }

   public CnaRegion() {
   }

   public CnaRegion(final Long id, final Long pid, final String name, final String code, final Integer level, final String path) {
      this.id = id;
      this.pid = pid;
      this.name = name;
      this.code = code;
      this.level = level;
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

   public String getCode() {
      return this.code;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getPath() {
      return this.path;
   }

   @JsonProperty("id")
   public CnaRegion setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("pid")
   public CnaRegion setPid(final Long pid) {
      this.pid = pid;
      return this;
   }

   @JsonProperty("name")
   public CnaRegion setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("code")
   public CnaRegion setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("level")
   public CnaRegion setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   @JsonProperty("path")
   public CnaRegion setPath(final String path) {
      this.path = path;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CnaRegion)) {
         return false;
      }

      CnaRegion other = (CnaRegion)o;
      if (!other.canEqual(this)) {
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
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$code = this.getCode();
                  Object other$code = other.getCode();
                  if (this$code == null ? other$code == null : this$code.equals(other$code)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CnaRegion;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $path = this.getPath();
      return result * 59 + ($path == null ? 43 : $path.hashCode());
   }

   @Override
   public String toString() {
      return "CnaRegion(id="
         + this.getId()
         + ", pid="
         + this.getPid()
         + ", name="
         + this.getName()
         + ", code="
         + this.getCode()
         + ", level="
         + this.getLevel()
         + ", path="
         + this.getPath()
         + ")";
   }

   public static class CnaRegionBuilder {
      private Long id;
      private Long pid;
      private String name;
      private String code;
      private Integer level;
      private String path;

      CnaRegionBuilder() {
      }

      @JsonProperty("id")
      public CnaRegion.CnaRegionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("pid")
      public CnaRegion.CnaRegionBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      @JsonProperty("name")
      public CnaRegion.CnaRegionBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("code")
      public CnaRegion.CnaRegionBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("level")
      public CnaRegion.CnaRegionBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      @JsonProperty("path")
      public CnaRegion.CnaRegionBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public CnaRegion build() {
         return new CnaRegion(this.id, this.pid, this.name, this.code, this.level, this.path);
      }

      @Override
      public String toString() {
         return "CnaRegion.CnaRegionBuilder(id="
            + this.id
            + ", pid="
            + this.pid
            + ", name="
            + this.name
            + ", code="
            + this.code
            + ", level="
            + this.level
            + ", path="
            + this.path
            + ")";
      }
   }
}
