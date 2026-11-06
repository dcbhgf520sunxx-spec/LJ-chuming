package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "WasteSale对象", description = "废料出售记录表 ")
public class WasteSaleDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "saleDate", value = "出售日期", notes = "出售日期")
   private LocalDate saleDate;
   @ApiModelProperty(name = "branchCompanyId", value = "出售单位id (分支机构id)", notes = "出售单位id (分支机构id)")
   private Long branchCompanyId;
   @ApiModelProperty(name = "branchCompanyName", value = "出售单位(分支机构)", notes = "出售单位(分支机构)")
   private String branchCompanyName;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同表id", notes = "废料合同表id")
   private Long contractWasteId;
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "purchaser", value = "废料收购方", notes = "废料收购方")
   private String purchaser;
   @ApiModelProperty(name = "plateNumber", value = "车牌号", notes = "车牌号")
   private String plateNumber;
   @ApiModelProperty(name = "totalAmount", value = "总额", notes = "总额")
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "creatorRemark", value = "创建人备注", notes = "创建人备注")
   private String creatorRemark;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   private String auditUserName;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditorRemark", value = "审核人备注", notes = "审核人备注")
   private String auditorRemark;
   @ApiModelProperty(name = "wasteSaleDetailList", value = "废料销售明细列表", notes = "废料销售明细列表")
   private List<WasteSaleDetailDTO> wasteSaleDetailList;

   public static WasteSaleDTO.WasteSaleDTOBuilder builder() {
      return new WasteSaleDTO.WasteSaleDTOBuilder();
   }

   public WasteSaleDTO() {
   }

   public WasteSaleDTO(
      final Long id,
      final LocalDate saleDate,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long contractWasteId,
      final String serialNumber,
      final String purchaser,
      final String plateNumber,
      final BigDecimal totalAmount,
      final Long createUserId,
      final String createUserName,
      final LocalDateTime createTime,
      final String creatorRemark,
      final Integer auditStatusEnum,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final String auditorRemark,
      final List<WasteSaleDetailDTO> wasteSaleDetailList
   ) {
      this.id = id;
      this.saleDate = saleDate;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.contractWasteId = contractWasteId;
      this.serialNumber = serialNumber;
      this.purchaser = purchaser;
      this.plateNumber = plateNumber;
      this.totalAmount = totalAmount;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.createTime = createTime;
      this.creatorRemark = creatorRemark;
      this.auditStatusEnum = auditStatusEnum;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditorRemark = auditorRemark;
      this.wasteSaleDetailList = wasteSaleDetailList;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getSaleDate() {
      return this.saleDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
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

   public String getPlateNumber() {
      return this.plateNumber;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
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

   public String getCreatorRemark() {
      return this.creatorRemark;
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

   public String getAuditorRemark() {
      return this.auditorRemark;
   }

   public List<WasteSaleDetailDTO> getWasteSaleDetailList() {
      return this.wasteSaleDetailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSaleDate(final LocalDate saleDate) {
      this.saleDate = saleDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
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

   public void setPlateNumber(final String plateNumber) {
      this.plateNumber = plateNumber;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
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

   public void setCreatorRemark(final String creatorRemark) {
      this.creatorRemark = creatorRemark;
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

   public void setAuditorRemark(final String auditorRemark) {
      this.auditorRemark = auditorRemark;
   }

   public void setWasteSaleDetailList(final List<WasteSaleDetailDTO> wasteSaleDetailList) {
      this.wasteSaleDetailList = wasteSaleDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteSaleDTO)) {
         return false;
      }

      WasteSaleDTO other = (WasteSaleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$contractWasteId = this.getContractWasteId();
            Object other$contractWasteId = other.getContractWasteId();
            if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$auditStatusEnum = this.getAuditStatusEnum();
                  Object other$auditStatusEnum = other.getAuditStatusEnum();
                  if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                     Object this$auditUserId = this.getAuditUserId();
                     Object other$auditUserId = other.getAuditUserId();
                     if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                        Object this$saleDate = this.getSaleDate();
                        Object other$saleDate = other.getSaleDate();
                        if (this$saleDate == null ? other$saleDate == null : this$saleDate.equals(other$saleDate)) {
                           Object this$branchCompanyName = this.getBranchCompanyName();
                           Object other$branchCompanyName = other.getBranchCompanyName();
                           if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$purchaser = this.getPurchaser();
                                 Object other$purchaser = other.getPurchaser();
                                 if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
                                    Object this$plateNumber = this.getPlateNumber();
                                    Object other$plateNumber = other.getPlateNumber();
                                    if (this$plateNumber == null ? other$plateNumber == null : this$plateNumber.equals(other$plateNumber)) {
                                       Object this$totalAmount = this.getTotalAmount();
                                       Object other$totalAmount = other.getTotalAmount();
                                       if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                                          Object this$createUserName = this.getCreateUserName();
                                          Object other$createUserName = other.getCreateUserName();
                                          if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                             Object this$createTime = this.getCreateTime();
                                             Object other$createTime = other.getCreateTime();
                                             if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                Object this$creatorRemark = this.getCreatorRemark();
                                                Object other$creatorRemark = other.getCreatorRemark();
                                                if (this$creatorRemark == null ? other$creatorRemark == null : this$creatorRemark.equals(other$creatorRemark)) {
                                                   Object this$auditUserName = this.getAuditUserName();
                                                   Object other$auditUserName = other.getAuditUserName();
                                                   if (this$auditUserName == null
                                                      ? other$auditUserName == null
                                                      : this$auditUserName.equals(other$auditUserName)) {
                                                      Object this$auditTime = this.getAuditTime();
                                                      Object other$auditTime = other.getAuditTime();
                                                      if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                                         Object this$auditorRemark = this.getAuditorRemark();
                                                         Object other$auditorRemark = other.getAuditorRemark();
                                                         if (this$auditorRemark == null
                                                            ? other$auditorRemark == null
                                                            : this$auditorRemark.equals(other$auditorRemark)) {
                                                            Object this$wasteSaleDetailList = this.getWasteSaleDetailList();
                                                            Object other$wasteSaleDetailList = other.getWasteSaleDetailList();
                                                            return this$wasteSaleDetailList == null
                                                               ? other$wasteSaleDetailList == null
                                                               : this$wasteSaleDetailList.equals(other$wasteSaleDetailList);
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
      return other instanceof WasteSaleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $saleDate = this.getSaleDate();
      result = result * 59 + ($saleDate == null ? 43 : $saleDate.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $plateNumber = this.getPlateNumber();
      result = result * 59 + ($plateNumber == null ? 43 : $plateNumber.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $creatorRemark = this.getCreatorRemark();
      result = result * 59 + ($creatorRemark == null ? 43 : $creatorRemark.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $auditorRemark = this.getAuditorRemark();
      result = result * 59 + ($auditorRemark == null ? 43 : $auditorRemark.hashCode());
      Object $wasteSaleDetailList = this.getWasteSaleDetailList();
      return result * 59 + ($wasteSaleDetailList == null ? 43 : $wasteSaleDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "WasteSaleDTO(id="
         + this.getId()
         + ", saleDate="
         + this.getSaleDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaser="
         + this.getPurchaser()
         + ", plateNumber="
         + this.getPlateNumber()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", creatorRemark="
         + this.getCreatorRemark()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditorRemark="
         + this.getAuditorRemark()
         + ", wasteSaleDetailList="
         + this.getWasteSaleDetailList()
         + ")";
   }

   public static class WasteSaleDTOBuilder {
      private Long id;
      private LocalDate saleDate;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long contractWasteId;
      private String serialNumber;
      private String purchaser;
      private String plateNumber;
      private BigDecimal totalAmount;
      private Long createUserId;
      private String createUserName;
      private LocalDateTime createTime;
      private String creatorRemark;
      private Integer auditStatusEnum;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private String auditorRemark;
      private List<WasteSaleDetailDTO> wasteSaleDetailList;

      WasteSaleDTOBuilder() {
      }

      public WasteSaleDTO.WasteSaleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder saleDate(final LocalDate saleDate) {
         this.saleDate = saleDate;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder plateNumber(final String plateNumber) {
         this.plateNumber = plateNumber;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder creatorRemark(final String creatorRemark) {
         this.creatorRemark = creatorRemark;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder auditorRemark(final String auditorRemark) {
         this.auditorRemark = auditorRemark;
         return this;
      }

      public WasteSaleDTO.WasteSaleDTOBuilder wasteSaleDetailList(final List<WasteSaleDetailDTO> wasteSaleDetailList) {
         this.wasteSaleDetailList = wasteSaleDetailList;
         return this;
      }

      public WasteSaleDTO build() {
         return new WasteSaleDTO(
            this.id,
            this.saleDate,
            this.branchCompanyId,
            this.branchCompanyName,
            this.contractWasteId,
            this.serialNumber,
            this.purchaser,
            this.plateNumber,
            this.totalAmount,
            this.createUserId,
            this.createUserName,
            this.createTime,
            this.creatorRemark,
            this.auditStatusEnum,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.auditorRemark,
            this.wasteSaleDetailList
         );
      }

      @Override
      public String toString() {
         return "WasteSaleDTO.WasteSaleDTOBuilder(id="
            + this.id
            + ", saleDate="
            + this.saleDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", contractWasteId="
            + this.contractWasteId
            + ", serialNumber="
            + this.serialNumber
            + ", purchaser="
            + this.purchaser
            + ", plateNumber="
            + this.plateNumber
            + ", totalAmount="
            + this.totalAmount
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", createTime="
            + this.createTime
            + ", creatorRemark="
            + this.creatorRemark
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditorRemark="
            + this.auditorRemark
            + ", wasteSaleDetailList="
            + this.wasteSaleDetailList
            + ")";
      }
   }
}
