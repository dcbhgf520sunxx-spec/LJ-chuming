package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("型材套料部件构件配置DTO")
public class AssembleStructureConfigDTO {
   @ApiModelProperty(name = "ids", value = "构件配置表ids")
   private List<Long> ids;
   @ApiModelProperty(name = "classificationName", value = "构件种类名称")
   private String classificationName;
   @ApiModelProperty(name = "structureNameDTOS", value = "构件种类名称和定义代码列表")
   private List<AssembleStructureNameDTO> structureNameDTOS;
   @ApiModelProperty(name = "assemblePropertyDTOS", value = "部件配置信息")
   private List<AssemblePropertyDTO> assemblePropertyDTOS;

   public static AssembleStructureConfigDTO.AssembleStructureConfigDTOBuilder builder() {
      return new AssembleStructureConfigDTO.AssembleStructureConfigDTOBuilder();
   }

   public AssembleStructureConfigDTO() {
   }

   public AssembleStructureConfigDTO(
      final List<Long> ids,
      final String classificationName,
      final List<AssembleStructureNameDTO> structureNameDTOS,
      final List<AssemblePropertyDTO> assemblePropertyDTOS
   ) {
      this.ids = ids;
      this.classificationName = classificationName;
      this.structureNameDTOS = structureNameDTOS;
      this.assemblePropertyDTOS = assemblePropertyDTOS;
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public List<AssembleStructureNameDTO> getStructureNameDTOS() {
      return this.structureNameDTOS;
   }

   public List<AssemblePropertyDTO> getAssemblePropertyDTOS() {
      return this.assemblePropertyDTOS;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setStructureNameDTOS(final List<AssembleStructureNameDTO> structureNameDTOS) {
      this.structureNameDTOS = structureNameDTOS;
   }

   public void setAssemblePropertyDTOS(final List<AssemblePropertyDTO> assemblePropertyDTOS) {
      this.assemblePropertyDTOS = assemblePropertyDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleStructureConfigDTO)) {
         return false;
      }

      AssembleStructureConfigDTO other = (AssembleStructureConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ids = this.getIds();
      Object other$ids = other.getIds();
      if (this$ids == null ? other$ids == null : this$ids.equals(other$ids)) {
         Object this$classificationName = this.getClassificationName();
         Object other$classificationName = other.getClassificationName();
         if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
            Object this$structureNameDTOS = this.getStructureNameDTOS();
            Object other$structureNameDTOS = other.getStructureNameDTOS();
            if (this$structureNameDTOS == null ? other$structureNameDTOS == null : this$structureNameDTOS.equals(other$structureNameDTOS)) {
               Object this$assemblePropertyDTOS = this.getAssemblePropertyDTOS();
               Object other$assemblePropertyDTOS = other.getAssemblePropertyDTOS();
               return this$assemblePropertyDTOS == null ? other$assemblePropertyDTOS == null : this$assemblePropertyDTOS.equals(other$assemblePropertyDTOS);
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
      return other instanceof AssembleStructureConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ids = this.getIds();
      result = result * 59 + ($ids == null ? 43 : $ids.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $structureNameDTOS = this.getStructureNameDTOS();
      result = result * 59 + ($structureNameDTOS == null ? 43 : $structureNameDTOS.hashCode());
      Object $assemblePropertyDTOS = this.getAssemblePropertyDTOS();
      return result * 59 + ($assemblePropertyDTOS == null ? 43 : $assemblePropertyDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleStructureConfigDTO(ids="
         + this.getIds()
         + ", classificationName="
         + this.getClassificationName()
         + ", structureNameDTOS="
         + this.getStructureNameDTOS()
         + ", assemblePropertyDTOS="
         + this.getAssemblePropertyDTOS()
         + ")";
   }

   public static class AssembleStructureConfigDTOBuilder {
      private List<Long> ids;
      private String classificationName;
      private List<AssembleStructureNameDTO> structureNameDTOS;
      private List<AssemblePropertyDTO> assemblePropertyDTOS;

      AssembleStructureConfigDTOBuilder() {
      }

      public AssembleStructureConfigDTO.AssembleStructureConfigDTOBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public AssembleStructureConfigDTO.AssembleStructureConfigDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public AssembleStructureConfigDTO.AssembleStructureConfigDTOBuilder structureNameDTOS(final List<AssembleStructureNameDTO> structureNameDTOS) {
         this.structureNameDTOS = structureNameDTOS;
         return this;
      }

      public AssembleStructureConfigDTO.AssembleStructureConfigDTOBuilder assemblePropertyDTOS(final List<AssemblePropertyDTO> assemblePropertyDTOS) {
         this.assemblePropertyDTOS = assemblePropertyDTOS;
         return this;
      }

      public AssembleStructureConfigDTO build() {
         return new AssembleStructureConfigDTO(this.ids, this.classificationName, this.structureNameDTOS, this.assemblePropertyDTOS);
      }

      @Override
      public String toString() {
         return "AssembleStructureConfigDTO.AssembleStructureConfigDTOBuilder(ids="
            + this.ids
            + ", classificationName="
            + this.classificationName
            + ", structureNameDTOS="
            + this.structureNameDTOS
            + ", assemblePropertyDTOS="
            + this.assemblePropertyDTOS
            + ")";
      }
   }
}
