package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;

public class MesPartProcessConfigLinkDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", value = "关联工序id", notes = "关联工序id")
   private Long processId;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;

   public static MesPartProcessConfigLinkDTO.MesPartProcessConfigLinkDTOBuilder builder() {
      return new MesPartProcessConfigLinkDTO.MesPartProcessConfigLinkDTOBuilder();
   }

   public MesPartProcessConfigLinkDTO() {
   }

   public MesPartProcessConfigLinkDTO(final Long id, final Long processId, final String processName) {
      this.id = id;
      this.processId = processId;
      this.processName = processName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPartProcessConfigLinkDTO)) {
         return false;
      }

      MesPartProcessConfigLinkDTO other = (MesPartProcessConfigLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesPartProcessConfigLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   @Override
   public String toString() {
      return "MesPartProcessConfigLinkDTO(id=" + this.getId() + ", processId=" + this.getProcessId() + ", processName=" + this.getProcessName() + ")";
   }

   public static class MesPartProcessConfigLinkDTOBuilder {
      private Long id;
      private Long processId;
      private String processName;

      MesPartProcessConfigLinkDTOBuilder() {
      }

      public MesPartProcessConfigLinkDTO.MesPartProcessConfigLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPartProcessConfigLinkDTO.MesPartProcessConfigLinkDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesPartProcessConfigLinkDTO.MesPartProcessConfigLinkDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public MesPartProcessConfigLinkDTO build() {
         return new MesPartProcessConfigLinkDTO(this.id, this.processId, this.processName);
      }

      @Override
      public String toString() {
         return "MesPartProcessConfigLinkDTO.MesPartProcessConfigLinkDTOBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ")";
      }
   }
}
