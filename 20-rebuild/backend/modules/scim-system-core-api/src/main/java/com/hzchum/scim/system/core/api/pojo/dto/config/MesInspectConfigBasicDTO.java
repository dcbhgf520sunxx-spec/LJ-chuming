package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;

public class MesInspectConfigBasicDTO {
   @ApiModelProperty(name = "质检id")
   private Long id;
   @ApiModelProperty(name = "工序Id")
   private Long processId;
   @ApiModelProperty(name = "班组Id")
   private Long teamId;
   @ApiModelProperty(name = "产品种类Id")
   private Long classificationId;

   public static MesInspectConfigBasicDTO.MesInspectConfigBasicDTOBuilder builder() {
      return new MesInspectConfigBasicDTO.MesInspectConfigBasicDTOBuilder();
   }

   public MesInspectConfigBasicDTO() {
   }

   public MesInspectConfigBasicDTO(final Long id, final Long processId, final Long teamId, final Long classificationId) {
      this.id = id;
      this.processId = processId;
      this.teamId = teamId;
      this.classificationId = classificationId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectConfigBasicDTO)) {
         return false;
      }

      MesInspectConfigBasicDTO other = (MesInspectConfigBasicDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$classificationId = this.getClassificationId();
               Object other$classificationId = other.getClassificationId();
               return this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId);
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
      return other instanceof MesInspectConfigBasicDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $classificationId = this.getClassificationId();
      return result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
   }

   @Override
   public String toString() {
      return "MesInspectConfigBasicDTO(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", classificationId="
         + this.getClassificationId()
         + ")";
   }

   public static class MesInspectConfigBasicDTOBuilder {
      private Long id;
      private Long processId;
      private Long teamId;
      private Long classificationId;

      MesInspectConfigBasicDTOBuilder() {
      }

      public MesInspectConfigBasicDTO.MesInspectConfigBasicDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectConfigBasicDTO.MesInspectConfigBasicDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesInspectConfigBasicDTO.MesInspectConfigBasicDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesInspectConfigBasicDTO.MesInspectConfigBasicDTOBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public MesInspectConfigBasicDTO build() {
         return new MesInspectConfigBasicDTO(this.id, this.processId, this.teamId, this.classificationId);
      }

      @Override
      public String toString() {
         return "MesInspectConfigBasicDTO.MesInspectConfigBasicDTOBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", teamId="
            + this.teamId
            + ", classificationId="
            + this.classificationId
            + ")";
      }
   }
}
