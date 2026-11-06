package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmBasicsConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "crmBasicsConfigEnum", value = "crm-基础配置枚举参考CrmBasicsConfigEnum", notes = "crm-基础配置枚举参考CrmBasicsConfigEnum")
   private Integer crmBasicsConfigEnum;
   @ApiModelProperty(name = "name", value = "名称（包含 性质 类别）", notes = "名称（包含 性质 类别）")
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;

   public static CrmBasicsConfigDTO.CrmBasicsConfigDTOBuilder builder() {
      return new CrmBasicsConfigDTO.CrmBasicsConfigDTOBuilder();
   }

   public CrmBasicsConfigDTO() {
   }

   public CrmBasicsConfigDTO(final Long id, final Integer crmBasicsConfigEnum, final String name, final Integer sort) {
      this.id = id;
      this.crmBasicsConfigEnum = crmBasicsConfigEnum;
      this.name = name;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmBasicsConfigEnum() {
      return this.crmBasicsConfigEnum;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public CrmBasicsConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmBasicsConfigDTO setCrmBasicsConfigEnum(final Integer crmBasicsConfigEnum) {
      this.crmBasicsConfigEnum = crmBasicsConfigEnum;
      return this;
   }

   public CrmBasicsConfigDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public CrmBasicsConfigDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBasicsConfigDTO(id="
         + this.getId()
         + ", crmBasicsConfigEnum="
         + this.getCrmBasicsConfigEnum()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBasicsConfigDTO)) {
         return false;
      }

      CrmBasicsConfigDTO other = (CrmBasicsConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmBasicsConfigEnum = this.getCrmBasicsConfigEnum();
         Object other$crmBasicsConfigEnum = other.getCrmBasicsConfigEnum();
         if (this$crmBasicsConfigEnum == null ? other$crmBasicsConfigEnum == null : this$crmBasicsConfigEnum.equals(other$crmBasicsConfigEnum)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof CrmBasicsConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmBasicsConfigEnum = this.getCrmBasicsConfigEnum();
      result = result * 59 + ($crmBasicsConfigEnum == null ? 43 : $crmBasicsConfigEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class CrmBasicsConfigDTOBuilder {
      private Long id;
      private Integer crmBasicsConfigEnum;
      private String name;
      private Integer sort;

      CrmBasicsConfigDTOBuilder() {
      }

      public CrmBasicsConfigDTO.CrmBasicsConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmBasicsConfigDTO.CrmBasicsConfigDTOBuilder crmBasicsConfigEnum(final Integer crmBasicsConfigEnum) {
         this.crmBasicsConfigEnum = crmBasicsConfigEnum;
         return this;
      }

      public CrmBasicsConfigDTO.CrmBasicsConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CrmBasicsConfigDTO.CrmBasicsConfigDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public CrmBasicsConfigDTO build() {
         return new CrmBasicsConfigDTO(this.id, this.crmBasicsConfigEnum, this.name, this.sort);
      }

      @Override
      public String toString() {
         return "CrmBasicsConfigDTO.CrmBasicsConfigDTOBuilder(id="
            + this.id
            + ", crmBasicsConfigEnum="
            + this.crmBasicsConfigEnum
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
