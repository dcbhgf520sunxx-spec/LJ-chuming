package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;

public class OutboundDetailBasicDTO {
   private Long projectId;
   private BigDecimal mete;

   public static OutboundDetailBasicDTO.OutboundDetailBasicDTOBuilder builder() {
      return new OutboundDetailBasicDTO.OutboundDetailBasicDTOBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OutboundDetailBasicDTO)) {
         return false;
      } else {
         OutboundDetailBasicDTO other = (OutboundDetailBasicDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OutboundDetailBasicDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDetailBasicDTO(projectId=" + this.getProjectId() + ", mete=" + this.getMete() + ")";
   }

   public OutboundDetailBasicDTO(final Long projectId, final BigDecimal mete) {
      this.projectId = projectId;
      this.mete = mete;
   }

   public OutboundDetailBasicDTO() {
   }

   public static class OutboundDetailBasicDTOBuilder {
      private Long projectId;
      private BigDecimal mete;

      OutboundDetailBasicDTOBuilder() {
      }

      public OutboundDetailBasicDTO.OutboundDetailBasicDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public OutboundDetailBasicDTO.OutboundDetailBasicDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public OutboundDetailBasicDTO build() {
         return new OutboundDetailBasicDTO(this.projectId, this.mete);
      }

      @Override
      public String toString() {
         return "OutboundDetailBasicDTO.OutboundDetailBasicDTOBuilder(projectId=" + this.projectId + ", mete=" + this.mete + ")";
      }
   }
}
