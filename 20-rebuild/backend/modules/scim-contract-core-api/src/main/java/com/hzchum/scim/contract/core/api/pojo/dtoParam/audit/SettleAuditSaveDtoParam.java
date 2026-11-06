package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SettleAuditSaveDtoParam {
   @NotNull(message = "审批记录id不能为空!")
   private Long auditId;
   @NotNull(message = "审核状态有误!")
   @EnumValidator(value = AuditStatusEnum.class, message = "审核状态有误!")
   @Min(value = 2L, message = "审核状态有误!")
   private Integer auditStatusEnum;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @Size(max = 500, message = "字数超出限制!")
   private String remark;

   SettleAuditSaveDtoParam(final Long auditId, final Integer auditStatusEnum, final BigDecimal settlementAmount, final String remark) {
      this.auditId = auditId;
      this.auditStatusEnum = auditStatusEnum;
      this.settlementAmount = settlementAmount;
      this.remark = remark;
   }

   public static SettleAuditSaveDtoParam.SettleAuditSaveDtoParamBuilder builder() {
      return new SettleAuditSaveDtoParam.SettleAuditSaveDtoParamBuilder();
   }

   public Long getAuditId() {
      return this.auditId;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setAuditId(final Long auditId) {
      this.auditId = auditId;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SettleAuditSaveDtoParam)) {
         return false;
      }

      SettleAuditSaveDtoParam other = (SettleAuditSaveDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditId = this.getAuditId();
      Object other$auditId = other.getAuditId();
      if (this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId)) {
         Object this$auditStatusEnum = this.getAuditStatusEnum();
         Object other$auditStatusEnum = other.getAuditStatusEnum();
         if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
            Object this$settlementAmount = this.getSettlementAmount();
            Object other$settlementAmount = other.getSettlementAmount();
            if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SettleAuditSaveDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditId = this.getAuditId();
      result = result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SettleAuditSaveDtoParam(auditId="
         + this.getAuditId()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class SettleAuditSaveDtoParamBuilder {
      private Long auditId;
      private Integer auditStatusEnum;
      private BigDecimal settlementAmount;
      private String remark;

      SettleAuditSaveDtoParamBuilder() {
      }

      public SettleAuditSaveDtoParam.SettleAuditSaveDtoParamBuilder auditId(final Long auditId) {
         this.auditId = auditId;
         return this;
      }

      public SettleAuditSaveDtoParam.SettleAuditSaveDtoParamBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public SettleAuditSaveDtoParam.SettleAuditSaveDtoParamBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SettleAuditSaveDtoParam.SettleAuditSaveDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SettleAuditSaveDtoParam build() {
         return new SettleAuditSaveDtoParam(this.auditId, this.auditStatusEnum, this.settlementAmount, this.remark);
      }

      @Override
      public String toString() {
         return "SettleAuditSaveDtoParam.SettleAuditSaveDtoParamBuilder(auditId="
            + this.auditId
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", settlementAmount="
            + this.settlementAmount
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
