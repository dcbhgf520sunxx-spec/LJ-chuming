package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "PaintingDTO", description = "项目看板")
public class PaintingDTO {
   @ApiModelProperty(name = "thickness", value = "干膜厚度(um)", notes = "干膜厚度(um)")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "volumeSolids", value = "体积固体份(%)", notes = "体积固体份(%)")
   @JsonProperty("volumeSolids")
   @JSONField(name = "volumeSolids")
   private BigDecimal volumeSolids;
   @ApiModelProperty(name = "loss", value = "损耗(%)", notes = "损耗(%)")
   @JsonProperty("loss")
   @JSONField(name = "loss")
   private BigDecimal loss;

   public static PaintingDTO.PaintingDTOBuilder builder() {
      return new PaintingDTO.PaintingDTOBuilder();
   }

   public PaintingDTO() {
   }

   public PaintingDTO(final BigDecimal thickness, final BigDecimal volumeSolids, final BigDecimal loss) {
      this.thickness = thickness;
      this.volumeSolids = volumeSolids;
      this.loss = loss;
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

   @JsonProperty("thickness")
   public PaintingDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("volumeSolids")
   public PaintingDTO setVolumeSolids(final BigDecimal volumeSolids) {
      this.volumeSolids = volumeSolids;
      return this;
   }

   @JsonProperty("loss")
   public PaintingDTO setLoss(final BigDecimal loss) {
      this.loss = loss;
      return this;
   }

   @Override
   public String toString() {
      return "PaintingDTO(thickness=" + this.getThickness() + ", volumeSolids=" + this.getVolumeSolids() + ", loss=" + this.getLoss() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintingDTO)) {
         return false;
      }

      PaintingDTO other = (PaintingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PaintingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $volumeSolids = this.getVolumeSolids();
      result = result * 59 + ($volumeSolids == null ? 43 : $volumeSolids.hashCode());
      Object $loss = this.getLoss();
      return result * 59 + ($loss == null ? 43 : $loss.hashCode());
   }

   public static class PaintingDTOBuilder {
      private BigDecimal thickness;
      private BigDecimal volumeSolids;
      private BigDecimal loss;

      PaintingDTOBuilder() {
      }

      @JsonProperty("thickness")
      public PaintingDTO.PaintingDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("volumeSolids")
      public PaintingDTO.PaintingDTOBuilder volumeSolids(final BigDecimal volumeSolids) {
         this.volumeSolids = volumeSolids;
         return this;
      }

      @JsonProperty("loss")
      public PaintingDTO.PaintingDTOBuilder loss(final BigDecimal loss) {
         this.loss = loss;
         return this;
      }

      public PaintingDTO build() {
         return new PaintingDTO(this.thickness, this.volumeSolids, this.loss);
      }

      @Override
      public String toString() {
         return "PaintingDTO.PaintingDTOBuilder(thickness=" + this.thickness + ", volumeSolids=" + this.volumeSolids + ", loss=" + this.loss + ")";
      }
   }
}
