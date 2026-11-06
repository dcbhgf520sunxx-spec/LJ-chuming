package com.hzchum.scim.contract.core.api.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "报销费用query类")
public class ContractReimbursementFeeQuery {
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty("费用归属ID")
   private Long branchCompanyId;
   @ApiModelProperty("部门ID")
   private Long deptId;
   @ApiModelProperty("费用类型")
   private Long expenseTypeId;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("报销人名称")
   private String reimburserName;
   @ApiModelProperty("填报人名称")
   private String writtenByName;
   @NotNull(message = "pageNumber不能为空")
   private Integer pageNumber;
   @NotNull(message = "pageSize不能为空")
   private Integer pageSize;
   @NotEmpty(message = "sort不能为空")
   private List<String> sort;

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getReimburserName() {
      return this.reimburserName;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public List<String> getSort() {
      return this.sort;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setReimburserName(final String reimburserName) {
      this.reimburserName = reimburserName;
   }

   public void setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   public void setSort(final List<String> sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractReimbursementFeeQuery)) {
         return false;
      }

      ContractReimbursementFeeQuery other = (ContractReimbursementFeeQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$deptId = this.getDeptId();
         Object other$deptId = other.getDeptId();
         if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
            Object this$expenseTypeId = this.getExpenseTypeId();
            Object other$expenseTypeId = other.getExpenseTypeId();
            if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$pageNumber = this.getPageNumber();
                  Object other$pageNumber = other.getPageNumber();
                  if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                     Object this$pageSize = this.getPageSize();
                     Object other$pageSize = other.getPageSize();
                     if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                        Object this$startDate = this.getStartDate();
                        Object other$startDate = other.getStartDate();
                        if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                           Object this$endDate = this.getEndDate();
                           Object other$endDate = other.getEndDate();
                           if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                              Object this$reimburserName = this.getReimburserName();
                              Object other$reimburserName = other.getReimburserName();
                              if (this$reimburserName == null ? other$reimburserName == null : this$reimburserName.equals(other$reimburserName)) {
                                 Object this$writtenByName = this.getWrittenByName();
                                 Object other$writtenByName = other.getWrittenByName();
                                 if (this$writtenByName == null ? other$writtenByName == null : this$writtenByName.equals(other$writtenByName)) {
                                    Object this$sort = this.getSort();
                                    Object other$sort = other.getSort();
                                    return this$sort == null ? other$sort == null : this$sort.equals(other$sort);
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
      return other instanceof ContractReimbursementFeeQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $reimburserName = this.getReimburserName();
      result = result * 59 + ($reimburserName == null ? 43 : $reimburserName.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "ContractReimbursementFeeQuery(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", deptId="
         + this.getDeptId()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", projectId="
         + this.getProjectId()
         + ", reimburserName="
         + this.getReimburserName()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
