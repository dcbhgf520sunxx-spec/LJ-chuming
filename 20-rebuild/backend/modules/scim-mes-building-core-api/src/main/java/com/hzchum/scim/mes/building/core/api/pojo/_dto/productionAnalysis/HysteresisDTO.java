package com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "HysteresisVORequest", description = "迟滞请求类")
public class HysteresisDTO {
   @ApiModelProperty(name = "artifactAssembleList", value = "构件或组立")
   @JsonProperty("artifactAssembleList")
   @JSONField(name = "artifactAssembleList")
   @JsonInclude(Include.NON_NULL)
   private List<ArtifactAssembleHysteresisDTO> artifactAssembleList;
   @ApiModelProperty(name = "enclosureList", value = "围护")
   @JsonProperty("enclosureList")
   @JSONField(name = "enclosureList")
   @JsonInclude(Include.NON_NULL)
   private List<EnclosureHysteresisDTO> enclosureList;

   public static HysteresisDTO.HysteresisDTOBuilder builder() {
      return new HysteresisDTO.HysteresisDTOBuilder();
   }

   public HysteresisDTO() {
   }

   public HysteresisDTO(final List<ArtifactAssembleHysteresisDTO> artifactAssembleList, final List<EnclosureHysteresisDTO> enclosureList) {
      this.artifactAssembleList = artifactAssembleList;
      this.enclosureList = enclosureList;
   }

   public List<ArtifactAssembleHysteresisDTO> getArtifactAssembleList() {
      return this.artifactAssembleList;
   }

   public List<EnclosureHysteresisDTO> getEnclosureList() {
      return this.enclosureList;
   }

   @JsonProperty("artifactAssembleList")
   public HysteresisDTO setArtifactAssembleList(final List<ArtifactAssembleHysteresisDTO> artifactAssembleList) {
      this.artifactAssembleList = artifactAssembleList;
      return this;
   }

   @JsonProperty("enclosureList")
   public HysteresisDTO setEnclosureList(final List<EnclosureHysteresisDTO> enclosureList) {
      this.enclosureList = enclosureList;
      return this;
   }

   @Override
   public String toString() {
      return "HysteresisDTO(artifactAssembleList=" + this.getArtifactAssembleList() + ", enclosureList=" + this.getEnclosureList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof HysteresisDTO)) {
         return false;
      } else {
         HysteresisDTO other = (HysteresisDTO)o;
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
      return other instanceof HysteresisDTO;
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

   public static class HysteresisDTOBuilder {
      private List<ArtifactAssembleHysteresisDTO> artifactAssembleList;
      private List<EnclosureHysteresisDTO> enclosureList;

      HysteresisDTOBuilder() {
      }

      @JsonProperty("artifactAssembleList")
      public HysteresisDTO.HysteresisDTOBuilder artifactAssembleList(final List<ArtifactAssembleHysteresisDTO> artifactAssembleList) {
         this.artifactAssembleList = artifactAssembleList;
         return this;
      }

      @JsonProperty("enclosureList")
      public HysteresisDTO.HysteresisDTOBuilder enclosureList(final List<EnclosureHysteresisDTO> enclosureList) {
         this.enclosureList = enclosureList;
         return this;
      }

      public HysteresisDTO build() {
         return new HysteresisDTO(this.artifactAssembleList, this.enclosureList);
      }

      @Override
      public String toString() {
         return "HysteresisDTO.HysteresisDTOBuilder(artifactAssembleList=" + this.artifactAssembleList + ", enclosureList=" + this.enclosureList + ")";
      }
   }
}
