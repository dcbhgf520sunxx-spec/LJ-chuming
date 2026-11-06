package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(description = "厂房折旧DTO类")
public class FactoryBuildingDepreciationDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   private Long branchCompanyId;
   @ApiModelProperty("费用归属名称")
   private String branchCompanyName;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "grossFloorArea", value = "建筑面积(㎡)", notes = "建筑面积(㎡)")
   private BigDecimal grossFloorArea;
   @ApiModelProperty(name = "originalValue", value = "原值(元)", notes = "原值(元)")
   private BigDecimal originalValue;
   @ApiModelProperty(name = "startDate", value = "开始计算折旧日期", notes = "开始计算折旧日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束计算折旧日期", notes = "结束计算折旧日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "depreciationYear", value = "折旧年限", notes = "折旧年限")
   private BigDecimal depreciationYear;
   @ApiModelProperty(name = "residualValueRate", value = "残值率 (残值/原值)", notes = "残值率 (残值/原值)")
   private BigDecimal residualValueRate;
   @ApiModelProperty(name = "yearDepreciationRate", value = "年折旧率", notes = "年折旧率")
   private BigDecimal yearDepreciationRate;
   @ApiModelProperty(name = "yearDepreciationAmount", value = "年折旧额", notes = "年折旧额")
   private BigDecimal yearDepreciationAmount;
   @ApiModelProperty(name = "monthDepreciationRate", value = "月折旧率", notes = "月折旧率")
   private BigDecimal monthDepreciationRate;
   @ApiModelProperty(name = "monthDepreciationAmount", value = "月折旧额", notes = "月折旧额")
   private BigDecimal monthDepreciationAmount;
   @ApiModelProperty("剩余年限")
   private String remainingYears;
   @ApiModelProperty(name = "userId", value = "录用用户ID", notes = "录用用户ID")
   private Long userId;
   @ApiModelProperty("录用用户名称")
   private String userName;
   @ApiModelProperty(name = "boolStatus", value = "状态 0关闭 1开启", notes = "状态 0关闭 1开启")
   private Boolean boolStatus;

   public Long getId() {
      return this.id;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getGrossFloorArea() {
      return this.grossFloorArea;
   }

   public BigDecimal getOriginalValue() {
      return this.originalValue;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public BigDecimal getDepreciationYear() {
      return this.depreciationYear;
   }

   public BigDecimal getResidualValueRate() {
      return this.residualValueRate;
   }

   public BigDecimal getYearDepreciationRate() {
      return this.yearDepreciationRate;
   }

   public BigDecimal getYearDepreciationAmount() {
      return this.yearDepreciationAmount;
   }

   public BigDecimal getMonthDepreciationRate() {
      return this.monthDepreciationRate;
   }

   public BigDecimal getMonthDepreciationAmount() {
      return this.monthDepreciationAmount;
   }

   public String getRemainingYears() {
      return this.remainingYears;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setGrossFloorArea(final BigDecimal grossFloorArea) {
      this.grossFloorArea = grossFloorArea;
   }

   public void setOriginalValue(final BigDecimal originalValue) {
      this.originalValue = originalValue;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setDepreciationYear(final BigDecimal depreciationYear) {
      this.depreciationYear = depreciationYear;
   }

   public void setResidualValueRate(final BigDecimal residualValueRate) {
      this.residualValueRate = residualValueRate;
   }

   public void setYearDepreciationRate(final BigDecimal yearDepreciationRate) {
      this.yearDepreciationRate = yearDepreciationRate;
   }

   public void setYearDepreciationAmount(final BigDecimal yearDepreciationAmount) {
      this.yearDepreciationAmount = yearDepreciationAmount;
   }

   public void setMonthDepreciationRate(final BigDecimal monthDepreciationRate) {
      this.monthDepreciationRate = monthDepreciationRate;
   }

   public void setMonthDepreciationAmount(final BigDecimal monthDepreciationAmount) {
      this.monthDepreciationAmount = monthDepreciationAmount;
   }

   public void setRemainingYears(final String remainingYears) {
      this.remainingYears = remainingYears;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FactoryBuildingDepreciationDTO)) {
         return false;
      }

      FactoryBuildingDepreciationDTO other = (FactoryBuildingDepreciationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$boolStatus = this.getBoolStatus();
               Object other$boolStatus = other.getBoolStatus();
               if (this$boolStatus == null ? other$boolStatus == null : this$boolStatus.equals(other$boolStatus)) {
                  Object this$branchCompanyName = this.getBranchCompanyName();
                  Object other$branchCompanyName = other.getBranchCompanyName();
                  if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$grossFloorArea = this.getGrossFloorArea();
                        Object other$grossFloorArea = other.getGrossFloorArea();
                        if (this$grossFloorArea == null ? other$grossFloorArea == null : this$grossFloorArea.equals(other$grossFloorArea)) {
                           Object this$originalValue = this.getOriginalValue();
                           Object other$originalValue = other.getOriginalValue();
                           if (this$originalValue == null ? other$originalValue == null : this$originalValue.equals(other$originalValue)) {
                              Object this$startDate = this.getStartDate();
                              Object other$startDate = other.getStartDate();
                              if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                 Object this$endDate = this.getEndDate();
                                 Object other$endDate = other.getEndDate();
                                 if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                    Object this$depreciationYear = this.getDepreciationYear();
                                    Object other$depreciationYear = other.getDepreciationYear();
                                    if (this$depreciationYear == null ? other$depreciationYear == null : this$depreciationYear.equals(other$depreciationYear)) {
                                       Object this$residualValueRate = this.getResidualValueRate();
                                       Object other$residualValueRate = other.getResidualValueRate();
                                       if (this$residualValueRate == null
                                          ? other$residualValueRate == null
                                          : this$residualValueRate.equals(other$residualValueRate)) {
                                          Object this$yearDepreciationRate = this.getYearDepreciationRate();
                                          Object other$yearDepreciationRate = other.getYearDepreciationRate();
                                          if (this$yearDepreciationRate == null
                                             ? other$yearDepreciationRate == null
                                             : this$yearDepreciationRate.equals(other$yearDepreciationRate)) {
                                             Object this$yearDepreciationAmount = this.getYearDepreciationAmount();
                                             Object other$yearDepreciationAmount = other.getYearDepreciationAmount();
                                             if (this$yearDepreciationAmount == null
                                                ? other$yearDepreciationAmount == null
                                                : this$yearDepreciationAmount.equals(other$yearDepreciationAmount)) {
                                                Object this$monthDepreciationRate = this.getMonthDepreciationRate();
                                                Object other$monthDepreciationRate = other.getMonthDepreciationRate();
                                                if (this$monthDepreciationRate == null
                                                   ? other$monthDepreciationRate == null
                                                   : this$monthDepreciationRate.equals(other$monthDepreciationRate)) {
                                                   Object this$monthDepreciationAmount = this.getMonthDepreciationAmount();
                                                   Object other$monthDepreciationAmount = other.getMonthDepreciationAmount();
                                                   if (this$monthDepreciationAmount == null
                                                      ? other$monthDepreciationAmount == null
                                                      : this$monthDepreciationAmount.equals(other$monthDepreciationAmount)) {
                                                      Object this$remainingYears = this.getRemainingYears();
                                                      Object other$remainingYears = other.getRemainingYears();
                                                      if (this$remainingYears == null
                                                         ? other$remainingYears == null
                                                         : this$remainingYears.equals(other$remainingYears)) {
                                                         Object this$userName = this.getUserName();
                                                         Object other$userName = other.getUserName();
                                                         return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof FactoryBuildingDepreciationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolStatus = this.getBoolStatus();
      result = result * 59 + ($boolStatus == null ? 43 : $boolStatus.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $grossFloorArea = this.getGrossFloorArea();
      result = result * 59 + ($grossFloorArea == null ? 43 : $grossFloorArea.hashCode());
      Object $originalValue = this.getOriginalValue();
      result = result * 59 + ($originalValue == null ? 43 : $originalValue.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $depreciationYear = this.getDepreciationYear();
      result = result * 59 + ($depreciationYear == null ? 43 : $depreciationYear.hashCode());
      Object $residualValueRate = this.getResidualValueRate();
      result = result * 59 + ($residualValueRate == null ? 43 : $residualValueRate.hashCode());
      Object $yearDepreciationRate = this.getYearDepreciationRate();
      result = result * 59 + ($yearDepreciationRate == null ? 43 : $yearDepreciationRate.hashCode());
      Object $yearDepreciationAmount = this.getYearDepreciationAmount();
      result = result * 59 + ($yearDepreciationAmount == null ? 43 : $yearDepreciationAmount.hashCode());
      Object $monthDepreciationRate = this.getMonthDepreciationRate();
      result = result * 59 + ($monthDepreciationRate == null ? 43 : $monthDepreciationRate.hashCode());
      Object $monthDepreciationAmount = this.getMonthDepreciationAmount();
      result = result * 59 + ($monthDepreciationAmount == null ? 43 : $monthDepreciationAmount.hashCode());
      Object $remainingYears = this.getRemainingYears();
      result = result * 59 + ($remainingYears == null ? 43 : $remainingYears.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "FactoryBuildingDepreciationDTO(id="
         + this.getId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", name="
         + this.getName()
         + ", grossFloorArea="
         + this.getGrossFloorArea()
         + ", originalValue="
         + this.getOriginalValue()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", depreciationYear="
         + this.getDepreciationYear()
         + ", residualValueRate="
         + this.getResidualValueRate()
         + ", yearDepreciationRate="
         + this.getYearDepreciationRate()
         + ", yearDepreciationAmount="
         + this.getYearDepreciationAmount()
         + ", monthDepreciationRate="
         + this.getMonthDepreciationRate()
         + ", monthDepreciationAmount="
         + this.getMonthDepreciationAmount()
         + ", remainingYears="
         + this.getRemainingYears()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", boolStatus="
         + this.getBoolStatus()
         + ")";
   }
}
