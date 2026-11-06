package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "零件类型定义配置(截面类型名称与规格关联) ")
@Entity
@Table(name = "sys_steel_section_spec_name_link")
public class SysSteelSectionSpecNameLink {
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
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty("类型名称库id")
   @JsonProperty("sectionWarehouseConfigId")
   @JSONField(name = "sectionWarehouseConfigId")
   @TableField("section_warehouse_config_id")
   @Column(name = "section_warehouse_config_id", nullable = false, columnDefinition = "bigint(20) comment '类型名称库id'")
   private Long sectionWarehouseConfigId;

   public static SysSteelSectionSpecNameLink.SysSteelSectionSpecNameLinkBuilder builder() {
      return new SysSteelSectionSpecNameLink.SysSteelSectionSpecNameLinkBuilder();
   }

   public SysSteelSectionSpecNameLink() {
   }

   public SysSteelSectionSpecNameLink(final Long id, final Long steelId, final String specPrefix, final String name, final Long sectionWarehouseConfigId) {
      this.id = id;
      this.steelId = steelId;
      this.specPrefix = specPrefix;
      this.name = name;
      this.sectionWarehouseConfigId = sectionWarehouseConfigId;
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

   public String getName() {
      return this.name;
   }

   public Long getSectionWarehouseConfigId() {
      return this.sectionWarehouseConfigId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("steelId")
   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("sectionWarehouseConfigId")
   public void setSectionWarehouseConfigId(final Long sectionWarehouseConfigId) {
      this.sectionWarehouseConfigId = sectionWarehouseConfigId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysSteelSectionSpecNameLink)) {
         return false;
      }

      SysSteelSectionSpecNameLink other = (SysSteelSectionSpecNameLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$steelId = this.getSteelId();
         Object other$steelId = other.getSteelId();
         if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
            Object this$sectionWarehouseConfigId = this.getSectionWarehouseConfigId();
            Object other$sectionWarehouseConfigId = other.getSectionWarehouseConfigId();
            if (this$sectionWarehouseConfigId == null
               ? other$sectionWarehouseConfigId == null
               : this$sectionWarehouseConfigId.equals(other$sectionWarehouseConfigId)) {
               Object this$specPrefix = this.getSpecPrefix();
               Object other$specPrefix = other.getSpecPrefix();
               if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof SysSteelSectionSpecNameLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $sectionWarehouseConfigId = this.getSectionWarehouseConfigId();
      result = result * 59 + ($sectionWarehouseConfigId == null ? 43 : $sectionWarehouseConfigId.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysSteelSectionSpecNameLink(id="
         + this.getId()
         + ", steelId="
         + this.getSteelId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", name="
         + this.getName()
         + ", sectionWarehouseConfigId="
         + this.getSectionWarehouseConfigId()
         + ")";
   }

   public static class SysSteelSectionSpecNameLinkBuilder {
      private Long id;
      private Long steelId;
      private String specPrefix;
      private String name;
      private Long sectionWarehouseConfigId;

      SysSteelSectionSpecNameLinkBuilder() {
      }

      public SysSteelSectionSpecNameLink.SysSteelSectionSpecNameLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("steelId")
      public SysSteelSectionSpecNameLink.SysSteelSectionSpecNameLinkBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public SysSteelSectionSpecNameLink.SysSteelSectionSpecNameLinkBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public SysSteelSectionSpecNameLink.SysSteelSectionSpecNameLinkBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sectionWarehouseConfigId")
      public SysSteelSectionSpecNameLink.SysSteelSectionSpecNameLinkBuilder sectionWarehouseConfigId(final Long sectionWarehouseConfigId) {
         this.sectionWarehouseConfigId = sectionWarehouseConfigId;
         return this;
      }

      public SysSteelSectionSpecNameLink build() {
         return new SysSteelSectionSpecNameLink(this.id, this.steelId, this.specPrefix, this.name, this.sectionWarehouseConfigId);
      }

      @Override
      public String toString() {
         return "SysSteelSectionSpecNameLink.SysSteelSectionSpecNameLinkBuilder(id="
            + this.id
            + ", steelId="
            + this.steelId
            + ", specPrefix="
            + this.specPrefix
            + ", name="
            + this.name
            + ", sectionWarehouseConfigId="
            + this.sectionWarehouseConfigId
            + ")";
      }
   }
}
