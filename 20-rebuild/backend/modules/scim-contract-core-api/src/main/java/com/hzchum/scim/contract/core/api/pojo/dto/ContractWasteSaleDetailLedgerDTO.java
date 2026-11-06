package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(value = "WasteSaleDetailWholeInfoDTO", description = "废料出售明细-完整信息类 ")
public class ContractWasteSaleDetailLedgerDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "WasteSaleId", value = "废料销售表id", notes = "废料销售表id")
   private Long WasteSaleId;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同表id", notes = "废料合同表id")
   private Long contractWasteId;
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "purchaser", value = "废料收购方", notes = "废料收购方")
   private String purchaser;
   @ApiModelProperty(name = "branchCompanyId", value = "出售单位id (分支机构id)", notes = "出售单位id (分支机构id)")
   private Long branchCompanyId;
   @ApiModelProperty(name = "branchCompanyName", value = "出售单位(分支机构)", notes = "出售单位(分支机构)")
   private String branchCompanyName;
   @ApiModelProperty(name = "plateNumber", value = "车牌号", notes = "车牌号")
   private String plateNumber;
   @ApiModelProperty(name = "wasteClassificationId", value = "废料种类表id", notes = "废料种类表id")
   private Long wasteClassificationId;
   @ApiModelProperty(name = "wasteClassificationName", value = "废料种类名称", notes = "废料种类名称")
   private String wasteClassificationName;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;
   @ApiModelProperty(name = "saleMete", value = "销量", notes = "销量")
   private BigDecimal saleMete;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;
   @ApiModelProperty(name = "amount", value = "金额 = 销量*单价", notes = "金额 = 销量*单价")
   private BigDecimal amount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "saleDate", value = "出售日期", notes = "出售日期")
   private LocalDate saleDate;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   private String auditUserName;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime auditTime;

   public static ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder builder() {
      return new ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder();
   }

   public ContractWasteSaleDetailLedgerDTO() {
   }

   public ContractWasteSaleDetailLedgerDTO(
      final Long id,
      final Long WasteSaleId,
      final Long contractWasteId,
      final String serialNumber,
      final String purchaser,
      final Long branchCompanyId,
      final String branchCompanyName,
      final String plateNumber,
      final Long wasteClassificationId,
      final String wasteClassificationName,
      final String measureUnit,
      final BigDecimal saleMete,
      final BigDecimal price,
      final BigDecimal amount,
      final String remark,
      final LocalDate saleDate,
      final Long createUserId,
      final String createUserName,
      final LocalDateTime createTime,
      final Integer auditStatusEnum,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.WasteSaleId = WasteSaleId;
      this.contractWasteId = contractWasteId;
      this.serialNumber = serialNumber;
      this.purchaser = purchaser;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.plateNumber = plateNumber;
      this.wasteClassificationId = wasteClassificationId;
      this.wasteClassificationName = wasteClassificationName;
      this.measureUnit = measureUnit;
      this.saleMete = saleMete;
      this.price = price;
      this.amount = amount;
      this.remark = remark;
      this.saleDate = saleDate;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.createTime = createTime;
      this.auditStatusEnum = auditStatusEnum;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWasteSaleId() {
      return this.WasteSaleId;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getPlateNumber() {
      return this.plateNumber;
   }

   public Long getWasteClassificationId() {
      return this.wasteClassificationId;
   }

   public String getWasteClassificationName() {
      return this.wasteClassificationName;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getSaleMete() {
      return this.saleMete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDate getSaleDate() {
      return this.saleDate;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWasteSaleId(final Long WasteSaleId) {
      this.WasteSaleId = WasteSaleId;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setPlateNumber(final String plateNumber) {
      this.plateNumber = plateNumber;
   }

   public void setWasteClassificationId(final Long wasteClassificationId) {
      this.wasteClassificationId = wasteClassificationId;
   }

   public void setWasteClassificationName(final String wasteClassificationName) {
      this.wasteClassificationName = wasteClassificationName;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setSaleMete(final BigDecimal saleMete) {
      this.saleMete = saleMete;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSaleDate(final LocalDate saleDate) {
      this.saleDate = saleDate;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWasteSaleDetailLedgerDTO)) {
         return false;
      }

      ContractWasteSaleDetailLedgerDTO other = (ContractWasteSaleDetailLedgerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$WasteSaleId = this.getWasteSaleId();
         Object other$WasteSaleId = other.getWasteSaleId();
         if (this$WasteSaleId == null ? other$WasteSaleId == null : this$WasteSaleId.equals(other$WasteSaleId)) {
            Object this$contractWasteId = this.getContractWasteId();
            Object other$contractWasteId = other.getContractWasteId();
            if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$wasteClassificationId = this.getWasteClassificationId();
                  Object other$wasteClassificationId = other.getWasteClassificationId();
                  if (this$wasteClassificationId == null ? other$wasteClassificationId == null : this$wasteClassificationId.equals(other$wasteClassificationId)
                     )
                   {
                     Object this$createUserId = this.getCreateUserId();
                     Object other$createUserId = other.getCreateUserId();
                     if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                        Object this$auditStatusEnum = this.getAuditStatusEnum();
                        Object other$auditStatusEnum = other.getAuditStatusEnum();
                        if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                           Object this$auditUserId = this.getAuditUserId();
                           Object other$auditUserId = other.getAuditUserId();
                           if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$purchaser = this.getPurchaser();
                                 Object other$purchaser = other.getPurchaser();
                                 if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
                                    Object this$branchCompanyName = this.getBranchCompanyName();
                                    Object other$branchCompanyName = other.getBranchCompanyName();
                                    if (this$branchCompanyName == null
                                       ? other$branchCompanyName == null
                                       : this$branchCompanyName.equals(other$branchCompanyName)) {
                                       Object this$plateNumber = this.getPlateNumber();
                                       Object other$plateNumber = other.getPlateNumber();
                                       if (this$plateNumber == null ? other$plateNumber == null : this$plateNumber.equals(other$plateNumber)) {
                                          Object this$wasteClassificationName = this.getWasteClassificationName();
                                          Object other$wasteClassificationName = other.getWasteClassificationName();
                                          if (this$wasteClassificationName == null
                                             ? other$wasteClassificationName == null
                                             : this$wasteClassificationName.equals(other$wasteClassificationName)) {
                                             Object this$measureUnit = this.getMeasureUnit();
                                             Object other$measureUnit = other.getMeasureUnit();
                                             if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                Object this$saleMete = this.getSaleMete();
                                                Object other$saleMete = other.getSaleMete();
                                                if (this$saleMete == null ? other$saleMete == null : this$saleMete.equals(other$saleMete)) {
                                                   Object this$price = this.getPrice();
                                                   Object other$price = other.getPrice();
                                                   if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                      Object this$amount = this.getAmount();
                                                      Object other$amount = other.getAmount();
                                                      if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                         Object this$remark = this.getRemark();
                                                         Object other$remark = other.getRemark();
                                                         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                            Object this$saleDate = this.getSaleDate();
                                                            Object other$saleDate = other.getSaleDate();
                                                            if (this$saleDate == null ? other$saleDate == null : this$saleDate.equals(other$saleDate)) {
                                                               Object this$createUserName = this.getCreateUserName();
                                                               Object other$createUserName = other.getCreateUserName();
                                                               if (this$createUserName == null
                                                                  ? other$createUserName == null
                                                                  : this$createUserName.equals(other$createUserName)) {
                                                                  Object this$createTime = this.getCreateTime();
                                                                  Object other$createTime = other.getCreateTime();
                                                                  if (this$createTime == null
                                                                     ? other$createTime == null
                                                                     : this$createTime.equals(other$createTime)) {
                                                                     Object this$auditUserName = this.getAuditUserName();
                                                                     Object other$auditUserName = other.getAuditUserName();
                                                                     if (this$auditUserName == null
                                                                        ? other$auditUserName == null
                                                                        : this$auditUserName.equals(other$auditUserName)) {
                                                                        Object this$auditTime = this.getAuditTime();
                                                                        Object other$auditTime = other.getAuditTime();
                                                                        return this$auditTime == null
                                                                           ? other$auditTime == null
                                                                           : this$auditTime.equals(other$auditTime);
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
      return other instanceof ContractWasteSaleDetailLedgerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $WasteSaleId = this.getWasteSaleId();
      result = result * 59 + ($WasteSaleId == null ? 43 : $WasteSaleId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $wasteClassificationId = this.getWasteClassificationId();
      result = result * 59 + ($wasteClassificationId == null ? 43 : $wasteClassificationId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $plateNumber = this.getPlateNumber();
      result = result * 59 + ($plateNumber == null ? 43 : $plateNumber.hashCode());
      Object $wasteClassificationName = this.getWasteClassificationName();
      result = result * 59 + ($wasteClassificationName == null ? 43 : $wasteClassificationName.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $saleMete = this.getSaleMete();
      result = result * 59 + ($saleMete == null ? 43 : $saleMete.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $saleDate = this.getSaleDate();
      result = result * 59 + ($saleDate == null ? 43 : $saleDate.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWasteSaleDetailLedgerDTO(id="
         + this.getId()
         + ", WasteSaleId="
         + this.getWasteSaleId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaser="
         + this.getPurchaser()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", plateNumber="
         + this.getPlateNumber()
         + ", wasteClassificationId="
         + this.getWasteClassificationId()
         + ", wasteClassificationName="
         + this.getWasteClassificationName()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", saleMete="
         + this.getSaleMete()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", remark="
         + this.getRemark()
         + ", saleDate="
         + this.getSaleDate()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   public static class ContractWasteSaleDetailLedgerDTOBuilder {
      private Long id;
      private Long WasteSaleId;
      private Long contractWasteId;
      private String serialNumber;
      private String purchaser;
      private Long branchCompanyId;
      private String branchCompanyName;
      private String plateNumber;
      private Long wasteClassificationId;
      private String wasteClassificationName;
      private String measureUnit;
      private BigDecimal saleMete;
      private BigDecimal price;
      private BigDecimal amount;
      private String remark;
      private LocalDate saleDate;
      private Long createUserId;
      private String createUserName;
      private LocalDateTime createTime;
      private Integer auditStatusEnum;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;

      ContractWasteSaleDetailLedgerDTOBuilder() {
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder WasteSaleId(final Long WasteSaleId) {
         this.WasteSaleId = WasteSaleId;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder plateNumber(final String plateNumber) {
         this.plateNumber = plateNumber;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder wasteClassificationId(final Long wasteClassificationId) {
         this.wasteClassificationId = wasteClassificationId;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder wasteClassificationName(final String wasteClassificationName) {
         this.wasteClassificationName = wasteClassificationName;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder saleMete(final BigDecimal saleMete) {
         this.saleMete = saleMete;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder saleDate(final LocalDate saleDate) {
         this.saleDate = saleDate;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractWasteSaleDetailLedgerDTO build() {
         return new ContractWasteSaleDetailLedgerDTO(
            this.id,
            this.WasteSaleId,
            this.contractWasteId,
            this.serialNumber,
            this.purchaser,
            this.branchCompanyId,
            this.branchCompanyName,
            this.plateNumber,
            this.wasteClassificationId,
            this.wasteClassificationName,
            this.measureUnit,
            this.saleMete,
            this.price,
            this.amount,
            this.remark,
            this.saleDate,
            this.createUserId,
            this.createUserName,
            this.createTime,
            this.auditStatusEnum,
            this.auditUserId,
            this.auditUserName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ContractWasteSaleDetailLedgerDTO.ContractWasteSaleDetailLedgerDTOBuilder(id="
            + this.id
            + ", WasteSaleId="
            + this.WasteSaleId
            + ", contractWasteId="
            + this.contractWasteId
            + ", serialNumber="
            + this.serialNumber
            + ", purchaser="
            + this.purchaser
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", plateNumber="
            + this.plateNumber
            + ", wasteClassificationId="
            + this.wasteClassificationId
            + ", wasteClassificationName="
            + this.wasteClassificationName
            + ", measureUnit="
            + this.measureUnit
            + ", saleMete="
            + this.saleMete
            + ", price="
            + this.price
            + ", amount="
            + this.amount
            + ", remark="
            + this.remark
            + ", saleDate="
            + this.saleDate
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", createTime="
            + this.createTime
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}
