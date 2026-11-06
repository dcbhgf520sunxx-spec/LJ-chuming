package com.hzchum.scim.mes.building.core.api.pojo._doModel.factory;

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

@ApiModel(value = "MesBuildingFactory对象", description = "")
@Entity
@TableName("mes_building_factory")
@Table(name = "mes_building_factory")
public class MesBuildingFactory extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   @JsonProperty("branchCompanyId")
   @JSONField(name = "branchCompanyId")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构id'", nullable = false)
   private Long branchCompanyId;
   @ApiModelProperty(name = "name", value = "工厂名称", notes = "工厂名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '工厂名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "shortName", value = "工厂简称", notes = "工厂简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   @TableField("short_name")
   @Column(name = "short_name", columnDefinition = "varchar(255)  COMMENT '工厂简称'", nullable = true)
   private String shortName;
   @ApiModelProperty(name = "tagColor", value = "标签颜色", notes = "标签颜色")
   @JsonProperty("tagColor")
   @JSONField(name = "tagColor")
   @TableField("tag_color")
   @Column(name = "tag_color", columnDefinition = "varchar(255)  COMMENT '标签颜色'", nullable = true)
   private String tagColor;
   @ApiModelProperty(name = "boolEnabledEnum", value = "启用状态 [0 禁用, 1 启用]", notes = "启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   @TableField("bool_enabled_enum")
   @Column(name = "bool_enabled_enum", columnDefinition = "tinyint(1) default '1' COMMENT '启用状态 [0 禁用, 1 启用]'", nullable = true)
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = true)
   private Integer sort;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = false)
   private Long userId;

   public static MesBuildingFactory.MesBuildingFactoryBuilder builder() {
      return new MesBuildingFactory.MesBuildingFactoryBuilder();
   }

   public MesBuildingFactory() {
   }

   public MesBuildingFactory(
      final Long id,
      final Long branchCompanyId,
      final String name,
      final String shortName,
      final String tagColor,
      final Boolean boolEnabledEnum,
      final Integer sort,
      final String remark,
      final Long userId
   ) {
      this.id = id;
      this.branchCompanyId = branchCompanyId;
      this.name = name;
      this.shortName = shortName;
      this.tagColor = tagColor;
      this.boolEnabledEnum = boolEnabledEnum;
      this.sort = sort;
      this.remark = remark;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getTagColor() {
      return this.tagColor;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingFactory setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("branchCompanyId")
   public MesBuildingFactory setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingFactory setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public MesBuildingFactory setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("tagColor")
   public MesBuildingFactory setTagColor(final String tagColor) {
      this.tagColor = tagColor;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingFactory setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingFactory setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingFactory setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingFactory setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingFactory(id="
         + this.getId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", tagColor="
         + this.getTagColor()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingFactory)) {
         return false;
      }

      MesBuildingFactory other = (MesBuildingFactory)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$boolEnabledEnum = this.getBoolEnabledEnum();
            Object other$boolEnabledEnum = other.getBoolEnabledEnum();
            if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$shortName = this.getShortName();
                        Object other$shortName = other.getShortName();
                        if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                           Object this$tagColor = this.getTagColor();
                           Object other$tagColor = other.getTagColor();
                           if (this$tagColor == null ? other$tagColor == null : this$tagColor.equals(other$tagColor)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof MesBuildingFactory;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $tagColor = this.getTagColor();
      result = result * 59 + ($tagColor == null ? 43 : $tagColor.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MesBuildingFactoryBuilder {
      private Long id;
      private Long branchCompanyId;
      private String name;
      private String shortName;
      private String tagColor;
      private Boolean boolEnabledEnum;
      private Integer sort;
      private String remark;
      private Long userId;

      MesBuildingFactoryBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingFactory.MesBuildingFactoryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("branchCompanyId")
      public MesBuildingFactory.MesBuildingFactoryBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingFactory.MesBuildingFactoryBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public MesBuildingFactory.MesBuildingFactoryBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("tagColor")
      public MesBuildingFactory.MesBuildingFactoryBuilder tagColor(final String tagColor) {
         this.tagColor = tagColor;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingFactory.MesBuildingFactoryBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingFactory.MesBuildingFactoryBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingFactory.MesBuildingFactoryBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingFactory.MesBuildingFactoryBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingFactory build() {
         return new MesBuildingFactory(
            this.id, this.branchCompanyId, this.name, this.shortName, this.tagColor, this.boolEnabledEnum, this.sort, this.remark, this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingFactory.MesBuildingFactoryBuilder(id="
            + this.id
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", tagColor="
            + this.tagColor
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
