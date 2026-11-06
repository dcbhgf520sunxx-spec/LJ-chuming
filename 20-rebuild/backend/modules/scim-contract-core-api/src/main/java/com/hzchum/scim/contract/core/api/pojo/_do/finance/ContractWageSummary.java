package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractWageSummary对象", description = "员工工资统计表 ")
@Entity
@TableName("contract_wage_summary")
@Table(name = "contract_wage_summary")
@org.hibernate.annotations.Table(appliesTo = "contract_wage_summary", comment = "员工工资统计表 ")
public class ContractWageSummary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "wageType", value = "工资类型 1管理人员工资 2生产人员工资", notes = "工资类型 1管理人员工资 2生产人员工资")
   @TableField("wage_type")
   @Column(name = "wage_type", columnDefinition = "int(11)  COMMENT '工资类型 1管理人员工资 2生产人员工资'", nullable = false)
   private Integer wageType;
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   @TableField("year")
   @Column(name = "year", columnDefinition = "int(11)  COMMENT '年份'", nullable = false)
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份(1~12)", notes = "月份(1~12)")
   @TableField("month")
   @Column(name = "month", columnDefinition = "int(11)  COMMENT '月份(1~12)'", nullable = false)
   private Integer month;
   @ApiModelProperty(name = "yearMonthValue", value = "年月(格式 202208)", notes = "年月(格式 202208)")
   @TableField("year_month_value")
   @Column(name = "year_month_value", columnDefinition = "int(11)  COMMENT '年月(格式 202208)'", nullable = false)
   private Integer yearMonthValue;
   @ApiModelProperty(name = "employeeQuantity", value = "员工数量", notes = "员工数量")
   @TableField("employee_quantity")
   @Column(name = "employee_quantity", columnDefinition = "int(11)  COMMENT '员工数量'", nullable = false)
   private Integer employeeQuantity;
   @ApiModelProperty(name = "totalWage", value = "工资总额", notes = "工资总额")
   @TableField("total_wage")
   @Column(name = "total_wage", columnDefinition = "decimal(32,3)  COMMENT '工资总额'", nullable = false)
   private BigDecimal totalWage;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   @TableField(value = "attachment_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024)  COMMENT '附件ID字符串'")
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'")
   private String remark;
   @ApiModelProperty(name = "userId", value = "录入用户ID", notes = "录入用户ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) COMMENT '录入用户ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "boolConfirmStatus", value = "确认状态 0未确认 1已确认", notes = "确认状态 0未确认 1已确认")
   @TableField("bool_confirm_status")
   @Column(name = "bool_confirm_status", columnDefinition = "tinyint(1) default '0' COMMENT '确认状态 0未确认 1已确认'", nullable = false)
   private Boolean boolConfirmStatus;

   public static ContractWageSummary.ContractWageSummaryBuilder builder() {
      return new ContractWageSummary.ContractWageSummaryBuilder();
   }

   public ContractWageSummary() {
   }

   public ContractWageSummary(
      final Long id,
      final Integer wageType,
      final Integer year,
      final Integer month,
      final Integer yearMonthValue,
      final Integer employeeQuantity,
      final BigDecimal totalWage,
      final String attachmentIds,
      final String remark,
      final Long userId,
      final Boolean boolConfirmStatus
   ) {
      this.id = id;
      this.wageType = wageType;
      this.year = year;
      this.month = month;
      this.yearMonthValue = yearMonthValue;
      this.employeeQuantity = employeeQuantity;
      this.totalWage = totalWage;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.userId = userId;
      this.boolConfirmStatus = boolConfirmStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getWageType() {
      return this.wageType;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public Integer getYearMonthValue() {
      return this.yearMonthValue;
   }

   public Integer getEmployeeQuantity() {
      return this.employeeQuantity;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolConfirmStatus() {
      return this.boolConfirmStatus;
   }

   public ContractWageSummary setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractWageSummary setWageType(final Integer wageType) {
      this.wageType = wageType;
      return this;
   }

   public ContractWageSummary setYear(final Integer year) {
      this.year = year;
      return this;
   }

   public ContractWageSummary setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   public ContractWageSummary setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
      return this;
   }

   public ContractWageSummary setEmployeeQuantity(final Integer employeeQuantity) {
      this.employeeQuantity = employeeQuantity;
      return this;
   }

   public ContractWageSummary setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
      return this;
   }

   public ContractWageSummary setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ContractWageSummary setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractWageSummary setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractWageSummary setBoolConfirmStatus(final Boolean boolConfirmStatus) {
      this.boolConfirmStatus = boolConfirmStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ContractWageSummary(id="
         + this.getId()
         + ", wageType="
         + this.getWageType()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", yearMonthValue="
         + this.getYearMonthValue()
         + ", employeeQuantity="
         + this.getEmployeeQuantity()
         + ", totalWage="
         + this.getTotalWage()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", boolConfirmStatus="
         + this.getBoolConfirmStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWageSummary)) {
         return false;
      }

      ContractWageSummary other = (ContractWageSummary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$wageType = this.getWageType();
         Object other$wageType = other.getWageType();
         if (this$wageType == null ? other$wageType == null : this$wageType.equals(other$wageType)) {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               if (this$month == null ? other$month == null : this$month.equals(other$month)) {
                  Object this$yearMonthValue = this.getYearMonthValue();
                  Object other$yearMonthValue = other.getYearMonthValue();
                  if (this$yearMonthValue == null ? other$yearMonthValue == null : this$yearMonthValue.equals(other$yearMonthValue)) {
                     Object this$employeeQuantity = this.getEmployeeQuantity();
                     Object other$employeeQuantity = other.getEmployeeQuantity();
                     if (this$employeeQuantity == null ? other$employeeQuantity == null : this$employeeQuantity.equals(other$employeeQuantity)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$boolConfirmStatus = this.getBoolConfirmStatus();
                           Object other$boolConfirmStatus = other.getBoolConfirmStatus();
                           if (this$boolConfirmStatus == null ? other$boolConfirmStatus == null : this$boolConfirmStatus.equals(other$boolConfirmStatus)) {
                              Object this$totalWage = this.getTotalWage();
                              Object other$totalWage = other.getTotalWage();
                              if (this$totalWage == null ? other$totalWage == null : this$totalWage.equals(other$totalWage)) {
                                 Object this$attachmentIds = this.getAttachmentIds();
                                 Object other$attachmentIds = other.getAttachmentIds();
                                 if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractWageSummary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $wageType = this.getWageType();
      result = result * 59 + ($wageType == null ? 43 : $wageType.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $yearMonthValue = this.getYearMonthValue();
      result = result * 59 + ($yearMonthValue == null ? 43 : $yearMonthValue.hashCode());
      Object $employeeQuantity = this.getEmployeeQuantity();
      result = result * 59 + ($employeeQuantity == null ? 43 : $employeeQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolConfirmStatus = this.getBoolConfirmStatus();
      result = result * 59 + ($boolConfirmStatus == null ? 43 : $boolConfirmStatus.hashCode());
      Object $totalWage = this.getTotalWage();
      result = result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractWageSummaryBuilder {
      private Long id;
      private Integer wageType;
      private Integer year;
      private Integer month;
      private Integer yearMonthValue;
      private Integer employeeQuantity;
      private BigDecimal totalWage;
      private String attachmentIds;
      private String remark;
      private Long userId;
      private Boolean boolConfirmStatus;

      ContractWageSummaryBuilder() {
      }

      public ContractWageSummary.ContractWageSummaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder wageType(final Integer wageType) {
         this.wageType = wageType;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder employeeQuantity(final Integer employeeQuantity) {
         this.employeeQuantity = employeeQuantity;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder totalWage(final BigDecimal totalWage) {
         this.totalWage = totalWage;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractWageSummary.ContractWageSummaryBuilder boolConfirmStatus(final Boolean boolConfirmStatus) {
         this.boolConfirmStatus = boolConfirmStatus;
         return this;
      }

      public ContractWageSummary build() {
         return new ContractWageSummary(
            this.id,
            this.wageType,
            this.year,
            this.month,
            this.yearMonthValue,
            this.employeeQuantity,
            this.totalWage,
            this.attachmentIds,
            this.remark,
            this.userId,
            this.boolConfirmStatus
         );
      }

      @Override
      public String toString() {
         return "ContractWageSummary.ContractWageSummaryBuilder(id="
            + this.id
            + ", wageType="
            + this.wageType
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", yearMonthValue="
            + this.yearMonthValue
            + ", employeeQuantity="
            + this.employeeQuantity
            + ", totalWage="
            + this.totalWage
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", boolConfirmStatus="
            + this.boolConfirmStatus
            + ")";
      }
   }
}
