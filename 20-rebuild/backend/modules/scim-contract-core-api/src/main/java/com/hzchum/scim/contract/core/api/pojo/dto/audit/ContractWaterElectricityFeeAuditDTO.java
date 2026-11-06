package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(value = "ContractWaterElectricityPropertyFee对象", description = "水、电、物业费表")
public class ContractWaterElectricityFeeAuditDTO extends ContractFeeBaseInfo {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "type", value = "类型(1: 水, 2: 电, 3: 物业)", notes = "类型(1: 水, 2: 电, 3: 物业)")
   private Integer type;
   @ApiModelProperty(name = "yearMonthDate", value = "年月日期", notes = "年月日期")
   private LocalDate yearMonthDate;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   private Long branchCompanyId;
   @ApiModelProperty("费用归属")
   private String branchCompanyName;
   @ApiModelProperty(name = "userId", value = "录用用户ID", notes = "录用用户ID")
   private Long userId;
   @ApiModelProperty("录入人名称")
   private String userName;
   @ApiModelProperty(name = "consumption", value = "消耗量(水: 吨, 电: kw/h=度)", notes = "消耗量(水: 吨, 电: kw/h=度)")
   private BigDecimal consumption;
   @ApiModelProperty(name = "totalFee", value = "费用总额(元)", notes = "费用总额(元)")
   private BigDecimal totalFee;
   @ApiModelProperty(name = "averageUnitPrice", value = "平均单价(元)", notes = "平均单价(元)")
   private BigDecimal averageUnitPrice;
   @ApiModelProperty(name = "boolStatus", value = "状态(0: 禁用, 1: 启用)", notes = "状态(0: 禁用, 1: 启用)")
   private Boolean boolStatus;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "auditStatusEnum", value = "审批状态 1未审批 2已通过 4已驳回", notes = "审批状态 1未审批 2已通过 4已驳回")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   private LocalDateTime auditTime;

   public static ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder builder() {
      return new ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder();
   }

   public ContractWaterElectricityFeeAuditDTO() {
   }

   public ContractWaterElectricityFeeAuditDTO(
      final Integer type,
      final LocalDate yearMonthDate,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long userId,
      final String userName,
      final BigDecimal consumption,
      final BigDecimal totalFee,
      final BigDecimal averageUnitPrice,
      final Boolean boolStatus,
      final String remark,
      final Integer auditStatusEnum,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime
   ) {
      this.type = type;
      this.yearMonthDate = yearMonthDate;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.userId = userId;
      this.userName = userName;
      this.consumption = consumption;
      this.totalFee = totalFee;
      this.averageUnitPrice = averageUnitPrice;
      this.boolStatus = boolStatus;
      this.remark = remark;
      this.auditStatusEnum = auditStatusEnum;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDate getYearMonthDate() {
      return this.yearMonthDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public BigDecimal getConsumption() {
      return this.consumption;
   }

   public BigDecimal getTotalFee() {
      return this.totalFee;
   }

   public BigDecimal getAverageUnitPrice() {
      return this.averageUnitPrice;
   }

   public Boolean getBoolStatus() {
      return this.boolStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Long getAuditorId() {
      return this.auditorId;
   }

   public String getAuditorName() {
      return this.auditorName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setYearMonthDate(final LocalDate yearMonthDate) {
      this.yearMonthDate = yearMonthDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setConsumption(final BigDecimal consumption) {
      this.consumption = consumption;
   }

   public void setTotalFee(final BigDecimal totalFee) {
      this.totalFee = totalFee;
   }

   public void setAverageUnitPrice(final BigDecimal averageUnitPrice) {
      this.averageUnitPrice = averageUnitPrice;
   }

   public void setBoolStatus(final Boolean boolStatus) {
      this.boolStatus = boolStatus;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
   }

   public void setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWaterElectricityFeeAuditDTO)) {
         return false;
      }

      ContractWaterElectricityFeeAuditDTO other = (ContractWaterElectricityFeeAuditDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$boolStatus = this.getBoolStatus();
               Object other$boolStatus = other.getBoolStatus();
               if (this$boolStatus == null ? other$boolStatus == null : this$boolStatus.equals(other$boolStatus)) {
                  Object this$auditStatusEnum = this.getAuditStatusEnum();
                  Object other$auditStatusEnum = other.getAuditStatusEnum();
                  if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                     Object this$auditorId = this.getAuditorId();
                     Object other$auditorId = other.getAuditorId();
                     if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                        Object this$yearMonthDate = this.getYearMonthDate();
                        Object other$yearMonthDate = other.getYearMonthDate();
                        if (this$yearMonthDate == null ? other$yearMonthDate == null : this$yearMonthDate.equals(other$yearMonthDate)) {
                           Object this$branchCompanyName = this.getBranchCompanyName();
                           Object other$branchCompanyName = other.getBranchCompanyName();
                           if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                              Object this$userName = this.getUserName();
                              Object other$userName = other.getUserName();
                              if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                 Object this$consumption = this.getConsumption();
                                 Object other$consumption = other.getConsumption();
                                 if (this$consumption == null ? other$consumption == null : this$consumption.equals(other$consumption)) {
                                    Object this$totalFee = this.getTotalFee();
                                    Object other$totalFee = other.getTotalFee();
                                    if (this$totalFee == null ? other$totalFee == null : this$totalFee.equals(other$totalFee)) {
                                       Object this$averageUnitPrice = this.getAverageUnitPrice();
                                       Object other$averageUnitPrice = other.getAverageUnitPrice();
                                       if (this$averageUnitPrice == null
                                          ? other$averageUnitPrice == null
                                          : this$averageUnitPrice.equals(other$averageUnitPrice)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                             Object this$auditorName = this.getAuditorName();
                                             Object other$auditorName = other.getAuditorName();
                                             if (this$auditorName == null ? other$auditorName == null : this$auditorName.equals(other$auditorName)) {
                                                Object this$auditTime = this.getAuditTime();
                                                Object other$auditTime = other.getAuditTime();
                                                return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractWaterElectricityFeeAuditDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolStatus = this.getBoolStatus();
      result = result * 59 + ($boolStatus == null ? 43 : $boolStatus.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $yearMonthDate = this.getYearMonthDate();
      result = result * 59 + ($yearMonthDate == null ? 43 : $yearMonthDate.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $consumption = this.getConsumption();
      result = result * 59 + ($consumption == null ? 43 : $consumption.hashCode());
      Object $totalFee = this.getTotalFee();
      result = result * 59 + ($totalFee == null ? 43 : $totalFee.hashCode());
      Object $averageUnitPrice = this.getAverageUnitPrice();
      result = result * 59 + ($averageUnitPrice == null ? 43 : $averageUnitPrice.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWaterElectricityFeeAuditDTO(type="
         + this.getType()
         + ", yearMonthDate="
         + this.getYearMonthDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", consumption="
         + this.getConsumption()
         + ", totalFee="
         + this.getTotalFee()
         + ", averageUnitPrice="
         + this.getAverageUnitPrice()
         + ", boolStatus="
         + this.getBoolStatus()
         + ", remark="
         + this.getRemark()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   public static class ContractWaterElectricityFeeAuditDTOBuilder {
      private Integer type;
      private LocalDate yearMonthDate;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long userId;
      private String userName;
      private BigDecimal consumption;
      private BigDecimal totalFee;
      private BigDecimal averageUnitPrice;
      private Boolean boolStatus;
      private String remark;
      private Integer auditStatusEnum;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;

      ContractWaterElectricityFeeAuditDTOBuilder() {
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder yearMonthDate(final LocalDate yearMonthDate) {
         this.yearMonthDate = yearMonthDate;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder consumption(final BigDecimal consumption) {
         this.consumption = consumption;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder totalFee(final BigDecimal totalFee) {
         this.totalFee = totalFee;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder averageUnitPrice(final BigDecimal averageUnitPrice) {
         this.averageUnitPrice = averageUnitPrice;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder boolStatus(final Boolean boolStatus) {
         this.boolStatus = boolStatus;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractWaterElectricityFeeAuditDTO build() {
         return new ContractWaterElectricityFeeAuditDTO(
            this.type,
            this.yearMonthDate,
            this.branchCompanyId,
            this.branchCompanyName,
            this.userId,
            this.userName,
            this.consumption,
            this.totalFee,
            this.averageUnitPrice,
            this.boolStatus,
            this.remark,
            this.auditStatusEnum,
            this.auditorId,
            this.auditorName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ContractWaterElectricityFeeAuditDTO.ContractWaterElectricityFeeAuditDTOBuilder(type="
            + this.type
            + ", yearMonthDate="
            + this.yearMonthDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", consumption="
            + this.consumption
            + ", totalFee="
            + this.totalFee
            + ", averageUnitPrice="
            + this.averageUnitPrice
            + ", boolStatus="
            + this.boolStatus
            + ", remark="
            + this.remark
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}
