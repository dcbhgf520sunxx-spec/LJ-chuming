package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.util.ArrayList;
import java.util.List;

public class SteelDensityClassTreeDTO {
   private Long id;
   private Long parentId;
   private Integer level;
   private String className;
   private Integer basicClass;
   private Boolean isDensityConfig;
   private List<SteelDensityClassTreeDTO> children = new ArrayList<>();

   public static SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder builder() {
      return new SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getClassName() {
      return this.className;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Boolean getIsDensityConfig() {
      return this.isDensityConfig;
   }

   public List<SteelDensityClassTreeDTO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setClassName(final String className) {
      this.className = className;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setIsDensityConfig(final Boolean isDensityConfig) {
      this.isDensityConfig = isDensityConfig;
   }

   public void setChildren(final List<SteelDensityClassTreeDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelDensityClassTreeDTO)) {
         return false;
      }

      SteelDensityClassTreeDTO other = (SteelDensityClassTreeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$parentId = this.getParentId();
         Object other$parentId = other.getParentId();
         if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
            Object this$level = this.getLevel();
            Object other$level = other.getLevel();
            if (this$level == null ? other$level == null : this$level.equals(other$level)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$isDensityConfig = this.getIsDensityConfig();
                  Object other$isDensityConfig = other.getIsDensityConfig();
                  if (this$isDensityConfig == null ? other$isDensityConfig == null : this$isDensityConfig.equals(other$isDensityConfig)) {
                     Object this$className = this.getClassName();
                     Object other$className = other.getClassName();
                     if (this$className == null ? other$className == null : this$className.equals(other$className)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelDensityClassTreeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $isDensityConfig = this.getIsDensityConfig();
      result = result * 59 + ($isDensityConfig == null ? 43 : $isDensityConfig.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SteelDensityClassTreeDTO(id="
         + this.getId()
         + ", parentId="
         + this.getParentId()
         + ", level="
         + this.getLevel()
         + ", className="
         + this.getClassName()
         + ", basicClass="
         + this.getBasicClass()
         + ", isDensityConfig="
         + this.getIsDensityConfig()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public SteelDensityClassTreeDTO(
      final Long id,
      final Long parentId,
      final Integer level,
      final String className,
      final Integer basicClass,
      final Boolean isDensityConfig,
      final List<SteelDensityClassTreeDTO> children
   ) {
      this.id = id;
      this.parentId = parentId;
      this.level = level;
      this.className = className;
      this.basicClass = basicClass;
      this.isDensityConfig = isDensityConfig;
      this.children = children;
   }

   public SteelDensityClassTreeDTO() {
   }

   public static class SteelDensityClassTreeDTOBuilder {
      private Long id;
      private Long parentId;
      private Integer level;
      private String className;
      private Integer basicClass;
      private Boolean isDensityConfig;
      private List<SteelDensityClassTreeDTO> children;

      SteelDensityClassTreeDTOBuilder() {
      }

      public SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder className(final String className) {
         this.className = className;
         return this;
      }

      public SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder isDensityConfig(final Boolean isDensityConfig) {
         this.isDensityConfig = isDensityConfig;
         return this;
      }

      public SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder children(final List<SteelDensityClassTreeDTO> children) {
         this.children = children;
         return this;
      }

      public SteelDensityClassTreeDTO build() {
         return new SteelDensityClassTreeDTO(this.id, this.parentId, this.level, this.className, this.basicClass, this.isDensityConfig, this.children);
      }

      @Override
      public String toString() {
         return "SteelDensityClassTreeDTO.SteelDensityClassTreeDTOBuilder(id="
            + this.id
            + ", parentId="
            + this.parentId
            + ", level="
            + this.level
            + ", className="
            + this.className
            + ", basicClass="
            + this.basicClass
            + ", isDensityConfig="
            + this.isDensityConfig
            + ", children="
            + this.children
            + ")";
      }
   }
}
