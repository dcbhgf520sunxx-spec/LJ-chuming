package com.hzchum.scim.crm.core.api.pojo._do;

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

@ApiModel(value = "CrmPageManagementConfig对象", description = "页面样式配置")
@Entity
@TableName("crm_page_management_config")
@Table(name = "crm_page_management_config")
@org.hibernate.annotations.Table(appliesTo = "crm_page_management_config")
public class CrmPageManagementConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "fieldName", value = "字段名称", notes = "字段名称")
   @TableField("field_name")
   @Column(name = "field_name", columnDefinition = "varchar(255)  COMMENT '字段名称'", nullable = false)
   private String fieldName;
   @ApiModelProperty(name = "argumentName", value = "参数名称", notes = "参数名称")
   @TableField("argument_name")
   @Column(name = "argument_name", columnDefinition = "varchar(255)  COMMENT '参数名称'", nullable = false)
   private String argumentName;
   @ApiModelProperty(name = "argumentShowName", value = "参数展示名称", notes = "参数展示名称")
   @TableField("argument_show_name")
   @Column(name = "argument_show_name", columnDefinition = "varchar(255)  COMMENT '参数展示名称'", nullable = false)
   private String argumentShowName;
   @ApiModelProperty(name = "isShow", value = "是否展示", notes = "是否展示")
   @TableField("is_show")
   @Column(name = "is_show", columnDefinition = "tinyint(1) default '0' COMMENT '是否展示'", nullable = false)
   private Boolean isShow;
   @ApiModelProperty(name = "isWrite", value = "是否必填", notes = "是否必填")
   @TableField("is_write")
   @Column(name = "is_write", columnDefinition = "tinyint(1) default '0' COMMENT '是否必填'", nullable = false)
   private Boolean isWrite;
   @ApiModelProperty(name = "crmFieldParentTypeEnum", value = "上级字段枚举（CrmFieldParentTypeEnum）", notes = "上级字段枚举（CrmFieldParentTypeEnum）")
   @TableField("crm_field_parent_type_enum")
   @Column(name = "crm_field_parent_type_enum", columnDefinition = "int(11)  COMMENT '上级字段枚举（CrmFieldParentTypeEnum）'", nullable = true)
   private Integer crmFieldParentTypeEnum;
   @ApiModelProperty(
      name = "crmPageManagementConfigEnum",
      value = "页面配置tab类型枚举（CrmPageManagementConfigEnum）",
      notes = "页面配置tab类型枚举（CrmPageManagementConfigEnum）"
   )
   @TableField("crm_page_management_config_enum")
   @Column(name = "crm_page_management_config_enum", columnDefinition = "int(11)  COMMENT '页面配置tab类型枚举（CrmPageManagementConfigEnum）'", nullable = false)
   private Integer crmPageManagementConfigEnum;
   @ApiModelProperty(name = "crmCountryTypeEnum", value = "国家类型枚举（CrmCountryTypeEnum）", notes = "国家类型枚举（CrmCountryTypeEnum）")
   @TableField("crm_country_type_enum")
   @Column(name = "crm_country_type_enum", columnDefinition = "int(11)  COMMENT '国家类型枚举（CrmCountryTypeEnum）'", nullable = true)
   private Integer crmCountryTypeEnum;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = false)
   private Integer sort;

   public static CrmPageManagementConfig.CrmPageManagementConfigBuilder builder() {
      return new CrmPageManagementConfig.CrmPageManagementConfigBuilder();
   }

   public CrmPageManagementConfig() {
   }

   public CrmPageManagementConfig(
      final Long id,
      final String fieldName,
      final String argumentName,
      final String argumentShowName,
      final Boolean isShow,
      final Boolean isWrite,
      final Integer crmFieldParentTypeEnum,
      final Integer crmPageManagementConfigEnum,
      final Integer crmCountryTypeEnum,
      final Integer sort
   ) {
      this.id = id;
      this.fieldName = fieldName;
      this.argumentName = argumentName;
      this.argumentShowName = argumentShowName;
      this.isShow = isShow;
      this.isWrite = isWrite;
      this.crmFieldParentTypeEnum = crmFieldParentTypeEnum;
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public String getFieldName() {
      return this.fieldName;
   }

   public String getArgumentName() {
      return this.argumentName;
   }

   public String getArgumentShowName() {
      return this.argumentShowName;
   }

   public Boolean getIsShow() {
      return this.isShow;
   }

   public Boolean getIsWrite() {
      return this.isWrite;
   }

   public Integer getCrmFieldParentTypeEnum() {
      return this.crmFieldParentTypeEnum;
   }

   public Integer getCrmPageManagementConfigEnum() {
      return this.crmPageManagementConfigEnum;
   }

   public Integer getCrmCountryTypeEnum() {
      return this.crmCountryTypeEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public CrmPageManagementConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmPageManagementConfig setFieldName(final String fieldName) {
      this.fieldName = fieldName;
      return this;
   }

   public CrmPageManagementConfig setArgumentName(final String argumentName) {
      this.argumentName = argumentName;
      return this;
   }

   public CrmPageManagementConfig setArgumentShowName(final String argumentShowName) {
      this.argumentShowName = argumentShowName;
      return this;
   }

   public CrmPageManagementConfig setIsShow(final Boolean isShow) {
      this.isShow = isShow;
      return this;
   }

   public CrmPageManagementConfig setIsWrite(final Boolean isWrite) {
      this.isWrite = isWrite;
      return this;
   }

   public CrmPageManagementConfig setCrmFieldParentTypeEnum(final Integer crmFieldParentTypeEnum) {
      this.crmFieldParentTypeEnum = crmFieldParentTypeEnum;
      return this;
   }

   public CrmPageManagementConfig setCrmPageManagementConfigEnum(final Integer crmPageManagementConfigEnum) {
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
      return this;
   }

   public CrmPageManagementConfig setCrmCountryTypeEnum(final Integer crmCountryTypeEnum) {
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      return this;
   }

   public CrmPageManagementConfig setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "CrmPageManagementConfig(id="
         + this.getId()
         + ", fieldName="
         + this.getFieldName()
         + ", argumentName="
         + this.getArgumentName()
         + ", argumentShowName="
         + this.getArgumentShowName()
         + ", isShow="
         + this.getIsShow()
         + ", isWrite="
         + this.getIsWrite()
         + ", crmFieldParentTypeEnum="
         + this.getCrmFieldParentTypeEnum()
         + ", crmPageManagementConfigEnum="
         + this.getCrmPageManagementConfigEnum()
         + ", crmCountryTypeEnum="
         + this.getCrmCountryTypeEnum()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPageManagementConfig)) {
         return false;
      }

      CrmPageManagementConfig other = (CrmPageManagementConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$isShow = this.getIsShow();
         Object other$isShow = other.getIsShow();
         if (this$isShow == null ? other$isShow == null : this$isShow.equals(other$isShow)) {
            Object this$isWrite = this.getIsWrite();
            Object other$isWrite = other.getIsWrite();
            if (this$isWrite == null ? other$isWrite == null : this$isWrite.equals(other$isWrite)) {
               Object this$crmFieldParentTypeEnum = this.getCrmFieldParentTypeEnum();
               Object other$crmFieldParentTypeEnum = other.getCrmFieldParentTypeEnum();
               if (this$crmFieldParentTypeEnum == null
                  ? other$crmFieldParentTypeEnum == null
                  : this$crmFieldParentTypeEnum.equals(other$crmFieldParentTypeEnum)) {
                  Object this$crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
                  Object other$crmPageManagementConfigEnum = other.getCrmPageManagementConfigEnum();
                  if (this$crmPageManagementConfigEnum == null
                     ? other$crmPageManagementConfigEnum == null
                     : this$crmPageManagementConfigEnum.equals(other$crmPageManagementConfigEnum)) {
                     Object this$crmCountryTypeEnum = this.getCrmCountryTypeEnum();
                     Object other$crmCountryTypeEnum = other.getCrmCountryTypeEnum();
                     if (this$crmCountryTypeEnum == null ? other$crmCountryTypeEnum == null : this$crmCountryTypeEnum.equals(other$crmCountryTypeEnum)) {
                        Object this$sort = this.getSort();
                        Object other$sort = other.getSort();
                        if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                           Object this$fieldName = this.getFieldName();
                           Object other$fieldName = other.getFieldName();
                           if (this$fieldName == null ? other$fieldName == null : this$fieldName.equals(other$fieldName)) {
                              Object this$argumentName = this.getArgumentName();
                              Object other$argumentName = other.getArgumentName();
                              if (this$argumentName == null ? other$argumentName == null : this$argumentName.equals(other$argumentName)) {
                                 Object this$argumentShowName = this.getArgumentShowName();
                                 Object other$argumentShowName = other.getArgumentShowName();
                                 return this$argumentShowName == null ? other$argumentShowName == null : this$argumentShowName.equals(other$argumentShowName);
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
      return other instanceof CrmPageManagementConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isShow = this.getIsShow();
      result = result * 59 + ($isShow == null ? 43 : $isShow.hashCode());
      Object $isWrite = this.getIsWrite();
      result = result * 59 + ($isWrite == null ? 43 : $isWrite.hashCode());
      Object $crmFieldParentTypeEnum = this.getCrmFieldParentTypeEnum();
      result = result * 59 + ($crmFieldParentTypeEnum == null ? 43 : $crmFieldParentTypeEnum.hashCode());
      Object $crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
      result = result * 59 + ($crmPageManagementConfigEnum == null ? 43 : $crmPageManagementConfigEnum.hashCode());
      Object $crmCountryTypeEnum = this.getCrmCountryTypeEnum();
      result = result * 59 + ($crmCountryTypeEnum == null ? 43 : $crmCountryTypeEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $fieldName = this.getFieldName();
      result = result * 59 + ($fieldName == null ? 43 : $fieldName.hashCode());
      Object $argumentName = this.getArgumentName();
      result = result * 59 + ($argumentName == null ? 43 : $argumentName.hashCode());
      Object $argumentShowName = this.getArgumentShowName();
      return result * 59 + ($argumentShowName == null ? 43 : $argumentShowName.hashCode());
   }

   public static class CrmPageManagementConfigBuilder {
      private Long id;
      private String fieldName;
      private String argumentName;
      private String argumentShowName;
      private Boolean isShow;
      private Boolean isWrite;
      private Integer crmFieldParentTypeEnum;
      private Integer crmPageManagementConfigEnum;
      private Integer crmCountryTypeEnum;
      private Integer sort;

      CrmPageManagementConfigBuilder() {
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder fieldName(final String fieldName) {
         this.fieldName = fieldName;
         return this;
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder argumentName(final String argumentName) {
         this.argumentName = argumentName;
         return this;
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder argumentShowName(final String argumentShowName) {
         this.argumentShowName = argumentShowName;
         return this;
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder isShow(final Boolean isShow) {
         this.isShow = isShow;
         return this;
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder isWrite(final Boolean isWrite) {
         this.isWrite = isWrite;
         return this;
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder crmFieldParentTypeEnum(final Integer crmFieldParentTypeEnum) {
         this.crmFieldParentTypeEnum = crmFieldParentTypeEnum;
         return this;
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder crmPageManagementConfigEnum(final Integer crmPageManagementConfigEnum) {
         this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
         return this;
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder crmCountryTypeEnum(final Integer crmCountryTypeEnum) {
         this.crmCountryTypeEnum = crmCountryTypeEnum;
         return this;
      }

      public CrmPageManagementConfig.CrmPageManagementConfigBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public CrmPageManagementConfig build() {
         return new CrmPageManagementConfig(
            this.id,
            this.fieldName,
            this.argumentName,
            this.argumentShowName,
            this.isShow,
            this.isWrite,
            this.crmFieldParentTypeEnum,
            this.crmPageManagementConfigEnum,
            this.crmCountryTypeEnum,
            this.sort
         );
      }

      @Override
      public String toString() {
         return "CrmPageManagementConfig.CrmPageManagementConfigBuilder(id="
            + this.id
            + ", fieldName="
            + this.fieldName
            + ", argumentName="
            + this.argumentName
            + ", argumentShowName="
            + this.argumentShowName
            + ", isShow="
            + this.isShow
            + ", isWrite="
            + this.isWrite
            + ", crmFieldParentTypeEnum="
            + this.crmFieldParentTypeEnum
            + ", crmPageManagementConfigEnum="
            + this.crmPageManagementConfigEnum
            + ", crmCountryTypeEnum="
            + this.crmCountryTypeEnum
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
