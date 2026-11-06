package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractWageFee对象", description = "工资费用表")
@Entity
@TableName("contract_wage_fee")
@Table(name = "contract_wage_fee")
@org.hibernate.annotations.Table(appliesTo = "contract_wage_fee", comment = "工资费用表")
public class ContractWageFee extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "fillInDate", value = "填写日期", notes = "填写日期")
   @TableField("fill_in_date")
   @Column(name = "fill_in_date", columnDefinition = "datetime  COMMENT '填写日期'", nullable = true)
   private LocalDateTime fillInDate;
   @ApiModelProperty(name = "fillInYear", value = "填写年份", notes = "填写年份")
   @TableField("fill_in_year")
   @Column(name = "fill_in_year", columnDefinition = "int(11)  COMMENT '填写年份'", nullable = true)
   private Integer fillInYear;
   @ApiModelProperty(name = "fillInMonth", value = "填写月份", notes = "填写月份")
   @TableField("fill_in_month")
   @Column(name = "fill_in_month", columnDefinition = "int(11)  COMMENT '填写月份'", nullable = true)
   private Integer fillInMonth;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构ID'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "expenseTypeId", value = "费用类型", notes = "费用类型")
   @TableField("expense_type_id")
   @Column(name = "expense_type_id", columnDefinition = "bigint(20)  COMMENT '费用类型'", nullable = true)
   private Long expenseTypeId;
   @ApiModelProperty(name = "founderId", value = "创建人ID", notes = "创建人ID")
   @TableField("founder_id")
   @Column(name = "founder_id", columnDefinition = "bigint(20)  COMMENT '创建人ID'", nullable = true)
   private Long founderId;
   @ApiModelProperty(name = "totalWage", value = "工资总额(元)", notes = "工资总额(元)")
   @TableField("total_wage")
   @Column(name = "total_wage", columnDefinition = "decimal(32,8)  COMMENT '工资总额(元)'", nullable = true)
   private BigDecimal totalWage;
   @ApiModelProperty(name = "employeeQuantity", value = "员工数量", notes = "员工数量")
   @TableField("employee_quantity")
   @Column(name = "employee_quantity", columnDefinition = "int(11)  COMMENT '员工数量'", nullable = true)
   private Integer employeeQuantity;
   @ApiModelProperty(name = "averageWage", value = "平均工资", notes = "平均工资")
   @TableField("average_wage")
   @Column(name = "average_wage", columnDefinition = "decimal(32,8)  COMMENT '平均工资'", nullable = true)
   private BigDecimal averageWage;
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

   public static ContractWageFee.ContractWageFeeBuilder builder() {
      return new ContractWageFee.ContractWageFeeBuilder();
   }

   public ContractWageFee() {
   }

   public ContractWageFee(
      final Long id,
      final LocalDateTime fillInDate,
      final Integer fillInYear,
      final Integer fillInMonth,
      final Long branchCompanyId,
      final Long expenseTypeId,
      final Long founderId,
      final BigDecimal totalWage,
      final Integer employeeQuantity,
      final BigDecimal averageWage,
      final Integer auditStatusEnum,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.fillInDate = fillInDate;
      this.fillInYear = fillInYear;
      this.fillInMonth = fillInMonth;
      this.branchCompanyId = branchCompanyId;
      this.expenseTypeId = expenseTypeId;
      this.founderId = founderId;
      this.totalWage = totalWage;
      this.employeeQuantity = employeeQuantity;
      this.averageWage = averageWage;
      this.auditStatusEnum = auditStatusEnum;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getFillInDate() {
      return this.fillInDate;
   }

   public Integer getFillInYear() {
      return this.fillInYear;
   }

   public Integer getFillInMonth() {
      return this.fillInMonth;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public Long getFounderId() {
      return this.founderId;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public Integer getEmployeeQuantity() {
      return this.employeeQuantity;
   }

   public BigDecimal getAverageWage() {
      return this.averageWage;
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

   public ContractWageFee setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractWageFee setFillInDate(final LocalDateTime fillInDate) {
      this.fillInDate = fillInDate;
      return this;
   }

   public ContractWageFee setFillInYear(final Integer fillInYear) {
      this.fillInYear = fillInYear;
      return this;
   }

   public ContractWageFee setFillInMonth(final Integer fillInMonth) {
      this.fillInMonth = fillInMonth;
      return this;
   }

   public ContractWageFee setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public ContractWageFee setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
      return this;
   }

   public ContractWageFee setFounderId(final Long founderId) {
      this.founderId = founderId;
      return this;
   }

   public ContractWageFee setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
      return this;
   }

   public ContractWageFee setEmployeeQuantity(final Integer employeeQuantity) {
      this.employeeQuantity = employeeQuantity;
      return this;
   }

   public ContractWageFee setAverageWage(final BigDecimal averageWage) {
      this.averageWage = averageWage;
      return this;
   }

   public ContractWageFee setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   public ContractWageFee setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
      return this;
   }

   public ContractWageFee setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
      return this;
   }

   public ContractWageFee setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @Override
   public String toString() {
      return "ContractWageFee(id="
         + this.getId()
         + ", fillInDate="
         + this.getFillInDate()
         + ", fillInYear="
         + this.getFillInYear()
         + ", fillInMonth="
         + this.getFillInMonth()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", founderId="
         + this.getFounderId()
         + ", totalWage="
         + this.getTotalWage()
         + ", employeeQuantity="
         + this.getEmployeeQuantity()
         + ", averageWage="
         + this.getAverageWage()
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

      if (!(o instanceof ContractWageFee)) {
         return false;
      }

      ContractWageFee other = (ContractWageFee)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$fillInYear = this.getFillInYear();
         Object other$fillInYear = other.getFillInYear();
         if (this$fillInYear == null ? other$fillInYear == null : this$fillInYear.equals(other$fillInYear)) {
            Object this$fillInMonth = this.getFillInMonth();
            Object other$fillInMonth = other.getFillInMonth();
            if (this$fillInMonth == null ? other$fillInMonth == null : this$fillInMonth.equals(other$fillInMonth)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$expenseTypeId = this.getExpenseTypeId();
                  Object other$expenseTypeId = other.getExpenseTypeId();
                  if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
                     Object this$founderId = this.getFounderId();
                     Object other$founderId = other.getFounderId();
                     if (this$founderId == null ? other$founderId == null : this$founderId.equals(other$founderId)) {
                        Object this$employeeQuantity = this.getEmployeeQuantity();
                        Object other$employeeQuantity = other.getEmployeeQuantity();
                        if (this$employeeQuantity == null ? other$employeeQuantity == null : this$employeeQuantity.equals(other$employeeQuantity)) {
                           Object this$auditStatusEnum = this.getAuditStatusEnum();
                           Object other$auditStatusEnum = other.getAuditStatusEnum();
                           if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                              Object this$auditorId = this.getAuditorId();
                              Object other$auditorId = other.getAuditorId();
                              if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                                 Object this$fillInDate = this.getFillInDate();
                                 Object other$fillInDate = other.getFillInDate();
                                 if (this$fillInDate == null ? other$fillInDate == null : this$fillInDate.equals(other$fillInDate)) {
                                    Object this$totalWage = this.getTotalWage();
                                    Object other$totalWage = other.getTotalWage();
                                    if (this$totalWage == null ? other$totalWage == null : this$totalWage.equals(other$totalWage)) {
                                       Object this$averageWage = this.getAverageWage();
                                       Object other$averageWage = other.getAverageWage();
                                       if (this$averageWage == null ? other$averageWage == null : this$averageWage.equals(other$averageWage)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractWageFee;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $fillInYear = this.getFillInYear();
      result = result * 59 + ($fillInYear == null ? 43 : $fillInYear.hashCode());
      Object $fillInMonth = this.getFillInMonth();
      result = result * 59 + ($fillInMonth == null ? 43 : $fillInMonth.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $founderId = this.getFounderId();
      result = result * 59 + ($founderId == null ? 43 : $founderId.hashCode());
      Object $employeeQuantity = this.getEmployeeQuantity();
      result = result * 59 + ($employeeQuantity == null ? 43 : $employeeQuantity.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $fillInDate = this.getFillInDate();
      result = result * 59 + ($fillInDate == null ? 43 : $fillInDate.hashCode());
      Object $totalWage = this.getTotalWage();
      result = result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
      Object $averageWage = this.getAverageWage();
      result = result * 59 + ($averageWage == null ? 43 : $averageWage.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public static class ContractWageFeeBuilder {
      private Long id;
      private LocalDateTime fillInDate;
      private Integer fillInYear;
      private Integer fillInMonth;
      private Long branchCompanyId;
      private Long expenseTypeId;
      private Long founderId;
      private BigDecimal totalWage;
      private Integer employeeQuantity;
      private BigDecimal averageWage;
      private Integer auditStatusEnum;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;

      ContractWageFeeBuilder() {
      }

      public ContractWageFee.ContractWageFeeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder fillInDate(final LocalDateTime fillInDate) {
         this.fillInDate = fillInDate;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder fillInYear(final Integer fillInYear) {
         this.fillInYear = fillInYear;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder fillInMonth(final Integer fillInMonth) {
         this.fillInMonth = fillInMonth;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder founderId(final Long founderId) {
         this.founderId = founderId;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder totalWage(final BigDecimal totalWage) {
         this.totalWage = totalWage;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder employeeQuantity(final Integer employeeQuantity) {
         this.employeeQuantity = employeeQuantity;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder averageWage(final BigDecimal averageWage) {
         this.averageWage = averageWage;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractWageFee.ContractWageFeeBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractWageFee build() {
         return new ContractWageFee(
            this.id,
            this.fillInDate,
            this.fillInYear,
            this.fillInMonth,
            this.branchCompanyId,
            this.expenseTypeId,
            this.founderId,
            this.totalWage,
            this.employeeQuantity,
            this.averageWage,
            this.auditStatusEnum,
            this.auditorId,
            this.auditorName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ContractWageFee.ContractWageFeeBuilder(id="
            + this.id
            + ", fillInDate="
            + this.fillInDate
            + ", fillInYear="
            + this.fillInYear
            + ", fillInMonth="
            + this.fillInMonth
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", founderId="
            + this.founderId
            + ", totalWage="
            + this.totalWage
            + ", employeeQuantity="
            + this.employeeQuantity
            + ", averageWage="
            + this.averageWage
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
