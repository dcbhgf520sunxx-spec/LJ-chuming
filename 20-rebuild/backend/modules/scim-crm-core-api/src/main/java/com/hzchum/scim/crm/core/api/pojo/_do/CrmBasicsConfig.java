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

@ApiModel(value = "CrmBasicsConfig对象", description = "基础配置")
@Entity
@TableName("crm_basics_config")
@Table(name = "crm_basics_config")
@org.hibernate.annotations.Table(appliesTo = "crm_basics_config")
public class CrmBasicsConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "crmBasicsConfigEnum", value = "crm-基础配置枚举参考CrmBasicsConfigEnum", notes = "crm-基础配置枚举参考CrmBasicsConfigEnum")
   @TableField("crm_basics_config_enum")
   @Column(name = "crm_basics_config_enum", columnDefinition = "int(11)  COMMENT 'crm-基础配置枚举参考CrmBasicsConfigEnum'", nullable = false)
   private Integer crmBasicsConfigEnum;
   @ApiModelProperty(name = "name", value = "名称（包含 性质 类别）", notes = "名称（包含 性质 类别）")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称（包含 性质 类别）'", nullable = false)
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = false)
   private Integer sort;

   public static CrmBasicsConfig.CrmBasicsConfigBuilder builder() {
      return new CrmBasicsConfig.CrmBasicsConfigBuilder();
   }

   public CrmBasicsConfig() {
   }

   public CrmBasicsConfig(final Long id, final Integer crmBasicsConfigEnum, final String name, final Integer sort) {
      this.id = id;
      this.crmBasicsConfigEnum = crmBasicsConfigEnum;
      this.name = name;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmBasicsConfigEnum() {
      return this.crmBasicsConfigEnum;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public CrmBasicsConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmBasicsConfig setCrmBasicsConfigEnum(final Integer crmBasicsConfigEnum) {
      this.crmBasicsConfigEnum = crmBasicsConfigEnum;
      return this;
   }

   public CrmBasicsConfig setName(final String name) {
      this.name = name;
      return this;
   }

   public CrmBasicsConfig setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBasicsConfig(id="
         + this.getId()
         + ", crmBasicsConfigEnum="
         + this.getCrmBasicsConfigEnum()
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

      if (!(o instanceof CrmBasicsConfig)) {
         return false;
      }

      CrmBasicsConfig other = (CrmBasicsConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmBasicsConfigEnum = this.getCrmBasicsConfigEnum();
         Object other$crmBasicsConfigEnum = other.getCrmBasicsConfigEnum();
         if (this$crmBasicsConfigEnum == null ? other$crmBasicsConfigEnum == null : this$crmBasicsConfigEnum.equals(other$crmBasicsConfigEnum)) {
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
      return other instanceof CrmBasicsConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmBasicsConfigEnum = this.getCrmBasicsConfigEnum();
      result = result * 59 + ($crmBasicsConfigEnum == null ? 43 : $crmBasicsConfigEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class CrmBasicsConfigBuilder {
      private Long id;
      private Integer crmBasicsConfigEnum;
      private String name;
      private Integer sort;

      CrmBasicsConfigBuilder() {
      }

      public CrmBasicsConfig.CrmBasicsConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmBasicsConfig.CrmBasicsConfigBuilder crmBasicsConfigEnum(final Integer crmBasicsConfigEnum) {
         this.crmBasicsConfigEnum = crmBasicsConfigEnum;
         return this;
      }

      public CrmBasicsConfig.CrmBasicsConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CrmBasicsConfig.CrmBasicsConfigBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public CrmBasicsConfig build() {
         return new CrmBasicsConfig(this.id, this.crmBasicsConfigEnum, this.name, this.sort);
      }

      @Override
      public String toString() {
         return "CrmBasicsConfig.CrmBasicsConfigBuilder(id="
            + this.id
            + ", crmBasicsConfigEnum="
            + this.crmBasicsConfigEnum
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
