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

@ApiModel(value = "ContractPropertyFee对象", description = "物业费表 ")
@Entity
@TableName("contract_property_fee")
@Table(name = "contract_property_fee")
@org.hibernate.annotations.Table(appliesTo = "contract_property_fee", comment = "物业费表 ")
public class ContractPropertyFee extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
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
   @ApiModelProperty(name = "feeAmount", value = "费用", notes = "费用")
   @TableField("fee_amount")
   @Column(name = "fee_amount", columnDefinition = "decimal(32,3)  COMMENT '费用'", nullable = false)
   private BigDecimal feeAmount;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   @TableField("attachment_ids")
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

   public static ContractPropertyFee.ContractPropertyFeeBuilder builder() {
      return new ContractPropertyFee.ContractPropertyFeeBuilder();
   }

   public ContractPropertyFee() {
   }

   public ContractPropertyFee(
      final Long id,
      final Integer year,
      final Integer month,
      final Integer yearMonthValue,
      final BigDecimal feeAmount,
      final String attachmentIds,
      final String remark,
      final Long userId,
      final Boolean boolConfirmStatus
   ) {
      this.id = id;
      this.year = year;
      this.month = month;
      this.yearMonthValue = yearMonthValue;
      this.feeAmount = feeAmount;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.userId = userId;
      this.boolConfirmStatus = boolConfirmStatus;
   }

   public Long getId() {
      return this.id;
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

   public BigDecimal getFeeAmount() {
      return this.feeAmount;
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

   public ContractPropertyFee setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractPropertyFee setYear(final Integer year) {
      this.year = year;
      return this;
   }

   public ContractPropertyFee setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   public ContractPropertyFee setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
      return this;
   }

   public ContractPropertyFee setFeeAmount(final BigDecimal feeAmount) {
      this.feeAmount = feeAmount;
      return this;
   }

   public ContractPropertyFee setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ContractPropertyFee setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractPropertyFee setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractPropertyFee setBoolConfirmStatus(final Boolean boolConfirmStatus) {
      this.boolConfirmStatus = boolConfirmStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ContractPropertyFee(id="
         + this.getId()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", yearMonthValue="
         + this.getYearMonthValue()
         + ", feeAmount="
         + this.getFeeAmount()
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

      if (!(o instanceof ContractPropertyFee)) {
         return false;
      }

      ContractPropertyFee other = (ContractPropertyFee)o;
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
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$boolConfirmStatus = this.getBoolConfirmStatus();
                     Object other$boolConfirmStatus = other.getBoolConfirmStatus();
                     if (this$boolConfirmStatus == null ? other$boolConfirmStatus == null : this$boolConfirmStatus.equals(other$boolConfirmStatus)) {
                        Object this$feeAmount = this.getFeeAmount();
                        Object other$feeAmount = other.getFeeAmount();
                        if (this$feeAmount == null ? other$feeAmount == null : this$feeAmount.equals(other$feeAmount)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractPropertyFee;
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
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolConfirmStatus = this.getBoolConfirmStatus();
      result = result * 59 + ($boolConfirmStatus == null ? 43 : $boolConfirmStatus.hashCode());
      Object $feeAmount = this.getFeeAmount();
      result = result * 59 + ($feeAmount == null ? 43 : $feeAmount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractPropertyFeeBuilder {
      private Long id;
      private Integer year;
      private Integer month;
      private Integer yearMonthValue;
      private BigDecimal feeAmount;
      private String attachmentIds;
      private String remark;
      private Long userId;
      private Boolean boolConfirmStatus;

      ContractPropertyFeeBuilder() {
      }

      public ContractPropertyFee.ContractPropertyFeeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractPropertyFee.ContractPropertyFeeBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractPropertyFee.ContractPropertyFeeBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractPropertyFee.ContractPropertyFeeBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractPropertyFee.ContractPropertyFeeBuilder feeAmount(final BigDecimal feeAmount) {
         this.feeAmount = feeAmount;
         return this;
      }

      public ContractPropertyFee.ContractPropertyFeeBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractPropertyFee.ContractPropertyFeeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractPropertyFee.ContractPropertyFeeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractPropertyFee.ContractPropertyFeeBuilder boolConfirmStatus(final Boolean boolConfirmStatus) {
         this.boolConfirmStatus = boolConfirmStatus;
         return this;
      }

      public ContractPropertyFee build() {
         return new ContractPropertyFee(
            this.id, this.year, this.month, this.yearMonthValue, this.feeAmount, this.attachmentIds, this.remark, this.userId, this.boolConfirmStatus
         );
      }

      @Override
      public String toString() {
         return "ContractPropertyFee.ContractPropertyFeeBuilder(id="
            + this.id
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", yearMonthValue="
            + this.yearMonthValue
            + ", feeAmount="
            + this.feeAmount
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
