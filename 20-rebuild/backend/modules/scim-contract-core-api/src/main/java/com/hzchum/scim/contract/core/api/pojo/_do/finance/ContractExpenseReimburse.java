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

@ApiModel(value = "ContractExpenseReimburse对象", description = "费用报销表 ")
@Entity
@TableName("contract_expense_reimburse")
@Table(name = "contract_expense_reimburse")
@org.hibernate.annotations.Table(appliesTo = "contract_expense_reimburse", comment = "费用报销表 ")
public class ContractExpenseReimburse extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "reimburseDate", value = "报销日期", notes = "报销日期")
   @TableField("reimburse_date")
   @Column(name = "reimburse_date", columnDefinition = "date  COMMENT '报销日期'", nullable = false)
   private LocalDate reimburseDate;
   @ApiModelProperty(name = "year", value = "年度 (例:2022)", notes = "年度 (例:2022)")
   @TableField("year")
   @Column(name = "year", columnDefinition = "int(11)  COMMENT '年度 (例:2022)'", nullable = false)
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份(1~12)", notes = "月份(1~12)")
   @TableField("month")
   @Column(name = "month", columnDefinition = "int(11)  COMMENT '月份(1~12)'", nullable = false)
   private Integer month;
   @ApiModelProperty(name = "yearMonthValue", value = "年月(格式 202208)", notes = "年月(格式 202208)")
   @TableField("year_month_value")
   @Column(name = "year_month_value", columnDefinition = "int(11)  COMMENT '年月(格式 202208)'", nullable = false)
   private Integer yearMonthValue;
   @ApiModelProperty(name = "reimburseUserId", value = "报销人ID", notes = "报销人ID")
   @TableField("reimburse_user_id")
   @Column(name = "reimburse_user_id", columnDefinition = "bigint(20)  COMMENT '报销人ID'", nullable = false)
   private Long reimburseUserId;
   @ApiModelProperty(name = "deptId", value = "当时的部门ID", notes = "当时的部门ID")
   @TableField("dept_id")
   @Column(name = "dept_id", columnDefinition = "bigint(20)  COMMENT '当时的部门ID'", nullable = false)
   private Long deptId;
   @ApiModelProperty(name = "deptName", value = "当时的部门名称", notes = "当时的部门名称")
   @TableField("dept_name")
   @Column(name = "dept_name", columnDefinition = "varchar(255)  COMMENT '当时的部门名称'", nullable = false)
   private String deptName;
   @ApiModelProperty(name = "reimburseAmount", value = "报销金额", notes = "报销金额")
   @TableField("reimburse_amount")
   @Column(name = "reimburse_amount", columnDefinition = "decimal(32,8)  COMMENT '报销金额'", nullable = false)
   private BigDecimal reimburseAmount;
   @ApiModelProperty(name = "expenseTypeId", value = "费用分类ID", notes = "费用分类ID")
   @TableField("expense_type_id")
   @Column(name = "expense_type_id", columnDefinition = "bigint(20)  COMMENT '费用分类ID'", nullable = false)
   private Long expenseTypeId;
   @ApiModelProperty(name = "expenseSubjectId", value = "费用科目ID", notes = "费用科目ID")
   @TableField("expense_subject_id")
   @Column(name = "expense_subject_id", columnDefinition = "bigint(20)  COMMENT '费用科目ID'", nullable = false)
   private Long expenseSubjectId;
   @ApiModelProperty(name = "projectId", value = "关联项目ID(可不填)", notes = "关联项目ID(可不填)")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '关联项目ID(可不填)'")
   private Long projectId;
   @ApiModelProperty(name = "writtenById", value = "填报人id", notes = "填报人id")
   @TableField("written_by_id")
   @Column(name = "written_by_id", columnDefinition = "bigint(20)  COMMENT '填报人id'", nullable = false)
   private Long writtenById;
   @ApiModelProperty(name = "boolConfirmStatus", value = "报销确认状态 0未确认 1已确认", notes = "报销确认状态 0未确认 1已确认")
   @TableField("bool_confirm_status")
   @Column(name = "bool_confirm_status", columnDefinition = "tinyint(1) default '0' COMMENT '报销确认状态 0未确认 1已确认'", nullable = false)
   private Boolean boolConfirmStatus;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'")
   private String remark;

   public static ContractExpenseReimburse.ContractExpenseReimburseBuilder builder() {
      return new ContractExpenseReimburse.ContractExpenseReimburseBuilder();
   }

   public ContractExpenseReimburse() {
   }

   public ContractExpenseReimburse(
      final Long id,
      final LocalDate reimburseDate,
      final Integer year,
      final Integer month,
      final Integer yearMonthValue,
      final Long reimburseUserId,
      final Long deptId,
      final String deptName,
      final BigDecimal reimburseAmount,
      final Long expenseTypeId,
      final Long expenseSubjectId,
      final Long projectId,
      final Long writtenById,
      final Boolean boolConfirmStatus,
      final String remark
   ) {
      this.id = id;
      this.reimburseDate = reimburseDate;
      this.year = year;
      this.month = month;
      this.yearMonthValue = yearMonthValue;
      this.reimburseUserId = reimburseUserId;
      this.deptId = deptId;
      this.deptName = deptName;
      this.reimburseAmount = reimburseAmount;
      this.expenseTypeId = expenseTypeId;
      this.expenseSubjectId = expenseSubjectId;
      this.projectId = projectId;
      this.writtenById = writtenById;
      this.boolConfirmStatus = boolConfirmStatus;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getReimburseDate() {
      return this.reimburseDate;
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

   public Long getReimburseUserId() {
      return this.reimburseUserId;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public BigDecimal getReimburseAmount() {
      return this.reimburseAmount;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public Long getExpenseSubjectId() {
      return this.expenseSubjectId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public Boolean getBoolConfirmStatus() {
      return this.boolConfirmStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   public ContractExpenseReimburse setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractExpenseReimburse setReimburseDate(final LocalDate reimburseDate) {
      this.reimburseDate = reimburseDate;
      return this;
   }

   public ContractExpenseReimburse setYear(final Integer year) {
      this.year = year;
      return this;
   }

   public ContractExpenseReimburse setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   public ContractExpenseReimburse setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
      return this;
   }

   public ContractExpenseReimburse setReimburseUserId(final Long reimburseUserId) {
      this.reimburseUserId = reimburseUserId;
      return this;
   }

   public ContractExpenseReimburse setDeptId(final Long deptId) {
      this.deptId = deptId;
      return this;
   }

   public ContractExpenseReimburse setDeptName(final String deptName) {
      this.deptName = deptName;
      return this;
   }

   public ContractExpenseReimburse setReimburseAmount(final BigDecimal reimburseAmount) {
      this.reimburseAmount = reimburseAmount;
      return this;
   }

   public ContractExpenseReimburse setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
      return this;
   }

   public ContractExpenseReimburse setExpenseSubjectId(final Long expenseSubjectId) {
      this.expenseSubjectId = expenseSubjectId;
      return this;
   }

   public ContractExpenseReimburse setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractExpenseReimburse setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
      return this;
   }

   public ContractExpenseReimburse setBoolConfirmStatus(final Boolean boolConfirmStatus) {
      this.boolConfirmStatus = boolConfirmStatus;
      return this;
   }

   public ContractExpenseReimburse setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ContractExpenseReimburse(id="
         + this.getId()
         + ", reimburseDate="
         + this.getReimburseDate()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", yearMonthValue="
         + this.getYearMonthValue()
         + ", reimburseUserId="
         + this.getReimburseUserId()
         + ", deptId="
         + this.getDeptId()
         + ", deptName="
         + this.getDeptName()
         + ", reimburseAmount="
         + this.getReimburseAmount()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", expenseSubjectId="
         + this.getExpenseSubjectId()
         + ", projectId="
         + this.getProjectId()
         + ", writtenById="
         + this.getWrittenById()
         + ", boolConfirmStatus="
         + this.getBoolConfirmStatus()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractExpenseReimburse)) {
         return false;
      }

      ContractExpenseReimburse other = (ContractExpenseReimburse)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$year = this.getYear();
         Object other$year = other.getYear();
         if (this$year == null ? other$year == null : this$year.equals(other$year)) {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$yearMonthValue = this.getYearMonthValue();
               Object other$yearMonthValue = other.getYearMonthValue();
               if (this$yearMonthValue == null ? other$yearMonthValue == null : this$yearMonthValue.equals(other$yearMonthValue)) {
                  Object this$reimburseUserId = this.getReimburseUserId();
                  Object other$reimburseUserId = other.getReimburseUserId();
                  if (this$reimburseUserId == null ? other$reimburseUserId == null : this$reimburseUserId.equals(other$reimburseUserId)) {
                     Object this$deptId = this.getDeptId();
                     Object other$deptId = other.getDeptId();
                     if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                        Object this$expenseTypeId = this.getExpenseTypeId();
                        Object other$expenseTypeId = other.getExpenseTypeId();
                        if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
                           Object this$expenseSubjectId = this.getExpenseSubjectId();
                           Object other$expenseSubjectId = other.getExpenseSubjectId();
                           if (this$expenseSubjectId == null ? other$expenseSubjectId == null : this$expenseSubjectId.equals(other$expenseSubjectId)) {
                              Object this$projectId = this.getProjectId();
                              Object other$projectId = other.getProjectId();
                              if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                 Object this$writtenById = this.getWrittenById();
                                 Object other$writtenById = other.getWrittenById();
                                 if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                                    Object this$boolConfirmStatus = this.getBoolConfirmStatus();
                                    Object other$boolConfirmStatus = other.getBoolConfirmStatus();
                                    if (this$boolConfirmStatus == null
                                       ? other$boolConfirmStatus == null
                                       : this$boolConfirmStatus.equals(other$boolConfirmStatus)) {
                                       Object this$reimburseDate = this.getReimburseDate();
                                       Object other$reimburseDate = other.getReimburseDate();
                                       if (this$reimburseDate == null ? other$reimburseDate == null : this$reimburseDate.equals(other$reimburseDate)) {
                                          Object this$deptName = this.getDeptName();
                                          Object other$deptName = other.getDeptName();
                                          if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                                             Object this$reimburseAmount = this.getReimburseAmount();
                                             Object other$reimburseAmount = other.getReimburseAmount();
                                             if (this$reimburseAmount == null
                                                ? other$reimburseAmount == null
                                                : this$reimburseAmount.equals(other$reimburseAmount)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractExpenseReimburse;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $yearMonthValue = this.getYearMonthValue();
      result = result * 59 + ($yearMonthValue == null ? 43 : $yearMonthValue.hashCode());
      Object $reimburseUserId = this.getReimburseUserId();
      result = result * 59 + ($reimburseUserId == null ? 43 : $reimburseUserId.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $expenseSubjectId = this.getExpenseSubjectId();
      result = result * 59 + ($expenseSubjectId == null ? 43 : $expenseSubjectId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $boolConfirmStatus = this.getBoolConfirmStatus();
      result = result * 59 + ($boolConfirmStatus == null ? 43 : $boolConfirmStatus.hashCode());
      Object $reimburseDate = this.getReimburseDate();
      result = result * 59 + ($reimburseDate == null ? 43 : $reimburseDate.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $reimburseAmount = this.getReimburseAmount();
      result = result * 59 + ($reimburseAmount == null ? 43 : $reimburseAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractExpenseReimburseBuilder {
      private Long id;
      private LocalDate reimburseDate;
      private Integer year;
      private Integer month;
      private Integer yearMonthValue;
      private Long reimburseUserId;
      private Long deptId;
      private String deptName;
      private BigDecimal reimburseAmount;
      private Long expenseTypeId;
      private Long expenseSubjectId;
      private Long projectId;
      private Long writtenById;
      private Boolean boolConfirmStatus;
      private String remark;

      ContractExpenseReimburseBuilder() {
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder reimburseDate(final LocalDate reimburseDate) {
         this.reimburseDate = reimburseDate;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder reimburseUserId(final Long reimburseUserId) {
         this.reimburseUserId = reimburseUserId;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder reimburseAmount(final BigDecimal reimburseAmount) {
         this.reimburseAmount = reimburseAmount;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder expenseSubjectId(final Long expenseSubjectId) {
         this.expenseSubjectId = expenseSubjectId;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder boolConfirmStatus(final Boolean boolConfirmStatus) {
         this.boolConfirmStatus = boolConfirmStatus;
         return this;
      }

      public ContractExpenseReimburse.ContractExpenseReimburseBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractExpenseReimburse build() {
         return new ContractExpenseReimburse(
            this.id,
            this.reimburseDate,
            this.year,
            this.month,
            this.yearMonthValue,
            this.reimburseUserId,
            this.deptId,
            this.deptName,
            this.reimburseAmount,
            this.expenseTypeId,
            this.expenseSubjectId,
            this.projectId,
            this.writtenById,
            this.boolConfirmStatus,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractExpenseReimburse.ContractExpenseReimburseBuilder(id="
            + this.id
            + ", reimburseDate="
            + this.reimburseDate
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", yearMonthValue="
            + this.yearMonthValue
            + ", reimburseUserId="
            + this.reimburseUserId
            + ", deptId="
            + this.deptId
            + ", deptName="
            + this.deptName
            + ", reimburseAmount="
            + this.reimburseAmount
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", expenseSubjectId="
            + this.expenseSubjectId
            + ", projectId="
            + this.projectId
            + ", writtenById="
            + this.writtenById
            + ", boolConfirmStatus="
            + this.boolConfirmStatus
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
