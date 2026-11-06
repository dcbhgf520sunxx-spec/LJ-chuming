package com.hzchum.scim.mes.building.core.api.pojo._doModel.projectKanban;

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

@ApiModel(value = "MesBuildingPainting对象", description = "涂装计算表 ")
@Entity
@TableName("mes_building_painting")
@Table(name = "mes_building_painting")
public class MesBuildingPainting extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "paintingType", value = "涂装类别", notes = "涂装类别")
   @JsonProperty("paintingType")
   @JSONField(name = "paintingType")
   @TableField("painting_type")
   @Column(name = "painting_type", columnDefinition = "int(11)  COMMENT '涂装类别'", nullable = true)
   private Integer paintingType;
   @ApiModelProperty(name = "thickness", value = "干膜厚度(um)", notes = "干膜厚度(um)")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,6)  COMMENT '干膜厚度(um)'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "volumeSolids", value = "体积固体份(%)", notes = "体积固体份(%)")
   @JsonProperty("volumeSolids")
   @JSONField(name = "volumeSolids")
   @TableField("volume_solids")
   @Column(name = "volume_solids", columnDefinition = "decimal(32,6)  COMMENT '体积固体份(%)'", nullable = true)
   private BigDecimal volumeSolids;
   @ApiModelProperty(name = "loss", value = "损耗(%)", notes = "损耗(%)")
   @JsonProperty("loss")
   @JSONField(name = "loss")
   @TableField("loss")
   @Column(name = "loss", columnDefinition = "decimal(32,6)  COMMENT '损耗(%)'", nullable = true)
   private BigDecimal loss;

   public static MesBuildingPainting.MesBuildingPaintingBuilder builder() {
      return new MesBuildingPainting.MesBuildingPaintingBuilder();
   }

   public MesBuildingPainting() {
   }

   public MesBuildingPainting(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Integer paintingType,
      final BigDecimal thickness,
      final BigDecimal volumeSolids,
      final BigDecimal loss
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.paintingType = paintingType;
      this.thickness = thickness;
      this.volumeSolids = volumeSolids;
      this.loss = loss;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getPaintingType() {
      return this.paintingType;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getVolumeSolids() {
      return this.volumeSolids;
   }

   public BigDecimal getLoss() {
      return this.loss;
   }

   @JsonProperty("id")
   public MesBuildingPainting setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingPainting setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingPainting setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("paintingType")
   public MesBuildingPainting setPaintingType(final Integer paintingType) {
      this.paintingType = paintingType;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingPainting setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("volumeSolids")
   public MesBuildingPainting setVolumeSolids(final BigDecimal volumeSolids) {
      this.volumeSolids = volumeSolids;
      return this;
   }

   @JsonProperty("loss")
   public MesBuildingPainting setLoss(final BigDecimal loss) {
      this.loss = loss;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPainting(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", paintingType="
         + this.getPaintingType()
         + ", thickness="
         + this.getThickness()
         + ", volumeSolids="
         + this.getVolumeSolids()
         + ", loss="
         + this.getLoss()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPainting)) {
         return false;
      }

      MesBuildingPainting other = (MesBuildingPainting)o;
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
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$paintingType = this.getPaintingType();
               Object other$paintingType = other.getPaintingType();
               if (this$paintingType == null ? other$paintingType == null : this$paintingType.equals(other$paintingType)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                     Object this$volumeSolids = this.getVolumeSolids();
                     Object other$volumeSolids = other.getVolumeSolids();
                     if (this$volumeSolids == null ? other$volumeSolids == null : this$volumeSolids.equals(other$volumeSolids)) {
                        Object this$loss = this.getLoss();
                        Object other$loss = other.getLoss();
                        return this$loss == null ? other$loss == null : this$loss.equals(other$loss);
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
      return other instanceof MesBuildingPainting;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $paintingType = this.getPaintingType();
      result = result * 59 + ($paintingType == null ? 43 : $paintingType.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $volumeSolids = this.getVolumeSolids();
      result = result * 59 + ($volumeSolids == null ? 43 : $volumeSolids.hashCode());
      Object $loss = this.getLoss();
      return result * 59 + ($loss == null ? 43 : $loss.hashCode());
   }

   public static class MesBuildingPaintingBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Integer paintingType;
      private BigDecimal thickness;
      private BigDecimal volumeSolids;
      private BigDecimal loss;

      MesBuildingPaintingBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPainting.MesBuildingPaintingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingPainting.MesBuildingPaintingBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingPainting.MesBuildingPaintingBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("paintingType")
      public MesBuildingPainting.MesBuildingPaintingBuilder paintingType(final Integer paintingType) {
         this.paintingType = paintingType;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingPainting.MesBuildingPaintingBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("volumeSolids")
      public MesBuildingPainting.MesBuildingPaintingBuilder volumeSolids(final BigDecimal volumeSolids) {
         this.volumeSolids = volumeSolids;
         return this;
      }

      @JsonProperty("loss")
      public MesBuildingPainting.MesBuildingPaintingBuilder loss(final BigDecimal loss) {
         this.loss = loss;
         return this;
      }

      public MesBuildingPainting build() {
         return new MesBuildingPainting(this.id, this.projectId, this.monomerId, this.paintingType, this.thickness, this.volumeSolids, this.loss);
      }

      @Override
      public String toString() {
         return "MesBuildingPainting.MesBuildingPaintingBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", paintingType="
            + this.paintingType
            + ", thickness="
            + this.thickness
            + ", volumeSolids="
            + this.volumeSolids
            + ", loss="
            + this.loss
            + ")";
      }
   }
}
