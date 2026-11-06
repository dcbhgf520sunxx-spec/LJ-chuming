package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingArtifactSchedulingAssembleDTO", description = "构件排产所需部件信息汇总")
public class MesBuildingArtifactSchedulingAssembleDTO {
   @ApiModelProperty(name = "assembleList", value = "部件信息", notes = "部件信息")
   @JsonProperty("assembleList")
   @JSONField(name = "assembleList")
   private List<MesBuildingAssembleSchedulingDTO> assembleList;
   @ApiModelProperty(name = "groupsId", value = "班组信息", notes = "班组信息")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;

   MesBuildingArtifactSchedulingAssembleDTO(final List<MesBuildingAssembleSchedulingDTO> assembleList, final Long groupsId) {
      this.assembleList = assembleList;
      this.groupsId = groupsId;
   }

   public static MesBuildingArtifactSchedulingAssembleDTO.MesBuildingArtifactSchedulingAssembleDTOBuilder builder() {
      return new MesBuildingArtifactSchedulingAssembleDTO.MesBuildingArtifactSchedulingAssembleDTOBuilder();
   }

   public List<MesBuildingAssembleSchedulingDTO> getAssembleList() {
      return this.assembleList;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   @JsonProperty("assembleList")
   public MesBuildingArtifactSchedulingAssembleDTO setAssembleList(final List<MesBuildingAssembleSchedulingDTO> assembleList) {
      this.assembleList = assembleList;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingArtifactSchedulingAssembleDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingAssembleDTO(assembleList=" + this.getAssembleList() + ", groupsId=" + this.getGroupsId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingArtifactSchedulingAssembleDTO)) {
         return false;
      } else {
         MesBuildingArtifactSchedulingAssembleDTO other = (MesBuildingArtifactSchedulingAssembleDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$groupsId = this.getGroupsId();
            Object other$groupsId = other.getGroupsId();
            if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
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
      return other instanceof MesBuildingArtifactSchedulingAssembleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $assembleList = this.getAssembleList();
      return result * 59 + ($assembleList == null ? 43 : $assembleList.hashCode());
   }

   public static class MesBuildingArtifactSchedulingAssembleDTOBuilder {
      private List<MesBuildingAssembleSchedulingDTO> assembleList;
      private Long groupsId;

      MesBuildingArtifactSchedulingAssembleDTOBuilder() {
      }

      @JsonProperty("assembleList")
      public MesBuildingArtifactSchedulingAssembleDTO.MesBuildingArtifactSchedulingAssembleDTOBuilder assembleList(
         final List<MesBuildingAssembleSchedulingDTO> assembleList
      ) {
         this.assembleList = assembleList;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingArtifactSchedulingAssembleDTO.MesBuildingArtifactSchedulingAssembleDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public MesBuildingArtifactSchedulingAssembleDTO build() {
         return new MesBuildingArtifactSchedulingAssembleDTO(this.assembleList, this.groupsId);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingAssembleDTO.MesBuildingArtifactSchedulingAssembleDTOBuilder(assembleList="
            + this.assembleList
            + ", groupsId="
            + this.groupsId
            + ")";
      }
   }
}
