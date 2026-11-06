package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class StructureParentTypeProcessDTO {
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("父类型 1.柱 2.梁 (智能线时有父类型)")
   private Integer parentType;
   @ApiModelProperty("构件类型列表")
   private List<StructureClassificationProcessDTO> structureClassificationList;

   public static StructureParentTypeProcessDTO.StructureParentTypeProcessDTOBuilder builder() {
      return new StructureParentTypeProcessDTO.StructureParentTypeProcessDTOBuilder();
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getParentType() {
      return this.parentType;
   }

   public List<StructureClassificationProcessDTO> getStructureClassificationList() {
      return this.structureClassificationList;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setParentType(final Integer parentType) {
      this.parentType = parentType;
   }

   public void setStructureClassificationList(final List<StructureClassificationProcessDTO> structureClassificationList) {
      this.structureClassificationList = structureClassificationList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureParentTypeProcessDTO)) {
         return false;
      }

      StructureParentTypeProcessDTO other = (StructureParentTypeProcessDTO)o;
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
      return other instanceof StructureParentTypeProcessDTO;
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
      return "StructureParentTypeProcessDTO(productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", parentType="
         + this.getParentType()
         + ", structureClassificationList="
         + this.getStructureClassificationList()
         + ")";
   }

   public StructureParentTypeProcessDTO(
      final Integer productionLineTypeEnum, final Integer parentType, final List<StructureClassificationProcessDTO> structureClassificationList
   ) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.parentType = parentType;
      this.structureClassificationList = structureClassificationList;
   }

   public StructureParentTypeProcessDTO() {
   }

   public static class StructureParentTypeProcessDTOBuilder {
      private Integer productionLineTypeEnum;
      private Integer parentType;
      private List<StructureClassificationProcessDTO> structureClassificationList;

      StructureParentTypeProcessDTOBuilder() {
      }

      public StructureParentTypeProcessDTO.StructureParentTypeProcessDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public StructureParentTypeProcessDTO.StructureParentTypeProcessDTOBuilder parentType(final Integer parentType) {
         this.parentType = parentType;
         return this;
      }

      public StructureParentTypeProcessDTO.StructureParentTypeProcessDTOBuilder structureClassificationList(
         final List<StructureClassificationProcessDTO> structureClassificationList
      ) {
         this.structureClassificationList = structureClassificationList;
         return this;
      }

      public StructureParentTypeProcessDTO build() {
         return new StructureParentTypeProcessDTO(this.productionLineTypeEnum, this.parentType, this.structureClassificationList);
      }

      @Override
      public String toString() {
         return "StructureParentTypeProcessDTO.StructureParentTypeProcessDTOBuilder(productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", parentType="
            + this.parentType
            + ", structureClassificationList="
            + this.structureClassificationList
            + ")";
      }
   }
}
