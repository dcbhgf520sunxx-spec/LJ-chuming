package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProjectToFreezeDTO {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("备料冻结数量")
   private BigDecimal quantity;
   @ApiModelProperty("备料冻结量")
   private BigDecimal mete;

   public static ProjectToFreezeDTO.ProjectToFreezeDTOBuilder builder() {
      return new ProjectToFreezeDTO.ProjectToFreezeDTOBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectToFreezeDTO)) {
         return false;
      }

      ProjectToFreezeDTO other = (ProjectToFreezeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectToFreezeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectToFreezeDTO(projectId=" + this.getProjectId() + ", quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ")";
   }

   public ProjectToFreezeDTO(final Long projectId, final BigDecimal quantity, final BigDecimal mete) {
      this.projectId = projectId;
      this.quantity = quantity;
      this.mete = mete;
   }

   public ProjectToFreezeDTO() {
   }

   public static class ProjectToFreezeDTOBuilder {
      private Long projectId;
      private BigDecimal quantity;
      private BigDecimal mete;

      ProjectToFreezeDTOBuilder() {
      }

      public ProjectToFreezeDTO.ProjectToFreezeDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectToFreezeDTO.ProjectToFreezeDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectToFreezeDTO.ProjectToFreezeDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectToFreezeDTO build() {
         return new ProjectToFreezeDTO(this.projectId, this.quantity, this.mete);
      }

      @Override
      public String toString() {
         return "ProjectToFreezeDTO.ProjectToFreezeDTOBuilder(projectId=" + this.projectId + ", quantity=" + this.quantity + ", mete=" + this.mete + ")";
      }
   }
}
