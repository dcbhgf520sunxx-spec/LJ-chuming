package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClass;
import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel("构件类别")
public class MesArtifactClassDTO {
   private List<MesArtifactClass> mesArtifactClassList;

   public static MesArtifactClassDTO.MesArtifactClassDTOBuilder builder() {
      return new MesArtifactClassDTO.MesArtifactClassDTOBuilder();
   }

   public MesArtifactClassDTO(final List<MesArtifactClass> mesArtifactClassList) {
      this.mesArtifactClassList = mesArtifactClassList;
   }

   public MesArtifactClassDTO() {
   }

   public List<MesArtifactClass> getMesArtifactClassList() {
      return this.mesArtifactClassList;
   }

   public MesArtifactClassDTO setMesArtifactClassList(final List<MesArtifactClass> mesArtifactClassList) {
      this.mesArtifactClassList = mesArtifactClassList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesArtifactClassDTO)) {
         return false;
      }

      MesArtifactClassDTO other = (MesArtifactClassDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$mesArtifactClassList = this.getMesArtifactClassList();
      Object other$mesArtifactClassList = other.getMesArtifactClassList();
      return this$mesArtifactClassList == null ? other$mesArtifactClassList == null : this$mesArtifactClassList.equals(other$mesArtifactClassList);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesArtifactClassDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mesArtifactClassList = this.getMesArtifactClassList();
      return result * 59 + ($mesArtifactClassList == null ? 43 : $mesArtifactClassList.hashCode());
   }

   @Override
   public String toString() {
      return "MesArtifactClassDTO(mesArtifactClassList=" + this.getMesArtifactClassList() + ")";
   }

   public static class MesArtifactClassDTOBuilder {
      private List<MesArtifactClass> mesArtifactClassList;

      MesArtifactClassDTOBuilder() {
      }

      public MesArtifactClassDTO.MesArtifactClassDTOBuilder mesArtifactClassList(final List<MesArtifactClass> mesArtifactClassList) {
         this.mesArtifactClassList = mesArtifactClassList;
         return this;
      }

      public MesArtifactClassDTO build() {
         return new MesArtifactClassDTO(this.mesArtifactClassList);
      }

      @Override
      public String toString() {
         return "MesArtifactClassDTO.MesArtifactClassDTOBuilder(mesArtifactClassList=" + this.mesArtifactClassList + ")";
      }
   }
}
