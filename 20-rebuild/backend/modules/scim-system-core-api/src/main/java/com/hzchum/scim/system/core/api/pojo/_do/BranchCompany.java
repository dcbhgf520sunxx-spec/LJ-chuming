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

@ApiModel(value = "BranchCompany对象", description = "分支机构")
@Entity
@TableName("sys_branch_company")
@Table(name = "sys_branch_company")
public class BranchCompany extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "enabled")
   @JsonProperty("enabled")
   @JSONField(name = "enabled")
   @TableField("enabled")
   @Column(name = "enabled", columnDefinition = "int(11)  DEFAULT 1 comment '启用状态 1启用 0禁用'")
   private Integer enabled;
   @ApiModelProperty(name = "isParent")
   @JsonProperty("isParent")
   @JSONField(name = "isParent")
   @TableField("is_parent")
   @Column(name = "is_parent")
   private Integer isParent;
   @ApiModelProperty(name = "name")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   @TableField("short_name")
   @Column(name = "short_name")
   private String shortName;
   @ApiModelProperty(name = "remark")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "socialCode")
   @JsonProperty("socialCode")
   @JSONField(name = "socialCode")
   @TableField("social_code")
   @Column(name = "social_code")
   private String socialCode;
   @ApiModelProperty(name = "sort")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "level")
   @JsonProperty("level")
   @JSONField(name = "level")
   @TableField("level")
   @Column(name = "level", columnDefinition = "int(11) default 2 COMMENT '单位层级 一级单位 二级单位'", nullable = false)
   private Integer level;
   @ApiModelProperty(name = "branchAttributeEnum", value = "分支机构-属性 1安装 2加工 4其他")
   @TableField("branch_attribute_enum")
   @Column(name = "branch_attribute_enum", columnDefinition = "int(11) default 0 COMMENT '分支机构-属性 1安装 2加工 4其他'", nullable = false)
   private Integer branchAttributeEnum;

   public static BranchCompany.BranchCompanyBuilder builder() {
      return new BranchCompany.BranchCompanyBuilder();
   }

   public BranchCompany() {
   }

   public BranchCompany(
      final Long id,
      final Integer enabled,
      final Integer isParent,
      final String name,
      final String shortName,
      final String remark,
      final String socialCode,
      final Integer sort,
      final Integer level,
      final Integer branchAttributeEnum
   ) {
      this.id = id;
      this.enabled = enabled;
      this.isParent = isParent;
      this.name = name;
      this.shortName = shortName;
      this.remark = remark;
      this.socialCode = socialCode;
      this.sort = sort;
      this.level = level;
      this.branchAttributeEnum = branchAttributeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getEnabled() {
      return this.enabled;
   }

   public Integer getIsParent() {
      return this.isParent;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getBranchAttributeEnum() {
      return this.branchAttributeEnum;
   }

   @JsonProperty("id")
   public BranchCompany setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("enabled")
   public BranchCompany setEnabled(final Integer enabled) {
      this.enabled = enabled;
      return this;
   }

   @JsonProperty("isParent")
   public BranchCompany setIsParent(final Integer isParent) {
      this.isParent = isParent;
      return this;
   }

   @JsonProperty("name")
   public BranchCompany setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public BranchCompany setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("remark")
   public BranchCompany setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("socialCode")
   public BranchCompany setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
      return this;
   }

   @JsonProperty("sort")
   public BranchCompany setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("level")
   public BranchCompany setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   public BranchCompany setBranchAttributeEnum(final Integer branchAttributeEnum) {
      this.branchAttributeEnum = branchAttributeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "BranchCompany(id="
         + this.getId()
         + ", enabled="
         + this.getEnabled()
         + ", isParent="
         + this.getIsParent()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", remark="
         + this.getRemark()
         + ", socialCode="
         + this.getSocialCode()
         + ", sort="
         + this.getSort()
         + ", level="
         + this.getLevel()
         + ", branchAttributeEnum="
         + this.getBranchAttributeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BranchCompany)) {
         return false;
      }

      BranchCompany other = (BranchCompany)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$enabled = this.getEnabled();
         Object other$enabled = other.getEnabled();
         if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
            Object this$isParent = this.getIsParent();
            Object other$isParent = other.getIsParent();
            if (this$isParent == null ? other$isParent == null : this$isParent.equals(other$isParent)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$level = this.getLevel();
                  Object other$level = other.getLevel();
                  if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                     Object this$branchAttributeEnum = this.getBranchAttributeEnum();
                     Object other$branchAttributeEnum = other.getBranchAttributeEnum();
                     if (this$branchAttributeEnum == null ? other$branchAttributeEnum == null : this$branchAttributeEnum.equals(other$branchAttributeEnum)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$shortName = this.getShortName();
                           Object other$shortName = other.getShortName();
                           if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$socialCode = this.getSocialCode();
                                 Object other$socialCode = other.getSocialCode();
                                 return this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode);
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
      return other instanceof BranchCompany;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $isParent = this.getIsParent();
      result = result * 59 + ($isParent == null ? 43 : $isParent.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $branchAttributeEnum = this.getBranchAttributeEnum();
      result = result * 59 + ($branchAttributeEnum == null ? 43 : $branchAttributeEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $socialCode = this.getSocialCode();
      return result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
   }

   public static class BranchCompanyBuilder {
      private Long id;
      private Integer enabled;
      private Integer isParent;
      private String name;
      private String shortName;
      private String remark;
      private String socialCode;
      private Integer sort;
      private Integer level;
      private Integer branchAttributeEnum;

      BranchCompanyBuilder() {
      }

      @JsonProperty("id")
      public BranchCompany.BranchCompanyBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("enabled")
      public BranchCompany.BranchCompanyBuilder enabled(final Integer enabled) {
         this.enabled = enabled;
         return this;
      }

      @JsonProperty("isParent")
      public BranchCompany.BranchCompanyBuilder isParent(final Integer isParent) {
         this.isParent = isParent;
         return this;
      }

      @JsonProperty("name")
      public BranchCompany.BranchCompanyBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public BranchCompany.BranchCompanyBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("remark")
      public BranchCompany.BranchCompanyBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("socialCode")
      public BranchCompany.BranchCompanyBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      @JsonProperty("sort")
      public BranchCompany.BranchCompanyBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("level")
      public BranchCompany.BranchCompanyBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public BranchCompany.BranchCompanyBuilder branchAttributeEnum(final Integer branchAttributeEnum) {
         this.branchAttributeEnum = branchAttributeEnum;
         return this;
      }

      public BranchCompany build() {
         return new BranchCompany(
            this.id, this.enabled, this.isParent, this.name, this.shortName, this.remark, this.socialCode, this.sort, this.level, this.branchAttributeEnum
         );
      }

      @Override
      public String toString() {
         return "BranchCompany.BranchCompanyBuilder(id="
            + this.id
            + ", enabled="
            + this.enabled
            + ", isParent="
            + this.isParent
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", remark="
            + this.remark
            + ", socialCode="
            + this.socialCode
            + ", sort="
            + this.sort
            + ", level="
            + this.level
            + ", branchAttributeEnum="
            + this.branchAttributeEnum
            + ")";
      }
   }
}
