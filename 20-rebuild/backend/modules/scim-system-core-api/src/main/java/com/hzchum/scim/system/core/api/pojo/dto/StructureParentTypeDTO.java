package com.hzchum.scim.system.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class StructureParentTypeDTO {
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("父类型  1.梁 2.柱 (智能线时有父类型)")
   private Integer parentType;
   @ApiModelProperty("构件类型列表")
   private List<StructureClassificationDTO> structureClassificationList;

   public static StructureParentTypeDTO.StructureParentTypeDTOBuilder builder() {
      return new StructureParentTypeDTO.StructureParentTypeDTOBuilder();
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getParentType() {
      return this.parentType;
   }

   public List<StructureClassificationDTO> getStructureClassificationList() {
      return this.structureClassificationList;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setParentType(final Integer parentType) {
      this.parentType = parentType;
   }

   public void setStructureClassificationList(final List<StructureClassificationDTO> structureClassificationList) {
      this.structureClassificationList = structureClassificationList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureParentTypeDTO)) {
         return false;
      }

      StructureParentTypeDTO other = (StructureParentTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
      Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
      if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
         Object this$parentType = this.getParentType();
         Object other$parentType = other.getParentType();
         if (this$parentType == null ? other$parentType == null : this$parentType.equals(other$parentType)) {
            Object this$structureClassificationList = this.getStructureClassificationList();
            Object other$structureClassificationList = other.getStructureClassificationList();
            return this$structureClassificationList == null
               ? other$structureClassificationList == null
               : this$structureClassificationList.equals(other$structureClassificationList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof StructureParentTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $parentType = this.getParentType();
      result = result * 59 + ($parentType == null ? 43 : $parentType.hashCode());
      Object $structureClassificationList = this.getStructureClassificationList();
      return result * 59 + ($structureClassificationList == null ? 43 : $structureClassificationList.hashCode());
   }

   @Override
   public String toString() {
      return "StructureParentTypeDTO(productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", parentType="
         + this.getParentType()
         + ", structureClassificationList="
         + this.getStructureClassificationList()
         + ")";
   }

   public StructureParentTypeDTO(
      final Integer productionLineTypeEnum, final Integer parentType, final List<StructureClassificationDTO> structureClassificationList
   ) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.parentType = parentType;
      this.structureClassificationList = structureClassificationList;
   }

   public StructureParentTypeDTO() {
   }

   public static class StructureParentTypeDTOBuilder {
      private Integer productionLineTypeEnum;
      private Integer parentType;
      private List<StructureClassificationDTO> structureClassificationList;

      StructureParentTypeDTOBuilder() {
      }

      public StructureParentTypeDTO.StructureParentTypeDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public StructureParentTypeDTO.StructureParentTypeDTOBuilder parentType(final Integer parentType) {
         this.parentType = parentType;
         return this;
      }

      public StructureParentTypeDTO.StructureParentTypeDTOBuilder structureClassificationList(
         final List<StructureClassificationDTO> structureClassificationList
      ) {
         this.structureClassificationList = structureClassificationList;
         return this;
      }

      public StructureParentTypeDTO build() {
         return new StructureParentTypeDTO(this.productionLineTypeEnum, this.parentType, this.structureClassificationList);
      }

      @Override
      public String toString() {
         return "StructureParentTypeDTO.StructureParentTypeDTOBuilder(productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", parentType="
            + this.parentType
            + ", structureClassificationList="
            + this.structureClassificationList
            + ")";
      }
   }
}
