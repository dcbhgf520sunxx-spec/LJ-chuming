package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.scim.system.core.api.pojo._do.MesProcessConversionRate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("工序折合完工率")
public class MesProcessConversionRateDTO {
   @ApiModelProperty(name = "artifactClassId", value = "构件类别Id", notes = "构件类别Id")
   @NotNull(message = "构件类别Id不可为空")
   private Long artifactClassId;
   @ApiModelProperty(name = "mesProcessConversionRateList", value = "工序折合完工率列表", notes = "工序折合完工率列表")
   private List<MesProcessConversionRate> mesProcessConversionRateList;

   public static MesProcessConversionRateDTO.MesProcessConversionRateDTOBuilder builder() {
      return new MesProcessConversionRateDTO.MesProcessConversionRateDTOBuilder();
   }

   public MesProcessConversionRateDTO(final Long artifactClassId, final List<MesProcessConversionRate> mesProcessConversionRateList) {
      this.artifactClassId = artifactClassId;
      this.mesProcessConversionRateList = mesProcessConversionRateList;
   }

   public MesProcessConversionRateDTO() {
   }

   public Long getArtifactClassId() {
      return this.artifactClassId;
   }

   public List<MesProcessConversionRate> getMesProcessConversionRateList() {
      return this.mesProcessConversionRateList;
   }

   public MesProcessConversionRateDTO setArtifactClassId(final Long artifactClassId) {
      this.artifactClassId = artifactClassId;
      return this;
   }

   public MesProcessConversionRateDTO setMesProcessConversionRateList(final List<MesProcessConversionRate> mesProcessConversionRateList) {
      this.mesProcessConversionRateList = mesProcessConversionRateList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesProcessConversionRateDTO)) {
         return false;
      } else {
         MesProcessConversionRateDTO other = (MesProcessConversionRateDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactClassId = this.getArtifactClassId();
            Object other$artifactClassId = other.getArtifactClassId();
            if (this$artifactClassId == null ? other$artifactClassId == null : this$artifactClassId.equals(other$artifactClassId)) {
               Object this$mesProcessConversionRateList = this.getMesProcessConversionRateList();
               Object other$mesProcessConversionRateList = other.getMesProcessConversionRateList();
               return this$mesProcessConversionRateList == null
                  ? other$mesProcessConversionRateList == null
                  : this$mesProcessConversionRateList.equals(other$mesProcessConversionRateList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesProcessConversionRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactClassId = this.getArtifactClassId();
      result = result * 59 + ($artifactClassId == null ? 43 : $artifactClassId.hashCode());
      Object $mesProcessConversionRateList = this.getMesProcessConversionRateList();
      return result * 59 + ($mesProcessConversionRateList == null ? 43 : $mesProcessConversionRateList.hashCode());
   }

   @Override
   public String toString() {
      return "MesProcessConversionRateDTO(artifactClassId="
         + this.getArtifactClassId()
         + ", mesProcessConversionRateList="
         + this.getMesProcessConversionRateList()
         + ")";
   }

   public static class MesProcessConversionRateDTOBuilder {
      private Long artifactClassId;
      private List<MesProcessConversionRate> mesProcessConversionRateList;

      MesProcessConversionRateDTOBuilder() {
      }

      public MesProcessConversionRateDTO.MesProcessConversionRateDTOBuilder artifactClassId(final Long artifactClassId) {
         this.artifactClassId = artifactClassId;
         return this;
      }

      public MesProcessConversionRateDTO.MesProcessConversionRateDTOBuilder mesProcessConversionRateList(
         final List<MesProcessConversionRate> mesProcessConversionRateList
      ) {
         this.mesProcessConversionRateList = mesProcessConversionRateList;
         return this;
      }

      public MesProcessConversionRateDTO build() {
         return new MesProcessConversionRateDTO(this.artifactClassId, this.mesProcessConversionRateList);
      }

      @Override
      public String toString() {
         return "MesProcessConversionRateDTO.MesProcessConversionRateDTOBuilder(artifactClassId="
            + this.artifactClassId
            + ", mesProcessConversionRateList="
            + this.mesProcessConversionRateList
            + ")";
      }
   }
}
