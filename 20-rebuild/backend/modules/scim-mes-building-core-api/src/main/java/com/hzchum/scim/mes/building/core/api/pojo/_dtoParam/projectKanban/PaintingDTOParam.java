package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "PaintingDTOParam", description = "涂装计算修改请求类")
public class PaintingDTOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "paintingType", notes = "涂装类别")
   @JsonProperty("paintingType")
   @JSONField(name = "paintingType")
   @NotNull(message = "涂装类别不能为空")
   private Integer paintingType;
   @ApiModelProperty(name = "surfaceArea", value = "清单面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @NotNull(message = "清单面积不能为空")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "paintCategory", value = "油漆类别")
   @JsonProperty("paintCategory")
   @JSONField(name = "paintCategory")
   @NotNull(message = "油漆类别不能为空")
   private String paintCategory;
   @ApiModelProperty(name = "thickness", value = "干膜厚度(um)")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @NotNull(message = "干膜厚度(um)不能为空")
   private BigDecimal thickness;
   @ApiModelProperty(name = "volumeSolids", value = "体积固体份(%)")
   @JsonProperty("volumeSolids")
   @JSONField(name = "volumeSolids")
   @NotNull(message = "体积固体份(%)不能为空")
   private BigDecimal volumeSolids;
   @ApiModelProperty(name = "loss", value = "损耗(%)")
   @JsonProperty("loss")
   @JSONField(name = "loss")
   @NotNull(message = "损耗(%)不能为空")
   private BigDecimal loss;

   public static PaintingDTOParam.PaintingDTOParamBuilder builder() {
      return new PaintingDTOParam.PaintingDTOParamBuilder();
   }

   public PaintingDTOParam() {
   }

   public PaintingDTOParam(
      final Long projectId,
      final Long monomerId,
      final Integer paintingType,
      final BigDecimal surfaceArea,
      final String paintCategory,
      final BigDecimal thickness,
      final BigDecimal volumeSolids,
      final BigDecimal loss
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.paintingType = paintingType;
      this.surfaceArea = surfaceArea;
      this.paintCategory = paintCategory;
      this.thickness = thickness;
      this.volumeSolids = volumeSolids;
      this.loss = loss;
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

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
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

   @JsonProperty("projectId")
   public PaintingDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public PaintingDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("paintingType")
   public PaintingDTOParam setPaintingType(final Integer paintingType) {
      this.paintingType = paintingType;
      return this;
   }

   @JsonProperty("surfaceArea")
   public PaintingDTOParam setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("paintCategory")
   public PaintingDTOParam setPaintCategory(final String paintCategory) {
      this.paintCategory = paintCategory;
      return this;
   }

   @JsonProperty("thickness")
   public PaintingDTOParam setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("volumeSolids")
   public PaintingDTOParam setVolumeSolids(final BigDecimal volumeSolids) {
      this.volumeSolids = volumeSolids;
      return this;
   }

   @JsonProperty("loss")
   public PaintingDTOParam setLoss(final BigDecimal loss) {
      this.loss = loss;
      return this;
   }

   @Override
   public String toString() {
      return "PaintingDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", paintingType="
         + this.getPaintingType()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", paintCategory="
         + this.getPaintCategory()
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

      if (!(o instanceof PaintingDTOParam)) {
         return false;
      }

      PaintingDTOParam other = (PaintingDTOParam)o;
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
               Object this$surfaceArea = this.getSurfaceArea();
               Object other$surfaceArea = other.getSurfaceArea();
               if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PaintingDTOParam;
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
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $paintCategory = this.getPaintCategory();
      result = result * 59 + ($paintCategory == null ? 43 : $paintCategory.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $volumeSolids = this.getVolumeSolids();
      result = result * 59 + ($volumeSolids == null ? 43 : $volumeSolids.hashCode());
      Object $loss = this.getLoss();
      return result * 59 + ($loss == null ? 43 : $loss.hashCode());
   }

   public static class PaintingDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Integer paintingType;
      private BigDecimal surfaceArea;
      private String paintCategory;
      private BigDecimal thickness;
      private BigDecimal volumeSolids;
      private BigDecimal loss;

      PaintingDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public PaintingDTOParam.PaintingDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public PaintingDTOParam.PaintingDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("paintingType")
      public PaintingDTOParam.PaintingDTOParamBuilder paintingType(final Integer paintingType) {
         this.paintingType = paintingType;
         return this;
      }

      @JsonProperty("surfaceArea")
      public PaintingDTOParam.PaintingDTOParamBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("paintCategory")
      public PaintingDTOParam.PaintingDTOParamBuilder paintCategory(final String paintCategory) {
         this.paintCategory = paintCategory;
         return this;
      }

      @JsonProperty("thickness")
      public PaintingDTOParam.PaintingDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("volumeSolids")
      public PaintingDTOParam.PaintingDTOParamBuilder volumeSolids(final BigDecimal volumeSolids) {
         this.volumeSolids = volumeSolids;
         return this;
      }

      @JsonProperty("loss")
      public PaintingDTOParam.PaintingDTOParamBuilder loss(final BigDecimal loss) {
         this.loss = loss;
         return this;
      }

      public PaintingDTOParam build() {
         return new PaintingDTOParam(
            this.projectId, this.monomerId, this.paintingType, this.surfaceArea, this.paintCategory, this.thickness, this.volumeSolids, this.loss
         );
      }

      @Override
      public String toString() {
         return "PaintingDTOParam.PaintingDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", paintingType="
            + this.paintingType
            + ", surfaceArea="
            + this.surfaceArea
            + ", paintCategory="
            + this.paintCategory
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
