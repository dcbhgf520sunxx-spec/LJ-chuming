package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class SubjectTreeDTO implements Serializable {
   private Long id;
   private String name;
   private boolean boolLastEnum;
   @JsonInclude(Include.NON_NULL)
   private String code;
   @JsonInclude(Include.NON_NULL)
   private Integer basicClass;
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private List<SubjectTreeDTO> children;
   @ApiModelProperty("是否被钢材分类使用")
   private Boolean isUseSteel;
   private Integer classifyUpdateStatus;
   private Boolean boolStatus;

   SubjectTreeDTO(
      final Long id,
      final String name,
      final boolean boolLastEnum,
      final String code,
      final Integer basicClass,
      final String serialNumber,
      final List<SubjectTreeDTO> children,
      final Boolean isUseSteel,
      final Integer classifyUpdateStatus,
      final Boolean boolStatus
   ) {
      this.id = id;
      this.name = name;
      this.boolLastEnum = boolLastEnum;
      this.code = code;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.children = children;
      this.isUseSteel = isUseSteel;
      this.classifyUpdateStatus = classifyUpdateStatus;
      this.boolStatus = boolStatus;
   }

   public static SubjectTreeDTO.SubjectTreeDTOBuilder builder() {
      return new SubjectTreeDTO.SubjectTreeDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public boolean isBoolLastEnum() {
      return this.boolLastEnum;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<SubjectTreeDTO> getChildren() {
      return this.children;
   }

   public Boolean getIsUseSteel() {
      return this.isUseSteel;
   }

   public Integer getClassifyUpdateStatus() {
      return this.classifyUpdateStatus;
   }

   public Boolean getBoolStatus() {
      return this.boolStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBoolLastEnum(final boolean boolLastEnum) {
      this.boolLastEnum = boolLastEnum;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setChildren(final List<SubjectTreeDTO> children) {
      this.children = children;
   }

   public void setIsUseSteel(final Boolean isUseSteel) {
      this.isUseSteel = isUseSteel;
   }

   public void setClassifyUpdateStatus(final Integer classifyUpdateStatus) {
      this.classifyUpdateStatus = classifyUpdateStatus;
   }

   public void setBoolStatus(final Boolean boolStatus) {
      this.boolStatus = boolStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectTreeDTO)) {
         return false;
      }

      SubjectTreeDTO other = (SubjectTreeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolLastEnum() != other.isBoolLastEnum()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$isUseSteel = this.getIsUseSteel();
            Object other$isUseSteel = other.getIsUseSteel();
            if (this$isUseSteel == null ? other$isUseSteel == null : this$isUseSteel.equals(other$isUseSteel)) {
               Object this$classifyUpdateStatus = this.getClassifyUpdateStatus();
               Object other$classifyUpdateStatus = other.getClassifyUpdateStatus();
               if (this$classifyUpdateStatus == null ? other$classifyUpdateStatus == null : this$classifyUpdateStatus.equals(other$classifyUpdateStatus)) {
                  Object this$boolStatus = this.getBoolStatus();
                  Object other$boolStatus = other.getBoolStatus();
                  if (this$boolStatus == null ? other$boolStatus == null : this$boolStatus.equals(other$boolStatus)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$code = this.getCode();
                        Object other$code = other.getCode();
                        if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$children = this.getChildren();
                              Object other$children = other.getChildren();
                              return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof SubjectTreeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolLastEnum() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $isUseSteel = this.getIsUseSteel();
      result = result * 59 + ($isUseSteel == null ? 43 : $isUseSteel.hashCode());
      Object $classifyUpdateStatus = this.getClassifyUpdateStatus();
      result = result * 59 + ($classifyUpdateStatus == null ? 43 : $classifyUpdateStatus.hashCode());
      Object $boolStatus = this.getBoolStatus();
      result = result * 59 + ($boolStatus == null ? 43 : $boolStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectTreeDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", boolLastEnum="
         + this.isBoolLastEnum()
         + ", code="
         + this.getCode()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", children="
         + this.getChildren()
         + ", isUseSteel="
         + this.getIsUseSteel()
         + ", classifyUpdateStatus="
         + this.getClassifyUpdateStatus()
         + ", boolStatus="
         + this.getBoolStatus()
         + ")";
   }

   public static class SubjectTreeDTOBuilder {
      private Long id;
      private String name;
      private boolean boolLastEnum;
      private String code;
      private Integer basicClass;
      private String serialNumber;
      private List<SubjectTreeDTO> children;
      private Boolean isUseSteel;
      private Integer classifyUpdateStatus;
      private Boolean boolStatus;

      SubjectTreeDTOBuilder() {
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder boolLastEnum(final boolean boolLastEnum) {
         this.boolLastEnum = boolLastEnum;
         return this;
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder children(final List<SubjectTreeDTO> children) {
         this.children = children;
         return this;
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder isUseSteel(final Boolean isUseSteel) {
         this.isUseSteel = isUseSteel;
         return this;
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder classifyUpdateStatus(final Integer classifyUpdateStatus) {
         this.classifyUpdateStatus = classifyUpdateStatus;
         return this;
      }

      public SubjectTreeDTO.SubjectTreeDTOBuilder boolStatus(final Boolean boolStatus) {
         this.boolStatus = boolStatus;
         return this;
      }

      public SubjectTreeDTO build() {
         return new SubjectTreeDTO(
            this.id,
            this.name,
            this.boolLastEnum,
            this.code,
            this.basicClass,
            this.serialNumber,
            this.children,
            this.isUseSteel,
            this.classifyUpdateStatus,
            this.boolStatus
         );
      }

      @Override
      public String toString() {
         return "SubjectTreeDTO.SubjectTreeDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", boolLastEnum="
            + this.boolLastEnum
            + ", code="
            + this.code
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", children="
            + this.children
            + ", isUseSteel="
            + this.isUseSteel
            + ", classifyUpdateStatus="
            + this.classifyUpdateStatus
            + ", boolStatus="
            + this.boolStatus
            + ")";
      }
   }
}
