package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingArtifactSchedulingAssembleAndTypesettingDTO", description = "构件排产所需部件信息汇总")
public class MesBuildingArtifactSchedulingAssembleAndTypesettingDTO {
   @ApiModelProperty(name = "assembleSchedulingList", value = "部件排产信息", notes = "部件排产信息")
   @JsonProperty("assembleSchedulingList")
   @JSONField(name = "assembleSchedulingList")
   private List<MesBuildingArtifactSchedulingAssembleDTO> assembleSchedulingList;
   @ApiModelProperty(name = "surplusAssemble", value = "多余组立信息", notes = "多余组立信息")
   @JsonProperty("surplusAssemble")
   @JSONField(name = "surplusAssemble")
   private List<MesBuildingArtifactSchedulingSurplusAssembleDTO> surplusAssemble;

   MesBuildingArtifactSchedulingAssembleAndTypesettingDTO(
      final List<MesBuildingArtifactSchedulingAssembleDTO> assembleSchedulingList, final List<MesBuildingArtifactSchedulingSurplusAssembleDTO> surplusAssemble
   ) {
      this.assembleSchedulingList = assembleSchedulingList;
      this.surplusAssemble = surplusAssemble;
   }

   public static MesBuildingArtifactSchedulingAssembleAndTypesettingDTO.MesBuildingArtifactSchedulingAssembleAndTypesettingDTOBuilder builder() {
      return new MesBuildingArtifactSchedulingAssembleAndTypesettingDTO.MesBuildingArtifactSchedulingAssembleAndTypesettingDTOBuilder();
   }

   public List<MesBuildingArtifactSchedulingAssembleDTO> getAssembleSchedulingList() {
      return this.assembleSchedulingList;
   }

   public List<MesBuildingArtifactSchedulingSurplusAssembleDTO> getSurplusAssemble() {
      return this.surplusAssemble;
   }

   @JsonProperty("assembleSchedulingList")
   public MesBuildingArtifactSchedulingAssembleAndTypesettingDTO setAssembleSchedulingList(
      final List<MesBuildingArtifactSchedulingAssembleDTO> assembleSchedulingList
   ) {
      this.assembleSchedulingList = assembleSchedulingList;
      return this;
   }

   @JsonProperty("surplusAssemble")
   public MesBuildingArtifactSchedulingAssembleAndTypesettingDTO setSurplusAssemble(final List<MesBuildingArtifactSchedulingSurplusAssembleDTO> surplusAssemble) {
      this.surplusAssemble = surplusAssemble;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingAssembleAndTypesettingDTO(assembleSchedulingList="
         + this.getAssembleSchedulingList()
         + ", surplusAssemble="
         + this.getSurplusAssemble()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingArtifactSchedulingAssembleAndTypesettingDTO)) {
         return false;
      } else {
         MesBuildingArtifactSchedulingAssembleAndTypesettingDTO other = (MesBuildingArtifactSchedulingAssembleAndTypesettingDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$assembleSchedulingList = this.getAssembleSchedulingList();
            Object other$assembleSchedulingList = other.getAssembleSchedulingList();
            if (this$assembleSchedulingList == null ? other$assembleSchedulingList == null : this$assembleSchedulingList.equals(other$assembleSchedulingList)) {
               Object this$surplusAssemble = this.getSurplusAssemble();
               Object other$surplusAssemble = other.getSurplusAssemble();
               return this$surplusAssemble == null ? other$surplusAssemble == null : this$surplusAssemble.equals(other$surplusAssemble);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactSchedulingAssembleAndTypesettingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $assembleSchedulingList = this.getAssembleSchedulingList();
      result = result * 59 + ($assembleSchedulingList == null ? 43 : $assembleSchedulingList.hashCode());
      Object $surplusAssemble = this.getSurplusAssemble();
      return result * 59 + ($surplusAssemble == null ? 43 : $surplusAssemble.hashCode());
   }

   public static class MesBuildingArtifactSchedulingAssembleAndTypesettingDTOBuilder {
      private List<MesBuildingArtifactSchedulingAssembleDTO> assembleSchedulingList;
      private List<MesBuildingArtifactSchedulingSurplusAssembleDTO> surplusAssemble;

      MesBuildingArtifactSchedulingAssembleAndTypesettingDTOBuilder() {
      }

      @JsonProperty("assembleSchedulingList")
      public MesBuildingArtifactSchedulingAssembleAndTypesettingDTO.MesBuildingArtifactSchedulingAssembleAndTypesettingDTOBuilder assembleSchedulingList(
         final List<MesBuildingArtifactSchedulingAssembleDTO> assembleSchedulingList
      ) {
         this.assembleSchedulingList = assembleSchedulingList;
         return this;
      }

      @JsonProperty("surplusAssemble")
      public MesBuildingArtifactSchedulingAssembleAndTypesettingDTO.MesBuildingArtifactSchedulingAssembleAndTypesettingDTOBuilder surplusAssemble(
         final List<MesBuildingArtifactSchedulingSurplusAssembleDTO> surplusAssemble
      ) {
         this.surplusAssemble = surplusAssemble;
         return this;
      }

      public MesBuildingArtifactSchedulingAssembleAndTypesettingDTO build() {
         return new MesBuildingArtifactSchedulingAssembleAndTypesettingDTO(this.assembleSchedulingList, this.surplusAssemble);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingAssembleAndTypesettingDTO.MesBuildingArtifactSchedulingAssembleAndTypesettingDTOBuilder(assembleSchedulingList="
            + this.assembleSchedulingList
            + ", surplusAssemble="
            + this.surplusAssemble
            + ")";
      }
   }
}
