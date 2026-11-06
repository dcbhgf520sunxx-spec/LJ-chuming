package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import io.swagger.annotations.ApiModelProperty;

public class CrmPageManagementConfigUpdateParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "fieldName", value = "字段名称", notes = "字段名称")
   private String fieldName;
   @ApiModelProperty(name = "isShow", value = "是否展示", notes = "是否展示")
   private Boolean isShow;
   @ApiModelProperty(name = "isWrite", value = "是否必填", notes = "是否必填")
   private Boolean isWrite;
   @ApiModelProperty(name = "crmFieldParentTypeEnum", value = "上级字段枚举（CrmFieldParentTypeEnum）", notes = "上级字段枚举（CrmFieldParentTypeEnum）")
   private Integer crmFieldParentTypeEnum;
   @ApiModelProperty(
      name = "crmPageManagementConfigEnum",
      value = "页面配置tab类型枚举（CrmPageManagementConfigEnum）",
      notes = "页面配置tab类型枚举（CrmPageManagementConfigEnum）"
   )
   private Integer crmPageManagementConfigEnum;
   @ApiModelProperty(name = "crmCountryTypeEnum", value = "页面配置tab类型枚举（CrmPageManagementConfigEnum）", notes = "页面配置tab类型枚举（CrmPageManagementConfigEnum）")
   private Integer crmCountryTypeEnum;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;

   public CrmPageManagementConfigUpdateParam(
      final Long id,
      final String fieldName,
      final Boolean isShow,
      final Boolean isWrite,
      final Integer crmFieldParentTypeEnum,
      final Integer crmPageManagementConfigEnum,
      final Integer crmCountryTypeEnum,
      final Integer sort
   ) {
      this.id = id;
      this.fieldName = fieldName;
      this.isShow = isShow;
      this.isWrite = isWrite;
      this.crmFieldParentTypeEnum = crmFieldParentTypeEnum;
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      this.sort = sort;
   }

   public CrmPageManagementConfigUpdateParam() {
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

   public Boolean getIsWrite() {
      return this.isWrite;
   }

   public Integer getCrmFieldParentTypeEnum() {
      return this.crmFieldParentTypeEnum;
   }

   public Integer getCrmPageManagementConfigEnum() {
      return this.crmPageManagementConfigEnum;
   }

   public Integer getCrmCountryTypeEnum() {
      return this.crmCountryTypeEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFieldName(final String fieldName) {
      this.fieldName = fieldName;
   }

   public void setIsShow(final Boolean isShow) {
      this.isShow = isShow;
   }

   public void setIsWrite(final Boolean isWrite) {
      this.isWrite = isWrite;
   }

   public void setCrmFieldParentTypeEnum(final Integer crmFieldParentTypeEnum) {
      this.crmFieldParentTypeEnum = crmFieldParentTypeEnum;
   }

   public void setCrmPageManagementConfigEnum(final Integer crmPageManagementConfigEnum) {
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
   }

   public void setCrmCountryTypeEnum(final Integer crmCountryTypeEnum) {
      this.crmCountryTypeEnum = crmCountryTypeEnum;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPageManagementConfigUpdateParam)) {
         return false;
      }

      CrmPageManagementConfigUpdateParam other = (CrmPageManagementConfigUpdateParam)o;
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
                  Object this$crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
                  Object other$crmPageManagementConfigEnum = other.getCrmPageManagementConfigEnum();
                  if (this$crmPageManagementConfigEnum == null
                     ? other$crmPageManagementConfigEnum == null
                     : this$crmPageManagementConfigEnum.equals(other$crmPageManagementConfigEnum)) {
                     Object this$crmCountryTypeEnum = this.getCrmCountryTypeEnum();
                     Object other$crmCountryTypeEnum = other.getCrmCountryTypeEnum();
                     if (this$crmCountryTypeEnum == null ? other$crmCountryTypeEnum == null : this$crmCountryTypeEnum.equals(other$crmCountryTypeEnum)) {
                        Object this$sort = this.getSort();
                        Object other$sort = other.getSort();
                        if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                           Object this$fieldName = this.getFieldName();
                           Object other$fieldName = other.getFieldName();
                           return this$fieldName == null ? other$fieldName == null : this$fieldName.equals(other$fieldName);
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
      return other instanceof CrmPageManagementConfigUpdateParam;
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
      Object $crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
      result = result * 59 + ($crmPageManagementConfigEnum == null ? 43 : $crmPageManagementConfigEnum.hashCode());
      Object $crmCountryTypeEnum = this.getCrmCountryTypeEnum();
      result = result * 59 + ($crmCountryTypeEnum == null ? 43 : $crmCountryTypeEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $fieldName = this.getFieldName();
      return result * 59 + ($fieldName == null ? 43 : $fieldName.hashCode());
   }

   @Override
   public String toString() {
      return "CrmPageManagementConfigUpdateParam(id="
         + this.getId()
         + ", fieldName="
         + this.getFieldName()
         + ", isShow="
         + this.getIsShow()
         + ", isWrite="
         + this.getIsWrite()
         + ", crmFieldParentTypeEnum="
         + this.getCrmFieldParentTypeEnum()
         + ", crmPageManagementConfigEnum="
         + this.getCrmPageManagementConfigEnum()
         + ", crmCountryTypeEnum="
         + this.getCrmCountryTypeEnum()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
