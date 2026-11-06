package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.io.Serializable;
import java.util.List;

public class SpecificationDTO implements Serializable {
   private Long id;
   private String name;
   private Boolean boolWeightedAverage;
   private Integer sort;
   private Long classificationId;
   private List<SpecificationDetailDTO> list;

   public static SpecificationDTO.SpecificationDTOBuilder builder() {
      return new SpecificationDTO.SpecificationDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolWeightedAverage() {
      return this.boolWeightedAverage;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public List<SpecificationDetailDTO> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBoolWeightedAverage(final Boolean boolWeightedAverage) {
      this.boolWeightedAverage = boolWeightedAverage;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
   }

   public void setList(final List<SpecificationDetailDTO> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpecificationDTO)) {
         return false;
      }

      SpecificationDTO other = (SpecificationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolWeightedAverage = this.getBoolWeightedAverage();
         Object other$boolWeightedAverage = other.getBoolWeightedAverage();
         if (this$boolWeightedAverage == null ? other$boolWeightedAverage == null : this$boolWeightedAverage.equals(other$boolWeightedAverage)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$classificationId = this.getClassificationId();
               Object other$classificationId = other.getClassificationId();
               if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
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
      return other instanceof SpecificationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolWeightedAverage = this.getBoolWeightedAverage();
      result = result * 59 + ($boolWeightedAverage == null ? 43 : $boolWeightedAverage.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "SpecificationDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", boolWeightedAverage="
         + this.getBoolWeightedAverage()
         + ", sort="
         + this.getSort()
         + ", classificationId="
         + this.getClassificationId()
         + ", list="
         + this.getList()
         + ")";
   }

   public SpecificationDTO(
      final Long id,
      final String name,
      final Boolean boolWeightedAverage,
      final Integer sort,
      final Long classificationId,
      final List<SpecificationDetailDTO> list
   ) {
      this.id = id;
      this.name = name;
      this.boolWeightedAverage = boolWeightedAverage;
      this.sort = sort;
      this.classificationId = classificationId;
      this.list = list;
   }

   public SpecificationDTO() {
   }

   public static class SpecificationDTOBuilder {
      private Long id;
      private String name;
      private Boolean boolWeightedAverage;
      private Integer sort;
      private Long classificationId;
      private List<SpecificationDetailDTO> list;

      SpecificationDTOBuilder() {
      }

      public SpecificationDTO.SpecificationDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SpecificationDTO.SpecificationDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SpecificationDTO.SpecificationDTOBuilder boolWeightedAverage(final Boolean boolWeightedAverage) {
         this.boolWeightedAverage = boolWeightedAverage;
         return this;
      }

      public SpecificationDTO.SpecificationDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SpecificationDTO.SpecificationDTOBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public SpecificationDTO.SpecificationDTOBuilder list(final List<SpecificationDetailDTO> list) {
         this.list = list;
         return this;
      }

      public SpecificationDTO build() {
         return new SpecificationDTO(this.id, this.name, this.boolWeightedAverage, this.sort, this.classificationId, this.list);
      }

      @Override
      public String toString() {
         return "SpecificationDTO.SpecificationDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", boolWeightedAverage="
            + this.boolWeightedAverage
            + ", sort="
            + this.sort
            + ", classificationId="
            + this.classificationId
            + ", list="
            + this.list
            + ")";
      }
   }
}
