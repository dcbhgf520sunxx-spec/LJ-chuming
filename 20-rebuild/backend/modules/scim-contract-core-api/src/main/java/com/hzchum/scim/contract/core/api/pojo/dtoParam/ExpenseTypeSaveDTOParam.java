package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@ApiModel("费用支出类型 更新请求类")
public class ExpenseTypeSaveDTOParam {
   @NotBlank(message = "费用支出类型不能为空")
   @Length(message = "结构类型名称最大长度为64个字", max = 64)
   @ApiModelProperty(name = "name", value = "费用类型名称")
   private String name;
   @NotNull(message = "排序不能为空")
   @ApiModelProperty(name = "sort", value = "排序")
   private Integer sort;
   @ApiModelProperty(name = "dictionaryIdList", value = "关联字典id列表")
   private List<Long> dictionaryIdList;

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<Long> getDictionaryIdList() {
      return this.dictionaryIdList;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setDictionaryIdList(final List<Long> dictionaryIdList) {
      this.dictionaryIdList = dictionaryIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ExpenseTypeSaveDTOParam)) {
         return false;
      }

      ExpenseTypeSaveDTOParam other = (ExpenseTypeSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$dictionaryIdList = this.getDictionaryIdList();
            Object other$dictionaryIdList = other.getDictionaryIdList();
            return this$dictionaryIdList == null ? other$dictionaryIdList == null : this$dictionaryIdList.equals(other$dictionaryIdList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ExpenseTypeSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $dictionaryIdList = this.getDictionaryIdList();
      return result * 59 + ($dictionaryIdList == null ? 43 : $dictionaryIdList.hashCode());
   }

   @Override
   public String toString() {
      return "ExpenseTypeSaveDTOParam(name=" + this.getName() + ", sort=" + this.getSort() + ", dictionaryIdList=" + this.getDictionaryIdList() + ")";
   }
}
