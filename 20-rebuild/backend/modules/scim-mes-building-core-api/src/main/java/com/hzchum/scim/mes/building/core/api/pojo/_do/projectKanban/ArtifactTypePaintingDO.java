package com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactTypePaintingDO", description = "项目看板")
public class ArtifactTypePaintingDO {
   @ApiModelProperty(name = "config", value = "配置")
   @JsonProperty("config")
   @JSONField(name = "config")
   private IdAndNameDO config;
   @ApiModelProperty(name = "surfaceArea", value = "面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "primerMeasure", value = "底漆用量")
   @JsonProperty("primerMeasure")
   @JSONField(name = "primerMeasure")
   private BigDecimal primerMeasure;
   @ApiModelProperty(name = "intermediateMeasure", value = "中间漆用量")
   @JsonProperty("intermediateMeasure")
   @JSONField(name = "intermediateMeasure")
   private BigDecimal intermediateMeasure;
   @ApiModelProperty(name = "topcoatMeasure", value = "面漆用量")
   @JsonProperty("topcoatMeasure")
   @JSONField(name = "topcoatMeasure")
   private BigDecimal topcoatMeasure;

   public static ArtifactTypePaintingDO.ArtifactTypePaintingDOBuilder builder() {
      return new ArtifactTypePaintingDO.ArtifactTypePaintingDOBuilder();
   }

   public ArtifactTypePaintingDO() {
   }

   public ArtifactTypePaintingDO(
      final IdAndNameDO config,
      final BigDecimal surfaceArea,
      final BigDecimal primerMeasure,
      final BigDecimal intermediateMeasure,
      final BigDecimal topcoatMeasure
   ) {
      this.config = config;
      this.surfaceArea = surfaceArea;
      this.primerMeasure = primerMeasure;
      this.intermediateMeasure = intermediateMeasure;
      this.topcoatMeasure = topcoatMeasure;
   }

   public IdAndNameDO getConfig() {
      return this.config;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getPrimerMeasure() {
      return this.primerMeasure;
   }

   public BigDecimal getIntermediateMeasure() {
      return this.intermediateMeasure;
   }

   public BigDecimal getTopcoatMeasure() {
      return this.topcoatMeasure;
   }

   @JsonProperty("config")
   public ArtifactTypePaintingDO setConfig(final IdAndNameDO config) {
      this.config = config;
      return this;
   }

   @JsonProperty("surfaceArea")
   public ArtifactTypePaintingDO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("primerMeasure")
   public ArtifactTypePaintingDO setPrimerMeasure(final BigDecimal primerMeasure) {
      this.primerMeasure = primerMeasure;
      return this;
   }

   @JsonProperty("intermediateMeasure")
   public ArtifactTypePaintingDO setIntermediateMeasure(final BigDecimal intermediateMeasure) {
      this.intermediateMeasure = intermediateMeasure;
      return this;
   }

   @JsonProperty("topcoatMeasure")
   public ArtifactTypePaintingDO setTopcoatMeasure(final BigDecimal topcoatMeasure) {
      this.topcoatMeasure = topcoatMeasure;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactTypePaintingDO(config="
         + this.getConfig()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", primerMeasure="
         + this.getPrimerMeasure()
         + ", intermediateMeasure="
         + this.getIntermediateMeasure()
         + ", topcoatMeasure="
         + this.getTopcoatMeasure()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactTypePaintingDO)) {
         return false;
      }

      ArtifactTypePaintingDO other = (ArtifactTypePaintingDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$config = this.getConfig();
      Object other$config = other.getConfig();
      if (this$config == null ? other$config == null : this$config.equals(other$config)) {
         Object this$surfaceArea = this.getSurfaceArea();
         Object other$surfaceArea = other.getSurfaceArea();
         if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
            Object this$primerMeasure = this.getPrimerMeasure();
            Object other$primerMeasure = other.getPrimerMeasure();
            if (this$primerMeasure == null ? other$primerMeasure == null : this$primerMeasure.equals(other$primerMeasure)) {
               Object this$intermediateMeasure = this.getIntermediateMeasure();
               Object other$intermediateMeasure = other.getIntermediateMeasure();
               if (this$intermediateMeasure == null ? other$intermediateMeasure == null : this$intermediateMeasure.equals(other$intermediateMeasure)) {
                  Object this$topcoatMeasure = this.getTopcoatMeasure();
                  Object other$topcoatMeasure = other.getTopcoatMeasure();
                  return this$topcoatMeasure == null ? other$topcoatMeasure == null : this$topcoatMeasure.equals(other$topcoatMeasure);
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
      return other instanceof ArtifactTypePaintingDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $config = this.getConfig();
      result = result * 59 + ($config == null ? 43 : $config.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $primerMeasure = this.getPrimerMeasure();
      result = result * 59 + ($primerMeasure == null ? 43 : $primerMeasure.hashCode());
      Object $intermediateMeasure = this.getIntermediateMeasure();
      result = result * 59 + ($intermediateMeasure == null ? 43 : $intermediateMeasure.hashCode());
      Object $topcoatMeasure = this.getTopcoatMeasure();
      return result * 59 + ($topcoatMeasure == null ? 43 : $topcoatMeasure.hashCode());
   }

   public static class ArtifactTypePaintingDOBuilder {
      private IdAndNameDO config;
      private BigDecimal surfaceArea;
      private BigDecimal primerMeasure;
      private BigDecimal intermediateMeasure;
      private BigDecimal topcoatMeasure;

      ArtifactTypePaintingDOBuilder() {
      }

      @JsonProperty("config")
      public ArtifactTypePaintingDO.ArtifactTypePaintingDOBuilder config(final IdAndNameDO config) {
         this.config = config;
         return this;
      }

      @JsonProperty("surfaceArea")
      public ArtifactTypePaintingDO.ArtifactTypePaintingDOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("primerMeasure")
      public ArtifactTypePaintingDO.ArtifactTypePaintingDOBuilder primerMeasure(final BigDecimal primerMeasure) {
         this.primerMeasure = primerMeasure;
         return this;
      }

      @JsonProperty("intermediateMeasure")
      public ArtifactTypePaintingDO.ArtifactTypePaintingDOBuilder intermediateMeasure(final BigDecimal intermediateMeasure) {
         this.intermediateMeasure = intermediateMeasure;
         return this;
      }

      @JsonProperty("topcoatMeasure")
      public ArtifactTypePaintingDO.ArtifactTypePaintingDOBuilder topcoatMeasure(final BigDecimal topcoatMeasure) {
         this.topcoatMeasure = topcoatMeasure;
         return this;
      }

      public ArtifactTypePaintingDO build() {
         return new ArtifactTypePaintingDO(this.config, this.surfaceArea, this.primerMeasure, this.intermediateMeasure, this.topcoatMeasure);
      }

      @Override
      public String toString() {
         return "ArtifactTypePaintingDO.ArtifactTypePaintingDOBuilder(config="
            + this.config
            + ", surfaceArea="
            + this.surfaceArea
            + ", primerMeasure="
            + this.primerMeasure
            + ", intermediateMeasure="
            + this.intermediateMeasure
            + ", topcoatMeasure="
            + this.topcoatMeasure
            + ")";
      }
   }
}
