package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmProjectInformationConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "crmProjectInformationConfigEnum", value = "项目信息配置枚举", notes = "项目信息配置枚举")
   private Integer crmProjectInformationConfigEnum;
   @ApiModelProperty(name = "name", value = "名称（建筑形式）", notes = "名称（建筑形式）")
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;

   public static CrmProjectInformationConfigDTO.CrmProjectInformationConfigDTOBuilder builder() {
      return new CrmProjectInformationConfigDTO.CrmProjectInformationConfigDTOBuilder();
   }

   public CrmProjectInformationConfigDTO() {
   }

   public CrmProjectInformationConfigDTO(final Long id, final Integer crmProjectInformationConfigEnum, final String name, final Integer sort) {
      this.id = id;
      this.crmProjectInformationConfigEnum = crmProjectInformationConfigEnum;
      this.name = name;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmProjectInformationConfigEnum() {
      return this.crmProjectInformationConfigEnum;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public CrmProjectInformationConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectInformationConfigDTO setCrmProjectInformationConfigEnum(final Integer crmProjectInformationConfigEnum) {
      this.crmProjectInformationConfigEnum = crmProjectInformationConfigEnum;
      return this;
   }

   public CrmProjectInformationConfigDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public CrmProjectInformationConfigDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectInformationConfigDTO(id="
         + this.getId()
         + ", crmProjectInformationConfigEnum="
         + this.getCrmProjectInformationConfigEnum()
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

      if (!(o instanceof CrmProjectInformationConfigDTO)) {
         return false;
      }

      CrmProjectInformationConfigDTO other = (CrmProjectInformationConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmProjectInformationConfigEnum = this.getCrmProjectInformationConfigEnum();
         Object other$crmProjectInformationConfigEnum = other.getCrmProjectInformationConfigEnum();
         if (this$crmProjectInformationConfigEnum == null
            ? other$crmProjectInformationConfigEnum == null
            : this$crmProjectInformationConfigEnum.equals(other$crmProjectInformationConfigEnum)) {
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
      return other instanceof CrmProjectInformationConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectInformationConfigEnum = this.getCrmProjectInformationConfigEnum();
      result = result * 59 + ($crmProjectInformationConfigEnum == null ? 43 : $crmProjectInformationConfigEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class CrmProjectInformationConfigDTOBuilder {
      private Long id;
      private Integer crmProjectInformationConfigEnum;
      private String name;
      private Integer sort;

      CrmProjectInformationConfigDTOBuilder() {
      }

      public CrmProjectInformationConfigDTO.CrmProjectInformationConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectInformationConfigDTO.CrmProjectInformationConfigDTOBuilder crmProjectInformationConfigEnum(final Integer crmProjectInformationConfigEnum) {
         this.crmProjectInformationConfigEnum = crmProjectInformationConfigEnum;
         return this;
      }

      public CrmProjectInformationConfigDTO.CrmProjectInformationConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CrmProjectInformationConfigDTO.CrmProjectInformationConfigDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public CrmProjectInformationConfigDTO build() {
         return new CrmProjectInformationConfigDTO(this.id, this.crmProjectInformationConfigEnum, this.name, this.sort);
      }

      @Override
      public String toString() {
         return "CrmProjectInformationConfigDTO.CrmProjectInformationConfigDTOBuilder(id="
            + this.id
            + ", crmProjectInformationConfigEnum="
            + this.crmProjectInformationConfigEnum
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
