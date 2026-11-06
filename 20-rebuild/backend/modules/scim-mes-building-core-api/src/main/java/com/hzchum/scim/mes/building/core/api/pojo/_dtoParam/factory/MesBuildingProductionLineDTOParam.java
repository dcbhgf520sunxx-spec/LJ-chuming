package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingProductionLineDTO对象", description = "")
public class MesBuildingProductionLineDTOParam extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "禁用状态 禁用状态 启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "userId", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "linkIdList", value = "可生产列表", notes = "可生产列表")
   @JsonProperty("linkIdList")
   @JSONField(name = "linkIdList")
   private List<Long> linkIdList;
   @ApiModelProperty(name = "targetProduction", value = "目标产量", notes = "目标产量")
   @JsonProperty("targetProduction")
   @JSONField(name = "targetProduction")
   private BigDecimal targetProduction;
   @ApiModelProperty("mes分类 1建刚 2桥梁")
   @JsonProperty("mesProductEnum")
   @JSONField(name = "mesProductEnum")
   private Integer mesProductEnum;

   public static MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder builder() {
      return new MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public List<Long> getLinkIdList() {
      return this.linkIdList;
   }

   public BigDecimal getTargetProduction() {
      return this.targetProduction;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("id")
   public MesBuildingProductionLineDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProductionLineDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProductionLineDTOParam setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingProductionLineDTOParam setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingProductionLineDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingProductionLineDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingProductionLineDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProductionLineDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductionLineDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingProductionLineDTOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("linkIdList")
   public MesBuildingProductionLineDTOParam setLinkIdList(final List<Long> linkIdList) {
      this.linkIdList = linkIdList;
      return this;
   }

   @JsonProperty("targetProduction")
   public MesBuildingProductionLineDTOParam setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   @JsonProperty("mesProductEnum")
   public MesBuildingProductionLineDTOParam setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductionLineDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", remark="
         + this.getRemark()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", userId="
         + this.getUserId()
         + ", productType="
         + this.getProductType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", linkIdList="
         + this.getLinkIdList()
         + ", targetProduction="
         + this.getTargetProduction()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   public MesBuildingProductionLineDTOParam(
      final Long id,
      final String name,
      final Integer sort,
      final Boolean boolEnabledEnum,
      final String remark,
      final Long factoryId,
      final Long workshopId,
      final Long userId,
      final Integer productType,
      final Integer productionLineTypeEnum,
      final List<Long> linkIdList,
      final BigDecimal targetProduction,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.boolEnabledEnum = boolEnabledEnum;
      this.remark = remark;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.userId = userId;
      this.productType = productType;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.linkIdList = linkIdList;
      this.targetProduction = targetProduction;
      this.mesProductEnum = mesProductEnum;
   }

   public MesBuildingProductionLineDTOParam() {
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionLineDTOParam)) {
         return false;
      }

      MesBuildingProductionLineDTOParam other = (MesBuildingProductionLineDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$boolEnabledEnum = this.getBoolEnabledEnum();
            Object other$boolEnabledEnum = other.getBoolEnabledEnum();
            if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                           Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                           if (this$productionLineTypeEnum == null
                              ? other$productionLineTypeEnum == null
                              : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                              Object this$mesProductEnum = this.getMesProductEnum();
                              Object other$mesProductEnum = other.getMesProductEnum();
                              if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$linkIdList = this.getLinkIdList();
                                       Object other$linkIdList = other.getLinkIdList();
                                       if (this$linkIdList == null ? other$linkIdList == null : this$linkIdList.equals(other$linkIdList)) {
                                          Object this$targetProduction = this.getTargetProduction();
                                          Object other$targetProduction = other.getTargetProduction();
                                          return this$targetProduction == null
                                             ? other$targetProduction == null
                                             : this$targetProduction.equals(other$targetProduction);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductionLineDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $linkIdList = this.getLinkIdList();
      result = result * 59 + ($linkIdList == null ? 43 : $linkIdList.hashCode());
      Object $targetProduction = this.getTargetProduction();
      return result * 59 + ($targetProduction == null ? 43 : $targetProduction.hashCode());
   }

   public static class MesBuildingProductionLineDTOParamBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Boolean boolEnabledEnum;
      private String remark;
      private Long factoryId;
      private Long workshopId;
      private Long userId;
      private Integer productType;
      private Integer productionLineTypeEnum;
      private List<Long> linkIdList;
      private BigDecimal targetProduction;
      private Integer mesProductEnum;

      MesBuildingProductionLineDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("linkIdList")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder linkIdList(final List<Long> linkIdList) {
         this.linkIdList = linkIdList;
         return this;
      }

      @JsonProperty("targetProduction")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      @JsonProperty("mesProductEnum")
      public MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesBuildingProductionLineDTOParam build() {
         return new MesBuildingProductionLineDTOParam(
            this.id,
            this.name,
            this.sort,
            this.boolEnabledEnum,
            this.remark,
            this.factoryId,
            this.workshopId,
            this.userId,
            this.productType,
            this.productionLineTypeEnum,
            this.linkIdList,
            this.targetProduction,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductionLineDTOParam.MesBuildingProductionLineDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", remark="
            + this.remark
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", userId="
            + this.userId
            + ", productType="
            + this.productType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", linkIdList="
            + this.linkIdList
            + ", targetProduction="
            + this.targetProduction
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
