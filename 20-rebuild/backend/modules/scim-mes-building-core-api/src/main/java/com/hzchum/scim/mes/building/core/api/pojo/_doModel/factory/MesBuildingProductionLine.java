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
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingProductionLine对象", description = "生产线 ")
@Entity
@TableName("mes_building_production_line")
@Table(name = "mes_building_production_line")
public class MesBuildingProductionLine extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "生产线名称", notes = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '生产线名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = true)
   private Integer sort;
   @ApiModelProperty(name = "boolEnabledEnum", value = "禁用状态 禁用状态 启用状态 [0 禁用, 1 启用]", notes = "禁用状态 禁用状态 启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   @TableField("bool_enabled_enum")
   @Column(name = "bool_enabled_enum", columnDefinition = "tinyint(1) default '0' COMMENT '禁用状态 禁用状态 启用状态 [0 禁用, 1 启用]'", nullable = false)
   private Boolean boolEnabledEnum;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default 1 COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "targetProduction", value = "目标产量", notes = "目标产量")
   @JsonProperty("targetProduction")
   @JSONField(name = "targetProduction")
   @TableField("target_production")
   @Column(name = "target_production", columnDefinition = "decimal(32,8)  default '0' COMMENT '目标产量'", nullable = true)
   private BigDecimal targetProduction;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static MesBuildingProductionLine.MesBuildingProductionLineBuilder builder() {
      return new MesBuildingProductionLine.MesBuildingProductionLineBuilder();
   }

   public MesBuildingProductionLine() {
   }

   public MesBuildingProductionLine(
      final Long id,
      final String name,
      final Integer productType,
      final Integer sort,
      final Boolean boolEnabledEnum,
      final Integer productionLineTypeEnum,
      final String remark,
      final Long factoryId,
      final Long workshopId,
      final Long userId,
      final BigDecimal targetProduction,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.name = name;
      this.productType = productType;
      this.sort = sort;
      this.boolEnabledEnum = boolEnabledEnum;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.remark = remark;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.userId = userId;
      this.targetProduction = targetProduction;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
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

   public BigDecimal getTargetProduction() {
      return this.targetProduction;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("id")
   public MesBuildingProductionLine setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProductionLine setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductionLine setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProductionLine setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingProductionLine setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingProductionLine setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingProductionLine setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingProductionLine setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingProductionLine setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProductionLine setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("targetProduction")
   public MesBuildingProductionLine setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   public MesBuildingProductionLine setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductionLine(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", sort="
         + this.getSort()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", remark="
         + this.getRemark()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", userId="
         + this.getUserId()
         + ", targetProduction="
         + this.getTargetProduction()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionLine)) {
         return false;
      }

      MesBuildingProductionLine other = (MesBuildingProductionLine)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$boolEnabledEnum = this.getBoolEnabledEnum();
               Object other$boolEnabledEnum = other.getBoolEnabledEnum();
               if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
                  Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                  Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                  if (this$productionLineTypeEnum == null
                     ? other$productionLineTypeEnum == null
                     : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                     Object this$factoryId = this.getFactoryId();
                     Object other$factoryId = other.getFactoryId();
                     if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$mesProductEnum = this.getMesProductEnum();
                              Object other$mesProductEnum = other.getMesProductEnum();
                              if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductionLine;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $targetProduction = this.getTargetProduction();
      return result * 59 + ($targetProduction == null ? 43 : $targetProduction.hashCode());
   }

   public static class MesBuildingProductionLineBuilder {
      private Long id;
      private String name;
      private Integer productType;
      private Integer sort;
      private Boolean boolEnabledEnum;
      private Integer productionLineTypeEnum;
      private String remark;
      private Long factoryId;
      private Long workshopId;
      private Long userId;
      private BigDecimal targetProduction;
      private Integer mesProductEnum;

      MesBuildingProductionLineBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("targetProduction")
      public MesBuildingProductionLine.MesBuildingProductionLineBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      public MesBuildingProductionLine.MesBuildingProductionLineBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesBuildingProductionLine build() {
         return new MesBuildingProductionLine(
            this.id,
            this.name,
            this.productType,
            this.sort,
            this.boolEnabledEnum,
            this.productionLineTypeEnum,
            this.remark,
            this.factoryId,
            this.workshopId,
            this.userId,
            this.targetProduction,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductionLine.MesBuildingProductionLineBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productType="
            + this.productType
            + ", sort="
            + this.sort
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", remark="
            + this.remark
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", userId="
            + this.userId
            + ", targetProduction="
            + this.targetProduction
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
