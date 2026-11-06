package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProgressProcessDTO", description = "工序进度列表")
public class ProgressProcessDTO {
   @ApiModelProperty(name = "artifactList", notes = "构件")
   @JsonProperty("artifactList")
   @JSONField(name = "artifactList")
   private List<List<TaskTrackingProcessDTO>> artifactList;
   @ApiModelProperty(name = "assembleList", notes = "部件")
   @JsonProperty("assembleList")
   @JSONField(name = "assembleList")
   private List<List<TaskTrackingProcessDTO>> assembleList;

   public static ProgressProcessDTO.ProgressProcessDTOBuilder builder() {
      return new ProgressProcessDTO.ProgressProcessDTOBuilder();
   }

   public ProgressProcessDTO() {
   }

   public ProgressProcessDTO(final List<List<TaskTrackingProcessDTO>> artifactList, final List<List<TaskTrackingProcessDTO>> assembleList) {
      this.artifactList = artifactList;
      this.assembleList = assembleList;
   }

   public List<List<TaskTrackingProcessDTO>> getArtifactList() {
      return this.artifactList;
   }

   public List<List<TaskTrackingProcessDTO>> getAssembleList() {
      return this.assembleList;
   }

   @JsonProperty("artifactList")
   public ProgressProcessDTO setArtifactList(final List<List<TaskTrackingProcessDTO>> artifactList) {
      this.artifactList = artifactList;
      return this;
   }

   @JsonProperty("assembleList")
   public ProgressProcessDTO setAssembleList(final List<List<TaskTrackingProcessDTO>> assembleList) {
      this.assembleList = assembleList;
      return this;
   }

   @Override
   public String toString() {
      return "ProgressProcessDTO(artifactList=" + this.getArtifactList() + ", assembleList=" + this.getAssembleList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProgressProcessDTO)) {
         return false;
      } else {
         ProgressProcessDTO other = (ProgressProcessDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactList = this.getArtifactList();
            Object other$artifactList = other.getArtifactList();
            if (this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList)) {
               Object this$assembleList = this.getAssembleList();
               Object other$assembleList = other.getAssembleList();
               return this$assembleList == null ? other$assembleList == null : this$assembleList.equals(other$assembleList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProgressProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactList = this.getArtifactList();
      result = result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
      Object $assembleList = this.getAssembleList();
      return result * 59 + ($assembleList == null ? 43 : $assembleList.hashCode());
   }

   public static class ProgressProcessDTOBuilder {
      private List<List<TaskTrackingProcessDTO>> artifactList;
      private List<List<TaskTrackingProcessDTO>> assembleList;

      ProgressProcessDTOBuilder() {
      }

      @JsonProperty("artifactList")
      public ProgressProcessDTO.ProgressProcessDTOBuilder artifactList(final List<List<TaskTrackingProcessDTO>> artifactList) {
         this.artifactList = artifactList;
         return this;
      }

      @JsonProperty("assembleList")
      public ProgressProcessDTO.ProgressProcessDTOBuilder assembleList(final List<List<TaskTrackingProcessDTO>> assembleList) {
         this.assembleList = assembleList;
         return this;
      }

      public ProgressProcessDTO build() {
         return new ProgressProcessDTO(this.artifactList, this.assembleList);
      }

      @Override
      public String toString() {
         return "ProgressProcessDTO.ProgressProcessDTOBuilder(artifactList=" + this.artifactList + ", assembleList=" + this.assembleList + ")";
      }
   }
}
