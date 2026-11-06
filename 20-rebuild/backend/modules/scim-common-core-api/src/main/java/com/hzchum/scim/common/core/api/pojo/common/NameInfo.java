package com.hzchum.scim.common.core.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

public class NameInfo {
   private Long id;
   private String name;
   @JsonInclude(Include.NON_NULL)
   private List<NameInfo> nameInfos;

   public static NameInfo.NameInfoBuilder builder() {
      return new NameInfo.NameInfoBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<NameInfo> getNameInfos() {
      return this.nameInfos;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setNameInfos(final List<NameInfo> nameInfos) {
      this.nameInfos = nameInfos;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NameInfo)) {
         return false;
      }

      NameInfo other = (NameInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$nameInfos = this.getNameInfos();
            Object other$nameInfos = other.getNameInfos();
            return this$nameInfos == null ? other$nameInfos == null : this$nameInfos.equals(other$nameInfos);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NameInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $nameInfos = this.getNameInfos();
      return result * 59 + ($nameInfos == null ? 43 : $nameInfos.hashCode());
   }

   @Override
   public String toString() {
      return "NameInfo(id=" + this.getId() + ", name=" + this.getName() + ", nameInfos=" + this.getNameInfos() + ")";
   }

   public NameInfo() {
   }

   public NameInfo(final Long id, final String name, final List<NameInfo> nameInfos) {
      this.id = id;
      this.name = name;
      this.nameInfos = nameInfos;
   }

   public static class NameInfoBuilder {
      private Long id;
      private String name;
      private List<NameInfo> nameInfos;

      NameInfoBuilder() {
      }

      public NameInfo.NameInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public NameInfo.NameInfoBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public NameInfo.NameInfoBuilder nameInfos(final List<NameInfo> nameInfos) {
         this.nameInfos = nameInfos;
         return this;
      }

      public NameInfo build() {
         return new NameInfo(this.id, this.name, this.nameInfos);
      }

      @Override
      public String toString() {
         return "NameInfo.NameInfoBuilder(id=" + this.id + ", name=" + this.name + ", nameInfos=" + this.nameInfos + ")";
      }
   }
}
