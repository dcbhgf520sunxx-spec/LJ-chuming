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

@ApiModel(value = "MesBuildingWorkshop对象", description = "车间 ")
@Entity
@TableName("mes_building_workshop")
@Table(name = "mes_building_workshop")
public class MesBuildingWorkshop extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "车间名", notes = "车间名")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '车间名'", nullable = false)
   private String name;
   @ApiModelProperty(name = "shortName", value = "车间简名", notes = "车间简名")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   @TableField("short_name")
   @Column(name = "short_name", columnDefinition = "varchar(255)  COMMENT '车间简名'")
   private String shortName;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = true)
   private Integer sort;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "boolEnabledEnum", value = "禁用状态 启用状态 [0 禁用, 1 启用]", notes = "禁用状态 启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   @TableField("bool_enabled_enum")
   @Column(name = "bool_enabled_enum", columnDefinition = "tinyint(1) default '0' COMMENT '禁用状态 启用状态 [0 禁用, 1 启用]'", nullable = false)
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "type", value = "车间类型 1:建钢车间 2:桥梁车间 4:围护车间", notes = "车间类型  1:建钢车间 2:桥梁车间 4:围护车间")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '1' COMMENT '车间类型 1:建钢车间 2:桥梁车间 4:围护车间'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", notes = "生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default '1' COMMENT '生产线类型 1传统线 2智能线'", nullable = true)
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "ton", value = "目标产量", notes = "目标产量")
   @JsonProperty("ton")
   @JSONField(name = "ton")
   @TableField("ton")
   @Column(name = "ton", columnDefinition = "decimal(16,4) DEFAULT '0.0000' COMMENT '目标产量'", nullable = false)
   private BigDecimal ton;

   public static MesBuildingWorkshop.MesBuildingWorkshopBuilder builder() {
      return new MesBuildingWorkshop.MesBuildingWorkshopBuilder();
   }

   public MesBuildingWorkshop() {
   }

   public MesBuildingWorkshop(
      final Long id,
      final String name,
      final String shortName,
      final Integer sort,
      final Long userId,
      final Boolean boolEnabledEnum,
      final Long factoryId,
      final String remark,
      final Integer type,
      final Integer productionLineTypeEnum,
      final BigDecimal ton
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.sort = sort;
      this.userId = userId;
      this.boolEnabledEnum = boolEnabledEnum;
      this.factoryId = factoryId;
      this.remark = remark;
      this.type = type;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.ton = ton;
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

   public Integer getSort() {
      return this.sort;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public BigDecimal getTon() {
      return this.ton;
   }

   @JsonProperty("id")
   public MesBuildingWorkshop setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingWorkshop setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public MesBuildingWorkshop setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingWorkshop setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingWorkshop setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingWorkshop setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingWorkshop setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingWorkshop setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingWorkshop setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingWorkshop setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("ton")
   public MesBuildingWorkshop setTon(final BigDecimal ton) {
      this.ton = ton;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWorkshop(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", sort="
         + this.getSort()
         + ", userId="
         + this.getUserId()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", factoryId="
         + this.getFactoryId()
         + ", remark="
         + this.getRemark()
         + ", type="
         + this.getType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", ton="
         + this.getTon()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWorkshop)) {
         return false;
      }

      MesBuildingWorkshop other = (MesBuildingWorkshop)o;
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
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$boolEnabledEnum = this.getBoolEnabledEnum();
               Object other$boolEnabledEnum = other.getBoolEnabledEnum();
               if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                        Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                        if (this$productionLineTypeEnum == null
                           ? other$productionLineTypeEnum == null
                           : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$shortName = this.getShortName();
                              Object other$shortName = other.getShortName();
                              if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$ton = this.getTon();
                                    Object other$ton = other.getTon();
                                    return this$ton == null ? other$ton == null : this$ton.equals(other$ton);
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
      return other instanceof MesBuildingWorkshop;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $ton = this.getTon();
      return result * 59 + ($ton == null ? 43 : $ton.hashCode());
   }

   public static class MesBuildingWorkshopBuilder {
      private Long id;
      private String name;
      private String shortName;
      private Integer sort;
      private Long userId;
      private Boolean boolEnabledEnum;
      private Long factoryId;
      private String remark;
      private Integer type;
      private Integer productionLineTypeEnum;
      private BigDecimal ton;

      MesBuildingWorkshopBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("ton")
      public MesBuildingWorkshop.MesBuildingWorkshopBuilder ton(final BigDecimal ton) {
         this.ton = ton;
         return this;
      }

      public MesBuildingWorkshop build() {
         return new MesBuildingWorkshop(
            this.id,
            this.name,
            this.shortName,
            this.sort,
            this.userId,
            this.boolEnabledEnum,
            this.factoryId,
            this.remark,
            this.type,
            this.productionLineTypeEnum,
            this.ton
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWorkshop.MesBuildingWorkshopBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", sort="
            + this.sort
            + ", userId="
            + this.userId
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", factoryId="
            + this.factoryId
            + ", remark="
            + this.remark
            + ", type="
            + this.type
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", ton="
            + this.ton
            + ")";
      }
   }
}
