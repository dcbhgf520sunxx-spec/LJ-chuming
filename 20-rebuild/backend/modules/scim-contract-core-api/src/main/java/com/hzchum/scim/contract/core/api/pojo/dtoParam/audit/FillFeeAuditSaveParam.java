package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FillFeeAuditSaveParam {
   @NotNull(message = "审批记录id不能为空!")
   private Long auditId;
   @NotNull(message = "审核状态有误!")
   @EnumValidator(value = AuditStatusEnum.class, message = "审核状态有误!")
   @Min(value = 2L, message = "审核状态有误!")
   private Integer auditStatusEnum;
   @Size(max = 500, message = "字数超出限制!")
   private String remark;

   public static FillFeeAuditSaveParam.FillFeeAuditSaveParamBuilder builder() {
      return new FillFeeAuditSaveParam.FillFeeAuditSaveParamBuilder();
   }

   public FillFeeAuditSaveParam(final Long auditId, final Integer auditStatusEnum, final String remark) {
      this.auditId = auditId;
      this.auditStatusEnum = auditStatusEnum;
      this.remark = remark;
   }

   public FillFeeAuditSaveParam() {
   }

   public Long getAuditId() {
      return this.auditId;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
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

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FillFeeAuditSaveParam)) {
         return false;
      }

      FillFeeAuditSaveParam other = (FillFeeAuditSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditId = this.getAuditId();
      Object other$auditId = other.getAuditId();
      if (this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId)) {
         Object this$auditStatusEnum = this.getAuditStatusEnum();
         Object other$auditStatusEnum = other.getAuditStatusEnum();
         if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FillFeeAuditSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditId = this.getAuditId();
      result = result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "FillFeeAuditSaveParam(auditId=" + this.getAuditId() + ", auditStatusEnum=" + this.getAuditStatusEnum() + ", remark=" + this.getRemark() + ")";
   }

   public static class FillFeeAuditSaveParamBuilder {
      private Long auditId;
      private Integer auditStatusEnum;
      private String remark;

      FillFeeAuditSaveParamBuilder() {
      }

      public FillFeeAuditSaveParam.FillFeeAuditSaveParamBuilder auditId(final Long auditId) {
         this.auditId = auditId;
         return this;
      }

      public FillFeeAuditSaveParam.FillFeeAuditSaveParamBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public FillFeeAuditSaveParam.FillFeeAuditSaveParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public FillFeeAuditSaveParam build() {
         return new FillFeeAuditSaveParam(this.auditId, this.auditStatusEnum, this.remark);
      }

      @Override
      public String toString() {
         return "FillFeeAuditSaveParam.FillFeeAuditSaveParamBuilder(auditId="
            + this.auditId
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
