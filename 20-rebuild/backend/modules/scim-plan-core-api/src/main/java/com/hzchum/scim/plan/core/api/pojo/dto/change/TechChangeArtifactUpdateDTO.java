package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class TechChangeArtifactUpdateDTO {
   @ApiModelProperty("构件ID")
   private Long artifactId;
   @ApiModelProperty("序号")
   private Integer sortNumber;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "面积（㎡）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "changeName", value = "变更后名称")
   private String changeName;
   @ApiModelProperty("变更后的编号")
   private String changeSerialNumber;
   @ApiModelProperty(name = "changeLength", value = "变更长度（mm）")
   private BigDecimal changeLength;
   @ApiModelProperty(name = "changeNetWeight", value = "变更单净重（kg）")
   private BigDecimal changeNetWeight;
   @ApiModelProperty(name = "changeGrossWeight", value = "变更单毛重（kg）")
   private BigDecimal changeGrossWeight;
   @ApiModelProperty(name = "changeSurfaceArea", value = "变更面积（㎡）")
   private BigDecimal changeSurfaceArea;
   @ApiModelProperty(name = "changeSortNumber", value = "变更后的序号", notes = "变更后的序号")
   private String changeSortNumber;

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
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

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getChangeName() {
      return this.changeName;
   }

   public String getChangeSerialNumber() {
      return this.changeSerialNumber;
   }

   public BigDecimal getChangeLength() {
      return this.changeLength;
   }

   public BigDecimal getChangeNetWeight() {
      return this.changeNetWeight;
   }

   public BigDecimal getChangeGrossWeight() {
      return this.changeGrossWeight;
   }

   public BigDecimal getChangeSurfaceArea() {
      return this.changeSurfaceArea;
   }

   public String getChangeSortNumber() {
      return this.changeSortNumber;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
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

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setChangeName(final String changeName) {
      this.changeName = changeName;
   }

   public void setChangeSerialNumber(final String changeSerialNumber) {
      this.changeSerialNumber = changeSerialNumber;
   }

   public void setChangeLength(final BigDecimal changeLength) {
      this.changeLength = changeLength;
   }

   public void setChangeNetWeight(final BigDecimal changeNetWeight) {
      this.changeNetWeight = changeNetWeight;
   }

   public void setChangeGrossWeight(final BigDecimal changeGrossWeight) {
      this.changeGrossWeight = changeGrossWeight;
   }

   public void setChangeSurfaceArea(final BigDecimal changeSurfaceArea) {
      this.changeSurfaceArea = changeSurfaceArea;
   }

   public void setChangeSortNumber(final String changeSortNumber) {
      this.changeSortNumber = changeSortNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeArtifactUpdateDTO)) {
         return false;
      }

      TechChangeArtifactUpdateDTO other = (TechChangeArtifactUpdateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$sortNumber = this.getSortNumber();
         Object other$sortNumber = other.getSortNumber();
         if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$length = this.getLength();
                        Object other$length = other.getLength();
                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                           Object this$netWeight = this.getNetWeight();
                           Object other$netWeight = other.getNetWeight();
                           if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                              Object this$grossWeight = this.getGrossWeight();
                              Object other$grossWeight = other.getGrossWeight();
                              if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                 Object this$surfaceArea = this.getSurfaceArea();
                                 Object other$surfaceArea = other.getSurfaceArea();
                                 if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                    Object this$changeName = this.getChangeName();
                                    Object other$changeName = other.getChangeName();
                                    if (this$changeName == null ? other$changeName == null : this$changeName.equals(other$changeName)) {
                                       Object this$changeSerialNumber = this.getChangeSerialNumber();
                                       Object other$changeSerialNumber = other.getChangeSerialNumber();
                                       if (this$changeSerialNumber == null
                                          ? other$changeSerialNumber == null
                                          : this$changeSerialNumber.equals(other$changeSerialNumber)) {
                                          Object this$changeLength = this.getChangeLength();
                                          Object other$changeLength = other.getChangeLength();
                                          if (this$changeLength == null ? other$changeLength == null : this$changeLength.equals(other$changeLength)) {
                                             Object this$changeNetWeight = this.getChangeNetWeight();
                                             Object other$changeNetWeight = other.getChangeNetWeight();
                                             if (this$changeNetWeight == null
                                                ? other$changeNetWeight == null
                                                : this$changeNetWeight.equals(other$changeNetWeight)) {
                                                Object this$changeGrossWeight = this.getChangeGrossWeight();
                                                Object other$changeGrossWeight = other.getChangeGrossWeight();
                                                if (this$changeGrossWeight == null
                                                   ? other$changeGrossWeight == null
                                                   : this$changeGrossWeight.equals(other$changeGrossWeight)) {
                                                   Object this$changeSurfaceArea = this.getChangeSurfaceArea();
                                                   Object other$changeSurfaceArea = other.getChangeSurfaceArea();
                                                   if (this$changeSurfaceArea == null
                                                      ? other$changeSurfaceArea == null
                                                      : this$changeSurfaceArea.equals(other$changeSurfaceArea)) {
                                                      Object this$changeSortNumber = this.getChangeSortNumber();
                                                      Object other$changeSortNumber = other.getChangeSortNumber();
                                                      return this$changeSortNumber == null
                                                         ? other$changeSortNumber == null
                                                         : this$changeSortNumber.equals(other$changeSortNumber);
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
      return other instanceof TechChangeArtifactUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $changeName = this.getChangeName();
      result = result * 59 + ($changeName == null ? 43 : $changeName.hashCode());
      Object $changeSerialNumber = this.getChangeSerialNumber();
      result = result * 59 + ($changeSerialNumber == null ? 43 : $changeSerialNumber.hashCode());
      Object $changeLength = this.getChangeLength();
      result = result * 59 + ($changeLength == null ? 43 : $changeLength.hashCode());
      Object $changeNetWeight = this.getChangeNetWeight();
      result = result * 59 + ($changeNetWeight == null ? 43 : $changeNetWeight.hashCode());
      Object $changeGrossWeight = this.getChangeGrossWeight();
      result = result * 59 + ($changeGrossWeight == null ? 43 : $changeGrossWeight.hashCode());
      Object $changeSurfaceArea = this.getChangeSurfaceArea();
      result = result * 59 + ($changeSurfaceArea == null ? 43 : $changeSurfaceArea.hashCode());
      Object $changeSortNumber = this.getChangeSortNumber();
      return result * 59 + ($changeSortNumber == null ? 43 : $changeSortNumber.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeArtifactUpdateDTO(artifactId="
         + this.getArtifactId()
         + ", sortNumber="
         + this.getSortNumber()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", changeName="
         + this.getChangeName()
         + ", changeSerialNumber="
         + this.getChangeSerialNumber()
         + ", changeLength="
         + this.getChangeLength()
         + ", changeNetWeight="
         + this.getChangeNetWeight()
         + ", changeGrossWeight="
         + this.getChangeGrossWeight()
         + ", changeSurfaceArea="
         + this.getChangeSurfaceArea()
         + ", changeSortNumber="
         + this.getChangeSortNumber()
         + ")";
   }
}
