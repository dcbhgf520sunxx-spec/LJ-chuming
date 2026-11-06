package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class MesBuildingFactoryDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工厂名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "工厂简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "tagColor", notes = "标签颜色")
   @JsonProperty("tagColor")
   @JSONField(name = "tagColor")
   private String tagColor;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "userId", notes = "操作人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   @JsonProperty("branchCompanyId")
   @JSONField(name = "branchCompanyId")
   private Long branchCompanyId;
   @ApiModelProperty(name = "workshopList", notes = "车间列表", value = "车间列表")
   @JsonProperty("workshopList")
   @JSONField(name = "workshopList")
   private List<MesBuildingWorkshopDO> workshopList;

   public static MesBuildingFactoryDO.MesBuildingFactoryDOBuilder builder() {
      return new MesBuildingFactoryDO.MesBuildingFactoryDOBuilder();
   }

   public MesBuildingFactoryDO(
      final Long id,
      final String name,
      final String shortName,
      final String tagColor,
      final Boolean boolEnabledEnum,
      final Integer sort,
      final String remark,
      final Long userId,
      final Long branchCompanyId,
      final List<MesBuildingWorkshopDO> workshopList
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.tagColor = tagColor;
      this.boolEnabledEnum = boolEnabledEnum;
      this.sort = sort;
      this.remark = remark;
      this.userId = userId;
      this.branchCompanyId = branchCompanyId;
      this.workshopList = workshopList;
   }

   public MesBuildingFactoryDO() {
   }

   public Long getId() {
      return this.id;
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

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public List<MesBuildingWorkshopDO> getWorkshopList() {
      return this.workshopList;
   }

   @JsonProperty("id")
   public MesBuildingFactoryDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingFactoryDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public MesBuildingFactoryDO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("tagColor")
   public MesBuildingFactoryDO setTagColor(final String tagColor) {
      this.tagColor = tagColor;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingFactoryDO setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingFactoryDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingFactoryDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingFactoryDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("branchCompanyId")
   public MesBuildingFactoryDO setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @JsonProperty("workshopList")
   public MesBuildingFactoryDO setWorkshopList(final List<MesBuildingWorkshopDO> workshopList) {
      this.workshopList = workshopList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingFactoryDO(id="
         + this.getId()
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
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", workshopList="
         + this.getWorkshopList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingFactoryDO)) {
         return false;
      }

      MesBuildingFactoryDO other = (MesBuildingFactoryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolEnabledEnum = this.getBoolEnabledEnum();
         Object other$boolEnabledEnum = other.getBoolEnabledEnum();
         if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$branchCompanyId = this.getBranchCompanyId();
                  Object other$branchCompanyId = other.getBranchCompanyId();
                  if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
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
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$workshopList = this.getWorkshopList();
                                 Object other$workshopList = other.getWorkshopList();
                                 return this$workshopList == null ? other$workshopList == null : this$workshopList.equals(other$workshopList);
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
      return other instanceof MesBuildingFactoryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $tagColor = this.getTagColor();
      result = result * 59 + ($tagColor == null ? 43 : $tagColor.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $workshopList = this.getWorkshopList();
      return result * 59 + ($workshopList == null ? 43 : $workshopList.hashCode());
   }

   public static class MesBuildingFactoryDOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String tagColor;
      private Boolean boolEnabledEnum;
      private Integer sort;
      private String remark;
      private Long userId;
      private Long branchCompanyId;
      private List<MesBuildingWorkshopDO> workshopList;

      MesBuildingFactoryDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("tagColor")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder tagColor(final String tagColor) {
         this.tagColor = tagColor;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("branchCompanyId")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      @JsonProperty("workshopList")
      public MesBuildingFactoryDO.MesBuildingFactoryDOBuilder workshopList(final List<MesBuildingWorkshopDO> workshopList) {
         this.workshopList = workshopList;
         return this;
      }

      public MesBuildingFactoryDO build() {
         return new MesBuildingFactoryDO(
            this.id,
            this.name,
            this.shortName,
            this.tagColor,
            this.boolEnabledEnum,
            this.sort,
            this.remark,
            this.userId,
            this.branchCompanyId,
            this.workshopList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingFactoryDO.MesBuildingFactoryDOBuilder(id="
            + this.id
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
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", workshopList="
            + this.workshopList
            + ")";
      }
   }
}
