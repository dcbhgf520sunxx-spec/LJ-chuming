package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SpecificationDTOParam {
   private Long id;
   @NotEmpty(message = "规格名称不为能空")
   private String name;
   private Integer sort;
   @NotNull(message = "科目ID不能为空")
   private Long classificationId;
   @NotNull(message = "参与平均价类型不为能空")
   private Boolean boolWeightedAverage;
   private List<SpecificationDetailDTOParam> list;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public Boolean getBoolWeightedAverage() {
      return this.boolWeightedAverage;
   }

   public List<SpecificationDetailDTOParam> getList() {
      return this.list;
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

   public void setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
   }

   public void setBoolWeightedAverage(final Boolean boolWeightedAverage) {
      this.boolWeightedAverage = boolWeightedAverage;
   }

   public void setList(final List<SpecificationDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpecificationDTOParam)) {
         return false;
      }

      SpecificationDTOParam other = (SpecificationDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$classificationId = this.getClassificationId();
            Object other$classificationId = other.getClassificationId();
            if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
               Object this$boolWeightedAverage = this.getBoolWeightedAverage();
               Object other$boolWeightedAverage = other.getBoolWeightedAverage();
               if (this$boolWeightedAverage == null ? other$boolWeightedAverage == null : this$boolWeightedAverage.equals(other$boolWeightedAverage)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SpecificationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $boolWeightedAverage = this.getBoolWeightedAverage();
      result = result * 59 + ($boolWeightedAverage == null ? 43 : $boolWeightedAverage.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "SpecificationDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", classificationId="
         + this.getClassificationId()
         + ", boolWeightedAverage="
         + this.getBoolWeightedAverage()
         + ", list="
         + this.getList()
         + ")";
   }
}
