package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.util.List;

public class SubjectDetailDTO {
   private Long subjectId;
   private String path;
   private Boolean boolLastEnum;
   private Integer level;
   private Long parentId;
   private String name;
   private Integer basicClass;
   private String code;
   private String serialNumber;
   private List<SpecificationDTO> specifications;
   private Long measureId;
   private String measureUnit;
   private Integer measureDecimalPrecision;
   private String accountingUnit;
   private Integer accountingDecimalPrecision;
   private String outMode;

   public static SubjectDetailDTO.SubjectDetailDTOBuilder builder() {
      return new SubjectDetailDTO.SubjectDetailDTOBuilder();
   }

   public Long getSubjectId() {
      return this.subjectId;
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

   public List<SpecificationDTO> getSpecifications() {
      return this.specifications;
   }

   public Long getMeasureId() {
      return this.measureId;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasureDecimalPrecision() {
      return this.measureDecimalPrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingDecimalPrecision() {
      return this.accountingDecimalPrecision;
   }

   public String getOutMode() {
      return this.outMode;
   }

   public void setSubjectId(final Long subjectId) {
      this.subjectId = subjectId;
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

   public void setSpecifications(final List<SpecificationDTO> specifications) {
      this.specifications = specifications;
   }

   public void setMeasureId(final Long measureId) {
      this.measureId = measureId;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasureDecimalPrecision(final Integer measureDecimalPrecision) {
      this.measureDecimalPrecision = measureDecimalPrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingDecimalPrecision(final Integer accountingDecimalPrecision) {
      this.accountingDecimalPrecision = accountingDecimalPrecision;
   }

   public void setOutMode(final String outMode) {
      this.outMode = outMode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectDetailDTO)) {
         return false;
      }

      SubjectDetailDTO other = (SubjectDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$subjectId = this.getSubjectId();
      Object other$subjectId = other.getSubjectId();
      if (this$subjectId == null ? other$subjectId == null : this$subjectId.equals(other$subjectId)) {
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
                     Object this$measureId = this.getMeasureId();
                     Object other$measureId = other.getMeasureId();
                     if (this$measureId == null ? other$measureId == null : this$measureId.equals(other$measureId)) {
                        Object this$measureDecimalPrecision = this.getMeasureDecimalPrecision();
                        Object other$measureDecimalPrecision = other.getMeasureDecimalPrecision();
                        if (this$measureDecimalPrecision == null
                           ? other$measureDecimalPrecision == null
                           : this$measureDecimalPrecision.equals(other$measureDecimalPrecision)) {
                           Object this$accountingDecimalPrecision = this.getAccountingDecimalPrecision();
                           Object other$accountingDecimalPrecision = other.getAccountingDecimalPrecision();
                           if (this$accountingDecimalPrecision == null
                              ? other$accountingDecimalPrecision == null
                              : this$accountingDecimalPrecision.equals(other$accountingDecimalPrecision)) {
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
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$specifications = this.getSpecifications();
                                          Object other$specifications = other.getSpecifications();
                                          if (this$specifications == null ? other$specifications == null : this$specifications.equals(other$specifications)) {
                                             Object this$measureUnit = this.getMeasureUnit();
                                             Object other$measureUnit = other.getMeasureUnit();
                                             if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                Object this$accountingUnit = this.getAccountingUnit();
                                                Object other$accountingUnit = other.getAccountingUnit();
                                                if (this$accountingUnit == null
                                                   ? other$accountingUnit == null
                                                   : this$accountingUnit.equals(other$accountingUnit)) {
                                                   Object this$outMode = this.getOutMode();
                                                   Object other$outMode = other.getOutMode();
                                                   return this$outMode == null ? other$outMode == null : this$outMode.equals(other$outMode);
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
      return other instanceof SubjectDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $subjectId = this.getSubjectId();
      result = result * 59 + ($subjectId == null ? 43 : $subjectId.hashCode());
      Object $boolLastEnum = this.getBoolLastEnum();
      result = result * 59 + ($boolLastEnum == null ? 43 : $boolLastEnum.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $measureId = this.getMeasureId();
      result = result * 59 + ($measureId == null ? 43 : $measureId.hashCode());
      Object $measureDecimalPrecision = this.getMeasureDecimalPrecision();
      result = result * 59 + ($measureDecimalPrecision == null ? 43 : $measureDecimalPrecision.hashCode());
      Object $accountingDecimalPrecision = this.getAccountingDecimalPrecision();
      result = result * 59 + ($accountingDecimalPrecision == null ? 43 : $accountingDecimalPrecision.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specifications = this.getSpecifications();
      result = result * 59 + ($specifications == null ? 43 : $specifications.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $outMode = this.getOutMode();
      return result * 59 + ($outMode == null ? 43 : $outMode.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectDetailDTO(subjectId="
         + this.getSubjectId()
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
         + ", specifications="
         + this.getSpecifications()
         + ", measureId="
         + this.getMeasureId()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measureDecimalPrecision="
         + this.getMeasureDecimalPrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingDecimalPrecision="
         + this.getAccountingDecimalPrecision()
         + ", outMode="
         + this.getOutMode()
         + ")";
   }

   public SubjectDetailDTO(
      final Long subjectId,
      final String path,
      final Boolean boolLastEnum,
      final Integer level,
      final Long parentId,
      final String name,
      final Integer basicClass,
      final String code,
      final String serialNumber,
      final List<SpecificationDTO> specifications,
      final Long measureId,
      final String measureUnit,
      final Integer measureDecimalPrecision,
      final String accountingUnit,
      final Integer accountingDecimalPrecision,
      final String outMode
   ) {
      this.subjectId = subjectId;
      this.path = path;
      this.boolLastEnum = boolLastEnum;
      this.level = level;
      this.parentId = parentId;
      this.name = name;
      this.basicClass = basicClass;
      this.code = code;
      this.serialNumber = serialNumber;
      this.specifications = specifications;
      this.measureId = measureId;
      this.measureUnit = measureUnit;
      this.measureDecimalPrecision = measureDecimalPrecision;
      this.accountingUnit = accountingUnit;
      this.accountingDecimalPrecision = accountingDecimalPrecision;
      this.outMode = outMode;
   }

   public SubjectDetailDTO() {
   }

   public static class SubjectDetailDTOBuilder {
      private Long subjectId;
      private String path;
      private Boolean boolLastEnum;
      private Integer level;
      private Long parentId;
      private String name;
      private Integer basicClass;
      private String code;
      private String serialNumber;
      private List<SpecificationDTO> specifications;
      private Long measureId;
      private String measureUnit;
      private Integer measureDecimalPrecision;
      private String accountingUnit;
      private Integer accountingDecimalPrecision;
      private String outMode;

      SubjectDetailDTOBuilder() {
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder subjectId(final Long subjectId) {
         this.subjectId = subjectId;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder boolLastEnum(final Boolean boolLastEnum) {
         this.boolLastEnum = boolLastEnum;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder specifications(final List<SpecificationDTO> specifications) {
         this.specifications = specifications;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder measureId(final Long measureId) {
         this.measureId = measureId;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder measureDecimalPrecision(final Integer measureDecimalPrecision) {
         this.measureDecimalPrecision = measureDecimalPrecision;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder accountingDecimalPrecision(final Integer accountingDecimalPrecision) {
         this.accountingDecimalPrecision = accountingDecimalPrecision;
         return this;
      }

      public SubjectDetailDTO.SubjectDetailDTOBuilder outMode(final String outMode) {
         this.outMode = outMode;
         return this;
      }

      public SubjectDetailDTO build() {
         return new SubjectDetailDTO(
            this.subjectId,
            this.path,
            this.boolLastEnum,
            this.level,
            this.parentId,
            this.name,
            this.basicClass,
            this.code,
            this.serialNumber,
            this.specifications,
            this.measureId,
            this.measureUnit,
            this.measureDecimalPrecision,
            this.accountingUnit,
            this.accountingDecimalPrecision,
            this.outMode
         );
      }

      @Override
      public String toString() {
         return "SubjectDetailDTO.SubjectDetailDTOBuilder(subjectId="
            + this.subjectId
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
            + ", specifications="
            + this.specifications
            + ", measureId="
            + this.measureId
            + ", measureUnit="
            + this.measureUnit
            + ", measureDecimalPrecision="
            + this.measureDecimalPrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingDecimalPrecision="
            + this.accountingDecimalPrecision
            + ", outMode="
            + this.outMode
            + ")";
      }
   }
}
