package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ArtifactSchedulingDTO", description = "项目排期信息 ")
public class ArtifactSchedulingDTO {
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体信息")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "schedulingTotalGrossWeight", value = "排产总毛重（kg）")
   @JsonProperty("schedulingTotalGrossWeight")
   @JSONField(name = "schedulingTotalGrossWeight")
   private BigDecimal schedulingTotalGrossWeight;
   @ApiModelProperty(name = "schedulingTotalNetWeight", value = "排产总净重（kg）")
   @JsonProperty("schedulingTotalNetWeight")
   @JSONField(name = "schedulingTotalNetWeight")
   private BigDecimal schedulingTotalNetWeight;
   @ApiModelProperty(name = "completeTotalGrossWeight", value = "完成产总毛重（kg）")
   @JsonProperty("completeTotalGrossWeight")
   @JSONField(name = "completeTotalGrossWeight")
   private BigDecimal completeTotalGrossWeight;
   @ApiModelProperty(name = "completeTotalNetWeight", value = "完成总净重（kg）")
   @JsonProperty("completeTotalNetWeight")
   @JSONField(name = "completeTotalNetWeight")
   private BigDecimal completeTotalNetWeight;
   @ApiModelProperty(name = "mete", value = "产量", notes = "产量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private List<YearQuantityAndMeteDTO> mete;

   public static ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder builder() {
      return new ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder();
   }

   public ArtifactSchedulingDTO() {
   }

   public ArtifactSchedulingDTO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final BigDecimal schedulingTotalGrossWeight,
      final BigDecimal schedulingTotalNetWeight,
      final BigDecimal completeTotalGrossWeight,
      final BigDecimal completeTotalNetWeight,
      final List<YearQuantityAndMeteDTO> mete
   ) {
      this.project = project;
      this.monomer = monomer;
      this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      this.completeTotalGrossWeight = completeTotalGrossWeight;
      this.completeTotalNetWeight = completeTotalNetWeight;
      this.mete = mete;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public BigDecimal getSchedulingTotalGrossWeight() {
      return this.schedulingTotalGrossWeight;
   }

   public BigDecimal getSchedulingTotalNetWeight() {
      return this.schedulingTotalNetWeight;
   }

   public BigDecimal getCompleteTotalGrossWeight() {
      return this.completeTotalGrossWeight;
   }

   public BigDecimal getCompleteTotalNetWeight() {
      return this.completeTotalNetWeight;
   }

   public List<YearQuantityAndMeteDTO> getMete() {
      return this.mete;
   }

   @JsonProperty("project")
   public ArtifactSchedulingDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ArtifactSchedulingDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("schedulingTotalGrossWeight")
   public ArtifactSchedulingDTO setSchedulingTotalGrossWeight(final BigDecimal schedulingTotalGrossWeight) {
      this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public ArtifactSchedulingDTO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("completeTotalGrossWeight")
   public ArtifactSchedulingDTO setCompleteTotalGrossWeight(final BigDecimal completeTotalGrossWeight) {
      this.completeTotalGrossWeight = completeTotalGrossWeight;
      return this;
   }

   @JsonProperty("completeTotalNetWeight")
   public ArtifactSchedulingDTO setCompleteTotalNetWeight(final BigDecimal completeTotalNetWeight) {
      this.completeTotalNetWeight = completeTotalNetWeight;
      return this;
   }

   @JsonProperty("mete")
   public ArtifactSchedulingDTO setMete(final List<YearQuantityAndMeteDTO> mete) {
      this.mete = mete;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactSchedulingDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", schedulingTotalGrossWeight="
         + this.getSchedulingTotalGrossWeight()
         + ", schedulingTotalNetWeight="
         + this.getSchedulingTotalNetWeight()
         + ", completeTotalGrossWeight="
         + this.getCompleteTotalGrossWeight()
         + ", completeTotalNetWeight="
         + this.getCompleteTotalNetWeight()
         + ", mete="
         + this.getMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactSchedulingDTO)) {
         return false;
      }

      ArtifactSchedulingDTO other = (ArtifactSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$monomer = this.getMonomer();
         Object other$monomer = other.getMonomer();
         if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
            Object this$schedulingTotalGrossWeight = this.getSchedulingTotalGrossWeight();
            Object other$schedulingTotalGrossWeight = other.getSchedulingTotalGrossWeight();
            if (this$schedulingTotalGrossWeight == null
               ? other$schedulingTotalGrossWeight == null
               : this$schedulingTotalGrossWeight.equals(other$schedulingTotalGrossWeight)) {
               Object this$schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
               Object other$schedulingTotalNetWeight = other.getSchedulingTotalNetWeight();
               if (this$schedulingTotalNetWeight == null
                  ? other$schedulingTotalNetWeight == null
                  : this$schedulingTotalNetWeight.equals(other$schedulingTotalNetWeight)) {
                  Object this$completeTotalGrossWeight = this.getCompleteTotalGrossWeight();
                  Object other$completeTotalGrossWeight = other.getCompleteTotalGrossWeight();
                  if (this$completeTotalGrossWeight == null
                     ? other$completeTotalGrossWeight == null
                     : this$completeTotalGrossWeight.equals(other$completeTotalGrossWeight)) {
                     Object this$completeTotalNetWeight = this.getCompleteTotalNetWeight();
                     Object other$completeTotalNetWeight = other.getCompleteTotalNetWeight();
                     if (this$completeTotalNetWeight == null
                        ? other$completeTotalNetWeight == null
                        : this$completeTotalNetWeight.equals(other$completeTotalNetWeight)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $schedulingTotalGrossWeight = this.getSchedulingTotalGrossWeight();
      result = result * 59 + ($schedulingTotalGrossWeight == null ? 43 : $schedulingTotalGrossWeight.hashCode());
      Object $schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
      result = result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
      Object $completeTotalGrossWeight = this.getCompleteTotalGrossWeight();
      result = result * 59 + ($completeTotalGrossWeight == null ? 43 : $completeTotalGrossWeight.hashCode());
      Object $completeTotalNetWeight = this.getCompleteTotalNetWeight();
      result = result * 59 + ($completeTotalNetWeight == null ? 43 : $completeTotalNetWeight.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   public static class ArtifactSchedulingDTOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private BigDecimal schedulingTotalGrossWeight;
      private BigDecimal schedulingTotalNetWeight;
      private BigDecimal completeTotalGrossWeight;
      private BigDecimal completeTotalNetWeight;
      private List<YearQuantityAndMeteDTO> mete;

      ArtifactSchedulingDTOBuilder() {
      }

      @JsonProperty("project")
      public ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("schedulingTotalGrossWeight")
      public ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder schedulingTotalGrossWeight(final BigDecimal schedulingTotalGrossWeight) {
         this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
         return this;
      }

      @JsonProperty("schedulingTotalNetWeight")
      public ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder schedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
         this.schedulingTotalNetWeight = schedulingTotalNetWeight;
         return this;
      }

      @JsonProperty("completeTotalGrossWeight")
      public ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder completeTotalGrossWeight(final BigDecimal completeTotalGrossWeight) {
         this.completeTotalGrossWeight = completeTotalGrossWeight;
         return this;
      }

      @JsonProperty("completeTotalNetWeight")
      public ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder completeTotalNetWeight(final BigDecimal completeTotalNetWeight) {
         this.completeTotalNetWeight = completeTotalNetWeight;
         return this;
      }

      @JsonProperty("mete")
      public ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder mete(final List<YearQuantityAndMeteDTO> mete) {
         this.mete = mete;
         return this;
      }

      public ArtifactSchedulingDTO build() {
         return new ArtifactSchedulingDTO(
            this.project,
            this.monomer,
            this.schedulingTotalGrossWeight,
            this.schedulingTotalNetWeight,
            this.completeTotalGrossWeight,
            this.completeTotalNetWeight,
            this.mete
         );
      }

      @Override
      public String toString() {
         return "ArtifactSchedulingDTO.ArtifactSchedulingDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", schedulingTotalGrossWeight="
            + this.schedulingTotalGrossWeight
            + ", schedulingTotalNetWeight="
            + this.schedulingTotalNetWeight
            + ", completeTotalGrossWeight="
            + this.completeTotalGrossWeight
            + ", completeTotalNetWeight="
            + this.completeTotalNetWeight
            + ", mete="
            + this.mete
            + ")";
      }
   }
}
