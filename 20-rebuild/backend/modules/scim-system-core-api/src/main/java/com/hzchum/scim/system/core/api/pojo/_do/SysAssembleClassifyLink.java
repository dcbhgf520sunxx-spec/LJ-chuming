package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

@ApiModel(description = "部件钢材分类匹配 ")
@Entity
@Table(name = "sys_assemble_classify_link")
public class SysAssembleClassifyLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("部件配置表Id")
   @JsonProperty("assembleConfigId")
   @JSONField(name = "assembleConfigId")
   @TableField("assemble_config_id")
   @Column(name = "assemble_config_id", columnDefinition = "bigint(20)  COMMENT '部件配置表Id'", nullable = false)
   private Long assembleConfigId;
   @ApiModelProperty("物料分类id")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint(20)  COMMENT '物料分类id'", nullable = false)
   private Long classifyId;
   @ApiModelProperty("物料分类名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(128)  COMMENT '物料分类名称'", nullable = false)
   private String classifyName;
   @ApiModelProperty("路径")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField("path")
   @Column(name = "path", columnDefinition = "varchar(128)  COMMENT '路径'", nullable = false)
   private String path;

   public static SysAssembleClassifyLink.SysAssembleClassifyLinkBuilder builder() {
      return new SysAssembleClassifyLink.SysAssembleClassifyLinkBuilder();
   }

   public SysAssembleClassifyLink() {
   }

   public SysAssembleClassifyLink(final Long id, final Long assembleConfigId, final Long classifyId, final String classifyName, final String path) {
      this.id = id;
      this.assembleConfigId = assembleConfigId;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.path = path;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getPath() {
      return this.path;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("assembleConfigId")
   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   @JsonProperty("classifyId")
   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   @JsonProperty("classifyName")
   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   @JsonProperty("path")
   public void setPath(final String path) {
      this.path = path;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAssembleClassifyLink)) {
         return false;
      }

      SysAssembleClassifyLink other = (SysAssembleClassifyLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleConfigId = this.getAssembleConfigId();
         Object other$assembleConfigId = other.getAssembleConfigId();
         if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$classifyName = this.getClassifyName();
               Object other$classifyName = other.getClassifyName();
               if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysAssembleClassifyLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $path = this.getPath();
      return result * 59 + ($path == null ? 43 : $path.hashCode());
   }

   @Override
   public String toString() {
      return "SysAssembleClassifyLink(id="
         + this.getId()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", path="
         + this.getPath()
         + ")";
   }

   public static class SysAssembleClassifyLinkBuilder {
      private Long id;
      private Long assembleConfigId;
      private Long classifyId;
      private String classifyName;
      private String path;

      SysAssembleClassifyLinkBuilder() {
      }

      public SysAssembleClassifyLink.SysAssembleClassifyLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("assembleConfigId")
      public SysAssembleClassifyLink.SysAssembleClassifyLinkBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      @JsonProperty("classifyId")
      public SysAssembleClassifyLink.SysAssembleClassifyLinkBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public SysAssembleClassifyLink.SysAssembleClassifyLinkBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("path")
      public SysAssembleClassifyLink.SysAssembleClassifyLinkBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public SysAssembleClassifyLink build() {
         return new SysAssembleClassifyLink(this.id, this.assembleConfigId, this.classifyId, this.classifyName, this.path);
      }

      @Override
      public String toString() {
         return "SysAssembleClassifyLink.SysAssembleClassifyLinkBuilder(id="
            + this.id
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", path="
            + this.path
            + ")";
      }
   }
}
