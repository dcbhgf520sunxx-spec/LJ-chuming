package com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work;

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

@ApiModel(value = "MesMaterialFeedingReportDetail对象", description = "投料填报详情表")
@Entity
@TableName("mes_material_feeding_report_detail")
@Table(name = "mes_material_feeding_report_detail")
@org.hibernate.annotations.Table(appliesTo = "mes_material_feeding_report_detail", comment = "投料填报详情表")
public class MesMaterialFeedingReportDetail extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("投料填报id")
   @TableField("material_feeding_report_id")
   @Column(name = "material_feeding_report_id", columnDefinition = "bigint(20) COMMENT '投料填报id'", nullable = true)
   private Long materialFeedingReportId;
   @ApiModelProperty("项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty("单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty("批次id")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20) COMMENT '批次id'", nullable = true)
   private Long areaBatchId;
   @ApiModelProperty("构件类别")
   @TableField("structure_type")
   @Column(name = "structure_type", columnDefinition = "varchar(255) COMMENT '构件类别'", nullable = true)
   private String structureType;
   @ApiModelProperty("投料量(㎏)")
   @TableField("feeding_quantity")
   @Column(name = "feeding_quantity", columnDefinition = "decimal(32,8) COMMENT '投料量(㎏)'", nullable = true)
   private BigDecimal feedingQuantity;
   @ApiModelProperty("车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) COMMENT '车间id'", nullable = true)
   private Long workshopId;

   public static MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder builder() {
      return new MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder();
   }

   public MesMaterialFeedingReportDetail() {
   }

   public MesMaterialFeedingReportDetail(
      final Long id,
      final Long materialFeedingReportId,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final String structureType,
      final BigDecimal feedingQuantity,
      final Long workshopId
   ) {
      this.id = id;
      this.materialFeedingReportId = materialFeedingReportId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.structureType = structureType;
      this.feedingQuantity = feedingQuantity;
      this.workshopId = workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMaterialFeedingReportId() {
      return this.materialFeedingReportId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public BigDecimal getFeedingQuantity() {
      return this.feedingQuantity;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public MesMaterialFeedingReportDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesMaterialFeedingReportDetail setMaterialFeedingReportId(final Long materialFeedingReportId) {
      this.materialFeedingReportId = materialFeedingReportId;
      return this;
   }

   public MesMaterialFeedingReportDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesMaterialFeedingReportDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesMaterialFeedingReportDetail setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public MesMaterialFeedingReportDetail setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public MesMaterialFeedingReportDetail setFeedingQuantity(final BigDecimal feedingQuantity) {
      this.feedingQuantity = feedingQuantity;
      return this;
   }

   public MesMaterialFeedingReportDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @Override
   public String toString() {
      return "MesMaterialFeedingReportDetail(id="
         + this.getId()
         + ", materialFeedingReportId="
         + this.getMaterialFeedingReportId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", structureType="
         + this.getStructureType()
         + ", feedingQuantity="
         + this.getFeedingQuantity()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMaterialFeedingReportDetail)) {
         return false;
      }

      MesMaterialFeedingReportDetail other = (MesMaterialFeedingReportDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialFeedingReportId = this.getMaterialFeedingReportId();
         Object other$materialFeedingReportId = other.getMaterialFeedingReportId();
         if (this$materialFeedingReportId == null ? other$materialFeedingReportId == null : this$materialFeedingReportId.equals(other$materialFeedingReportId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$structureType = this.getStructureType();
                        Object other$structureType = other.getStructureType();
                        if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                           Object this$feedingQuantity = this.getFeedingQuantity();
                           Object other$feedingQuantity = other.getFeedingQuantity();
                           return this$feedingQuantity == null ? other$feedingQuantity == null : this$feedingQuantity.equals(other$feedingQuantity);
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
      return other instanceof MesMaterialFeedingReportDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialFeedingReportId = this.getMaterialFeedingReportId();
      result = result * 59 + ($materialFeedingReportId == null ? 43 : $materialFeedingReportId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $feedingQuantity = this.getFeedingQuantity();
      return result * 59 + ($feedingQuantity == null ? 43 : $feedingQuantity.hashCode());
   }

   public static class MesMaterialFeedingReportDetailBuilder {
      private Long id;
      private Long materialFeedingReportId;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private String structureType;
      private BigDecimal feedingQuantity;
      private Long workshopId;

      MesMaterialFeedingReportDetailBuilder() {
      }

      public MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder materialFeedingReportId(final Long materialFeedingReportId) {
         this.materialFeedingReportId = materialFeedingReportId;
         return this;
      }

      public MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder feedingQuantity(final BigDecimal feedingQuantity) {
         this.feedingQuantity = feedingQuantity;
         return this;
      }

      public MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesMaterialFeedingReportDetail build() {
         return new MesMaterialFeedingReportDetail(
            this.id, this.materialFeedingReportId, this.projectId, this.monomerId, this.areaBatchId, this.structureType, this.feedingQuantity, this.workshopId
         );
      }

      @Override
      public String toString() {
         return "MesMaterialFeedingReportDetail.MesMaterialFeedingReportDetailBuilder(id="
            + this.id
            + ", materialFeedingReportId="
            + this.materialFeedingReportId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", structureType="
            + this.structureType
            + ", feedingQuantity="
            + this.feedingQuantity
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
