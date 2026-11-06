package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.ExpenseTypeCategoryEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@ApiModel("费用支出类型 更新请求类")
public class ExpenseTypeUpdateDTOParam {
   @NotNull(message = "id不能为空")
   @ApiModelProperty(name = "id", value = "费用类型id")
   private Long id;
   @NotBlank(message = "费用支出类型不能为空")
   @Length(message = "结构类型名称最大长度为64个字", max = 64)
   @ApiModelProperty(name = "name", value = "费用类型名称")
   private String name;
   @NotNull(message = "排序不能为空")
   @ApiModelProperty(name = "sort", value = "排序")
   private Integer sort;
   @NotEmpty(message = "费用明细不能为空")
   @ApiModelProperty(name = "dictionaryIdList", value = "关联字典id列表")
   private List<Long> dictionaryIdList;
   @ApiModelProperty("类别")
   @NotNull(message = "类别不能为空")
   @EnumValidator(value = ExpenseTypeCategoryEnum.class, message = "类别不存在")
   private Integer category;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<Long> getDictionaryIdList() {
      return this.dictionaryIdList;
   }

   public Integer getCategory() {
      return this.category;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setCategory(final Integer category) {
      this.category = category;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ExpenseTypeUpdateDTOParam)) {
         return false;
      }

      ExpenseTypeUpdateDTOParam other = (ExpenseTypeUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ExpenseTypeUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $dictionaryIdList = this.getDictionaryIdList();
      return result * 59 + ($dictionaryIdList == null ? 43 : $dictionaryIdList.hashCode());
   }

   @Override
   public String toString() {
      return "ExpenseTypeUpdateDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", dictionaryIdList="
         + this.getDictionaryIdList()
         + ", category="
         + this.getCategory()
         + ")";
   }
}
