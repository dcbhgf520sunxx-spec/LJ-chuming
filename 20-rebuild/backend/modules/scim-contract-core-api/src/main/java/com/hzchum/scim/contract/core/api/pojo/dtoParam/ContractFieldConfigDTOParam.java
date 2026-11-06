package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ContractFieldConfigDTOParam {
   @ApiModelProperty(notes = "字段ID")
   private Long id;
   @ApiModelProperty(notes = "字段枚举值")
   private Integer fieldEnumType;
   @ApiModelProperty(notes = "排序")
   private Integer fieldSort;
   @ApiModelProperty(notes = "所属一级部门ID")
   private Long parentId;
   @ApiModelProperty(notes = "字段可选值")
   private String fieldValue;
   @ApiModelProperty(notes = "所属部门的JSON")
   private Map<String, BigDecimal> deptJson;
   @ApiModelProperty(notes = "集合")
   private List<ContractFieldConfigDTOParam> list;

   ContractFieldConfigDTOParam(
      final Long id,
      final Integer fieldEnumType,
      final Integer fieldSort,
      final Long parentId,
      final String fieldValue,
      final Map<String, BigDecimal> deptJson,
      final List<ContractFieldConfigDTOParam> list
   ) {
      this.id = id;
      this.fieldEnumType = fieldEnumType;
      this.fieldSort = fieldSort;
      this.parentId = parentId;
      this.fieldValue = fieldValue;
      this.deptJson = deptJson;
      this.list = list;
   }

   public static ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder builder() {
      return new ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getFieldEnumType() {
      return this.fieldEnumType;
   }

   public Integer getFieldSort() {
      return this.fieldSort;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public String getFieldValue() {
      return this.fieldValue;
   }

   public Map<String, BigDecimal> getDeptJson() {
      return this.deptJson;
   }

   public List<ContractFieldConfigDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFieldEnumType(final Integer fieldEnumType) {
      this.fieldEnumType = fieldEnumType;
   }

   public void setFieldSort(final Integer fieldSort) {
      this.fieldSort = fieldSort;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setFieldValue(final String fieldValue) {
      this.fieldValue = fieldValue;
   }

   public void setDeptJson(final Map<String, BigDecimal> deptJson) {
      this.deptJson = deptJson;
   }

   public void setList(final List<ContractFieldConfigDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractFieldConfigDTOParam)) {
         return false;
      }

      ContractFieldConfigDTOParam other = (ContractFieldConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$fieldEnumType = this.getFieldEnumType();
         Object other$fieldEnumType = other.getFieldEnumType();
         if (this$fieldEnumType == null ? other$fieldEnumType == null : this$fieldEnumType.equals(other$fieldEnumType)) {
            Object this$fieldSort = this.getFieldSort();
            Object other$fieldSort = other.getFieldSort();
            if (this$fieldSort == null ? other$fieldSort == null : this$fieldSort.equals(other$fieldSort)) {
               Object this$parentId = this.getParentId();
               Object other$parentId = other.getParentId();
               if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
                  Object this$fieldValue = this.getFieldValue();
                  Object other$fieldValue = other.getFieldValue();
                  if (this$fieldValue == null ? other$fieldValue == null : this$fieldValue.equals(other$fieldValue)) {
                     Object this$deptJson = this.getDeptJson();
                     Object other$deptJson = other.getDeptJson();
                     if (this$deptJson == null ? other$deptJson == null : this$deptJson.equals(other$deptJson)) {
                        Object this$list = this.getList();
                        Object other$list = other.getList();
                        return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof ContractFieldConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $fieldEnumType = this.getFieldEnumType();
      result = result * 59 + ($fieldEnumType == null ? 43 : $fieldEnumType.hashCode());
      Object $fieldSort = this.getFieldSort();
      result = result * 59 + ($fieldSort == null ? 43 : $fieldSort.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $fieldValue = this.getFieldValue();
      result = result * 59 + ($fieldValue == null ? 43 : $fieldValue.hashCode());
      Object $deptJson = this.getDeptJson();
      result = result * 59 + ($deptJson == null ? 43 : $deptJson.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "ContractFieldConfigDTOParam(id="
         + this.getId()
         + ", fieldEnumType="
         + this.getFieldEnumType()
         + ", fieldSort="
         + this.getFieldSort()
         + ", parentId="
         + this.getParentId()
         + ", fieldValue="
         + this.getFieldValue()
         + ", deptJson="
         + this.getDeptJson()
         + ", list="
         + this.getList()
         + ")";
   }

   public static class ContractFieldConfigDTOParamBuilder {
      private Long id;
      private Integer fieldEnumType;
      private Integer fieldSort;
      private Long parentId;
      private String fieldValue;
      private Map<String, BigDecimal> deptJson;
      private List<ContractFieldConfigDTOParam> list;

      ContractFieldConfigDTOParamBuilder() {
      }

      public ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder fieldEnumType(final Integer fieldEnumType) {
         this.fieldEnumType = fieldEnumType;
         return this;
      }

      public ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder fieldSort(final Integer fieldSort) {
         this.fieldSort = fieldSort;
         return this;
      }

      public ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder fieldValue(final String fieldValue) {
         this.fieldValue = fieldValue;
         return this;
      }

      public ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder deptJson(final Map<String, BigDecimal> deptJson) {
         this.deptJson = deptJson;
         return this;
      }

      public ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder list(final List<ContractFieldConfigDTOParam> list) {
         this.list = list;
         return this;
      }

      public ContractFieldConfigDTOParam build() {
         return new ContractFieldConfigDTOParam(this.id, this.fieldEnumType, this.fieldSort, this.parentId, this.fieldValue, this.deptJson, this.list);
      }

      @Override
      public String toString() {
         return "ContractFieldConfigDTOParam.ContractFieldConfigDTOParamBuilder(id="
            + this.id
            + ", fieldEnumType="
            + this.fieldEnumType
            + ", fieldSort="
            + this.fieldSort
            + ", parentId="
            + this.parentId
            + ", fieldValue="
            + this.fieldValue
            + ", deptJson="
            + this.deptJson
            + ", list="
            + this.list
            + ")";
      }
   }
}
