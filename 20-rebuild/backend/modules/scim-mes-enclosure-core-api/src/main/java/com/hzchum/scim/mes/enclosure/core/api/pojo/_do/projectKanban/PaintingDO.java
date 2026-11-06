package com.hzchum.scim.mes.enclosure.core.api.pojo._do.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "PaintingDO", description = "项目看板")
public class PaintingDO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "paintingType", value = "涂装类别")
   @JsonProperty("paintingType")
   @JSONField(name = "paintingType")
   private Integer paintingType;
   @ApiModelProperty(name = "surfaceArea", value = "清单面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "changeArea", value = "修改后面积")
   @JsonProperty("changeArea")
   @JSONField(name = "changeArea")
   private BigDecimal changeArea;
   @ApiModelProperty(name = "paintCategory", value = "油漆类别")
   @JsonProperty("paintCategory")
   @JSONField(name = "paintCategory")
   private String paintCategory;
   @ApiModelProperty(name = "thickness", value = "干膜厚度(um)")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "volumeSolids", value = "体积固体份(%)")
   @JsonProperty("volumeSolids")
   @JSONField(name = "volumeSolids")
   private BigDecimal volumeSolids;
   @ApiModelProperty(name = "loss", value = "损耗(%)")
   @JsonProperty("loss")
   @JSONField(name = "loss")
   private BigDecimal loss;
   @ApiModelProperty(name = "measure", value = "实际用量")
   @JsonProperty("measure")
   @JSONField(name = "measure")
   private BigDecimal measure;

   public static PaintingDO.PaintingDOBuilder builder() {
      return new PaintingDO.PaintingDOBuilder();
   }

   public PaintingDO() {
   }

   public PaintingDO(
      final Long projectId,
      final Long monomerId,
      final String name,
      final String material,
      final Integer paintingType,
      final BigDecimal surfaceArea,
      final BigDecimal changeArea,
      final String paintCategory,
      final BigDecimal thickness,
      final BigDecimal volumeSolids,
      final BigDecimal loss,
      final BigDecimal measure
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.name = name;
      this.material = material;
      this.paintingType = paintingType;
      this.surfaceArea = surfaceArea;
      this.changeArea = changeArea;
      this.paintCategory = paintCategory;
      this.thickness = thickness;
      this.volumeSolids = volumeSolids;
      this.loss = loss;
      this.measure = measure;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getPaintingType() {
      return this.paintingType;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getChangeArea() {
      return this.changeArea;
   }

   public String getPaintCategory() {
      return this.paintCategory;
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

   public BigDecimal getMeasure() {
      return this.measure;
   }

   @JsonProperty("projectId")
   public PaintingDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public PaintingDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("name")
   public PaintingDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("material")
   public PaintingDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("paintingType")
   public PaintingDO setPaintingType(final Integer paintingType) {
      this.paintingType = paintingType;
      return this;
   }

   @JsonProperty("surfaceArea")
   public PaintingDO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("changeArea")
   public PaintingDO setChangeArea(final BigDecimal changeArea) {
      this.changeArea = changeArea;
      return this;
   }

   @JsonProperty("paintCategory")
   public PaintingDO setPaintCategory(final String paintCategory) {
      this.paintCategory = paintCategory;
      return this;
   }

   @JsonProperty("thickness")
   public PaintingDO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("volumeSolids")
   public PaintingDO setVolumeSolids(final BigDecimal volumeSolids) {
      this.volumeSolids = volumeSolids;
      return this;
   }

   @JsonProperty("loss")
   public PaintingDO setLoss(final BigDecimal loss) {
      this.loss = loss;
      return this;
   }

   @JsonProperty("measure")
   public PaintingDO setMeasure(final BigDecimal measure) {
      this.measure = measure;
      return this;
   }

   @Override
   public String toString() {
      return "PaintingDO(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", paintingType="
         + this.getPaintingType()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", changeArea="
         + this.getChangeArea()
         + ", paintCategory="
         + this.getPaintCategory()
         + ", thickness="
         + this.getThickness()
         + ", volumeSolids="
         + this.getVolumeSolids()
         + ", loss="
         + this.getLoss()
         + ", measure="
         + this.getMeasure()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintingDO)) {
         return false;
      }

      PaintingDO other = (PaintingDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$paintingType = this.getPaintingType();
            Object other$paintingType = other.getPaintingType();
            if (this$paintingType == null ? other$paintingType == null : this$paintingType.equals(other$paintingType)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$material = this.getMaterial();
                  Object other$material = other.getMaterial();
                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                     Object this$surfaceArea = this.getSurfaceArea();
                     Object other$surfaceArea = other.getSurfaceArea();
                     if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                        Object this$changeArea = this.getChangeArea();
                        Object other$changeArea = other.getChangeArea();
                        if (this$changeArea == null ? other$changeArea == null : this$changeArea.equals(other$changeArea)) {
                           Object this$paintCategory = this.getPaintCategory();
                           Object other$paintCategory = other.getPaintCategory();
                           if (this$paintCategory == null ? other$paintCategory == null : this$paintCategory.equals(other$paintCategory)) {
                              Object this$thickness = this.getThickness();
                              Object other$thickness = other.getThickness();
                              if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                 Object this$volumeSolids = this.getVolumeSolids();
                                 Object other$volumeSolids = other.getVolumeSolids();
                                 if (this$volumeSolids == null ? other$volumeSolids == null : this$volumeSolids.equals(other$volumeSolids)) {
                                    Object this$loss = this.getLoss();
                                    Object other$loss = other.getLoss();
                                    if (this$loss == null ? other$loss == null : this$loss.equals(other$loss)) {
                                       Object this$measure = this.getMeasure();
                                       Object other$measure = other.getMeasure();
                                       return this$measure == null ? other$measure == null : this$measure.equals(other$measure);
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

   protected boolean canEqual(final Object other) {
      return other instanceof PaintingDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $paintingType = this.getPaintingType();
      result = result * 59 + ($paintingType == null ? 43 : $paintingType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $changeArea = this.getChangeArea();
      result = result * 59 + ($changeArea == null ? 43 : $changeArea.hashCode());
      Object $paintCategory = this.getPaintCategory();
      result = result * 59 + ($paintCategory == null ? 43 : $paintCategory.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $volumeSolids = this.getVolumeSolids();
      result = result * 59 + ($volumeSolids == null ? 43 : $volumeSolids.hashCode());
      Object $loss = this.getLoss();
      result = result * 59 + ($loss == null ? 43 : $loss.hashCode());
      Object $measure = this.getMeasure();
      return result * 59 + ($measure == null ? 43 : $measure.hashCode());
   }

   public static class PaintingDOBuilder {
      private Long projectId;
      private Long monomerId;
      private String name;
      private String material;
      private Integer paintingType;
      private BigDecimal surfaceArea;
      private BigDecimal changeArea;
      private String paintCategory;
      private BigDecimal thickness;
      private BigDecimal volumeSolids;
      private BigDecimal loss;
      private BigDecimal measure;

      PaintingDOBuilder() {
      }

      @JsonProperty("projectId")
      public PaintingDO.PaintingDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public PaintingDO.PaintingDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("name")
      public PaintingDO.PaintingDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("material")
      public PaintingDO.PaintingDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("paintingType")
      public PaintingDO.PaintingDOBuilder paintingType(final Integer paintingType) {
         this.paintingType = paintingType;
         return this;
      }

      @JsonProperty("surfaceArea")
      public PaintingDO.PaintingDOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("changeArea")
      public PaintingDO.PaintingDOBuilder changeArea(final BigDecimal changeArea) {
         this.changeArea = changeArea;
         return this;
      }

      @JsonProperty("paintCategory")
      public PaintingDO.PaintingDOBuilder paintCategory(final String paintCategory) {
         this.paintCategory = paintCategory;
         return this;
      }

      @JsonProperty("thickness")
      public PaintingDO.PaintingDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("volumeSolids")
      public PaintingDO.PaintingDOBuilder volumeSolids(final BigDecimal volumeSolids) {
         this.volumeSolids = volumeSolids;
         return this;
      }

      @JsonProperty("loss")
      public PaintingDO.PaintingDOBuilder loss(final BigDecimal loss) {
         this.loss = loss;
         return this;
      }

      @JsonProperty("measure")
      public PaintingDO.PaintingDOBuilder measure(final BigDecimal measure) {
         this.measure = measure;
         return this;
      }

      public PaintingDO build() {
         return new PaintingDO(
            this.projectId,
            this.monomerId,
            this.name,
            this.material,
            this.paintingType,
            this.surfaceArea,
            this.changeArea,
            this.paintCategory,
            this.thickness,
            this.volumeSolids,
            this.loss,
            this.measure
         );
      }

      @Override
      public String toString() {
         return "PaintingDO.PaintingDOBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", paintingType="
            + this.paintingType
            + ", surfaceArea="
            + this.surfaceArea
            + ", changeArea="
            + this.changeArea
            + ", paintCategory="
            + this.paintCategory
            + ", thickness="
            + this.thickness
            + ", volumeSolids="
            + this.volumeSolids
            + ", loss="
            + this.loss
            + ", measure="
            + this.measure
            + ")";
      }
   }
}
