package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("废料明细-查询类")
public class WasteSaleDetailQueryDtoParam {
   @ApiModelProperty(name = "startDate", value = "开始日期", notes = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "截止日期", notes = "截止日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "wasteClassificationId", value = "废料种类表id", notes = "废料种类表id")
   private Long wasteClassificationId;
   @ApiModelProperty(name = "branchCompanyId", value = "出售单位id (分支机构id)", notes = "出售单位id (分支机构id)")
   private Long branchCompanyId;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同表id", notes = "废料合同表id")
   private Long contractWasteId;
   @ApiModelProperty(name = "purchaser", value = "购买方", notes = "购买方")
   private String purchaser;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   private String auditUserName;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   private Integer auditStatusEnum;

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getWasteClassificationId() {
      return this.wasteClassificationId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setWasteClassificationId(final Long wasteClassificationId) {
      this.wasteClassificationId = wasteClassificationId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteSaleDetailQueryDtoParam)) {
         return false;
      }

      WasteSaleDetailQueryDtoParam other = (WasteSaleDetailQueryDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$wasteClassificationId = this.getWasteClassificationId();
      Object other$wasteClassificationId = other.getWasteClassificationId();
      if (this$wasteClassificationId == null ? other$wasteClassificationId == null : this$wasteClassificationId.equals(other$wasteClassificationId)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$contractWasteId = this.getContractWasteId();
            Object other$contractWasteId = other.getContractWasteId();
            if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
               Object this$auditStatusEnum = this.getAuditStatusEnum();
               Object other$auditStatusEnum = other.getAuditStatusEnum();
               if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$purchaser = this.getPurchaser();
                        Object other$purchaser = other.getPurchaser();
                        if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WasteSaleDetailQueryDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $wasteClassificationId = this.getWasteClassificationId();
      result = result * 59 + ($wasteClassificationId == null ? 43 : $wasteClassificationId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      return result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
   }

   @Override
   public String toString() {
      return "WasteSaleDetailQueryDtoParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", wasteClassificationId="
         + this.getWasteClassificationId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", purchaser="
         + this.getPurchaser()
         + ", createUserName="
         + this.getCreateUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ")";
   }
}
