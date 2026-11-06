package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProcessListDTO", description = "")
public class ProcessListDTO {
   @ApiModelProperty(name = "artifactProcessList", notes = "构件工序", value = "构件工序")
   @JsonProperty("artifactProcessList")
   @JSONField(name = "artifactProcessList")
   private List<MesBuildingProcessDTO> artifactProcessList;
   @ApiModelProperty(name = "assembleProcessList", notes = "部件工序", value = "部件工序")
   @JsonProperty("assembleProcessList")
   @JSONField(name = "assembleProcessList")
   private List<MesBuildingProcessDTO> assembleProcessList;
   @ApiModelProperty(name = "machinePartProcessList", notes = "零件工序", value = "零件工序")
   @JsonProperty("machinePartProcessList")
   @JSONField(name = "machinePartProcessList")
   private List<MesBuildingProcessDTO> machinePartProcessList;

   public static ProcessListDTO.ProcessListDTOBuilder builder() {
      return new ProcessListDTO.ProcessListDTOBuilder();
   }

   public ProcessListDTO() {
   }

   public ProcessListDTO(
      final List<MesBuildingProcessDTO> artifactProcessList,
      final List<MesBuildingProcessDTO> assembleProcessList,
      final List<MesBuildingProcessDTO> machinePartProcessList
   ) {
      this.artifactProcessList = artifactProcessList;
      this.assembleProcessList = assembleProcessList;
      this.machinePartProcessList = machinePartProcessList;
   }

   public List<MesBuildingProcessDTO> getArtifactProcessList() {
      return this.artifactProcessList;
   }

   public List<MesBuildingProcessDTO> getAssembleProcessList() {
      return this.assembleProcessList;
   }

   public List<MesBuildingProcessDTO> getMachinePartProcessList() {
      return this.machinePartProcessList;
   }

   @JsonProperty("artifactProcessList")
   public ProcessListDTO setArtifactProcessList(final List<MesBuildingProcessDTO> artifactProcessList) {
      this.artifactProcessList = artifactProcessList;
      return this;
   }

   @JsonProperty("assembleProcessList")
   public ProcessListDTO setAssembleProcessList(final List<MesBuildingProcessDTO> assembleProcessList) {
      this.assembleProcessList = assembleProcessList;
      return this;
   }

   @JsonProperty("machinePartProcessList")
   public ProcessListDTO setMachinePartProcessList(final List<MesBuildingProcessDTO> machinePartProcessList) {
      this.machinePartProcessList = machinePartProcessList;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessListDTO(artifactProcessList="
         + this.getArtifactProcessList()
         + ", assembleProcessList="
         + this.getAssembleProcessList()
         + ", machinePartProcessList="
         + this.getMachinePartProcessList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessListDTO)) {
         return false;
      }

      ProcessListDTO other = (ProcessListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactProcessList = this.getArtifactProcessList();
      Object other$artifactProcessList = other.getArtifactProcessList();
      if (this$artifactProcessList == null ? other$artifactProcessList == null : this$artifactProcessList.equals(other$artifactProcessList)) {
         Object this$assembleProcessList = this.getAssembleProcessList();
         Object other$assembleProcessList = other.getAssembleProcessList();
         if (this$assembleProcessList == null ? other$assembleProcessList == null : this$assembleProcessList.equals(other$assembleProcessList)) {
            Object this$machinePartProcessList = this.getMachinePartProcessList();
            Object other$machinePartProcessList = other.getMachinePartProcessList();
            return this$machinePartProcessList == null
               ? other$machinePartProcessList == null
               : this$machinePartProcessList.equals(other$machinePartProcessList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactProcessList = this.getArtifactProcessList();
      result = result * 59 + ($artifactProcessList == null ? 43 : $artifactProcessList.hashCode());
      Object $assembleProcessList = this.getAssembleProcessList();
      result = result * 59 + ($assembleProcessList == null ? 43 : $assembleProcessList.hashCode());
      Object $machinePartProcessList = this.getMachinePartProcessList();
      return result * 59 + ($machinePartProcessList == null ? 43 : $machinePartProcessList.hashCode());
   }

   public static class ProcessListDTOBuilder {
      private List<MesBuildingProcessDTO> artifactProcessList;
      private List<MesBuildingProcessDTO> assembleProcessList;
      private List<MesBuildingProcessDTO> machinePartProcessList;

      ProcessListDTOBuilder() {
      }

      @JsonProperty("artifactProcessList")
      public ProcessListDTO.ProcessListDTOBuilder artifactProcessList(final List<MesBuildingProcessDTO> artifactProcessList) {
         this.artifactProcessList = artifactProcessList;
         return this;
      }

      @JsonProperty("assembleProcessList")
      public ProcessListDTO.ProcessListDTOBuilder assembleProcessList(final List<MesBuildingProcessDTO> assembleProcessList) {
         this.assembleProcessList = assembleProcessList;
         return this;
      }

      @JsonProperty("machinePartProcessList")
      public ProcessListDTO.ProcessListDTOBuilder machinePartProcessList(final List<MesBuildingProcessDTO> machinePartProcessList) {
         this.machinePartProcessList = machinePartProcessList;
         return this;
      }

      public ProcessListDTO build() {
         return new ProcessListDTO(this.artifactProcessList, this.assembleProcessList, this.machinePartProcessList);
      }

      @Override
      public String toString() {
         return "ProcessListDTO.ProcessListDTOBuilder(artifactProcessList="
            + this.artifactProcessList
            + ", assembleProcessList="
            + this.assembleProcessList
            + ", machinePartProcessList="
            + this.machinePartProcessList
            + ")";
      }
   }
}
