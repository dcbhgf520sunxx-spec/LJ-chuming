package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

public class ClassificationDTOParam implements Serializable {
   private Long id;
   private String path;
   private Boolean boolLastEnum;
   private Integer level;
   private Long parentId;
   @NotBlank(message = "名称不能为空")
   private String name;
   private Integer basicClass;
   @NotBlank(message = "代码不能为空")
   private String code;
   private String serialNumber;
   private Boolean boolStatus;

   public static ClassificationDTOParam.ClassificationDTOParamBuilder builder() {
      return new ClassificationDTOParam.ClassificationDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getPath() {
      return this.path;
   }

   public Boolean getBoolLastEnum() {
      return this.boolLastEnum;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getCode() {
      return this.code;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Boolean getBoolStatus() {
      return this.boolStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setBoolLastEnum(final Boolean boolLastEnum) {
      this.boolLastEnum = boolLastEnum;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setBoolStatus(final Boolean boolStatus) {
      this.boolStatus = boolStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClassificationDTOParam)) {
         return false;
      }

      ClassificationDTOParam other = (ClassificationDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolLastEnum = this.getBoolLastEnum();
         Object other$boolLastEnum = other.getBoolLastEnum();
         if (this$boolLastEnum == null ? other$boolLastEnum == null : this$boolLastEnum.equals(other$boolLastEnum)) {
            Object this$level = this.getLevel();
            Object other$level = other.getLevel();
            if (this$level == null ? other$level == null : this$level.equals(other$level)) {
               Object this$parentId = this.getParentId();
               Object other$parentId = other.getParentId();
               if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$boolStatus = this.getBoolStatus();
                     Object other$boolStatus = other.getBoolStatus();
                     if (this$boolStatus == null ? other$boolStatus == null : this$boolStatus.equals(other$boolStatus)) {
                        Object this$path = this.getPath();
                        Object other$path = other.getPath();
                        if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$code = this.getCode();
                              Object other$code = other.getCode();
                              if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof ClassificationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolLastEnum = this.getBoolLastEnum();
      result = result * 59 + ($boolLastEnum == null ? 43 : $boolLastEnum.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolStatus = this.getBoolStatus();
      result = result * 59 + ($boolStatus == null ? 43 : $boolStatus.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ClassificationDTOParam(id="
         + this.getId()
         + ", path="
         + this.getPath()
         + ", boolLastEnum="
         + this.getBoolLastEnum()
         + ", level="
         + this.getLevel()
         + ", parentId="
         + this.getParentId()
         + ", name="
         + this.getName()
         + ", basicClass="
         + this.getBasicClass()
         + ", code="
         + this.getCode()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", boolStatus="
         + this.getBoolStatus()
         + ")";
   }

   public ClassificationDTOParam(
      final Long id,
      final String path,
      final Boolean boolLastEnum,
      final Integer level,
      final Long parentId,
      final String name,
      final Integer basicClass,
      final String code,
      final String serialNumber,
      final Boolean boolStatus
   ) {
      this.id = id;
      this.path = path;
      this.boolLastEnum = boolLastEnum;
      this.level = level;
      this.parentId = parentId;
      this.name = name;
      this.basicClass = basicClass;
      this.code = code;
      this.serialNumber = serialNumber;
      this.boolStatus = boolStatus;
   }

   public ClassificationDTOParam() {
   }

   public static class ClassificationDTOParamBuilder {
      private Long id;
      private String path;
      private Boolean boolLastEnum;
      private Integer level;
      private Long parentId;
      private String name;
      private Integer basicClass;
      private String code;
      private String serialNumber;
      private Boolean boolStatus;

      ClassificationDTOParamBuilder() {
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder boolLastEnum(final Boolean boolLastEnum) {
         this.boolLastEnum = boolLastEnum;
         return this;
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ClassificationDTOParam.ClassificationDTOParamBuilder boolStatus(final Boolean boolStatus) {
         this.boolStatus = boolStatus;
         return this;
      }

      public ClassificationDTOParam build() {
         return new ClassificationDTOParam(
            this.id, this.path, this.boolLastEnum, this.level, this.parentId, this.name, this.basicClass, this.code, this.serialNumber, this.boolStatus
         );
      }

      @Override
      public String toString() {
         return "ClassificationDTOParam.ClassificationDTOParamBuilder(id="
            + this.id
            + ", path="
            + this.path
            + ", boolLastEnum="
            + this.boolLastEnum
            + ", level="
            + this.level
            + ", parentId="
            + this.parentId
            + ", name="
            + this.name
            + ", basicClass="
            + this.basicClass
            + ", code="
            + this.code
            + ", serialNumber="
            + this.serialNumber
            + ", boolStatus="
            + this.boolStatus
            + ")";
      }
   }
}
