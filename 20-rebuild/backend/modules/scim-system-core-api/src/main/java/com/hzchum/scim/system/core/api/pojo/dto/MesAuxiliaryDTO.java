package com.hzchum.scim.system.core.api.pojo.dto;

import java.math.BigDecimal;
import java.util.List;

public class MesAuxiliaryDTO {
   private Long id;
   private List<String> auxiliaryNameList;
   private String accountingUnit;
   private Integer basicClass;
   private BigDecimal meteDiff;
   private List<MesAuxiliaryRelevancyClassDTO> mesAuxiliaryRelevancyClassDTOS;

   public static MesAuxiliaryDTO.MesAuxiliaryDTOBuilder builder() {
      return new MesAuxiliaryDTO.MesAuxiliaryDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<String> getAuxiliaryNameList() {
      return this.auxiliaryNameList;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getMeteDiff() {
      return this.meteDiff;
   }

   public List<MesAuxiliaryRelevancyClassDTO> getMesAuxiliaryRelevancyClassDTOS() {
      return this.mesAuxiliaryRelevancyClassDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuxiliaryNameList(final List<String> auxiliaryNameList) {
      this.auxiliaryNameList = auxiliaryNameList;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMeteDiff(final BigDecimal meteDiff) {
      this.meteDiff = meteDiff;
   }

   public void setMesAuxiliaryRelevancyClassDTOS(final List<MesAuxiliaryRelevancyClassDTO> mesAuxiliaryRelevancyClassDTOS) {
      this.mesAuxiliaryRelevancyClassDTOS = mesAuxiliaryRelevancyClassDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAuxiliaryDTO)) {
         return false;
      }

      MesAuxiliaryDTO other = (MesAuxiliaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$auxiliaryNameList = this.getAuxiliaryNameList();
            Object other$auxiliaryNameList = other.getAuxiliaryNameList();
            if (this$auxiliaryNameList == null ? other$auxiliaryNameList == null : this$auxiliaryNameList.equals(other$auxiliaryNameList)) {
               Object this$accountingUnit = this.getAccountingUnit();
               Object other$accountingUnit = other.getAccountingUnit();
               if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                  Object this$meteDiff = this.getMeteDiff();
                  Object other$meteDiff = other.getMeteDiff();
                  if (this$meteDiff == null ? other$meteDiff == null : this$meteDiff.equals(other$meteDiff)) {
                     Object this$mesAuxiliaryRelevancyClassDTOS = this.getMesAuxiliaryRelevancyClassDTOS();
                     Object other$mesAuxiliaryRelevancyClassDTOS = other.getMesAuxiliaryRelevancyClassDTOS();
                     return this$mesAuxiliaryRelevancyClassDTOS == null
                        ? other$mesAuxiliaryRelevancyClassDTOS == null
                        : this$mesAuxiliaryRelevancyClassDTOS.equals(other$mesAuxiliaryRelevancyClassDTOS);
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
      return other instanceof MesAuxiliaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $auxiliaryNameList = this.getAuxiliaryNameList();
      result = result * 59 + ($auxiliaryNameList == null ? 43 : $auxiliaryNameList.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $meteDiff = this.getMeteDiff();
      result = result * 59 + ($meteDiff == null ? 43 : $meteDiff.hashCode());
      Object $mesAuxiliaryRelevancyClassDTOS = this.getMesAuxiliaryRelevancyClassDTOS();
      return result * 59 + ($mesAuxiliaryRelevancyClassDTOS == null ? 43 : $mesAuxiliaryRelevancyClassDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "MesAuxiliaryDTO(id="
         + this.getId()
         + ", auxiliaryNameList="
         + this.getAuxiliaryNameList()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", basicClass="
         + this.getBasicClass()
         + ", meteDiff="
         + this.getMeteDiff()
         + ", mesAuxiliaryRelevancyClassDTOS="
         + this.getMesAuxiliaryRelevancyClassDTOS()
         + ")";
   }

   public MesAuxiliaryDTO(
      final Long id,
      final List<String> auxiliaryNameList,
      final String accountingUnit,
      final Integer basicClass,
      final BigDecimal meteDiff,
      final List<MesAuxiliaryRelevancyClassDTO> mesAuxiliaryRelevancyClassDTOS
   ) {
      this.id = id;
      this.auxiliaryNameList = auxiliaryNameList;
      this.accountingUnit = accountingUnit;
      this.basicClass = basicClass;
      this.meteDiff = meteDiff;
      this.mesAuxiliaryRelevancyClassDTOS = mesAuxiliaryRelevancyClassDTOS;
   }

   public MesAuxiliaryDTO() {
   }

   public static class MesAuxiliaryDTOBuilder {
      private Long id;
      private List<String> auxiliaryNameList;
      private String accountingUnit;
      private Integer basicClass;
      private BigDecimal meteDiff;
      private List<MesAuxiliaryRelevancyClassDTO> mesAuxiliaryRelevancyClassDTOS;

      MesAuxiliaryDTOBuilder() {
      }

      public MesAuxiliaryDTO.MesAuxiliaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesAuxiliaryDTO.MesAuxiliaryDTOBuilder auxiliaryNameList(final List<String> auxiliaryNameList) {
         this.auxiliaryNameList = auxiliaryNameList;
         return this;
      }

      public MesAuxiliaryDTO.MesAuxiliaryDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public MesAuxiliaryDTO.MesAuxiliaryDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MesAuxiliaryDTO.MesAuxiliaryDTOBuilder meteDiff(final BigDecimal meteDiff) {
         this.meteDiff = meteDiff;
         return this;
      }

      public MesAuxiliaryDTO.MesAuxiliaryDTOBuilder mesAuxiliaryRelevancyClassDTOS(final List<MesAuxiliaryRelevancyClassDTO> mesAuxiliaryRelevancyClassDTOS) {
         this.mesAuxiliaryRelevancyClassDTOS = mesAuxiliaryRelevancyClassDTOS;
         return this;
      }

      public MesAuxiliaryDTO build() {
         return new MesAuxiliaryDTO(this.id, this.auxiliaryNameList, this.accountingUnit, this.basicClass, this.meteDiff, this.mesAuxiliaryRelevancyClassDTOS);
      }

      @Override
      public String toString() {
         return "MesAuxiliaryDTO.MesAuxiliaryDTOBuilder(id="
            + this.id
            + ", auxiliaryNameList="
            + this.auxiliaryNameList
            + ", accountingUnit="
            + this.accountingUnit
            + ", basicClass="
            + this.basicClass
            + ", meteDiff="
            + this.meteDiff
            + ", mesAuxiliaryRelevancyClassDTOS="
            + this.mesAuxiliaryRelevancyClassDTOS
            + ")";
      }
   }
}
