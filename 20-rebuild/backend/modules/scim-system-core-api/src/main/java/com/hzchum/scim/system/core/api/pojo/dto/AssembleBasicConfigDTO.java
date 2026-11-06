package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "组立配置基础DTO类 ")
public class AssembleBasicConfigDTO {
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("组立名称")
   private String name;
   @ApiModelProperty("组立规格前缀列表")
   private List<String> assembleSpecList;

   public static AssembleBasicConfigDTO.AssembleBasicConfigDTOBuilder builder() {
      return new AssembleBasicConfigDTO.AssembleBasicConfigDTOBuilder();
   }

   public AssembleBasicConfigDTO() {
   }

   public AssembleBasicConfigDTO(final Long id, final String name, final List<String> assembleSpecList) {
      this.id = id;
      this.name = name;
      this.assembleSpecList = assembleSpecList;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<String> getAssembleSpecList() {
      return this.assembleSpecList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setAssembleSpecList(final List<String> assembleSpecList) {
      this.assembleSpecList = assembleSpecList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleBasicConfigDTO)) {
         return false;
      }

      AssembleBasicConfigDTO other = (AssembleBasicConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$assembleSpecList = this.getAssembleSpecList();
            Object other$assembleSpecList = other.getAssembleSpecList();
            return this$assembleSpecList == null ? other$assembleSpecList == null : this$assembleSpecList.equals(other$assembleSpecList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleBasicConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $assembleSpecList = this.getAssembleSpecList();
      return result * 59 + ($assembleSpecList == null ? 43 : $assembleSpecList.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleBasicConfigDTO(id=" + this.getId() + ", name=" + this.getName() + ", assembleSpecList=" + this.getAssembleSpecList() + ")";
   }

   public static class AssembleBasicConfigDTOBuilder {
      private Long id;
      private String name;
      private List<String> assembleSpecList;

      AssembleBasicConfigDTOBuilder() {
      }

      public AssembleBasicConfigDTO.AssembleBasicConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AssembleBasicConfigDTO.AssembleBasicConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AssembleBasicConfigDTO.AssembleBasicConfigDTOBuilder assembleSpecList(final List<String> assembleSpecList) {
         this.assembleSpecList = assembleSpecList;
         return this;
      }

      public AssembleBasicConfigDTO build() {
         return new AssembleBasicConfigDTO(this.id, this.name, this.assembleSpecList);
      }

      @Override
      public String toString() {
         return "AssembleBasicConfigDTO.AssembleBasicConfigDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", assembleSpecList="
            + this.assembleSpecList
            + ")";
      }
   }
}
