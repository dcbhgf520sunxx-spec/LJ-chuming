package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "ContractFixedAssetsDepreciation对象", description = "固定资产折旧表dto ")
public class ContractFixedAssetsDepreciationDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "type", value = "类型 (1厂房折旧 2以后添加)", notes = "类型 (1厂房折旧 2以后添加)")
   private Integer type;
   @ApiModelProperty(name = "name", value = "目标名称", notes = "目标名称")
   private String name;
   @ApiModelProperty(name = "originalValue", value = "原值(元)", notes = "原值(元)")
   private BigDecimal originalValue;
   @ApiModelProperty(name = "depreciationYear", value = "折旧年限", notes = "折旧年限")
   private BigDecimal depreciationYear;
   @ApiModelProperty(name = "startDate", value = "开始计算折旧日期", notes = "开始计算折旧日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "yearMonthValue", value = "年月(格式 202208)", notes = "年月(格式 202208)")
   private Integer yearMonthValue;
   @ApiModelProperty(name = "endYearMonth", value = "结束计算年月(格式 202208)", notes = "结束计算年月(格式 202208)")
   private Integer endYearMonth;
   @ApiModelProperty(name = "residualValue", value = "残值(元) (年限到期后价值)", notes = "残值(元) (年限到期后价值)")
   private BigDecimal residualValue;
   @ApiModelProperty(name = "residualValueRate", value = "残值率 (残值/原值)", notes = "残值率 (残值/原值)")
   private BigDecimal residualValueRate;
   @ApiModelProperty(name = "yearDepreciationAmount", value = "年折旧额", notes = "年折旧额")
   private BigDecimal yearDepreciationAmount;
   @ApiModelProperty(name = "yearDepreciationRate", value = "年折旧率", notes = "年折旧率")
   private BigDecimal yearDepreciationRate;
   @ApiModelProperty(name = "monthDepreciationAmount", value = "月折旧额", notes = "月折旧额")
   private BigDecimal monthDepreciationAmount;
   @ApiModelProperty(name = "monthDepreciationRate", value = "月折旧率", notes = "月折旧率")
   private BigDecimal monthDepreciationRate;
   @ApiModelProperty(name = "userId", value = "录用用户ID", notes = "录用用户ID")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "录用用户", notes = "录用用户")
   private String userName;
   @ApiModelProperty(name = "boolStatus", value = "状态 false关闭 true开启", notes = "状态 false关闭 true开启")
   private Boolean boolStatus;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder builder() {
      return new ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder();
   }

   public ContractFixedAssetsDepreciationDTO() {
   }

   public ContractFixedAssetsDepreciationDTO(
      final Long id,
      final Integer type,
      final String name,
      final BigDecimal originalValue,
      final BigDecimal depreciationYear,
      final LocalDate startDate,
      final Integer yearMonthValue,
      final Integer endYearMonth,
      final BigDecimal residualValue,
      final BigDecimal residualValueRate,
      final BigDecimal yearDepreciationAmount,
      final BigDecimal yearDepreciationRate,
      final BigDecimal monthDepreciationAmount,
      final BigDecimal monthDepreciationRate,
      final Long userId,
      final String userName,
      final Boolean boolStatus,
      final String attachmentIds,
      final String remark
   ) {
      this.id = id;
      this.type = type;
      this.name = name;
      this.originalValue = originalValue;
      this.depreciationYear = depreciationYear;
      this.startDate = startDate;
      this.yearMonthValue = yearMonthValue;
      this.endYearMonth = endYearMonth;
      this.residualValue = residualValue;
      this.residualValueRate = residualValueRate;
      this.yearDepreciationAmount = yearDepreciationAmount;
      this.yearDepreciationRate = yearDepreciationRate;
      this.monthDepreciationAmount = monthDepreciationAmount;
      this.monthDepreciationRate = monthDepreciationRate;
      this.userId = userId;
      this.userName = userName;
      this.boolStatus = boolStatus;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getOriginalValue() {
      return this.originalValue;
   }

   public BigDecimal getDepreciationYear() {
      return this.depreciationYear;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public Integer getYearMonthValue() {
      return this.yearMonthValue;
   }

   public Integer getEndYearMonth() {
      return this.endYearMonth;
   }

   public BigDecimal getResidualValue() {
      return this.residualValue;
   }

   public BigDecimal getResidualValueRate() {
      return this.residualValueRate;
   }

   public BigDecimal getYearDepreciationAmount() {
      return this.yearDepreciationAmount;
   }

   public BigDecimal getYearDepreciationRate() {
      return this.yearDepreciationRate;
   }

   public BigDecimal getMonthDepreciationAmount() {
      return this.monthDepreciationAmount;
   }

   public BigDecimal getMonthDepreciationRate() {
      return this.monthDepreciationRate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Boolean getBoolStatus() {
      return this.boolStatus;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setOriginalValue(final BigDecimal originalValue) {
      this.originalValue = originalValue;
   }

   public void setDepreciationYear(final BigDecimal depreciationYear) {
      this.depreciationYear = depreciationYear;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
   }

   public void setEndYearMonth(final Integer endYearMonth) {
      this.endYearMonth = endYearMonth;
   }

   public void setResidualValue(final BigDecimal residualValue) {
      this.residualValue = residualValue;
   }

   public void setResidualValueRate(final BigDecimal residualValueRate) {
      this.residualValueRate = residualValueRate;
   }

   public void setYearDepreciationAmount(final BigDecimal yearDepreciationAmount) {
      this.yearDepreciationAmount = yearDepreciationAmount;
   }

   public void setYearDepreciationRate(final BigDecimal yearDepreciationRate) {
      this.yearDepreciationRate = yearDepreciationRate;
   }

   public void setMonthDepreciationAmount(final BigDecimal monthDepreciationAmount) {
      this.monthDepreciationAmount = monthDepreciationAmount;
   }

   public void setMonthDepreciationRate(final BigDecimal monthDepreciationRate) {
      this.monthDepreciationRate = monthDepreciationRate;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setBoolStatus(final Boolean boolStatus) {
      this.boolStatus = boolStatus;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractFixedAssetsDepreciationDTO)) {
         return false;
      }

      ContractFixedAssetsDepreciationDTO other = (ContractFixedAssetsDepreciationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$yearMonthValue = this.getYearMonthValue();
            Object other$yearMonthValue = other.getYearMonthValue();
            if (this$yearMonthValue == null ? other$yearMonthValue == null : this$yearMonthValue.equals(other$yearMonthValue)) {
               Object this$endYearMonth = this.getEndYearMonth();
               Object other$endYearMonth = other.getEndYearMonth();
               if (this$endYearMonth == null ? other$endYearMonth == null : this$endYearMonth.equals(other$endYearMonth)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$boolStatus = this.getBoolStatus();
                     Object other$boolStatus = other.getBoolStatus();
                     if (this$boolStatus == null ? other$boolStatus == null : this$boolStatus.equals(other$boolStatus)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$originalValue = this.getOriginalValue();
                           Object other$originalValue = other.getOriginalValue();
                           if (this$originalValue == null ? other$originalValue == null : this$originalValue.equals(other$originalValue)) {
                              Object this$depreciationYear = this.getDepreciationYear();
                              Object other$depreciationYear = other.getDepreciationYear();
                              if (this$depreciationYear == null ? other$depreciationYear == null : this$depreciationYear.equals(other$depreciationYear)) {
                                 Object this$startDate = this.getStartDate();
                                 Object other$startDate = other.getStartDate();
                                 if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                    Object this$residualValue = this.getResidualValue();
                                    Object other$residualValue = other.getResidualValue();
                                    if (this$residualValue == null ? other$residualValue == null : this$residualValue.equals(other$residualValue)) {
                                       Object this$residualValueRate = this.getResidualValueRate();
                                       Object other$residualValueRate = other.getResidualValueRate();
                                       if (this$residualValueRate == null
                                          ? other$residualValueRate == null
                                          : this$residualValueRate.equals(other$residualValueRate)) {
                                          Object this$yearDepreciationAmount = this.getYearDepreciationAmount();
                                          Object other$yearDepreciationAmount = other.getYearDepreciationAmount();
                                          if (this$yearDepreciationAmount == null
                                             ? other$yearDepreciationAmount == null
                                             : this$yearDepreciationAmount.equals(other$yearDepreciationAmount)) {
                                             Object this$yearDepreciationRate = this.getYearDepreciationRate();
                                             Object other$yearDepreciationRate = other.getYearDepreciationRate();
                                             if (this$yearDepreciationRate == null
                                                ? other$yearDepreciationRate == null
                                                : this$yearDepreciationRate.equals(other$yearDepreciationRate)) {
                                                Object this$monthDepreciationAmount = this.getMonthDepreciationAmount();
                                                Object other$monthDepreciationAmount = other.getMonthDepreciationAmount();
                                                if (this$monthDepreciationAmount == null
                                                   ? other$monthDepreciationAmount == null
                                                   : this$monthDepreciationAmount.equals(other$monthDepreciationAmount)) {
                                                   Object this$monthDepreciationRate = this.getMonthDepreciationRate();
                                                   Object other$monthDepreciationRate = other.getMonthDepreciationRate();
                                                   if (this$monthDepreciationRate == null
                                                      ? other$monthDepreciationRate == null
                                                      : this$monthDepreciationRate.equals(other$monthDepreciationRate)) {
                                                      Object this$userName = this.getUserName();
                                                      Object other$userName = other.getUserName();
                                                      if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                         Object this$attachmentIds = this.getAttachmentIds();
                                                         Object other$attachmentIds = other.getAttachmentIds();
                                                         if (this$attachmentIds == null
                                                            ? other$attachmentIds == null
                                                            : this$attachmentIds.equals(other$attachmentIds)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ContractFixedAssetsDepreciationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $yearMonthValue = this.getYearMonthValue();
      result = result * 59 + ($yearMonthValue == null ? 43 : $yearMonthValue.hashCode());
      Object $endYearMonth = this.getEndYearMonth();
      result = result * 59 + ($endYearMonth == null ? 43 : $endYearMonth.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolStatus = this.getBoolStatus();
      result = result * 59 + ($boolStatus == null ? 43 : $boolStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $originalValue = this.getOriginalValue();
      result = result * 59 + ($originalValue == null ? 43 : $originalValue.hashCode());
      Object $depreciationYear = this.getDepreciationYear();
      result = result * 59 + ($depreciationYear == null ? 43 : $depreciationYear.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $residualValue = this.getResidualValue();
      result = result * 59 + ($residualValue == null ? 43 : $residualValue.hashCode());
      Object $residualValueRate = this.getResidualValueRate();
      result = result * 59 + ($residualValueRate == null ? 43 : $residualValueRate.hashCode());
      Object $yearDepreciationAmount = this.getYearDepreciationAmount();
      result = result * 59 + ($yearDepreciationAmount == null ? 43 : $yearDepreciationAmount.hashCode());
      Object $yearDepreciationRate = this.getYearDepreciationRate();
      result = result * 59 + ($yearDepreciationRate == null ? 43 : $yearDepreciationRate.hashCode());
      Object $monthDepreciationAmount = this.getMonthDepreciationAmount();
      result = result * 59 + ($monthDepreciationAmount == null ? 43 : $monthDepreciationAmount.hashCode());
      Object $monthDepreciationRate = this.getMonthDepreciationRate();
      result = result * 59 + ($monthDepreciationRate == null ? 43 : $monthDepreciationRate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractFixedAssetsDepreciationDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", name="
         + this.getName()
         + ", originalValue="
         + this.getOriginalValue()
         + ", depreciationYear="
         + this.getDepreciationYear()
         + ", startDate="
         + this.getStartDate()
         + ", yearMonthValue="
         + this.getYearMonthValue()
         + ", endYearMonth="
         + this.getEndYearMonth()
         + ", residualValue="
         + this.getResidualValue()
         + ", residualValueRate="
         + this.getResidualValueRate()
         + ", yearDepreciationAmount="
         + this.getYearDepreciationAmount()
         + ", yearDepreciationRate="
         + this.getYearDepreciationRate()
         + ", monthDepreciationAmount="
         + this.getMonthDepreciationAmount()
         + ", monthDepreciationRate="
         + this.getMonthDepreciationRate()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", boolStatus="
         + this.getBoolStatus()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractFixedAssetsDepreciationDTOBuilder {
      private Long id;
      private Integer type;
      private String name;
      private BigDecimal originalValue;
      private BigDecimal depreciationYear;
      private LocalDate startDate;
      private Integer yearMonthValue;
      private Integer endYearMonth;
      private BigDecimal residualValue;
      private BigDecimal residualValueRate;
      private BigDecimal yearDepreciationAmount;
      private BigDecimal yearDepreciationRate;
      private BigDecimal monthDepreciationAmount;
      private BigDecimal monthDepreciationRate;
      private Long userId;
      private String userName;
      private Boolean boolStatus;
      private String attachmentIds;
      private String remark;

      ContractFixedAssetsDepreciationDTOBuilder() {
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder originalValue(final BigDecimal originalValue) {
         this.originalValue = originalValue;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder depreciationYear(final BigDecimal depreciationYear) {
         this.depreciationYear = depreciationYear;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder endYearMonth(final Integer endYearMonth) {
         this.endYearMonth = endYearMonth;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder residualValue(final BigDecimal residualValue) {
         this.residualValue = residualValue;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder residualValueRate(final BigDecimal residualValueRate) {
         this.residualValueRate = residualValueRate;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder yearDepreciationAmount(final BigDecimal yearDepreciationAmount) {
         this.yearDepreciationAmount = yearDepreciationAmount;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder yearDepreciationRate(final BigDecimal yearDepreciationRate) {
         this.yearDepreciationRate = yearDepreciationRate;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder monthDepreciationAmount(final BigDecimal monthDepreciationAmount) {
         this.monthDepreciationAmount = monthDepreciationAmount;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder monthDepreciationRate(final BigDecimal monthDepreciationRate) {
         this.monthDepreciationRate = monthDepreciationRate;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder boolStatus(final Boolean boolStatus) {
         this.boolStatus = boolStatus;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractFixedAssetsDepreciationDTO build() {
         return new ContractFixedAssetsDepreciationDTO(
            this.id,
            this.type,
            this.name,
            this.originalValue,
            this.depreciationYear,
            this.startDate,
            this.yearMonthValue,
            this.endYearMonth,
            this.residualValue,
            this.residualValueRate,
            this.yearDepreciationAmount,
            this.yearDepreciationRate,
            this.monthDepreciationAmount,
            this.monthDepreciationRate,
            this.userId,
            this.userName,
            this.boolStatus,
            this.attachmentIds,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractFixedAssetsDepreciationDTO.ContractFixedAssetsDepreciationDTOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", name="
            + this.name
            + ", originalValue="
            + this.originalValue
            + ", depreciationYear="
            + this.depreciationYear
            + ", startDate="
            + this.startDate
            + ", yearMonthValue="
            + this.yearMonthValue
            + ", endYearMonth="
            + this.endYearMonth
            + ", residualValue="
            + this.residualValue
            + ", residualValueRate="
            + this.residualValueRate
            + ", yearDepreciationAmount="
            + this.yearDepreciationAmount
            + ", yearDepreciationRate="
            + this.yearDepreciationRate
            + ", monthDepreciationAmount="
            + this.monthDepreciationAmount
            + ", monthDepreciationRate="
            + this.monthDepreciationRate
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", boolStatus="
            + this.boolStatus
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
