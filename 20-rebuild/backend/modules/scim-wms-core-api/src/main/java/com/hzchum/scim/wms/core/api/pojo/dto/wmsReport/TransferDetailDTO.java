package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;

public class TransferDetailDTO {
   private Long id;
   private Boolean boolPartyA;
   private Long classifyId;
   private Integer basicClass;
   private String specification;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String brand;
   private String heatNoAndBatchNo;
   private String color;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private BigDecimal mete;
   private BigDecimal unitPrice;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private ProjectInfo project;
   private BriefIdAndNameDTO factory;
   private BriefIdAndNameDTO warehouse;
   private TransferDTO transferReceipt;

   public static TransferDetailDTO.TransferDetailDTOBuilder builder() {
      return new TransferDetailDTO.TransferDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
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

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
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

   public ProjectInfo getProject() {
      return this.project;
   }

   public BriefIdAndNameDTO getFactory() {
      return this.factory;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public TransferDTO getTransferReceipt() {
      return this.transferReceipt;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
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

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
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

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setFactory(final BriefIdAndNameDTO factory) {
      this.factory = factory;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setTransferReceipt(final TransferDTO transferReceipt) {
      this.transferReceipt = transferReceipt;
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
         Object this$boolPartyA = this.getBoolPartyA();
         Object other$boolPartyA = other.getBoolPartyA();
         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$invoiceType = this.getInvoiceType();
                  Object other$invoiceType = other.getInvoiceType();
                  if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
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
                                             Object this$taxRate = this.getTaxRate();
                                             Object other$taxRate = other.getTaxRate();
                                             if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                Object this$mete = this.getMete();
                                                Object other$mete = other.getMete();
                                                if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                   Object this$unitPrice = this.getUnitPrice();
                                                   Object other$unitPrice = other.getUnitPrice();
                                                   if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
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
                                                            if (this$inputVAT == null ? other$inputVAT == null : this$inputVAT.equals(other$inputVAT)) {
                                                               Object this$project = this.getProject();
                                                               Object other$project = other.getProject();
                                                               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                  Object this$factory = this.getFactory();
                                                                  Object other$factory = other.getFactory();
                                                                  if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                                                     Object this$warehouse = this.getWarehouse();
                                                                     Object other$warehouse = other.getWarehouse();
                                                                     if (this$warehouse == null
                                                                        ? other$warehouse == null
                                                                        : this$warehouse.equals(other$warehouse)) {
                                                                        Object this$transferReceipt = this.getTransferReceipt();
                                                                        Object other$transferReceipt = other.getTransferReceipt();
                                                                        return this$transferReceipt == null
                                                                           ? other$transferReceipt == null
                                                                           : this$transferReceipt.equals(other$transferReceipt);
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
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
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
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      result = result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $transferReceipt = this.getTransferReceipt();
      return result * 59 + ($transferReceipt == null ? 43 : $transferReceipt.hashCode());
   }

   @Override
   public String toString() {
      return "TransferDetailDTO(id="
         + this.getId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
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
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", mete="
         + this.getMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ", project="
         + this.getProject()
         + ", factory="
         + this.getFactory()
         + ", warehouse="
         + this.getWarehouse()
         + ", transferReceipt="
         + this.getTransferReceipt()
         + ")";
   }

   public TransferDetailDTO(
      final Long id,
      final Boolean boolPartyA,
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BigDecimal mete,
      final BigDecimal unitPrice,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final ProjectInfo project,
      final BriefIdAndNameDTO factory,
      final BriefIdAndNameDTO warehouse,
      final TransferDTO transferReceipt
   ) {
      this.id = id;
      this.boolPartyA = boolPartyA;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.mete = mete;
      this.unitPrice = unitPrice;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.project = project;
      this.factory = factory;
      this.warehouse = warehouse;
      this.transferReceipt = transferReceipt;
   }

   public TransferDetailDTO() {
   }

   public static class TransferDetailDTOBuilder {
      private Long id;
      private Boolean boolPartyA;
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BigDecimal mete;
      private BigDecimal unitPrice;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private ProjectInfo project;
      private BriefIdAndNameDTO factory;
      private BriefIdAndNameDTO warehouse;
      private TransferDTO transferReceipt;

      TransferDetailDTOBuilder() {
      }

      public TransferDetailDTO.TransferDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
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

      public TransferDetailDTO.TransferDetailDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
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

      public TransferDetailDTO.TransferDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder factory(final BriefIdAndNameDTO factory) {
         this.factory = factory;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public TransferDetailDTO.TransferDetailDTOBuilder transferReceipt(final TransferDTO transferReceipt) {
         this.transferReceipt = transferReceipt;
         return this;
      }

      public TransferDetailDTO build() {
         return new TransferDetailDTO(
            this.id,
            this.boolPartyA,
            this.classifyId,
            this.basicClass,
            this.specification,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.invoiceType,
            this.taxRate,
            this.mete,
            this.unitPrice,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.project,
            this.factory,
            this.warehouse,
            this.transferReceipt
         );
      }

      @Override
      public String toString() {
         return "TransferDetailDTO.TransferDetailDTOBuilder(id="
            + this.id
            + ", boolPartyA="
            + this.boolPartyA
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
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
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", mete="
            + this.mete
            + ", unitPrice="
            + this.unitPrice
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", inputVAT="
            + this.inputVAT
            + ", project="
            + this.project
            + ", factory="
            + this.factory
            + ", warehouse="
            + this.warehouse
            + ", transferReceipt="
            + this.transferReceipt
            + ")";
      }
   }
}
