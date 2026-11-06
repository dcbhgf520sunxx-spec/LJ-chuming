package com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica;

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

@ApiModel(value = "MesBuildingStructureClassificationTypeLink对象", description = "构件种类与类型关联表")
@Entity
@TableName("mes_building_structure_classification_type_link")
@Table(name = "mes_building_structure_classification_type_link")
public class MesBuildingStructureClassificationTypeLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "artifactTypeId", value = "构件种类配置id")
   @JsonProperty("artifactTypeId")
   @JSONField(name = "artifact_type_id")
   @TableField("artifact_type_id")
   @Column(name = "artifact_type_id", columnDefinition = "bigint(20)  COMMENT '构件种类配置id'", nullable = false)
   private Long artifactTypeId;
   @ApiModelProperty(name = "structureClassificationId", value = "构件类型id")
   @JsonProperty("structureClassificationId")
   @JSONField(name = "structure_classification_id")
   @TableField("structure_classification_id")
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  COMMENT '构件类型id'", nullable = false)
   private Long structureClassificationId;
   @ApiModelProperty(name = "minNumerical", value = "数值范围(开始)")
   @JsonProperty("minNumerical")
   @JSONField(name = "min_numerical")
   @TableField("min_numerical")
   @Column(name = "min_numerical", columnDefinition = "decimal(32,8)  COMMENT '数值范围(开始)'", nullable = false)
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "数值范围(结束)")
   @JsonProperty("maxNumerical")
   @JSONField(name = "max_numerical")
   @TableField("max_numerical")
   @Column(name = "max_numerical", columnDefinition = "decimal(32,8)  COMMENT '数值范围(结束)'", nullable = false)
   private BigDecimal maxNumerical;

   public static MesBuildingStructureClassificationTypeLink.MesBuildingStructureClassificationTypeLinkBuilder builder() {
      return new MesBuildingStructureClassificationTypeLink.MesBuildingStructureClassificationTypeLinkBuilder();
   }

   public MesBuildingStructureClassificationTypeLink() {
   }

   public MesBuildingStructureClassificationTypeLink(
      final Long id, final Long artifactTypeId, final Long structureClassificationId, final BigDecimal minNumerical, final BigDecimal maxNumerical
   ) {
      this.id = id;
      this.artifactTypeId = artifactTypeId;
      this.structureClassificationId = structureClassificationId;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactTypeId() {
      return this.artifactTypeId;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public BigDecimal getMinNumerical() {
      return this.minNumerical;
   }

   public BigDecimal getMaxNumerical() {
      return this.maxNumerical;
   }

   @JsonProperty("id")
   public MesBuildingStructureClassificationTypeLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("artifactTypeId")
   public MesBuildingStructureClassificationTypeLink setArtifactTypeId(final Long artifactTypeId) {
      this.artifactTypeId = artifactTypeId;
      return this;
   }

   @JsonProperty("structureClassificationId")
   public MesBuildingStructureClassificationTypeLink setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
      return this;
   }

   @JsonProperty("minNumerical")
   public MesBuildingStructureClassificationTypeLink setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
      return this;
   }

   @JsonProperty("maxNumerical")
   public MesBuildingStructureClassificationTypeLink setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingStructureClassificationTypeLink(id="
         + this.getId()
         + ", artifactTypeId="
         + this.getArtifactTypeId()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", minNumerical="
         + this.getMinNumerical()
         + ", maxNumerical="
         + this.getMaxNumerical()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingStructureClassificationTypeLink)) {
         return false;
      }

      MesBuildingStructureClassificationTypeLink other = (MesBuildingStructureClassificationTypeLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactTypeId = this.getArtifactTypeId();
         Object other$artifactTypeId = other.getArtifactTypeId();
         if (this$artifactTypeId == null ? other$artifactTypeId == null : this$artifactTypeId.equals(other$artifactTypeId)) {
            Object this$structureClassificationId = this.getStructureClassificationId();
            Object other$structureClassificationId = other.getStructureClassificationId();
            if (this$structureClassificationId == null
               ? other$structureClassificationId == null
               : this$structureClassificationId.equals(other$structureClassificationId)) {
               Object this$minNumerical = this.getMinNumerical();
               Object other$minNumerical = other.getMinNumerical();
               if (this$minNumerical == null ? other$minNumerical == null : this$minNumerical.equals(other$minNumerical)) {
                  Object this$maxNumerical = this.getMaxNumerical();
                  Object other$maxNumerical = other.getMaxNumerical();
                  return this$maxNumerical == null ? other$maxNumerical == null : this$maxNumerical.equals(other$maxNumerical);
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
      return other instanceof MesBuildingStructureClassificationTypeLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactTypeId = this.getArtifactTypeId();
      result = result * 59 + ($artifactTypeId == null ? 43 : $artifactTypeId.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      return result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
   }

   public static class MesBuildingStructureClassificationTypeLinkBuilder {
      private Long id;
      private Long artifactTypeId;
      private Long structureClassificationId;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;

      MesBuildingStructureClassificationTypeLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingStructureClassificationTypeLink.MesBuildingStructureClassificationTypeLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("artifactTypeId")
      public MesBuildingStructureClassificationTypeLink.MesBuildingStructureClassificationTypeLinkBuilder artifactTypeId(final Long artifactTypeId) {
         this.artifactTypeId = artifactTypeId;
         return this;
      }

      @JsonProperty("structureClassificationId")
      public MesBuildingStructureClassificationTypeLink.MesBuildingStructureClassificationTypeLinkBuilder structureClassificationId(
         final Long structureClassificationId
      ) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      @JsonProperty("minNumerical")
      public MesBuildingStructureClassificationTypeLink.MesBuildingStructureClassificationTypeLinkBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      @JsonProperty("maxNumerical")
      public MesBuildingStructureClassificationTypeLink.MesBuildingStructureClassificationTypeLinkBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesBuildingStructureClassificationTypeLink build() {
         return new MesBuildingStructureClassificationTypeLink(
            this.id, this.artifactTypeId, this.structureClassificationId, this.minNumerical, this.maxNumerical
         );
      }

      @Override
      public String toString() {
         return "MesBuildingStructureClassificationTypeLink.MesBuildingStructureClassificationTypeLinkBuilder(id="
            + this.id
            + ", artifactTypeId="
            + this.artifactTypeId
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", minNumerical="
            + this.minNumerical
            + ", maxNumerical="
            + this.maxNumerical
            + ")";
      }
   }
}
