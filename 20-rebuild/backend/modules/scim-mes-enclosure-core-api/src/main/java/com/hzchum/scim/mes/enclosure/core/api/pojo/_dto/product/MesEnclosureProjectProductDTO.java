package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class MesEnclosureProjectProductDTO {
   @ApiModelProperty(name = "machinePartData", value = "零件")
   private MesEnclosureAreaProductDTO machinePartData;
   @ApiModelProperty(name = "assembleData", value = "部件")
   private MesEnclosureAreaProductDTO assembleData;
   @ApiModelProperty(name = "artifactData", value = "构件")
   private MesEnclosureAreaProductDTO artifactData;
   @ApiModelProperty(name = "carGoData", value = "发运")
   private MesEnclosureAreaProductDTO carGoData;
   @ApiModelProperty(name = "installData", value = "安装")
   private MesEnclosureAreaProductDTO installData;

   public static MesEnclosureProjectProductDTO.MesEnclosureProjectProductDTOBuilder builder() {
      return new MesEnclosureProjectProductDTO.MesEnclosureProjectProductDTOBuilder();
   }

   public MesEnclosureAreaProductDTO getMachinePartData() {
      return this.machinePartData;
   }

   public MesEnclosureAreaProductDTO getAssembleData() {
      return this.assembleData;
   }

   public MesEnclosureAreaProductDTO getArtifactData() {
      return this.artifactData;
   }

   public MesEnclosureAreaProductDTO getCarGoData() {
      return this.carGoData;
   }

   public MesEnclosureAreaProductDTO getInstallData() {
      return this.installData;
   }

   public void setMachinePartData(final MesEnclosureAreaProductDTO machinePartData) {
      this.machinePartData = machinePartData;
   }

   public void setAssembleData(final MesEnclosureAreaProductDTO assembleData) {
      this.assembleData = assembleData;
   }

   public void setArtifactData(final MesEnclosureAreaProductDTO artifactData) {
      this.artifactData = artifactData;
   }

   public void setCarGoData(final MesEnclosureAreaProductDTO carGoData) {
      this.carGoData = carGoData;
   }

   public void setInstallData(final MesEnclosureAreaProductDTO installData) {
      this.installData = installData;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProjectProductDTO)) {
         return false;
      }

      MesEnclosureProjectProductDTO other = (MesEnclosureProjectProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$machinePartData = this.getMachinePartData();
      Object other$machinePartData = other.getMachinePartData();
      if (this$machinePartData == null ? other$machinePartData == null : this$machinePartData.equals(other$machinePartData)) {
         Object this$assembleData = this.getAssembleData();
         Object other$assembleData = other.getAssembleData();
         if (this$assembleData == null ? other$assembleData == null : this$assembleData.equals(other$assembleData)) {
            Object this$artifactData = this.getArtifactData();
            Object other$artifactData = other.getArtifactData();
            if (this$artifactData == null ? other$artifactData == null : this$artifactData.equals(other$artifactData)) {
               Object this$carGoData = this.getCarGoData();
               Object other$carGoData = other.getCarGoData();
               if (this$carGoData == null ? other$carGoData == null : this$carGoData.equals(other$carGoData)) {
                  Object this$installData = this.getInstallData();
                  Object other$installData = other.getInstallData();
                  return this$installData == null ? other$installData == null : this$installData.equals(other$installData);
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
      return other instanceof MesEnclosureProjectProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $machinePartData = this.getMachinePartData();
      result = result * 59 + ($machinePartData == null ? 43 : $machinePartData.hashCode());
      Object $assembleData = this.getAssembleData();
      result = result * 59 + ($assembleData == null ? 43 : $assembleData.hashCode());
      Object $artifactData = this.getArtifactData();
      result = result * 59 + ($artifactData == null ? 43 : $artifactData.hashCode());
      Object $carGoData = this.getCarGoData();
      result = result * 59 + ($carGoData == null ? 43 : $carGoData.hashCode());
      Object $installData = this.getInstallData();
      return result * 59 + ($installData == null ? 43 : $installData.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureProjectProductDTO(machinePartData="
         + this.getMachinePartData()
         + ", assembleData="
         + this.getAssembleData()
         + ", artifactData="
         + this.getArtifactData()
         + ", carGoData="
         + this.getCarGoData()
         + ", installData="
         + this.getInstallData()
         + ")";
   }

   public MesEnclosureProjectProductDTO(
      final MesEnclosureAreaProductDTO machinePartData,
      final MesEnclosureAreaProductDTO assembleData,
      final MesEnclosureAreaProductDTO artifactData,
      final MesEnclosureAreaProductDTO carGoData,
      final MesEnclosureAreaProductDTO installData
   ) {
      this.machinePartData = machinePartData;
      this.assembleData = assembleData;
      this.artifactData = artifactData;
      this.carGoData = carGoData;
      this.installData = installData;
   }

   public MesEnclosureProjectProductDTO() {
   }

   public static class MesEnclosureProjectProductDTOBuilder {
      private MesEnclosureAreaProductDTO machinePartData;
      private MesEnclosureAreaProductDTO assembleData;
      private MesEnclosureAreaProductDTO artifactData;
      private MesEnclosureAreaProductDTO carGoData;
      private MesEnclosureAreaProductDTO installData;

      MesEnclosureProjectProductDTOBuilder() {
      }

      public MesEnclosureProjectProductDTO.MesEnclosureProjectProductDTOBuilder machinePartData(final MesEnclosureAreaProductDTO machinePartData) {
         this.machinePartData = machinePartData;
         return this;
      }

      public MesEnclosureProjectProductDTO.MesEnclosureProjectProductDTOBuilder assembleData(final MesEnclosureAreaProductDTO assembleData) {
         this.assembleData = assembleData;
         return this;
      }

      public MesEnclosureProjectProductDTO.MesEnclosureProjectProductDTOBuilder artifactData(final MesEnclosureAreaProductDTO artifactData) {
         this.artifactData = artifactData;
         return this;
      }

      public MesEnclosureProjectProductDTO.MesEnclosureProjectProductDTOBuilder carGoData(final MesEnclosureAreaProductDTO carGoData) {
         this.carGoData = carGoData;
         return this;
      }

      public MesEnclosureProjectProductDTO.MesEnclosureProjectProductDTOBuilder installData(final MesEnclosureAreaProductDTO installData) {
         this.installData = installData;
         return this;
      }

      public MesEnclosureProjectProductDTO build() {
         return new MesEnclosureProjectProductDTO(this.machinePartData, this.assembleData, this.artifactData, this.carGoData, this.installData);
      }

      @Override
      public String toString() {
         return "MesEnclosureProjectProductDTO.MesEnclosureProjectProductDTOBuilder(machinePartData="
            + this.machinePartData
            + ", assembleData="
            + this.assembleData
            + ", artifactData="
            + this.artifactData
            + ", carGoData="
            + this.carGoData
            + ", installData="
            + this.installData
            + ")";
      }
   }
}
