package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class MesBuildingProjectProductDTO {
   @ApiModelProperty(name = "machinePartData", value = "零件")
   private MesBuildingAreaProductDTO machinePartData;
   @ApiModelProperty(name = "assembleData", value = "部件")
   private MesBuildingAreaProductDTO assembleData;
   @ApiModelProperty(name = "artifactData", value = "构件")
   private MesBuildingAreaProductDTO artifactData;
   @ApiModelProperty(name = "carGoData", value = "发运")
   private MesBuildingAreaProductDTO carGoData;
   @ApiModelProperty(name = "installData", value = "安装")
   private MesBuildingAreaProductDTO installData;

   public static MesBuildingProjectProductDTO.MesBuildingProjectProductDTOBuilder builder() {
      return new MesBuildingProjectProductDTO.MesBuildingProjectProductDTOBuilder();
   }

   public MesBuildingAreaProductDTO getMachinePartData() {
      return this.machinePartData;
   }

   public MesBuildingAreaProductDTO getAssembleData() {
      return this.assembleData;
   }

   public MesBuildingAreaProductDTO getArtifactData() {
      return this.artifactData;
   }

   public MesBuildingAreaProductDTO getCarGoData() {
      return this.carGoData;
   }

   public MesBuildingAreaProductDTO getInstallData() {
      return this.installData;
   }

   public void setMachinePartData(final MesBuildingAreaProductDTO machinePartData) {
      this.machinePartData = machinePartData;
   }

   public void setAssembleData(final MesBuildingAreaProductDTO assembleData) {
      this.assembleData = assembleData;
   }

   public void setArtifactData(final MesBuildingAreaProductDTO artifactData) {
      this.artifactData = artifactData;
   }

   public void setCarGoData(final MesBuildingAreaProductDTO carGoData) {
      this.carGoData = carGoData;
   }

   public void setInstallData(final MesBuildingAreaProductDTO installData) {
      this.installData = installData;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProjectProductDTO)) {
         return false;
      }

      MesBuildingProjectProductDTO other = (MesBuildingProjectProductDTO)o;
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
      return other instanceof MesBuildingProjectProductDTO;
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
      return "MesBuildingProjectProductDTO(machinePartData="
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

   public MesBuildingProjectProductDTO(
      final MesBuildingAreaProductDTO machinePartData,
      final MesBuildingAreaProductDTO assembleData,
      final MesBuildingAreaProductDTO artifactData,
      final MesBuildingAreaProductDTO carGoData,
      final MesBuildingAreaProductDTO installData
   ) {
      this.machinePartData = machinePartData;
      this.assembleData = assembleData;
      this.artifactData = artifactData;
      this.carGoData = carGoData;
      this.installData = installData;
   }

   public MesBuildingProjectProductDTO() {
   }

   public static class MesBuildingProjectProductDTOBuilder {
      private MesBuildingAreaProductDTO machinePartData;
      private MesBuildingAreaProductDTO assembleData;
      private MesBuildingAreaProductDTO artifactData;
      private MesBuildingAreaProductDTO carGoData;
      private MesBuildingAreaProductDTO installData;

      MesBuildingProjectProductDTOBuilder() {
      }

      public MesBuildingProjectProductDTO.MesBuildingProjectProductDTOBuilder machinePartData(final MesBuildingAreaProductDTO machinePartData) {
         this.machinePartData = machinePartData;
         return this;
      }

      public MesBuildingProjectProductDTO.MesBuildingProjectProductDTOBuilder assembleData(final MesBuildingAreaProductDTO assembleData) {
         this.assembleData = assembleData;
         return this;
      }

      public MesBuildingProjectProductDTO.MesBuildingProjectProductDTOBuilder artifactData(final MesBuildingAreaProductDTO artifactData) {
         this.artifactData = artifactData;
         return this;
      }

      public MesBuildingProjectProductDTO.MesBuildingProjectProductDTOBuilder carGoData(final MesBuildingAreaProductDTO carGoData) {
         this.carGoData = carGoData;
         return this;
      }

      public MesBuildingProjectProductDTO.MesBuildingProjectProductDTOBuilder installData(final MesBuildingAreaProductDTO installData) {
         this.installData = installData;
         return this;
      }

      public MesBuildingProjectProductDTO build() {
         return new MesBuildingProjectProductDTO(this.machinePartData, this.assembleData, this.artifactData, this.carGoData, this.installData);
      }

      @Override
      public String toString() {
         return "MesBuildingProjectProductDTO.MesBuildingProjectProductDTOBuilder(machinePartData="
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
