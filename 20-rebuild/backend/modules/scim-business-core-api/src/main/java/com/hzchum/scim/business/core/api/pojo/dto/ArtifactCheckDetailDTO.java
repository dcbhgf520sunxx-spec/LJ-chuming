package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import java.math.BigDecimal;

public class ArtifactCheckDetailDTO {
   private Long id;
   private ProjectInfo project;
   private String name;
   private String material;
   private BigDecimal oldUnitPrice;
   private BigDecimal newUnitPrice;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getOldUnitPrice() {
      return this.oldUnitPrice;
   }

   public BigDecimal getNewUnitPrice() {
      return this.newUnitPrice;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setOldUnitPrice(final BigDecimal oldUnitPrice) {
      this.oldUnitPrice = oldUnitPrice;
   }

   public void setNewUnitPrice(final BigDecimal newUnitPrice) {
      this.newUnitPrice = newUnitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactCheckDetailDTO)) {
         return false;
      }

      ArtifactCheckDetailDTO other = (ArtifactCheckDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                  Object this$oldUnitPrice = this.getOldUnitPrice();
                  Object other$oldUnitPrice = other.getOldUnitPrice();
                  if (this$oldUnitPrice == null ? other$oldUnitPrice == null : this$oldUnitPrice.equals(other$oldUnitPrice)) {
                     Object this$newUnitPrice = this.getNewUnitPrice();
                     Object other$newUnitPrice = other.getNewUnitPrice();
                     return this$newUnitPrice == null ? other$newUnitPrice == null : this$newUnitPrice.equals(other$newUnitPrice);
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
      return other instanceof ArtifactCheckDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $oldUnitPrice = this.getOldUnitPrice();
      result = result * 59 + ($oldUnitPrice == null ? 43 : $oldUnitPrice.hashCode());
      Object $newUnitPrice = this.getNewUnitPrice();
      return result * 59 + ($newUnitPrice == null ? 43 : $newUnitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactCheckDetailDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", oldUnitPrice="
         + this.getOldUnitPrice()
         + ", newUnitPrice="
         + this.getNewUnitPrice()
         + ")";
   }
}
