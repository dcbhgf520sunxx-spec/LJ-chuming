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

@ApiModel(value = "ContractFixedAssetsDepreciation对象", description = "固定资产折旧表 ")
@Entity
@TableName("contract_fixed_assets_depreciation")
@Table(name = "contract_fixed_assets_depreciation")
@org.hibernate.annotations.Table(appliesTo = "contract_fixed_assets_depreciation", comment = "固定资产折旧表 ")
public class ContractFixedAssetsDepreciation extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "type", value = "类型 (1厂房折旧 2以后添加)", notes = "类型 (1厂房折旧 2以后添加)")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '1' COMMENT '类型 (1厂房折旧 2以后添加)'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "originalValue", value = "原值(元)", notes = "原值(元)")
   @TableField("original_value")
   @Column(name = "original_value", columnDefinition = "decimal(32,8)  COMMENT '原值(元)'", nullable = false)
   private BigDecimal originalValue;
   @ApiModelProperty(name = "depreciationYear", value = "折旧年限", notes = "折旧年限")
   @TableField("depreciation_year")
   @Column(name = "depreciation_year", columnDefinition = "decimal(8,2) COMMENT '折旧年限'", nullable = false)
   private BigDecimal depreciationYear;
   @ApiModelProperty(name = "startDate", value = "开始计算折旧日期", notes = "开始计算折旧日期")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "date  COMMENT '开始计算折旧日期'", nullable = false)
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束计算折旧日期", notes = "结束计算折旧日期")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "date  COMMENT '结束计算折旧日期'", nullable = false)
   private LocalDate endDate;
   @ApiModelProperty(name = "yearMonthValue", value = "开始计算年月(格式 202208)", notes = "开始计算年月(格式 202208)")
   @TableField("year_month_value")
   @Column(name = "year_month_value", columnDefinition = "int(11)  COMMENT '开始计算年月(格式 202208)'", nullable = false)
   private Integer yearMonthValue;
   @ApiModelProperty(name = "endYearMonth", value = "结束计算年月(格式 202208)", notes = "结束计算年月(格式 202208)")
   @TableField("end_year_month")
   @Column(name = "end_year_month", columnDefinition = "int(11)  COMMENT '结束计算年月(格式 202208)'", nullable = false)
   private Integer endYearMonth;
   @ApiModelProperty(name = "residualValue", value = "残值(元) (年限到期后价值)", notes = "残值(元) (年限到期后价值)")
   @TableField("residual_value")
   @Column(name = "residual_value", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '残值(元) (年限到期后价值)'", nullable = false)
   private BigDecimal residualValue;
   @ApiModelProperty(name = "residualValueRate", value = "残值率 (残值/原值)", notes = "残值率 (残值/原值)")
   @TableField("residual_value_rate")
   @Column(name = "residual_value_rate", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '残值率 (残值/原值)'", nullable = false)
   private BigDecimal residualValueRate;
   @ApiModelProperty(name = "yearDepreciationAmount", value = "年折旧额", notes = "年折旧额")
   @TableField("year_depreciation_amount")
   @Column(name = "year_depreciation_amount", columnDefinition = "decimal(32,8)  COMMENT '年折旧额'", nullable = false)
   private BigDecimal yearDepreciationAmount;
   @ApiModelProperty(name = "yearDepreciationRate", value = "年折旧率", notes = "年折旧率")
   @TableField("year_depreciation_rate")
   @Column(name = "year_depreciation_rate", columnDefinition = "decimal(32,8)  COMMENT '年折旧率'", nullable = false)
   private BigDecimal yearDepreciationRate;
   @ApiModelProperty(name = "monthDepreciationAmount", value = "月折旧额", notes = "月折旧额")
   @TableField("month_depreciation_amount")
   @Column(name = "month_depreciation_amount", columnDefinition = "decimal(32,8)  COMMENT '月折旧额'", nullable = false)
   private BigDecimal monthDepreciationAmount;
   @ApiModelProperty(name = "monthDepreciationRate", value = "月折旧率", notes = "月折旧率")
   @TableField("month_depreciation_rate")
   @Column(name = "month_depreciation_rate", columnDefinition = "decimal(32,8)  COMMENT '月折旧率'", nullable = false)
   private BigDecimal monthDepreciationRate;
   @ApiModelProperty(name = "userId", value = "录用用户ID", notes = "录用用户ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '录用用户ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "boolStatus", value = "状态 0关闭 1开启", notes = "状态 0关闭 1开启")
   @TableField("bool_status")
   @Column(name = "bool_status", columnDefinition = "tinyint(1) default '1' COMMENT '状态 0关闭 1开启'", nullable = false)
   private Boolean boolStatus;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024)  COMMENT '附件ID字符串'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "grossFloorArea", value = "建筑面积(㎡)", notes = "建筑面积(㎡)")
   @TableField("gross_floor_area")
   @Column(name = "gross_floor_area", columnDefinition = "decimal(32,8)  COMMENT '建筑面积(㎡)'", nullable = false)
   private BigDecimal grossFloorArea;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构ID'", nullable = false)
   private Long branchCompanyId;

   public static ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder builder() {
      return new ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder();
   }

   public ContractFixedAssetsDepreciation() {
   }

   public ContractFixedAssetsDepreciation(
      final Long id,
      final Integer type,
      final String name,
      final BigDecimal originalValue,
      final BigDecimal depreciationYear,
      final LocalDate startDate,
      final LocalDate endDate,
      final Integer yearMonthValue,
      final Integer endYearMonth,
      final BigDecimal residualValue,
      final BigDecimal residualValueRate,
      final BigDecimal yearDepreciationAmount,
      final BigDecimal yearDepreciationRate,
      final BigDecimal monthDepreciationAmount,
      final BigDecimal monthDepreciationRate,
      final Long userId,
      final Boolean boolStatus,
      final String attachmentIds,
      final String remark,
      final BigDecimal grossFloorArea,
      final Long branchCompanyId
   ) {
      this.id = id;
      this.type = type;
      this.name = name;
      this.originalValue = originalValue;
      this.depreciationYear = depreciationYear;
      this.startDate = startDate;
      this.endDate = endDate;
      this.yearMonthValue = yearMonthValue;
      this.endYearMonth = endYearMonth;
      this.residualValue = residualValue;
      this.residualValueRate = residualValueRate;
      this.yearDepreciationAmount = yearDepreciationAmount;
      this.yearDepreciationRate = yearDepreciationRate;
      this.monthDepreciationAmount = monthDepreciationAmount;
      this.monthDepreciationRate = monthDepreciationRate;
      this.userId = userId;
      this.boolStatus = boolStatus;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.grossFloorArea = grossFloorArea;
      this.branchCompanyId = branchCompanyId;
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

   public LocalDate getEndDate() {
      return this.endDate;
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

   public Boolean getBoolStatus() {
      return this.boolStatus;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getGrossFloorArea() {
      return this.grossFloorArea;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public ContractFixedAssetsDepreciation setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractFixedAssetsDepreciation setType(final Integer type) {
      this.type = type;
      return this;
   }

   public ContractFixedAssetsDepreciation setName(final String name) {
      this.name = name;
      return this;
   }

   public ContractFixedAssetsDepreciation setOriginalValue(final BigDecimal originalValue) {
      this.originalValue = originalValue;
      return this;
   }

   public ContractFixedAssetsDepreciation setDepreciationYear(final BigDecimal depreciationYear) {
      this.depreciationYear = depreciationYear;
      return this;
   }

   public ContractFixedAssetsDepreciation setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
      return this;
   }

   public ContractFixedAssetsDepreciation setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
      return this;
   }

   public ContractFixedAssetsDepreciation setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
      return this;
   }

   public ContractFixedAssetsDepreciation setEndYearMonth(final Integer endYearMonth) {
      this.endYearMonth = endYearMonth;
      return this;
   }

   public ContractFixedAssetsDepreciation setResidualValue(final BigDecimal residualValue) {
      this.residualValue = residualValue;
      return this;
   }

   public ContractFixedAssetsDepreciation setResidualValueRate(final BigDecimal residualValueRate) {
      this.residualValueRate = residualValueRate;
      return this;
   }

   public ContractFixedAssetsDepreciation setYearDepreciationAmount(final BigDecimal yearDepreciationAmount) {
      this.yearDepreciationAmount = yearDepreciationAmount;
      return this;
   }

   public ContractFixedAssetsDepreciation setYearDepreciationRate(final BigDecimal yearDepreciationRate) {
      this.yearDepreciationRate = yearDepreciationRate;
      return this;
   }

   public ContractFixedAssetsDepreciation setMonthDepreciationAmount(final BigDecimal monthDepreciationAmount) {
      this.monthDepreciationAmount = monthDepreciationAmount;
      return this;
   }

   public ContractFixedAssetsDepreciation setMonthDepreciationRate(final BigDecimal monthDepreciationRate) {
      this.monthDepreciationRate = monthDepreciationRate;
      return this;
   }

   public ContractFixedAssetsDepreciation setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractFixedAssetsDepreciation setBoolStatus(final Boolean boolStatus) {
      this.boolStatus = boolStatus;
      return this;
   }

   public ContractFixedAssetsDepreciation setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ContractFixedAssetsDepreciation setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractFixedAssetsDepreciation setGrossFloorArea(final BigDecimal grossFloorArea) {
      this.grossFloorArea = grossFloorArea;
      return this;
   }

   public ContractFixedAssetsDepreciation setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @Override
   public String toString() {
      return "ContractFixedAssetsDepreciation(id="
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
         + ", endDate="
         + this.getEndDate()
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
         + ", boolStatus="
         + this.getBoolStatus()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", grossFloorArea="
         + this.getGrossFloorArea()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractFixedAssetsDepreciation)) {
         return false;
      }

      ContractFixedAssetsDepreciation other = (ContractFixedAssetsDepreciation)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                        Object this$branchCompanyId = this.getBranchCompanyId();
                        Object other$branchCompanyId = other.getBranchCompanyId();
                        if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
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
                                       Object this$endDate = this.getEndDate();
                                       Object other$endDate = other.getEndDate();
                                       if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
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
                                                            Object this$attachmentIds = this.getAttachmentIds();
                                                            Object other$attachmentIds = other.getAttachmentIds();
                                                            if (this$attachmentIds == null
                                                               ? other$attachmentIds == null
                                                               : this$attachmentIds.equals(other$attachmentIds)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$grossFloorArea = this.getGrossFloorArea();
                                                                  Object other$grossFloorArea = other.getGrossFloorArea();
                                                                  return this$grossFloorArea == null
                                                                     ? other$grossFloorArea == null
                                                                     : this$grossFloorArea.equals(other$grossFloorArea);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractFixedAssetsDepreciation;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $originalValue = this.getOriginalValue();
      result = result * 59 + ($originalValue == null ? 43 : $originalValue.hashCode());
      Object $depreciationYear = this.getDepreciationYear();
      result = result * 59 + ($depreciationYear == null ? 43 : $depreciationYear.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
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
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $grossFloorArea = this.getGrossFloorArea();
      return result * 59 + ($grossFloorArea == null ? 43 : $grossFloorArea.hashCode());
   }

   public static class ContractFixedAssetsDepreciationBuilder {
      private Long id;
      private Integer type;
      private String name;
      private BigDecimal originalValue;
      private BigDecimal depreciationYear;
      private LocalDate startDate;
      private LocalDate endDate;
      private Integer yearMonthValue;
      private Integer endYearMonth;
      private BigDecimal residualValue;
      private BigDecimal residualValueRate;
      private BigDecimal yearDepreciationAmount;
      private BigDecimal yearDepreciationRate;
      private BigDecimal monthDepreciationAmount;
      private BigDecimal monthDepreciationRate;
      private Long userId;
      private Boolean boolStatus;
      private String attachmentIds;
      private String remark;
      private BigDecimal grossFloorArea;
      private Long branchCompanyId;

      ContractFixedAssetsDepreciationBuilder() {
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder originalValue(final BigDecimal originalValue) {
         this.originalValue = originalValue;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder depreciationYear(final BigDecimal depreciationYear) {
         this.depreciationYear = depreciationYear;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder endYearMonth(final Integer endYearMonth) {
         this.endYearMonth = endYearMonth;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder residualValue(final BigDecimal residualValue) {
         this.residualValue = residualValue;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder residualValueRate(final BigDecimal residualValueRate) {
         this.residualValueRate = residualValueRate;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder yearDepreciationAmount(final BigDecimal yearDepreciationAmount) {
         this.yearDepreciationAmount = yearDepreciationAmount;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder yearDepreciationRate(final BigDecimal yearDepreciationRate) {
         this.yearDepreciationRate = yearDepreciationRate;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder monthDepreciationAmount(final BigDecimal monthDepreciationAmount) {
         this.monthDepreciationAmount = monthDepreciationAmount;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder monthDepreciationRate(final BigDecimal monthDepreciationRate) {
         this.monthDepreciationRate = monthDepreciationRate;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder boolStatus(final Boolean boolStatus) {
         this.boolStatus = boolStatus;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder grossFloorArea(final BigDecimal grossFloorArea) {
         this.grossFloorArea = grossFloorArea;
         return this;
      }

      public ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractFixedAssetsDepreciation build() {
         return new ContractFixedAssetsDepreciation(
            this.id,
            this.type,
            this.name,
            this.originalValue,
            this.depreciationYear,
            this.startDate,
            this.endDate,
            this.yearMonthValue,
            this.endYearMonth,
            this.residualValue,
            this.residualValueRate,
            this.yearDepreciationAmount,
            this.yearDepreciationRate,
            this.monthDepreciationAmount,
            this.monthDepreciationRate,
            this.userId,
            this.boolStatus,
            this.attachmentIds,
            this.remark,
            this.grossFloorArea,
            this.branchCompanyId
         );
      }

      @Override
      public String toString() {
         return "ContractFixedAssetsDepreciation.ContractFixedAssetsDepreciationBuilder(id="
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
            + ", endDate="
            + this.endDate
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
            + ", boolStatus="
            + this.boolStatus
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", grossFloorArea="
            + this.grossFloorArea
            + ", branchCompanyId="
            + this.branchCompanyId
            + ")";
      }
   }
}
