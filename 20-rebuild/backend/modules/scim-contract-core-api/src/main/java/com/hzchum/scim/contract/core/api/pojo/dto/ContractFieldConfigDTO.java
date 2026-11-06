package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ContractFieldConfigDTO {
   @ApiModelProperty(notes = "字段ID")
   private Long id;
   @ApiModelProperty(notes = "字段枚举值")
   private Integer fieldEnumType;
   @ApiModelProperty(notes = "字段枚举值名称")
   private String fieldEnumName;
   @ApiModelProperty(notes = "排序")
   private Integer fieldSort;
   @ApiModelProperty(notes = "所属一级部门ID")
   private Long parentId;
   @ApiModelProperty(notes = "所属一级部门名称")
   private String firstLevelDeptName;
   @ApiModelProperty(notes = "字段可选值")
   private String fieldValue;
   @ApiModelProperty(notes = "所属部门的JSON")
   private Map<String, BigDecimal> deptJson;
   @ApiModelProperty(notes = "集合")
   private List<ContractFieldConfigDTO> list;

   ContractFieldConfigDTO(
      final Long id,
      final Integer fieldEnumType,
      final String fieldEnumName,
      final Integer fieldSort,
      final Long parentId,
      final String firstLevelDeptName,
      final String fieldValue,
      final Map<String, BigDecimal> deptJson,
      final List<ContractFieldConfigDTO> list
   ) {
      this.id = id;
      this.fieldEnumType = fieldEnumType;
      this.fieldEnumName = fieldEnumName;
      this.fieldSort = fieldSort;
      this.parentId = parentId;
      this.firstLevelDeptName = firstLevelDeptName;
      this.fieldValue = fieldValue;
      this.deptJson = deptJson;
      this.list = list;
   }

   public static ContractFieldConfigDTO.ContractFieldConfigDTOBuilder builder() {
      return new ContractFieldConfigDTO.ContractFieldConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getFieldEnumType() {
      return this.fieldEnumType;
   }

   public String getFieldEnumName() {
      return this.fieldEnumName;
   }

   public Integer getFieldSort() {
      return this.fieldSort;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public String getFirstLevelDeptName() {
      return this.firstLevelDeptName;
   }

   public String getFieldValue() {
      return this.fieldValue;
   }

   public Map<String, BigDecimal> getDeptJson() {
      return this.deptJson;
   }

   public List<ContractFieldConfigDTO> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFieldEnumType(final Integer fieldEnumType) {
      this.fieldEnumType = fieldEnumType;
   }

   public void setFieldEnumName(final String fieldEnumName) {
      this.fieldEnumName = fieldEnumName;
   }

   public void setFieldSort(final Integer fieldSort) {
      this.fieldSort = fieldSort;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setFirstLevelDeptName(final String firstLevelDeptName) {
      this.firstLevelDeptName = firstLevelDeptName;
   }

   public void setFieldValue(final String fieldValue) {
      this.fieldValue = fieldValue;
   }

   public void setDeptJson(final Map<String, BigDecimal> deptJson) {
      this.deptJson = deptJson;
   }

   public void setList(final List<ContractFieldConfigDTO> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractFieldConfigDTO)) {
         return false;
      }

      ContractFieldConfigDTO other = (ContractFieldConfigDTO)o;
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
                  Object this$fieldEnumName = this.getFieldEnumName();
                  Object other$fieldEnumName = other.getFieldEnumName();
                  if (this$fieldEnumName == null ? other$fieldEnumName == null : this$fieldEnumName.equals(other$fieldEnumName)) {
                     Object this$firstLevelDeptName = this.getFirstLevelDeptName();
                     Object other$firstLevelDeptName = other.getFirstLevelDeptName();
                     if (this$firstLevelDeptName == null ? other$firstLevelDeptName == null : this$firstLevelDeptName.equals(other$firstLevelDeptName)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractFieldConfigDTO;
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
      Object $fieldEnumName = this.getFieldEnumName();
      result = result * 59 + ($fieldEnumName == null ? 43 : $fieldEnumName.hashCode());
      Object $firstLevelDeptName = this.getFirstLevelDeptName();
      result = result * 59 + ($firstLevelDeptName == null ? 43 : $firstLevelDeptName.hashCode());
      Object $fieldValue = this.getFieldValue();
      result = result * 59 + ($fieldValue == null ? 43 : $fieldValue.hashCode());
      Object $deptJson = this.getDeptJson();
      result = result * 59 + ($deptJson == null ? 43 : $deptJson.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "ContractFieldConfigDTO(id="
         + this.getId()
         + ", fieldEnumType="
         + this.getFieldEnumType()
         + ", fieldEnumName="
         + this.getFieldEnumName()
         + ", fieldSort="
         + this.getFieldSort()
         + ", parentId="
         + this.getParentId()
         + ", firstLevelDeptName="
         + this.getFirstLevelDeptName()
         + ", fieldValue="
         + this.getFieldValue()
         + ", deptJson="
         + this.getDeptJson()
         + ", list="
         + this.getList()
         + ")";
   }

   public static class ContractFieldConfigDTOBuilder {
      private Long id;
      private Integer fieldEnumType;
      private String fieldEnumName;
      private Integer fieldSort;
      private Long parentId;
      private String firstLevelDeptName;
      private String fieldValue;
      private Map<String, BigDecimal> deptJson;
      private List<ContractFieldConfigDTO> list;

      ContractFieldConfigDTOBuilder() {
      }

      public ContractFieldConfigDTO.ContractFieldConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractFieldConfigDTO.ContractFieldConfigDTOBuilder fieldEnumType(final Integer fieldEnumType) {
         this.fieldEnumType = fieldEnumType;
         return this;
      }

      public ContractFieldConfigDTO.ContractFieldConfigDTOBuilder fieldEnumName(final String fieldEnumName) {
         this.fieldEnumName = fieldEnumName;
         return this;
      }

      public ContractFieldConfigDTO.ContractFieldConfigDTOBuilder fieldSort(final Integer fieldSort) {
         this.fieldSort = fieldSort;
         return this;
      }

      public ContractFieldConfigDTO.ContractFieldConfigDTOBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public ContractFieldConfigDTO.ContractFieldConfigDTOBuilder firstLevelDeptName(final String firstLevelDeptName) {
         this.firstLevelDeptName = firstLevelDeptName;
         return this;
      }

      public ContractFieldConfigDTO.ContractFieldConfigDTOBuilder fieldValue(final String fieldValue) {
         this.fieldValue = fieldValue;
         return this;
      }

      public ContractFieldConfigDTO.ContractFieldConfigDTOBuilder deptJson(final Map<String, BigDecimal> deptJson) {
         this.deptJson = deptJson;
         return this;
      }

      public ContractFieldConfigDTO.ContractFieldConfigDTOBuilder list(final List<ContractFieldConfigDTO> list) {
         this.list = list;
         return this;
      }

      public ContractFieldConfigDTO build() {
         return new ContractFieldConfigDTO(
            this.id, this.fieldEnumType, this.fieldEnumName, this.fieldSort, this.parentId, this.firstLevelDeptName, this.fieldValue, this.deptJson, this.list
         );
      }

      @Override
      public String toString() {
         return "ContractFieldConfigDTO.ContractFieldConfigDTOBuilder(id="
            + this.id
            + ", fieldEnumType="
            + this.fieldEnumType
            + ", fieldEnumName="
            + this.fieldEnumName
            + ", fieldSort="
            + this.fieldSort
            + ", parentId="
            + this.parentId
            + ", firstLevelDeptName="
            + this.firstLevelDeptName
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
