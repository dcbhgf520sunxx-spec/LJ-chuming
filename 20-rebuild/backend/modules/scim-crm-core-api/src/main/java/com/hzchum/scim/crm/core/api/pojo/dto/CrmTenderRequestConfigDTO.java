package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmTenderRequestConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "crmTenderRequestConfigEnum", value = "投标申请配置枚举(CrmTenderRequestConfigEnum)", notes = "投标申请配置枚举(CrmTenderRequestConfigEnum)")
   private Integer crmTenderRequestConfigEnum;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;
   @ApiModelProperty(name = "crmSpecialBubmissionStatusEnum", value = "专项提报类型", notes = "专项提报类型")
   private Integer crmSpecialBubmissionStatusEnum;

   public static CrmTenderRequestConfigDTO.CrmTenderRequestConfigDTOBuilder builder() {
      return new CrmTenderRequestConfigDTO.CrmTenderRequestConfigDTOBuilder();
   }

   public CrmTenderRequestConfigDTO() {
   }

   public CrmTenderRequestConfigDTO(
      final Long id, final Integer crmTenderRequestConfigEnum, final String name, final Integer sort, final Integer crmSpecialBubmissionStatusEnum
   ) {
      this.id = id;
      this.crmTenderRequestConfigEnum = crmTenderRequestConfigEnum;
      this.name = name;
      this.sort = sort;
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmTenderRequestConfigEnum() {
      return this.crmTenderRequestConfigEnum;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getCrmSpecialBubmissionStatusEnum() {
      return this.crmSpecialBubmissionStatusEnum;
   }

   public CrmTenderRequestConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmTenderRequestConfigDTO setCrmTenderRequestConfigEnum(final Integer crmTenderRequestConfigEnum) {
      this.crmTenderRequestConfigEnum = crmTenderRequestConfigEnum;
      return this;
   }

   public CrmTenderRequestConfigDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public CrmTenderRequestConfigDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public CrmTenderRequestConfigDTO setCrmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmTenderRequestConfigDTO(id="
         + this.getId()
         + ", crmTenderRequestConfigEnum="
         + this.getCrmTenderRequestConfigEnum()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", crmSpecialBubmissionStatusEnum="
         + this.getCrmSpecialBubmissionStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTenderRequestConfigDTO)) {
         return false;
      }

      CrmTenderRequestConfigDTO other = (CrmTenderRequestConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmTenderRequestConfigEnum = this.getCrmTenderRequestConfigEnum();
         Object other$crmTenderRequestConfigEnum = other.getCrmTenderRequestConfigEnum();
         if (this$crmTenderRequestConfigEnum == null
            ? other$crmTenderRequestConfigEnum == null
            : this$crmTenderRequestConfigEnum.equals(other$crmTenderRequestConfigEnum)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
               Object other$crmSpecialBubmissionStatusEnum = other.getCrmSpecialBubmissionStatusEnum();
               if (this$crmSpecialBubmissionStatusEnum == null
                  ? other$crmSpecialBubmissionStatusEnum == null
                  : this$crmSpecialBubmissionStatusEnum.equals(other$crmSpecialBubmissionStatusEnum)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmTenderRequestConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmTenderRequestConfigEnum = this.getCrmTenderRequestConfigEnum();
      result = result * 59 + ($crmTenderRequestConfigEnum == null ? 43 : $crmTenderRequestConfigEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      result = result * 59 + ($crmSpecialBubmissionStatusEnum == null ? 43 : $crmSpecialBubmissionStatusEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class CrmTenderRequestConfigDTOBuilder {
      private Long id;
      private Integer crmTenderRequestConfigEnum;
      private String name;
      private Integer sort;
      private Integer crmSpecialBubmissionStatusEnum;

      CrmTenderRequestConfigDTOBuilder() {
      }

      public CrmTenderRequestConfigDTO.CrmTenderRequestConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmTenderRequestConfigDTO.CrmTenderRequestConfigDTOBuilder crmTenderRequestConfigEnum(final Integer crmTenderRequestConfigEnum) {
         this.crmTenderRequestConfigEnum = crmTenderRequestConfigEnum;
         return this;
      }

      public CrmTenderRequestConfigDTO.CrmTenderRequestConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CrmTenderRequestConfigDTO.CrmTenderRequestConfigDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public CrmTenderRequestConfigDTO.CrmTenderRequestConfigDTOBuilder crmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
         this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
         return this;
      }

      public CrmTenderRequestConfigDTO build() {
         return new CrmTenderRequestConfigDTO(this.id, this.crmTenderRequestConfigEnum, this.name, this.sort, this.crmSpecialBubmissionStatusEnum);
      }

      @Override
      public String toString() {
         return "CrmTenderRequestConfigDTO.CrmTenderRequestConfigDTOBuilder(id="
            + this.id
            + ", crmTenderRequestConfigEnum="
            + this.crmTenderRequestConfigEnum
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", crmSpecialBubmissionStatusEnum="
            + this.crmSpecialBubmissionStatusEnum
            + ")";
      }
   }
}
