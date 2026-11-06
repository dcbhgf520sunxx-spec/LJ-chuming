package com.hzchum.scim.common.core.api.pojo.dto.oa;

import java.util.Objects;

public class CompositeKey {
   private final Long deptId;
   private final String name;

   public CompositeKey(Long deptId, String name) {
      this.deptId = deptId;
      this.name = name;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         CompositeKey that = (CompositeKey)o;
         return Objects.equals(this.deptId, that.deptId) && Objects.equals(this.name, that.name);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.deptId, this.name);
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getName() {
      return this.name;
   }

   @Override
   public String toString() {
      return "CompositeKey(deptId=" + this.getDeptId() + ", name=" + this.getName() + ")";
   }
}
