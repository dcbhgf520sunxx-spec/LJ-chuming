package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.CappCraftCardDictEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@ApiModel(description = "CAPP 工艺卡字典项 新增 请求参数")
public class CappCraftCardDictItemSaveDTO {
   @ApiModelProperty(name = "dictType", value = "字典类型", notes = "字典类型")
   @NotBlank(message = "字典类型不能为空")
   @EnumValidator(value = CappCraftCardDictEnum.class, message = "字典类型不在有效范围内")
   private String dictType;
   @ApiModelProperty(name = "items", value = "字典值列表", notes = "字典值列表")
   @NotEmpty(message = "字典值列表不能为空")
   private List<CappCraftCardDictItemSaveDTO.@Valid Item> items;

   public String getDictType() {
      return this.dictType;
   }

   public List<CappCraftCardDictItemSaveDTO.@Valid Item> getItems() {
      return this.items;
   }

   public void setDictType(final String dictType) {
      this.dictType = dictType;
   }

   public void setItems(final List<CappCraftCardDictItemSaveDTO.@Valid Item> items) {
      this.items = items;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CappCraftCardDictItemSaveDTO)) {
         return false;
      } else {
         CappCraftCardDictItemSaveDTO other = (CappCraftCardDictItemSaveDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$dictType = this.getDictType();
            Object other$dictType = other.getDictType();
            if (this$dictType == null ? other$dictType == null : this$dictType.equals(other$dictType)) {
               Object this$items = this.getItems();
               Object other$items = other.getItems();
               return this$items == null ? other$items == null : this$items.equals(other$items);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardDictItemSaveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dictType = this.getDictType();
      result = result * 59 + ($dictType == null ? 43 : $dictType.hashCode());
      Object $items = this.getItems();
      return result * 59 + ($items == null ? 43 : $items.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardDictItemSaveDTO(dictType=" + this.getDictType() + ", items=" + this.getItems() + ")";
   }

   public static class Item {
      @ApiModelProperty(name = "dictValue", value = "字典值", notes = "字典值")
      @NotBlank(message = "字典值不能为空")
      @Length(max = 256, message = "字典值长度不能超过256")
      private String dictValue;
      @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
      private Integer sort;
      @ApiModelProperty(name = "enabledFlag", value = "是否启用：0 未启用；1 启用", notes = "是否启用：0 未启用；1 启用")
      @NotNull(message = "是否启用不能为空")
      private Boolean enabledFlag;

      public String getDictValue() {
         return this.dictValue;
      }

      public Integer getSort() {
         return this.sort;
      }

      public Boolean getEnabledFlag() {
         return this.enabledFlag;
      }

      public void setDictValue(final String dictValue) {
         this.dictValue = dictValue;
      }

      public void setSort(final Integer sort) {
         this.sort = sort;
      }

      public void setEnabledFlag(final Boolean enabledFlag) {
         this.enabledFlag = enabledFlag;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof CappCraftCardDictItemSaveDTO.Item)) {
            return false;
         }

         CappCraftCardDictItemSaveDTO.Item other = (CappCraftCardDictItemSaveDTO.Item)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$enabledFlag = this.getEnabledFlag();
            Object other$enabledFlag = other.getEnabledFlag();
            if (this$enabledFlag == null ? other$enabledFlag == null : this$enabledFlag.equals(other$enabledFlag)) {
               Object this$dictValue = this.getDictValue();
               Object other$dictValue = other.getDictValue();
               return this$dictValue == null ? other$dictValue == null : this$dictValue.equals(other$dictValue);
            } else {
               return false;
            }
         } else {
            return false;
         }
      }

      protected boolean canEqual(final Object other) {
         return other instanceof CappCraftCardDictItemSaveDTO.Item;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $sort = this.getSort();
         result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
         Object $enabledFlag = this.getEnabledFlag();
         result = result * 59 + ($enabledFlag == null ? 43 : $enabledFlag.hashCode());
         Object $dictValue = this.getDictValue();
         return result * 59 + ($dictValue == null ? 43 : $dictValue.hashCode());
      }

      @Override
      public String toString() {
         return "CappCraftCardDictItemSaveDTO.Item(dictValue="
            + this.getDictValue()
            + ", sort="
            + this.getSort()
            + ", enabledFlag="
            + this.getEnabledFlag()
            + ")";
      }
   }
}
