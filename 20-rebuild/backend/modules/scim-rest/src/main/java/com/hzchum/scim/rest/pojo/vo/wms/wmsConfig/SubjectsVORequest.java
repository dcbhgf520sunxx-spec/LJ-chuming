package com.hzchum.scim.rest.pojo.vo.wms.wmsConfig;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

public class SubjectsVORequest implements Serializable {
   private static final long serialVersionUID = 2784149675942454536L;
   private Long parentId;
   @NotBlank(message = "名称不能为空")
   private String name;
   @NotBlank(message = "代码不能为空")
   private String code;
   private Integer basicClass;

   public static SubjectsVORequest.SubjectsVORequestBuilder builder() {
      return new SubjectsVORequest.SubjectsVORequestBuilder();
   }

   public Long getParentId() {
      return this.parentId;
   }

   public String getName() {
      return this.name;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectsVORequest)) {
         return false;
      }

      SubjectsVORequest other = (SubjectsVORequest)o;
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
      return other instanceof SubjectsVORequest;
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
      return "SubjectsVORequest(parentId="
         + this.getParentId()
         + ", name="
         + this.getName()
         + ", code="
         + this.getCode()
         + ", basicClass="
         + this.getBasicClass()
         + ")";
   }

   public SubjectsVORequest(final Long parentId, final String name, final String code, final Integer basicClass) {
      this.parentId = parentId;
      this.name = name;
      this.code = code;
      this.basicClass = basicClass;
   }

   public SubjectsVORequest() {
   }

   public static class SubjectsVORequestBuilder {
      private Long parentId;
      private String name;
      private String code;
      private Integer basicClass;

      SubjectsVORequestBuilder() {
      }

      public SubjectsVORequest.SubjectsVORequestBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public SubjectsVORequest.SubjectsVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubjectsVORequest.SubjectsVORequestBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public SubjectsVORequest.SubjectsVORequestBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SubjectsVORequest build() {
         return new SubjectsVORequest(this.parentId, this.name, this.code, this.basicClass);
      }

      @Override
      public String toString() {
         return "SubjectsVORequest.SubjectsVORequestBuilder(parentId="
            + this.parentId
            + ", name="
            + this.name
            + ", code="
            + this.code
            + ", basicClass="
            + this.basicClass
            + ")";
      }
   }
}
