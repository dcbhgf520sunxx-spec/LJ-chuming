package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechCappCraftProductWeldTask对象", description = "产品焊缝任务表")
@Entity
@TableName("tech_capp_craft_product_weld_task")
@Table(name = "tech_capp_craft_product_weld_task")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_product_weld_task", comment = "产品焊缝任务表")
public class TechCappCraftProductWeldTask extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   @TableField("product_serial_number")
   @Column(name = "product_serial_number", columnDefinition = "varchar(255)  COMMENT '产品编号'", nullable = false)
   private String productSerialNumber;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型（目前只有个构件 跟 部件进行焊接操作）", notes = "产品类型（目前只有个构件 跟 部件进行焊接操作）")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型（目前只有个构件 跟 部件进行焊接操作）'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "techCappCraftProductTaskId", value = "焊接任务主表id", notes = "焊接任务主表id")
   @TableField("tech_capp_craft_product_task_id")
   @Column(name = "tech_capp_craft_product_task_id", columnDefinition = "bigint(20)  COMMENT '焊接任务主表id'", nullable = false)
   private Long techCappCraftProductTaskId;
   @ApiModelProperty(
      name = "techCappProductTaskWorkType",
      value = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum",
      notes = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum"
   )
   @TableField("tech_capp_product_task_work_type")
   @Column(
      name = "tech_capp_product_task_work_type",
      columnDefinition = "int(11)  COMMENT 'capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum'",
      nullable = false
   )
   private Integer techCappProductTaskWorkType;
   @ApiModelProperty(name = "weldingSerialNumber", value = "焊缝编号", notes = "焊缝编号")
   @TableField("welding_serial_number")
   @Column(name = "welding_serial_number", columnDefinition = "varchar(255)  COMMENT '焊缝编号'", nullable = false)
   private String weldingSerialNumber;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "焊接工艺id", notes = "焊接工艺id")
   @TableField("tech_capp_craft_card_storehouse_id")
   @Column(name = "tech_capp_craft_card_storehouse_id", columnDefinition = "bigint(20)  COMMENT '焊接工艺id'", nullable = false)
   private Long techCappCraftCardStorehouseId;

   public static TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder builder() {
      return new TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder();
   }

   public TechCappCraftProductWeldTask() {
   }

   public TechCappCraftProductWeldTask(
      final Long id,
      final String productSerialNumber,
      final Long productId,
      final Integer productType,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long techCappCraftProductTaskId,
      final Integer techCappProductTaskWorkType,
      final String weldingSerialNumber,
      final Long techCappCraftCardStorehouseId
   ) {
      this.id = id;
      this.productSerialNumber = productSerialNumber;
      this.productId = productId;
      this.productType = productType;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.techCappCraftProductTaskId = techCappCraftProductTaskId;
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
      this.weldingSerialNumber = weldingSerialNumber;
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
   }

   public Long getId() {
      return this.id;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getTechCappCraftProductTaskId() {
      return this.techCappCraftProductTaskId;
   }

   public Integer getTechCappProductTaskWorkType() {
      return this.techCappProductTaskWorkType;
   }

   public String getWeldingSerialNumber() {
      return this.weldingSerialNumber;
   }

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public TechCappCraftProductWeldTask setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftProductWeldTask setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   public TechCappCraftProductWeldTask setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public TechCappCraftProductWeldTask setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public TechCappCraftProductWeldTask setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechCappCraftProductWeldTask setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechCappCraftProductWeldTask setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechCappCraftProductWeldTask setTechCappCraftProductTaskId(final Long techCappCraftProductTaskId) {
      this.techCappCraftProductTaskId = techCappCraftProductTaskId;
      return this;
   }

   public TechCappCraftProductWeldTask setTechCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
      return this;
   }

   public TechCappCraftProductWeldTask setWeldingSerialNumber(final String weldingSerialNumber) {
      this.weldingSerialNumber = weldingSerialNumber;
      return this;
   }

   public TechCappCraftProductWeldTask setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftProductWeldTask(id="
         + this.getId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", techCappCraftProductTaskId="
         + this.getTechCappCraftProductTaskId()
         + ", techCappProductTaskWorkType="
         + this.getTechCappProductTaskWorkType()
         + ", weldingSerialNumber="
         + this.getWeldingSerialNumber()
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftProductWeldTask)) {
         return false;
      }

      TechCappCraftProductWeldTask other = (TechCappCraftProductWeldTask)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$techCappCraftProductTaskId = this.getTechCappCraftProductTaskId();
                        Object other$techCappCraftProductTaskId = other.getTechCappCraftProductTaskId();
                        if (this$techCappCraftProductTaskId == null
                           ? other$techCappCraftProductTaskId == null
                           : this$techCappCraftProductTaskId.equals(other$techCappCraftProductTaskId)) {
                           Object this$techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
                           Object other$techCappProductTaskWorkType = other.getTechCappProductTaskWorkType();
                           if (this$techCappProductTaskWorkType == null
                              ? other$techCappProductTaskWorkType == null
                              : this$techCappProductTaskWorkType.equals(other$techCappProductTaskWorkType)) {
                              Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
                              Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
                              if (this$techCappCraftCardStorehouseId == null
                                 ? other$techCappCraftCardStorehouseId == null
                                 : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
                                 Object this$productSerialNumber = this.getProductSerialNumber();
                                 Object other$productSerialNumber = other.getProductSerialNumber();
                                 if (this$productSerialNumber == null
                                    ? other$productSerialNumber == null
                                    : this$productSerialNumber.equals(other$productSerialNumber)) {
                                    Object this$weldingSerialNumber = this.getWeldingSerialNumber();
                                    Object other$weldingSerialNumber = other.getWeldingSerialNumber();
                                    return this$weldingSerialNumber == null
                                       ? other$weldingSerialNumber == null
                                       : this$weldingSerialNumber.equals(other$weldingSerialNumber);
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
      return other instanceof TechCappCraftProductWeldTask;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $techCappCraftProductTaskId = this.getTechCappCraftProductTaskId();
      result = result * 59 + ($techCappCraftProductTaskId == null ? 43 : $techCappCraftProductTaskId.hashCode());
      Object $techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
      result = result * 59 + ($techCappProductTaskWorkType == null ? 43 : $techCappProductTaskWorkType.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $weldingSerialNumber = this.getWeldingSerialNumber();
      return result * 59 + ($weldingSerialNumber == null ? 43 : $weldingSerialNumber.hashCode());
   }

   public static class TechCappCraftProductWeldTaskBuilder {
      private Long id;
      private String productSerialNumber;
      private Long productId;
      private Integer productType;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long techCappCraftProductTaskId;
      private Integer techCappProductTaskWorkType;
      private String weldingSerialNumber;
      private Long techCappCraftCardStorehouseId;

      TechCappCraftProductWeldTaskBuilder() {
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder techCappCraftProductTaskId(final Long techCappCraftProductTaskId) {
         this.techCappCraftProductTaskId = techCappCraftProductTaskId;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder techCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
         this.techCappProductTaskWorkType = techCappProductTaskWorkType;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder weldingSerialNumber(final String weldingSerialNumber) {
         this.weldingSerialNumber = weldingSerialNumber;
         return this;
      }

      public TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder techCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
         this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
         return this;
      }

      public TechCappCraftProductWeldTask build() {
         return new TechCappCraftProductWeldTask(
            this.id,
            this.productSerialNumber,
            this.productId,
            this.productType,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.techCappCraftProductTaskId,
            this.techCappProductTaskWorkType,
            this.weldingSerialNumber,
            this.techCappCraftCardStorehouseId
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftProductWeldTask.TechCappCraftProductWeldTaskBuilder(id="
            + this.id
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", techCappCraftProductTaskId="
            + this.techCappCraftProductTaskId
            + ", techCappProductTaskWorkType="
            + this.techCappProductTaskWorkType
            + ", weldingSerialNumber="
            + this.weldingSerialNumber
            + ", techCappCraftCardStorehouseId="
            + this.techCappCraftCardStorehouseId
            + ")";
      }
   }
}
