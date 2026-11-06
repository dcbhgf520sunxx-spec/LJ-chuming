package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;
import java.util.List;

public class InventoryDetailsRecordDTO {
   private Boolean boolPartyA;
   private Long classifyId;
   private String classifyName;
   private Integer basicClass;
   private String specs;
   private List<String> specifications;
   private BigDecimal thickness;
   private String brand;
   private String color;
   private String heatNoAndBatchNo;
   private ProjectInfo project;
   private BriefIdAndNameDTO factory;
   private Measure measure;
   private Long statId;
   private String nationalStandard;
   private String detailKey;

   public static InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder builder() {
      return new InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder();
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecs() {
      return this.specs;
   }

   public List<String> getSpecifications() {
      return this.specifications;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BriefIdAndNameDTO getFactory() {
      return this.factory;
   }

   public Measure getMeasure() {
      return this.measure;
   }

   public Long getStatId() {
      return this.statId;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public String getDetailKey() {
      return this.detailKey;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecs(final String specs) {
      this.specs = specs;
   }

   public void setSpecifications(final List<String> specifications) {
      this.specifications = specifications;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setFactory(final BriefIdAndNameDTO factory) {
      this.factory = factory;
   }

   public void setMeasure(final Measure measure) {
      this.measure = measure;
   }

   public void setStatId(final Long statId) {
      this.statId = statId;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setDetailKey(final String detailKey) {
      this.detailKey = detailKey;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryDetailsRecordDTO)) {
         return false;
      }

      InventoryDetailsRecordDTO other = (InventoryDetailsRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolPartyA = this.getBoolPartyA();
      Object other$boolPartyA = other.getBoolPartyA();
      if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$statId = this.getStatId();
               Object other$statId = other.getStatId();
               if (this$statId == null ? other$statId == null : this$statId.equals(other$statId)) {
                  Object this$classifyName = this.getClassifyName();
                  Object other$classifyName = other.getClassifyName();
                  if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                     Object this$specs = this.getSpecs();
                     Object other$specs = other.getSpecs();
                     if (this$specs == null ? other$specs == null : this$specs.equals(other$specs)) {
                        Object this$specifications = this.getSpecifications();
                        Object other$specifications = other.getSpecifications();
                        if (this$specifications == null ? other$specifications == null : this$specifications.equals(other$specifications)) {
                           Object this$thickness = this.getThickness();
                           Object other$thickness = other.getThickness();
                           if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                              Object this$brand = this.getBrand();
                              Object other$brand = other.getBrand();
                              if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                 Object this$color = this.getColor();
                                 Object other$color = other.getColor();
                                 if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                    Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                    Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                    if (this$heatNoAndBatchNo == null ? other$heatNoAndBatchNo == null : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                       Object this$project = this.getProject();
                                       Object other$project = other.getProject();
                                       if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                          Object this$factory = this.getFactory();
                                          Object other$factory = other.getFactory();
                                          if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                             Object this$measure = this.getMeasure();
                                             Object other$measure = other.getMeasure();
                                             if (this$measure == null ? other$measure == null : this$measure.equals(other$measure)) {
                                                Object this$nationalStandard = this.getNationalStandard();
                                                Object other$nationalStandard = other.getNationalStandard();
                                                if (this$nationalStandard == null
                                                   ? other$nationalStandard == null
                                                   : this$nationalStandard.equals(other$nationalStandard)) {
                                                   Object this$detailKey = this.getDetailKey();
                                                   Object other$detailKey = other.getDetailKey();
                                                   return this$detailKey == null ? other$detailKey == null : this$detailKey.equals(other$detailKey);
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
      return other instanceof InventoryDetailsRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $statId = this.getStatId();
      result = result * 59 + ($statId == null ? 43 : $statId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specs = this.getSpecs();
      result = result * 59 + ($specs == null ? 43 : $specs.hashCode());
      Object $specifications = this.getSpecifications();
      result = result * 59 + ($specifications == null ? 43 : $specifications.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $measure = this.getMeasure();
      result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $detailKey = this.getDetailKey();
      return result * 59 + ($detailKey == null ? 43 : $detailKey.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryDetailsRecordDTO(boolPartyA="
         + this.getBoolPartyA()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", basicClass="
         + this.getBasicClass()
         + ", specs="
         + this.getSpecs()
         + ", specifications="
         + this.getSpecifications()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", project="
         + this.getProject()
         + ", factory="
         + this.getFactory()
         + ", measure="
         + this.getMeasure()
         + ", statId="
         + this.getStatId()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", detailKey="
         + this.getDetailKey()
         + ")";
   }

   public InventoryDetailsRecordDTO(
      final Boolean boolPartyA,
      final Long classifyId,
      final String classifyName,
      final Integer basicClass,
      final String specs,
      final List<String> specifications,
      final BigDecimal thickness,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final ProjectInfo project,
      final BriefIdAndNameDTO factory,
      final Measure measure,
      final Long statId,
      final String nationalStandard,
      final String detailKey
   ) {
      this.boolPartyA = boolPartyA;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.basicClass = basicClass;
      this.specs = specs;
      this.specifications = specifications;
      this.thickness = thickness;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.project = project;
      this.factory = factory;
      this.measure = measure;
      this.statId = statId;
      this.nationalStandard = nationalStandard;
      this.detailKey = detailKey;
   }

   public InventoryDetailsRecordDTO() {
   }

   public static class InventoryDetailsRecordDTOBuilder {
      private Boolean boolPartyA;
      private Long classifyId;
      private String classifyName;
      private Integer basicClass;
      private String specs;
      private List<String> specifications;
      private BigDecimal thickness;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private ProjectInfo project;
      private BriefIdAndNameDTO factory;
      private Measure measure;
      private Long statId;
      private String nationalStandard;
      private String detailKey;

      InventoryDetailsRecordDTOBuilder() {
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder specs(final String specs) {
         this.specs = specs;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder specifications(final List<String> specifications) {
         this.specifications = specifications;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder factory(final BriefIdAndNameDTO factory) {
         this.factory = factory;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder measure(final Measure measure) {
         this.measure = measure;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder statId(final Long statId) {
         this.statId = statId;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder detailKey(final String detailKey) {
         this.detailKey = detailKey;
         return this;
      }

      public InventoryDetailsRecordDTO build() {
         return new InventoryDetailsRecordDTO(
            this.boolPartyA,
            this.classifyId,
            this.classifyName,
            this.basicClass,
            this.specs,
            this.specifications,
            this.thickness,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.project,
            this.factory,
            this.measure,
            this.statId,
            this.nationalStandard,
            this.detailKey
         );
      }

      @Override
      public String toString() {
         return "InventoryDetailsRecordDTO.InventoryDetailsRecordDTOBuilder(boolPartyA="
            + this.boolPartyA
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", basicClass="
            + this.basicClass
            + ", specs="
            + this.specs
            + ", specifications="
            + this.specifications
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", project="
            + this.project
            + ", factory="
            + this.factory
            + ", measure="
            + this.measure
            + ", statId="
            + this.statId
            + ", nationalStandard="
            + this.nationalStandard
            + ", detailKey="
            + this.detailKey
            + ")";
      }
   }
}
