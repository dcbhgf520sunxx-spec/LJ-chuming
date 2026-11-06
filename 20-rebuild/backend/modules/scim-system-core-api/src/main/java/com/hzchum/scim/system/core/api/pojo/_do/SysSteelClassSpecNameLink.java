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

@ApiModel(value = "SysSteelClassSpecNameLink对象", description = "零件匹配名称列表")
@Entity
@TableName("sys_steel_class_spec_name_link")
@Table(name = "sys_steel_class_spec_name_link")
@org.hibernate.annotations.Table(appliesTo = "sys_steel_class_spec_name_link", comment = "零件匹配名称列表")
public class SysSteelClassSpecNameLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("零件类型配置Id")
   @JsonProperty("steelId")
   @JSONField(name = "steelId")
   @TableField("steel_id")
   @Column(name = "steel_id", columnDefinition = "bigint(20)  COMMENT '零件类型配置Id'", nullable = false)
   private Long steelId;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀", notes = "规格前缀")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(255)  COMMENT '规格前缀'", nullable = false)
   private String specPrefix;
   @ApiModelProperty(name = "matchingName", value = "匹配名称", notes = "匹配名称")
   @TableField("matching_name")
   @Column(name = "matching_name", columnDefinition = "varchar(255)  COMMENT '匹配名称'", nullable = false)
   private String matchingName;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static SysSteelClassSpecNameLink.SysSteelClassSpecNameLinkBuilder builder() {
      return new SysSteelClassSpecNameLink.SysSteelClassSpecNameLinkBuilder();
   }

   public SysSteelClassSpecNameLink() {
   }

   public SysSteelClassSpecNameLink(final Long id, final Long steelId, final String specPrefix, final String matchingName, final Integer mesProductEnum) {
      this.id = id;
      this.steelId = steelId;
      this.specPrefix = specPrefix;
      this.matchingName = matchingName;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getMatchingName() {
      return this.matchingName;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public SysSteelClassSpecNameLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("steelId")
   public SysSteelClassSpecNameLink setSteelId(final Long steelId) {
      this.steelId = steelId;
      return this;
   }

   public SysSteelClassSpecNameLink setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public SysSteelClassSpecNameLink setMatchingName(final String matchingName) {
      this.matchingName = matchingName;
      return this;
   }

   public SysSteelClassSpecNameLink setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysSteelClassSpecNameLink(id="
         + this.getId()
         + ", steelId="
         + this.getSteelId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", matchingName="
         + this.getMatchingName()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysSteelClassSpecNameLink)) {
         return false;
      }

      SysSteelClassSpecNameLink other = (SysSteelClassSpecNameLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$steelId = this.getSteelId();
         Object other$steelId = other.getSteelId();
         if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
            Object this$mesProductEnum = this.getMesProductEnum();
            Object other$mesProductEnum = other.getMesProductEnum();
            if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
               Object this$specPrefix = this.getSpecPrefix();
               Object other$specPrefix = other.getSpecPrefix();
               if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                  Object this$matchingName = this.getMatchingName();
                  Object other$matchingName = other.getMatchingName();
                  return this$matchingName == null ? other$matchingName == null : this$matchingName.equals(other$matchingName);
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
      return other instanceof SysSteelClassSpecNameLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $matchingName = this.getMatchingName();
      return result * 59 + ($matchingName == null ? 43 : $matchingName.hashCode());
   }

   public static class SysSteelClassSpecNameLinkBuilder {
      private Long id;
      private Long steelId;
      private String specPrefix;
      private String matchingName;
      private Integer mesProductEnum;

      SysSteelClassSpecNameLinkBuilder() {
      }

      public SysSteelClassSpecNameLink.SysSteelClassSpecNameLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("steelId")
      public SysSteelClassSpecNameLink.SysSteelClassSpecNameLinkBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public SysSteelClassSpecNameLink.SysSteelClassSpecNameLinkBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public SysSteelClassSpecNameLink.SysSteelClassSpecNameLinkBuilder matchingName(final String matchingName) {
         this.matchingName = matchingName;
         return this;
      }

      public SysSteelClassSpecNameLink.SysSteelClassSpecNameLinkBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysSteelClassSpecNameLink build() {
         return new SysSteelClassSpecNameLink(this.id, this.steelId, this.specPrefix, this.matchingName, this.mesProductEnum);
      }

      @Override
      public String toString() {
         return "SysSteelClassSpecNameLink.SysSteelClassSpecNameLinkBuilder(id="
            + this.id
            + ", steelId="
            + this.steelId
            + ", specPrefix="
            + this.specPrefix
            + ", matchingName="
            + this.matchingName
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
