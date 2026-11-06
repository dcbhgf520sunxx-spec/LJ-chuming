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

@ApiModel(value = "CrmNumberPrefixConfig对象", description = "编号前缀配置")
@Entity
@TableName("crm_number_prefix_config")
@Table(name = "crm_number_prefix_config")
@org.hibernate.annotations.Table(appliesTo = "crm_number_prefix_config")
public class CrmNumberPrefixConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "numberPrefixConfigEnum", value = "编号前缀配置所属类型", notes = "编号前缀配置所属类型")
   @TableField("number_prefix_config_enum")
   @Column(name = "number_prefix_config_enum", columnDefinition = "int(11)  COMMENT '编号前缀配置所属类型'", nullable = false)
   private Integer numberPrefixConfigEnum;
   @ApiModelProperty(name = "prefixNaming", value = "前缀命名", notes = "前缀命名")
   @TableField("prefix_naming")
   @Column(name = "prefix_naming", columnDefinition = "varchar(255)  COMMENT '前缀命名'", nullable = false)
   private String prefixNaming;

   public static CrmNumberPrefixConfig.CrmNumberPrefixConfigBuilder builder() {
      return new CrmNumberPrefixConfig.CrmNumberPrefixConfigBuilder();
   }

   public CrmNumberPrefixConfig() {
   }

   public CrmNumberPrefixConfig(final Long id, final Integer numberPrefixConfigEnum, final String prefixNaming) {
      this.id = id;
      this.numberPrefixConfigEnum = numberPrefixConfigEnum;
      this.prefixNaming = prefixNaming;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getNumberPrefixConfigEnum() {
      return this.numberPrefixConfigEnum;
   }

   public String getPrefixNaming() {
      return this.prefixNaming;
   }

   public CrmNumberPrefixConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmNumberPrefixConfig setNumberPrefixConfigEnum(final Integer numberPrefixConfigEnum) {
      this.numberPrefixConfigEnum = numberPrefixConfigEnum;
      return this;
   }

   public CrmNumberPrefixConfig setPrefixNaming(final String prefixNaming) {
      this.prefixNaming = prefixNaming;
      return this;
   }

   @Override
   public String toString() {
      return "CrmNumberPrefixConfig(id="
         + this.getId()
         + ", numberPrefixConfigEnum="
         + this.getNumberPrefixConfigEnum()
         + ", prefixNaming="
         + this.getPrefixNaming()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmNumberPrefixConfig)) {
         return false;
      }

      CrmNumberPrefixConfig other = (CrmNumberPrefixConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$numberPrefixConfigEnum = this.getNumberPrefixConfigEnum();
         Object other$numberPrefixConfigEnum = other.getNumberPrefixConfigEnum();
         if (this$numberPrefixConfigEnum == null ? other$numberPrefixConfigEnum == null : this$numberPrefixConfigEnum.equals(other$numberPrefixConfigEnum)) {
            Object this$prefixNaming = this.getPrefixNaming();
            Object other$prefixNaming = other.getPrefixNaming();
            return this$prefixNaming == null ? other$prefixNaming == null : this$prefixNaming.equals(other$prefixNaming);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmNumberPrefixConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $numberPrefixConfigEnum = this.getNumberPrefixConfigEnum();
      result = result * 59 + ($numberPrefixConfigEnum == null ? 43 : $numberPrefixConfigEnum.hashCode());
      Object $prefixNaming = this.getPrefixNaming();
      return result * 59 + ($prefixNaming == null ? 43 : $prefixNaming.hashCode());
   }

   public static class CrmNumberPrefixConfigBuilder {
      private Long id;
      private Integer numberPrefixConfigEnum;
      private String prefixNaming;

      CrmNumberPrefixConfigBuilder() {
      }

      public CrmNumberPrefixConfig.CrmNumberPrefixConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmNumberPrefixConfig.CrmNumberPrefixConfigBuilder numberPrefixConfigEnum(final Integer numberPrefixConfigEnum) {
         this.numberPrefixConfigEnum = numberPrefixConfigEnum;
         return this;
      }

      public CrmNumberPrefixConfig.CrmNumberPrefixConfigBuilder prefixNaming(final String prefixNaming) {
         this.prefixNaming = prefixNaming;
         return this;
      }

      public CrmNumberPrefixConfig build() {
         return new CrmNumberPrefixConfig(this.id, this.numberPrefixConfigEnum, this.prefixNaming);
      }

      @Override
      public String toString() {
         return "CrmNumberPrefixConfig.CrmNumberPrefixConfigBuilder(id="
            + this.id
            + ", numberPrefixConfigEnum="
            + this.numberPrefixConfigEnum
            + ", prefixNaming="
            + this.prefixNaming
            + ")";
      }
   }
}
