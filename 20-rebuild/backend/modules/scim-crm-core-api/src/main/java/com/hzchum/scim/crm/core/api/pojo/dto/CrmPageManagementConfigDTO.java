package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmPageManagementConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "fieldName", value = "字段名称", notes = "字段名称")
   private String fieldName;
   @ApiModelProperty(name = "isShow", value = "是否展示", notes = "是否展示")
   private Boolean isShow;
   @ApiModelProperty(name = "argumentName", value = "字段名称")
   private String argumentName;
   @ApiModelProperty(name = "argumentShowName", value = "参数展示名称", notes = "参数展示名称")
   private String argumentShowName;
   @ApiModelProperty(name = "isWrite", value = "是否必填", notes = "是否必填")
   private Boolean isWrite;
   @ApiModelProperty(name = "crmFieldParentTypeEnum", value = "上级字段枚举（CrmFieldParentTypeEnum）", notes = "上级字段枚举（CrmFieldParentTypeEnum）")
   private Integer crmFieldParentTypeEnum;
   @ApiModelProperty(name = "crmFieldParentTypeEnumName", value = "上级字段枚举（CrmFieldParentTypeEnum）", notes = "上级字段枚举名称")
   private String crmFieldParentTypeEnumName;
   @ApiModelProperty(name = "crmFieldParentTypeEnumSort", value = "上级字段枚举（CrmFieldParentTypeEnum）", notes = "上级字段枚举排序")
   private Integer crmFieldParentTypeEnumSort;
   @ApiModelProperty(
      name = "crmPageManagementConfigEnum",
      value = "页面配置tab类型枚举（CrmPageManagementConfigEnum）",
      notes = "页面配置tab类型枚举（CrmPageManagementConfigEnum）"
   )
   private Integer crmPageManagementConfigEnum;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;

   public static CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder builder() {
      return new CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder();
   }

   public CrmPageManagementConfigDTO() {
   }

   public CrmPageManagementConfigDTO(
      final Long id,
      final String fieldName,
      final Boolean isShow,
      final String argumentName,
      final String argumentShowName,
      final Boolean isWrite,
      final Integer crmFieldParentTypeEnum,
      final String crmFieldParentTypeEnumName,
      final Integer crmFieldParentTypeEnumSort,
      final Integer crmPageManagementConfigEnum,
      final Integer sort
   ) {
      this.id = id;
      this.fieldName = fieldName;
      this.isShow = isShow;
      this.argumentName = argumentName;
      this.argumentShowName = argumentShowName;
      this.isWrite = isWrite;
      this.crmFieldParentTypeEnum = crmFieldParentTypeEnum;
      this.crmFieldParentTypeEnumName = crmFieldParentTypeEnumName;
      this.crmFieldParentTypeEnumSort = crmFieldParentTypeEnumSort;
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public String getFieldName() {
      return this.fieldName;
   }

   public Boolean getIsShow() {
      return this.isShow;
   }

   public String getArgumentName() {
      return this.argumentName;
   }

   public String getArgumentShowName() {
      return this.argumentShowName;
   }

   public Boolean getIsWrite() {
      return this.isWrite;
   }

   public Integer getCrmFieldParentTypeEnum() {
      return this.crmFieldParentTypeEnum;
   }

   public String getCrmFieldParentTypeEnumName() {
      return this.crmFieldParentTypeEnumName;
   }

   public Integer getCrmFieldParentTypeEnumSort() {
      return this.crmFieldParentTypeEnumSort;
   }

   public Integer getCrmPageManagementConfigEnum() {
      return this.crmPageManagementConfigEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public CrmPageManagementConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmPageManagementConfigDTO setFieldName(final String fieldName) {
      this.fieldName = fieldName;
      return this;
   }

   public CrmPageManagementConfigDTO setIsShow(final Boolean isShow) {
      this.isShow = isShow;
      return this;
   }

   public CrmPageManagementConfigDTO setArgumentName(final String argumentName) {
      this.argumentName = argumentName;
      return this;
   }

   public CrmPageManagementConfigDTO setArgumentShowName(final String argumentShowName) {
      this.argumentShowName = argumentShowName;
      return this;
   }

   public CrmPageManagementConfigDTO setIsWrite(final Boolean isWrite) {
      this.isWrite = isWrite;
      return this;
   }

   public CrmPageManagementConfigDTO setCrmFieldParentTypeEnum(final Integer crmFieldParentTypeEnum) {
      this.crmFieldParentTypeEnum = crmFieldParentTypeEnum;
      return this;
   }

   public CrmPageManagementConfigDTO setCrmFieldParentTypeEnumName(final String crmFieldParentTypeEnumName) {
      this.crmFieldParentTypeEnumName = crmFieldParentTypeEnumName;
      return this;
   }

   public CrmPageManagementConfigDTO setCrmFieldParentTypeEnumSort(final Integer crmFieldParentTypeEnumSort) {
      this.crmFieldParentTypeEnumSort = crmFieldParentTypeEnumSort;
      return this;
   }

   public CrmPageManagementConfigDTO setCrmPageManagementConfigEnum(final Integer crmPageManagementConfigEnum) {
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
      return this;
   }

   public CrmPageManagementConfigDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "CrmPageManagementConfigDTO(id="
         + this.getId()
         + ", fieldName="
         + this.getFieldName()
         + ", isShow="
         + this.getIsShow()
         + ", argumentName="
         + this.getArgumentName()
         + ", argumentShowName="
         + this.getArgumentShowName()
         + ", isWrite="
         + this.getIsWrite()
         + ", crmFieldParentTypeEnum="
         + this.getCrmFieldParentTypeEnum()
         + ", crmFieldParentTypeEnumName="
         + this.getCrmFieldParentTypeEnumName()
         + ", crmFieldParentTypeEnumSort="
         + this.getCrmFieldParentTypeEnumSort()
         + ", crmPageManagementConfigEnum="
         + this.getCrmPageManagementConfigEnum()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPageManagementConfigDTO)) {
         return false;
      }

      CrmPageManagementConfigDTO other = (CrmPageManagementConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$isShow = this.getIsShow();
         Object other$isShow = other.getIsShow();
         if (this$isShow == null ? other$isShow == null : this$isShow.equals(other$isShow)) {
            Object this$isWrite = this.getIsWrite();
            Object other$isWrite = other.getIsWrite();
            if (this$isWrite == null ? other$isWrite == null : this$isWrite.equals(other$isWrite)) {
               Object this$crmFieldParentTypeEnum = this.getCrmFieldParentTypeEnum();
               Object other$crmFieldParentTypeEnum = other.getCrmFieldParentTypeEnum();
               if (this$crmFieldParentTypeEnum == null
                  ? other$crmFieldParentTypeEnum == null
                  : this$crmFieldParentTypeEnum.equals(other$crmFieldParentTypeEnum)) {
                  Object this$crmFieldParentTypeEnumSort = this.getCrmFieldParentTypeEnumSort();
                  Object other$crmFieldParentTypeEnumSort = other.getCrmFieldParentTypeEnumSort();
                  if (this$crmFieldParentTypeEnumSort == null
                     ? other$crmFieldParentTypeEnumSort == null
                     : this$crmFieldParentTypeEnumSort.equals(other$crmFieldParentTypeEnumSort)) {
                     Object this$crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
                     Object other$crmPageManagementConfigEnum = other.getCrmPageManagementConfigEnum();
                     if (this$crmPageManagementConfigEnum == null
                        ? other$crmPageManagementConfigEnum == null
                        : this$crmPageManagementConfigEnum.equals(other$crmPageManagementConfigEnum)) {
                        Object this$sort = this.getSort();
                        Object other$sort = other.getSort();
                        if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                           Object this$fieldName = this.getFieldName();
                           Object other$fieldName = other.getFieldName();
                           if (this$fieldName == null ? other$fieldName == null : this$fieldName.equals(other$fieldName)) {
                              Object this$argumentName = this.getArgumentName();
                              Object other$argumentName = other.getArgumentName();
                              if (this$argumentName == null ? other$argumentName == null : this$argumentName.equals(other$argumentName)) {
                                 Object this$argumentShowName = this.getArgumentShowName();
                                 Object other$argumentShowName = other.getArgumentShowName();
                                 if (this$argumentShowName == null ? other$argumentShowName == null : this$argumentShowName.equals(other$argumentShowName)) {
                                    Object this$crmFieldParentTypeEnumName = this.getCrmFieldParentTypeEnumName();
                                    Object other$crmFieldParentTypeEnumName = other.getCrmFieldParentTypeEnumName();
                                    return this$crmFieldParentTypeEnumName == null
                                       ? other$crmFieldParentTypeEnumName == null
                                       : this$crmFieldParentTypeEnumName.equals(other$crmFieldParentTypeEnumName);
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
      return other instanceof CrmPageManagementConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isShow = this.getIsShow();
      result = result * 59 + ($isShow == null ? 43 : $isShow.hashCode());
      Object $isWrite = this.getIsWrite();
      result = result * 59 + ($isWrite == null ? 43 : $isWrite.hashCode());
      Object $crmFieldParentTypeEnum = this.getCrmFieldParentTypeEnum();
      result = result * 59 + ($crmFieldParentTypeEnum == null ? 43 : $crmFieldParentTypeEnum.hashCode());
      Object $crmFieldParentTypeEnumSort = this.getCrmFieldParentTypeEnumSort();
      result = result * 59 + ($crmFieldParentTypeEnumSort == null ? 43 : $crmFieldParentTypeEnumSort.hashCode());
      Object $crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
      result = result * 59 + ($crmPageManagementConfigEnum == null ? 43 : $crmPageManagementConfigEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $fieldName = this.getFieldName();
      result = result * 59 + ($fieldName == null ? 43 : $fieldName.hashCode());
      Object $argumentName = this.getArgumentName();
      result = result * 59 + ($argumentName == null ? 43 : $argumentName.hashCode());
      Object $argumentShowName = this.getArgumentShowName();
      result = result * 59 + ($argumentShowName == null ? 43 : $argumentShowName.hashCode());
      Object $crmFieldParentTypeEnumName = this.getCrmFieldParentTypeEnumName();
      return result * 59 + ($crmFieldParentTypeEnumName == null ? 43 : $crmFieldParentTypeEnumName.hashCode());
   }

   public static class CrmPageManagementConfigDTOBuilder {
      private Long id;
      private String fieldName;
      private Boolean isShow;
      private String argumentName;
      private String argumentShowName;
      private Boolean isWrite;
      private Integer crmFieldParentTypeEnum;
      private String crmFieldParentTypeEnumName;
      private Integer crmFieldParentTypeEnumSort;
      private Integer crmPageManagementConfigEnum;
      private Integer sort;

      CrmPageManagementConfigDTOBuilder() {
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder fieldName(final String fieldName) {
         this.fieldName = fieldName;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder isShow(final Boolean isShow) {
         this.isShow = isShow;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder argumentName(final String argumentName) {
         this.argumentName = argumentName;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder argumentShowName(final String argumentShowName) {
         this.argumentShowName = argumentShowName;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder isWrite(final Boolean isWrite) {
         this.isWrite = isWrite;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder crmFieldParentTypeEnum(final Integer crmFieldParentTypeEnum) {
         this.crmFieldParentTypeEnum = crmFieldParentTypeEnum;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder crmFieldParentTypeEnumName(final String crmFieldParentTypeEnumName) {
         this.crmFieldParentTypeEnumName = crmFieldParentTypeEnumName;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder crmFieldParentTypeEnumSort(final Integer crmFieldParentTypeEnumSort) {
         this.crmFieldParentTypeEnumSort = crmFieldParentTypeEnumSort;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder crmPageManagementConfigEnum(final Integer crmPageManagementConfigEnum) {
         this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
         return this;
      }

      public CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public CrmPageManagementConfigDTO build() {
         return new CrmPageManagementConfigDTO(
            this.id,
            this.fieldName,
            this.isShow,
            this.argumentName,
            this.argumentShowName,
            this.isWrite,
            this.crmFieldParentTypeEnum,
            this.crmFieldParentTypeEnumName,
            this.crmFieldParentTypeEnumSort,
            this.crmPageManagementConfigEnum,
            this.sort
         );
      }

      @Override
      public String toString() {
         return "CrmPageManagementConfigDTO.CrmPageManagementConfigDTOBuilder(id="
            + this.id
            + ", fieldName="
            + this.fieldName
            + ", isShow="
            + this.isShow
            + ", argumentName="
            + this.argumentName
            + ", argumentShowName="
            + this.argumentShowName
            + ", isWrite="
            + this.isWrite
            + ", crmFieldParentTypeEnum="
            + this.crmFieldParentTypeEnum
            + ", crmFieldParentTypeEnumName="
            + this.crmFieldParentTypeEnumName
            + ", crmFieldParentTypeEnumSort="
            + this.crmFieldParentTypeEnumSort
            + ", crmPageManagementConfigEnum="
            + this.crmPageManagementConfigEnum
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
