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

@ApiModel(value = "CrmTenderRequestConfig对象", description = "投标申请配置")
@Entity
@TableName("crm_tender_request_config")
@Table(name = "crm_tender_request_config")
@org.hibernate.annotations.Table(appliesTo = "crm_tender_request_config")
public class CrmTenderRequestConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "crmTenderRequestConfigEnum", value = "投标申请配置枚举(CrmTenderRequestConfigEnum)", notes = "投标申请配置枚举(CrmTenderRequestConfigEnum)")
   @TableField("crm_tender_request_config_enum")
   @Column(name = "crm_tender_request_config_enum", columnDefinition = "int(11)  COMMENT '投标申请配置枚举(CrmTenderRequestConfigEnum)'", nullable = false)
   private Integer crmTenderRequestConfigEnum;
   @ApiModelProperty(name = "crmSpecialBubmissionStatusEnum", value = "专项提报类型", notes = "专项提报类型")
   @TableField("crm_special_bubmission_status_enum")
   @Column(name = "crm_special_bubmission_status_enum", columnDefinition = "int(11)  COMMENT '专项提报类型 参考枚举 CrmSpecialBubmissionStatusEnum 默认为 投标分配类型'")
   private Integer crmSpecialBubmissionStatusEnum;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = false)
   private Integer sort;

   public static CrmTenderRequestConfig.CrmTenderRequestConfigBuilder builder() {
      return new CrmTenderRequestConfig.CrmTenderRequestConfigBuilder();
   }

   public CrmTenderRequestConfig() {
   }

   public CrmTenderRequestConfig(
      final Long id, final Integer crmTenderRequestConfigEnum, final Integer crmSpecialBubmissionStatusEnum, final String name, final Integer sort
   ) {
      this.id = id;
      this.crmTenderRequestConfigEnum = crmTenderRequestConfigEnum;
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      this.name = name;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmTenderRequestConfigEnum() {
      return this.crmTenderRequestConfigEnum;
   }

   public Integer getCrmSpecialBubmissionStatusEnum() {
      return this.crmSpecialBubmissionStatusEnum;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public CrmTenderRequestConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmTenderRequestConfig setCrmTenderRequestConfigEnum(final Integer crmTenderRequestConfigEnum) {
      this.crmTenderRequestConfigEnum = crmTenderRequestConfigEnum;
      return this;
   }

   public CrmTenderRequestConfig setCrmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      return this;
   }

   public CrmTenderRequestConfig setName(final String name) {
      this.name = name;
      return this;
   }

   public CrmTenderRequestConfig setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "CrmTenderRequestConfig(id="
         + this.getId()
         + ", crmTenderRequestConfigEnum="
         + this.getCrmTenderRequestConfigEnum()
         + ", crmSpecialBubmissionStatusEnum="
         + this.getCrmSpecialBubmissionStatusEnum()
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

      if (!(o instanceof CrmTenderRequestConfig)) {
         return false;
      }

      CrmTenderRequestConfig other = (CrmTenderRequestConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmTenderRequestConfigEnum = this.getCrmTenderRequestConfigEnum();
         Object other$crmTenderRequestConfigEnum = other.getCrmTenderRequestConfigEnum();
         if (this$crmTenderRequestConfigEnum == null
            ? other$crmTenderRequestConfigEnum == null
            : this$crmTenderRequestConfigEnum.equals(other$crmTenderRequestConfigEnum)) {
            Object this$crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
            Object other$crmSpecialBubmissionStatusEnum = other.getCrmSpecialBubmissionStatusEnum();
            if (this$crmSpecialBubmissionStatusEnum == null
               ? other$crmSpecialBubmissionStatusEnum == null
               : this$crmSpecialBubmissionStatusEnum.equals(other$crmSpecialBubmissionStatusEnum)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmTenderRequestConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmTenderRequestConfigEnum = this.getCrmTenderRequestConfigEnum();
      result = result * 59 + ($crmTenderRequestConfigEnum == null ? 43 : $crmTenderRequestConfigEnum.hashCode());
      Object $crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      result = result * 59 + ($crmSpecialBubmissionStatusEnum == null ? 43 : $crmSpecialBubmissionStatusEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class CrmTenderRequestConfigBuilder {
      private Long id;
      private Integer crmTenderRequestConfigEnum;
      private Integer crmSpecialBubmissionStatusEnum;
      private String name;
      private Integer sort;

      CrmTenderRequestConfigBuilder() {
      }

      public CrmTenderRequestConfig.CrmTenderRequestConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmTenderRequestConfig.CrmTenderRequestConfigBuilder crmTenderRequestConfigEnum(final Integer crmTenderRequestConfigEnum) {
         this.crmTenderRequestConfigEnum = crmTenderRequestConfigEnum;
         return this;
      }

      public CrmTenderRequestConfig.CrmTenderRequestConfigBuilder crmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
         this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
         return this;
      }

      public CrmTenderRequestConfig.CrmTenderRequestConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CrmTenderRequestConfig.CrmTenderRequestConfigBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public CrmTenderRequestConfig build() {
         return new CrmTenderRequestConfig(this.id, this.crmTenderRequestConfigEnum, this.crmSpecialBubmissionStatusEnum, this.name, this.sort);
      }

      @Override
      public String toString() {
         return "CrmTenderRequestConfig.CrmTenderRequestConfigBuilder(id="
            + this.id
            + ", crmTenderRequestConfigEnum="
            + this.crmTenderRequestConfigEnum
            + ", crmSpecialBubmissionStatusEnum="
            + this.crmSpecialBubmissionStatusEnum
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
