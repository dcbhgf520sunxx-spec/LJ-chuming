package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingProductionLineDTO对象", description = "")
public class MesBuildingProductionLineDO extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "factoryName", notes = "工厂名", value = "工厂名")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
   @ApiModelProperty(name = "workshopName", notes = "车间名", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "typeList", notes = "可生产类型/定义代码", value = "可生产类型/定义代码")
   @JsonProperty("typeList")
   @JSONField(name = "typeList")
   @JsonInclude(Include.NON_NULL)
   private List<IdAndNameDO> typeList;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "targetProduction", value = "目标产量", notes = "目标产量")
   @JsonProperty("targetProduction")
   @JSONField(name = "targetProduction")
   private BigDecimal targetProduction;
   @ApiModelProperty("是否配置工序")
   private Boolean hasProcess;
   @ApiModelProperty(name = "groupsList", notes = "生产组列表", value = "生产组列表")
   @JsonProperty("groupsList")
   @JSONField(name = "groupsList")
   @JsonInclude(Include.NON_NULL)
   private List<MesBuildingGroupsDO> groupsList;

   public static MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder builder() {
      return new MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder();
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

   public String getFactoryName() {
      return this.factoryName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public List<IdAndNameDO> getTypeList() {
      return this.typeList;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public BigDecimal getTargetProduction() {
      return this.targetProduction;
   }

   public Boolean getHasProcess() {
      return this.hasProcess;
   }

   public List<MesBuildingGroupsDO> getGroupsList() {
      return this.groupsList;
   }

   @JsonProperty("id")
   public MesBuildingProductionLineDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProductionLineDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProductionLineDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingProductionLineDO setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingProductionLineDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingProductionLineDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingProductionLineDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProductionLineDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductionLineDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("factoryName")
   public MesBuildingProductionLineDO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingProductionLineDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("typeList")
   public MesBuildingProductionLineDO setTypeList(final List<IdAndNameDO> typeList) {
      this.typeList = typeList;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingProductionLineDO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("targetProduction")
   public MesBuildingProductionLineDO setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   public MesBuildingProductionLineDO setHasProcess(final Boolean hasProcess) {
      this.hasProcess = hasProcess;
      return this;
   }

   @JsonProperty("groupsList")
   public MesBuildingProductionLineDO setGroupsList(final List<MesBuildingGroupsDO> groupsList) {
      this.groupsList = groupsList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductionLineDO(id="
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
         + ", factoryName="
         + this.getFactoryName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", typeList="
         + this.getTypeList()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", targetProduction="
         + this.getTargetProduction()
         + ", hasProcess="
         + this.getHasProcess()
         + ", groupsList="
         + this.getGroupsList()
         + ")";
   }

   public MesBuildingProductionLineDO(
      final Long id,
      final String name,
      final Integer sort,
      final Boolean boolEnabledEnum,
      final String remark,
      final Long factoryId,
      final Long workshopId,
      final Long userId,
      final Integer productType,
      final String factoryName,
      final String workshopName,
      final List<IdAndNameDO> typeList,
      final Integer productionLineTypeEnum,
      final BigDecimal targetProduction,
      final Boolean hasProcess,
      final List<MesBuildingGroupsDO> groupsList
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
      this.factoryName = factoryName;
      this.workshopName = workshopName;
      this.typeList = typeList;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.targetProduction = targetProduction;
      this.hasProcess = hasProcess;
      this.groupsList = groupsList;
   }

   public MesBuildingProductionLineDO() {
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionLineDO)) {
         return false;
      }

      MesBuildingProductionLineDO other = (MesBuildingProductionLineDO)o;
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
                              Object this$hasProcess = this.getHasProcess();
                              Object other$hasProcess = other.getHasProcess();
                              if (this$hasProcess == null ? other$hasProcess == null : this$hasProcess.equals(other$hasProcess)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$factoryName = this.getFactoryName();
                                       Object other$factoryName = other.getFactoryName();
                                       if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                                          Object this$workshopName = this.getWorkshopName();
                                          Object other$workshopName = other.getWorkshopName();
                                          if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                             Object this$typeList = this.getTypeList();
                                             Object other$typeList = other.getTypeList();
                                             if (this$typeList == null ? other$typeList == null : this$typeList.equals(other$typeList)) {
                                                Object this$targetProduction = this.getTargetProduction();
                                                Object other$targetProduction = other.getTargetProduction();
                                                if (this$targetProduction == null
                                                   ? other$targetProduction == null
                                                   : this$targetProduction.equals(other$targetProduction)) {
                                                   Object this$groupsList = this.getGroupsList();
                                                   Object other$groupsList = other.getGroupsList();
                                                   return this$groupsList == null ? other$groupsList == null : this$groupsList.equals(other$groupsList);
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
      return other instanceof MesBuildingProductionLineDO;
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
      Object $hasProcess = this.getHasProcess();
      result = result * 59 + ($hasProcess == null ? 43 : $hasProcess.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $typeList = this.getTypeList();
      result = result * 59 + ($typeList == null ? 43 : $typeList.hashCode());
      Object $targetProduction = this.getTargetProduction();
      result = result * 59 + ($targetProduction == null ? 43 : $targetProduction.hashCode());
      Object $groupsList = this.getGroupsList();
      return result * 59 + ($groupsList == null ? 43 : $groupsList.hashCode());
   }

   public static class MesBuildingProductionLineDOBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Boolean boolEnabledEnum;
      private String remark;
      private Long factoryId;
      private Long workshopId;
      private Long userId;
      private Integer productType;
      private String factoryName;
      private String workshopName;
      private List<IdAndNameDO> typeList;
      private Integer productionLineTypeEnum;
      private BigDecimal targetProduction;
      private Boolean hasProcess;
      private List<MesBuildingGroupsDO> groupsList;

      MesBuildingProductionLineDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("factoryName")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("typeList")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder typeList(final List<IdAndNameDO> typeList) {
         this.typeList = typeList;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("targetProduction")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder hasProcess(final Boolean hasProcess) {
         this.hasProcess = hasProcess;
         return this;
      }

      @JsonProperty("groupsList")
      public MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder groupsList(final List<MesBuildingGroupsDO> groupsList) {
         this.groupsList = groupsList;
         return this;
      }

      public MesBuildingProductionLineDO build() {
         return new MesBuildingProductionLineDO(
            this.id,
            this.name,
            this.sort,
            this.boolEnabledEnum,
            this.remark,
            this.factoryId,
            this.workshopId,
            this.userId,
            this.productType,
            this.factoryName,
            this.workshopName,
            this.typeList,
            this.productionLineTypeEnum,
            this.targetProduction,
            this.hasProcess,
            this.groupsList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductionLineDO.MesBuildingProductionLineDOBuilder(id="
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
            + ", factoryName="
            + this.factoryName
            + ", workshopName="
            + this.workshopName
            + ", typeList="
            + this.typeList
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", targetProduction="
            + this.targetProduction
            + ", hasProcess="
            + this.hasProcess
            + ", groupsList="
            + this.groupsList
            + ")";
      }
   }
}
