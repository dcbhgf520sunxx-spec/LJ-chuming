package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.util.List;

public class ProjectPickingListDTO {
   private List<ProjectPickingDTO> moveOutboundDetails;
   private List<ProjectPickingDTO> returnDetails;

   public static ProjectPickingListDTO.ProjectPickingListDTOBuilder builder() {
      return new ProjectPickingListDTO.ProjectPickingListDTOBuilder();
   }

   public List<ProjectPickingDTO> getMoveOutboundDetails() {
      return this.moveOutboundDetails;
   }

   public List<ProjectPickingDTO> getReturnDetails() {
      return this.returnDetails;
   }

   public void setMoveOutboundDetails(final List<ProjectPickingDTO> moveOutboundDetails) {
      this.moveOutboundDetails = moveOutboundDetails;
   }

   public void setReturnDetails(final List<ProjectPickingDTO> returnDetails) {
      this.returnDetails = returnDetails;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectPickingListDTO)) {
         return false;
      } else {
         ProjectPickingListDTO other = (ProjectPickingListDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$moveOutboundDetails = this.getMoveOutboundDetails();
            Object other$moveOutboundDetails = other.getMoveOutboundDetails();
            if (this$moveOutboundDetails == null ? other$moveOutboundDetails == null : this$moveOutboundDetails.equals(other$moveOutboundDetails)) {
               Object this$returnDetails = this.getReturnDetails();
               Object other$returnDetails = other.getReturnDetails();
               return this$returnDetails == null ? other$returnDetails == null : this$returnDetails.equals(other$returnDetails);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectPickingListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $moveOutboundDetails = this.getMoveOutboundDetails();
      result = result * 59 + ($moveOutboundDetails == null ? 43 : $moveOutboundDetails.hashCode());
      Object $returnDetails = this.getReturnDetails();
      return result * 59 + ($returnDetails == null ? 43 : $returnDetails.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPickingListDTO(moveOutboundDetails=" + this.getMoveOutboundDetails() + ", returnDetails=" + this.getReturnDetails() + ")";
   }

   public ProjectPickingListDTO(final List<ProjectPickingDTO> moveOutboundDetails, final List<ProjectPickingDTO> returnDetails) {
      this.moveOutboundDetails = moveOutboundDetails;
      this.returnDetails = returnDetails;
   }

   public ProjectPickingListDTO() {
   }

   public static class ProjectPickingListDTOBuilder {
      private List<ProjectPickingDTO> moveOutboundDetails;
      private List<ProjectPickingDTO> returnDetails;

      ProjectPickingListDTOBuilder() {
      }

      public ProjectPickingListDTO.ProjectPickingListDTOBuilder moveOutboundDetails(final List<ProjectPickingDTO> moveOutboundDetails) {
         this.moveOutboundDetails = moveOutboundDetails;
         return this;
      }

      public ProjectPickingListDTO.ProjectPickingListDTOBuilder returnDetails(final List<ProjectPickingDTO> returnDetails) {
         this.returnDetails = returnDetails;
         return this;
      }

      public ProjectPickingListDTO build() {
         return new ProjectPickingListDTO(this.moveOutboundDetails, this.returnDetails);
      }

      @Override
      public String toString() {
         return "ProjectPickingListDTO.ProjectPickingListDTOBuilder(moveOutboundDetails="
            + this.moveOutboundDetails
            + ", returnDetails="
            + this.returnDetails
            + ")";
      }
   }
}
