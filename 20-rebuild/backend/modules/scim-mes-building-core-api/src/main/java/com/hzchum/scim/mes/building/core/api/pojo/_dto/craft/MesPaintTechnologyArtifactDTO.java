package com.hzchum.scim.mes.building.core.api.pojo._dto.craft;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class MesPaintTechnologyArtifactDTO {
   @ApiModelProperty(name = "artifactId", value = "构件ID")
   private Long artifactId;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(㎡)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "总面积(㎡)")
   private BigDecimal totalArea;

   public static MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder builder() {
      return new MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder();
   }

   public MesPaintTechnologyArtifactDTO(
      final Long artifactId,
      final NameInfo monomer,
      final NameInfo area,
      final String name,
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final BigDecimal surfaceArea,
      final BigDecimal totalArea
   ) {
      this.artifactId = artifactId;
      this.monomer = monomer;
      this.area = area;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.surfaceArea = surfaceArea;
      this.totalArea = totalArea;
   }

   public MesPaintTechnologyArtifactDTO() {
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintTechnologyArtifactDTO)) {
         return false;
      }

      MesPaintTechnologyArtifactDTO other = (MesPaintTechnologyArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$monomer = this.getMonomer();
            Object other$monomer = other.getMonomer();
            if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
               Object this$area = this.getArea();
               Object other$area = other.getArea();
               if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$surfaceArea = this.getSurfaceArea();
                           Object other$surfaceArea = other.getSurfaceArea();
                           if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                              Object this$totalArea = this.getTotalArea();
                              Object other$totalArea = other.getTotalArea();
                              return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
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
      return other instanceof MesPaintTechnologyArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintTechnologyArtifactDTO(artifactId="
         + this.getArtifactId()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ")";
   }

   public static class MesPaintTechnologyArtifactDTOBuilder {
      private Long artifactId;
      private NameInfo monomer;
      private NameInfo area;
      private String name;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private BigDecimal surfaceArea;
      private BigDecimal totalArea;

      MesPaintTechnologyArtifactDTOBuilder() {
      }

      public MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public MesPaintTechnologyArtifactDTO build() {
         return new MesPaintTechnologyArtifactDTO(
            this.artifactId, this.monomer, this.area, this.name, this.serialNumber, this.specification, this.quantity, this.surfaceArea, this.totalArea
         );
      }

      @Override
      public String toString() {
         return "MesPaintTechnologyArtifactDTO.MesPaintTechnologyArtifactDTOBuilder(artifactId="
            + this.artifactId
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalArea="
            + this.totalArea
            + ")";
      }
   }
}
