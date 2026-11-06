package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.util.List;

public class MaterialWarehouseDTOParam {
   private Long id;
   private String name;
   private List<Long> classifyIds;
   private Integer basicClass;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialWarehouseDTOParam)) {
         return false;
      }

      MaterialWarehouseDTOParam other = (MaterialWarehouseDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$classifyIds = this.getClassifyIds();
               Object other$classifyIds = other.getClassifyIds();
               return this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds);
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
      return other instanceof MaterialWarehouseDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $classifyIds = this.getClassifyIds();
      return result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialWarehouseDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", basicClass="
         + this.getBasicClass()
         + ")";
   }

   public MaterialWarehouseDTOParam(final Long id, final String name, final List<Long> classifyIds, final Integer basicClass) {
      this.id = id;
      this.name = name;
      this.classifyIds = classifyIds;
      this.basicClass = basicClass;
   }

   public MaterialWarehouseDTOParam() {
   }
}
