package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArtifactBasicsDO", description = "构件基础信息 ")
public class ArtifactBasicsDO extends ArtifactShipMeteDO {
   @ApiModelProperty("产品ids 逗号分隔")
   private String productIds;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("单体")
   private NameInfo monomer;
   @ApiModelProperty("区域")
   private NameInfo area;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("材质")
   private String material;

   public String getProductIds() {
      return this.productIds;
   }

   public ProjectInfo getProject() {
      return this.project;
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

   public String getMaterial() {
      return this.material;
   }

   public ArtifactBasicsDO setProductIds(final String productIds) {
      this.productIds = productIds;
      return this;
   }

   public ArtifactBasicsDO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public ArtifactBasicsDO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public ArtifactBasicsDO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   public ArtifactBasicsDO setName(final String name) {
      this.name = name;
      return this;
   }

   public ArtifactBasicsDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ArtifactBasicsDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public ArtifactBasicsDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactBasicsDO(productIds="
         + this.getProductIds()
         + ", project="
         + this.getProject()
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
         + ", material="
         + this.getMaterial()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactBasicsDO)) {
         return false;
      }

      ArtifactBasicsDO other = (ArtifactBasicsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$productIds = this.getProductIds();
      Object other$productIds = other.getProductIds();
      if (this$productIds == null ? other$productIds == null : this$productIds.equals(other$productIds)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
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
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           return this$material == null ? other$material == null : this$material.equals(other$material);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactBasicsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $productIds = this.getProductIds();
      result = result * 59 + ($productIds == null ? 43 : $productIds.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
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
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }
}
