package com.hzchum.scim.contract.core.api.pojo._do.finance;

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

@ApiModel(value = "ContractGasSummary对象", description = "气体用量统计表 ")
@Entity
@TableName("contract_gas_summary")
@Table(name = "contract_gas_summary")
@org.hibernate.annotations.Table(appliesTo = "contract_gas_summary", comment = "气体用量统计表 ")
public class ContractGasSummary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "classifyId", value = "科目表ID", notes = "科目表ID")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint(20)  COMMENT '科目表ID'", nullable = false)
   private Long classifyId;
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
   @ApiModelProperty(name = "usedMete", value = "使用量", notes = "使用量")
   @TableField("used_mete")
   @Column(name = "used_mete", columnDefinition = "decimal(32,8)  COMMENT '使用量'", nullable = false)
   private BigDecimal usedMete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(255) COMMENT '核算单位(录入时后台配置单位)'", nullable = false)
   private String accountingUnit;
   @ApiModelProperty(name = "totalAmount", value = "总额(元)", notes = "总额(元)")
   @TableField("total_amount")
   @Column(name = "total_amount", columnDefinition = "decimal(32,3)  COMMENT '总额(元)'", nullable = false)
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "boolConfirmStatus", value = "确认状态 0未确认 1已确认", notes = "确认状态 0未确认 1已确认")
   @TableField("bool_confirm_status")
   @Column(name = "bool_confirm_status", columnDefinition = "tinyint(1) default '0' COMMENT '确认状态 0未确认 1已确认'", nullable = false)
   private Boolean boolConfirmStatus;
   @ApiModelProperty(name = "userId", value = "录入人ID", notes = "录入人ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '录入人ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(1024)  COMMENT '附件ID字符串'")
   private String attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'")
   private String remark;

   public static ContractGasSummary.ContractGasSummaryBuilder builder() {
      return new ContractGasSummary.ContractGasSummaryBuilder();
   }

   public ContractGasSummary() {
   }

   public ContractGasSummary(
      final Long id,
      final Long classifyId,
      final Integer year,
      final Integer month,
      final Integer yearMonthValue,
      final BigDecimal usedMete,
      final String accountingUnit,
      final BigDecimal totalAmount,
      final Boolean boolConfirmStatus,
      final Long userId,
      final String attachmentIds,
      final String remark
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.year = year;
      this.month = month;
      this.yearMonthValue = yearMonthValue;
      this.usedMete = usedMete;
      this.accountingUnit = accountingUnit;
      this.totalAmount = totalAmount;
      this.boolConfirmStatus = boolConfirmStatus;
      this.userId = userId;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
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

   public BigDecimal getUsedMete() {
      return this.usedMete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public Boolean getBoolConfirmStatus() {
      return this.boolConfirmStatus;
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

   public ContractGasSummary setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractGasSummary setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public ContractGasSummary setYear(final Integer year) {
      this.year = year;
      return this;
   }

   public ContractGasSummary setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   public ContractGasSummary setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
      return this;
   }

   public ContractGasSummary setUsedMete(final BigDecimal usedMete) {
      this.usedMete = usedMete;
      return this;
   }

   public ContractGasSummary setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   public ContractGasSummary setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
      return this;
   }

   public ContractGasSummary setBoolConfirmStatus(final Boolean boolConfirmStatus) {
      this.boolConfirmStatus = boolConfirmStatus;
      return this;
   }

   public ContractGasSummary setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractGasSummary setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ContractGasSummary setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ContractGasSummary(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", yearMonthValue="
         + this.getYearMonthValue()
         + ", usedMete="
         + this.getUsedMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", boolConfirmStatus="
         + this.getBoolConfirmStatus()
         + ", userId="
         + this.getUserId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractGasSummary)) {
         return false;
      }

      ContractGasSummary other = (ContractGasSummary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               if (this$month == null ? other$month == null : this$month.equals(other$month)) {
                  Object this$yearMonthValue = this.getYearMonthValue();
                  Object other$yearMonthValue = other.getYearMonthValue();
                  if (this$yearMonthValue == null ? other$yearMonthValue == null : this$yearMonthValue.equals(other$yearMonthValue)) {
                     Object this$boolConfirmStatus = this.getBoolConfirmStatus();
                     Object other$boolConfirmStatus = other.getBoolConfirmStatus();
                     if (this$boolConfirmStatus == null ? other$boolConfirmStatus == null : this$boolConfirmStatus.equals(other$boolConfirmStatus)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$usedMete = this.getUsedMete();
                           Object other$usedMete = other.getUsedMete();
                           if (this$usedMete == null ? other$usedMete == null : this$usedMete.equals(other$usedMete)) {
                              Object this$accountingUnit = this.getAccountingUnit();
                              Object other$accountingUnit = other.getAccountingUnit();
                              if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                 Object this$totalAmount = this.getTotalAmount();
                                 Object other$totalAmount = other.getTotalAmount();
                                 if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractGasSummary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $yearMonthValue = this.getYearMonthValue();
      result = result * 59 + ($yearMonthValue == null ? 43 : $yearMonthValue.hashCode());
      Object $boolConfirmStatus = this.getBoolConfirmStatus();
      result = result * 59 + ($boolConfirmStatus == null ? 43 : $boolConfirmStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $usedMete = this.getUsedMete();
      result = result * 59 + ($usedMete == null ? 43 : $usedMete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractGasSummaryBuilder {
      private Long id;
      private Long classifyId;
      private Integer year;
      private Integer month;
      private Integer yearMonthValue;
      private BigDecimal usedMete;
      private String accountingUnit;
      private BigDecimal totalAmount;
      private Boolean boolConfirmStatus;
      private Long userId;
      private String attachmentIds;
      private String remark;

      ContractGasSummaryBuilder() {
      }

      public ContractGasSummary.ContractGasSummaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder usedMete(final BigDecimal usedMete) {
         this.usedMete = usedMete;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder boolConfirmStatus(final Boolean boolConfirmStatus) {
         this.boolConfirmStatus = boolConfirmStatus;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractGasSummary.ContractGasSummaryBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractGasSummary build() {
         return new ContractGasSummary(
            this.id,
            this.classifyId,
            this.year,
            this.month,
            this.yearMonthValue,
            this.usedMete,
            this.accountingUnit,
            this.totalAmount,
            this.boolConfirmStatus,
            this.userId,
            this.attachmentIds,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractGasSummary.ContractGasSummaryBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", yearMonthValue="
            + this.yearMonthValue
            + ", usedMete="
            + this.usedMete
            + ", accountingUnit="
            + this.accountingUnit
            + ", totalAmount="
            + this.totalAmount
            + ", boolConfirmStatus="
            + this.boolConfirmStatus
            + ", userId="
            + this.userId
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
