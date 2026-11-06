package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModelProperty;

public class MesBuildingAssembleExtTaskCargoDTO {
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   private Long artifactId;
   @ApiModelProperty(name = "artifactNumber", value = "构件一物一码号", notes = "构件一物一码号")
   private Integer artifactNumber;
   @ApiModelProperty(name = "assembleId", value = "部件id", notes = "部件id")
   private Long assembleId;
   @ApiModelProperty(name = "assembleNumber", value = "部件一物一码号", notes = "部件一物一码号")
   private Integer assembleNumber;
   @ApiModelProperty(name = "部件码号入库状态", value = "入库状态", notes = "入库状态")
   private Integer status;

   public static MesBuildingAssembleExtTaskCargoDTO.MesBuildingAssembleExtTaskCargoDTOBuilder builder() {
      return new MesBuildingAssembleExtTaskCargoDTO.MesBuildingAssembleExtTaskCargoDTOBuilder();
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getArtifactNumber() {
      return this.artifactNumber;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public Integer getAssembleNumber() {
      return this.assembleNumber;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setArtifactNumber(final Integer artifactNumber) {
      this.artifactNumber = artifactNumber;
   }

   public void setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
   }

   public void setAssembleNumber(final Integer assembleNumber) {
      this.assembleNumber = assembleNumber;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleExtTaskCargoDTO)) {
         return false;
      }

      MesBuildingAssembleExtTaskCargoDTO other = (MesBuildingAssembleExtTaskCargoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$artifactNumber = this.getArtifactNumber();
         Object other$artifactNumber = other.getArtifactNumber();
         if (this$artifactNumber == null ? other$artifactNumber == null : this$artifactNumber.equals(other$artifactNumber)) {
            Object this$assembleId = this.getAssembleId();
            Object other$assembleId = other.getAssembleId();
            if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
               Object this$assembleNumber = this.getAssembleNumber();
               Object other$assembleNumber = other.getAssembleNumber();
               if (this$assembleNumber == null ? other$assembleNumber == null : this$assembleNumber.equals(other$assembleNumber)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  return this$status == null ? other$status == null : this$status.equals(other$status);
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
      return other instanceof MesBuildingAssembleExtTaskCargoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $artifactNumber = this.getArtifactNumber();
      result = result * 59 + ($artifactNumber == null ? 43 : $artifactNumber.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $assembleNumber = this.getAssembleNumber();
      result = result * 59 + ($assembleNumber == null ? 43 : $assembleNumber.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleExtTaskCargoDTO(artifactId="
         + this.getArtifactId()
         + ", artifactNumber="
         + this.getArtifactNumber()
         + ", assembleId="
         + this.getAssembleId()
         + ", assembleNumber="
         + this.getAssembleNumber()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public MesBuildingAssembleExtTaskCargoDTO(
      final Long artifactId, final Integer artifactNumber, final Long assembleId, final Integer assembleNumber, final Integer status
   ) {
      this.artifactId = artifactId;
      this.artifactNumber = artifactNumber;
      this.assembleId = assembleId;
      this.assembleNumber = assembleNumber;
      this.status = status;
   }

   public MesBuildingAssembleExtTaskCargoDTO() {
   }

   public static class MesBuildingAssembleExtTaskCargoDTOBuilder {
      private Long artifactId;
      private Integer artifactNumber;
      private Long assembleId;
      private Integer assembleNumber;
      private Integer status;

      MesBuildingAssembleExtTaskCargoDTOBuilder() {
      }

      public MesBuildingAssembleExtTaskCargoDTO.MesBuildingAssembleExtTaskCargoDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public MesBuildingAssembleExtTaskCargoDTO.MesBuildingAssembleExtTaskCargoDTOBuilder artifactNumber(final Integer artifactNumber) {
         this.artifactNumber = artifactNumber;
         return this;
      }

      public MesBuildingAssembleExtTaskCargoDTO.MesBuildingAssembleExtTaskCargoDTOBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      public MesBuildingAssembleExtTaskCargoDTO.MesBuildingAssembleExtTaskCargoDTOBuilder assembleNumber(final Integer assembleNumber) {
         this.assembleNumber = assembleNumber;
         return this;
      }

      public MesBuildingAssembleExtTaskCargoDTO.MesBuildingAssembleExtTaskCargoDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public MesBuildingAssembleExtTaskCargoDTO build() {
         return new MesBuildingAssembleExtTaskCargoDTO(this.artifactId, this.artifactNumber, this.assembleId, this.assembleNumber, this.status);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleExtTaskCargoDTO.MesBuildingAssembleExtTaskCargoDTOBuilder(artifactId="
            + this.artifactId
            + ", artifactNumber="
            + this.artifactNumber
            + ", assembleId="
            + this.assembleId
            + ", assembleNumber="
            + this.assembleNumber
            + ", status="
            + this.status
            + ")";
      }
   }
}
