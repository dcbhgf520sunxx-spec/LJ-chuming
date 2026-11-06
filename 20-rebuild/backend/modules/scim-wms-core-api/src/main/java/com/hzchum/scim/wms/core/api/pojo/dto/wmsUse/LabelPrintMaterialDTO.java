package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LabelPrintMaterialDTO {
   private Long id;
   private String barcode;
   private Boolean boolPartyA;
   private Boolean boolHasFrozen;
   private String serialNumber;
   private Long classifyId;
   private Integer basicClass;
   private Integer printedNumber;
   private String specification;
   private BigDecimal mete;
   private BigDecimal frozenMete;
   private BigDecimal quantity;
   private BigDecimal frozenQuantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String brand;
   private String color;
   private String heatNoAndBatchNo;
   private ProjectInfo project;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO warehouse;
   private LocalDateTime createTime;
   private BriefIdAndSNDTO receipt;
   private String nationalStandard;

   public static LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder builder() {
      return new LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Boolean getBoolHasFrozen() {
      return this.boolHasFrozen;
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

   public Integer getPrintedNumber() {
      return this.printedNumber;
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

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public BriefIdAndSNDTO getReceipt() {
      return this.receipt;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBarcode(final String barcode) {
      this.barcode = barcode;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setBoolHasFrozen(final Boolean boolHasFrozen) {
      this.boolHasFrozen = boolHasFrozen;
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

   public void setPrintedNumber(final Integer printedNumber) {
      this.printedNumber = printedNumber;
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

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReceipt(final BriefIdAndSNDTO receipt) {
      this.receipt = receipt;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LabelPrintMaterialDTO)) {
         return false;
      }

      LabelPrintMaterialDTO other = (LabelPrintMaterialDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolPartyA = this.getBoolPartyA();
         Object other$boolPartyA = other.getBoolPartyA();
         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
            Object this$boolHasFrozen = this.getBoolHasFrozen();
            Object other$boolHasFrozen = other.getBoolHasFrozen();
            if (this$boolHasFrozen == null ? other$boolHasFrozen == null : this$boolHasFrozen.equals(other$boolHasFrozen)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$printedNumber = this.getPrintedNumber();
                     Object other$printedNumber = other.getPrintedNumber();
                     if (this$printedNumber == null ? other$printedNumber == null : this$printedNumber.equals(other$printedNumber)) {
                        Object this$barcode = this.getBarcode();
                        Object other$barcode = other.getBarcode();
                        if (this$barcode == null ? other$barcode == null : this$barcode.equals(other$barcode)) {
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
                                                      Object this$brand = this.getBrand();
                                                      Object other$brand = other.getBrand();
                                                      if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                         Object this$color = this.getColor();
                                                         Object other$color = other.getColor();
                                                         if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                            Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                            Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                            if (this$heatNoAndBatchNo == null
                                                               ? other$heatNoAndBatchNo == null
                                                               : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                               Object this$project = this.getProject();
                                                               Object other$project = other.getProject();
                                                               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                  Object this$workshop = this.getWorkshop();
                                                                  Object other$workshop = other.getWorkshop();
                                                                  if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                                     Object this$warehouse = this.getWarehouse();
                                                                     Object other$warehouse = other.getWarehouse();
                                                                     if (this$warehouse == null
                                                                        ? other$warehouse == null
                                                                        : this$warehouse.equals(other$warehouse)) {
                                                                        Object this$createTime = this.getCreateTime();
                                                                        Object other$createTime = other.getCreateTime();
                                                                        if (this$createTime == null
                                                                           ? other$createTime == null
                                                                           : this$createTime.equals(other$createTime)) {
                                                                           Object this$receipt = this.getReceipt();
                                                                           Object other$receipt = other.getReceipt();
                                                                           if (this$receipt == null
                                                                              ? other$receipt == null
                                                                              : this$receipt.equals(other$receipt)) {
                                                                              Object this$nationalStandard = this.getNationalStandard();
                                                                              Object other$nationalStandard = other.getNationalStandard();
                                                                              return this$nationalStandard == null
                                                                                 ? other$nationalStandard == null
                                                                                 : this$nationalStandard.equals(other$nationalStandard);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LabelPrintMaterialDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $boolHasFrozen = this.getBoolHasFrozen();
      result = result * 59 + ($boolHasFrozen == null ? 43 : $boolHasFrozen.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $printedNumber = this.getPrintedNumber();
      result = result * 59 + ($printedNumber == null ? 43 : $printedNumber.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
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
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $receipt = this.getReceipt();
      result = result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      return result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
   }

   @Override
   public String toString() {
      return "LabelPrintMaterialDTO(id="
         + this.getId()
         + ", barcode="
         + this.getBarcode()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", boolHasFrozen="
         + this.getBoolHasFrozen()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", printedNumber="
         + this.getPrintedNumber()
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
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", project="
         + this.getProject()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", createTime="
         + this.getCreateTime()
         + ", receipt="
         + this.getReceipt()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ")";
   }

   public LabelPrintMaterialDTO(
      final Long id,
      final String barcode,
      final Boolean boolPartyA,
      final Boolean boolHasFrozen,
      final String serialNumber,
      final Long classifyId,
      final Integer basicClass,
      final Integer printedNumber,
      final String specification,
      final BigDecimal mete,
      final BigDecimal frozenMete,
      final BigDecimal quantity,
      final BigDecimal frozenQuantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final ProjectInfo project,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO warehouse,
      final LocalDateTime createTime,
      final BriefIdAndSNDTO receipt,
      final String nationalStandard
   ) {
      this.id = id;
      this.barcode = barcode;
      this.boolPartyA = boolPartyA;
      this.boolHasFrozen = boolHasFrozen;
      this.serialNumber = serialNumber;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.printedNumber = printedNumber;
      this.specification = specification;
      this.mete = mete;
      this.frozenMete = frozenMete;
      this.quantity = quantity;
      this.frozenQuantity = frozenQuantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.project = project;
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.createTime = createTime;
      this.receipt = receipt;
      this.nationalStandard = nationalStandard;
   }

   public LabelPrintMaterialDTO() {
   }

   public static class LabelPrintMaterialDTOBuilder {
      private Long id;
      private String barcode;
      private Boolean boolPartyA;
      private Boolean boolHasFrozen;
      private String serialNumber;
      private Long classifyId;
      private Integer basicClass;
      private Integer printedNumber;
      private String specification;
      private BigDecimal mete;
      private BigDecimal frozenMete;
      private BigDecimal quantity;
      private BigDecimal frozenQuantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private ProjectInfo project;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO warehouse;
      private LocalDateTime createTime;
      private BriefIdAndSNDTO receipt;
      private String nationalStandard;

      LabelPrintMaterialDTOBuilder() {
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder boolHasFrozen(final Boolean boolHasFrozen) {
         this.boolHasFrozen = boolHasFrozen;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder printedNumber(final Integer printedNumber) {
         this.printedNumber = printedNumber;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder frozenMete(final BigDecimal frozenMete) {
         this.frozenMete = frozenMete;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder frozenQuantity(final BigDecimal frozenQuantity) {
         this.frozenQuantity = frozenQuantity;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder receipt(final BriefIdAndSNDTO receipt) {
         this.receipt = receipt;
         return this;
      }

      public LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public LabelPrintMaterialDTO build() {
         return new LabelPrintMaterialDTO(
            this.id,
            this.barcode,
            this.boolPartyA,
            this.boolHasFrozen,
            this.serialNumber,
            this.classifyId,
            this.basicClass,
            this.printedNumber,
            this.specification,
            this.mete,
            this.frozenMete,
            this.quantity,
            this.frozenQuantity,
            this.thickness,
            this.length,
            this.width,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.project,
            this.workshop,
            this.warehouse,
            this.createTime,
            this.receipt,
            this.nationalStandard
         );
      }

      @Override
      public String toString() {
         return "LabelPrintMaterialDTO.LabelPrintMaterialDTOBuilder(id="
            + this.id
            + ", barcode="
            + this.barcode
            + ", boolPartyA="
            + this.boolPartyA
            + ", boolHasFrozen="
            + this.boolHasFrozen
            + ", serialNumber="
            + this.serialNumber
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", printedNumber="
            + this.printedNumber
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
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", project="
            + this.project
            + ", workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
            + ", createTime="
            + this.createTime
            + ", receipt="
            + this.receipt
            + ", nationalStandard="
            + this.nationalStandard
            + ")";
      }
   }
}
