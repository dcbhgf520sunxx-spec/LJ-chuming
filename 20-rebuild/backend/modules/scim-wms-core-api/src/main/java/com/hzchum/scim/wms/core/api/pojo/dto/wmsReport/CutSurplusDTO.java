package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CutSurplusDTO {
   private Integer basicClass;
   private String classifyName;
   private Long classifyId;
   private String spec;
   private String sourceSpec;
   private Boolean boolPartyA;
   private Integer theoryThickness;
   private BigDecimal quantity;
   private String brand;
   private String heatNoAndBatchNo;
   private BigDecimal mete;
   private String areaName;
   private String monomerName;
   private String surplusSn;
   private String cutTaskId;
   private LocalDateTime cutEndTime;
   private BriefIdAndNameDTO warehouse;
   private BriefIdAndNameDTO workshop;
   private ProjectInfo project;

   public static CutSurplusDTO.CutSurplusDTOBuilder builder() {
      return new CutSurplusDTO.CutSurplusDTOBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSpec() {
      return this.spec;
   }

   public String getSourceSpec() {
      return this.sourceSpec;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public LocalDateTime getCutEndTime() {
      return this.cutEndTime;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setSpec(final String spec) {
      this.spec = spec;
   }

   public void setSourceSpec(final String sourceSpec) {
      this.sourceSpec = sourceSpec;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setTheoryThickness(final Integer theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
   }

   public void setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
   }

   public void setCutEndTime(final LocalDateTime cutEndTime) {
      this.cutEndTime = cutEndTime;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutSurplusDTO)) {
         return false;
      }

      CutSurplusDTO other = (CutSurplusDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$theoryThickness = this.getTheoryThickness();
               Object other$theoryThickness = other.getTheoryThickness();
               if (this$theoryThickness == null ? other$theoryThickness == null : this$theoryThickness.equals(other$theoryThickness)) {
                  Object this$classifyName = this.getClassifyName();
                  Object other$classifyName = other.getClassifyName();
                  if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                     Object this$spec = this.getSpec();
                     Object other$spec = other.getSpec();
                     if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
                        Object this$sourceSpec = this.getSourceSpec();
                        Object other$sourceSpec = other.getSourceSpec();
                        if (this$sourceSpec == null ? other$sourceSpec == null : this$sourceSpec.equals(other$sourceSpec)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$brand = this.getBrand();
                              Object other$brand = other.getBrand();
                              if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                 Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                 Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                 if (this$heatNoAndBatchNo == null ? other$heatNoAndBatchNo == null : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                    Object this$mete = this.getMete();
                                    Object other$mete = other.getMete();
                                    if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                       Object this$areaName = this.getAreaName();
                                       Object other$areaName = other.getAreaName();
                                       if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                          Object this$monomerName = this.getMonomerName();
                                          Object other$monomerName = other.getMonomerName();
                                          if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                             Object this$surplusSn = this.getSurplusSn();
                                             Object other$surplusSn = other.getSurplusSn();
                                             if (this$surplusSn == null ? other$surplusSn == null : this$surplusSn.equals(other$surplusSn)) {
                                                Object this$cutTaskId = this.getCutTaskId();
                                                Object other$cutTaskId = other.getCutTaskId();
                                                if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
                                                   Object this$cutEndTime = this.getCutEndTime();
                                                   Object other$cutEndTime = other.getCutEndTime();
                                                   if (this$cutEndTime == null ? other$cutEndTime == null : this$cutEndTime.equals(other$cutEndTime)) {
                                                      Object this$warehouse = this.getWarehouse();
                                                      Object other$warehouse = other.getWarehouse();
                                                      if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
                                                         Object this$workshop = this.getWorkshop();
                                                         Object other$workshop = other.getWorkshop();
                                                         if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                            Object this$project = this.getProject();
                                                            Object other$project = other.getProject();
                                                            return this$project == null ? other$project == null : this$project.equals(other$project);
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
      return other instanceof CutSurplusDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $sourceSpec = this.getSourceSpec();
      result = result * 59 + ($sourceSpec == null ? 43 : $sourceSpec.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $cutEndTime = this.getCutEndTime();
      result = result * 59 + ($cutEndTime == null ? 43 : $cutEndTime.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   @Override
   public String toString() {
      return "CutSurplusDTO(basicClass="
         + this.getBasicClass()
         + ", classifyName="
         + this.getClassifyName()
         + ", classifyId="
         + this.getClassifyId()
         + ", spec="
         + this.getSpec()
         + ", sourceSpec="
         + this.getSourceSpec()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", quantity="
         + this.getQuantity()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", mete="
         + this.getMete()
         + ", areaName="
         + this.getAreaName()
         + ", monomerName="
         + this.getMonomerName()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", cutTaskId="
         + this.getCutTaskId()
         + ", cutEndTime="
         + this.getCutEndTime()
         + ", warehouse="
         + this.getWarehouse()
         + ", workshop="
         + this.getWorkshop()
         + ", project="
         + this.getProject()
         + ")";
   }

   public CutSurplusDTO(
      final Integer basicClass,
      final String classifyName,
      final Long classifyId,
      final String spec,
      final String sourceSpec,
      final Boolean boolPartyA,
      final Integer theoryThickness,
      final BigDecimal quantity,
      final String brand,
      final String heatNoAndBatchNo,
      final BigDecimal mete,
      final String areaName,
      final String monomerName,
      final String surplusSn,
      final String cutTaskId,
      final LocalDateTime cutEndTime,
      final BriefIdAndNameDTO warehouse,
      final BriefIdAndNameDTO workshop,
      final ProjectInfo project
   ) {
      this.basicClass = basicClass;
      this.classifyName = classifyName;
      this.classifyId = classifyId;
      this.spec = spec;
      this.sourceSpec = sourceSpec;
      this.boolPartyA = boolPartyA;
      this.theoryThickness = theoryThickness;
      this.quantity = quantity;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.mete = mete;
      this.areaName = areaName;
      this.monomerName = monomerName;
      this.surplusSn = surplusSn;
      this.cutTaskId = cutTaskId;
      this.cutEndTime = cutEndTime;
      this.warehouse = warehouse;
      this.workshop = workshop;
      this.project = project;
   }

   public CutSurplusDTO() {
   }

   public static class CutSurplusDTOBuilder {
      private Integer basicClass;
      private String classifyName;
      private Long classifyId;
      private String spec;
      private String sourceSpec;
      private Boolean boolPartyA;
      private Integer theoryThickness;
      private BigDecimal quantity;
      private String brand;
      private String heatNoAndBatchNo;
      private BigDecimal mete;
      private String areaName;
      private String monomerName;
      private String surplusSn;
      private String cutTaskId;
      private LocalDateTime cutEndTime;
      private BriefIdAndNameDTO warehouse;
      private BriefIdAndNameDTO workshop;
      private ProjectInfo project;

      CutSurplusDTOBuilder() {
      }

      public CutSurplusDTO.CutSurplusDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder spec(final String spec) {
         this.spec = spec;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder sourceSpec(final String sourceSpec) {
         this.sourceSpec = sourceSpec;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder theoryThickness(final Integer theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder cutEndTime(final LocalDateTime cutEndTime) {
         this.cutEndTime = cutEndTime;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public CutSurplusDTO.CutSurplusDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public CutSurplusDTO build() {
         return new CutSurplusDTO(
            this.basicClass,
            this.classifyName,
            this.classifyId,
            this.spec,
            this.sourceSpec,
            this.boolPartyA,
            this.theoryThickness,
            this.quantity,
            this.brand,
            this.heatNoAndBatchNo,
            this.mete,
            this.areaName,
            this.monomerName,
            this.surplusSn,
            this.cutTaskId,
            this.cutEndTime,
            this.warehouse,
            this.workshop,
            this.project
         );
      }

      @Override
      public String toString() {
         return "CutSurplusDTO.CutSurplusDTOBuilder(basicClass="
            + this.basicClass
            + ", classifyName="
            + this.classifyName
            + ", classifyId="
            + this.classifyId
            + ", spec="
            + this.spec
            + ", sourceSpec="
            + this.sourceSpec
            + ", boolPartyA="
            + this.boolPartyA
            + ", theoryThickness="
            + this.theoryThickness
            + ", quantity="
            + this.quantity
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", mete="
            + this.mete
            + ", areaName="
            + this.areaName
            + ", monomerName="
            + this.monomerName
            + ", surplusSn="
            + this.surplusSn
            + ", cutTaskId="
            + this.cutTaskId
            + ", cutEndTime="
            + this.cutEndTime
            + ", warehouse="
            + this.warehouse
            + ", workshop="
            + this.workshop
            + ", project="
            + this.project
            + ")";
      }
   }
}
