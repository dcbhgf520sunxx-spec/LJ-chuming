package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SpecConfigDTO;
import java.util.List;

public class ClassifySpecDTO {
   private Long id;
   private String name;
   private String fullName;
   private List<Long> fullPathId;
   private String serialNumber;
   private Integer basicClass;
   private String measureUnit;
   private Integer measurePrecision;
   private String accountingUnit;
   private Integer accountingPrecision;
   private Integer outboundUnitType;
   private List<SpecConfigDTO> nationalStandard;
   private List<SpecConfigDTO> specConfig;

   public static ClassifySpecDTO.ClassifySpecDTOBuilder builder() {
      return new ClassifySpecDTO.ClassifySpecDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getFullName() {
      return this.fullName;
   }

   public List<Long> getFullPathId() {
      return this.fullPathId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public List<SpecConfigDTO> getNationalStandard() {
      return this.nationalStandard;
   }

   public List<SpecConfigDTO> getSpecConfig() {
      return this.specConfig;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setFullName(final String fullName) {
      this.fullName = fullName;
   }

   public void setFullPathId(final List<Long> fullPathId) {
      this.fullPathId = fullPathId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
   }

   public void setNationalStandard(final List<SpecConfigDTO> nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setSpecConfig(final List<SpecConfigDTO> specConfig) {
      this.specConfig = specConfig;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClassifySpecDTO)) {
         return false;
      }

      ClassifySpecDTO other = (ClassifySpecDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$measurePrecision = this.getMeasurePrecision();
            Object other$measurePrecision = other.getMeasurePrecision();
            if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
               Object this$accountingPrecision = this.getAccountingPrecision();
               Object other$accountingPrecision = other.getAccountingPrecision();
               if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                  Object this$outboundUnitType = this.getOutboundUnitType();
                  Object other$outboundUnitType = other.getOutboundUnitType();
                  if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$fullName = this.getFullName();
                        Object other$fullName = other.getFullName();
                        if (this$fullName == null ? other$fullName == null : this$fullName.equals(other$fullName)) {
                           Object this$fullPathId = this.getFullPathId();
                           Object other$fullPathId = other.getFullPathId();
                           if (this$fullPathId == null ? other$fullPathId == null : this$fullPathId.equals(other$fullPathId)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$measureUnit = this.getMeasureUnit();
                                 Object other$measureUnit = other.getMeasureUnit();
                                 if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                    Object this$accountingUnit = this.getAccountingUnit();
                                    Object other$accountingUnit = other.getAccountingUnit();
                                    if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                       Object this$nationalStandard = this.getNationalStandard();
                                       Object other$nationalStandard = other.getNationalStandard();
                                       if (this$nationalStandard == null
                                          ? other$nationalStandard == null
                                          : this$nationalStandard.equals(other$nationalStandard)) {
                                          Object this$specConfig = this.getSpecConfig();
                                          Object other$specConfig = other.getSpecConfig();
                                          return this$specConfig == null ? other$specConfig == null : this$specConfig.equals(other$specConfig);
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
      return other instanceof ClassifySpecDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $fullName = this.getFullName();
      result = result * 59 + ($fullName == null ? 43 : $fullName.hashCode());
      Object $fullPathId = this.getFullPathId();
      result = result * 59 + ($fullPathId == null ? 43 : $fullPathId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $specConfig = this.getSpecConfig();
      return result * 59 + ($specConfig == null ? 43 : $specConfig.hashCode());
   }

   @Override
   public String toString() {
      return "ClassifySpecDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", fullName="
         + this.getFullName()
         + ", fullPathId="
         + this.getFullPathId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", specConfig="
         + this.getSpecConfig()
         + ")";
   }

   public ClassifySpecDTO(
      final Long id,
      final String name,
      final String fullName,
      final List<Long> fullPathId,
      final String serialNumber,
      final Integer basicClass,
      final String measureUnit,
      final Integer measurePrecision,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer outboundUnitType,
      final List<SpecConfigDTO> nationalStandard,
      final List<SpecConfigDTO> specConfig
   ) {
      this.id = id;
      this.name = name;
      this.fullName = fullName;
      this.fullPathId = fullPathId;
      this.serialNumber = serialNumber;
      this.basicClass = basicClass;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.outboundUnitType = outboundUnitType;
      this.nationalStandard = nationalStandard;
      this.specConfig = specConfig;
   }

   public ClassifySpecDTO() {
   }

   public static class ClassifySpecDTOBuilder {
      private Long id;
      private String name;
      private String fullName;
      private List<Long> fullPathId;
      private String serialNumber;
      private Integer basicClass;
      private String measureUnit;
      private Integer measurePrecision;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer outboundUnitType;
      private List<SpecConfigDTO> nationalStandard;
      private List<SpecConfigDTO> specConfig;

      ClassifySpecDTOBuilder() {
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder fullName(final String fullName) {
         this.fullName = fullName;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder fullPathId(final List<Long> fullPathId) {
         this.fullPathId = fullPathId;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder nationalStandard(final List<SpecConfigDTO> nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public ClassifySpecDTO.ClassifySpecDTOBuilder specConfig(final List<SpecConfigDTO> specConfig) {
         this.specConfig = specConfig;
         return this;
      }

      public ClassifySpecDTO build() {
         return new ClassifySpecDTO(
            this.id,
            this.name,
            this.fullName,
            this.fullPathId,
            this.serialNumber,
            this.basicClass,
            this.measureUnit,
            this.measurePrecision,
            this.accountingUnit,
            this.accountingPrecision,
            this.outboundUnitType,
            this.nationalStandard,
            this.specConfig
         );
      }

      @Override
      public String toString() {
         return "ClassifySpecDTO.ClassifySpecDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", fullName="
            + this.fullName
            + ", fullPathId="
            + this.fullPathId
            + ", serialNumber="
            + this.serialNumber
            + ", basicClass="
            + this.basicClass
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", nationalStandard="
            + this.nationalStandard
            + ", specConfig="
            + this.specConfig
            + ")";
      }
   }
}
