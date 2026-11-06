package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "PaintingSettingDTO", description = "项目看板")
public class PaintingSettingDTO {
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "surfaceArea", value = "清单面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "primerPainting", value = "底漆")
   @JsonProperty("primerPainting")
   @JSONField(name = "primerPainting")
   private PaintingDTO primerPainting;
   @ApiModelProperty(name = "intermediatePainting", value = "中间漆")
   @JsonProperty("intermediatePainting")
   @JSONField(name = "intermediatePainting")
   private PaintingDTO intermediatePainting;
   @ApiModelProperty(name = "topcoatPainting", value = "面漆")
   @JsonProperty("topcoatPainting")
   @JSONField(name = "topcoatPainting")
   private PaintingDTO topcoatPainting;

   public static PaintingSettingDTO.PaintingSettingDTOBuilder builder() {
      return new PaintingSettingDTO.PaintingSettingDTOBuilder();
   }

   public PaintingSettingDTO() {
   }

   public PaintingSettingDTO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final BigDecimal surfaceArea,
      final PaintingDTO primerPainting,
      final PaintingDTO intermediatePainting,
      final PaintingDTO topcoatPainting
   ) {
      this.project = project;
      this.monomer = monomer;
      this.surfaceArea = surfaceArea;
      this.primerPainting = primerPainting;
      this.intermediatePainting = intermediatePainting;
      this.topcoatPainting = topcoatPainting;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public PaintingDTO getPrimerPainting() {
      return this.primerPainting;
   }

   public PaintingDTO getIntermediatePainting() {
      return this.intermediatePainting;
   }

   public PaintingDTO getTopcoatPainting() {
      return this.topcoatPainting;
   }

   @JsonProperty("project")
   public PaintingSettingDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public PaintingSettingDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("surfaceArea")
   public PaintingSettingDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("primerPainting")
   public PaintingSettingDTO setPrimerPainting(final PaintingDTO primerPainting) {
      this.primerPainting = primerPainting;
      return this;
   }

   @JsonProperty("intermediatePainting")
   public PaintingSettingDTO setIntermediatePainting(final PaintingDTO intermediatePainting) {
      this.intermediatePainting = intermediatePainting;
      return this;
   }

   @JsonProperty("topcoatPainting")
   public PaintingSettingDTO setTopcoatPainting(final PaintingDTO topcoatPainting) {
      this.topcoatPainting = topcoatPainting;
      return this;
   }

   @Override
   public String toString() {
      return "PaintingSettingDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", primerPainting="
         + this.getPrimerPainting()
         + ", intermediatePainting="
         + this.getIntermediatePainting()
         + ", topcoatPainting="
         + this.getTopcoatPainting()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintingSettingDTO)) {
         return false;
      }

      PaintingSettingDTO other = (PaintingSettingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$monomer = this.getMonomer();
         Object other$monomer = other.getMonomer();
         if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
            Object this$surfaceArea = this.getSurfaceArea();
            Object other$surfaceArea = other.getSurfaceArea();
            if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
               Object this$primerPainting = this.getPrimerPainting();
               Object other$primerPainting = other.getPrimerPainting();
               if (this$primerPainting == null ? other$primerPainting == null : this$primerPainting.equals(other$primerPainting)) {
                  Object this$intermediatePainting = this.getIntermediatePainting();
                  Object other$intermediatePainting = other.getIntermediatePainting();
                  if (this$intermediatePainting == null ? other$intermediatePainting == null : this$intermediatePainting.equals(other$intermediatePainting)) {
                     Object this$topcoatPainting = this.getTopcoatPainting();
                     Object other$topcoatPainting = other.getTopcoatPainting();
                     return this$topcoatPainting == null ? other$topcoatPainting == null : this$topcoatPainting.equals(other$topcoatPainting);
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
      return other instanceof PaintingSettingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $primerPainting = this.getPrimerPainting();
      result = result * 59 + ($primerPainting == null ? 43 : $primerPainting.hashCode());
      Object $intermediatePainting = this.getIntermediatePainting();
      result = result * 59 + ($intermediatePainting == null ? 43 : $intermediatePainting.hashCode());
      Object $topcoatPainting = this.getTopcoatPainting();
      return result * 59 + ($topcoatPainting == null ? 43 : $topcoatPainting.hashCode());
   }

   public static class PaintingSettingDTOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private BigDecimal surfaceArea;
      private PaintingDTO primerPainting;
      private PaintingDTO intermediatePainting;
      private PaintingDTO topcoatPainting;

      PaintingSettingDTOBuilder() {
      }

      @JsonProperty("project")
      public PaintingSettingDTO.PaintingSettingDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public PaintingSettingDTO.PaintingSettingDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("surfaceArea")
      public PaintingSettingDTO.PaintingSettingDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("primerPainting")
      public PaintingSettingDTO.PaintingSettingDTOBuilder primerPainting(final PaintingDTO primerPainting) {
         this.primerPainting = primerPainting;
         return this;
      }

      @JsonProperty("intermediatePainting")
      public PaintingSettingDTO.PaintingSettingDTOBuilder intermediatePainting(final PaintingDTO intermediatePainting) {
         this.intermediatePainting = intermediatePainting;
         return this;
      }

      @JsonProperty("topcoatPainting")
      public PaintingSettingDTO.PaintingSettingDTOBuilder topcoatPainting(final PaintingDTO topcoatPainting) {
         this.topcoatPainting = topcoatPainting;
         return this;
      }

      public PaintingSettingDTO build() {
         return new PaintingSettingDTO(this.project, this.monomer, this.surfaceArea, this.primerPainting, this.intermediatePainting, this.topcoatPainting);
      }

      @Override
      public String toString() {
         return "PaintingSettingDTO.PaintingSettingDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", surfaceArea="
            + this.surfaceArea
            + ", primerPainting="
            + this.primerPainting
            + ", intermediatePainting="
            + this.intermediatePainting
            + ", topcoatPainting="
            + this.topcoatPainting
            + ")";
      }
   }
}
