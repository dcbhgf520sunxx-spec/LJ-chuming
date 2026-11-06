package com.hzchum.scim.mes.building.core.api.pojo._doModel.factory;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingWarehouse对象", description = "库位表")
@Entity
@TableName("mes_building_warehouse")
@Table(name = "mes_building_warehouse")
@org.hibernate.annotations.Table(appliesTo = "mes_building_warehouse", comment = "库位表")
public class MesBuildingWarehouse extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "库位名称", notes = "库位名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '库位名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "boolEnableEnum", value = "开启状态 1开启 0禁用", notes = "开启状态 1开启 0禁用")
   @TableField("bool_enable_Enum")
   @Column(name = "bool_enable_Enum", columnDefinition = "tinyint(1) default '1' COMMENT '开启状态 1开启 0禁用'", nullable = false)
   private Boolean boolEnableEnum;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(1) default '1' COMMENT '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;

   public static MesBuildingWarehouse.MesBuildingWarehouseBuilder builder() {
      return new MesBuildingWarehouse.MesBuildingWarehouseBuilder();
   }

   public MesBuildingWarehouse() {
   }

   public MesBuildingWarehouse(
      final Long id,
      final String name,
      final Long workshopId,
      final Long factoryId,
      final Boolean boolEnableEnum,
      final Integer sort,
      final String remark,
      final Long createUserId
   ) {
      this.id = id;
      this.name = name;
      this.workshopId = workshopId;
      this.factoryId = factoryId;
      this.boolEnableEnum = boolEnableEnum;
      this.sort = sort;
      this.remark = remark;
      this.createUserId = createUserId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Boolean getBoolEnableEnum() {
      return this.boolEnableEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public MesBuildingWarehouse setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingWarehouse setName(final String name) {
      this.name = name;
      return this;
   }

   public MesBuildingWarehouse setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesBuildingWarehouse setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public MesBuildingWarehouse setBoolEnableEnum(final Boolean boolEnableEnum) {
      this.boolEnableEnum = boolEnableEnum;
      return this;
   }

   public MesBuildingWarehouse setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public MesBuildingWarehouse setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MesBuildingWarehouse setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWarehouse(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", factoryId="
         + this.getFactoryId()
         + ", boolEnableEnum="
         + this.getBoolEnableEnum()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWarehouse)) {
         return false;
      }

      MesBuildingWarehouse other = (MesBuildingWarehouse)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$boolEnableEnum = this.getBoolEnableEnum();
               Object other$boolEnableEnum = other.getBoolEnableEnum();
               if (this$boolEnableEnum == null ? other$boolEnableEnum == null : this$boolEnableEnum.equals(other$boolEnableEnum)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$createUserId = this.getCreateUserId();
                     Object other$createUserId = other.getCreateUserId();
                     if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingWarehouse;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $boolEnableEnum = this.getBoolEnableEnum();
      result = result * 59 + ($boolEnableEnum == null ? 43 : $boolEnableEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MesBuildingWarehouseBuilder {
      private Long id;
      private String name;
      private Long workshopId;
      private Long factoryId;
      private Boolean boolEnableEnum;
      private Integer sort;
      private String remark;
      private Long createUserId;

      MesBuildingWarehouseBuilder() {
      }

      public MesBuildingWarehouse.MesBuildingWarehouseBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingWarehouse.MesBuildingWarehouseBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingWarehouse.MesBuildingWarehouseBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingWarehouse.MesBuildingWarehouseBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public MesBuildingWarehouse.MesBuildingWarehouseBuilder boolEnableEnum(final Boolean boolEnableEnum) {
         this.boolEnableEnum = boolEnableEnum;
         return this;
      }

      public MesBuildingWarehouse.MesBuildingWarehouseBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public MesBuildingWarehouse.MesBuildingWarehouseBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesBuildingWarehouse.MesBuildingWarehouseBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MesBuildingWarehouse build() {
         return new MesBuildingWarehouse(this.id, this.name, this.workshopId, this.factoryId, this.boolEnableEnum, this.sort, this.remark, this.createUserId);
      }

      @Override
      public String toString() {
         return "MesBuildingWarehouse.MesBuildingWarehouseBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", workshopId="
            + this.workshopId
            + ", factoryId="
            + this.factoryId
            + ", boolEnableEnum="
            + this.boolEnableEnum
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", createUserId="
            + this.createUserId
            + ")";
      }
   }
}
