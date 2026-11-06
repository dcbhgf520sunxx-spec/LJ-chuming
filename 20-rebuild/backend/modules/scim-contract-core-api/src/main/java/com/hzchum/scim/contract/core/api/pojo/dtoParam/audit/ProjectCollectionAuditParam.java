package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectCollectionAuditParam {
   @NotNull(message = "审批id不能为空")
   @ApiModelProperty(value = "审批id", notes = "审批id")
   private Long auditId;
   @ApiModelProperty(name = "collectionAmount", value = "收款金额")
   @NotNull(message = "收款金额不能为空")
   private BigDecimal collectionAmount;
   @NotNull(message = "审批状态不能为空")
   @ApiModelProperty(value = "审批状态", notes = "审批状态")
   private Integer auditStatusEnum;
   @Size(max = 255, message = "备注信息字数过多")
   @ApiModelProperty(value = "备注", notes = "备注")
   private String remark;

   public Long getAuditId() {
      return this.auditId;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
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

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
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

      if (!(o instanceof ProjectCollectionAuditParam)) {
         return false;
      }

      ProjectCollectionAuditParam other = (ProjectCollectionAuditParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditId = this.getAuditId();
      Object other$auditId = other.getAuditId();
      if (this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId)) {
         Object this$auditStatusEnum = this.getAuditStatusEnum();
         Object other$auditStatusEnum = other.getAuditStatusEnum();
         if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
            Object this$collectionAmount = this.getCollectionAmount();
            Object other$collectionAmount = other.getCollectionAmount();
            if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
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
      return other instanceof ProjectCollectionAuditParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditId = this.getAuditId();
      result = result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCollectionAuditParam(auditId="
         + this.getAuditId()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
