package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@ApiModel(description = "CAPP 工艺卡字典项 修改 请求参数")
public class CappCraftCardDictItemUpdateDTO {
   @ApiModelProperty(name = "id", value = "CAPP 工艺卡字典项 id", notes = "CAPP 工艺卡字典项 id")
   @NotNull(message = "字典值id不能为空")
   private Long id;
   @ApiModelProperty(name = "dictValue", value = "字典值", notes = "字典值")
   @NotBlank(message = "字典值不能为空")
   @Length(max = 256, message = "字典值长度不能超过256")
   private String dictValue;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;
   @ApiModelProperty(name = "enabledFlag", value = "是否启用：0 未启用；1 启用", notes = "是否启用：0 未启用；1 启用")
   @NotNull(message = "是否启用不能为空")
   private Boolean enabledFlag;

   public Long getId() {
      return this.id;
   }

   public String getDictValue() {
      return this.dictValue;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getEnabledFlag() {
      return this.enabledFlag;
   }

   public void setId(final Long id) {
      this.id = id;
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

      if (!(o instanceof CappCraftCardDictItemUpdateDTO)) {
         return false;
      }

      CappCraftCardDictItemUpdateDTO other = (CappCraftCardDictItemUpdateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardDictItemUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enabledFlag = this.getEnabledFlag();
      result = result * 59 + ($enabledFlag == null ? 43 : $enabledFlag.hashCode());
      Object $dictValue = this.getDictValue();
      return result * 59 + ($dictValue == null ? 43 : $dictValue.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardDictItemUpdateDTO(id="
         + this.getId()
         + ", dictValue="
         + this.getDictValue()
         + ", sort="
         + this.getSort()
         + ", enabledFlag="
         + this.getEnabledFlag()
         + ")";
   }
}
