package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel(value = "WasteSale对象", description = "废料出售记录表 ")
public class WasteSaleQueryDtoParam {
   @ApiModelProperty(name = "startDate", value = "开始日期", notes = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "截止日期", notes = "截止日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "branchCompanyId", value = "出售单位id (分支机构id)", notes = "出售单位id (分支机构id)")
   private Long branchCompanyId;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同表id", notes = "废料合同表id")
   private Long contractWasteId;
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "purchaser", value = "合同收购方", notes = "合同收购方")
   private String purchaser;
   @ApiModelProperty(name = "plateNumber", value = "车牌号", notes = "车牌号")
   private String plateNumber;
   @ApiModelProperty(name = "wasteClassificationId", value = "废料种类表id", notes = "废料种类表id")
   private Long wasteClassificationId;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   private String auditUserName;

   public static WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder builder() {
      return new WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder();
   }

   public WasteSaleQueryDtoParam() {
   }

   public WasteSaleQueryDtoParam(
      final LocalDate startDate,
      final LocalDate endDate,
      final Long branchCompanyId,
      final Long contractWasteId,
      final String serialNumber,
      final String purchaser,
      final String plateNumber,
      final Long wasteClassificationId,
      final Integer auditStatusEnum,
      final String createUserName,
      final String auditUserName
   ) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.branchCompanyId = branchCompanyId;
      this.contractWasteId = contractWasteId;
      this.serialNumber = serialNumber;
      this.purchaser = purchaser;
      this.plateNumber = plateNumber;
      this.wasteClassificationId = wasteClassificationId;
      this.auditStatusEnum = auditStatusEnum;
      this.createUserName = createUserName;
      this.auditUserName = auditUserName;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
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

   public Long getWasteClassificationId() {
      return this.wasteClassificationId;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
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

   public void setWasteClassificationId(final Long wasteClassificationId) {
      this.wasteClassificationId = wasteClassificationId;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteSaleQueryDtoParam)) {
         return false;
      }

      WasteSaleQueryDtoParam other = (WasteSaleQueryDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$contractWasteId = this.getContractWasteId();
         Object other$contractWasteId = other.getContractWasteId();
         if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
            Object this$wasteClassificationId = this.getWasteClassificationId();
            Object other$wasteClassificationId = other.getWasteClassificationId();
            if (this$wasteClassificationId == null ? other$wasteClassificationId == null : this$wasteClassificationId.equals(other$wasteClassificationId)) {
               Object this$auditStatusEnum = this.getAuditStatusEnum();
               Object other$auditStatusEnum = other.getAuditStatusEnum();
               if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$purchaser = this.getPurchaser();
                           Object other$purchaser = other.getPurchaser();
                           if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
                              Object this$plateNumber = this.getPlateNumber();
                              Object other$plateNumber = other.getPlateNumber();
                              if (this$plateNumber == null ? other$plateNumber == null : this$plateNumber.equals(other$plateNumber)) {
                                 Object this$createUserName = this.getCreateUserName();
                                 Object other$createUserName = other.getCreateUserName();
                                 if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                    Object this$auditUserName = this.getAuditUserName();
                                    Object other$auditUserName = other.getAuditUserName();
                                    return this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName);
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
      return other instanceof WasteSaleQueryDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $wasteClassificationId = this.getWasteClassificationId();
      result = result * 59 + ($wasteClassificationId == null ? 43 : $wasteClassificationId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $plateNumber = this.getPlateNumber();
      result = result * 59 + ($plateNumber == null ? 43 : $plateNumber.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      return result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
   }

   @Override
   public String toString() {
      return "WasteSaleQueryDtoParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaser="
         + this.getPurchaser()
         + ", plateNumber="
         + this.getPlateNumber()
         + ", wasteClassificationId="
         + this.getWasteClassificationId()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", createUserName="
         + this.getCreateUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ")";
   }

   public static class WasteSaleQueryDtoParamBuilder {
      private LocalDate startDate;
      private LocalDate endDate;
      private Long branchCompanyId;
      private Long contractWasteId;
      private String serialNumber;
      private String purchaser;
      private String plateNumber;
      private Long wasteClassificationId;
      private Integer auditStatusEnum;
      private String createUserName;
      private String auditUserName;

      WasteSaleQueryDtoParamBuilder() {
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder plateNumber(final String plateNumber) {
         this.plateNumber = plateNumber;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder wasteClassificationId(final Long wasteClassificationId) {
         this.wasteClassificationId = wasteClassificationId;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public WasteSaleQueryDtoParam build() {
         return new WasteSaleQueryDtoParam(
            this.startDate,
            this.endDate,
            this.branchCompanyId,
            this.contractWasteId,
            this.serialNumber,
            this.purchaser,
            this.plateNumber,
            this.wasteClassificationId,
            this.auditStatusEnum,
            this.createUserName,
            this.auditUserName
         );
      }

      @Override
      public String toString() {
         return "WasteSaleQueryDtoParam.WasteSaleQueryDtoParamBuilder(startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", contractWasteId="
            + this.contractWasteId
            + ", serialNumber="
            + this.serialNumber
            + ", purchaser="
            + this.purchaser
            + ", plateNumber="
            + this.plateNumber
            + ", wasteClassificationId="
            + this.wasteClassificationId
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", createUserName="
            + this.createUserName
            + ", auditUserName="
            + this.auditUserName
            + ")";
      }
   }
}
