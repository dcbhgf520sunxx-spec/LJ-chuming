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

@ApiModel(value = "CrmProjectInformationConfig对象", description = "项目信息配置")
@Entity
@TableName("crm_project_information_config")
@Table(name = "crm_project_information_config")
@org.hibernate.annotations.Table(appliesTo = "crm_project_information_config")
public class CrmProjectInformationConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "crmProjectInformationConfigEnum", value = "项目信息配置枚举", notes = "项目信息配置枚举")
   @TableField("crm_project_information_config_enum")
   @Column(name = "crm_project_information_config_enum", columnDefinition = "int(11)  COMMENT '项目信息配置枚举'", nullable = false)
   private Integer crmProjectInformationConfigEnum;
   @ApiModelProperty(name = "name", value = "名称（建筑形式）", notes = "名称（建筑形式）")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称（建筑形式）'", nullable = true)
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = false)
   private Integer sort;

   public static CrmProjectInformationConfig.CrmProjectInformationConfigBuilder builder() {
      return new CrmProjectInformationConfig.CrmProjectInformationConfigBuilder();
   }

   public CrmProjectInformationConfig() {
   }

   public CrmProjectInformationConfig(final Long id, final Integer crmProjectInformationConfigEnum, final String name, final Integer sort) {
      this.id = id;
      this.crmProjectInformationConfigEnum = crmProjectInformationConfigEnum;
      this.name = name;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmProjectInformationConfigEnum() {
      return this.crmProjectInformationConfigEnum;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public CrmProjectInformationConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectInformationConfig setCrmProjectInformationConfigEnum(final Integer crmProjectInformationConfigEnum) {
      this.crmProjectInformationConfigEnum = crmProjectInformationConfigEnum;
      return this;
   }

   public CrmProjectInformationConfig setName(final String name) {
      this.name = name;
      return this;
   }

   public CrmProjectInformationConfig setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectInformationConfig(id="
         + this.getId()
         + ", crmProjectInformationConfigEnum="
         + this.getCrmProjectInformationConfigEnum()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectInformationConfig)) {
         return false;
      }

      CrmProjectInformationConfig other = (CrmProjectInformationConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmProjectInformationConfigEnum = this.getCrmProjectInformationConfigEnum();
         Object other$crmProjectInformationConfigEnum = other.getCrmProjectInformationConfigEnum();
         if (this$crmProjectInformationConfigEnum == null
            ? other$crmProjectInformationConfigEnum == null
            : this$crmProjectInformationConfigEnum.equals(other$crmProjectInformationConfigEnum)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectInformationConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectInformationConfigEnum = this.getCrmProjectInformationConfigEnum();
      result = result * 59 + ($crmProjectInformationConfigEnum == null ? 43 : $crmProjectInformationConfigEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class CrmProjectInformationConfigBuilder {
      private Long id;
      private Integer crmProjectInformationConfigEnum;
      private String name;
      private Integer sort;

      CrmProjectInformationConfigBuilder() {
      }

      public CrmProjectInformationConfig.CrmProjectInformationConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectInformationConfig.CrmProjectInformationConfigBuilder crmProjectInformationConfigEnum(final Integer crmProjectInformationConfigEnum) {
         this.crmProjectInformationConfigEnum = crmProjectInformationConfigEnum;
         return this;
      }

      public CrmProjectInformationConfig.CrmProjectInformationConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CrmProjectInformationConfig.CrmProjectInformationConfigBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public CrmProjectInformationConfig build() {
         return new CrmProjectInformationConfig(this.id, this.crmProjectInformationConfigEnum, this.name, this.sort);
      }

      @Override
      public String toString() {
         return "CrmProjectInformationConfig.CrmProjectInformationConfigBuilder(id="
            + this.id
            + ", crmProjectInformationConfigEnum="
            + this.crmProjectInformationConfigEnum
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
