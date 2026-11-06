package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;
import java.util.List;

public class MaterialFreezeDTO {
   private Long id;
   private Boolean boolPartyA;
   private String serialNumber;
   private Long classifyId;
   private Integer basicClass;
   private String specification;
   private BigDecimal mete;
   private BigDecimal frozenMete;
   private BigDecimal quantity;
   private BigDecimal frozenQuantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String color;
   private String brand;
   private String heatNoAndBatchNo;
   private ProjectInfoDTO project;
   private String monomerName;
   private String areaName;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO warehouse;
   private String nationalStandard;
   private BigDecimal unitNet;
   private List<MaterialFreezeRecordDTO> recordList;

   public static MaterialFreezeDTO.MaterialFreezeDTOBuilder builder() {
      return new MaterialFreezeDTO.MaterialFreezeDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getFrozenMete() {
      return this.frozenMete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getFrozenQuantity() {
      return this.frozenQuantity;
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

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public List<MaterialFreezeRecordDTO> getRecordList() {
      return this.recordList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setFrozenMete(final BigDecimal frozenMete) {
      this.frozenMete = frozenMete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setFrozenQuantity(final BigDecimal frozenQuantity) {
      this.frozenQuantity = frozenQuantity;
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

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setRecordList(final List<MaterialFreezeRecordDTO> recordList) {
      this.recordList = recordList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialFreezeDTO)) {
         return false;
      }

      MaterialFreezeDTO other = (MaterialFreezeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolPartyA = this.getBoolPartyA();
         Object other$boolPartyA = other.getBoolPartyA();
         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                           Object this$frozenMete = this.getFrozenMete();
                           Object other$frozenMete = other.getFrozenMete();
                           if (this$frozenMete == null ? other$frozenMete == null : this$frozenMete.equals(other$frozenMete)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$frozenQuantity = this.getFrozenQuantity();
                                 Object other$frozenQuantity = other.getFrozenQuantity();
                                 if (this$frozenQuantity == null ? other$frozenQuantity == null : this$frozenQuantity.equals(other$frozenQuantity)) {
                                    Object this$thickness = this.getThickness();
                                    Object other$thickness = other.getThickness();
                                    if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$width = this.getWidth();
                                          Object other$width = other.getWidth();
                                          if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                             Object this$color = this.getColor();
                                             Object other$color = other.getColor();
                                             if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                Object this$brand = this.getBrand();
                                                Object other$brand = other.getBrand();
                                                if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                   Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                   Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                   if (this$heatNoAndBatchNo == null
                                                      ? other$heatNoAndBatchNo == null
                                                      : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                      Object this$project = this.getProject();
                                                      Object other$project = other.getProject();
                                                      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                         Object this$monomerName = this.getMonomerName();
                                                         Object other$monomerName = other.getMonomerName();
                                                         if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                                            Object this$areaName = this.getAreaName();
                                                            Object other$areaName = other.getAreaName();
                                                            if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                               Object this$workshop = this.getWorkshop();
                                                               Object other$workshop = other.getWorkshop();
                                                               if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                                  Object this$warehouse = this.getWarehouse();
                                                                  Object other$warehouse = other.getWarehouse();
                                                                  if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)
                                                                     )
                                                                   {
                                                                     Object this$nationalStandard = this.getNationalStandard();
                                                                     Object other$nationalStandard = other.getNationalStandard();
                                                                     if (this$nationalStandard == null
                                                                        ? other$nationalStandard == null
                                                                        : this$nationalStandard.equals(other$nationalStandard)) {
                                                                        Object this$unitNet = this.getUnitNet();
                                                                        Object other$unitNet = other.getUnitNet();
                                                                        if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                                           Object this$recordList = this.getRecordList();
                                                                           Object other$recordList = other.getRecordList();
                                                                           return this$recordList == null
                                                                              ? other$recordList == null
                                                                              : this$recordList.equals(other$recordList);
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
      return other instanceof MaterialFreezeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $frozenMete = this.getFrozenMete();
      result = result * 59 + ($frozenMete == null ? 43 : $frozenMete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $frozenQuantity = this.getFrozenQuantity();
      result = result * 59 + ($frozenQuantity == null ? 43 : $frozenQuantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $recordList = this.getRecordList();
      return result * 59 + ($recordList == null ? 43 : $recordList.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialFreezeDTO(id="
         + this.getId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", mete="
         + this.getMete()
         + ", frozenMete="
         + this.getFrozenMete()
         + ", quantity="
         + this.getQuantity()
         + ", frozenQuantity="
         + this.getFrozenQuantity()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", unitNet="
         + this.getUnitNet()
         + ", recordList="
         + this.getRecordList()
         + ")";
   }

   public MaterialFreezeDTO(
      final Long id,
      final Boolean boolPartyA,
      final String serialNumber,
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final BigDecimal mete,
      final BigDecimal frozenMete,
      final BigDecimal quantity,
      final BigDecimal frozenQuantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String color,
      final String brand,
      final String heatNoAndBatchNo,
      final ProjectInfoDTO project,
      final String monomerName,
      final String areaName,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO warehouse,
      final String nationalStandard,
      final BigDecimal unitNet,
      final List<MaterialFreezeRecordDTO> recordList
   ) {
      this.id = id;
      this.boolPartyA = boolPartyA;
      this.serialNumber = serialNumber;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.mete = mete;
      this.frozenMete = frozenMete;
      this.quantity = quantity;
      this.frozenQuantity = frozenQuantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.color = color;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.nationalStandard = nationalStandard;
      this.unitNet = unitNet;
      this.recordList = recordList;
   }

   public MaterialFreezeDTO() {
   }

   public static class MaterialFreezeDTOBuilder {
      private Long id;
      private Boolean boolPartyA;
      private String serialNumber;
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private BigDecimal mete;
      private BigDecimal frozenMete;
      private BigDecimal quantity;
      private BigDecimal frozenQuantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String color;
      private String brand;
      private String heatNoAndBatchNo;
      private ProjectInfoDTO project;
      private String monomerName;
      private String areaName;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO warehouse;
      private String nationalStandard;
      private BigDecimal unitNet;
      private List<MaterialFreezeRecordDTO> recordList;

      MaterialFreezeDTOBuilder() {
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder frozenMete(final BigDecimal frozenMete) {
         this.frozenMete = frozenMete;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder frozenQuantity(final BigDecimal frozenQuantity) {
         this.frozenQuantity = frozenQuantity;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder project(final ProjectInfoDTO project) {
         this.project = project;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public MaterialFreezeDTO.MaterialFreezeDTOBuilder recordList(final List<MaterialFreezeRecordDTO> recordList) {
         this.recordList = recordList;
         return this;
      }

      public MaterialFreezeDTO build() {
         return new MaterialFreezeDTO(
            this.id,
            this.boolPartyA,
            this.serialNumber,
            this.classifyId,
            this.basicClass,
            this.specification,
            this.mete,
            this.frozenMete,
            this.quantity,
            this.frozenQuantity,
            this.thickness,
            this.length,
            this.width,
            this.color,
            this.brand,
            this.heatNoAndBatchNo,
            this.project,
            this.monomerName,
            this.areaName,
            this.workshop,
            this.warehouse,
            this.nationalStandard,
            this.unitNet,
            this.recordList
         );
      }

      @Override
      public String toString() {
         return "MaterialFreezeDTO.MaterialFreezeDTOBuilder(id="
            + this.id
            + ", boolPartyA="
            + this.boolPartyA
            + ", serialNumber="
            + this.serialNumber
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", mete="
            + this.mete
            + ", frozenMete="
            + this.frozenMete
            + ", quantity="
            + this.quantity
            + ", frozenQuantity="
            + this.frozenQuantity
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
            + ", nationalStandard="
            + this.nationalStandard
            + ", unitNet="
            + this.unitNet
            + ", recordList="
            + this.recordList
            + ")";
      }
   }
}
