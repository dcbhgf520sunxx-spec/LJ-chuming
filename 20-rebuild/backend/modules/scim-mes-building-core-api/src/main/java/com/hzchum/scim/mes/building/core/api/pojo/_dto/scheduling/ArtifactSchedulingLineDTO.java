package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "ArtifactSchedulingLineDTO", description = "清单排产产线dto")
public class ArtifactSchedulingLineDTO {
   private String groupLineName;

   public static ArtifactSchedulingLineDTO.ArtifactSchedulingLineDTOBuilder builder() {
      return new ArtifactSchedulingLineDTO.ArtifactSchedulingLineDTOBuilder();
   }

   public ArtifactSchedulingLineDTO() {
   }

   public ArtifactSchedulingLineDTO(final String groupLineName) {
      this.groupLineName = groupLineName;
   }

   public String getGroupLineName() {
      return this.groupLineName;
   }

   public ArtifactSchedulingLineDTO setGroupLineName(final String groupLineName) {
      this.groupLineName = groupLineName;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactSchedulingLineDTO(groupLineName=" + this.getGroupLineName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactSchedulingLineDTO)) {
         return false;
      }

      ArtifactSchedulingLineDTO other = (ArtifactSchedulingLineDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$groupLineName = this.getGroupLineName();
      Object other$groupLineName = other.getGroupLineName();
      return this$groupLineName == null ? other$groupLineName == null : this$groupLineName.equals(other$groupLineName);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactSchedulingLineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupLineName = this.getGroupLineName();
      return result * 59 + ($groupLineName == null ? 43 : $groupLineName.hashCode());
   }

   public static class ArtifactSchedulingLineDTOBuilder {
      private String groupLineName;

      ArtifactSchedulingLineDTOBuilder() {
      }

      public ArtifactSchedulingLineDTO.ArtifactSchedulingLineDTOBuilder groupLineName(final String groupLineName) {
         this.groupLineName = groupLineName;
         return this;
      }

      public ArtifactSchedulingLineDTO build() {
         return new ArtifactSchedulingLineDTO(this.groupLineName);
      }

      @Override
      public String toString() {
         return "ArtifactSchedulingLineDTO.ArtifactSchedulingLineDTOBuilder(groupLineName=" + this.groupLineName + ")";
      }
   }
}
