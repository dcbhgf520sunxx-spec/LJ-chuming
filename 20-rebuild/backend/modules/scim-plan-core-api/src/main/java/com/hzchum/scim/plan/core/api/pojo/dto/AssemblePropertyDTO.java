package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("型材套料属性DTO")
public class AssemblePropertyDTO {
   @ApiModelProperty(name = "id", value = "部件配置表id")
   private Long id;
   @ApiModelProperty(name = "specPrefix", value = "部件截面类型")
   private String specPrefix;
   @ApiModelProperty(name = "name", value = "部件配置名称")
   private String name;
   @ApiModelProperty(name = "specificationList", value = "规格/材质")
   private List<AssembleSpecificationDTO> specificationList;

   public static AssemblePropertyDTO.AssemblePropertyDTOBuilder builder() {
      return new AssemblePropertyDTO.AssemblePropertyDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getName() {
      return this.name;
   }

   public List<AssembleSpecificationDTO> getSpecificationList() {
      return this.specificationList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecificationList(final List<AssembleSpecificationDTO> specificationList) {
      this.specificationList = specificationList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssemblePropertyDTO)) {
         return false;
      }

      AssemblePropertyDTO other = (AssemblePropertyDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$specPrefix = this.getSpecPrefix();
         Object other$specPrefix = other.getSpecPrefix();
         if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$specificationList = this.getSpecificationList();
               Object other$specificationList = other.getSpecificationList();
               return this$specificationList == null ? other$specificationList == null : this$specificationList.equals(other$specificationList);
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
      return other instanceof AssemblePropertyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specificationList = this.getSpecificationList();
      return result * 59 + ($specificationList == null ? 43 : $specificationList.hashCode());
   }

   @Override
   public String toString() {
      return "AssemblePropertyDTO(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", name="
         + this.getName()
         + ", specificationList="
         + this.getSpecificationList()
         + ")";
   }

   public AssemblePropertyDTO() {
   }

   public AssemblePropertyDTO(final Long id, final String specPrefix, final String name, final List<AssembleSpecificationDTO> specificationList) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.name = name;
      this.specificationList = specificationList;
   }

   public static class AssemblePropertyDTOBuilder {
      private Long id;
      private String specPrefix;
      private String name;
      private List<AssembleSpecificationDTO> specificationList;

      AssemblePropertyDTOBuilder() {
      }

      public AssemblePropertyDTO.AssemblePropertyDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AssemblePropertyDTO.AssemblePropertyDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public AssemblePropertyDTO.AssemblePropertyDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AssemblePropertyDTO.AssemblePropertyDTOBuilder specificationList(final List<AssembleSpecificationDTO> specificationList) {
         this.specificationList = specificationList;
         return this;
      }

      public AssemblePropertyDTO build() {
         return new AssemblePropertyDTO(this.id, this.specPrefix, this.name, this.specificationList);
      }

      @Override
      public String toString() {
         return "AssemblePropertyDTO.AssemblePropertyDTOBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", name="
            + this.name
            + ", specificationList="
            + this.specificationList
            + ")";
      }
   }
}
