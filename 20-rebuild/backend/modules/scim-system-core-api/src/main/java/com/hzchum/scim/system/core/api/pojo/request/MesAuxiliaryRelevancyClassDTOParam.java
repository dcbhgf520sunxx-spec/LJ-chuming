package com.hzchum.scim.system.core.api.pojo.request;

public class MesAuxiliaryRelevancyClassDTOParam {
   private Long id;
   private Long classifyId;
   private String classifyName;
   private Long auxiliaryId;

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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAuxiliaryRelevancyClassDTOParam)) {
         return false;
      }

      MesAuxiliaryRelevancyClassDTOParam other = (MesAuxiliaryRelevancyClassDTOParam)o;
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
               return this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName);
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
      return other instanceof MesAuxiliaryRelevancyClassDTOParam;
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
      return result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
   }

   @Override
   public String toString() {
      return "MesAuxiliaryRelevancyClassDTOParam(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", auxiliaryId="
         + this.getAuxiliaryId()
         + ")";
   }
}
