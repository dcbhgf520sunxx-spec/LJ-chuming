package com.hzchum.scim.system.core.api.pojo.dto;

import java.time.LocalDateTime;

public class SysDictionaryDetailDTO {
   private Long id;
   private String name;
   private String remark;
   private String label;
   private String value;
   private Integer sort;
   private LocalDateTime createTime;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getLabel() {
      return this.label;
   }

   public String getValue() {
      return this.value;
   }

   public Integer getSort() {
      return this.sort;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysDictionaryDetailDTO)) {
         return false;
      }

      SysDictionaryDetailDTO other = (SysDictionaryDetailDTO)o;
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
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                  Object this$label = this.getLabel();
                  Object other$label = other.getLabel();
                  if (this$label == null ? other$label == null : this$label.equals(other$label)) {
                     Object this$value = this.getValue();
                     Object other$value = other.getValue();
                     if (this$value == null ? other$value == null : this$value.equals(other$value)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof SysDictionaryDetailDTO;
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
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "SysDictionaryDetailDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", remark="
         + this.getRemark()
         + ", label="
         + this.getLabel()
         + ", value="
         + this.getValue()
         + ", sort="
         + this.getSort()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }
}
