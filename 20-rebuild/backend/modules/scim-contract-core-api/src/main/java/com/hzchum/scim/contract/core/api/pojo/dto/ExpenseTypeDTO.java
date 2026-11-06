package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.DictionaryInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("费用分类")
public class ExpenseTypeDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "分类名称")
   private String name;
   @ApiModelProperty(name = "sort", value = "排序")
   private Integer sort;
   @ApiModelProperty(name = "links", value = "字典表的id和label")
   private List<DictionaryInfo> links;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<DictionaryInfo> getLinks() {
      return this.links;
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

   public void setLinks(final List<DictionaryInfo> links) {
      this.links = links;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ExpenseTypeDTO)) {
         return false;
      }

      ExpenseTypeDTO other = (ExpenseTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$links = this.getLinks();
               Object other$links = other.getLinks();
               return this$links == null ? other$links == null : this$links.equals(other$links);
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
      return other instanceof ExpenseTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $links = this.getLinks();
      return result * 59 + ($links == null ? 43 : $links.hashCode());
   }

   @Override
   public String toString() {
      return "ExpenseTypeDTO(id=" + this.getId() + ", name=" + this.getName() + ", sort=" + this.getSort() + ", links=" + this.getLinks() + ")";
   }
}
