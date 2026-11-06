package com.hzchum.scim.mes.building.core.api.pojo._doModel.machine_part_raw_material;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesMachinePartRawMaterialFeedingRecord对象", description = "零件原料投料记录表")
@Entity
@TableName("mes_machine_part_raw_material_feeding_record")
@Table(name = "mes_machine_part_raw_material_feeding_record")
@org.hibernate.annotations.Table(appliesTo = "mes_machine_part_raw_material_feeding_record", comment = "零件原料投料记录表")
public class MesMachinePartRawMaterialFeedingRecord extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty("任务工单id")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20) COMMENT '任务工单id'", nullable = true)
   private Long taskOrderId;
   @ApiModelProperty("领料明细排产出库审核id")
   @TableField("picking_approve_detail_id")
   @Column(name = "picking_approve_detail_id", columnDefinition = "bigint(20) COMMENT '领料明细排产出库审核id'", nullable = true)
   private Long pickingApproveDetailId;
   @ApiModelProperty("规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255) COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty("厚度(㎜)")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8) COMMENT '厚度(㎜)'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty("材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255) COMMENT '材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "mete", value = "核算量(g)")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8) COMMENT '核算量(g)'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty("创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) COMMENT '创建人id'", nullable = true)
   private Long createUserId;

   public static MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder builder() {
      return new MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder();
   }

   public MesMachinePartRawMaterialFeedingRecord() {
   }

   public MesMachinePartRawMaterialFeedingRecord(
      final Long id,
      final Long projectId,
      final Long taskOrderId,
      final Long pickingApproveDetailId,
      final String specification,
      final BigDecimal thickness,
      final String material,
      final BigDecimal mete,
      final Long createUserId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.taskOrderId = taskOrderId;
      this.pickingApproveDetailId = pickingApproveDetailId;
      this.specification = specification;
      this.thickness = thickness;
      this.material = material;
      this.mete = mete;
      this.createUserId = createUserId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getPickingApproveDetailId() {
      return this.pickingApproveDetailId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public MesMachinePartRawMaterialFeedingRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesMachinePartRawMaterialFeedingRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesMachinePartRawMaterialFeedingRecord setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   public MesMachinePartRawMaterialFeedingRecord setPickingApproveDetailId(final Long pickingApproveDetailId) {
      this.pickingApproveDetailId = pickingApproveDetailId;
      return this;
   }

   public MesMachinePartRawMaterialFeedingRecord setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public MesMachinePartRawMaterialFeedingRecord setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public MesMachinePartRawMaterialFeedingRecord setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public MesMachinePartRawMaterialFeedingRecord setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public MesMachinePartRawMaterialFeedingRecord setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @Override
   public String toString() {
      return "MesMachinePartRawMaterialFeedingRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", pickingApproveDetailId="
         + this.getPickingApproveDetailId()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", material="
         + this.getMaterial()
         + ", mete="
         + this.getMete()
         + ", createUserId="
         + this.getCreateUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMachinePartRawMaterialFeedingRecord)) {
         return false;
      }

      MesMachinePartRawMaterialFeedingRecord other = (MesMachinePartRawMaterialFeedingRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$pickingApproveDetailId = this.getPickingApproveDetailId();
               Object other$pickingApproveDetailId = other.getPickingApproveDetailId();
               if (this$pickingApproveDetailId == null
                  ? other$pickingApproveDetailId == null
                  : this$pickingApproveDetailId.equals(other$pickingApproveDetailId)) {
                  Object this$createUserId = this.getCreateUserId();
                  Object other$createUserId = other.getCreateUserId();
                  if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$thickness = this.getThickness();
                        Object other$thickness = other.getThickness();
                        if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$mete = this.getMete();
                              Object other$mete = other.getMete();
                              return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof MesMachinePartRawMaterialFeedingRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $pickingApproveDetailId = this.getPickingApproveDetailId();
      result = result * 59 + ($pickingApproveDetailId == null ? 43 : $pickingApproveDetailId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   public static class MesMachinePartRawMaterialFeedingRecordBuilder {
      private Long id;
      private Long projectId;
      private Long taskOrderId;
      private Long pickingApproveDetailId;
      private String specification;
      private BigDecimal thickness;
      private String material;
      private BigDecimal mete;
      private Long createUserId;

      MesMachinePartRawMaterialFeedingRecordBuilder() {
      }

      public MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder pickingApproveDetailId(final Long pickingApproveDetailId) {
         this.pickingApproveDetailId = pickingApproveDetailId;
         return this;
      }

      public MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MesMachinePartRawMaterialFeedingRecord build() {
         return new MesMachinePartRawMaterialFeedingRecord(
            this.id,
            this.projectId,
            this.taskOrderId,
            this.pickingApproveDetailId,
            this.specification,
            this.thickness,
            this.material,
            this.mete,
            this.createUserId
         );
      }

      @Override
      public String toString() {
         return "MesMachinePartRawMaterialFeedingRecord.MesMachinePartRawMaterialFeedingRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", taskOrderId="
            + this.taskOrderId
            + ", pickingApproveDetailId="
            + this.pickingApproveDetailId
            + ", specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", material="
            + this.material
            + ", mete="
            + this.mete
            + ", createUserId="
            + this.createUserId
            + ")";
      }
   }
}
