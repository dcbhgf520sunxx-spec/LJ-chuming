package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingNumberLinkDTO", description = "绑码数据")
public class MesBuildingNumberLinkDTO {
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   private Long artifactId;
   @ApiModelProperty(name = "artSerialNumber", value = "构件编号", notes = "构件编号")
   private String artSerialNumber;
   @ApiModelProperty(name = "artNumber", value = "构件一物一码号", notes = "构件一物一码号")
   private Integer artNumber;
   @ApiModelProperty(name = "assembleId", value = "部件id", notes = "部件id")
   private Long assembleId;
   @ApiModelProperty(name = "assSerialNumber", value = "部件编号", notes = "部件编号")
   private String assSerialNumber;
   @ApiModelProperty(name = "assNumber", value = "部件一物一码号", notes = "部件一物一码号")
   private Integer assNumber;
   @ApiModelProperty(name = "processName", value = "部件工序情况", notes = "部件工序情况")
   private String processName;

   public static MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder builder() {
      return new MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder();
   }

   public MesBuildingNumberLinkDTO() {
   }

   public MesBuildingNumberLinkDTO(
      final Long artifactId,
      final String artSerialNumber,
      final Integer artNumber,
      final Long assembleId,
      final String assSerialNumber,
      final Integer assNumber,
      final String processName
   ) {
      this.artifactId = artifactId;
      this.artSerialNumber = artSerialNumber;
      this.artNumber = artNumber;
      this.assembleId = assembleId;
      this.assSerialNumber = assSerialNumber;
      this.assNumber = assNumber;
      this.processName = processName;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getArtSerialNumber() {
      return this.artSerialNumber;
   }

   public Integer getArtNumber() {
      return this.artNumber;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public String getAssSerialNumber() {
      return this.assSerialNumber;
   }

   public Integer getAssNumber() {
      return this.assNumber;
   }

   public String getProcessName() {
      return this.processName;
   }

   public MesBuildingNumberLinkDTO setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public MesBuildingNumberLinkDTO setArtSerialNumber(final String artSerialNumber) {
      this.artSerialNumber = artSerialNumber;
      return this;
   }

   public MesBuildingNumberLinkDTO setArtNumber(final Integer artNumber) {
      this.artNumber = artNumber;
      return this;
   }

   public MesBuildingNumberLinkDTO setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   public MesBuildingNumberLinkDTO setAssSerialNumber(final String assSerialNumber) {
      this.assSerialNumber = assSerialNumber;
      return this;
   }

   public MesBuildingNumberLinkDTO setAssNumber(final Integer assNumber) {
      this.assNumber = assNumber;
      return this;
   }

   public MesBuildingNumberLinkDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNumberLinkDTO(artifactId="
         + this.getArtifactId()
         + ", artSerialNumber="
         + this.getArtSerialNumber()
         + ", artNumber="
         + this.getArtNumber()
         + ", assembleId="
         + this.getAssembleId()
         + ", assSerialNumber="
         + this.getAssSerialNumber()
         + ", assNumber="
         + this.getAssNumber()
         + ", processName="
         + this.getProcessName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNumberLinkDTO)) {
         return false;
      }

      MesBuildingNumberLinkDTO other = (MesBuildingNumberLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$artNumber = this.getArtNumber();
         Object other$artNumber = other.getArtNumber();
         if (this$artNumber == null ? other$artNumber == null : this$artNumber.equals(other$artNumber)) {
            Object this$assembleId = this.getAssembleId();
            Object other$assembleId = other.getAssembleId();
            if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
               Object this$assNumber = this.getAssNumber();
               Object other$assNumber = other.getAssNumber();
               if (this$assNumber == null ? other$assNumber == null : this$assNumber.equals(other$assNumber)) {
                  Object this$artSerialNumber = this.getArtSerialNumber();
                  Object other$artSerialNumber = other.getArtSerialNumber();
                  if (this$artSerialNumber == null ? other$artSerialNumber == null : this$artSerialNumber.equals(other$artSerialNumber)) {
                     Object this$assSerialNumber = this.getAssSerialNumber();
                     Object other$assSerialNumber = other.getAssSerialNumber();
                     if (this$assSerialNumber == null ? other$assSerialNumber == null : this$assSerialNumber.equals(other$assSerialNumber)) {
                        Object this$processName = this.getProcessName();
                        Object other$processName = other.getProcessName();
                        return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingNumberLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $artNumber = this.getArtNumber();
      result = result * 59 + ($artNumber == null ? 43 : $artNumber.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $assNumber = this.getAssNumber();
      result = result * 59 + ($assNumber == null ? 43 : $assNumber.hashCode());
      Object $artSerialNumber = this.getArtSerialNumber();
      result = result * 59 + ($artSerialNumber == null ? 43 : $artSerialNumber.hashCode());
      Object $assSerialNumber = this.getAssSerialNumber();
      result = result * 59 + ($assSerialNumber == null ? 43 : $assSerialNumber.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   public static class MesBuildingNumberLinkDTOBuilder {
      private Long artifactId;
      private String artSerialNumber;
      private Integer artNumber;
      private Long assembleId;
      private String assSerialNumber;
      private Integer assNumber;
      private String processName;

      MesBuildingNumberLinkDTOBuilder() {
      }

      public MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder artSerialNumber(final String artSerialNumber) {
         this.artSerialNumber = artSerialNumber;
         return this;
      }

      public MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder artNumber(final Integer artNumber) {
         this.artNumber = artNumber;
         return this;
      }

      public MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      public MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder assSerialNumber(final String assSerialNumber) {
         this.assSerialNumber = assSerialNumber;
         return this;
      }

      public MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder assNumber(final Integer assNumber) {
         this.assNumber = assNumber;
         return this;
      }

      public MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public MesBuildingNumberLinkDTO build() {
         return new MesBuildingNumberLinkDTO(
            this.artifactId, this.artSerialNumber, this.artNumber, this.assembleId, this.assSerialNumber, this.assNumber, this.processName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNumberLinkDTO.MesBuildingNumberLinkDTOBuilder(artifactId="
            + this.artifactId
            + ", artSerialNumber="
            + this.artSerialNumber
            + ", artNumber="
            + this.artNumber
            + ", assembleId="
            + this.assembleId
            + ", assSerialNumber="
            + this.assSerialNumber
            + ", assNumber="
            + this.assNumber
            + ", processName="
            + this.processName
            + ")";
      }
   }
}
