package com.hzchum.scim.scm.core.api.pojo.dto;

public class SupplierAllBriefDTO {
   private Long id;
   private Long annualContractId;
   private String name;
   private String shortName;
   private Integer type;
   private Integer basicClass;
   private Boolean boolHide;
   private Boolean boolAnnualEvaluated;
   private Long classifyId;
   private Long qualificationsId;

   public static SupplierAllBriefDTO.SupplierAllBriefDTOBuilder builder() {
      return new SupplierAllBriefDTO.SupplierAllBriefDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getAnnualContractId() {
      return this.annualContractId;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Boolean getBoolHide() {
      return this.boolHide;
   }

   public Boolean getBoolAnnualEvaluated() {
      return this.boolAnnualEvaluated;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getQualificationsId() {
      return this.qualificationsId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAnnualContractId(final Long annualContractId) {
      this.annualContractId = annualContractId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBoolHide(final Boolean boolHide) {
      this.boolHide = boolHide;
   }

   public void setBoolAnnualEvaluated(final Boolean boolAnnualEvaluated) {
      this.boolAnnualEvaluated = boolAnnualEvaluated;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setQualificationsId(final Long qualificationsId) {
      this.qualificationsId = qualificationsId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierAllBriefDTO)) {
         return false;
      }

      SupplierAllBriefDTO other = (SupplierAllBriefDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$annualContractId = this.getAnnualContractId();
         Object other$annualContractId = other.getAnnualContractId();
         if (this$annualContractId == null ? other$annualContractId == null : this$annualContractId.equals(other$annualContractId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$boolHide = this.getBoolHide();
                  Object other$boolHide = other.getBoolHide();
                  if (this$boolHide == null ? other$boolHide == null : this$boolHide.equals(other$boolHide)) {
                     Object this$boolAnnualEvaluated = this.getBoolAnnualEvaluated();
                     Object other$boolAnnualEvaluated = other.getBoolAnnualEvaluated();
                     if (this$boolAnnualEvaluated == null ? other$boolAnnualEvaluated == null : this$boolAnnualEvaluated.equals(other$boolAnnualEvaluated)) {
                        Object this$classifyId = this.getClassifyId();
                        Object other$classifyId = other.getClassifyId();
                        if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                           Object this$qualificationsId = this.getQualificationsId();
                           Object other$qualificationsId = other.getQualificationsId();
                           if (this$qualificationsId == null ? other$qualificationsId == null : this$qualificationsId.equals(other$qualificationsId)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$shortName = this.getShortName();
                                 Object other$shortName = other.getShortName();
                                 return this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName);
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
      return other instanceof SupplierAllBriefDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $annualContractId = this.getAnnualContractId();
      result = result * 59 + ($annualContractId == null ? 43 : $annualContractId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolHide = this.getBoolHide();
      result = result * 59 + ($boolHide == null ? 43 : $boolHide.hashCode());
      Object $boolAnnualEvaluated = this.getBoolAnnualEvaluated();
      result = result * 59 + ($boolAnnualEvaluated == null ? 43 : $boolAnnualEvaluated.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $qualificationsId = this.getQualificationsId();
      result = result * 59 + ($qualificationsId == null ? 43 : $qualificationsId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      return result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierAllBriefDTO(id="
         + this.getId()
         + ", annualContractId="
         + this.getAnnualContractId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", type="
         + this.getType()
         + ", basicClass="
         + this.getBasicClass()
         + ", boolHide="
         + this.getBoolHide()
         + ", boolAnnualEvaluated="
         + this.getBoolAnnualEvaluated()
         + ", classifyId="
         + this.getClassifyId()
         + ", qualificationsId="
         + this.getQualificationsId()
         + ")";
   }

   public SupplierAllBriefDTO(
      final Long id,
      final Long annualContractId,
      final String name,
      final String shortName,
      final Integer type,
      final Integer basicClass,
      final Boolean boolHide,
      final Boolean boolAnnualEvaluated,
      final Long classifyId,
      final Long qualificationsId
   ) {
      this.id = id;
      this.annualContractId = annualContractId;
      this.name = name;
      this.shortName = shortName;
      this.type = type;
      this.basicClass = basicClass;
      this.boolHide = boolHide;
      this.boolAnnualEvaluated = boolAnnualEvaluated;
      this.classifyId = classifyId;
      this.qualificationsId = qualificationsId;
   }

   public SupplierAllBriefDTO() {
   }

   public static class SupplierAllBriefDTOBuilder {
      private Long id;
      private Long annualContractId;
      private String name;
      private String shortName;
      private Integer type;
      private Integer basicClass;
      private Boolean boolHide;
      private Boolean boolAnnualEvaluated;
      private Long classifyId;
      private Long qualificationsId;

      SupplierAllBriefDTOBuilder() {
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder annualContractId(final Long annualContractId) {
         this.annualContractId = annualContractId;
         return this;
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder boolHide(final Boolean boolHide) {
         this.boolHide = boolHide;
         return this;
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder boolAnnualEvaluated(final Boolean boolAnnualEvaluated) {
         this.boolAnnualEvaluated = boolAnnualEvaluated;
         return this;
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public SupplierAllBriefDTO.SupplierAllBriefDTOBuilder qualificationsId(final Long qualificationsId) {
         this.qualificationsId = qualificationsId;
         return this;
      }

      public SupplierAllBriefDTO build() {
         return new SupplierAllBriefDTO(
            this.id,
            this.annualContractId,
            this.name,
            this.shortName,
            this.type,
            this.basicClass,
            this.boolHide,
            this.boolAnnualEvaluated,
            this.classifyId,
            this.qualificationsId
         );
      }

      @Override
      public String toString() {
         return "SupplierAllBriefDTO.SupplierAllBriefDTOBuilder(id="
            + this.id
            + ", annualContractId="
            + this.annualContractId
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", type="
            + this.type
            + ", basicClass="
            + this.basicClass
            + ", boolHide="
            + this.boolHide
            + ", boolAnnualEvaluated="
            + this.boolAnnualEvaluated
            + ", classifyId="
            + this.classifyId
            + ", qualificationsId="
            + this.qualificationsId
            + ")";
      }
   }
}
