package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "TaskProductLineListDTO", description = "任务跟踪列表")
public class TaskProductLineListDTO {
   @ApiModelProperty(name = "artifactList", notes = "构件")
   @JsonProperty("artifactList")
   @JSONField(name = "artifactList")
   private List<TaskProductDTO> artifactList;
   @ApiModelProperty(name = "assembleList", notes = "部件")
   @JsonProperty("assembleList")
   @JSONField(name = "assembleList")
   private List<TaskProductDTO> assembleList;
   @ApiModelProperty(name = "machineList", notes = "零件")
   @JsonProperty("machineList")
   @JSONField(name = "machineList")
   private List<TaskProductDTO> machineList;

   public static TaskProductLineListDTO.TaskProductLineListDTOBuilder builder() {
      return new TaskProductLineListDTO.TaskProductLineListDTOBuilder();
   }

   public TaskProductLineListDTO() {
   }

   public TaskProductLineListDTO(final List<TaskProductDTO> artifactList, final List<TaskProductDTO> assembleList, final List<TaskProductDTO> machineList) {
      this.artifactList = artifactList;
      this.assembleList = assembleList;
      this.machineList = machineList;
   }

   public List<TaskProductDTO> getArtifactList() {
      return this.artifactList;
   }

   public List<TaskProductDTO> getAssembleList() {
      return this.assembleList;
   }

   public List<TaskProductDTO> getMachineList() {
      return this.machineList;
   }

   @JsonProperty("artifactList")
   public TaskProductLineListDTO setArtifactList(final List<TaskProductDTO> artifactList) {
      this.artifactList = artifactList;
      return this;
   }

   @JsonProperty("assembleList")
   public TaskProductLineListDTO setAssembleList(final List<TaskProductDTO> assembleList) {
      this.assembleList = assembleList;
      return this;
   }

   @JsonProperty("machineList")
   public TaskProductLineListDTO setMachineList(final List<TaskProductDTO> machineList) {
      this.machineList = machineList;
      return this;
   }

   @Override
   public String toString() {
      return "TaskProductLineListDTO(artifactList="
         + this.getArtifactList()
         + ", assembleList="
         + this.getAssembleList()
         + ", machineList="
         + this.getMachineList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskProductLineListDTO)) {
         return false;
      }

      TaskProductLineListDTO other = (TaskProductLineListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactList = this.getArtifactList();
      Object other$artifactList = other.getArtifactList();
      if (this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList)) {
         Object this$assembleList = this.getAssembleList();
         Object other$assembleList = other.getAssembleList();
         if (this$assembleList == null ? other$assembleList == null : this$assembleList.equals(other$assembleList)) {
            Object this$machineList = this.getMachineList();
            Object other$machineList = other.getMachineList();
            return this$machineList == null ? other$machineList == null : this$machineList.equals(other$machineList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskProductLineListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactList = this.getArtifactList();
      result = result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
      Object $assembleList = this.getAssembleList();
      result = result * 59 + ($assembleList == null ? 43 : $assembleList.hashCode());
      Object $machineList = this.getMachineList();
      return result * 59 + ($machineList == null ? 43 : $machineList.hashCode());
   }

   public static class TaskProductLineListDTOBuilder {
      private List<TaskProductDTO> artifactList;
      private List<TaskProductDTO> assembleList;
      private List<TaskProductDTO> machineList;

      TaskProductLineListDTOBuilder() {
      }

      @JsonProperty("artifactList")
      public TaskProductLineListDTO.TaskProductLineListDTOBuilder artifactList(final List<TaskProductDTO> artifactList) {
         this.artifactList = artifactList;
         return this;
      }

      @JsonProperty("assembleList")
      public TaskProductLineListDTO.TaskProductLineListDTOBuilder assembleList(final List<TaskProductDTO> assembleList) {
         this.assembleList = assembleList;
         return this;
      }

      @JsonProperty("machineList")
      public TaskProductLineListDTO.TaskProductLineListDTOBuilder machineList(final List<TaskProductDTO> machineList) {
         this.machineList = machineList;
         return this;
      }

      public TaskProductLineListDTO build() {
         return new TaskProductLineListDTO(this.artifactList, this.assembleList, this.machineList);
      }

      @Override
      public String toString() {
         return "TaskProductLineListDTO.TaskProductLineListDTOBuilder(artifactList="
            + this.artifactList
            + ", assembleList="
            + this.assembleList
            + ", machineList="
            + this.machineList
            + ")";
      }
   }
}
