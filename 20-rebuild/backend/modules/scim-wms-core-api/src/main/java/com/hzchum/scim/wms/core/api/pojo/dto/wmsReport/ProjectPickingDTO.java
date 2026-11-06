package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProjectPickingDTO {
   private Long id;
   private String type;
   private Long classifyId;
   private String classifyName;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String specification;
   private String material;
   private String measureUnit;
   private String accountingUnit;
   private Integer accountingPrecision;
   private Integer measurePrecision;
   private BigDecimal quantity;
   private BigDecimal mete;
   private LocalDateTime time;
   private String recipientName;
   private Integer basicClass;
   private BigDecimal meteCount;
   private BigDecimal actualTheoryWeight;

   public static ProjectPickingDTO.ProjectPickingDTOBuilder builder() {
      return new ProjectPickingDTO.ProjectPickingDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getType() {
      return this.type;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public LocalDateTime getTime() {
      return this.time;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getMeteCount() {
      return this.meteCount;
   }

   public BigDecimal getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTime(final LocalDateTime time) {
      this.time = time;
   }

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMeteCount(final BigDecimal meteCount) {
      this.meteCount = meteCount;
   }

   public void setActualTheoryWeight(final BigDecimal actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPickingDTO)) {
         return false;
      }

      ProjectPickingDTO other = (ProjectPickingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$accountingPrecision = this.getAccountingPrecision();
            Object other$accountingPrecision = other.getAccountingPrecision();
            if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
               Object this$measurePrecision = this.getMeasurePrecision();
               Object other$measurePrecision = other.getMeasurePrecision();
               if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$classifyName = this.getClassifyName();
                        Object other$classifyName = other.getClassifyName();
                        if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                           Object this$thickness = this.getThickness();
                           Object other$thickness = other.getThickness();
                           if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                              Object this$length = this.getLength();
                              Object other$length = other.getLength();
                              if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                 Object this$width = this.getWidth();
                                 Object other$width = other.getWidth();
                                 if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$measureUnit = this.getMeasureUnit();
                                          Object other$measureUnit = other.getMeasureUnit();
                                          if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                             Object this$accountingUnit = this.getAccountingUnit();
                                             Object other$accountingUnit = other.getAccountingUnit();
                                             if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                                Object this$quantity = this.getQuantity();
                                                Object other$quantity = other.getQuantity();
                                                if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$time = this.getTime();
                                                      Object other$time = other.getTime();
                                                      if (this$time == null ? other$time == null : this$time.equals(other$time)) {
                                                         Object this$recipientName = this.getRecipientName();
                                                         Object other$recipientName = other.getRecipientName();
                                                         if (this$recipientName == null
                                                            ? other$recipientName == null
                                                            : this$recipientName.equals(other$recipientName)) {
                                                            Object this$meteCount = this.getMeteCount();
                                                            Object other$meteCount = other.getMeteCount();
                                                            if (this$meteCount == null ? other$meteCount == null : this$meteCount.equals(other$meteCount)) {
                                                               Object this$actualTheoryWeight = this.getActualTheoryWeight();
                                                               Object other$actualTheoryWeight = other.getActualTheoryWeight();
                                                               return this$actualTheoryWeight == null
                                                                  ? other$actualTheoryWeight == null
                                                                  : this$actualTheoryWeight.equals(other$actualTheoryWeight);
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
      return other instanceof ProjectPickingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $meteCount = this.getMeteCount();
      result = result * 59 + ($meteCount == null ? 43 : $meteCount.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      return result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPickingDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", time="
         + this.getTime()
         + ", recipientName="
         + this.getRecipientName()
         + ", basicClass="
         + this.getBasicClass()
         + ", meteCount="
         + this.getMeteCount()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ")";
   }

   public ProjectPickingDTO(
      final Long id,
      final String type,
      final Long classifyId,
      final String classifyName,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String specification,
      final String material,
      final String measureUnit,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer measurePrecision,
      final BigDecimal quantity,
      final BigDecimal mete,
      final LocalDateTime time,
      final String recipientName,
      final Integer basicClass,
      final BigDecimal meteCount,
      final BigDecimal actualTheoryWeight
   ) {
      this.id = id;
      this.type = type;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.specification = specification;
      this.material = material;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.measurePrecision = measurePrecision;
      this.quantity = quantity;
      this.mete = mete;
      this.time = time;
      this.recipientName = recipientName;
      this.basicClass = basicClass;
      this.meteCount = meteCount;
      this.actualTheoryWeight = actualTheoryWeight;
   }

   public ProjectPickingDTO() {
   }

   public static class ProjectPickingDTOBuilder {
      private Long id;
      private String type;
      private Long classifyId;
      private String classifyName;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String specification;
      private String material;
      private String measureUnit;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer measurePrecision;
      private BigDecimal quantity;
      private BigDecimal mete;
      private LocalDateTime time;
      private String recipientName;
      private Integer basicClass;
      private BigDecimal meteCount;
      private BigDecimal actualTheoryWeight;

      ProjectPickingDTOBuilder() {
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder time(final LocalDateTime time) {
         this.time = time;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder meteCount(final BigDecimal meteCount) {
         this.meteCount = meteCount;
         return this;
      }

      public ProjectPickingDTO.ProjectPickingDTOBuilder actualTheoryWeight(final BigDecimal actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      public ProjectPickingDTO build() {
         return new ProjectPickingDTO(
            this.id,
            this.type,
            this.classifyId,
            this.classifyName,
            this.thickness,
            this.length,
            this.width,
            this.specification,
            this.material,
            this.measureUnit,
            this.accountingUnit,
            this.accountingPrecision,
            this.measurePrecision,
            this.quantity,
            this.mete,
            this.time,
            this.recipientName,
            this.basicClass,
            this.meteCount,
            this.actualTheoryWeight
         );
      }

      @Override
      public String toString() {
         return "ProjectPickingDTO.ProjectPickingDTOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", measurePrecision="
            + this.measurePrecision
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", time="
            + this.time
            + ", recipientName="
            + this.recipientName
            + ", basicClass="
            + this.basicClass
            + ", meteCount="
            + this.meteCount
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ")";
      }
   }
}
