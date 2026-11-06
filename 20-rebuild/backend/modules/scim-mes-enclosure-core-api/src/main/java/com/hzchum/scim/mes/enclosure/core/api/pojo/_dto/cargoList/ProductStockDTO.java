package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.TechStandardPartDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "产品库存信息")
public class ProductStockDTO {
   @ApiModelProperty(name = "artifactList", notes = "构件")
   private List<ArtifactDetailDO> artifactList;
   @ApiModelProperty(name = "partList", notes = "零件-直发件")
   private List<SendDirectlyDetailDO> partList;
   @ApiModelProperty(name = "enclosureList", notes = "围护")
   private List<EnclosureDetailDO> enclosureList;
   @ApiModelProperty(name = "auxiliaryMaterialList", notes = "辅材")
   private List<TechStandardPartDetailDO> auxiliaryMaterialList;

   public static ProductStockDTO.ProductStockDTOBuilder builder() {
      return new ProductStockDTO.ProductStockDTOBuilder();
   }

   public ProductStockDTO() {
   }

   public ProductStockDTO(
      final List<ArtifactDetailDO> artifactList,
      final List<SendDirectlyDetailDO> partList,
      final List<EnclosureDetailDO> enclosureList,
      final List<TechStandardPartDetailDO> auxiliaryMaterialList
   ) {
      this.artifactList = artifactList;
      this.partList = partList;
      this.enclosureList = enclosureList;
      this.auxiliaryMaterialList = auxiliaryMaterialList;
   }

   public List<ArtifactDetailDO> getArtifactList() {
      return this.artifactList;
   }

   public List<SendDirectlyDetailDO> getPartList() {
      return this.partList;
   }

   public List<EnclosureDetailDO> getEnclosureList() {
      return this.enclosureList;
   }

   public List<TechStandardPartDetailDO> getAuxiliaryMaterialList() {
      return this.auxiliaryMaterialList;
   }

   public ProductStockDTO setArtifactList(final List<ArtifactDetailDO> artifactList) {
      this.artifactList = artifactList;
      return this;
   }

   public ProductStockDTO setPartList(final List<SendDirectlyDetailDO> partList) {
      this.partList = partList;
      return this;
   }

   public ProductStockDTO setEnclosureList(final List<EnclosureDetailDO> enclosureList) {
      this.enclosureList = enclosureList;
      return this;
   }

   public ProductStockDTO setAuxiliaryMaterialList(final List<TechStandardPartDetailDO> auxiliaryMaterialList) {
      this.auxiliaryMaterialList = auxiliaryMaterialList;
      return this;
   }

   @Override
   public String toString() {
      return "ProductStockDTO(artifactList="
         + this.getArtifactList()
         + ", partList="
         + this.getPartList()
         + ", enclosureList="
         + this.getEnclosureList()
         + ", auxiliaryMaterialList="
         + this.getAuxiliaryMaterialList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductStockDTO)) {
         return false;
      }

      ProductStockDTO other = (ProductStockDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactList = this.getArtifactList();
      Object other$artifactList = other.getArtifactList();
      if (this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList)) {
         Object this$partList = this.getPartList();
         Object other$partList = other.getPartList();
         if (this$partList == null ? other$partList == null : this$partList.equals(other$partList)) {
            Object this$enclosureList = this.getEnclosureList();
            Object other$enclosureList = other.getEnclosureList();
            if (this$enclosureList == null ? other$enclosureList == null : this$enclosureList.equals(other$enclosureList)) {
               Object this$auxiliaryMaterialList = this.getAuxiliaryMaterialList();
               Object other$auxiliaryMaterialList = other.getAuxiliaryMaterialList();
               return this$auxiliaryMaterialList == null ? other$auxiliaryMaterialList == null : this$auxiliaryMaterialList.equals(other$auxiliaryMaterialList);
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
      return other instanceof ProductStockDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactList = this.getArtifactList();
      result = result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
      Object $partList = this.getPartList();
      result = result * 59 + ($partList == null ? 43 : $partList.hashCode());
      Object $enclosureList = this.getEnclosureList();
      result = result * 59 + ($enclosureList == null ? 43 : $enclosureList.hashCode());
      Object $auxiliaryMaterialList = this.getAuxiliaryMaterialList();
      return result * 59 + ($auxiliaryMaterialList == null ? 43 : $auxiliaryMaterialList.hashCode());
   }

   public static class ProductStockDTOBuilder {
      private List<ArtifactDetailDO> artifactList;
      private List<SendDirectlyDetailDO> partList;
      private List<EnclosureDetailDO> enclosureList;
      private List<TechStandardPartDetailDO> auxiliaryMaterialList;

      ProductStockDTOBuilder() {
      }

      public ProductStockDTO.ProductStockDTOBuilder artifactList(final List<ArtifactDetailDO> artifactList) {
         this.artifactList = artifactList;
         return this;
      }

      public ProductStockDTO.ProductStockDTOBuilder partList(final List<SendDirectlyDetailDO> partList) {
         this.partList = partList;
         return this;
      }

      public ProductStockDTO.ProductStockDTOBuilder enclosureList(final List<EnclosureDetailDO> enclosureList) {
         this.enclosureList = enclosureList;
         return this;
      }

      public ProductStockDTO.ProductStockDTOBuilder auxiliaryMaterialList(final List<TechStandardPartDetailDO> auxiliaryMaterialList) {
         this.auxiliaryMaterialList = auxiliaryMaterialList;
         return this;
      }

      public ProductStockDTO build() {
         return new ProductStockDTO(this.artifactList, this.partList, this.enclosureList, this.auxiliaryMaterialList);
      }

      @Override
      public String toString() {
         return "ProductStockDTO.ProductStockDTOBuilder(artifactList="
            + this.artifactList
            + ", partList="
            + this.partList
            + ", enclosureList="
            + this.enclosureList
            + ", auxiliaryMaterialList="
            + this.auxiliaryMaterialList
            + ")";
      }
   }
}
