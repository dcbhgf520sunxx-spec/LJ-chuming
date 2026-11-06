package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

public class MesBuildingFactoryDTOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "branchCompanyId", notes = "分支机构id", value = "分支机构id")
   @JsonProperty("branchCompanyId")
   @JSONField(name = "branchCompanyId")
   private Long branchCompanyId;
   @ApiModelProperty(name = "name", notes = "工厂名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "工厂简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "shortName", notes = "工厂简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String product_type;
   @ApiModelProperty(name = "tagColor", notes = "标签颜色")
   @JsonProperty("tagColor")
   @JSONField(name = "tagColor")
   private String tagColor;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
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
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @JsonProperty("mesProductEnum")
   @JSONField(name = "mesProductEnum")
   private Integer mesProductEnum;

   public static MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder builder() {
      return new MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder();
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

   public String getProduct_type() {
      return this.product_type;
   }

   public String getTagColor() {
      return this.tagColor;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
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

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("id")
   public MesBuildingFactoryDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("branchCompanyId")
   public MesBuildingFactoryDTOParam setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingFactoryDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public MesBuildingFactoryDTOParam setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("shortName")
   public MesBuildingFactoryDTOParam setProduct_type(final String product_type) {
      this.product_type = product_type;
      return this;
   }

   @JsonProperty("tagColor")
   public MesBuildingFactoryDTOParam setTagColor(final String tagColor) {
      this.tagColor = tagColor;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingFactoryDTOParam setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingFactoryDTOParam setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingFactoryDTOParam setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingFactoryDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingFactoryDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("mesProductEnum")
   public MesBuildingFactoryDTOParam setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingFactoryDTOParam(id="
         + this.getId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", product_type="
         + this.getProduct_type()
         + ", tagColor="
         + this.getTagColor()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingFactoryDTOParam)) {
         return false;
      }

      MesBuildingFactoryDTOParam other = (MesBuildingFactoryDTOParam)o;
      if (!other.canEqual(this)) {
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
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$mesProductEnum = this.getMesProductEnum();
                        Object other$mesProductEnum = other.getMesProductEnum();
                        if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$shortName = this.getShortName();
                              Object other$shortName = other.getShortName();
                              if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                 Object this$product_type = this.getProduct_type();
                                 Object other$product_type = other.getProduct_type();
                                 if (this$product_type == null ? other$product_type == null : this$product_type.equals(other$product_type)) {
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
      return other instanceof MesBuildingFactoryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $product_type = this.getProduct_type();
      result = result * 59 + ($product_type == null ? 43 : $product_type.hashCode());
      Object $tagColor = this.getTagColor();
      result = result * 59 + ($tagColor == null ? 43 : $tagColor.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public MesBuildingFactoryDTOParam(
      final Long id,
      final Long branchCompanyId,
      final String name,
      final String shortName,
      final String product_type,
      final String tagColor,
      final Boolean boolEnabledEnum,
      final Integer taskTypeEnum,
      final Integer sort,
      final String remark,
      final Long userId,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.branchCompanyId = branchCompanyId;
      this.name = name;
      this.shortName = shortName;
      this.product_type = product_type;
      this.tagColor = tagColor;
      this.boolEnabledEnum = boolEnabledEnum;
      this.taskTypeEnum = taskTypeEnum;
      this.sort = sort;
      this.remark = remark;
      this.userId = userId;
      this.mesProductEnum = mesProductEnum;
   }

   public MesBuildingFactoryDTOParam() {
   }

   public static class MesBuildingFactoryDTOParamBuilder {
      private Long id;
      private Long branchCompanyId;
      private String name;
      private String shortName;
      private String product_type;
      private String tagColor;
      private Boolean boolEnabledEnum;
      private Integer taskTypeEnum;
      private Integer sort;
      private String remark;
      private Long userId;
      private Integer mesProductEnum;

      MesBuildingFactoryDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("branchCompanyId")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("shortName")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder product_type(final String product_type) {
         this.product_type = product_type;
         return this;
      }

      @JsonProperty("tagColor")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder tagColor(final String tagColor) {
         this.tagColor = tagColor;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("mesProductEnum")
      public MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesBuildingFactoryDTOParam build() {
         return new MesBuildingFactoryDTOParam(
            this.id,
            this.branchCompanyId,
            this.name,
            this.shortName,
            this.product_type,
            this.tagColor,
            this.boolEnabledEnum,
            this.taskTypeEnum,
            this.sort,
            this.remark,
            this.userId,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingFactoryDTOParam.MesBuildingFactoryDTOParamBuilder(id="
            + this.id
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", product_type="
            + this.product_type
            + ", tagColor="
            + this.tagColor
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
