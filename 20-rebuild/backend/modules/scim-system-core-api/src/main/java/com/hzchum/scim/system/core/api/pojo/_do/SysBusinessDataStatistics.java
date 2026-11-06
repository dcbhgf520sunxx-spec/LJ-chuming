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

@ApiModel(value = "SysBusinessDataStatistics对象", description = "业务数据统计表")
@Entity
@TableName("sys_business_data_statistics")
@Table(name = "sys_business_data_statistics")
public class SysBusinessDataStatistics extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "code")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code", columnDefinition = "varchar(25) comment '配置项，key值'")
   private String code;
   @ApiModelProperty(name = "name")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(25) comment '名称（备注）'")
   private String name;
   @ApiModelProperty(name = "value")
   @JsonProperty("value")
   @JSONField(name = "value")
   @TableField("value")
   @Column(name = "value", columnDefinition = "varchar(25) comment '数值'")
   private String value;

   public static SysBusinessDataStatistics.SysBusinessDataStatisticsBuilder builder() {
      return new SysBusinessDataStatistics.SysBusinessDataStatisticsBuilder();
   }

   public SysBusinessDataStatistics() {
   }

   public SysBusinessDataStatistics(final Long id, final String code, final String name, final String value) {
      this.id = id;
      this.code = code;
      this.name = name;
      this.value = value;
   }

   public Long getId() {
      return this.id;
   }

   public String getCode() {
      return this.code;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   @JsonProperty("id")
   public SysBusinessDataStatistics setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("code")
   public SysBusinessDataStatistics setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("name")
   public SysBusinessDataStatistics setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("value")
   public SysBusinessDataStatistics setValue(final String value) {
      this.value = value;
      return this;
   }

   @Override
   public String toString() {
      return "SysBusinessDataStatistics(id=" + this.getId() + ", code=" + this.getCode() + ", name=" + this.getName() + ", value=" + this.getValue() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysBusinessDataStatistics)) {
         return false;
      }

      SysBusinessDataStatistics other = (SysBusinessDataStatistics)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$code = this.getCode();
         Object other$code = other.getCode();
         if (this$code == null ? other$code == null : this$code.equals(other$code)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$value = this.getValue();
               Object other$value = other.getValue();
               return this$value == null ? other$value == null : this$value.equals(other$value);
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
      return other instanceof SysBusinessDataStatistics;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   public static class SysBusinessDataStatisticsBuilder {
      private Long id;
      private String code;
      private String name;
      private String value;

      SysBusinessDataStatisticsBuilder() {
      }

      @JsonProperty("id")
      public SysBusinessDataStatistics.SysBusinessDataStatisticsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("code")
      public SysBusinessDataStatistics.SysBusinessDataStatisticsBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("name")
      public SysBusinessDataStatistics.SysBusinessDataStatisticsBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("value")
      public SysBusinessDataStatistics.SysBusinessDataStatisticsBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public SysBusinessDataStatistics build() {
         return new SysBusinessDataStatistics(this.id, this.code, this.name, this.value);
      }

      @Override
      public String toString() {
         return "SysBusinessDataStatistics.SysBusinessDataStatisticsBuilder(id="
            + this.id
            + ", code="
            + this.code
            + ", name="
            + this.name
            + ", value="
            + this.value
            + ")";
      }
   }
}
