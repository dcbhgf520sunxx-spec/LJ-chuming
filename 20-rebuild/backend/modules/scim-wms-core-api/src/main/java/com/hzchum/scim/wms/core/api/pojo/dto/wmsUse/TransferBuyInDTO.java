package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferBuyInDTO {
   private Long id;
   private Long classifyId;
   private Integer basicClass;
   private String specification;
   private BigDecimal mete;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String brand;
   private String color;
   private String heatNoAndBatchNo;
   private Integer invoiceType;
   private BigDecimal taxRate;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPriceExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amount;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amountExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inputVAT;
   private ProjectInfo project;
   private BriefIdAndNameDTO warehouse;
   private BriefIdAndSNDTO transfer;
   private String nationalStandard;
   private String applicantName;
   private LocalDateTime reviewTime;

   public static TransferBuyInDTO.TransferBuyInDTOBuilder builder() {
      return new TransferBuyInDTO.TransferBuyInDTOBuilder();
   }

   public Long getId() {
      return this.id;
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

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
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

   public ProjectInfo getProject() {
      return this.project;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public BriefIdAndSNDTO getTransfer() {
      return this.transfer;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setColor(final String color) {
      this.color = color;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
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

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setTransfer(final BriefIdAndSNDTO transfer) {
      this.transfer = transfer;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferBuyInDTO)) {
         return false;
      }

      TransferBuyInDTO other = (TransferBuyInDTO)o;
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
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$mete = this.getMete();
                     Object other$mete = other.getMete();
                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
                                       Object this$color = this.getColor();
                                       Object other$color = other.getColor();
                                       if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                          Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                          Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                          if (this$heatNoAndBatchNo == null
                                             ? other$heatNoAndBatchNo == null
                                             : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                             Object this$taxRate = this.getTaxRate();
                                             Object other$taxRate = other.getTaxRate();
                                             if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                Object this$unitPrice = this.getUnitPrice();
                                                Object other$unitPrice = other.getUnitPrice();
                                                if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
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
                                                            if (this$inputVAT == null ? other$inputVAT == null : this$inputVAT.equals(other$inputVAT)) {
                                                               Object this$project = this.getProject();
                                                               Object other$project = other.getProject();
                                                               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                  Object this$warehouse = this.getWarehouse();
                                                                  Object other$warehouse = other.getWarehouse();
                                                                  if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)
                                                                     )
                                                                   {
                                                                     Object this$transfer = this.getTransfer();
                                                                     Object other$transfer = other.getTransfer();
                                                                     if (this$transfer == null ? other$transfer == null : this$transfer.equals(other$transfer)) {
                                                                        Object this$nationalStandard = this.getNationalStandard();
                                                                        Object other$nationalStandard = other.getNationalStandard();
                                                                        if (this$nationalStandard == null
                                                                           ? other$nationalStandard == null
                                                                           : this$nationalStandard.equals(other$nationalStandard)) {
                                                                           Object this$applicantName = this.getApplicantName();
                                                                           Object other$applicantName = other.getApplicantName();
                                                                           if (this$applicantName == null
                                                                              ? other$applicantName == null
                                                                              : this$applicantName.equals(other$applicantName)) {
                                                                              Object this$reviewTime = this.getReviewTime();
                                                                              Object other$reviewTime = other.getReviewTime();
                                                                              return this$reviewTime == null
                                                                                 ? other$reviewTime == null
                                                                                 : this$reviewTime.equals(other$reviewTime);
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
      return other instanceof TransferBuyInDTO;
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
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
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
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
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
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $transfer = this.getTransfer();
      result = result * 59 + ($transfer == null ? 43 : $transfer.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   @Override
   public String toString() {
      return "TransferBuyInDTO(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", mete="
         + this.getMete()
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
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
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
         + ", project="
         + this.getProject()
         + ", warehouse="
         + this.getWarehouse()
         + ", transfer="
         + this.getTransfer()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewTime="
         + this.getReviewTime()
         + ")";
   }

   public TransferBuyInDTO(
      final Long id,
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final BigDecimal mete,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final ProjectInfo project,
      final BriefIdAndNameDTO warehouse,
      final BriefIdAndSNDTO transfer,
      final String nationalStandard,
      final String applicantName,
      final LocalDateTime reviewTime
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.mete = mete;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.project = project;
      this.warehouse = warehouse;
      this.transfer = transfer;
      this.nationalStandard = nationalStandard;
      this.applicantName = applicantName;
      this.reviewTime = reviewTime;
   }

   public TransferBuyInDTO() {
   }

   public static class TransferBuyInDTOBuilder {
      private Long id;
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private BigDecimal mete;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private ProjectInfo project;
      private BriefIdAndNameDTO warehouse;
      private BriefIdAndSNDTO transfer;
      private String nationalStandard;
      private String applicantName;
      private LocalDateTime reviewTime;

      TransferBuyInDTOBuilder() {
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder transfer(final BriefIdAndSNDTO transfer) {
         this.transfer = transfer;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public TransferBuyInDTO.TransferBuyInDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public TransferBuyInDTO build() {
         return new TransferBuyInDTO(
            this.id,
            this.classifyId,
            this.basicClass,
            this.specification,
            this.mete,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.invoiceType,
            this.taxRate,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.project,
            this.warehouse,
            this.transfer,
            this.nationalStandard,
            this.applicantName,
            this.reviewTime
         );
      }

      @Override
      public String toString() {
         return "TransferBuyInDTO.TransferBuyInDTOBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", mete="
            + this.mete
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
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
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
            + ", project="
            + this.project
            + ", warehouse="
            + this.warehouse
            + ", transfer="
            + this.transfer
            + ", nationalStandard="
            + this.nationalStandard
            + ", applicantName="
            + this.applicantName
            + ", reviewTime="
            + this.reviewTime
            + ")";
      }
   }
}
