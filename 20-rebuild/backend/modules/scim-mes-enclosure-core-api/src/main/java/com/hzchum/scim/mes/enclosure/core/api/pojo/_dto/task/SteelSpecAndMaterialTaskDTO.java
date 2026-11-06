package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.MaterialTaskDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.SteelSpecTaskDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "SteelSpecTaskDTO", description = "零件板厚规格 ")
public class SteelSpecAndMaterialTaskDTO {
   @ApiModelProperty(name = "steelSpecs", notes = "板厚/规格")
   @JsonProperty("steelSpecs")
   @JSONField(name = "steelSpecs")
   private List<SteelSpecTaskDO> steelSpecs;
   @ApiModelProperty(name = "materials", notes = "材质")
   @JsonProperty("materials")
   @JSONField(name = "materials")
   private List<MaterialTaskDO> materials;

   public static SteelSpecAndMaterialTaskDTO.SteelSpecAndMaterialTaskDTOBuilder builder() {
      return new SteelSpecAndMaterialTaskDTO.SteelSpecAndMaterialTaskDTOBuilder();
   }

   public List<SteelSpecTaskDO> getSteelSpecs() {
      return this.steelSpecs;
   }

   public List<MaterialTaskDO> getMaterials() {
      return this.materials;
   }

   @JsonProperty("steelSpecs")
   public SteelSpecAndMaterialTaskDTO setSteelSpecs(final List<SteelSpecTaskDO> steelSpecs) {
      this.steelSpecs = steelSpecs;
      return this;
   }

   @JsonProperty("materials")
   public SteelSpecAndMaterialTaskDTO setMaterials(final List<MaterialTaskDO> materials) {
      this.materials = materials;
      return this;
   }

   @Override
   public String toString() {
      return "SteelSpecAndMaterialTaskDTO(steelSpecs=" + this.getSteelSpecs() + ", materials=" + this.getMaterials() + ")";
   }

   public SteelSpecAndMaterialTaskDTO(final List<SteelSpecTaskDO> steelSpecs, final List<MaterialTaskDO> materials) {
      this.steelSpecs = steelSpecs;
      this.materials = materials;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SteelSpecAndMaterialTaskDTO)) {
         return false;
      } else {
         SteelSpecAndMaterialTaskDTO other = (SteelSpecAndMaterialTaskDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$steelSpecs = this.getSteelSpecs();
            Object other$steelSpecs = other.getSteelSpecs();
            if (this$steelSpecs == null ? other$steelSpecs == null : this$steelSpecs.equals(other$steelSpecs)) {
               Object this$materials = this.getMaterials();
               Object other$materials = other.getMaterials();
               return this$materials == null ? other$materials == null : this$materials.equals(other$materials);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelSpecAndMaterialTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelSpecs = this.getSteelSpecs();
      result = result * 59 + ($steelSpecs == null ? 43 : $steelSpecs.hashCode());
      Object $materials = this.getMaterials();
      return result * 59 + ($materials == null ? 43 : $materials.hashCode());
   }

   public static class SteelSpecAndMaterialTaskDTOBuilder {
      private List<SteelSpecTaskDO> steelSpecs;
      private List<MaterialTaskDO> materials;

      SteelSpecAndMaterialTaskDTOBuilder() {
      }

      @JsonProperty("steelSpecs")
      public SteelSpecAndMaterialTaskDTO.SteelSpecAndMaterialTaskDTOBuilder steelSpecs(final List<SteelSpecTaskDO> steelSpecs) {
         this.steelSpecs = steelSpecs;
         return this;
      }

      @JsonProperty("materials")
      public SteelSpecAndMaterialTaskDTO.SteelSpecAndMaterialTaskDTOBuilder materials(final List<MaterialTaskDO> materials) {
         this.materials = materials;
         return this;
      }

      public SteelSpecAndMaterialTaskDTO build() {
         return new SteelSpecAndMaterialTaskDTO(this.steelSpecs, this.materials);
      }

      @Override
      public String toString() {
         return "SteelSpecAndMaterialTaskDTO.SteelSpecAndMaterialTaskDTOBuilder(steelSpecs=" + this.steelSpecs + ", materials=" + this.materials + ")";
      }
   }
}
