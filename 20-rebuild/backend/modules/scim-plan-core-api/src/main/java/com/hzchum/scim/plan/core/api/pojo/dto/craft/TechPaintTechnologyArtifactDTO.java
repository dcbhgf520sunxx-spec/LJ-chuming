package com.hzchum.scim.plan.core.api.pojo.dto.craft;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class TechPaintTechnologyArtifactDTO {
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "artifactId", value = "构件ID")
   private Long artifactId;
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

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Long getArtifactId() {
      return this.artifactId;
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

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
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

      if (!(o instanceof TechPaintTechnologyArtifactDTO)) {
         return false;
      }

      TechPaintTechnologyArtifactDTO other = (TechPaintTechnologyArtifactDTO)o;
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
      return other instanceof TechPaintTechnologyArtifactDTO;
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
      return "TechPaintTechnologyArtifactDTO(monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", artifactId="
         + this.getArtifactId()
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
}
