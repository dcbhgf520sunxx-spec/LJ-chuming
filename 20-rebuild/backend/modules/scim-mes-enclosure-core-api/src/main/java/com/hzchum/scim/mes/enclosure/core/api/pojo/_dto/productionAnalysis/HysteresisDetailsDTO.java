package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "HysteresisVORequest", description = "迟滞请求类")
public class HysteresisDetailsDTO {
   @ApiModelProperty(name = "artifactAssembleList", value = "构件或组立")
   @JsonProperty("artifactAssembleList")
   @JSONField(name = "artifactAssembleList")
   @JsonInclude(Include.NON_NULL)
   private List<ArtifactAssembleHysteresisDetailsDTO> artifactAssembleList;
   @ApiModelProperty(name = "enclosureList", value = "围护")
   @JsonProperty("enclosureList")
   @JSONField(name = "enclosureList")
   @JsonInclude(Include.NON_NULL)
   private List<EnclosureHysteresisDetailsDTO> enclosureList;

   public static HysteresisDetailsDTO.HysteresisDetailsDTOBuilder builder() {
      return new HysteresisDetailsDTO.HysteresisDetailsDTOBuilder();
   }

   public HysteresisDetailsDTO() {
   }

   public HysteresisDetailsDTO(final List<ArtifactAssembleHysteresisDetailsDTO> artifactAssembleList, final List<EnclosureHysteresisDetailsDTO> enclosureList) {
      this.artifactAssembleList = artifactAssembleList;
      this.enclosureList = enclosureList;
   }

   public List<ArtifactAssembleHysteresisDetailsDTO> getArtifactAssembleList() {
      return this.artifactAssembleList;
   }

   public List<EnclosureHysteresisDetailsDTO> getEnclosureList() {
      return this.enclosureList;
   }

   @JsonProperty("artifactAssembleList")
   public HysteresisDetailsDTO setArtifactAssembleList(final List<ArtifactAssembleHysteresisDetailsDTO> artifactAssembleList) {
      this.artifactAssembleList = artifactAssembleList;
      return this;
   }

   @JsonProperty("enclosureList")
   public HysteresisDetailsDTO setEnclosureList(final List<EnclosureHysteresisDetailsDTO> enclosureList) {
      this.enclosureList = enclosureList;
      return this;
   }

   @Override
   public String toString() {
      return "HysteresisDetailsDTO(artifactAssembleList=" + this.getArtifactAssembleList() + ", enclosureList=" + this.getEnclosureList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof HysteresisDetailsDTO)) {
         return false;
      } else {
         HysteresisDetailsDTO other = (HysteresisDetailsDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactAssembleList = this.getArtifactAssembleList();
            Object other$artifactAssembleList = other.getArtifactAssembleList();
            if (this$artifactAssembleList == null ? other$artifactAssembleList == null : this$artifactAssembleList.equals(other$artifactAssembleList)) {
               Object this$enclosureList = this.getEnclosureList();
               Object other$enclosureList = other.getEnclosureList();
               return this$enclosureList == null ? other$enclosureList == null : this$enclosureList.equals(other$enclosureList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof HysteresisDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactAssembleList = this.getArtifactAssembleList();
      result = result * 59 + ($artifactAssembleList == null ? 43 : $artifactAssembleList.hashCode());
      Object $enclosureList = this.getEnclosureList();
      return result * 59 + ($enclosureList == null ? 43 : $enclosureList.hashCode());
   }

   public static class HysteresisDetailsDTOBuilder {
      private List<ArtifactAssembleHysteresisDetailsDTO> artifactAssembleList;
      private List<EnclosureHysteresisDetailsDTO> enclosureList;

      HysteresisDetailsDTOBuilder() {
      }

      @JsonProperty("artifactAssembleList")
      public HysteresisDetailsDTO.HysteresisDetailsDTOBuilder artifactAssembleList(final List<ArtifactAssembleHysteresisDetailsDTO> artifactAssembleList) {
         this.artifactAssembleList = artifactAssembleList;
         return this;
      }

      @JsonProperty("enclosureList")
      public HysteresisDetailsDTO.HysteresisDetailsDTOBuilder enclosureList(final List<EnclosureHysteresisDetailsDTO> enclosureList) {
         this.enclosureList = enclosureList;
         return this;
      }

      public HysteresisDetailsDTO build() {
         return new HysteresisDetailsDTO(this.artifactAssembleList, this.enclosureList);
      }

      @Override
      public String toString() {
         return "HysteresisDetailsDTO.HysteresisDetailsDTOBuilder(artifactAssembleList="
            + this.artifactAssembleList
            + ", enclosureList="
            + this.enclosureList
            + ")";
      }
   }
}
