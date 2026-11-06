package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("项目添加 请求类")
public class ProjectSaveDTOParam {
   @NotNull(message = "基础信息不能为空")
   @Valid
   @ApiModelProperty(name = "baseRequestVO", value = "基础信息添加类")
   private BaseSaveDTOParam baseRequestVO;
   @NotNull(message = "客户信息不能为空")
   @Valid
   @ApiModelProperty(name = "customer", value = "客户信息")
   private CustomerSaveDTOParam customer;
   @ApiModelProperty(name = "userIdList", value = "项目关联用户id列表")
   @NotEmpty(message = "请先去选择成员模板")
   private List<Long> userIdList;

   public BaseSaveDTOParam getBaseRequestVO() {
      return this.baseRequestVO;
   }

   public CustomerSaveDTOParam getCustomer() {
      return this.customer;
   }

   public List<Long> getUserIdList() {
      return this.userIdList;
   }

   public void setBaseRequestVO(final BaseSaveDTOParam baseRequestVO) {
      this.baseRequestVO = baseRequestVO;
   }

   public void setCustomer(final CustomerSaveDTOParam customer) {
      this.customer = customer;
   }

   public void setUserIdList(final List<Long> userIdList) {
      this.userIdList = userIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSaveDTOParam)) {
         return false;
      }

      ProjectSaveDTOParam other = (ProjectSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$baseRequestVO = this.getBaseRequestVO();
      Object other$baseRequestVO = other.getBaseRequestVO();
      if (this$baseRequestVO == null ? other$baseRequestVO == null : this$baseRequestVO.equals(other$baseRequestVO)) {
         Object this$customer = this.getCustomer();
         Object other$customer = other.getCustomer();
         if (this$customer == null ? other$customer == null : this$customer.equals(other$customer)) {
            Object this$userIdList = this.getUserIdList();
            Object other$userIdList = other.getUserIdList();
            return this$userIdList == null ? other$userIdList == null : this$userIdList.equals(other$userIdList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $baseRequestVO = this.getBaseRequestVO();
      result = result * 59 + ($baseRequestVO == null ? 43 : $baseRequestVO.hashCode());
      Object $customer = this.getCustomer();
      result = result * 59 + ($customer == null ? 43 : $customer.hashCode());
      Object $userIdList = this.getUserIdList();
      return result * 59 + ($userIdList == null ? 43 : $userIdList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSaveDTOParam(baseRequestVO=" + this.getBaseRequestVO() + ", customer=" + this.getCustomer() + ", userIdList=" + this.getUserIdList() + ")";
   }
}
