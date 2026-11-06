package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import io.swagger.annotations.ApiModelProperty;

public class CrmProjectInformationConfigUpdateParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称（建筑形式）", notes = "名称（建筑形式）")
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;

   public CrmProjectInformationConfigUpdateParam(final Long id, final String name, final Integer sort) {
      this.id = id;
      this.name = name;
      this.sort = sort;
   }

   public CrmProjectInformationConfigUpdateParam() {
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectInformationConfigUpdateParam)) {
         return false;
      }

      CrmProjectInformationConfigUpdateParam other = (CrmProjectInformationConfigUpdateParam)o;
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
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectInformationConfigUpdateParam;
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
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "CrmProjectInformationConfigUpdateParam(id=" + this.getId() + ", name=" + this.getName() + ", sort=" + this.getSort() + ")";
   }
}
