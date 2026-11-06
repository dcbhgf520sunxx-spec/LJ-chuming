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

@ApiModel(value = "CrmBusinessLicenseQueryConfig对象", description = "")
@Entity
@TableName("crm_business_license_query_config")
@Table(name = "crm_business_license_query_config")
@org.hibernate.annotations.Table(appliesTo = "crm_business_license_query_config")
public class CrmBusinessLicenseQueryConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "times", value = "crm-每日可查询次数（默认10次）", notes = "crm-每日可查询次数（默认10次）")
   @TableField("times")
   @Column(name = "times", columnDefinition = "int(11)  COMMENT 'crm-每日可查询次数（默认10次）'", nullable = false)
   private Integer times;

   public static CrmBusinessLicenseQueryConfig.CrmBusinessLicenseQueryConfigBuilder builder() {
      return new CrmBusinessLicenseQueryConfig.CrmBusinessLicenseQueryConfigBuilder();
   }

   public CrmBusinessLicenseQueryConfig() {
   }

   public CrmBusinessLicenseQueryConfig(final Long id, final Integer times) {
      this.id = id;
      this.times = times;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getTimes() {
      return this.times;
   }

   public CrmBusinessLicenseQueryConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmBusinessLicenseQueryConfig setTimes(final Integer times) {
      this.times = times;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBusinessLicenseQueryConfig(id=" + this.getId() + ", times=" + this.getTimes() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmBusinessLicenseQueryConfig)) {
         return false;
      } else {
         CrmBusinessLicenseQueryConfig other = (CrmBusinessLicenseQueryConfig)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$times = this.getTimes();
               Object other$times = other.getTimes();
               return this$times == null ? other$times == null : this$times.equals(other$times);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmBusinessLicenseQueryConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $times = this.getTimes();
      return result * 59 + ($times == null ? 43 : $times.hashCode());
   }

   public static class CrmBusinessLicenseQueryConfigBuilder {
      private Long id;
      private Integer times;

      CrmBusinessLicenseQueryConfigBuilder() {
      }

      public CrmBusinessLicenseQueryConfig.CrmBusinessLicenseQueryConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmBusinessLicenseQueryConfig.CrmBusinessLicenseQueryConfigBuilder times(final Integer times) {
         this.times = times;
         return this;
      }

      public CrmBusinessLicenseQueryConfig build() {
         return new CrmBusinessLicenseQueryConfig(this.id, this.times);
      }

      @Override
      public String toString() {
         return "CrmBusinessLicenseQueryConfig.CrmBusinessLicenseQueryConfigBuilder(id=" + this.id + ", times=" + this.times + ")";
      }
   }
}
