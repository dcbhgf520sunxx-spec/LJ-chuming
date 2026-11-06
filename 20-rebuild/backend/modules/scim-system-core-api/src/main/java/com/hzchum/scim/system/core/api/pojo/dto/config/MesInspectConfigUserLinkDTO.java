package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;

public class MesInspectConfigUserLinkDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "inspectConfigId", value = "质检配置id", notes = "质检配置id")
   private Long inspectConfigId;
   @ApiModelProperty(name = "teamId", value = "质检人id", notes = "质检人id")
   private Long inspectUserId;
   @ApiModelProperty(name = "teamLeaderName", value = "质检人用户", notes = "质检人用户")
   private String inspectUserName;

   public static MesInspectConfigUserLinkDTO.MesInspectConfigUserLinkDTOBuilder builder() {
      return new MesInspectConfigUserLinkDTO.MesInspectConfigUserLinkDTOBuilder();
   }

   public MesInspectConfigUserLinkDTO() {
   }

   public MesInspectConfigUserLinkDTO(final Long id, final Long inspectConfigId, final Long inspectUserId, final String inspectUserName) {
      this.id = id;
      this.inspectConfigId = inspectConfigId;
      this.inspectUserId = inspectUserId;
      this.inspectUserName = inspectUserName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInspectConfigId() {
      return this.inspectConfigId;
   }

   public Long getInspectUserId() {
      return this.inspectUserId;
   }

   public String getInspectUserName() {
      return this.inspectUserName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInspectConfigId(final Long inspectConfigId) {
      this.inspectConfigId = inspectConfigId;
   }

   public void setInspectUserId(final Long inspectUserId) {
      this.inspectUserId = inspectUserId;
   }

   public void setInspectUserName(final String inspectUserName) {
      this.inspectUserName = inspectUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectConfigUserLinkDTO)) {
         return false;
      }

      MesInspectConfigUserLinkDTO other = (MesInspectConfigUserLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inspectConfigId = this.getInspectConfigId();
         Object other$inspectConfigId = other.getInspectConfigId();
         if (this$inspectConfigId == null ? other$inspectConfigId == null : this$inspectConfigId.equals(other$inspectConfigId)) {
            Object this$inspectUserId = this.getInspectUserId();
            Object other$inspectUserId = other.getInspectUserId();
            if (this$inspectUserId == null ? other$inspectUserId == null : this$inspectUserId.equals(other$inspectUserId)) {
               Object this$inspectUserName = this.getInspectUserName();
               Object other$inspectUserName = other.getInspectUserName();
               return this$inspectUserName == null ? other$inspectUserName == null : this$inspectUserName.equals(other$inspectUserName);
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
      return other instanceof MesInspectConfigUserLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inspectConfigId = this.getInspectConfigId();
      result = result * 59 + ($inspectConfigId == null ? 43 : $inspectConfigId.hashCode());
      Object $inspectUserId = this.getInspectUserId();
      result = result * 59 + ($inspectUserId == null ? 43 : $inspectUserId.hashCode());
      Object $inspectUserName = this.getInspectUserName();
      return result * 59 + ($inspectUserName == null ? 43 : $inspectUserName.hashCode());
   }

   @Override
   public String toString() {
      return "MesInspectConfigUserLinkDTO(id="
         + this.getId()
         + ", inspectConfigId="
         + this.getInspectConfigId()
         + ", inspectUserId="
         + this.getInspectUserId()
         + ", inspectUserName="
         + this.getInspectUserName()
         + ")";
   }

   public static class MesInspectConfigUserLinkDTOBuilder {
      private Long id;
      private Long inspectConfigId;
      private Long inspectUserId;
      private String inspectUserName;

      MesInspectConfigUserLinkDTOBuilder() {
      }

      public MesInspectConfigUserLinkDTO.MesInspectConfigUserLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectConfigUserLinkDTO.MesInspectConfigUserLinkDTOBuilder inspectConfigId(final Long inspectConfigId) {
         this.inspectConfigId = inspectConfigId;
         return this;
      }

      public MesInspectConfigUserLinkDTO.MesInspectConfigUserLinkDTOBuilder inspectUserId(final Long inspectUserId) {
         this.inspectUserId = inspectUserId;
         return this;
      }

      public MesInspectConfigUserLinkDTO.MesInspectConfigUserLinkDTOBuilder inspectUserName(final String inspectUserName) {
         this.inspectUserName = inspectUserName;
         return this;
      }

      public MesInspectConfigUserLinkDTO build() {
         return new MesInspectConfigUserLinkDTO(this.id, this.inspectConfigId, this.inspectUserId, this.inspectUserName);
      }

      @Override
      public String toString() {
         return "MesInspectConfigUserLinkDTO.MesInspectConfigUserLinkDTOBuilder(id="
            + this.id
            + ", inspectConfigId="
            + this.inspectConfigId
            + ", inspectUserId="
            + this.inspectUserId
            + ", inspectUserName="
            + this.inspectUserName
            + ")";
      }
   }
}
