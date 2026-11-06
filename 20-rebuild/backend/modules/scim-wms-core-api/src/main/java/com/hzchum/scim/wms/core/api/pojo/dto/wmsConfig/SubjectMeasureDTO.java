package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.math.BigDecimal;
import java.util.List;

public class SubjectMeasureDTO {
   private Long id;
   private String name;
   private Integer basicClass;
   private String code;
   private String serialNumber;
   private Long metrologyId;
   private String measureUnit;
   private Integer measurePrecision;
   private String accountingUnit;
   private Integer accountingPrecision;
   private Integer outboundUnitType;
   private BigDecimal rdRate;
   private Integer classifyQuantity;
   private List<SubjectMeasureDTO> children;

   public static SubjectMeasureDTO.SubjectMeasureDTOBuilder builder() {
      return new SubjectMeasureDTO.SubjectMeasureDTOBuilder();
   }

   public Long getId() {
      return this.id;
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

   public Long getMetrologyId() {
      return this.metrologyId;
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

   public BigDecimal getRdRate() {
      return this.rdRate;
   }

   public Integer getClassifyQuantity() {
      return this.classifyQuantity;
   }

   public List<SubjectMeasureDTO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setMetrologyId(final Long metrologyId) {
      this.metrologyId = metrologyId;
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

   public void setRdRate(final BigDecimal rdRate) {
      this.rdRate = rdRate;
   }

   public void setClassifyQuantity(final Integer classifyQuantity) {
      this.classifyQuantity = classifyQuantity;
   }

   public void setChildren(final List<SubjectMeasureDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectMeasureDTO)) {
         return false;
      }

      SubjectMeasureDTO other = (SubjectMeasureDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$metrologyId = this.getMetrologyId();
            Object other$metrologyId = other.getMetrologyId();
            if (this$metrologyId == null ? other$metrologyId == null : this$metrologyId.equals(other$metrologyId)) {
               Object this$measurePrecision = this.getMeasurePrecision();
               Object other$measurePrecision = other.getMeasurePrecision();
               if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                  Object this$accountingPrecision = this.getAccountingPrecision();
                  Object other$accountingPrecision = other.getAccountingPrecision();
                  if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                     Object this$outboundUnitType = this.getOutboundUnitType();
                     Object other$outboundUnitType = other.getOutboundUnitType();
                     if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                        Object this$classifyQuantity = this.getClassifyQuantity();
                        Object other$classifyQuantity = other.getClassifyQuantity();
                        if (this$classifyQuantity == null ? other$classifyQuantity == null : this$classifyQuantity.equals(other$classifyQuantity)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$code = this.getCode();
                              Object other$code = other.getCode();
                              if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$measureUnit = this.getMeasureUnit();
                                    Object other$measureUnit = other.getMeasureUnit();
                                    if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                       Object this$accountingUnit = this.getAccountingUnit();
                                       Object other$accountingUnit = other.getAccountingUnit();
                                       if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                          Object this$rdRate = this.getRdRate();
                                          Object other$rdRate = other.getRdRate();
                                          if (this$rdRate == null ? other$rdRate == null : this$rdRate.equals(other$rdRate)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubjectMeasureDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $metrologyId = this.getMetrologyId();
      result = result * 59 + ($metrologyId == null ? 43 : $metrologyId.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $classifyQuantity = this.getClassifyQuantity();
      result = result * 59 + ($classifyQuantity == null ? 43 : $classifyQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $rdRate = this.getRdRate();
      result = result * 59 + ($rdRate == null ? 43 : $rdRate.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectMeasureDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", basicClass="
         + this.getBasicClass()
         + ", code="
         + this.getCode()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", metrologyId="
         + this.getMetrologyId()
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
         + ", rdRate="
         + this.getRdRate()
         + ", classifyQuantity="
         + this.getClassifyQuantity()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public SubjectMeasureDTO(
      final Long id,
      final String name,
      final Integer basicClass,
      final String code,
      final String serialNumber,
      final Long metrologyId,
      final String measureUnit,
      final Integer measurePrecision,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer outboundUnitType,
      final BigDecimal rdRate,
      final Integer classifyQuantity,
      final List<SubjectMeasureDTO> children
   ) {
      this.id = id;
      this.name = name;
      this.basicClass = basicClass;
      this.code = code;
      this.serialNumber = serialNumber;
      this.metrologyId = metrologyId;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.outboundUnitType = outboundUnitType;
      this.rdRate = rdRate;
      this.classifyQuantity = classifyQuantity;
      this.children = children;
   }

   public SubjectMeasureDTO() {
   }

   public static class SubjectMeasureDTOBuilder {
      private Long id;
      private String name;
      private Integer basicClass;
      private String code;
      private String serialNumber;
      private Long metrologyId;
      private String measureUnit;
      private Integer measurePrecision;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer outboundUnitType;
      private BigDecimal rdRate;
      private Integer classifyQuantity;
      private List<SubjectMeasureDTO> children;

      SubjectMeasureDTOBuilder() {
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder metrologyId(final Long metrologyId) {
         this.metrologyId = metrologyId;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder rdRate(final BigDecimal rdRate) {
         this.rdRate = rdRate;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder classifyQuantity(final Integer classifyQuantity) {
         this.classifyQuantity = classifyQuantity;
         return this;
      }

      public SubjectMeasureDTO.SubjectMeasureDTOBuilder children(final List<SubjectMeasureDTO> children) {
         this.children = children;
         return this;
      }

      public SubjectMeasureDTO build() {
         return new SubjectMeasureDTO(
            this.id,
            this.name,
            this.basicClass,
            this.code,
            this.serialNumber,
            this.metrologyId,
            this.measureUnit,
            this.measurePrecision,
            this.accountingUnit,
            this.accountingPrecision,
            this.outboundUnitType,
            this.rdRate,
            this.classifyQuantity,
            this.children
         );
      }

      @Override
      public String toString() {
         return "SubjectMeasureDTO.SubjectMeasureDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", basicClass="
            + this.basicClass
            + ", code="
            + this.code
            + ", serialNumber="
            + this.serialNumber
            + ", metrologyId="
            + this.metrologyId
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
            + ", rdRate="
            + this.rdRate
            + ", classifyQuantity="
            + this.classifyQuantity
            + ", children="
            + this.children
            + ")";
      }
   }
}
