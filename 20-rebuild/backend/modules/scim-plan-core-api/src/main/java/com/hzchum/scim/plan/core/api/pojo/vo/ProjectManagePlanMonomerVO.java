package com.hzchum.scim.plan.core.api.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanMonomerDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "项目管理单体VO")
@JsonInclude(Include.NON_NULL)
public class ProjectManagePlanMonomerVO extends ProjectPlanMonomerDTO {
   @ApiModelProperty(name = "supplierList", value = "供应商列表")
   private List<SupplierInfo> supplierList;
   @ApiModelProperty("区域列表")
   private List<ProjectManagePlanAreaVO> manageAreaList;

   public List<SupplierInfo> getSupplierList() {
      return this.supplierList;
   }

   public List<ProjectManagePlanAreaVO> getManageAreaList() {
      return this.manageAreaList;
   }

   public void setSupplierList(final List<SupplierInfo> supplierList) {
      this.supplierList = supplierList;
   }

   public void setManageAreaList(final List<ProjectManagePlanAreaVO> manageAreaList) {
      this.manageAreaList = manageAreaList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectManagePlanMonomerVO)) {
         return false;
      } else {
         ProjectManagePlanMonomerVO other = (ProjectManagePlanMonomerVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$supplierList = this.getSupplierList();
            Object other$supplierList = other.getSupplierList();
            if (this$supplierList == null ? other$supplierList == null : this$supplierList.equals(other$supplierList)) {
               Object this$manageAreaList = this.getManageAreaList();
               Object other$manageAreaList = other.getManageAreaList();
               return this$manageAreaList == null ? other$manageAreaList == null : this$manageAreaList.equals(other$manageAreaList);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectManagePlanMonomerVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierList = this.getSupplierList();
      result = result * 59 + ($supplierList == null ? 43 : $supplierList.hashCode());
      Object $manageAreaList = this.getManageAreaList();
      return result * 59 + ($manageAreaList == null ? 43 : $manageAreaList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManagePlanMonomerVO(supplierList=" + this.getSupplierList() + ", manageAreaList=" + this.getManageAreaList() + ")";
   }
}
