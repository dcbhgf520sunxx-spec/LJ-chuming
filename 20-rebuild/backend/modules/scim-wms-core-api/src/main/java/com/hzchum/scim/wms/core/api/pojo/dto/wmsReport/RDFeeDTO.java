package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundListDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RDFeeDTO {
   private Long id;
   private String specification;
   private String nationalStandard;
   private Long classifyId;
   private Integer materialIsWhole;
   private Integer materialOutboundMode;
   private Integer basicClass;
   private BigDecimal quantity;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private String brand;
   private String heatNoAndBatchNo;
   private String color;
   private BigDecimal mete;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private BigDecimal unitPrice;
   private BigDecimal unitPriceExcludingVAT;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private BigDecimal unitPriceNoFreight;
   private BigDecimal unitPriceExcludingVATNoFreight;
   private BigDecimal amountNoFreight;
   private BigDecimal amountExcludingVATNoFreight;
   private BigDecimal inputVATNoFreight;
   private BigDecimal rdRate;
   private BigDecimal rdFee;
   private BigDecimal rdFeeNoFreight;
   private Boolean boolPartyA;
   private ProjectInfo project;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO mesWorkshop;
   private BriefIdAndNameDTO warehouse;
   private LocalDateTime outboundTime;
   private OutboundListDTO outboundReceipt;

   public static RDFeeDTO.RDFeeDTOBuilder builder() {
      return new RDFeeDTO.RDFeeDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Integer getMaterialOutboundMode() {
      return this.materialOutboundMode;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
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

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getMete() {
      return this.mete;
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

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVATNoFreight() {
      return this.unitPriceExcludingVATNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVATNoFreight() {
      return this.amountExcludingVATNoFreight;
   }

   public BigDecimal getInputVATNoFreight() {
      return this.inputVATNoFreight;
   }

   public BigDecimal getRdRate() {
      return this.rdRate;
   }

   public BigDecimal getRdFee() {
      return this.rdFee;
   }

   public BigDecimal getRdFeeNoFreight() {
      return this.rdFeeNoFreight;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public OutboundListDTO getOutboundReceipt() {
      return this.outboundReceipt;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setMaterialOutboundMode(final Integer materialOutboundMode) {
      this.materialOutboundMode = materialOutboundMode;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
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

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
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

   public void setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
   }

   public void setUnitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
   }

   public void setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
   }

   public void setAmountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
   }

   public void setInputVATNoFreight(final BigDecimal inputVATNoFreight) {
      this.inputVATNoFreight = inputVATNoFreight;
   }

   public void setRdRate(final BigDecimal rdRate) {
      this.rdRate = rdRate;
   }

   public void setRdFee(final BigDecimal rdFee) {
      this.rdFee = rdFee;
   }

   public void setRdFeeNoFreight(final BigDecimal rdFeeNoFreight) {
      this.rdFeeNoFreight = rdFeeNoFreight;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setMesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setOutboundReceipt(final OutboundListDTO outboundReceipt) {
      this.outboundReceipt = outboundReceipt;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RDFeeDTO)) {
         return false;
      }

      RDFeeDTO other = (RDFeeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$materialIsWhole = this.getMaterialIsWhole();
            Object other$materialIsWhole = other.getMaterialIsWhole();
            if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
               Object this$materialOutboundMode = this.getMaterialOutboundMode();
               Object other$materialOutboundMode = other.getMaterialOutboundMode();
               if (this$materialOutboundMode == null ? other$materialOutboundMode == null : this$materialOutboundMode.equals(other$materialOutboundMode)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$invoiceType = this.getInvoiceType();
                     Object other$invoiceType = other.getInvoiceType();
                     if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                        Object this$boolPartyA = this.getBoolPartyA();
                        Object other$boolPartyA = other.getBoolPartyA();
                        if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$nationalStandard = this.getNationalStandard();
                              Object other$nationalStandard = other.getNationalStandard();
                              if (this$nationalStandard == null ? other$nationalStandard == null : this$nationalStandard.equals(other$nationalStandard)) {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$width = this.getWidth();
                                       Object other$width = other.getWidth();
                                       if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                          Object this$thickness = this.getThickness();
                                          Object other$thickness = other.getThickness();
                                          if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
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
                                                      Object this$mete = this.getMete();
                                                      Object other$mete = other.getMete();
                                                      if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
                                                                        if (this$inputVAT == null
                                                                           ? other$inputVAT == null
                                                                           : this$inputVAT.equals(other$inputVAT)) {
                                                                           Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                           Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                           if (this$unitPriceNoFreight == null
                                                                              ? other$unitPriceNoFreight == null
                                                                              : this$unitPriceNoFreight.equals(other$unitPriceNoFreight)) {
                                                                              Object this$unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
                                                                              Object other$unitPriceExcludingVATNoFreight = other.getUnitPriceExcludingVATNoFreight();
                                                                              if (this$unitPriceExcludingVATNoFreight == null
                                                                                 ? other$unitPriceExcludingVATNoFreight == null
                                                                                 : this$unitPriceExcludingVATNoFreight.equals(
                                                                                    other$unitPriceExcludingVATNoFreight
                                                                                 )) {
                                                                                 Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                 Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                 if (this$amountNoFreight == null
                                                                                    ? other$amountNoFreight == null
                                                                                    : this$amountNoFreight.equals(other$amountNoFreight)) {
                                                                                    Object this$amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
                                                                                    Object other$amountExcludingVATNoFreight = other.getAmountExcludingVATNoFreight();
                                                                                    if (this$amountExcludingVATNoFreight == null
                                                                                       ? other$amountExcludingVATNoFreight == null
                                                                                       : this$amountExcludingVATNoFreight.equals(
                                                                                          other$amountExcludingVATNoFreight
                                                                                       )) {
                                                                                       Object this$inputVATNoFreight = this.getInputVATNoFreight();
                                                                                       Object other$inputVATNoFreight = other.getInputVATNoFreight();
                                                                                       if (this$inputVATNoFreight == null
                                                                                          ? other$inputVATNoFreight == null
                                                                                          : this$inputVATNoFreight.equals(other$inputVATNoFreight)) {
                                                                                          Object this$rdRate = this.getRdRate();
                                                                                          Object other$rdRate = other.getRdRate();
                                                                                          if (this$rdRate == null
                                                                                             ? other$rdRate == null
                                                                                             : this$rdRate.equals(other$rdRate)) {
                                                                                             Object this$rdFee = this.getRdFee();
                                                                                             Object other$rdFee = other.getRdFee();
                                                                                             if (this$rdFee == null
                                                                                                ? other$rdFee == null
                                                                                                : this$rdFee.equals(other$rdFee)) {
                                                                                                Object this$rdFeeNoFreight = this.getRdFeeNoFreight();
                                                                                                Object other$rdFeeNoFreight = other.getRdFeeNoFreight();
                                                                                                if (this$rdFeeNoFreight == null
                                                                                                   ? other$rdFeeNoFreight == null
                                                                                                   : this$rdFeeNoFreight.equals(other$rdFeeNoFreight)) {
                                                                                                   Object this$project = this.getProject();
                                                                                                   Object other$project = other.getProject();
                                                                                                   if (this$project == null
                                                                                                      ? other$project == null
                                                                                                      : this$project.equals(other$project)) {
                                                                                                      Object this$workshop = this.getWorkshop();
                                                                                                      Object other$workshop = other.getWorkshop();
                                                                                                      if (this$workshop == null
                                                                                                         ? other$workshop == null
                                                                                                         : this$workshop.equals(other$workshop)) {
                                                                                                         Object this$mesWorkshop = this.getMesWorkshop();
                                                                                                         Object other$mesWorkshop = other.getMesWorkshop();
                                                                                                         if (this$mesWorkshop == null
                                                                                                            ? other$mesWorkshop == null
                                                                                                            : this$mesWorkshop.equals(other$mesWorkshop)) {
                                                                                                            Object this$warehouse = this.getWarehouse();
                                                                                                            Object other$warehouse = other.getWarehouse();
                                                                                                            if (this$warehouse == null
                                                                                                               ? other$warehouse == null
                                                                                                               : this$warehouse.equals(other$warehouse)) {
                                                                                                               Object this$outboundTime = this.getOutboundTime();
                                                                                                               Object other$outboundTime = other.getOutboundTime();
                                                                                                               if (this$outboundTime == null
                                                                                                                  ? other$outboundTime == null
                                                                                                                  : this$outboundTime.equals(other$outboundTime)
                                                                                                                  )
                                                                                                                {
                                                                                                                  Object this$outboundReceipt = this.getOutboundReceipt();
                                                                                                                  Object other$outboundReceipt = other.getOutboundReceipt();
                                                                                                                  return this$outboundReceipt == null
                                                                                                                     ? other$outboundReceipt == null
                                                                                                                     : this$outboundReceipt.equals(
                                                                                                                        other$outboundReceipt
                                                                                                                     );
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
      return other instanceof RDFeeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $materialOutboundMode = this.getMaterialOutboundMode();
      result = result * 59 + ($materialOutboundMode == null ? 43 : $materialOutboundMode.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
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
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
      result = result * 59 + ($unitPriceExcludingVATNoFreight == null ? 43 : $unitPriceExcludingVATNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
      result = result * 59 + ($amountExcludingVATNoFreight == null ? 43 : $amountExcludingVATNoFreight.hashCode());
      Object $inputVATNoFreight = this.getInputVATNoFreight();
      result = result * 59 + ($inputVATNoFreight == null ? 43 : $inputVATNoFreight.hashCode());
      Object $rdRate = this.getRdRate();
      result = result * 59 + ($rdRate == null ? 43 : $rdRate.hashCode());
      Object $rdFee = this.getRdFee();
      result = result * 59 + ($rdFee == null ? 43 : $rdFee.hashCode());
      Object $rdFeeNoFreight = this.getRdFeeNoFreight();
      result = result * 59 + ($rdFeeNoFreight == null ? 43 : $rdFeeNoFreight.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $outboundReceipt = this.getOutboundReceipt();
      return result * 59 + ($outboundReceipt == null ? 43 : $outboundReceipt.hashCode());
   }

   @Override
   public String toString() {
      return "RDFeeDTO(id="
         + this.getId()
         + ", specification="
         + this.getSpecification()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", classifyId="
         + this.getClassifyId()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", materialOutboundMode="
         + this.getMaterialOutboundMode()
         + ", basicClass="
         + this.getBasicClass()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", mete="
         + this.getMete()
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
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVATNoFreight="
         + this.getUnitPriceExcludingVATNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVATNoFreight="
         + this.getAmountExcludingVATNoFreight()
         + ", inputVATNoFreight="
         + this.getInputVATNoFreight()
         + ", rdRate="
         + this.getRdRate()
         + ", rdFee="
         + this.getRdFee()
         + ", rdFeeNoFreight="
         + this.getRdFeeNoFreight()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", project="
         + this.getProject()
         + ", workshop="
         + this.getWorkshop()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", outboundReceipt="
         + this.getOutboundReceipt()
         + ")";
   }

   public RDFeeDTO(
      final Long id,
      final String specification,
      final String nationalStandard,
      final Long classifyId,
      final Integer materialIsWhole,
      final Integer materialOutboundMode,
      final Integer basicClass,
      final BigDecimal quantity,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final BigDecimal mete,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVATNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVATNoFreight,
      final BigDecimal inputVATNoFreight,
      final BigDecimal rdRate,
      final BigDecimal rdFee,
      final BigDecimal rdFeeNoFreight,
      final Boolean boolPartyA,
      final ProjectInfo project,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO mesWorkshop,
      final BriefIdAndNameDTO warehouse,
      final LocalDateTime outboundTime,
      final OutboundListDTO outboundReceipt
   ) {
      this.id = id;
      this.specification = specification;
      this.nationalStandard = nationalStandard;
      this.classifyId = classifyId;
      this.materialIsWhole = materialIsWhole;
      this.materialOutboundMode = materialOutboundMode;
      this.basicClass = basicClass;
      this.quantity = quantity;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.mete = mete;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
      this.inputVATNoFreight = inputVATNoFreight;
      this.rdRate = rdRate;
      this.rdFee = rdFee;
      this.rdFeeNoFreight = rdFeeNoFreight;
      this.boolPartyA = boolPartyA;
      this.project = project;
      this.workshop = workshop;
      this.mesWorkshop = mesWorkshop;
      this.warehouse = warehouse;
      this.outboundTime = outboundTime;
      this.outboundReceipt = outboundReceipt;
   }

   public RDFeeDTO() {
   }

   public static class RDFeeDTOBuilder {
      private Long id;
      private String specification;
      private String nationalStandard;
      private Long classifyId;
      private Integer materialIsWhole;
      private Integer materialOutboundMode;
      private Integer basicClass;
      private BigDecimal quantity;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private BigDecimal mete;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVATNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVATNoFreight;
      private BigDecimal inputVATNoFreight;
      private BigDecimal rdRate;
      private BigDecimal rdFee;
      private BigDecimal rdFeeNoFreight;
      private Boolean boolPartyA;
      private ProjectInfo project;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO mesWorkshop;
      private BriefIdAndNameDTO warehouse;
      private LocalDateTime outboundTime;
      private OutboundListDTO outboundReceipt;

      RDFeeDTOBuilder() {
      }

      public RDFeeDTO.RDFeeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder materialOutboundMode(final Integer materialOutboundMode) {
         this.materialOutboundMode = materialOutboundMode;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder unitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
         this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder amountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
         this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder inputVATNoFreight(final BigDecimal inputVATNoFreight) {
         this.inputVATNoFreight = inputVATNoFreight;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder rdRate(final BigDecimal rdRate) {
         this.rdRate = rdRate;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder rdFee(final BigDecimal rdFee) {
         this.rdFee = rdFee;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder rdFeeNoFreight(final BigDecimal rdFeeNoFreight) {
         this.rdFeeNoFreight = rdFeeNoFreight;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder mesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public RDFeeDTO.RDFeeDTOBuilder outboundReceipt(final OutboundListDTO outboundReceipt) {
         this.outboundReceipt = outboundReceipt;
         return this;
      }

      public RDFeeDTO build() {
         return new RDFeeDTO(
            this.id,
            this.specification,
            this.nationalStandard,
            this.classifyId,
            this.materialIsWhole,
            this.materialOutboundMode,
            this.basicClass,
            this.quantity,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.mete,
            this.invoiceType,
            this.taxRate,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVATNoFreight,
            this.amountNoFreight,
            this.amountExcludingVATNoFreight,
            this.inputVATNoFreight,
            this.rdRate,
            this.rdFee,
            this.rdFeeNoFreight,
            this.boolPartyA,
            this.project,
            this.workshop,
            this.mesWorkshop,
            this.warehouse,
            this.outboundTime,
            this.outboundReceipt
         );
      }

      @Override
      public String toString() {
         return "RDFeeDTO.RDFeeDTOBuilder(id="
            + this.id
            + ", specification="
            + this.specification
            + ", nationalStandard="
            + this.nationalStandard
            + ", classifyId="
            + this.classifyId
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", materialOutboundMode="
            + this.materialOutboundMode
            + ", basicClass="
            + this.basicClass
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", mete="
            + this.mete
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
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVATNoFreight="
            + this.unitPriceExcludingVATNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVATNoFreight="
            + this.amountExcludingVATNoFreight
            + ", inputVATNoFreight="
            + this.inputVATNoFreight
            + ", rdRate="
            + this.rdRate
            + ", rdFee="
            + this.rdFee
            + ", rdFeeNoFreight="
            + this.rdFeeNoFreight
            + ", boolPartyA="
            + this.boolPartyA
            + ", project="
            + this.project
            + ", workshop="
            + this.workshop
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", warehouse="
            + this.warehouse
            + ", outboundTime="
            + this.outboundTime
            + ", outboundReceipt="
            + this.outboundReceipt
            + ")";
      }
   }
}
