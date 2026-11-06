package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class TechChangeArtifactBasicUpdateDTO {
   @ApiModelProperty("构件ID")
   private Long artifactId;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "原数量", notes = "原数量")
   private Integer quantity;
   @ApiModelProperty(name = "changeQuantity", value = "变更后数量", notes = "变更后数量")
   private Integer changeQuantity;
   @ApiModelProperty(name = "length", value = "原长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "changeLength", value = "变更后长度（mm）")
   private BigDecimal changeLength;
   @ApiModelProperty(name = "netWeight", value = "原单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "changeNetWeight", value = "变更后单净重（kg）")
   private BigDecimal changeNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "changeGrossWeight", value = "变更后单毛重（kg）")
   private BigDecimal changeGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "原单面积（mm²）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "changeSurfaceArea", value = "变更后单面积（mm²）")
   private BigDecimal changeSurfaceArea;
   @ApiModelProperty(name = "changeName", value = "变更后名称")
   private String changeName;
   @ApiModelProperty(name = "printedCode", value = "原喷印编码")
   private String printedCode;
   @ApiModelProperty(name = "changePrintedCode", value = "修改后喷印编码")
   private String changePrintedCode;

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

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getChangeQuantity() {
      return this.changeQuantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getChangeLength() {
      return this.changeLength;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getChangeNetWeight() {
      return this.changeNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getChangeGrossWeight() {
      return this.changeGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getChangeSurfaceArea() {
      return this.changeSurfaceArea;
   }

   public String getChangeName() {
      return this.changeName;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   public String getChangePrintedCode() {
      return this.changePrintedCode;
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

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setChangeQuantity(final Integer changeQuantity) {
      this.changeQuantity = changeQuantity;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setChangeLength(final BigDecimal changeLength) {
      this.changeLength = changeLength;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setChangeNetWeight(final BigDecimal changeNetWeight) {
      this.changeNetWeight = changeNetWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setChangeGrossWeight(final BigDecimal changeGrossWeight) {
      this.changeGrossWeight = changeGrossWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setChangeSurfaceArea(final BigDecimal changeSurfaceArea) {
      this.changeSurfaceArea = changeSurfaceArea;
   }

   public void setChangeName(final String changeName) {
      this.changeName = changeName;
   }

   public void setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
   }

   public void setChangePrintedCode(final String changePrintedCode) {
      this.changePrintedCode = changePrintedCode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeArtifactBasicUpdateDTO)) {
         return false;
      }

      TechChangeArtifactBasicUpdateDTO other = (TechChangeArtifactBasicUpdateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$changeQuantity = this.getChangeQuantity();
            Object other$changeQuantity = other.getChangeQuantity();
            if (this$changeQuantity == null ? other$changeQuantity == null : this$changeQuantity.equals(other$changeQuantity)) {
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
                              Object this$changeLength = this.getChangeLength();
                              Object other$changeLength = other.getChangeLength();
                              if (this$changeLength == null ? other$changeLength == null : this$changeLength.equals(other$changeLength)) {
                                 Object this$netWeight = this.getNetWeight();
                                 Object other$netWeight = other.getNetWeight();
                                 if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                    Object this$changeNetWeight = this.getChangeNetWeight();
                                    Object other$changeNetWeight = other.getChangeNetWeight();
                                    if (this$changeNetWeight == null ? other$changeNetWeight == null : this$changeNetWeight.equals(other$changeNetWeight)) {
                                       Object this$grossWeight = this.getGrossWeight();
                                       Object other$grossWeight = other.getGrossWeight();
                                       if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                          Object this$changeGrossWeight = this.getChangeGrossWeight();
                                          Object other$changeGrossWeight = other.getChangeGrossWeight();
                                          if (this$changeGrossWeight == null
                                             ? other$changeGrossWeight == null
                                             : this$changeGrossWeight.equals(other$changeGrossWeight)) {
                                             Object this$surfaceArea = this.getSurfaceArea();
                                             Object other$surfaceArea = other.getSurfaceArea();
                                             if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                Object this$changeSurfaceArea = this.getChangeSurfaceArea();
                                                Object other$changeSurfaceArea = other.getChangeSurfaceArea();
                                                if (this$changeSurfaceArea == null
                                                   ? other$changeSurfaceArea == null
                                                   : this$changeSurfaceArea.equals(other$changeSurfaceArea)) {
                                                   Object this$changeName = this.getChangeName();
                                                   Object other$changeName = other.getChangeName();
                                                   if (this$changeName == null ? other$changeName == null : this$changeName.equals(other$changeName)) {
                                                      Object this$printedCode = this.getPrintedCode();
                                                      Object other$printedCode = other.getPrintedCode();
                                                      if (this$printedCode == null ? other$printedCode == null : this$printedCode.equals(other$printedCode)) {
                                                         Object this$changePrintedCode = this.getChangePrintedCode();
                                                         Object other$changePrintedCode = other.getChangePrintedCode();
                                                         return this$changePrintedCode == null
                                                            ? other$changePrintedCode == null
                                                            : this$changePrintedCode.equals(other$changePrintedCode);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechChangeArtifactBasicUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $changeQuantity = this.getChangeQuantity();
      result = result * 59 + ($changeQuantity == null ? 43 : $changeQuantity.hashCode());
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
      Object $changeLength = this.getChangeLength();
      result = result * 59 + ($changeLength == null ? 43 : $changeLength.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $changeNetWeight = this.getChangeNetWeight();
      result = result * 59 + ($changeNetWeight == null ? 43 : $changeNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $changeGrossWeight = this.getChangeGrossWeight();
      result = result * 59 + ($changeGrossWeight == null ? 43 : $changeGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $changeSurfaceArea = this.getChangeSurfaceArea();
      result = result * 59 + ($changeSurfaceArea == null ? 43 : $changeSurfaceArea.hashCode());
      Object $changeName = this.getChangeName();
      result = result * 59 + ($changeName == null ? 43 : $changeName.hashCode());
      Object $printedCode = this.getPrintedCode();
      result = result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
      Object $changePrintedCode = this.getChangePrintedCode();
      return result * 59 + ($changePrintedCode == null ? 43 : $changePrintedCode.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeArtifactBasicUpdateDTO(artifactId="
         + this.getArtifactId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", changeQuantity="
         + this.getChangeQuantity()
         + ", length="
         + this.getLength()
         + ", changeLength="
         + this.getChangeLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", changeNetWeight="
         + this.getChangeNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", changeGrossWeight="
         + this.getChangeGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", changeSurfaceArea="
         + this.getChangeSurfaceArea()
         + ", changeName="
         + this.getChangeName()
         + ", printedCode="
         + this.getPrintedCode()
         + ", changePrintedCode="
         + this.getChangePrintedCode()
         + ")";
   }
}
