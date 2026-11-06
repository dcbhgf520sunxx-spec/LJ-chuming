package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;

public class VirtualMaterialDTO {
   private Integer basicClass;
   private Long classifyId;
   private String serialNumber;
   private ProjectInfo project;
   private String monomerName;
   private String areaName;
   private BigDecimal quantity;
   private String specification;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private BigDecimal mete;
   private String nationalStandard;
   private Boolean boolPartyA;
   private String brand;
   private String heatNoAndBatchNo;
   private String barcode;
   private String color;
   private BriefIdAndNameDTO warehouse;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndSNDTO returnReceipt;

   public static VirtualMaterialDTO.VirtualMaterialDTOBuilder builder() {
      return new VirtualMaterialDTO.VirtualMaterialDTOBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public String getColor() {
      return this.color;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndSNDTO getReturnReceipt() {
      return this.returnReceipt;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setBarcode(final String barcode) {
      this.barcode = barcode;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setReturnReceipt(final BriefIdAndSNDTO returnReceipt) {
      this.returnReceipt = returnReceipt;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof VirtualMaterialDTO)) {
         return false;
      }

      VirtualMaterialDTO other = (VirtualMaterialDTO)o;
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
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomerName = this.getMonomerName();
                     Object other$monomerName = other.getMonomerName();
                     if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$width = this.getWidth();
                                    Object other$width = other.getWidth();
                                    if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                       Object this$thickness = this.getThickness();
                                       Object other$thickness = other.getThickness();
                                       if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                          Object this$mete = this.getMete();
                                          Object other$mete = other.getMete();
                                          if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                             Object this$nationalStandard = this.getNationalStandard();
                                             Object other$nationalStandard = other.getNationalStandard();
                                             if (this$nationalStandard == null
                                                ? other$nationalStandard == null
                                                : this$nationalStandard.equals(other$nationalStandard)) {
                                                Object this$brand = this.getBrand();
                                                Object other$brand = other.getBrand();
                                                if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                   Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                   Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                   if (this$heatNoAndBatchNo == null
                                                      ? other$heatNoAndBatchNo == null
                                                      : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                      Object this$barcode = this.getBarcode();
                                                      Object other$barcode = other.getBarcode();
                                                      if (this$barcode == null ? other$barcode == null : this$barcode.equals(other$barcode)) {
                                                         Object this$color = this.getColor();
                                                         Object other$color = other.getColor();
                                                         if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                            Object this$warehouse = this.getWarehouse();
                                                            Object other$warehouse = other.getWarehouse();
                                                            if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
                                                               Object this$workshop = this.getWorkshop();
                                                               Object other$workshop = other.getWorkshop();
                                                               if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                                  Object this$returnReceipt = this.getReturnReceipt();
                                                                  Object other$returnReceipt = other.getReturnReceipt();
                                                                  return this$returnReceipt == null
                                                                     ? other$returnReceipt == null
                                                                     : this$returnReceipt.equals(other$returnReceipt);
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
      return other instanceof VirtualMaterialDTO;
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
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $returnReceipt = this.getReturnReceipt();
      return result * 59 + ($returnReceipt == null ? 43 : $returnReceipt.hashCode());
   }

   @Override
   public String toString() {
      return "VirtualMaterialDTO(basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", quantity="
         + this.getQuantity()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", mete="
         + this.getMete()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", barcode="
         + this.getBarcode()
         + ", color="
         + this.getColor()
         + ", warehouse="
         + this.getWarehouse()
         + ", workshop="
         + this.getWorkshop()
         + ", returnReceipt="
         + this.getReturnReceipt()
         + ")";
   }

   public VirtualMaterialDTO(
      final Integer basicClass,
      final Long classifyId,
      final String serialNumber,
      final ProjectInfo project,
      final String monomerName,
      final String areaName,
      final BigDecimal quantity,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal mete,
      final String nationalStandard,
      final Boolean boolPartyA,
      final String brand,
      final String heatNoAndBatchNo,
      final String barcode,
      final String color,
      final BriefIdAndNameDTO warehouse,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndSNDTO returnReceipt
   ) {
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.serialNumber = serialNumber;
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.quantity = quantity;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.mete = mete;
      this.nationalStandard = nationalStandard;
      this.boolPartyA = boolPartyA;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.barcode = barcode;
      this.color = color;
      this.warehouse = warehouse;
      this.workshop = workshop;
      this.returnReceipt = returnReceipt;
   }

   public VirtualMaterialDTO() {
   }

   public static class VirtualMaterialDTOBuilder {
      private Integer basicClass;
      private Long classifyId;
      private String serialNumber;
      private ProjectInfo project;
      private String monomerName;
      private String areaName;
      private BigDecimal quantity;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal mete;
      private String nationalStandard;
      private Boolean boolPartyA;
      private String brand;
      private String heatNoAndBatchNo;
      private String barcode;
      private String color;
      private BriefIdAndNameDTO warehouse;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndSNDTO returnReceipt;

      VirtualMaterialDTOBuilder() {
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public VirtualMaterialDTO.VirtualMaterialDTOBuilder returnReceipt(final BriefIdAndSNDTO returnReceipt) {
         this.returnReceipt = returnReceipt;
         return this;
      }

      public VirtualMaterialDTO build() {
         return new VirtualMaterialDTO(
            this.basicClass,
            this.classifyId,
            this.serialNumber,
            this.project,
            this.monomerName,
            this.areaName,
            this.quantity,
            this.specification,
            this.length,
            this.width,
            this.thickness,
            this.mete,
            this.nationalStandard,
            this.boolPartyA,
            this.brand,
            this.heatNoAndBatchNo,
            this.barcode,
            this.color,
            this.warehouse,
            this.workshop,
            this.returnReceipt
         );
      }

      @Override
      public String toString() {
         return "VirtualMaterialDTO.VirtualMaterialDTOBuilder(basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", serialNumber="
            + this.serialNumber
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", quantity="
            + this.quantity
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", mete="
            + this.mete
            + ", nationalStandard="
            + this.nationalStandard
            + ", boolPartyA="
            + this.boolPartyA
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", barcode="
            + this.barcode
            + ", color="
            + this.color
            + ", warehouse="
            + this.warehouse
            + ", workshop="
            + this.workshop
            + ", returnReceipt="
            + this.returnReceipt
            + ")";
      }
   }
}
