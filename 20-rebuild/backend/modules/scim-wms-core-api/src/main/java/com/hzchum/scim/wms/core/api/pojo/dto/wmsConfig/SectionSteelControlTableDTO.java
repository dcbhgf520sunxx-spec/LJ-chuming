package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class SectionSteelControlTableDTO {
   private Long id;
   private String name;
   private Set<String> mesSectionSpecifications;
   private Set<Long> wmsClassifyIds;
   private Map<String, BigDecimal> map;
   private String image;
   private String errorType;
   private Integer basicClass;
   private Integer mesProductEnum;

   SectionSteelControlTableDTO(
      final Long id,
      final String name,
      final Set<String> mesSectionSpecifications,
      final Set<Long> wmsClassifyIds,
      final Map<String, BigDecimal> map,
      final String image,
      final String errorType,
      final Integer basicClass,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.name = name;
      this.mesSectionSpecifications = mesSectionSpecifications;
      this.wmsClassifyIds = wmsClassifyIds;
      this.map = map;
      this.image = image;
      this.errorType = errorType;
      this.basicClass = basicClass;
      this.mesProductEnum = mesProductEnum;
   }

   public static SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder builder() {
      return new SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Set<String> getMesSectionSpecifications() {
      return this.mesSectionSpecifications;
   }

   public Set<Long> getWmsClassifyIds() {
      return this.wmsClassifyIds;
   }

   public Map<String, BigDecimal> getMap() {
      return this.map;
   }

   public String getImage() {
      return this.image;
   }

   public String getErrorType() {
      return this.errorType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMesSectionSpecifications(final Set<String> mesSectionSpecifications) {
      this.mesSectionSpecifications = mesSectionSpecifications;
   }

   public void setWmsClassifyIds(final Set<Long> wmsClassifyIds) {
      this.wmsClassifyIds = wmsClassifyIds;
   }

   public void setMap(final Map<String, BigDecimal> map) {
      this.map = map;
   }

   public void setImage(final String image) {
      this.image = image;
   }

   public void setErrorType(final String errorType) {
      this.errorType = errorType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelControlTableDTO)) {
         return false;
      }

      SectionSteelControlTableDTO other = (SectionSteelControlTableDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$mesProductEnum = this.getMesProductEnum();
            Object other$mesProductEnum = other.getMesProductEnum();
            if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$mesSectionSpecifications = this.getMesSectionSpecifications();
                  Object other$mesSectionSpecifications = other.getMesSectionSpecifications();
                  if (this$mesSectionSpecifications == null
                     ? other$mesSectionSpecifications == null
                     : this$mesSectionSpecifications.equals(other$mesSectionSpecifications)) {
                     Object this$wmsClassifyIds = this.getWmsClassifyIds();
                     Object other$wmsClassifyIds = other.getWmsClassifyIds();
                     if (this$wmsClassifyIds == null ? other$wmsClassifyIds == null : this$wmsClassifyIds.equals(other$wmsClassifyIds)) {
                        Object this$map = this.getMap();
                        Object other$map = other.getMap();
                        if (this$map == null ? other$map == null : this$map.equals(other$map)) {
                           Object this$image = this.getImage();
                           Object other$image = other.getImage();
                           if (this$image == null ? other$image == null : this$image.equals(other$image)) {
                              Object this$errorType = this.getErrorType();
                              Object other$errorType = other.getErrorType();
                              return this$errorType == null ? other$errorType == null : this$errorType.equals(other$errorType);
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
      return other instanceof SectionSteelControlTableDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $mesSectionSpecifications = this.getMesSectionSpecifications();
      result = result * 59 + ($mesSectionSpecifications == null ? 43 : $mesSectionSpecifications.hashCode());
      Object $wmsClassifyIds = this.getWmsClassifyIds();
      result = result * 59 + ($wmsClassifyIds == null ? 43 : $wmsClassifyIds.hashCode());
      Object $map = this.getMap();
      result = result * 59 + ($map == null ? 43 : $map.hashCode());
      Object $image = this.getImage();
      result = result * 59 + ($image == null ? 43 : $image.hashCode());
      Object $errorType = this.getErrorType();
      return result * 59 + ($errorType == null ? 43 : $errorType.hashCode());
   }

   @Override
   public String toString() {
      return "SectionSteelControlTableDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", mesSectionSpecifications="
         + this.getMesSectionSpecifications()
         + ", wmsClassifyIds="
         + this.getWmsClassifyIds()
         + ", map="
         + this.getMap()
         + ", image="
         + this.getImage()
         + ", errorType="
         + this.getErrorType()
         + ", basicClass="
         + this.getBasicClass()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   public static class SectionSteelControlTableDTOBuilder {
      private Long id;
      private String name;
      private Set<String> mesSectionSpecifications;
      private Set<Long> wmsClassifyIds;
      private Map<String, BigDecimal> map;
      private String image;
      private String errorType;
      private Integer basicClass;
      private Integer mesProductEnum;

      SectionSteelControlTableDTOBuilder() {
      }

      public SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder mesSectionSpecifications(final Set<String> mesSectionSpecifications) {
         this.mesSectionSpecifications = mesSectionSpecifications;
         return this;
      }

      public SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder wmsClassifyIds(final Set<Long> wmsClassifyIds) {
         this.wmsClassifyIds = wmsClassifyIds;
         return this;
      }

      public SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder map(final Map<String, BigDecimal> map) {
         this.map = map;
         return this;
      }

      public SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder image(final String image) {
         this.image = image;
         return this;
      }

      public SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder errorType(final String errorType) {
         this.errorType = errorType;
         return this;
      }

      public SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SectionSteelControlTableDTO build() {
         return new SectionSteelControlTableDTO(
            this.id, this.name, this.mesSectionSpecifications, this.wmsClassifyIds, this.map, this.image, this.errorType, this.basicClass, this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SectionSteelControlTableDTO.SectionSteelControlTableDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", mesSectionSpecifications="
            + this.mesSectionSpecifications
            + ", wmsClassifyIds="
            + this.wmsClassifyIds
            + ", map="
            + this.map
            + ", image="
            + this.image
            + ", errorType="
            + this.errorType
            + ", basicClass="
            + this.basicClass
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
