package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "Classification对象", description = "物料分类")
@Entity
@TableName("wms_classification")
@Table(name = "wms_classification")
public class Classification extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "基础物料类型,针对一级科目", notes = "基础物料类型,针对一级科目")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础物料类型,针对一级科目'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "name", value = "科目名称", notes = "科目名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '科目名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "boolLastEnum", value = "是否为末级[0否,1是],默认为末级", notes = "是否为末级[0否,1是],默认为末级")
   @JsonProperty("boolLastEnum")
   @JSONField(name = "boolLastEnum")
   @TableField("bool_last_enum")
   @Column(name = "bool_last_enum", columnDefinition = "tinyint(1) default '1' COMMENT '是否为末级[0否,1是],默认为末级'", nullable = true)
   private Boolean boolLastEnum;
   @ApiModelProperty(name = "parentId", value = "父级ID", notes = "父级ID")
   @JsonProperty("parentId")
   @JSONField(name = "parentId")
   @TableField("parent_id")
   @Column(name = "parent_id", columnDefinition = "bigint  COMMENT '父级ID'", nullable = true)
   private Long parentId;
   @ApiModelProperty(name = "code", value = "代码", notes = "代码")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code", columnDefinition = "varchar(128)  COMMENT '代码'", nullable = true)
   private String code;
   @ApiModelProperty(name = "level", value = "当前科目层级", notes = "当前科目层级")
   @JsonProperty("level")
   @JSONField(name = "level")
   @TableField("level")
   @Column(name = "level", columnDefinition = "int  COMMENT '当前科目层级'", nullable = true)
   private Integer level;
   @ApiModelProperty(name = "path", value = "科目全路径,包含当前", notes = "科目全路径,包含当前")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField("path")
   @Column(name = "path", columnDefinition = "varchar(64)  COMMENT '科目全路径,包含当前'", nullable = true)
   private String path;
   @ApiModelProperty(name = "serialNumber", value = "科目编号,层级代码拼接", notes = "科目编号,层级代码拼接")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(128)  COMMENT '科目编号,层级代码拼接'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "classifyUpdateStatus", notes = "该科目的修改状态 1都可以修改 2只可以修改名称 3都不可以修改 默认为1 ClassifyUpdateStatusEnum")
   @JsonProperty("classifyUpdateStatus")
   @JSONField(name = "classifyUpdateStatus")
   @TableField("classify_update_status")
   @Column(
      name = "classify_update_status",
      columnDefinition = "tinyint(1) DEFAULT '1'  COMMENT '该科目的修改状态 1都可以修改 2只可以修改名称 3都不可以修改 默认为1都可以修改 ClassifyUpdateStatusEnum'",
      nullable = true
   )
   private Integer classifyUpdateStatus;
   @ApiModelProperty(name = "boolStatus", notes = "启用状态 1启用 0禁用 默认为1  EnableEnum")
   @JsonProperty("boolStatus")
   @JSONField(name = "boolStatus")
   @TableField("bool_status")
   @Column(name = "bool_status", columnDefinition = "tinyint(1) DEFAULT '1'  COMMENT '启用状态 1启用 0禁用 默认为1  EnableEnum'", nullable = true)
   private Boolean boolStatus;
   @ApiModelProperty(name = "userUpdateTime", value = "用户编辑时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time", columnDefinition = "datetime(6) COMMENT '用户编辑时间'")
   private LocalDateTime userUpdateTime;

   public static Classification.ClassificationBuilder builder() {
      return new Classification.ClassificationBuilder();
   }

   public Classification() {
   }

   public Classification(
      final Long id,
      final Integer basicClass,
      final String name,
      final Boolean boolLastEnum,
      final Long parentId,
      final String code,
      final Integer level,
      final String path,
      final String serialNumber,
      final Integer classifyUpdateStatus,
      final Boolean boolStatus,
      final LocalDateTime userUpdateTime
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.name = name;
      this.boolLastEnum = boolLastEnum;
      this.parentId = parentId;
      this.code = code;
      this.level = level;
      this.path = path;
      this.serialNumber = serialNumber;
      this.classifyUpdateStatus = classifyUpdateStatus;
      this.boolStatus = boolStatus;
      this.userUpdateTime = userUpdateTime;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolLastEnum() {
      return this.boolLastEnum;
   }

   public Long getParentId() {
      return this.parentId;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getClassifyUpdateStatus() {
      return this.classifyUpdateStatus;
   }

   public Boolean getBoolStatus() {
      return this.boolStatus;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   @JsonProperty("id")
   public Classification setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public Classification setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("name")
   public Classification setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("boolLastEnum")
   public Classification setBoolLastEnum(final Boolean boolLastEnum) {
      this.boolLastEnum = boolLastEnum;
      return this;
   }

   @JsonProperty("parentId")
   public Classification setParentId(final Long parentId) {
      this.parentId = parentId;
      return this;
   }

   @JsonProperty("code")
   public Classification setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("level")
   public Classification setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   @JsonProperty("path")
   public Classification setPath(final String path) {
      this.path = path;
      return this;
   }

   @JsonProperty("serialNumber")
   public Classification setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("classifyUpdateStatus")
   public Classification setClassifyUpdateStatus(final Integer classifyUpdateStatus) {
      this.classifyUpdateStatus = classifyUpdateStatus;
      return this;
   }

   @JsonProperty("boolStatus")
   public Classification setBoolStatus(final Boolean boolStatus) {
      this.boolStatus = boolStatus;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public Classification setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @Override
   public String toString() {
      return "Classification(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", name="
         + this.getName()
         + ", boolLastEnum="
         + this.getBoolLastEnum()
         + ", parentId="
         + this.getParentId()
         + ", code="
         + this.getCode()
         + ", level="
         + this.getLevel()
         + ", path="
         + this.getPath()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyUpdateStatus="
         + this.getClassifyUpdateStatus()
         + ", boolStatus="
         + this.getBoolStatus()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Classification)) {
         return false;
      }

      Classification other = (Classification)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$boolLastEnum = this.getBoolLastEnum();
            Object other$boolLastEnum = other.getBoolLastEnum();
            if (this$boolLastEnum == null ? other$boolLastEnum == null : this$boolLastEnum.equals(other$boolLastEnum)) {
               Object this$parentId = this.getParentId();
               Object other$parentId = other.getParentId();
               if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
                  Object this$level = this.getLevel();
                  Object other$level = other.getLevel();
                  if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                     Object this$classifyUpdateStatus = this.getClassifyUpdateStatus();
                     Object other$classifyUpdateStatus = other.getClassifyUpdateStatus();
                     if (this$classifyUpdateStatus == null ? other$classifyUpdateStatus == null : this$classifyUpdateStatus.equals(other$classifyUpdateStatus)) {
                        Object this$boolStatus = this.getBoolStatus();
                        Object other$boolStatus = other.getBoolStatus();
                        if (this$boolStatus == null ? other$boolStatus == null : this$boolStatus.equals(other$boolStatus)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$code = this.getCode();
                              Object other$code = other.getCode();
                              if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                                 Object this$path = this.getPath();
                                 Object other$path = other.getPath();
                                 if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$userUpdateTime = this.getUserUpdateTime();
                                       Object other$userUpdateTime = other.getUserUpdateTime();
                                       return this$userUpdateTime == null ? other$userUpdateTime == null : this$userUpdateTime.equals(other$userUpdateTime);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof Classification;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolLastEnum = this.getBoolLastEnum();
      result = result * 59 + ($boolLastEnum == null ? 43 : $boolLastEnum.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $classifyUpdateStatus = this.getClassifyUpdateStatus();
      result = result * 59 + ($classifyUpdateStatus == null ? 43 : $classifyUpdateStatus.hashCode());
      Object $boolStatus = this.getBoolStatus();
      result = result * 59 + ($boolStatus == null ? 43 : $boolStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      return result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
   }

   public static class ClassificationBuilder {
      private Long id;
      private Integer basicClass;
      private String name;
      private Boolean boolLastEnum;
      private Long parentId;
      private String code;
      private Integer level;
      private String path;
      private String serialNumber;
      private Integer classifyUpdateStatus;
      private Boolean boolStatus;
      private LocalDateTime userUpdateTime;

      ClassificationBuilder() {
      }

      @JsonProperty("id")
      public Classification.ClassificationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public Classification.ClassificationBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("name")
      public Classification.ClassificationBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("boolLastEnum")
      public Classification.ClassificationBuilder boolLastEnum(final Boolean boolLastEnum) {
         this.boolLastEnum = boolLastEnum;
         return this;
      }

      @JsonProperty("parentId")
      public Classification.ClassificationBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      @JsonProperty("code")
      public Classification.ClassificationBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("level")
      public Classification.ClassificationBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      @JsonProperty("path")
      public Classification.ClassificationBuilder path(final String path) {
         this.path = path;
         return this;
      }

      @JsonProperty("serialNumber")
      public Classification.ClassificationBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("classifyUpdateStatus")
      public Classification.ClassificationBuilder classifyUpdateStatus(final Integer classifyUpdateStatus) {
         this.classifyUpdateStatus = classifyUpdateStatus;
         return this;
      }

      @JsonProperty("boolStatus")
      public Classification.ClassificationBuilder boolStatus(final Boolean boolStatus) {
         this.boolStatus = boolStatus;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public Classification.ClassificationBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public Classification build() {
         return new Classification(
            this.id,
            this.basicClass,
            this.name,
            this.boolLastEnum,
            this.parentId,
            this.code,
            this.level,
            this.path,
            this.serialNumber,
            this.classifyUpdateStatus,
            this.boolStatus,
            this.userUpdateTime
         );
      }

      @Override
      public String toString() {
         return "Classification.ClassificationBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", name="
            + this.name
            + ", boolLastEnum="
            + this.boolLastEnum
            + ", parentId="
            + this.parentId
            + ", code="
            + this.code
            + ", level="
            + this.level
            + ", path="
            + this.path
            + ", serialNumber="
            + this.serialNumber
            + ", classifyUpdateStatus="
            + this.classifyUpdateStatus
            + ", boolStatus="
            + this.boolStatus
            + ", userUpdateTime="
            + this.userUpdateTime
            + ")";
      }
   }
}
