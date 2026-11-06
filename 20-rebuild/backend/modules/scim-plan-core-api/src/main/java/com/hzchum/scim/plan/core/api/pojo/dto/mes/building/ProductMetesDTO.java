package com.hzchum.scim.plan.core.api.pojo.dto.mes.building;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductMetesDTO", description = "产量汇总 ")
public class ProductMetesDTO {
   @ApiModelProperty(name = "artifactQuantity", notes = "构件数量")
   private Integer artifactQuantity;
   @ApiModelProperty(name = "artifactMete", notes = "构件总量")
   private BigDecimal artifactMete;
   @ApiModelProperty(name = "assembleQuantity", notes = "组立数量")
   private Integer assembleQuantity;
   @ApiModelProperty(name = "assembleMete", notes = "组立总量")
   private BigDecimal assembleMete;
   @ApiModelProperty(name = "machinePartQuantity", notes = "零件数量")
   private Integer machinePartQuantity;
   @ApiModelProperty(name = "machinePartMete", notes = "零件总量")
   private BigDecimal machinePartMete;

   public static ProductMetesDTO.ProductMetesDTOBuilder builder() {
      return new ProductMetesDTO.ProductMetesDTOBuilder();
   }

   public Integer getArtifactQuantity() {
      return this.artifactQuantity;
   }

   public BigDecimal getArtifactMete() {
      return this.artifactMete;
   }

   public Integer getAssembleQuantity() {
      return this.assembleQuantity;
   }

   public BigDecimal getAssembleMete() {
      return this.assembleMete;
   }

   public Integer getMachinePartQuantity() {
      return this.machinePartQuantity;
   }

   public BigDecimal getMachinePartMete() {
      return this.machinePartMete;
   }

   public void setArtifactQuantity(final Integer artifactQuantity) {
      this.artifactQuantity = artifactQuantity;
   }

   public void setArtifactMete(final BigDecimal artifactMete) {
      this.artifactMete = artifactMete;
   }

   public void setAssembleQuantity(final Integer assembleQuantity) {
      this.assembleQuantity = assembleQuantity;
   }

   public void setAssembleMete(final BigDecimal assembleMete) {
      this.assembleMete = assembleMete;
   }

   public void setMachinePartQuantity(final Integer machinePartQuantity) {
      this.machinePartQuantity = machinePartQuantity;
   }

