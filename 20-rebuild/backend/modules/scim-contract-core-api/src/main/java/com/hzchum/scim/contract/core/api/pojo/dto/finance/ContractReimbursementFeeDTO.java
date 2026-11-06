package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "报销费用DTO类")
public class ContractReimbursementFeeDTO extends ContractReimbursementFee {
   @ApiModelProperty("费用归属名称")
   private String branchCompanyName;
   @ApiModelProperty("费用类型名称")
   private String expenseTypeName;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("部门名称")
   private String deptName;
   @ApiModelProperty("报销人名称")
   private String reimburserName;
   @ApiModelProperty("填报人名称")
   private String writtenByName;
   @ApiModelProperty(name = "attachmentList", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachmentList;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractReimbursementFeeDTO)) {
         return false;
      }

      ContractReimbursementFeeDTO other = (ContractReimbursementFeeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$branchCompanyName = this.getBranchCompanyName();
      Object other$branchCompanyName = other.getBranchCompanyName();
      if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
         Object this$expenseTypeName = this.getExpenseTypeName();
         Object other$expenseTypeName = other.getExpenseTypeName();
         if (this$expenseTypeName == null ? other$expenseTypeName == null : this$expenseTypeName.equals(other$expenseTypeName)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$deptName = this.getDeptName();
               Object other$deptName = other.getDeptName();
               if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                  Object this$reimburserName = this.getReimburserName();
                  Object other$reimburserName = other.getReimburserName();
                  if (this$reimburserName == null ? other$reimburserName == null : this$reimburserName.equals(other$reimburserName)) {
                     Object this$writtenByName = this.getWrittenByName();
                     Object other$writtenByName = other.getWrittenByName();
                     if (this$writtenByName == null ? other$writtenByName == null : this$writtenByName.equals(other$writtenByName)) {
                        Object this$attachmentList = this.getAttachmentList();
                        Object other$attachmentList = other.getAttachmentList();
                        return this$attachmentList == null ? other$attachmentList == null : this$attachmentList.equals(other$attachmentList);
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
      return other instanceof ContractReimbursementFeeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $expenseTypeName = this.getExpenseTypeName();
      result = result * 59 + ($expenseTypeName == null ? 43 : $expenseTypeName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $reimburserName = this.getReimburserName();
      result = result * 59 + ($reimburserName == null ? 43 : $reimburserName.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $attachmentList = this.getAttachmentList();
      return result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
   }

   @Override
   public String toString() {
      return "ContractReimbursementFeeDTO(super="
         + super.toString()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", expenseTypeName="
         + this.getExpenseTypeName()
         + ", projectName="
         + this.getProjectName()
         + ", deptName="
         + this.getDeptName()
         + ", reimburserName="
         + this.getReimburserName()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", attachmentList="
         + this.getAttachmentList()
         + ")";
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getExpenseTypeName() {
      return this.expenseTypeName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public String getReimburserName() {
      return this.reimburserName;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setExpenseTypeName(final String expenseTypeName) {
      this.expenseTypeName = expenseTypeName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setReimburserName(final String reimburserName) {
      this.reimburserName = reimburserName;
   }

   public void setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }
}
