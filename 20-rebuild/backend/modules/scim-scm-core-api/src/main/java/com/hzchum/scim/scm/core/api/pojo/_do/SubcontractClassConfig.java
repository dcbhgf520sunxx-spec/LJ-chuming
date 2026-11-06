package com.hzchum.scim.scm.core.api.pojo._do;

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

@ApiModel(value = "SubcontractClassConfig对象", description = "分包类别配置表 ")
@Entity
@TableName("scm_subcontract_class_config")
@Table(name = "scm_subcontract_class_config")
@org.hibernate.annotations.Table(appliesTo = "scm_subcontract_class_config", comment = "分包类别配置表 ")
public class SubcontractClassConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "分包类别名称", notes = "分包类别名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(128)  COMMENT '分包类别名称'", nullable = false)
   private String name;

   public static SubcontractClassConfig.SubcontractClassConfigBuilder builder() {
      return new SubcontractClassConfig.SubcontractClassConfigBuilder();
   }

   public SubcontractClassConfig() {
   }

   public SubcontractClassConfig(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public SubcontractClassConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SubcontractClassConfig setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "SubcontractClassConfig(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SubcontractClassConfig)) {
         return false;
      } else {
         SubcontractClassConfig other = (SubcontractClassConfig)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SubcontractClassConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SubcontractClassConfigBuilder {
      private Long id;
      private String name;

      SubcontractClassConfigBuilder() {
      }

      @JsonProperty("id")
      public SubcontractClassConfig.SubcontractClassConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SubcontractClassConfig.SubcontractClassConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubcontractClassConfig build() {
         return new SubcontractClassConfig(this.id, this.name);
      }

      @Override
      public String toString() {
         return "SubcontractClassConfig.SubcontractClassConfigBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
