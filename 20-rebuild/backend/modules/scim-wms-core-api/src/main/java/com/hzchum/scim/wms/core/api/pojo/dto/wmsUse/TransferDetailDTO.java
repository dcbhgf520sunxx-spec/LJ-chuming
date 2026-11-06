package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferDetailDTO {
   private Long id;
   private String serialNumber;
   private Long classifyId;
   private Integer basicClass;
   private Boolean boolPartyA;
   private String specification;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal mete;
   private String brand;
   private String heatNoAndBatchNo;
   private String color;
   private String remark;
   private String nationalStandard;
   private ProjectInfoDTO project;
   private String monomerName;
   private String areaName;
   private Long workshopId;
   private Warehouse warehouse;
   private BigDecimal unitPrice;
   private BigDecimal unitPriceExcludingVAT;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private String materialSnNew;
   private LocalDateTime realTime;

   public static TransferDetailDTO.TransferDetailDTOBuilder builder() {
      return new TransferDetailDTO.TransferDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
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

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
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

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
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

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Warehouse getWarehouse() {
      return this.warehouse;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getInputVAT() {
      return this.inputVAT;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
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

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
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

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouse(final Warehouse warehouse) {
      this.warehouse = warehouse;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferDetailDTO)) {
         return false;
      }

      TransferDetailDTO other = (TransferDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$boolPartyA = this.getBoolPartyA();
               Object other$boolPartyA = other.getBoolPartyA();
               if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$thickness = this.getThickness();
                              Object other$thickness = other.getThickness();
                              if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$width = this.getWidth();
                                    Object other$width = other.getWidth();
                                    if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                       Object this$mete = this.getMete();
                                       Object other$mete = other.getMete();
                                       if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                          Object this$brand = this.getBrand();
                                          Object other$brand = other.getBrand();
                                          if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                             Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                             Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                             if (this$heatNoAndBatchNo == null
                                                ? other$heatNoAndBatchNo == null
                                                : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                Object this$color = this.getColor();
                                                Object other$color = other.getColor();
                                                if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$nationalStandard = this.getNationalStandard();
                                                      Object other$nationalStandard = other.getNationalStandard();
                                                      if (this$nationalStandard == null
                                                         ? other$nationalStandard == null
                                                         : this$nationalStandard.equals(other$nationalStandard)) {
                                                         Object this$project = this.getProject();
                                                         Object other$project = other.getProject();
                                                         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                            Object this$monomerName = this.getMonomerName();
                                                            Object other$monomerName = other.getMonomerName();
                                                            if (this$monomerName == null
                                                               ? other$monomerName == null
                                                               : this$monomerName.equals(other$monomerName)) {
                                                               Object this$areaName = this.getAreaName();
                                                               Object other$areaName = other.getAreaName();
                                                               if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                                  Object this$warehouse = this.getWarehouse();
                                                                  Object other$warehouse = other.getWarehouse();
                                                                  if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)
                                                                     )
                                                                   {
                                                                     Object this$unitPrice = this.getUnitPrice();
                                                                     Object other$unitPrice = other.getUnitPrice();
                                                                     if (this$unitPrice == null
                                                                        ? other$unitPrice == null
                                                                        : this$unitPrice.equals(other$unitPrice)) {
                                                                        Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                                                                        Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                                                                        if (this$unitPriceExcludingVAT == null
                                                                           ? other$unitPriceExcludingVAT == null
                                                                           : this$unitPriceExcludingVAT.equals(other$unitPriceExcludingVAT)) {
                                                                           Object this$amount = this.getAmount();
                                                                           Object other$amount = other.getAmount();
                                                                           if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                              Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                                                              Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                                                              if (this$amountExcludingVAT == null
                                                                                 ? other$amountExcludingVAT == null
                                                                                 : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                                                                                 Object this$inputVAT = this.getInputVAT();
                                                                                 Object other$inputVAT = other.getInputVAT();
                                                                                 if (this$inputVAT == null
                                                                                    ? other$inputVAT == null
                                                                                    : this$inputVAT.equals(other$inputVAT)) {
                                                                                    Object this$materialSnNew = this.getMaterialSnNew();
                                                                                    Object other$materialSnNew = other.getMaterialSnNew();
                                                                                    if (this$materialSnNew == null
                                                                                       ? other$materialSnNew == null
                                                                                       : this$materialSnNew.equals(other$materialSnNew)) {
                                                                                       Object this$realTime = this.getRealTime();
                                                                                       Object other$realTime = other.getRealTime();
                                                                                       return this$realTime == null
                                                                                          ? other$realTime == null
                                                                                          : this$realTime.equals(other$realTime);
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
      return other instanceof TransferDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      result = result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      result = result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   @Override
   public String toString() {
      return "TransferDetailDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", mete="
         + this.getMete()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", remark="
         + this.getRemark()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouse="
         + this.getWarehouse()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   public TransferDetailDTO(
      final Long id,
      final String serialNumber,
      final Long classifyId,
      final Integer basicClass,
      final Boolean boolPartyA,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal mete,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final String remark,
      final String nationalStandard,
      final ProjectInfoDTO project,
      final String monomerName,
      final String areaName,
      final Long workshopId,
      final Warehouse warehouse,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final String materialSnNew,
      final LocalDateTime realTime
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.boolPartyA = boolPartyA;
      this.specification = specification;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.mete = mete;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.remark = remark;
      this.nationalStandard = nationalStandard;
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.workshopId = workshopId;
      this.warehouse = warehouse;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.materialSnNew = materialSnNew;
      this.realTime = realTime;
   }

   public TransferDetailDTO() {
   }

   public static class TransferDetailDTOBuilder {
      private Long id;
      private String serialNumber;
      private Long classifyId;
      private Integer basicClass;
      private Boolean boolPartyA;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal mete;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private String remark;
      private String nationalStandard;
      private ProjectInfoDTO project;
      private String monomerName;
      private String areaName;
      private Long workshopId;
      private Warehouse warehouse;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private String materialSnNew;
      private LocalDateTime realTime;

      TransferDetailDTOBuilder() {
      }

      public TransferDetailDTO.TransferDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder project(final ProjectInfoDTO project) {
         this.project = project;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder warehouse(final Warehouse warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public TransferDetailDTO build() {
         return new TransferDetailDTO(
            this.id,
            this.serialNumber,
            this.classifyId,
            this.basicClass,
            this.boolPartyA,
            this.specification,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.mete,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.remark,
            this.nationalStandard,
            this.project,
            this.monomerName,
            this.areaName,
            this.workshopId,
            this.warehouse,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.materialSnNew,
            this.realTime
         );
      }

      @Override
      public String toString() {
         return "TransferDetailDTO.TransferDetailDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", boolPartyA="
            + this.boolPartyA
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", mete="
            + this.mete
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", remark="
            + this.remark
            + ", nationalStandard="
            + this.nationalStandard
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", workshopId="
            + this.workshopId
            + ", warehouse="
            + this.warehouse
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVAT="
            + this.unitPriceExcludingVAT
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", inputVAT="
            + this.inputVAT
            + ", materialSnNew="
            + this.materialSnNew
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
