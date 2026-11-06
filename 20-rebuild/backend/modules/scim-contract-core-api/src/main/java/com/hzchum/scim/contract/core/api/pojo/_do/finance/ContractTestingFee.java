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
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractTestingFee对象", description = "检测费表 ")
@Entity
@TableName("contract_testing_fee")
@Table(name = "contract_testing_fee")
@org.hibernate.annotations.Table(appliesTo = "contract_testing_fee", comment = "检测费表 ")
public class ContractTestingFee extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "payDate", value = "支付日期", notes = "支付日期")
   @TableField("pay_date")
   @Column(name = "pay_date", columnDefinition = "date  COMMENT '支付日期'", nullable = false)
   private LocalDate payDate;
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   @TableField("year")
   @Column(name = "year", columnDefinition = "int(11)  COMMENT '年份'", nullable = false)
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @TableField("month")
   @Column(name = "month", columnDefinition = "int(11)  COMMENT '月份'", nullable = false)
   private Integer month;
   @ApiModelProperty(name = "yearMonthValue", value = "年月(格式 202208)", notes = "年月(格式 202208)")
   @TableField("year_month_value")
   @Column(name = "year_month_value", columnDefinition = "int(11)  COMMENT '年月(格式 202208)'", nullable = false)
   private Integer yearMonthValue;
   @ApiModelProperty(name = "testingFeeTypeId", value = "类型id", notes = "类型id")
   @TableField("testing_fee_type_id")
   @Column(name = "testing_fee_type_id", columnDefinition = "bigint(20)  COMMENT '类型id'", nullable = false)
   private Long testingFeeTypeId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField(value = "project_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_id", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '项目ID'")
   private Long projectId;
   @ApiModelProperty(name = "feeAmount", value = "费用(元)", notes = "费用(元)")
   @TableField("fee_amount")
   @Column(name = "fee_amount", columnDefinition = "decimal(32,3)  COMMENT '费用(元)'", nullable = false)
   private BigDecimal feeAmount;
   @ApiModelProperty(name = "userId", value = "录入用户ID", notes = "录入用户ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '录入用户ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024)  COMMENT '附件ID字符串'")
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'")
   private String remark;
   @ApiModelProperty("分支机构ID")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构ID'", nullable = true)
   private Long branchCompanyId;
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

   public static ContractTestingFee.ContractTestingFeeBuilder builder() {
      return new ContractTestingFee.ContractTestingFeeBuilder();
   }

   public ContractTestingFee() {
   }

   public ContractTestingFee(
      final Long id,
      final LocalDate payDate,
      final Integer year,
      final Integer month,
      final Integer yearMonthValue,
      final Long testingFeeTypeId,
      final Long projectId,
      final BigDecimal feeAmount,
      final Long userId,
      final String attachmentIds,
      final String remark,
      final Long branchCompanyId,
      final Integer auditStatusEnum,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.payDate = payDate;
      this.year = year;
      this.month = month;
      this.yearMonthValue = yearMonthValue;
      this.testingFeeTypeId = testingFeeTypeId;
      this.projectId = projectId;
      this.feeAmount = feeAmount;
      this.userId = userId;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.branchCompanyId = branchCompanyId;
      this.auditStatusEnum = auditStatusEnum;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getPayDate() {
      return this.payDate;
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

   public Long getTestingFeeTypeId() {
      return this.testingFeeTypeId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getFeeAmount() {
      return this.feeAmount;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
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

   public ContractTestingFee setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractTestingFee setPayDate(final LocalDate payDate) {
      this.payDate = payDate;
      return this;
   }

   public ContractTestingFee setYear(final Integer year) {
      this.year = year;
      return this;
   }

   public ContractTestingFee setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   public ContractTestingFee setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
      return this;
   }

   public ContractTestingFee setTestingFeeTypeId(final Long testingFeeTypeId) {
      this.testingFeeTypeId = testingFeeTypeId;
      return this;
   }

   public ContractTestingFee setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractTestingFee setFeeAmount(final BigDecimal feeAmount) {
      this.feeAmount = feeAmount;
      return this;
   }

   public ContractTestingFee setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractTestingFee setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ContractTestingFee setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractTestingFee setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public ContractTestingFee setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   public ContractTestingFee setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
      return this;
   }

   public ContractTestingFee setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
      return this;
   }

   public ContractTestingFee setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @Override
   public String toString() {
      return "ContractTestingFee(id="
         + this.getId()
         + ", payDate="
         + this.getPayDate()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", yearMonthValue="
         + this.getYearMonthValue()
         + ", testingFeeTypeId="
         + this.getTestingFeeTypeId()
         + ", projectId="
         + this.getProjectId()
         + ", feeAmount="
         + this.getFeeAmount()
         + ", userId="
         + this.getUserId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
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

      if (!(o instanceof ContractTestingFee)) {
         return false;
      }

      ContractTestingFee other = (ContractTestingFee)o;
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
                  Object this$testingFeeTypeId = this.getTestingFeeTypeId();
                  Object other$testingFeeTypeId = other.getTestingFeeTypeId();
                  if (this$testingFeeTypeId == null ? other$testingFeeTypeId == null : this$testingFeeTypeId.equals(other$testingFeeTypeId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$branchCompanyId = this.getBranchCompanyId();
                           Object other$branchCompanyId = other.getBranchCompanyId();
                           if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                              Object this$auditStatusEnum = this.getAuditStatusEnum();
                              Object other$auditStatusEnum = other.getAuditStatusEnum();
                              if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                                 Object this$auditorId = this.getAuditorId();
                                 Object other$auditorId = other.getAuditorId();
                                 if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                                    Object this$payDate = this.getPayDate();
                                    Object other$payDate = other.getPayDate();
                                    if (this$payDate == null ? other$payDate == null : this$payDate.equals(other$payDate)) {
                                       Object this$feeAmount = this.getFeeAmount();
                                       Object other$feeAmount = other.getFeeAmount();
                                       if (this$feeAmount == null ? other$feeAmount == null : this$feeAmount.equals(other$feeAmount)) {
                                          Object this$attachmentIds = this.getAttachmentIds();
                                          Object other$attachmentIds = other.getAttachmentIds();
                                          if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
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
      return other instanceof ContractTestingFee;
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
      Object $testingFeeTypeId = this.getTestingFeeTypeId();
      result = result * 59 + ($testingFeeTypeId == null ? 43 : $testingFeeTypeId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $payDate = this.getPayDate();
      result = result * 59 + ($payDate == null ? 43 : $payDate.hashCode());
      Object $feeAmount = this.getFeeAmount();
      result = result * 59 + ($feeAmount == null ? 43 : $feeAmount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public static class ContractTestingFeeBuilder {
      private Long id;
      private LocalDate payDate;
      private Integer year;
      private Integer month;
      private Integer yearMonthValue;
      private Long testingFeeTypeId;
      private Long projectId;
      private BigDecimal feeAmount;
      private Long userId;
      private String attachmentIds;
      private String remark;
      private Long branchCompanyId;
      private Integer auditStatusEnum;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;

      ContractTestingFeeBuilder() {
      }

      public ContractTestingFee.ContractTestingFeeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder payDate(final LocalDate payDate) {
         this.payDate = payDate;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder testingFeeTypeId(final Long testingFeeTypeId) {
         this.testingFeeTypeId = testingFeeTypeId;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder feeAmount(final BigDecimal feeAmount) {
         this.feeAmount = feeAmount;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractTestingFee.ContractTestingFeeBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractTestingFee build() {
         return new ContractTestingFee(
            this.id,
            this.payDate,
            this.year,
            this.month,
            this.yearMonthValue,
            this.testingFeeTypeId,
            this.projectId,
            this.feeAmount,
            this.userId,
            this.attachmentIds,
            this.remark,
            this.branchCompanyId,
            this.auditStatusEnum,
            this.auditorId,
            this.auditorName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ContractTestingFee.ContractTestingFeeBuilder(id="
            + this.id
            + ", payDate="
            + this.payDate
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", yearMonthValue="
            + this.yearMonthValue
            + ", testingFeeTypeId="
            + this.testingFeeTypeId
            + ", projectId="
            + this.projectId
            + ", feeAmount="
            + this.feeAmount
            + ", userId="
            + this.userId
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", branchCompanyId="
            + this.branchCompanyId
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
