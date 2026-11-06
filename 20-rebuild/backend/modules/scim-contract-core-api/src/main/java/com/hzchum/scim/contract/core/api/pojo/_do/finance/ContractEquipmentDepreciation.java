package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractEquipmentDepreciation对象", description = "设备折旧表")
@Entity
@TableName("contract_equipment_depreciation")
@Table(name = "contract_equipment_depreciation")
@org.hibernate.annotations.Table(appliesTo = "contract_equipment_depreciation", comment = "设备折旧表")
public class ContractEquipmentDepreciation extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "classificationName", value = "分类名称", notes = "分类名称")
   @TableField("classification_name")
   @Column(name = "classification_name", columnDefinition = "varchar(255)  COMMENT '分类名称'", nullable = true)
   private String classificationName;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构ID'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "equipmentName", value = "设备名称", notes = "设备名称")
   @TableField("equipment_name")
   @Column(name = "equipment_name", columnDefinition = "varchar(255)  COMMENT '设备名称'", nullable = true)
   private String equipmentName;
   @ApiModelProperty(name = "originalValue", value = "原值(元)", notes = "原值(元)")
   @TableField("original_value")
   @Column(name = "original_value", columnDefinition = "decimal(32,8)  COMMENT '原值(元)'", nullable = true)
   private BigDecimal originalValue;
   @ApiModelProperty(name = "depreciationYear", value = "折旧年限", notes = "折旧年限")
   @TableField("depreciation_year")
   @Column(name = "depreciation_year", columnDefinition = "decimal(32,8)  COMMENT '折旧年限'", nullable = true)
   private BigDecimal depreciationYear;
   @ApiModelProperty(name = "startDate", value = "开始计算折旧日期", notes = "开始计算折旧日期")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "datetime  COMMENT '开始计算折旧日期'", nullable = true)
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束计算折旧日期", notes = "结束计算折旧日期")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "datetime  COMMENT '结束计算折旧日期'", nullable = true)
   private LocalDate endDate;
   @ApiModelProperty(name = "residualValueRate", value = "残值率 (残值/原值)", notes = "残值率 (残值/原值)")
   @TableField("residual_value_rate")
   @Column(name = "residual_value_rate", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '残值率 (残值/原值)'", nullable = true)
   private BigDecimal residualValueRate;
   @ApiModelProperty(name = "residualValue", value = "残值(元) (年限到期后价值)", notes = "残值(元) (年限到期后价值)")
   @TableField("residual_value")
   @Column(name = "residual_value", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '残值(元) (年限到期后价值)'", nullable = true)
   private BigDecimal residualValue;
   @ApiModelProperty(name = "yearDepreciationRate", value = "年折旧率", notes = "年折旧率")
   @TableField("year_depreciation_rate")
   @Column(name = "year_depreciation_rate", columnDefinition = "decimal(32,8)  COMMENT '年折旧率'", nullable = true)
   private BigDecimal yearDepreciationRate;
   @ApiModelProperty(name = "yearDepreciationAmount", value = "年折旧额(元)", notes = "年折旧额(元)")
   @TableField("year_depreciation_amount")
   @Column(name = "year_depreciation_amount", columnDefinition = "decimal(32,8)  COMMENT '年折旧额(元)'", nullable = true)
   private BigDecimal yearDepreciationAmount;
   @ApiModelProperty(name = "monthDepreciationRate", value = "月折旧率", notes = "月折旧率")
   @TableField("month_depreciation_rate")
   @Column(name = "month_depreciation_rate", columnDefinition = "decimal(32,8)  COMMENT '月折旧率'", nullable = true)
   private BigDecimal monthDepreciationRate;
   @ApiModelProperty(name = "monthDepreciationAmount", value = "月折旧额(元)", notes = "月折旧额(元)")
   @TableField("month_depreciation_amount")
   @Column(name = "month_depreciation_amount", columnDefinition = "decimal(32,8)  COMMENT '月折旧额(元)'", nullable = true)
   private BigDecimal monthDepreciationAmount;
   @ApiModelProperty(name = "userId", value = "录用用户ID", notes = "录用用户ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '录用用户ID'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "boolStatus", value = "状态 0关闭 1开启", notes = "状态 0关闭 1开启")
   @TableField("bool_status")
   @Column(name = "bool_status", columnDefinition = "tinyint(1) default '1' COMMENT '状态 0关闭 1开启'", nullable = true)
   private Boolean boolStatus;

   public static ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder builder() {
      return new ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder();
   }

   public ContractEquipmentDepreciation() {
   }

   public ContractEquipmentDepreciation(
      final Long id,
      final String classificationName,
      final Long branchCompanyId,
      final String equipmentName,
      final BigDecimal originalValue,
      final BigDecimal depreciationYear,
      final LocalDate startDate,
      final LocalDate endDate,
      final BigDecimal residualValueRate,
      final BigDecimal residualValue,
      final BigDecimal yearDepreciationRate,
      final BigDecimal yearDepreciationAmount,
      final BigDecimal monthDepreciationRate,
      final BigDecimal monthDepreciationAmount,
      final Long userId,
      final Boolean boolStatus
   ) {
      this.id = id;
      this.classificationName = classificationName;
      this.branchCompanyId = branchCompanyId;
      this.equipmentName = equipmentName;
      this.originalValue = originalValue;
      this.depreciationYear = depreciationYear;
      this.startDate = startDate;
      this.endDate = endDate;
      this.residualValueRate = residualValueRate;
      this.residualValue = residualValue;
      this.yearDepreciationRate = yearDepreciationRate;
      this.yearDepreciationAmount = yearDepreciationAmount;
      this.monthDepreciationRate = monthDepreciationRate;
      this.monthDepreciationAmount = monthDepreciationAmount;
      this.userId = userId;
      this.boolStatus = boolStatus;
   }

   public Long getId() {
      return this.id;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getEquipmentName() {
      return this.equipmentName;
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

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public BigDecimal getResidualValueRate() {
      return this.residualValueRate;
   }

   public BigDecimal getResidualValue() {
      return this.residualValue;
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

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolStatus() {
      return this.boolStatus;
   }

   public ContractEquipmentDepreciation setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractEquipmentDepreciation setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
      return this;
   }

   public ContractEquipmentDepreciation setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public ContractEquipmentDepreciation setEquipmentName(final String equipmentName) {
      this.equipmentName = equipmentName;
      return this;
   }

   public ContractEquipmentDepreciation setOriginalValue(final BigDecimal originalValue) {
      this.originalValue = originalValue;
      return this;
   }

   public ContractEquipmentDepreciation setDepreciationYear(final BigDecimal depreciationYear) {
      this.depreciationYear = depreciationYear;
      return this;
   }

   public ContractEquipmentDepreciation setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
      return this;
   }

   public ContractEquipmentDepreciation setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
      return this;
   }

   public ContractEquipmentDepreciation setResidualValueRate(final BigDecimal residualValueRate) {
      this.residualValueRate = residualValueRate;
      return this;
   }

   public ContractEquipmentDepreciation setResidualValue(final BigDecimal residualValue) {
      this.residualValue = residualValue;
      return this;
   }

   public ContractEquipmentDepreciation setYearDepreciationRate(final BigDecimal yearDepreciationRate) {
      this.yearDepreciationRate = yearDepreciationRate;
      return this;
   }

   public ContractEquipmentDepreciation setYearDepreciationAmount(final BigDecimal yearDepreciationAmount) {
      this.yearDepreciationAmount = yearDepreciationAmount;
      return this;
   }

   public ContractEquipmentDepreciation setMonthDepreciationRate(final BigDecimal monthDepreciationRate) {
      this.monthDepreciationRate = monthDepreciationRate;
      return this;
   }

   public ContractEquipmentDepreciation setMonthDepreciationAmount(final BigDecimal monthDepreciationAmount) {
      this.monthDepreciationAmount = monthDepreciationAmount;
      return this;
   }

   public ContractEquipmentDepreciation setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractEquipmentDepreciation setBoolStatus(final Boolean boolStatus) {
      this.boolStatus = boolStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ContractEquipmentDepreciation(id="
         + this.getId()
         + ", classificationName="
         + this.getClassificationName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", equipmentName="
         + this.getEquipmentName()
         + ", originalValue="
         + this.getOriginalValue()
         + ", depreciationYear="
         + this.getDepreciationYear()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", residualValueRate="
         + this.getResidualValueRate()
         + ", residualValue="
         + this.getResidualValue()
         + ", yearDepreciationRate="
         + this.getYearDepreciationRate()
         + ", yearDepreciationAmount="
         + this.getYearDepreciationAmount()
         + ", monthDepreciationRate="
         + this.getMonthDepreciationRate()
         + ", monthDepreciationAmount="
         + this.getMonthDepreciationAmount()
         + ", userId="
         + this.getUserId()
         + ", boolStatus="
         + this.getBoolStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractEquipmentDepreciation)) {
         return false;
      }

      ContractEquipmentDepreciation other = (ContractEquipmentDepreciation)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                  Object this$classificationName = this.getClassificationName();
                  Object other$classificationName = other.getClassificationName();
                  if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
                     Object this$equipmentName = this.getEquipmentName();
                     Object other$equipmentName = other.getEquipmentName();
                     if (this$equipmentName == null ? other$equipmentName == null : this$equipmentName.equals(other$equipmentName)) {
                        Object this$originalValue = this.getOriginalValue();
                        Object other$originalValue = other.getOriginalValue();
                        if (this$originalValue == null ? other$originalValue == null : this$originalValue.equals(other$originalValue)) {
                           Object this$depreciationYear = this.getDepreciationYear();
                           Object other$depreciationYear = other.getDepreciationYear();
                           if (this$depreciationYear == null ? other$depreciationYear == null : this$depreciationYear.equals(other$depreciationYear)) {
                              Object this$startDate = this.getStartDate();
                              Object other$startDate = other.getStartDate();
                              if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                 Object this$endDate = this.getEndDate();
                                 Object other$endDate = other.getEndDate();
                                 if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                    Object this$residualValueRate = this.getResidualValueRate();
                                    Object other$residualValueRate = other.getResidualValueRate();
                                    if (this$residualValueRate == null
                                       ? other$residualValueRate == null
                                       : this$residualValueRate.equals(other$residualValueRate)) {
                                       Object this$residualValue = this.getResidualValue();
                                       Object other$residualValue = other.getResidualValue();
                                       if (this$residualValue == null ? other$residualValue == null : this$residualValue.equals(other$residualValue)) {
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
                                                   return this$monthDepreciationAmount == null
                                                      ? other$monthDepreciationAmount == null
                                                      : this$monthDepreciationAmount.equals(other$monthDepreciationAmount);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractEquipmentDepreciation;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolStatus = this.getBoolStatus();
      result = result * 59 + ($boolStatus == null ? 43 : $boolStatus.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $equipmentName = this.getEquipmentName();
      result = result * 59 + ($equipmentName == null ? 43 : $equipmentName.hashCode());
      Object $originalValue = this.getOriginalValue();
      result = result * 59 + ($originalValue == null ? 43 : $originalValue.hashCode());
      Object $depreciationYear = this.getDepreciationYear();
      result = result * 59 + ($depreciationYear == null ? 43 : $depreciationYear.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $residualValueRate = this.getResidualValueRate();
      result = result * 59 + ($residualValueRate == null ? 43 : $residualValueRate.hashCode());
      Object $residualValue = this.getResidualValue();
      result = result * 59 + ($residualValue == null ? 43 : $residualValue.hashCode());
      Object $yearDepreciationRate = this.getYearDepreciationRate();
      result = result * 59 + ($yearDepreciationRate == null ? 43 : $yearDepreciationRate.hashCode());
      Object $yearDepreciationAmount = this.getYearDepreciationAmount();
      result = result * 59 + ($yearDepreciationAmount == null ? 43 : $yearDepreciationAmount.hashCode());
      Object $monthDepreciationRate = this.getMonthDepreciationRate();
      result = result * 59 + ($monthDepreciationRate == null ? 43 : $monthDepreciationRate.hashCode());
      Object $monthDepreciationAmount = this.getMonthDepreciationAmount();
      return result * 59 + ($monthDepreciationAmount == null ? 43 : $monthDepreciationAmount.hashCode());
   }

   public static class ContractEquipmentDepreciationBuilder {
      private Long id;
      private String classificationName;
      private Long branchCompanyId;
      private String equipmentName;
      private BigDecimal originalValue;
      private BigDecimal depreciationYear;
      private LocalDate startDate;
      private LocalDate endDate;
      private BigDecimal residualValueRate;
      private BigDecimal residualValue;
      private BigDecimal yearDepreciationRate;
      private BigDecimal yearDepreciationAmount;
      private BigDecimal monthDepreciationRate;
      private BigDecimal monthDepreciationAmount;
      private Long userId;
      private Boolean boolStatus;

      ContractEquipmentDepreciationBuilder() {
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder equipmentName(final String equipmentName) {
         this.equipmentName = equipmentName;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder originalValue(final BigDecimal originalValue) {
         this.originalValue = originalValue;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder depreciationYear(final BigDecimal depreciationYear) {
         this.depreciationYear = depreciationYear;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder residualValueRate(final BigDecimal residualValueRate) {
         this.residualValueRate = residualValueRate;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder residualValue(final BigDecimal residualValue) {
         this.residualValue = residualValue;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder yearDepreciationRate(final BigDecimal yearDepreciationRate) {
         this.yearDepreciationRate = yearDepreciationRate;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder yearDepreciationAmount(final BigDecimal yearDepreciationAmount) {
         this.yearDepreciationAmount = yearDepreciationAmount;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder monthDepreciationRate(final BigDecimal monthDepreciationRate) {
         this.monthDepreciationRate = monthDepreciationRate;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder monthDepreciationAmount(final BigDecimal monthDepreciationAmount) {
         this.monthDepreciationAmount = monthDepreciationAmount;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder boolStatus(final Boolean boolStatus) {
         this.boolStatus = boolStatus;
         return this;
      }

      public ContractEquipmentDepreciation build() {
         return new ContractEquipmentDepreciation(
            this.id,
            this.classificationName,
            this.branchCompanyId,
            this.equipmentName,
            this.originalValue,
            this.depreciationYear,
            this.startDate,
            this.endDate,
            this.residualValueRate,
            this.residualValue,
            this.yearDepreciationRate,
            this.yearDepreciationAmount,
            this.monthDepreciationRate,
            this.monthDepreciationAmount,
            this.userId,
            this.boolStatus
         );
      }

      @Override
      public String toString() {
         return "ContractEquipmentDepreciation.ContractEquipmentDepreciationBuilder(id="
            + this.id
            + ", classificationName="
            + this.classificationName
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", equipmentName="
            + this.equipmentName
            + ", originalValue="
            + this.originalValue
            + ", depreciationYear="
            + this.depreciationYear
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", residualValueRate="
            + this.residualValueRate
            + ", residualValue="
            + this.residualValue
            + ", yearDepreciationRate="
            + this.yearDepreciationRate
            + ", yearDepreciationAmount="
            + this.yearDepreciationAmount
            + ", monthDepreciationRate="
            + this.monthDepreciationRate
            + ", monthDepreciationAmount="
            + this.monthDepreciationAmount
            + ", userId="
            + this.userId
            + ", boolStatus="
            + this.boolStatus
            + ")";
      }
   }
}
