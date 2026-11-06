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

@ApiModel(value = "TechCappCraftProductTask对象", description = "焊接任务主表")
@Entity
@TableName("tech_capp_craft_product_task")
@Table(name = "tech_capp_craft_product_task")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_product_task", comment = "焊接任务主表")
public class TechCappCraftProductTask extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id", notes = "主键id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "oneCodeExtId", value = "产品一物一码表id（根据产品类型区别）", notes = "产品一物一码表id（根据产品类型区别）")
   @TableField("one_code_ext_id")
   @Column(name = "one_code_ext_id", columnDefinition = "bigint(20)  COMMENT '产品一物一码表id（根据产品类型区别）'", nullable = false)
   private Long oneCodeExtId;
   @ApiModelProperty(name = "mesBuildingTaskId", value = "mes任务id", notes = "mes任务id")
   @TableField("mes_building_task_id")
   @Column(name = "mes_building_task_id", columnDefinition = "bigint(20)  COMMENT 'mes任务id'", nullable = false)
   private Long mesBuildingTaskId;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   @TableField("product_serial_number")
   @Column(name = "product_serial_number", columnDefinition = "varchar(255)  COMMENT '产品编号'", nullable = false)
   private String productSerialNumber;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
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
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
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
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;

   public static TechCappCraftProductTask.TechCappCraftProductTaskBuilder builder() {
      return new TechCappCraftProductTask.TechCappCraftProductTaskBuilder();
   }

   public TechCappCraftProductTask() {
   }

   public TechCappCraftProductTask(
      final Long id,
      final Long oneCodeExtId,
      final Long mesBuildingTaskId,
      final String productSerialNumber,
      final Long productId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer productType,
      final Integer techCappProductTaskWorkType,
      final Long productionLineId
   ) {
      this.id = id;
      this.oneCodeExtId = oneCodeExtId;
      this.mesBuildingTaskId = mesBuildingTaskId;
      this.productSerialNumber = productSerialNumber;
      this.productId = productId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productType = productType;
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
      this.productionLineId = productionLineId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOneCodeExtId() {
      return this.oneCodeExtId;
   }

   public Long getMesBuildingTaskId() {
      return this.mesBuildingTaskId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Long getProductId() {
      return this.productId;
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

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getTechCappProductTaskWorkType() {
      return this.techCappProductTaskWorkType;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public TechCappCraftProductTask setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftProductTask setOneCodeExtId(final Long oneCodeExtId) {
      this.oneCodeExtId = oneCodeExtId;
      return this;
   }

   public TechCappCraftProductTask setMesBuildingTaskId(final Long mesBuildingTaskId) {
      this.mesBuildingTaskId = mesBuildingTaskId;
      return this;
   }

   public TechCappCraftProductTask setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   public TechCappCraftProductTask setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public TechCappCraftProductTask setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechCappCraftProductTask setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechCappCraftProductTask setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechCappCraftProductTask setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public TechCappCraftProductTask setTechCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
      return this;
   }

   public TechCappCraftProductTask setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftProductTask(id="
         + this.getId()
         + ", oneCodeExtId="
         + this.getOneCodeExtId()
         + ", mesBuildingTaskId="
         + this.getMesBuildingTaskId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productId="
         + this.getProductId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", techCappProductTaskWorkType="
         + this.getTechCappProductTaskWorkType()
         + ", productionLineId="
         + this.getProductionLineId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftProductTask)) {
         return false;
      }

      TechCappCraftProductTask other = (TechCappCraftProductTask)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$oneCodeExtId = this.getOneCodeExtId();
         Object other$oneCodeExtId = other.getOneCodeExtId();
         if (this$oneCodeExtId == null ? other$oneCodeExtId == null : this$oneCodeExtId.equals(other$oneCodeExtId)) {
            Object this$mesBuildingTaskId = this.getMesBuildingTaskId();
            Object other$mesBuildingTaskId = other.getMesBuildingTaskId();
            if (this$mesBuildingTaskId == null ? other$mesBuildingTaskId == null : this$mesBuildingTaskId.equals(other$mesBuildingTaskId)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$productType = this.getProductType();
                           Object other$productType = other.getProductType();
                           if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                              Object this$techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
                              Object other$techCappProductTaskWorkType = other.getTechCappProductTaskWorkType();
                              if (this$techCappProductTaskWorkType == null
                                 ? other$techCappProductTaskWorkType == null
                                 : this$techCappProductTaskWorkType.equals(other$techCappProductTaskWorkType)) {
                                 Object this$productionLineId = this.getProductionLineId();
                                 Object other$productionLineId = other.getProductionLineId();
                                 if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                                    Object this$productSerialNumber = this.getProductSerialNumber();
                                    Object other$productSerialNumber = other.getProductSerialNumber();
                                    return this$productSerialNumber == null
                                       ? other$productSerialNumber == null
                                       : this$productSerialNumber.equals(other$productSerialNumber);
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
      return other instanceof TechCappCraftProductTask;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $oneCodeExtId = this.getOneCodeExtId();
      result = result * 59 + ($oneCodeExtId == null ? 43 : $oneCodeExtId.hashCode());
      Object $mesBuildingTaskId = this.getMesBuildingTaskId();
      result = result * 59 + ($mesBuildingTaskId == null ? 43 : $mesBuildingTaskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
      result = result * 59 + ($techCappProductTaskWorkType == null ? 43 : $techCappProductTaskWorkType.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   public static class TechCappCraftProductTaskBuilder {
      private Long id;
      private Long oneCodeExtId;
      private Long mesBuildingTaskId;
      private String productSerialNumber;
      private Long productId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer productType;
      private Integer techCappProductTaskWorkType;
      private Long productionLineId;

      TechCappCraftProductTaskBuilder() {
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder oneCodeExtId(final Long oneCodeExtId) {
         this.oneCodeExtId = oneCodeExtId;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder mesBuildingTaskId(final Long mesBuildingTaskId) {
         this.mesBuildingTaskId = mesBuildingTaskId;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder techCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
         this.techCappProductTaskWorkType = techCappProductTaskWorkType;
         return this;
      }

      public TechCappCraftProductTask.TechCappCraftProductTaskBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public TechCappCraftProductTask build() {
         return new TechCappCraftProductTask(
            this.id,
            this.oneCodeExtId,
            this.mesBuildingTaskId,
            this.productSerialNumber,
            this.productId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productType,
            this.techCappProductTaskWorkType,
            this.productionLineId
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftProductTask.TechCappCraftProductTaskBuilder(id="
            + this.id
            + ", oneCodeExtId="
            + this.oneCodeExtId
            + ", mesBuildingTaskId="
            + this.mesBuildingTaskId
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", productId="
            + this.productId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productType="
            + this.productType
            + ", techCappProductTaskWorkType="
            + this.techCappProductTaskWorkType
            + ", productionLineId="
            + this.productionLineId
            + ")";
      }
   }
}
