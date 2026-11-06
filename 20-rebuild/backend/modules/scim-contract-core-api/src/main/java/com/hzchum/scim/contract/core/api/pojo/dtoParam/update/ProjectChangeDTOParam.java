package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("合同信息变更请求类")
public class ProjectChangeDTOParam {
   @Valid
   @ApiModelProperty(name = "baseUpdateDTOParam", value = "基本信息")
   @NotNull(message = "基本信息不能为空")
   private ProjectBaseChangeDTOParam baseUpdateDTOParam;
   @Valid
   @ApiModelProperty(name = "baseUpdateDTOParam", value = "商务信息")
   @NotNull(message = "商务信息不能为空")
   private ProjectBusinessChangeDTOParam businessUpdateDTOParam;
   @Valid
   @ApiModelProperty(name = "baseUpdateDTOParam", value = "客户信息")
   private ProjectCustomerChangeDTOParam customerUpdateDTOParam;
   @ApiModelProperty(name = "userIdList", value = "关联用户id列表")
   @NotEmpty(message = "项目最少关联一名用户")
   private List<Long> userIdList;

   public ProjectBaseChangeDTOParam getBaseUpdateDTOParam() {
      return this.baseUpdateDTOParam;
   }

   public ProjectBusinessChangeDTOParam getBusinessUpdateDTOParam() {
      return this.businessUpdateDTOParam;
   }

   public ProjectCustomerChangeDTOParam getCustomerUpdateDTOParam() {
      return this.customerUpdateDTOParam;
   }

   public List<Long> getUserIdList() {
      return this.userIdList;
   }

   public void setBaseUpdateDTOParam(final ProjectBaseChangeDTOParam baseUpdateDTOParam) {
      this.baseUpdateDTOParam = baseUpdateDTOParam;
   }

   public void setBusinessUpdateDTOParam(final ProjectBusinessChangeDTOParam businessUpdateDTOParam) {
      this.businessUpdateDTOParam = businessUpdateDTOParam;
   }

   public void setCustomerUpdateDTOParam(final ProjectCustomerChangeDTOParam customerUpdateDTOParam) {
      this.customerUpdateDTOParam = customerUpdateDTOParam;
   }

   public void setUserIdList(final List<Long> userIdList) {
      this.userIdList = userIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectChangeDTOParam)) {
         return false;
      }

      ProjectChangeDTOParam other = (ProjectChangeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$baseUpdateDTOParam = this.getBaseUpdateDTOParam();
      Object other$baseUpdateDTOParam = other.getBaseUpdateDTOParam();
      if (this$baseUpdateDTOParam == null ? other$baseUpdateDTOParam == null : this$baseUpdateDTOParam.equals(other$baseUpdateDTOParam)) {
         Object this$businessUpdateDTOParam = this.getBusinessUpdateDTOParam();
         Object other$businessUpdateDTOParam = other.getBusinessUpdateDTOParam();
         if (this$businessUpdateDTOParam == null ? other$businessUpdateDTOParam == null : this$businessUpdateDTOParam.equals(other$businessUpdateDTOParam)) {
            Object this$customerUpdateDTOParam = this.getCustomerUpdateDTOParam();
            Object other$customerUpdateDTOParam = other.getCustomerUpdateDTOParam();
            if (this$customerUpdateDTOParam == null ? other$customerUpdateDTOParam == null : this$customerUpdateDTOParam.equals(other$customerUpdateDTOParam)) {
               Object this$userIdList = this.getUserIdList();
               Object other$userIdList = other.getUserIdList();
               return this$userIdList == null ? other$userIdList == null : this$userIdList.equals(other$userIdList);
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
      return other instanceof ProjectChangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $baseUpdateDTOParam = this.getBaseUpdateDTOParam();
      result = result * 59 + ($baseUpdateDTOParam == null ? 43 : $baseUpdateDTOParam.hashCode());
      Object $businessUpdateDTOParam = this.getBusinessUpdateDTOParam();
      result = result * 59 + ($businessUpdateDTOParam == null ? 43 : $businessUpdateDTOParam.hashCode());
      Object $customerUpdateDTOParam = this.getCustomerUpdateDTOParam();
      result = result * 59 + ($customerUpdateDTOParam == null ? 43 : $customerUpdateDTOParam.hashCode());
      Object $userIdList = this.getUserIdList();
      return result * 59 + ($userIdList == null ? 43 : $userIdList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectChangeDTOParam(baseUpdateDTOParam="
         + this.getBaseUpdateDTOParam()
         + ", businessUpdateDTOParam="
         + this.getBusinessUpdateDTOParam()
         + ", customerUpdateDTOParam="
         + this.getCustomerUpdateDTOParam()
         + ", userIdList="
         + this.getUserIdList()
         + ")";
   }
}
