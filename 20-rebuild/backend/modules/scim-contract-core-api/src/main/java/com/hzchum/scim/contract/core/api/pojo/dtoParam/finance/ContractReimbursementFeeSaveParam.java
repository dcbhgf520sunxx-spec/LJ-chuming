package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "报销费用新增修改param类")
public class ContractReimbursementFeeSaveParam {
   @ApiModelProperty(name = "id")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "reimbursementDate", value = "报销日期", notes = "报销日期")
   @NotNull(groups = {Add.class, Update.class}, message = "报销日期不能为空")
   private LocalDateTime reimbursementDate;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   @NotNull(groups = {Add.class, Update.class}, message = "费用归属不能为空")
   private Long branchCompanyId;
   @ApiModelProperty(name = "expenseTypeId", value = "费用类型", notes = "费用类型")
   @NotNull(groups = {Add.class, Update.class}, message = "费用类型不能为空")
   private Long expenseTypeId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "reimbursementAmount", value = "报销金额(元)", notes = "报销金额(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "报销金额不能为空")
   private BigDecimal reimbursementAmount;
   @ApiModelProperty(name = "deptId", value = "部门ID", notes = "部门ID")
   @NotNull(groups = {Add.class, Update.class}, message = "部门不能为空")
   private Long deptId;
   @ApiModelProperty(name = "reimburserId", value = "报销人ID", notes = "报销人ID")
   @NotNull(groups = {Add.class, Update.class}, message = "报销人不能为空")
   private Long reimburserId;
   @ApiModelProperty(name = "reimbursementVoucherNumber", value = "报销凭证号", notes = "报销凭证号")
   private String reimbursementVoucherNumber;
   @Size(max = 20, message = "附件数量过多!")
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   private Set<Long> attachmentIds;
   @Size(max = 255, message = "备注内容过长!")
   @ApiModelProperty(name = "remark", value = "remark", notes = "备注")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getReimbursementDate() {
      return this.reimbursementDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getReimbursementAmount() {
      return this.reimbursementAmount;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public Long getReimburserId() {
      return this.reimburserId;
   }

   public String getReimbursementVoucherNumber() {
      return this.reimbursementVoucherNumber;
   }

   public Set<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setReimbursementDate(final LocalDateTime reimbursementDate) {
      this.reimbursementDate = reimbursementDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setReimbursementAmount(final BigDecimal reimbursementAmount) {
      this.reimbursementAmount = reimbursementAmount;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setReimburserId(final Long reimburserId) {
      this.reimburserId = reimburserId;
   }

   public void setReimbursementVoucherNumber(final String reimbursementVoucherNumber) {
      this.reimbursementVoucherNumber = reimbursementVoucherNumber;
   }

   public void setAttachmentIds(final Set<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractReimbursementFeeSaveParam)) {
         return false;
      }

      ContractReimbursementFeeSaveParam other = (ContractReimbursementFeeSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$expenseTypeId = this.getExpenseTypeId();
            Object other$expenseTypeId = other.getExpenseTypeId();
            if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$deptId = this.getDeptId();
                  Object other$deptId = other.getDeptId();
                  if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                     Object this$reimburserId = this.getReimburserId();
                     Object other$reimburserId = other.getReimburserId();
                     if (this$reimburserId == null ? other$reimburserId == null : this$reimburserId.equals(other$reimburserId)) {
                        Object this$reimbursementDate = this.getReimbursementDate();
                        Object other$reimbursementDate = other.getReimbursementDate();
                        if (this$reimbursementDate == null ? other$reimbursementDate == null : this$reimbursementDate.equals(other$reimbursementDate)) {
                           Object this$reimbursementAmount = this.getReimbursementAmount();
                           Object other$reimbursementAmount = other.getReimbursementAmount();
                           if (this$reimbursementAmount == null
                              ? other$reimbursementAmount == null
                              : this$reimbursementAmount.equals(other$reimbursementAmount)) {
                              Object this$reimbursementVoucherNumber = this.getReimbursementVoucherNumber();
                              Object other$reimbursementVoucherNumber = other.getReimbursementVoucherNumber();
                              if (this$reimbursementVoucherNumber == null
                                 ? other$reimbursementVoucherNumber == null
                                 : this$reimbursementVoucherNumber.equals(other$reimbursementVoucherNumber)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof ContractReimbursementFeeSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $reimburserId = this.getReimburserId();
      result = result * 59 + ($reimburserId == null ? 43 : $reimburserId.hashCode());
      Object $reimbursementDate = this.getReimbursementDate();
      result = result * 59 + ($reimbursementDate == null ? 43 : $reimbursementDate.hashCode());
      Object $reimbursementAmount = this.getReimbursementAmount();
      result = result * 59 + ($reimbursementAmount == null ? 43 : $reimbursementAmount.hashCode());
      Object $reimbursementVoucherNumber = this.getReimbursementVoucherNumber();
      result = result * 59 + ($reimbursementVoucherNumber == null ? 43 : $reimbursementVoucherNumber.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractReimbursementFeeSaveParam(id="
         + this.getId()
         + ", reimbursementDate="
         + this.getReimbursementDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", projectId="
         + this.getProjectId()
         + ", reimbursementAmount="
         + this.getReimbursementAmount()
         + ", deptId="
         + this.getDeptId()
         + ", reimburserId="
         + this.getReimburserId()
         + ", reimbursementVoucherNumber="
         + this.getReimbursementVoucherNumber()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
