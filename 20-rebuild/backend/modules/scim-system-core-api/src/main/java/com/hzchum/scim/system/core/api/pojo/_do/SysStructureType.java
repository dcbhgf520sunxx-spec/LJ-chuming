package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysStructureType对象", description = "项目结构类型表 ")
@Entity
@TableName("sys_structure_type")
@Table(name = "sys_structure_type")
@org.hibernate.annotations.Table(appliesTo = "sys_structure_type", comment = "项目结构类型表 ")
public class SysStructureType extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "类型名称", notes = "类型名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '类型名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢 2桥梁", notes = "项目类型 1建钢 2桥梁")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11)  COMMENT '项目类型 1建钢 2桥梁'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "boolEnableEnum", value = "是否启用 1启用 0禁用 ")
   @TableField("bool_enable_enum")
   @Column(name = "bool_enable_enum", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '是否启用 1启用 0禁用'", nullable = false)
   private Boolean boolEnableEnum;
   @ApiModelProperty(name = "userId", value = "创建人id", notes = "创建人id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long userId;

   public static SysStructureType.SysStructureTypeBuilder builder() {
      return new SysStructureType.SysStructureTypeBuilder();
   }

   public SysStructureType() {
   }

   public SysStructureType(final Long id, final String name, final Integer projectType, final Boolean boolEnableEnum, final Long userId) {
      this.id = id;
      this.name = name;
      this.projectType = projectType;
      this.boolEnableEnum = boolEnableEnum;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Boolean getBoolEnableEnum() {
      return this.boolEnableEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public SysStructureType setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysStructureType setName(final String name) {
      this.name = name;
      return this;
   }

   public SysStructureType setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public SysStructureType setBoolEnableEnum(final Boolean boolEnableEnum) {
      this.boolEnableEnum = boolEnableEnum;
      return this;
   }

   public SysStructureType setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "SysStructureType(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", projectType="
         + this.getProjectType()
         + ", boolEnableEnum="
         + this.getBoolEnableEnum()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureType)) {
         return false;
      }

      SysStructureType other = (SysStructureType)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$boolEnableEnum = this.getBoolEnableEnum();
            Object other$boolEnableEnum = other.getBoolEnableEnum();
            if (this$boolEnableEnum == null ? other$boolEnableEnum == null : this$boolEnableEnum.equals(other$boolEnableEnum)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof SysStructureType;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $boolEnableEnum = this.getBoolEnableEnum();
      result = result * 59 + ($boolEnableEnum == null ? 43 : $boolEnableEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SysStructureTypeBuilder {
      private Long id;
      private String name;
      private Integer projectType;
      private Boolean boolEnableEnum;
      private Long userId;

      SysStructureTypeBuilder() {
      }

      public SysStructureType.SysStructureTypeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysStructureType.SysStructureTypeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysStructureType.SysStructureTypeBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public SysStructureType.SysStructureTypeBuilder boolEnableEnum(final Boolean boolEnableEnum) {
         this.boolEnableEnum = boolEnableEnum;
         return this;
      }

      public SysStructureType.SysStructureTypeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SysStructureType build() {
         return new SysStructureType(this.id, this.name, this.projectType, this.boolEnableEnum, this.userId);
      }

      @Override
      public String toString() {
         return "SysStructureType.SysStructureTypeBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", projectType="
            + this.projectType
            + ", boolEnableEnum="
            + this.boolEnableEnum
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
