package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("项目人员模板 请求类")
public class ProjectPersonnelSaveDTOParam {
   @NotBlank(message = "模板名称不能为空")
   @Size(min = 2, max = 10, message = "模板名称只能输入个2~10个字符")
   @ApiModelProperty("模板名称")
   private String templateName;
   @NotBlank(message = "描述不能为空")
   @ApiModelProperty("模板描述")
   private String remark;
   @NotNull(message = "是否默认0:否 1:是 不能为空")
   @ApiModelProperty("是否默认 0:否 1:是")
   private Boolean isDefault;
   @Valid
   @NotEmpty(message = "用户信息列表不能为空")
   @ApiModelProperty("用户id列表")
   private List<Long> userIdList;

   public String getTemplateName() {
      return this.templateName;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getIsDefault() {
      return this.isDefault;
   }

   public List<Long> getUserIdList() {
      return this.userIdList;
   }

   public void setTemplateName(final String templateName) {
      this.templateName = templateName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setIsDefault(final Boolean isDefault) {
      this.isDefault = isDefault;
   }

   public void setUserIdList(final List<Long> userIdList) {
      this.userIdList = userIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPersonnelSaveDTOParam)) {
         return false;
      }

      ProjectPersonnelSaveDTOParam other = (ProjectPersonnelSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isDefault = this.getIsDefault();
      Object other$isDefault = other.getIsDefault();
      if (this$isDefault == null ? other$isDefault == null : this$isDefault.equals(other$isDefault)) {
         Object this$templateName = this.getTemplateName();
         Object other$templateName = other.getTemplateName();
         if (this$templateName == null ? other$templateName == null : this$templateName.equals(other$templateName)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
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
      return other instanceof ProjectPersonnelSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isDefault = this.getIsDefault();
      result = result * 59 + ($isDefault == null ? 43 : $isDefault.hashCode());
      Object $templateName = this.getTemplateName();
      result = result * 59 + ($templateName == null ? 43 : $templateName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $userIdList = this.getUserIdList();
      return result * 59 + ($userIdList == null ? 43 : $userIdList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPersonnelSaveDTOParam(templateName="
         + this.getTemplateName()
         + ", remark="
         + this.getRemark()
         + ", isDefault="
         + this.getIsDefault()
         + ", userIdList="
         + this.getUserIdList()
         + ")";
   }
}
