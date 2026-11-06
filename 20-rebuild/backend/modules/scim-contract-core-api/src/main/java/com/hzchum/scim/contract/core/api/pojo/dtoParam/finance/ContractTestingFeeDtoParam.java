package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ContractTestingFee对象", description = "检测费表 ")
public class ContractTestingFeeDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(groups = Update.class, message = "记录ID不能为空")
   private Long id;
   @ApiModelProperty(name = "payDate", value = "支付日期", notes = "支付日期")
   @NotNull(message = "支付日期不能为空")
   private LocalDate payDate;
   @ApiModelProperty(name = "testingFeeTypeId", value = "类型id", notes = "类型id")
   @NotNull(message = "检测费类型不能为空")
   private Long testingFeeTypeId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "feeAmount", value = "费用(元)", notes = "费用(元)")
   @NotNull(message = "费用(元)不能为空")
   @DecimalMin(value = "0.0001", message = "费用太少")
   private BigDecimal feeAmount;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   @Size(max = 50, message = "附件不能太多!")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 1000, message = "搞这么多字干嘛!")
   private String remark;
   @ApiModelProperty("费用归属")
   @NotNull(message = "费用归属不能为空")
   private Long branchCompanyId;

   public static ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder builder() {
      return new ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder();
   }

   public ContractTestingFeeDtoParam() {
   }

   public ContractTestingFeeDtoParam(
      final Long id,
      final LocalDate payDate,
      final Long testingFeeTypeId,
      final Long projectId,
      final BigDecimal feeAmount,
      final List<Long> attachmentIds,
      final String remark,
      final Long branchCompanyId
   ) {
      this.id = id;
      this.payDate = payDate;
      this.testingFeeTypeId = testingFeeTypeId;
      this.projectId = projectId;
      this.feeAmount = feeAmount;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.branchCompanyId = branchCompanyId;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getPayDate() {
      return this.payDate;
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

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPayDate(final LocalDate payDate) {
      this.payDate = payDate;
   }

   public void setTestingFeeTypeId(final Long testingFeeTypeId) {
      this.testingFeeTypeId = testingFeeTypeId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setFeeAmount(final BigDecimal feeAmount) {
      this.feeAmount = feeAmount;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractTestingFeeDtoParam)) {
         return false;
      }

      ContractTestingFeeDtoParam other = (ContractTestingFeeDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$testingFeeTypeId = this.getTestingFeeTypeId();
         Object other$testingFeeTypeId = other.getTestingFeeTypeId();
         if (this$testingFeeTypeId == null ? other$testingFeeTypeId == null : this$testingFeeTypeId.equals(other$testingFeeTypeId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractTestingFeeDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $testingFeeTypeId = this.getTestingFeeTypeId();
      result = result * 59 + ($testingFeeTypeId == null ? 43 : $testingFeeTypeId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $payDate = this.getPayDate();
      result = result * 59 + ($payDate == null ? 43 : $payDate.hashCode());
      Object $feeAmount = this.getFeeAmount();
      result = result * 59 + ($feeAmount == null ? 43 : $feeAmount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractTestingFeeDtoParam(id="
         + this.getId()
         + ", payDate="
         + this.getPayDate()
         + ", testingFeeTypeId="
         + this.getTestingFeeTypeId()
         + ", projectId="
         + this.getProjectId()
         + ", feeAmount="
         + this.getFeeAmount()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ")";
   }

   public static class ContractTestingFeeDtoParamBuilder {
      private Long id;
      private LocalDate payDate;
      private Long testingFeeTypeId;
      private Long projectId;
      private BigDecimal feeAmount;
      private List<Long> attachmentIds;
      private String remark;
      private Long branchCompanyId;

      ContractTestingFeeDtoParamBuilder() {
      }

      public ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder payDate(final LocalDate payDate) {
         this.payDate = payDate;
         return this;
      }

      public ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder testingFeeTypeId(final Long testingFeeTypeId) {
         this.testingFeeTypeId = testingFeeTypeId;
         return this;
      }

      public ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder feeAmount(final BigDecimal feeAmount) {
         this.feeAmount = feeAmount;
         return this;
      }

      public ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractTestingFeeDtoParam build() {
         return new ContractTestingFeeDtoParam(
            this.id, this.payDate, this.testingFeeTypeId, this.projectId, this.feeAmount, this.attachmentIds, this.remark, this.branchCompanyId
         );
      }

      @Override
      public String toString() {
         return "ContractTestingFeeDtoParam.ContractTestingFeeDtoParamBuilder(id="
            + this.id
            + ", payDate="
            + this.payDate
            + ", testingFeeTypeId="
            + this.testingFeeTypeId
            + ", projectId="
            + this.projectId
            + ", feeAmount="
            + this.feeAmount
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", branchCompanyId="
            + this.branchCompanyId
            + ")";
      }
   }
}
