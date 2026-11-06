package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysAssembleClassifyLinkChange对象", description = "部件物料分类关联变更表")
@Entity
@TableName("sys_assemble_classify_link_change")
@Table(name = "sys_assemble_classify_link_change")
public class SysAssembleClassifyLinkChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "assembleConfigId", value = "部件配置表Id", notes = "部件配置表Id")
   @JsonProperty("assembleConfigId")
   @JSONField(name = "assembleConfigId")
   @TableField("assemble_config_id")
   @Column(name = "assemble_config_id", columnDefinition = "bigint(20)  COMMENT '部件配置表Id'", nullable = false)
   private Long assembleConfigId;
   @ApiModelProperty(name = "assembleConfigChangeId", value = "部件配置变更表id", notes = "部件配置变更表id")
   @JsonProperty("assembleConfigChangeId")
   @JSONField(name = "assembleConfigChangeId")
   @TableField("assemble_config_change_id")
   @Column(name = "assemble_config_change_id", columnDefinition = "bigint(20)  COMMENT '部件配置变更表id'", nullable = true)
   private Long assembleConfigChangeId;
   @ApiModelProperty(name = "classifyId", value = "物料分类id", notes = "物料分类id")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint(20)  COMMENT '物料分类id'", nullable = false)
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "物料分类名称", notes = "物料分类名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(128)  COMMENT '物料分类名称'", nullable = false)
   private String classifyName;
   @ApiModelProperty(name = "path", value = "路径", notes = "路径")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField("path")
   @Column(name = "path", columnDefinition = "varchar(128)  COMMENT '路径'", nullable = false)
   private String path;

   public static SysAssembleClassifyLinkChange.SysAssembleClassifyLinkChangeBuilder builder() {
      return new SysAssembleClassifyLinkChange.SysAssembleClassifyLinkChangeBuilder();
   }

   public SysAssembleClassifyLinkChange() {
   }

   public SysAssembleClassifyLinkChange(
      final Long id, final Long assembleConfigId, final Long assembleConfigChangeId, final Long classifyId, final String classifyName, final String path
   ) {
      this.id = id;
      this.assembleConfigId = assembleConfigId;
      this.assembleConfigChangeId = assembleConfigChangeId;
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

   public Long getAssembleConfigChangeId() {
      return this.assembleConfigChangeId;
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

   @JsonProperty("id")
   public SysAssembleClassifyLinkChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("assembleConfigId")
   public SysAssembleClassifyLinkChange setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
      return this;
   }

   @JsonProperty("assembleConfigChangeId")
   public SysAssembleClassifyLinkChange setAssembleConfigChangeId(final Long assembleConfigChangeId) {
      this.assembleConfigChangeId = assembleConfigChangeId;
      return this;
   }

   @JsonProperty("classifyId")
   public SysAssembleClassifyLinkChange setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public SysAssembleClassifyLinkChange setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("path")
   public SysAssembleClassifyLinkChange setPath(final String path) {
      this.path = path;
      return this;
   }

   @Override
   public String toString() {
      return "SysAssembleClassifyLinkChange(id="
         + this.getId()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", assembleConfigChangeId="
         + this.getAssembleConfigChangeId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", path="
         + this.getPath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAssembleClassifyLinkChange)) {
         return false;
      }

      SysAssembleClassifyLinkChange other = (SysAssembleClassifyLinkChange)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleConfigId = this.getAssembleConfigId();
         Object other$assembleConfigId = other.getAssembleConfigId();
         if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
            Object this$assembleConfigChangeId = this.getAssembleConfigChangeId();
            Object other$assembleConfigChangeId = other.getAssembleConfigChangeId();
            if (this$assembleConfigChangeId == null ? other$assembleConfigChangeId == null : this$assembleConfigChangeId.equals(other$assembleConfigChangeId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysAssembleClassifyLinkChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $assembleConfigChangeId = this.getAssembleConfigChangeId();
      result = result * 59 + ($assembleConfigChangeId == null ? 43 : $assembleConfigChangeId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $path = this.getPath();
      return result * 59 + ($path == null ? 43 : $path.hashCode());
   }

   public static class SysAssembleClassifyLinkChangeBuilder {
      private Long id;
      private Long assembleConfigId;
      private Long assembleConfigChangeId;
      private Long classifyId;
      private String classifyName;
      private String path;

      SysAssembleClassifyLinkChangeBuilder() {
      }

      @JsonProperty("id")
      public SysAssembleClassifyLinkChange.SysAssembleClassifyLinkChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("assembleConfigId")
      public SysAssembleClassifyLinkChange.SysAssembleClassifyLinkChangeBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      @JsonProperty("assembleConfigChangeId")
      public SysAssembleClassifyLinkChange.SysAssembleClassifyLinkChangeBuilder assembleConfigChangeId(final Long assembleConfigChangeId) {
         this.assembleConfigChangeId = assembleConfigChangeId;
         return this;
      }

      @JsonProperty("classifyId")
      public SysAssembleClassifyLinkChange.SysAssembleClassifyLinkChangeBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public SysAssembleClassifyLinkChange.SysAssembleClassifyLinkChangeBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("path")
      public SysAssembleClassifyLinkChange.SysAssembleClassifyLinkChangeBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public SysAssembleClassifyLinkChange build() {
         return new SysAssembleClassifyLinkChange(this.id, this.assembleConfigId, this.assembleConfigChangeId, this.classifyId, this.classifyName, this.path);
      }

      @Override
      public String toString() {
         return "SysAssembleClassifyLinkChange.SysAssembleClassifyLinkChangeBuilder(id="
            + this.id
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", assembleConfigChangeId="
            + this.assembleConfigChangeId
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
