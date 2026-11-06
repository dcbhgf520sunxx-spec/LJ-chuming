package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import java.util.List;

public class SubjectSpecMeasureDTO {
   private Long subjectId;
   @JsonInclude(Include.NON_NULL)
   private String path;
   @JsonInclude(Include.NON_NULL)
   private Boolean boolLastEnum;
   @JsonInclude(Include.NON_NULL)
   private Integer level;
   @JsonInclude(Include.NON_NULL)
   private Long parentId;
   @JsonInclude(Include.NON_NULL)
   private String name;
   @JsonInclude(Include.NON_NULL)
   private Integer basicClass;
   @JsonInclude(Include.NON_NULL)
   private String code;
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private List<SpecificationDTO> specifications;
   @JsonInclude(Include.NON_NULL)
   private Long metrologyId;
   @JsonInclude(Include.NON_NULL)
   private String measureUnit;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal measureDecimalPrecision;
   @JsonInclude(Include.NON_NULL)
   private String accountingUnit;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal accountingDecimalPrecision;
   @JsonInclude(Include.NON_NULL)
   private String outboundMethod;
   private List<SubjectSpecMeasureDTO> children;

   SubjectSpecMeasureDTO(
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
      final Long metrologyId,
      final String measureUnit,
      final BigDecimal measureDecimalPrecision,
      final String accountingUnit,
      final BigDecimal accountingDecimalPrecision,
      final String outboundMethod,
      final List<SubjectSpecMeasureDTO> children
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
      this.metrologyId = metrologyId;
      this.measureUnit = measureUnit;
      this.measureDecimalPrecision = measureDecimalPrecision;
      this.accountingUnit = accountingUnit;
      this.accountingDecimalPrecision = accountingDecimalPrecision;
      this.outboundMethod = outboundMethod;
      this.children = children;
   }

   public static SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder builder() {
      return new SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder();
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

   public Long getMetrologyId() {
      return this.metrologyId;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMeasureDecimalPrecision() {
      return this.measureDecimalPrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getAccountingDecimalPrecision() {
      return this.accountingDecimalPrecision;
   }

   public String getOutboundMethod() {
      return this.outboundMethod;
   }

   public List<SubjectSpecMeasureDTO> getChildren() {
      return this.children;
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

   public void setMetrologyId(final Long metrologyId) {
      this.metrologyId = metrologyId;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasureDecimalPrecision(final BigDecimal measureDecimalPrecision) {
      this.measureDecimalPrecision = measureDecimalPrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingDecimalPrecision(final BigDecimal accountingDecimalPrecision) {
      this.accountingDecimalPrecision = accountingDecimalPrecision;
   }

   public void setOutboundMethod(final String outboundMethod) {
      this.outboundMethod = outboundMethod;
   }

   public void setChildren(final List<SubjectSpecMeasureDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectSpecMeasureDTO)) {
         return false;
      }

      SubjectSpecMeasureDTO other = (SubjectSpecMeasureDTO)o;
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
                     Object this$metrologyId = this.getMetrologyId();
                     Object other$metrologyId = other.getMetrologyId();
                     if (this$metrologyId == null ? other$metrologyId == null : this$metrologyId.equals(other$metrologyId)) {
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
                                          Object this$measureDecimalPrecision = this.getMeasureDecimalPrecision();
                                          Object other$measureDecimalPrecision = other.getMeasureDecimalPrecision();
                                          if (this$measureDecimalPrecision == null
                                             ? other$measureDecimalPrecision == null
                                             : this$measureDecimalPrecision.equals(other$measureDecimalPrecision)) {
                                             Object this$accountingUnit = this.getAccountingUnit();
                                             Object other$accountingUnit = other.getAccountingUnit();
                                             if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                                Object this$accountingDecimalPrecision = this.getAccountingDecimalPrecision();
                                                Object other$accountingDecimalPrecision = other.getAccountingDecimalPrecision();
                                                if (this$accountingDecimalPrecision == null
                                                   ? other$accountingDecimalPrecision == null
                                                   : this$accountingDecimalPrecision.equals(other$accountingDecimalPrecision)) {
                                                   Object this$outboundMethod = this.getOutboundMethod();
                                                   Object other$outboundMethod = other.getOutboundMethod();
                                                   if (this$outboundMethod == null
                                                      ? other$outboundMethod == null
                                                      : this$outboundMethod.equals(other$outboundMethod)) {
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
      return other instanceof SubjectSpecMeasureDTO;
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
      Object $metrologyId = this.getMetrologyId();
      result = result * 59 + ($metrologyId == null ? 43 : $metrologyId.hashCode());
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
      Object $measureDecimalPrecision = this.getMeasureDecimalPrecision();
      result = result * 59 + ($measureDecimalPrecision == null ? 43 : $measureDecimalPrecision.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $accountingDecimalPrecision = this.getAccountingDecimalPrecision();
      result = result * 59 + ($accountingDecimalPrecision == null ? 43 : $accountingDecimalPrecision.hashCode());
      Object $outboundMethod = this.getOutboundMethod();
      result = result * 59 + ($outboundMethod == null ? 43 : $outboundMethod.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectSpecMeasureDTO(subjectId="
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
         + ", metrologyId="
         + this.getMetrologyId()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measureDecimalPrecision="
         + this.getMeasureDecimalPrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingDecimalPrecision="
         + this.getAccountingDecimalPrecision()
         + ", outboundMethod="
         + this.getOutboundMethod()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public static class SubjectSpecMeasureDTOBuilder {
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
      private Long metrologyId;
      private String measureUnit;
      private BigDecimal measureDecimalPrecision;
      private String accountingUnit;
      private BigDecimal accountingDecimalPrecision;
      private String outboundMethod;
      private List<SubjectSpecMeasureDTO> children;

      SubjectSpecMeasureDTOBuilder() {
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder subjectId(final Long subjectId) {
         this.subjectId = subjectId;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder boolLastEnum(final Boolean boolLastEnum) {
         this.boolLastEnum = boolLastEnum;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder specifications(final List<SpecificationDTO> specifications) {
         this.specifications = specifications;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder metrologyId(final Long metrologyId) {
         this.metrologyId = metrologyId;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder measureDecimalPrecision(final BigDecimal measureDecimalPrecision) {
         this.measureDecimalPrecision = measureDecimalPrecision;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder accountingDecimalPrecision(final BigDecimal accountingDecimalPrecision) {
         this.accountingDecimalPrecision = accountingDecimalPrecision;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder outboundMethod(final String outboundMethod) {
         this.outboundMethod = outboundMethod;
         return this;
      }

      public SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder children(final List<SubjectSpecMeasureDTO> children) {
         this.children = children;
         return this;
      }

      public SubjectSpecMeasureDTO build() {
         return new SubjectSpecMeasureDTO(
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
            this.metrologyId,
            this.measureUnit,
            this.measureDecimalPrecision,
            this.accountingUnit,
            this.accountingDecimalPrecision,
            this.outboundMethod,
            this.children
         );
      }

      @Override
      public String toString() {
         return "SubjectSpecMeasureDTO.SubjectSpecMeasureDTOBuilder(subjectId="
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
            + ", metrologyId="
            + this.metrologyId
            + ", measureUnit="
            + this.measureUnit
            + ", measureDecimalPrecision="
            + this.measureDecimalPrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingDecimalPrecision="
            + this.accountingDecimalPrecision
            + ", outboundMethod="
            + this.outboundMethod
            + ", children="
            + this.children
            + ")";
      }
   }
}
