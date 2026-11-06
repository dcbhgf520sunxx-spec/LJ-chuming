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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractWaterElectricityPropertyFee对象", description = "水、电、物业费表")
@Entity
@TableName("contract_water_electricity_property_fee")
@Table(name = "contract_water_electricity_property_fee")
@org.hibernate.annotations.Table(appliesTo = "contract_water_electricity_property_fee", comment = "水、电、物业费表")
public class ContractWaterElectricityPropertyFee extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "type", value = "类型(1: 水, 2: 电, 3: 物业)", notes = "类型(1: 水, 2: 电, 3: 物业)")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '类型(1: 水, 2: 电, 3: 物业)'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   @TableField("year")
   @Column(name = "year", columnDefinition = "int(11)  COMMENT '年份'", nullable = true)
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @TableField("month")
   @Column(name = "month", columnDefinition = "int(11)  COMMENT '月份'", nullable = true)
   private Integer month;
   @ApiModelProperty(name = "yearMonthDate", value = "年月日期", notes = "年月日期")
   @TableField("year_month_date")
   @Column(name = "year_month_date", columnDefinition = "datetime  COMMENT '年月日期'", nullable = true)
   private LocalDate yearMonthDate;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构ID'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "userId", value = "录用用户ID", notes = "录用用户ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '录用用户ID'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "consumption", value = "消耗量(水: 吨, 电: kw/h=度)", notes = "消耗量(水: 吨, 电: kw/h=度)")
   @TableField("consumption")
   @Column(name = "consumption", columnDefinition = "decimal(32,8)  COMMENT '消耗量(水: 吨, 电: kw/h=度)'", nullable = true)
   private BigDecimal consumption;
   @ApiModelProperty(name = "totalFee", value = "费用总额(元)", notes = "费用总额(元)")
   @TableField("total_fee")
   @Column(name = "total_fee", columnDefinition = "decimal(32,8)  COMMENT '费用总额(元)'", nullable = true)
   private BigDecimal totalFee;
   @ApiModelProperty(name = "averageUnitPrice", value = "平均单价(元)", notes = "平均单价(元)")
   @TableField("average_unit_price")
   @Column(name = "average_unit_price", columnDefinition = "decimal(32,8)  COMMENT '平均单价(元)'", nullable = true)
   private BigDecimal averageUnitPrice;
   @ApiModelProperty(name = "boolStatus", value = "状态(0: 禁用, 1: 启用)", notes = "状态(0: 禁用, 1: 启用)")
   @TableField("bool_status")
   @Column(name = "bool_status", columnDefinition = "tinyint(1) default '1' COMMENT '状态(0: 禁用, 1: 启用)'", nullable = true)
   private Boolean boolStatus;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(500)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "auditStatusEnum", value = "审批状态 1未审批 2已通过 4已驳回", notes = "审批状态 1未审批 2已通过 4已驳回")
   @TableField("audit_status_enum")
   @Column(name = "audit_status_enum", columnDefinition = "int(11) default '1' COMMENT '审批状态 1未审批 2已通过 4已驳回'", nullable = false)
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   @TableField("auditor_id")
   @Column(name = "auditor_id", columnDefinition = "bigint(20) comment '审核人id'")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   @TableField("auditor_name")
   @Column(name = "auditor_name", columnDefinition = "varchar(128) comment '审核人名字'")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime(6) comment '审核时间'")
   private LocalDateTime auditTime;

   public static ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder builder() {
      return new ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder();
   }

   public ContractWaterElectricityPropertyFee() {
   }

   public ContractWaterElectricityPropertyFee(
      final Long id,
      final Integer type,
      final Integer year,
      final Integer month,
      final LocalDate yearMonthDate,
      final Long branchCompanyId,
      final Long userId,
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
      this.id = id;
      this.type = type;
      this.year = year;
      this.month = month;
      this.yearMonthDate = yearMonthDate;
      this.branchCompanyId = branchCompanyId;
      this.userId = userId;
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

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public LocalDate getYearMonthDate() {
      return this.yearMonthDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getUserId() {
      return this.userId;
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

   public ContractWaterElectricityPropertyFee setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractWaterElectricityPropertyFee setType(final Integer type) {
      this.type = type;
      return this;
   }

   public ContractWaterElectricityPropertyFee setYear(final Integer year) {
      this.year = year;
      return this;
   }

   public ContractWaterElectricityPropertyFee setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   public ContractWaterElectricityPropertyFee setYearMonthDate(final LocalDate yearMonthDate) {
      this.yearMonthDate = yearMonthDate;
      return this;
   }

   public ContractWaterElectricityPropertyFee setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public ContractWaterElectricityPropertyFee setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractWaterElectricityPropertyFee setConsumption(final BigDecimal consumption) {
      this.consumption = consumption;
      return this;
   }

   public ContractWaterElectricityPropertyFee setTotalFee(final BigDecimal totalFee) {
      this.totalFee = totalFee;
      return this;
   }

   public ContractWaterElectricityPropertyFee setAverageUnitPrice(final BigDecimal averageUnitPrice) {
      this.averageUnitPrice = averageUnitPrice;
      return this;
   }

   public ContractWaterElectricityPropertyFee setBoolStatus(final Boolean boolStatus) {
      this.boolStatus = boolStatus;
      return this;
   }

   public ContractWaterElectricityPropertyFee setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractWaterElectricityPropertyFee setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   public ContractWaterElectricityPropertyFee setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
      return this;
   }

   public ContractWaterElectricityPropertyFee setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
      return this;
   }

   public ContractWaterElectricityPropertyFee setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @Override
   public String toString() {
      return "ContractWaterElectricityPropertyFee(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", yearMonthDate="
         + this.getYearMonthDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", userId="
         + this.getUserId()
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWaterElectricityPropertyFee)) {
         return false;
      }

      ContractWaterElectricityPropertyFee other = (ContractWaterElectricityPropertyFee)o;
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
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               if (this$month == null ? other$month == null : this$month.equals(other$month)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractWaterElectricityPropertyFee;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
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

   public static class ContractWaterElectricityPropertyFeeBuilder {
      private Long id;
      private Integer type;
      private Integer year;
      private Integer month;
      private LocalDate yearMonthDate;
      private Long branchCompanyId;
      private Long userId;
      private BigDecimal consumption;
      private BigDecimal totalFee;
      private BigDecimal averageUnitPrice;
      private Boolean boolStatus;
      private String remark;
      private Integer auditStatusEnum;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;

      ContractWaterElectricityPropertyFeeBuilder() {
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder yearMonthDate(final LocalDate yearMonthDate) {
         this.yearMonthDate = yearMonthDate;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder consumption(final BigDecimal consumption) {
         this.consumption = consumption;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder totalFee(final BigDecimal totalFee) {
         this.totalFee = totalFee;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder averageUnitPrice(final BigDecimal averageUnitPrice) {
         this.averageUnitPrice = averageUnitPrice;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder boolStatus(final Boolean boolStatus) {
         this.boolStatus = boolStatus;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractWaterElectricityPropertyFee build() {
         return new ContractWaterElectricityPropertyFee(
            this.id,
            this.type,
            this.year,
            this.month,
            this.yearMonthDate,
            this.branchCompanyId,
            this.userId,
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
         return "ContractWaterElectricityPropertyFee.ContractWaterElectricityPropertyFeeBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", yearMonthDate="
            + this.yearMonthDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", userId="
            + this.userId
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
