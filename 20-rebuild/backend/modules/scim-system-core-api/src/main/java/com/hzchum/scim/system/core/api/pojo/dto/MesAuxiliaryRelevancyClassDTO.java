package com.hzchum.scim.system.core.api.pojo.dto;

public class MesAuxiliaryRelevancyClassDTO {
   private Long id;
   private Long classifyId;
   private String classifyName;
   private Long auxiliaryId;
   private String auxiliaryName;

   MesAuxiliaryRelevancyClassDTO(final Long id, final Long classifyId, final String classifyName, final Long auxiliaryId, final String auxiliaryName) {
      this.id = id;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.auxiliaryId = auxiliaryId;
      this.auxiliaryName = auxiliaryName;
   }

   public static MesAuxiliaryRelevancyClassDTO.MesAuxiliaryRelevancyClassDTOBuilder builder() {
      return new MesAuxiliaryRelevancyClassDTO.MesAuxiliaryRelevancyClassDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Long getAuxiliaryId() {
      return this.auxiliaryId;
   }

   public String getAuxiliaryName() {
      return this.auxiliaryName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setAuxiliaryId(final Long auxiliaryId) {
      this.auxiliaryId = auxiliaryId;
   }

   public void setAuxiliaryName(final String auxiliaryName) {
      this.auxiliaryName = auxiliaryName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAuxiliaryRelevancyClassDTO)) {
         return false;
      }

      MesAuxiliaryRelevancyClassDTO other = (MesAuxiliaryRelevancyClassDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$auxiliaryId = this.getAuxiliaryId();
            Object other$auxiliaryId = other.getAuxiliaryId();
            if (this$auxiliaryId == null ? other$auxiliaryId == null : this$auxiliaryId.equals(other$auxiliaryId)) {
               Object this$classifyName = this.getClassifyName();
               Object other$classifyName = other.getClassifyName();
               if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                  Object this$auxiliaryName = this.getAuxiliaryName();
                  Object other$auxiliaryName = other.getAuxiliaryName();
                  return this$auxiliaryName == null ? other$auxiliaryName == null : this$auxiliaryName.equals(other$auxiliaryName);
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
      return other instanceof MesAuxiliaryRelevancyClassDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $auxiliaryId = this.getAuxiliaryId();
      result = result * 59 + ($auxiliaryId == null ? 43 : $auxiliaryId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $auxiliaryName = this.getAuxiliaryName();
      return result * 59 + ($auxiliaryName == null ? 43 : $auxiliaryName.hashCode());
   }

   @Override
   public String toString() {
      return "MesAuxiliaryRelevancyClassDTO(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", auxiliaryId="
         + this.getAuxiliaryId()
         + ", auxiliaryName="
         + this.getAuxiliaryName()
         + ")";
   }

   public static class MesAuxiliaryRelevancyClassDTOBuilder {
      private Long id;
      private Long classifyId;
      private String classifyName;
      private Long auxiliaryId;
      private String auxiliaryName;

      MesAuxiliaryRelevancyClassDTOBuilder() {
      }

      public MesAuxiliaryRelevancyClassDTO.MesAuxiliaryRelevancyClassDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesAuxiliaryRelevancyClassDTO.MesAuxiliaryRelevancyClassDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public MesAuxiliaryRelevancyClassDTO.MesAuxiliaryRelevancyClassDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public MesAuxiliaryRelevancyClassDTO.MesAuxiliaryRelevancyClassDTOBuilder auxiliaryId(final Long auxiliaryId) {
         this.auxiliaryId = auxiliaryId;
         return this;
      }

      public MesAuxiliaryRelevancyClassDTO.MesAuxiliaryRelevancyClassDTOBuilder auxiliaryName(final String auxiliaryName) {
         this.auxiliaryName = auxiliaryName;
         return this;
      }

      public MesAuxiliaryRelevancyClassDTO build() {
         return new MesAuxiliaryRelevancyClassDTO(this.id, this.classifyId, this.classifyName, this.auxiliaryId, this.auxiliaryName);
      }

      @Override
      public String toString() {
         return "MesAuxiliaryRelevancyClassDTO.MesAuxiliaryRelevancyClassDTOBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", auxiliaryId="
            + this.auxiliaryId
            + ", auxiliaryName="
            + this.auxiliaryName
            + ")";
      }
   }
}
