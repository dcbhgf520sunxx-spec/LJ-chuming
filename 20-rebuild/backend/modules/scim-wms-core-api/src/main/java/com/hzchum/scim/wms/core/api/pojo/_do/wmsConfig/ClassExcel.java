package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ClassExcel {
   @Excel(name = "名称")
   private String name;
   @Excel(name = "代码")
   private String code;
   @Excel(name = "父级")
   private Long parentId;
   @Excel(name = "类型")
   private Integer basicClass;

   public static ClassExcel.ClassExcelBuilder builder() {
      return new ClassExcel.ClassExcelBuilder();
   }

   public String getName() {
      return this.name;
   }

   public String getCode() {
      return this.code;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClassExcel)) {
         return false;
      }

      ClassExcel other = (ClassExcel)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$parentId = this.getParentId();
      Object other$parentId = other.getParentId();
      if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$code = this.getCode();
               Object other$code = other.getCode();
               return this$code == null ? other$code == null : this$code.equals(other$code);
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
      return other instanceof ClassExcel;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "ClassExcel(name="
         + this.getName()
         + ", code="
         + this.getCode()
         + ", parentId="
         + this.getParentId()
         + ", basicClass="
         + this.getBasicClass()
         + ")";
   }

   public ClassExcel(final String name, final String code, final Long parentId, final Integer basicClass) {
      this.name = name;
      this.code = code;
      this.parentId = parentId;
      this.basicClass = basicClass;
   }

   public ClassExcel() {
   }

   public static class ClassExcelBuilder {
      private String name;
      private String code;
      private Long parentId;
      private Integer basicClass;

      ClassExcelBuilder() {
      }

      public ClassExcel.ClassExcelBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ClassExcel.ClassExcelBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public ClassExcel.ClassExcelBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public ClassExcel.ClassExcelBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ClassExcel build() {
         return new ClassExcel(this.name, this.code, this.parentId, this.basicClass);
      }

      @Override
      public String toString() {
         return "ClassExcel.ClassExcelBuilder(name="
            + this.name
            + ", code="
            + this.code
            + ", parentId="
            + this.parentId
            + ", basicClass="
            + this.basicClass
            + ")";
      }
   }
}
