package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

@ApiModel(description = "组立配置表 ")
@Entity
@Table(name = "sys_assemble_config")
public class SysAssembleConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("部件类型名称")
   @Column(name = "name", nullable = false, columnDefinition = "varchar(64) comment '部件类型名称'")
   private String name;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [0 否, 1 是]", notes = "是否成品型材 [0 否, 1 是]")
   @JsonProperty("boolSectionSteel")
   @JSONField(name = "boolSectionSteel")
   @TableField("bool_section_steel")
   @Column(name = "bool_section_steel", columnDefinition = "tinyint(1) default '0' COMMENT '是否成品型材 [0 否, 1 是]'", nullable = false)
   private Boolean boolSectionSteel;
   @ApiModelProperty("排序")
   @Column(name = "sort", nullable = false, columnDefinition = "int(11) default 1 comment '排序'")
   private Integer sort;
   @ApiModelProperty(name = "lastChangeId", value = "最新变更记录id", notes = "最新变更记录id")
   @JsonProperty("lastChangeId")
   @JSONField(name = "lastChangeId")
   @TableField("last_change_id")
   @Column(name = "last_change_id", columnDefinition = "bigint(20)  COMMENT '最新变更记录id'", nullable = true)
   private Long lastChangeId;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static SysAssembleConfig.SysAssembleConfigBuilder builder() {
      return new SysAssembleConfig.SysAssembleConfigBuilder();
   }

   public SysAssembleConfig() {
   }

   public SysAssembleConfig(
      final Long id, final String name, final Boolean boolSectionSteel, final Integer sort, final Long lastChangeId, final Integer mesProductEnum
   ) {
      this.id = id;
      this.name = name;
      this.boolSectionSteel = boolSectionSteel;
      this.sort = sort;
      this.lastChangeId = lastChangeId;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getLastChangeId() {
      return this.lastChangeId;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("boolSectionSteel")
   public void setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @JsonProperty("lastChangeId")
   public void setLastChangeId(final Long lastChangeId) {
      this.lastChangeId = lastChangeId;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAssembleConfig)) {
         return false;
      }

      SysAssembleConfig other = (SysAssembleConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolSectionSteel = this.getBoolSectionSteel();
         Object other$boolSectionSteel = other.getBoolSectionSteel();
         if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$lastChangeId = this.getLastChangeId();
               Object other$lastChangeId = other.getLastChangeId();
               if (this$lastChangeId == null ? other$lastChangeId == null : this$lastChangeId.equals(other$lastChangeId)) {
                  Object this$mesProductEnum = this.getMesProductEnum();
                  Object other$mesProductEnum = other.getMesProductEnum();
                  if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysAssembleConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $lastChangeId = this.getLastChangeId();
      result = result * 59 + ($lastChangeId == null ? 43 : $lastChangeId.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysAssembleConfig(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", sort="
         + this.getSort()
         + ", lastChangeId="
         + this.getLastChangeId()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   public static class SysAssembleConfigBuilder {
      private Long id;
      private String name;
      private Boolean boolSectionSteel;
      private Integer sort;
      private Long lastChangeId;
      private Integer mesProductEnum;

      SysAssembleConfigBuilder() {
      }

      public SysAssembleConfig.SysAssembleConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysAssembleConfig.SysAssembleConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("boolSectionSteel")
      public SysAssembleConfig.SysAssembleConfigBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      public SysAssembleConfig.SysAssembleConfigBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("lastChangeId")
      public SysAssembleConfig.SysAssembleConfigBuilder lastChangeId(final Long lastChangeId) {
         this.lastChangeId = lastChangeId;
         return this;
      }

      public SysAssembleConfig.SysAssembleConfigBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysAssembleConfig build() {
         return new SysAssembleConfig(this.id, this.name, this.boolSectionSteel, this.sort, this.lastChangeId, this.mesProductEnum);
      }

      @Override
      public String toString() {
         return "SysAssembleConfig.SysAssembleConfigBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", sort="
            + this.sort
            + ", lastChangeId="
            + this.lastChangeId
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
