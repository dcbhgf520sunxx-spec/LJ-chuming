package com.hzchum.scim.project.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProjectWasteProductMainDTOParam {
   @ApiModelProperty("二次利用项目id")
   private Long useProjectId;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty(name = "wasteHandleMethod", value = "废品处理方式 1二次利用 2废品出售 ", notes = "废品处理方式 1二次利用 2废品出售")
   private Integer wasteHandleMethod;
   @ApiModelProperty("废料合同id")
   private Long contractWasteId;
   @ApiModelProperty("分支机构id(出售方)")
   private Long branchCompanyId;
   @ApiModelProperty("总金额")
   private BigDecimal totalAmount;
   @Size(max = 255, message = "备注字数超出限制!")
   private String remark;
   @NotEmpty(message = "产品数据不能为空!")
   @ApiModelProperty
   private List<ProjectWasteProductChildDTOParam> projectWasteProductChildVOList;

   public ProjectWasteProductMainDTOParam(
      final Long useProjectId,
      final Integer productType,
      final Integer wasteHandleMethod,
      final Long contractWasteId,
      final Long branchCompanyId,
      final BigDecimal totalAmount,
      final String remark,
      final List<ProjectWasteProductChildDTOParam> projectWasteProductChildVOList
   ) {
      this.useProjectId = useProjectId;
      this.productType = productType;
      this.wasteHandleMethod = wasteHandleMethod;
      this.contractWasteId = contractWasteId;
      this.branchCompanyId = branchCompanyId;
      this.totalAmount = totalAmount;
      this.remark = remark;
      this.projectWasteProductChildVOList = projectWasteProductChildVOList;
   }

   public ProjectWasteProductMainDTOParam() {
   }

   public Long getUseProjectId() {
      return this.useProjectId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getWasteHandleMethod() {
      return this.wasteHandleMethod;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<ProjectWasteProductChildDTOParam> getProjectWasteProductChildVOList() {
      return this.projectWasteProductChildVOList;
   }

   public void setUseProjectId(final Long useProjectId) {
      this.useProjectId = useProjectId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setWasteHandleMethod(final Integer wasteHandleMethod) {
      this.wasteHandleMethod = wasteHandleMethod;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setProjectWasteProductChildVOList(final List<ProjectWasteProductChildDTOParam> projectWasteProductChildVOList) {
      this.projectWasteProductChildVOList = projectWasteProductChildVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectWasteProductMainDTOParam)) {
         return false;
      }

      ProjectWasteProductMainDTOParam other = (ProjectWasteProductMainDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$useProjectId = this.getUseProjectId();
      Object other$useProjectId = other.getUseProjectId();
      if (this$useProjectId == null ? other$useProjectId == null : this$useProjectId.equals(other$useProjectId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$wasteHandleMethod = this.getWasteHandleMethod();
            Object other$wasteHandleMethod = other.getWasteHandleMethod();
            if (this$wasteHandleMethod == null ? other$wasteHandleMethod == null : this$wasteHandleMethod.equals(other$wasteHandleMethod)) {
               Object this$contractWasteId = this.getContractWasteId();
               Object other$contractWasteId = other.getContractWasteId();
               if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
                  Object this$branchCompanyId = this.getBranchCompanyId();
                  Object other$branchCompanyId = other.getBranchCompanyId();
                  if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                     Object this$totalAmount = this.getTotalAmount();
                     Object other$totalAmount = other.getTotalAmount();
                     if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                           Object this$projectWasteProductChildVOList = this.getProjectWasteProductChildVOList();
                           Object other$projectWasteProductChildVOList = other.getProjectWasteProductChildVOList();
                           return this$projectWasteProductChildVOList == null
                              ? other$projectWasteProductChildVOList == null
                              : this$projectWasteProductChildVOList.equals(other$projectWasteProductChildVOList);
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
      return other instanceof ProjectWasteProductMainDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $useProjectId = this.getUseProjectId();
      result = result * 59 + ($useProjectId == null ? 43 : $useProjectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $wasteHandleMethod = this.getWasteHandleMethod();
      result = result * 59 + ($wasteHandleMethod == null ? 43 : $wasteHandleMethod.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $projectWasteProductChildVOList = this.getProjectWasteProductChildVOList();
      return result * 59 + ($projectWasteProductChildVOList == null ? 43 : $projectWasteProductChildVOList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWasteProductMainDTOParam(useProjectId="
         + this.getUseProjectId()
         + ", productType="
         + this.getProductType()
         + ", wasteHandleMethod="
         + this.getWasteHandleMethod()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", remark="
         + this.getRemark()
         + ", projectWasteProductChildVOList="
         + this.getProjectWasteProductChildVOList()
         + ")";
   }
}