   public void setMachinePartMete(final BigDecimal machinePartMete) {
      this.machinePartMete = machinePartMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductMetesDTO)) {
         return false;
      }

      ProductMetesDTO other = (ProductMetesDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactQuantity = this.getArtifactQuantity();
      Object other$artifactQuantity = other.getArtifactQuantity();
      if (this$artifactQuantity == null ? other$artifactQuantity == null : this$artifactQuantity.equals(other$artifactQuantity)) {
         Object this$assembleQuantity = this.getAssembleQuantity();
         Object other$assembleQuantity = other.getAssembleQuantity();
         if (this$assembleQuantity == null ? other$assembleQuantity == null : this$assembleQuantity.equals(other$assembleQuantity)) {
            Object this$machinePartQuantity = this.getMachinePartQuantity();
            Object other$machinePartQuantity = other.getMachinePartQuantity();
            if (this$machinePartQuantity == null ? other$machinePartQuantity == null : this$machinePartQuantity.equals(other$machinePartQuantity)) {
               Object this$artifactMete = this.getArtifactMete();
               Object other$artifactMete = other.getArtifactMete();
               if (this$artifactMete == null ? other$artifactMete == null : this$artifactMete.equals(other$artifactMete)) {
                  Object this$assembleMete = this.getAssembleMete();
                  Object other$assembleMete = other.getAssembleMete();
                  if (this$assembleMete == null ? other$assembleMete == null : this$assembleMete.equals(other$assembleMete)) {
                     Object this$machinePartMete = this.getMachinePartMete();
                     Object other$machinePartMete = other.getMachinePartMete();
                     return this$machinePartMete == null ? other$machinePartMete == null : this$machinePartMete.equals(other$machinePartMete);
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
      return other instanceof ProductMetesDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactQuantity = this.getArtifactQuantity();
      result = result * 59 + ($artifactQuantity == null ? 43 : $artifactQuantity.hashCode());
      Object $assembleQuantity = this.getAssembleQuantity();
      result = result * 59 + ($assembleQuantity == null ? 43 : $assembleQuantity.hashCode());
      Object $machinePartQuantity = this.getMachinePartQuantity();
      result = result * 59 + ($machinePartQuantity == null ? 43 : $machinePartQuantity.hashCode());
      Object $artifactMete = this.getArtifactMete();
      result = result * 59 + ($artifactMete == null ? 43 : $artifactMete.hashCode());
      Object $assembleMete = this.getAssembleMete();
      result = result * 59 + ($assembleMete == null ? 43 : $assembleMete.hashCode());
      Object $machinePartMete = this.getMachinePartMete();
      return result * 59 + ($machinePartMete == null ? 43 : $machinePartMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProductMetesDTO(artifactQuantity="
         + this.getArtifactQuantity()
         + ", artifactMete="
         + this.getArtifactMete()
         + ", assembleQuantity="
         + this.getAssembleQuantity()
         + ", assembleMete="
         + this.getAssembleMete()
         + ", machinePartQuantity="
         + this.getMachinePartQuantity()
         + ", machinePartMete="
         + this.getMachinePartMete()
         + ")";
   }

   public ProductMetesDTO() {
   }

   public ProductMetesDTO(
      final Integer artifactQuantity,
      final BigDecimal artifactMete,
      final Integer assembleQuantity,
      final BigDecimal assembleMete,
      final Integer machinePartQuantity,
      final BigDecimal machinePartMete
   ) {
      this.artifactQuantity = artifactQuantity;
      this.artifactMete = artifactMete;
      this.assembleQuantity = assembleQuantity;
      this.assembleMete = assembleMete;
      this.machinePartQuantity = machinePartQuantity;
      this.machinePartMete = machinePartMete;
   }

   public static class ProductMetesDTOBuilder {
      private Integer artifactQuantity;
      private BigDecimal artifactMete;
      private Integer assembleQuantity;
      private BigDecimal assembleMete;
      private Integer machinePartQuantity;
      private BigDecimal machinePartMete;

      ProductMetesDTOBuilder() {
      }

      public ProductMetesDTO.ProductMetesDTOBuilder artifactQuantity(final Integer artifactQuantity) {
         this.artifactQuantity = artifactQuantity;
         return this;
      }

      public ProductMetesDTO.ProductMetesDTOBuilder artifactMete(final BigDecimal artifactMete) {
         this.artifactMete = artifactMete;
         return this;
      }

      public ProductMetesDTO.ProductMetesDTOBuilder assembleQuantity(final Integer assembleQuantity) {
         this.assembleQuantity = assembleQuantity;
         return this;
      }

      public ProductMetesDTO.ProductMetesDTOBuilder assembleMete(final BigDecimal assembleMete) {
         this.assembleMete = assembleMete;
         return this;
      }

      public ProductMetesDTO.ProductMetesDTOBuilder machinePartQuantity(final Integer machinePartQuantity) {
         this.machinePartQuantity = machinePartQuantity;
         return this;
      }

      public ProductMetesDTO.ProductMetesDTOBuilder machinePartMete(final BigDecimal machinePartMete) {
         this.machinePartMete = machinePartMete;
         return this;
      }

      public ProductMetesDTO build() {
         return new ProductMetesDTO(
            this.artifactQuantity, this.artifactMete, this.assembleQuantity, this.assembleMete, this.machinePartQuantity, this.machinePartMete
         );
      }

      @Override
      public String toString() {
         return "ProductMetesDTO.ProductMetesDTOBuilder(artifactQuantity="
            + this.artifactQuantity
            + ", artifactMete="
            + this.artifactMete
            + ", assembleQuantity="
            + this.assembleQuantity
            + ", assembleMete="
            + this.assembleMete
            + ", machinePartQuantity="
            + this.machinePartQuantity
            + ", machinePartMete="
            + this.machinePartMete
            + ")";
      }
   }
}
