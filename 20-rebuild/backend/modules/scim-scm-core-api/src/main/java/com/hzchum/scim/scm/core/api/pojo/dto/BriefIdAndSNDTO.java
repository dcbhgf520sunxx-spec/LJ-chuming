package com.hzchum.scim.scm.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import java.math.BigDecimal;
import java.util.List;

public class BriefIdAndSNDTO {
   private Long id;
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private Long purchaseDetailId;
   @JsonInclude(Include.NON_NULL)
   private Integer purchaseCreationState;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal quantity;
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @JsonInclude(Include.NON_NULL)
   private List<ProjectInfo> projects;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inboundMete;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inboundQuantity;

   public static BriefIdAndSNDTO.BriefIdAndSNDTOBuilder builder() {
      return new BriefIdAndSNDTO.BriefIdAndSNDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getPurchaseDetailId() {
      return this.purchaseDetailId;
   }

   public Integer getPurchaseCreationState() {
      return this.purchaseCreationState;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getInboundQuantity() {
      return this.inboundQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPurchaseDetailId(final Long purchaseDetailId) {
      this.purchaseDetailId = purchaseDetailId;
   }

   public void setPurchaseCreationState(final Integer purchaseCreationState) {
      this.purchaseCreationState = purchaseCreationState;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setInboundQuantity(final BigDecimal inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BriefIdAndSNDTO)) {
         return false;
      }

      BriefIdAndSNDTO other = (BriefIdAndSNDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseDetailId = this.getPurchaseDetailId();
         Object other$purchaseDetailId = other.getPurchaseDetailId();
         if (this$purchaseDetailId == null ? other$purchaseDetailId == null : this$purchaseDetailId.equals(other$purchaseDetailId)) {
            Object this$purchaseCreationState = this.getPurchaseCreationState();
            Object other$purchaseCreationState = other.getPurchaseCreationState();
            if (this$purchaseCreationState == null ? other$purchaseCreationState == null : this$purchaseCreationState.equals(other$purchaseCreationState)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$projects = this.getProjects();
                           Object other$projects = other.getProjects();
                           if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                              Object this$inboundMete = this.getInboundMete();
                              Object other$inboundMete = other.getInboundMete();
                              if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                                 Object this$inboundQuantity = this.getInboundQuantity();
                                 Object other$inboundQuantity = other.getInboundQuantity();
                                 return this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity);
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
      return other instanceof BriefIdAndSNDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseDetailId = this.getPurchaseDetailId();
      result = result * 59 + ($purchaseDetailId == null ? 43 : $purchaseDetailId.hashCode());
      Object $purchaseCreationState = this.getPurchaseCreationState();
      result = result * 59 + ($purchaseCreationState == null ? 43 : $purchaseCreationState.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      return result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "BriefIdAndSNDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaseDetailId="
         + this.getPurchaseDetailId()
         + ", purchaseCreationState="
         + this.getPurchaseCreationState()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", project="
         + this.getProject()
         + ", projects="
         + this.getProjects()
         + ", inboundMete="
         + this.getInboundMete()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ")";
   }

   public BriefIdAndSNDTO(
      final Long id,
      final String serialNumber,
      final Long purchaseDetailId,
      final Integer purchaseCreationState,
      final BigDecimal mete,
      final BigDecimal quantity,
      final ProjectInfo project,
      final List<ProjectInfo> projects,
      final BigDecimal inboundMete,
      final BigDecimal inboundQuantity
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.purchaseDetailId = purchaseDetailId;
      this.purchaseCreationState = purchaseCreationState;
      this.mete = mete;
      this.quantity = quantity;
      this.project = project;
      this.projects = projects;
      this.inboundMete = inboundMete;
      this.inboundQuantity = inboundQuantity;
   }

   public BriefIdAndSNDTO() {
   }

   public static class BriefIdAndSNDTOBuilder {
      private Long id;
      private String serialNumber;
      private Long purchaseDetailId;
      private Integer purchaseCreationState;
      private BigDecimal mete;
      private BigDecimal quantity;
      private ProjectInfo project;
      private List<ProjectInfo> projects;
      private BigDecimal inboundMete;
      private BigDecimal inboundQuantity;

      BriefIdAndSNDTOBuilder() {
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder purchaseDetailId(final Long purchaseDetailId) {
         this.purchaseDetailId = purchaseDetailId;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder purchaseCreationState(final Integer purchaseCreationState) {
         this.purchaseCreationState = purchaseCreationState;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      public BriefIdAndSNDTO.BriefIdAndSNDTOBuilder inboundQuantity(final BigDecimal inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      public BriefIdAndSNDTO build() {
         return new BriefIdAndSNDTO(
            this.id,
            this.serialNumber,
            this.purchaseDetailId,
            this.purchaseCreationState,
            this.mete,
            this.quantity,
            this.project,
            this.projects,
            this.inboundMete,
            this.inboundQuantity
         );
      }

      @Override
      public String toString() {
         return "BriefIdAndSNDTO.BriefIdAndSNDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", purchaseDetailId="
            + this.purchaseDetailId
            + ", purchaseCreationState="
            + this.purchaseCreationState
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", project="
            + this.project
            + ", projects="
            + this.projects
            + ", inboundMete="
            + this.inboundMete
            + ", inboundQuantity="
            + this.inboundQuantity
            + ")";
      }
   }
}
