package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory;

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

@ApiModel(value = "MesEnclosureProductionLine对象", description = "生产线 ")
@Entity
@TableName("mes_enclosure_production_line")
@Table(name = "mes_enclosure_production_line")
public class MesEnclosureProductionLine extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "type", value = "围护类型 2压型彩板 4夹心板 8桁架楼承板 16压型楼承板 32折边件", notes = "围护类型 2压型彩板 4夹心板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '围护类型 2压型彩板 4夹心板 8桁架楼承板 16压型楼承板 32折边件'", nullable = true)
   private Integer type;

   public static MesEnclosureProductionLine.MesEnclosureProductionLineBuilder builder() {
      return new MesEnclosureProductionLine.MesEnclosureProductionLineBuilder();
   }

   public MesEnclosureProductionLine() {
   }

   public MesEnclosureProductionLine(
      final Long id,
      final String name,
      final Integer sort,
      final Boolean boolEnabledEnum,
      final String remark,
      final Long factoryId,
      final Long workshopId,
      final Long userId,
      final BigDecimal targetProduction,
      final Integer type
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.boolEnabledEnum = boolEnabledEnum;
      this.remark = remark;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.userId = userId;
      this.targetProduction = targetProduction;
      this.type = type;
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

   public BigDecimal getTargetProduction() {
      return this.targetProduction;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public MesEnclosureProductionLine setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureProductionLine setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public MesEnclosureProductionLine setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesEnclosureProductionLine setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureProductionLine setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureProductionLine setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureProductionLine setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureProductionLine setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("targetProduction")
   public MesEnclosureProductionLine setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   @JsonProperty("type")
   public MesEnclosureProductionLine setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductionLine(id="
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
         + ", targetProduction="
         + this.getTargetProduction()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductionLine)) {
         return false;
      }

      MesEnclosureProductionLine other = (MesEnclosureProductionLine)o;
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
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$targetProduction = this.getTargetProduction();
                                 Object other$targetProduction = other.getTargetProduction();
                                 return this$targetProduction == null ? other$targetProduction == null : this$targetProduction.equals(other$targetProduction);
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
      return other instanceof MesEnclosureProductionLine;
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
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $targetProduction = this.getTargetProduction();
      return result * 59 + ($targetProduction == null ? 43 : $targetProduction.hashCode());
   }

   public static class MesEnclosureProductionLineBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Boolean boolEnabledEnum;
      private String remark;
      private Long factoryId;
      private Long workshopId;
      private Long userId;
      private BigDecimal targetProduction;
      private Integer type;

      MesEnclosureProductionLineBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("targetProduction")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      @JsonProperty("type")
      public MesEnclosureProductionLine.MesEnclosureProductionLineBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesEnclosureProductionLine build() {
         return new MesEnclosureProductionLine(
            this.id, this.name, this.sort, this.boolEnabledEnum, this.remark, this.factoryId, this.workshopId, this.userId, this.targetProduction, this.type
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProductionLine.MesEnclosureProductionLineBuilder(id="
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
            + ", targetProduction="
            + this.targetProduction
            + ", type="
            + this.type
            + ")";
      }
   }
}
