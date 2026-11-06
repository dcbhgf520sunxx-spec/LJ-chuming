package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@ApiModel("单体简单信息")
public class PlanMonomerSimpleDTO {
   @ApiModelProperty(name = "id", notes = "单体ID")
   private Long id;
   @ApiModelProperty(name = "name", notes = "单体名称")
   private String name;
   @ApiModelProperty(name = "date", notes = "单体完成日期")
   private LocalDate date;
   @ApiModelProperty(name = "productTypeList", value = "产品类型列表")
   private List<Map<String, Object>> productTypeList;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public List<Map<String, Object>> getProductTypeList() {
      return this.productTypeList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setProductTypeList(final List<Map<String, Object>> productTypeList) {
      this.productTypeList = productTypeList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanMonomerSimpleDTO)) {
         return false;
      }

      PlanMonomerSimpleDTO other = (PlanMonomerSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$productTypeList = this.getProductTypeList();
               Object other$productTypeList = other.getProductTypeList();
               return this$productTypeList == null ? other$productTypeList == null : this$productTypeList.equals(other$productTypeList);
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
      return other instanceof PlanMonomerSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $productTypeList = this.getProductTypeList();
      return result * 59 + ($productTypeList == null ? 43 : $productTypeList.hashCode());
   }

   @Override
   public String toString() {
      return "PlanMonomerSimpleDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", productTypeList="
         + this.getProductTypeList()
         + ")";
   }
}
